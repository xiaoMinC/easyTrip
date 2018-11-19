package com.example.chen.easygo.map.localtion;

import android.content.Context;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.model.LatLng;
import com.example.chen.easygo.utils.L;

public class Location implements ILocal {

    private Context context ;
    private AMapLocation mAMapLocation;

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;

    public AMapLocationListener mLocationListener;

//    //声明定位回调监听器
//    public AMapLocationListener mLocationListener = new AMapLocationListener() {
//        @Override
//        public void onLocationChanged(AMapLocation aMapLocation) {
//            L.i("Amap",(aMapLocation == null)+"");
//            if (aMapLocation != null){
//                mAMapLocation = aMapLocation;
//
////                adrr = aMapLocation.getAddress();
////                textView.setText("获取纬度:"+aMapLocation.getLatitude()
////                        +"\n获取经度:"+aMapLocation.getLongitude()
////                        +"\n城市编码:"+aMapLocation.getCityCode()
////                        +"\n地址:"+aMapLocation.getAddress()
////                        +"\n国家信息:"+aMapLocation.getCountry()
////                        +"\n省信息:"+aMapLocation.getProvince()
////                        +"\n城市信息:"+aMapLocation.getCity()
////                        +"\n城区信息:"+aMapLocation.getDistrict()
////                        +"\n街道信息:"+aMapLocation.getStreet());
//
//            }else {
//                //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
//                Log.e("AmapError","location Error, ErrCode:"
//                        + aMapLocation.getErrorCode() + ", errInfo:"
//                        + aMapLocation.getErrorInfo());
//            }
//        }
//    };

    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;

    public Location(Context context, AMapLocationListener aMapLocationListener) {
        this.context = context;
        this.mLocationListener = aMapLocationListener;
        initLocal();
    }

    private void initLocal() {
        //初始化定位
        mLocationClient = new AMapLocationClient(context.getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);

        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();

        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        //设置定位模式为AMapLocationMode.Battery_Saving，低功耗模式。
        //设置定位模式为AMapLocationMode.Device_Sensors，仅设备模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);

        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否允许模拟位置,默认为true，允许模拟位置
        mLocationOption.setMockEnable(true);

        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);


        //获取一次定位结果：
        //该方法默认为false。
//        mLocationOption.setOnceLocation(true);
        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
//        mLocationOption.setOnceLocationLatest(true);
    }

    @Override
    public void startLocation() {
        //启动定位
        mLocationClient.startLocation();
    }

    @Override
    public void stopLocation() {
        //停止定位后，本地定位服务并不会被销毁
        mLocationClient.stopLocation();
    }

    @Override
    public AMapLocation getLocalInfo() {
        if (mAMapLocation != null){
            L.i("Amap",mAMapLocation.getAddress());
           return mAMapLocation;
        }
        return null;
    }

}
