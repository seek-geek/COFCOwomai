package com.cofcowomai.shouye;


import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class Quanjucsh  extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
                ImageLoaderConfiguration imageLoaderConfiguration=new
                ImageLoaderConfiguration.Builder(getApplicationContext()).build();
                ImageLoader.getInstance().init(imageLoaderConfiguration);//全局初始化
    }
}
