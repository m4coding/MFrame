package com.mcs.flexboxdemo;

/**
 * @author mochangsheng
 * @description 标签数据类
 */
public class LabelEntity {

    private String label;
    private boolean isSelected;

    public LabelEntity(String label, boolean isSelected) {
        this.label = label;
        this.isSelected = isSelected;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
