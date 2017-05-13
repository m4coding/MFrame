package com.mcs.flexboxdemo;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewMyProfession, mRecyclerViewMyStyle;

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
        List<String> professionList = Arrays.asList(
                getResources().getStringArray(R.array.profession_label));

        List<String> styleList = Arrays.asList(
                getResources().getStringArray(R.array.style_label));

        FlexboxLayoutManager layoutManagerProfession = new FlexboxLayoutManager();
        layoutManagerProfession.setFlexWrap(FlexWrap.WRAP);
        layoutManagerProfession.setFlexDirection(FlexDirection.ROW);
        layoutManagerProfession.setAlignItems(AlignItems.STRETCH);

        FlexboxLayoutManager LayoutManagerStyle = new FlexboxLayoutManager();
        LayoutManagerStyle.setFlexWrap(FlexWrap.WRAP);
        LayoutManagerStyle.setFlexDirection(FlexDirection.ROW);

        LabelAdapter labelAdapterProfession = new LabelAdapter(R.layout.item_my_label, professionList);
        LabelAdapter labelAdapterStyle = new LabelAdapter(R.layout.item_my_label, styleList);

        mRecyclerViewMyProfession.setLayoutManager(layoutManagerProfession);
        mRecyclerViewMyStyle.setLayoutManager(LayoutManagerStyle);

        int itemSpace = (int) getResources().getDimensionPixelSize(R.dimen.px_20);
        SpaceItemDecoration spaceItemDecoration = new SpaceItemDecoration(0, itemSpace, itemSpace, 0);

        //mRecyclerViewMyProfession.addItemDecoration(spaceItemDecoration);
        mRecyclerViewMyProfession.setAdapter(labelAdapterProfession);

        //mRecyclerViewMyStyle.addItemDecoration(spaceItemDecoration);
        mRecyclerViewMyStyle.setAdapter(labelAdapterStyle);


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
