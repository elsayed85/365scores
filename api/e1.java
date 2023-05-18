package com.scores365.api;

import com.scores365.entitys.GsonManager;
import com.scores365.entitys.SetsObj;
/* compiled from: ApiPointByPoint.java */
/* loaded from: classes2.dex */
public class e1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private SetsObj f22971a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f22972b = null;

    /* renamed from: c  reason: collision with root package name */
    private int f22973c;

    public e1(int i10) {
        this.f22973c = i10;
    }

    public SetsObj a() {
        return this.f22971a;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "Data/Games/GameCenter/PointByPoint?Gameid=" + this.f22973c;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f22971a = (SetsObj) GsonManager.getGson().l(str, SetsObj.class);
            this.f22972b = str;
        } catch (com.google.gson.s e10) {
            li.x0.N1(e10);
        }
    }
}
