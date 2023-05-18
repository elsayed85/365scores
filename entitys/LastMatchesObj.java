package com.scores365.entitys;

import com.scores365.entitys.NewsObj;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import li.x0;
/* loaded from: classes2.dex */
public class LastMatchesObj implements Serializable {
    @p9.c("Paging")
    protected NewsObj.Paging paging;
    @p9.c("RelatedEntities")
    private RelatedEntities relatedEntities;
    @p9.c("StatisticTypes")
    private LinkedHashMap<Integer, StatisticType> statTypes;
    @p9.c("Countries")
    private ArrayList<CountryObj> countries = new ArrayList<>();
    @p9.c("Competitions")
    private ArrayList<CompetitionObj> competitions = new ArrayList<>();
    @p9.c("Games")
    private ArrayList<GameStats> games = new ArrayList<>();
    @p9.c("MissingStatMessage")
    private String missingStatMessage = null;
    @p9.c("Headers")
    private ArrayList<LastMatchesHeaderObj> headers = null;
    @p9.c("HeadersCategories")
    private ArrayList<LastMatchHeaderCategory> headerCategories = null;

    public ArrayList<CompetitionObj> getCompetitions() {
        return this.competitions;
    }

    public ArrayList<GameStats> getGames() {
        return this.games;
    }

    public ArrayList<LastMatchHeaderCategory> getHeaderCategories() {
        return this.headerCategories;
    }

    public ArrayList<LastMatchesHeaderObj> getHeaders(int i10) {
        ArrayList<LastMatchesHeaderObj> arrayList;
        ArrayList<LastMatchesHeaderObj> arrayList2 = this.headers;
        if (arrayList2 == null || i10 <= -1) {
            return arrayList2;
        }
        try {
            arrayList = new ArrayList<>();
        } catch (Exception e10) {
            e = e10;
        }
        try {
            Iterator<LastMatchesHeaderObj> it = this.headers.iterator();
            while (it.hasNext()) {
                LastMatchesHeaderObj next = it.next();
                if (next.getCategory() == i10) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        } catch (Exception e11) {
            e = e11;
            arrayList2 = arrayList;
            x0.N1(e);
            return arrayList2;
        }
    }

    public String getMissingStatMessage() {
        return this.missingStatMessage;
    }

    public NewsObj.Paging getPaging() {
        return this.paging;
    }

    public RelatedEntities getRelatedEntities() {
        return this.relatedEntities;
    }

    public LinkedHashMap<Integer, StatisticType> getStatTypes() {
        return this.statTypes;
    }

    public boolean hasHeaderData() {
        ArrayList<LastMatchesHeaderObj> arrayList = this.headers;
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }
}
