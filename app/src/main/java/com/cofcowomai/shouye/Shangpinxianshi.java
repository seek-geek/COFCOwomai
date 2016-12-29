package com.cofcowomai.shouye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.cofcowomai.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Shangpinxianshi extends FragmentActivity{
    List<Xiansd2> list = new ArrayList<>();
    private GridView gvlb;
    private List<Shangpinxiangqinstl> goodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        gvlb = (GridView) findViewById(R.id.gvlb);
        gvlb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(Shangpinxianshi.this,Zhuangshangpinxiagq.class);
             /*   if(position < goodList.size()){

                    Bundle bundle = new Bundle();
                    bundle.putString("goodId", goodList.get(position).getGoodId());//商品id
                    bundle.putString("goodPhoto", goodList.get(position).getGoodPhoto());//商品图片
                    bundle.putString("goodName", goodList.get(position).getGoodName());//商品名
                    bundle.putString("goodPrice", goodList.get(position).getGoodPrice());//商品价格
                    bundle.putString("goodDescribe", goodList.get(position).getGoodDescribe());
                    bundle.putString("goodNum", goodList.get(position).getGoodNum());
                    bundle.putString("goodWeight", goodList.get(position).getGoodWeight());
                    bundle.putString("goodIntegral", goodList.get(position).getGoodIntegral());
                    bundle.putString("goodPlateType", goodList.get(position).getGoodPlateType());
                    bundle.putString("goodType", goodList.get(position).getGoodType());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }*/
            }
        });
        okhttp();
    }
    private void okhttp() {
        OkHttpClient client = new OkHttpClient();//初始化框架
        Request request = new Request.Builder()
                .url("http://192.168.43.117:8080/shouye/index_Data/goodList_Data/FruitGoodList.json")
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

                Log.d("=====","===BBBB==="+str);
                Gson gson = new Gson();
                list = gson.fromJson(str, new TypeToken<List<Xiansd2>>() {
                }.getType());
                goodList = gson.fromJson(str, new TypeToken<List<Shangpinxiangqinstl>>() {
                }.getType());
                final Shangspq adap = new Shangspq(Shangpinxianshi.this, list);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gvlb.setAdapter(adap);
                    }
                });
            }
        });
    }

}
