package com.scores365.entitys;

import com.google.gson.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import li.x0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ChartDashboardData implements Serializable {
    private static final long serialVersionUID = -7701393884707615428L;
    @p9.c("Rows")
    public ArrayList<ChartRowObj> chartData;
    @p9.c("Competition")
    public CompetitionObj competitionObj;
    @p9.c("Competitions")
    public LinkedHashMap<Integer, CompetitionObj> competitiosById;
    @p9.c("Competitors")
    public LinkedHashMap<Integer, CompObj> competitorsById;
    @p9.c("Countries")
    public LinkedHashMap<Integer, CountryObj> countriesById;

    public static ChartDashboardData parse(JSONObject jSONObject) {
        try {
            return (ChartDashboardData) GsonManager.getGson().l(jSONObject.toString(), ChartDashboardData.class);
        } catch (s e10) {
            x0.N1(e10);
            return null;
        }
    }
}
