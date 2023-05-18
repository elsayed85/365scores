package com.scores365.api;

import android.content.Context;
import com.scores365.entitys.GamesObj;
/* compiled from: APIFixtures.java */
/* loaded from: classes2.dex */
public class g extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f22994a;

    /* renamed from: b  reason: collision with root package name */
    private int f22995b;

    /* renamed from: c  reason: collision with root package name */
    private GamesObj f22996c;

    /* renamed from: d  reason: collision with root package name */
    private String f22997d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f22998e;

    /* renamed from: f  reason: collision with root package name */
    int f22999f;

    /* renamed from: g  reason: collision with root package name */
    int f23000g;

    /* renamed from: h  reason: collision with root package name */
    int f23001h;

    public g(Context context, int i10) {
        this.f22995b = -1;
        this.f22996c = null;
        this.f22997d = null;
        this.f22998e = false;
        this.f22999f = -1;
        this.f23000g = -1;
        this.f23001h = -1;
        this.f22994a = i10;
        this.f22995b = sf.a.i0(context).j0();
    }

    public g(Context context, int i10, int i11, int i12, int i13) {
        this.f22995b = -1;
        this.f22996c = null;
        this.f22997d = null;
        this.f22998e = false;
        this.f22999f = -1;
        this.f23000g = -1;
        this.f23001h = -1;
        this.f22994a = i10;
        this.f22995b = sf.a.i0(context).j0();
        this.f22999f = i12;
        this.f23001h = i11;
        this.f23000g = i13;
    }

    public GamesObj a() {
        return this.f22996c;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Data/Games/Fixtures/");
        if (this.f22998e) {
            sb2.append("Live/");
        }
        sb2.append("?CompetitionID=");
        sb2.append(this.f22994a);
        if (this.f22999f > -1) {
            sb2.append("&Season=");
            sb2.append(this.f22999f);
        }
        if (this.f23000g > -1) {
            sb2.append("&Group=");
            sb2.append(this.f23000g);
        }
        if (this.f23001h > -1) {
            sb2.append("&Stage=");
            sb2.append(this.f23001h);
        }
        sb2.append("&UserCountry=");
        sb2.append(this.f22995b);
        sb2.append("&OddsFormat=");
        sb2.append(sf.b.X1().A2().getValue());
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f22996c = w.h(str);
        this.f22997d = str;
    }
}
