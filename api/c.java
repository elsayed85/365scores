package com.scores365.api;

import android.content.Context;
import com.scores365.entitys.CategorizedObj;
import com.scores365.entitys.GsonManager;
/* compiled from: APICategorized.java */
/* loaded from: classes2.dex */
public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    protected int f22930a;

    /* renamed from: b  reason: collision with root package name */
    private int f22931b;

    /* renamed from: c  reason: collision with root package name */
    private int f22932c;

    /* renamed from: d  reason: collision with root package name */
    protected String f22933d;

    /* renamed from: e  reason: collision with root package name */
    protected CategorizedObj f22934e;

    public c(Context context, int i10, int i11, int i12) {
        this.f22930a = i10;
        this.f22932c = i12;
        this.f22931b = i11;
    }

    public CategorizedObj a() {
        return this.f22934e;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Data/Entities/Competitions/Categorized/?");
        if (this.f22931b > -1) {
            sb2.append("&sid=");
            sb2.append(this.f22931b);
        }
        if (this.f22932c > -1) {
            sb2.append("&CountryID=");
            sb2.append(this.f22932c);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f22934e = (CategorizedObj) GsonManager.getGson().l(str, CategorizedObj.class);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        this.f22933d = str;
    }
}
