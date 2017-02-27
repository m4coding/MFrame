package com.mcs.mframe.sample.testRecyclerView.adapter;

import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.testRecyclerView.model.DataItem;
import com.mcs.mframe.sample.testRecyclerView.model.SectionDataItem;
import com.mcs.mframe.ui.recyclerview.BaseSectionQuickAdapter;
import com.mcs.mframe.ui.recyclerview.BaseViewHolder;

import java.util.List;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/2/27
 * @changeRecord [修改记录] <br/>
 */

public class SectionAdapter extends BaseSectionQuickAdapter<SectionDataItem, BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SectionAdapter(int layoutResId, int sectionHeadResId, List<SectionDataItem> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, SectionDataItem item) {
        helper.setText(R.id.header, item.header);
        helper.setVisible(R.id.more, item.isMore());
        helper.addOnClickListener(R.id.more);//添加后，点击more view，onItemChildClick能够回调
    }

    @Override
    protected void convert(BaseViewHolder helper, SectionDataItem item) {
        DataItem dataItem = item.t;
        helper.setImageResource(R.id.iv, dataItem.getResId());
        helper.setText(R.id.tv, dataItem.getText());
    }
}
