package com.scores365.removeAds;
/* loaded from: classes2.dex */
public enum eRemoveAdsScreenType {
    OPEN_SCREEN(1),
    BUY_SCREEN(2),
    SOCIAL_LOGIN(3),
    APPROVEMENT_SCREEN(4),
    LIFETIME_SELL(5);
    
    private final int value;

    eRemoveAdsScreenType(int i10) {
        this.value = i10;
    }

    public int getValue() {
        return this.value;
    }
}
