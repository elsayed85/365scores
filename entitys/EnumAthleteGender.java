package com.scores365.entitys;
/* loaded from: classes2.dex */
public enum EnumAthleteGender {
    UNKNOWN(0),
    MALE(1),
    FEMALE(2),
    MIXED(3);
    
    private int value;

    EnumAthleteGender(int i10) {
        this.value = i10;
    }

    public static EnumAthleteGender create(int i10) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return null;
                    }
                    return MIXED;
                }
                return FEMALE;
            }
            return MALE;
        }
        return UNKNOWN;
    }

    public int getValue() {
        return this.value;
    }
}
