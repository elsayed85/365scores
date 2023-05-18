package com.scores365.api;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ApiIP.java */
/* loaded from: classes2.dex */
public class s0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f23208a;

    public String a() {
        return this.f23208a;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.api.d
    public String getURL() {
        return li.p0.l0("PUBLIC_IP_API");
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23208a = new JSONObject(str).getString("ip");
        } catch (JSONException e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
