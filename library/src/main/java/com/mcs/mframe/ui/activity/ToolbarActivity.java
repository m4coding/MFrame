package com.mcs.mframe.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2016/12/30
 * @changeRecord [修改记录] <br/>
 */

public abstract class ToolbarActivity extends BaseActivity {

    protected AppBarLayout mAppBar;
    protected Toolbar mToolbar;
    protected boolean mIsHidden = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeSetContent();
        setContentView(provideContentViewId());
        mAppBar = (AppBarLayout) findViewById(provideAppBarLayoutId());
        mToolbar = (Toolbar) findViewById(provideToolbarId());
        if (mToolbar == null || mAppBar == null) {
            throw new IllegalStateException(
                    "The subclass of ToolbarActivity must contain a toolbar.");
        }
        mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onToolbarClick();
            }
        });
        setSupportActionBar(mToolbar);
        if (canBack()) {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            mAppBar.setElevation(10.6f);
        }
    }

    public boolean canBack() {
        return false;
    }

    protected void setAppBarAlpha(float alpha) {
        mAppBar.setAlpha(alpha);
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    protected void hideOrShowToolbar() {
        mAppBar.animate()
                .translationY(mIsHidden ? 0 : -mAppBar.getHeight())
                .setInterpolator(new DecelerateInterpolator(2))
                .start();
        mIsHidden = !mIsHidden;
    }

    public void onToolbarClick() {

    }

    protected void beforeSetContent() {

    }

    /**********抽象方法*************/

    /**
     * 提供layout 资源id
     * @return
     */
    protected abstract int provideContentViewId();

    /**
     * 提供AppBar id
     */
    protected abstract int provideAppBarLayoutId();

    /**
     * 提供Toolbar id
     */
    protected abstract int provideToolbarId();
}
