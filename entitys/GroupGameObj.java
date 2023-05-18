package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class GroupGameObj implements Serializable {
    private static final long serialVersionUID = 8549063591483498399L;
    @p9.c("TVNetworks")
    public HashMap<Integer, TvNetworkObj> TvNetworks;
    @p9.c("Competitors")
    private CompObj[] competitors;
    @p9.c("GameID")
    public int gameId;
    @p9.c("Game")
    public GameObj gameObj;
    public String groupName = "";
    @p9.c("Possible")
    public boolean isPossibleGame;
    @p9.c("Num")
    public int num;
    @p9.c("Officials")
    public ArrayList<PlayerObj> officialsList;
    @p9.c("PenaltyScore")
    private ScoreObj[] penaltyScore;
    @p9.c("SeasonNum")
    private int seasonNum;
    @p9.c("SportTypeID")
    private int sportTypeId;
    @p9.c("StageNum")
    private int stageNum;
    @p9.c("StartTime")
    public Date startTime;
    @p9.c("UseName")
    public boolean useName;
    @p9.c("Venue")
    public VenueObj venueObj;

    public GroupGameObj(int i10, boolean z10, Date date, int i11, VenueObj venueObj, ArrayList<PlayerObj> arrayList, HashMap<Integer, TvNetworkObj> hashMap, GameObj gameObj) {
        new HashMap();
        this.isPossibleGame = false;
        this.num = i10;
        this.useName = z10;
        this.startTime = date;
        this.gameId = i11;
        this.venueObj = venueObj;
        this.officialsList = arrayList;
        this.TvNetworks = hashMap;
        this.gameObj = gameObj;
    }

    public static GroupGameObj parse(String str) {
        return (GroupGameObj) GsonManager.getGson().l(str, GroupGameObj.class);
    }

    public int getAwayPenaltyScore() {
        ScoreObj[] scoreObjArr = this.penaltyScore;
        if (scoreObjArr == null || scoreObjArr.length <= 1) {
            return -1;
        }
        return scoreObjArr[1].getScore();
    }

    public CompObj[] getCompetitors() {
        return this.competitors;
    }

    public int getHomePenaltyScore() {
        ScoreObj[] scoreObjArr = this.penaltyScore;
        if (scoreObjArr == null || scoreObjArr.length <= 0) {
            return -1;
        }
        return scoreObjArr[0].getScore();
    }

    public int getSeasonNum() {
        return this.seasonNum;
    }

    public int getSportTypeId() {
        return this.sportTypeId;
    }

    public int getStageNum() {
        return this.stageNum;
    }
}
