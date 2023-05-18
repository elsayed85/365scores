package com.scores365.dashboardEntities.dashboardScores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import li.o0;
import li.p0;
import li.x0;
import nb.o;
import nb.p;
/* compiled from: ScoresItemTitle.java */
/* loaded from: classes2.dex */
public class j extends i {

    /* renamed from: a  reason: collision with root package name */
    public boolean f23460a = false;

    /* renamed from: b  reason: collision with root package name */
    public CompetitionObj f23461b;

    /* renamed from: c  reason: collision with root package name */
    public GameObj f23462c;

    /* renamed from: d  reason: collision with root package name */
    public String f23463d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23464e;

    /* renamed from: f  reason: collision with root package name */
    private String f23465f;

    /* renamed from: g  reason: collision with root package name */
    private int f23466g;

    /* renamed from: h  reason: collision with root package name */
    private String f23467h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScoresItemTitle.java */
    /* loaded from: classes2.dex */
    public static class a extends t {

        /* renamed from: f  reason: collision with root package name */
        RelativeLayout f23468f;

        /* renamed from: g  reason: collision with root package name */
        ImageView f23469g;

        /* renamed from: h  reason: collision with root package name */
        TextView f23470h;

        /* renamed from: i  reason: collision with root package name */
        Button f23471i;

        public a(View view, q.e eVar) {
            super(view);
            this.f23468f = (RelativeLayout) view.findViewById(R.id.W3);
            this.f23469g = (ImageView) view.findViewById(R.id.Pb);
            this.f23470h = (TextView) view.findViewById(R.id.HA);
            this.f23471i = (Button) view.findViewById(R.id.f22282s1);
            this.f23470h.setTextColor(p0.A(R.attr.U0));
            ((t) this).itemView.setOnClickListener(new u(this, eVar));
        }
    }

    public j(GameObj gameObj, CompetitionObj competitionObj, String str, boolean z10) {
        this.f23465f = null;
        this.f23461b = competitionObj;
        this.f23462c = gameObj;
        this.f23463d = str;
        this.f23464e = z10;
        try {
            this.f23465f = o.x(x0.n1() ? p.CompetitionsLight : p.Competitions, competitionObj.getID(), 100, 100, false, p.CountriesRoundFlags, Integer.valueOf(competitionObj.getCid()), competitionObj.getImgVer());
            if (this.f23460a) {
                this.f23467h = p0.l0("DASHBOARD_FAVORITE_TEAMS");
            } else {
                this.f23467h = str;
            }
            this.f23466g = super.hashCode();
            this.f23466g = this.f23467h.hashCode();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static t onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        try {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.Z2, viewGroup, false), eVar);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // com.scores365.dashboardEntities.dashboardScores.i
    public long getId() {
        return this.f23461b.getID();
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.ScoresItemTitle.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getSpanSize() {
        try {
            return com.scores365.Design.Activities.c.fragmentSpanSize;
        } catch (Exception unused) {
            return 1;
        }
    }

    public int hashCode() {
        return this.f23466g;
    }

    @Override // com.scores365.Design.PageObjects.c
    public boolean isFullSpanWidthSize() {
        return true;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            a aVar = (a) e0Var;
            aVar.f23468f.setVisibility(0);
            aVar.f23471i.setVisibility(8);
            if (x0.n1()) {
                aVar.f23468f.setBackgroundResource(R.drawable.f21828u5);
            } else {
                aVar.f23468f.setBackgroundResource(R.drawable.f21820t5);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.f23470h.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar.f23469g.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) aVar.f23471i.getLayoutParams();
            if (x0.l1()) {
                layoutParams2.addRule(11);
                layoutParams.addRule(0, aVar.f23469g.getId());
                layoutParams3.addRule(9);
            } else {
                layoutParams2.addRule(9);
                layoutParams.addRule(1, aVar.f23469g.getId());
                layoutParams3.addRule(11);
            }
            layoutParams2.width = p0.s(20);
            layoutParams2.height = p0.s(20);
            if (this.f23464e) {
                layoutParams2.width = p0.s(17);
                layoutParams2.height = p0.s(17);
            }
            aVar.f23470h.setText(this.f23467h);
            if (this.f23460a) {
                aVar.f23469g.setImageResource(R.drawable.f21808s1);
            } else {
                aVar.f23469g.setImageResource(0);
                if (this.f23464e) {
                    li.u.G(this.f23461b.olympicSportId, aVar.f23469g);
                } else {
                    if (this.f23465f == null) {
                        this.f23465f = o.x(x0.n1() ? p.CompetitionsLight : p.Competitions, this.f23461b.getID(), 100, 100, false, p.CountriesRoundFlags, Integer.valueOf(this.f23461b.getCid()), this.f23461b.getImgVer());
                    }
                    li.u.A(this.f23465f, ((a) e0Var).f23469g, li.u.f(((a) e0Var).f23469g.getLayoutParams().width));
                    ((a) e0Var).f23469g.setAdjustViewBounds(true);
                }
            }
            aVar.f23470h.setTypeface(o0.d(App.m()));
            aVar.f23470h.setTextSize(1, 13.0f);
            if (sf.b.X1().L3()) {
                ((t) aVar).itemView.setOnLongClickListener(new li.k(this.f23461b.getID()).b(aVar));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
