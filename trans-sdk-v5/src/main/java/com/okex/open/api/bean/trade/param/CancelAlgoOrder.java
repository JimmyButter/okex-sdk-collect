package com.okex.open.api.bean.trade.param;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class CancelAlgoOrder {

    private String algoId;
    private String instId;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
