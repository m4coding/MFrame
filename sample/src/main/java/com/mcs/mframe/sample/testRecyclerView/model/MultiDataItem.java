package com.mcs.mframe.sample.testRecyclerView.model;

import com.mcs.mframe.ui.recyclerview.entity.MultiItemEntity;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/1/16
 * @changeRecord [修改记录] <br/>
 */

public class MultiDataItem implements MultiItemEntity {

    //item type类型
    public static final int TEXT = 1;
    public static final int IMG = 2;
    public static final int IMG_TEXT = 3;
    //item所占的span size
    public static final int TEXT_SPAN_SIZE = 3;
    public static final int IMG_SPAN_SIZE = 1;
    public static final int IMG_TEXT_SPAN_SIZE = 4;
    public static final int IMG_TEXT_SPAN_SIZE_MIN = 2;
    private int mItemType;
    private int mSpanSize;
    private String mContent;

    public MultiDataItem(int itemType, int spanSize, String content) {
        this.mItemType = itemType;
        this.mSpanSize = spanSize;
        this.mContent = content;
    }

    public MultiDataItem(int itemType, int spanSize) {
        this.mItemType = itemType;
        this.mSpanSize = spanSize;
    }

    public int getSpanSize() {
        return mSpanSize;
    }

    public void setSpanSize(int spanSize) {
        this.mSpanSize = spanSize;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        this.mContent = content;
    }

    @Override
    public int getItemType() {
        return mItemType;
    }
}
