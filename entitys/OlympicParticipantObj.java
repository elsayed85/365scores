package com.scores365.entitys;

import com.scores365.entitys.CompObj;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class OlympicParticipantObj implements Serializable {
    @p9.c("CompetitorID")
    public int competitorId;
    @p9.c("CompetitorType")
    private int competitorType;
    @p9.c("Country")
    public int countryId;
    @p9.c("IsOR")
    public boolean isOlympicRecord;
    @p9.c("Qualify")
    public boolean isQualifier;
    @p9.c("RecordHolder")
    public boolean isRecordHolder;
    @p9.c("IsWR")
    public boolean isWorldRecord;
    @p9.c("Medal")
    public boolean medal;
    @p9.c("MedalType")
    public int medalType;
    @p9.c("Name")
    public String name;
    @p9.c("Order")
    public int order;
    @p9.c("Position")
    public String position;
    @p9.c("Record")
    public String record;
    @p9.c("Result")
    public String result;

    public CompObj.eCompetitorType getCompetitorType() {
        return CompObj.eCompetitorType.create(this.competitorType);
    }
}
