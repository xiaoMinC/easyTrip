package com.example.chen.easygo.loginOrRegister;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chen.easygo.BaseActivity;
import com.example.chen.easygo.R;
import com.example.chen.easygo.net.Bean.JsonBaseBean;
import com.example.chen.easygo.net.Bean.RegisterProblemBean;
import com.example.chen.easygo.net.myHttp.DataManager;
import com.example.chen.easygo.net.myHttp.HttpUrl;
import com.example.chen.easygo.net.myHttp.RObserver;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class RegisterOneActivity extends BaseActivity {

    @BindView(R.id.btn_register_msg)
    Button btnRegisterMsg;
    @BindView(R.id.ll_question)
    LinearLayout llQuestion;

    DataManager dataManager;
    CompositeSubscription compositeSubscription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_q);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    private void initView() {
        compositeSubscription = new CompositeSubscription();

        setTitleBar("注册须知");
        initBackView();
    }

    private void initData() {
        String url = HttpUrl.SERVER_URL + "operative/common/problem/2";
        dataManager = new DataManager(getApplicationContext(), new HashMap<String, String>());
        compositeSubscription.add(dataManager.loadProblem(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RObserver<RegisterProblemBean>(this, true) {
                    @Override
                    protected void onSuccess(RegisterProblemBean baseBean) {
                        if (baseBean.getCode() == 0){
                            setViewValue(baseBean);
                        }
                    }

                    @Override
                    protected void onError(String msg) {

                    }
                }));
    }

    private void setViewValue(RegisterProblemBean baseBean) {
        for (int i = 0; i < baseBean.getData().size(); i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.register_question_item,null);
            TextView content = (TextView) view.findViewById(R.id.tv_question_content);
            content.setText(baseBean.getData().get(i).getProblem());

            llQuestion.addView(view);
        }
    }


    @OnClick({ R.id.btn_register_msg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_register_msg:
                startActivity(new Intent(this, RegisterTwoActivity.class));
                break;
        }
    }

}
