package com.scores365.api;

import android.content.Context;
import com.scores365.bets.model.GameBetsObj;
import com.scores365.entitys.GsonManager;
/* compiled from: APIOdds.java */
/* loaded from: classes2.dex */
public class n extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f23143a;

    /* renamed from: b  reason: collision with root package name */
    private int f23144b;

    /* renamed from: c  reason: collision with root package name */
    private int f23145c;

    /* renamed from: d  reason: collision with root package name */
    private long f23146d = -1;

    /* renamed from: e  reason: collision with root package name */
    private GameBetsObj f23147e;

    public n(Context context, int i10, int i11) {
        this.f23145c = 1;
        this.f23143a = i10;
        this.f23144b = i11;
        this.f23145c = sf.a.i0(context).k0();
    }

    public GameBetsObj a() {
        return this.f23147e;
    }

    public void b(long j10) {
        this.f23146d = j10;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Data/Bets/Lines/?");
        sb2.append("gameid=");
        sb2.append(this.f23143a);
        if (this.f23146d > -1) {
            sb2.append("&uid=");
            sb2.append(this.f23146d);
        }
        sb2.append("&ShowNAOdds=true");
        if (this.f23144b != -1) {
            sb2.append("&TopBM=");
            sb2.append(this.f23144b);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23147e = (GameBetsObj) GsonManager.getGson().l(str, GameBetsObj.class);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
