package com.mcs.flexboxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.mcs.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    private TagFlowLayout mMyProfessionFlowLayout, mMyStyleFlowLayout;
    private LabelAdapter mProfessionLabelAdapter, mStyleLabelAdapter;
    private TextView mMyProfessionLabel, mMyStyleLabel, mMyLabelTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mMyProfessionLabel = (TextView) findViewById(R.id.tv_my_label__profession);
        mMyStyleLabel = (TextView) findViewById(R.id.tv_my_label_style);
        mMyLabelTitle = (TextView) findViewById(R.id.tv_my_label);
        mMyProfessionFlowLayout = (TagFlowLayout) findViewById(R.id.flow_layout_my_profession);
        mMyStyleFlowLayout = (TagFlowLayout) findViewById(R.id.flow_layout_my_style);
    }

    private void initData() {

        int selection = 0;

        //我的职业
        final List<LabelEntity> professionList = customData(
                getResources().getStringArray(R.array.profession_label), selection);

        mProfessionLabelAdapter = new LabelAdapter(this, R.layout.item_my_label_profession, professionList);
        mMyProfessionFlowLayout.setAdapter(mProfessionLabelAdapter);
        mMyProfessionFlowLayout.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                setLabel(mMyProfessionLabel, selectPosSet, professionList);
            }
        });

        mMyProfessionLabel.setText(professionList.get(selection).getLabel());
        mMyProfessionLabel.setSelected(true);

        //我的风格
        final List<LabelEntity> styleList = customData(getResources().getStringArray(R.array.style_label), selection);

        mStyleLabelAdapter = new LabelAdapter(this, R.layout.item_my_label_style, styleList);
        mMyStyleFlowLayout.setAdapter(mStyleLabelAdapter);
        mMyStyleFlowLayout.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                setLabel(mMyStyleLabel, selectPosSet, styleList);
            }
        });

        mMyStyleLabel.setText(styleList.get(selection).getLabel());
        mMyStyleLabel.setSelected(true);

        mMyLabelTitle.setText(getMyLabelString(2));
    }

    private String getMyLabelString(int total) {
        return String.format(getString(R.string.my_label) + "  (%d/2)", total);
    }

    private void setLabel(TextView textVew, Set<Integer> selectPosSet, List<LabelEntity> list) {
        Iterator<Integer> iterator = selectPosSet.iterator();
        while (iterator.hasNext()) {
            int position = iterator.next();
            //Toast.makeText(MainActivity.this, "position==" + position, Toast.LENGTH_LONG).show();
            textVew.setText(list.get(position).getLabel());
        }
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
}
