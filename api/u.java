package com.scores365.api;

import com.scores365.entitys.TransfersObj;
import jd.f;
import org.json.JSONObject;
/* compiled from: APITransfers.java */
/* loaded from: classes2.dex */
public class u extends d {

    /* renamed from: a  reason: collision with root package name */
    public String f23216a;

    /* renamed from: b  reason: collision with root package name */
    public String f23217b;

    /* renamed from: c  reason: collision with root package name */
    public String f23218c;

    /* renamed from: d  reason: collision with root package name */
    public TransfersObj f23219d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23220e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f23221f = "";

    /* renamed from: g  reason: collision with root package name */
    private boolean f23222g = false;

    /* renamed from: h  reason: collision with root package name */
    private int f23223h = -1;

    /* renamed from: i  reason: collision with root package name */
    private f.d f23224i = null;

    public u(String str, String str2, String str3) {
        this.f23216a = str;
        this.f23217b = str2;
        this.f23218c = str3;
    }

    public TransfersObj a() {
        return this.f23219d;
    }

    public void b(int i10) {
        try {
            this.f23220e = true;
            this.f23221f = "afterTransfer=" + i10;
        } catch (Exception unused) {
        }
    }

    public void c(f.d dVar) {
        this.f23224i = dVar;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Data/Transfers/?");
        if (this.f23222g) {
            sb2.append("Filter=");
            sb2.append(this.f23223h);
        } else {
            sb2.append("competitors=");
            sb2.append(this.f23217b);
            sb2.append("&competitions=");
            sb2.append(this.f23216a);
            sb2.append("&athletes=");
            sb2.append(this.f23218c);
        }
        if (this.f23224i != null) {
            sb2.append("&statuses=");
            sb2.append(this.f23224i.getValue());
        }
        if (this.f23220e) {
            sb2.append("&");
            sb2.append(this.f23221f);
            this.f23220e = false;
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23219d = TransfersObj.parseTransfersObj(new JSONObject(str));
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
