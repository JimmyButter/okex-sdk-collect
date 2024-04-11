package com.supermancell.trans.common.view;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TickerView {

    private BigDecimal last;
    private BigDecimal lastSz;
    private BigDecimal open24h;
    private BigDecimal askSz;
    private BigDecimal low24h;
    private BigDecimal volCcy24h;
    private BigDecimal vol24h;
    private String instType;
    private String instId;
    private BigDecimal bidSz;
    private BigDecimal high24h;
    private long ts;
}
