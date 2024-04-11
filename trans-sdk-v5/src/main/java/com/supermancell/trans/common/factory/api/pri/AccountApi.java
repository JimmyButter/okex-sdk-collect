package com.supermancell.trans.common.factory.api.pri;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.account.param.SetLeverage;
import com.okex.open.api.bean.account.param.SetPositionMode;
import com.okex.open.api.exception.APIException;
import com.okex.open.api.service.account.AccountAPIService;
import com.okex.open.api.service.funding.FundingAPIService;
import com.supermancell.trans.common.constant.LeverEnum;
import com.supermancell.trans.common.constant.MgnModeEnum;
import com.supermancell.trans.common.constant.OkexConstant;
import com.supermancell.trans.common.view.AccountConfigView;
import com.supermancell.trans.common.view.PositionView;
import com.supermancell.trans.common.view.model.Worker;
import com.supermancell.trans.common.view.resp.OkexApiResp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 账户
 */
public class AccountApi {

    private volatile static Map<String, AccountApi> singleton = new HashMap<>();
    private AccountAPIService accountApi;
    private FundingAPIService fundingApi;

    public static AccountApi getInstance(Worker worker){
        synchronized (AccountApi.class) {
            if (singleton.get(worker.getAccount()) == null) {
                singleton.put(worker.getAccount(), new AccountApi(worker));
            }
        }

        return singleton.get(worker.getAccount());
    }

    public AccountApi(Worker worker){

        accountApi = PrivateApiFactory.instance(worker).accountApi();
        fundingApi = PrivateApiFactory.instance(worker).fundingApi();
    }

    /**
     * 查看账户余额
     * GET /api/v5/account/balance
     * 限速：10次/2s 限速规则：UserID
     * @return
     */
    public BigDecimal usdt(){
        JSONObject joBalance = accountApi.getBalance("USDT").getJSONArray("data").getJSONObject(0);
        return joBalance.getJSONArray("details").getJSONObject(0).getBigDecimal("cashBal").setScale(3, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 设置持仓模式
     * POST /api/v5/account/set-position-mode
     * @param posMode
     */
    public boolean setPosMode(String posMode){
        SetPositionMode positionMode = new SetPositionMode();
        positionMode.setPosMode(posMode);
        JSONObject res = accountApi.setPositionMode(positionMode);
        OkexApiResp okexApiResp = JSONObject.parseObject(res.toJSONString(), OkexApiResp.class);
        return OkexConstant.CODE_SUCCESS.equals(okexApiResp.getCode());
    }

    /**
     *
     * 查看账户配置
     * 限速：5次/2s 限速规则：UserID
     * GET /api/v5/account/config
     * @return
     */
    public AccountConfigView getPosMode(){
        JSONObject resp = accountApi.getAccountConfiguration();
        OkexApiResp okexApiResp = JSONObject.parseObject(resp.toJSONString(), OkexApiResp.class);
        return okexApiResp.accountConfig();
    }

    /**
     * 设置杠杆倍数
     * @param instId
     * POST /api/v5/account/set-leverage
     */
    public boolean setLeverage(String instId, int lever){
        SetLeverage setLeverage = new SetLeverage();
        setLeverage.setInstId(instId);
        setLeverage.setMgnMode(MgnModeEnum.cross.v());
        setLeverage.setLever(lever + "");
        try {
            JSONObject res = accountApi.setLeverage(setLeverage);
            OkexApiResp okexApiResp = JSONObject.parseObject(res.toJSONString(), OkexApiResp.class);
            return OkexConstant.CODE_SUCCESS.equals(okexApiResp.getCode());
        }catch (APIException ex){
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 获取仓位信息
     * @return
     */
    public List<PositionView> getPositions(){
        JSONObject res = accountApi.getPositions(null, null, null);
        System.out.println(JSONObject.toJSONString(res));
        OkexApiResp okexApiResp = JSONObject.parseObject(res.toJSONString(), OkexApiResp.class);
        return okexApiResp.positions();
    }
}
