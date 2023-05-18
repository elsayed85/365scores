package com.scores365.api;

import com.scores365.App;
/* compiled from: VolleyRequestQueue.java */
/* loaded from: classes2.dex */
public class x1 {

    /* renamed from: a  reason: collision with root package name */
    private static x1.n f23252a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f23253b = new Object();

    public static x1.n a() {
        x1.n nVar = f23252a;
        if (nVar != null) {
            return nVar;
        }
        synchronized (f23253b) {
            if (f23252a == null) {
                x1.n a10 = y1.o.a(App.m());
                f23252a = a10;
                a10.g();
            }
        }
        return f23252a;
    }
}
