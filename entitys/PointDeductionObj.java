package com.scores365.entitys;

import java.io.Serializable;
import kotlin.jvm.internal.m;
/* compiled from: PointDeductionObj.kt */
/* loaded from: classes2.dex */
public final class PointDeductionObj implements Serializable {
    @p9.c("CompetitorId")
    private int competitorId = -1;
    @p9.c("CompetitorName")
    private String competitorName = "";
    @p9.c("Points")
    private int points = -1;
    @p9.c("For")
    private int mFor = -1;
    @p9.c("Against")
    private int against = -1;
    @p9.c("Reason")
    private String reason = "";
    @p9.c("DeductionDate")
    private String deductionDate = "";
    @p9.c("DeductionText")
    private String deductionText = "";

    public final int getAgainst() {
        return this.against;
    }

    public final int getCompetitorId() {
        return this.competitorId;
    }

    public final String getCompetitorName() {
        return this.competitorName;
    }

    public final String getDeductionDate() {
        return this.deductionDate;
    }

    public final String getDeductionText() {
        return this.deductionText;
    }

    public final int getMFor() {
        return this.mFor;
    }

    public final int getPoints() {
        return this.points;
    }

    public final String getReason() {
        return this.reason;
    }

    public final void setAgainst(int i10) {
        this.against = i10;
    }

    public final void setCompetitorId(int i10) {
        this.competitorId = i10;
    }

    public final void setCompetitorName(String str) {
        m.g(str, "<set-?>");
        this.competitorName = str;
    }

    public final void setDeductionDate(String str) {
        m.g(str, "<set-?>");
        this.deductionDate = str;
    }

    public final void setDeductionText(String str) {
        m.g(str, "<set-?>");
        this.deductionText = str;
    }

    public final void setMFor(int i10) {
        this.mFor = i10;
    }

    public final void setPoints(int i10) {
        this.points = i10;
    }

    public final void setReason(String str) {
        m.g(str, "<set-?>");
        this.reason = str;
    }
}
