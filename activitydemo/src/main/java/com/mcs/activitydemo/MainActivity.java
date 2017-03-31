package com.mcs.activitydemo;

import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mcs.mframe.log.MLog;

public class MainActivity extends AppCompatActivity {

    private static final String DATA_SAVE = "data_save";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MLog.d("savedInstanceState ==" + savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            String value = savedInstanceState.getString(DATA_SAVE);
            MLog.d("value ==" + value);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        MLog.d("newConfig==" + newConfig);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        MLog.d("savedInstanceState==" + savedInstanceState);
        String value = savedInstanceState.getString(DATA_SAVE);
        MLog.d("value ==" + value);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        MLog.d("outState==" + outState);
        outState.putString(DATA_SAVE, "test");
    }

    @Override
    protected void onStart() {
        super.onStart();
        MLog.d("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        MLog.d("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        MLog.d("onResume");

        mHandler.sendEmptyMessageDelayed(1, 500);
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 1:
                    MLog.d("1");
                    test();
                    mHandler.sendEmptyMessageDelayed(1, 500);
                    break;
                default:
                break;
            }
        }
    };

    private void test() {
        for(int i = 0; i < 1000000; i++) {

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        MLog.d("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        MLog.d("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MLog.d("onDestroy");
    }
}
