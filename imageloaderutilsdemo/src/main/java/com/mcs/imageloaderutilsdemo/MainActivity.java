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
        String url_1 = "http://image.sports.baofeng.com/25a3dbb0c99c5e48e52e60941ed230be";
        String url_2 = "http://image.sports.baofeng.com/19ce5d6ac3b4fff255196f200b1d3079";
        String url_3 = "http://image.sports.baofeng.com/25a3dbb0c99c5e48e52e60941ed230be";
        ImageLoaderUtils.getInstance().displayImage(url_1, mImageView_1);
        ImageLoaderUtils.getInstance().displayImage(url_2, mImageView_2);

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

        ImageLoaderUtils.getInstance().displayImage(url_2, mImageView_3, imageLoaderConfiguration);
    }
}
