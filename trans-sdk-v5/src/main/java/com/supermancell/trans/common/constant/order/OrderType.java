package com.supermancell.trans.common.constant.order;

public enum OrderType {

    MARKET("market"),//市价单
    LIMIT("limit"),//限价单
    POST_ONLY("post_only"),//只做maker单
    FOK("fok"),//全部成交或立即取消
    IOC("ioc"),//立即成交并取消剩余
    OPTIMAL_LIMIT_IOC("optimal_limit_ioc"),//市价委托立即成交并取消剩余（仅适用交割、永续）
    ;

    private String v;

    OrderType(String v) {
        this.v = v;
    }

    public String v() {
        return v;
    }
}
