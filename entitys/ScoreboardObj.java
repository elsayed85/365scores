package com.scores365.entitys;

import java.util.ArrayList;
/* compiled from: ScoreboardObj.kt */
/* loaded from: classes2.dex */
public final class ScoreboardObj extends BaseObj {
    @p9.c("Columns")
    private ArrayList<ScoreboardColumnObj> columns;
    @p9.c("Possesion")
    private int possesion = -1;
    @p9.c("ScrollToEnd")
    private boolean scrollToEnd;
    @p9.c("ShowTimeRow")
    private boolean showTimeRow;
    @p9.c("TeamNamesSpace")
    private boolean teamNamesSpace;

    public final ArrayList<ScoreboardColumnObj> getColumns() {
        return this.columns;
    }

    public final int getPossesion() {
        return this.possesion;
    }

    public final boolean getScrollToEnd() {
        return this.scrollToEnd;
    }

    public final boolean getShowTimeRow() {
        return this.showTimeRow;
    }

    public final boolean getTeamNamesSpace() {
        return this.teamNamesSpace;
    }

    public final void setColumns(ArrayList<ScoreboardColumnObj> arrayList) {
        this.columns = arrayList;
    }

    public final void setPossesion(int i10) {
        this.possesion = i10;
    }

    public final void setScrollToEnd(boolean z10) {
        this.scrollToEnd = z10;
    }

    public final void setShowTimeRow(boolean z10) {
        this.showTimeRow = z10;
    }

    public final void setTeamNamesSpace(boolean z10) {
        this.teamNamesSpace = z10;
    }
}
