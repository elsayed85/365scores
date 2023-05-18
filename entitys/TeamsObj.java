package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
/* compiled from: TeamsObj.kt */
/* loaded from: classes2.dex */
public final class TeamsObj implements Serializable {
    @p9.c("Competitors")
    private ArrayList<HistoryAndTeamsCompetitorObj> competitors;
    @p9.c("Groups")
    private ArrayList<TeamsGroupObj> groups;
    @p9.c("TabName")
    private String tabName = "";

    public final ArrayList<HistoryAndTeamsCompetitorObj> getCompetitors() {
        return this.competitors;
    }

    public final ArrayList<TeamsGroupObj> getGroups() {
        return this.groups;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final void setCompetitors(ArrayList<HistoryAndTeamsCompetitorObj> arrayList) {
        this.competitors = arrayList;
    }

    public final void setGroups(ArrayList<TeamsGroupObj> arrayList) {
        this.groups = arrayList;
    }

    public final void setTabName(String str) {
        m.g(str, "<set-?>");
        this.tabName = str;
    }
}
