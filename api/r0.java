package com.scores365.api;

import com.scores365.entitys.GamesObj;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: ApiGamesValidations.java */
/* loaded from: classes2.dex */
public class r0 extends d {

    /* renamed from: a  reason: collision with root package name */
    public GamesObj f23201a;

    /* renamed from: b  reason: collision with root package name */
    private HashSet<Integer> f23202b;

    public r0(HashSet<Integer> hashSet) {
        this.f23202b = hashSet;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("Data/Games/Dashboard/?games=");
            Iterator<Integer> it = this.f23202b.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Integer next = it.next();
                if (z10) {
                    sb2.append(",");
                }
                sb2.append(next);
                z10 = true;
            }
            sb2.append("&competitions=100000");
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23201a = w.h(str);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
