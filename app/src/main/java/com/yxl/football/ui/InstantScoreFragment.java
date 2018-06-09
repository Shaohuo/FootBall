package com.yxl.football.ui;


import android.app.Activity;
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
import com.yxl.football.adapter.InstantScoreAdapter;
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


public class InstantScoreFragment extends Fragment {
    private View view;
    private List<Score> mScores = new ArrayList<>();
    private InstantScoreAdapter mInstantScoreAdapter = new InstantScoreAdapter(mScores);
    private RecyclerView mRecyclerView;
    private EasyRefreshLayout mEasyRefreshLayout;

    public InstantScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null){
             view = inflater.inflate(R.layout.fragment_instant_score, container, false);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null){
            parent.removeView(view);
        }
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mEasyRefreshLayout = (EasyRefreshLayout) view.findViewById(R.id.easylayout);
        mEasyRefreshLayout.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {

            }

            @Override
            public void onRefreshing() {
                loadData();
            }
        });
        mRecyclerView.setAdapter(mInstantScoreAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        loadData();
        return view;
    }

    private void loadData() {
        mScores.clear();
        Call<InstantScoreListModel> call = ApiManager.getInstance().create(ApiServer
                .class).getInstantScoreList("3", "", SystemClock
                .currentThreadTimeMillis() + "", "1", "1", "c28d797bdf3f789e759150cdac45957a");
        call.enqueue(new Callback<InstantScoreListModel>() {
            @Override
            public void onResponse(Call<InstantScoreListModel> call,
                                   Response<InstantScoreListModel> response) {
                mEasyRefreshLayout.refreshComplete();
                if (response.isSuccessful() && response.body() != null) {
                    Log.e("GameFragment", "" + response.body().toString());
                    mScores.clear();
                    mScores.addAll(response.body().getData().getList());
                    mRecyclerView.setAdapter(mInstantScoreAdapter);
                    mInstantScoreAdapter.setNewData(mScores);
                }
            }

            @Override
            public void onFailure(Call<InstantScoreListModel> call, Throwable t) {
                mEasyRefreshLayout.refreshComplete();
            }
        });
    }

}
