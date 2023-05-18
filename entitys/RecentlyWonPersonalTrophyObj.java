package com.scores365.entitys;

import kotlin.jvm.internal.m;
/* compiled from: RecentlyWonPersonalTrophyItem.kt */
/* loaded from: classes2.dex */
public final class RecentlyWonPersonalTrophyObj extends BaseObj {
    @p9.c("CompetitionID")
    private final int competitionID;
    @p9.c("Title")
    private final String title;

    public RecentlyWonPersonalTrophyObj(String title, int i10) {
        m.g(title, "title");
        this.title = title;
        this.competitionID = i10;
    }

    public static /* synthetic */ RecentlyWonPersonalTrophyObj copy$default(RecentlyWonPersonalTrophyObj recentlyWonPersonalTrophyObj, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = recentlyWonPersonalTrophyObj.title;
        }
        if ((i11 & 2) != 0) {
            i10 = recentlyWonPersonalTrophyObj.competitionID;
        }
        return recentlyWonPersonalTrophyObj.copy(str, i10);
    }

    public final String component1() {
        return this.title;
    }

    public final int component2() {
        return this.competitionID;
    }

    public final RecentlyWonPersonalTrophyObj copy(String title, int i10) {
        m.g(title, "title");
        return new RecentlyWonPersonalTrophyObj(title, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecentlyWonPersonalTrophyObj) {
            RecentlyWonPersonalTrophyObj recentlyWonPersonalTrophyObj = (RecentlyWonPersonalTrophyObj) obj;
            return m.b(this.title, recentlyWonPersonalTrophyObj.title) && this.competitionID == recentlyWonPersonalTrophyObj.competitionID;
        }
        return false;
    }

    public final int getCompetitionID() {
        return this.competitionID;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.competitionID;
    }

    public String toString() {
        return "RecentlyWonPersonalTrophyObj(title=" + this.title + ", competitionID=" + this.competitionID + ')';
    }
}
