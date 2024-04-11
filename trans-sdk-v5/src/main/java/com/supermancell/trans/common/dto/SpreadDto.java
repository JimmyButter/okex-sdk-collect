package com.supermancell.trans.common.dto;

import com.supermancell.trans.common.view.InstrumentView;
import com.supermancell.trans.common.view.analysis.CandleBollAnalysis;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SpreadDto {

    private String instId;
    private String uly;
    private BigDecimal ask;
    private BigDecimal bid;
    private BigDecimal spread;
    private BigDecimal thousandth;
    private CandleBollAnalysis boll;
    private BigDecimal std;
    private int stdN;
    private InstrumentView instFutures;
}
