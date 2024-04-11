package com.supermancell.trans.common.factory.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.service.marketData.MarketDataAPIService;
import com.supermancell.trans.common.view.CandleView;
import com.supermancell.trans.common.view.TickerView;
import com.supermancell.trans.common.view.resp.OkexApiResp;

import java.util.List;


public class MarketApi {

    private volatile static MarketApi singleton = null;
    private MarketDataAPIService marketApi;

    public static MarketApi instance(){
        if(singleton == null) {
            singleton = new MarketApi();
        }
        return singleton;
    }

    public MarketApi(){
        marketApi = PublicApiFactory.instance().marketDataApi();
    }

    public TickerView tickers(String instType, String uly){
        JSONObject res = marketApi.getTickers(instType, uly);
        OkexApiResp okexApiResp = JSON.parseObject(res.toJSONString(), OkexApiResp.class);
        return okexApiResp.ticker();
    }

    //GET /api/v5/market/candles
    public List<CandleView> candles(String instId, String bar, String before, String after, String limit){
        JSONObject res = marketApi.getCandlesticks(instId, after, before, bar, limit);

        OkexApiResp okexApiResp = JSON.parseObject(res.toJSONString(), OkexApiResp.class);
        return okexApiResp.candles();
    }

    //GET /api/v5/market/history-candles
    public List<CandleView> candlesHistory(String instId, String bar, String before, String after){
        JSONObject res = marketApi.getCandlesticksHistory(instId, after, before, bar, null);

        OkexApiResp okexApiResp = JSON.parseObject(res.toJSONString(), OkexApiResp.class);
        return okexApiResp.candles();
    }



}
