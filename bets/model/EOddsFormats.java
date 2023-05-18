package com.scores365.bets.model;

import li.x0;
/* loaded from: classes2.dex */
public enum EOddsFormats {
    DECIMAL(1),
    FRACTIONAL(2),
    AMERICAN(3);
    
    private int value;

    EOddsFormats(int i10) {
        this.value = i10;
    }

    public static EOddsFormats create(int i10) {
        EOddsFormats eOddsFormats = DECIMAL;
        if (i10 != 1) {
            try {
                if (i10 == 2) {
                    eOddsFormats = FRACTIONAL;
                } else if (i10 == 3) {
                    eOddsFormats = AMERICAN;
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
        return eOddsFormats;
    }

    public int getValue() {
        return this.value;
    }
}
