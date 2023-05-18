package com.scores365.api;

import com.scores365.entitys.CategorizedObj;
import com.scores365.entitys.GsonManager;
/* compiled from: APIStandingsInternational.java */
/* loaded from: classes2.dex */
public class q extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f23184a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23185b;

    /* renamed from: c  reason: collision with root package name */
    private String f23186c;

    /* renamed from: d  reason: collision with root package name */
    CategorizedObj f23187d;

    public q(int i10, boolean z10) {
        this.f23185b = z10;
        this.f23184a = i10;
    }

    public CategorizedObj a() {
        return this.f23187d;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Data/Entities/Competitions/Categorized/International/");
        if (this.f23185b) {
            sb2.append("Nations/");
        } else {
            sb2.append("Clubs/");
        }
        sb2.append("?");
        if (this.f23184a > -1) {
            sb2.append("sid=");
            sb2.append(this.f23184a);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23187d = (CategorizedObj) GsonManager.getGson().l(str, CategorizedObj.class);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        this.f23186c = str;
    }
}
