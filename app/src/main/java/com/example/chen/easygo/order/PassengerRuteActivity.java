package com.example.chen.easygo.order;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.maps.MapView;
import com.amap.api.navi.model.NaviLatLng;
import com.example.chen.easygo.BaseActivity;
import com.example.chen.easygo.R;
import com.example.chen.easygo.map.GPSNaviActivity;
import com.example.chen.easygo.net.myHttp.DataManager;
import com.example.chen.easygo.utils.L;
import com.example.chen.easygo.utils.ToActivityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.subscriptions.CompositeSubscription;

public class PassengerRuteActivity extends BaseActivity {

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
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_shunlu)
    TextView tvShunlu;
    @BindView(R.id.tv_cancel_rule)
    TextView tvCancelRule;
    @BindView(R.id.passenger_msg)
    LinearLayout passengerMsg;


    String FLAG;
    NaviLatLng mStartLatlng;
    NaviLatLng mEndLatlng;

    DataManager dataManager;
    CompositeSubscription compositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_rute);
        ButterKnife.bind(this);
        initView();
        getIntentData();
    }


    private void initView() {
        setTitleBar("乘客行程");
        initBackView();

        compositeSubscription = new CompositeSubscription();

    }

    private void getIntentData() {
        if (getIntent() != null) {
            FLAG = getIntent().getStringExtra("flag");
            L.i("FLAG:" + FLAG);
        }

        if (FLAG.equalsIgnoreCase("rule")){
            passengerMsg.setVisibility(View.GONE);
            tvCancelRule.setText("开始导航接该乘客");
            tvCancelRule.setTextColor(getResources().getColor(R.color.white));
        }
    }

    @OnClick({R.id.tv_phone, R.id.tv_cancel_rule})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_phone:
                break;
            case R.id.tv_cancel_rule:
                if (FLAG.equalsIgnoreCase("rule")){
                    ToActivityUtil.toNextActivityObject(this, GPSNaviActivity.class,
                            mStartLatlng,
                            mEndLatlng
                    );
                }else {
                    //弹出警告框
                }
                break;
        }
    }
}
