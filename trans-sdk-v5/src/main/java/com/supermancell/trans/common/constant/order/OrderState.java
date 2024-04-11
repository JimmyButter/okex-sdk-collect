package com.supermancell.trans.common.constant.order;

public enum OrderState {

    LIVE("live"),//等待成交
    PARTIALLY_FILLED("partially_filled"),//部分成交
    ;

    private String v;

    OrderState(String v) {
        this.v = v;
    }

    public String v() {
        return v;
    }
}
