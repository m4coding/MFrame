package com.mcs.mframe.sample.testLazy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.mcs.mframe.log.MLog;
import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.testLazy.adapter.LazyFragmentAdapter;
import com.mcs.mframe.sample.testLazy.fragment.FirstLazyFragment;
import com.mcs.mframe.sample.testLazy.fragment.FourthLazyFragment;
import com.mcs.mframe.sample.testLazy.fragment.SecondLazyFragment;
import com.mcs.mframe.sample.testLazy.fragment.ThirdLazyFragment;
import com.mcs.mframe.ui.activity.BaseActivity;
import com.mcs.mframe.ui.activity.ToolbarActivity;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/1/5
 * @changeRecord [修改记录] <br/>
 */

public class TestLazyActivity extends ToolbarActivity {

    private static String TAG = TestLazyActivity.class.getSimpleName();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    public static void newInstance(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, TestLazyActivity.class));
        context.startActivity(intent);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_test_lazy;
    }

    @Override
    protected int provideAppBarLayoutId() {
        return R.id.appbar_layout;
    }

    @Override
    protected int provideToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
    }

    protected void initView() {
        //ButterKnife.bind(this);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.lazy_view_pager);

        setBarTitle(TAG);

    }

    protected void initData() {
        LazyFragmentAdapter lazyFragmentAdapter = new LazyFragmentAdapter(getSupportFragmentManager());
        lazyFragmentAdapter.addTab(new FirstLazyFragment(), "FirstLazy");
        lazyFragmentAdapter.addTab(new SecondLazyFragment(), "SecondLazy");
        lazyFragmentAdapter.addTab(new ThirdLazyFragment(), "ThirdLazy");
        lazyFragmentAdapter.addTab(new FourthLazyFragment(), "FourthLazy");
        mViewPager.setAdapter(lazyFragmentAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onToolbarClick() {
        super.onToolbarClick();

        MLog.d("===onToolbarClick");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        MLog.d("====onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }
}
