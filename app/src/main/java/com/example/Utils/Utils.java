package com.example.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.example.loginapplication.R;

public class Utils {
    private static int ScreenRealWidth;
    private static int ScreenRealHeight;
    private static int ScreenCanUseWidth;
    private static int ScreenCanUseHeight;
    private static final String TAG = "Utils";

    //获取屏幕实际分辨率宽度,高度
    public static void RealScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point mPoint = new Point();
        wm.getDefaultDisplay().getRealSize(mPoint);
        //屏幕实际宽度（像素个数）
        ScreenRealWidth = mPoint.x;
        ScreenRealHeight = mPoint.y;
        Log.d(TAG, "屏幕实际宽度: "+mPoint.x);
        Log.d(TAG, "屏幕实际GAO度: "+mPoint.y);
    }

    //获取屏幕可用分辨率高度
    public static void CanUsedScreenSize(Context context){

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        //屏幕可用宽度(像素个数)
        ScreenCanUseWidth = point.x;
        //屏幕可用高度(像素个数)
        ScreenCanUseHeight = point.y;
        Log.d(TAG, "屏幕可用宽度: "+point.x);
        Log.d(TAG, "屏幕可用高度: "+point.y);

       // Log.d(TAG, "width = " + rect.width() + " height = " + rect.height());

    }

    public static void setStatusBarColor(Activity activity){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);

            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);//设置状态栏颜色
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//实现状态栏图标和文字颜色为暗色
        }
    }

    //状态栏高度
    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        Log.d(TAG, "getStatusBarHeight: height" + height);
        return height;
    }

    public static void setTabPaddingTop(Context context, View view){
        int height = getStatusBarHeight(context);
        view.setPadding(0,height,0,0);
    }

}
