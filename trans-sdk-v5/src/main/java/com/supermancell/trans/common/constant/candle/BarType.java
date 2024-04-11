package com.supermancell.trans.common.constant.candle;

public enum BarType {

    TYPE_1M("1m"),
    //TYPE_5M("5m"),
    TYPE_15M("15m"),
    TYPE_1H("1H"),
    TYPE_4H("4H"),
    //TYPE_1D("1D"),
    //TYPE_1W("1W"),
    ;

    private String v;

    BarType(String v) {
        this.v = v;
    }

    public String v() {
        return v;
    }
}
