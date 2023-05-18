package com.scores365.api;

import com.scores365.App;
import com.scores365.entitys.GsonManager;
import com.scores365.entitys.LineUpsObj;
/* compiled from: ApiTeamOfTheWeek.kt */
/* loaded from: classes2.dex */
public final class q1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f23190a;

    /* renamed from: b  reason: collision with root package name */
    private LineUpsObj f23191b;

    public q1(String key) {
        kotlin.jvm.internal.m.g(key, "key");
        this.f23190a = key;
    }

    public final LineUpsObj a() {
        return this.f23191b;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        String str = "Data/Entities/Competitions/TeamOfTheWeek?weekKey=" + this.f23190a + "&langid=" + sf.a.i0(App.m()).k0();
        kotlin.jvm.internal.m.f(str, "params.toString()");
        return str;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23191b = (LineUpsObj) GsonManager.getGson().l(str, LineUpsObj.class);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
