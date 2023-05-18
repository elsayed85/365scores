package com.scores365.api;

import android.content.Context;
import com.scores365.App;
import com.scores365.entitys.GsonManager;
/* compiled from: ApiMyScoresBoost.kt */
/* loaded from: classes2.dex */
public final class z0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private le.c f23269a;

    public final le.c a() {
        return this.f23269a;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "";
    }

    @Override // com.scores365.api.d
    protected StringBuilder getRequestUrl() {
        String l02 = li.p0.l0("MY_SCORES_BOOST_CARD_URL");
        kotlin.jvm.internal.m.f(l02, "getTerm(\"MY_SCORES_BOOST_CARD_URL\")");
        le.b bVar = le.b.f34226a;
        Context m10 = App.m();
        kotlin.jvm.internal.m.f(m10, "getInstance()");
        return new StringBuilder(bVar.i(l02, m10));
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23269a = (le.c) GsonManager.getGson().l(str, le.c.class);
    }
}
