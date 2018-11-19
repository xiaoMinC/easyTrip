package com.example.chen.easygo.common.onechoose;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.chen.easygo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/10/26.
 */

public class OCAdapter extends BaseAdapter implements View.OnClickListener, IAdapter {
    private Context mContext;
    private Callback mCallback;
    private List<DialogBean> mList;

    public OCAdapter(Context context, Callback callback) {
        this.mContext = context;
        this.mCallback = callback;
        init();
    }

    @Override
    public void init() {
        if (mList == null) {
            mList = new ArrayList<>();
        }
    }

    @Override
    public void updateData(List resultList, boolean isClear) {
        if (resultList != null) {
            if (isClear) {
                mList.clear();
            }
            if (resultList != null && resultList.size() > 0) {
                mList.addAll(resultList);
            }
        }
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.one_choose_dialog_item_layout, null);
            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (mList != null) {
            viewHolder.tvItemOc.setText(mList.get(position).getName());
            viewHolder.tvItemOc.setOnClickListener(this);
            viewHolder.tvItemOc.setTag(position);
        }
        return convertView;
    }


    /**
     * 自定义接口，用于回调按钮点击事件到Activity
     */
    public interface Callback {
        public void click(int position);
    }

    //响应按钮点击事件,调用子定义接口，并传入View
    @Override
    public void onClick(View v) {
        mCallback.click((Integer) v.getTag());
    }


    static class ViewHolder {
        @BindView(R.id.tv_item_oc)
        TextView tvItemOc;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
