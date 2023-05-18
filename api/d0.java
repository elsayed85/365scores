package com.scores365.api;

import com.scores365.entitys.GsonManager;
import com.scores365.entitys.TrophyStats;
/* compiled from: ApiAthleteTrophies.java */
/* loaded from: classes2.dex */
public class d0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f22941a;

    /* renamed from: b  reason: collision with root package name */
    private int f22942b;

    /* renamed from: c  reason: collision with root package name */
    public TrophyStats f22943c;

    public d0(int i10, int i11) {
        this.f22941a = i10;
        this.f22942b = i11;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "Data/Entities/Athletes/Trophies/Stats/?AthleteID=" + this.f22941a + "&competitionID=" + this.f22942b;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f22943c = (TrophyStats) GsonManager.getGson().l(str, TrophyStats.class);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
