package com.cofcowomai.shouye;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;
public class Tugdspq extends PagerAdapter {//适配器
    private List<ImageView> mListViews;
    public Tugdspq( List<ImageView> mListViews) {
        this.mListViews = mListViews;
    }
    @Override
    public void destroyItem(ViewGroup container, int position , Object object) {
        container.removeView(mListViews.get(position));
    }
    @Override
    public Object instantiateItem(ViewGroup container,int position) {
        container.addView(mListViews.get(position),0);
        return mListViews.get(position);
    }
    @Override
    public int getCount() {
        return mListViews.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }


}
