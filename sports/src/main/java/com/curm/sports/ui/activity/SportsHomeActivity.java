package com.curm.sports.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.curm.sports.R;
import com.curm.sports.ui.fragment.CascadeFragment;
import com.curm.sports.ui.fragment.EarlyTradingFragment;
import com.curm.sports.ui.fragment.FollowFragment;
import com.curm.sports.ui.fragment.ToDayFragment;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

public class SportsHomeActivity extends RxAppCompatActivity implements View.OnClickListener {

    private Fragment currentFragment = new Fragment();

    ToDayFragment toDayFragment;
    EarlyTradingFragment earlyTradingFragment;
    CascadeFragment cascadeFragment;
    FollowFragment followFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_home);

        findViewById(R.id.ll_jinri).setOnClickListener(this::onClick);
        findViewById(R.id.ll_zaopan).setOnClickListener(this::onClick);
        findViewById(R.id.ll_chuanguan).setOnClickListener(this::onClick);
        findViewById(R.id.ll_guanzhu).setOnClickListener(this::onClick);

        toDayFragment = new ToDayFragment();
        earlyTradingFragment = new EarlyTradingFragment();
        cascadeFragment = new CascadeFragment();
        followFragment = new FollowFragment();
        switchFragment(R.id.frame,toDayFragment).commit();

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.ll_jinri){
            switchFragment(R.id.frame,toDayFragment).commit();
        }else if (view.getId()==R.id.ll_zaopan){
            switchFragment(R.id.frame,earlyTradingFragment).commit();
        }else if (view.getId()==R.id.ll_chuanguan){
            switchFragment(R.id.frame,cascadeFragment).commit();
        }else if (view.getId()==R.id.ll_guanzhu){
            switchFragment(R.id.frame,followFragment).commit();
        }
    }

    public FragmentTransaction switchFragment(int viewId, Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(viewId, targetFragment, targetFragment.getClass().getName());
        } else {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment);
        }
        currentFragment = targetFragment;
        return transaction;
    }
}
