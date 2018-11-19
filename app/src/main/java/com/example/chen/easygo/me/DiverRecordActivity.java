package com.example.chen.easygo.me;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chen.easygo.BaseActivity;
import com.example.chen.easygo.R;
import com.example.chen.easygo.net.Bean.JsonBaseBean;
import com.example.chen.easygo.net.myHttp.DataManager;
import com.example.chen.easygo.net.myHttp.HttpUrl;
import com.example.chen.easygo.net.myHttp.RObserver;
import com.example.chen.easygo.utils.DateFormatUtil;
import com.example.chen.easygo.utils.UserLoginUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 行程记录
 */
public class DiverRecordActivity extends BaseActivity {

    @BindView(R.id.tv_num_dr)
    TextView tvNumDr;
    @BindView(R.id.tv_dan_num_dr)
    TextView tvDanNumDr;
    @BindView(R.id.tv_month)
    TextView tvMonth;
    @BindView(R.id.lv_dr)
    ListView lvDr;

    DataManager dataManager;
    CompositeSubscription compositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dirver_record);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    private void initView() {
        compositeSubscription = new CompositeSubscription();

        setTitleBar("行程记录");
        initBackView();
    }

    private void initData() {
        String url = HttpUrl.SERVER_URL+"driver/record/"+ UserLoginUtil.getDriverId()+"/"+ DateFormatUtil.getCurrentYM()
                +"/1/20";
        dataManager = new DataManager(getApplicationContext(),new HashMap<String, String>());
        compositeSubscription.add(dataManager.driverRecord(url)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new RObserver<JsonBaseBean>(this,true) {
            @Override
            protected void onSuccess(JsonBaseBean baseBean) {

            }

            @Override
            protected void onError(String msg) {

            }
        }));
    }
}
