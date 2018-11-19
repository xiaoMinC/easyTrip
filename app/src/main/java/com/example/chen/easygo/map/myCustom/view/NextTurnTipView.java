package com.example.chen.easygo.map.myCustom.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.chen.easygo.R;


/**
 * 下一个路口转向View类
 *
 */
public class NextTurnTipView extends ImageView {
    private int[] customIconTypeDrawables;
    private Bitmap nextTurnBitmap;
    private long mLastIconType = -1;
    private Resources customRes;
    private int[] defaultIconTypes = {R.drawable.caricon,
            R.drawable.caricon, R.drawable.sou2, R.drawable.sou3,
            R.drawable.sou4, R.drawable.sou5, R.drawable.sou6, R.drawable.sou7,
            R.drawable.sou8, R.drawable.sou9, R.drawable.sou10,
            R.drawable.sou11, R.drawable.sou12, R.drawable.sou13,
            R.drawable.sou14, R.drawable.sou15, R.drawable.sou16,
            R.drawable.sou17, R.drawable.sou18, R.drawable.sou19,
    };

    /**
     * 用于设置自定义的icon图片数组。
     * <p>
     * 此方法与NextTurnTipView.setIconType(int)相互配合。
     * 导航过程中，SDK会调用NextTurnTipView.setIconType(int)设置转向图片，其中图片
     * 就是通过customIconTypes[]数组对应index下标获取的。
     *
     * @param res             Resource资源
     * @param customIconTypes icon数组，数组中存放图片的顺序需要与IconType依次对应
     */
    public void setCustomIconTypes(Resources res, int[] customIconTypes) {
        try {
            if (res == null || customIconTypes == null) {
                return;
            }
            this.customRes = res;
            customIconTypeDrawables = new int[customIconTypes.length + 2];
            for (int i = 0; i < customIconTypes.length; i++) {
                customIconTypeDrawables[i + 2] = customIconTypes[i];
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * @exclude
     */
    public NextTurnTipView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * @exclude
     */
    public NextTurnTipView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @exclude
     */
    public NextTurnTipView(Context context) {
        super(context);

    }

    /**
     * 释放图片资源
     */
    public void recycleResource() {
        try {
            if (nextTurnBitmap != null) {
                nextTurnBitmap.recycle();
                nextTurnBitmap = null;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置自定义的转向图标，请参考{@link com.amap.api.navi.enums.IconType}
     *
     * @param iconType 图片的id
     */
    public void setIconType(int iconType) {
        try {
            if (iconType > 19 || mLastIconType == iconType) {
                return;
            }
            recycleResource();
            if (customIconTypeDrawables != null && customRes != null) {
                nextTurnBitmap = BitmapFactory.decodeResource(customRes, customIconTypeDrawables[iconType]);
            } else {
                nextTurnBitmap = BitmapFactory.decodeResource(getResources(), defaultIconTypes[iconType]);
            }
            setImageBitmap(nextTurnBitmap);
            mLastIconType = iconType;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
