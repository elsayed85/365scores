package com.scores365.entitys;

import com.scores365.entitys.CompObj;
import li.x0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MedalObj extends BaseObj {
    @p9.c("Athlete")
    public String Athlete;
    @p9.c("AthleteCID")
    public int AthleteCID;
    @p9.c("CompetitorID")
    public int CompetitorID;
    @p9.c("IsOR")
    public boolean IsOR;
    @p9.c("IsWR")
    public boolean IsWR;
    @p9.c("MedalType")
    public int MedalType;
    @p9.c("OldRecord")
    public String OldRecord;
    @p9.c("Result")
    public String Result;
    @p9.c("CompetitorType")
    public CompObj.eCompetitorType competitorType;

    public MedalObj(int i10, String str, int i11, int i12, String str2, boolean z10, boolean z11, String str3, CompObj.eCompetitorType ecompetitortype) {
        this.MedalType = i10;
        this.Athlete = str;
        this.AthleteCID = i11;
        this.CompetitorID = i12;
        this.Result = str2;
        this.IsWR = z11;
        this.IsOR = z10;
        this.OldRecord = str3;
        this.competitorType = ecompetitortype;
    }

    public static MedalObj parseSingleMedalObj(JSONObject jSONObject) {
        try {
            if (jSONObject != null) {
                return new MedalObj(jSONObject.has("MedalType") ? jSONObject.getInt("MedalType") : -1, jSONObject.has("Athlete") ? jSONObject.getString("Athlete") : "", jSONObject.has("AthleteCID") ? jSONObject.getInt("AthleteCID") : -1, jSONObject.has("CompetitorID") ? jSONObject.getInt("CompetitorID") : -1, jSONObject.has("Result") ? jSONObject.getString("Result") : "", false, jSONObject.has("IsOR") ? jSONObject.getBoolean("IsOR") : jSONObject.has("IsWR") ? jSONObject.getBoolean("IsWR") : false, jSONObject.has("OldRecord") ? jSONObject.getString("OldRecord") : "", jSONObject.has("CompetitorType") ? CompObj.eCompetitorType.create(jSONObject.getInt("CompetitorType")) : CompObj.eCompetitorType.create(1));
            }
            throw new IllegalArgumentException("jsonObject Cannot be null..");
        } catch (NullPointerException | JSONException e10) {
            x0.N1(e10);
            return null;
        }
    }
}
