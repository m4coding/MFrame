package com.mcs.mframe.sample.testRecyclerView.adapter;

import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.testRecyclerView.model.DataFactory;
import com.mcs.mframe.sample.testRecyclerView.model.DataItem;
import com.mcs.mframe.ui.recyclerview.BaseQuickAdapter;
import com.mcs.mframe.ui.recyclerview.BaseViewHolder;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/2/27
 * @changeRecord [修改记录] <br/>
 */

public class PullToRefreshUseAdapter extends BaseQuickAdapter<DataItem, BaseViewHolder> {

    public PullToRefreshUseAdapter() {
        super(R.layout.item_animation, DataFactory.getSampleData(20));
    }

    @Override
    protected void convert(BaseViewHolder helper, DataItem item) {
        helper.setImageResource(R.id.img, item.getResId())
                .setText(R.id.name, item.getText())
                .addOnClickListener(R.id.img)
                .addOnClickListener(R.id.name);
    }
}
