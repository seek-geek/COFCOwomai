package com.cofcowomai.shouye;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.cofcowomai.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class Shipq2 extends BaseAdapter{
    private Context mContext;//上下文
    private List<Xiansd> strings;//数据


    public Shipq2(Context mContext, List<Xiansd> strings) {//构造函数
        this.mContext = mContext;
        this.strings = strings;
    }

    @Override
    public int getCount() {
        return strings.size();//获取数据个数
    }

    @Override
    public Object getItem(int position) {
        return strings.get(position);//条目的对象
    }

    @Override
    public long getItemId(int position) {
        return position;//条目的id
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHellodr hellodr = null;
        if (convertView == null) {//判断不为空，只加载一次
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.gridview3, null);
            hellodr = new viewHellodr();
            hellodr.iv1 = (ImageView) convertView.findViewById(R.id.iv1);

            convertView.setTag(hellodr);//保存数据

        } else {
            hellodr = (viewHellodr) convertView.getTag();//取出数据
        }
        ImageLoader.getInstance().displayImage(strings.get(position).getImgUrl(), hellodr.iv1);
        return convertView;//展现数据
    }

    class viewHellodr {
        private ImageView iv1;
    }

}
