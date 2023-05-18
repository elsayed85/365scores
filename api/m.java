package com.scores365.api;

import android.content.Context;
import com.scores365.entitys.GsonManager;
import com.scores365.entitys.SourceObj;
import java.lang.reflect.Type;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: APINewsSources.java */
/* loaded from: classes2.dex */
public class m extends d {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<SourceObj> f23126a;

    /* renamed from: b  reason: collision with root package name */
    private String f23127b;

    /* compiled from: APINewsSources.java */
    /* loaded from: classes2.dex */
    class a extends com.google.gson.reflect.a<ArrayList<SourceObj>> {
        a() {
        }
    }

    public m(Context context, String str) {
        this.f23127b = str;
    }

    public ArrayList<SourceObj> a() {
        return this.f23126a;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("Data/News/Sources/?lang=");
            sb2.append(this.f23127b);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        String jSONArray;
        try {
            Type type = new a().getType();
            try {
                jSONArray = new JSONObject(str).getJSONArray("NewsSources").toString();
            } catch (JSONException e10) {
                li.x0.N1(e10);
            }
            this.f23126a = (ArrayList) GsonManager.getGson().m(jSONArray, type);
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
