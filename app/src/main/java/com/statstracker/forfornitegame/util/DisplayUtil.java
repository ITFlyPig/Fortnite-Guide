package com.statstracker.forfornitegame.util;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;


public class DisplayUtil {

    private static WindowManager windowManager;

    private static WindowManager getWindowManager(Context context) {
        if (windowManager == null) {
            windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        }
        return windowManager;
    }

    // 根据手机的分辨率将dp的单位转成px(像素)
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    // 根据手机的分辨率将px(像素)的单位转成dp
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    // 将px值转换为sp值
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    // 将sp值转换为px值
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    // 屏幕宽度（像素）
    public static int getScreenWidth(Context context) {
        DisplayMetrics metric = context.getResources().getDisplayMetrics();
        return metric.widthPixels;
    }

    // 屏幕高度（像素）
    public static int getScreenHeight(Context context) {
        DisplayMetrics metric = context.getResources().getDisplayMetrics();
        return metric.heightPixels;
    }

    public static float getScreenDensity(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager(context).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.density;
        } catch (Throwable e) {
            e.printStackTrace();
            return 1.0f;
        }
    }

    public static int getDensityDpi(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager(context).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.densityDpi;
        } catch (Throwable e) {
            e.printStackTrace();
            return 320;
        }
    }

    /**
     * 获取屏幕的真实高度
     *
     * @param context
     * @return
     */
    public static int getRealHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            display.getRealMetrics(dm);
        } else {
            display.getMetrics(dm);
        }
        int realHeight = dm.heightPixels;
        return realHeight;
    }



}
