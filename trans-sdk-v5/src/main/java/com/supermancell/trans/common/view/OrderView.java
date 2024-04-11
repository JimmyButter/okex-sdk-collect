package com.supermancell.trans.common.view;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderView {

    private String instType;
    private String instId;
    private String ordId;
    private String clOrdId;
    private String tag;
    private BigDecimal px;
    private Integer sz;
    private String ordType;
    private String side;
    private String posSide;
    private int lever;
    private String tradeId;
    private String fillSz;
    private String fillTime;
    private String state;
    private BigDecimal fee;
    private long uTime;
    private long cTime;
}
