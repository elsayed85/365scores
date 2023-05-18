package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ChartRowObj implements Serializable {
    @p9.c("Position")
    public int position;
    @p9.c("Entity")
    public RowEntity entity = new RowEntity();
    @p9.c("Stats")
    public Stats[] stats = new Stats[2];

    /* loaded from: classes2.dex */
    private class Stats {
        @p9.c("V")
        String V = "";

        private Stats() {
        }
    }

    public String getAmount() {
        return this.stats[0].V;
    }

    public String getMinPerChart() {
        Stats[] statsArr = this.stats;
        return statsArr.length > 1 ? statsArr[1].V : "";
    }
}
