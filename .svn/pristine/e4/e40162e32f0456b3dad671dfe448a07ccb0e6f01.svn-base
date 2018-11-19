package com.example.chen.easygo.map;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amap.api.navi.AMapNaviView;
import com.amap.api.navi.AMapNaviViewOptions;
import com.amap.api.navi.enums.NaviType;
import com.amap.api.navi.model.NaviLatLng;
import com.example.chen.easygo.R;
import com.example.chen.easygo.order.TripActivity;
import com.example.chen.easygo.utils.L;
import com.example.chen.easygo.utils.ToActivityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GPSNaviActivity extends MapBaseActivity {

    @BindView(R.id.call_safe)
    Button callSafe;
    AMapNaviView mAMapNaviView;
    @BindView(R.id.tv_arrive)
    TextView tvArrive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_basic_navi);
        ButterKnife.bind(this);
        mAMapNaviView = (AMapNaviView) findViewById(R.id.navi_view);
        mAMapNaviView.onCreate(savedInstanceState);
        mAMapNaviView.setAMapNaviViewListener(this);

        AMapNaviViewOptions options = new AMapNaviViewOptions();
        options.setScreenAlwaysBright(false);
        mAMapNaviView.setViewOptions(options);

        getIntentData();
    }

    private void getIntentData() {
        NaviLatLng start, end;
        if (getIntent() != null) {
            start = getIntent().getParcelableExtra("object");
            end = getIntent().getParcelableExtra("object1");
            L.i("start:" + start.getLatitude() + "--" + start.getLongitude());
            L.i("end:" + end.getLatitude() + "--" + end.getLongitude());
            setLatlng(start, end);
        }


    }


    @Override
    public void onInitNaviSuccess() {
        super.onInitNaviSuccess();
        /**
         * 方法: int strategy=mAMapNavi.strategyConvert(congestion, avoidhightspeed, cost, hightspeed, multipleroute); 参数:
         *
         * @congestion 躲避拥堵
         * @avoidhightspeed 不走高速
         * @cost 避免收费
         * @hightspeed 高速优先
         * @multipleroute 多路径
         *
         *  说明: 以上参数都是boolean类型，其中multipleroute参数表示是否多条路线，如果为true则此策略会算出多条路线。
         *  注意: 不走高速与高速优先不能同时为true 高速优先与避免收费不能同时为true
         */
        int strategy = 0;
        try {
            //再次强调，最后一个参数为true时代表多路径，否则代表单路径
            strategy = mAMapNavi.strategyConvert(true, false, false, false, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        mAMapNavi.setCarNumber("京", "DFZ588");
        mAMapNavi.calculateDriveRoute(sList, eList, mWayPointList, strategy);

    }

    @Override
    public void onCalculateRouteSuccess(int[] ids) {
        super.onCalculateRouteSuccess(ids);
        L.i("算路成功回调");
        mAMapNavi.startNavi(NaviType.EMULATOR);
    }

    @Override
    public void onArriveDestination() {
        super.onArriveDestination();
        //导航结束，到达目的地跳转到TripActivity
        L.i("导航结束，到达目的地");

    }

    @OnClick({R.id.call_safe, R.id.tv_arrive})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.call_safe:
                break;
            case R.id.tv_arrive:
                ToActivityUtil.toNextActivity(this, TripActivity.class);
                break;
        }
    }


}
