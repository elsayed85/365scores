package com.scores365.api;

import com.scores365.entitys.GsonManager;
import com.scores365.entitys.LastMatchesObj;
/* compiled from: ApiAthleteStats.java */
/* loaded from: classes2.dex */
public class c0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private LastMatchesObj f22935a;

    /* renamed from: b  reason: collision with root package name */
    private int f22936b;

    /* renamed from: c  reason: collision with root package name */
    private int f22937c;

    /* renamed from: d  reason: collision with root package name */
    private int f22938d;

    public c0(int i10, int i11, int i12) {
        this.f22936b = i10;
        this.f22937c = i11;
        this.f22938d = i12;
    }

    public LastMatchesObj a() {
        return this.f22935a;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "Data/Entities/Athletes/Games/?athleteid=" + this.f22936b + "&competitionid=" + this.f22937c + "&stattype=" + this.f22938d + "&OddsFormat=" + sf.b.X1().A2().getValue();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f22935a = (LastMatchesObj) GsonManager.getGson().l(str, LastMatchesObj.class);
    }
}
