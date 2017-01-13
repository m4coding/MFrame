package com.mcs.mframe.sample.testLazy.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mcs.mframe.log.MLog;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/1/5
 * @changeRecord [修改记录] <br/>
 */

public class FirstLazyFragment extends BaseTestLazyFragment{

    private static String TAG = FirstLazyFragment.class.getSimpleName();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MLog.d("====onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStop() {
        MLog.d("====onStop");
        super.onStop();
    }

    @Override
    public void onStart() {
        MLog.d("====onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        MLog.d("====onResume");
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        MLog.d("====onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        MLog.d("====onDestroy");
        super.onDestroy();
    }

    @Override
    protected void initLazyData() {
        super.initLazyData();
        produceData(TAG, 100000);
    }

    @Override
    protected void onSwipeRefresh() {
        super.onSwipeRefresh();
        MLog.d("=====onRefresh");
        produceData(TAG, 10);
    }
}
