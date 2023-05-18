package com.scores365.Pages.stats;

import android.os.AsyncTask;
import com.scores365.api.d1;
import com.scores365.entitys.ChartDashboardData;
import java.lang.ref.WeakReference;
import li.x0;
/* compiled from: PlayerStateActivityLoader.java */
/* loaded from: classes2.dex */
public class a extends AsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<InterfaceC0238a> f21311a;

    /* renamed from: b  reason: collision with root package name */
    private String f21312b;

    /* compiled from: PlayerStateActivityLoader.java */
    /* renamed from: com.scores365.Pages.stats.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0238a {
        void s(ChartDashboardData chartDashboardData);
    }

    public a(InterfaceC0238a interfaceC0238a, String str) {
        this.f21311a = new WeakReference<>(interfaceC0238a);
        this.f21312b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        InterfaceC0238a interfaceC0238a;
        try {
            d1 d1Var = new d1(this.f21312b);
            d1Var.call();
            ChartDashboardData a10 = d1Var.a();
            WeakReference<InterfaceC0238a> weakReference = this.f21311a;
            if (weakReference == null || (interfaceC0238a = weakReference.get()) == null) {
                return null;
            }
            interfaceC0238a.s(a10);
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }
}
