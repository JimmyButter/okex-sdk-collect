package com.supermancell.trans.common.constant;

public class OkexConstant {

    public final static String ENDPOINT = "https://www.okx.com";
    public final static String WS_PRIVATE_SERVICE_URL = "wss://ws.okx.com:8443/ws/v5/private";
    public final static String WS_PRIVATE_SERVICE_LISTENER = "com.supermancell.trans.common.factory.ws.listener.PriChannelListener";
    public final static String WS_PUBLIC_SERVICE_URL = "wss://ws.okx.com:8443/ws/v5/public";
    public final static String WS_PUBLIC_SERVICE_LISTENER = "com.supermancell.trans.common.factory.ws.listener.PubChannelListener";
    public final static String WS_BUSINESS_SERVICE_URL = "wss://ws.okx.com:8443/ws/v5/business";
    public final static String WS_BUSINESS_SERVICE_LISTENER = "com.supermancell.trans.common.factory.ws.listener.BusChannelListener";
    public final static String TRANS_API = "http://trans-api.supermancell.com";

    public final static String CODE_SUCCESS = "0";
    public static String EVENT_PONG = "pong";
    public static String EVENT_LOGIN = "login";
    public static String EVENT_ERROR = "error";
    public static String EVENT_SUBSCRIBE = "subscribe";
    public static String CHANNEL_TICKERS = "tickers";
    public static String CHANNEL_BOOKS = "books";
    public static String CHANNEL_BOOKS5 = "books5";//首次推5档快照数据，以后定量推送，每100毫秒当5档快照数据有变化推送一次5档数据
    public static String CHANNEL_BOOKS_TBT = "books-l2-tbt";//首次推400档快照数据，以后增量推送，每10毫秒推送一次变化的数据
    public static String CHANNEL_ACCOUNT = "account";
    public static String CHANNEL_FUNDING_RATE = "funding-rate";
    public static String CHANNEL_POSITIONS = "positions";
    public static String CHANNEL_ORDERS = "orders";
    public static String CHANNEL_CANDLE15m = "candle15m";
    public static String CHANNEL_CANDLE5m = "candle5m";
    public static String CHANNEL_CANDLE1H = "candle1H";
    public static String CHANNEL_CANDLE1D = "candle1D";
    public static String OP_AMEND_ORDER = "amend-order";
    public static String OP_ORDER = "amend-order";

    public static String EVENT_CODE_UN_LOGIN = "60011";
}
