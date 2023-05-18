package com.scores365;

import android.app.Application;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.scores365.entitys.GCMNotificationObj;
import hj.o;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import wj.a0;
import wj.d1;
import wj.k;
import wj.n0;
import wj.o0;
import wj.w2;
/* compiled from: FirebaseMessageService.kt */
/* loaded from: classes2.dex */
public final class FirebaseMessageService extends FirebaseMessagingService {

    /* renamed from: g  reason: collision with root package name */
    public static final a f21063g = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f21064a = "NotificationService";

    /* renamed from: b  reason: collision with root package name */
    private final com.scores365.b f21065b = new com.scores365.b(this);

    /* renamed from: c  reason: collision with root package name */
    private final a0 f21066c;

    /* renamed from: d  reason: collision with root package name */
    private final n0 f21067d;

    /* renamed from: e  reason: collision with root package name */
    private final kotlinx.coroutines.sync.b f21068e;

    /* renamed from: f  reason: collision with root package name */
    private final LinkedList<GCMNotificationObj> f21069f;

    /* compiled from: FirebaseMessageService.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FirebaseMessageService.kt */
    @f(c = "com.scores365.FirebaseMessageService$onMessageReceived$1", f = "FirebaseMessageService.kt", l = {86}, m = "invokeSuspend")
    /* loaded from: classes2.dex */
    static final class b extends l implements Function2<n0, d<? super Unit>, Object> {

        /* renamed from: f  reason: collision with root package name */
        Object f21070f;

        /* renamed from: g  reason: collision with root package name */
        int f21071g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ RemoteMessage f21072h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ FirebaseMessageService f21073i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FirebaseMessageService.kt */
        @f(c = "com.scores365.FirebaseMessageService$onMessageReceived$1$2", f = "FirebaseMessageService.kt", l = {91}, m = "invokeSuspend")
        /* loaded from: classes2.dex */
        public static final class a extends l implements Function2<n0, d<? super Unit>, Object> {

            /* renamed from: f  reason: collision with root package name */
            int f21074f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ FirebaseMessageService f21075g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(FirebaseMessageService firebaseMessageService, d<? super a> dVar) {
                super(2, dVar);
                this.f21075g = firebaseMessageService;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final d<Unit> create(Object obj, d<?> dVar) {
                return new a(this.f21075g, dVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(n0 n0Var, d<? super Unit> dVar) {
                return ((a) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object d10;
                d10 = kj.d.d();
                int i10 = this.f21074f;
                if (i10 == 0) {
                    o.b(obj);
                    FirebaseMessageService firebaseMessageService = this.f21075g;
                    this.f21074f = 1;
                    if (firebaseMessageService.h(this) == d10) {
                        return d10;
                    }
                } else if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    o.b(obj);
                }
                return Unit.f33377a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(RemoteMessage remoteMessage, FirebaseMessageService firebaseMessageService, d<? super b> dVar) {
            super(2, dVar);
            this.f21072h = remoteMessage;
            this.f21073i = firebaseMessageService;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final d<Unit> create(Object obj, d<?> dVar) {
            return new b(this.f21072h, this.f21073i, dVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, d<? super Unit> dVar) {
            return ((b) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x006d A[Catch: all -> 0x00e7, TryCatch #0 {all -> 0x00e7, blocks: (B:6:0x0010, B:38:0x00bb, B:11:0x0020, B:13:0x0056, B:17:0x005f, B:26:0x006d, B:28:0x0092, B:30:0x0096, B:31:0x009a, B:33:0x009d, B:34:0x00a9), top: B:44:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0092 A[Catch: all -> 0x00e7, TryCatch #0 {all -> 0x00e7, blocks: (B:6:0x0010, B:38:0x00bb, B:11:0x0020, B:13:0x0056, B:17:0x005f, B:26:0x006d, B:28:0x0092, B:30:0x0096, B:31:0x009a, B:33:0x009d, B:34:0x00a9), top: B:44:0x0008 }] */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instructions count: 248
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scores365.FirebaseMessageService.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FirebaseMessageService.kt */
    @f(c = "com.scores365.FirebaseMessageService", f = "FirebaseMessageService.kt", l = {102, FacebookMediationAdapter.ERROR_REQUIRES_ACTIVITY_CONTEXT, 115, 121}, m = "sendNotifications")
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: f  reason: collision with root package name */
        Object f21076f;

        /* renamed from: g  reason: collision with root package name */
        Object f21077g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f21078h;

        /* renamed from: j  reason: collision with root package name */
        int f21080j;

        c(d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f21078h = obj;
            this.f21080j |= Integer.MIN_VALUE;
            return FirebaseMessageService.this.h(this);
        }
    }

    public FirebaseMessageService() {
        a0 b10 = w2.b(null, 1, null);
        this.f21066c = b10;
        this.f21067d = o0.a(d1.b().plus(b10));
        this.f21068e = kotlinx.coroutines.sync.d.b(false, 1, null);
        this.f21069f = new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(kotlin.coroutines.d<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.FirebaseMessageService.h(kotlin.coroutines.d):java.lang.Object");
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        m.g(remoteMessage, "remoteMessage");
        k.d(this.f21067d, d1.a(), null, new b(remoteMessage, this, null), 2, null);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        m.g(token, "token");
        super.onNewToken(token);
        ng.a.f35508a.b(this.f21064a, "got new fcm token", null);
        Application application = getApplication();
        m.e(application, "null cannot be cast to non-null type com.scores365.App");
        qg.b x10 = ((App) application).x();
        sf.b X1 = sf.b.X1();
        m.f(X1, "getSettings()");
        x10.f(X1, token);
    }
}
