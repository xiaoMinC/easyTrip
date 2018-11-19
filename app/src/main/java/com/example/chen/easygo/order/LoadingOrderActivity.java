package com.example.chen.easygo.order;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chen.easygo.BaseActivity;
import com.example.chen.easygo.R;
import com.example.chen.easygo.common.swipebtn.SwipeButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoadingOrderActivity extends BaseActivity {

    @BindView(R.id.tv_service_num)
    TextView tvServiceNum;
    @BindView(R.id.tv_week_liuShui)
    TextView tvWeekLiuShui;
    @BindView(R.id.tv_week_num)
    TextView tvWeekNum;
    @BindView(R.id.ll_order_head)
    LinearLayout llOrderHead;
    @BindView(R.id.swipeNoState)
    SwipeButton swipeNoState;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.order_lv)
    ListView orderLv;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;

    private LoadingOrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_order);
        ButterKnife.bind(this);

        initView();


    }

    private void initView() {
        setTitleBar("顺风听单");
        initBackView();

        adapter = new LoadingOrderAdapter(this);
        orderLv.setAdapter(adapter);



    }


    @OnClick(R.id.tv_cancel)
    public void onViewClicked() {
        finish();
    }
}
