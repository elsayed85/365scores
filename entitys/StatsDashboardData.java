package com.scores365.entitys;

import com.google.gson.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import li.x0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class StatsDashboardData implements Serializable {
    @p9.c("Competitions")
    public LinkedHashMap<Integer, CompetitionObj> competitionsById;
    @p9.c("Competitors")
    public LinkedHashMap<Integer, CompObj> competitorsById;
    @p9.c("Countries")
    public LinkedHashMap<Integer, CountryObj> countriesById;
    @p9.c("StatsFilters")
    public ArrayList<StatsFilter> statsFilters;
    @p9.c("Tables")
    public ArrayList<StatsTableRow> tableData;

    public static StatsDashboardData parse(String str) {
        try {
            return (StatsDashboardData) GsonManager.getGson().l(str, StatsDashboardData.class);
        } catch (s e10) {
            x0.N1(e10);
            return null;
        }
    }

    public static StatsDashboardData parse(JSONObject jSONObject) {
        return new StatsDashboardData();
    }

    public LinkedHashMap<Integer, CompetitionObj> getCompetitionsById() {
        return this.competitionsById;
    }

    public LinkedHashMap<Integer, CompObj> getCompetitorsById() {
        return this.competitorsById;
    }

    public LinkedHashMap<Integer, CountryObj> getCountriesById() {
        return this.countriesById;
    }

    public ArrayList<StatsTableRow> getTableData() {
        return this.tableData;
    }

    public void merge(StatsDashboardData statsDashboardData) {
        try {
            this.tableData = statsDashboardData.tableData;
            this.competitorsById = statsDashboardData.competitorsById;
            this.countriesById = statsDashboardData.countriesById;
            this.competitionsById = statsDashboardData.competitionsById;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setCompetitionsById(LinkedHashMap<Integer, CompetitionObj> linkedHashMap) {
        this.competitionsById = linkedHashMap;
    }

    public void setCompetitorsById(LinkedHashMap<Integer, CompObj> linkedHashMap) {
        this.competitorsById = linkedHashMap;
    }

    public void setCountriesById(LinkedHashMap<Integer, CountryObj> linkedHashMap) {
        this.countriesById = linkedHashMap;
    }

    public void setTableData(ArrayList<StatsTableRow> arrayList) {
        this.tableData = arrayList;
    }
}
