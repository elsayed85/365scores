package com.scores365.dashboardEntities.dashboardScores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import java.util.Calendar;
import java.util.Date;
import li.o0;
import li.p0;
import li.x0;
/* compiled from: ScoresSectionObj.java */
/* loaded from: classes2.dex */
public class m extends com.scores365.Design.PageObjects.b {

    /* renamed from: a  reason: collision with root package name */
    public Date f23534a;

    /* renamed from: b  reason: collision with root package name */
    public String f23535b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23536c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23537d;

    /* renamed from: e  reason: collision with root package name */
    public b f23538e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f23539f;

    /* renamed from: g  reason: collision with root package name */
    private Integer f23540g;

    /* renamed from: h  reason: collision with root package name */
    private int f23541h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScoresSectionObj.java */
    /* loaded from: classes2.dex */
    public static class a extends t {

        /* renamed from: f  reason: collision with root package name */
        TextView f23542f;

        /* renamed from: g  reason: collision with root package name */
        TextView f23543g;

        /* renamed from: h  reason: collision with root package name */
        TextView f23544h;

        /* renamed from: i  reason: collision with root package name */
        TextView f23545i;

        public a(View view, q.e eVar) {
            super(view);
            this.f23542f = (TextView) view.findViewById(R.id.aA);
            this.f23543g = (TextView) view.findViewById(R.id.eB);
            this.f23544h = (TextView) view.findViewById(R.id.bA);
            TextView textView = (TextView) view.findViewById(R.id.fB);
            this.f23545i = textView;
            textView.setTypeface(o0.b(App.m()));
            this.f23542f.setTypeface(o0.b(App.m()));
            this.f23544h.setTypeface(o0.b(App.m()));
            this.f23543g.setTypeface(o0.d(App.m()));
            this.f23545i.setTypeface(o0.d(App.m()));
            view.setOnClickListener(new u(this, eVar));
        }
    }

    /* compiled from: ScoresSectionObj.java */
    /* loaded from: classes2.dex */
    public enum b {
        date,
        dateNumber,
        category,
        favourite
    }

    public m(Date date, String str, boolean z10, boolean z11, b bVar) {
        this.f23539f = null;
        this.f23540g = null;
        this.f23534a = date;
        this.f23535b = str;
        this.f23536c = z10;
        this.f23537d = z11;
        this.f23538e = bVar;
        try {
            this.f23539f = Integer.valueOf(p0.A(R.attr.f21565m1));
            if (this.f23540g == null) {
                this.f23540g = Integer.valueOf(p0.A(R.attr.T0));
            }
            this.f23541h = super.hashCode();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.get(6);
            this.f23541h = (((this.f23535b.hashCode() * 367) + calendar.get(6)) * lf.u.values().length) + getObjectTypeNum();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static t onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        try {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22466a8, viewGroup, false), eVar);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof m) {
                m mVar = (m) obj;
                if (mVar.f23535b.equalsIgnoreCase(this.f23535b)) {
                    return this.f23534a.equals(mVar);
                }
                return false;
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.ScoresSection.ordinal();
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
        return this.f23541h;
    }

    @Override // com.scores365.Design.PageObjects.c
    public boolean isFullSpanWidthSize() {
        return true;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            a aVar = (a) e0Var;
            aVar.f23543g.setVisibility(8);
            aVar.f23542f.setVisibility(8);
            aVar.f23545i.setVisibility(8);
            aVar.f23544h.setVisibility(8);
            if (x0.l1()) {
                aVar.f23544h.setText(this.f23535b);
                aVar.f23545i.setVisibility(8);
                if (this.f23536c) {
                    aVar.f23545i.setVisibility(0);
                    aVar.f23545i.setTextSize(1, 12.0f);
                    aVar.f23545i.setText(p0.l0("SCORES_LIVE"));
                }
                aVar.f23544h.setVisibility(0);
                if (this.f23538e == b.favourite) {
                    aVar.f23544h.setTextSize(1, 14.0f);
                    aVar.f23544h.setTextColor(this.f23539f.intValue());
                    aVar.f23544h.setTypeface(o0.d(App.m()));
                    aVar.f23544h.setPadding(0, p0.A0(8), 0, p0.A0(8));
                }
                if (this.f23538e == b.date) {
                    aVar.f23544h.setTextSize(1, 16.0f);
                    aVar.f23544h.setTypeface(o0.b(App.m()));
                    aVar.f23544h.setTextColor(this.f23540g.intValue());
                    aVar.f23544h.setPadding(0, p0.A0(8), 0, p0.A0(16));
                }
                if (this.f23538e == b.dateNumber) {
                    aVar.f23544h.setTextSize(1, (int) (App.m().getResources().getDimension(R.dimen.f21636a) / App.m().getResources().getDisplayMetrics().density));
                    aVar.f23544h.setTypeface(o0.b(App.m()));
                    aVar.f23544h.setTextColor(this.f23540g.intValue());
                }
                if (this.f23538e == b.category) {
                    aVar.f23544h.setTextSize(1, 12.0f);
                    aVar.f23544h.setTypeface(o0.c(App.m()));
                    aVar.f23544h.setTextColor(this.f23539f.intValue());
                }
            } else {
                aVar.f23542f.setText(this.f23535b);
                aVar.f23542f.setTypeface(o0.b(App.m()));
                aVar.f23543g.setVisibility(8);
                if (this.f23536c) {
                    aVar.f23543g.setVisibility(0);
                    aVar.f23543g.setText(p0.l0("SCORES_LIVE"));
                    aVar.f23543g.setTypeface(o0.d(App.m()));
                    aVar.f23543g.setTextSize(1, 12.0f);
                }
                aVar.f23542f.setVisibility(0);
                if (this.f23538e == b.favourite) {
                    aVar.f23542f.setTypeface(o0.d(App.m()));
                    aVar.f23542f.setTextSize(1, 12.0f);
                    aVar.f23542f.setTextColor(this.f23539f.intValue());
                    aVar.f23542f.setPadding(0, p0.A0(8), 0, p0.A0(8));
                }
                if (this.f23538e == b.date) {
                    aVar.f23542f.setTypeface(o0.b(App.m()));
                    aVar.f23542f.setTextColor(this.f23540g.intValue());
                    aVar.f23542f.setTextSize(1, 16.0f);
                    aVar.f23542f.setPadding(0, p0.A0(8), 0, p0.A0(16));
                }
                if (this.f23538e == b.dateNumber) {
                    aVar.f23542f.setTextSize(1, (int) (App.m().getResources().getDimension(R.dimen.f21636a) / App.m().getResources().getDisplayMetrics().density));
                    aVar.f23542f.setTypeface(o0.b(App.m()));
                    aVar.f23542f.setTextColor(this.f23540g.intValue());
                }
                if (this.f23538e == b.category) {
                    aVar.f23542f.setTextSize(1, 12.0f);
                    aVar.f23542f.setTypeface(o0.c(App.m()));
                    aVar.f23542f.setTextColor(this.f23539f.intValue());
                }
            }
            if (((t) aVar).itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.c) {
                ((StaggeredGridLayoutManager.c) ((t) aVar).itemView.getLayoutParams()).l(true);
            }
            if (this.f23537d) {
                ((t) aVar).itemView.setPadding(p0.s(6), p0.s(16), p0.s(6), 0);
            } else {
                ((t) aVar).itemView.setPadding(p0.s(6), 0, p0.s(6), 0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public String toString() {
        String obj = super.toString();
        String str = this.f23535b;
        return str != null ? str : obj;
    }
}
