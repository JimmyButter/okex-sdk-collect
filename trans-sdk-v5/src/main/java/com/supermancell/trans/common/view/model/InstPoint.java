package com.supermancell.trans.common.view.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InstPoint implements java.io.Serializable{
    private String instId;
    private Integer point;//评分
    private Long avgVol;//每分钟的平均成交金额
    private BigDecimal ctVal;
    private BigDecimal tickSz;
    private int scale;
    private String status;
    private String lever;//	杠杆倍数， 不适用于币币

}
