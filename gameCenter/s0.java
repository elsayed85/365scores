package com.scores365.gameCenter;

import android.os.AsyncTask;
import com.scores365.api.e1;
import com.scores365.entitys.SetsObj;
import java.lang.ref.WeakReference;
/* compiled from: PointByPointMgr.java */
/* loaded from: classes2.dex */
public class s0 {

    /* renamed from: a  reason: collision with root package name */
    private SetsObj f24045a;

    /* renamed from: b  reason: collision with root package name */
    private int f24046b;

    /* compiled from: PointByPointMgr.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    /* compiled from: PointByPointMgr.java */
    /* loaded from: classes2.dex */
    private static class b extends AsyncTask<Void, Void, SetsObj> {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<a> f24047a;

        /* renamed from: b  reason: collision with root package name */
        int f24048b;

        public b(a aVar, int i10) {
            this.f24047a = new WeakReference<>(aVar);
            this.f24048b = i10;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public SetsObj doInBackground(Void... voidArr) {
            try {
                return c(this.f24048b);
            } catch (Exception e10) {
                li.x0.N1(e10);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(SetsObj setsObj) {
            super.onPostExecute(setsObj);
            try {
                WeakReference<a> weakReference = this.f24047a;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                this.f24047a.get().a();
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }

        public SetsObj c(int i10) {
            try {
                e1 e1Var = new e1(i10);
                e1Var.call();
                return e1Var.a();
            } catch (Exception e10) {
                li.x0.N1(e10);
                return null;
            }
        }
    }

    public SetsObj a(int i10) {
        SetsObj setsObj = null;
        try {
            setsObj = new b(null, i10).c(i10);
            d(setsObj, i10);
            return setsObj;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return setsObj;
        }
    }

    public SetsObj b() {
        return this.f24045a;
    }

    public boolean c(int i10) {
        SetsObj setsObj = this.f24045a;
        return setsObj != null && i10 >= 0 && setsObj.getSets().size() > i10;
    }

    public void d(SetsObj setsObj, int i10) {
        this.f24045a = setsObj;
        this.f24046b = i10;
    }
}
