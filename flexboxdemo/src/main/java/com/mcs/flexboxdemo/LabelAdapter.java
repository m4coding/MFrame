package com.mcs.flexboxdemo;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.flexbox.AlignSelf;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.List;

/**
 * @author mochangsheng
 * @description 该类的主要功能描述
 */
public class LabelAdapter extends BaseQuickAdapter<String,BaseViewHolder> {


    public LabelAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        TextView itemView = helper.getView(R.id.my_label_item);
        itemView.setText(item);

        ViewGroup.LayoutParams lp = itemView.getLayoutParams();
        if (lp instanceof FlexboxLayoutManager.LayoutParams) {
            FlexboxLayoutManager.LayoutParams flexboxLp = (FlexboxLayoutManager.LayoutParams) lp;
            //flexboxLp.setFlexGrow(1.0f);
            //flexboxLp.setAlignSelf(AlignSelf.FLEX_END);
        }
    }
}
