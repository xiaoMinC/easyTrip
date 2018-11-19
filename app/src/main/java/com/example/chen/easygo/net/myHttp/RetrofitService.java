package com.example.chen.easygo.net.myHttp;


import com.example.chen.easygo.net.Bean.JsonBaseBean;
import com.example.chen.easygo.net.Bean.LoginBean;
import com.example.chen.easygo.net.Bean.RegisterProblemBean;
import com.example.chen.easygo.net.Bean.UserBaseInfoBean;
import com.example.chen.easygo.net.Bean.UserInfoBean;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 设置请求地址及请求方式
 * Created by win764-1 on 2016/12/12.
 */

public interface RetrofitService {

    //司机登录
    @POST("driver/sms/login")
    Observable<LoginBean> login(@QueryMap Map<String, String> options);

    //获取验证码
    @GET
    Observable<JsonBaseBean> getCode(@Url String url);

    //注册上传图片
    @Multipart
    @POST("driver/register/")
    Observable<JsonBaseBean> uploadFile1(@QueryMap Map<String, String> options, @Part("description") RequestBody description,
                                        @Part MultipartBody.Part file);

    //注册多张图片
    @Multipart
    @POST("driver/register/")
    Observable<JsonBaseBean> uploadFile(@QueryMap Map<String, String> options,
                                        @Part("description") RequestBody description,
                                        @PartMap() Map<String, RequestBody> bodys);


    //个人中心
    @GET
    Observable<UserInfoBean> personCenter(@Url String url);


    //司机头像上传
    @Multipart
    @POST("driver/headicon/")
    Observable<JsonBaseBean> driverIcon(@QueryMap Map<String, String> options, @Part("description") RequestBody description,
                                        @Part MultipartBody.Part file);

    //司机个人资料
    @GET
    Observable<UserBaseInfoBean> driverInfo(@Url String url);

    //司机查看行程记录
    @GET
    Observable<JsonBaseBean> driverRecord(@Url String url);

    //司机申诉服务
    @GET
    Observable<JsonBaseBean> driverAppeal(@Url String url);

    //司机月度总结
    @GET
    Observable<JsonBaseBean> driverMonth(@Url String url);

    // 周边搜索
    @GET
    Observable<JsonBaseBean> search(@Url String url);

    // 司机接单
    @GET
    Observable<JsonBaseBean> driverReceive(@Url String url);

    // 最后位置上传
    @GET
    Observable<JsonBaseBean> loadPosition(@Url String url);

    // 司机查看顺路行程
    @GET
    Observable<JsonBaseBean> directRoute(@Url String url);

    // 司机查看本次顺路行程已接乘客
    @GET
    Observable<JsonBaseBean> alreadyReceive(@Url String url);

    // 司机发布行程
    @POST("driver/travel/publish")
    Observable<JsonBaseBean> publishTravel(@QueryMap Map<String, String> options);

    // 司机呼叫安全模式
    @GET
    Observable<JsonBaseBean> safeMode(@Url String url);

    // 司机前往乘客地点接乘
    @GET
    Observable<JsonBaseBean> travelRelay(@Url String url);

    // 取消乘客行程
    @GET
    Observable<JsonBaseBean> travelCancel(@Url String url);

    // 确认提醒乘客已上车
    @GET
    Observable<JsonBaseBean> travelRemind(@Url String url);

    // 确认抵达目的地
    @GET
    Observable<JsonBaseBean> travelArrival(@Url String url);

    // 司机提交行程问题
    @GET
    Observable<JsonBaseBean> travelProblem(@Url String url);

    // 获取宣传图片
    @GET
    Observable<JsonBaseBean> publicity(@Url String url);

    // 司机注册状态接口
    @GET
    Observable<JsonBaseBean> loadRegisterState(@Url String url);

    // 获取常见问题
    @GET
    Observable<RegisterProblemBean> loadProblem(@Url String url);

}


