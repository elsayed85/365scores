package com.scores365.api;

import com.scores365.entitys.GameTeaserObj;
import com.scores365.entitys.GsonManager;
/* compiled from: ApiGameTeaser.java */
/* loaded from: classes2.dex */
public class p0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f23179a;

    /* renamed from: b  reason: collision with root package name */
    private int f23180b;

    /* renamed from: c  reason: collision with root package name */
    public GameTeaserObj f23181c;

    public p0(int i10, int i11) {
        this.f23179a = i10;
        this.f23180b = i11;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/Data/Bets/Teaser/?GameId=");
        sb2.append(this.f23179a);
        sb2.append("&ShowNAOdds=true");
        if (this.f23180b != -1) {
            sb2.append("&TopBM=");
            sb2.append(this.f23180b);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23181c = (GameTeaserObj) GsonManager.getGson().l(str, GameTeaserObj.class);
    }
}
