package com.mcs.mframe.sample.testRecyclerView.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.testRecyclerView.adapter.SectionAdapter;
import com.mcs.mframe.sample.testRecyclerView.model.DataFactory;
import com.mcs.mframe.sample.testRecyclerView.model.DataItem;
import com.mcs.mframe.sample.testRecyclerView.model.SectionDataItem;
import com.mcs.mframe.ui.fragment.LazyFragment;
import com.mcs.mframe.ui.recyclerview.BaseQuickAdapter;
import com.mcs.mframe.ui.recyclerview.listener.OnItemClickListener;

import java.util.List;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/2/27
 * @changeRecord [修改记录] <br/>
 */

public class SectionUseFragment extends LazyFragment {

    public static final String TAG = SectionUseFragment.class.getSimpleName();

    private RecyclerView mRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_section_use;
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
        final List<SectionDataItem> data = DataFactory.getSectionDataItem();
        SectionAdapter sectionAdapter =
                new SectionAdapter(R.layout.item_section_content, R.layout.item_section_head,data);
        //使用 StaggeredGridLayoutManager 才可以进行适配
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);//设置列数
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(sectionAdapter);


        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {

            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                SectionDataItem sectionDataItem = data.get(position);
                if (sectionDataItem.isHeader)
                    Toast.makeText(getActivity(), sectionDataItem.header, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity(), sectionDataItem.t.getText(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getActivity(), "onItemChildClick more" + position, Toast.LENGTH_LONG).show();
            }


        });
    }
}
