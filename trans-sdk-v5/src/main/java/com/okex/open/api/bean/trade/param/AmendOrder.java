package com.okex.open.api.bean.trade.param;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class AmendOrder {
    private String instId;
    private Boolean cxlOnFail;
    private String ordId;
    private String clOrdId;
    private String reqId;
    private String newSz;
    private String newPx;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
