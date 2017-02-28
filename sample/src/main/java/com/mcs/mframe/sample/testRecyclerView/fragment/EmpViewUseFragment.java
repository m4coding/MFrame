package com.mcs.mframe.sample.testRecyclerView.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mcs.mframe.log.MLog;
import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.testRecyclerView.adapter.AnimationAdapter;
import com.mcs.mframe.sample.testRecyclerView.model.DataFactory;
import com.mcs.mframe.ui.fragment.LazyFragment;

/**
 * @author mochangsheng
 * @version 1.0
 * @description EmptyView功能显示
 * @created 2017/2/28
 * @changeRecord [修改记录] <br/>
 */

public class EmpViewUseFragment extends LazyFragment {

    public static final String TAG = EmpViewUseFragment.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private AnimationAdapter mAdapter;
    private View mNotDataView, mErrorView;
    private boolean mError = true;
    private boolean mNoData = true;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_empty_view;
    }

    @Override
    protected void initView() {
        mRecyclerView = findView(R.id.recycler_view);

        mNotDataView = getActivity().getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) mRecyclerView.getParent(), false);
        mNotDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });
        mErrorView = getActivity().getLayoutInflater().inflate(R.layout.error_view, (ViewGroup) mRecyclerView.getParent(), false);
        mErrorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLazyData() {
        MLog.d("=====initLazyData");
        mAdapter = new AnimationAdapter(0);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        mError = true;
        mNoData = true;
        onRefresh();
    }

    private void onRefresh() {

        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.setEmptyView(R.layout.loading_view, (ViewGroup) mRecyclerView.getParent());
                mRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mError) {
                            mAdapter.setEmptyView(mErrorView);
                            mError = false;
                        } else {
                            if (mNoData) {
                                mAdapter.setEmptyView(mNotDataView);
                                mNoData = false;
                            } else {
                                mAdapter.setNewData(DataFactory.getSampleData(10));
                            }
                        }
                    }
                }, 3000);
            }
        },50);//延时一段时间，保证setAdapter先刷新成功，以避免REcyclerView的Inconsistency detected错误

    }
}
