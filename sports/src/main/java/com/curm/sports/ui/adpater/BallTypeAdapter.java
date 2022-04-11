package com.curm.sports.ui.adpater;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.curm.sports.R;

import java.util.List;

public class BallTypeAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private int index = 0 ;

    public BallTypeAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        LinearLayout ll_item = helper.getView(R.id.ll_item);
        ImageView iv_ball_type = helper.getView(R.id.iv_ball_type);
        TextView tv_title = helper.getView(R.id.tv_title);
        TextView tv_number = helper.getView(R.id.tv_number);
        tv_title.setText(item);
        int position = helper.getLayoutPosition();
        if (index==position){
            ll_item.setBackgroundResource(R.mipmap.ico_qiulei_true);
            tv_title.setTextColor(mContext.getResources().getColor(R.color.white));
            tv_number.setTextColor(mContext.getResources().getColor(R.color.white));
            if (item.equals("足球")){
                iv_ball_type.setImageResource(R.mipmap.zhuqiu_true);
            }else if (item.equals("篮球")){
                iv_ball_type.setImageResource(R.mipmap.lanqiu_true);
            }else if (item.equals("电竞足球")){
                iv_ball_type.setImageResource(R.mipmap.dianjin_true);
            }else if (item.equals("网球")){
                iv_ball_type.setImageResource(R.mipmap.wangqiu_true);
            }else if (item.equals("排球")){
                iv_ball_type.setImageResource(R.mipmap.paiqiu_true);
            }else if (item.equals("羽毛球")){
                iv_ball_type.setImageResource(R.mipmap.yumaoqiu_true);
            }else if (item.equals("乒乓球")){
                iv_ball_type.setImageResource(R.mipmap.ppq_true);
            }else if (item.equals("冰球")){
                iv_ball_type.setImageResource(R.mipmap.bingqiu_true);
            }
        }else {
            ll_item.setBackgroundResource(R.mipmap.ico_qiulei_false);
            tv_title.setTextColor(mContext.getResources().getColor(R.color.color_666666));
            tv_number.setTextColor(mContext.getResources().getColor(R.color.color_666666));
            if (item.equals("足球")){
                iv_ball_type.setImageResource(R.mipmap.zhuqiu_false);
            }else if (item.equals("篮球")){
                iv_ball_type.setImageResource(R.mipmap.lanqiu_false);
            }else if (item.equals("电竞足球")){
                iv_ball_type.setImageResource(R.mipmap.dianjin_false);
            }else if (item.equals("网球")){
                iv_ball_type.setImageResource(R.mipmap.wangqiu_false);
            }else if (item.equals("排球")){
                iv_ball_type.setImageResource(R.mipmap.paiqiu_false);
            }else if (item.equals("羽毛球")){
                iv_ball_type.setImageResource(R.mipmap.yumaoqiu_false);
            }else if (item.equals("乒乓球")){
                iv_ball_type.setImageResource(R.mipmap.poq_flase);
            }else if (item.equals("冰球")){
                iv_ball_type.setImageResource(R.mipmap.bingqiu_false);
            }
        }
    }

    public void setSelectType(int position){
        index = position;
        notifyDataSetChanged();
    }

}
