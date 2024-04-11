package com.supermancell.trans.common.view.resp;

public class ApiResp<T> {

    private String code;
    private String msg;
    private T data;

    public static ApiResp success(){
        ApiResp apiResp = new ApiResp();
        apiResp.setCode("200");
        apiResp.setMsg("success");
        return apiResp;
    }

    public static ApiResp loginFail(){
        ApiResp apiResp = new ApiResp();
        apiResp.setCode("406");
        apiResp.setMsg("登陆失败，密码或用户名错误！");
        return apiResp;
    }

    public ApiResp success(T data){
        ApiResp apiResp = new ApiResp();
        apiResp.setCode("200");
        apiResp.setMsg("success");
        apiResp.setData(data);
        return apiResp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
