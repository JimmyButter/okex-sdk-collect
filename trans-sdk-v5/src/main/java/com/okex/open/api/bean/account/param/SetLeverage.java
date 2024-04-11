package com.okex.open.api.bean.account.param;

import lombok.Data;

@Data
public class SetLeverage {
    private String instId;
    private String ccy;
    private String lever;
    private String mgnMode;
    private String posSide;

    @Override
    public String toString() {
        return "SetLeverage{" +
                "instId='" + instId + '\'' +
                ", ccy='" + ccy + '\'' +
                ", lever='" + lever + '\'' +
                ", mgnMode='" + mgnMode + '\'' +
                ", posSide='" + posSide + '\'' +
                '}';
    }
}
