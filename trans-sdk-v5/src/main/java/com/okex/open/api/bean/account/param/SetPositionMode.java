package com.okex.open.api.bean.account.param;

import lombok.Data;

@Data
public class SetPositionMode {

    @Override
    public String toString() {
        return "SetPositionMode{" +
                "posMode='" + posMode + '\'' +
                '}';
    }

    private String posMode;


}
