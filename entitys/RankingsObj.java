package com.scores365.entitys;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class RankingsObj extends BaseObj {
    @p9.c("CompetitionID")
    private int competitionID = -1;
    @p9.c("TopPlayers")
    private ArrayList<TopPlayerObj> topPlayersList = new ArrayList<>();

    @Override // com.scores365.entitys.BaseObj
    public int getID() {
        return this.competitionID;
    }

    public ArrayList<TopPlayerObj> getTopPlayersList() {
        return this.topPlayersList;
    }
}
