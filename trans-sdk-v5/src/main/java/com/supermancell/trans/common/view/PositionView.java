package com.supermancell.trans.common.view;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PositionView {

    private String instType;//产品类型
    private String mgnMode;//保证金模式， cross：全仓 isolated：逐仓
    private String posId;//持仓ID
    private String posSide;//持仓方向 long：双向持仓多头 short：双向持仓空头 net：单向持仓（交割/永续/期权：pos为正代表多头，pos为负代表空头。币币杠杆：posCcy为交易货币时，代表多头；posCcy为计价货币时，代表空头。）
    private Integer pos;//持仓数量
    private String posCcy;//持仓数量币种，仅适用于币币杠杆
    private Integer availPos;//可平仓数量 适用于 币币杠杆,交割/永续（开平仓模式），期权（交易账户及保证金账户逐仓）
    private BigDecimal avgPx;//开仓平均价
    private BigDecimal upl;//未实现收益
    private BigDecimal uplRatio;//未实现收益率
    private String instId;//产品ID，如 BTC-USD-180216
    private Integer lever;//杠杆倍数，不适用于期权卖方
    private String liqPx;//预估强平价 不适用于期权
    private BigDecimal markPx;//标记价格
    private BigDecimal imr;//初始保证金，仅适用于全仓
    private String margin;//保证金余额，仅适用于逐仓，可增减
    private String mgnRatio;//保证金率
    private String mmr;//维持保证金
    private String liab;//负债额，仅适用于币币杠杆
    private String liabCcy;//负债币种，仅适用于币币杠杆
    private String interest;//利息，已经生成未扣利息
    private String tradeId;//最新成交ID
    private String notionalUsd;//以美金价值为单位的持仓数量
    private String optVal;//期权价值，仅适用于期权
    private Integer adl;//信号区，分为5档，从1到5，数字越小代表adl强度越弱
    private String ccy;//占用保证金的币种
    private String last;//最新成交价
    private String deltaBS;//美金本位持仓仓位delta，仅适用于期权
    private String deltaPA;//币本位持仓仓位delta，仅适用于期权
    private String gammaBS;//美金本位持仓仓位gamma，仅适用于期权
    private String gammaPA;//币本位持仓仓位gamma，仅适用于期权
    private String thetaBS;//美金本位持仓仓位theta，仅适用于期权
    private String thetaPA;//币本位持仓仓位theta，仅适用于
    private String vegaBS;//美金本位持仓仓位vega，仅适用于期权
    private String vegaPA;//币本位持仓仓位vega，仅适用于期权
    private Long cTime;//持仓创建时间，Unix时间戳的毫秒数格式，如 1597026383085
    private Long uTime;//最近一次持仓更新时间，Unix时间戳的毫秒数格式，如 1597026383085
    private String pTime;//持仓信息的推送时间，Unix时间戳的毫秒数格式，如 1597026383085
}
