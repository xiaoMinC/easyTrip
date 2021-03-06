package com.example.chen.easygo.loginOrRegister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chen.easygo.BaseActivity;
import com.example.chen.easygo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.subscriptions.CompositeSubscription;

public class RegisterTwoActivity extends BaseActivity {


    @BindView(R.id.tv_q_t1)
    TextView tvQT1;
    @BindView(R.id.tv_q_t2)
    TextView tvQT2;
    @BindView(R.id.tv_q_t3)
    TextView tvQT3;
    @BindView(R.id.btn_register_now)
    Button btnRegisterNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_two);
        ButterKnife.bind(this);
        initView();
//        initData();
    }

    private void initView() {
//        compositeSubscription = new CompositeSubscription();

        setTitleBar("注册须知");
        initBackView();
    }



    @OnClick({R.id.tv_q_t1, R.id.tv_q_t2, R.id.tv_q_t3, R.id.btn_register_now})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_q_t1:
                break;
            case R.id.tv_q_t2:
                break;
            case R.id.tv_q_t3:
                break;
            case R.id.btn_register_now:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
        }
    }
}
