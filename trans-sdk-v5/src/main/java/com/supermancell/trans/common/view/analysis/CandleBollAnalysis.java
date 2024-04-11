package com.supermancell.trans.common.view.analysis;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 布林线
 */
@Data
public class CandleBollAnalysis {

    private BigDecimal ma;//移动平均线
    private BigDecimal std;//标准差
    private BigDecimal bollMb;//布林中轨 = ma 移动平均线
    private BigDecimal bollUp;//布林上轨 = ma + 2std
    private BigDecimal bollDn;//布林下轨 = ma - 2std
    private BigDecimal rsi;//RSI

    public BigDecimal maAddStd(int n) {
        return ma.add(std.multiply(new BigDecimal(n)));
    }

    public BigDecimal maSubStd(int n) {
        return ma.subtract(std.multiply(new BigDecimal(n)));
    }
}
