package com.yxl.football.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yxl.football.R;
import com.yxl.football.entiy.Score;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/7 0007.
 */

public class MatchResultAdapter extends SectioningAdapter {

    public class ItemViewHolder extends SectioningAdapter.ItemViewHolder {
        TextView tvHomeTeam;
        TextView tvAwayTeam;
        TextView tvMatchTime;
        TextView tvMatchName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tvHomeTeam = (TextView) itemView.findViewById(R.id.tvHomeTeam);
            tvAwayTeam = (TextView) itemView.findViewById(R.id.tvAwayTeam);
            tvMatchTime = (TextView) itemView.findViewById(R.id.tvMatchTime);
            tvMatchName = (TextView) itemView.findViewById(R.id.tvMatchName);
        }
    }

    public class HeaderViewHolder extends SectioningAdapter.HeaderViewHolder {
        TextView tvMatchDate;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            tvMatchDate = (TextView) itemView.findViewById(R.id.tvMatchDate);
        }
    }

    List<Score> matchResults;
    ArrayList<Section> sections = new ArrayList<>();

    private class Section {
        String matchDate;
        ArrayList<Score> matchResults = new ArrayList<>();
    }

    public MatchResultAdapter() {

    }

    public List<Score> getMatchResult() {
        return matchResults;
    }

    public void setMatchResult(List<Score> matchResults) {
        this.matchResults = matchResults;
        sections.clear();

        // sort people into buckets by the first letter of last name
        String vsDate = "";
        Section currentSection = null;
        for (Score matchResult : matchResults) {
            if (!vsDate.equals(matchResult.getVsdate())) {
                if (currentSection != null) {
                    sections.add(currentSection);
                }
                currentSection = new Section();
                vsDate = matchResult.getVsdate();
                currentSection.matchDate = vsDate;
            }

            if (currentSection != null) {
                currentSection.matchResults.add(matchResult);
            }
        }
        sections.add(currentSection);
        notifyAllSectionsDataSetChanged();
    }

    @Override
    public int getNumberOfSections() {
        return sections.size();
    }

    @Override
    public int getNumberOfItemsInSection(int sectionIndex) {
        if (sections.get(0) == null) {
            return 0;
        }
        return sections.get(sectionIndex).matchResults.size();
    }

    @Override
    public boolean doesSectionHaveHeader(int sectionIndex) {
        return true;
    }

    @Override
    public boolean doesSectionHaveFooter(int sectionIndex) {
        return false;
    }

    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_item_match_result, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_item_match_date_header, parent, false);
        return new HeaderViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemViewHolder(SectioningAdapter.ItemViewHolder viewHolder, int
            sectionIndex, int itemIndex, int itemType) {
        Section s = sections.get(sectionIndex);
        ItemViewHolder ivh = (ItemViewHolder) viewHolder;
        Score matchResult = s.matchResults.get(itemIndex);
        if (matchResult != null) {
            ivh.tvHomeTeam.setText(matchResult.getHname());
            ivh.tvAwayTeam.setText(matchResult.getAname());
            ivh.tvMatchTime.setText(matchResult.getVsdate());
            ivh.tvMatchName.setText(matchResult.getLname());
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindHeaderViewHolder(SectioningAdapter.HeaderViewHolder viewHolder, int
            sectionIndex, int headerType) {
        Section s = sections.get(sectionIndex);
        if (s != null) {
            HeaderViewHolder hvh = (HeaderViewHolder) viewHolder;
            hvh.tvMatchDate.setText(s.matchDate);
        }
    }

}
