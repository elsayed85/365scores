package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class TrophyStats implements Serializable {
    @p9.c("Columns")
    private ArrayList<AthleteTrophiesScoreBoxColumnObj> columns;
    @p9.c("Rows")
    private ArrayList<AthleteTrophiesScoreBoxRowObj> rows;
    @p9.c("ShowColumnIcons")
    private boolean showColumnIcons = false;
    @p9.c("RowsEntityType")
    private String rowsEntityType = "";

    public ArrayList<AthleteTrophiesScoreBoxColumnObj> getColumns() {
        return this.columns;
    }

    public ArrayList<AthleteTrophiesScoreBoxRowObj> getRows() {
        return this.rows;
    }

    public String getRowsEntityType() {
        return this.rowsEntityType;
    }

    public boolean isShowColumnIcons() {
        return this.showColumnIcons;
    }
}
