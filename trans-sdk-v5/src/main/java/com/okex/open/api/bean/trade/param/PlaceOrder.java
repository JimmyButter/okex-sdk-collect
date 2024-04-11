package com.okex.open.api.bean.trade.param;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class PlaceOrder {
    private String instId;
    private String tdMode;
    private String ccy;
    private String clOrdId;
    private String tag;
    private String side;
    private String posSide;
    private String ordType;
    private String sz;
    private String px;
    private String tgtCcy;
    private Boolean banAmend;
    private Boolean reduceOnly;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
