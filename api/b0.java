package com.scores365.api;

import com.scores365.entitys.GsonManager;
import com.scores365.entitys.LastMatchesObj;
/* compiled from: ApiAthleteGames.java */
/* loaded from: classes2.dex */
public class b0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f22926a;

    /* renamed from: b  reason: collision with root package name */
    private LastMatchesObj f22927b;

    public b0(String str) {
        this.f22926a = str;
        this.containSlash = false;
    }

    public LastMatchesObj a() {
        return this.f22927b;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return this.f22926a;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f22927b = (LastMatchesObj) GsonManager.getGson().l(str, LastMatchesObj.class);
    }
}
