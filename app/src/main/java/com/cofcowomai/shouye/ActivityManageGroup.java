package com.cofcowomai.shouye;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.cofcowomai.R;

public class ActivityManageGroup extends ActivityGroup implements View.OnClickListener {
    private LinearLayout activityGroupLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_layout);
        activityGroupLayout = (LinearLayout) findViewById(R.id.group);
        init();
        switchActivity("shouyeActivity", Tupiangd.class);
    }
    private void init() {
        findViewById(R.id.iv_shouye).setOnClickListener(this);
        findViewById(R.id.iv_soushuo).setOnClickListener(this);
        findViewById(R.id.iv_fenlei).setOnClickListener(this);
        findViewById(R.id.iv_guowuc).setOnClickListener(this);
        findViewById(R.id.iv_wodexiaom).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_shouye:
                switchActivity("shouyeActivity", Tupiangd.class);
                break;
            case R.id.iv_soushuo:
                switchActivity("soushuoActivity" ,Two.class);
                break;
            case R.id.iv_fenlei:
                switchActivity("soushuoActivity" ,Three.class);
                break;
            case R.id.iv_guowuc:
                switchActivity("soushuoActivity" ,Four.class);
                break;
            case R.id.iv_wodexiaom:
                switchActivity("soushuoActivity" ,Five2.class);
                break;
        }
    }
    /**
     * 切换Activity
     * @param id
     * @param activityClass
     */
    private void switchActivity(String id, Class<?> activityClass) {
        activityGroupLayout.removeAllViews();
        Intent intent =  new Intent(ActivityManageGroup.this, activityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        Window window = getLocalActivityManager().startActivity(id, intent);
        View view = window.getDecorView();
        activityGroupLayout.addView(view);
    }
}
