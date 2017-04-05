package com.mcs.mframe.utils.imageloader.policy;

import android.content.Context;
import android.widget.ImageView;

import com.mcs.mframe.utils.imageloader.ImageLoaderConfiguration;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/4/5
 * @changeRecord [修改记录] <br/>
 */

public interface IImageLoaderPolicy {

    //无占位图
    void displayImage(String url, ImageView imageView);

    /**
     *
     * @param url
     * @param placeholder (默认占位图)
     * @param imageView
     */
    void displayImage(String url, int placeholder, ImageView imageView);

    void displayImage(String url, ImageView imageView, ImageLoaderConfiguration configuration);

    //清除硬盘缓存
    void clearImageDiskCache(Context context);

    //清除内存缓存
    void clearImageMemoryCache(Context context);
}
