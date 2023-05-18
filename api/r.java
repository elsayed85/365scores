package com.scores365.api;

import com.scores365.App;
import com.scores365.entitys.GsonManager;
import com.scores365.entitys.TableObj;
/* compiled from: APITables.java */
/* loaded from: classes2.dex */
public class r extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f23192a;

    /* renamed from: b  reason: collision with root package name */
    private int f23193b;

    /* renamed from: c  reason: collision with root package name */
    private int f23194c;

    /* renamed from: d  reason: collision with root package name */
    private int f23195d;

    /* renamed from: e  reason: collision with root package name */
    private int f23196e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f23197f;

    /* renamed from: g  reason: collision with root package name */
    private String f23198g;

    /* renamed from: h  reason: collision with root package name */
    public TableObj f23199h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f23200i;

    public r(int i10, int i11, int i12, int i13, int i14, boolean z10) {
        this.f23200i = false;
        this.f23192a = i10;
        this.f23193b = i11;
        this.f23194c = i12;
        this.f23195d = i13;
        this.f23196e = i14;
        this.f23197f = z10;
    }

    public r(int i10, int i11, int i12, int i13, boolean z10) {
        this(i10, i11, i12, i13, -1, z10);
    }

    public void a() {
        this.f23200i = true;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Data/Statistics/Tables/?Competition=");
        sb2.append(this.f23192a);
        if (this.f23193b > -1) {
            sb2.append("&season=");
            sb2.append(this.f23193b);
        }
        if (this.f23194c > -1) {
            sb2.append("&stage=");
            sb2.append(this.f23194c);
        }
        if (this.f23195d > -1) {
            sb2.append("&group=");
            sb2.append(this.f23195d);
        }
        if (this.f23196e > -1) {
            if (this.f23197f) {
                sb2.append("&groupcategory=");
                sb2.append(this.f23196e);
            } else {
                sb2.append("&type=");
                sb2.append(this.f23196e);
            }
        }
        sb2.append("&withExpanded=true");
        sb2.append("&IsTablet=");
        sb2.append(App.f20803w);
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            if (this.f23200i) {
                this.f23199h = (TableObj) GsonManager.getGson().l(str, TableObj.class);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        this.f23198g = str;
    }
}
