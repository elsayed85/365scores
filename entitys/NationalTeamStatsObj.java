package com.scores365.entitys;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class NationalTeamStatsObj extends BaseObj {
    @p9.c("Competition")
    private int competitionId;
    @p9.c("Competitor")
    private int competitor;
    @p9.c("SeasonNum")
    private int seasonNum;
    @p9.c("Stats")
    private ArrayList<NationalTeamStatObj> stats = new ArrayList<>();

    public int getCompetitionId() {
        return this.competitionId;
    }

    public int getCompetitor() {
        return this.competitor;
    }

    public int getSeasonNum() {
        return this.seasonNum;
    }

    public ArrayList<NationalTeamStatObj> getStats() {
        return this.stats;
    }
}
