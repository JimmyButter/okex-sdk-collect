package com.supermancell.trans.common.factory.api;

import com.alibaba.fastjson.JSONObject;
import com.supermancell.trans.common.constant.candle.BarType;
import com.supermancell.trans.common.constant.utils.AnalysisUtils;
import com.supermancell.trans.common.view.CandleView;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class MarketApiTest {

    private MarketApi api = MarketApi.instance();

    @Test
    public void test() {
        List<CandleView> list = api.candles("BTC-USDT-SWAP", BarType.TYPE_4H.v(), null, null, null);
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void testStandardDeviation(){
        List<CandleView> list = api.candles("BTC-USDT-SWAP", BarType.TYPE_4H.v(), null, null, null);
        BigDecimal ma = AnalysisUtils.MA(list, 30 ,1);
        BigDecimal variance = AnalysisUtils.variance(list, ma, 30, 1);
        BigDecimal sd = AnalysisUtils.StandardDeviation(variance, 1);
        System.out.println(sd);
    }

    @Test
    public void testRSV() {
        List<CandleView> list = api.candles("BTC-USDT-SWAP", BarType.TYPE_4H.v(), null, null, null);
        BigDecimal rsv = AnalysisUtils.rsv(list, 9);
        System.out.println(rsv);
    }
}
