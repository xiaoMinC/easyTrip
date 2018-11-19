package com.example.chen.easygo.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.view.PoiInputItemWidget;
import com.example.chen.easygo.BaseActivity;
import com.example.chen.easygo.R;
import com.example.chen.easygo.common.onechoose.DialogBean;
import com.example.chen.easygo.common.onechoose.OnChooseListener;
import com.example.chen.easygo.common.onechoose.OneChooseDialog;
import com.example.chen.easygo.map.localtion.Location;
import com.example.chen.easygo.map.search.SearchPoiActivity;
import com.example.chen.easygo.net.Bean.JsonBaseBean;
import com.example.chen.easygo.net.myHttp.DataManager;
import com.example.chen.easygo.net.myHttp.RObserver;
import com.example.chen.easygo.utils.L;
import com.example.chen.easygo.utils.UserLoginUtil;
import com.iflytek.cloud.thirdparty.S;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class PublishActivity extends BaseActivity{

    @BindView(R.id.id_start_addr)
    TextView idStartAddr;
    @BindView(R.id.id_end_addr)
    TextView idEndAddr;
    @BindView(R.id.id_num)
    TextView idNum;
    @BindView(R.id.id_start_time)
    TextView idStartTime;
    @BindView(R.id.btn_publish)
    Button btnPublish;
    NaviLatLng startLatlng;
    NaviLatLng endLatlng;

    DataManager dataManager;
    CompositeSubscription compositeSubscription;
    Location location;
    private String cityCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        ButterKnife.bind(this);

        initView();

        initValue();

    }

    private void initValue() {
        location = new Location(this, new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null){
                    L.i("aMapLocation:"+aMapLocation.getAddress());
                    idStartAddr.setText(aMapLocation.getAddress());
                    cityCode = aMapLocation.getCityCode();
                    location.stopLocation();
                }
            }
        });
        location.startLocation();

        if (!idStartAddr.getText().toString().equalsIgnoreCase("")){
            location.startLocation();
        }

    }

    private void initView() {
        setTitleBar("发布行程");
        initBackView();

        compositeSubscription = new CompositeSubscription();

    }


    @OnClick({R.id.id_start_addr,R.id.id_end_addr, R.id.id_start_time, R.id.btn_publish, R.id.id_num})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.id_end_addr:
                Intent sintent = new Intent(this, SearchPoiActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("pointType", PoiInputItemWidget.TYPE_START);
                sintent.putExtras(bundle);
                startActivityForResult(sintent, 100);
                break;
            case R.id.endpoint:
                Intent eintent = new Intent(this, SearchPoiActivity.class);
                Bundle ebundle = new Bundle();
                ebundle.putInt("pointType", PoiInputItemWidget.TYPE_DEST);
                eintent.putExtras(ebundle);
                startActivityForResult(eintent, 200);
                break;
            case R.id.id_start_time:
                break;
            case R.id.btn_publish:
                publishOrder();
                startActivity(new Intent(this,LoadingOrderActivity.class));
                break;
            case R.id.id_num:
                List<DialogBean> list = new ArrayList<>();
                list.add(new DialogBean("1",""));
                list.add(new DialogBean("2",""));
                list.add(new DialogBean("3",""));
                list.add(new DialogBean("4",""));
                OneChooseDialog dialog = new OneChooseDialog(this, list, new OnChooseListener() {
                    @Override
                    public void OnChooseListener(DialogBean bean) {
                        idNum.setText(bean.getName());
                    }
                });
                dialog.show();
                break;
        }
    }

    private void publishOrder() {
        HashMap<String,String> map = new HashMap<>();
        map.put("driverId", UserLoginUtil.getDriverId()+"");
        map.put("departCityCode", cityCode);
        map.put("arrivalCityCode", cityCode);
        map.put("seats", idNum.getText().toString());
        map.put("publishLocation", idStartAddr.getText().toString());
        map.put("expectDepartDatetime", idStartTime.getText().toString());
        map.put("expectArrivalDatetime", "");
        map.put("departAddress", idStartAddr.getText().toString());
        map.put("arrivalAddress", idEndAddr.getText().toString());
        map.put("departLocation", "");
        map.put("arrivalLocation", "");

        dataManager = new DataManager(getApplicationContext(),map);
        compositeSubscription.add(dataManager.publishTravel(map)
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && data.getParcelableExtra("poi") != null) {
            Poi poi = data.getParcelableExtra("poi");
            if (requestCode == 100) {//起点选择完成
                //Toast.makeText(this, "100", Toast.LENGTH_SHORT).show();
                startLatlng = new NaviLatLng(poi.getCoordinate().latitude, poi.getCoordinate().longitude);
            }
            if (requestCode == 200) {//终点选择完成
                //Toast.makeText(this, "200", Toast.LENGTH_SHORT).show();
                endLatlng = new NaviLatLng(poi.getCoordinate().latitude, poi.getCoordinate().longitude);
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        getAmapLocation().stopLocation();
    }
}
