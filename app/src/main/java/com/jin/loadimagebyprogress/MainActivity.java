package com.jin.loadimagebyprogress;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.github.lzyzsd.circleprogress.DonutProgress;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;


public class MainActivity extends ActionBarActivity {
    private ImageView mImageView;
    private static  final   String IMAGE_URL = "http://f.hiphotos.baidu.com/image/pic/item/7a899e510fb30f245f621e15cb95d143ad4b032f.jpg";
    private  static  final String TAG = "MainActivity";
    private DonutProgress mProgressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.imageview);
        mProgressbar = (DonutProgress) findViewById(R.id.progress);
        imageLoader.displayImage(IMAGE_URL,mImageView,options,new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String s, View view) {
                Log.v(TAG,"onLoadingStarted============>");
                mProgressbar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String s, View view, FailReason failReason) {
                Log.v(TAG,"onLoadingFailed============>");
                mProgressbar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                Log.v(TAG,"onLoadingComplete============>");
                mProgressbar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingCancelled(String s, View view) {
                Log.v(TAG,"onLoadingCancelled============>");
                mProgressbar.setVisibility(View.INVISIBLE);
            }
        },new ImageLoadingProgressListener() {
            //必须设置缓存到disk 否则不调用此接口
            @Override
            public void onProgressUpdate(String s, View view, int current, int total) {
                Log.v(TAG,"progress============>" + (double)current/(double)total);
                double progress = (double)current/(double)total * 100;
                mProgressbar.setProgress((int)progress);
            }
        });




    }


    // Imageloader 初始化配置
    ImageLoader imageLoader = ImageLoader.getInstance();

    DisplayImageOptions options = new DisplayImageOptions.Builder()
            .cacheInMemory(false)
            .cacheOnDisk(true).imageScaleType(ImageScaleType.EXACTLY)
            .displayer(new RoundedBitmapDisplayer(100)).build();



}
