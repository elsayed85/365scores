package com.scores365.onboarding;

import ah.a;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.e1;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.c0;
import androidx.lifecycle.u;
import androidx.lifecycle.v0;
import androidx.lifecycle.w0;
import androidx.lifecycle.z0;
import ci.b;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.login.widget.LoginButton;
import com.google.android.material.snackbar.Snackbar;
import com.scores365.App;
import com.scores365.R;
import com.scores365.onboarding.OnBoardingActivity;
import com.scores365.ui.AskBeforeExit;
import com.scores365.ui.ChooseThemeFragment;
import com.scores365.ui.SyncOldConfigurationActivity;
import dh.a;
import ee.k;
import hj.o;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.y;
import li.e0;
import li.o0;
import li.p0;
import li.x0;
import nb.v;
import oh.b;
import wg.a;
import wj.d1;
import wj.n0;
/* compiled from: OnBoardingActivity.kt */
/* loaded from: classes2.dex */
public final class OnBoardingActivity extends com.scores365.Design.Activities.d implements a.C0281a.InterfaceC0282a, b.a.e {
    private FrameLayout H;
    private View I;

    /* renamed from: b0  reason: collision with root package name */
    private View f24149b0;

    /* renamed from: f0  reason: collision with root package name */
    private TextView f24150f0;

    /* renamed from: g0  reason: collision with root package name */
    private TextView f24151g0;

    /* renamed from: h0  reason: collision with root package name */
    private TextView f24152h0;

    /* renamed from: i0  reason: collision with root package name */
    private ImageView f24153i0;

    /* renamed from: j0  reason: collision with root package name */
    private ImageView f24154j0;

    /* renamed from: k0  reason: collision with root package name */
    private ConstraintLayout f24155k0;

    /* renamed from: l0  reason: collision with root package name */
    private boolean f24156l0;

    /* renamed from: m0  reason: collision with root package name */
    private boolean f24157m0;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f24158n0;

    /* renamed from: t0  reason: collision with root package name */
    private ci.b f24164t0;

    /* renamed from: u0  reason: collision with root package name */
    private boolean f24165u0;
    private final String F = OnBoardingActivity.class.getName();
    private final hj.h G = new v0(y.b(rh.a.class), new i(this), new h(this), new j(null, this));

    /* renamed from: o0  reason: collision with root package name */
    private final String f24159o0 = "TUTORIAL_NEXT_BUTTON";

    /* renamed from: p0  reason: collision with root package name */
    private final String f24160p0 = "BACK";

    /* renamed from: q0  reason: collision with root package name */
    private final String f24161q0 = "FINISH_SETTINGS";

    /* renamed from: r0  reason: collision with root package name */
    private final String f24162r0 = "WELCOME_SCREEN_LEAGUE_COUNT";

    /* renamed from: s0  reason: collision with root package name */
    private final String f24163s0 = "WELCOME_SCREEN_TEAM_COUNT";

    /* compiled from: OnBoardingActivity.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24166a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f24167b;

        static {
            int[] iArr = new int[a.b.values().length];
            try {
                iArr[a.b.LEAGUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.b.TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f24166a = iArr;
            int[] iArr2 = new int[oh.b.values().length];
            try {
                iArr2[oh.b.SignIn.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[oh.b.Leagues.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[oh.b.Teams.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[oh.b.FavTeams.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[oh.b.Splash.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[oh.b.GDPR.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            f24167b = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnBoardingActivity.kt */
    @kotlin.coroutines.jvm.internal.f(c = "com.scores365.onboarding.OnBoardingActivity$continueNavigation$1", f = "OnBoardingActivity.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes2.dex */
    public static final class b extends l implements Function2<n0, kotlin.coroutines.d<? super Unit>, Object> {

        /* renamed from: f  reason: collision with root package name */
        int f24168f;

        b(kotlin.coroutines.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final kotlin.coroutines.d<Unit> create(Object obj, kotlin.coroutines.d<?> dVar) {
            return new b(dVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, kotlin.coroutines.d<? super Unit> dVar) {
            return ((b) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kj.d.d();
            if (this.f24168f == 0) {
                o.b(obj);
                OnBoardingActivity.this.hidePreLoader();
                OnBoardingActivity.this.s1();
                return Unit.f33377a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnBoardingActivity.kt */
    @kotlin.coroutines.jvm.internal.f(c = "com.scores365.onboarding.OnBoardingActivity$onBackPressed$1", f = "OnBoardingActivity.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes2.dex */
    public static final class c extends l implements Function2<n0, kotlin.coroutines.d<? super Unit>, Object> {

        /* renamed from: f  reason: collision with root package name */
        int f24170f;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ oh.b f24172h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(oh.b bVar, kotlin.coroutines.d<? super c> dVar) {
            super(2, dVar);
            this.f24172h = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final kotlin.coroutines.d<Unit> create(Object obj, kotlin.coroutines.d<?> dVar) {
            return new c(this.f24172h, dVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, kotlin.coroutines.d<? super Unit> dVar) {
            return ((c) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kj.d.d();
            if (this.f24170f == 0) {
                o.b(obj);
                OnBoardingActivity.this.r1().h2(this.f24172h, false);
                return Unit.f33377a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnBoardingActivity.kt */
    @kotlin.coroutines.jvm.internal.f(c = "com.scores365.onboarding.OnBoardingActivity$onBackPressed$2", f = "OnBoardingActivity.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes2.dex */
    public static final class d extends l implements Function2<n0, kotlin.coroutines.d<? super Unit>, Object> {

        /* renamed from: f  reason: collision with root package name */
        int f24173f;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ oh.b f24175h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(oh.b bVar, kotlin.coroutines.d<? super d> dVar) {
            super(2, dVar);
            this.f24175h = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final kotlin.coroutines.d<Unit> create(Object obj, kotlin.coroutines.d<?> dVar) {
            return new d(this.f24175h, dVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, kotlin.coroutines.d<? super Unit> dVar) {
            return ((d) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kj.d.d();
            if (this.f24173f == 0) {
                o.b(obj);
                OnBoardingActivity.this.r1().h2(this.f24175h, false);
                return Unit.f33377a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: OnBoardingActivity.kt */
    /* loaded from: classes2.dex */
    static final class e extends n implements Function1<oh.a, Unit> {

        /* compiled from: OnBoardingActivity.kt */
        /* loaded from: classes2.dex */
        public /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f24177a;

            static {
                int[] iArr = new int[a.b.values().length];
                try {
                    iArr[a.b.LEAGUE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.b.TEAM.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.b.FAVOURITE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f24177a = iArr;
            }
        }

        /* compiled from: OnBoardingActivity.kt */
        /* loaded from: classes2.dex */
        public static final class b implements a.C0632a.InterfaceC0633a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ OnBoardingActivity f24178a;

            b(OnBoardingActivity onBoardingActivity) {
                this.f24178a = onBoardingActivity;
            }

            @Override // wg.a.C0632a.InterfaceC0633a
            public void a() {
                try {
                    Fragment q12 = this.f24178a.q1();
                    if (q12 instanceof ah.a) {
                        ((ah.a) q12).d2();
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        }

        e() {
            super(1);
        }

        /* JADX WARN: Removed duplicated region for block: B:109:0x0270  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0223  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(oh.a r11) {
            /*
                Method dump skipped, instructions count: 874
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scores365.onboarding.OnBoardingActivity.e.a(oh.a):void");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(oh.a aVar) {
            a(aVar);
            return Unit.f33377a;
        }
    }

    /* compiled from: OnBoardingActivity.kt */
    /* loaded from: classes2.dex */
    static final class f implements c0, kotlin.jvm.internal.g {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f24179a;

        f(Function1 function) {
            m.g(function, "function");
            this.f24179a = function;
        }

        @Override // kotlin.jvm.internal.g
        public final hj.c<?> a() {
            return this.f24179a;
        }

        @Override // androidx.lifecycle.c0
        public final /* synthetic */ void d(Object obj) {
            this.f24179a.invoke(obj);
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof kotlin.jvm.internal.g)) {
                return m.b(a(), ((kotlin.jvm.internal.g) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    /* compiled from: OnBoardingActivity.kt */
    @kotlin.coroutines.jvm.internal.f(c = "com.scores365.onboarding.OnBoardingActivity$showAfterLoginScreen$1", f = "OnBoardingActivity.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes2.dex */
    static final class g extends l implements Function2<n0, kotlin.coroutines.d<? super Unit>, Object> {

        /* renamed from: f  reason: collision with root package name */
        int f24180f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ e0 f24181g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ OnBoardingActivity f24182h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f24183i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnBoardingActivity.kt */
        @kotlin.coroutines.jvm.internal.f(c = "com.scores365.onboarding.OnBoardingActivity$showAfterLoginScreen$1$1$1", f = "OnBoardingActivity.kt", l = {}, m = "invokeSuspend")
        /* loaded from: classes2.dex */
        public static final class a extends l implements Function2<n0, kotlin.coroutines.d<? super Unit>, Object> {

            /* renamed from: f  reason: collision with root package name */
            int f24184f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ boolean f24185g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ String f24186h;

            /* renamed from: i  reason: collision with root package name */
            final /* synthetic */ OnBoardingActivity f24187i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(boolean z10, String str, OnBoardingActivity onBoardingActivity, kotlin.coroutines.d<? super a> dVar) {
                super(2, dVar);
                this.f24185g = z10;
                this.f24186h = str;
                this.f24187i = onBoardingActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final kotlin.coroutines.d<Unit> create(Object obj, kotlin.coroutines.d<?> dVar) {
                return new a(this.f24185g, this.f24186h, this.f24187i, dVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(n0 n0Var, kotlin.coroutines.d<? super Unit> dVar) {
                return ((a) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kj.d.d();
                if (this.f24184f == 0) {
                    o.b(obj);
                    if (this.f24185g) {
                        k.o(App.m(), "onboarding", "synced", "", null, "network", this.f24186h, "user_id", sf.b.X1().F2());
                        OnBoardingActivity onBoardingActivity = this.f24187i;
                        SyncOldConfigurationActivity.onDataRecovered(true, onBoardingActivity, onBoardingActivity.getIntent());
                    } else {
                        this.f24187i.m1();
                    }
                    return Unit.f33377a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(e0 e0Var, OnBoardingActivity onBoardingActivity, String str, kotlin.coroutines.d<? super g> dVar) {
            super(2, dVar);
            this.f24181g = e0Var;
            this.f24182h = onBoardingActivity;
            this.f24183i = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(OnBoardingActivity onBoardingActivity, String str, boolean z10, boolean z11) {
            wj.k.d(u.a(onBoardingActivity), null, null, new a(z10, str, onBoardingActivity, null), 3, null);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final kotlin.coroutines.d<Unit> create(Object obj, kotlin.coroutines.d<?> dVar) {
            return new g(this.f24181g, this.f24182h, this.f24183i, dVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, kotlin.coroutines.d<? super Unit> dVar) {
            return ((g) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kj.d.d();
            if (this.f24180f == 0) {
                o.b(obj);
                e0 e0Var = this.f24181g;
                Application application = this.f24182h.getApplication();
                m.e(application, "null cannot be cast to non-null type com.scores365.App");
                if (e0Var.h(((App) application).q(), false)) {
                    sf.b.X1().H6("onboarding-sync");
                    e0 e0Var2 = this.f24181g;
                    final OnBoardingActivity onBoardingActivity = this.f24182h;
                    final String str = this.f24183i;
                    e0Var2.a(new e0.d() { // from class: com.scores365.onboarding.a
                        @Override // li.e0.d
                        public final void OnDataRecovery(boolean z10, boolean z11) {
                            OnBoardingActivity.g.d(OnBoardingActivity.this, str, z10, z11);
                        }
                    });
                } else {
                    this.f24182h.m1();
                }
                return Unit.f33377a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    /* loaded from: classes2.dex */
    public static final class h extends n implements Function0<w0.b> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f24188c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.f24188c = componentActivity;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final w0.b invoke() {
            w0.b defaultViewModelProviderFactory = this.f24188c.getDefaultViewModelProviderFactory();
            m.f(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    /* loaded from: classes2.dex */
    public static final class i extends n implements Function0<z0> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f24189c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.f24189c = componentActivity;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final z0 invoke() {
            z0 viewModelStore = this.f24189c.getViewModelStore();
            m.f(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    /* loaded from: classes2.dex */
    public static final class j extends n implements Function0<s0.a> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Function0 f24190c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f24191d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Function0 function0, ComponentActivity componentActivity) {
            super(0);
            this.f24190c = function0;
            this.f24191d = componentActivity;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final s0.a invoke() {
            s0.a aVar;
            Function0 function0 = this.f24190c;
            if (function0 == null || (aVar = (s0.a) function0.invoke()) == null) {
                s0.a defaultViewModelCreationExtras = this.f24191d.getDefaultViewModelCreationExtras();
                m.f(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1() {
        View view;
        this.H = (FrameLayout) findViewById(R.id.W3);
        this.I = findViewById(R.id.L6);
        this.f24149b0 = findViewById(R.id.I0);
        this.f24150f0 = (TextView) findViewById(R.id.Et);
        this.f24151g0 = (TextView) findViewById(R.id.Hu);
        this.f24152h0 = (TextView) findViewById(R.id.qv);
        this.f24155k0 = (ConstraintLayout) findViewById(R.id.f22151m3);
        this.f24153i0 = (ImageView) findViewById(R.id.f22333u8);
        this.f24154j0 = (ImageView) findViewById(R.id.Q8);
        if (x0.l1()) {
            View view2 = this.I;
            if (view2 != null) {
                view2.setLayoutDirection(1);
            }
            ImageView imageView = this.f24154j0;
            if (imageView != null) {
                imageView.setRotation(180.0f);
            }
            ImageView imageView2 = this.f24153i0;
            if (imageView2 != null) {
                imageView2.setRotation(180.0f);
            }
        } else if (x0.g1() && (view = this.I) != null) {
            view.setLayoutDirection(0);
        }
        ImageView imageView3 = this.f24153i0;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: tg.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    OnBoardingActivity.e1(OnBoardingActivity.this, view3);
                }
            });
        }
        ImageView imageView4 = this.f24154j0;
        if (imageView4 != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: tg.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    OnBoardingActivity.g1(OnBoardingActivity.this, view3);
                }
            });
        }
        TextView textView = this.f24150f0;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: tg.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    OnBoardingActivity.h1(OnBoardingActivity.this, view3);
                }
            });
            textView.setText(p0.l0(this.f24160p0));
            textView.setTypeface(o0.d(App.m()));
        }
        TextView textView2 = this.f24151g0;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: tg.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    OnBoardingActivity.i1(OnBoardingActivity.this, view3);
                }
            });
            textView2.setText(p0.l0(this.f24159o0));
            textView2.setTypeface(o0.d(App.m()));
        }
        TextView textView3 = this.f24152h0;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: tg.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    OnBoardingActivity.k1(OnBoardingActivity.this, view3);
                }
            });
        }
        View view3 = this.I;
        if (view3 == null || sf.b.X1().T() != ChooseThemeFragment.eThemesType.light.getValue()) {
            return;
        }
        view3.setBackgroundColor(Color.parseColor("#ebeff3"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(OnBoardingActivity this$0, View view) {
        m.g(this$0, "this$0");
        try {
            rh.a.o2(this$0.r1(), null, false, 1, null);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(OnBoardingActivity this$0, View view) {
        m.g(this$0, "this$0");
        this$0.s1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(OnBoardingActivity this$0, View view) {
        m.g(this$0, "this$0");
        try {
            rh.a.o2(this$0.r1(), null, false, 1, null);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(OnBoardingActivity this$0, View view) {
        m.g(this$0, "this$0");
        this$0.s1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(OnBoardingActivity this$0, View view) {
        m.g(this$0, "this$0");
        try {
            this$0.r1().p2();
            HashMap hashMap = new HashMap();
            hashMap.put("screen", this$0.r1().W1() == a.b.LEAGUE ? "leagues" : "teams");
            k.k(App.m(), "onboarding", "selection-review", "click", null, hashMap);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1() {
        wj.k.d(u.a(this), null, null, new b(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1(Activity activity) {
        try {
            sf.b.X1().P7(6);
            sf.b.X1().K9(true);
            sf.b.X1().M9(false);
            x0.C2();
            Intent x02 = x0.x0();
            x02.putExtra("isWizardFinished", true);
            activity.startActivity(x02);
            activity.finish();
            k.g();
            k.z();
            sf.b.X1().Y7(App.b.T().size());
            HashMap hashMap = new HashMap();
            hashMap.put("theme", x0.n1() ? "light" : "dark");
            hashMap.put("teams", Integer.valueOf(App.b.p()));
            hashMap.put("leagues", Integer.valueOf(App.b.j()));
            hashMap.put("favorites", Integer.valueOf(App.b.T().size()));
            k.k(App.m(), "onboarding", "finished", null, null, hashMap);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Fragment q1() {
        return getSupportFragmentManager().i0(R.id.W3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rh.a r1() {
        return (rh.a) this.G.getValue();
    }

    private final void u1(oh.b bVar, boolean z10, boolean z11) {
        String str;
        try {
            if (bVar == oh.b.SignIn || bVar == oh.b.Leagues || bVar == oh.b.Teams || bVar == oh.b.FavTeams) {
                HashMap hashMap = new HashMap();
                int i10 = a.f24167b[bVar.ordinal()];
                if (i10 != 1) {
                    String str2 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                    if (i10 == 2) {
                        hashMap.put("screen", "leagues");
                        if (App.b.j() <= 0) {
                            str2 = "0";
                        }
                        hashMap.put("has_selections", str2);
                    } else if (i10 == 3) {
                        hashMap.put("screen", "teams");
                        if (App.b.p() <= 0) {
                            str2 = "0";
                        }
                        hashMap.put("has_selections", str2);
                    } else if (i10 == 4) {
                        hashMap.put("screen", "favorite");
                        if (App.b.T().size() <= 0) {
                            str2 = "0";
                        }
                        hashMap.put("has_selections", str2);
                    }
                } else {
                    hashMap.put("screen", "connect");
                }
                if (z11) {
                    str = "next";
                } else {
                    str = "back";
                    hashMap.put("click_type", z10 ? "app" : DeviceRequestsHelper.DEVICE_INFO_DEVICE);
                }
                k.k(App.m(), "onboarding", str, "click", null, hashMap);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private final void x1() {
        try {
            a.b W1 = r1().W1();
            int i10 = W1 == null ? -1 : a.f24166a[W1.ordinal()];
            String l02 = i10 != 1 ? i10 != 2 ? p0.l0("TOAST_SELECT_FAVOURITE") : p0.l0("TOAST_SELECT_COMPETITOR") : p0.l0("TOAST_SELECT_COMPETITION");
            m.f(l02, "when (rootViewModel.curr…          }\n            }");
            View view = this.I;
            m.d(view);
            Snackbar h02 = Snackbar.h0(view, l02, 0);
            TextView textView = (TextView) h02.D().findViewById(com.google.android.material.R.id.R);
            if (textView != null) {
                m.f(textView, "findViewById<TextView>(c…erial.R.id.snackbar_text)");
                textView.setTypeface(v.m());
                textView.setTextSize(1, 14.0f);
            }
            m.f(h02, "make(footerContainer!!, …          }\n            }");
            ViewGroup.LayoutParams layoutParams = h02.D().getLayoutParams();
            m.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = p0.s(40);
            if (x0.l1()) {
                e1.I0(h02.D(), 1);
            }
            h02.U();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // dh.a.C0281a.InterfaceC0282a
    public void H0(LoginButton loginButton) {
        ci.b bVar;
        try {
            if (this.f24164t0 == null) {
                ci.b bVar2 = new ci.b();
                bVar2.o(this);
                bVar2.l(this);
                bVar2.h();
                this.f24164t0 = bVar2;
            }
            if (loginButton != null && (bVar = this.f24164t0) != null) {
                bVar.n(loginButton);
                bVar.g();
            }
            this.f24158n0 = false;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // dh.a.C0281a.InterfaceC0282a
    public void d0() {
        try {
            showPreLoader();
            ci.b bVar = this.f24164t0;
            if (bVar != null) {
                bVar.p();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // ci.b.a.e
    public void hidePreLoader() {
        ConstraintLayout constraintLayout = this.f24155k0;
        if (constraintLayout == null) {
            return;
        }
        constraintLayout.setVisibility(8);
    }

    @Override // ci.b.a.e
    public boolean isSpotImContext() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 112) {
            o1(this);
        } else if (i10 == 887) {
            if (i11 == -1) {
                this.f24157m0 = true;
                onBackPressed();
            }
        } else {
            try {
                ci.b bVar = this.f24164t0;
                if (bVar != null) {
                    m.d(intent);
                    bVar.i(i10, i11, intent);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            hidePreLoader();
            Fragment q12 = q1();
            b.a aVar = oh.b.Companion;
            m.e(q12, "null cannot be cast to non-null type com.scores365.Design.Pages.BasePage");
            oh.b b10 = aVar.b((com.scores365.Design.Pages.a) q12);
            boolean z10 = false;
            u1(b10, this.f24165u0, false);
            this.f24165u0 = false;
            if (b10 == oh.b.Splash && !this.f24157m0) {
                startActivityForResult(AskBeforeExit.getActivityIntent(false), AskBeforeExit.EXIT_ACTIVITY_CODE);
                return;
            }
            Intent intent = getIntent();
            if (intent != null && intent.getBooleanExtra("onBoardingPopupTag", false)) {
                z10 = true;
            }
            if (!z10) {
                wj.k.d(u.a(this), d1.c(), null, new d(b10, null), 2, null);
                super.onBackPressed();
                return;
            }
            if (b10 != oh.b.Leagues) {
                wj.k.d(u.a(this), d1.c(), null, new c(b10, null), 2, null);
            }
            super.onBackPressed();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22639o);
        r1().Z1().j(this, new f(new e()));
        r1().a2();
    }

    @Override // ci.b.a.e
    public void onSocialMediaConnectionFinished() {
    }

    @Override // dh.a.C0281a.InterfaceC0282a
    public void q0() {
        s1();
    }

    public final void s1() {
        try {
            if (r1().W1() != null && ((r1().W1() != a.b.LEAGUE || App.b.j() <= 0) && ((r1().W1() != a.b.TEAM || App.b.p() <= 0) && (r1().W1() != a.b.FAVOURITE || App.b.T().size() <= 0)))) {
                x1();
                Fragment q12 = q1();
                b.a aVar = oh.b.Companion;
                m.e(q12, "null cannot be cast to non-null type com.scores365.Design.Pages.BasePage");
                u1(aVar.b((com.scores365.Design.Pages.a) q12), false, true);
                return;
            }
            t1();
            if (this.f24156l0) {
                if (r1().W1() == a.b.FAVOURITE) {
                    r1().m2();
                    return;
                } else {
                    r1().b2();
                    return;
                }
            }
            Fragment q13 = q1();
            b.a aVar2 = oh.b.Companion;
            m.e(q13, "null cannot be cast to non-null type com.scores365.Design.Pages.BasePage");
            oh.b b10 = aVar2.b((com.scores365.Design.Pages.a) q13);
            u1(b10, false, true);
            r1().n2(b10, true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // ci.b.a.e
    public void setUserInfo(String str, String str2, String str3, String str4) {
    }

    @Override // ci.b.a.e
    public void showAfterLoginScreen(String socialLoginNetwork) {
        m.g(socialLoginNetwork, "socialLoginNetwork");
        if (this.f24158n0) {
            return;
        }
        this.f24158n0 = true;
        if (!m.b(oh.b.Companion.a(), b.AbstractC0503b.a.f36316a)) {
            m1();
            return;
        }
        showPreLoader();
        wj.k.d(u.a(this), d1.b(), null, new g(new e0(), this, socialLoginNetwork, null), 2, null);
    }

    public void showPreLoader() {
        ConstraintLayout constraintLayout = this.f24155k0;
        if (constraintLayout == null) {
            return;
        }
        constraintLayout.setVisibility(0);
    }

    @Override // ci.b.a.e
    public void showPreLoginScreen() {
    }

    public final void t1() {
        try {
            if (r1().W1() == a.b.LEAGUE) {
                sf.b.X1().H9(App.b.j());
            }
            if (r1().W1() == a.b.TEAM) {
                sf.b.X1().I9(App.b.p());
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public final void v1(boolean z10) {
        this.f24165u0 = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w1() {
        /*
            r14 = this;
            sf.b r0 = sf.b.X1()
            java.lang.String r0 = r0.z1()
            java.lang.String r1 = "stage"
            kotlin.jvm.internal.m.f(r0, r1)
            int r1 = r0.length()
            r2 = 0
            r3 = 1
            if (r1 <= 0) goto L17
            r1 = 1
            goto L18
        L17:
            r1 = 0
        L18:
            if (r1 == 0) goto L83
            oh.b$a r1 = oh.b.Companion
            int r0 = r1.g(r0)
            oh.b[] r1 = r1.c()
            int r4 = r1.length
            r5 = 0
            r6 = 0
        L27:
            if (r5 >= r4) goto L8b
            r7 = r1[r5]
            int r8 = r6 + 1
            if (r6 > r0) goto L7f
            rh.a r6 = r14.r1()
            com.scores365.Design.Pages.a r6 = r6.Y1(r7)
            if (r6 == 0) goto L78
            oh.b$a r9 = oh.b.Companion
            boolean r10 = r9.d(r7)
            if (r10 != 0) goto L53
            android.content.Intent r10 = r14.getIntent()
            if (r10 == 0) goto L4e
            java.lang.String r11 = "onBoardingPopupTag"
            boolean r10 = r10.getBooleanExtra(r11, r2)
            goto L4f
        L4e:
            r10 = 0
        L4f:
            if (r10 != 0) goto L53
            r10 = 1
            goto L54
        L53:
            r10 = 0
        L54:
            rh.a r11 = r14.r1()
            nh.a r11 = r11.X1()
            androidx.fragment.app.FragmentManager r12 = r14.getSupportFragmentManager()
            java.lang.String r13 = "supportFragmentManager"
            kotlin.jvm.internal.m.f(r12, r13)
            android.widget.FrameLayout r13 = r14.H
            r11.d(r12, r6, r13, r10)
            boolean r6 = r9.e(r7)
            if (r6 == 0) goto L7f
            rh.a r6 = r14.r1()
            r6.g2(r3)
            goto L7f
        L78:
            java.lang.String r6 = r14.F
            java.lang.String r7 = "page is null"
            android.util.Log.d(r6, r7)
        L7f:
            int r5 = r5 + 1
            r6 = r8
            goto L27
        L83:
            rh.a r0 = r14.r1()
            r1 = 0
            rh.a.o2(r0, r1, r3, r3, r1)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.onboarding.OnBoardingActivity.w1():void");
    }
}
