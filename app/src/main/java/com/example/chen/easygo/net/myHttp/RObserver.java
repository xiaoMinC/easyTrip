package com.example.chen.easygo.net.myHttp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.chen.easygo.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observer;

/**
 * 网络模块-服务器响应事件观察者
 * Created by Administrator on 2018/2/27 0027.
 */

public abstract class RObserver<T extends BaseResponse> implements Observer<T> {
    private Context mContext;
    private  boolean mShowProgress = true;//是否显示加载对话框
    private  boolean mIsLogin = true;//是否是登录页面
    private String errorMsg = "未知的错误！";
    private int errorCode = -1111;
    private static Gson gson = new Gson();

    public RObserver(Context mContext) {
        this.mContext = mContext;
    }

    public RObserver(Context context, boolean showProgress){
        this.mContext = context;
        mShowProgress = showProgress;
        if (showProgress) {
            // 此处可以添加进度框
            PDialog.getInstance().showDialog(mContext);
        }
        mIsLogin = false;
    }

    public RObserver(Context context, boolean showProgress,boolean isLogin){
        this.mContext = context;
        mShowProgress = showProgress;
        mIsLogin = isLogin;
        if (showProgress) {
            // 此处可以添加进度框
            PDialog.getInstance().showDialog(mContext);
        }
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onNext(T response) {
        if(mShowProgress){
            // 此处结束进度框
            PDialog.getInstance().dismissDialog();
        }
        if (!mIsLogin)
//            if (response.getResultCode().equalsIgnoreCase(AppUtils.FAIL)){
//                com.shunan.app.commom.T.showShort(mContext,mContext.getString(R.string.fail_msg));
//                final ConfirmDialog dialog = new ConfirmDialog(mContext,"是否重新登录");
//                dialog.setOnConfirmDialogListener(new OnDialogConfirmListener() {
//                    @Override
//                    public void confirm() {
//                        mContext.startActivity(new Intent(mContext, LoginActivity.class));
//                        ((Activity)mContext).finish();
//                    }
//                });
//
//                dialog.setOnConfirmCancalDialogListener(new OnDialogCancelListener() {
//                    @Override
//                    public void cancel() {
//                        dialog.dismiss();
//                    }
//                });
//                dialog.show();
//            }

        this.onSuccess(response);
    }

    @Override
    public void onError(Throwable e) {
        if(mShowProgress){
            // 此处结束进度框
            PDialog.getInstance().dismissDialog();
        }

        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            errorCode = httpException.code();
            errorMsg = httpException.getMessage();
//            getErrorMsg(httpException);
        } else if (e instanceof SocketTimeoutException) {  //VPN open
//            errorCode = RESPONSE_CODE_FAILED;
            errorMsg = mContext.getString(R.string.exception_socket_timeout);
        } else if (e instanceof ConnectException) {
//            errorCode = RESPONSE_CODE_FAILED;
            errorMsg = mContext.getString(R.string.exception_connection_abnormal);
        } else if (e instanceof ClassCastException) {
//            errorCode = RESPONSE_CODE_FAILED;
            errorMsg = mContext.getString(R.string.exception_class_cast);
        } else if (e instanceof RuntimeException) {
//            errorCode = RESPONSE_CODE_FAILED;
            errorMsg = mContext.getString(R.string.exception_runtime);
        } else if (e instanceof UnknownHostException) {
//            errorCode = RESPONSE_CODE_FAILED;
            errorMsg = mContext.getString(R.string.exception_unknown_host);
        } else if (e instanceof UnknownServiceException) {
//            errorCode = RESPONSE_CODE_FAILED;
            errorMsg = mContext.getString(R.string.exception_unknown_service);
        } else if (e instanceof IOException) {  //飞行模式等
//            errorCode = RESPONSE_CODE_FAILED;
            errorMsg = mContext.getString(R.string.exception_no_network);
        }
//        com.shunan.app.commom.T.showShort(mContext,errorMsg);
        this.onError(errorMsg);
    }

    protected abstract void onSuccess(T t);
    protected abstract void onError(String msg);

}
