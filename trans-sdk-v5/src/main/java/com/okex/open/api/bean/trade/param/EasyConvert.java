package com.okex.open.api.bean.trade.param;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

@Data
public class EasyConvert {
    private List<String> fromCcy;
    private String toCcy;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
