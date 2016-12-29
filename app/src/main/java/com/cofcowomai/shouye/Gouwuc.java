package com.cofcowomai.shouye;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cofcowomai.R;

public class Gouwuc extends Activity{
    private ImageView tvqjs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gwcaa);
        tvqjs=(ImageView)findViewById(R.id.tvqjs);
        tvqjs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Gouwuc.this,Dingdanqr.class);
                startActivity(intent);
            }
        });
    }
}
