package com.scores365.PlayerCard;

import java.io.Serializable;
/* compiled from: PlayerStatCareerSeasonObject.java */
/* loaded from: classes2.dex */
public class b implements Serializable {
    @p9.c("Name")

    /* renamed from: b  reason: collision with root package name */
    String f21375b;
    @p9.c("Key")

    /* renamed from: a  reason: collision with root package name */
    String f21374a = "-1";
    @p9.c("SName")

    /* renamed from: c  reason: collision with root package name */
    String f21376c = "";
    @p9.c("Stats")

    /* renamed from: d  reason: collision with root package name */
    e f21377d = null;
    @p9.c("ShowLogo")

    /* renamed from: e  reason: collision with root package name */
    boolean f21378e = false;
    @p9.c("LogoEntityType")

    /* renamed from: f  reason: collision with root package name */
    String f21379f = "";
    @p9.c("LogoEntityID")

    /* renamed from: g  reason: collision with root package name */
    int f21380g = -1;

    public String a() {
        return this.f21374a;
    }

    public int b() {
        return this.f21380g;
    }

    public String c() {
        return this.f21375b;
    }

    public e d() {
        return this.f21377d;
    }

    public String e() {
        return this.f21376c;
    }

    public void f(e eVar) {
        this.f21377d = eVar;
    }
}
