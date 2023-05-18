package com.scores365.api;

import com.scores365.entitys.GsonManager;
import com.scores365.entitys.WinProbabilityObj;
/* compiled from: ApiWinningProbability.kt */
/* loaded from: classes2.dex */
public final class t1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private final int f23214a;

    /* renamed from: b  reason: collision with root package name */
    private WinProbabilityObj f23215b;

    public t1(int i10) {
        this.f23214a = i10;
    }

    public final WinProbabilityObj a() {
        return this.f23215b;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("Data/Games/GameCenter/WinProbability?");
            sb2.append("gameId=");
            sb2.append(this.f23214a);
            sb2.append("&OddsFormat=");
            sb2.append(sf.b.X1().A2().getValue());
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        String sb3 = sb2.toString();
        kotlin.jvm.internal.m.f(sb3, "params.toString()");
        return sb3;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23215b = (WinProbabilityObj) GsonManager.getGson().l(str, WinProbabilityObj.class);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
