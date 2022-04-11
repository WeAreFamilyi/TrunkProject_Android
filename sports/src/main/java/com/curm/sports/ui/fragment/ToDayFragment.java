package com.curm.sports.ui.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.curm.sports.R;
import com.curm.sports.ui.adpater.BallGameAdapter;
import com.curm.sports.ui.adpater.BallTypeAdapter;
import com.curm.sports.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class ToDayFragment extends BaseFragment {

    RecyclerView recyclerView;
    RecyclerView recyclerView2;

    BallTypeAdapter myAdapter;
    List<String> listData = new ArrayList<>();

    BallGameAdapter gameAdapter;
    List<String> listDataBall = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.fragment_to_day;
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

        recyclerView2 = view.findViewById(R.id.recyclerView2);

        listDataBall.add("墨西哥超级联赛");
        listDataBall.add("南美解放者杯");
        listDataBall.add("危地马拉乙级联赛");

        gameAdapter = new BallGameAdapter(listDataBall,getActivity());
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView2.setAdapter(gameAdapter);

    }

    @Override
    protected void initData(Context mContext) {
        listData.add("足球");
        listData.add("篮球");
        listData.add("电竞足球");
        listData.add("网球");
        listData.add("排球");
        listData.add("羽毛球");
        listData.add("乒乓球");
        listData.add("冰球");
        myAdapter.notifyDataSetChanged();

    }
}
