package com.scores365.entitys;

import com.facebook.appevents.AppEventsConstants;
import li.x0;
/* loaded from: classes2.dex */
public class StatusObj extends BaseObj {
    private static final long serialVersionUID = -3261899020291655007L;
    @p9.c("GameTimeForStatus")
    private boolean GameTimeForStatus;
    @p9.c("AliasName")
    private String aliasName;
    @p9.c("HasEvents")
    public boolean hasEvents;
    @p9.c("HasGameTime")
    private boolean hasGameTime;
    @p9.c("isActive")
    private boolean isActive;
    @p9.c("isExtraTime")
    private boolean isExtraTime;
    @p9.c("isFinished")
    private boolean isFinished;
    @p9.c("isNotStarted")
    private boolean isNotStarted;
    @p9.c("isPenalties")
    private boolean isPenalties;
    @p9.c("ShortName")
    private String shortName;
    @p9.c("ShowGameIsAboutToStartUponCountdownZero")
    private boolean showGameIsAboutToStartUponCountDownZero;
    @p9.c("ShowStartTime")
    public boolean showStartTime;
    @p9.c("SportTypeID")
    private int sportTypeID;
    @p9.c("GameTimeOnStart")
    public int statusTimeOnStart = -1;
    @p9.c("GameTimeOnFinish")
    public int statusTimeOnFinish = -1;
    @p9.c("ProgressPace")
    public double statusProgressPace = -1.0d;
    @p9.c("IsClockAutomaticallyprogress")
    public boolean isClockAutomaticallyProgress = false;
    @p9.c("AutonomicTime")
    public boolean autonomicTime = false;
    @p9.c("isAbnormal")
    public boolean isAbnormal = false;
    @p9.c("StageID")
    public int relatedStageId = -1;
    @p9.c("ScoreStage")
    public int scoreStage = -1;

    public boolean HasGameTimeForStatus() {
        return this.GameTimeForStatus;
    }

    public String getAliasName() {
        return this.aliasName;
    }

    public boolean getHasGameTime() {
        return this.hasGameTime;
    }

    public boolean getIsAbnormal() {
        return this.isAbnormal;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public boolean getIsNotStarted() {
        return this.isNotStarted;
    }

    public String getShortName() {
        return this.shortName;
    }

    public int getSportTypeID() {
        return this.sportTypeID;
    }

    public boolean isExtraTime() {
        return this.isExtraTime;
    }

    public boolean isPenalties() {
        return this.isPenalties;
    }

    public boolean isShowGameIsAboutToStartUponCountDownZero() {
        return this.showGameIsAboutToStartUponCountDownZero;
    }

    public String valueForAnalytics() {
        try {
            return getIsFinished() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : getIsNotStarted() ? "0" : getIsActive() ? "2" : "";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }
}
