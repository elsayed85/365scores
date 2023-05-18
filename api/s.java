package com.scores365.api;

import android.content.Context;
import com.scores365.entitys.GsonManager;
import com.scores365.entitys.TennisCategorizedObj;
/* compiled from: APITennisStandingsPage.java */
/* loaded from: classes2.dex */
public class s extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f23205a;

    /* renamed from: b  reason: collision with root package name */
    private String f23206b;

    /* renamed from: c  reason: collision with root package name */
    TennisCategorizedObj f23207c;

    public s(Context context, int i10) {
        this.f23205a = i10;
    }

    public TennisCategorizedObj a() {
        return this.f23207c;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "Data/Entities/Tennis/Dashboard/?";
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23207c = (TennisCategorizedObj) GsonManager.getGson().l(str, TennisCategorizedObj.class);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        this.f23206b = str;
    }
}
