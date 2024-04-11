package com.supermancell.trans.common.view;

import lombok.Data;

import java.math.BigDecimal;

/**
 * {
 *     "arg": {
 *         "channel": "funding-rate",
 *         "instId": "ETH-USDT-SWAP"
 *     },
 *     "data": [
 *         {
 *             "fundingRate": "0.0004071525576499",
 *             "fundingTime": "1709884800000",
 *             "instId": "ETH-USDT-SWAP",
 *             "instType": "SWAP",
 *             "maxFundingRate": "0.0075",
 *             "method": "current_period",
 *             "minFundingRate": "-0.0075",
 *             "nextFundingRate": "",
 *             "nextFundingTime": "1709913600000",
 *             "premium": "0.0005800284998482",
 *             "settFundingRate": "0.0003823236319043",
 *             "settState": "settled",
 *             "ts": "1709876891611"
 *         }
 *     ]
 * }
 */
@Data
public class FundingRateView {

    private BigDecimal fundingRate;//资金费率,"0.0004071525576499"
    private long fundingTime;//资金费时间,"1709884800000"
    private String instId;//"ETH-USDT-SWAP"
    private String instType;//"SWAP"
    private BigDecimal nextFundingRate;//下一期预测资金费率,""
    private long nextFundingTime;//下一期资金费时间,"1709913600000"
    private BigDecimal maxFundingRate;//下一期的预测资金费率上限 "0.0075"
    private BigDecimal minFundingRate;//下一期的预测资金费率下限 "-0.0075"
    /**
     * 若 settState = processing，该字段代表用于本轮结算的资金费率；
     * 若 settState = settled，该字段代表用于上轮结算的资金费率
     */
    private BigDecimal settFundingRate;
    /**
     * 资金费率结算状态
     * processing：结算中
     * settled：已结算
     */
    private String settState;//资金费率结算状态 processing：结算中 settled：已结算
    private BigDecimal premium;//溢价，为合约的中间价和指数价格的差异
    /**
     * 资金费收取逻辑
     * current_period：当期收
     * next_period：跨期收
     */
    private String method;
}
