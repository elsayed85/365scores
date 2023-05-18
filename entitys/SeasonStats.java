package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SeasonStats implements Serializable {
    @p9.c("Competition")
    private int competitorId;
    @p9.c("SeasonNum")
    private int seasonNum;
    @p9.c("Stats")
    private PlayerStatObj[] stat;

    public PlayerStatObj[] getPlayerStat() {
        return this.stat;
    }
}
