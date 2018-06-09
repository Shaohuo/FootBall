package com.yxl.football.ui;


import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajguan.library.EasyRefreshLayout;
import com.yxl.football.R;
import com.yxl.football.adapter.EndingScoreAdapter;
import com.yxl.football.api.ApiManager;
import com.yxl.football.api.ApiServer;
import com.yxl.football.entiy.Score;
import com.yxl.football.entiy.InstantScoreListModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class EndingScoreFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private List<Score> mEndingScores = new ArrayList<>();
    private EndingScoreAdapter mEndingScoreAdapter = new EndingScoreAdapter(mEndingScores);
    private EasyRefreshLayout mEasyRefreshLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("EndingScoreFragment", "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("EndingScoreFragment", "onCreateView");
        // Inflate the layout for this fragment
        // 设置下拉刷新和上拉加载更多的风格
        View view = inflater.inflate(R.layout.fragment_ending_score, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mEasyRefreshLayout = (EasyRefreshLayout) view.findViewById(R.id.easylayout);
        mEasyRefreshLayout.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {

            }

            @Override
            public void onRefreshing() {
                loadingData();
            }
        });

        mRecyclerView.setAdapter(mEndingScoreAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        loadingData();
        return view;
    }

    private void loadingData() {
        mEndingScores.clear();
        Call<InstantScoreListModel> call = ApiManager.getInstance().create(ApiServer
                .class).getInstantScoreList("3", "", SystemClock
                .currentThreadTimeMillis() + "", "2", "1", "c28d797bdf3f789e759150cdac45957a");
        call.enqueue(new Callback<InstantScoreListModel>() {
            @Override
            public void onResponse(Call<InstantScoreListModel> call,
                                   Response<InstantScoreListModel> response) {
                mEasyRefreshLayout.refreshComplete();
                if (response.isSuccessful() && response.body() != null) {
                    Log.e("GameFragment", "" + response.body().toString());
                    mEndingScores.clear();
                    mEndingScores.addAll(response.body().getData().getList());
                    mEndingScoreAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<InstantScoreListModel> call, Throwable t) {
                mEasyRefreshLayout.refreshComplete();
            }
        });
    }


}
