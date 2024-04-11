package com.supermancell.trans.common.view.model;

import com.supermancell.trans.common.constant.utils.AESOperator;
import lombok.Data;

import java.math.BigDecimal;

import static com.supermancell.trans.common.constant.utils.AESOperator.skey;

@Data
public class Worker implements java.io.Serializable{

    private String account;
    /**
     *
     */
    private BigDecimal openScale;
    /**
     * 最重要的配置
     * Comm.ORDER_RISK_MULT 风险线
     * Comm.ORDER_DEAD_MULT 平仓线
     *
     * 由于Comm这两个配置是常量所以closeScale决定了抗风险的力度
     * ORDER_DEAD_MULT是closeScale的4倍,
     * 也就是closeScale越大抗风险越大，一但失败损失也越多
     */
    private BigDecimal closeScale;
    private Integer delay;
    private String apiKey;
    private String secretKey;
    private String passphrase;
    private String mail;
    private Boolean enable;
    /**
     * openScale = 0.02, size = 8 时
     * usdUseScale <= 1
     */
    private BigDecimal usdUseScale;
    /**
     * 最大16个，再大没有了
     */
    private int size;
    private String strategy;
    /**
     * 方向 long/short
     * 如果是定向策略的话
     */
    private String direction;

    private BigDecimal slippage; //滑点
    private int quitScale; //退出倍数
    private int quitTime; //退出时间
    private int lever; //账户使用的标杆数

    public void AESOperator() {
         this.passphrase = AESOperator.getInstance().decrypt(passphrase, skey);
    }

}
