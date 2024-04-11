package com.supermancell.trans.common.constant.utils;

import com.supermancell.trans.common.view.CandleView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class AnalysisUtils {

    /**
     * RSI
     * @param array
     * @param size
     * @return
     */
    public static BigDecimal RSI(List<CandleView> array, int size){

        if(array.size() < size) {
            return new BigDecimal(50);
        }

        BigDecimal up = BigDecimal.ZERO;
        BigDecimal down = BigDecimal.ZERO;
        BigDecimal perClose = BigDecimal.ZERO;
        for(int i=size-1; i>=0; i--) {
            CandleView candle = array.get(i);
            BigDecimal close = candle.getC();
            if(perClose.compareTo(BigDecimal.ZERO) == 1) {
                BigDecimal temp = close.subtract(perClose);
                if(temp.compareTo(BigDecimal.ZERO) == -1) {
                    down = down.add(temp.abs());
                }else {
                    up = up.add(temp.abs());
                }
            }

            perClose = close;
        }

        up = up.divide(new BigDecimal(array.size()), 4, BigDecimal.ROUND_UP);
        down = down.divide(new BigDecimal(array.size()), 4, BigDecimal.ROUND_UP);

        try {
            BigDecimal rs = up.divide(down, 4, BigDecimal.ROUND_HALF_UP);
            BigDecimal rsi = rs.divide(new BigDecimal(1).add(rs), 4, BigDecimal.ROUND_HALF_UP)
                    .multiply(new BigDecimal(100));
            return rsi;
        }catch (ArithmeticException ex) {
            //ex.printStackTrace();
            return new BigDecimal(100);
        }

    }

    /**
     * MA = (C1+C2+C3+C4+C5+....+Cn)/n C 为收盘价，n 为移动平均周期数
     * @param array
     * @param size
     * @param scale
     * @return MA 移动平均值
     */
    public static BigDecimal MA(List<CandleView> array, int size, int scale){
        if(array.size() < size) {
            size = array.size();
        }

        BigDecimal total = BigDecimal.ZERO;
        for(int i=size-1; i>=0; i--) {
            total = total.add(array.get(i).getC());
        }

        return total.divide(new BigDecimal(size), scale, RoundingMode.HALF_UP);
    }

    /**
     * 最高价
     * @param array
     * @param size
     * @return
     */
    public static BigDecimal Top(List<CandleView> array, int size){
        if(array.size() < size) {
            size = array.size();
        }

        BigDecimal top = BigDecimal.ZERO;
        for(int i=size-1; i>=0; i--) {
            if(array.get(i).getH().compareTo(top) == 1){
                top = array.get(i).getH();
            }
        }
        return top;
    }

    /**
     * 最低价
     * @param array
     * @param size
     * @return
     */
    public static BigDecimal Under(List<CandleView> array, int size){
        if(array.size() < size) {
            size = array.size();
        }

        BigDecimal under = array.get(0).getL();
        for(int i=size-1; i>=0; i--) {
            if(array.get(i).getL().compareTo(under) == -1){
                under = array.get(i).getL();
            }
        }

        return under;
    }

    /**
     * 平均成交量
     * @param array
     * @param size
     * @return
     */
    public static BigDecimal AvgVol(List<CandleView> array, int size){
        if(array.size() < size) {
            size = array.size();
        }

        BigDecimal total = BigDecimal.ZERO;
        for(int i=size-1; i>=0; i--) {
            total = total.add(array.get(i).getVolCcyQuote());
        }

        return total.divide(new BigDecimal(size), 0, RoundingMode.HALF_UP);
    }

    /**
     * 方差s^2=[（x1-x）^2+（x2-x）^2+......（xn-x）^2]/（n）（x为平均数）
     * @param array
     * @param size
     * @param scale
     * @return 方差
     */
    public static BigDecimal variance(List<CandleView> array, BigDecimal x, int size, int scale) {
        BigDecimal total = BigDecimal.ZERO;

        for(int i=size-1; i>=0; i--) {
            BigDecimal xn = array.get(i).getC();
            BigDecimal var = xn.subtract(x);
            total = total.add(var.multiply(var));
        }

        return total.divide(new BigDecimal(size), scale + 2, RoundingMode.UP);
    }

    /**
     * StandardDeviation SD 标准差
     * @param scale
     * @return 标准差
     */
    public static BigDecimal StandardDeviation(BigDecimal variance, int scale){
        return new BigDecimal(Math.sqrt(variance.doubleValue())).setScale(scale , BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal rsv(List<CandleView> array, int size){
        assert array!=null;
        assert array.size()>=size;

        BigDecimal h = BigDecimal.ZERO;
        BigDecimal l = new BigDecimal(100000);
        BigDecimal c = array.get(size -1).getC();

        for(int i=size-1; i>=0; i--) {
            if(array.get(i).getH().compareTo(h) == 1) {
                h = array.get(i).getH();
            }

            if(array.get(i).getL().compareTo(l) == -1) {
                l = array.get(i).getL();
            }
        }

        return c.subtract(l).divide(h.subtract(l), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100));

    }
}
