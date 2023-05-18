package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class TopPerformerStatisticObj implements Serializable {
    @p9.c("FilterID")
    private int filterId;
    @p9.c("Players")
    private ArrayList<PlayerObj> players;
    @p9.c("Category")
    public String statisticTitle;

    public int getFilterId() {
        return this.filterId;
    }

    public PlayerObj getPlayerForCompetitor(int i10) {
        ArrayList<PlayerObj> arrayList = this.players;
        if (arrayList != null) {
            Iterator<PlayerObj> it = arrayList.iterator();
            while (it.hasNext()) {
                PlayerObj next = it.next();
                if (next != null && next.competitorNum == i10) {
                    return next;
                }
            }
        }
        return null;
    }

    public ArrayList<PlayerObj> getPlayers() {
        return this.players;
    }
}
