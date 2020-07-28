package com.vuebackend.vueapi.common;

public class ResponseModel {
    private String msg;
    private Object data;
    private int status;

    public static ResponseModel getSuccessResponse(Object data){
        return new ResponseModel().setStatus(0).setMsg("ok").setData(data);
    }

    public String getMsg() {
        return msg;
    }

    public ResponseModel setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseModel setData(Object data) {
        this.data = data;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ResponseModel setStatus(int status) {
        this.status = status;
        return this;
    }
}
