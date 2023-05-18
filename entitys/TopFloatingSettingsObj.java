package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class TopFloatingSettingsObj implements Serializable {
    @p9.c("OVERALL_CAP_DAY")
    private int capDay;
    @p9.c("OVERALL_GAP_BETWEEN_SESSIONS")
    private int gapBetweenSessions;

    public int getCapDay() {
        return this.capDay;
    }

    public int getGapBetweenSessions() {
        return this.gapBetweenSessions;
    }
}
