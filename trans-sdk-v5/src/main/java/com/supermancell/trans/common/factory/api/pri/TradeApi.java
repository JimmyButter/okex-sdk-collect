package com.supermancell.trans.common.factory.api.pri;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.trade.param.CancelOrder;
import com.okex.open.api.bean.trade.param.ClosePositions;
import com.okex.open.api.service.trade.TradeAPIService;
import com.supermancell.trans.common.constant.InstType;
import com.supermancell.trans.common.constant.order.OrderType;
import com.supermancell.trans.common.view.model.Worker;
import com.supermancell.trans.common.view.resp.OkexApiResp;
import com.supermancell.trans.common.view.OrderView;
import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeApi {


    private final static Map<String,TradeApi> singleton = new HashMap<>();
    private TradeAPIService tradeApi;

    public static TradeApi getInstance(Worker worker){
        if(singleton.get(worker.getAccount()) == null) {
            singleton.put(worker.getAccount(), new TradeApi(worker));
        }

        return singleton.get(worker.getAccount());
    }

    public TradeApi(Worker worker){
        tradeApi = PrivateApiFactory.instance(worker).tradeApi();
    }

    //GET /api/v5/trade/orders-pending 限速：60次/2s
    public List<OrderView> swapOrdersPending(String instId, OrderType orderType){
        String instType = null;
        if(orderType != null) {
            instType = orderType.v();
        }
        JSONObject res = tradeApi.getOrderList(InstType.SWAP.v(), null, instId, instType, null, null, null, null);
        OkexApiResp okexApiResp = JSON.parseObject(res.toJSONString(), OkexApiResp.class);
        return okexApiResp.orders();
    }

    /**
     * 批量取消
     * @param orderType
     */
    public void cancelOrdersPending(OrderType orderType) {
        List<OrderView> orders = swapOrdersPending(null, orderType);
        for(OrderView o : orders) {
            CancelOrder cancelOrder = new CancelOrder();
            cancelOrder.setOrdId(o.getOrdId());
            cancelOrder.setInstId(o.getInstId());
            cancelOrder.setOrdId(o.getOrdId());
            tradeApi.cancelOrder(cancelOrder);
        }
    }

    /**
     * 市价仓位全平
     * POST /api/v5/trade/close-position
     */
    public OkexApiResp closePositions(ClosePositions closePositions){
        JSONObject res = tradeApi.closePositions(closePositions);
        OkexApiResp okexApiResp = JSON.parseObject(res.toJSONString(), OkexApiResp.class);
        return okexApiResp;
    }
}
