package com.mcs.mframe.sample.testRecyclerView;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.testRecyclerView.adapter.TestRecyclerViewVPAdapter;
import com.mcs.mframe.sample.testRecyclerView.fragment.AnimationUseFragment;
import com.mcs.mframe.sample.testRecyclerView.fragment.EmpViewUseFragment;
import com.mcs.mframe.sample.testRecyclerView.fragment.HeaderAndFooterUseFragment;
import com.mcs.mframe.sample.testRecyclerView.fragment.ItemDragAndSwipeUseFragment;
import com.mcs.mframe.sample.testRecyclerView.fragment.MultipleItemUseFragment;
import com.mcs.mframe.sample.testRecyclerView.fragment.PullToRefreshUseFragment;
import com.mcs.mframe.sample.testRecyclerView.fragment.SectionUseFragment;
import com.mcs.mframe.sample.testRecyclerView.model.HomeItem;
import com.mcs.mframe.ui.activity.ToolbarActivity;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/1/16
 * @changeRecord [修改记录] <br/>
 */

public class TestRecyclerViewActivity extends ToolbarActivity {

    private static final String TAG = TestRecyclerViewActivity.class.getSimpleName();
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TestRecyclerViewVPAdapter mTestRecyclerViewVPAdapter;
    private HomeItem mHomeItems[] = {
            new HomeItem(AnimationUseFragment.TAG ,new AnimationUseFragment()),
            new HomeItem(MultipleItemUseFragment.TAG, new MultipleItemUseFragment()),
            new HomeItem(HeaderAndFooterUseFragment.TAG, new HeaderAndFooterUseFragment()),
            new HomeItem(PullToRefreshUseFragment.TAG, new PullToRefreshUseFragment()),
            new HomeItem(SectionUseFragment.TAG, new SectionUseFragment()),
            new HomeItem(EmpViewUseFragment.TAG, new EmpViewUseFragment()),
            new HomeItem(ItemDragAndSwipeUseFragment.TAG, new ItemDragAndSwipeUseFragment()),
    };

    public static void newInstance(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, TestRecyclerViewActivity.class));
        context.startActivity(intent);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_test_recyclerview;
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

    private void initView() {
        setBarTitle(TAG);
        mViewPager = (ViewPager) findViewById(R.id.tr_view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
    }

    private void initData() {
        mTestRecyclerViewVPAdapter = new TestRecyclerViewVPAdapter(getSupportFragmentManager());
        for (HomeItem homeItem : mHomeItems) {
            mTestRecyclerViewVPAdapter.addTab(homeItem.getFragment(), homeItem.getTitle());
        }

        mViewPager.setAdapter(mTestRecyclerViewVPAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
