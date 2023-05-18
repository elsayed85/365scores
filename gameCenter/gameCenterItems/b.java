package com.scores365.gameCenter.gameCenterItems;

import ag.o;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import com.scores365.gameCenter.gameCenterItems.a;
import java.lang.ref.WeakReference;
import lf.u;
import li.p0;
import li.x0;
import se.q0;
/* compiled from: GameCenterLineupsVisualItem.java */
/* loaded from: classes2.dex */
public class b extends com.scores365.Design.PageObjects.b {

    /* renamed from: f  reason: collision with root package name */
    public static o f23775f;

    /* renamed from: g  reason: collision with root package name */
    private static q0 f23776g;

    /* renamed from: h  reason: collision with root package name */
    private static a.EnumC0251a f23777h;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f23778i;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f23779a;

    /* renamed from: b  reason: collision with root package name */
    boolean f23780b;

    /* renamed from: d  reason: collision with root package name */
    final WeakReference<FragmentManager> f23782d;

    /* renamed from: c  reason: collision with root package name */
    boolean f23781c = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f23783e = true;

    /* compiled from: GameCenterLineupsVisualItem.java */
    /* loaded from: classes2.dex */
    public static class a extends t {

        /* renamed from: f  reason: collision with root package name */
        public VisualLineup f23784f;

        /* renamed from: g  reason: collision with root package name */
        protected View f23785g;

        /* renamed from: h  reason: collision with root package name */
        protected ProgressBar f23786h;

        public a(View view) {
            super(view);
            this.f23785g = null;
            this.f23786h = null;
            this.f23784f = (VisualLineup) view.findViewById(R.id.SI);
            this.f23785g = view.findViewById(R.id.Rk);
            this.f23786h = (ProgressBar) view.findViewById(R.id.Ej);
        }

        public void c(boolean z10) {
            this.f23784f.A(b.f23776g.d().get(1).getFormation(), a.EnumC0251a.AWAY, z10);
        }

        public void d(boolean z10) {
            this.f23784f.A(b.f23776g.d().get(0).getFormation(), a.EnumC0251a.HOME, z10);
        }

        public void l(boolean z10) {
            try {
                if (z10) {
                    this.f23785g.setVisibility(0);
                    this.f23786h.setVisibility(0);
                } else {
                    this.f23785g.setVisibility(8);
                    this.f23786h.setVisibility(8);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public void m(b bVar) {
            String h10 = b.f23776g.h();
            if (bVar.f23782d.get() != null) {
                this.f23784f.C("lineups", h10, b.f23776g.c(), bVar.f23782d.get());
            }
            this.f23784f.setGCScope(bVar.f23783e);
            this.f23784f.setForShare(bVar.f23780b);
            this.f23784f.A(bVar.r(), b.f23777h, bVar.f23779a);
            l(bVar.f23781c);
            if (b.f23778i) {
                ((t) this).itemView.setBackgroundColor(p0.A(R.attr.f21557k));
            }
        }
    }

    public b(o oVar, q0 q0Var, a.EnumC0251a enumC0251a, boolean z10, boolean z11, FragmentManager fragmentManager, boolean z12) {
        f23776g = q0Var;
        f23775f = oVar;
        f23777h = enumC0251a;
        this.f23780b = z10;
        this.f23779a = z11;
        this.f23782d = new WeakReference<>(fragmentManager);
        f23778i = z12;
    }

    public static a.EnumC0251a s() {
        return f23777h;
    }

    public static t t(ViewGroup viewGroup, q.e eVar, boolean z10) {
        a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.J2, viewGroup, false));
        aVar.f23784f.setGameCenterLineupsMetadata(f23775f);
        aVar.f23784f.setVisualLineupsData(f23776g);
        aVar.f23784f.setFromDashBoardDetails(f23778i);
        return aVar;
    }

    public static void x(q0 q0Var) {
        f23776g = q0Var;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.LINEUPS_VISUAL_ITEM.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        ((a) e0Var).m(this);
    }

    public String r() {
        try {
            return f23777h == a.EnumC0251a.HOME ? f23776g.d().get(0).getFormation() : f23776g.d().get(1).getFormation();
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public void u(boolean z10) {
        this.f23783e = z10;
    }

    public void v(a.EnumC0251a enumC0251a) {
        f23777h = enumC0251a;
    }

    public void w(boolean z10) {
        this.f23781c = z10;
    }
}
