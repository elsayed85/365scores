package com.scores365.api;

import com.scores365.App;
import com.scores365.entitys.InitObj;
/* compiled from: ApiLightInitData.java */
/* loaded from: classes2.dex */
public class t0 extends d {

    /* renamed from: a  reason: collision with root package name */
    public InitObj f23213a;

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder("Data/Init/Light/?category=MOBILE_APP_META_DATA");
        try {
            sb2.append("&lang=");
            sb2.append(sf.a.i0(App.m()).k0());
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23213a = w.i(str);
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
