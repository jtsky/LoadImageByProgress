package com.jin.loadimagebyprogress.app;

import android.app.Application;
import android.content.Context;

import com.jin.loadimagebyprogress.data.Constans;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;


public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader(getApplicationContext());

    }

    // 初始化ImageLoader
    public static void initImageLoader(Context context) {

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .discCache(new UnlimitedDiscCache(new File(Constans.IMAGE_CACHEPATH)))
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .threadPoolSize(3)
                .memoryCache(new UsingFreqLimitedMemoryCache(2000000))
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
        ImageLoader.getInstance().init(config);
    }


}
