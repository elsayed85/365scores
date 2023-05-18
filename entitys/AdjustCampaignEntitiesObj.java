package com.scores365.entitys;

import java.util.ArrayList;
/* compiled from: AdjustCampaignEntitiesObj.kt */
/* loaded from: classes2.dex */
public final class AdjustCampaignEntitiesObj extends BaseObj {
    @p9.c("AdGroupName")
    private final String adGroupName = "";
    @p9.c("Athletes")
    private final ArrayList<Integer> athletes;
    @p9.c("Competitions")
    private final ArrayList<Integer> competitions;
    @p9.c("Competitors")
    private final ArrayList<Integer> competitors;
    @p9.c("Games")
    private final ArrayList<Integer> games;

    public final String getAdGroupName() {
        return this.adGroupName;
    }

    public final ArrayList<Integer> getAthletes() {
        return this.athletes;
    }

    public final ArrayList<Integer> getCompetitions() {
        return this.competitions;
    }

    public final ArrayList<Integer> getCompetitors() {
        return this.competitors;
    }

    public final ArrayList<Integer> getGames() {
        return this.games;
    }
}
