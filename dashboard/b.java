package com.scores365.dashboard;

import android.os.Handler;
import android.os.Looper;
import com.scores365.dashboard.a;
import java.lang.ref.WeakReference;
import li.x0;
/* compiled from: GetPageDataTask.java */
/* loaded from: classes2.dex */
public class b implements Runnable, a.b {

    /* renamed from: a  reason: collision with root package name */
    private String f23340a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<a.c> f23341b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<com.scores365.dashboard.a> f23342c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<a.d> f23343d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f23344e = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    long f23345f;

    /* compiled from: GetPageDataTask.java */
    /* loaded from: classes2.dex */
    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Object f23346a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<a.c> f23347b;

        public a(Object obj, WeakReference<a.c> weakReference) {
            this.f23346a = obj;
            this.f23347b = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.c cVar = this.f23347b.get();
                if (cVar != null) {
                    cVar.onPageDataLoaded(this.f23346a);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public b(String str, com.scores365.dashboard.a aVar, a.c cVar, a.d dVar) {
        this.f23340a = str;
        this.f23342c = new WeakReference<>(aVar);
        this.f23341b = new WeakReference<>(cVar);
        this.f23343d = new WeakReference<>(dVar);
    }

    @Override // com.scores365.dashboard.a.b
    public void a(Object obj) {
        try {
            this.f23344e.post(new a(obj, this.f23341b));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f23345f = System.currentTimeMillis();
            com.scores365.dashboard.a aVar = this.f23342c.get();
            if (aVar != null) {
                aVar.y(this.f23340a, this.f23343d.get(), this);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
