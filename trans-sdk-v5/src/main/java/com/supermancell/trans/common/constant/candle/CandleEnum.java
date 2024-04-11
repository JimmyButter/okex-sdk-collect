package com.supermancell.trans.common.constant.candle;

public enum CandleEnum {

    ts(0),
    open(1),
    high(2),
    low(3),
    close(4),
    vol(5),
    volCcy(6),
    volCcyQuote(7),
    confirm(8),
            ;

    private int value;

    CandleEnum(int value) {
        this.value = value;
    }

    public int v() {
        return value;
    }
}
