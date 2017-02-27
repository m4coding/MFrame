package com.mcs.mframe.sample.testRecyclerView.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.mcs.mframe.log.MLog;
import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.testRecyclerView.adapter.AnimationAdapter;
import com.mcs.mframe.sample.testRecyclerView.animation.CustomAnimation;
import com.mcs.mframe.sample.testRecyclerView.model.DataItem;
import com.mcs.mframe.ui.fragment.LazyFragment;
import com.mcs.mframe.ui.recyclerview.BaseQuickAdapter;
import com.mcs.mframe.ui.recyclerview.listener.OnItemChildClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mochangsheng
 * @version 1.0
 * @description item动画使用示例
 * @created 2017/1/16
 * @changeRecord [修改记录] <br/>
 */

public class AnimationUseFragment extends LazyFragment {

    public static final String TAG = AnimationUseFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private AnimationAdapter mAnimationAdapter;
    private int mFirstPageItemCount = 3;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_animation_use;
    }

    @Override
    protected void initView() {
        mRecyclerView = findView(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initMenu();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLazyData() {
        mAnimationAdapter = new AnimationAdapter();
        mAnimationAdapter.openLoadAnimation();
        mAnimationAdapter.setNotDoAnimationCount(mFirstPageItemCount);
        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String content = null;
                DataItem dataItem = (DataItem) adapter.getItem(position);
                MLog.d("======onSimpleItemChildClick view==" + view);
                switch (view.getId()) {
                    case R.id.img:
                        content = "img click";
                        Toast.makeText(getActivity(), content, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.name:
                        content = "name click:" + dataItem.getText();
                        Toast.makeText(getActivity(), content, Toast.LENGTH_LONG).show();
                        break;
                }

            }
        });

        mRecyclerView.setAdapter(mAnimationAdapter);
    }

    private void initMenu() {
        Spinner spinner = findView(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("AlphaIn");
        list.add("ScaleIn");
        list.add("SlideInBottom");
        list.add("SlideInLeft");
        list.add("SlideInRight");
        list.add("Custom");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                        break;
                    case 1:
                        mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                        break;
                    case 2:
                        mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
                        break;
                    case 3:
                        mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
                        break;
                    case 4:
                        mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
                        break;
                    case 5:
                        mAnimationAdapter.openLoadAnimation(new CustomAnimation());
                        break;
                    default:
                        break;
                }

                mRecyclerView.setAdapter(mAnimationAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        ToggleButton toggleButton = findView(R.id.toggle_button);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
                if (isChecked) {
                    mAnimationAdapter.isFirstOnly(true);
                } else {
                    mAnimationAdapter.isFirstOnly(false);
                }
                mAnimationAdapter.notifyDataSetChanged();
            }
        });

    }
}
