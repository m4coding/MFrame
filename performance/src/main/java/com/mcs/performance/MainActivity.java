package com.mcs.performance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getWindow().setBackgroundDrawable(null);
        //ViewStub mViewStub = (ViewStub) findViewById(R.id.view_stub);
        //mViewStub.setVisibility(View.VISIBLE);
        //mViewStub.inflate();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    /*try {
                        Thread.sleep(500);
                        for (int i=0; i < 2000;i++) {
                            String string = System.currentTimeMillis() + "";
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/

                    for (int i=0; i < 2000;i++) {
                        String string = System.currentTimeMillis() + "";
                    }
                }
            }
        }).start();
    }
}
