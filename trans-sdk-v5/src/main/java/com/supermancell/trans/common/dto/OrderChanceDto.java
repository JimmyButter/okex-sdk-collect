package com.supermancell.trans.common.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderChanceDto {

    private String pairSeqNo;
    private String askInstId;
    private BigDecimal askOpenPx;
    private String askOpenSz;
    private String bidInstId;
    private BigDecimal bidOpenPx;
    private String createTime;
    private String bidOpenSz;
    private int askStatus;
    private int bidStatus;
}
