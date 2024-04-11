package com.supermancell.trans.common.constant.op;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
public class Op {

    public enum Key {
        instId("instId"),
        ccy("ccy"),
        channel("channel"),
        instType("instType"),;

        private String value;
        Key(String value) {
            this.value = value;
        }
        public String v() {
            return value;
        }
    }

    private String op;
    private String id;
    private List<Map<String, String>> args = new ArrayList<>();

    public Op(String op){
        this.op = op;
    }

    public static Op buildOpSubscribe(){
        return new Op(OpEnum.SUBSCRIBE.value());
    }

    public static Op buildUnSubscribe(){
        return new Op(OpEnum.UNSUBSCRIBE.value());
    }

    public void putOpArg(Map<String, String> opArg) {
        args.add(opArg);
    }

    @Override
    public String toString(){
        String s = JSONObject.toJSONString(this);
        return s.replace(",{\"$ref\":\"$.args[0]\"}", "");
    }

}
