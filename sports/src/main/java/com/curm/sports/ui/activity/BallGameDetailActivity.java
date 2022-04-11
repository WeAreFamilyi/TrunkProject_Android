package com.curm.sports.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.curm.sports.R;
import com.curm.sports.ui.fragment.BetFragment;
import com.curm.sports.ui.fragment.ChatFragment;
import com.curm.sports.ui.fragment.DataFragment;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

public class BallGameDetailActivity extends RxAppCompatActivity implements View.OnClickListener {

    private Fragment currentFragment = new Fragment();

    BetFragment betFragment;
    ChatFragment chatFragment;
    DataFragment dataFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball_game_detail);
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

        findViewById(R.id.rb_touzhu).setOnClickListener(this::onClick);
        findViewById(R.id.rb_liaotian).setOnClickListener(this::onClick);
        findViewById(R.id.rb_shuju).setOnClickListener(this::onClick);

        betFragment = new BetFragment();
        chatFragment = new ChatFragment();
        dataFragment = new DataFragment();
        switchFragment(R.id.frame,betFragment).commit();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.rb_touzhu) {
            switchFragment(R.id.frame,betFragment).commit();
        }else if (view.getId() == R.id.rb_liaotian){
            switchFragment(R.id.frame,chatFragment).commit();
        }else if (view.getId() == R.id.rb_shuju){
            switchFragment(R.id.frame,dataFragment).commit();
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
