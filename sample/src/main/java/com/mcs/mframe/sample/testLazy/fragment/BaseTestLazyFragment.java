package com.mcs.mframe.sample.testLazy.fragment;

import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.mcs.mframe.log.MLog;
import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.testLazy.adapter.ListAdapter;
import com.mcs.mframe.ui.fragment.LazyFragment;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/1/5
 * @changeRecord [修改记录] <br/>
 */

public class BaseTestLazyFragment extends LazyFragment {

    private List<String> mList;
    private ListView mListView;
    private ProgressBar mProgressBar;
    private ListAdapter mListAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test_lazy;
    }

    @Override
    protected void initView() {
        MLog.d("initView mListView==" + mListView + "; mProgressBar==" + mProgressBar);
        if (mListView == null) {
            mListView = findView(R.id.lazy_list_view);
        }

        if (mProgressBar == null) {
            mProgressBar = findView(R.id.progress_bar);
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void initData() {
        MLog.d("initView mList==" + (mList!=null) + "; mListAdapter==" + mListAdapter);
        if (mList == null) {
            mList = new ArrayList<>();
        } else {
            MLog.d("initView mList.size==" + mList.size());
        }
        if (mListAdapter == null) {
            mListAdapter = new ListAdapter(getActivity(), mList);
        }
    }

    @Override
    protected void initLazyData() {
        //mListAdapter = new ListAdapter(getActivity(), mList);
    }

    @Override
    protected void lazyUpdateData() {
        if (mListAdapter != null) {
            MLog.d("=======lazyUpdateData mListAdapter.notifyDataSetChanged()");
            mListAdapter.notifyDataSetChanged();
        }
    }

    protected void produceData(final String data, final int amount) {
        MLog.d("====" + data + " produceData");
        Observable.create(new Observable.OnSubscribe<Object>() {
                    @Override
                    public void call(Subscriber<? super Object> subscriber) {
                        for(int i = 0; i < amount; i++) {
                            mList.add(String.format("%d item==%s", i+1, data));
                        }
                        subscriber.onNext(mList);
                        subscriber.onCompleted();
                        MLog.d("handle end " + Thread.currentThread());
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.bindToLifecycle())
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        MLog.d("onNext");
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        MLog.e("onError");

                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        MLog.d("onComplete " + Thread.currentThread());
                        mListView.setAdapter(mListAdapter);
                        mProgressBar.setVisibility(View.GONE);
                    }
                });

    }
}
