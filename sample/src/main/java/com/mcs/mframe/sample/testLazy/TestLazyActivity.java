package com.mcs.mframe.sample.testLazy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.mcs.mframe.log.MLog;
import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.R2;
import com.mcs.mframe.sample.testLazy.adapter.LazyFragmentAdapter;
import com.mcs.mframe.sample.testLazy.fragment.FirstLazyFragment;
import com.mcs.mframe.sample.testLazy.fragment.FourthLazyFragment;
import com.mcs.mframe.sample.testLazy.fragment.SecondLazyFragment;
import com.mcs.mframe.sample.testLazy.fragment.ThirdLazyFragment;
import com.mcs.mframe.ui.activity.BaseActivity;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/1/5
 * @changeRecord [修改记录] <br/>
 */

public class TestLazyActivity extends BaseActivity {

    TabLayout mTabLayout;
    ViewPager mViewPager;

    public static void newInstance(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, TestLazyActivity.class));
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_test_lazy);
        //ButterKnife.bind(this);
        mTabLayout = (TabLayout) findViewById(R.id.lazy_tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.lazy_view_pager);
    }

    @Override
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
    protected void onSaveInstanceState(Bundle outState) {
        MLog.d("====onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }
}
