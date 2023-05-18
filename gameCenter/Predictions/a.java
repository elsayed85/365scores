package com.scores365.gameCenter.Predictions;

import com.scores365.App;
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BetLineType;
import com.scores365.entitys.BaseObj;
import com.scores365.insight.SingleInsightObj;
import java.util.ArrayList;
import li.x0;
import p9.c;
/* compiled from: PredictionObj.java */
/* loaded from: classes2.dex */
public class a extends BaseObj {
    @c("LineTypeID")

    /* renamed from: a  reason: collision with root package name */
    public int f23693a;
    @c("VotingKey")

    /* renamed from: b  reason: collision with root package name */
    String f23694b;
    @c("LineParam")

    /* renamed from: c  reason: collision with root package name */
    String f23695c;
    @c("Votes")

    /* renamed from: d  reason: collision with root package name */
    int[] f23696d;
    @c("ShowVotesCount")

    /* renamed from: e  reason: collision with root package name */
    boolean f23697e;
    @c("RelatedLine")

    /* renamed from: f  reason: collision with root package name */
    BetLine f23698f;
    @c("VotesPercentage")

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<String> f23699g = new ArrayList<>();
    @c("RelatedInsight")

    /* renamed from: h  reason: collision with root package name */
    SingleInsightObj f23700h;

    public BetLineType a() {
        try {
            return App.l().bets.getLineTypes().get(Integer.valueOf(this.f23693a));
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public SingleInsightObj c() {
        return this.f23700h;
    }

    public String d() {
        return this.f23695c;
    }

    public BetLine e() {
        return this.f23698f;
    }

    public int[] f() {
        return this.f23696d;
    }

    public String g() {
        ArrayList<String> arrayList = this.f23699g;
        return (arrayList == null || arrayList.isEmpty()) ? "" : this.f23699g.get(0);
    }

    public String h() {
        return this.f23694b;
    }

    public boolean i() {
        return this.f23697e;
    }
}
