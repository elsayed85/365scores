package com.scores365.entitys;

import cc.p0;
import java.util.ArrayList;
import li.x0;
/* loaded from: classes2.dex */
public class MonetizationSectionObj extends SpecialSections {
    @p9.c("FavoriteTeams")
    private ArrayList<Integer> favoriteTeams;
    @p9.c("FollowingLeagues")
    private ArrayList<Integer> followingLeagues;
    @p9.c("FollowingTeams")
    private ArrayList<Integer> followingTeams;
    @p9.c("IconPosition")
    private int iconPosition;
    @p9.c("IconText")
    private String iconText;
    @p9.c("IconURL")
    private String iconURL;
    @p9.c("IconURLUS")
    private String iconURLUS;
    private p0 targetingObj;

    public MonetizationSectionObj() {
        this.favoriteTeams = new ArrayList<>();
        this.followingTeams = new ArrayList<>();
        this.followingLeagues = new ArrayList<>();
        this.targetingObj = null;
    }

    public MonetizationSectionObj(String str, String str2, String str3, String str4, String str5, String str6) {
        super(str, str2, str3, str4, str5, str6);
        this.favoriteTeams = new ArrayList<>();
        this.followingTeams = new ArrayList<>();
        this.followingLeagues = new ArrayList<>();
        this.targetingObj = null;
    }

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

    public int getIconPosition() {
        return this.iconPosition;
    }

    public String getIconText() {
        return this.iconText;
    }

    public String getIconURL() {
        return this.iconURL;
    }

    public String getIconURLUS() {
        return this.iconURLUS;
    }

    public boolean isSpecialSectionTargetedForUserSelections() {
        return getTargetingObj().a();
    }
}
