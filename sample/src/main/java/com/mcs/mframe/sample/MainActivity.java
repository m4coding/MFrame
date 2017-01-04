package com.mcs.mframe.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mcs.mframe.log.MLog;
import com.mcs.mframe.log.base.MLogConstant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMLogTest(View view) {
        MLog.MLogConfig config = new MLog.MLogConfig()
                .setGlobalTag("MainActivity")
                .setLog2File(true)
                .setLog2FileName("test.log")
                .setLog2FilePath(getApplicationContext().getCacheDir().getAbsolutePath());
        MLog.init(config);
        MLog.v("=====onMLogTest click verbose");
        MLog.d("=====onMLogTest click debug");
        MLog.i("=====onMLogTest click info");
        MLog.w("=====onMLogTest click warn");
        MLog.e("=====onMLogTest click error");
        MLog.a("=====onMLogTest click assert");

        //过滤设置
        MLog.MLogConfig config2 = new MLog.MLogConfig()
                .setGlobalTag("MainActivity")
                .setLog2File(true)
                .setLog2FileName("test.log")
                .setLog2FilePath(getApplicationContext().getCacheDir().getAbsolutePath())
                .setLogFilter(MLogConstant.INFO);
        MLog.init(config2);

        MLog.v("=====onMLogTest click filter verbose");
        MLog.d("=====onMLogTest click filter debug");
        MLog.i("=====onMLogTest click filter info");
        MLog.w("=====onMLogTest click filter warn");
        MLog.e("=====onMLogTest click filter error");
        MLog.a("=====onMLogTest click filter assert");

    }
}
