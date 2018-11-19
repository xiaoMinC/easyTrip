package com.example.chen.easygo.net.myHttp;

/**
 * Created by Administrator on 2018/2/27 0027.
 */

public class BaseResponse {
    private int code;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
