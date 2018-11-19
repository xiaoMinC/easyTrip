package com.example.chen.easygo.utils;


import com.example.chen.easygo.net.Bean.LoginBean;
import com.iflytek.cloud.thirdparty.S;

/**
 * 用户管理用户信息数据库
 *
 * @author kinndann
 */
public class UserLoginUtil {

    private static LoginBean userLoginBean;

//    /**
//     * 清空用户信息表
//     * 每次登陆时操作，防止表单获取用户信息时错误
//     */
//    public static void clear() {
//        new Delete().from(User.class).execute();
//        new Delete().from(DepartmentBean.class).execute();
//        new Delete().from(OrganizationBean.class).execute();
//    }

    public UserLoginUtil(LoginBean userLoginBean) {
        this.userLoginBean = userLoginBean;
    }


    /**
     * 获取司机Id
     *
     * @return
     */
    public static int getDriverId() {
        int driverId = userLoginBean.getData().getDriver().getId();
        L.i("当前获取司机Id==" + driverId);
        return driverId;

    }

    /**
     * 获取Token
     *
     * @return
     */
    public static String getToken() {
        String 获取Token = userLoginBean.getData().getToken();
        L.i("当前Token==" + 获取Token);
        return 获取Token;

    }


}
