package com.scores365.tapbarMonetization.monetizationEntities;

import di.l;
import p9.c;
/* loaded from: classes2.dex */
public class StadiumMonetizationWorldCupObject extends ContentMonetizationWorldCupObject {
    @c("Capacity")
    private String capacity;
    @c("City")
    private String city;

    public StadiumMonetizationWorldCupObject(String str, String str2, String str3, boolean z10, l.b bVar, String str4, String str5) {
        super(str, str2, str3, z10, bVar);
        this.city = str4;
        this.capacity = str5;
    }

    public String getCapacity() {
        return this.capacity;
    }

    public String getCity() {
        return this.city;
    }

    public void setCapacity(String str) {
        this.capacity = str;
    }

    public void setCity(String str) {
        this.city = str;
    }
}
