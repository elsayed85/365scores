package com.scores365.entitys;

import java.io.Serializable;
/* compiled from: DynamicBettingPromotionTemplateDistributionObj.kt */
/* loaded from: classes2.dex */
public final class DynamicBettingPromotionTemplateDistributionObj implements Serializable {
    @p9.c("Dates")
    private DynamicBettingPromotionTemplateDistributionDatesObj dates;
    @p9.c("Frequencies")
    private DynamicBettingPromotionTemplateDistributionFrequenciesObj frequencies;
    @p9.c("WEIGHT")
    private int weight;

    public final DynamicBettingPromotionTemplateDistributionDatesObj getDates() {
        return this.dates;
    }

    public final DynamicBettingPromotionTemplateDistributionFrequenciesObj getFrequencies() {
        return this.frequencies;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final void setDates(DynamicBettingPromotionTemplateDistributionDatesObj dynamicBettingPromotionTemplateDistributionDatesObj) {
        this.dates = dynamicBettingPromotionTemplateDistributionDatesObj;
    }

    public final void setFrequencies(DynamicBettingPromotionTemplateDistributionFrequenciesObj dynamicBettingPromotionTemplateDistributionFrequenciesObj) {
        this.frequencies = dynamicBettingPromotionTemplateDistributionFrequenciesObj;
    }

    public final void setWeight(int i10) {
        this.weight = i10;
    }

    public String toString() {
        return "BpDist(dates=" + this.dates + ", frequencies=" + this.frequencies + ", weight=" + this.weight + ')';
    }
}
