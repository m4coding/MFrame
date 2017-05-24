package com.mcs.flexboxdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mcs.flowlayout.FlowLayout;
import com.mcs.flowlayout.TagAdapter;

import java.util.List;


/**
 * @author mochangsheng
 * @description 该类的主要功能描述
 */
public class LabelAdapter extends TagAdapter<LabelEntity> {

    private Context mContext;
    private int mRes;
    final LayoutInflater mInflater;

    public LabelAdapter(Context context, int res, List<LabelEntity> datas) {
        super(datas);
        mContext = context;
        mRes = res;
        mInflater = LayoutInflater.from(mContext);
    }

    //初始化时，指定哪个item被选中
    @Override
    public boolean setSelected(int position, LabelEntity labelEntity) {
        return labelEntity.isSelected();
    }

    @Override
    public View getView(FlowLayout parent, int position, LabelEntity labelEntity) {
        View itemView = mInflater.inflate(mRes, parent, false);

        TextView textView = (TextView) itemView;
        textView.setText(labelEntity.getLabel());

        return itemView;
    }
}
