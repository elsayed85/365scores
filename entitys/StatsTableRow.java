package com.scores365.entitys;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class StatsTableRow {
    @p9.c("ID")
    int ID;
    @p9.c("GetMoreRequest")
    public String getMoreRequest;
    @p9.c("HasMore")
    boolean hasMore;
    @p9.c("Expanded")
    boolean isExpanded;
    @p9.c("Rows")
    private ArrayList<ChartRowObj> mChartData;
    @p9.c("CompetitionID")
    private int mCompetitionId;
    @p9.c("Name")
    private String mName;
    private eStatType[] mStatTypes;
    @p9.c("StatTypes")
    private int[] mStatTypesInt;

    /* loaded from: classes2.dex */
    public enum eStatType {
        TOP_SCORERS(1),
        TOP_ASSISTS(2),
        TOP_YELLOW(3),
        TOP_RED(4),
        MINUTES_PER_GOAL(9);
        
        private int value;

        eStatType(int i10) {
            this.value = i10;
        }

        public static eStatType create(int i10) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 != 9) {
                                return null;
                            }
                            return MINUTES_PER_GOAL;
                        }
                        return TOP_RED;
                    }
                    return TOP_YELLOW;
                }
                return TOP_ASSISTS;
            }
            return TOP_SCORERS;
        }

        public int getValue() {
            return this.value;
        }
    }

    public StatsTableRow() {
        this.hasMore = false;
    }

    public StatsTableRow(String str, eStatType[] estattypeArr, int i10, ArrayList<ChartRowObj> arrayList, boolean z10, boolean z11, String str2) {
        this.mName = str;
        this.mCompetitionId = i10;
        this.mChartData = arrayList;
        this.isExpanded = z10;
        this.hasMore = z11;
    }

    public ArrayList<ChartRowObj> getChartData() {
        return this.mChartData;
    }

    public int getCompetitionId() {
        return this.mCompetitionId;
    }

    public int getID() {
        return this.ID;
    }

    public String getName() {
        return this.mName;
    }

    public eStatType[] getStatTypes() {
        eStatType[] estattypeArr = new eStatType[this.mStatTypesInt.length];
        int i10 = 0;
        while (true) {
            int[] iArr = this.mStatTypesInt;
            if (i10 >= iArr.length) {
                return estattypeArr;
            }
            estattypeArr[i10] = eStatType.create(iArr[i10]);
            i10++;
        }
    }

    public int[] getStatTypesInt() {
        return this.mStatTypesInt;
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setChartData(ArrayList<ChartRowObj> arrayList) {
        this.mChartData = arrayList;
    }

    public void setCompetitionId(int i10) {
        this.mCompetitionId = i10;
    }

    public void setExpanded(boolean z10) {
        this.isExpanded = z10;
    }

    public void setHasMore(boolean z10) {
        this.hasMore = z10;
    }

    public void setID(int i10) {
        this.ID = i10;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setStatTypes(eStatType[] estattypeArr) {
        this.mStatTypes = estattypeArr;
    }
}
