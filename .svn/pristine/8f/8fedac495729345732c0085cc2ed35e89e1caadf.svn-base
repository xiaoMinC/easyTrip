package com.example.chen.easygo.net.myHttp;

import android.content.Context;

import com.example.chen.easygo.utils.L;
import com.google.gson.GsonBuilder;
import com.tamic.novate.Novate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by win764-1 on 2016/12/12.
 */

public class RetrofitHelper {

    private Context mContext;
    private Novate novate;
    private Map<String, String> headers = new HashMap<>();
    private static final int DEFAULT_TIMEOUT=30;

    OkHttpClient client;
    GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    //懒汉模式
    private static RetrofitHelper instance = null;
    private Retrofit mRetrofit = null;
    public static RetrofitHelper getInstance(Context context){
        if (instance == null){
            instance = new RetrofitHelper(context.getApplicationContext());
        }
        return instance;
    }
    private RetrofitHelper(Context context){
        mContext = context;
        init();
    }

    private void init() {
        resetApp();
    }

    private void resetApp() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                L.i("RxJava"+message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder()
                //log请求参数
                .readTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(HttpUrl.SERVER_URL)
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())// 支持RxJava
                .build();
//        用于文件上传的novate
//        headers.put("Accept", "application/json");
//        novate = new Novate.Builder(mContext)
//                //.addParameters(parameters)
//                .connectTimeout(20)
//                .writeTimeout(15)
//                .baseUrl(HttpUrl.SERVER_URL)
////                .addHeader(headers)
//                .addCache(true)
//                .addLog(true)
//                .build();
    }
    public RetrofitService getServer(){
        return mRetrofit.create(RetrofitService.class);
    }


}
