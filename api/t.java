package com.scores365.api;

import android.content.Context;
import com.scores365.entitys.CategorizedObj;
import com.scores365.entitys.GsonManager;
/* compiled from: APITennisTournamentCategorized.java */
/* loaded from: classes2.dex */
public class t extends c {

    /* renamed from: f  reason: collision with root package name */
    String f23212f;

    public t(Context context, String str) {
        super(context, -1, -1, -1);
        this.f23212f = str;
    }

    @Override // com.scores365.api.c, com.scores365.api.d
    protected String getParams() {
        return this.f23212f;
    }

    @Override // com.scores365.api.c, com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f22934e = (CategorizedObj) GsonManager.getGson().l(str, CategorizedObj.class);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        this.f22933d = str;
    }
}
