package com.scores365.api;

import com.scores365.entitys.GsonManager;
/* compiled from: ApiBPRetargeting.kt */
/* loaded from: classes2.dex */
public final class e0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private pe.h f22969a;

    /* renamed from: b  reason: collision with root package name */
    private String f22970b = "";

    public final String a() {
        return this.f22970b;
    }

    public final pe.h b() {
        return this.f22969a;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.api.d
    public String getURL() {
        String l02 = li.p0.l0("BP_RETARGETING_DATA_URL");
        kotlin.jvm.internal.m.f(l02, "getTerm(\"BP_RETARGETING_DATA_URL\")");
        return l02;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f22970b = str;
        this.f22969a = (pe.h) GsonManager.getGson().l(str, pe.h.class);
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
