package com.supermancell.trans.common.factory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestLogLevel {

    @Test
    public void test(){
        log.debug("hello debug");
        log.info("hello info");
        log.warn("hello warn");
        log.error("hello error");
    }
}
