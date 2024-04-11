package com.supermancell.trans.common.factory.api;

import com.supermancell.trans.common.constant.utils.AnalysisUtils;
import com.supermancell.trans.common.view.analysis.CandleBollAnalysis;
import com.supermancell.trans.common.view.analysis.CandleRSIAnalysis;
import com.supermancell.trans.common.view.CandleView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class AnalysesApi {

    private volatile static AnalysesApi singleton = null;

    public static AnalysesApi instance(){
        if(singleton == null) {
            singleton = new AnalysesApi();
        }
        return singleton;
    }

    /**
     * 价差蜡烛图
     * @param candlesFutures
     * @param candlesUly
     * @return
     */
    public List<CandleView> spread(List<CandleView> candlesFutures, List<CandleView> candlesUly) {
        List<CandleView> spreadList = new ArrayList<>();
        for(int i=0; i< candlesFutures.size(); i++) {
            CandleView candleView = new CandleView();
            candleView.setC(candlesFutures.get(i).getC().subtract(candlesUly.get(i).getC()).abs());
            candleView.setL(candlesFutures.get(i).getL().subtract(candlesUly.get(i).getL()).abs());
            candleView.setH(candlesFutures.get(i).getH().subtract(candlesUly.get(i).getH()).abs());
            candleView.setO(candlesFutures.get(i).getO().subtract(candlesUly.get(i).getO()).abs());
            spreadList.add(candleView);
        }

        return spreadList;
    }

    /**
     * 分析布林线技术指标
     * @param scale
     * @return
     */
    public CandleBollAnalysis candleBollAnalyses(List<CandleView> candles, int scale){

        final int anaSize = 20;

        if(candles==null || candles.size() < anaSize) {
            return null;
        }

        CandleBollAnalysis analysis = new CandleBollAnalysis();
        BigDecimal ma = AnalysisUtils.MA(candles, anaSize, scale);
        BigDecimal variance = AnalysisUtils.variance(candles, ma, anaSize, scale);
        BigDecimal std = AnalysisUtils.StandardDeviation(variance, scale);
        BigDecimal ris = AnalysisUtils.RSI(candles, anaSize);

        analysis.setMa(ma);
        analysis.setStd(std);
        analysis.setBollMb(ma);
        analysis.setBollUp(ma.add(new BigDecimal(2).multiply(std)));
        analysis.setBollDn(ma.subtract(new BigDecimal(2).multiply(std)));
        analysis.setRsi(ris);
        return analysis;

    }

    /**
     * RSI 7
     * @param candles
     * @param scale
     * @return
     */
    public CandleRSIAnalysis candleRSIAnalysis(List<CandleView> candles, int scale) {

        final int anaSize = 7;
        if(candles==null || candles.size() < anaSize) {
            return null;
        }

        CandleRSIAnalysis analysis = new CandleRSIAnalysis();
        BigDecimal ma = AnalysisUtils.MA(candles, anaSize, scale);
        BigDecimal rsi = AnalysisUtils.RSI(candles, anaSize);
        analysis.setRsi(ma);
        analysis.setRsi(rsi);
        BigDecimal variance = AnalysisUtils.variance(candles, ma, anaSize, scale);
        BigDecimal std = AnalysisUtils.StandardDeviation(variance, scale);
        BigDecimal high = AnalysisUtils.Top(candles, anaSize);
        BigDecimal low = AnalysisUtils.Under(candles, anaSize);
        analysis.setStd(std);
        analysis.setTop(high);
        analysis.setUnder(low);
        return analysis;
    }





}
