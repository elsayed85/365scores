package com.scores365.api;

import com.scores365.entitys.GsonManager;
/* compiled from: ApiTrendsCalculation.kt */
/* loaded from: classes2.dex */
public final class r1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f23203a;

    /* renamed from: b  reason: collision with root package name */
    private ed.b f23204b;

    public r1(String str) {
        this.f23203a = str;
    }

    public final ed.b a() {
        return this.f23204b;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        String str = this.f23203a;
        return str == null ? "" : str;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23204b = (ed.b) GsonManager.getGson().l(str, ed.b.class);
    }
}
