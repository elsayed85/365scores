package com.scores365.api;

import com.scores365.entitys.GameStatistics;
import com.scores365.entitys.GsonManager;
/* compiled from: ApiStatisticsFilter.kt */
/* loaded from: classes2.dex */
public final class p1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f23182a;

    /* renamed from: b  reason: collision with root package name */
    private GameStatistics f23183b;

    public p1(String filtersPath) {
        kotlin.jvm.internal.m.g(filtersPath, "filtersPath");
        this.f23182a = filtersPath;
    }

    public final GameStatistics a() {
        return this.f23183b;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return this.f23182a;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23183b = (GameStatistics) GsonManager.getGson().l(str, GameStatistics.class);
    }
}
