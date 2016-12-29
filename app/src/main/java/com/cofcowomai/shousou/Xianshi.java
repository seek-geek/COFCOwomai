package com.cofcowomai.shousou;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cofcowomai.R;

import java.util.ArrayList;
import java.util.List;

public class Xianshi extends AppCompatActivity {

    private ListView lv;
    private List<String> strings = new ArrayList<>();
    private List<String> jiage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        lv = (ListView) findViewById(R.id.lv);
        list();
        jiage();
        MainAdap adap = new MainAdap(Xianshi.this, strings, jiage);
        lv.setAdapter(adap);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("==", "==ListView==" + parent);
            }
        });
    }

    private void list() {
        strings.add("[2016年新米]中粮除开基金");
        strings.add("[2016年新米]读书大红花熟地黄");
        strings.add("[2016年新米]撒大声读活动和");
        strings.add("[2016年新米]大刀记华盛顿");
        strings.add("[2016年新米]的维萨读书的会");
        strings.add("[2016年新米]大话毒害的萨达");
        strings.add("[2016年新米]大树华盛顿");
        strings.add("[2016年新米]的撒个地告诉胡霍党");
        strings.add("[2016年新米]阿萨德巴士看都不看");
        strings.add("[2016年新米]撒旦光束灯");
        for (int i = 1; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }



    }
    public void jiage(){
        jiage.add("零售价：￥10.00");
        jiage.add("零售价：￥20.00");
        jiage.add("零售价：￥30.00");
        jiage.add("零售价：￥40.00");
        jiage.add("零售价：￥50.00");
        jiage.add("零售价：￥60.00");
        jiage.add("零售价：￥70.00");
        jiage.add("零售价：￥80.00");
        jiage.add("零售价：￥90.00");
        jiage.add("零售价：￥100.00");

        for (int i = 1; i < jiage.size(); i++) {
            System.out.println(jiage.get(i));
        }
    }

}
