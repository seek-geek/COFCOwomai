package com.cofcowomai.wodexiaomai;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.cofcowomai.R;
import java.util.ArrayList;
import java.util.List;
import db.DBUserSerivce;
import db.UserName;
public class Yonghuzhuce extends Activity {
    private EditText et;
    private EditText et1;
    private ImageView imgzc;
    private DBUserSerivce dbUserSerivce;
    UserName userName;
    List<UserName> cursor = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kuaisuzhuc);
        dbUserSerivce=new DBUserSerivce(Yonghuzhuce.this);
        et = (EditText) findViewById(R.id.et);
        et1 = (EditText) findViewById(R.id.et1);
        imgzc = (ImageView) findViewById(R.id.imgzc);
        diaj();
    }
    public void diaj() {
        imgzc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  try{*/
                int cha = 0;
                String name = et.getText().toString();
                String pwd = et1.getText().toString();
                if(name.equals("")||pwd.equals("")){
                    Toast.makeText(Yonghuzhuce.this, "用户名或密码不能为空！", Toast.LENGTH_SHORT).show();
                }
                UserName user = new UserName();
                    user.setName(name);
                    user.setPwd(pwd);
                Log.d("=====","====DDD==="+name);
                cha = dbUserSerivce.queryUser(name);//获取验证结果
                Log.d("======","====yyyy==="+cha);
                if (cha == 0){
                    boolean result = dbUserSerivce.addUser(user);//注册结果
                    Log.d("======","===ZZZZZ==="+user);
                    if (result == true){
                        Toast.makeText(Yonghuzhuce.this, "注册成功", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Yonghuzhuce.this,Dengluatvt.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Yonghuzhuce.this, "注册失败", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Yonghuzhuce.this, "该用户名已经存在", Toast.LENGTH_SHORT).show();
                }
          /*  }catch (Exception e){
Log.e("===========","======AAAAAAAAAAA========"+e.toString());
            }*/
            }
        });
    }}
