package com.mcs.mframe.sample.testRecyclerView.model;

import com.mcs.mframe.sample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/1/16
 * @changeRecord [修改记录] <br/>
 */

public class DataFactory {

    public static List<DataItem> getSampleData(int length) {
        List<DataItem> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            DataItem dataItem = new DataItem();
            int value = i % 5;
            switch (value) {
                case 0:
                    dataItem.setResId(R.drawable.zhongguo);
                    dataItem.setText("China");
                    break;
                case 1:
                    dataItem.setResId(R.drawable.agenting);
                    dataItem.setText("Argentina");
                    break;
                case 2:
                    dataItem.setResId(R.drawable.baxi);
                    dataItem.setText("Brazil");
                    break;
                case 3:
                    dataItem.setResId(R.drawable.deguo);
                    dataItem.setText("Germany");
                    break;
                case 4:
                    dataItem.setResId(R.drawable.eluosi);
                    dataItem.setText("Russia");
                    break;
                default:
                    dataItem.setResId(R.drawable.baxi);
                    dataItem.setText("Brazil");
                    break;
            }
            list.add(dataItem);
        }
        return list;
    }


    public static List<MultiDataItem> getMultipleItemData() {
        List<MultiDataItem> list = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {//4*5=20
            list.add(new MultiDataItem(MultiDataItem.IMG, MultiDataItem.IMG_SPAN_SIZE));
            list.add(new MultiDataItem(MultiDataItem.TEXT, MultiDataItem.TEXT_SPAN_SIZE, "China"));
            list.add(new MultiDataItem(MultiDataItem.IMG_TEXT, MultiDataItem.IMG_TEXT_SPAN_SIZE));
            list.add(new MultiDataItem(MultiDataItem.IMG_TEXT, MultiDataItem.IMG_TEXT_SPAN_SIZE_MIN));
            list.add(new MultiDataItem(MultiDataItem.IMG_TEXT, MultiDataItem.IMG_TEXT_SPAN_SIZE_MIN));
        }

        return list;
    }

    public static List<SectionDataItem> getSectionDataItem() {
        List<SectionDataItem> list = new ArrayList<>();
        list.add(new SectionDataItem(true, "Section 1", true));
        list.add(new SectionDataItem(new DataItem("China", R.drawable.zhongguo)));
        list.add(new SectionDataItem(new DataItem("Argentina", R.drawable.agenting)));
        list.add(new SectionDataItem(new DataItem("Brazil", R.drawable.baxi)));
        list.add(new SectionDataItem(new DataItem("Germany", R.drawable.deguo)));
        list.add(new SectionDataItem(new DataItem("Russia", R.drawable.eluosi)));

        list.add(new SectionDataItem(true, "Section 2", false));
        list.add(new SectionDataItem(new DataItem("China", R.drawable.zhongguo)));
        list.add(new SectionDataItem(new DataItem("Argentina", R.drawable.agenting)));


        list.add(new SectionDataItem(true, "Section 3", false));
        list.add(new SectionDataItem(new DataItem("China", R.drawable.zhongguo)));
        list.add(new SectionDataItem(new DataItem("Argentina", R.drawable.agenting)));
        list.add(new SectionDataItem(new DataItem("Brazil", R.drawable.baxi)));
        list.add(new SectionDataItem(new DataItem("Germany", R.drawable.deguo)));


        list.add(new SectionDataItem(true, "Section 4", true));
        list.add(new SectionDataItem(new DataItem("China", R.drawable.zhongguo)));

        list.add(new SectionDataItem(true, "Section 5", false));
        list.add(new SectionDataItem(new DataItem("China", R.drawable.zhongguo)));
        list.add(new SectionDataItem(new DataItem("Argentina", R.drawable.agenting)));

        return list;
    }
}
