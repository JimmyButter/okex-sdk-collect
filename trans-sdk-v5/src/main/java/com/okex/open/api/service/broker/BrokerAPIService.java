package com.okex.open.api.service.broker;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.broker.param.*;
import retrofit2.http.Query;

public interface BrokerAPIService {

    //Broker账户信息  Get broker account information
    JSONObject getInfo();

    //创建子账户  Create sub-account
    JSONObject createSubAccount(CreateSubAccount createSubAccount);

    //删除子账户   Delete sub-account
    JSONObject deleteSubAccount(DeleteSubAccount deleteSubAccount);

    //查询子账户列表  Get sub-account list
    JSONObject getSubAccountInfo(String subAcct, String page, String limit);

    //创建子账户的APIKey Create an APIKey for a sub-account
    JSONObject createSubAccountApikey(CreateSubAccountApikey createSubAccountApikey);

    //查询子账户的APIKey Query the APIKey of a sub-account
    JSONObject getApikeyInfo(String subAcct,String apiKey);

    //重置子账户的APIKey Reset the APIKey of a sub-account
    JSONObject modifySubAccountApikey(ModifySubAccountApikey modifySubAccountApikey);

    //删除子账户的APIKey Delete the APIKey of sub-accounts
    JSONObject deleteSubAccountApikey(DeleteSubAccountApikey deleteSubAccountApikey);

    //设置子账户的账户等级  Set the account level of the sub-account
    JSONObject setSubAccountLevel(SetSubAccountLevel setSubAccountLevel);

    //设置子账户的交易手续费费率  Set trading fee rate for sub-account
    JSONObject setSubAccountFeeRate(SetSubAccountFeeRate setSubAccountFeeRate);

    //创建子账户充值地址  Create deposit address for sub-account
    JSONObject subAccountDepositAddress(SubAccountDepositAddress subAccountDepositAddress);

    //查看充值地址  Get sub-account deposit address
    JSONObject getSubAccountDepositAddress(String subAcct, String ccy);

    //查询子账户获取充值记录  Get sub-account deposit history
    JSONObject getSubAccountDepositHistory(String subAcct, String ccy, String txId, String state, String after, String before, String limit);

    //子账户返佣记录  Query daily rebate records
    JSONObject getRebateDaily(String subAcct, String begin, String end, String page, String limit);

    //获取返佣明细下载链接 Get download link
    JSONObject rebatePerOrders(String type,String begin,String end);

    //生成返佣明细下载链接 Create rebate details download link
    JSONObject setRebatePerOrders(SetRebatePerOrders setRebatePerOrders);

    //获取返佣明细下载链接 Get download link
    JSONObject rebatePerOrdersfd(String type,String begin,String end);

    //生成返佣明细下载链接 Create rebate details download link
    JSONObject setRebatePerOrdersfd(SetRebatePerOrders setRebatePerOrders);

    //重置子账户充值地址    modify-subaccount-deposit-address
    JSONObject modifySubaccountDepositAddress(SubAccountDepositAddress subAccountDepositAddress);

}
