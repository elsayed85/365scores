package com.scores365.dashboardEntities.dashboardScores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cc.e1;
import cc.r;
import cc.z0;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import lf.u;
import li.p0;
import li.x0;
/* compiled from: ScoresBannerAdItem.java */
/* loaded from: classes2.dex */
public class d extends i implements ef.f {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Activity f23438a;

    /* renamed from: b  reason: collision with root package name */
    private final sc.i f23439b;

    /* renamed from: c  reason: collision with root package name */
    private String f23440c;

    /* renamed from: d  reason: collision with root package name */
    private String f23441d;

    /* renamed from: e  reason: collision with root package name */
    private String f23442e;

    /* renamed from: f  reason: collision with root package name */
    private String f23443f;

    /* renamed from: g  reason: collision with root package name */
    public int f23444g;

    /* renamed from: h  reason: collision with root package name */
    public int f23445h;

    /* compiled from: ScoresBannerAdItem.java */
    /* loaded from: classes2.dex */
    public static class a extends t implements e1 {

        /* renamed from: f  reason: collision with root package name */
        z0 f23446f;

        /* renamed from: g  reason: collision with root package name */
        int f23447g;

        /* renamed from: h  reason: collision with root package name */
        private sc.i f23448h;

        public a(View view, q.e eVar) {
            super(view);
            this.f23446f = null;
        }

        @Override // cc.e1
        public ViewGroup GetBannerHolderView() {
            return (ViewGroup) ((t) this).itemView;
        }

        @Override // cc.e1
        public z0 getCurrBanner() {
            return this.f23446f;
        }

        @Override // cc.e1
        public z0 getMpuHandler() {
            return null;
        }

        @Override // cc.e1
        public sc.i getPlacement() {
            return this.f23448h;
        }

        @Override // cc.e1
        public boolean isBannerNeedToBeShown() {
            return isBannerNeedToBeVisible();
        }

        @Override // cc.e1
        public boolean isBannerNeedToBeVisible() {
            return true;
        }

        public void l() {
            try {
                z0 z0Var = this.f23446f;
                if (z0Var != null) {
                    z0Var.o();
                    this.f23446f = null;
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public void m(sc.i iVar) {
            this.f23448h = iVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x002c A[Catch: Exception -> 0x0035, TRY_LEAVE, TryCatch #0 {Exception -> 0x0035, blocks: (B:2:0x0000, B:4:0x000b, B:7:0x0012, B:9:0x0018, B:12:0x0028, B:14:0x002c, B:10:0x001d, B:11:0x0026), top: B:19:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        @Override // cc.e1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setBannerHandler(cc.z0 r4) {
            /*
                r3 = this;
                r3.f23446f = r4     // Catch: java.lang.Exception -> L35
                android.view.View r0 = r3.itemView     // Catch: java.lang.Exception -> L35
                android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()     // Catch: java.lang.Exception -> L35
                r1 = 0
                if (r4 == 0) goto L26
                sc.h r4 = r4.f10132d     // Catch: java.lang.Exception -> L35
                sc.h r2 = sc.h.FailedToLoad     // Catch: java.lang.Exception -> L35
                if (r4 != r2) goto L12
                goto L26
            L12:
                sc.i r4 = r3.f23448h     // Catch: java.lang.Exception -> L35
                sc.i r2 = sc.i.AllScores     // Catch: java.lang.Exception -> L35
                if (r4 != r2) goto L1d
                r4 = -2
                r0.height = r4     // Catch: java.lang.Exception -> L35
                r1 = 4
                goto L28
            L1d:
                r4 = 82
                int r4 = li.p0.s(r4)     // Catch: java.lang.Exception -> L35
                r0.height = r4     // Catch: java.lang.Exception -> L35
                goto L28
            L26:
                r0.height = r1     // Catch: java.lang.Exception -> L35
            L28:
                boolean r4 = r0 instanceof android.view.ViewGroup.MarginLayoutParams     // Catch: java.lang.Exception -> L35
                if (r4 == 0) goto L39
                android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0     // Catch: java.lang.Exception -> L35
                int r4 = li.p0.s(r1)     // Catch: java.lang.Exception -> L35
                r0.bottomMargin = r4     // Catch: java.lang.Exception -> L35
                goto L39
            L35:
                r4 = move-exception
                li.x0.N1(r4)
            L39:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scores365.dashboardEntities.dashboardScores.d.a.setBannerHandler(cc.z0):void");
        }

        @Override // cc.e1
        public void setMpuHandler(z0 z0Var) {
        }

        @Override // cc.e1
        public boolean showAdsForContext() {
            return true;
        }
    }

    public d(@NonNull Activity activity, sc.i iVar) {
        this.f23440c = null;
        this.f23441d = null;
        this.f23442e = null;
        this.f23443f = null;
        this.f23444g = -1;
        this.f23445h = -1;
        this.f23438a = activity;
        this.f23439b = iVar;
    }

    public d(@NonNull Activity activity, sc.i iVar, String str, String str2, String str3, int i10, int i11, String str4) {
        this.f23439b = iVar;
        this.f23440c = str;
        this.f23441d = str2;
        this.f23442e = str3;
        this.f23445h = i10;
        this.f23444g = i11;
        this.f23443f = str4;
        this.f23438a = activity;
    }

    public static t onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        try {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.N7, viewGroup, false), eVar);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // ef.f
    public int getCompetitionId() {
        return this.f23444g;
    }

    @Override // ef.f
    public int getCountryId() {
        return this.f23445h;
    }

    @Override // com.scores365.dashboardEntities.dashboardScores.i
    public long getId() {
        return 1L;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.ScoresBannerAdItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        z0 z0Var;
        try {
            a aVar = (a) e0Var;
            ViewGroup.LayoutParams layoutParams = ((t) aVar).itemView.getLayoutParams();
            if (q.isListInFling) {
                layoutParams.height = 0;
                return;
            }
            if (aVar.f23447g == this.f23444g && (z0Var = aVar.f23446f) != null) {
                aVar.setBannerHandler(z0Var);
                return;
            }
            aVar.m(this.f23439b);
            r.E(this.f23438a, aVar, this.f23439b, this.f23440c, this.f23441d, this.f23442e, this.f23443f);
            if (this.f23439b != sc.i.AllScores) {
                layoutParams.height = p0.s(82);
            } else {
                layoutParams.height = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = 0;
            }
            aVar.f23447g = this.f23444g;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
