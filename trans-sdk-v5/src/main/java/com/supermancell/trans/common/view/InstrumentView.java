package com.supermancell.trans.common.view;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InstrumentView {
    private String instType;
    private String instId;
    private String uly; //合约标的指数，如 BTC-USD ，仅适用于交割/永续/期权
    private Integer category;//手续费档位，每个交易产品属于哪个档位手续费
    private String baseCcy;//交易货币币种，如 BTC-USDT 中BTC ，仅适用于币币
    private String quoteCcy;//计价货币币种，如 BTC-USDT 中 USDT ，仅适用于币币
    private String settleCcy;//盈亏结算和保证金币种，如 BTC ，仅适用于 交割/永续/期权
    private BigDecimal ctVal;//合约面值
    private String ctMult;//合约乘数
    private String ctValCcy;//合约面值计价币种
    private String optType;//期权类型，C：看涨期权 P：看跌期权 ，仅适用于期权
    private String stk;//行权价格， 仅适用于期权
    private String listTime;//上线日期， 仅适用于 交割/永续/期权
    private String expTime;//交割日期， 仅适用于 交割/期权
    private String lever;//	杠杆倍数， 不适用于币币
    private BigDecimal tickSz;//下单价格精度，如 0.0001
    private String lotSz;//下单数量精度，如 1：BTC-USDT-200925 0.001：BTC-USDT
    private String minSz;//最小下单数量
    private String ctType;//合约类型，linear：正向合约 inverse：反向合约
    private String alias;//合约日期别名 this_week：本周 next_week：次周 quarter：季度 next_quarter：次季度 仅适用于交割
    private String state;//产品状态 live：交易中 suspend：暂停中 expired：已过期 preopen：预上线
}
