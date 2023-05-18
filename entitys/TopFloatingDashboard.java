package com.scores365.entitys;

import cc.p0;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import li.x0;
/* loaded from: classes2.dex */
public class TopFloatingDashboard extends BaseObj {
    @p9.c("TopFloatingId")
    public String topdashboardId = "";
    @p9.c("Type")
    public String type = "";
    @p9.c("ClickType")
    public String clickType = "";
    @p9.c("CountDownUntilDate")
    public String countdownUntilDate = "";
    @p9.c("CapLifetime")
    public String capLifetime = "";
    @p9.c("GapBetweenSessions")
    public String gapBetweenSessions = "";
    @p9.c("CapDay")
    public String capDay = "";
    @p9.c("Height")
    public int height = 0;
    @p9.c("Percentage")
    public float percentage = -1.0f;
    @p9.c("FavoriteTeams")
    private ArrayList<Integer> favoriteTeams = new ArrayList<>();
    @p9.c("FollowingTeams")
    private ArrayList<Integer> followingTeams = new ArrayList<>();
    @p9.c("FollowingLeagues")
    private ArrayList<Integer> followingLeagues = new ArrayList<>();
    private p0 targetingObj = null;

    private p0 getTargetingObj() {
        try {
            if (this.targetingObj == null) {
                this.targetingObj = new p0(this.favoriteTeams, this.followingTeams, this.followingLeagues);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.targetingObj;
    }

    public String getCapDay() {
        return this.capDay;
    }

    public String getCapLifetime() {
        return this.capLifetime;
    }

    public String getClickType() {
        return this.clickType;
    }

    public Date getCountdownUntilDateObj() {
        try {
            String str = this.countdownUntilDate;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ROOT);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
            return simpleDateFormat.parse(str);
        } catch (ParseException e10) {
            x0.N1(e10);
            return null;
        }
    }

    public int getHeight() {
        return this.height;
    }

    public float getPercentage() {
        return this.percentage;
    }

    public String getTopdashboardId() {
        return this.topdashboardId;
    }

    public String getType() {
        return this.type;
    }

    public boolean isTopFloatingDashboardTargetedForUserSelections() {
        return getTargetingObj().a();
    }
}
