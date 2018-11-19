package com.example.chen.easygo.me;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.chen.easygo.BaseActivity;
import com.example.chen.easygo.R;
import com.example.chen.easygo.net.Bean.JsonBaseBean;
import com.example.chen.easygo.net.myHttp.DataManager;
import com.example.chen.easygo.net.myHttp.HttpUrl;
import com.example.chen.easygo.net.myHttp.RObserver;
import com.example.chen.easygo.utils.ToastUtlis;
import com.example.chen.easygo.utils.UserLoginUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 申诉服务
 */
public class AppealServiceActivity extends BaseActivity {

    @BindView(R.id.appeal_content)
    EditText appealContent;
    @BindView(R.id.submit_appeal_btn)
    Button submitAppealBtn;

    DataManager dataManager;
    CompositeSubscription compositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appeal_service);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {
        setTitleBar("申诉服务");
        initBackView();
        compositeSubscription = new CompositeSubscription();
    }

    private void initData() {
        if (!appealContent.getText().toString().equalsIgnoreCase("")) {
            String url = HttpUrl.SERVER_URL + "driver/appeal/" + UserLoginUtil.getDriverId() + "/" + appealContent.getText().toString();
            dataManager = new DataManager(getApplicationContext(), new HashMap<String, String>());
            compositeSubscription.add(dataManager.driverAppeal(url)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new RObserver<JsonBaseBean>(this, true) {
                        @Override
                        protected void onSuccess(JsonBaseBean baseBean) {
                            if (baseBean.getCode() == 0){
                                ToastUtlis.show(AppealServiceActivity.this, "申诉成功，请等候客服与您联系");
                            }else {
                                ToastUtlis.show(AppealServiceActivity.this, baseBean.getMessage());
                            }
                        }

                        @Override
                        protected void onError(String msg) {

                        }
                    }));
        } else {
            ToastUtlis.show(this, "请填写申诉内容");
        }

    }



    @OnClick(R.id.submit_appeal_btn)
    public void onViewClicked() {
        initData();
    }
}
