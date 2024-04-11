package com.supermancell.trans.common.view.resp;

import lombok.Data;

@Data
public class OrderFail {

    private String tag;
    private String ordId;
    private String clOrdId;
    private String sCode;
    private String sMsg;

}
