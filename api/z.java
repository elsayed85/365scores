package com.scores365.api;

import com.scores365.entitys.DailyTipObj;
import com.scores365.entitys.GsonManager;
/* compiled from: ApiAgentHistory.java */
/* loaded from: classes2.dex */
public class z extends d {

    /* renamed from: a  reason: collision with root package name */
    public DailyTipObj f23267a;

    /* renamed from: b  reason: collision with root package name */
    private int f23268b;

    public z(int i10) {
        this.f23268b = i10;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "data/bets/insights/agent/history/?agentID=" + this.f23268b;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23267a = (DailyTipObj) GsonManager.getGson().l(str, DailyTipObj.class);
    }
}
