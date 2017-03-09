package com.mcs.leakcanarydemo;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/3/9
 * @changeRecord [修改记录] <br/>
 */

public class MyApplication extends Application {

    private RefWatcher mRefWatcher;

    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.mRefWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //如果是LeakCanary的分析进程，则返回，不进行监控内存泄露
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }

        mRefWatcher = LeakCanary.install(this);
    }
}
