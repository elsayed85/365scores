package com.scores365.api;

import com.scores365.entitys.GsonManager;
/* compiled from: ApiCompetitionDetailsAction.kt */
/* loaded from: classes2.dex */
public final class h0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private final int f23017a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23018b;

    /* renamed from: c  reason: collision with root package name */
    private se.o f23019c;

    public h0(int i10, int i11) {
        this.f23017a = i10;
        this.f23018b = i11;
    }

    public final se.o a() {
        return this.f23019c;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "Data/Entities/Competitions/Hosts?lang=1&CompetitionId=" + this.f23017a + "&SeasonNum=" + this.f23018b;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23019c = (se.o) GsonManager.getGson().l(str, se.o.class);
    }
}
