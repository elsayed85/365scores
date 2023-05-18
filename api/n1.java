package com.scores365.api;

import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.JSONObject;
/* compiled from: ApiServerTime.java */
/* loaded from: classes2.dex */
public class n1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private long f23160a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f23161b = "";

    public long a() {
        return this.f23160a;
    }

    public void b(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
            this.f23160a = simpleDateFormat.parse(str).getTime();
        } catch (ParseException e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("Data/Time/Current/");
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            String string = new JSONObject(str).getString("CurrTimeString");
            this.f23161b = string;
            b(string);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
