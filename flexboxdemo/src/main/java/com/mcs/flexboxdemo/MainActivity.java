package com.mcs.flexboxdemo;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewMyProfession, mRecyclerViewMyStyle;
    private LabelAdapter mLabelAdapterProfession, mLabelAdapterStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mRecyclerViewMyProfession = (RecyclerView) findViewById(R.id.recyclerview_my_profession);
        mRecyclerViewMyStyle = (RecyclerView) findViewById(R.id.recyclerview_my_style);
    }

    private void initData() {

        int selection = 0;

        List<LabelEntity> professionList = customData(
                getResources().getStringArray(R.array.profession_label), selection);

        List<LabelEntity> styleList = customData(getResources().getStringArray(R.array.style_label), selection);

        FlexboxLayoutManager layoutManagerProfession = new FlexboxLayoutManager();
        layoutManagerProfession.setFlexWrap(FlexWrap.WRAP);
        layoutManagerProfession.setFlexDirection(FlexDirection.ROW);
        layoutManagerProfession.setAlignItems(AlignItems.STRETCH);

        FlexboxLayoutManager LayoutManagerStyle = new FlexboxLayoutManager();
        LayoutManagerStyle.setFlexWrap(FlexWrap.WRAP);
        LayoutManagerStyle.setFlexDirection(FlexDirection.ROW);

        mLabelAdapterProfession = new LabelAdapter(R.layout.item_my_label, professionList);
        mLabelAdapterProfession.setSeletion(selection);
        mLabelAdapterStyle = new LabelAdapter(R.layout.item_my_label, styleList);
        mLabelAdapterStyle.setSeletion(selection);

        mRecyclerViewMyProfession.setLayoutManager(layoutManagerProfession);
        mRecyclerViewMyStyle.setLayoutManager(LayoutManagerStyle);

        mRecyclerViewMyProfession.setAdapter(mLabelAdapterProfession);

        mRecyclerViewMyStyle.setAdapter(mLabelAdapterStyle);

    }

    private List<LabelEntity> customData(String[] array, int selectedPosition) {

        List<LabelEntity> list = new ArrayList<>();

        if (array == null || array.length == 0) {
            return list;
        }


        for(int i = 0; i < array.length; i++) {
            boolean isSelected = (i == selectedPosition);
            LabelEntity labelEntity = new LabelEntity(array[i], isSelected);
            list.add(labelEntity);
        }

        return list;
    }

    private static class SpaceItemDecoration extends RecyclerView.ItemDecoration{

        private int left, top, right, bottom;

        public SpaceItemDecoration(int left, int top, int right, int bottom) {
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

            if(parent.getChildPosition(view) != 0)
                outRect.top = this.top;
                outRect.left = this.left;
                outRect.right = this.right;
                outRect.bottom = this.bottom;
        }
    }
}
