package com.curm.sports.ui.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.curm.sports.R;
import com.curm.sports.ui.adpater.BetFragmentAdapter;
import com.curm.sports.ui.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class BetFragment extends BaseFragment {

    TabLayout tab_layout;
    ViewPager viewPage;

    BetFragmentAdapter adapter;

    @Override
    protected int initLayout() {
        return R.layout.fragment_bet;
    }

    @Override
    protected void initView(View view, ViewGroup container) {
        tab_layout = view.findViewById(R.id.tab_layout);
        viewPage = view.findViewById(R.id.viewPage);
    }

    @Override
    protected void initData(Context mContext) {
        List<String> listTitle = new ArrayList<>();
        listTitle.add("全部");
        listTitle.add("热门");
        listTitle.add("让球&大小");
        listTitle.add("波胆");
        listTitle.add("进球");
        listTitle.add("特殊");
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < listTitle.size(); i++) {
            fragments.add(new BetTypeFragment());
        }
        adapter = new BetFragmentAdapter(getChildFragmentManager(),listTitle,fragments);
        viewPage.setAdapter(adapter);
        //头部导航栏
        tab_layout.setupWithViewPager(viewPage);

    }
}
