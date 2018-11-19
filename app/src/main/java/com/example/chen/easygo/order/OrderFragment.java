package com.example.chen.easygo.order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chen.easygo.R;
import com.example.chen.easygo.net.myHttp.DataManager;
import com.example.chen.easygo.utils.ToActivityUtil;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import rx.subscriptions.CompositeSubscription;

/**
 * 订单栏
 * Created by Chen on 2018/10/8.
 */

public class OrderFragment extends Fragment {

    @BindView(R.id.tv_service_num)
    TextView tvServiceNum;
    @BindView(R.id.tv_week_liuShui)
    TextView tvWeekLiuShui;
    @BindView(R.id.tv_week_num)
    TextView tvWeekNum;
    @BindView(R.id.ll_order_head)
    LinearLayout llOrderHead;

    Unbinder unbinder;

    DataManager dataManager;
    CompositeSubscription compositeSubscription;
    @BindView(R.id.lv_order)
    PullToRefreshListView lvOrder;
    @BindView(R.id.btn_mode)
    Button btnMode;
    @BindView(R.id.btn_publish)
    Button btnPublish;

    public OrderFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_fragment, container, false);
        initView(view);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    private void initView(View view) {
        compositeSubscription = new CompositeSubscription();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick(R.id.btn_publish)
    public void onViewClicked() {
        ToActivityUtil.toNextActivity(getActivity(),PublishActivity.class);
    }
}
