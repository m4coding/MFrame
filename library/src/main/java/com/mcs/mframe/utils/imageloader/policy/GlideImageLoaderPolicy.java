package com.mcs.mframe.utils.imageloader.policy;

import android.content.Context;
import android.os.Looper;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.mcs.mframe.utils.imageloader.ImageLoaderConfiguration;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/4/5
 * @changeRecord [修改记录] <br/>
 */

public class GlideImageLoaderPolicy extends BaseImageLoaderPolicy {

    @Override
    public void displayImage(String url, ImageView imageView) {
        displayImage(url, imageView, null);
    }

    @Override
    public void displayImage(String url, int placeholder, ImageView imageView) {
        mImageLoaderConfiguration.setImageResOnDefault(placeholder);
        displayImage(url, imageView, mImageLoaderConfiguration);
    }

    @Override
    public void displayImage(String url, final ImageView imageView, ImageLoaderConfiguration configuration) {

        if (configuration == null) {
            configuration = mImageLoaderConfiguration;
        }

        DrawableRequestBuilder drawableRequestBuilder = Glide.with(imageView.getContext())
                .load(url)
                .placeholder(configuration.getImageResOnDefault())
                .error(configuration.getImageResOnFail())
                .skipMemoryCache(!configuration.isCacheInMemory());

        //是否缓存在本地
        if (!configuration.isCacheOnDisk()) {
            drawableRequestBuilder.diskCacheStrategy( DiskCacheStrategy.NONE);
        }


        if (configuration.getImageLoadingListener() != null) {
            final ImageLoaderConfiguration finalConfiguration = configuration;
            drawableRequestBuilder.listener(new RequestListener<String,GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {

                    //异常回调
                    if (finalConfiguration.getImageLoadingListener() != null) {
                        finalConfiguration.getImageLoadingListener().onLoadingFailed(model, imageView, e);
                    }
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    //资源加载完回调
                    if (finalConfiguration.getImageLoadingListener() != null) {
                        finalConfiguration.getImageLoadingListener().onLoadingComplete(model, imageView);
                    }

                    return false;
                }

            });
        }

        drawableRequestBuilder.into(imageView);

        //资源加载开始回调
        if (configuration.getImageLoadingListener() != null) {
            configuration.getImageLoadingListener().onLoadingStarted(url, imageView);
        }

    }

    @Override
    public void clearImageDiskCache(final Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                //在主线程调用时，应该放在异步线程去clearDiskCache，避免阻塞UI
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(context.getApplicationContext()).clearDiskCache();
                    }
                }).start();
            } else {
                Glide.get(context.getApplicationContext()).clearDiskCache();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearImageMemoryCache(Context context) {
        Glide.get(context.getApplicationContext()).clearMemory();
    }
}
