package com.scores365.api;

import android.content.Context;
import android.text.TextUtils;
import com.scores365.entitys.InitObj;
import java.util.concurrent.TimeUnit;
/* compiled from: APIInit.java */
/* loaded from: classes2.dex */
public class j extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f23062a;

    /* renamed from: b  reason: collision with root package name */
    private String f23063b = "MOBILE_APP";

    /* renamed from: c  reason: collision with root package name */
    private InitObj f23064c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f23065d = null;

    public j(Context context, int i10) {
        this.f23062a = 1;
        if (i10 != -1) {
            this.f23062a = i10;
        }
    }

    public InitObj a() {
        return this.f23064c;
    }

    public String b() {
        return this.f23065d;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Data/Init/?");
        sb2.append("category=");
        sb2.append(this.f23063b);
        sb2.append("&SupportWebp=true");
        int e10 = li.j.e("INIT_VERSION");
        if (e10 > 0) {
            sb2.append("&version=");
            sb2.append(e10);
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.api.d
    public long getTimeoutConnection() {
        return Math.max(w.b(), TimeUnit.SECONDS.toMillis(60L));
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str != null) {
                this.f23064c = w.i(str);
                this.f23065d = str;
                return;
            }
            return;
        }
        ng.a.f35508a.c("APIClient", "got empty init data=" + str, new IllegalArgumentException("init data can't be empty, data=" + str));
    }
}
