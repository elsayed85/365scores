package com.scores365.gameCenter;

import android.app.Application;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.scores365.App;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.GameObj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import le.k;
import sf.b;
import wj.l2;
/* compiled from: GameCenterViewModel.kt */
/* loaded from: classes2.dex */
public final class l0 extends androidx.lifecycle.a {
    public static final a V = new a(null);
    private boolean Q;
    private GameObj R;
    private Boolean S;
    private boolean T;
    private le.a U;

    /* compiled from: GameCenterViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GameCenterViewModel.kt */
    @kotlin.coroutines.jvm.internal.f(c = "com.scores365.gameCenter.GameCenterViewModel$loadBoosts$1", f = "GameCenterViewModel.kt", l = {60}, m = "invokeSuspend")
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.coroutines.jvm.internal.l implements Function2<wj.n0, kotlin.coroutines.d<? super Unit>, Object> {

        /* renamed from: f  reason: collision with root package name */
        int f23992f;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ GameCenterBaseActivity f23994h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: GameCenterViewModel.kt */
        @kotlin.coroutines.jvm.internal.f(c = "com.scores365.gameCenter.GameCenterViewModel$loadBoosts$1$1", f = "GameCenterViewModel.kt", l = {}, m = "invokeSuspend")
        /* loaded from: classes2.dex */
        public static final class a extends kotlin.coroutines.jvm.internal.l implements Function2<wj.n0, kotlin.coroutines.d<? super Unit>, Object> {

            /* renamed from: f  reason: collision with root package name */
            int f23995f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ GameCenterBaseActivity f23996g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(GameCenterBaseActivity gameCenterBaseActivity, kotlin.coroutines.d<? super a> dVar) {
                super(2, dVar);
                this.f23996g = gameCenterBaseActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final kotlin.coroutines.d<Unit> create(Object obj, kotlin.coroutines.d<?> dVar) {
                return new a(this.f23996g, dVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(wj.n0 n0Var, kotlin.coroutines.d<? super Unit> dVar) {
                return ((a) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kj.d.d();
                if (this.f23995f == 0) {
                    hj.o.b(obj);
                    this.f23996g.k3();
                    return Unit.f33377a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(GameCenterBaseActivity gameCenterBaseActivity, kotlin.coroutines.d<? super b> dVar) {
            super(2, dVar);
            this.f23994h = gameCenterBaseActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final kotlin.coroutines.d<Unit> create(Object obj, kotlin.coroutines.d<?> dVar) {
            return new b(this.f23994h, dVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(wj.n0 n0Var, kotlin.coroutines.d<? super Unit> dVar) {
            return ((b) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object d10;
            d10 = kj.d.d();
            int i10 = this.f23992f;
            if (i10 == 0) {
                hj.o.b(obj);
                GameObj X1 = l0.this.X1();
                kotlin.jvm.internal.m.d(X1);
                com.scores365.api.g0 g0Var = new com.scores365.api.g0(X1.getID());
                g0Var.call();
                l0.this.Z1(g0Var.a());
                l2 c10 = wj.d1.c();
                a aVar = new a(this.f23994h, null);
                this.f23992f = 1;
                if (wj.i.g(c10, aVar, this) == d10) {
                    return d10;
                }
            } else if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                hj.o.b(obj);
            }
            return Unit.f33377a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(Application application) {
        super(application);
        kotlin.jvm.internal.m.g(application, "application");
    }

    public final ArrayList<com.scores365.Design.PageObjects.b> W1() {
        int r10;
        int e10;
        int b10;
        if (this.Q) {
            return new ArrayList<>(0);
        }
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        le.a aVar = this.U;
        ArrayList<BookMakerObj> a10 = aVar != null ? aVar.a() : null;
        if (a10 != null) {
            r10 = kotlin.collections.s.r(a10, 10);
            e10 = kotlin.collections.i0.e(r10);
            b10 = uj.g.b(e10, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(b10);
            for (Object obj : a10) {
                linkedHashMap.put(Integer.valueOf(((BookMakerObj) obj).getID()), obj);
            }
            le.a aVar2 = this.U;
            if (aVar2 != null) {
                aVar2.d(this.R);
            }
            arrayList.add(new yc.r(li.p0.l0("GC_BETBOOST_CARD_TITLE")));
            le.a aVar3 = this.U;
            kotlin.jvm.internal.m.d(aVar3);
            arrayList.add(new le.k(aVar3, new HashMap(linkedHashMap), k.b.GameCenter));
        }
        return arrayList;
    }

    public final GameObj X1() {
        return this.R;
    }

    public final void Y1(GameCenterBaseActivity gameCenterBaseActivity) {
        kotlin.jvm.internal.m.g(gameCenterBaseActivity, "gameCenterBaseActivity");
        if (this.T || this.R == null) {
            return;
        }
        this.T = true;
        wj.k.d(androidx.lifecycle.u0.a(this), wj.d1.b(), null, new b(gameCenterBaseActivity, null), 2, null);
    }

    public final void Z1(le.a aVar) {
        this.U = aVar;
    }

    public final void a2(GameObj gameObj) {
        this.R = gameObj;
    }

    public final void b2(boolean z10) {
        this.Q = z10;
    }

    public final boolean c2() {
        boolean n10;
        Integer g10;
        Integer g11;
        boolean s22 = li.x0.s2();
        if (this.S == null) {
            n10 = kotlin.text.u.n(li.p0.l0("GC_BETBOOST_CARD_AVAILABLE"), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, true);
            boolean z10 = !li.f.f();
            String l02 = li.p0.l0("GC_BETBOOST_CARD_MIN_SESSIONS");
            kotlin.jvm.internal.m.f(l02, "getTerm(\"GC_BETBOOST_CARD_MIN_SESSIONS\")");
            g10 = kotlin.text.t.g(l02);
            int intValue = g10 != null ? g10.intValue() : 0;
            String l03 = li.p0.l0("GC_BETBOOST_CARD_MIN_DAYS");
            kotlin.jvm.internal.m.f(l03, "getTerm(\"GC_BETBOOST_CARD_MIN_DAYS\")");
            g11 = kotlin.text.t.g(l03);
            int intValue2 = g11 != null ? g11.intValue() : 0;
            int c10 = sf.b.X1().c(b.e.SessionsCount, App.m());
            long days = TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - li.x0.f0());
            this.S = Boolean.valueOf(n10 && (z10 || (c10 >= intValue && days >= ((long) intValue2))));
            Log.d("GameCenterViewModel", "shouldShowBoostsInGC. isUserAcquired: " + z10 + " isEnabledByTerm: " + n10 + " currentSessionCount: " + c10 + " minSessions: " + intValue + " daysPastFromInstall " + days + " minDays: " + intValue2);
        }
        Log.d("GameCenterViewModel", "shouldShowBoostsInGC. showBoostsInGc: " + this.S + " isBettingAllowed: " + s22);
        return kotlin.jvm.internal.m.b(this.S, Boolean.TRUE) && s22;
    }
}
