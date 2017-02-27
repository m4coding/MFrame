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
 * @created 2017/1/18
 * @changeRecord [修改记录] <br/>
 */

public class HeaderAndFooterAdapter extends BaseQuickAdapter<DataItem, BaseViewHolder> {

    public HeaderAndFooterAdapter(int dataSize) {
        super(R.layout.item_header_and_footer, DataFactory.getSampleData(dataSize));
    }

    @Override
    protected void convert(BaseViewHolder helper, DataItem item) {
        switch (helper.getLayoutPosition()%
                3){
            case 0:
                helper.setImageResource(R.id.iv,R.drawable.zhongguo);
                break;
            case 1:
                helper.setImageResource(R.id.iv,R.drawable.baxi);
                break;
            case 2:
                helper.setImageResource(R.id.iv,R.drawable.agenting);
                break;
        }
    }
}
