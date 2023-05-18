package com.scores365.entitys;

import kotlin.jvm.internal.m;
/* compiled from: RoundFilterObj.kt */
/* loaded from: classes2.dex */
public final class RoundFilterObj {
    @p9.c("Key")
    private final String key;
    @p9.c("Title")
    private final String title;

    public RoundFilterObj(String str, String str2) {
        this.key = str;
        this.title = str2;
    }

    public static /* synthetic */ RoundFilterObj copy$default(RoundFilterObj roundFilterObj, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = roundFilterObj.key;
        }
        if ((i10 & 2) != 0) {
            str2 = roundFilterObj.title;
        }
        return roundFilterObj.copy(str, str2);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.title;
    }

    public final RoundFilterObj copy(String str, String str2) {
        return new RoundFilterObj(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RoundFilterObj) {
            RoundFilterObj roundFilterObj = (RoundFilterObj) obj;
            return m.b(this.key, roundFilterObj.key) && m.b(this.title, roundFilterObj.title);
        }
        return false;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.key;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "RoundFilterObj(key=" + this.key + ", title=" + this.title + ')';
    }
}
