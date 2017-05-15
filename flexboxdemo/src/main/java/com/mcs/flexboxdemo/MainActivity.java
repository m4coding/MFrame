package com.mcs.flexboxdemo;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TagFlowLayout mFlowLayoutMyProfession, mFlowLayoutMyStyle;
    private LabelAdapter mLabelAdapterProfession, mLabelAdapterStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mFlowLayoutMyProfession = (TagFlowLayout) findViewById(R.id.flow_layout_my_profession);
        mFlowLayoutMyStyle = (TagFlowLayout) findViewById(R.id.flow_layout_my_style);
    }

    private void initData() {

        int selection = 0;

        //我的职业
        List<LabelEntity> professionList = customData(
                getResources().getStringArray(R.array.profession_label), selection);

        mLabelAdapterProfession = new LabelAdapter(this, R.layout.item_my_label_profession, professionList);
        mLabelAdapterProfession.setSelection(selection);
        mFlowLayoutMyProfession.setAdapter(mLabelAdapterProfession);
        mFlowLayoutMyProfession.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                mLabelAdapterProfession.getItem(position).setSelected(true);
                view.setSelected(true);
                Toast.makeText(MainActivity.this, "i==" + mLabelAdapterProfession.getSelection(),Toast.LENGTH_LONG).show();
                mLabelAdapterProfession.getItem(mLabelAdapterProfession.getSelection()).setSelected(false);
                View preView = parent.getChildAt(mLabelAdapterProfession.getSelection());
                preView.setSelected(false);
                mLabelAdapterProfession.setSelection(position);
                mLabelAdapterProfession.notifyDataChanged();
                return false;
            }
        });

        //我的风格
        List<LabelEntity> styleList = customData(getResources().getStringArray(R.array.style_label), selection);

        mLabelAdapterStyle = new LabelAdapter(this, R.layout.item_my_label_style, styleList);
        mLabelAdapterStyle.setSelection(selection);
        mFlowLayoutMyStyle.setAdapter(mLabelAdapterStyle);

    }

    private List<LabelEntity> customData(String[] array, int selectedPosition) {

        List<LabelEntity> list = new ArrayList<>();

        if (array == null || array.length == 0) {
            return list;
        }

        Toast.makeText(this, "customData is " + array.length, Toast.LENGTH_LONG).show();

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

            outRect.top = this.top;
            outRect.left = this.left;
            outRect.right = this.right;
            outRect.bottom = this.bottom;
        }
    }
}
