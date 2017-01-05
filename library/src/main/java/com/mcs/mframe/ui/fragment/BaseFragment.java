package com.mcs.mframe.ui.fragment;

import android.support.v4.app.Fragment;

import com.trello.rxlifecycle.components.support.RxFragment;

import java.lang.reflect.Field;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 基本的BaseFragment，继承于RxFragment
 * @created 2017/1/5
 * @changeRecord [修改记录] <br/>
 */

public class BaseFragment extends RxFragment {


    // http://stackoverflow.com/questions/15207305/getting-the-error-java-lang-illegalstateexception-activity-has-been-destroyed
    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
