package com.yxl.football.adapter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yxl.football.R;
import com.yxl.football.entiy.Score;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/31 0031.
 */

public class EndingScoreAdapter extends BaseQuickAdapter<Score, BaseViewHolder> {

    public EndingScoreAdapter(@Nullable List<Score> data) {
        super(R.layout.list_item_match_result, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Score item) {

        helper.setText(R.id.tvHomeTeam, item.getHname());
        helper.setText(R.id.tvAwayTeam, item.getAname());
        helper.setText(R.id.tvMatchTime, item.getStime());
        helper.setText(R.id.tvMatchName, item.getLname());
        helper.setText(R.id.tvTime, "完");
        helper.setText(R.id.tvHalfScore, "半场" + item.getHhalfscore() + ":" + item.getAhalfscore());
        helper.setText(R.id.tvHscore, item.getHscore());
        helper.setText(R.id.tvAscore, item.getAscore());
        helper.setTextColor(R.id.tvHscore, Color.parseColor("#6fb338"));
        helper.setTypeface(R.id.tvHscore, Typeface.DEFAULT_BOLD);
        helper.setTextColor(R.id.tvAscore, Color.parseColor("#6fb338"));
        helper.setTypeface(R.id.tvAscore, Typeface.DEFAULT_BOLD);
//        setTime(helper, item);
    }

    private void setTime(BaseViewHolder helper, Score item) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date vsDate = simpleDateFormat.parse(item.getVsdate());
            Date vsHalfDate = simpleDateFormat.parse(item.getHalfstarttime());
            long vsTime = vsDate.getTime();
            long vsHalfTime = vsHalfDate.getTime();
            long currentTime = System.currentTimeMillis();
            if (currentTime < vsTime) {
                helper.setText(R.id.tvTime, "未");
                helper.setText(R.id.tvHscore, "-");
                helper.setText(R.id.tvAscore, "-");
                helper.setTypeface(R.id.tvHscore, Typeface.DEFAULT);
                helper.setTypeface(R.id.tvAscore, Typeface.DEFAULT);
                helper.setTextColor(R.id.tvTime, Color.parseColor("#c1c1c1"));
                helper.setTextColor(R.id.tvHscore, Color.parseColor("#c1c1c1"));
                helper.setTextColor(R.id.tvAscore, Color.parseColor("#c1c1c1"));
            } else {
                helper.setTextColor(R.id.tvTime, Color.GRAY);
                if (vsHalfTime - vsTime < 45 * 60 * 1000) {
                    if (currentTime - vsTime < 45 * 60 * 1000) {
                        long time = (currentTime - vsTime) / 1000 / 60;
                        helper.setText(R.id.tvTime, (int) time + "´");
                    } else {
                        helper.setText(R.id.tvTime, "中");
                    }
                } else {
                    long time = (currentTime - vsHalfTime) / 1000 / 60;
                    helper.setText(R.id.tvTime, ((int) time + 45) + "´");
                }
                helper.setText(R.id.tvHscore, item.getHscore());
                helper.setText(R.id.tvAscore, item.getAscore());
                helper.setTextColor(R.id.tvHscore, Color.parseColor("#6fb338"));
                helper.setTypeface(R.id.tvHscore, Typeface.DEFAULT_BOLD);
                helper.setTextColor(R.id.tvAscore, Color.parseColor("#6fb338"));
                helper.setTypeface(R.id.tvAscore, Typeface.DEFAULT_BOLD);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
