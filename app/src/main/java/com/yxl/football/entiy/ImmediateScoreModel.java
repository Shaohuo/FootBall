package com.yxl.football.entiy;

import java.util.List;

/**
 * Created by Administrator on 2018/5/28 0028.
 */

public class ImmediateScoreModel {

    private boolean ok;
    private int code;
    private String msg;
    private DataBean data;
    private long stamp;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public long getStamp() {
        return stamp;
    }

    public void setStamp(long stamp) {
        this.stamp = stamp;
    }

    public static class DataBean {

        private String issue;
        private String date;
        private int counts;
        private List<ScoresBean> scores;
        private List<String> issues;
        private List<?> leagues;

        public String getIssue() {
            return issue;
        }

        public void setIssue(String issue) {
            this.issue = issue;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getCounts() {
            return counts;
        }

        public void setCounts(int counts) {
            this.counts = counts;
        }

        public List<ScoresBean> getScores() {
            return scores;
        }

        public void setScores(List<ScoresBean> scores) {
            this.scores = scores;
        }

        public List<String> getIssues() {
            return issues;
        }

        public void setIssues(List<String> issues) {
            this.issues = issues;
        }

        public List<?> getLeagues() {
            return leagues;
        }

        public void setLeagues(List<?> leagues) {
            this.leagues = leagues;
        }

        public static class ScoresBean {

            private String no;
            private String league;
            private String begin;
            private boolean follow;
            private String score;
            private String halfScore;
            private String homeName;
            private String visitingName;
            private int homeRed;
            private int homeYellow;
            private int visitingRed;
            private int visitingYellow;
            private String step;
            private int state;
            private String issueNo;
            private String spfsp;
            private boolean exception;
            private boolean goalActivity;
            private String homeLogo;
            private String visitingLogo;

            @Override
            public String toString() {
                return "ScoresBean{" +
                        "no='" + no + '\'' +
                        ", league='" + league + '\'' +
                        ", begin='" + begin + '\'' +
                        ", follow=" + follow +
                        ", score='" + score + '\'' +
                        ", halfScore='" + halfScore + '\'' +
                        ", homeName='" + homeName + '\'' +
                        ", visitingName='" + visitingName + '\'' +
                        ", homeRed=" + homeRed +
                        ", homeYellow=" + homeYellow +
                        ", visitingRed=" + visitingRed +
                        ", visitingYellow=" + visitingYellow +
                        ", step='" + step + '\'' +
                        ", state=" + state +
                        ", issueNo='" + issueNo + '\'' +
                        ", spfsp='" + spfsp + '\'' +
                        ", exception=" + exception +
                        ", goalActivity=" + goalActivity +
                        ", homeLogo='" + homeLogo + '\'' +
                        ", visitingLogo='" + visitingLogo + '\'' +
                        '}';
            }

            public String getNo() {
                return no;
            }

            public void setNo(String no) {
                this.no = no;
            }

            public String getLeague() {
                return league;
            }

            public void setLeague(String league) {
                this.league = league;
            }

            public String getBegin() {
                return begin;
            }

            public void setBegin(String begin) {
                this.begin = begin;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getHalfScore() {
                return halfScore;
            }

            public void setHalfScore(String halfScore) {
                this.halfScore = halfScore;
            }

            public String getHomeName() {
                return homeName;
            }

            public void setHomeName(String homeName) {
                this.homeName = homeName;
            }

            public String getVisitingName() {
                return visitingName;
            }

            public void setVisitingName(String visitingName) {
                this.visitingName = visitingName;
            }

            public int getHomeRed() {
                return homeRed;
            }

            public void setHomeRed(int homeRed) {
                this.homeRed = homeRed;
            }

            public int getHomeYellow() {
                return homeYellow;
            }

            public void setHomeYellow(int homeYellow) {
                this.homeYellow = homeYellow;
            }

            public int getVisitingRed() {
                return visitingRed;
            }

            public void setVisitingRed(int visitingRed) {
                this.visitingRed = visitingRed;
            }

            public int getVisitingYellow() {
                return visitingYellow;
            }

            public void setVisitingYellow(int visitingYellow) {
                this.visitingYellow = visitingYellow;
            }

            public String getStep() {
                return step;
            }

            public void setStep(String step) {
                this.step = step;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public String getIssueNo() {
                return issueNo;
            }

            public void setIssueNo(String issueNo) {
                this.issueNo = issueNo;
            }

            public String getSpfsp() {
                return spfsp;
            }

            public void setSpfsp(String spfsp) {
                this.spfsp = spfsp;
            }

            public boolean isException() {
                return exception;
            }

            public void setException(boolean exception) {
                this.exception = exception;
            }

            public boolean isGoalActivity() {
                return goalActivity;
            }

            public void setGoalActivity(boolean goalActivity) {
                this.goalActivity = goalActivity;
            }

            public String getHomeLogo() {
                return homeLogo;
            }

            public void setHomeLogo(String homeLogo) {
                this.homeLogo = homeLogo;
            }

            public String getVisitingLogo() {
                return visitingLogo;
            }

            public void setVisitingLogo(String visitingLogo) {
                this.visitingLogo = visitingLogo;
            }
        }
    }
}
