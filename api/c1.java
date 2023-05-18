package com.scores365.api;

import android.content.Context;
import com.scores365.entitys.GsonManager;
import com.scores365.entitys.MessagesPBPObj;
/* compiled from: ApiPlayByPlay.java */
/* loaded from: classes2.dex */
public class c1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f22939a;

    /* renamed from: b  reason: collision with root package name */
    private MessagesPBPObj f22940b;

    public c1(Context context, String str) {
        this.containSlash = false;
        this.f22939a = str;
    }

    public MessagesPBPObj a() {
        return this.f22940b;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return this.f22939a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.api.d
    public String getURL() {
        return "";
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f22940b = (MessagesPBPObj) GsonManager.getGson().l(str, MessagesPBPObj.class);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
