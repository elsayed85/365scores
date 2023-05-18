package com.scores365.api;

import com.scores365.entitys.EntityObj;
/* compiled from: ApiCompetitorsEntities.java */
/* loaded from: classes2.dex */
public class j0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private EntityObj f23066a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f23067b;

    /* renamed from: c  reason: collision with root package name */
    private String f23068c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23069d;

    public j0(String str, String str2, boolean z10) {
        this.f23067b = str;
        this.f23068c = str2;
        this.f23069d = z10;
    }

    public EntityObj a() {
        return this.f23066a;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("Data/Entities/Competitors/?Competitions=");
            sb2.append(this.f23067b);
            sb2.append("&competitors=");
            sb2.append(this.f23068c);
            if (this.f23069d) {
                sb2.append("&WithCompetitions=true");
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23066a = w.g(str);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
