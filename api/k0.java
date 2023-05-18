package com.scores365.api;

import com.scores365.entitys.DailyTipObj;
import com.scores365.entitys.GsonManager;
/* compiled from: ApiDailyTip.java */
/* loaded from: classes2.dex */
public class k0 extends d {

    /* renamed from: a  reason: collision with root package name */
    public DailyTipObj f23076a;

    /* renamed from: b  reason: collision with root package name */
    private String f23077b;

    public k0(String str) {
        this.f23077b = str;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder("data/bets/insights/premium/dailytip/?");
        try {
            String str = this.f23077b;
            if (str != null && !str.isEmpty()) {
                sb2.append("notification=");
                sb2.append(this.f23077b);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23076a = (DailyTipObj) GsonManager.getGson().l(str, DailyTipObj.class);
    }
}
