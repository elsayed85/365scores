package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class OlympicMedalEntry implements Serializable {
    @p9.c("Rank")
    private int Rank;
    @p9.c("Bronze")
    private int bronzeMedals;
    @p9.c("Country")
    private CountryObj countryObj;
    @p9.c("Gold")
    private int goldMedals;
    @p9.c("Silver")
    private int silverMedals;
    @p9.c("Total")
    private int totalMedals;

    public OlympicMedalEntry(int i10, String str, int i11, int i12, int i13, int i14, int i15) {
        this.goldMedals = -1;
        this.silverMedals = -1;
        this.bronzeMedals = -1;
        this.totalMedals = -1;
        this.Rank = -1;
        this.countryObj = new CountryObj(i10, str);
        this.goldMedals = i11;
        this.silverMedals = i12;
        this.bronzeMedals = i13;
        this.totalMedals = i14;
        this.Rank = i15;
    }

    public int getBronzeMedals() {
        return this.bronzeMedals;
    }

    public int getCountryId() {
        return this.countryObj.getID();
    }

    public String getCountryName() {
        return this.countryObj.getName();
    }

    public int getGoldMedals() {
        return this.goldMedals;
    }

    public int getRank() {
        return this.Rank;
    }

    public int getSilverMedals() {
        return this.silverMedals;
    }

    public int getTotalMedals() {
        return this.totalMedals;
    }
}
