package com.mcs.mframe.sample.testRecyclerView.adapter;

import com.mcs.mframe.log.MLog;
import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.testRecyclerView.model.DataItem;
import com.mcs.mframe.ui.recyclerview.BaseItemDraggableAdapter;
import com.mcs.mframe.ui.recyclerview.BaseQuickAdapter;
import com.mcs.mframe.ui.recyclerview.BaseViewHolder;

import java.util.List;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/2/28
 * @changeRecord [修改记录] <br/>
 */

public class ItemDragAdapter extends BaseQuickAdapter<DataItem,BaseViewHolder> {


    public ItemDragAdapter(int layoutResId, List<DataItem> data) {
        super(layoutResId, data);
        MLog.d("ItemDragAdapter list.size==" + data.size());
    }

    @Override
    protected void convert(BaseViewHolder helper, DataItem item) {
        int type = helper.getAdapterPosition() % 5;
        MLog.d("convert type==" + type);
        helper.setImageResource(R.id.iv, item.getResId());
        helper.setText(R.id.tv, item.getText());
    }
}
