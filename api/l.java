package com.scores365.api;

import android.content.Context;
import com.scores365.entitys.NewsObj;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* compiled from: APINews.java */
/* loaded from: classes2.dex */
public class l extends d {

    /* renamed from: a  reason: collision with root package name */
    private boolean f23084a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23085b;

    /* renamed from: c  reason: collision with root package name */
    private int f23086c;

    /* renamed from: d  reason: collision with root package name */
    private String f23087d;

    /* renamed from: e  reason: collision with root package name */
    private String f23088e;

    /* renamed from: f  reason: collision with root package name */
    private String f23089f;

    /* renamed from: g  reason: collision with root package name */
    private int f23090g;

    /* renamed from: h  reason: collision with root package name */
    private String f23091h;

    /* renamed from: i  reason: collision with root package name */
    private String f23092i;

    /* renamed from: j  reason: collision with root package name */
    private String f23093j;

    /* renamed from: k  reason: collision with root package name */
    private String f23094k;

    /* renamed from: l  reason: collision with root package name */
    private String f23095l;

    /* renamed from: m  reason: collision with root package name */
    private String f23096m;

    /* renamed from: n  reason: collision with root package name */
    private String f23097n;

    /* renamed from: o  reason: collision with root package name */
    private String f23098o;

    /* renamed from: p  reason: collision with root package name */
    private String f23099p;

    /* renamed from: q  reason: collision with root package name */
    public int f23100q;

    /* renamed from: r  reason: collision with root package name */
    public int f23101r;

    /* renamed from: s  reason: collision with root package name */
    private NewsObj f23102s;

    /* renamed from: t  reason: collision with root package name */
    private String f23103t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f23104u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f23105v;

    /* renamed from: w  reason: collision with root package name */
    private int f23106w;

    /* renamed from: x  reason: collision with root package name */
    private String f23107x;

    /* renamed from: y  reason: collision with root package name */
    private int f23108y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f23109z;

    public l(Context context) {
        this.f23084a = false;
        this.f23085b = false;
        this.f23086c = -1;
        this.f23087d = "";
        this.f23100q = -1;
        this.f23101r = -1;
        this.f23102s = null;
        this.f23103t = null;
        this.f23104u = true;
        this.f23105v = false;
        this.f23106w = -1;
        this.f23108y = -1;
        this.f23109z = false;
    }

    public l(Context context, int i10, String str, int i11) {
        this.f23085b = false;
        this.f23087d = "";
        this.f23100q = -1;
        this.f23101r = -1;
        this.f23102s = null;
        this.f23103t = null;
        this.f23104u = true;
        this.f23105v = false;
        this.f23106w = -1;
        this.f23108y = -1;
        this.f23109z = false;
        this.f23084a = true;
        this.f23086c = i10;
        this.f23089f = str;
        this.f23090g = i11;
    }

    public l(Context context, String str, String str2, int i10, String str3, String str4, String str5, String str6, String str7, Date date, Date date2, String str8, String str9) {
        this.f23084a = false;
        this.f23085b = false;
        this.f23086c = -1;
        this.f23087d = "";
        this.f23100q = -1;
        this.f23101r = -1;
        this.f23102s = null;
        this.f23103t = null;
        this.f23104u = true;
        this.f23105v = false;
        this.f23106w = -1;
        this.f23108y = -1;
        this.f23109z = false;
        this.f23088e = str;
        this.f23089f = str2;
        this.f23090g = i10;
        this.f23091h = str3;
        this.f23092i = str4;
        this.f23093j = str5;
        this.f23094k = str6;
        this.f23095l = str7;
        this.f23096m = li.x0.U(date, "dd/MM/yyyy");
        this.f23097n = li.x0.U(date2, "dd/MM/yyyy");
        this.f23098o = str8;
        this.f23099p = str9;
    }

    public l(Context context, ArrayList<Integer> arrayList, String str, int i10) {
        this.f23086c = -1;
        this.f23087d = "";
        this.f23100q = -1;
        this.f23101r = -1;
        this.f23102s = null;
        this.f23103t = null;
        this.f23104u = true;
        this.f23105v = false;
        this.f23106w = -1;
        this.f23108y = -1;
        this.f23109z = false;
        this.f23084a = true;
        this.f23085b = true;
        this.f23089f = str;
        this.f23090g = i10;
        StringBuilder sb2 = new StringBuilder();
        if (arrayList != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (!sb2.toString().isEmpty()) {
                    sb2.append(",");
                }
                sb2.append(String.valueOf(next));
            }
        }
        this.f23087d = sb2.toString();
    }

    public NewsObj a() {
        return this.f23102s;
    }

    public void b(int i10) {
        this.f23105v = true;
        this.f23106w = i10;
    }

    public void c(String str) {
        this.f23105v = true;
        this.f23107x = str;
    }

    public void d() {
        this.f23104u = false;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("Data/News/?");
            if (!this.f23105v || (str = this.f23107x) == null || str.isEmpty()) {
                if (this.f23109z) {
                    sb2.append("&Filter=");
                    sb2.append(this.f23108y);
                } else if (!this.f23084a) {
                    sb2.append("&Competitions=");
                    sb2.append(this.f23092i);
                    sb2.append("&Competitors=");
                    sb2.append(this.f23093j);
                    sb2.append("&LimitNews=true&MaxNewsItems=");
                    sb2.append(this.f23098o);
                    sb2.append("&MinNewsItems=");
                    sb2.append(this.f23099p);
                    sb2.append("&Countries=");
                    sb2.append(this.f23091h);
                    sb2.append("&Games=");
                    sb2.append(this.f23094k);
                    sb2.append("&Athletes=");
                    sb2.append(this.f23095l);
                    sb2.append("&startdate=");
                    sb2.append(this.f23096m);
                    sb2.append("&enddate=");
                    sb2.append(this.f23097n);
                    sb2.append("&NewsType=");
                    sb2.append(this.f23088e);
                    sb2.append("&newsSources=");
                    sb2.append(sf.b.X1().t2());
                    sb2.append("&FilterSourcesOut=true");
                    if (!this.f23104u) {
                        sb2.append("&OnlyInLang=false");
                    }
                    if (this.f23100q != -1) {
                        sb2.append("&MinNewsItemsPerCategory=");
                        sb2.append(this.f23100q);
                    }
                    if (this.f23101r != -1) {
                        sb2.append("&MaxCategoriesToFill=");
                        sb2.append(this.f23101r);
                    }
                    if (this.f23105v) {
                        sb2.append("&AfterItem=");
                        sb2.append(this.f23106w);
                    }
                } else if (this.f23085b) {
                    sb2.append("&newsitems=");
                    sb2.append(this.f23087d);
                } else {
                    sb2.append("&newsitems=");
                    sb2.append(this.f23086c);
                }
                sb2.append("&NewsLang=");
                sb2.append(sf.b.X1().s2());
            } else {
                sb2.append("&");
                sb2.append(this.f23107x);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23102s = w.l(str);
        this.f23103t = str;
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        String str;
        return !this.f23105v || (str = this.f23107x) == null || str.isEmpty();
    }
}
