package com.scores365.entitys.ScoreBoxObjects;

import com.scores365.entitys.AthleteTrophiesScoreBoxColumnObj;
import com.scores365.entitys.BaseObj;
import com.scores365.ui.playerCard.StatsRowObj;
import java.util.ArrayList;
import p9.c;
/* loaded from: classes2.dex */
public class ScoreBoxTablesObj extends BaseObj {
    @c("CategoryID")
    private int categoryID;
    @c("Columns")
    private ArrayList<AthleteTrophiesScoreBoxColumnObj> columns;
    @c("EmptyText")
    private String emptyText;
    @c("Expandable")
    private boolean expandable;
    @c("ExtraData")
    private ArrayList<ScoreBoxExtraDataEntryObj> extraData;
    @c("Groups")
    private ArrayList<ScoreBoxGroupObj> groups;
    @c("RowEntityType")
    private String rowEntityType;
    @c("Rows")
    private ArrayList<StatsRowObj> rows;
    private boolean shouldShowSummary;
    @c("ShowColumnIcons")
    private boolean showColumnIcons;
    @c("Summary")
    private ArrayList<ScoreBoxSummaryObj> summary;

    public ScoreBoxTablesObj() {
        this.categoryID = -1;
        this.showColumnIcons = false;
        this.expandable = false;
        this.groups = null;
        this.columns = null;
        this.rows = null;
        this.summary = null;
        this.emptyText = "";
        this.shouldShowSummary = true;
    }

    public ScoreBoxTablesObj(int i10, boolean z10, ArrayList<AthleteTrophiesScoreBoxColumnObj> arrayList, ArrayList<StatsRowObj> arrayList2, ArrayList<ScoreBoxSummaryObj> arrayList3) {
        this.showColumnIcons = false;
        this.emptyText = "";
        this.shouldShowSummary = true;
        this.categoryID = i10;
        this.expandable = z10;
        this.groups = null;
        this.columns = arrayList;
        this.rows = arrayList2;
        this.summary = arrayList3;
    }

    public int getCategoryID() {
        return this.categoryID;
    }

    public ArrayList<AthleteTrophiesScoreBoxColumnObj> getColumns() {
        return this.columns;
    }

    public String getEmptyText() {
        return this.emptyText;
    }

    public ArrayList<ScoreBoxExtraDataEntryObj> getExtraData() {
        return this.extraData;
    }

    public ArrayList<ScoreBoxGroupObj> getGroups() {
        return this.groups;
    }

    @Override // com.scores365.entitys.BaseObj
    public int getID() {
        return -1;
    }

    public String getRowEntityType() {
        return this.rowEntityType;
    }

    public ArrayList<StatsRowObj> getRows() {
        return this.rows;
    }

    public ArrayList<ScoreBoxSummaryObj> getSummary() {
        return this.summary;
    }

    public boolean isExpandable() {
        return this.expandable;
    }

    public boolean isShouldShowSummary() {
        return this.shouldShowSummary;
    }

    public boolean isShowColumnIcons() {
        return this.showColumnIcons;
    }

    public void setCategoryID(int i10) {
        this.categoryID = i10;
    }

    public void setColumns(ArrayList<AthleteTrophiesScoreBoxColumnObj> arrayList) {
        this.columns = arrayList;
    }

    public void setExpandable(boolean z10) {
        this.expandable = z10;
    }

    public void setGroups(ArrayList<ScoreBoxGroupObj> arrayList) {
        this.groups = arrayList;
    }

    public void setRows(ArrayList<StatsRowObj> arrayList) {
        this.rows = arrayList;
    }

    public void setShouldShowSummary(boolean z10) {
        this.shouldShowSummary = z10;
    }

    public void setSummary(ArrayList<ScoreBoxSummaryObj> arrayList) {
        this.summary = arrayList;
    }
}
