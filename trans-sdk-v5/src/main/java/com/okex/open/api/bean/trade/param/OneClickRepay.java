package com.okex.open.api.bean.trade.param;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

@Data
public class OneClickRepay {
    private List<String> debtCcy;
    private String repayCcy;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
