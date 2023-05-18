package com.scores365;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import androidx.annotation.NonNull;
import cc.r;
import com.google.firebase.perf.metrics.Trace;
import com.scores365.App;
import com.scores365.b;
import com.scores365.entitys.TermObj;
import com.scores365.ui.Splash;
import ee.k;
import gk.j;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicBoolean;
import li.g0;
import li.p0;
import li.x0;
import re.h;
/* compiled from: ApplicationLifecycleObserver.java */
/* loaded from: classes2.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: h  reason: collision with root package name */
    public static AtomicBoolean f22889h = new AtomicBoolean();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final sk.b f22890a = new sk.b();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final vc.b f22891b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final ki.b f22892c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22893d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f22894e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22895f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22896g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ApplicationLifecycleObserver.java */
    /* renamed from: com.scores365.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0240a extends j<String> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f22897e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Trace f22898f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ long f22899g;

        C0240a(String str, Trace trace, long j10) {
            this.f22897e = str;
            this.f22898f = trace;
            this.f22899g = j10;
        }

        @Override // gk.e
        /* renamed from: h */
        public void c(String str) {
            ng.a aVar = ng.a.f35508a;
            aVar.b("AppLifecycle", "warm loading step done, step=" + str + ", pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), null);
            try {
                if (str.equals("onPreUI")) {
                    aVar.b("AppLifecycle", "warm loading pre-ui completed, continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), null);
                    g0.f34558a.j();
                    a.this.f22896g = true;
                    Trace trace = this.f22898f;
                    if (trace != null) {
                        trace.putMetric("PreUiComplete", System.currentTimeMillis() - this.f22899g);
                        a.this.f22892c.s();
                    }
                    if (a.this.f22895f) {
                        a.this.u(this.f22897e);
                    }
                }
            } catch (Exception e10) {
                ng.a.f35508a.c("AppLifecycle", "warm loading subscriber error", e10);
            }
        }

        @Override // gk.e
        public void onCompleted() {
            a.this.f22890a.c(this);
            ng.a aVar = ng.a.f35508a;
            aVar.b("AppLifecycle", "warm loading completed- " + this.f22897e + ", pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), null);
        }

        @Override // gk.e
        public void onError(Throwable th2) {
            a.this.f22890a.c(this);
            ng.a aVar = ng.a.f35508a;
            aVar.c("AppLifecycle", "warm loading error- " + this.f22897e + ", pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ApplicationLifecycleObserver.java */
    /* loaded from: classes2.dex */
    public class b extends j<String> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f22901e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Trace f22902f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ long f22903g;

        b(String str, Trace trace, long j10) {
            this.f22901e = str;
            this.f22902f = trace;
            this.f22903g = j10;
        }

        @Override // gk.e
        /* renamed from: h */
        public void c(String str) {
            ng.a aVar = ng.a.f35508a;
            aVar.b("AppLifecycle", "sequence splash loading step done, step=" + str + ", pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), null);
            a.this.f22892c.s();
            Trace trace = this.f22902f;
            if (trace != null) {
                trace.incrementMetric("splashLoading", System.currentTimeMillis() - this.f22903g);
                a.this.f22892c.s();
            }
        }

        @Override // gk.e
        public void onCompleted() {
            a.this.f22890a.c(this);
            ng.a aVar = ng.a.f35508a;
            aVar.b("AppLifecycle", "sequence splash loading completed- " + this.f22901e + ", pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), null);
        }

        @Override // gk.e
        public void onError(Throwable th2) {
            a.this.f22890a.c(this);
            ng.a aVar = ng.a.f35508a;
            aVar.c("AppLifecycle", "sequence splash loading error- " + this.f22901e + ", pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ApplicationLifecycleObserver.java */
    /* loaded from: classes2.dex */
    public class c extends j<String> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f22905e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Trace f22906f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ long f22907g;

        c(String str, Trace trace, long j10) {
            this.f22905e = str;
            this.f22906f = trace;
            this.f22907g = j10;
        }

        @Override // gk.e
        /* renamed from: h */
        public void c(String str) {
            ng.a aVar = ng.a.f35508a;
            aVar.b("AppLifecycle", "postUI task step completed, step=" + str + ", pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), null);
            try {
                Trace trace = this.f22906f;
                if (trace != null) {
                    trace.putMetric("PostUiDuration", System.currentTimeMillis() - this.f22907g);
                    a.this.f22892c.s();
                }
            } catch (Exception e10) {
                ng.a aVar2 = ng.a.f35508a;
                aVar2.c("AppLifecycle", "application observer error on postUI = " + e10.getMessage() + ", pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), e10);
            }
        }

        @Override // gk.e
        public void onCompleted() {
            a.this.f22890a.c(this);
            ng.a aVar = ng.a.f35508a;
            aVar.b("AppLifecycle", "postUI task completed" + this.f22905e + ", pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), null);
        }

        @Override // gk.e
        public void onError(Throwable th2) {
            a.this.f22890a.c(this);
            ng.a aVar = ng.a.f35508a;
            aVar.c("AppLifecycle", "postUI task error" + this.f22905e + ", pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ApplicationLifecycleObserver.java */
    /* loaded from: classes2.dex */
    public class d extends j<String> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Trace f22909e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f22910f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ApplicationLifecycleObserver.java */
        /* renamed from: com.scores365.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0241a extends j<String> {
            C0241a() {
            }

            @Override // gk.e
            /* renamed from: h */
            public void c(String str) {
                ng.a aVar = ng.a.f35508a;
                aVar.b("AppLifecycle", "postUI step done, step=" + str + ", pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), null);
            }

            @Override // gk.e
            public void onCompleted() {
                a.this.f22890a.c(this);
                ng.a aVar = ng.a.f35508a;
                aVar.b("AppLifecycle", "postUI completed, pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), null);
            }

            @Override // gk.e
            public void onError(Throwable th2) {
                a.this.f22890a.c(this);
                ng.a aVar = ng.a.f35508a;
                aVar.c("AppLifecycle", "postUI error, pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), th2);
            }
        }

        d(Trace trace, long j10) {
            this.f22909e = trace;
            this.f22910f = j10;
        }

        @Override // gk.e
        /* renamed from: h */
        public void c(String str) {
            ng.a aVar = ng.a.f35508a;
            aVar.b("AppLifecycle", "splash loading step done, step=" + str + ", pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), null);
            Trace trace = this.f22909e;
            if (trace != null) {
                trace.putMetric("splashPreUiDuration", System.currentTimeMillis() - this.f22910f);
            }
            a.this.f22892c.s();
            if (str.equals("onPreUI")) {
                if (a.this.f22895f) {
                    a.this.f22890a.c(this);
                    h.j(this.f22909e).r(new C0241a());
                }
                g0.f34558a.j();
                a.this.f22896g = true;
                aVar.b("AppLifecycle", "pre-ui completed, step=" + str + ", pre-ui completed=true, continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), null);
            }
        }

        @Override // gk.e
        public void onCompleted() {
            a.this.f22890a.c(this);
            ng.a aVar = ng.a.f35508a;
            aVar.b("AppLifecycle", "splash loading completed, pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), null);
        }

        @Override // gk.e
        public void onError(Throwable th2) {
            a.this.f22890a.c(this);
            ng.a aVar = ng.a.f35508a;
            aVar.c("AppLifecycle", "splash loading error, pre-ui completed=" + a.this.f22896g + ", continueToPostUI=" + a.this.f22895f + ", inBackground=" + a.this.f22892c.l(), th2);
        }
    }

    public a(@NonNull vc.b bVar, @NonNull ki.b bVar2) {
        this.f22891b = bVar;
        this.f22892c = bVar2;
    }

    private void i() {
        new Handler().postDelayed(new Runnable() { // from class: nb.i
            @Override // java.lang.Runnable
            public final void run() {
                com.scores365.a.this.p();
            }
        }, 5000L);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cb, code lost:
        if (r3.equals("team") != false) goto L41;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Class<com.scores365.gameCenter.GameCenterBaseActivity>] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Class<com.scores365.dashboard.singleEntity.SingleEntityDashboardActivity>] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Class<com.scores365.ui.playerCard.SinglePlayerCardActivity>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Class j(android.content.Intent r10) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.a.j(android.content.Intent):java.lang.Class");
    }

    private void k(@NonNull Activity activity, @NonNull String str, boolean z10) {
        String valueOf = String.valueOf(sf.b.X1().b5());
        ng.a aVar = ng.a.f35508a;
        aVar.b("AppLifecycle", "handling loading sequence for activity=" + str + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + z10 + ", wizardFinished=" + valueOf, null);
        Trace h10 = this.f22892c.h();
        if (!z10) {
            if (str.equals("ui.Splash")) {
                aVar.b("AppLifecycle", "starting splash loading - " + str + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + z10, null);
                long currentTimeMillis = System.currentTimeMillis();
                h.f37484a = false;
                this.f22890a.a(h.v(activity.getApplicationContext(), h10, activity.getApplication(), activity.getIntent(), this.f22891b).r(new b(str, h10, currentTimeMillis)));
            }
        } else if (!str.equals("ui.Splash")) {
            if (App.f20797q == null) {
                App.f20797q = "notification";
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            aVar.b("AppLifecycle", "starting warm loading - " + str + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + z10, null);
            try {
                Thread thread = new Thread(new Runnable() { // from class: nb.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        App.b.t();
                    }
                });
                thread.start();
                thread.join();
            } catch (InterruptedException e10) {
                x0.N1(e10);
            }
            this.f22890a.a(h.z(this.f22891b, h10, activity.getApplication()).r(new C0240a(str, h10, currentTimeMillis2)));
        } else {
            if (o(activity.getIntent())) {
                App.f20797q = "deep_link";
            } else if ((activity instanceof Splash) && ((Splash) activity).isStartedFromNotification()) {
                App.f20797q = "notification";
            } else {
                App.f20797q = "app_open";
            }
            v(activity.getApplication(), activity.getIntent());
            try {
                k.p(App.m(), "page-view", "splash", null, false);
            } catch (Exception e11) {
                ng.a aVar2 = ng.a.f35508a;
                aVar2.c("AppLifecycle", "application observer error on handle loading sequence= " + e11.getMessage() + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + z10, e11);
            }
        }
    }

    public static boolean m() {
        return App.f20801u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        try {
            f22889h.set(false);
        } catch (Exception e10) {
            ng.a aVar = ng.a.f35508a;
            aVar.c("AppLifecycle", "application observer error delaying background= " + e10.getMessage() + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + this.f22892c.l(), e10);
        }
    }

    private void s(Activity activity) {
        if (x0.o1(activity)) {
            return;
        }
        String string = activity.getString(R.string.f22814c);
        Hashtable<String, TermObj> v10 = App.v();
        if (v10 != null && v10.containsKey("CONNECTION_ISSUE_TITLE")) {
            string = p0.l0("CONNECTION_ISSUE_TITLE");
        }
        final Toast makeText = Toast.makeText(activity, string, 0);
        Handler handler = new Handler();
        makeText.show();
        handler.postDelayed(new Runnable() { // from class: nb.k
            @Override // java.lang.Runnable
            public final void run() {
                makeText.cancel();
            }
        }, 1200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str) {
        boolean l10 = this.f22892c.l();
        if (!this.f22896g || this.f22895f) {
            ng.a aVar = ng.a.f35508a;
            aVar.b("AppLifecycle", "skipping postUI, " + str + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + l10, null);
            return;
        }
        this.f22895f = true;
        ng.a aVar2 = ng.a.f35508a;
        aVar2.b("AppLifecycle", "starting postUI task = " + str + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + l10, null);
        long currentTimeMillis = System.currentTimeMillis();
        Trace h10 = this.f22892c.h();
        h.j(h10).r(new c(str, h10, currentTimeMillis));
    }

    private void v(@NonNull final Application application, final Intent intent) {
        new Handler().postDelayed(new Runnable() { // from class: nb.l
            @Override // java.lang.Runnable
            public final void run() {
                com.scores365.a.this.q(application, intent);
            }
        }, 300L);
    }

    public boolean l() {
        return !this.f22892c.g();
    }

    public boolean n() {
        return this.f22892c.l();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
        r5.f22893d = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean o(android.content.Intent r6) {
        /*
            r5 = this;
            boolean r0 = r5.f22893d
            if (r0 != 0) goto L94
            android.net.Uri r1 = r6.getData()     // Catch: java.lang.Exception -> L77
            if (r1 == 0) goto L94
            android.net.Uri r6 = r6.getData()     // Catch: java.lang.Exception -> L77
            java.util.List r1 = r6.getPathSegments()     // Catch: java.lang.Exception -> L77
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L77
        L16:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Exception -> L77
            if (r2 == 0) goto L94
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> L77
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L77
            java.lang.String r3 = "gamecenter"
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Exception -> L77
            r4 = 1
            if (r3 != 0) goto L63
            java.lang.String r3 = "game"
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Exception -> L77
            if (r3 != 0) goto L63
            java.lang.String r3 = "singleentity"
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Exception -> L77
            if (r3 != 0) goto L63
            java.lang.String r3 = "league"
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Exception -> L77
            if (r3 != 0) goto L63
            java.lang.String r3 = "team"
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Exception -> L77
            if (r3 != 0) goto L63
            java.lang.String r3 = "athlete"
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Exception -> L77
            if (r3 != 0) goto L63
            java.lang.String r3 = "LeadForm"
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Exception -> L77
            if (r3 != 0) goto L63
            java.lang.String r3 = "removeAds"
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Exception -> L77
            if (r3 == 0) goto L64
        L63:
            r0 = 1
        L64:
            if (r0 == 0) goto L69
            r5.f22893d = r4     // Catch: java.lang.Exception -> L77
            goto L94
        L69:
            java.lang.String r3 = "devconfig"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L77
            if (r2 == 0) goto L16
            li.b r2 = li.b.f34480a     // Catch: java.lang.Exception -> L77
            r2.c(r6)     // Catch: java.lang.Exception -> L77
            goto L16
        L77:
            r6 = move-exception
            ng.a r1 = ng.a.f35508a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "application observer error checking if started from deep link = "
            r2.append(r3)
            java.lang.String r3 = r6.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "AppLifecycle"
            r1.c(r3, r2, r6)
        L94:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.a.o(android.content.Intent):boolean");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
        String localClassName = activity.getLocalClassName();
        boolean l10 = this.f22892c.l();
        boolean b52 = sf.b.X1().b5();
        ng.a aVar = ng.a.f35508a;
        aVar.b("AppLifecycle", "activity created = " + localClassName + ", wizardFinished=" + b52 + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + l10, null);
        try {
            if (this.f22892c.k()) {
                if (localClassName.equals("ui.Splash")) {
                    if (o(activity.getIntent())) {
                        App.f20797q = "deep_link";
                    } else if ((activity instanceof Splash) && ((Splash) activity).isStartedFromNotification()) {
                        App.f20797q = "notification";
                    } else {
                        App.f20797q = "app_open";
                    }
                }
                App.f20802v = System.currentTimeMillis();
            }
            if (activity instanceof Splash) {
                sf.b.X1().oa(activity);
                try {
                    activity.setRequestedOrientation(1);
                } catch (Exception e10) {
                    ng.a aVar2 = ng.a.f35508a;
                    aVar2.c("AppLifecycle", "application observer onActivityCreated error = " + e10.getMessage() + ", activity=" + activity.getLocalClassName() + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + l10, e10);
                }
                s(activity);
            }
        } catch (Exception e11) {
            ng.a aVar3 = ng.a.f35508a;
            aVar3.c("AppLifecycle", "application observer onActivityCreated error = " + e11.getMessage() + ", activity=" + activity.getLocalClassName() + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + l10, e11);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        String localClassName = activity.getLocalClassName();
        ng.a aVar = ng.a.f35508a;
        aVar.b("AppLifecycle", "activity resumed - " + localClassName + ", pre-ui completed=" + this.f22896g + ", continueToPostUIObservable=" + this.f22895f + ", inBackground=" + this.f22892c.l(), null);
        try {
            if (activity instanceof b.a) {
                NotificationBroadcastReceiver.g((b.a) activity);
            }
        } catch (Exception e10) {
            ng.a aVar2 = ng.a.f35508a;
            aVar2.c("AppLifecycle", "application observer error on activity resumed = " + e10.getMessage() + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + this.f22892c.l(), e10);
        }
        try {
            if (!App.f20796p) {
                if (this.f22894e) {
                    k.o(App.m(), "app", "background", "return", null, "screen", activity.getClass().getName());
                }
                this.f22894e = true;
                i();
                if (activity instanceof pd.b) {
                    r.H(activity);
                }
                try {
                    App.m().registerReceiver(hc.a.f27760a.a(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e11) {
                    ng.a aVar3 = ng.a.f35508a;
                    aVar3.c("AppLifecycle", "application observer error (activityResumed)= " + e11.getMessage() + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + this.f22892c.l(), e11);
                }
            }
            ((App) activity.getApplication()).F(activity);
        } catch (Exception e12) {
            ng.a aVar4 = ng.a.f35508a;
            aVar4.c("AppLifecycle", "app observer activityResumed error = " + e12.getMessage() + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + this.f22892c.l(), e12);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        String localClassName = activity.getLocalClassName();
        boolean l10 = this.f22892c.l();
        ng.a aVar = ng.a.f35508a;
        aVar.b("AppLifecycle", "activity started = " + localClassName + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + l10, null);
        try {
            this.f22892c.j(localClassName);
            this.f22892c.o(activity instanceof Splash);
            k(activity, localClassName, l10);
        } catch (Exception e10) {
            ng.a aVar2 = ng.a.f35508a;
            aVar2.c("AppLifecycle", "application observer error = " + e10.getMessage() + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + l10, e10);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        String localClassName = activity.getLocalClassName();
        ng.a aVar = ng.a.f35508a;
        aVar.b("AppLifecycle", "activity stopped - " + localClassName + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + this.f22892c.l(), null);
        try {
            App app = (App) activity.getApplication();
            this.f22892c.d(localClassName);
            if (this.f22892c.l()) {
                f22889h.set(true);
                ye.a.n(true);
                this.f22890a.b();
                this.f22895f = false;
                this.f22896g = false;
                k.j(app, "app", "background", "exit", null, App.g(null, false), false, "screen", activity.getClass().getName());
                app.G();
                g0.a aVar2 = g0.f34558a;
                if (aVar2.g()) {
                    aVar.c("AppLifecycle", "activity stopped - maintenance screen shown " + localClassName + ", pre-ui completed=" + this.f22896g + ", inBackground=" + this.f22892c.l(), new IllegalStateException("maintenance screen shown"));
                    activity.finishAffinity();
                    aVar2.k(false);
                    aVar2.l(false);
                }
            }
        } catch (Exception e10) {
            ng.a aVar3 = ng.a.f35508a;
            aVar3.c("AppLifecycle", "application observer error on activity stopped = " + e10.getMessage() + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + this.f22892c.l(), e10);
        }
    }

    public void r(@NonNull Activity activity) {
        String localClassName = activity.getLocalClassName();
        boolean l10 = this.f22892c.l();
        ng.a aVar = ng.a.f35508a;
        aVar.b("AppLifecycle", "activity rendered = " + localClassName + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + l10, null);
        u(localClassName);
    }

    /* renamed from: t */
    public void q(@NonNull Application application, Intent intent) {
        try {
            ng.a aVar = ng.a.f35508a;
            aVar.b("AppLifecycle", "starting activity in splash, pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + this.f22892c.l(), null);
            long currentTimeMillis = System.currentTimeMillis();
            Trace h10 = this.f22892c.h();
            this.f22890a.a(h.v(application, h10, application, intent, this.f22891b).r(new d(h10, currentTimeMillis)));
        } catch (Exception e10) {
            ng.a aVar2 = ng.a.f35508a;
            aVar2.c("AppLifecycle", "application observer error start activity in splash = " + e10.getMessage() + ", pre-ui completed=" + this.f22896g + ", continueToPostUI=" + this.f22895f + ", inBackground=" + this.f22892c.l(), e10);
        }
    }
}
