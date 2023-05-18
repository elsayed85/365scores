package com.scores365.api;

import com.scores365.App;
import com.scores365.bets.model.GameBetsObj;
import com.scores365.entitys.GsonManager;
import java.util.Date;
/* compiled from: ApiScoresOdds.java */
/* loaded from: classes2.dex */
public class l1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f23116a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23117b;

    /* renamed from: c  reason: collision with root package name */
    private String f23118c;

    /* renamed from: d  reason: collision with root package name */
    private String f23119d;

    /* renamed from: e  reason: collision with root package name */
    private String f23120e;

    /* renamed from: f  reason: collision with root package name */
    private String f23121f;

    /* renamed from: g  reason: collision with root package name */
    private String f23122g;

    /* renamed from: h  reason: collision with root package name */
    private String f23123h;

    /* renamed from: i  reason: collision with root package name */
    int f23124i;

    /* renamed from: j  reason: collision with root package name */
    private GameBetsObj f23125j;

    public l1(boolean z10, Date date, Date date2, String str, String str2, String str3, String str4) {
        this.f23117b = z10;
        this.f23116a = str;
        try {
            this.f23124i = sf.a.i0(App.m()).k0();
            this.f23120e = String.valueOf(sf.a.i0(App.m()).l0());
            this.f23118c = li.x0.U(date, "dd/MM/yyyy");
            this.f23119d = li.x0.U(date2, "dd/MM/yyyy");
            this.f23123h = str2;
            this.f23122g = str3;
            this.f23121f = str4;
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public GameBetsObj a() {
        return this.f23125j;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder("Data/Bets/Lines/Main/?");
        String str = this.f23123h;
        if (str != null && !str.isEmpty()) {
            sb2.append("&games=");
            sb2.append(this.f23123h);
        }
        String str2 = this.f23122g;
        if (str2 != null && !str2.isEmpty()) {
            sb2.append("&competitors=");
            sb2.append(this.f23122g);
        }
        String str3 = this.f23121f;
        if (str3 != null && !str3.isEmpty()) {
            sb2.append("&competitions=");
            sb2.append(this.f23121f);
        }
        if (this.f23118c != null) {
            sb2.append("&startdate=");
            sb2.append(this.f23118c);
        }
        if (this.f23119d != null) {
            sb2.append("&enddate=");
            sb2.append(this.f23119d);
        }
        sb2.append("&WithOddsPreviews=true");
        sb2.append(this.f23117b ? "&onlymajorgames=true" : "");
        String str4 = this.f23116a;
        if (str4 != null && !str4.isEmpty()) {
            sb2.append(this.f23116a);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23125j = (GameBetsObj) GsonManager.getGson().l(str, GameBetsObj.class);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
