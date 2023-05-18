package com.scores365.api;

import com.scores365.entitys.GamesObj;
/* compiled from: ApiDashboardGames.java */
/* loaded from: classes2.dex */
public class l0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private GamesObj f23110a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f23111b;

    /* renamed from: c  reason: collision with root package name */
    private String f23112c;

    /* renamed from: d  reason: collision with root package name */
    private String f23113d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f23114e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f23115f;

    public l0(String str, String str2, String str3, boolean z10, boolean z11) {
        this.f23111b = str;
        this.f23112c = str2;
        this.f23113d = str3;
        this.f23114e = z10;
        this.f23115f = z11;
    }

    public GamesObj a() {
        return this.f23110a;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder("Data/Games/Dashboard/?");
        sb2.append("competitions=");
        sb2.append(this.f23111b);
        sb2.append("&competitors=");
        sb2.append(this.f23112c);
        sb2.append("&games=");
        sb2.append(this.f23113d);
        sb2.append("&FullCurrTime=true");
        sb2.append("&onlyvideos=false");
        sb2.append("&withExpanded=true");
        if (this.f23114e && li.x0.s2()) {
            sb2.append("&WithMainOdds=true");
            sb2.append("&WithOddsPreviews=true");
        }
        sb2.append("&ShowNAOdds=true");
        if (this.f23115f) {
            sb2.append("&FiltersRelation=And");
        }
        sb2.append("&OddsFormat=");
        sb2.append(sf.b.X1().A2().getValue());
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23110a = w.h(str);
    }
}
