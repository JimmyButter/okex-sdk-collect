package com.supermancell.trans.common.constant.op;

public enum OpEnum {

    AMEND_ORDER("amend-order"),
    BATCH_AMEND_ORDERS("batch-amend-orders"),
    ORDER("order"),
    BATCH_ORDERS("batch-orders"),
    BATCH_CANCEL_ORDERS("batch-cancel-orders"),
    CANCEL_ORDER("cancel-order"),
    SUBSCRIBE("subscribe"),
    UNSUBSCRIBE("unsubscribe"),;

    private String value;

    OpEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
