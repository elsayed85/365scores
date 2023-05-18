package com.scores365.entitys;

import java.util.LinkedHashMap;
import li.x0;
/* loaded from: classes2.dex */
public class CategorizedObj extends BaseObj {
    @p9.c("TournamentCategories")
    private LinkedHashMap<Integer, TournamentCategoryObj> tournamentCategories = new LinkedHashMap<>();
    @p9.c("Categories")
    private LinkedHashMap<Integer, CategoryObj> categories = new LinkedHashMap<>();
    @p9.c("Competitions")
    private LinkedHashMap<Integer, CompetitionObj> competitions = new LinkedHashMap<>();
    @p9.c("Countries")
    private LinkedHashMap<Integer, CountryObj> countries = new LinkedHashMap<>();
    @p9.c("Competitors")
    private LinkedHashMap<Integer, CompObj> competitors = new LinkedHashMap<>();

    public LinkedHashMap<Integer, CategoryObj> getCategories() {
        return this.categories;
    }

    public LinkedHashMap<Integer, CompetitionObj> getCompetitions() {
        return this.competitions;
    }

    public LinkedHashMap<Integer, CompObj> getCompetitors() {
        return this.competitors;
    }

    public LinkedHashMap<Integer, CountryObj> getCountries() {
        return this.countries;
    }

    public LinkedHashMap<Integer, TournamentCategoryObj> getTournamentCategories() {
        return this.tournamentCategories;
    }

    public void mergeCategorizedObj(CategorizedObj categorizedObj) {
        try {
            this.tournamentCategories.putAll(categorizedObj.tournamentCategories);
            this.competitions.putAll(categorizedObj.competitions);
            this.competitors.putAll(categorizedObj.competitors);
            this.categories.putAll(categorizedObj.categories);
            this.countries.putAll(categorizedObj.countries);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
