package com.cofcowomai.wodexiaomai;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.cofcowomai.R;

/**
 * Created by Administrator on 2016/12/26.
 */
public class MyRelatedItemView extends FrameLayout {

    public MyRelatedItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MyRelatedItemView(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.view_my_related_item, this);
        View leftLine = findViewById(R.id.left_line);
        View rightLine = findViewById(R.id.right_line);
        ImageView ivMyIcon = (ImageView) findViewById(R.id.iv_my_icon);
        TextView tvMyText = (TextView) findViewById(R.id.tv_my_text);
        if(attrs != null){
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyRelatedItemView);
            boolean rightLineVisible = ta.getBoolean(R.styleable.MyRelatedItemView_rightLineVisible, false);
            boolean leftLineVisible = ta.getBoolean(R.styleable.MyRelatedItemView_leftLineVisible, false);
            int resIcon = ta.getResourceId(R.styleable.MyRelatedItemView_myRelatedIcon, 0);
            String resText = ta.getString(R.styleable.MyRelatedItemView_myRelatedText);
            if(leftLineVisible)leftLine.setVisibility(VISIBLE);
            if(rightLineVisible)rightLine.setVisibility(VISIBLE);
            ivMyIcon.setImageResource(resIcon);
            tvMyText.setText(resText);
            ta.recycle();
        }
    }
}
