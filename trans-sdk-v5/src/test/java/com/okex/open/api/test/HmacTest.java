package com.okex.open.api.test;

import com.okex.open.api.utils.HmacSHA256Base64Utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

public class HmacTest {

    public static void main(String[] args) throws UnsupportedEncodingException, InvalidKeyException, CloneNotSupportedException {
        String sign = HmacSHA256Base64Utils.sign(
                "2022-10-31T14:50:46Z",
                "GET",
                "/api/v5/account/balance",
                "ccy=USDT",
                "",
                "57D6CBD4004AB535716C414823A4FCC2");
        System.out.println(sign);
    }
}
