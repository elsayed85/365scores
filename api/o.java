package com.scores365.api;

import com.scores365.App;
import com.scores365.entitys.GsonManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: APIPromotion.java */
/* loaded from: classes2.dex */
public class o extends d {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<nd.c> f23162a;

    /* renamed from: b  reason: collision with root package name */
    private String f23163b;

    /* renamed from: c  reason: collision with root package name */
    private String f23164c;

    /* renamed from: d  reason: collision with root package name */
    private int f23165d;

    /* renamed from: e  reason: collision with root package name */
    private int f23166e;

    /* renamed from: f  reason: collision with root package name */
    private int f23167f;

    public o(String str, int i10) {
        this.f23164c = str;
        this.f23167f = i10;
    }

    public String a() {
        return this.f23163b;
    }

    public int b() {
        return this.f23166e;
    }

    public ArrayList<nd.c> c() {
        return this.f23162a;
    }

    public int d() {
        return this.f23165d;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("Data/Promotions/?");
            sb2.append("Competitors=");
            sb2.append(this.f23164c);
            sb2.append("&CountryID=");
            sb2.append(sf.a.i0(App.m()).j0());
            if (this.f23167f > 0) {
                sb2.append("&version=");
                sb2.append(this.f23167f);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23163b = str;
            JSONObject jSONObject = new JSONObject(str);
            this.f23165d = jSONObject.getInt("Version");
            this.f23166e = jSONObject.getInt("MinWaitTime");
            JSONArray jSONArray = jSONObject.getJSONArray("Promotions");
            this.f23162a = new ArrayList<>();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                this.f23162a.add((nd.c) GsonManager.getGson().l(jSONArray.get(i10).toString(), nd.c.class));
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
