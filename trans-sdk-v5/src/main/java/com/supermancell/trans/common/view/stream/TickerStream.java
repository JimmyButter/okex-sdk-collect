package com.supermancell.trans.common.view.stream;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TickerStream {

    private BigDecimal last;
    private BigDecimal perLast;
    private BigDecimal sz;
    private BigDecimal perSz;
    private long ts;
    private long perTs;


    @Override
    public String toString() {

        String str =  "TickerStream{" +
                "last=" + last +
                ", perLast=" + perLast +
                ", sz=" + sz +
                ", perSz=" + perSz +
                ", ts=" + ts +
                ", perTs=" + perTs +
                "} " ;

        StringBuffer sb = new StringBuffer(str);
        return sb.toString();
    }
}
