package com.scores365.gameCenter;

import com.facebook.appevents.codeless.internal.Constants;
import com.scores365.api.p1;
import com.scores365.entitys.GameStatistics;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import wj.f2;
import wj.l2;
import wj.z1;
/* compiled from: StatisticsFilterRepository.kt */
/* loaded from: classes2.dex */
public final class x0 {

    /* renamed from: a  reason: collision with root package name */
    private final y0 f24090a;

    /* renamed from: b  reason: collision with root package name */
    private final wj.a0 f24091b;

    /* renamed from: c  reason: collision with root package name */
    private final hj.h f24092c;

    /* compiled from: StatisticsFilterRepository.kt */
    @kotlin.coroutines.jvm.internal.f(c = "com.scores365.gameCenter.StatisticsFilterRepository$getStatisticsByFilterPath$1", f = "StatisticsFilterRepository.kt", l = {20}, m = "invokeSuspend")
    /* loaded from: classes2.dex */
    static final class a extends kotlin.coroutines.jvm.internal.l implements Function2<wj.n0, kotlin.coroutines.d<? super Unit>, Object> {

        /* renamed from: f  reason: collision with root package name */
        int f24093f;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f24095h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: StatisticsFilterRepository.kt */
        @kotlin.coroutines.jvm.internal.f(c = "com.scores365.gameCenter.StatisticsFilterRepository$getStatisticsByFilterPath$1$1", f = "StatisticsFilterRepository.kt", l = {Constants.MAX_TREE_DEPTH}, m = "invokeSuspend")
        /* renamed from: com.scores365.gameCenter.x0$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0254a extends kotlin.coroutines.jvm.internal.l implements Function2<wj.n0, kotlin.coroutines.d<? super Unit>, Object> {

            /* renamed from: f  reason: collision with root package name */
            int f24096f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ String f24097g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ x0 f24098h;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: StatisticsFilterRepository.kt */
            @kotlin.coroutines.jvm.internal.f(c = "com.scores365.gameCenter.StatisticsFilterRepository$getStatisticsByFilterPath$1$1$1", f = "StatisticsFilterRepository.kt", l = {}, m = "invokeSuspend")
            /* renamed from: com.scores365.gameCenter.x0$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0255a extends kotlin.coroutines.jvm.internal.l implements Function2<wj.n0, kotlin.coroutines.d<? super y0>, Object> {

                /* renamed from: f  reason: collision with root package name */
                int f24099f;

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ x0 f24100g;

                /* renamed from: h  reason: collision with root package name */
                final /* synthetic */ GameStatistics f24101h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0255a(x0 x0Var, GameStatistics gameStatistics, kotlin.coroutines.d<? super C0255a> dVar) {
                    super(2, dVar);
                    this.f24100g = x0Var;
                    this.f24101h = gameStatistics;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final kotlin.coroutines.d<Unit> create(Object obj, kotlin.coroutines.d<?> dVar) {
                    return new C0255a(this.f24100g, this.f24101h, dVar);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(wj.n0 n0Var, kotlin.coroutines.d<? super y0> dVar) {
                    return ((C0255a) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kj.d.d();
                    if (this.f24099f == 0) {
                        hj.o.b(obj);
                        y0 y0Var = this.f24100g.f24090a;
                        y0Var.a(this.f24101h);
                        y0Var.g(false);
                        return y0Var;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0254a(String str, x0 x0Var, kotlin.coroutines.d<? super C0254a> dVar) {
                super(2, dVar);
                this.f24097g = str;
                this.f24098h = x0Var;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final kotlin.coroutines.d<Unit> create(Object obj, kotlin.coroutines.d<?> dVar) {
                return new C0254a(this.f24097g, this.f24098h, dVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(wj.n0 n0Var, kotlin.coroutines.d<? super Unit> dVar) {
                return ((C0254a) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object d10;
                d10 = kj.d.d();
                int i10 = this.f24096f;
                if (i10 == 0) {
                    hj.o.b(obj);
                    p1 p1Var = new p1(this.f24097g);
                    p1Var.call();
                    GameStatistics a10 = p1Var.a();
                    if ((a10 != null ? a10.getStatistics() : null) != null && (!a10.getStatistics().isEmpty())) {
                        l2 c10 = wj.d1.c();
                        C0255a c0255a = new C0255a(this.f24098h, a10, null);
                        this.f24096f = 1;
                        if (wj.i.g(c10, c0255a, this) == d10) {
                            return d10;
                        }
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
        a(String str, kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
            this.f24095h = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final kotlin.coroutines.d<Unit> create(Object obj, kotlin.coroutines.d<?> dVar) {
            return new a(this.f24095h, dVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(wj.n0 n0Var, kotlin.coroutines.d<? super Unit> dVar) {
            return ((a) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object d10;
            d10 = kj.d.d();
            int i10 = this.f24093f;
            try {
                if (i10 == 0) {
                    hj.o.b(obj);
                    x0.this.f24090a.g(true);
                    wj.j0 b10 = wj.d1.b();
                    C0254a c0254a = new C0254a(this.f24095h, x0.this, null);
                    this.f24093f = 1;
                    if (wj.i.g(b10, c0254a, this) == d10) {
                        return d10;
                    }
                } else if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    hj.o.b(obj);
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
            return Unit.f33377a;
        }
    }

    /* compiled from: StatisticsFilterRepository.kt */
    /* loaded from: classes2.dex */
    static final class b extends kotlin.jvm.internal.n implements Function0<wj.n0> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final wj.n0 invoke() {
            return wj.o0.a(wj.d1.c().plus(x0.this.f24091b));
        }
    }

    public x0(y0 statisticsFilterResult) {
        wj.a0 b10;
        hj.h b11;
        kotlin.jvm.internal.m.g(statisticsFilterResult, "statisticsFilterResult");
        this.f24090a = statisticsFilterResult;
        b10 = f2.b(null, 1, null);
        this.f24091b = b10;
        b11 = hj.j.b(new b());
        this.f24092c = b11;
    }

    private final wj.n0 d() {
        return (wj.n0) this.f24092c.getValue();
    }

    public final void c() {
        z1.a.a(this.f24091b, null, 1, null);
    }

    public final void e(String path) {
        kotlin.jvm.internal.m.g(path, "path");
        wj.k.d(d(), null, null, new a(path, null), 3, null);
    }
}
