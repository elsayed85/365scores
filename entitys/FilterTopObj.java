package com.scores365.entitys;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
/* compiled from: FilterTopObj.kt */
/* loaded from: classes2.dex */
public final class FilterTopObj implements Serializable {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 3673297764031634323L;
    @p9.c("ID")

    /* renamed from: id  reason: collision with root package name */
    private final Integer f23586id;
    @p9.c("Name")
    private final String name;

    /* compiled from: FilterTopObj.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FilterTopObj(Integer num, String str) {
        this.f23586id = num;
        this.name = str;
    }

    public static /* synthetic */ FilterTopObj copy$default(FilterTopObj filterTopObj, Integer num, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = filterTopObj.f23586id;
        }
        if ((i10 & 2) != 0) {
            str = filterTopObj.name;
        }
        return filterTopObj.copy(num, str);
    }

    public final Integer component1() {
        return this.f23586id;
    }

    public final String component2() {
        return this.name;
    }

    public final FilterTopObj copy(Integer num, String str) {
        return new FilterTopObj(num, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FilterTopObj) {
            FilterTopObj filterTopObj = (FilterTopObj) obj;
            return m.b(this.f23586id, filterTopObj.f23586id) && m.b(this.name, filterTopObj.name);
        }
        return false;
    }

    public final Integer getId() {
        return this.f23586id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        Integer num = this.f23586id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.name;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "FilterTopObj(id=" + this.f23586id + ", name=" + this.name + ')';
    }
}
