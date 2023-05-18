package com.scores365.dashboardEntities.dashboardScores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import cc.s0;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.scores365.App;
import com.scores365.Design.Pages.SavedScrollStateRecyclerView;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import lf.d;
import lf.u;
import li.o0;
import li.p0;
import li.x0;
/* compiled from: ScoresNativeAdItem.java */
/* loaded from: classes2.dex */
public class l extends e implements ef.f {

    /* renamed from: a  reason: collision with root package name */
    protected sc.i f23508a;

    /* renamed from: b  reason: collision with root package name */
    private final sc.f f23509b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final uc.d f23510c;

    /* renamed from: d  reason: collision with root package name */
    private int f23511d;

    /* renamed from: e  reason: collision with root package name */
    private int f23512e;

    /* compiled from: ScoresNativeAdItem.java */
    /* loaded from: classes2.dex */
    public static class a extends t implements s0.a {
        private s0 A;

        /* renamed from: f  reason: collision with root package name */
        public ConstraintLayout f23513f;

        /* renamed from: g  reason: collision with root package name */
        public NativeAdView f23514g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f23515h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f23516i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f23517j;

        /* renamed from: k  reason: collision with root package name */
        private TextView f23518k;

        /* renamed from: l  reason: collision with root package name */
        public ImageView f23519l;

        /* renamed from: m  reason: collision with root package name */
        public ImageView f23520m;

        /* renamed from: n  reason: collision with root package name */
        public View f23521n;

        /* renamed from: o  reason: collision with root package name */
        public TextView f23522o;

        /* renamed from: p  reason: collision with root package name */
        public MediaView f23523p;

        /* renamed from: q  reason: collision with root package name */
        public TextView f23524q;

        /* renamed from: r  reason: collision with root package name */
        public TextView f23525r;

        /* renamed from: s  reason: collision with root package name */
        public TextView f23526s;

        /* renamed from: t  reason: collision with root package name */
        private TextView f23527t;

        /* renamed from: u  reason: collision with root package name */
        public ImageView f23528u;

        /* renamed from: v  reason: collision with root package name */
        public ImageView f23529v;

        /* renamed from: w  reason: collision with root package name */
        public View f23530w;

        /* renamed from: x  reason: collision with root package name */
        public TextView f23531x;

        /* renamed from: y  reason: collision with root package name */
        public MediaView f23532y;

        /* renamed from: z  reason: collision with root package name */
        public SavedScrollStateRecyclerView f23533z;

        public a(View view, ViewGroup viewGroup) {
            super(view);
            this.A = null;
            try {
                this.f23513f = (ConstraintLayout) view.findViewById(R.id.f22332u7);
                this.f23514g = (NativeAdView) ((t) this).itemView.findViewById(R.id.f22420y7);
                this.f23515h = (TextView) this.f23513f.findViewById(R.id.rw);
                this.f23516i = (TextView) this.f23513f.findViewById(R.id.nw);
                this.f23517j = (TextView) this.f23513f.findViewById(R.id.gy);
                this.f23518k = (TextView) this.f23513f.findViewById(R.id.mE);
                this.f23519l = (ImageView) this.f23513f.findViewById(R.id.f21933ca);
                this.f23520m = (ImageView) this.f23513f.findViewById(R.id.f21956da);
                this.f23521n = this.f23513f.findViewById(R.id.mI);
                this.f23522o = (TextView) this.f23513f.findViewById(R.id.qw);
                this.f23523p = (MediaView) this.f23513f.findViewById(R.id.Rh);
                this.f23518k.setTypeface(o0.d(App.m()));
                this.f23515h.setTypeface(o0.d(App.m()));
                this.f23516i.setTypeface(o0.b(App.m()));
                this.f23517j.setTypeface(o0.d(App.m()));
                this.f23522o.setTypeface(o0.d(App.m()));
                this.f23524q = (TextView) this.f23514g.findViewById(R.id.rw);
                this.f23525r = (TextView) this.f23514g.findViewById(R.id.nw);
                this.f23526s = (TextView) this.f23514g.findViewById(R.id.gy);
                this.f23527t = (TextView) this.f23514g.findViewById(R.id.mE);
                this.f23528u = (ImageView) this.f23514g.findViewById(R.id.f21933ca);
                this.f23529v = (ImageView) this.f23514g.findViewById(R.id.f21956da);
                this.f23530w = this.f23514g.findViewById(R.id.mI);
                this.f23531x = (TextView) this.f23514g.findViewById(R.id.qw);
                this.f23532y = (MediaView) this.f23514g.findViewById(R.id.Rh);
                this.f23527t.setTypeface(o0.d(App.m()));
                this.f23524q.setTypeface(o0.d(App.m()));
                this.f23525r.setTypeface(o0.b(App.m()));
                this.f23526s.setTypeface(o0.d(App.m()));
                this.f23531x.setTypeface(o0.d(App.m()));
                try {
                    if (Boolean.valueOf((String) cc.o0.y().q().get("NEW_NATIVE_AD_STYLE")).booleanValue()) {
                        this.f23517j.setBackground(androidx.core.content.a.getDrawable(App.m(), R.drawable.G5));
                        this.f23522o.setBackground(androidx.core.content.a.getDrawable(App.m(), R.drawable.G5));
                        this.f23521n.setBackgroundColor(p0.A(R.attr.f21559k1));
                        this.f23526s.setBackground(androidx.core.content.a.getDrawable(App.m(), R.drawable.G5));
                        this.f23531x.setBackground(androidx.core.content.a.getDrawable(App.m(), R.drawable.G5));
                        this.f23530w.setBackgroundColor(p0.A(R.attr.f21559k1));
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
                if (viewGroup instanceof SavedScrollStateRecyclerView) {
                    this.f23533z = (SavedScrollStateRecyclerView) viewGroup;
                }
                this.f23519l.setVisibility(0);
                this.f23528u.setVisibility(0);
                this.f23523p.setVisibility(8);
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }

        @Override // cc.s0.a
        public s0 h() {
            return this.A;
        }

        public void l(s0 s0Var) {
            this.A = s0Var;
        }
    }

    public l(@NonNull uc.d dVar, sc.i iVar, sc.f fVar) {
        this.f23510c = dVar;
        this.f23508a = iVar;
        this.f23509b = fVar;
    }

    public static t onCreateViewHolder(ViewGroup viewGroup) {
        return new a(x0.l1() ? LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.X7, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.W7, viewGroup, false), viewGroup);
    }

    @Override // ef.f
    public int getCompetitionId() {
        return this.f23512e;
    }

    @Override // ef.f
    public int getCountryId() {
        return this.f23511d;
    }

    @Override // com.scores365.dashboardEntities.dashboardScores.e, com.scores365.dashboardEntities.dashboardScores.i
    public long getId() {
        return 1L;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.ScoresNativeAd.ordinal();
    }

    public void l(int i10, int i11) {
        this.f23511d = i10;
        this.f23512e = i11;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        int s10;
        int s11;
        try {
            a aVar = (a) e0Var;
            s0 w10 = !q.isListInFling ? cc.o0.w(this.f23509b) : null;
            if (w10 == null) {
                ((t) aVar).itemView.getLayoutParams().height = 0;
                ((ViewGroup.MarginLayoutParams) ((t) aVar).itemView.getLayoutParams()).topMargin = 0;
                ((ViewGroup.MarginLayoutParams) ((t) aVar).itemView.getLayoutParams()).bottomMargin = 0;
                return;
            }
            aVar.l(w10);
            sc.i iVar = this.f23508a;
            sc.i iVar2 = sc.i.AllScreens;
            if (iVar == iVar2) {
                ((t) aVar).itemView.getLayoutParams().height = p0.s(64);
                ((ViewGroup.MarginLayoutParams) ((t) aVar).itemView.getLayoutParams()).topMargin = p0.s(8);
                s10 = p0.s(58);
                s11 = p0.s(67);
                aVar.f23521n.setVisibility(8);
                aVar.f23530w.setVisibility(8);
            } else {
                ((t) aVar).itemView.getLayoutParams().height = -2;
                ((ViewGroup.MarginLayoutParams) ((t) aVar).itemView.getLayoutParams()).topMargin = p0.s(8);
                s10 = p0.s(58);
                s11 = p0.s(68);
            }
            aVar.f23519l.getLayoutParams().height = s10;
            aVar.f23519l.getLayoutParams().width = s10;
            aVar.f23523p.getLayoutParams().height = s10;
            aVar.f23523p.getLayoutParams().width = s10;
            aVar.f23528u.getLayoutParams().height = s10;
            aVar.f23528u.getLayoutParams().width = s10;
            aVar.f23532y.getLayoutParams().height = s10;
            aVar.f23532y.getLayoutParams().width = s10;
            if (x0.l1()) {
                ((ViewGroup.MarginLayoutParams) aVar.f23522o.getLayoutParams()).rightMargin = s11;
                ((ViewGroup.MarginLayoutParams) aVar.f23515h.getLayoutParams()).rightMargin = s11;
                ((ViewGroup.MarginLayoutParams) aVar.f23516i.getLayoutParams()).rightMargin = s11;
                ((ViewGroup.MarginLayoutParams) aVar.f23531x.getLayoutParams()).rightMargin = s11;
                ((ViewGroup.MarginLayoutParams) aVar.f23524q.getLayoutParams()).rightMargin = s11;
                ((ViewGroup.MarginLayoutParams) aVar.f23525r.getLayoutParams()).rightMargin = s11;
            } else {
                ((ViewGroup.MarginLayoutParams) aVar.f23522o.getLayoutParams()).leftMargin = s11;
                ((ViewGroup.MarginLayoutParams) aVar.f23515h.getLayoutParams()).leftMargin = s11;
                ((ViewGroup.MarginLayoutParams) aVar.f23516i.getLayoutParams()).leftMargin = s11;
                ((ViewGroup.MarginLayoutParams) aVar.f23531x.getLayoutParams()).leftMargin = s11;
                ((ViewGroup.MarginLayoutParams) aVar.f23524q.getLayoutParams()).leftMargin = s11;
                ((ViewGroup.MarginLayoutParams) aVar.f23525r.getLayoutParams()).leftMargin = s11;
            }
            if (!w10.I()) {
                w10.w((Activity) ((t) aVar).itemView.getContext(), this.f23510c, this.f23509b);
            }
            w10.d(aVar);
            aVar.f23520m.setVisibility(8);
            aVar.f23529v.setVisibility(8);
            boolean z10 = true;
            if (!w10.B()) {
                aVar.f23515h.setText(w10.k());
                aVar.f23516i.setText(w10.j().replace('\n', ' '));
                aVar.f23517j.setText(w10.m());
                aVar.f23518k.setText(w10.s());
                aVar.f23522o.setText(p0.l0("AD_SPONSORED_TITLE"));
                aVar.f23524q.setText(w10.k());
                aVar.f23525r.setText(w10.j().replace('\n', ' '));
                aVar.f23526s.setText(w10.m());
                aVar.f23527t.setText(w10.s());
                aVar.f23531x.setText(p0.l0("AD_SPONSORED_TITLE"));
                w10.A(aVar, this.f23508a);
                w10.v(aVar, true);
            }
            aVar.f23513f.setVisibility(8);
            aVar.f23514g.setVisibility(8);
            if (!(w10 instanceof pf.b) || (w10 instanceof ec.h) || (w10 instanceof gc.b)) {
                aVar.f23513f.setVisibility(0);
                z10 = false;
            } else {
                aVar.f23514g.setVisibility(0);
                aVar.f23514g.setNativeAd(w10.L());
                aVar.f23514g.setMediaView(aVar.f23532y);
                aVar.f23514g.setCallToActionView(aVar.f23526s);
                aVar.f23519l.setOnClickListener(null);
                aVar.f23516i.setOnClickListener(null);
                aVar.f23515h.setOnClickListener(null);
                aVar.f23528u.setOnClickListener(null);
                aVar.f23525r.setOnClickListener(null);
                aVar.f23524q.setOnClickListener(null);
            }
            if (!z10 && w10.H()) {
                ((t) aVar).itemView.setOnClickListener(new d.a(w10, this.f23508a));
                aVar.f23517j.setOnClickListener(new d.a(w10, this.f23508a));
                aVar.f23526s.setOnClickListener(new d.a(w10, this.f23508a));
            }
            RecyclerView.q qVar = (RecyclerView.q) ((t) aVar).itemView.getLayoutParams();
            if (this.isLastItem && !this.hasPlayersItemBelow) {
                ((ViewGroup.MarginLayoutParams) qVar).bottomMargin = p0.s(4);
            } else if (this.f23508a == iVar2) {
                ((ViewGroup.MarginLayoutParams) ((t) aVar).itemView.getLayoutParams()).bottomMargin = p0.s(8);
            } else {
                ((ViewGroup.MarginLayoutParams) qVar).bottomMargin = 0;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
