package com.okex.open.api.bean.other;

import com.supermancell.trans.common.constant.order.SideType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PerOrder {
    private String instId;
    private BigDecimal openPx;
    private String openSz;
    private SideType side;
    private String pairSeqNo;
}
