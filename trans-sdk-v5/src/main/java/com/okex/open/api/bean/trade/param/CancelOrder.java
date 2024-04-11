package com.okex.open.api.bean.trade.param;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class CancelOrder {
    private String instId;
    private String ordId;
    private String clOrdId;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
