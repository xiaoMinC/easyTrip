package com.example.chen.easygo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.chen.easygo.hot.HotFragment;
import com.example.chen.easygo.me.MeFragment;
import com.example.chen.easygo.message.MessageFragment;
import com.example.chen.easygo.order.OrderFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_tab_viewpager)
    ViewPager viewPager;
    @BindView(android.R.id.tabcontent)
    FrameLayout tabcontent;
    @BindView(android.R.id.tabhost)
    FragmentTabHost tabhost;
    private String[] strs = new String[]{ "订单", "消息", "我的"};
    private Class[] fragments = new Class[]{ OrderFragment.class, MessageFragment.class, MeFragment.class};
    private List<Fragment> fragmentlist = new ArrayList<>();
    private int[] images = new int[]{R.drawable.ic_select_write, R.drawable.ic_select_write, R.drawable.ic_select_write};
    private LayoutInflater inflater;
    private FragmentStatePagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {
        inflater = LayoutInflater.from(this);
        tabhost.setup(this, getSupportFragmentManager(), R.id.fl_tab_viewpager);
        for (int i = 0; i < strs.length; i++) {
            TabHost.TabSpec tabSpec = tabhost.newTabSpec(strs[i]).setIndicator(getTabItemView(i));
            tabhost.addTab(tabSpec, fragments[i], null);
//            tabhost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_bg);
        }

        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                int position = tabhost.getCurrentTab();
                viewPager.setCurrentItem(position);
            }
        });

//        HotFragment p1 = new HotFragment();
        OrderFragment p2 = new OrderFragment();
        MessageFragment p3 = new MessageFragment();
        MeFragment p4 = new MeFragment();
//        fragmentlist.add(p1);
        fragmentlist.add(p2);
        fragmentlist.add(p3);
        fragmentlist.add(p4);
        viewPagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragmentlist.size();
            }

            @Override
            public Fragment getItem(int index) {
                return fragmentlist.get(index);
            }
        };
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                tabhost.setCurrentTab(position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

        //设置页面动画
        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                // page.setRotationY(position * -30);
                // final float normalizedposition = Math.abs(Math.abs(position) - 1);
                // page.setScaleX(normalizedposition / 2 + 0.5f);
                // page.setScaleY(normalizedposition / 2 + 0.5f);
            }
        });
    }


    public View getTabItemView(int index) {
        View view = inflater.inflate(R.layout.tab_item_view, null, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_tabImage);
        imageView.setImageResource(images[index]);
        TextView textView = (TextView) view.findViewById(R.id.tv_tabText);
        textView.setText(strs[index]);
//        if (index == 2) {
//            tv_notice = (TextView) view.findViewById(R.id.tv_msg_notice);
//        }
        return view;
    }


}
