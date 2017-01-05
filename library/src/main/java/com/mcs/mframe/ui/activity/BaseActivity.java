package com.mcs.mframe.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2016/12/30
 * @changeRecord [修改记录] <br/>
 */

public class BaseActivity extends RxAppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    protected void initView() {

    }

    protected void initData() {

    }

    /**************处理Fragment的相关方法*******************/

    public void addFragment(@NonNull int viewId, @NonNull Fragment fragment, @NonNull String tag, boolean isAddBackStack) {
        addFragment(viewId, fragment, tag, isAddBackStack, -1, -1);
    }

    public void addFragment(@NonNull int viewId, @NonNull Fragment fragment, @NonNull String tag,
                            boolean isAddBackStack,int enterTransit, int exitTransit) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (enterTransit != -1 && exitTransit != -1) {
            //v4包里面的fragment要求设置的是View 动画，非v4包里面的是属性动画
            //要放在add之前，设置才会有效果
            //transaction.setCustomAnimations(enterTransit, exitTransit);
            //设置四个参数的transit方法，exit时才会有exit动画
            transaction.setCustomAnimations(enterTransit,exitTransit,enterTransit,exitTransit);
        }
        if (isAddBackStack) {
            transaction.addToBackStack(null);
        }

        transaction.add(viewId, fragment, tag);

        transaction.commit();
    }

    public void removeFragment(Fragment fragment) {
        if (fragment == null) {
            return;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }

    public boolean isFragmentExit(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            return true;
        } else {
            return false;
        }
    }

    public void setFragmentVisible(String tag, boolean visible) {
        Fragment fragment = findFragmentByTag(tag);
        if (fragment != null) {
            if (visible) {
                getSupportFragmentManager().beginTransaction().show(fragment).commit();
            } else {
                getSupportFragmentManager().beginTransaction().hide(fragment).commit();
            }
        }
    }

    public Fragment findFragmentByTag(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        return fragment;
    }

}
