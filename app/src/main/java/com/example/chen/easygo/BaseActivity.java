package com.example.chen.easygo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.example.chen.easygo.map.localtion.Location;
import com.example.chen.easygo.map.util.CheckPermissionsActivity;
import com.example.chen.easygo.utils.L;

/**
 * Created by Chen on 2018/10/8.
 */

public abstract class BaseActivity extends CheckPermissionsActivity {
    Location location;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public void setTitleBar(String title) {
        TextView titleView = (TextView) findViewById(R.id.title);
        titleView.setText(title);
    }

    /**
     * 初始化标题栏 左上返回按钮
     */
    protected void initBackView() {
        // 回退按钮
        ImageButton backview = (ImageButton) findViewById(R.id.id_backview);
        if (backview != null)
            backview.setVisibility(View.VISIBLE);
        backview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolBarAction(v);
            }
        });
    }


    // 由子类去具体实现查询业务
    public void toolBarAction(View v) {
        if (v.getId() == R.id.id_backview) {
            finish();
        }
    }


}
