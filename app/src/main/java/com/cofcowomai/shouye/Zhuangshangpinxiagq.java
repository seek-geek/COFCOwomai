package com.cofcowomai.shouye;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cofcowomai.R;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品详情页面
 * Created by Administrator on 2016/12/9.
 */

public class Zhuangshangpinxiagq extends FragmentActivity {
    private Shangpinpinjialei shangpinpinjialei;//商品评价碎片
    private Shangpinxiangqlei shangpinxiangqlei;//商品详情碎片
    private List<Fragment> list = new ArrayList<>();//装碎片的集合
    private ViewPager vp;
    private  View good_view;
    private View appraise_view;
    private Intent intent;
    private TextView tv_collection;
    static String good_id;
    static String goodPhoto;
    static String goodName;
    static String goodDescribe;
    static String goodWeight;
    static String goodIntegral;
    static String goodPlateType;
    static String goodNum;
    static String goodPrice;
    static String good_type;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shangpinxiangqindibu);
        init();
        shangpinpinjialei = new Shangpinpinjialei();
        shangpinxiangqlei = new Shangpinxiangqlei();
        list.add(shangpinxiangqlei);
        list.add(shangpinpinjialei);
        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(),list,Zhuangshangpinxiagq.this);
          vp.setAdapter(vpAdapter);
       /*  Bundle bundle = getIntent().getExtras();
        good_id = bundle.getString("goodId");//商品ID
        goodPhoto=bundle.getString("goodPhoto");//商品图片
       goodName =bundle.getString("goodName");//商品名
        goodDescribe =bundle.getString("goodDescribe");
        goodPrice=bundle.getString("goodPrice");
        good_type = bundle.getString("goodType");
        goodNum =bundle.getString("goodNum");
        goodWeight =bundle.getString("goodWeight");
        goodIntegral =bundle.getString("goodIntegral");
        goodPlateType =bundle.getString("goodPlateType");
       Log.d("====","===QQQQ==="+good_id   +goodPhoto   +goodName   +goodPrice   +good_type);*/

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    /*public void love(View v){
        int i ;
        if (i==0
                ){
//            tv_collection.setCompoundDrawables(null,getResources().getDrawable(R.mipmap.icon_collection_selected),null,null);
//            tv_collection.setTextColor(getResources().getColor(R.color.alpha));
            tv_collection.setText("dsafdsa");
            i = 1;
        }else {
            tv_collection.setCompoundDrawables(null,getResources().getDrawable(R.mipmap.icon_collection_normal),null,null);
            i = 0;
        }
    }*/

    //装页面的容器（或适配器）
    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> list;
        private Context context;

        public ViewPagerAdapter(FragmentManager fm, List<Fragment> list, Context context) {
            super(fm);
            this.list = list;
            this.context = context;
        }

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return list.get(position);

        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public void finishUpdate(ViewGroup container) {
            if (vp.getCurrentItem() == 0){
                good_view.setVisibility(View.VISIBLE);
                appraise_view.setVisibility(View.GONE);
            }else {
                good_view.setVisibility(View.GONE);
                appraise_view.setVisibility(View.VISIBLE);
            }
            super.finishUpdate(container);
        }
    }

    //初始化控件
    public void init(){
        vp = (ViewPager) findViewById(R.id.vp);


        good_view =findViewById(R.id.good_view);
        appraise_view =findViewById(R.id.appraise_view);
        tv_collection = (TextView) findViewById(R.id.tv_collection);
    }

    public void to_layout(View v){
        switch(v.getId()){
            case R.id.tv_good:
                vp.setCurrentItem(0);
                break;
            case R.id.tv_appraise:
                vp.setCurrentItem(1);
                break;
            case R.id.tv_shopcar:
                intent = new Intent(Zhuangshangpinxiagq.this,Gouwuche2.class);
                startActivity(intent);
                break;
        }

    }
}
