package com.scores365.api;

import android.content.Context;
import com.scores365.entitys.GsonManager;
/* compiled from: ApiPrediction.java */
/* loaded from: classes2.dex */
public class g1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f23004a;

    /* renamed from: b  reason: collision with root package name */
    private int f23005b;

    /* renamed from: c  reason: collision with root package name */
    private com.scores365.gameCenter.Predictions.b f23006c;

    public g1(Context context, int i10, int i11) {
        this.f23004a = i10;
        this.f23005b = i11;
    }

    public com.scores365.gameCenter.Predictions.b a() {
        return this.f23006c;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("Data/games/Predictions/");
            sb2.append("?GameID=");
            sb2.append(this.f23004a);
            sb2.append("&ShowNAOdds=true");
            if (this.f23005b != -1) {
                sb2.append("&TopBM=");
                sb2.append(this.f23005b);
            }
            sb2.append("&OddsFormat=");
            sb2.append(sf.b.X1().A2().getValue());
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23006c = (com.scores365.gameCenter.Predictions.b) GsonManager.getGson().l(str, com.scores365.gameCenter.Predictions.b.class);
    }
}
