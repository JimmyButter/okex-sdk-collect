package com.supermancell.trans.common.constant;

public enum MgnModeEnum {

    isolated("isolated"),//逐仓
    cross("cross"),//全仓
    ;

    private String v;

    MgnModeEnum(String v) {
        this.v = v;
    }

    public String v() {
        return v;
    }
}
