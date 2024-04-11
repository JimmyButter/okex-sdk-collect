package com.supermancell.trans.common.view.resp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.supermancell.trans.common.constant.candle.CandleEnum;
import com.supermancell.trans.common.constant.OkexConstant;
import com.supermancell.trans.common.view.*;
import com.supermancell.trans.common.view.model.SystemStatus;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OkexApiResp {

    private String code;
    private String msg;
    private JSONArray data;

    public SystemStatus systemStatus(){
        if(!OkexConstant.CODE_SUCCESS.equals(code) || data.size()==0){
            return null;
        }

        return JSONObject.parseObject(data.getString(0), SystemStatus.class);
    }

    public List<InstrumentView> instruments(){
        List<InstrumentView> list = new ArrayList<>();
        if(!OkexConstant.CODE_SUCCESS.equals(code)){
            return list;
        }

        return JSONArray.parseArray(data.toJSONString(), InstrumentView.class);
    }

    public List<CandleView> candles(){
        List<CandleView> list = new ArrayList<>();
        if(!OkexConstant.CODE_SUCCESS.equals(code)){
            return list;
        }

        return CandleView.candles(data);
    }

    public TickerView ticker(){
        if(!OkexConstant.CODE_SUCCESS.equals(code)){
            return null;
        }

        return JSON.parseObject(data.getJSONObject(0).toJSONString(), TickerView.class);
    }

    public List<OrderView> orders(){
        if(!OkexConstant.CODE_SUCCESS.equals(code)){
            return new ArrayList<>();
        }

        return JSON.parseArray(data.toJSONString(), OrderView.class);
    }

    public AccountConfigView accountConfig(){
        if(!OkexConstant.CODE_SUCCESS.equals(code) || data.size()==0){
            return null;
        }

        return JSONObject.parseObject(data.getString(0), AccountConfigView.class);
    }

    public List<PositionView> positions(){
        if(!OkexConstant.CODE_SUCCESS.equals(code)){
            return new ArrayList<>();
        }

        return JSON.parseArray(data.toJSONString(), PositionView.class);
    }
}
