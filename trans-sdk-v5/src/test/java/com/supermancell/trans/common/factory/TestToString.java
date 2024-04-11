package com.supermancell.trans.common.factory;

import com.okex.open.api.bean.trade.param.AmendOrder;
import com.okex.open.api.utils.OrderIdUtils;
import org.junit.Test;

public class TestToString {

    @Test
    public void test(){
        AmendOrder amendOrder = new AmendOrder();
        amendOrder.setCxlOnFail(true);
        amendOrder.setInstId("BTC-USDT-SWAP");
        amendOrder.setNewPx("2800.8");
        amendOrder.setClOrdId(OrderIdUtils.generator());

        System.out.println(amendOrder);
    }
}
