package com.scores365.gameCenter;

import com.scores365.ui.OddsView;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ImprovedWWWAbcdeTestingMgr.kt */
/* loaded from: classes2.dex */
public final class n0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f24018a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private static int f24019b = -1;

    /* compiled from: ImprovedWWWAbcdeTestingMgr.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int a() {
            int i10 = 3;
            try {
                if (OddsView.shouldShowBetNowBtn()) {
                    int I1 = li.x0.I1(li.p0.l0("PREDICTIONS_AB_PERMITED_GEO"));
                    if (I1 != 1) {
                        if (I1 == 2) {
                            i10 = 1;
                        } else if (I1 == 3) {
                            i10 = 2;
                        }
                    }
                    i10 = 0;
                } else if (!li.x0.J1("PREDICTIONS_AB_NON_PERMITED_GEO")) {
                    i10 = 4;
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
            return i10;
        }

        public final String b() {
            int i10 = 0;
            try {
                int c10 = c();
                if (c10 != 0) {
                    if (c10 == 1) {
                        i10 = 2;
                    } else if (c10 == 2 || (c10 != 3 && c10 == 4)) {
                        i10 = 1;
                    }
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
            return String.valueOf(i10);
        }

        public final int c() {
            if (n0.f24019b == -1) {
                n0.f24019b = a();
            }
            return n0.f24019b;
        }

        public final boolean d() {
            return c() == 1;
        }

        public final boolean e() {
            return c() == 4;
        }

        public final boolean f() {
            try {
                int c10 = c();
                return c10 == 0 || c10 == 3;
            } catch (Exception e10) {
                li.x0.N1(e10);
                return true;
            }
        }
    }
}
