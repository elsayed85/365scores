package com.scores365.entitys;

import kotlin.jvm.internal.m;
/* compiled from: Params.kt */
/* loaded from: classes2.dex */
public final class Params extends BaseObj {
    @p9.c("ActualProbability")
    private final String actualProbability;
    @p9.c("Change")
    private final String change;
    @p9.c("CompetitorId")
    private final String competitorId;
    @p9.c("PredictedProbability")
    private final String predictedProbability;
    @p9.c("TrendCompetitor")
    private final String trendCompetitor;

    public Params(String str, String str2, String competitorId, String str3, String str4) {
        m.g(competitorId, "competitorId");
        this.actualProbability = str;
        this.change = str2;
        this.competitorId = competitorId;
        this.predictedProbability = str3;
        this.trendCompetitor = str4;
    }

    public static /* synthetic */ Params copy$default(Params params, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = params.actualProbability;
        }
        if ((i10 & 2) != 0) {
            str2 = params.change;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = params.competitorId;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = params.predictedProbability;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = params.trendCompetitor;
        }
        return params.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.actualProbability;
    }

    public final String component2() {
        return this.change;
    }

    public final String component3() {
        return this.competitorId;
    }

    public final String component4() {
        return this.predictedProbability;
    }

    public final String component5() {
        return this.trendCompetitor;
    }

    public final Params copy(String str, String str2, String competitorId, String str3, String str4) {
        m.g(competitorId, "competitorId");
        return new Params(str, str2, competitorId, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Params) {
            Params params = (Params) obj;
            return m.b(this.actualProbability, params.actualProbability) && m.b(this.change, params.change) && m.b(this.competitorId, params.competitorId) && m.b(this.predictedProbability, params.predictedProbability) && m.b(this.trendCompetitor, params.trendCompetitor);
        }
        return false;
    }

    public final String getActualProbability() {
        return this.actualProbability;
    }

    public final String getChange() {
        return this.change;
    }

    public final String getCompetitorId() {
        return this.competitorId;
    }

    public final String getPredictedProbability() {
        return this.predictedProbability;
    }

    public final String getTrendCompetitor() {
        return this.trendCompetitor;
    }

    public int hashCode() {
        String str = this.actualProbability;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.change;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.competitorId.hashCode()) * 31;
        String str3 = this.predictedProbability;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.trendCompetitor;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Params(actualProbability=" + this.actualProbability + ", change=" + this.change + ", competitorId=" + this.competitorId + ", predictedProbability=" + this.predictedProbability + ", trendCompetitor=" + this.trendCompetitor + ')';
    }
}
