package com.example.chen.easygo.loginOrRegister;

import android.app.Activity;
import android.content.Context;

import com.example.chen.easygo.MainActivity;
import com.example.chen.easygo.net.Bean.JsonBaseBean;
import com.example.chen.easygo.net.Bean.LoginBean;
import com.example.chen.easygo.net.myHttp.DataManager;
import com.example.chen.easygo.net.myHttp.GETUrl;
import com.example.chen.easygo.net.myHttp.HttpUrl;
import com.example.chen.easygo.net.myHttp.RObserver;
import com.example.chen.easygo.utils.ToActivityUtil;
import com.example.chen.easygo.utils.ToastUtlis;
import com.example.chen.easygo.utils.UserLoginUtil;

import java.util.HashMap;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 登录数据处理层
 * Created by Chen on 2018/11/19.
 */

public class LoginModel implements LoginInterface {

    private Context mContext;
    private DataManager dataManager;
    private CompositeSubscription compositeSubscription;

    public LoginModel(Context context) {
        this.mContext = context;
        compositeSubscription = new CompositeSubscription();
    }


    @Override
    public void getRegisterState(String phoneNum) {
        dataManager = new DataManager(mContext, new HashMap<String, String>());
        String url = GETUrl.driverStep + phoneNum;
        compositeSubscription.add(dataManager.loadRegisterState(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RObserver<JsonBaseBean>(mContext, true) {
                    @Override
                    protected void onSuccess(JsonBaseBean jsonBaseBean) {

                    }

                    @Override
                    protected void onError(String msg) {

                    }
                }));
    }

    @Override
    public void getCode(String phoneNum) {
        dataManager = new DataManager(mContext, new HashMap<String, String>());
        String url = HttpUrl.SERVER_URL + "sms/code/" + phoneNum + "/1";
        compositeSubscription.add(dataManager.getCode(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RObserver<JsonBaseBean>(mContext, true) {
                    @Override
                    protected void onSuccess(JsonBaseBean baseBean) {
                        if (baseBean.getCode() == 0) {

                        }
                    }

                    @Override
                    protected void onError(String msg) {

                    }
                }));
    }

    @Override
    public void login(String phoneNum, String msgCode) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile", phoneNum);
        map.put("smscode", msgCode);
        dataManager = new DataManager(mContext, map);
        compositeSubscription.add(dataManager.login(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RObserver<LoginBean>(mContext, true) {
                    @Override
                    protected void onSuccess(LoginBean loginBean) {
                        if (loginBean.getCode() == 0) {
                            ToActivityUtil.toNextActivity((Activity) mContext, MainActivity.class);
                            new UserLoginUtil(loginBean);
                        } else {
                            ToastUtlis.show(mContext, loginBean.getMessage());
                        }
                    }

                    @Override
                    protected void onError(String msg) {

                    }
                }));
    }

}
