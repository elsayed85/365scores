package com.scores365.api;

import android.content.Context;
import com.scores365.App;
import com.scores365.entitys.GsonManager;
import com.scores365.insight.InsightsObj;
/* compiled from: APIInsights.java */
/* loaded from: classes2.dex */
public class k extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f23073a;

    /* renamed from: b  reason: collision with root package name */
    private int f23074b;

    /* renamed from: c  reason: collision with root package name */
    private InsightsObj f23075c;

    public k(Context context, int i10, int i11) {
        this.f23073a = i10;
        this.f23074b = i11;
    }

    public InsightsObj a() {
        return this.f23075c;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("Data/Bets/Insights/");
            sb2.append("?GameID=");
            sb2.append(String.valueOf(this.f23073a));
            sb2.append("&ShowNAOdds=true");
            sb2.append(li.p0.a(App.m()));
            if (this.f23074b != -1) {
                sb2.append("&TopBM=");
                sb2.append(this.f23074b);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23075c = (InsightsObj) GsonManager.getGson().l(str, InsightsObj.class);
    }
}
