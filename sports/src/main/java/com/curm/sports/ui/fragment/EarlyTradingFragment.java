package com.curm.sports.ui.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.curm.sports.R;
import com.curm.sports.ui.adpater.BallTypeAdapter;
import com.curm.sports.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class EarlyTradingFragment extends BaseFragment {

    RecyclerView recyclerView;

    BallTypeAdapter myAdapter;
    List<String> listData = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.fragment_early_trading;
    }

    @Override
    protected void initView(View view, ViewGroup container) {
        recyclerView = view.findViewById(R.id.recyclerView);

        myAdapter = new BallTypeAdapter(R.layout.ball_type_item,listData);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                myAdapter.setSelectType(position);
            }
        });
    }

    @Override
    protected void initData(Context mContext) {
        listData.add("足球");
        listData.add("篮球");
        listData.add("网球");
        listData.add("排球");
        listData.add("羽毛球");
        listData.add("乒乓球");
        listData.add("冰球");
        myAdapter.notifyDataSetChanged();
    }
}
