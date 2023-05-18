package com.scores365.api;

import com.scores365.entitys.EntityObj;
/* compiled from: ApiPopularEntities.java */
/* loaded from: classes2.dex */
public class f1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f22992a;

    /* renamed from: b  reason: collision with root package name */
    private EntityObj f22993b;

    public EntityObj a() {
        return this.f22993b;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "Data/Entities/Popular/?";
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f22992a = str;
        this.f22993b = w.g(str);
    }
}
