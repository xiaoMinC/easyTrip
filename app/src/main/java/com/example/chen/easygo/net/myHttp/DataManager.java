package com.example.chen.easygo.net.myHttp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;


import com.example.chen.easygo.net.Bean.JsonBaseBean;
import com.example.chen.easygo.net.Bean.LoginBean;
import com.example.chen.easygo.net.Bean.RegisterProblemBean;
import com.example.chen.easygo.net.Bean.UserBaseInfoBean;
import com.example.chen.easygo.net.Bean.UserInfoBean;
import com.example.chen.easygo.utils.L;
import com.iflytek.cloud.thirdparty.S;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by win764-1 on 2016/12/12.
 */

public class DataManager {
    private RetrofitService mRetrofitService;
    private HashMap<String, String> mMap = new HashMap<>();

    public DataManager(Context context, HashMap<String, String> map) {
//        if (UserLoginUtil.getUUID() != null) {
//            mMap.put("uuid", UserLoginUtil.getUUID());
//
//        } else if (UserLoginUtil.getUUID().equals("")) {
//            T.showLong(context, "系统参数被清空，请重新登录！");
//            Intent intent = new Intent(context.getApplicationContext(), LoginActivity.class);
//            context.startActivity(intent);
//            ((Activity) context).finish();
//        }
//        mMap.putAll(map);
        L.i("参数:" + mMap.toString());
        for (String key : map.keySet()) {
            if (map.get(key) == null)
                L.i("字段属性名："+key + "字段值" + map.get(key));
        }
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }


    public Observable<JsonBaseBean> getCode(String url) {
        return mRetrofitService.getCode(url);
    }

    public Observable<JsonBaseBean> uploadFile(HashMap<String, String> map, RequestBody description, Map<String, RequestBody> bodys) {
        return mRetrofitService.uploadFile(map, description, bodys);
    }

    public Observable<LoginBean> login(HashMap<String, String> map) {
        return mRetrofitService.login(map);
    }

    public Observable<UserInfoBean> personCenter(String url) {
        return mRetrofitService.personCenter(url);
    }

    public Observable<JsonBaseBean> driverIcon(Map<String, String> map, RequestBody description, MultipartBody.Part file) {
        return mRetrofitService.driverIcon(map, description, file);
    }

    public Observable<UserBaseInfoBean> driverInfo(String url) {
        return mRetrofitService.driverInfo(url);
    }

    public Observable<JsonBaseBean> driverRecord(String url) {
        return mRetrofitService.driverRecord(url);
    }

    public Observable<JsonBaseBean> driverAppeal(String url) {
        return mRetrofitService.driverAppeal(url);
    }

    public Observable<JsonBaseBean> driverMonth(String url) {
        return mRetrofitService.driverMonth(url);
    }

    public Observable<JsonBaseBean> search(String url) {
        return mRetrofitService.search(url);
    }

    public Observable<JsonBaseBean> driverReceive(String url) {
        return mRetrofitService.driverReceive(url);
    }

    public Observable<JsonBaseBean> loadPosition(String url) {
        return mRetrofitService.loadPosition(url);
    }

    public Observable<JsonBaseBean> directRoute(String url) {
        return mRetrofitService.directRoute(url);
    }

    public Observable<JsonBaseBean> alreadyReceive(String url) {
        return mRetrofitService.alreadyReceive(url);
    }

    public Observable<JsonBaseBean> publishTravel(Map<String, String> options) {
        return mRetrofitService.publishTravel(options);
    }

    public Observable<JsonBaseBean> safeMode(String url) {
        return mRetrofitService.safeMode(url);
    }

    public Observable<JsonBaseBean> travelRelay(String url) {
        return mRetrofitService.travelRelay(url);
    }

    public Observable<JsonBaseBean> travelCancel(String url) {
        return mRetrofitService.travelCancel(url);
    }

    public Observable<JsonBaseBean> travelRemind(String url) {
        return mRetrofitService.travelRemind(url);
    }

    public Observable<JsonBaseBean> travelArrival(String url) {
        return mRetrofitService.travelArrival(url);
    }

    public Observable<JsonBaseBean> travelProblem(String url) {
        return mRetrofitService.travelProblem(url);
    }

    public Observable<JsonBaseBean> publicity(String url) {
        return mRetrofitService.publicity(url);
    }

    public Observable<JsonBaseBean> loadRegisterState(String url) {
        return mRetrofitService.loadRegisterState(url);
    }

    public Observable<RegisterProblemBean> loadProblem(String url) {
        return mRetrofitService.loadProblem(url);
    }

}
