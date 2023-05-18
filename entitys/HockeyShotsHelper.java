package com.scores365.entitys;

import kotlin.jvm.internal.m;
/* compiled from: HockeyShotsHelper.kt */
/* loaded from: classes2.dex */
public final class HockeyShotsHelper {
    private final String awayTeamScores;
    private final String homeTeamScores;
    private final String title;

    public HockeyShotsHelper(String homeTeamScores, String awayTeamScores, String title) {
        m.g(homeTeamScores, "homeTeamScores");
        m.g(awayTeamScores, "awayTeamScores");
        m.g(title, "title");
        this.homeTeamScores = homeTeamScores;
        this.awayTeamScores = awayTeamScores;
        this.title = title;
    }

    public static /* synthetic */ HockeyShotsHelper copy$default(HockeyShotsHelper hockeyShotsHelper, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = hockeyShotsHelper.homeTeamScores;
        }
        if ((i10 & 2) != 0) {
            str2 = hockeyShotsHelper.awayTeamScores;
        }
        if ((i10 & 4) != 0) {
            str3 = hockeyShotsHelper.title;
        }
        return hockeyShotsHelper.copy(str, str2, str3);
    }

    public final String component1() {
        return this.homeTeamScores;
    }

    public final String component2() {
        return this.awayTeamScores;
    }

    public final String component3() {
        return this.title;
    }

    public final HockeyShotsHelper copy(String homeTeamScores, String awayTeamScores, String title) {
        m.g(homeTeamScores, "homeTeamScores");
        m.g(awayTeamScores, "awayTeamScores");
        m.g(title, "title");
        return new HockeyShotsHelper(homeTeamScores, awayTeamScores, title);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HockeyShotsHelper) {
            HockeyShotsHelper hockeyShotsHelper = (HockeyShotsHelper) obj;
            return m.b(this.homeTeamScores, hockeyShotsHelper.homeTeamScores) && m.b(this.awayTeamScores, hockeyShotsHelper.awayTeamScores) && m.b(this.title, hockeyShotsHelper.title);
        }
        return false;
    }

    public final String getAwayTeamScores() {
        return this.awayTeamScores;
    }

    public final String getHomeTeamScores() {
        return this.homeTeamScores;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.homeTeamScores.hashCode() * 31) + this.awayTeamScores.hashCode()) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "HockeyShotsHelper(homeTeamScores=" + this.homeTeamScores + ", awayTeamScores=" + this.awayTeamScores + ", title=" + this.title + ')';
    }
}
