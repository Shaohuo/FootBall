package com.yxl.football.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.yxl.football.R;
import com.yxl.football.adapter.MatchResultAdapter;
import com.yxl.football.adapter.StickyHeaderLayoutManager;
import com.yxl.football.entiy.MatchResult;
import com.yxl.football.entiy.TabEntity;


import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private String[] mTitles = {"即时", "赛果", "赛程", "关注"};
    private RecyclerView mRecyclerView;
    private CommonTabLayout mTablayout;
    private MatchResultAdapter mMatchResultAdapter = new MatchResultAdapter();
    private List<MatchResult> mMatchResults = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        mTablayout = (CommonTabLayout) view.findViewById(R.id.tabLayout);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mTabEntities.clear();
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], -1, -1));
        }
        mTablayout.setTabData(mTabEntities);
        mMatchResults.clear();
        for (int i = 0; i < 5; i++) {
            MatchResult matchResult = new MatchResult();
            matchResult.home_team = "德黑兰";
            matchResult.away_team = "伊杜宗";
            matchResult.match_date = "2月9号";
            matchResult.match_time = "10:30";
            matchResult.match_name = "伊朗超";
            mMatchResults.add(matchResult);
        }
        for (int i = 0; i < 6; i++) {
            MatchResult matchResult = new MatchResult();
            matchResult.home_team = "莱特";
            matchResult.away_team = "彼司克";
            matchResult.match_date = "2月10号";
            matchResult.match_time = "15:30";
            matchResult.match_name = "荷乙";
            mMatchResults.add(matchResult);
        }
        mMatchResultAdapter.setMatchResult(mMatchResults);
        mRecyclerView.setAdapter(mMatchResultAdapter);
        mRecyclerView.setLayoutManager(new StickyHeaderLayoutManager());
        return view;
    }

}
