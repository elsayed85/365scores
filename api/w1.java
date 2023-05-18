package com.scores365.api;

import java.util.Map;
import x1.o;
/* compiled from: PostRequest.java */
/* loaded from: classes2.dex */
public class w1 extends y1.n {

    /* renamed from: s  reason: collision with root package name */
    private Map<String, String> f23244s;

    /* renamed from: t  reason: collision with root package name */
    private String f23245t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f23246u;

    public w1(int i10, String str, o.b<String> bVar, o.a aVar) {
        super(i10, str, bVar, aVar);
        this.f23245t = null;
    }

    public void V(String str) {
        this.f23245t = str;
    }

    public void W(Map<String, String> map) {
        this.f23244s = map;
    }

    public void X(boolean z10) {
        this.f23246u = z10;
    }

    @Override // x1.m
    public byte[] n() {
        String str = this.f23245t;
        return str == null ? super.n() : str.getBytes();
    }

    @Override // x1.m
    public String o() {
        return this.f23246u ? "application/json; charset=utf-8" : super.o();
    }

    @Override // x1.m
    public Map<String, String> r() {
        return li.x0.B();
    }

    @Override // x1.m
    protected Map<String, String> t() {
        return this.f23244s;
    }
}
