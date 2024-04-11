package com.supermancell.trans.common.constant.order;

public enum OrderTag {
    //用于标志区分 robot单的类型和手工单
    ambuscade("ambuscade"),//埋伏订单
    shipment("shipment"),//出货订单
    tou_tie("toutie"),//头铁
    ;

    private String v;

    OrderTag(String v) {
        this.v = v;
    }

    public String v() {
        return v;
    }
}
