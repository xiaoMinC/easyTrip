package com.example.chen.easygo.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chen.easygo.R;
import com.example.chen.easygo.net.Bean.UserInfoBean;
import com.example.chen.easygo.net.myHttp.DataManager;
import com.example.chen.easygo.net.myHttp.HttpUrl;
import com.example.chen.easygo.net.myHttp.RObserver;
import com.example.chen.easygo.utils.ToActivityUtil;
import com.example.chen.easygo.utils.ToastUtlis;
import com.example.chen.easygo.utils.UserLoginUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 我栏
 * Created by Chen on 2018/10/8.
 */

public class MeFragment extends Fragment {
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.tv_diver_name)
    TextView tvDiverName;
    @BindView(R.id.tv_diver_message)
    TextView tvDiverMessage;
    @BindView(R.id.tv_diver_record)
    TextView tvDiverRecord;
    @BindView(R.id.tv_month_summary)
    TextView tvMonthSummary;
    @BindView(R.id.tv_appeal_service)
    TextView tvAppealService;
    @BindView(R.id.tv_car_num)
    TextView tvCarNum;
    @BindView(R.id.tv_level)
    TextView tvLevel;

    Unbinder unbinder;

    DataManager dataManager;
    CompositeSubscription compositeSubscription;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me_fragment, container, false);
        initView(view);
        loadData();
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    private void initView(View view) {
        compositeSubscription = new CompositeSubscription();
    }

    private void loadData() {
        dataManager = new DataManager(getContext(), new HashMap<String, String>());
        String url = HttpUrl.SERVER_URL + "driver/profile/center/" + UserLoginUtil.getDriverId();
        compositeSubscription.add(dataManager.personCenter(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RObserver<UserInfoBean>(getContext(), true) {
                    @Override
                    protected void onSuccess(UserInfoBean baseBean) {
                        if (baseBean.getCode() == 0) {
                            setViewValue(baseBean);
                        } else {
                            ToastUtlis.show(getContext(), baseBean.getMessage());
                        }
                    }

                    @Override
                    protected void onError(String msg) {

                    }
                }));
    }

    private void setViewValue(UserInfoBean baseBean) {
        Glide.with(this).load(baseBean.getData().getDriver().getIconUrl()).into(ivIcon);
        tvDiverName.setText(baseBean.getData().getDriver().getDriverName());
        tvCarNum.setText(baseBean.getData().getDriver().getCarNumber());
            switch (baseBean.getData().getDriver().getGrade()){
                case 1:
                    tvLevel.setText("沙子");
                    break;
                case 2:
                    tvLevel.setText("石头");
                    break;
                case 3:
                    tvLevel.setText("贝壳");
                    break;
                case 4:
                    tvLevel.setText("珠宝");
                    break;
                case 5:
                    tvLevel.setText("钻石");
                    break;
                case 6:
                    tvLevel.setText("黄金");
                    break;
            }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_icon, R.id.tv_diver_message, R.id.tv_diver_record, R.id.tv_month_summary, R.id.tv_appeal_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_icon:
                break;
            case R.id.tv_diver_message:
                startActivity(new Intent(getActivity(),AboutMeActivity.class));
                break;
            case R.id.tv_diver_record:
                startActivity(new Intent(getActivity(),DiverRecordActivity.class));
                break;
            case R.id.tv_month_summary:
                startActivity(new Intent(getActivity(),MonthSummaryActivity.class));
                break;
            case R.id.tv_appeal_service:
                startActivity(new Intent(getActivity(),AppealServiceActivity.class));
                break;
        }
    }
}
