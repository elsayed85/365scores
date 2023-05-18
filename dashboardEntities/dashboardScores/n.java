package com.scores365.dashboardEntities.dashboardScores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.bets.model.BetLineOption;
import com.scores365.dashboardEntities.dashboardScores.f;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.SportTypeObj;
import com.scores365.entitys.StatusObj;
import com.scores365.entitys.oddsPreviewEntities.OddsPreview;
import com.scores365.ui.ScoresOddsView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import li.o0;
import li.p0;
import li.x0;
import nb.o;
import nb.p;
/* compiled from: ScoresTennisLiveItem.java */
/* loaded from: classes2.dex */
public class n extends f {

    /* renamed from: a  reason: collision with root package name */
    private String f23546a;

    /* renamed from: b  reason: collision with root package name */
    private String f23547b;

    /* renamed from: c  reason: collision with root package name */
    private String f23548c;

    /* compiled from: ScoresTennisLiveItem.java */
    /* loaded from: classes2.dex */
    public static class a extends f.a {

        /* renamed from: f  reason: collision with root package name */
        private ConstraintLayout f23549f;

        /* renamed from: g  reason: collision with root package name */
        private ImageView f23550g;

        /* renamed from: h  reason: collision with root package name */
        private ImageView f23551h;

        /* renamed from: i  reason: collision with root package name */
        private ImageView f23552i;

        /* renamed from: j  reason: collision with root package name */
        private ImageView f23553j;

        /* renamed from: k  reason: collision with root package name */
        private TextView f23554k;

        /* renamed from: l  reason: collision with root package name */
        private TextView f23555l;

        /* renamed from: m  reason: collision with root package name */
        private TextView f23556m;

        /* renamed from: n  reason: collision with root package name */
        private ScoresOddsView f23557n;

        /* renamed from: o  reason: collision with root package name */
        private GridLayout f23558o;

        /* renamed from: p  reason: collision with root package name */
        private b f23559p;

        /* renamed from: q  reason: collision with root package name */
        private Animation.AnimationListener f23560q;

        /* compiled from: ScoresTennisLiveItem.java */
        /* renamed from: com.scores365.dashboardEntities.dashboardScores.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class animation.Animation$AnimationListenerC0248a implements Animation.AnimationListener {
            animation.Animation$AnimationListenerC0248a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                try {
                    a.this.f23557n.setVisibility(8);
                    a.this.f23549f.setPadding(a.this.f23549f.getPaddingLeft(), a.this.f23549f.getPaddingTop(), a.this.f23549f.getPaddingRight(), 0);
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        }

        /* compiled from: ScoresTennisLiveItem.java */
        /* loaded from: classes2.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            private ArrayList<TextView> f23562a;

            /* renamed from: b  reason: collision with root package name */
            private ArrayList<RelativeLayout> f23563b;

            /* renamed from: c  reason: collision with root package name */
            private ArrayList<RelativeLayout> f23564c;

            /* renamed from: d  reason: collision with root package name */
            private ArrayList<TextView> f23565d;

            /* renamed from: e  reason: collision with root package name */
            private ArrayList<TextView> f23566e;

            /* renamed from: f  reason: collision with root package name */
            private ArrayList<TextView> f23567f;

            /* renamed from: g  reason: collision with root package name */
            private ArrayList<TextView> f23568g;

            /* renamed from: h  reason: collision with root package name */
            private ImageView f23569h;

            /* renamed from: i  reason: collision with root package name */
            private ImageView f23570i;

            /* renamed from: j  reason: collision with root package name */
            private TextView f23571j;

            /* renamed from: k  reason: collision with root package name */
            private TextView f23572k;

            /* renamed from: l  reason: collision with root package name */
            private RelativeLayout f23573l;

            /* renamed from: m  reason: collision with root package name */
            private RelativeLayout f23574m;

            public b(GridLayout gridLayout) {
                try {
                    if (x0.l1()) {
                        gridLayout.removeView(gridLayout.findViewById(R.id.f3do));
                        gridLayout.removeView(gridLayout.findViewById(R.id.bo));
                        this.f23569h = (ImageView) gridLayout.findViewById(R.id.Uc);
                        this.f23570i = (ImageView) gridLayout.findViewById(R.id.Sc);
                        this.f23571j = (TextView) gridLayout.findViewById(R.id.HD);
                        this.f23572k = (TextView) gridLayout.findViewById(R.id.FD);
                        this.f23573l = (RelativeLayout) gridLayout.findViewById(R.id.eo);
                        this.f23574m = (RelativeLayout) gridLayout.findViewById(R.id.co);
                    } else {
                        gridLayout.removeView(gridLayout.findViewById(R.id.eo));
                        gridLayout.removeView(gridLayout.findViewById(R.id.co));
                        this.f23569h = (ImageView) gridLayout.findViewById(R.id.Tc);
                        this.f23570i = (ImageView) gridLayout.findViewById(R.id.Rc);
                        this.f23571j = (TextView) gridLayout.findViewById(R.id.GD);
                        this.f23572k = (TextView) gridLayout.findViewById(R.id.ED);
                        this.f23573l = (RelativeLayout) gridLayout.findViewById(R.id.f3do);
                        this.f23574m = (RelativeLayout) gridLayout.findViewById(R.id.bo);
                    }
                    this.f23562a = new ArrayList<>();
                    this.f23563b = new ArrayList<>();
                    this.f23564c = new ArrayList<>();
                    this.f23565d = new ArrayList<>();
                    this.f23566e = new ArrayList<>();
                    this.f23567f = new ArrayList<>();
                    this.f23568g = new ArrayList<>();
                    if (x0.l1()) {
                        this.f23562a.add((TextView) gridLayout.findViewById(R.id.eH));
                        this.f23562a.add((TextView) gridLayout.findViewById(R.id.dH));
                        this.f23562a.add((TextView) gridLayout.findViewById(R.id.cH));
                        this.f23562a.add((TextView) gridLayout.findViewById(R.id.bH));
                        this.f23562a.add((TextView) gridLayout.findViewById(R.id.aH));
                        this.f23562a.add((TextView) gridLayout.findViewById(R.id.fH));
                        this.f23563b.add((RelativeLayout) gridLayout.findViewById(R.id.Zn));
                        this.f23563b.add((RelativeLayout) gridLayout.findViewById(R.id.Yn));
                        this.f23563b.add((RelativeLayout) gridLayout.findViewById(R.id.Xn));
                        this.f23563b.add((RelativeLayout) gridLayout.findViewById(R.id.Wn));
                        this.f23563b.add((RelativeLayout) gridLayout.findViewById(R.id.Vn));
                        this.f23564c.add((RelativeLayout) gridLayout.findViewById(R.id.Un));
                        this.f23564c.add((RelativeLayout) gridLayout.findViewById(R.id.Tn));
                        this.f23564c.add((RelativeLayout) gridLayout.findViewById(R.id.Sn));
                        this.f23564c.add((RelativeLayout) gridLayout.findViewById(R.id.Rn));
                        this.f23564c.add((RelativeLayout) gridLayout.findViewById(R.id.Qn));
                        this.f23565d.add((TextView) gridLayout.findViewById(R.id.yD));
                        this.f23565d.add((TextView) gridLayout.findViewById(R.id.xD));
                        this.f23565d.add((TextView) gridLayout.findViewById(R.id.wD));
                        this.f23565d.add((TextView) gridLayout.findViewById(R.id.vD));
                        this.f23565d.add((TextView) gridLayout.findViewById(R.id.uD));
                        this.f23566e.add((TextView) gridLayout.findViewById(R.id.tD));
                        this.f23566e.add((TextView) gridLayout.findViewById(R.id.sD));
                        this.f23566e.add((TextView) gridLayout.findViewById(R.id.rD));
                        this.f23566e.add((TextView) gridLayout.findViewById(R.id.qD));
                        this.f23566e.add((TextView) gridLayout.findViewById(R.id.pD));
                        this.f23567f.add((TextView) gridLayout.findViewById(R.id.ez));
                        this.f23567f.add((TextView) gridLayout.findViewById(R.id.dz));
                        this.f23567f.add((TextView) gridLayout.findViewById(R.id.cz));
                        this.f23567f.add((TextView) gridLayout.findViewById(R.id.bz));
                        this.f23567f.add((TextView) gridLayout.findViewById(R.id.az));
                        this.f23568g.add((TextView) gridLayout.findViewById(R.id.Zy));
                        this.f23568g.add((TextView) gridLayout.findViewById(R.id.Yy));
                        this.f23568g.add((TextView) gridLayout.findViewById(R.id.Xy));
                        this.f23568g.add((TextView) gridLayout.findViewById(R.id.Wy));
                        this.f23568g.add((TextView) gridLayout.findViewById(R.id.Vy));
                        return;
                    }
                    this.f23562a.add((TextView) gridLayout.findViewById(R.id.fH));
                    this.f23562a.add((TextView) gridLayout.findViewById(R.id.aH));
                    this.f23562a.add((TextView) gridLayout.findViewById(R.id.bH));
                    this.f23562a.add((TextView) gridLayout.findViewById(R.id.cH));
                    this.f23562a.add((TextView) gridLayout.findViewById(R.id.dH));
                    this.f23562a.add((TextView) gridLayout.findViewById(R.id.eH));
                    this.f23563b.add((RelativeLayout) gridLayout.findViewById(R.id.Vn));
                    this.f23563b.add((RelativeLayout) gridLayout.findViewById(R.id.Wn));
                    this.f23563b.add((RelativeLayout) gridLayout.findViewById(R.id.Xn));
                    this.f23563b.add((RelativeLayout) gridLayout.findViewById(R.id.Yn));
                    this.f23563b.add((RelativeLayout) gridLayout.findViewById(R.id.Zn));
                    this.f23564c.add((RelativeLayout) gridLayout.findViewById(R.id.Qn));
                    this.f23564c.add((RelativeLayout) gridLayout.findViewById(R.id.Rn));
                    this.f23564c.add((RelativeLayout) gridLayout.findViewById(R.id.Sn));
                    this.f23564c.add((RelativeLayout) gridLayout.findViewById(R.id.Tn));
                    this.f23564c.add((RelativeLayout) gridLayout.findViewById(R.id.Un));
                    this.f23565d.add((TextView) gridLayout.findViewById(R.id.uD));
                    this.f23565d.add((TextView) gridLayout.findViewById(R.id.vD));
                    this.f23565d.add((TextView) gridLayout.findViewById(R.id.wD));
                    this.f23565d.add((TextView) gridLayout.findViewById(R.id.xD));
                    this.f23565d.add((TextView) gridLayout.findViewById(R.id.yD));
                    this.f23566e.add((TextView) gridLayout.findViewById(R.id.pD));
                    this.f23566e.add((TextView) gridLayout.findViewById(R.id.qD));
                    this.f23566e.add((TextView) gridLayout.findViewById(R.id.rD));
                    this.f23566e.add((TextView) gridLayout.findViewById(R.id.sD));
                    this.f23566e.add((TextView) gridLayout.findViewById(R.id.tD));
                    this.f23567f.add((TextView) gridLayout.findViewById(R.id.az));
                    this.f23567f.add((TextView) gridLayout.findViewById(R.id.bz));
                    this.f23567f.add((TextView) gridLayout.findViewById(R.id.cz));
                    this.f23567f.add((TextView) gridLayout.findViewById(R.id.dz));
                    this.f23567f.add((TextView) gridLayout.findViewById(R.id.ez));
                    this.f23568g.add((TextView) gridLayout.findViewById(R.id.Vy));
                    this.f23568g.add((TextView) gridLayout.findViewById(R.id.Wy));
                    this.f23568g.add((TextView) gridLayout.findViewById(R.id.Xy));
                    this.f23568g.add((TextView) gridLayout.findViewById(R.id.Yy));
                    this.f23568g.add((TextView) gridLayout.findViewById(R.id.Zy));
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }

            public void l() {
                for (int i10 = 0; i10 < this.f23563b.size(); i10++) {
                    try {
                        int n10 = p0.n(p0.A(R.attr.T0), 0.05f);
                        this.f23563b.get(i10).setBackgroundColor(n10);
                        this.f23564c.get(i10).setBackgroundColor(n10);
                    } catch (Exception e10) {
                        x0.N1(e10);
                        return;
                    }
                }
                int n11 = p0.n(p0.A(R.attr.T0), 0.45f);
                this.f23573l.setBackgroundColor(n11);
                this.f23574m.setBackgroundColor(n11);
            }
        }

        public a(View view, q.e eVar) {
            super(view);
            this.f23560q = new animation.Animation$AnimationListenerC0248a();
            this.f23550g = (ImageView) view.findViewById(R.id.Jb);
            this.f23551h = (ImageView) view.findViewById(R.id.f22357va);
            this.f23553j = (ImageView) view.findViewById(R.id.Gb);
            this.f23552i = (ImageView) view.findViewById(R.id.f22291sa);
            this.f23554k = (TextView) view.findViewById(R.id.rA);
            this.f23555l = (TextView) view.findViewById(R.id.Mw);
            this.f23556m = (TextView) view.findViewById(R.id.aC);
            this.f23558o = (GridLayout) view.findViewById(R.id.f22385wg);
            this.f23557n = (ScoresOddsView) view.findViewById(R.id.mq);
            this.f23554k.setTypeface(o0.d(App.m()));
            this.f23555l.setTypeface(o0.d(App.m()));
            this.leftStripe = view.findViewById(R.id.Cf);
            this.f23549f = (ConstraintLayout) view.findViewById(R.id.Fn);
            this.f23556m.setTypeface(o0.d(App.m()));
            ((t) this).itemView.setOnClickListener(new u(this, eVar));
            b bVar = new b(this.f23558o);
            this.f23559p = bVar;
            bVar.l();
        }

        private void handleHiddenOdds() {
            if (this.f23557n.getVisibility() == 0 || App.f20803w) {
                return;
            }
            this.f23557n.startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21514n));
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public int getBottomOfItemView() {
            return p0.s(1);
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public int getLeftOfItemView() {
            try {
                return p0.s(3);
            } catch (Exception e10) {
                x0.N1(e10);
                return 0;
            }
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public int getTopMarginItemView() {
            return p0.s(1);
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public boolean isSelected() {
            return this.hasNotifications;
        }

        @Override // com.scores365.dashboardEntities.dashboardScores.f.a, com.scores365.ui.swipe.SwipeableViewHolder
        public boolean isSwipeable() {
            return this.isSwipable;
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public void toggleViewHolder() {
            try {
                int i10 = 0;
                this.hasNotifications = !this.hasNotifications;
                View leftStripe = getLeftStripe();
                if (!this.hasNotifications) {
                    i10 = 8;
                }
                leftStripe.setVisibility(i10);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // com.scores365.dashboardEntities.dashboardScores.f.a
        public void updateViewHolder(f fVar, boolean z10, boolean z11, boolean z12) {
            OddsPreview oddsPreview;
            HashSet<Integer> hashSet;
            try {
                if (fVar instanceof n) {
                    n nVar = (n) fVar;
                    boolean l12 = x0.l1();
                    SportTypeObj sportTypeObj = App.l().getSportTypes().get(Integer.valueOf(nVar.gameObj.getSportID()));
                    StatusObj statusObj = sportTypeObj.getStatuses().get(Integer.valueOf(nVar.gameObj.getStID()));
                    nVar.r(this, App.m());
                    nVar.t(App.m(), this, l12, statusObj, sportTypeObj, true, nVar.gameObj.homeAwayTeamOrder);
                    if (nVar.gameObj.isEditorsChoice() && (hashSet = xe.j.f42132v0) != null && !hashSet.contains(Integer.valueOf(nVar.gameObj.getID()))) {
                        x0.V1(nVar.gameObj, false);
                        xe.j.f42132v0.add(Integer.valueOf(nVar.gameObj.getID()));
                    }
                    nVar.s(this);
                    if (sf.b.X1().L3()) {
                        ((t) this).itemView.setOnLongClickListener(new li.k(nVar.gameObj.getID()).b(this));
                    }
                    if (z10 && x0.s2() && (oddsPreview = nVar.gameObj.oddsPreview) != null && oddsPreview.getOddsPreviewCell() != null && !nVar.gameObj.oddsPreview.getOddsPreviewCell().isEmpty()) {
                        handleHiddenOdds();
                        this.f23557n.setVisibility(0);
                        this.f23557n.setOddsPreview(nVar.gameObj.oddsPreview.getOddsPreviewCell(), nVar.gameObj.homeAwayTeamOrder);
                        ScoresOddsView scoresOddsView = this.f23557n;
                        scoresOddsView.setPadding(scoresOddsView.getPaddingLeft(), p0.s(8), this.f23557n.getPaddingRight(), 0);
                        ConstraintLayout constraintLayout = this.f23549f;
                        constraintLayout.setPadding(constraintLayout.getPaddingLeft(), this.f23549f.getPaddingTop(), this.f23549f.getPaddingRight(), 0);
                    } else if (z10 && x0.s2() && nVar.gameObj.getMainOddsObj() != null && nVar.gameObj.getMainOddsObj().lineOptions != null && nVar.gameObj.getMainOddsObj().lineOptions.length > 0) {
                        BetLineOption[] betLineOptionArr = nVar.gameObj.getMainOddsObj().lineOptions;
                        handleHiddenOdds();
                        this.f23557n.setVisibility(0);
                        this.f23557n.setBetLineFromOptions(betLineOptionArr, fVar.gameObj.getMainOddsObj().isConcluded, nVar.gameObj.getMainOddsObj().type, fVar.gameObj.getIsActive(), fVar.gameObj.isScheduled(), fVar.gameObj.homeAwayTeamOrder);
                        ScoresOddsView scoresOddsView2 = this.f23557n;
                        scoresOddsView2.setPadding(scoresOddsView2.getPaddingLeft(), p0.s(8), this.f23557n.getPaddingRight(), 0);
                        ConstraintLayout constraintLayout2 = this.f23549f;
                        constraintLayout2.setPadding(constraintLayout2.getPaddingLeft(), this.f23549f.getPaddingTop(), this.f23549f.getPaddingRight(), 0);
                    } else if (App.f20803w) {
                        this.f23560q.onAnimationEnd(null);
                    } else {
                        this.f23557n.setVisibility(8);
                    }
                    this.hasNotifications = nVar.hasNotifications;
                    this.isSwipable = true;
                    this.shouldShowLeftStripe = nVar.shouldShowLeftStripe;
                    handleLeftStripeVisibility();
                    restoreInitialStateWithoutAnimation();
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public n(GameObj gameObj, CompetitionObj competitionObj, boolean z10, boolean z11, boolean z12, Locale locale) {
        super(gameObj, competitionObj, z10, z11, z12, locale);
        this.f23546a = null;
        this.f23547b = null;
        this.f23548c = null;
        try {
            p pVar = p.Competitors;
            long id2 = gameObj.getComps()[0].getID();
            p pVar2 = p.CountriesRoundFlags;
            this.f23546a = o.x(pVar, id2, 100, 100, true, pVar2, Integer.valueOf(gameObj.getComps()[0].getCountryID()), gameObj.getComps()[0].getImgVer());
            this.f23547b = o.x(pVar, gameObj.getComps()[1].getID(), 100, 100, true, pVar2, Integer.valueOf(gameObj.getComps()[1].getCountryID()), gameObj.getComps()[1].getImgVer());
            p();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0351 A[Catch: Exception -> 0x056c, TryCatch #0 {Exception -> 0x056c, blocks: (B:3:0x0002, B:6:0x0013, B:8:0x001f, B:10:0x0050, B:12:0x00b4, B:16:0x00c9, B:18:0x00fc, B:19:0x0104, B:21:0x010a, B:31:0x01c0, B:37:0x01d2, B:42:0x0273, B:44:0x0277, B:46:0x033f, B:51:0x0349, B:53:0x0351, B:55:0x0359, B:57:0x037d, B:59:0x0387, B:64:0x03e0, B:66:0x03ea, B:71:0x044b, B:73:0x044f, B:75:0x0455, B:76:0x045d, B:78:0x0463, B:80:0x0471, B:86:0x048d, B:90:0x04d0, B:91:0x04ef, B:92:0x050d, B:67:0x0415, B:69:0x041f, B:61:0x03b0, B:63:0x03ba, B:94:0x052d, B:39:0x0223, B:40:0x023d, B:23:0x0118, B:24:0x0120, B:26:0x0126, B:27:0x0130, B:28:0x016a, B:30:0x0174, B:13:0x00bc, B:15:0x00c2, B:9:0x0042), top: B:99:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void o(com.scores365.dashboardEntities.dashboardScores.n.a.b r16, com.scores365.entitys.GameObj r17, com.scores365.entitys.CompetitionObj r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 1393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.dashboardEntities.dashboardScores.n.o(com.scores365.dashboardEntities.dashboardScores.n$a$b, com.scores365.entitys.GameObj, com.scores365.entitys.CompetitionObj, boolean, boolean):void");
    }

    public static t onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        try {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.T7, viewGroup, false), eVar);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private void p() {
        try {
            if (this.gameObj.getScores()[2].getScore() == -1 || this.gameObj.getScores()[3].getScore() == -1) {
                this.f23548c = null;
                return;
            }
            String str = "Ad";
            String stringScore = this.gameObj.getScores()[2].getScore() == 50 ? "Ad" : this.gameObj.getScores()[2].getStringScore();
            if (this.gameObj.getScores()[3].getScore() != 50) {
                str = this.gameObj.getScores()[3].getStringScore();
            }
            if (x0.l1()) {
                this.f23548c = str + " : " + stringScore;
                return;
            }
            this.f23548c = stringScore + " : " + str;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(a aVar, Context context) {
        aVar.f23551h.setVisibility(0);
        aVar.f23550g.setVisibility(0);
        aVar.f23555l.setTypeface(o0.b(context));
        aVar.f23554k.setTypeface(o0.b(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(a aVar) {
        try {
            RecyclerView.q qVar = (RecyclerView.q) ((t) aVar).itemView.getLayoutParams();
            if (!this.isLastItem || this.hasPlayersItemBelow) {
                ((t) aVar).itemView.setBackgroundResource(p0.T(R.attr.f21560l));
                ((ViewGroup.MarginLayoutParams) qVar).bottomMargin = 0;
            } else {
                ((t) aVar).itemView.setBackgroundResource(p0.T(R.attr.f21572p));
                ((ViewGroup.MarginLayoutParams) qVar).bottomMargin = p0.s(4);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Context context, a aVar, boolean z10, StatusObj statusObj, SportTypeObj sportTypeObj, boolean z11, int i10) {
        try {
            if (z10) {
                u(aVar.f23555l, aVar.f23554k, aVar.f23551h, aVar.f23550g);
            } else {
                u(aVar.f23554k, aVar.f23555l, aVar.f23550g, aVar.f23551h);
            }
            if (statusObj.getIsFinished() && this.gameObj.getToQualify() > 0) {
                if (x0.l(i10, true) ^ (this.gameObj.getToQualify() == 1)) {
                    aVar.f23554k.setTypeface(o0.d(App.m()));
                } else {
                    aVar.f23555l.setTypeface(o0.d(App.m()));
                }
            } else if (this.gameObj.getWinner() > 0) {
                if ((this.gameObj.getWinner() == 1) ^ x0.l1()) {
                    aVar.f23554k.setTypeface(o0.d(App.m()));
                } else {
                    aVar.f23555l.setTypeface(o0.d(App.m()));
                }
            }
            aVar.f23553j.setVisibility(8);
            aVar.f23552i.setVisibility(8);
            if (this.gameObj.GetPossession() == 1) {
                if (z10) {
                    aVar.f23552i.setVisibility(0);
                } else {
                    aVar.f23553j.setVisibility(0);
                }
            } else if (this.gameObj.GetPossession() == 2) {
                if (z10) {
                    aVar.f23553j.setVisibility(0);
                } else {
                    aVar.f23552i.setVisibility(0);
                }
            }
            if (this.f23548c != null) {
                aVar.f23556m.setVisibility(0);
                aVar.f23556m.setText(this.f23548c);
            } else {
                aVar.f23556m.setVisibility(4);
            }
            o(aVar.f23559p, this.gameObj, this.competitionObj, true, z11);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void u(TextView textView, TextView textView2, ImageView imageView, ImageView imageView2) {
        try {
            li.u.A(this.f23546a, imageView, li.u.f(imageView.getLayoutParams().width));
            li.u.A(this.f23547b, imageView2, li.u.f(imageView2.getLayoutParams().width));
            textView.setText(this.gameObj.getComps()[0].getShortName());
            textView2.setText(this.gameObj.getComps()[1].getShortName());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private static void v(GameObj gameObj, a.b bVar) {
        try {
            if (gameObj.getWinner() == -1) {
                ((RelativeLayout) bVar.f23571j.getParent()).setBackgroundColor(p0.A(R.attr.f21565m1));
                ((RelativeLayout) bVar.f23572k.getParent()).setBackgroundColor(p0.A(R.attr.f21565m1));
            } else if (gameObj.getWinner() == 1) {
                ((RelativeLayout) bVar.f23571j.getParent()).setBackgroundColor(p0.A(R.attr.T0));
                ((RelativeLayout) bVar.f23572k.getParent()).setBackgroundColor(p0.A(R.attr.f21598x1));
                if (x0.n1()) {
                    ((RelativeLayout) bVar.f23572k.getParent()).getBackground().setAlpha(160);
                    ((RelativeLayout) bVar.f23571j.getParent()).getBackground().setAlpha(160);
                }
            } else if (gameObj.getWinner() == 2) {
                ((RelativeLayout) bVar.f23571j.getParent()).setBackgroundColor(p0.A(R.attr.f21598x1));
                ((RelativeLayout) bVar.f23572k.getParent()).setBackgroundColor(p0.A(R.attr.T0));
                if (x0.n1()) {
                    ((RelativeLayout) bVar.f23571j.getParent()).getBackground().setAlpha(160);
                    ((RelativeLayout) bVar.f23572k.getParent()).getBackground().setAlpha(160);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.GameTennisLive.ordinal();
    }

    @Override // com.scores365.dashboardEntities.dashboardScores.f, com.scores365.Design.PageObjects.c
    public boolean isMainScoresListItem() {
        return true;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        ((a) e0Var).updateViewHolder(this, false, true, true);
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10, boolean z10, boolean z11) {
        try {
            ((a) e0Var).updateViewHolder(this, z10, true, true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.dashboardEntities.dashboardScores.f
    public void setGameObj(GameObj gameObj) {
        super.setGameObj(gameObj);
        try {
            p();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
