package com.scores365.api;

import com.scores365.entitys.GsonManager;
/* compiled from: ApiWebSync.kt */
/* loaded from: classes2.dex */
public final class s1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f23209a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23210b;

    /* renamed from: c  reason: collision with root package name */
    private vi.c f23211c;

    public s1(String scanUrl) {
        String u10;
        String u11;
        kotlin.jvm.internal.m.g(scanUrl, "scanUrl");
        String F2 = sf.b.X1().F2();
        kotlin.jvm.internal.m.f(F2, "getSettings().udid");
        this.f23209a = F2;
        u10 = kotlin.text.u.u(scanUrl, "#UID", F2, false, 4, null);
        u11 = kotlin.text.u.u(u10, "#DEVICE_TYPE", "2", false, 4, null);
        this.f23210b = u11;
        call();
    }

    public final vi.c a() {
        return this.f23211c;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.api.d
    public String getURL() {
        return this.f23210b;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23211c = (vi.c) GsonManager.getGson().l(str, vi.c.class);
    }
}
