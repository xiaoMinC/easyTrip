package com.example.chen.easygo.loginOrRegister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.chen.easygo.BaseActivity;
import com.example.chen.easygo.MainActivity;
import com.example.chen.easygo.R;
import com.example.chen.easygo.net.Bean.JsonBaseBean;
import com.example.chen.easygo.net.Bean.LoginBean;
import com.example.chen.easygo.net.myHttp.DataManager;
import com.example.chen.easygo.net.myHttp.HttpUrl;
import com.example.chen.easygo.net.myHttp.RObserver;
import com.example.chen.easygo.order.GetPassengerActivity;
import com.example.chen.easygo.utils.ToActivityUtil;
import com.example.chen.easygo.utils.ToastUtlis;
import com.example.chen.easygo.utils.UserLoginUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.email)
    AutoCompleteTextView mEmailView;
    @BindView(R.id.password)
    EditText mPasswordView;
    @BindView(R.id.email_sign_in_button)
    Button mEmailSignInButton;
    @BindView(R.id.register)
    Button register;
    @BindView(R.id.btn_get_code)
    Button btnGetCode;

    private DataManager dataManager;
    CompositeSubscription compositeSubscription;

    private LoginModel mLoginModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        compositeSubscription = new CompositeSubscription();
        mLoginModel = new LoginModel(this);
    }

    private void loadImage() {
        compositeSubscription = new CompositeSubscription();
        dataManager = new DataManager(this, new HashMap<String, String>());
        String url = HttpUrl.SERVER_URL + "operative/publicity/images/" + "2";
        compositeSubscription.add(dataManager.publicity(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RObserver<JsonBaseBean>(this, true) {
                    @Override
                    protected void onSuccess(JsonBaseBean jsonBaseBean) {

                    }

                    @Override
                    protected void onError(String msg) {

                    }
                }));
    }

    @OnClick({R.id.email_sign_in_button, R.id.register,R.id.btn_get_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.email_sign_in_button:
                if (mEmailView.getText().toString().equalsIgnoreCase("")){
                    return;
                }
                if (mPasswordView.getText().toString().equalsIgnoreCase("")){
                    return;
                }
                attemptLogin();
                break;
            case R.id.register:
                ToActivityUtil.toNextActivityNoFinish(this, RegisterOneActivity.class);
                break;
            case R.id.btn_get_code:
                if (mEmailView.getText().toString().equalsIgnoreCase("")){
                    return;
                }
                mLoginModel.getCode(mEmailView.getText().toString());
                break;
        }
    }

    private void attemptLogin() {
        mEmailView.setError(null);
        mPasswordView.setError(null);

        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        mLoginModel.login(email,password);


    }

}

