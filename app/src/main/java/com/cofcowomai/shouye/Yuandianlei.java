package com.cofcowomai.shouye;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cofcowomai.R;

public class Yuandianlei extends LinearLayout {
    private int count;//小圆点的数量

    public Yuandianlei(Context context) {
        this(context, null);
    }

    public Yuandianlei(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }
    public void setCount(int count) {
        this.count = count;
        removeAllViews();
        for (int i = 0; i < count; i++) {
            ImageView iv = new ImageView(getContext());
            iv.setImageResource(R.drawable.yuandian);
            addView(iv);//添加一个显示圆点的图片控件
            LinearLayout.LayoutParams params = (LayoutParams) iv.getLayoutParams();
            params.height = 16;
            params.width = 16;
            params.setMargins(10, 0, 0, 0);
            if (i == 0) {
                getChildAt(i).setSelected(true);
                iv.setTag("checked");
            }
        }
    }
    private void init() {
        setGravity(Gravity.CENTER);//控制相对布局里面的控件垂直和水平居中显示
        setOrientation(HORIZONTAL);//设置相对布局 以水平方式排列子控件，还可以设置垂直
        setPadding(0, 12, 0, 12);//设置相对布局的内边距，4个参数代表left，right，top，bottom，分别设置为左边，右边，上，下与子控件的距离
    }
    public void setSelectDot(int index) {
        ImageView iv = (ImageView) findViewWithTag("checked");
        iv.setSelected(false);
        iv.setTag(null);
        if (index >= 0 && index < count) {
            View chil = getChildAt(index);
            chil.setSelected(true);
            chil.setTag("checked");
        }
    }
}