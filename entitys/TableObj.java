package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import li.x0;
/* loaded from: classes2.dex */
public class TableObj implements Serializable {
    private static final long serialVersionUID = 9711893363123719L;
    @p9.c("Competition")
    public int competitionId;
    @p9.c("CompetitionRules")
    public CompetitionRulesObj competitionRules;
    @p9.c("TableRows")
    public ArrayList<TableRowObj> competitionTable;
    @p9.c("Columns")
    public ArrayList<ColumnObj> competitionTableColumn;
    @p9.c("GroupCategory")
    public int groupCategory;
    @p9.c("IsTableIncludeEvenCol")
    public boolean isTableIncludeEvenCol;
    @p9.c("PointsDeductions")
    private ArrayList<PointDeductionObj> pointsDeductions;
    @p9.c("RedLine")
    public int redLine;
    @p9.c("Destinations")
    public LinkedHashMap<Integer, RowMetadataObj> rowMetadataList;
    @p9.c("Season")
    public int season;
    @p9.c("Stage")
    public int stage;
    @p9.c("TableType")
    public int tableType;
    @p9.c("Types")
    public ArrayList<TableTypeObj> tableTypes;
    @p9.c("WinnerDescription")
    public String winnerDescription;
    @p9.c("LiveGames")
    public HashMap<Integer, GameObj> liveLightGames = new HashMap<>();
    @p9.c("ShowGrouped")
    public boolean showGrouped = false;
    private HashSet<Integer> pointDeductionCompetitorIds = null;

    public HashSet<Integer> getPointDeductionCompetitorIds() {
        try {
            if (this.pointDeductionCompetitorIds == null && getPointsDeductions() != null) {
                this.pointDeductionCompetitorIds = new HashSet<>();
                Iterator<PointDeductionObj> it = getPointsDeductions().iterator();
                while (it.hasNext()) {
                    this.pointDeductionCompetitorIds.add(Integer.valueOf(it.next().getCompetitorId()));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.pointDeductionCompetitorIds;
    }

    public ArrayList<PointDeductionObj> getPointsDeductions() {
        return this.pointsDeductions;
    }

    public ArrayList<ColumnObj> getTableColumns() {
        ArrayList<ColumnObj> arrayList = new ArrayList<>();
        ArrayList<ColumnObj> arrayList2 = this.competitionTableColumn;
        if (arrayList2 != null) {
            Iterator<ColumnObj> it = arrayList2.iterator();
            while (it.hasNext()) {
                ColumnObj next = it.next();
                if (next.isDisplayed()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public boolean isPointDeductedFromCompetitor(int i10) {
        try {
            HashSet<Integer> pointDeductionCompetitorIds = getPointDeductionCompetitorIds();
            if (pointDeductionCompetitorIds == null || pointDeductionCompetitorIds.isEmpty()) {
                return false;
            }
            return pointDeductionCompetitorIds.contains(Integer.valueOf(i10));
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }
}
