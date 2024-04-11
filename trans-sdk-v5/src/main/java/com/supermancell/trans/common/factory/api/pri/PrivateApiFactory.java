package com.supermancell.trans.common.factory.api.pri;

import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.account.AccountAPIService;
import com.okex.open.api.service.account.impl.AccountAPIServiceImpl;
import com.okex.open.api.service.funding.FundingAPIService;
import com.okex.open.api.service.funding.impl.FundingAPIServiceImpl;
import com.okex.open.api.service.trade.TradeAPIService;
import com.okex.open.api.service.trade.impl.TradeAPIServiceImpl;
import com.supermancell.trans.common.constant.OkexConstant;
import com.supermancell.trans.common.constant.PosModeEnum;
import com.supermancell.trans.common.view.AccountConfigView;
import com.supermancell.trans.common.view.model.Worker;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 需要Auth
 */
@Slf4j
public class PrivateApiFactory {

    /**
     *
     */
    public static AccountAPIService accountApi;
    public static TradeAPIService tradeApi;
    public static FundingAPIService fundingApi;
    private final static Map<String,PrivateApiFactory> singleton = new HashMap<>();
    private APIConfiguration apiConfiguration;

    /**
     * 支持多实例，一个worker只产生一个实例
     * @param worker
     * @return
     */
    public static PrivateApiFactory instance(Worker worker){
        assert worker!=null;
        assert StringUtils.isNotEmpty(worker.getApiKey());
        assert StringUtils.isNotEmpty(worker.getSecretKey());
        assert StringUtils.isNotEmpty(worker.getPassphrase());

        synchronized (PrivateApiFactory.class) {
            if (singleton.get(worker.getAccount()) == null) {
                singleton.put(worker.getAccount(), new PrivateApiFactory(worker));
            }
        }

        return singleton.get(worker.getAccount());
    }

    private PrivateApiFactory(Worker worker){

        apiConfiguration = new APIConfiguration();
        apiConfiguration.setEndpoint(OkexConstant.ENDPOINT);
        apiConfiguration.setApiKey(worker.getApiKey());
        apiConfiguration.setSecretKey(worker.getSecretKey());
        apiConfiguration.setPassphrase(worker.getPassphrase());
        log.info("Working by >{}<", worker.getAccount());
        accountApi = new AccountAPIServiceImpl(apiConfiguration);
        tradeApi = new TradeAPIServiceImpl(apiConfiguration);
        fundingApi = new FundingAPIServiceImpl(apiConfiguration);
    }


    public AccountAPIService accountApi() {
        return accountApi;
    }

    public TradeAPIService tradeApi() {
        return tradeApi;
    }

    public FundingAPIService fundingApi() {return fundingApi;}

}
