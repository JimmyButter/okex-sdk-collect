package com.supermancell.trans.common.factory.ws;

import com.okex.open.api.enums.CharsetEnum;
import com.supermancell.trans.common.constant.OkexConstant;
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
import java.util.concurrent.TimeUnit;

@Slf4j
public class PrivateWsFactory {

    private volatile static WebSocket priWebSocket = null;
    private volatile static boolean ON_CONNECTING = false;
    private volatile static long LAST_PONG_TS = 0;
    private volatile static boolean HAS_LOGIN = false;
    private volatile static Worker worker;

    public static WebSocket WS(Worker worker, WebSocketListener listener){

        if(priWebSocket != null && ON_CONNECTING && ts() < 30) {
            return priWebSocket;
        }

        synchronized (PrivateWsFactory.class) {
            PrivateWsFactory.worker = worker;
            log.debug("connection to " + OkexConstant.WS_PRIVATE_SERVICE_URL);
            OkHttpClient client = new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS)
                    .sslSocketFactory(createSSLSocketFactory(), new TrustAllCerts())
                    .hostnameVerifier(new TrustAllHostnameVerifier())
                    .retryOnConnectionFailure(true).build();
            Request request = new Request.Builder().url(OkexConstant.WS_PRIVATE_SERVICE_URL).build();
            priWebSocket = client.newWebSocket(request, listener);

            if(priWebSocket!=null) {
                login();
                ON_CONNECTING = true;
            }

            return priWebSocket;

        }


    }

    public static void retry(WebSocketListener listener){
        synchronized (PrivateWsFactory.class) {
            if(ON_CONNECTING == false) {
                log.debug("reconnection to " + OkexConstant.WS_PRIVATE_SERVICE_URL);
                OkHttpClient client = new OkHttpClient.Builder().readTimeout(12, TimeUnit.SECONDS)
                        .sslSocketFactory(createSSLSocketFactory(), new TrustAllCerts())
                        .hostnameVerifier(((hostname, session) -> true))
                        .build();
//                OkHttpClient client = new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS)
//                        .retryOnConnectionFailure(true).build();
                Request request = new Request.Builder().url(OkexConstant.WS_PRIVATE_SERVICE_URL).build();
                priWebSocket = client.newWebSocket(request, listener);

                if (priWebSocket != null) {
                    login();
                    ON_CONNECTING = true;
                }
            }

        }
    }

    public static void setStatus(boolean b){
        synchronized (PrivateWsFactory.class) {
            ON_CONNECTING = b;
        }
    }

    public static void setLoginStatus(boolean b){
        synchronized (PrivateWsFactory.class) {
            HAS_LOGIN = b;
        }
    }

    public static boolean hasLogin(){
        return HAS_LOGIN;
    }

    public static void setLastPongTs(long ts){
        synchronized (PrivateWsFactory.class) {
            LAST_PONG_TS = ts;
        }
    }

    private static long ts(){
        return System.currentTimeMillis()/1000 - LAST_PONG_TS;
    }

    public static void login() {

        String apiKey = worker.getApiKey();
        String passPhrase = worker.getPassphrase();
        String secretKey = worker.getSecretKey();
        String timestamp = System.currentTimeMillis() / 1000+ "";
        String message = timestamp + "GET" + "/users/self/verify";
        String sign = sha256_HMAC(message, secretKey);
        String str = "{\"op\"" + ":" + "\"login\"" + "," + "\"args\"" + ":" + "[{" + "\"apiKey\"" + ":"+ "\"" + apiKey + "\"" + "," + "\"passphrase\"" + ":" + "\"" + passPhrase + "\"" + ","+ "\"timestamp\"" + ":"  + "\"" + timestamp + "\"" + ","+ "\"sign\"" + ":"  + "\"" + sign + "\"" + "}]}";
        log.debug("Login->" + str);
        priWebSocket.send(str);
    }

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

    public void saleSend(String text){

        if(!ON_CONNECTING || !HAS_LOGIN) {
            try {
                Thread.sleep(2000);
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        priWebSocket.send(text);
    }

    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

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



}
