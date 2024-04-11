package com.okex.open.api.bean.trade.param;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class PlaceAlgoOrder {
    private String instId;
    private String tdMode;
    private String ccy;
    private String side;
    private String posSide;
    private String ordType;
    private String sz;
    private Boolean reduceOnly;
    private String tgtCcy;
    private String tag;
    //止盈止损
    private String tpTriggerPx;
    private String tpOrdPx;
    private String slTriggerPx;
    private String slOrdPx;
    private String tpTriggerPxType;
    private String slTriggerPxType;

    //计划委托
    private String triggerPx;
    private String orderPx;
    private String triggerPxType;

    //移动止盈止损
    private String callbackRatio;
    private String callbackSpread;
    private String activePx;

    //冰山委托
    private String pxVar;
    private String pxSpread;
    private String szLimit;
    private String pxLimit;

    //时间加权（其他参数跟冰山委托一致）
    private String timeInterval;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
