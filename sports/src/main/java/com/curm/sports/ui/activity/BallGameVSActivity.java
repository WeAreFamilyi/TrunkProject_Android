package com.curm.sports.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.curm.sports.R;
import com.curm.sports.ui.adpater.BallGameVSAdapter;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class BallGameVSActivity extends RxAppCompatActivity {

    TextView tv_name;
    RecyclerView recyclerView;

    BallGameVSAdapter adapter;
    List<String> listData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball_game_vs);
        init();
    }

    private void init() {

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.iv_danzhu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getParent(),BetRecordActivity.class));
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        tv_name = findViewById(R.id.tv_name);

        String name = getIntent().getStringExtra("name");
        tv_name.setText(name);

        adapter = new BallGameVSAdapter(R.layout.activity_ball_game_vs_item,listData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getParent(), BallGameDetailActivity.class));
            }
        });

        initData();
    }

    private void initData() {
        listData.add("");
        listData.add("");
        listData.add("");
        adapter.notifyDataSetChanged();
    }
}
