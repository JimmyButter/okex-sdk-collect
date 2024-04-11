package com.supermancell.trans.common.constant;

public enum InstType {

    SPOT("SPOT"),//币币
    MARGIN("MARGIN"),//币币杠杆
    SWAP("SWAP"),//永续合约
    FUTURES("FUTURES"),//交割合约
    OPTION("OPTION"),//期权
    ;

    private String v;

    InstType(String v) {
        this.v = v;
    }

    public String v() {
        return v;
    }
}
