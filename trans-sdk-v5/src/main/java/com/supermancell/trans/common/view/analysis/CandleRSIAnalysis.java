package com.supermancell.trans.common.view.analysis;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 布林线
 */
@Data
public class CandleRSIAnalysis {

    private BigDecimal ma;//移动平均线
    private BigDecimal rsi;//RSI
    private BigDecimal std;//标准差
    private BigDecimal top;
    private BigDecimal under;
}
