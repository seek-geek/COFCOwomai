package com.cofcowomai.wodexiaomai;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class Dhl extends Dialog {

    private static final int kuan = 150;
    private static final int gao = 150;

    public Dhl(Context context) {

        super(context);
    }
    public Dhl(Context context, View view, int style) {
        super(context, style);
        setContentView(view);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        float v = density(context);
        params.width = (int) (kuan * v);
        params.height = (int) (gao * v);
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
    }
    private float density(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return metrics.density;
    }

}
