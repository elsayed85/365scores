package com.scores365.entitys;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import li.x0;
/* loaded from: classes2.dex */
public class EntityObj implements Serializable {
    private static final long serialVersionUID = 5449901286039766174L;
    @p9.c("Athletes")
    private Vector<AthleteObj> athletes;
    @p9.c("Competitions")
    private Vector<CompetitionObj> competitions;
    private HashMap<Integer, CompetitionObj> competitionsById;
    private HashMap<Integer, CompObj> competitorById;
    @p9.c("Competitors")
    private Vector<CompObj> competitors;
    @p9.c("Countries")
    private CountryObj[] countries;
    private HashMap<Integer, CountryObj> countryById;
    @p9.c("RelatedEntities")
    private RelatedEntities relatedEntities;
    @p9.c("TotalCompetitionsCount")
    private Integer totalCompetitionsCount = -1;
    @p9.c("TotalCompetitorsCount")
    private Integer totalCompetitorsCount = -1;
    @p9.c("TotalAthleteCount")
    private Integer totalAthleteCount = -1;

    public EntityObj() {
    }

    public EntityObj(CountryObj[] countryObjArr, Vector<CompetitionObj> vector, Vector<CompObj> vector2, Vector<AthleteObj> vector3) {
        this.countries = countryObjArr;
        this.competitions = vector;
        this.athletes = vector3;
        setCompetitions(vector);
        setCompetitors(vector2);
        mapCountries(countryObjArr);
    }

    public Vector<AthleteObj> getAthletes() {
        return this.athletes;
    }

    public Vector<CompetitionObj> getCompetitions() {
        return this.competitions;
    }

    public HashMap<Integer, CompetitionObj> getCompetitionsById() {
        if (this.competitionsById == null) {
            setCompetitions(this.competitions);
        }
        return this.competitionsById;
    }

    public HashMap<Integer, CompObj> getCompetitorById() {
        try {
            if (this.competitorById == null) {
                setCompetitors(this.competitors);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.competitorById;
    }

    public Vector<CompObj> getCompetitors() {
        return this.competitors;
    }

    public CountryObj[] getCountries() {
        return this.countries;
    }

    public HashMap<Integer, CountryObj> getCountryById() {
        try {
            if (this.countryById == null) {
                mapCountries(this.countries);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.countryById;
    }

    public RelatedEntities getRelatedEntities() {
        return this.relatedEntities;
    }

    public Integer getTotalAthleteCount() {
        return this.totalAthleteCount;
    }

    public Integer getTotalCompetitionsCount() {
        return this.totalCompetitionsCount;
    }

    public Integer getTotalCompetitorsCount() {
        return this.totalCompetitorsCount;
    }

    public void mapCountries(CountryObj[] countryObjArr) {
        CountryObj[] countries;
        try {
            this.countryById = new HashMap<>();
            if (countryObjArr != null) {
                for (CountryObj countryObj : countryObjArr) {
                    this.countryById.put(Integer.valueOf(countryObj.getID()), countryObj);
                }
            }
            RelatedEntities relatedEntities = this.relatedEntities;
            if (relatedEntities == null || relatedEntities.getCountries() == null) {
                return;
            }
            for (CountryObj countryObj2 : this.relatedEntities.getCountries()) {
                this.countryById.put(Integer.valueOf(countryObj2.getID()), countryObj2);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setCompetitions(Vector<CompetitionObj> vector) {
        try {
            this.competitions = vector;
            this.competitionsById = new HashMap<>();
            try {
                Vector<CompetitionObj> vector2 = this.competitions;
                if (vector2 != null && !vector2.isEmpty()) {
                    Iterator<CompetitionObj> it = this.competitions.iterator();
                    while (it.hasNext()) {
                        CompetitionObj next = it.next();
                        this.competitionsById.put(Integer.valueOf(next.getID()), next);
                    }
                }
                RelatedEntities relatedEntities = this.relatedEntities;
                if (relatedEntities == null || relatedEntities.getCompetitors() == null) {
                    return;
                }
                Iterator<CompetitionObj> it2 = this.relatedEntities.getCompetitions().iterator();
                while (it2.hasNext()) {
                    CompetitionObj next2 = it2.next();
                    this.competitionsById.put(Integer.valueOf(next2.getID()), next2);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    public void setCompetitors(Vector<CompObj> vector) {
        try {
            this.competitors = vector;
            this.competitorById = new HashMap<>();
            try {
                Vector<CompObj> vector2 = this.competitors;
                if (vector2 != null && !vector2.isEmpty()) {
                    Iterator<CompObj> it = this.competitors.iterator();
                    while (it.hasNext()) {
                        CompObj next = it.next();
                        this.competitorById.put(Integer.valueOf(next.getID()), next);
                    }
                }
                RelatedEntities relatedEntities = this.relatedEntities;
                if (relatedEntities == null || relatedEntities.getCompetitors() == null) {
                    return;
                }
                Iterator<CompObj> it2 = this.relatedEntities.getCompetitors().iterator();
                while (it2.hasNext()) {
                    CompObj next2 = it2.next();
                    this.competitorById.put(Integer.valueOf(next2.getID()), next2);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }
}
