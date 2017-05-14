package com.mcs.flexboxdemo;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author mochangsheng
 * @description 该类的主要功能描述
 */
public class LabelAdapter extends BaseQuickAdapter<LabelEntity,BaseViewHolder> {

    public int mSelection = -1;

    public LabelAdapter(@LayoutRes int layoutResId, @Nullable List<LabelEntity> data) {
        super(layoutResId, data);

        setOnItemClickListener(mOnItemClickListener);
    }

    @Override
    protected void convert(BaseViewHolder helper, LabelEntity item) {
        TextView itemView = helper.getView(R.id.my_label_item);
        itemView.setText(item.getLabel());
        itemView.setSelected(item.isSelected());
    }

    public void setSeletion(int selection) {
        mSelection = selection;
    }

    public int getSelection() {
        return mSelection;
    }

    BaseQuickAdapter.OnItemClickListener mOnItemClickListener = new BaseQuickAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            if (view.isSelected()) {
                return;
            }
            mData.get(mSelection).setSelected(false);
            mData.get(position).setSelected(true);
            LabelAdapter.this.notifyItemChanged(position);
            LabelAdapter.this.notifyItemChanged(mSelection);
            mSelection = position;
        }
    };
}
