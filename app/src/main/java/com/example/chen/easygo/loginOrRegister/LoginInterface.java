package com.example.chen.easygo.loginOrRegister;

/**
 * Created by Chen on 2018/11/19.
 */

public interface LoginInterface {

    /**
     * 获取司机注册状态
     * @param phoneNum
     */
    void getRegisterState(String phoneNum);

    /**
     * 获取手机验证码
     * @param phoneNum
     */
    void getCode(String phoneNum);

    /**
     * 司机登录
     * @param phoneNum 手机号码
     * @param msgCode 验证码
     */
    void login(String phoneNum,String msgCode);
}
