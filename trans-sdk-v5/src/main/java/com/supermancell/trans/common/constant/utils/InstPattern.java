package com.supermancell.trans.common.constant.utils;

public class InstPattern {

    public static final String futurePattern = "^[A-Z]+[\\-USDT\\-]+\\d{6}$";
    public static final String swapPattern = "^[A-Z]+-USDT-SWAP";
    public static final String currencyPattern = "^[A-Z]+-USDT";

    public static boolean futurePattern(String inst){
        return inst.matches(futurePattern);
    }

    public static boolean swapPattern(String inst){
        return inst.matches(swapPattern);
    }

    public static boolean currencyPattern(String inst){
        return inst.matches(currencyPattern);
    }
}
