package com.scores365.gameCenter.gameCenterItems;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import com.scores365.entitys.PlayByPlayMessageObj;
import com.scores365.gameCenter.gameCenterItems.a;
import com.scores365.ui.NoTeamDataActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import lf.u;
import li.o0;
import li.p0;
import li.x0;
import nb.o;
import nb.p;
/* compiled from: PlayByPlayRegularItem.java */
/* loaded from: classes2.dex */
public class f extends com.scores365.Design.PageObjects.b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f23835a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f23836b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f23837c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f23838d;

    /* renamed from: e  reason: collision with root package name */
    private final String f23839e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f23840f;

    /* renamed from: g  reason: collision with root package name */
    private int f23841g;

    /* renamed from: h  reason: collision with root package name */
    private PlayByPlayMessageObj f23842h;

    /* renamed from: i  reason: collision with root package name */
    private String f23843i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f23844j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23845k = false;

    /* renamed from: l  reason: collision with root package name */
    String f23846l;

    /* renamed from: m  reason: collision with root package name */
    private a f23847m;

    /* renamed from: n  reason: collision with root package name */
    private a f23848n;

    /* compiled from: PlayByPlayRegularItem.java */
    /* loaded from: classes2.dex */
    private static class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f23849a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f23850b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f23851c;

        /* renamed from: d  reason: collision with root package name */
        private final String f23852d;

        /* renamed from: e  reason: collision with root package name */
        private WeakReference<FragmentManager> f23853e;

        /* renamed from: f  reason: collision with root package name */
        private int f23854f;

        /* renamed from: g  reason: collision with root package name */
        private int f23855g;

        /* renamed from: h  reason: collision with root package name */
        private int f23856h;

        /* renamed from: i  reason: collision with root package name */
        boolean f23857i;

        /* renamed from: j  reason: collision with root package name */
        private int f23858j;

        /* renamed from: k  reason: collision with root package name */
        private int f23859k;

        /* renamed from: l  reason: collision with root package name */
        private String f23860l;

        /* renamed from: m  reason: collision with root package name */
        private int f23861m;

        /* renamed from: n  reason: collision with root package name */
        private String f23862n;

        /* renamed from: o  reason: collision with root package name */
        private int f23863o;

        /* renamed from: p  reason: collision with root package name */
        private a.EnumC0251a f23864p;

        public a(int i10, int i11, boolean z10, int i12, String str, int i13, int i14, String str2, int i15, int i16, FragmentManager fragmentManager, boolean z11, boolean z12, String str3, boolean z13, boolean z14) {
            this.f23855g = i10;
            this.f23856h = i11;
            this.f23849a = z12;
            this.f23857i = z10;
            this.f23858j = i12;
            this.f23859k = i13;
            this.f23860l = str;
            this.f23861m = i14;
            this.f23862n = str2;
            this.f23863o = i15;
            this.f23864p = z11 ? a.EnumC0251a.HOME : a.EnumC0251a.AWAY;
            this.f23854f = i16;
            this.f23851c = z13;
            this.f23852d = str3;
            this.f23850b = z14;
            this.f23853e = new WeakReference<>(fragmentManager);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (this.f23855g <= 0 && (!this.f23851c || this.f23856h <= 0)) {
                    p0.m(NoTeamDataActivity.eNoTeamDataErrorType.Player, this.f23858j, this.f23860l, this.f23859k, this.f23861m, App.m(), null, this.f23862n, this.f23855g);
                    return;
                }
                WeakReference<FragmentManager> weakReference = this.f23853e;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                Context m10 = App.m();
                a.EnumC0251a enumC0251a = this.f23864p;
                int i10 = this.f23863o;
                p0.s0(this.f23859k, this.f23857i, this.f23854f, this.f23853e.get(), m10, enumC0251a, i10, this.f23849a, this.f23855g, this.f23856h, i10, this.f23860l, "pbp", this.f23852d, this.f23850b, this.f23851c, new se.f(false, ""), true);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* compiled from: PlayByPlayRegularItem.java */
    /* loaded from: classes2.dex */
    public static class b extends t {

        /* renamed from: f  reason: collision with root package name */
        TextView f23865f;

        /* renamed from: g  reason: collision with root package name */
        TextView f23866g;

        /* renamed from: h  reason: collision with root package name */
        TextView f23867h;

        /* renamed from: i  reason: collision with root package name */
        TextView f23868i;

        /* renamed from: j  reason: collision with root package name */
        TextView f23869j;

        /* renamed from: k  reason: collision with root package name */
        ImageView f23870k;

        /* renamed from: l  reason: collision with root package name */
        ImageView f23871l;

        /* renamed from: m  reason: collision with root package name */
        ImageView f23872m;

        /* renamed from: n  reason: collision with root package name */
        LinearLayout f23873n;

        /* renamed from: o  reason: collision with root package name */
        ConstraintLayout f23874o;

        /* renamed from: p  reason: collision with root package name */
        ConstraintLayout f23875p;

        /* renamed from: q  reason: collision with root package name */
        ConstraintLayout f23876q;

        /* renamed from: r  reason: collision with root package name */
        ArrayList<TextView> f23877r;

        /* renamed from: s  reason: collision with root package name */
        ArrayList<TextView> f23878s;

        /* renamed from: t  reason: collision with root package name */
        ArrayList<ImageView> f23879t;

        /* renamed from: u  reason: collision with root package name */
        View f23880u;

        /* renamed from: v  reason: collision with root package name */
        View f23881v;

        /* renamed from: w  reason: collision with root package name */
        ImageView f23882w;

        public b(View view) {
            super(view);
            this.f23877r = new ArrayList<>();
            this.f23878s = new ArrayList<>();
            this.f23879t = new ArrayList<>();
            try {
                this.f23880u = view.findViewById(R.id.V3);
                this.f23881v = view.findViewById(R.id.U3);
                this.f23865f = (TextView) view.findViewById(R.id.Tz);
                this.f23866g = (TextView) view.findViewById(R.id.Wz);
                this.f23872m = (ImageView) view.findViewById(R.id.Lb);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f22274rg);
                this.f23873n = linearLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) linearLayout.findViewById(R.id.U5);
                this.f23874o = constraintLayout;
                this.f23867h = (TextView) constraintLayout.findViewById(R.id.Qy);
                this.f23870k = (ImageView) this.f23874o.findViewById(R.id.f22181nb);
                this.f23871l = (ImageView) this.f23874o.findViewById(R.id.f21911bb);
                ConstraintLayout constraintLayout2 = (ConstraintLayout) this.f23873n.findViewById(R.id.T5);
                this.f23875p = constraintLayout2;
                this.f23879t.add((ImageView) constraintLayout2.findViewById(R.id.f22425yc));
                this.f23877r.add((TextView) this.f23875p.findViewById(R.id.nC));
                this.f23878s.add((TextView) this.f23875p.findViewById(R.id.jC));
                ConstraintLayout constraintLayout3 = (ConstraintLayout) this.f23873n.findViewById(R.id.Ro);
                this.f23876q = constraintLayout3;
                this.f23879t.add((ImageView) constraintLayout3.findViewById(R.id.f22425yc));
                this.f23877r.add((TextView) this.f23876q.findViewById(R.id.nC));
                this.f23878s.add((TextView) this.f23876q.findViewById(R.id.jC));
                this.f23868i = (TextView) this.f23873n.findViewById(R.id.Oy);
                this.f23869j = (TextView) this.f23873n.findViewById(R.id.Jx);
                this.f23882w = (ImageView) view.findViewById(R.id.f22445za);
                ImageView imageView = this.f23872m;
                if (imageView != null) {
                    imageView.setVisibility(4);
                    this.f23872m.setImageResource(R.drawable.D1);
                }
                this.f23865f.setTypeface(o0.c(App.m()));
                this.f23866g.setTypeface(o0.c(App.m()));
                this.f23877r.get(0).setTypeface(o0.d(App.m()));
                this.f23877r.get(1).setTypeface(o0.d(App.m()));
                this.f23878s.get(0).setTypeface(o0.d(App.m()));
                this.f23878s.get(1).setTypeface(o0.d(App.m()));
                this.f23868i.setTypeface(o0.d(App.m()));
                this.f23867h.setTypeface(o0.d(App.m()));
                this.f23869j.setTypeface(o0.d(App.m()));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public f(PlayByPlayMessageObj playByPlayMessageObj, String str, boolean z10, boolean z11, String str2, int i10, int i11, int i12, int i13, int i14, FragmentManager fragmentManager, int i15, boolean z12, String str3, boolean z13, boolean z14) {
        boolean z15;
        this.f23847m = null;
        this.f23848n = null;
        this.f23842h = playByPlayMessageObj;
        this.f23843i = str;
        this.f23841g = i14;
        this.f23844j = z10;
        this.f23840f = z14;
        this.f23835a = z11;
        this.f23837c = z12;
        this.f23839e = str3;
        this.f23838d = z13;
        boolean z16 = i15 == 0;
        this.f23836b = z16;
        if (playByPlayMessageObj.getPlayers() == null || playByPlayMessageObj.getPlayers().size() <= 0) {
            z15 = z16;
        } else {
            z15 = z16;
            this.f23847m = new a(playByPlayMessageObj.getPlayers().get(0).athleteId, playByPlayMessageObj.getPlayers().get(0).pId, z11, i10, str2, i11, i12, playByPlayMessageObj.getPlayers().get(0).getPlayerName(), i13, i14, fragmentManager, z15, z12, str3, z14, z13);
        }
        if (playByPlayMessageObj.getPlayers() == null || playByPlayMessageObj.getPlayers().size() <= 1) {
            return;
        }
        this.f23848n = new a(playByPlayMessageObj.getPlayers().get(1).athleteId, playByPlayMessageObj.getPlayers().get(1).pId, z11, i10, str2, i11, i12, playByPlayMessageObj.getPlayers().get(1).getPlayerName(), i13, i14, fragmentManager, z15, z12, str3, z14, z13);
    }

    private void m(b bVar) {
        try {
            if (o()) {
                bVar.f23881v.setVisibility(4);
            } else {
                bVar.f23881v.setVisibility(0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static t onCreateViewHolder(ViewGroup viewGroup) {
        try {
            return new b(x0.l1() ? LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22529f6, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22516e6, viewGroup, false));
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.PlayByPlayEvent.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getSpanSize() {
        try {
            return com.scores365.Design.Activities.c.fragmentSpanSize;
        } catch (Exception unused) {
            return 1;
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public boolean isFullSpanWidthSize() {
        return true;
    }

    public PlayByPlayMessageObj l() {
        return this.f23842h;
    }

    public void n(b bVar) {
        try {
            if (this.f23844j) {
                bVar.f23880u.setVisibility(4);
            } else {
                bVar.f23880u.setVisibility(0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public boolean o() {
        return this.f23845k;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            b bVar = (b) e0Var;
            bVar.f23874o.setVisibility(8);
            bVar.f23875p.setVisibility(8);
            bVar.f23876q.setVisibility(8);
            bVar.f23875p.setOnClickListener(this.f23847m);
            bVar.f23876q.setOnClickListener(this.f23848n);
            bVar.f23868i.setVisibility(8);
            bVar.f23869j.setVisibility(8);
            if (this.f23842h.getPlayers() != null && !this.f23842h.getPlayers().isEmpty()) {
                if (this.f23842h.getType() == 37 && this.f23842h.getPlayers().size() == 2) {
                    bVar.f23879t.get(0).setBackgroundResource(R.drawable.f21668a5);
                    bVar.f23879t.get(1).setBackgroundResource(R.drawable.f21676b5);
                    bVar.f23877r.get(0).setTextColor(p0.A(R.attr.f21562l1));
                    bVar.f23877r.get(1).setTextColor(p0.A(R.attr.f21559k1));
                } else {
                    bVar.f23879t.get(0).setBackgroundResource(0);
                    bVar.f23879t.get(1).setBackgroundResource(0);
                    bVar.f23877r.get(0).setTextColor(p0.A(R.attr.U0));
                    bVar.f23877r.get(1).setTextColor(p0.A(R.attr.U0));
                }
                for (int i11 = 0; i11 < this.f23842h.getPlayers().size(); i11++) {
                    if (i11 == 0) {
                        bVar.f23875p.setVisibility(0);
                    } else {
                        bVar.f23876q.setVisibility(0);
                    }
                    bVar.f23879t.get(i11).setVisibility(0);
                    bVar.f23877r.get(i11).setVisibility(0);
                    bVar.f23878s.get(i11).setVisibility(0);
                    bVar.f23877r.get(i11).setText(this.f23842h.getPlayers().get(i11).getPlayerName());
                    if (this.f23842h.getPlayers().get(i11).getDescription() == null || this.f23842h.getPlayers().get(i11).getDescription().isEmpty()) {
                        bVar.f23878s.get(i11).setVisibility(8);
                    } else {
                        bVar.f23878s.get(i11).setText(this.f23842h.getPlayers().get(i11).getDescription());
                        bVar.f23878s.get(i11).setVisibility(0);
                    }
                    li.u.A(o.d(this.f23842h.getPlayers().get(i11).athleteId, false, this.f23835a, this.f23842h.getPlayers().get(i11).getImgVer()), bVar.f23879t.get(i11), c.a.b(App.m(), R.drawable.f21845w6));
                }
            }
            if (this.f23842h.getTitle() == null || this.f23842h.getTitle().isEmpty()) {
                bVar.f23874o.setVisibility(8);
                bVar.f23867h.setVisibility(8);
                bVar.f23871l.setVisibility(8);
                bVar.f23870k.setVisibility(8);
            } else {
                bVar.f23874o.setVisibility(0);
                bVar.f23867h.setText(this.f23842h.getTitle());
                bVar.f23867h.setVisibility(0);
                bVar.f23871l.setVisibility(0);
                bVar.f23870k.setVisibility(0);
                if (this.f23842h.getTitleColor() != null) {
                    bVar.f23867h.setTextColor(Color.parseColor(this.f23842h.getTitleColor()));
                } else {
                    bVar.f23867h.setTextColor(p0.A(R.attr.U0));
                }
            }
            if (this.f23842h.getSubTitle() == null || this.f23842h.getSubTitle().isEmpty()) {
                bVar.f23868i.setVisibility(8);
            } else {
                bVar.f23868i.setText(this.f23842h.getSubTitle());
                bVar.f23868i.setVisibility(0);
                if (this.f23842h.getSubTitleColor() != null) {
                    bVar.f23868i.setTextColor(Color.parseColor(this.f23842h.getSubTitleColor()));
                } else {
                    bVar.f23867h.setTextColor(p0.A(R.attr.U0));
                }
            }
            if (this.f23842h.getAddedTime() == null || this.f23842h.getAddedTime().isEmpty()) {
                bVar.f23866g.setVisibility(8);
                if (this.f23842h.getTimeline() == null || this.f23842h.getTimeline().isEmpty()) {
                    bVar.f23865f.setVisibility(4);
                    bVar.f23872m.setVisibility(0);
                } else {
                    bVar.f23865f.setText(this.f23842h.getTimeline());
                    if (this.f23842h.isPenalty()) {
                        bVar.f23865f.setTextColor(p0.A(R.attr.A1));
                        bVar.f23865f.setBackgroundResource(R.drawable.W4);
                        bVar.f23865f.getLayoutParams().height = p0.s(16);
                        bVar.f23865f.getLayoutParams().width = p0.s(16);
                        bVar.f23865f.setTextSize(1, 12.0f);
                    } else {
                        bVar.f23865f.setTextColor(p0.A(R.attr.U0));
                        bVar.f23865f.getLayoutParams().height = -2;
                        bVar.f23865f.getLayoutParams().width = -2;
                        bVar.f23865f.setBackgroundResource(0);
                        bVar.f23865f.setTextSize(1, 14.0f);
                    }
                    bVar.f23872m.setVisibility(4);
                    bVar.f23865f.setVisibility(0);
                }
            } else {
                bVar.f23865f.setText(this.f23842h.getTimeline());
                bVar.f23872m.setVisibility(4);
                bVar.f23865f.setVisibility(0);
                bVar.f23865f.getLayoutParams().height = -2;
                bVar.f23865f.getLayoutParams().width = -2;
                bVar.f23865f.setBackgroundResource(0);
                bVar.f23866g.setText(this.f23842h.getAddedTime());
                bVar.f23866g.setVisibility(0);
                if (this.f23842h.getAddedTimeColor() == null || this.f23842h.getAddedTimeColor().isEmpty()) {
                    bVar.f23866g.setTextColor(p0.A(R.attr.f21559k1));
                } else {
                    bVar.f23866g.setTextColor(Color.parseColor(this.f23842h.getAddedTimeColor()));
                }
            }
            if (this.f23842h.getComment() == null || this.f23842h.getComment().isEmpty()) {
                bVar.f23869j.setVisibility(8);
            } else {
                bVar.f23869j.setText(this.f23842h.getComment());
                bVar.f23869j.setVisibility(0);
            }
            String str = this.f23843i;
            if (str != null) {
                ImageView imageView = bVar.f23871l;
                li.u.A(str, imageView, li.u.f(imageView.getLayoutParams().width));
                bVar.f23871l.setVisibility(0);
            } else {
                bVar.f23871l.setVisibility(8);
            }
            n(bVar);
            m(bVar);
            if (this.f23842h.isShowIcon()) {
                try {
                    li.u.x(o.r(p.PlayByPlayIcon, this.f23842h.getType(), 40, 40, false), bVar.f23870k);
                } catch (Exception e10) {
                    x0.N1(e10);
                }
                bVar.f23870k.setVisibility(0);
            } else {
                bVar.f23870k.setVisibility(8);
            }
            if (this.f23846l == null) {
                bVar.f23882w.setVisibility(8);
                ((t) bVar).itemView.setBackgroundResource(p0.T(R.attr.f21557k));
                return;
            }
            bVar.f23882w.setVisibility(0);
            ((t) bVar).itemView.setBackgroundResource(0);
            li.u.x(this.f23846l, bVar.f23882w);
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    public void p(boolean z10) {
        this.f23845k = z10;
    }

    public void setBackgroundUrl(String str) {
        this.f23846l = str;
    }
}
