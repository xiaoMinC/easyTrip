package com.example.chen.easygo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Parcelable;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/11 0011.
 */

public class ToActivityUtil {
    /**
     *
     * @Description: 隐式启动,跳转
     * @param packageContext
     * @param action
     *            含操作的Intent
     */
    public static void startActivityIntentSafe(Context packageContext,
                                               Intent action) {
        // Verify it resolves
        PackageManager packageManager = packageContext.getPackageManager();
        List activities = packageManager.queryIntentActivities(action,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;

        // Start an activity if it's safe
        if (isIntentSafe) {
            packageContext.startActivity(action);
        }

    }

    /**
     * @Description: 跳转,带参数的方法;需要其它的数据类型,再继续重载吧,暂时只写这么多吧,意义不大
     * @param packageContext
     * @param cls
     * @param keys
     * @param values  手动改变int[] values类型,可以传递其它数据类型,就不重载了
     */
    public static void toNextActivity(Context packageContext, Class<?> cls,
                                      String[] keys, int[] values) {
        Intent i = new Intent(packageContext, cls);
        for (int j = 0; j < values.length; j++) {
            i.putExtra(keys[j], values[j]);
        }
        packageContext.startActivity(i);

    }

    /**
     * @Description: 跳转
     * @param activity
     *            from,一般传XXXActivity.this
     * @param cls
     *            to,一般传XXXActivity.class
     */
    public static void toNextActivity(Activity activity, Class<?> cls) {
        Intent i = new Intent(activity, cls);
        activity.startActivity(i);
        finish(activity);
    }

    /**
     * @Description: 跳转不关闭
     * @param activity
     *            from,一般传XXXActivity.this
     * @param cls
     *            to,一般传XXXActivity.class
     */
    public static void toNextActivityNoFinish(Activity activity, Class<?> cls) {
        Intent i = new Intent(activity, cls);
        activity.startActivity(i);
    }

    /**
     * @Description: 跳转,带参数的方法;需要其它的数据类型,再继续重载吧
     * @param packageContext
     * @param cls
     * @param keyvalues
     *            需要传进去的String参数{{key1,values},{key2,value2}...}
     */
    public static void toNextActivity(Context packageContext, Class<?> cls,
                                      String[][] keyvalues) {
        Intent i = new Intent(packageContext, cls);
        for (String[] strings : keyvalues) {
            i.putExtra(strings[0], strings[1]);
        }
        packageContext.startActivity(i);
//        ((Activity) packageContext).finish();

    }

    /**
     * @Description: 跳转,带参数的方法;需要其它的数据类型,再继续重载吧
     * @param packageContext
     * @param cls
     * @param keyvalues
     *            需要传进去的String参数{{key1,values},{key2,value2}...}
     */
    public static void toNextActivityArrayList(Context packageContext, Class<?> cls,
                                               String[][] keyvalues, ArrayList checkList,ArrayList problemList) {
        Intent i = new Intent(packageContext, cls);
        for (String[] strings : keyvalues) {
            i.putExtra(strings[0], strings[1]);
        }
//        i.putExtra(AppUtils.CHECK_LIST, checkList);
//        i.putExtra(StringUtils.KEY_PARCELABLE, problemList);
        packageContext.startActivity(i);
//        ((Activity) packageContext).finish();

    }

    public static void toNextActivityObject(Context packageContext,
                                               Class<?> cls,Object object,Object object1) {
        Intent i = new Intent(packageContext, cls);
        i.putExtra("object", (Parcelable) object);
        i.putExtra("object1", (Parcelable) object1);
        packageContext.startActivity(i);

        ((Activity) packageContext).finish();
    }

    public static void finish(Activity activity) {
        activity.finish();
    }
}
