package com.scores365.api;

import com.scores365.entitys.EntityObj;
/* compiled from: ApiEntities.java */
/* loaded from: classes2.dex */
public class m0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f23129a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23130b;

    /* renamed from: c  reason: collision with root package name */
    private String f23131c;

    /* renamed from: d  reason: collision with root package name */
    private String f23132d;

    /* renamed from: e  reason: collision with root package name */
    private String f23133e;

    /* renamed from: f  reason: collision with root package name */
    private int f23134f;

    /* renamed from: g  reason: collision with root package name */
    private int f23135g;

    /* renamed from: h  reason: collision with root package name */
    private int f23136h;

    /* renamed from: i  reason: collision with root package name */
    private String f23137i;

    /* renamed from: j  reason: collision with root package name */
    private EntityObj f23138j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23139k;

    public m0(int i10, boolean z10, String str, String str2, String str3, int i11, int i12, int i13, boolean z11) {
        this.f23129a = i10;
        this.f23130b = z10;
        this.f23131c = str;
        this.f23132d = str2;
        this.f23133e = str3;
        this.f23134f = i11;
        this.f23135g = i12;
        this.f23136h = i13;
        this.f23139k = z11;
    }

    public EntityObj a() {
        return this.f23138j;
    }

    public boolean b() {
        EntityObj entityObj;
        try {
            String str = this.f23137i;
            if (str == null || str.isEmpty() || (entityObj = this.f23138j) == null || entityObj.getCompetitions() == null || this.f23138j.getCompetitions().isEmpty() || this.f23138j.getCompetitors() == null || this.f23138j.getCompetitors().isEmpty() || this.f23138j.getCountries() == null) {
                return false;
            }
            return this.f23138j.getCountries().length > 0;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Data/Entities/");
        int i10 = this.f23129a;
        if (i10 == 2) {
            sb2.append("Competitions/");
        } else if (i10 == 3) {
            sb2.append("Competitors/");
        } else if (i10 == 6) {
            sb2.append("Athletes/");
        } else if (i10 == 7) {
            sb2.append("Countries/");
        }
        sb2.append("?");
        sb2.append("catalog=");
        sb2.append(this.f23130b);
        String str = this.f23131c;
        if (str != null && !str.equals("")) {
            sb2.append("&competitors=");
            sb2.append(this.f23131c);
        }
        String str2 = this.f23132d;
        if (str2 != null && !str2.equals("")) {
            sb2.append("&competitions=");
            sb2.append(this.f23132d);
        }
        String str3 = this.f23133e;
        if (str3 != null && !str3.equals("")) {
            sb2.append("&athletes=");
            sb2.append(this.f23133e);
        }
        if (this.f23134f != -1) {
            sb2.append("&countryId=");
            sb2.append(this.f23134f);
        }
        if (this.f23135g != -1) {
            sb2.append("&CompetitionID=");
            sb2.append(this.f23135g);
        }
        if (this.f23136h != -1) {
            sb2.append("&sid=");
            sb2.append(this.f23136h);
        }
        sb2.append("&withlivecount=");
        sb2.append(this.f23139k);
        sb2.append("&onlyfromcache=true");
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23137i = str;
        this.f23138j = w.g(str);
    }
}
