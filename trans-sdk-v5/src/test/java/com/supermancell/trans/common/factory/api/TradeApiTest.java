package com.supermancell.trans.common.factory.api;

import com.supermancell.trans.common.constant.order.OrderType;
import com.supermancell.trans.common.factory.api.pri.TradeApi;
import com.supermancell.trans.common.view.model.Worker;
import com.supermancell.trans.common.view.OrderView;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TradeApiTest {

    private TradeApi apiWorkerWave2022;

    @Before
    public void init(){
//        Worker worker1 =  GuardianApi.instance().worker("wave2022");
//        worker1.AESOperator();
        Worker worker1 = new Worker();
        worker1.setApiKey("<Your ApiKey>");
        worker1.setSecretKey("<Your SecretKey>");
        worker1.setPassphrase("<<Your Passphrase>>");
        worker1.setAccount("<自定义名称>");
        apiWorkerWave2022 = TradeApi.getInstance(worker1);
    }

    @Test
    public void test(){
        List<OrderView> list1 = apiWorkerWave2022.swapOrdersPending(null, null);
        System.out.println(list1);
    }

    @Test
    public void cancelOrdersPending(){
        apiWorkerWave2022.cancelOrdersPending(OrderType.POST_ONLY);
    }


}
