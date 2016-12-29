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

public class shipq extends BaseAdapter {
    private Context mContext;//上下文
    private List<Xiansd3> strings;//数据


    public shipq(Context mContext, List<Xiansd3> strings) {//构造函数
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
            convertView = inflater.inflate(R.layout.gridview2, null);
            hellodr = new viewHellodr();
            hellodr.sgjnh = (ImageView) convertView.findViewById(R.id.sgjnh);

            convertView.setTag(hellodr);//保存数据

        } else {
            hellodr = (viewHellodr) convertView.getTag();//取出数据
        }
       // ImageLoader.getInstance().displayImage("http://192.168.43.117:8080/shouye/gridview2/a2.jpg", hellodr.sgjnh);
        ImageLoader.getInstance().displayImage(strings.get(position).getImgUrlr(), hellodr.sgjnh);
        return convertView;//展现数据
    }

    class viewHellodr {
        private ImageView sgjnh;
    }

}
