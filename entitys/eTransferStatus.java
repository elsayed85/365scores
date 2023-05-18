package com.scores365.entitys;
/* loaded from: classes2.dex */
public enum eTransferStatus {
    CONFIRMED(2),
    RUMOUR(5);
    
    private int value;

    eTransferStatus(int i10) {
        this.value = i10;
    }

    public static eTransferStatus create(int i10) {
        return i10 != 2 ? RUMOUR : CONFIRMED;
    }

    public int getValue() {
        return this.value;
    }
}
