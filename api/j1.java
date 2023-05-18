package com.scores365.api;

import com.scores365.App;
import com.scores365.entitys.GsonManager;
/* compiled from: ApiQuizQuestions.java */
/* loaded from: classes2.dex */
public class j1 extends d {

    /* renamed from: a  reason: collision with root package name */
    public wd.j f23070a;

    /* renamed from: b  reason: collision with root package name */
    private int f23071b;

    /* renamed from: c  reason: collision with root package name */
    private int f23072c;

    public j1(int i10, int i11) {
        this.f23071b = i10;
        this.f23072c = i11;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder("quiz/questions/?lang=");
        sb2.append(sf.a.i0(App.m()).k0());
        sb2.append("&mode_id=");
        sb2.append(this.f23071b);
        sb2.append("&stage_id=");
        sb2.append(this.f23072c);
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
        this.f23070a = (wd.j) GsonManager.getGson().l(str, wd.j.class);
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
