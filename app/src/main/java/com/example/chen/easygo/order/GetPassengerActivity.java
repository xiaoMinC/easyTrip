package com.example.chen.easygo.order;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.navi.model.NaviLatLng;
import com.example.chen.easygo.BaseActivity;
import com.example.chen.easygo.R;
import com.example.chen.easygo.common.swipebtn.OnStateChangeListener;
import com.example.chen.easygo.common.swipebtn.SwipeButton;
import com.example.chen.easygo.map.GPSNaviActivity;
import com.example.chen.easygo.map.myCustom.AllCustomNaviActivity;
import com.example.chen.easygo.utils.L;
import com.example.chen.easygo.utils.ToActivityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GetPassengerActivity extends BaseActivity implements LocationSource, AMapLocationListener {

    @BindView(R.id.swipeNoState)
    SwipeButton swipeNoState;
    @BindView(R.id.passenger_map)
    MapView passengerMap;
    @BindView(R.id.tv_start_addr)
    TextView tvStartAddr;
    @BindView(R.id.tv_start_distance)
    TextView tvStartDistance;
    @BindView(R.id.tv_end_addr)
    TextView tvEndAddr;
    @BindView(R.id.tv_end_distance)
    TextView tvEndDistance;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.ll_item)
    LinearLayout llItem;

    private AMap aMap;
    OnLocationChangedListener mListener;
    AMapLocationClient mlocationClient;
    AMapLocationClientOption mLocationOption;

    NaviLatLng mStartLatlng;
    NaviLatLng mEndLatlng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_passenger);
        ButterKnife.bind(this);

        initView();

        initMap(savedInstanceState);

        //112.874367,28.207579
        setMaker(28.207579, 112.874367, true);
        mEndLatlng = new NaviLatLng(28.207579, 112.874367);

        initMyLocation();


    }

    private void initMyLocation() {

        // 设置定位监听
        aMap.setLocationSource(this);
        // 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.setMyLocationEnabled(true);
        // 设置定位的类型为定位模式，有定位、跟随或地图根据面向方向旋转几种
        aMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);
    }


    /**
     * 标注乘客的位置
     *
     * @param v
     * @param v1
     */
    private void setMaker(double v, double v1, boolean isMove) {
        MarkerOptions markerOption = new MarkerOptions();
        LatLng latLng = new LatLng(v, v1);
        markerOption.position(latLng);
        markerOption.title("五一广场").snippet("五一广场：28.195317, 112.976433");

        markerOption.draggable(true);//设置Marker可拖动
        markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                .decodeResource(getResources(), R.drawable.start)));
        // 将Marker设置为贴地显示，可以双指下拉地图查看效果
        markerOption.setFlat(true);//设置marker平贴地图效果

        final Marker marker = aMap.addMarker(markerOption);

        if (isMove) {
            aMap.moveCamera(CameraUpdateFactory.changeLatLng(latLng));
        }
        aMap.moveCamera(CameraUpdateFactory.zoomTo(15));
        aMap.setTrafficEnabled(true);// 显示实时交通状况

    }

    private void initMap(Bundle savedInstanceState) {
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        passengerMap.onCreate(savedInstanceState);

        if (aMap == null) {
            aMap = passengerMap.getMap();
        }
    }

    private void initView() {
        setTitleBar("乘客行程");
        initBackView();

        swipeNoState.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                if (active) {
                    swipeNoState.setText("");
                    ToActivityUtil.toNextActivityObject(GetPassengerActivity.this, TripActivity.class,
                            mStartLatlng,
                            mEndLatlng
                    );
                } else {
                    swipeNoState.setText("右滑接该乘客");
                }
            }
        });

    }


    public void jump(View view) {
        ToActivityUtil.toNextActivity(GetPassengerActivity.this, AllCustomNaviActivity.class);
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        if (mlocationClient == null) {
            //初始化定位
            mlocationClient = new AMapLocationClient(this);
            //初始化定位参数
            mLocationOption = new AMapLocationClientOption();
            //设置定位回调监听
            mlocationClient.setLocationListener(this);
            //设置为高精度定位模式
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //设置定位参数
            mlocationClient.setLocationOption(mLocationOption);
            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
            // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
            // 在定位结束后，在合适的生命周期调用onDestroy()方法
            // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
            mlocationClient.startLocation();//启动定位
        }
    }

    @Override
    public void deactivate() {
        mListener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (mListener != null && aMapLocation != null) {
            if (aMapLocation != null
                    && aMapLocation.getErrorCode() == 0) {
                mlocationClient.stopLocation();//停止定位
                L.i("aMapLocation:" + aMapLocation.getLatitude());
                mStartLatlng = new NaviLatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                setMaker(aMapLocation.getLatitude(), aMapLocation.getLongitude(), false);
//                mListener.onLocationChanged(aMapLocation);// 显示系统小蓝点
            } else {
                String errText = "定位失败," + aMapLocation.getErrorCode() + ": " + aMapLocation.getErrorInfo();
                Log.e("AmapErr", errText);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        passengerMap.onDestroy();
        if (null != mlocationClient) {
            mlocationClient.onDestroy();
        }
    }


}
