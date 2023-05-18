package com.scores365;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.appcompat.app.h;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.scores365.App;
import com.scores365.dashboard.MainDashboardActivity;
import com.scores365.entitys.AthleteObj;
import com.scores365.entitys.BaseObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GeneralNotifyObj;
import com.scores365.entitys.InitObj;
import com.scores365.entitys.NotifiedUpdateObj;
import com.scores365.entitys.TermObj;
import com.scores365.entitys.eDashboardEntityType;
import com.scores365.gameCenter.GameCenterBaseActivity;
import com.scores365.ui.ChooseThemeFragment;
import ee.b;
import ee.k;
import ee.q;
import ee.t;
import fi.d;
import fi.g;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import ki.c;
import li.e0;
import li.f;
import li.h0;
import li.l0;
import li.p0;
import li.x0;
import ne.e;
import ne.j;
import sf.b;
/* loaded from: classes2.dex */
public class App extends v0.b {
    private static boolean A;
    public static boolean B;
    private static InitObj C;
    public static long D;
    private static final t E;
    private static int F;
    private static int G;
    private static ScheduledExecutorService H;

    /* renamed from: k  reason: collision with root package name */
    private static Context f20791k;

    /* renamed from: l  reason: collision with root package name */
    public static com.scores365.a f20792l;

    /* renamed from: m  reason: collision with root package name */
    public static boolean f20793m;

    /* renamed from: n  reason: collision with root package name */
    private static String f20794n;

    /* renamed from: o  reason: collision with root package name */
    private static Hashtable<String, TermObj> f20795o;

    /* renamed from: p  reason: collision with root package name */
    public static boolean f20796p;

    /* renamed from: q  reason: collision with root package name */
    public static String f20797q;

    /* renamed from: r  reason: collision with root package name */
    public static boolean f20798r;

    /* renamed from: s  reason: collision with root package name */
    public static boolean f20799s;

    /* renamed from: t  reason: collision with root package name */
    public static boolean f20800t;

    /* renamed from: u  reason: collision with root package name */
    public static boolean f20801u;

    /* renamed from: v  reason: collision with root package name */
    public static long f20802v;

    /* renamed from: w  reason: collision with root package name */
    public static boolean f20803w;

    /* renamed from: x  reason: collision with root package name */
    public static Resources.Theme f20804x;

    /* renamed from: y  reason: collision with root package name */
    public static int f20805y;

    /* renamed from: z  reason: collision with root package name */
    private static final Object f20806z;

    /* renamed from: a  reason: collision with root package name */
    private final dg.a f20807a;

    /* renamed from: b  reason: collision with root package name */
    private final vc.b f20808b;

    /* renamed from: c  reason: collision with root package name */
    private ne.b f20809c;

    /* renamed from: d  reason: collision with root package name */
    private final qg.b f20810d;

    /* renamed from: e  reason: collision with root package name */
    private d f20811e;

    /* renamed from: f  reason: collision with root package name */
    private final uc.d f20812f;

    /* renamed from: g  reason: collision with root package name */
    private ae.a f20813g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f20814h;

    /* renamed from: i  reason: collision with root package name */
    private ge.c f20815i;

    /* renamed from: j  reason: collision with root package name */
    private vc.a f20816j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20817a;

        static {
            int[] iArr = new int[c.values().length];
            f20817a = iArr;
            try {
                iArr[c.TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20817a[c.LEAGUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20817a[c.GAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20817a[c.ATHLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: g  reason: collision with root package name */
        private static HashMap<c, SparseArray<SparseIntArray>> f20824g;

        /* renamed from: h  reason: collision with root package name */
        private static HashSet<Integer> f20825h;

        /* renamed from: i  reason: collision with root package name */
        private static HashSet<Integer> f20826i;

        /* renamed from: a  reason: collision with root package name */
        private static ConcurrentHashMap<Integer, CompObj> f20818a = new ConcurrentHashMap<>();

        /* renamed from: b  reason: collision with root package name */
        private static ConcurrentHashMap<Integer, CompetitionObj> f20819b = new ConcurrentHashMap<>();

        /* renamed from: c  reason: collision with root package name */
        private static HashSet<Integer> f20820c = new HashSet<>();

        /* renamed from: d  reason: collision with root package name */
        private static ConcurrentHashMap<Integer, AthleteObj> f20821d = new ConcurrentHashMap<>();

        /* renamed from: e  reason: collision with root package name */
        private static long f20822e = -1;

        /* renamed from: f  reason: collision with root package name */
        private static HashSet<Integer> f20823f = null;

        /* renamed from: j  reason: collision with root package name */
        private static boolean f20827j = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f20828a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ c f20829b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f20830c;

            a(int i10, c cVar, boolean z10) {
                this.f20828a = i10;
                this.f20829b = cVar;
                this.f20830c = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    sf.a.i0(App.m()).V0(this.f20828a, this.f20829b, -1, -1);
                    if (this.f20830c) {
                        x0.D2(null, null, false);
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        }

        /* renamed from: com.scores365.App$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class RunnableC0228b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            int f20831a;

            /* renamed from: b  reason: collision with root package name */
            c f20832b;

            /* renamed from: c  reason: collision with root package name */
            int f20833c;

            /* renamed from: d  reason: collision with root package name */
            int f20834d;

            public RunnableC0228b(c cVar, int i10, int i11, int i12) {
                this.f20831a = i10;
                this.f20832b = cVar;
                this.f20833c = i11;
                this.f20834d = i12;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    sf.a.i0(App.m()).w1(this.f20831a, this.f20832b, -1);
                    sf.a.i0(App.m()).w1(this.f20831a, this.f20832b, this.f20833c);
                    sf.a.i0(App.m()).V0(this.f20831a, this.f20832b, this.f20833c, this.f20834d);
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        }

        /* loaded from: classes2.dex */
        private static class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            int f20835a;

            public c(int i10) {
                this.f20835a = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                sf.a.i0(App.m()).u(this.f20835a);
            }
        }

        /* loaded from: classes2.dex */
        private static class d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            int f20836a;

            public d(int i10) {
                this.f20836a = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                sf.a.i0(App.m()).v(this.f20836a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class e implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            Vector<GeneralNotifyObj> f20837a;

            /* renamed from: b  reason: collision with root package name */
            c f20838b;

            /* renamed from: c  reason: collision with root package name */
            int f20839c;

            /* renamed from: d  reason: collision with root package name */
            boolean f20840d;

            public e(Vector<GeneralNotifyObj> vector, c cVar, int i10, boolean z10) {
                this.f20837a = vector;
                this.f20838b = cVar;
                this.f20839c = i10;
                this.f20840d = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    sf.a.i0(App.m()).b1(this.f20837a, this.f20838b, this.f20839c);
                    if (this.f20840d) {
                        new k(this.f20839c, this.f20838b).run();
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class f implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            c f20841a;

            /* renamed from: b  reason: collision with root package name */
            int f20842b;

            public f(c cVar, int i10) {
                this.f20841a = cVar;
                this.f20842b = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i10 = a.f20817a[this.f20841a.ordinal()];
                    if (i10 == 1) {
                        sf.a.i0(App.m()).I1(this.f20842b);
                    } else if (i10 == 2) {
                        sf.a.i0(App.m()).D1(this.f20842b);
                    } else if (i10 == 3) {
                        sf.a.i0(App.m()).A1(this.f20842b);
                        sf.b.X1().V1().remove(Integer.valueOf(this.f20842b));
                        sf.b.X1().y5();
                    } else if (i10 == 4) {
                        sf.a.i0(App.m()).H1(this.f20842b);
                        sf.a.i0(App.m()).t1(this.f20842b);
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class g implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            int f20843a;

            /* renamed from: b  reason: collision with root package name */
            c f20844b;

            /* renamed from: c  reason: collision with root package name */
            int f20845c;

            /* renamed from: d  reason: collision with root package name */
            boolean f20846d = true;

            public g(c cVar, int i10) {
                this.f20843a = i10;
                this.f20844b = cVar;
            }

            public g(c cVar, int i10, int i11) {
                this.f20843a = i10;
                this.f20844b = cVar;
                this.f20845c = i11;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (this.f20846d) {
                        sf.a.i0(App.m()).v1(this.f20843a, this.f20844b);
                    } else {
                        sf.a.i0(App.m()).w1(this.f20843a, this.f20844b, this.f20845c);
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        }

        /* loaded from: classes2.dex */
        private static class h implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            int f20847a;

            public h(int i10) {
                this.f20847a = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                sf.a.i0(App.m()).s(this.f20847a);
            }
        }

        /* loaded from: classes2.dex */
        private static class i implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            int f20848a;

            public i(int i10) {
                this.f20848a = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                sf.a.i0(App.m()).t(this.f20848a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class j implements Runnable {
            private j() {
            }

            /* synthetic */ j(a aVar) {
                this();
            }

            @Override // java.lang.Runnable
            public void run() {
                b.x();
            }
        }

        /* loaded from: classes2.dex */
        private static class k implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            private int f20849a;

            /* renamed from: b  reason: collision with root package name */
            private c f20850b;

            public k(int i10, c cVar) {
                this.f20849a = i10;
                this.f20850b = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    sf.a.i0(App.m()).w1(this.f20849a, this.f20850b, -1);
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        }

        public static void A() {
            try {
                sf.b.X1().B5(l().elements());
                sf.b.X1().r9(m0());
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static void B() {
            try {
                sf.b.X1().V1().clear();
                sf.b.X1().V1().addAll(f20820c);
            } catch (Exception unused) {
            }
        }

        public static boolean C(int i10, int i11, int[] iArr) {
            boolean z10 = false;
            try {
                for (Integer num : f20821d.keySet()) {
                    if (f20821d.get(num).getSportTypeId() == i10) {
                        int intValue = num.intValue();
                        c cVar = c.ATHLETE;
                        if (!d0(intValue, cVar) && sf.a.i0(App.m()).g1(num.intValue()) && !sf.a.i0(App.m()).h1(num.intValue(), i11) && (iArr == null || iArr.length == 0 || c0(iArr, num.intValue(), cVar))) {
                            sf.a.i0(App.m()).e(num.intValue(), i11, l0.h(i11).f34610c);
                            z10 = true;
                        }
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return z10;
        }

        public static boolean D(int i10, int i11, int[] iArr) {
            boolean z10 = false;
            try {
                for (Integer num : f20819b.keySet()) {
                    CompetitionObj competitionObj = f20819b.get(num);
                    if (competitionObj.getSid() == i10 && sf.a.i0(App.m()).m1(competitionObj.getID())) {
                        int id2 = competitionObj.getID();
                        c cVar = c.LEAGUE;
                        if (!d0(id2, cVar) && !sf.a.i0(App.m()).n1(num.intValue(), i11) && (iArr == null || iArr.length == 0 || c0(iArr, competitionObj.getID(), cVar))) {
                            sf.a.i0(App.m()).q(num.intValue(), i11, l0.h(i11).f34610c);
                            z10 = true;
                        }
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return z10;
        }

        public static boolean E(int i10, int i11, int[] iArr) {
            boolean z10 = false;
            try {
                for (Integer num : f20818a.keySet()) {
                    CompObj compObj = f20818a.get(num);
                    if (compObj.getSportID() == i10) {
                        int intValue = num.intValue();
                        c cVar = c.TEAM;
                        if (!d0(intValue, cVar) && sf.a.i0(App.m()).p1(num.intValue()) && !sf.a.i0(App.m()).q1(num.intValue(), i11) && (iArr == null || iArr.length == 0 || c0(iArr, compObj.getID(), cVar))) {
                            sf.a.i0(App.m()).r(num.intValue(), i11, l0.h(i11).f34610c);
                            z10 = true;
                        }
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return z10;
        }

        public static void F(int i10) {
            try {
                Iterator<Integer> it = f20820c.iterator();
                while (it.hasNext()) {
                    Integer next = it.next();
                    if (sf.a.i0(App.m()).k1(next.intValue()) && !d0(next.intValue(), c.GAME) && !sf.a.i0(App.m()).l1(next.intValue(), i10)) {
                        sf.a.i0(App.m()).o(next.intValue(), i10, l0.h(i10).f34610c);
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static void G(int i10, int i11, c cVar) {
            H(i10, i11, cVar, false);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x008d A[Catch: Exception -> 0x00c3, TryCatch #0 {Exception -> 0x00c3, blocks: (B:2:0x0000, B:4:0x0012, B:6:0x0018, B:10:0x0021, B:16:0x002e, B:18:0x0032, B:21:0x0037, B:22:0x0048, B:24:0x004e, B:26:0x005a, B:28:0x0060, B:30:0x0087, B:32:0x008d, B:33:0x0095, B:34:0x0099, B:36:0x009f, B:37:0x00b1, B:29:0x007b), top: B:42:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x009f A[Catch: Exception -> 0x00c3, LOOP:1: B:34:0x0099->B:36:0x009f, LOOP_END, TryCatch #0 {Exception -> 0x00c3, blocks: (B:2:0x0000, B:4:0x0012, B:6:0x0018, B:10:0x0021, B:16:0x002e, B:18:0x0032, B:21:0x0037, B:22:0x0048, B:24:0x004e, B:26:0x005a, B:28:0x0060, B:30:0x0087, B:32:0x008d, B:33:0x0095, B:34:0x0099, B:36:0x009f, B:37:0x00b1, B:29:0x007b), top: B:42:0x0000 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void H(int r8, int r9, com.scores365.App.c r10, boolean r11) {
            /*
                java.util.HashMap<com.scores365.App$c, android.util.SparseArray<android.util.SparseIntArray>> r0 = com.scores365.App.b.f20824g     // Catch: java.lang.Exception -> Lc3
                java.lang.Object r0 = r0.get(r10)     // Catch: java.lang.Exception -> Lc3
                android.util.SparseArray r0 = (android.util.SparseArray) r0     // Catch: java.lang.Exception -> Lc3
                java.lang.Object r1 = r0.get(r8)     // Catch: java.lang.Exception -> Lc3
                android.util.SparseIntArray r1 = (android.util.SparseIntArray) r1     // Catch: java.lang.Exception -> Lc3
                r2 = 1
                r3 = 0
                if (r11 != 0) goto L2a
                int r4 = r0.indexOfKey(r8)     // Catch: java.lang.Exception -> Lc3
                if (r4 < 0) goto L20
                int r4 = r1.size()     // Catch: java.lang.Exception -> Lc3
                if (r4 <= 0) goto L20
                r4 = 1
                goto L21
            L20:
                r4 = 0
            L21:
                boolean r5 = d0(r8, r10)     // Catch: java.lang.Exception -> Lc3
                if (r4 == 0) goto L29
                if (r5 == 0) goto L2a
            L29:
                r3 = 1
            L2a:
                if (r3 != 0) goto L2e
                if (r11 == 0) goto Lc7
            L2e:
                com.scores365.App$c r11 = com.scores365.App.c.TEAM     // Catch: java.lang.Exception -> Lc3
                if (r10 == r11) goto L7b
                com.scores365.App$c r11 = com.scores365.App.c.GAME     // Catch: java.lang.Exception -> Lc3
                if (r10 != r11) goto L37
                goto L7b
            L37:
                java.util.Vector r11 = new java.util.Vector     // Catch: java.lang.Exception -> Lc3
                r11.<init>()     // Catch: java.lang.Exception -> Lc3
                com.scores365.entitys.InitObj r3 = com.scores365.App.l()     // Catch: java.lang.Exception -> Lc3
                java.util.Vector r3 = r3.getNotifiedUpdates()     // Catch: java.lang.Exception -> Lc3
                java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Exception -> Lc3
            L48:
                boolean r4 = r3.hasNext()     // Catch: java.lang.Exception -> Lc3
                if (r4 == 0) goto L87
                java.lang.Object r4 = r3.next()     // Catch: java.lang.Exception -> Lc3
                com.scores365.entitys.NotifiedUpdateObj r4 = (com.scores365.entitys.NotifiedUpdateObj) r4     // Catch: java.lang.Exception -> Lc3
                int r5 = r4.sportTypeId()     // Catch: java.lang.Exception -> Lc3
                if (r9 != r5) goto L48
                boolean r5 = r4.isSelectedByDefForEntityType(r10)     // Catch: java.lang.Exception -> Lc3
                if (r5 == 0) goto L48
                com.scores365.entitys.GeneralNotifyObj r5 = new com.scores365.entitys.GeneralNotifyObj     // Catch: java.lang.Exception -> Lc3
                int r6 = r4.sportTypeId()     // Catch: java.lang.Exception -> Lc3
                int r7 = r4.getID()     // Catch: java.lang.Exception -> Lc3
                int r4 = r4.getID()     // Catch: java.lang.Exception -> Lc3
                li.k0 r4 = li.l0.h(r4)     // Catch: java.lang.Exception -> Lc3
                int r4 = r4.f34608a     // Catch: java.lang.Exception -> Lc3
                r5.<init>(r6, r7, r4)     // Catch: java.lang.Exception -> Lc3
                r11.add(r5)     // Catch: java.lang.Exception -> Lc3
                goto L48
            L7b:
                android.content.Context r11 = com.scores365.App.m()     // Catch: java.lang.Exception -> Lc3
                sf.a r11 = sf.a.i0(r11)     // Catch: java.lang.Exception -> Lc3
                java.util.Vector r11 = r11.S(r9)     // Catch: java.lang.Exception -> Lc3
            L87:
                int r9 = r0.indexOfKey(r8)     // Catch: java.lang.Exception -> Lc3
                if (r9 >= 0) goto L95
                android.util.SparseIntArray r9 = new android.util.SparseIntArray     // Catch: java.lang.Exception -> Lc3
                r9.<init>()     // Catch: java.lang.Exception -> Lc3
                r0.append(r8, r9)     // Catch: java.lang.Exception -> Lc3
            L95:
                java.util.Iterator r9 = r11.iterator()     // Catch: java.lang.Exception -> Lc3
            L99:
                boolean r0 = r9.hasNext()     // Catch: java.lang.Exception -> Lc3
                if (r0 == 0) goto Lb1
                java.lang.Object r0 = r9.next()     // Catch: java.lang.Exception -> Lc3
                com.scores365.entitys.GeneralNotifyObj r0 = (com.scores365.entitys.GeneralNotifyObj) r0     // Catch: java.lang.Exception -> Lc3
                int r3 = r0.getNotifyID()     // Catch: java.lang.Exception -> Lc3
                int r0 = r0.getSound()     // Catch: java.lang.Exception -> Lc3
                r1.append(r3, r0)     // Catch: java.lang.Exception -> Lc3
                goto L99
            Lb1:
                r9 = -1
                r1.delete(r9)     // Catch: java.lang.Exception -> Lc3
                java.lang.Thread r9 = new java.lang.Thread     // Catch: java.lang.Exception -> Lc3
                com.scores365.App$b$e r0 = new com.scores365.App$b$e     // Catch: java.lang.Exception -> Lc3
                r0.<init>(r11, r10, r8, r2)     // Catch: java.lang.Exception -> Lc3
                r9.<init>(r0)     // Catch: java.lang.Exception -> Lc3
                r9.start()     // Catch: java.lang.Exception -> Lc3
                goto Lc7
            Lc3:
                r8 = move-exception
                li.x0.N1(r8)
            Lc7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scores365.App.b.H(int, int, com.scores365.App$c, boolean):void");
        }

        public static void I(c cVar, int i10, int i11, int i12) {
            if (f20824g.get(cVar).indexOfKey(i10) < 0) {
                f20824g.get(cVar).append(i10, new SparseIntArray());
            }
            f20824g.get(cVar).get(i10).delete(-1);
            f20824g.get(cVar).get(i10).append(i11, i12);
            new Thread(new RunnableC0228b(cVar, i10, i11, i12)).start();
        }

        public static void J(int i10) {
            try {
                f20826i.add(Integer.valueOf(i10));
                y0();
                new Thread(new c(i10)).start();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static void K(int i10) {
            try {
                f20825h.add(Integer.valueOf(i10));
                y0();
                new Thread(new d(i10)).start();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static void L(int i10) {
            try {
                W().add(Integer.valueOf(i10));
                sf.a.i0(App.m()).B(i10, new Date());
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static int M() {
            float f10;
            int i10 = -1;
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(l());
                arrayList.addAll(i());
                SparseIntArray sparseIntArray = new SparseIntArray();
                Iterator it = arrayList.iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    BaseObj baseObj = (BaseObj) it.next();
                    int sportID = baseObj instanceof CompObj ? ((CompObj) baseObj).getSportID() : ((CompetitionObj) baseObj).getSid();
                    sparseIntArray.put(sportID, sparseIntArray.get(sportID, 0) + 1);
                    i11++;
                }
                try {
                    f10 = Float.parseFloat(p0.l0("NEW_DASHBAORD_SEARCH_BAR_PARAM"));
                    if (f10 > 1.0f) {
                        f10 /= 100.0f;
                    }
                } catch (NumberFormatException e10) {
                    x0.N1(e10);
                    f10 = 0.85f;
                }
                int i12 = (int) (i11 * f10);
                for (int i13 = 0; i13 < sparseIntArray.size(); i13++) {
                    if (sparseIntArray.valueAt(i13) > i12) {
                        i10 = sparseIntArray.keyAt(i13);
                    }
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
            return i10;
        }

        public static Vector<BaseObj> N() {
            Vector<BaseObj> vector = new Vector<>();
            try {
                for (AthleteObj athleteObj : f20821d.values()) {
                    vector.add(athleteObj);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return vector;
        }

        public static HashSet<Integer> O() {
            HashSet<Integer> hashSet = new HashSet<>();
            try {
                for (Integer num : f20821d.keySet()) {
                    hashSet.add(num);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return hashSet;
        }

        public static int P(c cVar, int i10, int i11) {
            try {
                HashMap<c, SparseArray<SparseIntArray>> hashMap = f20824g;
                if (hashMap == null || !hashMap.containsKey(cVar) || f20824g.get(cVar).indexOfKey(i10) < 0 || f20824g.get(cVar).get(i10).indexOfKey(i11) < 0) {
                    return -1;
                }
                return f20824g.get(cVar).get(i10).get(i11);
            } catch (Exception e10) {
                x0.N1(e10);
                return -1;
            }
        }

        public static Vector<Integer> Q(c cVar, int i10) {
            Vector<Integer> vector = new Vector<>();
            try {
                if (f20824g.get(cVar).indexOfKey(i10) >= 0) {
                    for (int i11 = 0; i11 < f20824g.get(cVar).get(i10).size(); i11++) {
                        vector.add(Integer.valueOf(f20824g.get(cVar).get(i10).keyAt(i11)));
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return vector;
        }

        public static HashSet<Integer> R() {
            return f20826i;
        }

        public static String S() {
            String str = "";
            try {
                for (Integer num : f20819b.keySet()) {
                    int intValue = num.intValue();
                    str = str.concat(intValue + ",");
                }
                return str.substring(0, str.length() - 1);
            } catch (Exception e10) {
                x0.N1(e10);
                return "";
            }
        }

        public static HashSet<Integer> T() {
            return f20825h;
        }

        public static String U() {
            String str = "";
            try {
                for (Integer num : f20818a.keySet()) {
                    int intValue = num.intValue();
                    str = str.concat(intValue + ",");
                }
                return str.substring(0, str.length() - 1);
            } catch (Exception e10) {
                x0.N1(e10);
                return "";
            }
        }

        public static String V() {
            String str = "";
            try {
                if (sf.b.X1().V1() == null || sf.b.X1().V1().size() <= 0) {
                    return "";
                }
                Iterator<Integer> it = sf.b.X1().V1().iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    str = str.concat(intValue + ",");
                }
                return str.substring(0, str.length() - 1);
            } catch (Exception e10) {
                x0.N1(e10);
                return "";
            }
        }

        public static HashSet<Integer> W() {
            try {
                if (f20823f == null) {
                    f20823f = sf.a.i0(App.m()).n0();
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return f20823f;
        }

        public static long X() {
            return f20822e;
        }

        public static String Y() {
            return sf.b.X1().j0();
        }

        public static String Z() {
            return sf.a.i0(App.m()).F0();
        }

        public static void a(int i10, Object obj, c cVar) {
            b(i10, obj, cVar, -1, true, null);
        }

        public static Set<Integer> a0(c cVar) {
            Set<Integer> keySet;
            try {
                if (cVar == c.LEAGUE) {
                    keySet = f20819b.keySet();
                } else if (cVar == c.TEAM) {
                    keySet = f20818a.keySet();
                } else if (cVar != c.ATHLETE) {
                    return null;
                } else {
                    keySet = f20821d.keySet();
                }
                return keySet;
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }

        public static void b(int i10, Object obj, c cVar, int i11, boolean z10, ArrayList<GeneralNotifyObj> arrayList) {
            int sportID;
            try {
                int i12 = a.f20817a[cVar.ordinal()];
                if (i12 == 1) {
                    CompObj compObj = (CompObj) obj;
                    sportID = compObj.getSportID();
                    if (!f20818a.containsKey(Integer.valueOf(i10))) {
                        f20818a.put(Integer.valueOf(i10), compObj);
                        y0();
                    }
                    ee.c.f25841a.b(b.C0293b.f25837a);
                } else if (i12 != 2) {
                    if (i12 == 3) {
                        f20820c.add(Integer.valueOf(i10));
                        sf.b.X1().V1().add(Integer.valueOf(i10));
                        sf.b.X1().z5();
                        sportID = obj != null ? ((GameObj) obj).getSportID() : -1;
                        y0();
                        if (z10) {
                            sf.b.X1().m3(b.e.selectedGamesCount);
                            li.i.f34566a.k();
                        }
                    } else if (i12 == 4) {
                        AthleteObj athleteObj = (AthleteObj) obj;
                        f20821d.put(Integer.valueOf(athleteObj.getID()), athleteObj);
                        if (i11 <= 0) {
                            i11 = athleteObj.getSportTypeId();
                        }
                        sf.a.i0(App.m()).d1(i10, athleteObj.getName(), i11);
                        y0();
                        sportID = i11;
                    }
                } else {
                    CompetitionObj competitionObj = (CompetitionObj) obj;
                    sportID = competitionObj.getSid();
                    if (!f20819b.containsKey(Integer.valueOf(i10))) {
                        f20819b.put(Integer.valueOf(i10), competitionObj);
                        y0();
                    }
                    ee.c.f25841a.b(b.C0293b.f25837a);
                }
                HashMap<c, SparseArray<SparseIntArray>> hashMap = f20824g;
                if (hashMap != null && hashMap.get(cVar) != null) {
                    f20824g.get(cVar).append(i10, new SparseIntArray());
                }
                if (z10) {
                    G(i10, sportID, cVar);
                } else if (arrayList == null || arrayList.isEmpty()) {
                } else {
                    if (obj instanceof GameObj) {
                        Iterator<GeneralNotifyObj> it = arrayList.iterator();
                        while (it.hasNext()) {
                            GeneralNotifyObj next = it.next();
                            sf.a.i0(App.m()).V1((GameObj) obj, next.getNotifyID(), next.getSound());
                        }
                        return;
                    }
                    Iterator<GeneralNotifyObj> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        GeneralNotifyObj next2 = it2.next();
                        sf.a.i0(App.m()).T1((BaseObj) obj, next2.getNotifyID(), next2.getSound());
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static boolean b0(int i10) {
            try {
                return f20826i.contains(Integer.valueOf(i10));
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }

        public static void c(int i10, Object obj, c cVar, ArrayList<GeneralNotifyObj> arrayList) {
            b(i10, obj, cVar, -1, false, arrayList);
        }

        private static boolean c0(int[] iArr, int i10, c cVar) {
            try {
                for (int i11 : iArr) {
                    if (cVar == c.LEAGUE) {
                        if (!sf.a.i0(App.m()).n1(i10, i11)) {
                            return false;
                        }
                    } else if (cVar == c.TEAM) {
                        if (!sf.a.i0(App.m()).q1(i10, i11)) {
                            return false;
                        }
                    } else if (cVar == c.ATHLETE && !sf.a.i0(App.m()).h1(i10, i11)) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }

        public static void d(int i10, Object obj, c cVar, boolean z10) {
            b(i10, obj, cVar, -1, z10, null);
        }

        public static boolean d0(int i10, c cVar) {
            boolean z10 = false;
            try {
                HashMap<c, SparseArray<SparseIntArray>> hashMap = f20824g;
                if (hashMap == null) {
                    z10 = sf.a.i0(App.m()).j1(i10, cVar, -1);
                } else if (hashMap.get(cVar).indexOfKey(i10) > -1 && f20824g.get(cVar).get(i10).indexOfKey(-1) > -1) {
                    z10 = true;
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return z10;
        }

        public static void e(Object obj) {
            try {
                if (obj instanceof GameObj) {
                    a(((GameObj) obj).getID(), obj, c.GAME);
                } else if (obj instanceof CompetitionObj) {
                    a(((CompetitionObj) obj).getID(), obj, c.LEAGUE);
                } else if (obj instanceof CompObj) {
                    a(((CompObj) obj).getID(), obj, c.TEAM);
                } else if (obj instanceof AthleteObj) {
                    a(((AthleteObj) obj).getID(), obj, c.ATHLETE);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static boolean e0(BaseObj baseObj) {
            boolean h02;
            try {
                if (baseObj instanceof CompObj) {
                    h02 = i0(baseObj.getID());
                } else if (!(baseObj instanceof AthleteObj)) {
                    return false;
                } else {
                    h02 = h0(baseObj.getID());
                }
                return h02;
            } catch (Exception unused) {
                return false;
            }
        }

        public static AthleteObj f(int i10) {
            AthleteObj athleteObj = null;
            try {
                for (AthleteObj athleteObj2 : f20821d.values()) {
                    if (athleteObj2.getID() == i10) {
                        athleteObj = athleteObj2;
                    }
                }
            } catch (Exception unused) {
            }
            return athleteObj;
        }

        public static boolean f0(c cVar, int i10) {
            try {
                HashMap<c, SparseArray<SparseIntArray>> hashMap = f20824g;
                if (hashMap == null || hashMap.size() <= 0 || f20824g.get(cVar).indexOfKey(i10) < 0) {
                    return false;
                }
                return f20824g.get(cVar).get(i10).size() > 0;
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }

        public static int g() {
            try {
                return f20821d.size();
            } catch (Exception unused) {
                return 0;
            }
        }

        public static boolean g0(c cVar, int i10, int i11) {
            try {
                if (f20824g.get(cVar).indexOfKey(i10) > -1) {
                    return f20824g.get(cVar).get(i10).indexOfKey(i11) > -1;
                }
                return false;
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }

        public static CompetitionObj h(int i10) {
            CompetitionObj competitionObj = null;
            try {
                for (CompetitionObj competitionObj2 : f20819b.values()) {
                    if (competitionObj2.getID() == i10) {
                        competitionObj = competitionObj2;
                    }
                }
            } catch (Exception unused) {
            }
            return competitionObj;
        }

        public static boolean h0(int i10) {
            try {
                return f20826i.contains(Integer.valueOf(i10));
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }

        public static Vector<CompetitionObj> i() {
            Vector<CompetitionObj> vector = new Vector<>();
            try {
                for (CompetitionObj competitionObj : f20819b.values()) {
                    vector.add(competitionObj);
                }
            } catch (Exception unused) {
            }
            return vector;
        }

        public static boolean i0(int i10) {
            try {
                return f20825h.contains(Integer.valueOf(i10));
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }

        public static int j() {
            try {
                return f20819b.size();
            } catch (Exception unused) {
                return 0;
            }
        }

        public static boolean j0() {
            return f20827j;
        }

        public static CompObj k(int i10) {
            try {
                for (CompObj compObj : f20818a.values()) {
                    if (compObj.getID() == i10) {
                        return compObj;
                    }
                }
                return null;
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        }

        private static boolean k0(String str, ArrayList<Integer> arrayList) {
            try {
                String[] split = str.split(",");
                Hashtable hashtable = new Hashtable();
                for (String str2 : split) {
                    hashtable.put(Integer.valueOf(str2), Boolean.FALSE);
                }
                if (hashtable.size() == arrayList.size()) {
                    Iterator<Integer> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Integer next = it.next();
                        if (hashtable.containsKey(next)) {
                            hashtable.put(next, Boolean.TRUE);
                        }
                    }
                    for (Boolean bool : hashtable.values()) {
                        if (!bool.booleanValue()) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }

        public static Vector<CompObj> l() {
            Vector<CompObj> vector = new Vector<>();
            try {
                for (CompObj compObj : f20818a.values()) {
                    vector.add(compObj);
                }
            } catch (Exception unused) {
            }
            return vector;
        }

        public static boolean l0() {
            try {
                ArrayList arrayList = new ArrayList();
                Vector<CompetitionObj> i10 = i();
                if (i10.isEmpty()) {
                    return true;
                }
                Iterator<CompetitionObj> it = i10.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(it.next().getID()));
                }
                String l02 = p0.l0("DEFAULT_COMPETITIONS_" + sf.a.i0(App.m()).j0());
                if (l02.isEmpty()) {
                    l02 = p0.l0("DEFAULT_COMPETITIONS");
                }
                return k0(l02, arrayList);
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }

        public static Vector<Integer> m() {
            Vector<Integer> vector = new Vector<>();
            try {
                Iterator<Integer> it = sf.b.X1().V1().iterator();
                while (it.hasNext()) {
                    Integer next = it.next();
                    if (!vector.contains(next)) {
                        vector.add(next);
                    }
                }
            } catch (Exception unused) {
            }
            return vector;
        }

        public static boolean m0() {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<CompObj> it = l().iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(it.next().getID()));
                }
                String l02 = p0.l0("DEFAULT_COMPETITORS_" + sf.a.i0(App.m()).j0());
                if (l02.isEmpty()) {
                    l02 = p0.l0("DEFAULT_COMPETITORS");
                }
                return k0(l02, arrayList);
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }

        public static int n() {
            try {
                return f20819b.size();
            } catch (Exception unused) {
                return -1;
            }
        }

        public static void n0() {
            try {
                ConcurrentHashMap<Integer, AthleteObj> concurrentHashMap = new ConcurrentHashMap<>();
                f20821d = concurrentHashMap;
                concurrentHashMap.putAll(sf.a.i0(App.m()).D0());
                f20824g.put(c.ATHLETE, sf.a.i0(App.m()).U());
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static int o() {
            try {
                return f20818a.size();
            } catch (Exception unused) {
                return -1;
            }
        }

        public static void o0() {
            try {
                HashSet<Integer> hashSet = new HashSet<>();
                f20820c = hashSet;
                hashSet.addAll(sf.b.X1().V1());
                f20824g.put(c.GAME, sf.a.i0(App.m()).q0());
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static int p() {
            try {
                return f20818a.size();
            } catch (Exception unused) {
                return 0;
            }
        }

        public static void p0(int i10, c cVar) {
            q0(i10, cVar, true);
        }

        public static void q() {
            t();
        }

        public static void q0(int i10, c cVar, boolean z10) {
            try {
                HashMap<c, SparseArray<SparseIntArray>> hashMap = f20824g;
                if (hashMap != null) {
                    if (hashMap.get(cVar).indexOfKey(i10) < 0) {
                        f20824g.get(cVar).append(i10, new SparseIntArray());
                    }
                    f20824g.get(cVar).get(i10).clear();
                    f20824g.get(cVar).get(i10).append(-1, -1);
                }
                new Thread(new a(i10, cVar, z10)).start();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static boolean r(int i10, c cVar) {
            boolean containsKey;
            try {
                int i11 = a.f20817a[cVar.ordinal()];
                if (i11 == 1) {
                    containsKey = f20818a.containsKey(Integer.valueOf(i10));
                } else if (i11 == 2) {
                    containsKey = f20819b.containsKey(Integer.valueOf(i10));
                } else if (i11 == 3) {
                    containsKey = f20820c.contains(Integer.valueOf(i10));
                } else if (i11 != 4) {
                    return false;
                } else {
                    containsKey = f20821d.containsKey(Integer.valueOf(i10));
                }
                return containsKey;
            } catch (Exception unused) {
                return false;
            }
        }

        public static void r0(c cVar, int i10, int i11) {
            try {
                if (f20824g.get(cVar).indexOfKey(i10) >= 0) {
                    f20824g.get(cVar).get(i10).delete(i11);
                }
                new Thread(new g(cVar, i10, i11)).start();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static boolean s(Object obj) {
            boolean r10;
            try {
                if (obj instanceof CompetitionObj) {
                    r10 = r(((CompetitionObj) obj).getID(), c.LEAGUE);
                } else if (obj instanceof CompObj) {
                    r10 = r(((CompObj) obj).getID(), c.TEAM);
                } else if (obj instanceof GameObj) {
                    r10 = r(((GameObj) obj).getID(), c.GAME);
                } else if (!(obj instanceof AthleteObj)) {
                    return false;
                } else {
                    r10 = r(((AthleteObj) obj).getID(), c.ATHLETE);
                }
                return r10;
            } catch (Exception unused) {
                return false;
            }
        }

        public static void s0(c cVar, int i10) {
            try {
                f20824g.get(cVar).delete(i10);
                new Thread(new g(cVar, i10)).start();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static void t() {
            try {
                f20818a = new ConcurrentHashMap<>();
                f20819b = new ConcurrentHashMap<>();
                f20824g = new HashMap<>();
                f20825h = new HashSet<>();
                f20826i = new HashSet<>();
                f20824g.put(c.LEAGUE, sf.a.i0(App.m()).w0());
                for (CompetitionObj competitionObj : sf.b.X1().Y2(true).values()) {
                    f20819b.put(Integer.valueOf(competitionObj.getID()), competitionObj);
                }
                f20824g.put(c.TEAM, sf.a.i0(App.m()).N0());
                for (CompObj compObj : sf.b.X1().a3(true).values()) {
                    f20818a.put(Integer.valueOf(compObj.getID()), compObj);
                }
                o0();
                n0();
                sf.a.i0(App.m()).R0();
                f20825h.addAll(sf.a.i0(App.m()).c());
                f20826i.addAll(sf.a.i0(App.m()).b());
                f20827j = true;
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static void t0(Object obj) {
            try {
                if (obj instanceof GameObj) {
                    s0(c.GAME, ((GameObj) obj).getID());
                } else if (obj instanceof CompObj) {
                    s0(c.TEAM, ((CompObj) obj).getID());
                } else if (obj instanceof CompetitionObj) {
                    s0(c.LEAGUE, ((CompetitionObj) obj).getID());
                } else if (obj instanceof AthleteObj) {
                    s0(c.ATHLETE, ((AthleteObj) obj).getID());
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static void u(int i10, c cVar) {
            try {
                int i11 = a.f20817a[cVar.ordinal()];
                if (i11 != 1) {
                    if (i11 != 2) {
                        if (i11 != 3) {
                            if (i11 == 4 && f20821d.containsKey(Integer.valueOf(i10))) {
                                f20821d.remove(Integer.valueOf(i10));
                                y0();
                            }
                        } else if (f20820c.contains(Integer.valueOf(i10))) {
                            f20820c.remove(Integer.valueOf(i10));
                            y0();
                        }
                    } else if (f20819b.containsKey(Integer.valueOf(i10))) {
                        f20819b.remove(Integer.valueOf(i10));
                        y0();
                    }
                } else if (f20818a.containsKey(Integer.valueOf(i10))) {
                    f20818a.remove(Integer.valueOf(i10));
                    y0();
                }
                if (f20824g.get(cVar) != null) {
                    f20824g.get(cVar).remove(i10);
                }
                new Thread(new f(cVar, i10)).start();
            } catch (Exception unused) {
            }
        }

        public static void u0(int i10) {
            try {
                f20826i.remove(Integer.valueOf(i10));
                y0();
                new Thread(new h(i10)).start();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static void v(Object obj) {
            try {
                if (obj instanceof GameObj) {
                    u(((GameObj) obj).getID(), c.GAME);
                } else if (obj instanceof CompetitionObj) {
                    u(((CompetitionObj) obj).getID(), c.LEAGUE);
                } else if (obj instanceof CompObj) {
                    u(((CompObj) obj).getID(), c.TEAM);
                } else if (obj instanceof AthleteObj) {
                    u(((AthleteObj) obj).getID(), c.ATHLETE);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static void v0(int i10) {
            try {
                f20825h.remove(Integer.valueOf(i10));
                y0();
                new Thread(new i(i10)).start();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static void w() {
            try {
                sf.a.i0(App.m()).e1(new Vector<>(f20821d.values()));
            } catch (Exception unused) {
            }
        }

        public static void w0(int i10) {
            try {
                if (W().remove(Integer.valueOf(i10))) {
                    sf.a.i0(App.m()).z1(i10);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static void x() {
            try {
                A();
                z();
                B();
                w();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static void x0(LinkedHashMap<Integer, NotifiedUpdateObj> linkedHashMap) {
            try {
                if (sf.b.X1().q4()) {
                    return;
                }
                if (linkedHashMap != null) {
                    if (f20824g == null) {
                        q();
                    }
                    for (NotifiedUpdateObj notifiedUpdateObj : linkedHashMap.values()) {
                        if (!notifiedUpdateObj.getIsDisplayed()) {
                            for (Integer num : f20818a.keySet()) {
                                c cVar = c.TEAM;
                                if (g0(cVar, num.intValue(), notifiedUpdateObj.getID())) {
                                    r0(cVar, num.intValue(), notifiedUpdateObj.getID());
                                }
                            }
                            for (Integer num2 : f20819b.keySet()) {
                                c cVar2 = c.LEAGUE;
                                if (g0(cVar2, num2.intValue(), notifiedUpdateObj.getID())) {
                                    r0(cVar2, num2.intValue(), notifiedUpdateObj.getID());
                                }
                            }
                            for (Integer num3 : f20821d.keySet()) {
                                c cVar3 = c.ATHLETE;
                                if (g0(cVar3, num3.intValue(), notifiedUpdateObj.getID())) {
                                    r0(cVar3, num3.intValue(), notifiedUpdateObj.getID());
                                }
                            }
                        }
                    }
                }
                sf.b.X1().U7();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static void y() {
            try {
                new Thread(new j(null)).start();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public static void y0() {
            f20822e = System.currentTimeMillis();
        }

        public static void z() {
            try {
                sf.b.X1().A5(i().elements());
                sf.b.X1().q9(l0());
            } catch (Exception unused) {
            }
        }

        public static void z0(int i10, c cVar) {
            try {
                HashMap<c, SparseArray<SparseIntArray>> hashMap = f20824g;
                if (hashMap != null) {
                    hashMap.get(cVar).get(i10).delete(-1);
                }
                new Thread(new k(i10, cVar)).start();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum c {
        LEAGUE(1),
        TEAM(2),
        GAME(3),
        ATHLETE(5);
        
        private final int value;

        c(int i10) {
            this.value = i10;
        }

        public static c Create(int i10) {
            if (i10 == 1) {
                return LEAGUE;
            }
            if (i10 == 2) {
                return TEAM;
            }
            if (i10 == 3) {
                return GAME;
            }
            if (i10 == 5) {
                return ATHLETE;
            }
            return null;
        }

        public static c fromEDashboardEntityType(int i10) {
            if (i10 == eDashboardEntityType.Athlete.getValue()) {
                return ATHLETE;
            }
            if (i10 == eDashboardEntityType.Competitor.getValue()) {
                return TEAM;
            }
            if (i10 == eDashboardEntityType.Competition.getValue()) {
                return LEAGUE;
            }
            return null;
        }

        public int getValue() {
            return this.value;
        }
    }

    static {
        h.I(true);
        f20791k = null;
        f20793m = false;
        f20796p = false;
        f20797q = null;
        f20798r = false;
        f20799s = true;
        f20800t = false;
        f20801u = false;
        f20802v = 0L;
        f20803w = false;
        f20805y = -1;
        f20806z = new Object();
        A = false;
        B = false;
        C = null;
        E = new t();
        F = -1;
        G = -1;
    }

    public App() {
        eg.a aVar = new eg.a(this);
        this.f20807a = aVar;
        this.f20808b = new vc.b(aVar);
        this.f20810d = new qg.b();
        this.f20812f = new uc.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(ki.b bVar) {
        if (this.f20814h) {
            FirebaseApp.initializeApp(this);
        }
        ng.b bVar2 = new ng.b();
        ng.a aVar = ng.a.f35508a;
        aVar.e(bVar2);
        final sf.b X1 = sf.b.X1();
        String F2 = X1.F2();
        bVar.q(F2);
        if (this.f20814h) {
            FirebaseMessaging.l().A(true);
            b.t();
        } else {
            if (X1.T() == ChooseThemeFragment.eThemesType.light.getValue()) {
                f20805y = R.style.f22831f;
            } else {
                f20805y = R.style.f22830e;
            }
            this.f20815i = new ge.c(this, this.f20808b);
            f.d(this, X1, F2, this.f20808b);
            this.f20815i.h();
            q.c(this);
            k.u(this);
            I(bVar, bVar2, this.f20808b);
        }
        FirebaseMessaging.l().o().addOnSuccessListener(new OnSuccessListener() { // from class: nb.d
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                App.this.z(X1, (String) obj);
            }
        });
        aVar.b("App", "app started, deviceId=" + F2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(fc.a aVar) {
        if (aVar != null) {
            H(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(ic.a aVar, vc.b bVar, final ki.b bVar2, final ng.b bVar3) {
        aVar.e().k(new c0() { // from class: nb.f
            @Override // androidx.lifecycle.c0
            public final void d(Object obj) {
                App.this.C((fc.a) obj);
            }
        });
        bVar.a().k(this.f20816j);
        LiveData<ge.d> b10 = bVar.b();
        Objects.requireNonNull(bVar2);
        b10.k(new c0() { // from class: nb.g
            @Override // androidx.lifecycle.c0
            public final void d(Object obj) {
                ki.b.this.p((ge.d) obj);
            }
        });
        LiveData<c.a> f10 = bVar2.f();
        Objects.requireNonNull(bVar3);
        f10.k(new c0() { // from class: nb.h
            @Override // androidx.lifecycle.c0
            public final void d(Object obj) {
                ng.b.this.e((c.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E() {
        InitObj l10;
        synchronized (f20806z) {
            if (!A && (l10 = l()) != null) {
                f20795o = l10.getTerms();
                A = true;
            }
        }
    }

    private void I(@NonNull final ki.b bVar, final ng.b bVar2, final vc.b bVar3) {
        final ic.a aVar = new ic.a();
        this.f20816j = new vc.a(this, aVar);
        li.c.f34483a.e().execute(new Runnable() { // from class: nb.e
            @Override // java.lang.Runnable
            public final void run() {
                App.this.D(aVar, bVar3, bVar, bVar2);
            }
        });
    }

    public static void J() {
        A = false;
        O();
    }

    public static void L() {
        try {
            sf.b X1 = sf.b.X1();
            X1.I5();
            X1.J5();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static void M(Context context) {
        f20791k = context;
    }

    public static void N(String str) {
        f20794n = str;
    }

    public static void O() {
        if (A) {
            return;
        }
        li.c.f34483a.d().execute(new Runnable() { // from class: nb.c
            @Override // java.lang.Runnable
            public final void run() {
                App.E();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public void B(@NonNull sf.b bVar) {
        if (this.f20809c == null) {
            j jVar = new j();
            e eVar = new e();
            ne.b bVar2 = new ne.b(this, bVar, eVar, new ne.d(eVar, jVar), jVar);
            this.f20809c = bVar2;
            this.f20811e = new d(bVar, bVar2, new g());
            this.f20809c.G();
        }
    }

    @NonNull
    public static String g(Map<String, Object> map, boolean z10) {
        return E.c(map);
    }

    public static String getProcessName() {
        String processName;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
            return processName;
        }
        try {
            return (String) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException(e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException(e12);
        } catch (InvocationTargetException e13) {
            throw new RuntimeException(e13);
        }
    }

    public static void h() {
        try {
            C = null;
            DisplayMetrics displayMetrics = m().getResources().getDisplayMetrics();
            F = displayMetrics.widthPixels;
            G = displayMetrics.heightPixels;
        } catch (Exception unused) {
        }
    }

    public static InitObj l() {
        if (C == null) {
            sf.a i02 = sf.a.i0(m());
            InitObj t02 = i02 == null ? null : i02.t0();
            if (t02 != null) {
                C = t02;
            }
        }
        return C;
    }

    public static Context m() {
        return f20791k;
    }

    public static int o() {
        return r() > s() ? r() : s();
    }

    public static int p() {
        return r() > s() ? s() : r();
    }

    private static int r() {
        return G;
    }

    private static int s() {
        return F;
    }

    public static String t() {
        String str = f20794n;
        if (str == null || str.equals("")) {
            String c10 = h0.c(m());
            f20794n = c10;
            N(c10);
        }
        return f20794n;
    }

    public static ScheduledExecutorService u() {
        ScheduledExecutorService scheduledExecutorService = H;
        if (scheduledExecutorService == null) {
            H = Executors.newScheduledThreadPool(4);
        } else if (scheduledExecutorService.isShutdown()) {
            H = Executors.newScheduledThreadPool(4);
        }
        return H;
    }

    public static Hashtable<String, TermObj> v() {
        Hashtable<String, TermObj> hashtable;
        try {
            hashtable = f20795o;
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (hashtable == null || hashtable.isEmpty()) {
            O();
            return f20795o;
        }
        return f20795o;
    }

    private void y(@NonNull final ki.b bVar) {
        li.c.f34483a.b().execute(new Runnable() { // from class: nb.b
            @Override // java.lang.Runnable
            public final void run() {
                App.this.A(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(sf.b bVar, String str) {
        this.f20810d.f(bVar, str);
    }

    public void F(@NonNull Activity activity) {
        final sf.b X1 = sf.b.X1();
        if (X1.b5()) {
            li.c.f34483a.f().execute(new Runnable() { // from class: nb.a
                @Override // java.lang.Runnable
                public final void run() {
                    App.this.B(X1);
                }
            });
            ae.a aVar = this.f20813g;
            if (aVar != null) {
                aVar.r(activity);
            }
        }
        f20796p = true;
        E.f();
    }

    public void G() {
        MainDashboardActivity.J2();
        this.f20812f.h();
        com.scores365.gameCenter.c cVar = GameCenterBaseActivity.f23611w1;
        if (cVar != null) {
            cVar.g();
        }
        try {
            m().unregisterReceiver(hc.a.f27760a.a());
        } catch (Exception e10) {
            x0.N1(e10);
        }
        E.e();
        f20796p = false;
        f20802v = 0L;
        k.s();
    }

    public void H(@NonNull fc.a aVar) {
        ae.a aVar2 = new ae.a(this, aVar, this.f20812f);
        this.f20813g = aVar2;
        aVar2.p();
    }

    public void K() {
        try {
            if (f20793m && sf.b.X1().G2().isEmpty()) {
                boolean z10 = !e0.m().h(this.f20808b, false);
                f20797q = "app_open";
                sf.b.X1().e9();
                Context m10 = m();
                String[] strArr = new String[6];
                strArr[0] = "install_id";
                strArr[1] = sf.b.X1().G2();
                strArr[2] = "advertising_id";
                strArr[3] = sf.b.X1().M();
                strArr[4] = "type";
                strArr[5] = z10 ? "new" : "return";
                k.n(m10, "app", "install", "show", null, false, strArr);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v0.b, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        try {
            v0.a.l(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @NonNull
    public ne.b i() {
        return this.f20809c;
    }

    @NonNull
    public vc.a j() {
        return this.f20816j;
    }

    public oc.b k() {
        ae.a aVar = this.f20813g;
        if (aVar == null) {
            return null;
        }
        return aVar.m();
    }

    @NonNull
    public uc.d n() {
        return this.f20812f;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        String processName = getProcessName();
        ng.a.f35508a.h(processName);
        D = System.currentTimeMillis();
        f20791k = getApplicationContext();
        this.f20814h = processName.equals("com.scores365:fcm");
        ki.b bVar = new ki.b();
        y(bVar);
        com.scores365.a aVar = new com.scores365.a(this.f20808b, bVar);
        f20792l = aVar;
        registerActivityLifecycleCallbacks(aVar);
    }

    @NonNull
    public vc.b q() {
        return this.f20808b;
    }

    public d w() {
        return this.f20811e;
    }

    @NonNull
    public qg.b x() {
        return this.f20810d;
    }
}
