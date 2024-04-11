package com.supermancell.trans.common.view.order;

import com.supermancell.trans.common.constant.order.SideType;
import lombok.Data;

@Data
public class OrderPostView {

    private String instId;
    private String px;
    private String sz;
    private SideType side;
}
