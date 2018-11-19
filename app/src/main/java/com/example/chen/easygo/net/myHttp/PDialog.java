package com.example.chen.easygo.net.myHttp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by lenovo on 2017/12/11.
 */

public class PDialog {
    protected static PDialog pDialog;
    protected ProgressDialog mLoadingDialog;

    public static PDialog getInstance(){
        if(pDialog == null){
            pDialog = new PDialog();
        }
        return pDialog;
    }

    private PDialog(){

    }

    /**
     * 显示加载进度框
     */
    public void showDialog(Context context) {
        showDialog(context,"数据加载中...");
    }

    /**
     * 显示加载进度框
     * @param text 显示提示
     */
    public void showDialog(Context context, String text) {
        dismissDialog();
        mLoadingDialog = new ProgressDialog(context);
        mLoadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                dismissDialog();
            }
        });
//        mLoadingDialog.setCancelable(false);
        mLoadingDialog.setCanceledOnTouchOutside(false);
        mLoadingDialog.setMessage(text);
        mLoadingDialog.show();
    }

    /**
     * 关闭数据加载框
     */
    public void dismissDialog() {
        if (mLoadingDialog != null) {
            if (mLoadingDialog.isShowing()) {
                mLoadingDialog.dismiss();
            }
            mLoadingDialog.setOnCancelListener(null);
            mLoadingDialog = null;
        }
    }

}
