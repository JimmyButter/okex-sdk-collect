package com.supermancell.trans.common.constant.utils;

/**
 * 阻塞器
 */
public class Blocker {

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
