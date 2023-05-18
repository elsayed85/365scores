package com.scores365.entitys;

import li.x0;
/* loaded from: classes2.dex */
public enum eAthleteInjuryCategory {
    UNKONWN(0),
    MEDICAL(1),
    NATIONAL_TEAM(2),
    PERSONAL_REASONS(3);
    
    private int value;

    eAthleteInjuryCategory(int i10) {
        this.value = i10;
    }

    public static eAthleteInjuryCategory create(int i10) {
        try {
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? UNKONWN : PERSONAL_REASONS : NATIONAL_TEAM : MEDICAL;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public int getValue() {
        return this.value;
    }
}
