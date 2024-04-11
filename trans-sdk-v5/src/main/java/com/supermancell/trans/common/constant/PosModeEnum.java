package com.supermancell.trans.common.constant;

public enum PosModeEnum {
    //仅适用交割/永续

    long_short_mode("long_short_mode"),//双向持仓
    net_mode("net_mode"),//单向持仓
    ;

    private String v;

    PosModeEnum(String v) {
        this.v = v;
    }

    public String v() {
        return v;
    }
}
