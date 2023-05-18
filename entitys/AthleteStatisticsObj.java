package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AthleteStatisticsObj implements Serializable {
    private static final long serialVersionUID = -3514387950569773842L;
    @p9.c("Competition")
    public int competitionId;
    @p9.c("Competitor")
    public int comprtitorId;
    @p9.c("Stats")
    public PlayerStatObj[] playerStatistics;
    @p9.c("SeasonNum")
    public int seasonNum;
    @p9.c("Name")
    public String titleName;
}
