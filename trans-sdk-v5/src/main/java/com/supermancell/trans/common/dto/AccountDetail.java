package com.supermancell.trans.common.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDetail {

    public AccountDetail(){}

    public AccountDetail(String ccy, BigDecimal totalEq){
        this.ccy = ccy;
        this.cashBal = cashBal;
    }

    private String availBal;
    private String availEq;
    private String ccy;
    private BigDecimal cashBal;
    private long uTime;
    private BigDecimal disEq;
    private String eq;
    private BigDecimal eqUsd;
    private String frozenBal;
    private String interest;
    private String isoEq;
    private String liab;
    private String maxLoan;
    private String mgnRatio;
    private BigDecimal notionalLever;
    private String ordFrozen;
    private String upl;
    private String uplLiab;
    private String crossLiab;
    private String isoLiab;
    private String coinUsdPrice;
    private String stgyEq;
    private String spotInUseAmt;
    private String isoUpl;

//    "availBal": "",
//            "availEq": "1",
//            "ccy": "BTC",
//            "cashBal": "1",
//            "uTime": "1617279471503",
//            "disEq": "50559.01",
//            "eq": "1",
//            "eqUsd": "45078.3790756226851775",
//            "frozenBal": "0",
//            "interest": "0",
//            "isoEq": "0",
//            "liab": "0",
//            "maxLoan": "",
//            "mgnRatio": "",
//            "notionalLever": "0.0022195262185864",
//            "ordFrozen": "0",
//            "upl": "0",
//            "uplLiab": "0",
//            "crossLiab": "0",
//            "isoLiab": "0",
//            "coinUsdPrice": "60000",
//            "stgyEq":"0",
//            "spotInUseAmt":"",
//            "isoUpl":""
}
