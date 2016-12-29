package com.cofcowomai.shouye;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cofcowomai.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class Shangspq extends BaseAdapter {
    private Context mContext;//上下文
    private List<Xiansd2> stringe;//数据


    public Shangspq(Context mContext, List<Xiansd2> stringe) {//构造函数
        this.mContext = mContext;
        this.stringe = stringe;

    }
    @Override
    public int getCount() {

        return stringe.size();//获取数据个数
    }
    @Override
    public Object getItem(int position) {
        return stringe.get(position);//条目的对象
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
            convertView = inflater.inflate(R.layout.shangpinlb, null);
            hellodr = new viewHellodr();
            hellodr.imgs = (ImageView) convertView.findViewById(R.id.ivs);
            hellodr.tvs = (TextView) convertView.findViewById(R.id.tvs);
            hellodr.tvs2 = (TextView) convertView.findViewById(R.id.tvs2);
            convertView.setTag(hellodr);//保存数据
        } else {
            hellodr = (viewHellodr) convertView.getTag();//取出数据
        }
        hellodr.tvs.setText(stringe.get(position).getGoodName());//赋值
hellodr.tvs2.setText(stringe.get(position).getGoodPrice());
        ImageLoader.getInstance().displayImage(stringe.get(position).getGoodPhoto(),hellodr.imgs);
        return convertView;//展现数据
    }
    class viewHellodr {
        public ImageView imgs;
        public TextView tvs;
        public TextView tvs2;
    }

}
