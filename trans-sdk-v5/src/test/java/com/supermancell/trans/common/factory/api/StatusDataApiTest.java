package com.supermancell.trans.common.factory.api;

import com.alibaba.fastjson.JSONObject;
import com.supermancell.trans.common.view.model.SystemStatus;
import org.junit.Test;

public class StatusDataApiTest {

    private DataStatusApi api = DataStatusApi.instance();

    @Test
    public void test() {
        SystemStatus systemStatus = api.getStatus();
        System.out.println(JSONObject.toJSONString(systemStatus));
    }


}
