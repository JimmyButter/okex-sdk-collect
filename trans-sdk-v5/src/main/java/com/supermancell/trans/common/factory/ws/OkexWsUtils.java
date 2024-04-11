package com.supermancell.trans.common.factory.ws;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.enums.CharsetEnum;
import com.supermancell.trans.common.factory.TrustAllCerts;
import com.supermancell.trans.common.view.model.Worker;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.*;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class OkexWsUtils {

    private final static int readTimeout = 3;

    /**
     * connection
     * 重连就是建立新连接
     * @param url
     * @param listener
     * @return
     */
    public static WebSocket connection(String url, WebSocketListener listener){
        synchronized (OkexWsUtils.class) {
            log.debug("connection to " + url);
            OkHttpClient client = new OkHttpClient.Builder().readTimeout(readTimeout, TimeUnit.SECONDS)
                    .sslSocketFactory(createSSLSocketFactory(), new TrustAllCerts())
                    .hostnameVerifier(new TrustAllHostnameVerifier())
                    .retryOnConnectionFailure(true).build();
            Request request = new Request.Builder().url(url).build();
            return client.newWebSocket(request, listener);
        }
    }

    /**
     * 根据账号登录
     * @param worker
     * @param webSocket
     */
    public static void login(final Worker worker, final WebSocket webSocket) {
        String apiKey = worker.getApiKey();
        String passPhrase = worker.getPassphrase();
        String secretKey = worker.getSecretKey();
        String timestamp = System.currentTimeMillis() / 1000+ "";
        String message = timestamp + "GET" + "/users/self/verify";
        String sign = sha256_HMAC(message, secretKey);
        String str = "{\"op\"" + ":" + "\"login\"" + "," + "\"args\"" + ":" + "[{" + "\"apiKey\"" + ":"+ "\"" + apiKey + "\"" + "," + "\"passphrase\"" + ":" + "\"" + passPhrase + "\"" + ","+ "\"timestamp\"" + ":"  + "\"" + timestamp + "\"" + ","+ "\"sign\"" + ":"  + "\"" + sign + "\"" + "}]}";
        log.debug("Login->" + str);
        boolean b = webSocket.send(str);

        String msg = b?"Send login request success":"Send login request fail";
        log.info(msg);
    }

    /**
     * sha256_HMAC加密
     * @param message
     * @param secret
     * @return
     */
    private static String sha256_HMAC(String message, String secret) {
        String hash = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(CharsetEnum.UTF_8.charset()), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes(CharsetEnum.UTF_8.charset()));
            hash = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            log.error("Error HmacSHA256 ===========" + e.getMessage());
        }
        return hash;
    }

    /**
     * 信任所有证书
     */
    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    /**
     * createSSLSocketFactory
     */
    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new TrustAllCerts()}, new SecureRandom());

            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }
        return ssfFactory;
    }

    //订阅，参数为频道组成的集合
    public static void subscribe(final WebSocket webSocket, List<Map> list) {
        String s = listToJson(list);
        String str = "{\"op\": \"subscribe\", \"args\":" + s + "}";
        log.info(str);
        webSocket.send(str);
    }

    //取消订阅，参数为频道组成的集合
    public static void unsubscribe(final WebSocket webSocket, List<Map> list) {
        String s = listToJson(list);
        String str = "{\"op\": \"unsubscribe\", \"args\":" + s + "}";
        webSocket.send(str);
    }

    private static String listToJson(List<Map> list) {
        JSONArray jsonArray = new JSONArray();
        for (Map map : list) {
            jsonArray.add(JSONObject.parseObject(JSONObject.toJSONString(map)));
        }
        return jsonArray.toJSONString();
    }



}
