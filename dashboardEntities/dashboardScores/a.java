package com.scores365.dashboardEntities.dashboardScores;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.bets.model.BetLineOption;
import com.scores365.dashboardEntities.dashboardScores.f;
import com.scores365.dashboardEntities.dashboardScores.n;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.oddsPreviewEntities.OddsPreview;
import com.scores365.ui.ScoresOddsView;
import java.util.HashSet;
import java.util.Locale;
import li.o0;
import li.p0;
import li.x0;
import nb.o;
import nb.p;
/* compiled from: AllScoresTennisLiveItem.java */
/* loaded from: classes2.dex */
public class a extends f implements ef.f {

    /* renamed from: a  reason: collision with root package name */
    boolean f23419a;

    /* renamed from: b  reason: collision with root package name */
    private String f23420b;

    /* renamed from: c  reason: collision with root package name */
    private String f23421c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AllScoresTennisLiveItem.java */
    /* renamed from: com.scores365.dashboardEntities.dashboardScores.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0243a extends f.a {

        /* renamed from: f  reason: collision with root package name */
        private final ImageView f23422f;

        /* renamed from: g  reason: collision with root package name */
        private final ImageView f23423g;

        /* renamed from: h  reason: collision with root package name */
        private final TextView f23424h;

        /* renamed from: i  reason: collision with root package name */
        private final TextView f23425i;

        /* renamed from: j  reason: collision with root package name */
        private final TextView f23426j;

        /* renamed from: k  reason: collision with root package name */
        private final ImageView f23427k;

        /* renamed from: l  reason: collision with root package name */
        private final ImageView f23428l;

        /* renamed from: m  reason: collision with root package name */
        private final ScoresOddsView f23429m;

        /* renamed from: n  reason: collision with root package name */
        boolean f23430n;

        /* renamed from: o  reason: collision with root package name */
        private final n.a.b f23431o;

        /* renamed from: p  reason: collision with root package name */
        private final Animation.AnimationListener f23432p;

        /* compiled from: AllScoresTennisLiveItem.java */
        /* renamed from: com.scores365.dashboardEntities.dashboardScores.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class animation.Animation$AnimationListenerC0244a implements Animation.AnimationListener {
            animation.Animation$AnimationListenerC0244a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                try {
                    C0243a.this.f23429m.setVisibility(8);
                    View view = ((t) C0243a.this).itemView;
                    view.setPadding(view.getPaddingLeft(), ((t) C0243a.this).itemView.getPaddingTop(), ((t) C0243a.this).itemView.getPaddingRight(), 0);
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

        public C0243a(View view, q.e eVar) {
            super(view);
            this.f23432p = new animation.Animation$AnimationListenerC0244a();
            this.f23422f = (ImageView) view.findViewById(R.id.Jb);
            this.f23423g = (ImageView) view.findViewById(R.id.f22357va);
            this.f23427k = (ImageView) view.findViewById(R.id.Gb);
            this.f23428l = (ImageView) view.findViewById(R.id.f22291sa);
            TextView textView = (TextView) view.findViewById(R.id.rA);
            this.f23424h = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.Mw);
            this.f23425i = textView2;
            TextView textView3 = (TextView) view.findViewById(R.id.aG);
            this.f23426j = textView3;
            this.f23429m = (ScoresOddsView) view.findViewById(R.id.mq);
            this.leftStripe = view.findViewById(R.id.Cf);
            textView.setTypeface(o0.d(App.m()));
            textView2.setTypeface(o0.d(App.m()));
            textView3.setTypeface(o0.c(App.m()));
            n.a.b bVar = new n.a.b((GridLayout) view.findViewById(R.id.f22385wg));
            this.f23431o = bVar;
            ((t) this).itemView.setOnClickListener(new u(this, eVar));
            bVar.l();
        }

        private void handleHiddenOdds() {
            if (this.f23429m.getVisibility() == 0 || App.f20803w) {
                return;
            }
            this.f23429m.startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21514n));
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

        @Override // com.scores365.dashboardEntities.dashboardScores.f.a, com.scores365.ui.swipe.SwipeableViewHolder
        public float getSwipeWidth() {
            float swipeWidth = super.getSwipeWidth();
            try {
                swipeWidth = this.f23430n ? App.m().getResources().getDimension(R.dimen.A) : App.m().getResources().getDimension(R.dimen.A) * 2.0f;
            } catch (Resources.NotFoundException e10) {
                x0.N1(e10);
            }
            return swipeWidth;
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
            GameObj gameObj;
            OddsPreview oddsPreview;
            HashSet<Integer> hashSet;
            if (fVar instanceof a) {
                boolean l10 = x0.l(fVar.gameObj.homeAwayTeamOrder, true);
                a aVar = (a) fVar;
                aVar.l(this, App.m());
                aVar.m(this, l10);
                if (fVar.gameObj.isEditorsChoice() && (hashSet = xe.j.f42132v0) != null && !hashSet.contains(Integer.valueOf(fVar.gameObj.getID()))) {
                    x0.V1(fVar.gameObj, false);
                    xe.j.f42132v0.add(Integer.valueOf(fVar.gameObj.getID()));
                }
                if (sf.b.X1().L3()) {
                    ((t) this).itemView.setOnLongClickListener(new li.k(fVar.gameObj.getID()).b(this));
                }
                if (z10 && x0.s2() && (oddsPreview = fVar.gameObj.oddsPreview) != null && oddsPreview.getOddsPreviewCell() != null && !fVar.gameObj.oddsPreview.getOddsPreviewCell().isEmpty()) {
                    handleHiddenOdds();
                    this.f23429m.setVisibility(0);
                    this.f23429m.setOddsPreview(fVar.gameObj.oddsPreview.getOddsPreviewCell(), fVar.gameObj.homeAwayTeamOrder);
                    View view = ((t) this).itemView;
                    view.setPadding(view.getPaddingLeft(), ((t) this).itemView.getPaddingTop(), ((t) this).itemView.getPaddingRight(), 0);
                } else if (z10 && x0.s2() && (gameObj = fVar.gameObj) != null && gameObj.getMainOddsObj() != null && fVar.gameObj.getMainOddsObj().lineOptions != null && fVar.gameObj.getMainOddsObj().lineOptions.length > 0) {
                    BetLineOption[] betLineOptionArr = fVar.gameObj.getMainOddsObj().lineOptions;
                    handleHiddenOdds();
                    this.f23429m.setVisibility(0);
                    this.f23429m.setBetLineFromOptions(betLineOptionArr, fVar.gameObj.getMainOddsObj().isConcluded, fVar.gameObj.getMainOddsObj().type, fVar.gameObj.getIsActive(), fVar.gameObj.isScheduled(), fVar.gameObj.homeAwayTeamOrder);
                    View view2 = ((t) this).itemView;
                    view2.setPadding(view2.getPaddingLeft(), ((t) this).itemView.getPaddingTop(), ((t) this).itemView.getPaddingRight(), 0);
                } else if (App.f20803w) {
                    this.f23432p.onAnimationEnd(null);
                } else {
                    AnimationUtils.loadAnimation(App.m(), R.anim.f21515o).setAnimationListener(this.f23432p);
                    this.f23429m.setVisibility(8);
                }
                this.hasNotifications = fVar.hasNotifications;
                this.isSwipable = true;
                this.f23430n = fVar.gameObj.isFinished();
                this.shouldShowLeftStripe = fVar.shouldShowLeftStripe;
                handleLeftStripeVisibility();
                restoreInitialStateWithoutAnimation();
            }
        }
    }

    public a(GameObj gameObj, CompetitionObj competitionObj, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, Locale locale, boolean z15) {
        super(gameObj, competitionObj, z10, z11, z13, locale);
        this.f23420b = null;
        this.f23421c = null;
        this.isScoresTabItem = z12;
        this.isUnderCompetitionsByCountryInAllScores = z15;
        this.f23419a = z14;
        try {
            p pVar = p.Competitors;
            long id2 = gameObj.getComps()[0].getID();
            p pVar2 = p.CountriesRoundFlags;
            this.f23420b = o.x(pVar, id2, 100, 100, true, pVar2, Integer.valueOf(gameObj.getComps()[0].getCountryID()), gameObj.getComps()[0].getImgVer());
            this.f23421c = o.x(pVar, gameObj.getComps()[1].getID(), 100, 100, true, pVar2, Integer.valueOf(gameObj.getComps()[1].getCountryID()), gameObj.getComps()[1].getImgVer());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void n(TextView textView, TextView textView2, ImageView imageView, ImageView imageView2) {
        try {
            imageView.setImageResource(0);
            imageView2.setImageResource(0);
            li.u.A(this.f23420b, imageView, li.u.f(imageView.getLayoutParams().width));
            li.u.A(this.f23421c, imageView2, li.u.f(imageView2.getLayoutParams().width));
            textView.setText(this.gameObj.getComps()[0].getShortName());
            textView2.setText(this.gameObj.getComps()[1].getShortName());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static t onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        try {
            return new C0243a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.K, viewGroup, false), eVar);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // ef.f
    public int getCompetitionId() {
        GameObj gameObj = this.gameObj;
        if (gameObj != null) {
            return gameObj.getCompetitionID();
        }
        return -1;
    }

    @Override // ef.f
    public int getCountryId() {
        CompetitionObj competitionObj = this.competitionObj;
        if (competitionObj != null) {
            return competitionObj.getCid();
        }
        return -1;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.GameAllScoresTennisLive.ordinal();
    }

    public void l(C0243a c0243a, Context context) {
        c0243a.f23423g.setVisibility(0);
        c0243a.f23422f.setVisibility(0);
        c0243a.f23425i.setTypeface(o0.d(context));
        c0243a.f23424h.setTypeface(o0.d(context));
    }

    public void m(C0243a c0243a, boolean z10) {
        try {
            if (z10) {
                n(c0243a.f23425i, c0243a.f23424h, c0243a.f23423g, c0243a.f23422f);
            } else {
                n(c0243a.f23424h, c0243a.f23425i, c0243a.f23422f, c0243a.f23423g);
            }
            c0243a.f23427k.setVisibility(8);
            c0243a.f23428l.setVisibility(8);
            boolean z11 = true;
            if (this.gameObj.GetPossession() == 1) {
                if (z10) {
                    c0243a.f23428l.setVisibility(0);
                } else {
                    c0243a.f23427k.setVisibility(0);
                }
            } else if (this.gameObj.GetPossession() == 2) {
                if (z10) {
                    c0243a.f23427k.setVisibility(0);
                } else {
                    c0243a.f23428l.setVisibility(0);
                }
            }
            c0243a.f23426j.setText(this.gameObj.getGameStatusName());
            c0243a.f23426j.setVisibility(0);
            if (this.gameObj.getIsActive()) {
                c0243a.f23426j.setTextColor(p0.A(R.attr.f21559k1));
            } else {
                c0243a.f23426j.setTextColor(p0.A(R.attr.f21565m1));
            }
            if (this.gameObj.isFinished() && this.gameObj.getToQualify() > 0) {
                boolean l10 = x0.l(this.gameObj.homeAwayTeamOrder, true);
                if (this.gameObj.getToQualify() != 1) {
                    z11 = false;
                }
                if (l10 ^ z11) {
                    c0243a.f23424h.setTypeface(o0.d(App.m()));
                    c0243a.f23425i.setTypeface(o0.b(App.m()));
                } else {
                    c0243a.f23425i.setTypeface(o0.d(App.m()));
                    c0243a.f23424h.setTypeface(o0.b(App.m()));
                }
            } else if (this.gameObj.getWinner() > 0) {
                if (this.gameObj.getWinner() != 1) {
                    z11 = false;
                }
                if (x0.l1() ^ z11) {
                    c0243a.f23424h.setTypeface(o0.d(App.m()));
                    c0243a.f23425i.setTypeface(o0.b(App.m()));
                } else {
                    c0243a.f23425i.setTypeface(o0.d(App.m()));
                    c0243a.f23424h.setTypeface(o0.b(App.m()));
                }
            }
            n.o(c0243a.f23431o, this.gameObj, this.competitionObj, false, this.f23419a);
            if (this.gameObj.getIsActive()) {
                return;
            }
            c0243a.f23427k.setVisibility(8);
            c0243a.f23428l.setVisibility(8);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        ((C0243a) e0Var).updateViewHolder(this, false, true, true);
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10, boolean z10, boolean z11) {
        try {
            ((C0243a) e0Var).updateViewHolder(this, z10, true, true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
