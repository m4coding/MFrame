package com.mcs.imageloaderutilsdemo;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mcs.mframe.log.MLog;
import com.mcs.mframe.utils.imageloader.ImageLoaderConfiguration;
import com.mcs.mframe.utils.imageloader.ImageLoaderUtils;
import com.mcs.mframe.utils.imageloader.listener.ImageLoadingListener;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView_1, mImageView_2, mImageView_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView_1 = (ImageView) findViewById(R.id.image_1);
        mImageView_2 = (ImageView) findViewById(R.id.image_2);
        mImageView_3 = (ImageView) findViewById(R.id.image_3);

        load();
    }

    private void load() {
        String url_1 = "http://img3.imgtn.bdimg.com/it/u=1708275648,196699857&fm=214&gp=0.jpg";
        String url_2 = "http://www.mengtu.cc/uploads/allimg/151226/1-1512261ZU1.jpg";
        String url_3 = "http://b-ssl.duitang.com/uploads/blog/201408/16/20140816181213_V5Xwr.gif";
        ImageLoaderUtils.getInstance().displayImage(url_1, mImageView_1);
        ImageLoaderUtils.getInstance().displayImage(url_2, android.R.color.holo_blue_light, mImageView_2);

        ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder()
                .imageResOnDefault(android.R.color.white)
                .imageResOnFail(android.R.color.holo_red_light)
                .cacheInMemory(false)
                .cacheOnDisk(false)
                .setListener(new ImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {
                        MLog.d("imageUri==" + imageUri);
                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view, Exception e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view) {
                        MLog.d("imageUri==" + imageUri);
                    }
                })
                .build();

        ImageLoaderUtils.getInstance().displayImage(url_3, mImageView_3, imageLoaderConfiguration);
    }
}
