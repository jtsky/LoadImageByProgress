package com.jin.loadimagebyprogress.data;

import android.os.Environment;

import java.io.File;

/**
 * Created by Administrator on 2014/12/29.
 */
public class Constans {
    //imageloader图片SD卡图片缓存路径
    public static final String IMAGE_CACHEPATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "imageloader" + File.separator + "Cache";
}
