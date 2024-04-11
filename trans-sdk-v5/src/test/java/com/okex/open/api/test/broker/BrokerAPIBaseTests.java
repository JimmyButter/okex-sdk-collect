package com.okex.open.api.test.broker;

import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.enums.I18nEnum;
import com.okex.open.api.test.BaseTests;

public class BrokerAPIBaseTests extends BaseTests {

    public APIConfiguration config() {
        APIConfiguration config = new APIConfiguration();

        config.setEndpoint("https://www.okx.com/");

        config.setApiKey("");
        config.setSecretKey("");
        config.setPassphrase("");



        config.setPrint(true);
        config.setI18n(I18nEnum.ENGLISH);

        return config;
    }
}
