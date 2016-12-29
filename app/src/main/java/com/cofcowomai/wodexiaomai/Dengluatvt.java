package com.cofcowomai.wodexiaomai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cofcowomai.R;
import com.cofcowomai.shouye.Five;
import com.cofcowomai.shouye.Five2;
import com.cofcowomai.shouye.Four;

import java.util.ArrayList;
import java.util.List;

import db.DBUserSerivce;
import db.UserName;


public class Dengluatvt extends Activity {

    private EditText ed1;
    private EditText ed2;
    private TextView btn1_1;
    private TextView btn2_1;
    private Intent intent;
    private ImageView login_btn;
    private View v;
    private DBUserSerivce dbUserSerivce ;
    private Button ok_btn;
    private MyDialog dialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denglu);

        ikk();
        puanduan();
        zhuc();
    }

    public void ikk() {
        ed1 = (EditText) findViewById(R.id.edit1);
        ed2 = (EditText) findViewById(R.id.edit2);
        btn1_1 = (TextView) findViewById(R.id.btn1_1);
        btn2_1=(TextView)findViewById(R.id.btn2_1);
        dbUserSerivce=new DBUserSerivce(getApplicationContext());
    }
public void zhuc(){
    btn2_1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(Dengluatvt.this,Yonghuzhuce.class);
            startActivity(intent);
        }
    });

}
    public void puanduan() {
        btn1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed1.getText().length() != 0 || ed2.getText().length() != 0) {
                    Log.d("=====","===已经进来了==");
                    String name = ed1.getText().toString();
                    String pwd = ed2.getText().toString();
                    Log.d("=====","====MMMM==="+name);
                    Log.d("=====","===LLLL==="+pwd);
                    List<UserName> list = new ArrayList<>();
                    list =dbUserSerivce.queryUserqb();
                    for (int i = 0; i<list.size();i++){
                        Log.d("==用户名",list.get(i).getName());
                        Log.d("==密码",list.get(i).getPwd());
                    }
                    int result = dbUserSerivce.queryUser2(name,pwd);//把用户名和密码传进去数据库验证，1为存在即登录成功，0为失败。
                    if (result == 1) {
                        Toast.makeText(Dengluatvt.this,"登录成功", Toast.LENGTH_SHORT).show();
                        Bundle bundle = new Bundle();
                        bundle.putString("name",name);
                        intent = new Intent();
                        intent.putExtras(bundle);
                        intent.setClass(Dengluatvt.this,Five2.class);
                        startActivity(intent);
                    }else{
                        LayoutInflater inf = getLayoutInflater();
                        v = inf.inflate(R.layout.shib, null);
                        ok_btn= (Button) v.findViewById(R.id.sbqd);
                        dialog = new MyDialog(Dengluatvt.this, v, R.style.DialogTheme);
                        dialog.show();
                        ok_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });
                    }
                } else {
                    Toast.makeText(Dengluatvt.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
