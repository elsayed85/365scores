package com.scores365.bet365Survey;

import android.os.Bundle;
import android.view.WindowManager;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.a0;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.lifecycle.w0;
import androidx.lifecycle.z0;
import com.facebook.internal.ServerProtocol;
import com.scores365.App;
import ee.k;
import hj.h;
import je.a;
import je.j;
import je.o;
import je.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.y;
import li.x0;
import rf.g;
/* compiled from: Bet365SurveyActivity.kt */
/* loaded from: classes2.dex */
public final class Bet365SurveyActivity extends com.scores365.Design.Activities.c {
    public static final a H = new a(null);
    private static boolean I;

    /* renamed from: b0  reason: collision with root package name */
    private static boolean f23277b0;
    private g F;
    private final h G = new v0(y.b(p.class), new e(this), new d(this), new f(null, this));

    /* compiled from: Bet365SurveyActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return Bet365SurveyActivity.I;
        }

        public final boolean b() {
            return Bet365SurveyActivity.f23277b0;
        }

        public final void c(boolean z10) {
            Bet365SurveyActivity.f23277b0 = z10;
        }
    }

    /* compiled from: Bet365SurveyActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends n implements Function1<je.a, Unit> {
        b() {
            super(1);
        }

        public final void a(je.a aVar) {
            try {
                g gVar = null;
                if (m.b(aVar, a.b.f32617a)) {
                    a0 q10 = Bet365SurveyActivity.this.getSupportFragmentManager().q();
                    g gVar2 = Bet365SurveyActivity.this.F;
                    if (gVar2 == null) {
                        m.t("binding");
                    } else {
                        gVar = gVar2;
                    }
                    q10.p(gVar.f37702b.getId(), j.f32634p.a()).h();
                } else if (!m.b(aVar, a.c.f32618a)) {
                    if (m.b(aVar, a.C0388a.f32616a)) {
                        Bet365SurveyActivity.H.c(false);
                        Bet365SurveyActivity.this.finish();
                    }
                } else {
                    a0 q11 = Bet365SurveyActivity.this.getSupportFragmentManager().q();
                    g gVar3 = Bet365SurveyActivity.this.F;
                    if (gVar3 == null) {
                        m.t("binding");
                    } else {
                        gVar = gVar3;
                    }
                    q11.p(gVar.f37702b.getId(), o.f32648o.a()).h();
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(je.a aVar) {
            a(aVar);
            return Unit.f33377a;
        }
    }

    /* compiled from: Bet365SurveyActivity.kt */
    /* loaded from: classes2.dex */
    static final class c implements c0, kotlin.jvm.internal.g {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f23279a;

        c(Function1 function) {
            m.g(function, "function");
            this.f23279a = function;
        }

        @Override // kotlin.jvm.internal.g
        public final hj.c<?> a() {
            return this.f23279a;
        }

        @Override // androidx.lifecycle.c0
        public final /* synthetic */ void d(Object obj) {
            this.f23279a.invoke(obj);
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

    /* compiled from: ActivityViewModelLazy.kt */
    /* loaded from: classes2.dex */
    public static final class d extends n implements Function0<w0.b> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23280c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f23280c = componentActivity;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final w0.b invoke() {
            w0.b defaultViewModelProviderFactory = this.f23280c.getDefaultViewModelProviderFactory();
            m.f(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    /* loaded from: classes2.dex */
    public static final class e extends n implements Function0<z0> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23281c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f23281c = componentActivity;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final z0 invoke() {
            z0 viewModelStore = this.f23281c.getViewModelStore();
            m.f(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    /* loaded from: classes2.dex */
    public static final class f extends n implements Function0<s0.a> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Function0 f23282c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23283d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Function0 function0, ComponentActivity componentActivity) {
            super(0);
            this.f23282c = function0;
            this.f23283d = componentActivity;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final s0.a invoke() {
            s0.a aVar;
            Function0 function0 = this.f23282c;
            if (function0 == null || (aVar = (s0.a) function0.invoke()) == null) {
                s0.a defaultViewModelCreationExtras = this.f23283d.getDefaultViewModelCreationExtras();
                m.f(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
            return aVar;
        }
    }

    private final p i1() {
        return (p) this.G.getValue();
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g c10 = g.c(getLayoutInflater());
        m.f(c10, "inflate(layoutInflater)");
        this.F = c10;
        g gVar = null;
        if (c10 == null) {
            m.t("binding");
            c10 = null;
        }
        setContentView(c10.getRoot());
        try {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.height = (int) (App.o() * 0.93d);
            attributes.width = (int) (App.p() * 0.82d);
            attributes.dimAmount = 0.7f;
            getWindow().setAttributes(attributes);
            getWindow().addFlags(2);
            a0 q10 = getSupportFragmentManager().q();
            g gVar2 = this.F;
            if (gVar2 == null) {
                m.t("binding");
            } else {
                gVar = gVar2;
            }
            q10.p(gVar.f37702b.getId(), je.f.f32623n.a()).h();
            i1().X1().j(this, new c(new b()));
            I = true;
            k.h(App.m(), "app", "bp-feedback", ServerProtocol.DIALOG_PARAM_DISPLAY);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onPause() {
        super.onPause();
        I = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        super.onResume();
        I = true;
    }

    @Override // com.scores365.Design.Activities.c
    protected void startBet365SurveyActivity() {
    }
}
