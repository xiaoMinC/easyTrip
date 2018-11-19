package com.example.chen.easygo.order;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.chen.easygo.BaseActivity;
import com.example.chen.easygo.R;
import com.example.chen.easygo.order.fragment.PassengerFragment;
import com.example.chen.easygo.order.fragment.ShishiFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.hoang8f.android.segmented.SegmentedGroup;

/**
 * 乘客行程
 */
public class TripActivity extends BaseActivity {


    @BindView(R.id.tv_service_num)
    TextView tvServiceNum;
    @BindView(R.id.tv_week_liuShui)
    TextView tvWeekLiuShui;
    @BindView(R.id.tv_week_num)
    TextView tvWeekNum;
    @BindView(R.id.ll_order_head)
    LinearLayout llOrderHead;
    @BindView(R.id.rb_one)
    RadioButton rbOne;
    @BindView(R.id.rb_two)
    RadioButton rbTwo;
    @BindView(R.id.rg)
    SegmentedGroup rg;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    private ShishiFragment mShishiFragment;
    private PassengerFragment mPassengerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        rbOne = (RadioButton) rg.getChildAt(0);
        rbOne.setChecked(true);
        showFragments(1);

        rg.setOnCheckedChangeListener(areaCheck);
        areaCheck.onCheckedChanged(null, 0);


    }

    RadioGroup.OnCheckedChangeListener areaCheck = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            switch (checkedId) {
                case R.id.rb_one:
                    showFragments(1);
                    break;
                case R.id.rb_two:
                    showFragments(2);
                    break;
                default:
            }
        }
    };

    private void showFragments(int num) {
        FragmentTransaction mTransaction = getSupportFragmentManager().beginTransaction();
        hideFragments(mTransaction);
        switch (num) {
            case 1:
                if (mShishiFragment != null) {
                    mTransaction.show(mShishiFragment);
                } else {
                    mShishiFragment = new ShishiFragment();
                    mTransaction.add(R.id.ll_content, mShishiFragment);
                }
                break;
            case 2:
                if (mPassengerFragment != null) {
                    mTransaction.show(mPassengerFragment);
                } else {
                    mPassengerFragment = new PassengerFragment();
                    mTransaction.add(R.id.ll_content, mPassengerFragment);
                }
                break;
        }
        mTransaction.commit();
    }

    private void hideFragments(FragmentTransaction mTransaction) {
        if (mShishiFragment != null)
            mTransaction.hide(mShishiFragment);
        if (mPassengerFragment != null)
            mTransaction.hide(mPassengerFragment);
    }
}
