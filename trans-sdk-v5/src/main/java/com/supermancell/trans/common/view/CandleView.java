package com.supermancell.trans.common.view;

import com.alibaba.fastjson.JSONArray;
import com.supermancell.trans.common.constant.candle.CandleEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class CandleView {

    private long ts;
    private BigDecimal o;
    private BigDecimal h;
    private BigDecimal l;
    private BigDecimal c;
    private BigDecimal vol;
    private BigDecimal volCcy;
    private BigDecimal volCcyQuote;//交易量，以计价货币USDT为单位
    private Integer confirm;

    public static List<CandleView> candles(JSONArray data) {

        List<CandleView> list = new ArrayList<>();
        for(int i=0; i<data.size(); i++) {
            CandleView view = new CandleView();
            JSONArray current = data.getJSONArray(i);
            view.setC(current.getBigDecimal(CandleEnum.close.v()));
            view.setConfirm(current.getInteger(CandleEnum.confirm.v()));
            view.setH(current.getBigDecimal(CandleEnum.high.v()));
            view.setL(current.getBigDecimal(CandleEnum.low.v()));
            view.setO(current.getBigDecimal(CandleEnum.open.v()));
            view.setTs(current.getLongValue(CandleEnum.ts.v()));
            view.setVol(current.getBigDecimal(CandleEnum.vol.v()));
            view.setVolCcy(current.getBigDecimal(CandleEnum.volCcy.v()));
            view.setVolCcyQuote(current.getBigDecimal(CandleEnum.volCcyQuote.v()));
            list.add(view);
        }
        return list;
    }
}
