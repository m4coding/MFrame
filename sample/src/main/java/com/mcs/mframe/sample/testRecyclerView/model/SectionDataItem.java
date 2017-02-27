package com.mcs.mframe.sample.testRecyclerView.model;

import com.mcs.mframe.ui.recyclerview.entity.SectionEntity;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/2/27
 * @changeRecord [修改记录] <br/>
 */

public class SectionDataItem extends SectionEntity<DataItem> {

    private boolean mIsMore;

    //段头构造方法
    public SectionDataItem(boolean isHeader, String header, boolean isMore) {
        super(isHeader, header);
        mIsMore = isMore;
    }

    //普通数据Item构造
    public SectionDataItem(DataItem dataItem) {
        super(dataItem);
    }


    public boolean isMore() {
        return mIsMore;
    }

    public void setMore(boolean more) {
        mIsMore = more;
    }
}
