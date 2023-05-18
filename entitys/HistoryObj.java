package com.scores365.entitys;

import com.scores365.entitys.ScoreBoxObjects.ScoreBoxColumnsObj;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
/* compiled from: HistoryObj.kt */
/* loaded from: classes2.dex */
public final class HistoryObj extends BaseObj {
    @p9.c("Columns")
    private ArrayList<ScoreBoxColumnsObj> columns;
    @p9.c("Competitors")
    private ArrayList<CompObj> competitors;
    @p9.c("IsChampionByKnockout")
    private boolean isChampionByKnockout;
    @p9.c("Rows")
    private ArrayList<HistoryRowObj> rows;
    @p9.c("TabName")
    private String tabName = "";
    @p9.c("Title")
    private String title = "";

    public final ArrayList<ScoreBoxColumnsObj> getColumns() {
        return this.columns;
    }

    public final ArrayList<CompObj> getCompetitors() {
        return this.competitors;
    }

    public final ArrayList<HistoryRowObj> getRows() {
        return this.rows;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isChampionByKnockout() {
        return this.isChampionByKnockout;
    }

    public final void setChampionByKnockout(boolean z10) {
        this.isChampionByKnockout = z10;
    }

    public final void setColumns(ArrayList<ScoreBoxColumnsObj> arrayList) {
        this.columns = arrayList;
    }

    public final void setCompetitors(ArrayList<CompObj> arrayList) {
        this.competitors = arrayList;
    }

    public final void setRows(ArrayList<HistoryRowObj> arrayList) {
        this.rows = arrayList;
    }

    public final void setTabName(String str) {
        m.g(str, "<set-?>");
        this.tabName = str;
    }

    public final void setTitle(String str) {
        m.g(str, "<set-?>");
        this.title = str;
    }
}
