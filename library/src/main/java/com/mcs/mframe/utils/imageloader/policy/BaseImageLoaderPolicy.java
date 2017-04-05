package com.mcs.mframe.utils.imageloader.policy;

import com.mcs.mframe.utils.imageloader.ImageLoaderConfiguration;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/4/5
 * @changeRecord [修改记录] <br/>
 */

public abstract class BaseImageLoaderPolicy implements IImageLoaderPolicy{

    protected ImageLoaderConfiguration mImageLoaderConfiguration;

    public BaseImageLoaderPolicy() {
        //初始化默认的加载配置
        mImageLoaderConfiguration = new ImageLoaderConfiguration.Builder().build();
    }
}
