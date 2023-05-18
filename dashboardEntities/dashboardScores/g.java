package com.scores365.dashboardEntities.dashboardScores;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.e1;
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
import com.scores365.entitys.SportTypesEnum;
import com.scores365.entitys.StatusObj;
import com.scores365.entitys.oddsPreviewEntities.OddsPreview;
import com.scores365.ui.ScoresOddsView;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import li.o0;
import li.p0;
import li.x0;
import nb.o;
import nb.p;
/* compiled from: ScoresGameItem.java */
/* loaded from: classes2.dex */
public class g extends f implements ef.f {
    protected static int DEFAULT_HEIGHT = (int) App.m().getResources().getDimension(R.dimen.H);
    private String awayTeamLogoUrl;
    private String homeTeamLogoUrl;
    private final boolean isDivContext;
    boolean isGameHasOnlyGameNotifications;
    private boolean isLiveStatContext;
    private final boolean isPlayerPageContext;
    private Boolean oddsEnabled;
    private final int primaryTextColor;
    private String scoreText;
    private final int secondaryTextColor;
    private final int secondaryTextColor2;
    protected boolean setZ;
    protected boolean shouldAlwaysShowOdds;
    private Boolean teamsRtlForLang;
    private final boolean useRTL;

    /* compiled from: ScoresGameItem.java */
    /* loaded from: classes2.dex */
    public static class a extends f.a {
        C0246a animationListener;
        boolean isOddsViewHidden;
        protected boolean isOddsViewVisible;
        public boolean isOnlyRemoveButton;
        ImageView ivAwayTeamLogo;
        ImageView ivHomeTeamLogo;
        ConstraintLayout mainLayout;
        ScoresOddsView oddsView;
        ValueAnimator oddsViewAnimator;
        ImageView penaltyAway;
        ImageView penaltyHome;
        ImageView sportTypeImage;
        TextView sportTypeName;
        protected ImageView tipsterIcon;
        TextView tvAwayTeamName;
        TextView tvGameScore;
        public TextView tvGameStatus;
        TextView tvHomeTeamName;
        TextView winDescription;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ScoresGameItem.java */
        /* renamed from: com.scores365.dashboardEntities.dashboardScores.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0246a implements Animator.AnimatorListener {

            /* renamed from: a  reason: collision with root package name */
            boolean f23450a = false;

            /* renamed from: b  reason: collision with root package name */
            WeakReference<View> f23451b;

            public C0246a(View view) {
                this.f23451b = new WeakReference<>(view);
            }

            public void a(boolean z10) {
                this.f23450a = z10;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                try {
                    if (this.f23450a) {
                        WeakReference<View> weakReference = this.f23451b;
                        View view = weakReference != null ? weakReference.get() : null;
                        if (view != null) {
                            view.setVisibility(8);
                        }
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ScoresGameItem.java */
        /* loaded from: classes2.dex */
        public static class b implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a  reason: collision with root package name */
            WeakReference<View> f23452a;

            public b(View view) {
                this.f23452a = new WeakReference<>(view);
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    WeakReference<View> weakReference = this.f23452a;
                    View view = weakReference != null ? weakReference.get() : null;
                    if (view != null) {
                        view.setAlpha(animatedFraction);
                        view.setScaleY(animatedFraction);
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        }

        public a(View view, q.e eVar) {
            super(view);
            this.isOddsViewVisible = false;
            this.isOddsViewHidden = true;
            try {
                this.tvGameStatus = (TextView) view.findViewById(R.id.Jz);
                this.ivHomeTeamLogo = (ImageView) view.findViewById(R.id.Jb);
                this.ivAwayTeamLogo = (ImageView) view.findViewById(R.id.f22357va);
                this.tvHomeTeamName = (TextView) view.findViewById(R.id.rA);
                this.tvAwayTeamName = (TextView) view.findViewById(R.id.Mw);
                this.tvGameScore = (TextView) view.findViewById(R.id.Oz);
                this.penaltyHome = (ImageView) view.findViewById(R.id.Co);
                this.penaltyAway = (ImageView) view.findViewById(R.id.Bo);
                this.oddsView = (ScoresOddsView) view.findViewById(R.id.mq);
                this.leftStripe = view.findViewById(R.id.Cf);
                this.tipsterIcon = (ImageView) view.findViewById(R.id.Zd);
                this.winDescription = (TextView) view.findViewById(R.id.fI);
                this.sportTypeImage = (ImageView) view.findViewById(R.id.f22227pd);
                this.sportTypeName = (TextView) view.findViewById(R.id.wE);
                this.mainLayout = (ConstraintLayout) view.findViewById(R.id.f22412y);
                Typeface d10 = o0.d(App.m());
                TextView textView = this.winDescription;
                if (textView != null) {
                    textView.setTypeface(d10);
                }
                ((t) this).itemView.setOnClickListener(new u(this, eVar));
                if (x0.l1()) {
                    ConstraintLayout.b bVar = (ConstraintLayout.b) this.sportTypeImage.getLayoutParams();
                    ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.sportTypeName.getLayoutParams();
                    ConstraintLayout constraintLayout = this.mainLayout;
                    if (constraintLayout != null) {
                        bVar.f4628h = constraintLayout.getId();
                        bVar.f4622e = -1;
                        bVar2.f4624f = -1;
                        bVar2.f4626g = this.sportTypeImage.getId();
                    }
                }
                this.tvHomeTeamName.setTypeface(d10);
                this.tvAwayTeamName.setTypeface(d10);
                this.tvGameScore.setTypeface(d10);
                this.tvGameStatus.setTypeface(d10);
                this.sportTypeName.setTypeface(d10);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        private void adjustWinDescriptionConstraint() {
            ((ConstraintLayout.b) this.oddsView.getLayoutParams()).f4632j = this.winDescription.getId();
        }

        private void handleHiddenOdds() {
            try {
                if (this.isOddsViewHidden && shouldAnimateOdds() && !App.f20803w) {
                    Log.d("oddsBug", "animationDown start");
                    initOddsViewAnimator();
                    this.oddsViewAnimator.cancel();
                    this.animationListener.a(false);
                    this.oddsViewAnimator.setFloatValues(0.0f, 1.0f);
                    this.oddsViewAnimator.start();
                    this.isOddsViewHidden = false;
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        private void initOddsViewAnimator() {
            try {
                if (this.oddsViewAnimator == null) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[0]);
                    this.oddsViewAnimator = ofFloat;
                    ofFloat.setDuration(280L);
                    this.oddsViewAnimator.addUpdateListener(new b(this.oddsView));
                    C0246a c0246a = new C0246a(this.oddsView);
                    this.animationListener = c0246a;
                    this.oddsViewAnimator.addListener(c0246a);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        private boolean setWinDescription(g gVar) {
            boolean z10 = true;
            try {
                StatusObj statusObj = gVar.gameObj.getStatusObj();
                TimeZone timeZone = Calendar.getInstance().getTimeZone();
                TimeUnit timeUnit = TimeUnit.DAYS;
                long time = gVar.gameObj.getSTime().getTime() + timeZone.getRawOffset();
                TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
                long convert = timeUnit.convert(time, timeUnit2);
                long convert2 = timeUnit.convert(System.currentTimeMillis() + timeZone.getRawOffset(), timeUnit2);
                long convert3 = timeUnit2.convert(Long.parseLong(p0.l0("ABOUT_TO_START_TIMEOUT_PARAMETER")), TimeUnit.MINUTES);
                if (gVar.isPlayerPageContext && gVar.gameObj.isNotInSquad()) {
                    this.winDescription.setText(p0.l0("PLAYER_CARD_NOT_IN_SQUAD"));
                    this.winDescription.setTextColor(p0.A(R.attr.f21556j1));
                } else {
                    if (convert == convert2 && !statusObj.getAliasName().equals("OnlyFullTime")) {
                        GameObj gameObj = gVar.gameObj;
                        if (gameObj.isGameAboutToStart(gameObj.gameStartCountDown == -1) && !x0.t1(gVar.gameObj.getSTime().getTime(), convert3)) {
                            this.winDescription.setText(p0.l0("GAME_ABOUT_TO_START"));
                            this.winDescription.setTextColor(p0.A(R.attr.f21556j1));
                        }
                    }
                    if (gVar.gameObj.GetWinDescription().isEmpty() || gVar.gameObj.getSportID() == SportTypesEnum.CRICKET.getValue() || gVar.gameObj.getStID() == 128) {
                        z10 = false;
                    } else {
                        this.winDescription.setText(gVar.gameObj.GetWinDescription());
                        this.winDescription.setTextColor(p0.A(R.attr.f21565m1));
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return z10;
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
                swipeWidth = this.isOnlyRemoveButton ? App.m().getResources().getDimension(R.dimen.A) : App.m().getResources().getDimension(R.dimen.A) * 2.0f;
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

        public boolean shouldAnimateOdds() {
            return true;
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
                this.invertLeftColors = true;
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // com.scores365.dashboardEntities.dashboardScores.f.a
        public void updateViewHolder(f fVar, boolean z10, boolean z11, boolean z12) {
            GameObj gameObj;
            OddsPreview oddsPreview;
            HashSet<Integer> hashSet;
            try {
                if (fVar instanceof g) {
                    Log.d("oddsBug", "updateViewHolder start");
                    g gVar = (g) fVar;
                    boolean z13 = gVar.gameObj.getSportID() == SportTypesEnum.TENNIS.getValue();
                    if (gVar.gameObj.isEditorsChoice() && (hashSet = xe.j.f42132v0) != null && !hashSet.contains(Integer.valueOf(gVar.gameObj.getID()))) {
                        x0.V1(gVar.gameObj, gVar instanceof sg.d);
                        xe.j.f42132v0.add(Integer.valueOf(gVar.gameObj.getID()));
                    }
                    gVar.setData(this, gVar.useRTL, z13, gVar.gameObj.getStatusObj(), gVar.isPlayerPageContext, ((App) App.m()).i().J());
                    if (sf.b.X1().L3()) {
                        ((t) this).itemView.setOnLongClickListener(new li.k(gVar.gameObj.getID()).b(this));
                    }
                    this.isOddsViewVisible = false;
                    if (this.oddsView != null) {
                        if (z10 && gVar.isOddsEnabled() && (oddsPreview = gVar.gameObj.oddsPreview) != null && oddsPreview.getOddsPreviewCell() != null && !gVar.gameObj.oddsPreview.getOddsPreviewCell().isEmpty()) {
                            handleHiddenOdds();
                            this.isOddsViewVisible = true;
                            this.oddsView.setVisibility(0);
                            this.oddsView.setOddsPreview(gVar.gameObj.oddsPreview.getOddsPreviewCell(), gVar.gameObj.homeAwayTeamOrder);
                        } else if (z10 && gVar.isOddsEnabled() && (gameObj = gVar.gameObj) != null && gameObj.getMainOddsObj() != null && gVar.gameObj.getMainOddsObj().lineOptions != null && gVar.gameObj.getMainOddsObj().lineOptions.length > 0) {
                            handleHiddenOdds();
                            BetLineOption[] betLineOptionArr = gVar.gameObj.getMainOddsObj().lineOptions;
                            this.isOddsViewVisible = true;
                            this.oddsView.setVisibility(0);
                            this.oddsView.setBetLineFromOptions(betLineOptionArr, fVar.gameObj.getMainOddsObj().isConcluded, gVar.gameObj.getMainOddsObj().type, fVar.gameObj.getIsActive(), fVar.gameObj.isScheduled(), fVar.gameObj.homeAwayTeamOrder);
                        } else if (z10 || this.isOddsViewHidden || !shouldAnimateOdds()) {
                            this.oddsView.setVisibility(8);
                        } else if (!App.f20803w) {
                            initOddsViewAnimator();
                            this.oddsViewAnimator.cancel();
                            this.animationListener.a(true);
                            this.oddsViewAnimator.setFloatValues(1.0f, 0.0f);
                            this.oddsViewAnimator.start();
                            this.isOddsViewHidden = true;
                        }
                    }
                    this.hasNotifications = gVar.hasNotifications;
                    this.isSwipable = true;
                    this.isOnlyRemoveButton = gVar.gameObj.isFinished();
                    this.shouldShowLeftStripe = gVar.shouldShowLeftStripe;
                    handleLeftStripeVisibility();
                    int i10 = g.DEFAULT_HEIGHT;
                    if (this.isOddsViewVisible) {
                        i10 += p0.s(30);
                    }
                    if (gVar.gameObj.isEditorsShowSportType()) {
                        i10 += p0.s(14);
                    }
                    this.tvGameScore.setVisibility(0);
                    ((ConstraintLayout.b) this.oddsView.getLayoutParams()).f4632j = this.tvGameScore.getId();
                    if (setWinDescription(gVar)) {
                        this.winDescription.setVisibility(0);
                        i10 += p0.s(16);
                        adjustWinDescriptionConstraint();
                    } else {
                        this.winDescription.setVisibility(8);
                    }
                    ((t) this).itemView.getLayoutParams().height = i10;
                    restoreInitialStateWithoutAnimation();
                    if (!gVar.gameObj.isEditorsShowSportType()) {
                        this.sportTypeImage.setVisibility(8);
                        this.sportTypeName.setVisibility(8);
                        return;
                    }
                    this.sportTypeImage.setVisibility(0);
                    this.sportTypeName.setVisibility(0);
                    this.sportTypeImage.setImageResource(p0.v(gVar.gameObj.getSportID(), false));
                    SportTypeObj sportTypeObj = App.l().getSportTypes().get(Integer.valueOf(gVar.gameObj.getSportID()));
                    this.sportTypeName.setText(sportTypeObj != null ? sportTypeObj.getShortName() : "");
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public g(GameObj gameObj, CompetitionObj competitionObj, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, Locale locale, boolean z15, boolean z16, boolean z17) {
        super(gameObj, competitionObj, z10, z11, z13, locale);
        this.homeTeamLogoUrl = null;
        this.awayTeamLogoUrl = null;
        this.oddsEnabled = null;
        this.isLiveStatContext = false;
        this.scoreText = null;
        this.shouldAlwaysShowOdds = false;
        this.teamsRtlForLang = null;
        this.isScoresTabItem = z12;
        this.isGameHasOnlyGameNotifications = z13;
        this.setZ = z14;
        this.isUnderCompetitionsByCountryInAllScores = z16;
        this.isDivContext = z15;
        this.isPlayerPageContext = z17;
        try {
            if (gameObj.getSportID() == SportTypesEnum.TENNIS.getValue()) {
                p pVar = p.Competitors;
                p pVar2 = p.CountriesRoundFlags;
                this.homeTeamLogoUrl = o.x(pVar, gameObj.getComps()[0].getID(), 100, 100, true, pVar2, Integer.valueOf(gameObj.getComps()[0].getCountryID()), gameObj.getComps()[0].getImgVer());
                this.awayTeamLogoUrl = o.x(pVar, gameObj.getComps()[1].getID(), 100, 100, true, pVar2, Integer.valueOf(gameObj.getComps()[1].getCountryID()), gameObj.getComps()[1].getImgVer());
            } else {
                p pVar3 = p.Competitors;
                this.homeTeamLogoUrl = o.l(pVar3, gameObj.getComps()[0].getID(), 70, 70, false, true, Integer.valueOf(gameObj.getSportID()), null, null, gameObj.getComps()[0].getImgVer());
                this.awayTeamLogoUrl = o.l(pVar3, gameObj.getComps()[1].getID(), 70, 70, false, true, Integer.valueOf(gameObj.getSportID()), null, null, gameObj.getComps()[1].getImgVer());
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        this.primaryTextColor = p0.A(R.attr.U0);
        this.secondaryTextColor = p0.A(R.attr.f21565m1);
        this.secondaryTextColor2 = p0.A(R.attr.f21559k1);
        this.useRTL = isTeamsRtlForLang();
        initScoreText(gameObj.getStatusObj());
    }

    private String getGameDate() {
        String T = x0.T(this.gameObj.getSTime(), false);
        if (DateUtils.isToday(this.gameObj.getSTime().getTime())) {
            return p0.l0("TODAY");
        }
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        TimeUnit timeUnit = TimeUnit.DAYS;
        long time = this.gameObj.getSTime().getTime() + timeZone.getRawOffset();
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        return timeUnit.convert(time, timeUnit2) - timeUnit.convert(System.currentTimeMillis() + ((long) timeZone.getRawOffset()), timeUnit2) == 1 ? p0.l0("TOMORROW") : T;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOddsEnabled() {
        try {
            if (this.oddsEnabled == null) {
                this.oddsEnabled = Boolean.valueOf(x0.s2());
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.oddsEnabled.booleanValue();
    }

    private boolean isTeamsRtlForLang() {
        try {
            if (this.teamsRtlForLang == null) {
                this.teamsRtlForLang = Boolean.valueOf(x0.l(this.gameObj.homeAwayTeamOrder, true));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.teamsRtlForLang.booleanValue();
    }

    public static t onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        try {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.Q7, viewGroup, false), eVar);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(a aVar, boolean z10, boolean z11, StatusObj statusObj, boolean z12, boolean z13) {
        GameObj gameObj;
        if (this.isDivContext || this.isLiveStatContext) {
            aVar.tvHomeTeamName.setTextSize(1, 12.0f);
            aVar.tvAwayTeamName.setTextSize(1, 12.0f);
        }
        if (z10) {
            setImageAndTextView(aVar.tvAwayTeamName, aVar.tvHomeTeamName, aVar.ivAwayTeamLogo, aVar.ivHomeTeamLogo, z11);
        } else {
            setImageAndTextView(aVar.tvHomeTeamName, aVar.tvAwayTeamName, aVar.ivHomeTeamLogo, aVar.ivAwayTeamLogo, z11);
        }
        setScoreText(aVar);
        aVar.tvHomeTeamName.setTypeface(o0.b(App.m()));
        aVar.tvAwayTeamName.setTypeface(o0.b(App.m()));
        if (statusObj == null || statusObj.getIsNotStarted() || statusObj.getIsActive()) {
            aVar.tvGameScore.setTextColor(this.primaryTextColor);
        } else if (statusObj.getIsFinished()) {
            aVar.tvGameScore.setTextColor(this.secondaryTextColor);
        } else {
            aVar.tvGameScore.setTextColor(this.secondaryTextColor);
        }
        if (sf.b.X1().r()) {
            aVar.tvGameScore.setTextSize(1, p0.d0(this.scoreText));
        } else {
            aVar.tvGameScore.setTextSize(1, 17.0f);
        }
        setGameStatus(aVar, statusObj);
        if (aVar.tipsterIcon != null) {
            if (!z13 || z12 || App.f20803w || (gameObj = this.gameObj) == null || !gameObj.hasTips() || statusObj == null || !statusObj.getIsNotStarted() || !x0.s2() || !App.l().bets.isDailyTipAvailable() || aVar.tvGameStatus.getVisibility() == 0) {
                aVar.tipsterIcon.setVisibility(8);
            } else {
                aVar.tipsterIcon.setVisibility(0);
            }
        }
        if (!this.gameObj.isFinished()) {
            aVar.penaltyHome.setVisibility(4);
            aVar.penaltyAway.setVisibility(4);
        } else if (this.gameObj == null || statusObj == null || !statusObj.getIsFinished() || this.gameObj.getToQualify() <= 0 || this.gameObj.getToQualify() > 2) {
            aVar.penaltyHome.setVisibility(4);
            aVar.penaltyAway.setVisibility(4);
        } else {
            if (this.useRTL ^ (this.gameObj.getToQualify() == 1)) {
                aVar.penaltyHome.setVisibility(0);
                aVar.penaltyAway.setVisibility(4);
            } else {
                aVar.penaltyHome.setVisibility(4);
                aVar.penaltyAway.setVisibility(0);
            }
        }
        setWinnerBoldTypeFace(aVar);
    }

    private void setImageAndTextView(TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, boolean z10) {
        try {
            if (z10) {
                if (this.homeTeamLogoUrl == null) {
                    this.homeTeamLogoUrl = o.x(p.Competitors, this.gameObj.getComps()[0].getID(), 100, 100, true, p.CountriesRoundFlags, Integer.valueOf(this.gameObj.getComps()[0].getCountryID()), this.gameObj.getComps()[0].getImgVer());
                }
                if (this.awayTeamLogoUrl == null) {
                    this.awayTeamLogoUrl = o.x(p.Competitors, this.gameObj.getComps()[1].getID(), 100, 100, true, p.CountriesRoundFlags, Integer.valueOf(this.gameObj.getComps()[1].getCountryID()), this.gameObj.getComps()[1].getImgVer());
                }
            } else {
                if (this.homeTeamLogoUrl == null) {
                    this.homeTeamLogoUrl = o.s(p.Competitors, this.gameObj.getComps()[0].getID(), 70, 70, false, this.gameObj.getComps()[0].getImgVer());
                }
                if (this.awayTeamLogoUrl == null) {
                    this.awayTeamLogoUrl = o.s(p.Competitors, this.gameObj.getComps()[1].getID(), 70, 70, false, this.gameObj.getComps()[1].getImgVer());
                }
            }
            li.u.A(this.homeTeamLogoUrl, imageView, li.u.f(imageView.getLayoutParams().width));
            li.u.A(this.awayTeamLogoUrl, imageView2, li.u.f(imageView2.getLayoutParams().width));
            textView.setText(this.gameObj.getComps()[0].getName());
            textView2.setText(this.gameObj.getComps()[1].getName());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setScoreText(a aVar) {
        try {
            if (sf.b.X1().r()) {
                aVar.tvGameScore.setText(this.scoreText);
            } else {
                p0.N(this.scoreText, aVar.tvGameScore);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setWinnerBoldTypeFace(a aVar) {
        try {
            GameObj gameObj = this.gameObj;
            if (gameObj != null && gameObj.getWinner() > 0) {
                boolean z10 = true;
                if (this.gameObj.getWinner() != 1) {
                    z10 = false;
                }
                if (this.useRTL ^ z10) {
                    aVar.tvHomeTeamName.setTypeface(o0.d(App.m()));
                    aVar.tvAwayTeamName.setTypeface(o0.b(App.m()));
                } else {
                    aVar.tvAwayTeamName.setTypeface(o0.d(App.m()));
                    aVar.tvHomeTeamName.setTypeface(o0.b(App.m()));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
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

    public String getDateTimeString() {
        GameObj gameObj = this.gameObj;
        return gameObj != null ? x0.U(gameObj.getSTime(), x0.H0(x0.e.SHORT)) : "";
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.Game.ordinal();
    }

    @Override // com.scores365.dashboardEntities.dashboardScores.f
    public void initScoreText(StatusObj statusObj) {
        GameObj gameObj;
        try {
            this.scoreText = "";
            GameObj gameObj2 = this.gameObj;
            if ((gameObj2 != null && gameObj2.getID() < 0) || (statusObj != null && statusObj.getIsNotStarted())) {
                this.scoreText = getDateTimeString();
            } else if (statusObj != null && this.gameObj != null && ((statusObj.getIsFinished() || statusObj.getIsActive()) && this.gameObj.getScores()[1].getScore() != -1 && this.gameObj.getScores()[0].getScore() != -1)) {
                if (this.useRTL) {
                    this.scoreText = this.gameObj.getScores()[1].getScore() + " - " + this.gameObj.getScores()[0].getScore();
                } else {
                    this.scoreText = this.gameObj.getScores()[0].getScore() + " - " + this.gameObj.getScores()[1].getScore();
                }
            }
            if (statusObj == null || (gameObj = this.gameObj) == null || !statusObj.isAbnormal || gameObj.getScores()[1].getScore() >= 0 || this.gameObj.getScores()[0].getScore() >= 0) {
                return;
            }
            this.scoreText = getDateTimeString();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            a aVar = (a) e0Var;
            if (this.setZ) {
                e1.S0(((t) aVar).itemView, p0.s(2));
            }
            aVar.updateViewHolder(this, this.shouldAlwaysShowOdds, true, true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10, boolean z10, boolean z11) {
        try {
            ((a) e0Var).updateViewHolder(this, z10, true, true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected void setGameStatus(a aVar, StatusObj statusObj) {
        if (aVar.tvGameStatus != null) {
            if (statusObj != null && (!statusObj.getIsNotStarted() || statusObj.getIsFinished())) {
                if (statusObj.getIsFinished()) {
                    aVar.tvGameStatus.setVisibility(0);
                    aVar.tvGameStatus.setText(this.gameObj.getGameStatusName());
                    aVar.tvGameStatus.setTextColor(this.secondaryTextColor);
                    return;
                }
                aVar.tvGameStatus.setVisibility(0);
                aVar.tvGameStatus.setText(p0.k0(this.gameObj));
                aVar.tvGameStatus.setTextColor(this.secondaryTextColor2);
            } else if (this.isDivContext || this.isPlayerPageContext) {
                aVar.tvGameStatus.setVisibility(0);
                if (this.isDivContext) {
                    aVar.tvGameStatus.setText(x0.T(this.gameObj.getSTime(), false));
                } else {
                    aVar.tvGameStatus.setText(getGameDate());
                }
            } else if (statusObj == null || !statusObj.isAbnormal || statusObj.getID() == 128) {
                aVar.tvGameStatus.setVisibility(4);
            } else {
                aVar.tvGameStatus.setText(this.gameObj.getGameStatusName());
                aVar.tvGameStatus.setVisibility(0);
            }
        }
    }

    public void setLiveStatContext(boolean z10) {
        this.isLiveStatContext = z10;
    }

    public void setShouldAlwaysShowOdds(boolean z10) {
        this.shouldAlwaysShowOdds = z10;
    }
}
