package com.scores365.api;

import com.scores365.entitys.GsonManager;
import com.scores365.entitys.OutrightBetDetailsObj;
/* compiled from: ApiOutrightsDialog.kt */
/* loaded from: classes2.dex */
public final class b1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f22928a;

    /* renamed from: b  reason: collision with root package name */
    private OutrightBetDetailsObj f22929b;

    public b1(String urlSuffix) {
        kotlin.jvm.internal.m.g(urlSuffix, "urlSuffix");
        this.f22928a = urlSuffix;
    }

    public final OutrightBetDetailsObj a() {
        return this.f22929b;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return this.f22928a;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f22929b = (OutrightBetDetailsObj) GsonManager.getGson().l(str, OutrightBetDetailsObj.class);
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
