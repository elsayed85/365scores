package com.scores365.entitys.competitionsDetailsCards;

import com.scores365.entitys.BaseObj;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import p9.c;
/* compiled from: CompetitionDetailsOutrightTableObj.kt */
/* loaded from: classes2.dex */
public final class CompetitionDetailsOutrightTableObj extends BaseObj {
    @c("Columns")
    private final LinkedHashMap<Integer, CompetitionDetailsOutrightColumnObj> columns;
    @c("Rows")
    private final ArrayList<CompetitionDetailsOutrightRowObj> rows;
    @c("ShowVotesCount")
    private final boolean showVotesCount;
    @c("BetLineType")
    private final int betLineType = -1;
    @c("EntityType")
    private final int entityType = -1;
    @c("TotalVotes")
    private final int totalVotes = -1;

    public final int getBetLineType() {
        return this.betLineType;
    }

    public final LinkedHashMap<Integer, CompetitionDetailsOutrightColumnObj> getColumns() {
        return this.columns;
    }

    public final int getEntityType() {
        return this.entityType;
    }

    public final ArrayList<CompetitionDetailsOutrightRowObj> getRows() {
        return this.rows;
    }

    public final boolean getShowVotesCount() {
        return this.showVotesCount;
    }

    public final int getTotalVotes() {
        return this.totalVotes;
    }
}
