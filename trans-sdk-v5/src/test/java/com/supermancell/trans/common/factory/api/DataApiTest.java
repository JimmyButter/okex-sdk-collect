package com.supermancell.trans.common.factory.api;

import com.alibaba.fastjson.JSONArray;
import com.supermancell.trans.common.constant.InstType;
import com.supermancell.trans.common.view.InstrumentView;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DataApiTest {

    private DataApi api;

    @Before
    public void init(){
        api = DataApi.instance();
    }

    @Test
    public void test(){
        List<InstrumentView> result = api.instruments(InstType.SWAP.v(), null);
        System.out.println(JSONArray.toJSON(result));
    }


}
