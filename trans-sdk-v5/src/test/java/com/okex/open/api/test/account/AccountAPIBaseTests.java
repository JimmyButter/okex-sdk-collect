package com.okex.open.api.test.account;

import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.enums.I18nEnum;
import com.okex.open.api.test.BaseTests;

/**
 * Account api basetests
 *
 * @author hucj
 * @version 1.0.0
 * @date 2018/7/04 18:23
 */
public class AccountAPIBaseTests extends BaseTests {

    public APIConfiguration config() {
        APIConfiguration config = new APIConfiguration();

        config.setEndpoint("https://www.okx.com/");


        /**
         * apikey = "f2c6d773-7f8e-4522-823b-692bdfd63daf"
         * secretkey = "33EC2A6A9118D494345C015E3AC89694"
         * IP = ""
         * 备注名 = "bideNew"
         * 权限 = "读取"
         */
        // apiKey，api注册成功后页面上有
        config.setApiKey("f2c6d773-7f8e-4522-823b-692bdfd63daf");
        config.setSecretKey("33EC2A6A9118D494345C015E3AC89694");
        config.setPassphrase("Dreaming7788!");


        config.setPrint(true);
        config.setI18n(I18nEnum.ENGLISH);

        return config;
    }


}
