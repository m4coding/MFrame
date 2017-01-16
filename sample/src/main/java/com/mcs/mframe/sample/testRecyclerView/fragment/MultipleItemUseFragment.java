package com.mcs.mframe.sample.testRecyclerView.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.testRecyclerView.adapter.MultiItemAdapter;
import com.mcs.mframe.sample.testRecyclerView.model.DataFactory;
import com.mcs.mframe.sample.testRecyclerView.model.MultiDataItem;
import com.mcs.mframe.ui.fragment.LazyFragment;
import com.mcs.mframe.ui.recyclerview.BaseQuickAdapter;

import java.util.List;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/1/16
 * @changeRecord [修改记录] <br/>
 */

public class MultipleItemUseFragment extends LazyFragment {

    public static final String TAG = MultipleItemUseFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_multi_item_use;
    }

    @Override
    protected void initView() {
        mRecyclerView = findView(R.id.recycler_view);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLazyData() {
        final List<MultiDataItem> data = DataFactory.getMultipleItemData();
        final MultiItemAdapter multipleItemAdapter = new MultiItemAdapter(getActivity(), data);
        final GridLayoutManager manager = new GridLayoutManager(getActivity(), 4);//设置列数
        mRecyclerView.setLayoutManager(manager);
        //设置每个Item所占的列数，可以形成item的不规则排布
        multipleItemAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return data.get(position).getSpanSize();
            }
        });
        mRecyclerView.setAdapter(multipleItemAdapter);
    }
}
