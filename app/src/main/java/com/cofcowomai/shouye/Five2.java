package com.cofcowomai.shouye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cofcowomai.R;
import com.cofcowomai.wodexiaomai.Dengluatvt;
import com.cofcowomai.wodexiaomai.Shezhijiemian;

public class Five2 extends AppCompatActivity {
private TextView dianji2;
    private ImageView sz;
    private RelativeLayout null_layout;
    private LinearLayout have_layout;
    private TextView tv_uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wodexiaomai2);
        dian();
        tiao();
        tiao2();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Bundle bundle = this.getIntent().getExtras();
        if (bundle !=null){
            dianji2.setVisibility(View.GONE);
            have_layout.setVisibility(View.VISIBLE);
            String username = bundle.getString("name");
            tv_uname.setText(username);
        }
    }

    public void dian(){
        dianji2=(TextView)findViewById(R.id.dianji2);
        sz=(ImageView)findViewById(R.id.se);
        tv_uname = (TextView) findViewById(R.id.tv_uname);
        null_layout = (RelativeLayout) findViewById(R.id.one);
        have_layout = (LinearLayout) findViewById(R.id.have_layout);
    }
    public  void tiao(){
        dianji2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Five2.this, Dengluatvt.class);
                startActivity(intent);
            }
        });

    }
    public  void tiao2(){
        sz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Five2.this, Shezhijiemian.class);
                startActivity(intent);
            }
        });

    }
}
