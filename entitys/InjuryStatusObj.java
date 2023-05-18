package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class InjuryStatusObj implements Serializable {
    @p9.c("ExpectedReturn")
    public String expectedReturn;
    @p9.c("InjuryCategory")
    public int injuryCategory;
    @p9.c("InjuryType")
    public String injuryType;
    @p9.c("InjuryTypeImgID")
    public String injuryTypeImgID;
    @p9.c("StartDate")
    public String startDate;

    public eAthleteInjuryCategory getAthleteInjuryCategory() {
        return eAthleteInjuryCategory.create(this.injuryCategory);
    }
}
