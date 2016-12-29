package com.cofcowomai.shouye;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.cofcowomai.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Tupiangd extends Activity {
    private ViewPager viewPager;
    private Yuandianlei dotView;
    List<Xiansd> list = new ArrayList<>();
    List<Xiansd3> list2 = new ArrayList<>();

    private GridView gvs;
    private ImageView iv1;
    private GridView gvss;

    private int tp[] = new int[]
            {R.mipmap.a1, R.mipmap.hua2, R.mipmap.hua3, R.mipmap.hua4, R.mipmap.hua5, R.mipmap.hua6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shouye);
        viewPager = (ViewPager) findViewById(R.id.vp_head);
        dotView = (Yuandianlei) findViewById(R.id.views);
        dotView.setCount(tp.length);
        iv1 = (ImageView) findViewById(R.id.iv1);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                dotView.setSelectDot(position);//圆点对象调用了里面选择圆点的方法
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        inkmd();
        zs();
        okhttp();
        okhttp2();

    }

    private void inkmd() {
        viewPager = (ViewPager) findViewById(R.id.vp_head);
        List<ImageView> ivList = new ArrayList<>();//初始化图片集合
        for (int i = 0; i < tp.length; i++) {
            ImageView iv = new ImageView(this);//生成ImageView对象
            iv.setScaleType(ImageView.ScaleType.FIT_XY);//设置图片铺满控件
            iv.setImageResource(tp[i]);//数组图片显示
            ivList.add(iv);//添加到集合
        }
        viewPager.setAdapter(new Tugdspq(ivList));//适配器Tugdspq类

        Timer timer = new Timer();
        final Handler handler = new Handler(Looper.getMainLooper());
        timer.schedule(new TimerTask() {
            int indext = -1;//从0开始-1+1等于0

            @Override
            public void run() {//
                indext++;
                if (indext >= tp.length) {
                    indext = 0;
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        viewPager.setCurrentItem(indext);
                    }
                });
            }
        }, 3000, 3000);//第一个参数了是第一次进去多久播放，第二个参数是以后每隔多久播放
    }

    public void zs() {
        gvs = (GridView) findViewById(R.id.gvs);
        gvss = (GridView) findViewById(R.id.gvss);

    }

    /**
     * 网络请求
     */
    private void okhttp() {
        OkHttpClient client = new OkHttpClient();//初始化框架
        Request request = new Request.Builder()
                .url("http://192.168.43.117:8080/shouye/gridview2/gv3.json")//42.142
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                //请求失败
            }

            @Override
            public void onResponse(Response response) throws IOException {
                //请求成功
                final String str = response.body().string();
                Log.d("=====", "===BBBB===" + str);
                Gson gson = new Gson();

                list = gson.fromJson(str, new TypeToken<List<Xiansd>>() {
                }.getType());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Shipq2 adap = new Shipq2(Tupiangd.this, list);
                        Log.d("======", "===CCCC===" + str);
                        gvss.setAdapter(adap);
                    }
                });
            }
        });
    }

    private void okhttp2() {
        OkHttpClient client = new OkHttpClient();//初始化框架
        Request request = new Request.Builder()
                .url("http://192.168.43.117:8080/shouye/gridview/gv2.json")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                //请求失败
            }

            @Override
            public void onResponse(Response response) throws IOException {
                //请求成功
                final String str = response.body().string();
                Log.d("=====", "===AAAA===" + str);
                Gson gson = new Gson();
                list2 = gson.fromJson(str, new TypeToken<List<Xiansd3>>() {
                }.getType());
                final shipq adap = new shipq(Tupiangd.this, list2);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gvs.setAdapter(adap);

                    }
                });
                gvs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent =new Intent(Tupiangd.this,Shangpinxianshi.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }
}
