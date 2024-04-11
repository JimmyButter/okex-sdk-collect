package com.supermancell.trans.common.view.resp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.supermancell.trans.common.constant.candle.CandleEnum;
import com.supermancell.trans.common.dto.AccountDetail;
import com.supermancell.trans.common.view.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用泛型，无法支持JSONObject.parseXxx()
 */
@Data
public class OkexWsResp{

    private String action;
    private String event;
    private String code;
    private String msg;
    private JSONArray data;
    private Arg arg;
    private String op;
    private String id;
    private String connId;

    /**
     * 行情
     * @return
     */
    public List<TickerView> tickers(){
        if(data == null) {
            return new ArrayList<>();
        }

        return JSONObject.parseArray(data.toJSONString(), TickerView.class);
    }

    /**
     * 资金费率
     * @return
     */
    public FundingRateView fundingRate(){
        if(data == null || data.size() == 0) {
            return null;
        }

        return JSONObject.parseObject(data.getString(0), FundingRateView.class);
    }

    /**
     * 钱包明细
     * @return
     */
    public List<AccountDetail> accountDetails() {
        if(data == null || data.size() == 0) {
            return null;
        }

        return JSONObject.parseArray(data.getJSONObject(0).getJSONArray("details").toJSONString(), AccountDetail.class);
    }

    /**
     * 通过账户接口拿到usdt数量
     * @return
     */
    public BigDecimal accountAmount(){
        if(data == null || data.size() == 0) {
            return null;
        }

        return data.getJSONObject(0).getBigDecimal("totalEq");
    }

    /**
     * 订单
     * @return
     */
    public List<OrderView> orders(){
        if(data == null || data.size() == 0) {
            return new ArrayList<>();
        }

        return JSONObject.parseArray(data.toJSONString(), OrderView.class);
    }

    public List<PositionView> positions(){
        if(data == null || data.size() == 0) {
            return new ArrayList<>();
        }

        return JSONObject.parseArray(data.toJSONString(), PositionView.class);
    }

    public CandleView candle(){
        if(data == null || data.size() == 0) {
            return null;
        }

        CandleView view = new CandleView();
        JSONArray current = data.getJSONArray(0);
        view.setC(current.getBigDecimal(CandleEnum.close.v()));
        view.setConfirm(current.getInteger(CandleEnum.confirm.v()));
        view.setH(current.getBigDecimal(CandleEnum.high.v()));
        view.setL(current.getBigDecimal(CandleEnum.low.v()));
        view.setO(current.getBigDecimal(CandleEnum.open.v()));
        view.setTs(current.getLongValue(CandleEnum.ts.v()));
        view.setVol(current.getBigDecimal(CandleEnum.vol.v()));
        view.setVolCcy(current.getBigDecimal(CandleEnum.volCcy.v()));
        view.setVolCcyQuote(current.getBigDecimal(CandleEnum.volCcyQuote.v()));

        return view;
    }

    @Data
    public class Arg{
        private String instId;
        private String channel;
        private String ccy;
    }

    public OrderFail orderFail(){
        if(data == null || data.size() == 0) {
            return null;
        }

        return JSONObject.parseObject(data.getString(0), OrderFail.class);

    }

}
