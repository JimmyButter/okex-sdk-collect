package com.supermancell.trans.common.factory.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.service.publicData.PublicDataAPIService;
import com.okex.open.api.service.status.StatusDataAPIService;
import com.okex.open.api.service.status.impl.StatusDataAPI;
import com.supermancell.trans.common.view.InstrumentView;
import com.supermancell.trans.common.view.resp.OkexApiResp;

import java.util.List;


public class DataApi {

    private volatile static DataApi singleton = null;
    private PublicDataAPIService dataApi;

    public static DataApi instance(){
        if(singleton == null) {
            singleton = new DataApi();
        }
        return singleton;
    }

    public DataApi(){
        dataApi = PublicApiFactory.instance().pubDateApi();
    }

    //GET /api/v5/public/instruments
    public List<InstrumentView> instruments(String instType, String instId){
        JSONObject res = dataApi.getInstruments(instType, null, instId);

        OkexApiResp okexApiResp = JSON.parseObject(res.toJSONString(), OkexApiResp.class);
        return okexApiResp.instruments();
    }

}
