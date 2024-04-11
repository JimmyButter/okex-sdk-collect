package com.supermancell.trans.common.factory.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.service.publicData.PublicDataAPIService;
import com.okex.open.api.service.status.StatusDataAPIService;
import com.supermancell.trans.common.view.InstrumentView;
import com.supermancell.trans.common.view.model.SystemStatus;
import com.supermancell.trans.common.view.resp.OkexApiResp;

import java.util.List;


public class DataStatusApi {

    private volatile static DataStatusApi singleton = null;
    private StatusDataAPIService dataApi;

    public static DataStatusApi instance(){
        if(singleton == null) {
            singleton = new DataStatusApi();
        }
        return singleton;
    }

    public DataStatusApi(){
        dataApi = PublicApiFactory.instance().statusApi();
    }

    //GET /api/v5/system/status
    public SystemStatus getStatus(){
        JSONObject res = dataApi.getStatus(null);

        OkexApiResp okexApiResp = JSON.parseObject(res.toJSONString(), OkexApiResp.class);
        return okexApiResp.systemStatus();
    }

}
