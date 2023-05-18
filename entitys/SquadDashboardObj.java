package com.scores365.entitys;

import java.io.Serializable;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class SquadDashboardObj implements Serializable {
    private static final long serialVersionUID = -8750792461082560637L;
    @p9.c("Competitions")
    public LinkedHashMap<Integer, CompetitionObj> competitionById;
    @p9.c("Competitors")
    public LinkedHashMap<Integer, CompObj> competitorById;
    @p9.c("Countries")
    public LinkedHashMap<Integer, CountryObj> countriesById;

    public SquadDashboardObj(LinkedHashMap<Integer, CountryObj> linkedHashMap, LinkedHashMap<Integer, CompetitionObj> linkedHashMap2, LinkedHashMap<Integer, CompObj> linkedHashMap3) {
        this.countriesById = linkedHashMap;
        this.competitionById = linkedHashMap2;
        this.competitorById = linkedHashMap3;
    }
}
