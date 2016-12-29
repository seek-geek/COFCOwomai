package com.cofcowomai.shouye;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.cofcowomai.R;
import com.cofcowomai.help.Tomcat_Access;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Shangpinxiangqlei extends Fragment {
    private List<Shangpinxiangqinstl> goodList;
    private Shangpinxiangqinstl good ;//用来展示商品详情的对象
    private ImageView good_imageview;
    private TextView tv_good_title;
    private TextView tv_price;
    private View view;
    String goodtype;
    String id;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shangpinxiangqin,null);
        init();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        goodtype = Zhuangshangpinxiagq.good_type;
        id = Zhuangshangpinxiagq.good_id;
        getGoodInfo();//根据ID找到相应的商品
    }

    public void getGoodInfo() {
        OkHttpClient client = new OkHttpClient();
        //创建请求
        final Request request = new Request.Builder()
                .url(Tomcat_Access.TOMCAT_URL_GOODLIST + ".json")//访问全部商品的tomcat
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Request request, IOException e) {
                //请求失败
                Log.d("===", "===请求错误" + e.toString());
            }
            @Override
            public void onResponse(Response response) throws IOException {
                //请求成功
                String name = response.body().string();
                goodList = new ArrayList<Shangpinxiangqinstl>();//商品集合
                try {
                    JSONArray jsonArray = new JSONArray(name);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String good_Type = jsonObject.getString("goodType");//获取商品类型
                        Log.d("第一关",goodtype);
                        //用传过来的商品类型和allgood.json中的商品类型对比，符合即往里面遍历
                        if (good_Type.equals(goodtype)){
                            String list = jsonObject.getString("data");
                            Gson gson = new Gson();
                            goodList = gson.fromJson(list, new TypeToken<List<Shangpinxiangqlei>>() {
                            }.getType());
                            for (int j = 0;j<goodList.size() ; j++){
                                Log.d("第三关", ""+goodList.size());
                                //判断ID 如果符合拿出来
                                if (goodList.get(j).getGoodId().equals(id)){
                                    good = new Shangpinxiangqinstl();//用来展示商品详情的对象
                                    good = goodList.get(j);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ImageLoader.getInstance().displayImage(Tomcat_Access.TOMCAT_URL_GOODLIST+"/"+ good.getGoodPhoto(), good_imageview);
                        tv_good_title.setText(good.getGoodName());
                        tv_price.setText(good.getGoodPrice());
                    }
                });
            }
        });
    }
    private void init() {
        good_imageview = (ImageView) view.findViewById(R.id.good_imageview);
        tv_good_title = (TextView) view.findViewById(R.id.tv_good_title);
        tv_price = (TextView) view.findViewById(R.id.tv_price);
    }
}
