package com.mcs.mframe.sample.testRecyclerView.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.testRecyclerView.adapter.HeaderAndFooterAdapter;
import com.mcs.mframe.ui.fragment.LazyFragment;
import com.mcs.mframe.ui.recyclerview.BaseQuickAdapter;
import com.mcs.mframe.ui.recyclerview.listener.OnItemClickListener;

/**
 * @author mochangsheng
 * @version 1.0
 * @description Header View、Footer View使用示例
 * @created 2017/1/18
 * @changeRecord [修改记录] <br/>
 */

public class HeaderAndFooterUseFragment extends LazyFragment {

    public static final String TAG = HeaderAndFooterUseFragment.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private HeaderAndFooterAdapter mHeaderAndFooterAdapter;
    private static final int PAGE_SIZE = 3;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_header_and_footer_use;
    }

    @Override
    protected void initView() {
        mRecyclerView = findView(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getActivity(), "" + Integer.toString(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLazyData() {
        mHeaderAndFooterAdapter = new HeaderAndFooterAdapter(PAGE_SIZE);
        //注释掉动画，避免Fragment切换到时出现闪下的现象
        //mHeaderAndFooterAdapter.openLoadAnimation();

        View headerView = getHeaderView(0, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHeaderAndFooterAdapter.addHeaderView(getHeaderView(1, getRemoveHeaderListener()), 0);
            }
        });
        mHeaderAndFooterAdapter.addHeaderView(headerView);


        View footerView = getFooterView(0, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHeaderAndFooterAdapter.addFooterView(getFooterView(1, getRemoveFooterListener()), 0);
            }
        });
        mHeaderAndFooterAdapter.addFooterView(footerView, 0);

        mRecyclerView.setAdapter(mHeaderAndFooterAdapter);
    }

    private View getHeaderView(int type, View.OnClickListener listener) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.head_view, (ViewGroup) mRecyclerView.getParent(), false);
        if (type == 1) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv);
            imageView.setImageResource(R.mipmap.rm_icon);
        }
        view.setOnClickListener(listener);
        return view;
    }
    private View getFooterView(int type, View.OnClickListener listener) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.footer_view, (ViewGroup) mRecyclerView.getParent(), false);
        if (type == 1) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv);
            imageView.setImageResource(R.mipmap.rm_icon);
        }
        view.setOnClickListener(listener);
        return view;
    }

    private View.OnClickListener getRemoveHeaderListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHeaderAndFooterAdapter.removeHeaderView(v);
            }
        };
    }


    private View.OnClickListener getRemoveFooterListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHeaderAndFooterAdapter.removeFooterView(v);
            }
        };
    }
}
