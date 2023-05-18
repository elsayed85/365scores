package com.scores365.gameCenter.Predictions;

import com.scores365.bets.model.BookMakerObj;
import java.io.Serializable;
import java.util.LinkedHashMap;
import p9.c;
/* compiled from: PredictionsObj.java */
/* loaded from: classes2.dex */
public class b implements Serializable {
    @c("Predictions")

    /* renamed from: a  reason: collision with root package name */
    LinkedHashMap<Integer, a> f23701a;
    @c("Bookmakers")

    /* renamed from: b  reason: collision with root package name */
    LinkedHashMap<Integer, BookMakerObj> f23702b;

    public LinkedHashMap<Integer, BookMakerObj> a() {
        return this.f23702b;
    }

    public LinkedHashMap<Integer, a> b() {
        return this.f23701a;
    }
}
