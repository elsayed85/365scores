package com.scores365.api;

import com.scores365.entitys.InitObj;
import java.util.Locale;
import java.util.TimeZone;
/* compiled from: ApiLocalData.java */
/* loaded from: classes2.dex */
public class u0 extends d {

    /* renamed from: a  reason: collision with root package name */
    public InitObj f23225a;

    /* renamed from: b  reason: collision with root package name */
    public String f23226b;

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder("Data/Init/LocalData/?locale=");
        try {
            sb2.append(li.x0.x(Locale.getDefault().toString()));
            sb2.append("&TimeZone=");
            sb2.append(li.x0.x(TimeZone.getDefault().getID()));
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.api.d
    public String getURL() {
        return "http://api.localdetector.com/";
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23226b = str;
        sf.b.X1().x7(str);
        this.f23225a = w.i(str);
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
