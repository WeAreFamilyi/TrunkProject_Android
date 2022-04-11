package com.curm.sports.ui.adpater;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.curm.sports.R;
import com.curm.sports.ui.activity.BallGameDetailActivity;
import com.curm.sports.ui.activity.BallGameVSActivity;
import com.githang.groundrecycleradapter.GroupRecyclerAdapter;

import java.util.List;

public class BallGameAdapter extends GroupRecyclerAdapter<String, BallGameAdapter.BallGroupView, BallGameAdapter.BallChildView> {
    LayoutInflater layoutInflater;
    Context context ;
    public BallGameAdapter(List<String> groups, Context context) {
        super(groups);
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    protected BallGroupView onCreateGroupViewHolder(ViewGroup parent) {
        return new BallGroupView(layoutInflater.inflate(R.layout.ball_game_group, parent, false));
    }

    @Override
    protected BallChildView onCreateChildViewHolder(ViewGroup parent) {
        return new BallChildView(layoutInflater.inflate(R.layout.ball_game_child, parent, false));
    }

    @Override
    protected void onBindGroupViewHolder(BallGroupView groupView, int poition) {

        groupView.tv_name.setText(getGroup(poition));

        groupView.ll_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, BallGameVSActivity.class).putExtra("name",getGroup(poition)));
            }
        });
    }

    @Override
    protected void onBindChildViewHolder(BallChildView childView, int groupPosition, int childPosition) {
        childView.ll_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, BallGameDetailActivity.class));
            }
        });
    }

    @Override
    protected int getChildCount(String group) {
        return 2;
    }

    public class BallGroupView extends RecyclerView.ViewHolder{

        LinearLayout ll_item;
        TextView tv_name;
        public BallGroupView(@NonNull View itemView) {
            super(itemView);
            ll_item = itemView.findViewById(R.id.ll_item);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }

    public class BallChildView extends RecyclerView.ViewHolder{

        LinearLayout ll_item;

        public BallChildView(@NonNull View itemView) {
            super(itemView);
            ll_item = itemView.findViewById(R.id.ll_item);
        }
    }
}
