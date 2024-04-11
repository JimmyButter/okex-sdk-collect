package com.supermancell.trans.common.factory.ws.health;

import lombok.Data;

@Data
public class WsHealth {

    private Long beatPassTime = 0l;
    private Long connectionTimes = 0l;
    private Long connectionTime = 0l;
    private Long beatTimes = 0l;
    private Long lastBeatTime = 0l;

    public void setLastBeatTime(Long lastBeatTime) {
        this.lastBeatTime = lastBeatTime;
    }

    public Long getBeatPassTime() {
        return System.currentTimeMillis() - lastBeatTime;
    }
}
