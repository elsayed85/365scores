package com.scores365.entitys;

import com.scores365.App;
import java.io.Serializable;
import li.x0;
/* loaded from: classes2.dex */
public class EventObj implements Serializable, Comparable<EventObj>, yf.d {
    private static final long serialVersionUID = -1864114230859967402L;
    @p9.c("Balls")
    private int balls;
    @p9.c("Comp")
    private int comp;
    @p9.c("Description")
    private String description;
    @p9.c("ExtraAthletes")
    private int[] extraAthletes;
    @p9.c("ExtraDetails")
    private String extraDetails;
    @p9.c("ExtraPlayerIds")
    private int[] extraPlayerIds;
    @p9.c("ExtraPlayers")
    private String[] extraPlayers;
    @p9.c("FiltersIds")
    private int[] filterIds;
    @p9.c("GT")
    private int gameTime;
    @p9.c("GTD")
    private String gameTimeToDisplay;
    @p9.c("GroupId")
    private int groupId;
    private int key;
    @p9.c("Num")
    private int num;
    @p9.c("Outs")
    private int outs;
    @p9.c("PBPEventKey")
    private String pbpEventKey;
    @p9.c("Player")
    private String player;
    @p9.c("Score")
    private String[] score;
    @p9.c("Status")
    public int statusId;
    @p9.c("Strikes")
    private int strikes;
    @p9.c("SType")
    private int subType;
    @p9.c("Type")
    public int type;
    @p9.c("PlayerSName")
    private String playerShortName = "";
    public int eventTypeID = -1;
    private boolean isNew = false;
    private boolean isDel = false;
    @p9.c("S")

    /* renamed from: s  reason: collision with root package name */
    private String f23585s = "";
    @p9.c("PenTime")
    private int peneltyTime = -1;
    @p9.c("AthleteID")
    private int athleteID = -1;
    @p9.c("Reason")
    private String reason = "";
    @p9.c("PID")
    public int PId = -1;
    @p9.c("GameCompletion")
    public double GameCompletion = -1.0d;
    @p9.c("AddedTime")
    public int addedTime = -2;
    @p9.c("EventOrder")
    public int eventOrder = -1;
    @p9.c("Boots")
    public int Boots = -1;
    @p9.c("NotInPlay")
    private boolean isNotInPlay = false;
    @p9.c("ImgVer")
    private int imgVer = -1;

    @Override // java.lang.Comparable
    public int compareTo(EventObj eventObj) {
        if (getGT() < eventObj.getGT()) {
            return -1;
        }
        return getGT() > eventObj.getGT() ? 1 : 0;
    }

    @Override // yf.d
    public int getAddedTime() {
        return this.addedTime;
    }

    @Override // yf.d
    public int getAthleteID() {
        return this.athleteID;
    }

    @Override // yf.d
    public int getAthleteID2() {
        try {
            int[] iArr = this.extraAthletes;
            if (iArr != null) {
                return iArr[0];
            }
            return -1;
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    public int getBalls() {
        return this.balls;
    }

    public int getComp() {
        return this.comp;
    }

    public String getDescription() {
        return this.description;
    }

    @Override // yf.d
    public String getEventIdForAnalytics() {
        return String.valueOf(this.type);
    }

    public String getEventTitleToDisplay(int i10) {
        String str = getEventType(i10).name;
        try {
            SubTypeObj subTypeObj = getSubTypeObj(i10);
            return subTypeObj != null ? subTypeObj.name : str;
        } catch (Exception e10) {
            x0.N1(e10);
            return str;
        }
    }

    public EventTypeObj getEventType(int i10) {
        try {
            return App.l().getSportTypes().get(Integer.valueOf(i10)).getEventByIndex(getType());
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public int[] getExtraAthletes() {
        return this.extraAthletes;
    }

    public String getExtraDetails() {
        return this.extraDetails;
    }

    public int[] getExtraPlayerIds() {
        return this.extraPlayerIds;
    }

    public String[] getExtraPlayers() {
        return this.extraPlayers;
    }

    public int[] getFilterIds() {
        return this.filterIds;
    }

    public int getGT() {
        return this.gameTime;
    }

    public int getGameTime() {
        return this.gameTime;
    }

    @Override // yf.d
    public String getGameTimeToDisplay() {
        return this.gameTimeToDisplay;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public boolean getIsDel() {
        return this.isDel;
    }

    public int getKey() {
        return this.key;
    }

    public int getNum() {
        return this.num;
    }

    public int getOuts() {
        return this.outs;
    }

    @Override // yf.d
    public String getPbpEventKey() {
        return this.pbpEventKey;
    }

    public int getPenaltyPen() {
        return this.peneltyTime;
    }

    public String getPlayer() {
        return this.player;
    }

    public String getReason() {
        return this.reason;
    }

    public String getS() {
        return this.f23585s;
    }

    public String[] getScore() {
        return this.score;
    }

    public int getStatusId() {
        return this.statusId;
    }

    public StatusObj getStatusObj(int i10) {
        try {
            return App.l().getSportTypes().get(Integer.valueOf(i10)).getStatuses().get(Integer.valueOf(this.statusId));
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public int getStrikes() {
        return this.strikes;
    }

    public int getSubType() {
        return this.subType;
    }

    @Override // yf.d
    public int getSubTypeId() {
        return this.subType;
    }

    public SubTypeObj getSubTypeObj(int i10) {
        try {
            SubTypeObj[] subTypes = getEventType(i10).getSubTypes();
            if (subTypes == null || subTypes.length <= 0) {
                return null;
            }
            return subTypes[getSubType()];
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public int getType() {
        return this.type;
    }

    @Override // yf.d
    public int getTypeId() {
        return this.type;
    }

    public boolean isNotInPlay() {
        return this.isNotInPlay;
    }

    public boolean isPlayerFromOtherTeam() {
        try {
            if (this.type == 0) {
                return this.subType == 1;
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public void setComp(int i10) {
        this.comp = i10;
    }

    public void setGroupId(int i10) {
        this.groupId = i10;
    }

    public void setKey(int i10) {
        this.key = i10;
    }

    public void setNum(int i10) {
        this.num = i10;
    }

    public void setPenaltyTime(int i10) {
        this.peneltyTime = i10;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public boolean shouldSkipPopupOnClick() {
        return this.type == 4;
    }
}
