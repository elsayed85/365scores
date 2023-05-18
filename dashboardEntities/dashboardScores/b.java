package com.scores365.dashboardEntities.dashboardScores;
/* compiled from: ScoresGameItemWithTvChannels.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f23434a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23435b;

    public b(String listOfChannels, int i10) {
        kotlin.jvm.internal.m.g(listOfChannels, "listOfChannels");
        this.f23434a = listOfChannels;
        this.f23435b = i10;
    }

    public final int a() {
        return this.f23435b;
    }

    public final String b() {
        return this.f23434a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return kotlin.jvm.internal.m.b(this.f23434a, bVar.f23434a) && this.f23435b == bVar.f23435b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f23434a.hashCode() * 31) + this.f23435b;
    }

    public String toString() {
        return "Channels(listOfChannels=" + this.f23434a + ", lines=" + this.f23435b + ')';
    }
}
