package com.example.chen.easygo.order.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.example.chen.easygo.R;
import com.example.chen.easygo.map.localtion.Location;
import com.example.chen.easygo.net.Bean.JsonBaseBean;
import com.example.chen.easygo.net.myHttp.DataManager;
import com.example.chen.easygo.net.myHttp.HttpUrl;
import com.example.chen.easygo.net.myHttp.RObserver;
import com.example.chen.easygo.order.OrderAdapter;
import com.example.chen.easygo.order.PublishActivity;
import com.example.chen.easygo.utils.L;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 实时订单
 */
public class ShishiFragment extends Fragment {

    @BindView(R.id.lv_order)
    PullToRefreshListView lvOrder;
    @BindView(R.id.btn_publish)
    Button btnPublish;
    @BindView(R.id.ll_publish)
    LinearLayout llPublish;
    Unbinder unbinder;

    private OrderAdapter adapter;
    private int currentPage = 1;
    private boolean PullDown = false;
    private String descStr = "";
    DataManager dataManager;
    CompositeSubscription compositeSubscription;
    private Double v,v1;
    private String cityCode;
    Location location;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_item_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        initView(view);

        return view;
    }

    private void initView(View view) {
        compositeSubscription = new CompositeSubscription();

        lvOrder = (PullToRefreshListView) view.findViewById(R.id.lv_order);
        lvOrder.setMode(PullToRefreshBase.Mode.BOTH);

        lvOrder.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                PullDown = true;
                currentPage = 1;
                loadData();
                if (!descStr.equals("")) {
                    refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("上次更新时间:" + descStr);
                }
                descStr = DateUtils.formatDateTime(getContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                PullDown = false;
                currentPage++;
                loadData();
                if (!descStr.equals("")) {
                    refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("上次更新时间:" + descStr);
                }
                descStr = DateUtils.formatDateTime(getContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

            }

        });
        adapter = new OrderAdapter(getContext());
        lvOrder.setAdapter(adapter);


        location = new Location(getContext(), new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {

                if (aMapLocation != null) {
                    location.stopLocation();
                    L.i("aMapLocation:" + aMapLocation.getAddress());
                    v = aMapLocation.getLatitude();
                    v1 = aMapLocation.getLongitude();
                    cityCode = aMapLocation.getCityCode();

                }
            }
        });
        location.startLocation();


    }

    private void loadData() {
        dataManager = new DataManager(getContext(),new HashMap<String, String>());
        String location = "";
        String url = HttpUrl.SERVER_URL+"driver/travel/directroute/"+location+"/"+cityCode+"/"+currentPage+"/20";
        compositeSubscription.add(dataManager.directRoute(url)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new RObserver<JsonBaseBean>(getContext(),true) {
            @Override
            protected void onSuccess(JsonBaseBean baseBean) {

            }

            @Override
            protected void onError(String msg) {

            }
        }));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_publish)
    public void onViewClicked() {
        startActivity(new Intent(getContext(), PublishActivity.class));
    }
}
