package com.scores365.entitys;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class AthletesObj implements Serializable {
    private static final long serialVersionUID = -4361094005374170060L;
    @p9.c("Athletes")
    public LinkedHashMap<Integer, AthleteObj> athleteById;
    @p9.c("AthleteStatisticTypes")
    private LinkedHashMap<Integer, AthletesStatisticTypeObj> athleteStatTypes;
    @p9.c("Competitions")
    public LinkedHashMap<Integer, CompetitionObj> competitionsById;
    @p9.c("Competitors")
    public LinkedHashMap<Integer, CompObj> competitorsById;
    @p9.c("Countries")
    public Hashtable<Integer, CountryObj> countryById;
    @p9.c("NewsSources")
    public Hashtable<Integer, SourceObj> newsSources = new Hashtable<>();
    @p9.c("StatisticTypes")
    private LinkedHashMap<Integer, StatisticType> statTypes;

    public LinkedHashMap<Integer, AthleteObj> getAthleteById() {
        return this.athleteById;
    }

    public LinkedHashMap<Integer, AthletesStatisticTypeObj> getAthleteStatTypes() {
        return this.athleteStatTypes;
    }

    public LinkedHashMap<Integer, CompetitionObj> getCompetitionsById() {
        return this.competitionsById;
    }

    public LinkedHashMap<Integer, CompObj> getCompetitorsById() {
        return this.competitorsById;
    }

    public Hashtable<Integer, CountryObj> getCountryById() {
        return this.countryById;
    }

    public LinkedHashMap<Integer, StatisticType> getStatTypes() {
        return this.statTypes;
    }
}
