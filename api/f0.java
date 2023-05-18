package com.scores365.api;

import com.scores365.entitys.GsonManager;
/* compiled from: ApiBetting5thButton.kt */
/* loaded from: classes2.dex */
public final class f0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f22990a;

    /* renamed from: b  reason: collision with root package name */
    private le.c f22991b;

    public f0(String url) {
        kotlin.jvm.internal.m.g(url, "url");
        this.f22990a = url;
        call();
    }

    public final le.c a() {
        return this.f22991b;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "";
    }

    @Override // com.scores365.api.d
    protected StringBuilder getRequestUrl() {
        return new StringBuilder(this.f22990a);
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f22991b = (le.c) GsonManager.getGson().l(str, le.c.class);
    }
}
