package com.scores365.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.scores365.App;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
/* compiled from: ApiMonetizationV2.java */
/* loaded from: classes2.dex */
public class y0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private fc.a f23255a;

    /* renamed from: b  reason: collision with root package name */
    public String f23256b = "";

    /* renamed from: c  reason: collision with root package name */
    private final int f23257c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final ge.a f23258d;

    /* renamed from: e  reason: collision with root package name */
    private Exception f23259e;

    public y0(int i10, @NonNull ge.a aVar) {
        this.f23258d = aVar;
        this.containSlash = false;
        this.f23257c = i10;
    }

    public Exception a() {
        return this.f23259e;
    }

    public fc.a b() {
        return this.f23255a;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("?countryId=");
            sf.a i02 = sf.a.i0(App.m());
            sb2.append(i02.j0());
            sb2.append("&lang=");
            sb2.append(i02.k0());
            sb2.append("&platform=2");
            if (this.f23257c > 0) {
                sb2.append("&version=");
                sb2.append(this.f23257c);
            }
            sb2.append("&AppVersion=");
            sb2.append(li.p0.a(App.m()));
            String b10 = this.f23258d.b();
            if (!TextUtils.isEmpty(b10)) {
                sb2.append("&AttCmp=");
                sb2.append(URLEncoder.encode(b10, StandardCharsets.UTF_8.toString()));
            }
            String d10 = this.f23258d.d();
            if (!TextUtils.isEmpty(d10)) {
                sb2.append("&AttNw=");
                sb2.append(URLEncoder.encode(d10, StandardCharsets.UTF_8.toString()));
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    public String getURL() {
        String r12 = sf.b.X1().r1();
        return r12 == null ? "http://adrsettings.365scores.com/api/AdsSettings/GetAdsSettings/" : r12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.api.d
    public void onRequestError(Exception exc) {
        super.onRequestError(exc);
        this.f23259e = exc;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23256b = str;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f23255a = fc.a.a(str);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
