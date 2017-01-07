package com.mcs.mframe.sample.testLazy.fragment;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/1/5
 * @changeRecord [修改记录] <br/>
 */

public class FourthLazyFragment extends BaseTestLazyFragment {

    private static String TAG = FourthLazyFragment.class.getSimpleName();

    @Override
    protected void initLazyData() {
        super.initLazyData();
        produceData(TAG, 2000);
    }
}
