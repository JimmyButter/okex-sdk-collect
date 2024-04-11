package com.supermancell.trans.common.view.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RespBand {

    List<String> instSet;
    BigDecimal median;
}
