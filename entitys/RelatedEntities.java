package com.scores365.entitys;

import java.io.Serializable;
import java.util.Vector;
/* loaded from: classes2.dex */
public class RelatedEntities implements Serializable {
    @p9.c("Athletes")
    private Vector<AthleteObj> athletes;
    @p9.c("Competitions")
    private Vector<CompetitionObj> competitions;
    @p9.c("Competitors")
    private Vector<CompObj> competitors;
    @p9.c("Countries")
    private CountryObj[] countries;

    public Vector<AthleteObj> getAthletes() {
        return this.athletes;
    }

    public Vector<CompetitionObj> getCompetitions() {
        return this.competitions;
    }

    public Vector<CompObj> getCompetitors() {
        return this.competitors;
    }

    public CountryObj[] getCountries() {
        return this.countries;
    }

    public void setCountries(CountryObj[] countryObjArr) {
        this.countries = countryObjArr;
    }
}
