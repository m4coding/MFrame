package com.mcs.mframe.sample.testRecyclerView.fragment;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.mcs.mframe.log.MLog;
import com.mcs.mframe.sample.R;
import com.mcs.mframe.sample.testRecyclerView.adapter.ItemDragAdapter;
import com.mcs.mframe.sample.testRecyclerView.model.DataFactory;
import com.mcs.mframe.ui.fragment.LazyFragment;
import com.mcs.mframe.ui.recyclerview.callback.ItemDragAndSwipeCallback;
import com.mcs.mframe.ui.recyclerview.listener.OnItemDragListener;
import com.mcs.mframe.ui.recyclerview.listener.OnItemSwipeListener;

/**
 * @author mochangsheng
 * @version 1.0
 * @description 该类的主要功能描述
 * @created 2017/2/28
 * @changeRecord [修改记录] <br/>
 */

public class ItemDragAndSwipeUseFragment extends LazyFragment {

    public static final String TAG = ItemDragAndSwipeUseFragment.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private ItemDragAdapter mAdapter;
    private ItemDragAndSwipeCallback mItemDragAndSwipeCallback;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_drag_swipe_use;
    }

    @Override
    protected void initView() {
        mRecyclerView = findView(R.id.recycler_view);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLazyData() {
        MLog.d("initLazyData");
        mAdapter = new ItemDragAdapter(R.layout.item_img_text_view, DataFactory.getSampleData(20));
        /*mItemDragAndSwipeCallback = new ItemDragAndSwipeCallback(mAdapter);
        mItemTouchHelper = new ItemTouchHelper(mItemDragAndSwipeCallback);
        //联系ItemTouchHelper
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        //设置能移动方向
        mItemDragAndSwipeCallback.setDragMoveFlags(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP | ItemTouchHelper.DOWN);
        //设置滑动擦除的方向
        mItemDragAndSwipeCallback.setSwipeMoveFlags(ItemTouchHelper.START | ItemTouchHelper.END);
        //使能擦除功能
        mAdapter.enableSwipeItem();
        mAdapter.setOnItemSwipeListener(mOnItemSwipeListener);
        //使能拖拽功能
        mAdapter.enableDragItem(mItemTouchHelper);
        mAdapter.setOnItemDragListener(mOnItemDragListener);*/

        mRecyclerView.setAdapter(mAdapter);
    }

    private OnItemSwipeListener mOnItemSwipeListener = new OnItemSwipeListener() {
        @Override
        public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
            MLog.d("onItemSwipeStart");
        }

        @Override
        public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
            MLog.d("clearView");
        }

        @Override
        public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
            MLog.d("onItemSwiped");
        }

        @Override
        public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {
            MLog.d("onItemSwipeMoving");
        }
    };

    private OnItemDragListener mOnItemDragListener = new OnItemDragListener() {
        @Override
        public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
            MLog.d("onItemDragStart");
        }

        @Override
        public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
            MLog.d("onItemDragMoving");
        }

        @Override
        public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
            MLog.d("onItemDragEnd");
        }
    };
}
