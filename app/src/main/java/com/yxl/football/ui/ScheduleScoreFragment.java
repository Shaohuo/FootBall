package com.yxl.football.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajguan.library.EasyRefreshLayout;
import com.yxl.football.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleScoreFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private EasyRefreshLayout mEasyRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mEasyRefreshLayout = (EasyRefreshLayout) view.findViewById(R.id.easylayout);
        mEasyRefreshLayout.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {

            }

            @Override
            public void onRefreshing() {
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

}
