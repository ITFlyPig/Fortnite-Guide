package com.igameguide.pubg.detail.bean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 排位的信息
 */
public class Paiwei implements Serializable {

    public float assists;
    public float bestRankPoint;
    public float boosts;
    public float dBNOs;
    public float dailyKills;
    public float dailyWins;
    public float damageDealt;
    public float days;
    public float headshotKills;
    public float heals;
    public float killPoints;
    public float kills;
    public float longestKill;
    public float longestTimeSurvived;
    public float losses;
    public float maxKillStreaks;
    public float mostSurvivalTime;
    public float rankPoints;
    public float revives;
    public float rideDistance;
    public float roadKills;
    public float roundMostKills;
    public float roundsPlayed;
    public float suicides;
    public float swimDistance;
    public float teamKills;
    public float timeSurvived;
    public float top10s;
    public float vehicleDestroys;
    public float walkDistance;
    public float weaponsAcquired;
    public float weeklyKills;
    public float weeklyWins;
    public float winPoints;
    public float wins;
    //Score(score) ,wins(wins) ,Win%(winLv) ,Top 10(top10s),Kills(kills),K/d(kd),Matches Played(matchesPlayed)
    public String score = "0";
    public String winLv = "0%";//就是Win%
    public String kd = "0";
    public String matchesPlayed = "0";
    public String winsStr = "0";
    public String top10sStr = "0";
    public String killsStr = "0";
    public String top3s = "0";
    public String top5s = "0";
    public String top6s = "0";
    public String top12s = "0";
    public String top25s = "0";

    public List<HeaderBean> headerBeans;
    public List<HItemBean> hItemBeans;


    public static Paiwei parseForfornitegame(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        Paiwei paiwei = new Paiwei();
        JSONArray jsonArray = jsonObject.getJSONArray("lifeTimeStats");
        if (jsonArray == null) {
            return paiwei;
        }
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            String key = obj.getString("key");
            String value = obj.getString("value");
            if (key.equals("Score")) {
                paiwei.score = value;
            } else if (key.equals("Wins")) {
                paiwei.winsStr = value;
            } else if (key.equals("Win%")) {
                paiwei.winLv = value;
            } else if (key.equals("Top 10")) {
                paiwei.top10sStr = value;
            } else if (key.equals("Kills")) {
                paiwei.killsStr = value;
            } else if (key.equals("K/d")) {
                paiwei.kd = value;
            } else if (key.equals("Matches Played")) {
                paiwei.matchesPlayed = value;
            } else if (key.equals("Top 3s")) {
                paiwei.top3s = value;
            } else if (key.equals("Top 5s")) {
                paiwei.top5s = value;
            } else if (key.equals("Top 6s")) {
                paiwei.top6s = value;
            } else if (key.equals("Top 12s")) {
                paiwei.top12s = value;
            } else if (key.equals("Top 25s")) {
                paiwei.top25s = value;
            }

        }
        return paiwei;
    }


    public static Paiwei parseForHeaderBean(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        JSONArray jsonArray = jsonObject.getJSONArray("lifeTimeStats");
        if (jsonArray == null) {
            return null;
        }
        Paiwei paiwei = new Paiwei();
        List<HeaderBean> list = new ArrayList<>();
        paiwei.headerBeans = list;
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            String key = obj.getString("key");
            String value = obj.getString("value");
            String showKey = null;
            if (key.equals("Score")) {
                showKey = "Score";
            } else if (key.equals("Wins")) {
                showKey = "wins";
            } else if (key.equals("Win%")) {
                showKey = "Win%";
            } else if (key.equals("Top 10")) {
                showKey = "Top 10";
            } else if (key.equals("Kills")) {
                showKey = "Kills";
            } else if (key.equals("K/d")) {
                showKey = "K/d";
            } else if (key.equals("Matches Played")) {
                showKey = "Matches Played";
            } else if (key.equals("Top 3s")) {
                showKey = "Top 3s";
            } else if (key.equals("Top 5s")) {
                showKey = "Top 5s";
            } else if (key.equals("Top 6s")) {
                showKey = "Top 6s";
            } else if (key.equals("Top 12s")) {
                showKey = "Top 12s";
            } else if (key.equals("Top 25s")) {
                showKey = "Top 25s";
            }
            HeaderBean bean = new HeaderBean();
            bean.key = showKey;
            bean.value = value;
            list.add(bean);

        }
        return paiwei;
    }

    /**
     * 构造空的显示数据
     *
     * @return
     */
    public static Paiwei getEmptyHeaderBean() {
        String[] keys = new String[]{"Score", "wins", "Win%", "Top 10", "Kills", "K/d", "Matches Played", "Top 3s",
                "Top 5s", "Top 6s", "top 12s", "Top 25s"};
        Paiwei paiwei = new Paiwei();
        paiwei.headerBeans = new ArrayList<>();

        for (String key : keys) {
            HeaderBean bean = new HeaderBean();
            bean.key = key;
            bean.value = "0";
            paiwei.headerBeans.add(bean);
        }
        return paiwei;

    }


    public static List<HItemBean> parseForHItems(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        JSONArray jsonArray = jsonObject.getJSONArray("recentMatches");
        if (jsonArray == null) {
            return null;
        }
        List<HItemBean> list = new ArrayList<>();
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            HItemBean hItemBean = new HItemBean();
            hItemBean.date = obj.getString("dateCollected");
            hItemBean.kills = obj.getString("kills");
            hItemBean.rating = obj.getString("trnRating");
            hItemBean.score = obj.getString("score");
            list.add(hItemBean);
        }
        return list;
    }


}


