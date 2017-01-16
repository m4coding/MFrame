package com.mcs.mframe.sample.testRecyclerView.adapter;

import android.content.Context;

import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.testRecyclerView.model.MultiDataItem;
import com.mcs.mframe.ui.recyclerview.BaseMultiItemQuickAdapter;
import com.mcs.mframe.ui.recyclerview.BaseViewHolder;

import java.util.List;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/1/16
 * @changeRecord [修改记录] <br/>
 */

public class MultiItemAdapter extends BaseMultiItemQuickAdapter<MultiDataItem, BaseViewHolder> {

    public MultiItemAdapter(Context context, List<MultiDataItem> data) {
        super(data);
        addItemType(MultiDataItem.TEXT, R.layout.item_text_view);
        addItemType(MultiDataItem.IMG, R.layout.item_image_view);
        addItemType(MultiDataItem.IMG_TEXT, R.layout.item_img_text_view);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiDataItem item) {
        switch (helper.getItemViewType()) {
            case MultiDataItem.TEXT:
                helper.setText(R.id.tv, item.getContent());
                break;
            case MultiDataItem.IMG_TEXT:
                switch (helper.getLayoutPosition() %
                        2) {
                    case 0:
                        helper.setImageResource(R.id.iv, R.mipmap.agenting)
                              .setText(R.id.tv, "Argentina");
                        break;
                    case 1:
                        helper.setImageResource(R.id.iv, R.mipmap.baxi);
                        break;

                }
                break;
        }
    }
}
