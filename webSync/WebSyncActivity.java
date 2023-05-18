package com.scores365.webSync;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.u;
import androidx.lifecycle.v0;
import androidx.lifecycle.w0;
import androidx.lifecycle.z0;
import com.scores365.App;
import ee.k;
import hj.h;
import hj.j;
import hj.o;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.y;
import li.p0;
import li.x0;
import wj.n0;
import xi.b;
/* compiled from: WebSyncActivity.kt */
/* loaded from: classes2.dex */
public final class WebSyncActivity extends com.scores365.Design.Activities.c {
    private final String F = WebSyncActivity.class.getName();
    private final h G = new v0(y.b(aj.a.class), new e(this), new d(this), new f(null, this));
    private final h H;

    /* compiled from: WebSyncActivity.kt */
    /* loaded from: classes2.dex */
    static final class a extends n implements Function0<rf.a> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final rf.a invoke() {
            rf.a c10 = rf.a.c(WebSyncActivity.this.getLayoutInflater());
            m.f(c10, "inflate(layoutInflater)");
            return c10;
        }
    }

    /* compiled from: WebSyncActivity.kt */
    @kotlin.coroutines.jvm.internal.f(c = "com.scores365.webSync.WebSyncActivity$onCreate$1", f = "WebSyncActivity.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes2.dex */
    static final class b extends l implements Function2<n0, kotlin.coroutines.d<? super Unit>, Object> {

        /* renamed from: f  reason: collision with root package name */
        int f24435f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WebSyncActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends n implements Function1<xi.b, Unit> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ WebSyncActivity f24437c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(WebSyncActivity webSyncActivity) {
                super(1);
                this.f24437c = webSyncActivity;
            }

            public final void a(xi.b bVar) {
                if (m.b(bVar, b.c.f42687a)) {
                    this.f24437c.o1();
                } else if (bVar instanceof b.d) {
                    b.d dVar = (b.d) bVar;
                    this.f24437c.m1(dVar.b(), dVar.a());
                } else if (m.b(bVar, b.a.f42685a)) {
                    this.f24437c.finish();
                } else if (m.b(bVar, b.C0659b.f42686a)) {
                    this.f24437c.i1().f37516c.setVisibility(8);
                } else if (m.b(bVar, b.e.f42690a)) {
                    this.f24437c.i1().f37516c.setVisibility(0);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(xi.b bVar) {
                a(bVar);
                return Unit.f33377a;
            }
        }

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
            if (this.f24435f == 0) {
                o.b(obj);
                LiveData<xi.b> W1 = WebSyncActivity.this.k1().W1();
                WebSyncActivity webSyncActivity = WebSyncActivity.this;
                W1.j(webSyncActivity, new c(new a(webSyncActivity)));
                return Unit.f33377a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebSyncActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements c0, g {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f24438a;

        c(Function1 function) {
            m.g(function, "function");
            this.f24438a = function;
        }

        @Override // kotlin.jvm.internal.g
        public final hj.c<?> a() {
            return this.f24438a;
        }

        @Override // androidx.lifecycle.c0
        public final /* synthetic */ void d(Object obj) {
            this.f24438a.invoke(obj);
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof g)) {
                return m.b(a(), ((g) obj).a());
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
        final /* synthetic */ ComponentActivity f24439c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f24439c = componentActivity;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final w0.b invoke() {
            w0.b defaultViewModelProviderFactory = this.f24439c.getDefaultViewModelProviderFactory();
            m.f(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    /* loaded from: classes2.dex */
    public static final class e extends n implements Function0<z0> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f24440c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f24440c = componentActivity;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final z0 invoke() {
            z0 viewModelStore = this.f24440c.getViewModelStore();
            m.f(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    /* loaded from: classes2.dex */
    public static final class f extends n implements Function0<s0.a> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Function0 f24441c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f24442d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Function0 function0, ComponentActivity componentActivity) {
            super(0);
            this.f24441c = function0;
            this.f24442d = componentActivity;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final s0.a invoke() {
            s0.a aVar;
            Function0 function0 = this.f24441c;
            if (function0 == null || (aVar = (s0.a) function0.invoke()) == null) {
                s0.a defaultViewModelCreationExtras = this.f24442d.getDefaultViewModelCreationExtras();
                m.f(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
            return aVar;
        }
    }

    public WebSyncActivity() {
        h b10;
        b10 = j.b(new a());
        this.H = b10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rf.a i1() {
        return (rf.a) this.H.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final aj.a k1() {
        return (aj.a) this.G.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1(com.scores365.Design.Pages.a aVar, boolean z10) {
        li.n nVar = li.n.f34628a;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        m.f(supportFragmentManager, "supportFragmentManager");
        nVar.a(supportFragmentManager, aVar, i1().f37517d, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1() {
        k1().c2(zi.a.EXPORT, false);
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        String l02 = p0.l0(zi.b.f44159a.a());
        m.f(l02, "getTerm(WebSyncUtil.back_term)");
        return l02;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i1().getRoot());
        this.toolbar = i1().f37515b;
        initActionBar();
        u.a(this).b(new b(null));
        k1().b2();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        m.g(item, "item");
        if (item.getItemId() == 16908332) {
            try {
                onBackPressed();
                if (k1().Z1() == zi.a.EXPORT) {
                    k.q(App.m(), "app", "selections-sync", "click", true, "click_type", "back");
                    return true;
                }
                return true;
            } catch (Exception e10) {
                onBackPressed();
                x0.N1(e10);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
