package com.supermancell.trans.common.factory.api;

import com.supermancell.trans.common.factory.api.pri.AccountApi;
import com.supermancell.trans.common.view.model.Worker;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class AccountApiTest {

    private AccountApi api;

    @Before
    public void init(){
        Worker worker = new Worker();
        
        worker.setApiKey("<Your ApiKey>");
        worker.setSecretKey("<Your SecretKey>");
        worker.setPassphrase("<<Your Passphrase>>");
        worker.setAccount("<自定义名称>");
        api = AccountApi.getInstance(worker);
    }

    @Test
    public void test(){
        BigDecimal usdt = api.usdt();
        System.out.println(usdt);
    }


}
