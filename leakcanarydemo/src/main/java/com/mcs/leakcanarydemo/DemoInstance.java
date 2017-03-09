package com.mcs.leakcanarydemo;

import android.content.Context;
import android.view.View;
import android.widget.Button;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/3/9
 * @changeRecord [修改记录] <br/>
 */

public class DemoInstance {

    private static DemoInstance sInstance;

    private Context mContext;
    private View mView;

    private DemoInstance(Context context) {
        mContext = context;
    }

    public static DemoInstance getInstance(Context context) {
        if (sInstance == null) {
            synchronized(DemoInstance.class) {
                if (sInstance == null) {
                    sInstance =  new DemoInstance(context);
                }
            }
        }

        return sInstance;
    }

    public void setButton(View view) {
        mView = view;
        ((Button)view).setText("setButton");
    }
}
