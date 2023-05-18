package com.scores365.Design.PageObjects;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import cg.b;
import cg.c;
import cg.e;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import lf.u;
import rf.a1;
import rf.t0;
import rf.u0;
/* compiled from: BasePageViewHolderBindFactory.kt */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20907a = new a(null);

    /* compiled from: BasePageViewHolderBindFactory.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* compiled from: BasePageViewHolderBindFactory.kt */
        /* renamed from: com.scores365.Design.PageObjects.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public /* synthetic */ class C0231a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f20908a;

            static {
                int[] iArr = new int[u.values().length];
                try {
                    iArr[u.HockeyEventItem.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[u.EmptyScoringEventItem.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[u.EmptyPenaltyEventItem.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f20908a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final LayoutInflater a(ViewGroup viewGroup) {
            return LayoutInflater.from(viewGroup.getContext());
        }

        private final t b(i1.a aVar, q.e eVar) {
            if (aVar instanceof a1) {
                return new e.b((a1) aVar, eVar);
            }
            if (aVar instanceof u0) {
                return new c.a((u0) aVar, eVar);
            }
            if (aVar instanceof t0) {
                return new b.a((t0) aVar, eVar);
            }
            return null;
        }

        public final t c(ViewGroup parent, q.e eVar, u itemType) {
            m.g(parent, "parent");
            m.g(itemType, "itemType");
            int i10 = C0231a.f20908a[itemType.ordinal()];
            return b(i10 != 1 ? i10 != 2 ? i10 != 3 ? null : t0.c(a(parent), parent, false) : u0.c(a(parent), parent, false) : a1.c(a(parent), parent, false), eVar);
        }
    }
}
