package com.mcs.mframe.utils.imageloader.listener;

import android.graphics.Bitmap;
import android.view.View;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/4/5
 * @changeRecord [修改记录] <br/>
 */

public class SimpleImageLoadingListener implements ImageLoadingListener {

    @Override
    public void onLoadingStarted(String imageUri, View view) {
        //空实现
    }

    @Override
    public void onLoadingFailed(String imageUri, View view, Exception e) {
        //空实现
    }

    @Override
    public void onLoadingComplete(String imageUri, View view) {
        //空实现
    }
}
