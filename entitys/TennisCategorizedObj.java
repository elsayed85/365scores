package com.scores365.entitys;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class TennisCategorizedObj extends BaseObj {
    @p9.c("TournamentCategories")
    private LinkedHashMap<Integer, TournamentCategoryObj> tournamentCategories = new LinkedHashMap<>();
    @p9.c("Rankings")
    private ArrayList<RankingsObj> rankingsList = new ArrayList<>();

    public ArrayList<RankingsObj> getRankingsList() {
        return this.rankingsList;
    }

    public LinkedHashMap<Integer, TournamentCategoryObj> getTournamentCategories() {
        return this.tournamentCategories;
    }
}
