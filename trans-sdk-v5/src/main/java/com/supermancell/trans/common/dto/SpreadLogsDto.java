package com.supermancell.trans.common.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class SpreadLogsDto {

    private Long spreadId;
    private String instId;
    private String ulyId;
    private BigDecimal spread;
    private BigDecimal md;
    private BigDecimal std;
    private BigDecimal up;
    private BigDecimal ask;
    private BigDecimal bid;
    private String createTime;
}
