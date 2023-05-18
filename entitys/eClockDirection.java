package com.scores365.entitys;
/* loaded from: classes2.dex */
public enum eClockDirection {
    FORWARD(1),
    BACKWARD(-1),
    WITHOUT_CLOCK(0);
    
    private int value;

    eClockDirection(int i10) {
        this.value = i10;
    }

    public static eClockDirection create(int i10) {
        return i10 != -1 ? i10 != 1 ? WITHOUT_CLOCK : FORWARD : BACKWARD;
    }

    public int getValue() {
        return this.value;
    }
}
