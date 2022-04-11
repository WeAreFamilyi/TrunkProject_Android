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

public class BetTypeFragment extends BaseFragment {

    @Override
    protected int initLayout() {
        return R.layout.fragment_bet_type;
    }

    @Override
    protected void initView(View view, ViewGroup container) {

    }

    @Override
    protected void initData(Context mContext) {

    }
}
