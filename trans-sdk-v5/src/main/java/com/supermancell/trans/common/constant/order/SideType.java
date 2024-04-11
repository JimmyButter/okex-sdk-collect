package com.supermancell.trans.common.constant.order;

public enum SideType {

    LONG("long", "buy",  "sell"),
    SHORT("short", "sell", "buy"),
    NONE("none", "none", "none"),
    ;

    private String v, open, close;

    SideType(String v, String open, String close) {

        this.v = v;
        this.open = open;
        this.close = close;
    }

    public String v() {
        return v;
    }
    public String open() {
        return open;
    }
    public String close() {
        return close;
    }
}
