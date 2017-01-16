package com.mcs.mframe.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mcs.mframe.log.MLog;
import com.mcs.mframe.log.base.MLogConstant;
import com.mcs.mframe.sample.testLazy.TestLazyActivity;
import com.mcs.mframe.sample.testRecyclerView.TestRecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    private static String XML =
            "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
            "    android:id=\"@+id/activity_main\"\n" +
            "    android:layout_width=\"match_parent\"\n" +
            "    android:layout_height=\"match_parent\"\n" +
            "    android:paddingBottom=\"@dimen/activity_vertical_margin\"\n" +
            "    android:paddingLeft=\"@dimen/activity_horizontal_margin\"\n" +
            "    android:paddingRight=\"@dimen/activity_horizontal_margin\"\n" +
            "    android:paddingTop=\"@dimen/activity_vertical_margin\"\n" +
            "    tools:context=\"com.mcs.mframe.sample.MainActivity\"\n" +
            "    android:orientation=\"vertical\">\n" +
            "</LinearLayout>";

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

        MLog.i(getString(R.string.json));
        MLog.json(MLogConstant.INFO, getString(R.string.json));

        MLog.xml(MLogConstant.INFO, "test xml");
        MLog.xml(MLogConstant.INFO, XML);
    }

    public void onLazyFragmentTest(View view) {
        TestLazyActivity.newInstance(this);
    }

    public void onRecyclerViewAdapterTest(View view) {
        TestRecyclerViewActivity.newInstance(this);
    }
}
