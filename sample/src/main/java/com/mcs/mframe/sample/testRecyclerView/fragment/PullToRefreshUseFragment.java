package com.mcs.mframe.sample.testRecyclerView.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.mcs.mframe.log.MLog;
import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.testRecyclerView.adapter.PullToRefreshUseAdapter;
import com.mcs.mframe.sample.testRecyclerView.model.DataFactory;
import com.mcs.mframe.ui.fragment.LazyFragment;
import com.mcs.mframe.ui.recyclerview.BaseQuickAdapter;
import com.mcs.mframe.ui.recyclerview.listener.OnItemChildClickListener;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 下拉刷新、加载更多示例
 * @created 2017/2/27
 * @changeRecord [修改记录] <br/>
 */

public class PullToRefreshUseFragment extends LazyFragment {

    public static final String TAG = PullToRefreshUseFragment.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private PullToRefreshUseAdapter mAdapter;
    private long mMillDelay = 1000;
    private int mCurrentCounter = 0;
    private static final int PAGE_SIZE = 6;
    private static final int TOTAL_COUNTER = 18;
    private boolean mIsLoadMoreError = true;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pull_to_refresh;
    }

    @Override
    protected void initView() {
        mRecyclerView = findView(R.id.rv_list);
        mSwipeRefreshLayout = findView(R.id.swipeLayout);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLazyData() {
        mAdapter = new PullToRefreshUseAdapter();
        //设置加载更多监听器之后，就启动了加载更多
        mAdapter.setOnLoadMoreListener(mRequestLoadMoreListener);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mCurrentCounter = mAdapter.getData().size();
        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(mOnRefreshListener);
    }

    private BaseQuickAdapter.RequestLoadMoreListener mRequestLoadMoreListener = new BaseQuickAdapter.RequestLoadMoreListener() {
        @Override
        public void onLoadMoreRequested() {
            MLog.d("onLoadMoreRequested");
            mSwipeRefreshLayout.setEnabled(false);//当加载更多时，阻止下拉刷新
            mRecyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (mCurrentCounter >= TOTAL_COUNTER) {
                        MLog.d("onLoadMoreRequested mCurrentCounter >= TOTAL_COUNTER");
                        mAdapter.loadMoreEnd(false);//true is gone,false is visible
                    } else {
                        MLog.d("onLoadMoreRequested other");
                        if (mIsLoadMoreError) {//加载更多错误时的处理
                            mIsLoadMoreError = false;
                            Toast.makeText(getActivity(), R.string.load_more_error, Toast.LENGTH_LONG).show();
                            mAdapter.loadMoreFail();
                        } else {//加载更多成功时的处理
                            mAdapter.addData(DataFactory.getSampleData(PAGE_SIZE));
                            mCurrentCounter = mAdapter.getData().size();
                            mAdapter.loadMoreComplete();
                        }
                    }

                    //加载更多完成后，才不阻止下拉刷新
                    mSwipeRefreshLayout.setEnabled(true);
                }

            }, 5000);
        }
    };

    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            mAdapter.setEnableLoadMore(false);//下拉刷新时，阻止加载更多
            mRecyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mAdapter.setNewData(DataFactory.getSampleData(PAGE_SIZE));
                    mIsLoadMoreError = true;
                    mCurrentCounter = PAGE_SIZE;
                    mSwipeRefreshLayout.setRefreshing(false);//设置下拉刷新完成
                    mAdapter.setEnableLoadMore(true);//下拉刷新完成后，使能加载更多
                    MLog.d("onRefresh end");
                }
            },mMillDelay);
        }
    };
}
