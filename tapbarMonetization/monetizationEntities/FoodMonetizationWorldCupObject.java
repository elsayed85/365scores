package com.scores365.tapbarMonetization.monetizationEntities;

import di.l;
import p9.c;
/* loaded from: classes2.dex */
public class FoodMonetizationWorldCupObject extends ContentMonetizationWorldCupObject {
    @c("Description")
    private String description;

    public FoodMonetizationWorldCupObject(String str, String str2, String str3, boolean z10, l.b bVar, String str4) {
        super(str, str2, str3, z10, bVar);
        this.description = str4;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }
}
