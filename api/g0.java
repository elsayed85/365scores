package com.scores365.api;

import android.content.Context;
import com.scores365.App;
import com.scores365.entitys.GsonManager;
/* compiled from: ApiBoosts.kt */
/* loaded from: classes2.dex */
public final class g0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private final int f23002a;

    /* renamed from: b  reason: collision with root package name */
    private le.a f23003b;

    public g0(int i10) {
        this.f23002a = i10;
    }

    public final le.a a() {
        return this.f23003b;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "";
    }

    @Override // com.scores365.api.d
    protected StringBuilder getRequestUrl() {
        String u10;
        String l02 = li.p0.l0("GC_BETBOOST_CARD_URL");
        kotlin.jvm.internal.m.f(l02, "getTerm(\"GC_BETBOOST_CARD_URL\")");
        u10 = kotlin.text.u.u(l02, "#GAME_ID", String.valueOf(this.f23002a), false, 4, null);
        le.b bVar = le.b.f34226a;
        Context m10 = App.m();
        kotlin.jvm.internal.m.f(m10, "getInstance()");
        return new StringBuilder(bVar.i(u10, m10));
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23003b = (le.a) GsonManager.getGson().l(str, le.a.class);
    }
}
