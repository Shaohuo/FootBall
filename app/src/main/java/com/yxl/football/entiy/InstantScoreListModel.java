package com.yxl.football.entiy;

import java.util.List;

/**
 * Created by Administrator on 2018/5/31 0031.
 */

public class InstantScoreListModel extends BaseApiModel {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        private String cid;
        private String stid;
        private String t;
        private String time;
        private List<Score> list;
        private List<?> goals;

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getStid() {
            return stid;
        }

        public void setStid(String stid) {
            this.stid = stid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public List<Score> getList() {
            return list;
        }

        public void setList(List<Score> list) {
            this.list = list;
        }

        public List<?> getGoals() {
            return goals;
        }

        public void setGoals(List<?> goals) {
            this.goals = goals;
        }

    }
}
