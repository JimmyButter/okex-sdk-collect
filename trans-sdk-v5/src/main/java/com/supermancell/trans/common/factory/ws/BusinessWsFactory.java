package com.supermancell.trans.common.factory.ws;

import com.supermancell.trans.common.constant.OkexConstant;
import com.supermancell.trans.common.factory.TrustAllCerts;
import com.supermancell.trans.common.factory.ws.health.WsHealth;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BusinessWsFactory {

    private volatile static WebSocket webSocket = null;
    private volatile static boolean ON_CONNECTING = false;
    private static WsHealth health;

    public static WebSocket WS(WebSocketListener listener){

        if(health == null){
            health = new WsHealth();
        }

        if(webSocket != null && ON_CONNECTING) {
            return webSocket;
        }

        synchronized (BusinessWsFactory.class) {
            log.debug("connection to " + OkexConstant.WS_BUSINESS_SERVICE_URL);
            OkHttpClient client = new OkHttpClient.Builder().readTimeout(12, TimeUnit.SECONDS)
                    .sslSocketFactory(createSSLSocketFactory(), new TrustAllCerts())
                    .hostnameVerifier(((hostname, session) -> true))
                    .build();
            Request request = new Request.Builder().url(OkexConstant.WS_BUSINESS_SERVICE_URL).build();
            webSocket = client.newWebSocket(request, listener);
            ON_CONNECTING = true;
        }

        return webSocket;
    }

    public static void retry(WebSocketListener listener){
        synchronized (BusinessWsFactory.class) {
            if(ON_CONNECTING == false) {
                log.debug("reconnection to " + OkexConstant.WS_BUSINESS_SERVICE_URL);
                OkHttpClient client = new OkHttpClient.Builder().readTimeout(12, TimeUnit.SECONDS)
                        .sslSocketFactory(createSSLSocketFactory(), new TrustAllCerts())
                        .hostnameVerifier(((hostname, session) -> true))
                        .build();
                Request request = new Request.Builder().url(OkexConstant.WS_BUSINESS_SERVICE_URL).build();
                webSocket = client.newWebSocket(request, listener);
                ON_CONNECTING = true;
            }

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

    public static void setPubStatus(boolean b){
        synchronized (BusinessWsFactory.class) {
            ON_CONNECTING = b;
        }
    }

    public static void setLastPongTs(long ts){
        synchronized (BusinessWsFactory.class) {
            health.setLastBeatTime(ts);
        }
    }

}
