package com.mcs.flexboxdemo;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.List;

/**
 * @author mochangsheng
 * @description 该类的主要功能描述
 */
public class LabelAdapter extends TagAdapter<LabelEntity> {

    private int mSelection = -1;
    private Context mContext;
    private int mRes;
    final LayoutInflater mInflater;

    public LabelAdapter(Context context, int res, List<LabelEntity> datas) {
        super(datas);
        mContext = context;
        mRes = res;
        mInflater = LayoutInflater.from(mContext);
    }


    public void setSelection(int selection) {
        mSelection = selection;
    }

    public int getSelection() {
        return mSelection;
    }

    @Override
    public View getView(FlowLayout parent, int position, LabelEntity labelEntity) {
        View itemView = mInflater.inflate(R.layout.item_my_label_profession, parent, false);

        TextView textView = (TextView) itemView.findViewById(R.id.my_label_item);
        textView.setText(labelEntity.getLabel());
        textView.setSelected(labelEntity.isSelected());

        return itemView;
    }
}
