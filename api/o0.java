package com.scores365.api;

import com.scores365.entitys.DailyTipObj;
import com.scores365.entitys.GsonManager;
/* compiled from: ApiFullDailyTip.java */
/* loaded from: classes2.dex */
public class o0 extends d {

    /* renamed from: a  reason: collision with root package name */
    public DailyTipObj f23168a;

    /* renamed from: b  reason: collision with root package name */
    private int f23169b;

    /* renamed from: c  reason: collision with root package name */
    private String f23170c;

    public o0(int i10, String str) {
        this.f23169b = i10;
        this.f23170c = str;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder("data/bets/insights/insight/");
        sb2.append("?insightID=");
        sb2.append(this.f23169b);
        sb2.append("&DeviceID=");
        sb2.append(sf.b.X1().F2());
        String str = this.f23170c;
        if (str != null && !str.isEmpty()) {
            sb2.append("&notification=");
            sb2.append(this.f23170c);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23168a = (DailyTipObj) GsonManager.getGson().l(str, DailyTipObj.class);
    }
}
