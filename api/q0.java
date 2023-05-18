package com.scores365.api;

import com.scores365.entitys.GamesObj;
/* compiled from: ApiGamesPaging.java */
/* loaded from: classes2.dex */
public class q0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f23188a;

    /* renamed from: b  reason: collision with root package name */
    private GamesObj f23189b;

    public q0(String str) {
        this.f23188a = str;
    }

    public GamesObj a() {
        return this.f23189b;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return this.f23188a.replaceAll(" ", "%20");
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23189b = w.h(str);
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
