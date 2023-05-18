package com.scores365.api;

import com.scores365.App;
import com.scores365.entitys.BaseObj;
import com.scores365.entitys.GamesObj;
import com.scores365.entitys.GsonManager;
import com.scores365.entitys.HeaderObj;
import com.scores365.entitys.dashboardSections.AbstractSectionObject;
import java.util.HashMap;
/* compiled from: APIDashboard.java */
/* loaded from: classes2.dex */
public class e extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f22946a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22947b;

    /* renamed from: c  reason: collision with root package name */
    private final String f22948c;

    /* renamed from: d  reason: collision with root package name */
    private final String f22949d;

    /* renamed from: e  reason: collision with root package name */
    private final String f22950e;

    /* renamed from: f  reason: collision with root package name */
    private final String f22951f;

    /* renamed from: g  reason: collision with root package name */
    private final int f22952g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f22953h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f22954i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f22955j;

    /* renamed from: k  reason: collision with root package name */
    private final String f22956k;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f22962q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f22963r;

    /* renamed from: t  reason: collision with root package name */
    private int f22965t;

    /* renamed from: l  reason: collision with root package name */
    private AbstractSectionObject[] f22957l = null;

    /* renamed from: m  reason: collision with root package name */
    private HashMap<Integer, BaseObj> f22958m = null;

    /* renamed from: n  reason: collision with root package name */
    private String f22959n = null;

    /* renamed from: o  reason: collision with root package name */
    private int f22960o = -1;

    /* renamed from: p  reason: collision with root package name */
    private boolean f22961p = false;

    /* renamed from: s  reason: collision with root package name */
    private String f22964s = null;

    /* renamed from: u  reason: collision with root package name */
    private HeaderObj f22966u = null;

    /* renamed from: v  reason: collision with root package name */
    private Boolean f22967v = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: APIDashboard.java */
    /* loaded from: classes2.dex */
    public class a extends com.google.gson.reflect.a<HashMap<Integer, BaseObj>> {
        a() {
        }
    }

    public e(String str, String str2, String str3, String str4, String str5, String str6, int i10, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, String str7) {
        this.f22946a = str;
        this.f22947b = str2;
        this.f22948c = str3;
        this.f22949d = str4;
        this.f22950e = str5;
        this.f22951f = str6;
        this.f22952g = i10;
        this.f22953h = z10;
        this.f22954i = z11;
        this.f22962q = z12;
        this.f22963r = z13;
        this.f22955j = z14;
        this.f22956k = str7;
    }

    private void j() {
        AbstractSectionObject[] abstractSectionObjectArr;
        for (AbstractSectionObject abstractSectionObject : this.f22957l) {
            if (abstractSectionObject != null && (abstractSectionObject.getData() instanceof GamesObj)) {
                ((GamesObj) abstractSectionObject.getData()).setWithMainOdds(this.f22963r && li.x0.s2());
            }
        }
    }

    public String a() {
        return this.f22959n;
    }

    public HeaderObj b() {
        return this.f22966u;
    }

    public AbstractSectionObject[] c() {
        return this.f22957l;
    }

    public HashMap<Integer, BaseObj> d() {
        return this.f22958m;
    }

    public void e(String str) {
        try {
            parseJSON(str);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public void f(Boolean bool) {
        this.f22967v = bool;
    }

    public void g(String str) {
        this.f22964s = str;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("Data/Dashboard/Light/?");
            sb2.append("NewsLang=");
            sb2.append(this.f22946a);
            if (this.f22961p) {
                sb2.append("&filters=");
                sb2.append(this.f22960o);
            }
            sb2.append("&Countries=");
            sb2.append(this.f22947b);
            sb2.append("&Competitions=");
            sb2.append(this.f22948c);
            sb2.append("&Competitors=");
            sb2.append(this.f22949d);
            sb2.append("&Games=");
            sb2.append(this.f22950e);
            sb2.append("&Athletes=");
            sb2.append(this.f22951f);
            if (this.f22962q) {
                sb2.append("&context=ScreenCompetitor");
            }
            sb2.append("&UserCountry=");
            sb2.append(this.f22952g);
            sb2.append("&OnlyInLang=");
            sb2.append(this.f22953h);
            sb2.append("&OnlyInCountry=");
            sb2.append(this.f22954i);
            sb2.append("&WithTransfers=true");
            sb2.append("&newsSources=");
            sb2.append(sf.b.X1().t2());
            sb2.append("&FilterSourcesOut=true");
            sb2.append("&IsTablet=");
            sb2.append(App.f20803w);
            String str = this.f22964s;
            if (str != null && !str.isEmpty()) {
                sb2.append("&Sections=");
                sb2.append(this.f22964s);
            }
            if (this.f22955j) {
                sb2.append("&FiltersRelation=And");
            }
            String str2 = this.f22956k;
            if (str2 != null && !str2.isEmpty()) {
                if (!this.f22956k.contains("&")) {
                    sb2.append("&");
                }
                sb2.append(this.f22956k);
            }
            if (this.f22963r && li.x0.s2()) {
                sb2.append("&WithMainOdds=true");
                sb2.append("&WithOddsPreviews=true");
            }
            if (this.f22965t > 0) {
                sb2.append("&PromotedBuzzItems=");
                sb2.append(this.f22965t);
            }
            if (this.f22967v != null) {
                sb2.append("&isInitialStatsRequest=");
                sb2.append(this.f22967v);
            }
            sb2.append("&OddsFormat=");
            sb2.append(sf.b.X1().A2().getValue());
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return sb2.toString();
    }

    public void h(int i10) {
        this.f22965t = i10;
    }

    public void i(int i10) {
        this.f22960o = i10;
        this.f22961p = true;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f22959n = str;
            if (str == null) {
                return;
            }
            com.google.gson.m e10 = com.google.gson.o.d(str.replace("\"TrackingURL\":\"http://www.365365.com\",", "")).e();
            this.f22957l = (AbstractSectionObject[]) GsonManager.getGson().h(e10.p("Sections"), AbstractSectionObject[].class);
            j();
            com.google.gson.j p10 = e10.p("SectionsGroups");
            if (p10 != null) {
                this.f22958m = (HashMap) GsonManager.getGson().i(p10, new a().getType());
            }
            com.google.gson.j p11 = e10.p("Header");
            if (p11 != null) {
                this.f22966u = (HeaderObj) GsonManager.getGson().h(p11, HeaderObj.class);
            }
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
    }
}
