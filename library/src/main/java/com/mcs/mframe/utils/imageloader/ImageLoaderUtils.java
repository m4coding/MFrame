package com.mcs.mframe.utils.imageloader;

import android.content.Context;
import android.widget.ImageView;

import com.mcs.mframe.utils.imageloader.policy.BaseImageLoaderPolicy;
import com.mcs.mframe.utils.imageloader.policy.GlideImageLoaderPolicy;
import com.mcs.mframe.utils.imageloader.policy.IImageLoaderPolicy;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/4/5
 * @changeRecord [修改记录] <br/>
 */

public class ImageLoaderUtils implements IImageLoaderPolicy {

    private BaseImageLoaderPolicy mBaseImageLoaderPolicy;

    private static ImageLoaderUtils sInstance;

    private ImageLoaderUtils() {
        //默认使用glide加载策略
        mBaseImageLoaderPolicy = new GlideImageLoaderPolicy();
    }

    public void setImageLoaderPolicy(BaseImageLoaderPolicy imageLoaderPolicy) {
        mBaseImageLoaderPolicy = imageLoaderPolicy;
    }

    @Override
    public void displayImage(String url, ImageView imageView) {
        mBaseImageLoaderPolicy.displayImage(url, imageView);
    }

    @Override
    public void displayImage(String url, int placeholder, ImageView imageView) {
        mBaseImageLoaderPolicy.displayImage(url, placeholder, imageView);
    }

    @Override
    public void displayImage(String url, ImageView imageView, ImageLoaderConfiguration configuration) {
        mBaseImageLoaderPolicy.displayImage(url, imageView, configuration);
    }

    @Override
    public void clearImageDiskCache(Context context) {
        mBaseImageLoaderPolicy.clearImageDiskCache(context);
    }

    @Override
    public void clearImageMemoryCache(Context context) {
        mBaseImageLoaderPolicy.clearImageMemoryCache(context);
    }

    public static ImageLoaderUtils getInstance() {

        if (sInstance == null) {
            synchronized (ImageLoaderUtils.class) {
                if (sInstance == null) {
                    sInstance = new ImageLoaderUtils();
                }
            }
        }

        return sInstance;
    }
}
