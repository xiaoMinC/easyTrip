package com.example.chen.easygo.me;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
 * 月度总结
 */
public class MonthSummaryActivity extends BaseActivity {

    @BindView(R.id.tv_service_num_ms)
    TextView tvServiceNumMs;
    @BindView(R.id.bill_ms)
    TextView billMs;
    @BindView(R.id.textView8)
    TextView textView8;

    DataManager dataManager;
    CompositeSubscription compositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_summary);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        compositeSubscription = new CompositeSubscription();

        setTitleBar("月度总结");
        initBackView();
    }

    private void initData() {
        String url = HttpUrl.SERVER_URL+"driver/month/summary/"+ UserLoginUtil.getDriverId()+"/"+ DateFormatUtil.getCurrentMonth();
        dataManager = new DataManager(getApplicationContext(),new HashMap<String, String>());
        compositeSubscription.add(dataManager.driverMonth(url)
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
