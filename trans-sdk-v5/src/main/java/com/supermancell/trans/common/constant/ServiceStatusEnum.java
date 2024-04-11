package com.supermancell.trans.common.constant;

public enum ServiceStatusEnum {

    WEBSOCKET(0),//WebSocket
    TRANS(5),//交易服务
    BLOCK_TRANS(6),//大宗交易
    QUAN_TRANS(7),//策略交易
    OTHER(99),;

    private int status;

    ServiceStatusEnum(int value) {
        this.status = value;
    }

    public int value() {
        return status;
    }
}
