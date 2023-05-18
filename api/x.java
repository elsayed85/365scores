package com.scores365.api;

import android.content.Context;
import com.scores365.entitys.BetObj;
import java.util.LinkedList;
/* compiled from: APIWinnerBets.java */
/* loaded from: classes2.dex */
public class x extends d {

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<BetObj> f23247a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f23248b;

    /* renamed from: c  reason: collision with root package name */
    private int f23249c;

    public x(Context context, int i10) {
        this.f23249c = 1;
        this.f23248b = i10;
        this.f23249c = sf.a.i0(context).k0();
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "Data/Bets/?GameID=" + this.f23248b + "&ShowNAOdds=true";
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23247a = w.a(str);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
