package com.scores365.api;

import com.scores365.App;
import com.scores365.entitys.GsonManager;
/* compiled from: ApiQuizInit.java */
/* loaded from: classes2.dex */
public class i1 extends d {

    /* renamed from: a  reason: collision with root package name */
    public wd.a f23061a;

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder("quiz/init/?lang=");
        sb2.append(sf.a.i0(App.m()).k0());
        String J1 = sf.b.X1().J1();
        if (!J1.equals("prod")) {
            sb2.append("&env=");
            sb2.append(J1);
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.api.d
    public String getURL() {
        return "https://quizapi.365scores.com/";
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23061a = (wd.a) GsonManager.getGson().l(str, wd.a.class);
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
