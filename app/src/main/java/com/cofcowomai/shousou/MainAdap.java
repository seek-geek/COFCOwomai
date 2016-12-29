package com.cofcowomai.shousou;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cofcowomai.R;

import java.util.List;


public class MainAdap extends BaseAdapter {
    private Context mContext;//上下文
    private List<String> strings;//数据
    private List<String> jiage;
    public MainAdap(Context mContext, List<String> strings, List<String> jiage) {//构造函数
        this.mContext = mContext;
        this.strings = strings;
        this.jiage = jiage;
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
            convertView = inflater.inflate(R.layout.dami, null);
            hellodr = new viewHellodr();
            hellodr.img = (ImageView) convertView.findViewById(R.id.iv);
            hellodr.tv = (TextView) convertView.findViewById(R.id.tv);
            hellodr.img2 = (ImageView) convertView.findViewById(R.id.iv2);
            hellodr.tv2 = (TextView) convertView.findViewById(R.id.tv2);
            convertView.setTag(hellodr);//保存数据
        } else {
            hellodr = (viewHellodr) convertView.getTag();//取出数据
        }
        hellodr.tv.setText(strings.get(position));//赋值
        hellodr.tv2.setText(jiage.get(position));
        return convertView;//展现数据
    }
    class viewHellodr {
        public ImageView img;
        public TextView tv;
        public ImageView img2;
        public TextView tv2;
    }

}
