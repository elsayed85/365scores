package com.scores365.api;

import android.content.Context;
import com.scores365.entitys.GamesObj;
/* compiled from: APIGameCenter.java */
/* loaded from: classes2.dex */
public class h extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f23007a;

    /* renamed from: b  reason: collision with root package name */
    private String f23008b;

    /* renamed from: c  reason: collision with root package name */
    private String f23009c;

    /* renamed from: d  reason: collision with root package name */
    private String f23010d;

    /* renamed from: e  reason: collision with root package name */
    private int f23011e;

    /* renamed from: f  reason: collision with root package name */
    private GamesObj f23012f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f23013g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23014h = false;

    /* renamed from: i  reason: collision with root package name */
    private int f23015i;

    /* renamed from: j  reason: collision with root package name */
    private int f23016j;

    public h(Context context, int i10, int i11, String str, String str2, int i12, int i13) {
        this.f23007a = null;
        this.f23015i = -1;
        this.f23016j = -1;
        this.f23008b = "" + i10;
        this.f23009c = "" + i11;
        this.f23007a = str;
        this.f23010d = str2;
        this.f23015i = i12;
        this.f23016j = i13;
    }

    public GamesObj a() {
        return this.f23012f;
    }

    public void b(int i10) {
        this.f23011e = i10;
    }

    public void c(boolean z10) {
        this.f23014h = z10;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Data/Games/GameCenter/?games=");
        sb2.append(this.f23007a);
        if (this.f23015i != -1) {
            sb2.append("&notificationID=");
            sb2.append(this.f23015i);
        }
        sb2.append("&ShowNAOdds=true");
        sb2.append("&withExpanded=true");
        if (this.f23014h) {
            sb2.append("&WithNews=true");
        }
        if (this.f23011e > 0) {
            sb2.append("&PromotedBuzzItems=");
            sb2.append(this.f23011e);
        }
        if (this.f23016j != -1) {
            sb2.append("&TopBM=");
            sb2.append(this.f23016j);
        }
        sb2.append("&withexpandedstats=true");
        sb2.append("&OddsFormat=");
        sb2.append(sf.b.X1().A2().getValue());
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23012f = w.h(str);
        this.f23013g = str;
    }
}
