package com.example.chen.easygo.common.onechoose;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


import com.example.chen.easygo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 单选对话框
 * Created by admin on 2016/10/26.
 */

public class OneChooseDialog extends Dialog implements OCAdapter.Callback {
    TextView tvTitleDialog;
    ListView oneChooseLv;
    private Context mContext;
    private OCAdapter mAdapter;
    private OnChooseListener mOnChooseListener;
    private List<DialogBean> mList = new ArrayList<>();
    private int layoutHeight;


    public OneChooseDialog(Context context, List<DialogBean> list, OnChooseListener onChooseListener) {
        super(context, R.style.ShareDialog);
        mContext = context;
        mOnChooseListener = onChooseListener;
        mList.addAll(list);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.one_choose_dialog_layout, null);
        setCanceledOnTouchOutside(true);
        tvTitleDialog = (TextView) layout.findViewById(R.id.tv_title_dialog);
        oneChooseLv = (ListView) layout.findViewById(R.id.one_choose_lv);
        init();
        setAdapter(mList);
        this.setContentView(layout);
    }

    private void init() {
        mAdapter = new OCAdapter(mContext, this);
//        oneChooseLv.setOnItemClickListener(this);
        oneChooseLv.setAdapter(mAdapter);
    }

    private void setAdapter(List<DialogBean> mList) {
        if (mAdapter != null && mList.size() > 0) {
            mAdapter.updateData(mList, true);
            mAdapter.notifyDataSetChanged();
        }

    }

//    /**
//     * 响应ListView中item的点击事件
//     */
//    @Override
//    public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
//
//    }


    @Override
    public void click(int position) {
        mOnChooseListener.OnChooseListener(mList.get(position));
//        Utils.toastText(mContext, "点击的省份ID为：" + mList.get(position).getProvinceId());
        dismiss();
    }
}
