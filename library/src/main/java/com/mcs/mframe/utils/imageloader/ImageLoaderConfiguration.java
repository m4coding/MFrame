package com.mcs.mframe.utils.imageloader;

import com.mcs.mframe.utils.imageloader.listener.ImageLoadingListener;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/4/5
 * @changeRecord [修改记录] <br/>
 */

public class ImageLoaderConfiguration {

    //默认loading图
    private  int mImageResOnDefault;
    //错误加载后的显示图
    private  int mImageResOnFail;

    //是否缓存在内存中
    private  boolean mCacheInMemory;
    //是否缓存在本地中
    private  boolean mCacheOnDisk;

    private ImageLoadingListener mImageLoadingListener;

    public ImageLoaderConfiguration(Builder builder) {
        mImageResOnDefault = builder.imageResOnDefault;
        mImageResOnFail = builder.imageResOnFail;
        mCacheInMemory = builder.cacheInMemory;
        mCacheOnDisk = builder.cacheOnDisk;
        mImageLoadingListener = builder.imageLoadingListener;
    }

    public int getImageResOnDefault() {
        return mImageResOnDefault;
    }

    public void setImageResOnDefault(int resOnDefault) {
        mImageResOnDefault = resOnDefault;
    }

    public int getImageResOnFail() {
        return mImageResOnFail;
    }

    public void setImageResOnFail(int resOnFail) {
        mImageResOnFail = resOnFail;
    }

    public boolean isCacheInMemory() {
        return mCacheInMemory;
    }

    public void setCacheInMemory(boolean cacheInMemory) {
        mCacheInMemory = cacheInMemory;
    }

    public boolean isCacheOnDisk() {
        return mCacheOnDisk;
    }

    public void setCacheOnDisk(boolean cacheOnDisk) {
        mCacheOnDisk = cacheOnDisk;
    }

    public ImageLoadingListener getImageLoadingListener() {
        return mImageLoadingListener;
    }

    public void setImageLoadinglistener(ImageLoadingListener imageLoadinglistener) {
        mImageLoadingListener = imageLoadinglistener;
    }


    //builder configuration
    public static class Builder {
        private int imageResOnDefault;
        private int imageResOnFail;
        private boolean cacheInMemory;
        private boolean cacheOnDisk;
        private ImageLoadingListener imageLoadingListener;

        public Builder() {
            this.imageResOnDefault = 0;
            this.imageResOnFail = 0;
            this.cacheInMemory = true;
            this.cacheOnDisk = true;
            this.imageLoadingListener = null;
        }

        public Builder imageResOnDefault(int imageResOnDefault) {
            this.imageResOnDefault = imageResOnDefault;
            return this;
        }

        public Builder imageResOnFail(int imageResOnFail) {
            this.imageResOnFail = imageResOnFail;
            return this;
        }

        public Builder cacheInMemory(boolean cacheInMemory) {
            this.cacheInMemory = cacheInMemory;
            return this;
        }

        public Builder cacheOnDisk(boolean cacheOnDisk) {
            this.cacheOnDisk = cacheOnDisk;
            return this;
        }

        public Builder setListener(ImageLoadingListener imageLoadingListener) {
            this.imageLoadingListener = imageLoadingListener;
            return this;
        }

        public ImageLoaderConfiguration build() {
            return new ImageLoaderConfiguration(this);
        }

    }
}
