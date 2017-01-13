package com.mcs.mframe.sample.testLazy.fragment;

import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.mcs.mframe.log.MLog;
import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.testLazy.adapter.ListAdapter;
import com.mcs.mframe.ui.fragment.LazyFragment;
import com.trello.rxlifecycle.android.FragmentEvent;

import java.util.ArrayList;
import java.util.Collection;
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
    private SwipeRefreshLayout mSwipeRefreshLayout;
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
            //ListView能嵌套滚动，CoordinatorLayout才能起到作用，若在5.0以下版本推荐使用RecyclerView
            ViewCompat.setNestedScrollingEnabled(mListView,true);
        }
        if (mProgressBar == null) {
            mProgressBar = findView(R.id.progress_bar);
        }
        mProgressBar.setVisibility(View.VISIBLE);

        if (mSwipeRefreshLayout == null) {
            mSwipeRefreshLayout = findView(R.id.swipe_refresh_layout);
            mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light);//发生变化的颜色，依次进行
            mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    MLog.d("=====mSwipeRefreshLayout onRefresh");
                    mSwipeRefreshLayout.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            onSwipeRefresh();
                        }
                    }, 1000);
                }
            });
        }
    }

    protected void onSwipeRefresh() {

    }

    @Override
    protected void initData() {
        MLog.d("initView mList==" + (mList!=null) + "; mListAdapter==" + mListAdapter);
        mList = new ArrayList<>();
        mListAdapter = new ListAdapter(getActivity(), mList);
        mListView.setAdapter(mListAdapter);
    }

    @Override
    protected void initLazyData() {

    }

    protected void produceData(final String data, final int amount) {
        MLog.d("====" + data + " produceData");
        Observable.create(new Observable.OnSubscribe<Object>() {
                    @Override
                    public void call(Subscriber<? super Object> subscriber) {
                        ArrayList<String> list = new ArrayList<>();
                        for(int i = 0; i < amount; i++) {
                            list.add(String.format("%d item==%s", i+1, data));
                        }
                        subscriber.onNext(list);
                        subscriber.onCompleted();
                        MLog.d("handle end " + Thread.currentThread());
                    }
                })
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        MLog.d("====doOnTerminate");
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY_VIEW))
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        MLog.d("onNext");
                        mList.clear();
                        mList.addAll((Collection<? extends String>) o);
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
                        //mListView.setAdapter(mListAdapter);
                        mListAdapter.notifyDataSetChanged();
                        mProgressBar.setVisibility(View.GONE);
                    }
                });

    }
}
