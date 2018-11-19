package com.example.chen.easygo.me;

import android.os.Bundle;
import android.widget.TextView;

import com.example.chen.easygo.BaseActivity;
import com.example.chen.easygo.R;
import com.example.chen.easygo.net.Bean.UserBaseInfoBean;
import com.example.chen.easygo.net.Bean.UserInfoBean;
import com.example.chen.easygo.net.myHttp.DataManager;
import com.example.chen.easygo.net.myHttp.HttpUrl;
import com.example.chen.easygo.net.myHttp.RObserver;
import com.example.chen.easygo.utils.StringUtils;
import com.example.chen.easygo.utils.ToastUtlis;
import com.example.chen.easygo.utils.UserLoginUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 个人中心
 */
public class AboutMeActivity extends BaseActivity {

    @BindView(R.id.tv_name_am)
    TextView tvNameAm;
    @BindView(R.id.card_num_am)
    TextView cardNumAm;
    @BindView(R.id.driver_date_am)
    TextView driverDateAm;
    @BindView(R.id.driver_img_am)
    TextView driverImgAm;
    @BindView(R.id.city_am)
    TextView cityAm;

    DataManager dataManager;
    CompositeSubscription compositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    private void initView() {
        compositeSubscription = new CompositeSubscription();

        setTitleBar("个人中心");
        initBackView();
    }

    private void initData() {
        String url = HttpUrl.SERVER_URL+"driver/profile/info/"+ UserLoginUtil.getDriverId();
        dataManager = new DataManager(getApplicationContext(),new HashMap<String, String>());
        compositeSubscription.add(dataManager.driverInfo(url)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new RObserver<UserBaseInfoBean>(this,true) {
            @Override
            protected void onSuccess(UserBaseInfoBean baseInfoBean) {
                if (baseInfoBean.getCode() == 0){
                    setViewValue(baseInfoBean);
                }else {
                    ToastUtlis.show(getApplicationContext(),baseInfoBean.getMessage());
                }
            }

            @Override
            protected void onError(String msg) {

            }
        }));
    }

    private void setViewValue(UserBaseInfoBean baseInfoBean) {
        tvNameAm.setText(baseInfoBean.getData().getDriver().getDriverName());
        cardNumAm.setText(StringUtils.idIDCard(baseInfoBean.getData().getDriver().getIdentityNumber()));
        driverDateAm.setText(baseInfoBean.getData().getDriver().getFirstIssueDate());
        cityAm.setText(baseInfoBean.getData().getDriver().getCityName());
    }
}
