package com.scores365.entitys.competitionsDetailsCards;

import com.scores365.entitys.BaseObj;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p9.c;
/* compiled from: TopTeamCategoryObj.kt */
/* loaded from: classes2.dex */
public final class TopTeamCategoryObj extends BaseObj {
    @c("AVG")
    private final String avg;
    @c("Category")
    private final String category;
    @c("Teams")
    private final ArrayList<TeamObj> teams;

    public TopTeamCategoryObj() {
        this(null, null, null, 7, null);
    }

    public TopTeamCategoryObj(String str, String str2, ArrayList<TeamObj> teams) {
        m.g(teams, "teams");
        this.category = str;
        this.avg = str2;
        this.teams = teams;
    }

    public /* synthetic */ TopTeamCategoryObj(String str, String str2, ArrayList arrayList, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? new ArrayList() : arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TopTeamCategoryObj copy$default(TopTeamCategoryObj topTeamCategoryObj, String str, String str2, ArrayList arrayList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = topTeamCategoryObj.category;
        }
        if ((i10 & 2) != 0) {
            str2 = topTeamCategoryObj.avg;
        }
        if ((i10 & 4) != 0) {
            arrayList = topTeamCategoryObj.teams;
        }
        return topTeamCategoryObj.copy(str, str2, arrayList);
    }

    public final String component1() {
        return this.category;
    }

    public final String component2() {
        return this.avg;
    }

    public final ArrayList<TeamObj> component3() {
        return this.teams;
    }

    public final TopTeamCategoryObj copy(String str, String str2, ArrayList<TeamObj> teams) {
        m.g(teams, "teams");
        return new TopTeamCategoryObj(str, str2, teams);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TopTeamCategoryObj) {
            TopTeamCategoryObj topTeamCategoryObj = (TopTeamCategoryObj) obj;
            return m.b(this.category, topTeamCategoryObj.category) && m.b(this.avg, topTeamCategoryObj.avg) && m.b(this.teams, topTeamCategoryObj.teams);
        }
        return false;
    }

    public final String getAvg() {
        return this.avg;
    }

    public final String getCategory() {
        return this.category;
    }

    public final ArrayList<TeamObj> getTeams() {
        return this.teams;
    }

    public int hashCode() {
        String str = this.category;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.avg;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.teams.hashCode();
    }

    public String toString() {
        return "TopTeamCategoryObj(category=" + this.category + ", avg=" + this.avg + ", teams=" + this.teams + ')';
    }
}
