package com.scores365.api;

import com.scores365.entitys.ChartDashboardData;
import org.json.JSONObject;
/* compiled from: ApiPlayerStates.java */
/* loaded from: classes2.dex */
public class d1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private ChartDashboardData f22944a;

    /* renamed from: b  reason: collision with root package name */
    private String f22945b;

    public d1(String str) {
        this.f22945b = str;
    }

    public ChartDashboardData a() {
        return this.f22944a;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return this.f22945b;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f22944a = ChartDashboardData.parse(new JSONObject(str));
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
