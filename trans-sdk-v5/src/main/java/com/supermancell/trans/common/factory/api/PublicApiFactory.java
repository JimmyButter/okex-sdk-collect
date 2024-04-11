package com.supermancell.trans.common.factory.api;

import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.service.marketData.MarketDataAPIService;
import com.okex.open.api.service.marketData.impl.MarketDataAPIServiceImpl;
import com.okex.open.api.service.publicData.PublicDataAPIService;
import com.okex.open.api.service.publicData.impl.PublicDataAPIServiceImpl;
import com.okex.open.api.service.status.StatusDataAPIService;
import com.okex.open.api.service.status.impl.StatusDataAPIServiceImpl;
import com.supermancell.trans.common.constant.OkexConstant;

/**
 * 公共请求，不需要Auth
 */
public class PublicApiFactory {

    /**
     *
     */
    private PublicDataAPIService dataApi;
    private MarketDataAPIService marketApi;
    private volatile static PublicApiFactory singleton = null;
    private StatusDataAPIService statusApi;
    private APIConfiguration apiConfiguration;

    public static PublicApiFactory instance(){
        if(singleton == null) {
            singleton = new PublicApiFactory();
        }

        return singleton;
    }

    private PublicApiFactory(){
        apiConfiguration = new APIConfiguration();
        apiConfiguration.setEndpoint(OkexConstant.ENDPOINT);
        dataApi = new PublicDataAPIServiceImpl(apiConfiguration);
        marketApi = new MarketDataAPIServiceImpl(apiConfiguration);
        statusApi = new StatusDataAPIServiceImpl(apiConfiguration);
    }


    public PublicDataAPIService pubDateApi() {
        return dataApi;
    }

    public MarketDataAPIService marketDataApi() {
        return marketApi;
    }

    public StatusDataAPIService statusApi(){
        return statusApi;
    }

}
