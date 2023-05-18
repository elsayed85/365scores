package com.scores365.dashboard;

import af.g;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.c;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.a0;
import androidx.lifecycle.a1;
import androidx.lifecycle.w0;
import androidx.viewpager.widget.ViewPager;
import cc.v0;
import cc.z0;
import com.amazon.device.ads.DTBAdSize;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.material.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.install.InstallState;
import com.scores365.App;
import com.scores365.Design.Activities.LocationWizardActivity;
import com.scores365.Design.Activities.f;
import com.scores365.DraggableView.ScoresDraggableView;
import com.scores365.DraggableView.VideoDraggableView;
import com.scores365.b;
import com.scores365.bets.model.EOddsFormats;
import com.scores365.dashboard.MainDashboardActivity;
import com.scores365.dashboard.a;
import com.scores365.didomi.DidomiNoticeActivity;
import com.scores365.entitys.BaseObj;
import com.scores365.entitys.BottomNavigationMenuItem;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.CountryObj;
import com.scores365.entitys.DynamicBettingPromotionTemplateObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GamesObj;
import com.scores365.entitys.NotificationObj;
import com.scores365.entitys.SpecialSectionFifthBtn;
import com.scores365.entitys.StatsFilter;
import com.scores365.entitys.VideoObj;
import com.scores365.entitys.eDashboardSection;
import com.scores365.services.b;
import com.scores365.ui.AskBeforeExit;
import ee.k;
import ef.m;
import gc.g0;
import gc.n;
import hd.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import je.b;
import lf.t;
import li.b0;
import li.c0;
import li.m0;
import li.o0;
import li.p0;
import li.x0;
import md.a;
import nb.y;
import re.p;
import sc.i;
import sh.a;
import tf.b;
import th.e;
import xe.b;
import xe.j;
import xe.q;
import xe.u;
import yc.m;
import ye.a;
import ze.h;
/* loaded from: classes2.dex */
public class MainDashboardActivity extends f implements a.d, g0, l, u, b.a, m, m.k, a.g, c7.b, a.b, b.c, n.a {
    public static String Y0 = "isDashboardFilter";
    public static boolean Z0 = false;

    /* renamed from: a1  reason: collision with root package name */
    public static boolean f23295a1 = false;

    /* renamed from: b1  reason: collision with root package name */
    public static boolean f23296b1 = false;

    /* renamed from: c1  reason: collision with root package name */
    private static boolean f23297c1 = false;

    /* renamed from: d1  reason: collision with root package name */
    public static long f23298d1 = -1;

    /* renamed from: e1  reason: collision with root package name */
    private static com.scores365.services.b f23299e1;
    Fragment A0;
    Fragment B0;
    Fragment C0;
    Fragment D0;
    Fragment E0;
    Fragment F0;
    Fragment G0;
    private boolean H0;
    private EOddsFormats I0;
    private boolean J0;
    private kf.a K0;
    private m0 L0;
    ConstraintLayout N0;
    private y6.b O0;
    private y6.a P0;
    Snackbar U0;

    /* renamed from: s0  reason: collision with root package name */
    private com.scores365.dashboard.a f23300s0;

    /* renamed from: t0  reason: collision with root package name */
    public t f23301t0;

    /* renamed from: u0  reason: collision with root package name */
    private SparseArray<Integer> f23302u0;

    /* renamed from: v0  reason: collision with root package name */
    long f23303v0 = -1;

    /* renamed from: w0  reason: collision with root package name */
    private boolean f23304w0 = false;

    /* renamed from: x0  reason: collision with root package name */
    boolean f23305x0 = false;

    /* renamed from: y0  reason: collision with root package name */
    boolean f23306y0 = false;

    /* renamed from: z0  reason: collision with root package name */
    boolean f23307z0 = false;
    private boolean M0 = false;
    private eDashboardSection Q0 = null;
    int R0 = 0;
    boolean S0 = false;
    private final a1 T0 = this;
    private final b.c V0 = new a();
    ConstraintLayout W0 = null;
    ye.a X0 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements b.c {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(GameObj gameObj) {
            try {
                Fragment fragment = MainDashboardActivity.this.A0;
                if (fragment == null || !(fragment instanceof hd.m)) {
                    return;
                }
                ((hd.m) fragment).onGameUpdate(gameObj);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(NotificationObj notificationObj, GameObj gameObj) {
            try {
                Fragment fragment = MainDashboardActivity.this.A0;
                if (fragment instanceof hd.m) {
                    ((hd.m) fragment).onNotification(notificationObj, gameObj);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // com.scores365.services.b.c
        public void onCompetitionsUpdated(ArrayList<CompetitionObj> arrayList) {
        }

        @Override // com.scores365.services.b.c
        public void onCountriesUpdated(ArrayList<CountryObj> arrayList) {
        }

        @Override // com.scores365.services.b.c
        public void onGameAdded(GameObj gameObj) {
        }

        @Override // com.scores365.services.b.c
        public void onGameDeleted(GameObj gameObj) {
        }

        @Override // com.scores365.services.b.c
        public void onGameUpdated(final GameObj gameObj) {
            if (gameObj != null) {
                try {
                    MainDashboardActivity.this.f23300s0.j().getGames().put(Integer.valueOf(gameObj.getID()), gameObj);
                    MainDashboardActivity.this.runOnUiThread(new Runnable() { // from class: com.scores365.dashboard.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            MainDashboardActivity.a.this.c(gameObj);
                        }
                    });
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        }

        @Override // com.scores365.services.b.c
        public void onGamesUpdated(GamesObj gamesObj) {
        }

        @Override // com.scores365.services.b.c
        public void onNetworkError() {
        }

        @Override // com.scores365.services.b.c
        public void onNewVideoArrive(Vector<VideoObj> vector, GameObj gameObj) {
        }

        @Override // com.scores365.services.b.c
        public void onNotification(final NotificationObj notificationObj, final GameObj gameObj) {
            try {
                MainDashboardActivity.this.runOnUiThread(new Runnable() { // from class: com.scores365.dashboard.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainDashboardActivity.a.this.d(notificationObj, gameObj);
                    }
                });
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23309a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f23310b;

        static {
            int[] iArr = new int[t.values().length];
            f23310b = iArr;
            try {
                iArr[t.MORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23310b[t.MEDIA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23310b[t.SCORES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23310b[t.FIFTH_BTN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23310b[t.SPECIAL_FIFTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23310b[t.SPECIAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23310b[t.FOLLOWING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23310b[t.BETTING_FIFTH_BTN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[eDashboardSection.values().length];
            f23309a = iArr2;
            try {
                iArr2[eDashboardSection.SCORES.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f23309a[eDashboardSection.ALL_SCORES.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<MainDashboardActivity> f23311a;

        public c(MainDashboardActivity mainDashboardActivity) {
            this.f23311a = new WeakReference<>(mainDashboardActivity);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[Catch: Exception -> 0x0075, TRY_LEAVE, TryCatch #0 {Exception -> 0x0075, blocks: (B:2:0x0000, B:4:0x000a, B:7:0x001a, B:9:0x0020, B:10:0x0025, B:12:0x002b, B:17:0x003b, B:19:0x006b), top: B:24:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r9 = this;
                java.lang.ref.WeakReference<com.scores365.dashboard.MainDashboardActivity> r0 = r9.f23311a     // Catch: java.lang.Exception -> L75
                java.lang.Object r0 = r0.get()     // Catch: java.lang.Exception -> L75
                com.scores365.dashboard.MainDashboardActivity r0 = (com.scores365.dashboard.MainDashboardActivity) r0     // Catch: java.lang.Exception -> L75
                if (r0 == 0) goto L79
                lf.c r1 = r0.l1()     // Catch: java.lang.Exception -> L75
                com.scores365.dashboard.a r2 = com.scores365.dashboard.MainDashboardActivity.X1(r0)     // Catch: java.lang.Exception -> L75
                com.scores365.entitys.GamesObj r2 = r2.j()     // Catch: java.lang.Exception -> L75
                if (r1 == 0) goto L79
                if (r2 == 0) goto L79
                androidx.fragment.app.Fragment r2 = r0.A0     // Catch: java.lang.Exception -> L75
                boolean r3 = r2 instanceof hd.m     // Catch: java.lang.Exception -> L75
                if (r3 == 0) goto L25
                hd.m r2 = (hd.m) r2     // Catch: java.lang.Exception -> L75
                r2.showPreloader()     // Catch: java.lang.Exception -> L75
            L25:
                boolean r2 = com.scores365.dashboard.MainDashboardActivity.Y1(r0)     // Catch: java.lang.Exception -> L75
                if (r2 != 0) goto L39
                sf.b r2 = sf.b.X1()     // Catch: java.lang.Exception -> L75
                boolean r2 = r2.N9()     // Catch: java.lang.Exception -> L75
                if (r2 == 0) goto L36
                goto L39
            L36:
                r2 = 0
                r7 = 0
                goto L3b
            L39:
                r2 = 1
                r7 = 1
            L3b:
                com.scores365.api.l0 r2 = new com.scores365.api.l0     // Catch: java.lang.Exception -> L75
                java.util.HashSet<java.lang.Integer> r3 = r1.f34290b     // Catch: java.lang.Exception -> L75
                java.lang.String r4 = li.x0.D0(r3)     // Catch: java.lang.Exception -> L75
                java.util.HashSet<java.lang.Integer> r3 = r1.f34289a     // Catch: java.lang.Exception -> L75
                java.lang.String r5 = li.x0.D0(r3)     // Catch: java.lang.Exception -> L75
                java.util.HashSet<java.lang.Integer> r1 = r1.f34291c     // Catch: java.lang.Exception -> L75
                java.lang.String r6 = li.x0.D0(r1)     // Catch: java.lang.Exception -> L75
                r8 = 0
                r3 = r2
                r3.<init>(r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L75
                r2.call()     // Catch: java.lang.Exception -> L75
                com.scores365.dashboard.a r1 = com.scores365.dashboard.MainDashboardActivity.X1(r0)     // Catch: java.lang.Exception -> L75
                com.scores365.entitys.GamesObj r3 = r2.a()     // Catch: java.lang.Exception -> L75
                r1.B(r3)     // Catch: java.lang.Exception -> L75
                r0.q2()     // Catch: java.lang.Exception -> L75
                androidx.fragment.app.Fragment r0 = r0.A0     // Catch: java.lang.Exception -> L75
                boolean r1 = r0 instanceof hd.m     // Catch: java.lang.Exception -> L75
                if (r1 == 0) goto L79
                hd.m r0 = (hd.m) r0     // Catch: java.lang.Exception -> L75
                com.scores365.entitys.GamesObj r1 = r2.a()     // Catch: java.lang.Exception -> L75
                r0.onGamesUpdate(r1)     // Catch: java.lang.Exception -> L75
                goto L79
            L75:
                r0 = move-exception
                li.x0.N1(r0)
            L79:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scores365.dashboard.MainDashboardActivity.c.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A2() {
        try {
            if (this.U0 == null) {
                Snackbar h02 = Snackbar.h0(findViewById(16908290), p0.l0("USER_HELP_CONNECTION_ISSUE"), 0);
                this.U0 = h02;
                TextView textView = (TextView) h02.D().findViewById(R.id.R);
                if (textView != null) {
                    textView.setTextSize(1, 14.0f);
                    textView.setTypeface(o0.d(App.m()));
                }
                this.U0.U();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void B2() {
        new Thread(new c(this)).start();
    }

    private void C2() {
        DynamicBettingPromotionTemplateObj dynamicBettingPromotionTemplateObj;
        int i10;
        if (li.g0.f34558a.g()) {
            ng.a.f35508a.b("DashboardActivity", "maintenance screen showing, content is ignored", null);
            return;
        }
        b.a aVar = je.b.f32619a;
        if (aVar.l()) {
            ng.a.f35508a.b("DashboardActivity", "survey screen should show, content is ignored", null);
        } else if (aVar.f()) {
            ng.a.f35508a.b("DashboardActivity", "survey screen started, content is ignored", null);
        } else {
            b.a aVar2 = tf.b.f39719a;
            aVar2.e(true);
            fc.a y10 = cc.o0.y();
            if (y10 == null) {
                cc.o0.h(this, true, false);
                ng.a.f35508a.c("DashboardActivity", "content config not found", new NullPointerException("missing content configuration"));
                return;
            }
            DynamicBettingPromotionTemplateObj f10 = ((App) getApplication()).j().f().f();
            oe.a aVar3 = oe.a.f36145a;
            boolean k10 = aVar3.k();
            boolean f11 = li.f.f();
            if (f10 == null) {
                DynamicBettingPromotionTemplateObj e10 = aVar3.e(getApplicationContext(), y10);
                aVar3.t(getApplicationContext(), e10 != null, f11, k10);
                dynamicBettingPromotionTemplateObj = e10;
                i10 = 1;
            } else {
                dynamicBettingPromotionTemplateObj = f10;
                i10 = 0;
            }
            if (dynamicBettingPromotionTemplateObj != null) {
                a.C0569a c0569a = sh.a.f39207a;
                c0569a.r(dynamicBettingPromotionTemplateObj, getSupportFragmentManager(), c0569a.c(getIntent().getBooleanExtra("isWizardFinished", false)), i10, f11 ? 1 : 0, k10 ? 1 : 0);
            } else if ((!App.f20793m && aVar2.q()) || aVar2.r()) {
                startActivity(new Intent(App.m(), DidomiNoticeActivity.class));
            } else if (!this.M0 && !App.f20793m && !y.a() && y.b()) {
                k.n(App.m(), "app", "user-permission", "pop-up", "show", false, ShareConstants.FEED_SOURCE_PARAM, "sync");
                Intent intent = new Intent(App.m(), LocationWizardActivity.class);
                intent.putExtra("loc", "sync");
                startActivity(intent);
                this.M0 = true;
            } else {
                int o10 = md.a.o(this);
                if (o10 == 1) {
                    md.a.n();
                } else if (o10 == 2) {
                    b2();
                }
            }
        }
    }

    private void F2() {
        try {
            t tVar = this.f23301t0;
            if (tVar != null && tVar != t.SCORES) {
                if (getIntent().getBooleanExtra("passedOnOnNewIntent", false)) {
                    this.f20875k0 = true;
                    getIntent().putExtra("passedOnOnNewIntent", false);
                } else {
                    this.f20875k0 = false;
                }
                getIntent().putExtra("isSelectedByDefault", true);
                this.f20869b0.setSelectedItemId(this.f23301t0.getValue());
                return;
            }
            t tVar2 = t.SCORES;
            this.f23301t0 = tVar2;
            Fragment fragment = this.A0;
            if (fragment == null) {
                this.A0 = j.h3(tVar2, p0.l0("MOBILE_MENU_SCORES"), false, j2(tVar2), li.y.f34689a.g());
            } else {
                ((j) fragment).o();
            }
            this.f20869b0.setSelectedItemId(com.scores365.R.id.G0);
            ((j) this.A0).w3(g2());
            a0 q10 = getSupportFragmentManager().q();
            q10.p(com.scores365.R.id.f21973e4, this.A0);
            q10.w(this.A0).i();
            this.f20875k0 = true;
            if (!x0.l1()) {
                p0.d.b(this.f20869b0, 0);
                return;
            }
            BottomNavigationView bottomNavigationView = this.f20869b0;
            p0.d.b(bottomNavigationView, bottomNavigationView.getMenu().size() - 1);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void G2() {
        try {
            this.f20869b0.setSelectedItemId(this.f23301t0.getValue());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private boolean H2() {
        try {
            int e02 = sf.b.X1().e0();
            if (eDashboardSection.create(getIntent().getIntExtra("dashboard_filetr_screen", 1)) != eDashboardSection.ALL_SCORES) {
                if (e02 == -2) {
                    return false;
                }
                if (!p0.l0("DASHBOARD_SCORES_DEFAULT_PAGE").equalsIgnoreCase("all_Scores") && e02 != -3) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    private boolean I2(t tVar, boolean z10) {
        try {
            boolean H2 = H2();
            if (tVar == t.SCORES) {
                return (z10 && !H2) ^ (!z10 && H2);
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public static void J2() {
        try {
            com.scores365.services.b bVar = f23299e1;
            if (bVar != null) {
                bVar.requestStop();
            }
            f23297c1 = true;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void a2() {
        try {
            final int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getApplicationContext());
            sf.b.X1().a8(isGooglePlayServicesAvailable);
            if (isGooglePlayServicesAvailable == 0 || !GoogleApiAvailability.getInstance().isUserResolvableError(isGooglePlayServicesAvailable)) {
                return;
            }
            String l02 = p0.l0("GOOGLE_PLAY_SERVICES_UPDATE_TITLE");
            String l03 = p0.l0("GOOGLE_PLAY_SERVICES_UPDATE_BODY");
            String l04 = p0.l0("GOOGLE_PLAY_SERVICES_UPDATE_CTA");
            if ((l02.isEmpty() || l03.isEmpty() || l04.isEmpty()) ? false : true) {
                androidx.appcompat.app.c a10 = new c.a(this).a();
                a10.setTitle(l02);
                a10.m(l03);
                a10.setCanceledOnTouchOutside(false);
                a10.l(-3, l04, new DialogInterface.OnClickListener() { // from class: re.m
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        MainDashboardActivity.this.w2(isGooglePlayServicesAvailable, dialogInterface, i10);
                    }
                });
                a10.show();
            } else {
                GoogleApiAvailability.getInstance().showErrorDialogFragment(this, isGooglePlayServicesAvailable, 723);
            }
            k.n(getApplicationContext(), "app", "popup", "open", null, false, "type", "google-play-services-update");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void b2() {
        boolean z10 = false;
        try {
            int i10 = com.scores365.tournamentPromotion.a.i(false);
            int l22 = l2();
            y6.a aVar = this.P0;
            if (aVar != null && aVar.b() == 2 && sf.b.X1().W1() % l22 == 0) {
                k.i(App.m(), "app", "update", "pop-up", ServerProtocol.DIALOG_PARAM_DISPLAY);
                this.O0.e(this.P0, 0, this, 997);
            } else {
                if (new tb.a().l()) {
                    tb.d.f39628l.b().show(getSupportFragmentManager(), "EncourageMe");
                } else if (i10 > -1) {
                    com.scores365.tournamentPromotion.a.u(i10, DTBAdSize.AAX_INTERSTITIAL_AD_SIZE);
                } else if (b0.g()) {
                    if (Boolean.parseBoolean(p0.l0("PRESENT_IN_APP_REVIEW"))) {
                        e.f39731a.e(this);
                        k.h(App.m(), "app", "rate_us_request", "sent");
                    } else {
                        c0.e(b0.a() ? 1 : 0);
                    }
                } else if (ub.e.p()) {
                    ub.e.m(this);
                    sf.b.X1().k7();
                } else if (ub.e.o()) {
                    ub.e.l(this);
                    sf.b.X1().j7();
                } else if (od.a.N0()) {
                    od.a.O0(this);
                } else if (!sf.b.X1().T0() && Boolean.parseBoolean(p0.l0("FAST_NOTIFICATION_POPUP_ENABLE"))) {
                    new sh.f().show(getSupportFragmentManager(), "fastNotificationFragment");
                    sf.b.X1().S6(true);
                }
                z10 = true;
            }
            if (z10) {
                sf.b.X1().v3();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private String[] c2(String str, String str2) {
        String[] strArr = new String[2];
        String lowerCase = t.SCORES.toString().toLowerCase();
        boolean equals = Objects.equals(str, lowerCase);
        boolean equals2 = Objects.equals(str2, lowerCase);
        Fragment fragment = this.A0;
        if (fragment != null && (fragment instanceof j)) {
            String str3 = ((j) fragment).V2() ? "all-scores" : "my-scores";
            if (equals) {
                str = str3;
            } else if (equals2) {
                str2 = str3;
            }
        }
        strArr[0] = str;
        strArr[1] = str2;
        return strArr;
    }

    private void d2() {
        try {
            a2();
            Z1();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void e2() {
        boolean z10;
        try {
            Fragment fragment = this.A0;
            if (fragment == null || fragment.isHidden()) {
                this.f20869b0.setSelectedItemId(h2(eDashboardSection.SCORES));
                return;
            }
            if (((j) this.A0).W2()) {
                ((j) this.A0).H2();
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return;
            }
            if (sf.b.X1().i4()) {
                startActivityForResult(AskBeforeExit.getActivityIntent(), AskBeforeExit.EXIT_ACTIVITY_CODE);
            } else {
                finish();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private int h2(eDashboardSection edashboardsection) {
        int i10 = b.f23309a[edashboardsection.ordinal()];
        return (i10 == 1 || i10 == 2) ? com.scores365.R.id.G0 : com.scores365.R.id.f22391x0;
    }

    private t i2() {
        t tVar;
        t tVar2 = t.SCORES;
        try {
            String l02 = p0.l0("DEFAULT_DASHBOARD_PAGE");
            boolean z10 = true;
            if (le.b.f34226a.k(true)) {
                tVar = t.BETTING_FIFTH_BTN;
            } else {
                if (!l02.isEmpty()) {
                    if (l02.equalsIgnoreCase("buzz")) {
                        tVar = t.MEDIA;
                    } else if (l02.equalsIgnoreCase("following")) {
                        tVar = t.FOLLOWING;
                    } else if (l02.equalsIgnoreCase("more")) {
                        tVar = t.MORE;
                    } else if (l02.equalsIgnoreCase("entity_promotiom")) {
                        tVar = t.FIFTH_BTN;
                    } else if (l02.equalsIgnoreCase("monetization")) {
                        tVar = t.SPECIAL;
                    }
                }
                tVar = tVar2;
            }
            if (tVar != tVar2) {
                try {
                    Iterator<BottomNavigationMenuItem> it = this.f20871g0.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z10 = false;
                            break;
                        } else if (it.next().f23583id == tVar.getValue()) {
                            break;
                        }
                    }
                    if (z10) {
                        return tVar;
                    }
                    return null;
                } catch (Exception e10) {
                    t tVar3 = tVar;
                    e = e10;
                    tVar2 = tVar3;
                    x0.N1(e);
                    return tVar2;
                }
            }
            return tVar;
        } catch (Exception e11) {
            e = e11;
        }
    }

    private int l2() {
        String l02 = p0.l0("SESSION_NUM_BETWEEN_UPDATE_DIALOG");
        if (x0.r1(l02)) {
            return Integer.parseInt(l02);
        }
        return 2;
    }

    private App.c o2(int i10) {
        App.c cVar = null;
        try {
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (i10 != 3) {
            if (i10 == 4) {
                cVar = App.c.TEAM;
            }
            return cVar;
        }
        cVar = App.c.LEAGUE;
        return cVar;
    }

    private void p2(String str, String str2, HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            try {
                hashMap = new HashMap<>();
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        HashMap<String, Object> hashMap2 = hashMap;
        hashMap2.put("screen", str);
        hashMap2.put("type_of_click", "click");
        hashMap2.put(ShareConstants.FEED_SOURCE_PARAM, str2);
        hashMap2.put("button_type", le.b.f34226a.l() ? "fire" : "arrow");
        k.k(App.m(), "dashboard", "strip-bar", "click", null, hashMap2);
    }

    private void r2() {
        try {
            t tVar = this.f23301t0;
            if (tVar == t.SCORES) {
                ((j) this.A0).a2();
            } else if (tVar == t.MEDIA) {
                ((xe.f) this.B0).a2();
            } else if (tVar == t.FOLLOWING) {
                ((xe.d) this.C0).a2();
            } else if (tVar == t.MORE) {
                ((xe.k) this.D0).a2();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s2() {
        try {
            Fragment i02 = getSupportFragmentManager().i0(com.scores365.R.id.f21973e4);
            boolean a32 = i02 instanceof j ? ((j) i02).a3() : false;
            return !a32 ? sf.b.X1().N9() : a32;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    private boolean t2(MenuItem menuItem) {
        try {
            if (menuItem.getItemId() == t.FIFTH_BTN.getValue()) {
                return com.scores365.tournamentPromotion.a.j().d().d().contains("singleplayer");
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    private boolean v2(ViewPager viewPager) {
        if (viewPager != null) {
            if (!x0.l1() && viewPager.getCurrentItem() == 0) {
                return true;
            }
            if (x0.l1() && viewPager.getCurrentItem() == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w2(int i10, DialogInterface dialogInterface, int i11) {
        try {
            PendingIntent errorResolutionPendingIntent = GoogleApiAvailability.getInstance().getErrorResolutionPendingIntent(App.m(), i10, 723);
            if (errorResolutionPendingIntent != null) {
                errorResolutionPendingIntent.send();
            }
            k.n(getApplicationContext(), "app", "popup", "click", null, false, "type", "google-play-services-update");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x2() {
        try {
            Fragment fragment = this.C0;
            if (fragment != null) {
                ((xe.d) fragment).o2();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets y2(View view, WindowInsets windowInsets) {
        try {
            this.R0 = view.onApplyWindowInsets(windowInsets).getSystemWindowInsetTop();
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z2(y6.a aVar) {
        try {
            if (aVar.b() == 2) {
                this.P0 = aVar;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // hd.l
    public void A0(BaseObj baseObj, boolean z10) {
        try {
            this.f23300s0.A(l1());
            B2();
            if (baseObj instanceof CompetitionObj) {
                Fragment fragment = this.A0;
                if (fragment instanceof j) {
                    ((j) fragment).k3();
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.f
    protected void A1() {
        try {
            this.f23307z0 = true;
            Bundle extras = getIntent() != null ? getIntent().getExtras() : null;
            if (this.f23301t0 == null) {
                this.f23301t0 = i2();
            }
            if (extras == null || !extras.containsKey("dashboard_filetr_screen")) {
                int e02 = sf.b.X1().e0();
                if (e02 == -4) {
                    this.f23301t0 = t.MEDIA;
                } else {
                    if (e02 != -3 && e02 != -2) {
                        if (e02 > 0 && this.f20880p0 != -1) {
                            if (com.scores365.tournamentPromotion.a.j().b() == e02) {
                                this.f23301t0 = t.FIFTH_BTN;
                            } else if (com.scores365.tournamentPromotion.a.g(e02) instanceof nd.b) {
                                m((nd.b) com.scores365.tournamentPromotion.a.g(e02));
                            }
                        }
                    }
                    this.f23301t0 = t.SCORES;
                }
                F2();
            } else {
                int h22 = h2(eDashboardSection.create(getIntent().getIntExtra("dashboard_filetr_screen", 1)));
                if (h22 != com.scores365.R.id.G0) {
                    this.f20869b0.setSelectedItemId(h22);
                } else {
                    this.f23301t0 = t.SCORES;
                    F2();
                }
            }
            C2();
            App.f20792l.r(this);
            this.f23306y0 = true;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // yc.m.k
    public void C0() {
        try {
            this.L0.b();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // yc.m.k
    public boolean D0() {
        try {
            return this.L0.c();
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public void D2() {
        try {
            Fragment fragment = this.A0;
            if (fragment instanceof j) {
                ((j) fragment).K3();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // f7.a
    /* renamed from: E2 */
    public void j(@NonNull InstallState installState) {
        try {
            if (installState.c() == 11) {
                this.O0.b();
                this.O0.a(this);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // gc.n.a
    public boolean G0() {
        return (isDestroyed() || isFinishing() || isChangingConfigurations()) ? false : true;
    }

    @Override // com.scores365.dashboard.a.d
    public boolean I0() {
        return false;
    }

    @Override // hd.l
    public void J0() {
        try {
            if (this.f23303v0 != App.b.X() || f23296b1) {
                this.f23300s0.d();
                Iterator it = new ArrayList(this.f23300s0.h().keySet()).iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!str.equals("Games")) {
                        this.f23300s0.h().remove(str);
                    }
                }
                D1(false, true, false);
                this.f23303v0 = App.b.X();
                f23295a1 = true;
                Fragment fragment = this.A0;
                if (fragment != null) {
                    ((j) fragment).m3(false, false);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // hd.l
    public void K0(GameObj gameObj, CompetitionObj competitionObj, boolean z10, Fragment fragment) {
        q2();
        f23295a1 = true;
    }

    @Override // com.scores365.Design.Activities.f
    protected void O1() {
        try {
            setContentView(com.scores365.R.layout.f22640o0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.f
    protected boolean P1() {
        return true;
    }

    @Override // com.scores365.dashboard.a.d
    public String Q0() {
        return sf.b.X1().s2();
    }

    @Override // com.scores365.Design.Activities.f
    protected void Q1() {
        try {
            Fragment fragment = this.A0;
            if (fragment instanceof p) {
                ((p) fragment).o();
            }
            Fragment fragment2 = this.B0;
            if (fragment2 instanceof p) {
                ((p) fragment2).o();
            }
            Fragment fragment3 = this.C0;
            if (fragment3 instanceof p) {
                ((p) fragment3).o();
            }
            Fragment fragment4 = this.D0;
            if (fragment4 instanceof p) {
                ((p) fragment4).o();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.dashboard.a.d
    public void S0() {
        runOnUiThread(new Runnable() { // from class: re.j
            @Override // java.lang.Runnable
            public final void run() {
                MainDashboardActivity.this.A2();
            }
        });
    }

    @Override // com.scores365.dashboard.a.d
    public ArrayList<StatsFilter> U0() {
        return null;
    }

    @Override // gc.g0
    @NonNull
    public sc.f W0() {
        return sc.f.SmallLayout;
    }

    public void Z1() {
        this.S0 = uf.a.t((ConstraintLayout) findViewById(com.scores365.R.id.f22129l3), i.Dashboard, this);
    }

    @Override // xe.u
    public void d(t tVar, int i10) {
        try {
            if (this.f23302u0 == null) {
                this.f23302u0 = new SparseArray<>();
            }
            this.f23302u0.append(tVar.getValue(), Integer.valueOf(i10));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            this.L0.e(motionEvent, (j) this.A0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        try {
            if (motionEvent.getAction() != 5) {
                if (!super.dispatchTouchEvent(motionEvent)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e11) {
            x0.N1(e11);
            return false;
        }
    }

    @Override // com.scores365.dashboard.a.d
    public int e0() {
        return -1;
    }

    @Override // com.scores365.dashboard.a.d
    public void f0(ArrayList<StatsFilter> arrayList) {
    }

    @Override // com.scores365.dashboard.a.d
    public boolean f1() {
        return s2() || sf.b.X1().N9();
    }

    public int f2(int i10) {
        for (int i11 = 0; i11 < this.f20871g0.size(); i11++) {
            if (this.f20871g0.get(i11).f23583id == i10) {
                return i11;
            }
        }
        return -1;
    }

    public int g2() {
        int i10 = 0;
        try {
            for (Integer num : this.f23300s0.j().getGames().keySet()) {
                int intValue = num.intValue();
                GameObj gameObj = this.f23300s0.j().getGames().get(Integer.valueOf(intValue));
                if (gameObj != null && gameObj.getIsActive() && !App.b.W().contains(Integer.valueOf(intValue))) {
                    i10++;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return i10;
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public i getPlacement() {
        return i.Dashboard;
    }

    @Override // com.scores365.b.a
    public void i(int i10, boolean z10) {
        try {
            Fragment fragment = this.A0;
            if (fragment != null) {
                ((j) fragment).H3(i10, z10);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // hd.l
    public void i0() {
        try {
            com.scores365.dashboard.a aVar = this.f23300s0;
            if (aVar != null) {
                aVar.A(l1());
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // gc.n.a
    public void j1(@NonNull String str, @NonNull NativeCustomFormatAd nativeCustomFormatAd, @NonNull n nVar) {
        if (str.equals("12190751")) {
            Z1();
        }
    }

    public int j2(t tVar) {
        boolean l12;
        try {
            l12 = x0.l1();
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (I2(tVar, l12)) {
            return 1;
        }
        if (tVar == t.FOLLOWING) {
            return l12 ? 1 : 0;
        }
        SparseArray<Integer> sparseArray = this.f23302u0;
        if (sparseArray != null && tVar != null) {
            return sparseArray.get(tVar.getValue()).intValue();
        }
        return 0;
    }

    @Override // com.scores365.dashboard.a.d
    public void k0(String str, Object obj) {
    }

    @Override // com.scores365.Design.Activities.f
    protected void k1() {
        try {
            Context m10 = App.m();
            String[] strArr = new String[10];
            strArr[0] = "screen";
            strArr[1] = "scores";
            strArr[2] = "type_of_click";
            strArr[3] = "auto";
            strArr[4] = ShareConstants.FEED_SOURCE_PARAM;
            strArr[5] = "open-app";
            strArr[6] = "is_betting";
            le.b bVar = le.b.f34226a;
            strArr[7] = bVar.a(getApplicationContext());
            strArr[8] = "button_type";
            strArr[9] = bVar.l() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "0";
            k.o(m10, "dashboard", "strip-bar", "click", null, strArr);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public Fragment k2() {
        return this.A0;
    }

    @Override // com.scores365.dashboard.a.d
    public ArrayList<com.scores365.Design.Pages.b> l0(t tVar) {
        return this.f23300s0.l(tVar);
    }

    @Override // com.scores365.dashboard.a.d
    public lf.c l1() {
        return x0.j0();
    }

    @Override // ye.a.g
    public void m(nd.b bVar) {
        try {
            MenuItem findItem = this.f20869b0.getMenu().findItem(t.FIFTH_BTN.getValue());
            com.scores365.tournamentPromotion.a.t(bVar);
            com.scores365.tournamentPromotion.a.d();
            sf.b.X1().x8(bVar.b());
            if (this.f20869b0.getSelectedItemId() == findItem.getItemId()) {
                getSupportFragmentManager().q().n(this.F0).h();
                this.F0 = q.r2(bVar.d().f(), bVar.d().e(), false, 0, false);
                getSupportFragmentManager().q().b(com.scores365.R.id.f21973e4, this.F0).g(null).w(this.F0).h();
                ye.a aVar = this.X0;
                if (aVar != null) {
                    aVar.h();
                }
            } else {
                this.F0 = null;
                this.f20869b0.setSelectedItemId(findItem.getItemId());
            }
            findItem.setTitle(bVar.d().c());
            new a.h(findItem, bVar).execute(new Void[0]);
            if (this.f20880p0 > -1) {
                try {
                    new Handler().postDelayed(new f.g(this), 200L);
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    @Override // gc.g0
    public void m0() {
        for (Fragment fragment : getSupportFragmentManager().v0()) {
            if (fragment instanceof j) {
                ((j) fragment).renderNativeAds();
            }
        }
    }

    public String m2() {
        t tVar = this.f23301t0;
        if (tVar != null) {
            switch (b.f23310b[tVar.ordinal()]) {
                case 1:
                    return "more";
                case 2:
                    return ShareConstants.WEB_DIALOG_PARAM_MEDIA;
                case 3:
                    return "scores";
                case 4:
                case 5:
                case 6:
                    return "promotion";
                case 7:
                    return "following";
                case 8:
                    return "betting";
            }
        }
        return "";
    }

    @Override // md.a.b
    public void n(boolean z10) {
        try {
            if (z10) {
                md.a.n();
            } else {
                b2();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // ef.m
    public void n0() {
        try {
            this.f23304w0 = true;
            this.f20869b0.setSelectedItemId(com.scores365.R.id.f22303t0);
            this.f23304w0 = false;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.dashboard.a.d
    public void n1(String str, Object obj) {
        try {
            com.scores365.dashboard.a aVar = this.f23300s0;
            if (aVar == null || !(obj instanceof GamesObj)) {
                return;
            }
            aVar.B((GamesObj) obj);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public kf.a n2() {
        return this.K0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        Fragment fragment;
        Fragment fragment2;
        Fragment fragment3;
        int i12;
        Fragment fragment4;
        try {
            super.onActivityResult(i10, i11, intent);
            if (isOpeningActivityLocked()) {
                lockUnLockActivityOpening();
            }
            if (i10 == 888) {
                if (i11 == -1 || i11 == 994) {
                    if (intent != null && intent.getExtras() != null && intent.getExtras().containsKey("update_dashboard")) {
                        if (intent.getExtras().getBoolean("update_dashboard", false)) {
                            m1(true);
                            D1(true, false, false);
                        }
                    } else if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("gameItemPositionToUpdate") || (i12 = intent.getExtras().getInt("gameItemPositionToUpdate", -1)) == -1 || this.f23301t0 != t.SCORES || (fragment4 = this.A0) == null || !(fragment4 instanceof j)) {
                    } else {
                        ((j) fragment4).L3(i12);
                    }
                }
            } else if (i10 == 996) {
                if (this.f23301t0 == t.FOLLOWING && (fragment3 = this.C0) != null && (fragment3 instanceof xe.d) && intent != null && intent.getExtras() != null && intent.getExtras().containsKey("entityType") && intent.getExtras().containsKey("entityID")) {
                    ((xe.d) this.C0).q2(intent.getExtras().getInt("entityID"), intent.getExtras().getInt("entityType"));
                }
            } else {
                if (i10 != 990 && (i10 != 995 || i11 != -1)) {
                    if (i10 == 991) {
                        if (intent == null || !intent.getBooleanExtra("is_selection_changed", false) || (fragment2 = this.C0) == null) {
                            return;
                        }
                        ((xe.d) fragment2).t2();
                        return;
                    } else if (i10 == 1456) {
                        G2();
                        return;
                    } else if (i10 != 993) {
                        if (i10 == 887) {
                            if (i11 == -1) {
                                finish();
                                return;
                            }
                            return;
                        } else if (i10 == 997) {
                            k.o(App.m(), "app", "update", "pop-up", "click", "click_type", i11 == -1 ? "update" : "no");
                            return;
                        } else {
                            return;
                        }
                    } else {
                        if (intent.getBooleanExtra("should_remove_competitor", false)) {
                            Fragment fragment5 = this.C0;
                            if (fragment5 instanceof xe.d) {
                                ViewPager F1 = ((xe.d) fragment5).F1();
                                if (v2(F1)) {
                                    Object i13 = F1.getAdapter() != null ? F1.getAdapter().i(F1, F1.getCurrentItem()) : null;
                                    if (i13 instanceof h) {
                                        int intExtra = intent.getIntExtra("container_tag", -1);
                                        ((h) i13).f3((g) intent.getSerializableExtra("follow_base_obj"), intExtra, (ze.b) ((h) i13).getRvBaseAdapter().A(intExtra), (BaseObj) intent.getSerializableExtra("baseObjFollowed"));
                                    }
                                }
                            }
                        }
                        Fragment fragment6 = this.F0;
                        if (fragment6 != null) {
                            fragment6.onActivityResult(i10, i11, intent);
                            return;
                        }
                        return;
                    }
                }
                t tVar = this.f23301t0;
                if ((tVar == t.FOLLOWING || tVar == t.MORE) && (fragment = this.C0) != null && (fragment instanceof xe.d)) {
                    ((xe.d) fragment).t2();
                }
                if (intent == null || !intent.getBooleanExtra("isDirty", false)) {
                    return;
                }
                B2();
                yc.m.B = null;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            if (this.K0.h()) {
                this.K0.g();
            } else {
                ye.a aVar = this.X0;
                if (aVar == null || !aVar.i()) {
                    Fragment i02 = getSupportFragmentManager().i0(com.scores365.R.id.f21973e4);
                    if (!(i02 instanceof ac.j)) {
                        e2();
                    } else if (((ac.j) i02).P()) {
                        ((ac.j) i02).T();
                    } else if (((ac.j) i02).m()) {
                        e2();
                    }
                } else {
                    this.X0.h();
                }
            }
        } catch (Exception e10) {
            super.onBackPressed();
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.f, com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(com.scores365.R.id.f22129l3);
        this.N0 = constraintLayout;
        constraintLayout.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: re.k
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets y22;
                y22 = MainDashboardActivity.this.y2(view, windowInsets);
                return y22;
            }
        });
        this.K0 = new kf.a(this.N0);
        com.scores365.dashboard.a aVar = new com.scores365.dashboard.a();
        this.f23300s0 = aVar;
        aVar.z((xe.c) new w0(this.T0).a(xe.c.class), this.T0);
        d2();
        try {
            if (App.l() != null && App.l().bets != null) {
                this.H0 = App.l().bets.showBetsInAllScores && x0.s2();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        this.I0 = sf.b.X1().A2();
        this.J0 = sf.b.X1().r();
        if (App.f20793m) {
            App.b.y0();
            this.f23303v0 = App.b.X();
        }
        this.L0 = new m0();
        try {
            ConstraintLayout constraintLayout2 = this.N0;
            if (constraintLayout2 != null) {
                constraintLayout2.setSystemUiVisibility(1280);
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
        try {
            y6.b a10 = y6.c.a(getApplicationContext());
            this.O0 = a10;
            a10.c().d(new j7.c() { // from class: re.l
                @Override // j7.c
                public final void onSuccess(Object obj) {
                    MainDashboardActivity.this.z2((y6.a) obj);
                }
            });
            this.O0.d(this);
        } catch (Exception e12) {
            x0.N1(e12);
        }
        ec.e.f25767v = "Dashboard new sessions";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onDestroy() {
        try {
            com.scores365.services.b bVar = f23299e1;
            if (bVar != null) {
                bVar.requestStop();
            }
            f23299e1 = null;
        } catch (Exception e10) {
            x0.N1(e10);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        intent.putExtra("passedOnOnNewIntent", true);
        this.f23306y0 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onPause() {
        super.onPause();
        f23298d1 = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.f, com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            if (!this.f23306y0 && this.f23307z0) {
                A1();
            }
            try {
                boolean s22 = x0.s2();
                boolean z10 = App.l().bets.showBetsInAllScores;
                boolean z11 = (this.H0 != z10 && s22) || this.I0 != sf.b.X1().A2();
                this.H0 = z10 && s22;
                this.I0 = sf.b.X1().A2();
                Fragment fragment = this.A0;
                if (fragment != null) {
                    ((j) fragment).J3();
                }
                if (this.J0 != sf.b.X1().r()) {
                    z11 = true;
                }
                this.J0 = sf.b.X1().r();
                if (z11) {
                    ((j) this.A0).m3(true, false);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            double d10 = 3.0d;
            try {
                if (!p0.l0("REFRESH_DATA_AFTER_X_HOURS").isEmpty()) {
                    d10 = Double.parseDouble(p0.l0("REFRESH_DATA_AFTER_X_HOURS"));
                }
            } catch (NumberFormatException e11) {
                x0.N1(e11);
            }
            long millis = (long) (TimeUnit.HOURS.toMillis(1L) * d10);
            if (this.f23306y0 && f23297c1 && millis + f23298d1 < System.currentTimeMillis()) {
                D1(true, false, true);
            } else {
                com.scores365.services.b bVar = f23299e1;
                if (bVar != null) {
                    bVar.setQuit(false);
                    q2();
                }
                J0();
                if (f23295a1) {
                    f23295a1 = false;
                    B2();
                }
                if (this.f23305x0) {
                    this.f23305x0 = false;
                    this.f20869b0.setSelectedItemId(this.f23301t0.getValue());
                }
            }
            if (this.S0 || !uf.a.f40209k) {
                uf.a.J((ConstraintLayout) findViewById(com.scores365.R.id.f22129l3));
            } else {
                Z1();
            }
            r2();
            t tVar = this.f23301t0;
            t tVar2 = t.FIFTH_BTN;
            if ((tVar == tVar2 || tVar == t.SPECIAL_FIFTH) && ye.a.j()) {
                this.f20882r0.a(this.f20869b0.getMenu().findItem(tVar2.getValue()));
                return;
            }
            t tVar3 = this.f23301t0;
            t tVar4 = t.BETTING_FIFTH_BTN;
            if (tVar3 == tVar4 && le.b.f34226a.e()) {
                getIntent().putExtra("shouldSendAnalEventOnBetting5thButton", false);
                this.f20882r0.a(this.f20869b0.getMenu().findItem(tVar4.getValue()));
            }
        } catch (Exception e12) {
            x0.N1(e12);
        }
    }

    @Override // com.scores365.dashboard.a.d
    public Object p0(String str) {
        try {
            this.f23300s0.y(str, this, null);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return r0(str);
    }

    @Override // com.scores365.dashboard.a.d
    public int p1() {
        return 0;
    }

    @Override // com.scores365.Design.Activities.f
    protected boolean q1(boolean z10) {
        boolean z11;
        Exception e10;
        boolean z12 = false;
        try {
            if (!z10) {
                try {
                    if (!x0.o1(App.m())) {
                        S0();
                        z11 = false;
                        q2();
                        Vector<CompObj> l10 = App.b.l();
                        Vector<CompetitionObj> i10 = App.b.i();
                        if (!l10.isEmpty() && i10.isEmpty()) {
                            k.n(App.m(), "app", "no-selections", "check", null, false, "db-teams-selection-empty", String.valueOf(sf.a.i0(App.m()).F0().isEmpty()));
                            return z11;
                        }
                    }
                } catch (Exception e11) {
                    e10 = e11;
                    x0.N1(e10);
                    return z12;
                }
            }
            SparseArray<Integer> sparseArray = this.f23302u0;
            if (sparseArray != null) {
                sparseArray.clear();
            }
            if (z11 && ((v0.i() || v0.h()) && v0.d() > -1)) {
                v0.g(this);
                v0.f(this);
            }
            q2();
            Vector<CompObj> l102 = App.b.l();
            Vector<CompetitionObj> i102 = App.b.i();
            return !l102.isEmpty() ? z11 : z11;
        } catch (Exception e12) {
            z12 = z11;
            e10 = e12;
            x0.N1(e10);
            return z12;
        }
        z11 = this.f23300s0.w(this, null, li.y.f34689a.g(), z10);
    }

    public void q2() {
        try {
            GamesObj j10 = this.f23300s0.j();
            if (j10 != null) {
                lf.c l12 = l1();
                com.scores365.services.b bVar = f23299e1;
                if (bVar != null) {
                    bVar.requestStop();
                    f23299e1 = null;
                }
                com.scores365.services.b bVar2 = new com.scores365.services.b("", x0.D0(l12.f34290b), x0.D0(l12.f34289a), x0.D0(l12.f34291c), false, j10, -1);
                f23299e1 = bVar2;
                bVar2.setIsLiveFilter(false);
                f23299e1.setWithMainOdds(s2());
                f23299e1.setEventsType(com.scores365.services.b.EVENT_TYPE_BROADCAST);
                f23299e1.setOnChangeListener(this.V0);
                f23299e1.start(true);
                f23297c1 = false;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.dashboard.a.d
    public Object r0(String str) {
        return this.f23300s0.m(str);
    }

    @Override // hd.l
    public boolean s0() {
        boolean z10 = f23295a1;
        f23295a1 = false;
        return z10;
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public void setMpuHandler(z0 z0Var) {
        try {
            super.setMpuHandler(z0Var);
            Fragment fragment = this.A0;
            if (fragment != null) {
                ((j) fragment).x3(z0Var);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.f
    protected ArrayList<BottomNavigationMenuItem> t1() {
        ArrayList<BottomNavigationMenuItem> arrayList = new ArrayList<>();
        arrayList.add(new BottomNavigationMenuItem(t.SCORES.getValue(), 1, p0.l0("MOBILE_MENU_SCORES"), com.scores365.R.drawable.G, null, false));
        arrayList.add(new BottomNavigationMenuItem(t.MEDIA.getValue(), 1, p0.l0("MAIN_TAB_NAME_NEWS"), com.scores365.R.drawable.E, null, false));
        arrayList.add(new BottomNavigationMenuItem(t.FOLLOWING.getValue(), 1, p0.l0("NEW_DASHBAORD_FOLLOWING"), com.scores365.R.drawable.D, null, false));
        arrayList.add(new BottomNavigationMenuItem(t.MORE.getValue(), 1, p0.l0("NEW_DASHBAORD_MORE"), com.scores365.R.drawable.F, null, false));
        try {
            le.b bVar = le.b.f34226a;
            if (bVar.g(getApplicationContext())) {
                arrayList.add(bVar.c(), new BottomNavigationMenuItem(t.BETTING_FIFTH_BTN.getValue(), 1, p0.l0("BETTING_5TH_BUTTON_TITLE"), BottomNavigationMenuItem.BETTING_5TH_ICON_ID, null, false));
            } else if (v0.i() && v0.d() > -1) {
                arrayList.add(v0.d(), new BottomNavigationMenuItem(t.SPECIAL_FIFTH.getValue(), 1, v0.c(), BottomNavigationMenuItem.SPECIAL_FIFTH_ICON_ID, null, false));
                k.n(App.m(), "dashboard", "strip-bar", "button", ServerProtocol.DIALOG_PARAM_DISPLAY, false, "button", "monetization", "promotion_id", v0.e(), "position", String.valueOf(v0.d()), "is_longtap", String.valueOf(com.scores365.tournamentPromotion.a.p()));
            } else if (v0.h() && v0.d() > -1) {
                arrayList.add(v0.d(), new BottomNavigationMenuItem(t.SPECIAL.getValue(), 1, v0.c(), BottomNavigationMenuItem.SPECIAL_ICON_ID, null, false));
            } else if (com.scores365.tournamentPromotion.a.j() != null) {
                nd.b j10 = com.scores365.tournamentPromotion.a.j();
                if (j10.d() != null) {
                    arrayList.add(j10.d().a(), new BottomNavigationMenuItem(t.FIFTH_BTN.getValue(), 1, j10.d().c(), BottomNavigationMenuItem.FIFTH_ICON_ID, null, false));
                    ye.a.l(j10.b(), j10.d().a());
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (x0.l1()) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }

    public boolean u2() {
        boolean z10 = false;
        try {
            Fragment fragment = this.C0;
            if (fragment == null || !(fragment instanceof xe.d)) {
                return false;
            }
            int o10 = App.b.o();
            int n10 = App.b.n();
            int l22 = ((xe.d) this.C0).l2();
            int k22 = ((xe.d) this.C0).k2();
            if (l22 > -1 && o10 != l22) {
                z10 = true;
            }
            if (k22 <= -1 || n10 == k22) {
                return z10;
            }
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // xe.b.c
    public int v0() {
        return this.R0;
    }

    @Override // com.scores365.dashboard.a.d
    public void x0(String str, a.c cVar) {
        try {
            new Thread(new com.scores365.dashboard.b(str, this.f23300s0, cVar, this)).start();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.f
    protected Fragment x1(MenuItem menuItem) {
        String str;
        Fragment fragment;
        boolean z10;
        boolean z11;
        Fragment fragment2;
        Fragment fragment3;
        Fragment r22;
        Fragment fragment4;
        String str2;
        String str3;
        j jVar;
        String m22 = m2();
        ye.a aVar = this.X0;
        if (aVar != null) {
            aVar.h();
        }
        try {
            if (!t2(menuItem)) {
                t tVar = this.f23301t0;
                if (tVar == t.SCORES && this.A0 != null) {
                    getSupportFragmentManager().q().n(this.A0).h();
                    ScoresDraggableView O0 = ((rb.c) this.A0).O0();
                    if (O0 != null) {
                        if (O0 instanceof VideoDraggableView) {
                            ((VideoDraggableView) O0).E();
                        } else {
                            O0.setRemoved(true);
                        }
                    }
                } else if (tVar == t.MEDIA && this.B0 != null) {
                    getSupportFragmentManager().q().n(this.B0).h();
                } else if (tVar == t.FOLLOWING && this.C0 != null) {
                    new Handler().postDelayed(new Runnable() { // from class: re.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            MainDashboardActivity.this.x2();
                        }
                    }, 100L);
                    getSupportFragmentManager().q().n(this.C0).h();
                } else if (tVar == t.FIFTH_BTN && this.F0 != null) {
                    getSupportFragmentManager().q().n(this.F0).h();
                } else if (tVar == t.MORE && this.D0 != null) {
                    getSupportFragmentManager().q().n(this.D0).h();
                } else if (tVar == t.SPECIAL && this.E0 != null) {
                    getSupportFragmentManager().q().n(this.E0).h();
                } else if (tVar == t.SPECIAL_FIFTH && this.F0 != null) {
                    getSupportFragmentManager().q().n(this.F0).h();
                } else if (tVar == t.BETTING_FIFTH_BTN && this.G0 != null) {
                    getSupportFragmentManager().q().n(this.G0).h();
                    le.b.f34226a.j(true);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        Window window = getWindow();
        int itemId = menuItem.getItemId();
        t tVar2 = t.FIFTH_BTN;
        if (itemId == tVar2.getValue()) {
            window.addFlags(67108864);
        } else {
            window.clearFlags(67108864);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        int itemId2 = menuItem.getItemId();
        t tVar3 = t.SCORES;
        if (itemId2 == tVar3.getValue()) {
            this.f23301t0 = tVar3;
            if (f23295a1) {
                this.f23300s0.A(l1());
                B2();
                f23295a1 = false;
            }
            Fragment fragment5 = this.A0;
            if (fragment5 == null) {
                j h32 = j.h3(tVar3, p0.l0("MY_SCORES"), false, j2(tVar3), li.y.f34689a.g());
                h32.w3(g2());
                this.A0 = h32;
                this.f20875k0 = true;
                jVar = h32;
            } else {
                this.f20875k0 = false;
                ((j) fragment5).r3();
                jVar = fragment5;
            }
            str = "scores";
            fragment = jVar;
        } else {
            int itemId3 = menuItem.getItemId();
            t tVar4 = t.MEDIA;
            if (itemId3 == tVar4.getValue()) {
                eDashboardSection edashboardsection = eDashboardSection.NEWS;
                if (getIntent().hasExtra("dashboard_filetr_screen")) {
                    edashboardsection = eDashboardSection.create(getIntent().getExtras().getInt("dashboard_filetr_screen", 1));
                    getIntent().removeExtra("dashboard_filetr_screen");
                }
                this.f23301t0 = tVar4;
                Fragment fragment6 = this.B0;
                if (fragment6 == null) {
                    fragment4 = xe.f.m2(tVar4, p0.l0("MAIN_TAB_NAME_NEWS"), true, edashboardsection, j2(tVar4));
                    this.B0 = fragment4;
                    this.f20875k0 = true;
                } else {
                    this.f20875k0 = false;
                    ((xe.f) fragment6).n2();
                    fragment4 = fragment6;
                }
                str = ShareConstants.WEB_DIALOG_PARAM_MEDIA;
                fragment = fragment4;
            } else {
                int itemId4 = menuItem.getItemId();
                t tVar5 = t.FOLLOWING;
                if (itemId4 == tVar5.getValue()) {
                    this.f23301t0 = tVar5;
                    if (this.C0 == null || u2()) {
                        r22 = xe.d.r2(tVar5, p0.l0("NEW_DASHBAORD_FOLLOWING"), false, j2(tVar5));
                        this.C0 = r22;
                        this.f20875k0 = true;
                    } else {
                        this.f20875k0 = false;
                        r22 = this.C0;
                        ((xe.d) r22).u2();
                    }
                    str = "following";
                    fragment = r22;
                } else {
                    int itemId5 = menuItem.getItemId();
                    t tVar6 = t.MORE;
                    if (itemId5 == tVar6.getValue()) {
                        this.f23301t0 = tVar6;
                        Fragment fragment7 = this.D0;
                        if (fragment7 == null) {
                            fragment7 = xe.k.m2(tVar6, p0.l0("NEW_DASHBAORD_MORE"), false, j2(tVar6));
                            this.D0 = fragment7;
                            this.f20875k0 = true;
                        } else {
                            this.f20875k0 = false;
                        }
                        int f22 = f2(tVar6.getValue());
                        if (f22 > -1) {
                            p0.d.d(this.f20869b0, f22);
                        }
                        str = "more";
                        fragment = fragment7;
                    } else {
                        int itemId6 = menuItem.getItemId();
                        t tVar7 = t.SPECIAL;
                        if (itemId6 == tVar7.getValue()) {
                            this.f23301t0 = tVar7;
                            Fragment fragment8 = this.E0;
                            if (fragment8 == null) {
                                fragment8 = com.scores365.GeneralCampaignMgr.a.m2(tVar7, v0.e());
                                this.E0 = fragment8;
                                this.f20875k0 = true;
                            } else {
                                this.f20875k0 = false;
                            }
                            str = "special";
                            fragment = fragment8;
                        } else {
                            q qVar = null;
                            if (menuItem.getItemId() == tVar2.getValue()) {
                                this.f23301t0 = tVar2;
                                if (this.F0 == null || ye.a.j()) {
                                    ye.a.n(false);
                                    nd.b j10 = com.scores365.tournamentPromotion.a.j();
                                    hashMap.put("promotion_id", Integer.valueOf(j10.b()));
                                    if (j10.d().d().contains("singleplayer")) {
                                        x0.M1(j10.d().d());
                                        this.f20875k0 = false;
                                    } else {
                                        q r23 = q.r2(j10.d().f(), j10.d().e(), false, 0, false);
                                        eDashboardSection edashboardsection2 = this.Q0;
                                        if (edashboardsection2 != null) {
                                            r23.O2(edashboardsection2.getValue());
                                            this.Q0 = null;
                                        }
                                        if (this.F0 != null) {
                                            getSupportFragmentManager().q().o(this.F0).i();
                                        }
                                        this.F0 = r23;
                                        this.f20875k0 = true;
                                        qVar = r23;
                                    }
                                    fragment3 = qVar;
                                } else {
                                    this.f20875k0 = false;
                                    fragment3 = this.F0;
                                }
                                if (com.scores365.tournamentPromotion.a.p() && !sf.b.X1().Y4() && (sf.b.X1().A0() == 0 || sf.b.X1().A0() % ye.a.g() == 0)) {
                                    new ye.c().show(getSupportFragmentManager(), "fifthButtonTutorial");
                                }
                                str = "promotion";
                                fragment = fragment3;
                            } else {
                                int itemId7 = menuItem.getItemId();
                                t tVar8 = t.SPECIAL_FIFTH;
                                if (itemId7 == tVar8.getValue()) {
                                    this.f23301t0 = tVar8;
                                    if (this.F0 == null || ye.a.j()) {
                                        ye.a.n(false);
                                        SpecialSectionFifthBtn specialSectionFifthBtn = v0.f10101b;
                                        q t22 = q.t2(o2(specialSectionFifthBtn.getEntityType()), specialSectionFifthBtn.getEntityID(), false, specialSectionFifthBtn.tabs, specialSectionFifthBtn.getSectionID(), 0, true);
                                        hashMap.put("promotion_id", specialSectionFifthBtn.getSectionID());
                                        if (this.F0 != null) {
                                            getSupportFragmentManager().q().o(this.F0).i();
                                        }
                                        this.F0 = t22;
                                        this.f20875k0 = true;
                                        fragment2 = t22;
                                    } else {
                                        this.f20875k0 = false;
                                        fragment2 = this.F0;
                                        ((q) fragment2).W2();
                                    }
                                    str = "monetization";
                                    fragment = fragment2;
                                } else {
                                    int itemId8 = menuItem.getItemId();
                                    t tVar9 = t.BETTING_FIFTH_BTN;
                                    if (itemId8 == tVar9.getValue()) {
                                        this.f23301t0 = tVar9;
                                        fragment = this.G0;
                                        if (fragment == null) {
                                            fragment = le.e.M.a(getIntent() != null && getIntent().getBooleanExtra("isSelectedByDefault", false));
                                            getIntent().putExtra("isSelectedByDefault", false);
                                            this.G0 = fragment;
                                            this.f20875k0 = true;
                                        } else {
                                            this.f20875k0 = false;
                                            ((le.e) fragment).s2();
                                        }
                                        if (getIntent().getBooleanExtra("shouldSendAnalEventOnBetting5thButton", true)) {
                                            ee.c.f25841a.d("betting_section", "", "", new String[0]);
                                            k.n(App.m(), "acquisition", "event", "sent", null, true, "event_type", "betting_section");
                                            z10 = true;
                                        } else {
                                            getIntent().putExtra("shouldSendAnalEventOnBetting5thButton", true);
                                            z10 = false;
                                        }
                                        z11 = z10;
                                        str = "betting";
                                        String[] c22 = c2(m22, str);
                                        str2 = c22[0];
                                        str3 = c22[1];
                                        if (z11 && !this.f23304w0) {
                                            p2(str3, str2, hashMap);
                                        }
                                        K1();
                                        return fragment;
                                    }
                                    str = "";
                                    fragment = null;
                                }
                            }
                        }
                    }
                }
            }
        }
        z11 = true;
        String[] c222 = c2(m22, str);
        str2 = c222[0];
        str3 = c222[1];
        if (z11) {
            p2(str3, str2, hashMap);
        }
        K1();
        return fragment;
    }

    @Override // com.scores365.dashboard.a.d
    public boolean y0() {
        return true;
    }

    @Override // com.scores365.Design.Activities.f
    protected void y1(MenuItem menuItem) {
        try {
            if (t2(menuItem)) {
                x1(menuItem);
            } else {
                for (Fragment fragment : getSupportFragmentManager().v0()) {
                    if (fragment instanceof xe.b) {
                        xe.b bVar = (xe.b) fragment;
                        if (menuItem.getItemId() == bVar.T1().getValue()) {
                            bVar.h2();
                        }
                    }
                }
            }
            K1();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.f
    public void z1() {
        super.z1();
        try {
            if (this.W0 == null) {
                this.W0 = (ConstraintLayout) findViewById(com.scores365.R.id.f21972e3);
            }
            if (this.X0 == null) {
                this.X0 = new ye.a(this.W0);
            }
            this.X0.k(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
