package com.scores365.entitys;

import java.io.Serializable;
/* compiled from: DynamicBettingPromotionTemplateDistributionFrequenciesObj.kt */
/* loaded from: classes2.dex */
public final class DynamicBettingPromotionTemplateDistributionFrequenciesObj implements Serializable {
    @p9.c("FIRST_SHOW_MIN")
    private int firstShowMin = -1;
    @p9.c("NEXT_SHOW_MIN")
    private int nextShowMin = -1;
    @p9.c("HOURLY_CAP")
    private int hourlyCap = -1;
    @p9.c("DAILY_CAP")
    private int dailyCap = -1;
    @p9.c("WEEKLY_CAP")
    private int weeklyCap = -1;
    @p9.c("LIFE_TIME_CAP")
    private int lifeTimeCap = -1;

    public final int getDailyCap() {
        return this.dailyCap;
    }

    public final int getFirstShowMin() {
        return this.firstShowMin;
    }

    public final int getHourlyCap() {
        return this.hourlyCap;
    }

    public final int getLifeTimeCap() {
        return this.lifeTimeCap;
    }

    public final int getNextShowMin() {
        return this.nextShowMin;
    }

    public final int getWeeklyCap() {
        return this.weeklyCap;
    }

    public final void setDailyCap(int i10) {
        this.dailyCap = i10;
    }

    public final void setFirstShowMin(int i10) {
        this.firstShowMin = i10;
    }

    public final void setHourlyCap(int i10) {
        this.hourlyCap = i10;
    }

    public final void setLifeTimeCap(int i10) {
        this.lifeTimeCap = i10;
    }

    public final void setNextShowMin(int i10) {
        this.nextShowMin = i10;
    }

    public final void setWeeklyCap(int i10) {
        this.weeklyCap = i10;
    }
}
