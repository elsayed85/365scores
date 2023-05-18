package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class TablePosition implements Serializable {
    @p9.c("Columns")
    public ArrayList<ColumnObj> competitionTableColumn;
    @p9.c("TableRow")
    public TableRowObj tableRowObj;
    @p9.c("TableID")
    private int tableId = -1;
    @p9.c("TableStructureID")
    private int tableStructureId = -1;
    @p9.c("Title")
    private String title = "";

    public ArrayList<ColumnObj> getTableColumns(boolean z10) {
        ArrayList<ColumnObj> arrayList = new ArrayList<>();
        ArrayList<ColumnObj> arrayList2 = this.competitionTableColumn;
        if (arrayList2 != null) {
            Iterator<ColumnObj> it = arrayList2.iterator();
            while (it.hasNext()) {
                ColumnObj next = it.next();
                if (next.isDisplayed() && (z10 || (!z10 && !next.getOnlyExpanded()))) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public int getTableId() {
        return this.tableId;
    }

    public int getTableStructureId() {
        return this.tableStructureId;
    }

    public String getTableTitle() {
        return this.title;
    }

    public boolean isSameTable(int i10) {
        return this.tableId == i10;
    }

    public boolean isSameTableStructure(int i10) {
        return this.tableStructureId == i10;
    }
}
