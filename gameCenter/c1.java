package com.scores365.gameCenter;

import com.google.android.gms.common.ConnectionResult;
import com.scores365.api.t1;
import com.scores365.entitys.WinProbabilityObj;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import wj.l2;
/* compiled from: WinProbabilityLivePostMgr.kt */
/* loaded from: classes2.dex */
public final class c1 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f23726a = new a(null);

    /* compiled from: WinProbabilityLivePostMgr.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WinProbabilityLivePostMgr.kt */
        @kotlin.coroutines.jvm.internal.f(c = "com.scores365.gameCenter.WinProbabilityLivePostMgr$Companion$loadWinProbabilityData$1", f = "WinProbabilityLivePostMgr.kt", l = {ConnectionResult.API_DISABLED}, m = "invokeSuspend")
        /* renamed from: com.scores365.gameCenter.c1$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0249a extends kotlin.coroutines.jvm.internal.l implements Function2<wj.n0, kotlin.coroutines.d<? super Unit>, Object> {

            /* renamed from: f  reason: collision with root package name */
            int f23727f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ int f23728g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ b f23729h;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: WinProbabilityLivePostMgr.kt */
            @kotlin.coroutines.jvm.internal.f(c = "com.scores365.gameCenter.WinProbabilityLivePostMgr$Companion$loadWinProbabilityData$1$1", f = "WinProbabilityLivePostMgr.kt", l = {}, m = "invokeSuspend")
            /* renamed from: com.scores365.gameCenter.c1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0250a extends kotlin.coroutines.jvm.internal.l implements Function2<wj.n0, kotlin.coroutines.d<? super Unit>, Object> {

                /* renamed from: f  reason: collision with root package name */
                int f23730f;

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ b f23731g;

                /* renamed from: h  reason: collision with root package name */
                final /* synthetic */ t1 f23732h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0250a(b bVar, t1 t1Var, kotlin.coroutines.d<? super C0250a> dVar) {
                    super(2, dVar);
                    this.f23731g = bVar;
                    this.f23732h = t1Var;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final kotlin.coroutines.d<Unit> create(Object obj, kotlin.coroutines.d<?> dVar) {
                    return new C0250a(this.f23731g, this.f23732h, dVar);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(wj.n0 n0Var, kotlin.coroutines.d<? super Unit> dVar) {
                    return ((C0250a) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kj.d.d();
                    if (this.f23730f == 0) {
                        hj.o.b(obj);
                        this.f23731g.Z0(this.f23732h.a());
                        return Unit.f33377a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0249a(int i10, b bVar, kotlin.coroutines.d<? super C0249a> dVar) {
                super(2, dVar);
                this.f23728g = i10;
                this.f23729h = bVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final kotlin.coroutines.d<Unit> create(Object obj, kotlin.coroutines.d<?> dVar) {
                return new C0249a(this.f23728g, this.f23729h, dVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(wj.n0 n0Var, kotlin.coroutines.d<? super Unit> dVar) {
                return ((C0249a) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object d10;
                d10 = kj.d.d();
                int i10 = this.f23727f;
                try {
                    if (i10 == 0) {
                        hj.o.b(obj);
                        t1 t1Var = new t1(this.f23728g);
                        t1Var.call();
                        l2 c10 = wj.d1.c();
                        C0250a c0250a = new C0250a(this.f23729h, t1Var, null);
                        this.f23727f = 1;
                        if (wj.i.g(c10, c0250a, this) == d10) {
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

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(b listener, int i10) {
            kotlin.jvm.internal.m.g(listener, "listener");
            try {
                if (listener instanceof androidx.lifecycle.t) {
                    wj.k.d(androidx.lifecycle.u.a((androidx.lifecycle.t) listener), wj.d1.b(), null, new C0249a(i10, listener, null), 2, null);
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* compiled from: WinProbabilityLivePostMgr.kt */
    /* loaded from: classes2.dex */
    public interface b {
        void Z0(WinProbabilityObj winProbabilityObj);
    }
}
