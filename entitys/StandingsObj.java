package com.scores365.entitys;

import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes2.dex */
public class StandingsObj {
    @p9.c("Competitions")
    ArrayList<CompetitionObj> mCompetitions;
    @p9.c("Countries")
    Hashtable<Integer, CountryObj> mCountries;
    @p9.c("ShowOnlyTables")
    boolean showOnlyTables = false;

    public ArrayList<CompetitionObj> getCompetitions() {
        return this.mCompetitions;
    }

    public Hashtable<Integer, CountryObj> getCountries() {
        return this.mCountries;
    }

    public boolean isShowOnlyTables() {
        return this.showOnlyTables;
    }
}
