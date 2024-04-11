package com.supermancell.trans.common.constant.order;

public enum OrderFailCode {


    NOT_ENOUGH("51008"),//委托失败，账户余额不足
    ;

    private String code;

    OrderFailCode(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
