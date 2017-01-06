package com.mcs.mframe.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mcs.mframe.log.MLog;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 懒加载Fragment
 * @created 2017/1/5
 * @changeRecord [修改记录] <br/>
 */

public abstract class LazyFragment extends BaseFragment {

    private boolean mIsVisible = false;//当前Fragment是否可见
    private boolean mIsInitView = false;//是否与View建立起映射关系
    private boolean mIsFirstLoad = true;//是否是第一次加载数据

    private View mConvertView;
    private SparseArray<View> mViews;
    private static boolean DEBUG = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (DEBUG) MLog.i("savedInstanceState==" + savedInstanceState);
        if (mConvertView != null) {
            return mConvertView;
        } else {
            mConvertView = inflater.inflate(getLayoutId(), container, false);
            mViews = new SparseArray<>();
            initView();
            initData();
            mIsInitView = true;
            lazyLoadData();
            return mConvertView;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mViews != null) {
            mViews.clear();
            mViews = null;
        }

        mConvertView = null;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (DEBUG) MLog.i(" isVisibleToUser==" + isVisibleToUser);
        if (isVisibleToUser) {
            mIsVisible = true;
            lazyLoadData();

        } else {
            mIsVisible = false;
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    private void lazyLoadData() {
        if (mIsFirstLoad) {
            if (DEBUG) MLog.i(String.format("the is first time load #mIsInitView==%b #mIsVisible==%b", mIsInitView, mIsVisible));
        } else {
            if (DEBUG) MLog.i(String.format("the is not first time load #mIsInitView==%b #mIsVisible==%b", mIsInitView, mIsVisible));
        }

        if (/*!mIsFirstLoad || */!mIsVisible || !mIsInitView) {
            if (DEBUG) MLog.i("not load");
            return;
        }

        if (mIsFirstLoad) {
            if (DEBUG) MLog.i("Complete the data load for the first time");
            initLazyData();
        } else {
            lazyUpdateData();
        }

        mIsFirstLoad = false;
    }

    /**
     * fragment中可以通过这个方法直接找到需要的view，而不需要进行类型强转
     * @param viewId
     * @param <E>
     * @return
     */
    protected <E extends View> E findView(int viewId) {
        if (mConvertView != null) {
            E view = (E) mViews.get(viewId);
            if (view == null) {
                view = (E) mConvertView.findViewById(viewId);
                mViews.put(viewId, view);
            }
            return view;
        }
        return null;
    }

    /***********抽象方法****************/

    /**
     * 加载页面布局文件
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 让布局中的view与fragment中的变量建立起映射
     */
    protected abstract void initView();

    /**
     * 加载要显示的数据(紧跟着intiView后面执行)
     */
    protected abstract void initData();

    /**
     * 加载要显示的数据(懒加载，即Fragment可见后才进行initLazyData (第一次，只执行一次))
     */
    protected abstract void initLazyData();

    /**
     * 刷新要显示的数据(懒加载，即Fragment可见后才进行 (非第一次执行，执行多次))
     */
    protected abstract void lazyUpdateData();

}
