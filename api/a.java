package com.scores365.api;

import com.scores365.entitys.AthletesObj;
/* compiled from: APIAthletes.java */
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private AthletesObj f22918a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22919b;

    /* renamed from: c  reason: collision with root package name */
    private final String f22920c;

    /* renamed from: d  reason: collision with root package name */
    private int f22921d;

    public a(String str, int i10) {
        this.f22920c = str;
        this.f22919b = i10;
    }

    public AthletesObj a() {
        return this.f22918a;
    }

    public void b(int i10) {
        this.f22921d = i10;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Data/Entities/Athletes/?");
        if (this.f22919b > 0) {
            sb2.append("CompetitionID=");
            sb2.append(this.f22919b);
            z10 = true;
        } else {
            z10 = false;
        }
        if (!this.f22920c.isEmpty()) {
            if (z10) {
                sb2.append("&");
            }
            sb2.append("athletes=");
            sb2.append(this.f22920c);
        }
        sb2.append("&fulldetails=true");
        if (this.f22921d > 0) {
            sb2.append("&PromotedBuzzItems=");
            sb2.append(this.f22921d);
        }
        sb2.append("&NewsLang=");
        sb2.append(sf.b.X1().s2());
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f22918a = w.f(str);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
