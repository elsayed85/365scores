package com.scores365.api;

import com.scores365.entitys.GsonManager;
/* compiled from: ApiShotChart.kt */
/* loaded from: classes2.dex */
public final class o1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f23171a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23172b;

    /* renamed from: c  reason: collision with root package name */
    private zh.c f23173c;

    public o1(String gameId, int i10) {
        kotlin.jvm.internal.m.g(gameId, "gameId");
        this.f23171a = gameId;
        this.f23172b = i10;
        call();
    }

    public final zh.c a() {
        return this.f23173c;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Data/Games/GameCenter/EventsChart/?gameid=");
        sb2.append(this.f23171a);
        if (this.f23172b > -1) {
            str = "&pid=" + this.f23172b;
        } else {
            str = "";
        }
        sb2.append(str);
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23173c = (zh.c) GsonManager.getGson().l(str, zh.c.class);
    }
}
