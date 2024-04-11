package com.supermancell.trans.common.view.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class OpenConfirm {

    private long id;
    private String instId;
    private String openTime;
    private BigDecimal openSpread;
    private BigDecimal openStd;
    private BigDecimal openMb;
    private int confirm;
    private String confirmTime;
    private BigDecimal confirmSpread;
    private BigDecimal ulyPrice;
    private BigDecimal futuresPrice;
}
