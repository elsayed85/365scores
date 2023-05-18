package com.scores365.entitys;

import com.google.gson.s;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import li.x0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TransfersObj {
    @p9.c("Transfers")
    public LinkedHashMap<Integer, TransferObj> transfersById;
    @p9.c("Competitors")
    public Hashtable<Integer, CompObj> competitorById = new Hashtable<>();
    @p9.c("Competitions")
    public Hashtable<Integer, CompetitionObj> competitionById = new Hashtable<>();
    @p9.c("Countries")
    public Hashtable<Integer, CountryObj> countryById = new Hashtable<>();
    @p9.c("NewsSources")
    public Hashtable<Integer, SourceObj> sourceObjById = new Hashtable<>();

    public static TransfersObj parseTransfersObj(JSONObject jSONObject) {
        try {
            return (TransfersObj) GsonManager.getGson().l(jSONObject.toString(), TransfersObj.class);
        } catch (s e10) {
            x0.N1(e10);
            return null;
        }
    }

    public void clearData() {
        try {
            LinkedHashMap<Integer, TransferObj> linkedHashMap = this.transfersById;
            if (linkedHashMap != null) {
                linkedHashMap.clear();
            }
            Hashtable<Integer, CompObj> hashtable = this.competitorById;
            if (hashtable != null) {
                hashtable.clear();
            }
            Hashtable<Integer, CompetitionObj> hashtable2 = this.competitionById;
            if (hashtable2 != null) {
                hashtable2.clear();
            }
            Hashtable<Integer, CountryObj> hashtable3 = this.countryById;
            if (hashtable3 != null) {
                hashtable3.clear();
            }
            Hashtable<Integer, SourceObj> hashtable4 = this.sourceObjById;
            if (hashtable4 != null) {
                hashtable4.clear();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void mergeTransfersObj(TransfersObj transfersObj) {
        try {
            LinkedHashMap<Integer, TransferObj> linkedHashMap = transfersObj.transfersById;
            if (linkedHashMap != null) {
                this.transfersById.putAll(linkedHashMap);
            }
            Hashtable<Integer, CompObj> hashtable = transfersObj.competitorById;
            if (hashtable != null) {
                this.competitorById.putAll(hashtable);
            }
            Hashtable<Integer, CompetitionObj> hashtable2 = transfersObj.competitionById;
            if (hashtable2 != null) {
                this.competitionById.putAll(hashtable2);
            }
            Hashtable<Integer, CountryObj> hashtable3 = transfersObj.countryById;
            if (hashtable3 != null) {
                this.countryById.putAll(hashtable3);
            }
            Hashtable<Integer, SourceObj> hashtable4 = transfersObj.sourceObjById;
            if (hashtable4 != null) {
                this.sourceObjById.putAll(hashtable4);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
