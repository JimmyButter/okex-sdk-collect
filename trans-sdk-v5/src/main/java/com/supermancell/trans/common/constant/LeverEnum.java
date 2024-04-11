package com.supermancell.trans.common.constant;

public enum LeverEnum {

    five("5"),//5倍
    ten("10"),//10倍, 策略合理倍数为10
    twenty("20"),//20倍
    ;

    private String v;

    LeverEnum(String v) {
        this.v = v;
    }

    public String v() {
        return v;
    }
}
