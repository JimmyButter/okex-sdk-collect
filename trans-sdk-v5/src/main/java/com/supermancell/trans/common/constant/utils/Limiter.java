package com.supermancell.trans.common.constant.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 限流器
 *
 */
public class Limiter{

    //记录上一次执行时间，在指定split间隔内不允许执行，旨在控制执行频率
    private static Map<String, Long> limitMap = new HashMap<>();
    //记录下一次可执行时间，类似于冷静期
    private static Map<String, Long> allowMap = new HashMap<>();

    public static boolean disable(String key, long split){
        long ts = System.currentTimeMillis()/1000;

        if(!limitMap.containsKey(key)){
            limitMap.put(key, ts);
            return false;
        }

        if(limitMap.containsKey(key) && ts - limitMap.get(key) < split) {
            return true;
        }else {
            limitMap.put(key, ts);
            return false;
        }


    }

    public static boolean allow(String key) {
        long ts = System.currentTimeMillis()/1000;
        if(allowMap.containsKey(key) && ts < allowMap.get(key)) {
            return false;
        }

        return true;
    }

    public static void allow(String key, long allowTime){
        long ts = System.currentTimeMillis()/1000;
        limitMap.put(key, ts + allowTime);
    }
}
