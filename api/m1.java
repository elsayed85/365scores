package com.scores365.api;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ApiSendTelegramData.java */
/* loaded from: classes2.dex */
public class m1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f23140a;

    /* renamed from: b  reason: collision with root package name */
    private String f23141b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23142c;

    public m1(String str, String str2) {
        this.usePostDataName = false;
        this.f23140a = str;
        this.f23141b = str2;
    }

    public boolean a() {
        return this.f23142c;
    }

    @Override // com.scores365.api.d
    public void call() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("DeviceId", sf.b.X1().F2());
            jSONObject.put("PhoneNumber", this.f23140a);
            jSONObject.put("Doal", v.f(this.f23141b));
            jSONObject.put("AppType", "2");
            setPostData(jSONObject.toString());
            y1.m d10 = y1.m.d();
            v1 v1Var = new v1(1, getURL(), new JSONObject(this.postData), d10, d10);
            x1.n a10 = x1.a();
            v1Var.O(new x1.e((int) w.c(), w.d(), 1.0f));
            a10.a(v1Var);
            System.currentTimeMillis();
            try {
                str = ((JSONObject) d10.get()).toString();
            } catch (Exception e10) {
                e10.printStackTrace();
                str = null;
            }
            parseJSON(str);
            System.currentTimeMillis();
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.api.d
    public String getURL() {
        return "http://interestedtip.365scores.com/api/users/AddUser/";
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23142c = false;
        if (str != null) {
            try {
                if (new JSONObject(str).getString("data").equalsIgnoreCase("ok")) {
                    this.f23142c = true;
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
