package com.okex.open.api.bean.trade.param;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class ClosePositions {
    private String instId;
    private String posSide;
    private String mgnMode;
    private String ccy;
    private String autoCxl;
    private String clOrdId;
    private String tag;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
