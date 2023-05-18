package com.scores365.api;

import com.scores365.entitys.BaseObj;
/* compiled from: WinProbabilityEntryObj.kt */
/* loaded from: classes2.dex */
public final class y1 extends BaseObj {
    @p9.c("Time")

    /* renamed from: d  reason: collision with root package name */
    private final String f23263d;
    @p9.c("Score")

    /* renamed from: g  reason: collision with root package name */
    private final int[] f23266g;
    @p9.c("Completion")

    /* renamed from: a  reason: collision with root package name */
    private final float f23260a = -1.0f;
    @p9.c("Status")

    /* renamed from: b  reason: collision with root package name */
    private final int f23261b = -1;
    @p9.c("StatusSequenceNumber")

    /* renamed from: c  reason: collision with root package name */
    private final int f23262c = -1;
    @p9.c("FavoriteCompetitor")

    /* renamed from: e  reason: collision with root package name */
    private final int f23264e = -1;
    @p9.c("Probability")

    /* renamed from: f  reason: collision with root package name */
    private final float f23265f = -1.0f;

    public final float a() {
        return this.f23260a;
    }

    public final int c() {
        return this.f23264e;
    }

    public final float d() {
        return this.f23264e == 1 ? this.f23265f : 1 - this.f23265f;
    }

    public final int[] e() {
        return this.f23266g;
    }

    public final int f() {
        return this.f23261b;
    }

    public final int g() {
        return this.f23262c;
    }

    public final String getTime() {
        return this.f23263d;
    }

    public final boolean h() {
        return this.f23264e == 1;
    }
}
