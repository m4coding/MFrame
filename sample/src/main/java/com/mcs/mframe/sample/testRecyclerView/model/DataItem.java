package com.mcs.mframe.sample.testRecyclerView.model;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/1/16
 * @changeRecord [修改记录] <br/>
 */

public class DataItem {

    private String mText;
    private int mResId;

    public DataItem() {

    }

    public DataItem(String text, int resId) {
        mText = text;
        mResId = resId;
    }

    public void setText(String text) {
        mText = text;
    }

    public String getText() {
        return mText;
    }

    public void setResId(int resId) {
        mResId = resId;
    }

    public int getResId() {
        return mResId;
    }
}
