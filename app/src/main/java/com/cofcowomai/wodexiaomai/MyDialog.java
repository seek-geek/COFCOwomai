package com.cofcowomai.wodexiaomai;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/12/2.
 */

public class MyDialog extends Dialog {

    private static int default_width = 300;
    private static int default_height = 200;

    public MyDialog(Context context) {
        super(context);
    }

    public MyDialog(Context context, View v, int style) {
        this(context, v, default_height, default_width, style);
    }

    public MyDialog(Context context, View v, int height, int width, int style) {
        super(context, style);
        setContentView(v);//设置视图
        Window window = getWindow();//设置窗口属性
        WindowManager.LayoutParams params = window.getAttributes();
        float density = getDensity(context);
        params.width = (int) (width * density);
        params.height = (int) (height * density);
        params.gravity  = Gravity.CENTER;
        window.setAttributes(params);
    }

    //获取显示密度
    public float getDensity(Context context) {
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        return dm.density;
    }
}
