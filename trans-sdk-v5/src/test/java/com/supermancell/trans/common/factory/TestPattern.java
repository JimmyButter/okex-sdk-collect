package com.supermancell.trans.common.factory;

import org.junit.Test;


public class TestPattern {

    @Test
    public void test(){

        String pattern = "^[A-Z]+[\\-USDT\\-]+\\d{6}$";
        String test = "ETH-USDT-230707";
        System.out.println(test.matches(pattern));

        pattern = "^[A-Z]+-USDT-SWAP";
        test = "ETH-USDT-SWAP";
        System.out.println(test.matches(pattern));

        pattern = "^[A-Z]+-USDT";
        test = "ETH-USDT";
        System.out.println(test.matches(pattern));

        pattern = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        test = "abc@163.com";
        System.out.println(test.matches(pattern));

        pattern = "^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
        test = "http://www.baidu.com";
        System.out.println(test.matches(pattern));

        pattern = "\\d{3}-\\d{8}|\\d{4}-\\d{7}";
        test = "0511-4405222";
        System.out.println(test.matches(pattern));

    }
}
