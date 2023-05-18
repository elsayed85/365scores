package com.scores365.entitys;
/* loaded from: classes2.dex */
public class Trophy extends BaseObj {
    @p9.c("CompetitionID")
    private int competitionID = -1;
    @p9.c("Count")
    private int count = -1;
    @p9.c("Stats")
    private TrophyStats stats;
    @p9.c("SName")
    private String titleName;

    public int getCompetitionID() {
        return this.competitionID;
    }

    public int getCount() {
        return this.count;
    }

    public TrophyStats getStats() {
        return this.stats;
    }

    public String getTitleName() {
        String str = this.titleName;
        return (str == null || str.isEmpty()) ? this.name : this.titleName;
    }

    public void setStats(TrophyStats trophyStats) {
        this.stats = trophyStats;
    }
}
