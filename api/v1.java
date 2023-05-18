package com.scores365.api;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import x1.o;
/* compiled from: PostJsonRequest.java */
/* loaded from: classes2.dex */
public class v1 extends y1.i {
    public v1(int i10, String str, JSONObject jSONObject, o.b<JSONObject> bVar, o.a aVar) {
        super(i10, str, jSONObject, bVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // x1.m
    public x1.o<JSONObject> J(x1.k kVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", new String(kVar.f41796b));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return x1.o.c(jSONObject, y1.e.e(kVar));
    }

    @Override // x1.m
    public Map<String, String> r() {
        return li.x0.B();
    }
}
