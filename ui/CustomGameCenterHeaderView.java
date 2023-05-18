package com.scores365.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.scores365.App;
import com.scores365.R;
import com.scores365.branding.BrandAsset;
import com.scores365.branding.BrandingKey;
import com.scores365.branding.BrandingStripItem;
import com.scores365.dashboard.ProgressCircleView;
import com.scores365.entitys.ActiveVarEvent;
import com.scores365.entitys.BaseObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.HockeyShotsHelper;
import com.scores365.entitys.HockeyStrength;
import com.scores365.entitys.RankingObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.entitys.StatusObj;
import com.scores365.entitys.eDashboardSection;
import com.scores365.gameCenter.GameCenterBaseActivity;
import com.scores365.gameCenter.HeaderBonusView;
import com.scores365.ui.tooltips.ToolTipData;
import com.scores365.ui.tooltips.ToolTipDimensions;
import com.scores365.ui.tooltips.ToolTipFactory;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class CustomGameCenterHeaderView extends LinearLayout implements CountDownState, HeaderClickAnalytics {
    public static final int IMAGE_SIZE = 165;
    static final float LOGOS_MAX_SCALE = p0.s(30) / App.m().getResources().getDimension(R.dimen.f21651p);
    static final float LOGOS_MAX_TANSLATION_X = p0.s(35);
    static final int MAIN_CONTAINER_BASIC_HEIGHT = (int) App.m().getResources().getDimension(R.dimen.f21652q);
    int AGGREGATE_HEIGHT;
    ImageView AwayTeamIV;
    TextView AwayTeamTV;
    public int BRANDING_LOGO_HEIGHT;
    ProgressCircleView CircleView;
    RelativeLayout GameLayout;
    ImageView HomeTeamIV;
    TextView HomeTeamTV;
    float LOGOS_MAX_TRANSLATION_Y;
    int RANKING_HEIGHT;
    int WINDESCRIPTION_HEIGHT;
    WeakReference<GameCenterBaseActivity> activityWeakRef;
    ImageView animationArrowLeft;
    ImageView animationArrowRight;
    ImageView animationIMG;
    TextView animationTXT;
    HeaderBonusView awayBonus;
    private String awayTeamLogoUrl;
    LinearLayout awayTeamNameLayout;
    ImageView awayTeamPossession;
    TextView awayTeamRating;
    private int awayToolTipResource;
    BaseballStatusViewsObj baseballStatusViewsObj;
    boolean baseballStatusViewsVisible;
    float bottomTextMaxScale;
    float collapsedAlpha;
    GameCountDownHandler counterHandler;
    ValueAnimator crossFadeNotificationAnimator;
    GameObj gameObj;
    gameTimeUpdateTask gameTimeTask;
    ConstraintLayout hockeyShotsContainer;
    HeaderBonusView homeBonus;
    private String homeTeamLogoUrl;
    LinearLayout homeTeamNameLayout;
    ImageView homeTeamPossession;
    TextView homeTeamRating;
    private int homeToolTipResource;
    ImageView imgArrowAway;
    ImageView imgArrowHome;
    boolean isAlreadyInflated;
    private boolean isAwayToolTipShown;
    private boolean isGameAboutToStart;
    private boolean isGameCompleteDataArrived;
    private boolean isHeaderLogoImpressionSent;
    private boolean isHomeToolTipShown;
    private boolean isInflationResetEnabled;
    boolean isVarEventShown;
    ImageView ivAggregatedStar;
    RelativeLayout leagueHeader;
    ImageView leagueLogo;
    TextView leagueName;
    RelativeLayout leftContainer;
    LinearLayout llAgregateScoreContainer;
    HeaderType mHeaderType;
    LinearLayout mainContainer;
    float middleTextMaxScale;
    float middleTextScaleTranslationY;
    ImageView penaltyAway;
    ImageView penaltyHome;
    ConstraintLayout powerPlayContainer;
    RelativeLayout rightContainer;
    RelativeLayout rlBottomInfo;
    private float scoreTextsScaleTranslationY;
    RelativeLayout scoresContainer;
    private boolean shouldHideCompetitionNameOnTop;
    private int sportId;
    float topTextMaxScale;
    TextView tvAggregatedScore;
    TextView tvAggregatedScoreAway;
    TextView tvAggregatedScoreDash;
    TextView tvAggregatedScoreHome;
    TextView tvAwayRate;
    TextView tvAwayRecord;
    TextView tvAwayTeamScore;
    TextView tvBottom;
    TextView tvHockeyShotsAwayTeamShots;
    TextView tvHockeyShotsHomeTeamShots;
    TextView tvHockeyShotsTitle;
    TextView tvHomeRate;
    TextView tvHomeRecord;
    TextView tvHomeTeamScore;
    TextView tvMiddle;
    TextView tvPowerPlayTime;
    TextView tvPowerPlayTitle;
    TextView tvScoreSeparator;
    TextView tvSpread;
    TextView tvTop;
    TextView tvWinDescription;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scores365.ui.CustomGameCenterHeaderView$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$scores365$ui$CustomGameCenterHeaderView$HeaderType;
        static final /* synthetic */ int[] $SwitchMap$com$scores365$ui$CustomGameCenterHeaderView$eAggregatedType;

        static {
            int[] iArr = new int[eAggregatedType.values().length];
            $SwitchMap$com$scores365$ui$CustomGameCenterHeaderView$eAggregatedType = iArr;
            try {
                iArr[eAggregatedType.aggregate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scores365$ui$CustomGameCenterHeaderView$eAggregatedType[eAggregatedType.series.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[HeaderType.values().length];
            $SwitchMap$com$scores365$ui$CustomGameCenterHeaderView$HeaderType = iArr2;
            try {
                iArr2[HeaderType.LESS_WITH_TIMER.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$scores365$ui$CustomGameCenterHeaderView$HeaderType[HeaderType.LESS_NO_TIMER.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$scores365$ui$CustomGameCenterHeaderView$HeaderType[HeaderType.LIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$scores365$ui$CustomGameCenterHeaderView$HeaderType[HeaderType.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$scores365$ui$CustomGameCenterHeaderView$HeaderType[HeaderType.ABNORMAL_NOT_STARTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class BaseballStatusViewsObj {
        public ConstraintLayout ballsContainer;
        public TextView ballsTitle0;
        public TextView ballsTitle1;
        public TextView ballsTitle2;
        public BaseballStateBallsView ballsView0;
        public BaseballStateBallsView ballsView1;
        public BaseballStateBallsView ballsView2;
        public BaseballDiamondBasesView basesView;

        public BaseballStatusViewsObj(View view) {
            this.basesView = (BaseballDiamondBasesView) view.findViewById(R.id.P);
            this.ballsView0 = (BaseballStateBallsView) view.findViewById(R.id.N0);
            this.ballsView1 = (BaseballStateBallsView) view.findViewById(R.id.O0);
            this.ballsView2 = (BaseballStateBallsView) view.findViewById(R.id.P0);
            this.ballsTitle0 = (TextView) view.findViewById(R.id.Pw);
            this.ballsTitle1 = (TextView) view.findViewById(R.id.Qw);
            this.ballsTitle2 = (TextView) view.findViewById(R.id.Rw);
            this.ballsContainer = (ConstraintLayout) view.findViewById(R.id.X2);
        }
    }

    /* loaded from: classes2.dex */
    public static class CrossFadeAnimationListener implements Animator.AnimatorListener {
        WeakReference<CustomGameCenterHeaderView> customGameCenterHeaderViewRef;

        public CrossFadeAnimationListener(CustomGameCenterHeaderView customGameCenterHeaderView) {
            this.customGameCenterHeaderViewRef = new WeakReference<>(customGameCenterHeaderView);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            WeakReference<CustomGameCenterHeaderView> weakReference = this.customGameCenterHeaderViewRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.customGameCenterHeaderViewRef.get().checkHockeyShotsState(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            try {
                WeakReference<CustomGameCenterHeaderView> weakReference = this.customGameCenterHeaderViewRef;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                this.customGameCenterHeaderViewRef.get().stopNotificationAnim();
                this.customGameCenterHeaderViewRef.get().checkHockeyShotsState(false);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            WeakReference<CustomGameCenterHeaderView> weakReference = this.customGameCenterHeaderViewRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.customGameCenterHeaderViewRef.get().checkHockeyShotsState(true);
        }
    }

    /* loaded from: classes2.dex */
    public static class CrossFadeAnimationUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        WeakReference<View> animationTextViewRef;
        WeakReference<CustomGameCenterHeaderView> headerViewRef;
        WeakReference<View> initialTextViewRef;

        public CrossFadeAnimationUpdateListener(View view, View view2, CustomGameCenterHeaderView customGameCenterHeaderView) {
            this.animationTextViewRef = new WeakReference<>(view2);
            this.initialTextViewRef = new WeakReference<>(view);
            this.headerViewRef = new WeakReference<>(customGameCenterHeaderView);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f10;
            try {
                WeakReference<CustomGameCenterHeaderView> weakReference = this.headerViewRef;
                float f11 = 0.0f;
                if (weakReference == null || weakReference.get() == null) {
                    f10 = 1.0f;
                } else {
                    f10 = this.headerViewRef.get().collapsedAlpha;
                    if (f10 < 0.0f) {
                        f10 = 0.0f;
                    }
                }
                float animatedFraction = (valueAnimator.getAnimatedFraction() - 0.5f) * 2.0f * f10;
                if (animatedFraction < 0.0f) {
                    animatedFraction = 0.0f;
                }
                float animatedFraction2 = (1.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * f10;
                if (animatedFraction2 >= 0.0f) {
                    f11 = animatedFraction2;
                }
                WeakReference<View> weakReference2 = this.animationTextViewRef;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.animationTextViewRef.get().setAlpha(animatedFraction);
                }
                WeakReference<View> weakReference3 = this.initialTextViewRef;
                if (weakReference3 == null || weakReference3.get() == null) {
                    return;
                }
                this.initialTextViewRef.get().setAlpha(f11);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class GameCountDownHandler extends CountDownTimer {
        private WeakReference<CountDownState> countDownStateRef;
        private WeakReference<TextView> textViewRef;

        public GameCountDownHandler(TextView textView, GameObj gameObj, CountDownState countDownState) {
            super(TimeUnit.SECONDS.toMillis(gameObj.gameStartCountDown), 1000L);
            try {
                this.textViewRef = new WeakReference<>(textView);
                this.countDownStateRef = new WeakReference<>(countDownState);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            try {
                TextView textView = this.textViewRef.get();
                if (textView != null) {
                    textView.setText("00:00:00");
                    CountDownState countDownState = this.countDownStateRef.get();
                    if (countDownState != null) {
                        countDownState.counterFinished();
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            try {
                TextView textView = this.textViewRef.get();
                if (textView != null) {
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    long seconds = timeUnit.toSeconds(j10) - TimeUnit.MINUTES.toSeconds(timeUnit.toMinutes(j10));
                    if (seconds < 1) {
                        seconds = 0;
                    }
                    textView.setText(String.format("%02d:%02d:%02d", Long.valueOf(timeUnit.toHours(j10)), Long.valueOf(timeUnit.toMinutes(j10) - TimeUnit.HOURS.toMinutes(timeUnit.toHours(j10))), Long.valueOf(seconds)));
                    CountDownState countDownState = this.countDownStateRef.get();
                    if (countDownState != null) {
                        countDownState.counterTick();
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum HeaderType {
        LESS_NO_TIMER,
        LESS_WITH_TIMER,
        LIVE,
        FINISHED,
        ABNORMAL_NOT_STARTED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class OpenSingleCompetitorDashboard implements View.OnClickListener {
        BaseObj entity;
        WeakReference<GameCenterBaseActivity> gameCenterBaseActivityWeakReference;
        WeakReference<HeaderClickAnalytics> headerClickAnalyticsRef;
        Type type;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public enum Type {
            Competitor,
            Competition
        }

        public OpenSingleCompetitorDashboard(BaseObj baseObj, WeakReference<GameCenterBaseActivity> weakReference, Type type) {
            this.entity = baseObj;
            this.gameCenterBaseActivityWeakReference = weakReference;
            this.type = type;
        }

        public OpenSingleCompetitorDashboard(BaseObj baseObj, WeakReference<HeaderClickAnalytics> weakReference, WeakReference<GameCenterBaseActivity> weakReference2, Type type) {
            this.entity = baseObj;
            this.headerClickAnalyticsRef = weakReference;
            this.gameCenterBaseActivityWeakReference = weakReference2;
            this.type = type;
        }

        private String getEntityEntranceByType(Type type) {
            if (type != null) {
                if (type.equals(Type.Competition)) {
                    return "gamecenter_competition_name_header";
                }
                if (type.equals(Type.Competitor)) {
                    return "gamecenter_competitor_logo_header";
                }
            }
            return "";
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HeaderClickAnalytics headerClickAnalytics;
            try {
                if (this.entity != null) {
                    Context context = view.getContext();
                    Intent t10 = x0.t(this.entity, false, eDashboardSection.SCORES, false, new ee.l("gamecenter", getEntityEntranceByType(this.type)));
                    t10.addFlags(335544320);
                    GameCenterBaseActivity gameCenterBaseActivity = this.gameCenterBaseActivityWeakReference.get();
                    if (gameCenterBaseActivity != null) {
                        gameCenterBaseActivity.startActivityForResult(t10, 444);
                    } else {
                        context.startActivity(t10);
                    }
                    WeakReference<HeaderClickAnalytics> weakReference = this.headerClickAnalyticsRef;
                    if (weakReference == null || (headerClickAnalytics = weakReference.get()) == null) {
                        return;
                    }
                    headerClickAnalytics.sendHeaderClickAnalytics(this.entity);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum eAggregatedType {
        aggregate,
        series
    }

    /* loaded from: classes2.dex */
    private static class gameTimeUpdateTask extends TimerTask {
        private WeakReference<GameObj> gameObjRef;
        private Handler handler = new Handler();
        private WeakReference<TextView> tvTimeRef;

        public gameTimeUpdateTask(TextView textView, GameObj gameObj) {
            this.tvTimeRef = new WeakReference<>(textView);
            this.gameObjRef = new WeakReference<>(gameObj);
        }

        public void Clear() {
            try {
                cancel();
                this.tvTimeRef = null;
                this.gameObjRef = null;
                Handler handler = this.handler;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                this.handler = null;
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                WeakReference<TextView> weakReference = this.tvTimeRef;
                if (weakReference == null || this.gameObjRef == null) {
                    return;
                }
                TextView textView = weakReference.get();
                GameObj gameObj = this.gameObjRef.get();
                if (textView == null || gameObj == null) {
                    return;
                }
                this.handler.post(new gameTimeUpdaterRunnable(textView, (gameObj.getBaseballStatusObj() == null || gameObj.getBaseballStatusObj().getInningDescription() == null || gameObj.getBaseballStatusObj().getInningDescription().isEmpty()) ? x0.i0(gameObj) : new SpannableStringBuilder(gameObj.getBaseballStatusObj().getInningDescription())));
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class gameTimeUpdaterRunnable implements Runnable {
        private SpannableStringBuilder time;
        private WeakReference<TextView> tvTimeRef;

        public gameTimeUpdaterRunnable(TextView textView, SpannableStringBuilder spannableStringBuilder) {
            this.tvTimeRef = new WeakReference<>(textView);
            this.time = spannableStringBuilder;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = this.tvTimeRef.get();
            if (textView != null) {
                try {
                    if (textView.getText().toString().equals(this.time.toString()) || this.time.length() <= 0) {
                        return;
                    }
                    textView.setText(this.time);
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        }
    }

    public CustomGameCenterHeaderView(Context context) {
        super(context);
        this.collapsedAlpha = 1.0f;
        this.topTextMaxScale = 1.0f;
        this.middleTextMaxScale = 1.0f;
        this.bottomTextMaxScale = 1.0f;
        this.middleTextScaleTranslationY = 0.0f;
        this.scoreTextsScaleTranslationY = 0.0f;
        this.LOGOS_MAX_TRANSLATION_Y = 0.0f;
        this.AGGREGATE_HEIGHT = 0;
        this.WINDESCRIPTION_HEIGHT = 0;
        this.RANKING_HEIGHT = 0;
        this.BRANDING_LOGO_HEIGHT = 0;
        this.baseballStatusViewsVisible = false;
        this.crossFadeNotificationAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gameObj = null;
        this.homeTeamLogoUrl = null;
        this.awayTeamLogoUrl = null;
        this.isHeaderLogoImpressionSent = false;
        this.sportId = -1;
        this.homeToolTipResource = -1;
        this.awayToolTipResource = -1;
        this.isGameCompleteDataArrived = false;
        this.isAlreadyInflated = false;
        this.isVarEventShown = false;
    }

    public CustomGameCenterHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.collapsedAlpha = 1.0f;
        this.topTextMaxScale = 1.0f;
        this.middleTextMaxScale = 1.0f;
        this.bottomTextMaxScale = 1.0f;
        this.middleTextScaleTranslationY = 0.0f;
        this.scoreTextsScaleTranslationY = 0.0f;
        this.LOGOS_MAX_TRANSLATION_Y = 0.0f;
        this.AGGREGATE_HEIGHT = 0;
        this.WINDESCRIPTION_HEIGHT = 0;
        this.RANKING_HEIGHT = 0;
        this.BRANDING_LOGO_HEIGHT = 0;
        this.baseballStatusViewsVisible = false;
        this.crossFadeNotificationAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gameObj = null;
        this.homeTeamLogoUrl = null;
        this.awayTeamLogoUrl = null;
        this.isHeaderLogoImpressionSent = false;
        this.sportId = -1;
        this.homeToolTipResource = -1;
        this.awayToolTipResource = -1;
        this.isGameCompleteDataArrived = false;
        this.isAlreadyInflated = false;
        this.isVarEventShown = false;
    }

    public CustomGameCenterHeaderView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.collapsedAlpha = 1.0f;
        this.topTextMaxScale = 1.0f;
        this.middleTextMaxScale = 1.0f;
        this.bottomTextMaxScale = 1.0f;
        this.middleTextScaleTranslationY = 0.0f;
        this.scoreTextsScaleTranslationY = 0.0f;
        this.LOGOS_MAX_TRANSLATION_Y = 0.0f;
        this.AGGREGATE_HEIGHT = 0;
        this.WINDESCRIPTION_HEIGHT = 0;
        this.RANKING_HEIGHT = 0;
        this.BRANDING_LOGO_HEIGHT = 0;
        this.baseballStatusViewsVisible = false;
        this.crossFadeNotificationAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gameObj = null;
        this.homeTeamLogoUrl = null;
        this.awayTeamLogoUrl = null;
        this.isHeaderLogoImpressionSent = false;
        this.sportId = -1;
        this.homeToolTipResource = -1;
        this.awayToolTipResource = -1;
        this.isGameCompleteDataArrived = false;
        this.isAlreadyInflated = false;
        this.isVarEventShown = false;
    }

    private void addHockeyPowerPlay() {
        GameObj gameObj;
        try {
            this.powerPlayContainer.setVisibility(8);
            this.hockeyShotsContainer.setVisibility(8);
            if (this.gameObj.getSportID() != SportTypesEnum.HOCKEY.getValue() || (gameObj = this.gameObj) == null) {
                return;
            }
            if (gameObj.getHockeyStrength() == null || this.gameObj.getHockeyStrength().getCompetitorNum() < 1 || this.gameObj.getHockeyStrength().getCompetitorNum() > 3) {
                HockeyShotsHelper hockeyShotsHelper = this.gameObj.getHockeyShotsHelper();
                if (hockeyShotsHelper != null) {
                    this.hockeyShotsContainer.setVisibility(0);
                    this.tvHockeyShotsHomeTeamShots.setText(hockeyShotsHelper.getHomeTeamScores());
                    this.tvHockeyShotsAwayTeamShots.setText(hockeyShotsHelper.getAwayTeamScores());
                    this.tvHockeyShotsTitle.setText(hockeyShotsHelper.getTitle());
                    return;
                }
                return;
            }
            HockeyStrength hockeyStrength = this.gameObj.getHockeyStrength();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.powerPlayContainer.getLayoutParams();
            if (hockeyStrength.getCompetitorNum() == 3) {
                layoutParams.addRule(21);
                layoutParams.addRule(20);
            } else if (x0.l(this.gameObj.homeAwayTeamOrder, true)) {
                if (hockeyStrength.getCompetitorNum() == 2) {
                    layoutParams.addRule(20);
                    layoutParams.removeRule(21);
                } else {
                    layoutParams.addRule(21);
                    layoutParams.removeRule(20);
                }
            } else if (hockeyStrength.getCompetitorNum() == 1) {
                layoutParams.addRule(20);
                layoutParams.removeRule(21);
            } else {
                layoutParams.addRule(21);
                layoutParams.removeRule(20);
            }
            this.powerPlayContainer.setVisibility(0);
            this.tvPowerPlayTitle.setText(hockeyStrength.getDesc());
            this.tvPowerPlayTime.setText(hockeyStrength.getTimeLeft());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void addTeamFoulsViews() {
        try {
            if (this.gameObj.getSportID() != SportTypesEnum.BASKETBALL.getValue()) {
                this.homeBonus.setVisibility(4);
                this.awayBonus.setVisibility(4);
                return;
            }
            if (this.gameObj.getTeamFoulsObj() == null || this.gameObj.getTeamFoulsObj().a().isEmpty() || this.gameObj.getTeamFoulsObj().a().get(0) == null) {
                this.homeBonus.setVisibility(4);
            } else {
                this.homeBonus.d(this.gameObj.getTeamFoulsObj().a().get(0), this.gameObj.getTeamFoulsObj().b(), "home");
                this.homeBonus.setVisibility(0);
            }
            if (this.gameObj.getTeamFoulsObj().a() == null || this.gameObj.getTeamFoulsObj().a().size() <= 1 || this.gameObj.getTeamFoulsObj().a().get(1) == null) {
                this.awayBonus.setVisibility(4);
                return;
            }
            this.awayBonus.d(this.gameObj.getTeamFoulsObj().a().get(1), this.gameObj.getTeamFoulsObj().b(), "away");
            this.awayBonus.setVisibility(0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static void addVarEvent(ActiveVarEvent activeVarEvent, View view, View view2, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, int i10, boolean z10, ValueAnimator valueAnimator, CustomGameCenterHeaderView customGameCenterHeaderView, int i11) {
        try {
            if (valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(App.m(), R.anim.f21506f);
            view2.setVisibility(4);
            textView.startAnimation(loadAnimation);
            textView.setVisibility(0);
            textView.setText(p0.l0("GC_VAR"));
            textView.setTypeface(nb.v.m());
            imageView.setVisibility(0);
            imageView.setImageResource(activeVarEvent.getTypeIconResourse(z10));
            if ((activeVarEvent.getCompetitor() == 1) ^ x0.l(i11, true)) {
                imageView2.setVisibility(0);
                imageView3.setVisibility(8);
            } else {
                imageView3.setVisibility(0);
                imageView2.setVisibility(8);
            }
            valueAnimator.addUpdateListener(new CrossFadeAnimationUpdateListener(view, textView, customGameCenterHeaderView));
            valueAnimator.setDuration(1000L);
            valueAnimator.setRepeatMode(2);
            valueAnimator.setRepeatCount(-1);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.start();
            imageView.startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21513m));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkHockeyShotsState(boolean z10) {
        GameObj gameObj = this.gameObj;
        if (gameObj == null || gameObj.getSportID() != SportTypesEnum.HOCKEY.getValue() || this.gameObj.getHockeyShotsHelper() == null) {
            return;
        }
        this.hockeyShotsContainer.setVisibility(z10 ? 8 : 0);
    }

    private void drawNotificationAnim(GameObj.LatestNotifications latestNotifications) {
        try {
            if (latestNotifications.IsNotificationExpired() || this.gameObj.getBaseballStatusObj() != null) {
                return;
            }
            if (this.crossFadeNotificationAnimator.isRunning()) {
                this.crossFadeNotificationAnimator.cancel();
            }
            this.animationIMG.setVisibility(0);
            li.u.A(nb.o.r(nb.p.NotificationsAnimationsDark, latestNotifications.ID, Integer.valueOf(p0.s(20)), Integer.valueOf(p0.s(20)), false), this.animationIMG, null);
            String str = latestNotifications.Name;
            if (str != null && !str.isEmpty()) {
                this.animationTXT.setVisibility(0);
                this.animationTXT.setText(latestNotifications.Name);
                this.animationTXT.setTextColor(p0.A(R.attr.T0));
                this.animationTXT.setTypeface(o0.d(App.m()));
                this.crossFadeNotificationAnimator.addUpdateListener(new CrossFadeAnimationUpdateListener(this.tvTop, this.animationTXT, this));
                this.crossFadeNotificationAnimator.addListener(new CrossFadeAnimationListener(this));
                this.crossFadeNotificationAnimator.setDuration(1000L);
                this.crossFadeNotificationAnimator.setRepeatMode(2);
                this.crossFadeNotificationAnimator.setRepeatCount((int) (((latestNotifications.expiredTime - System.currentTimeMillis()) / 1000) + 1));
                this.crossFadeNotificationAnimator.setInterpolator(new LinearInterpolator());
                this.crossFadeNotificationAnimator.start();
            }
            boolean l10 = x0.l(this.gameObj.homeAwayTeamOrder, true);
            if ((latestNotifications.getCompetitorNum() != 1 || l10) && !(latestNotifications.getCompetitorNum() == 2 && l10)) {
                this.animationArrowLeft.setVisibility(8);
            } else {
                this.animationArrowLeft.setVisibility(0);
            }
            if ((latestNotifications.getCompetitorNum() != 2 || l10) && !(latestNotifications.getCompetitorNum() == 1 && l10)) {
                this.animationArrowRight.setVisibility(8);
            } else {
                this.animationArrowRight.setVisibility(0);
            }
            if (!latestNotifications.isAlreadyRender) {
                this.animationIMG.startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21513m));
            }
            this.tvBottom.setVisibility(8);
            latestNotifications.isAlreadyRender = true;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private String getBallPossessionToolTipText(StatusObj statusObj) {
        return isGameHalfTime(statusObj) ? getHalfTimeToolTipTerm() : getLiveBallPossessionToolTipTerm();
    }

    public static String getDateString(Date date) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            boolean z10 = true;
            if (calendar.get(1) >= Calendar.getInstance().get(1)) {
                z10 = false;
            }
            return x0.T(date, z10);
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    private String getHalfTimeToolTipTerm() {
        return p0.l0("HALF_TIME_POSSESSION_TOOLTIP_TEXT");
    }

    private String getLiveBallPossessionToolTipTerm() {
        return p0.l0("LIVE_GAME_POSSESSION_TOOLTIP_TEXT");
    }

    public static int getPossessionIconResource(int i10) {
        int i11 = 0;
        try {
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (i10 == 3) {
            i11 = R.drawable.B3;
        } else if (i10 == 11) {
            i11 = R.drawable.R2;
        } else if (i10 != 6) {
            if (i10 == 7) {
                i11 = R.drawable.P2;
            }
            return i11;
        } else {
            i11 = R.drawable.O2;
        }
        return i11;
    }

    private StatusObj getStatusObj() {
        return this.gameObj.getStatusObj();
    }

    public static SpannableStringBuilder getTopTextValue(HeaderType headerType, GameObj gameObj) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            if (gameObj.getBaseballStatusObj() != null && gameObj.getBaseballStatusObj().getInningDescription() != null && !gameObj.getBaseballStatusObj().getInningDescription().isEmpty()) {
                spannableStringBuilder.append((CharSequence) gameObj.getBaseballStatusObj().getInningDescription());
            } else if (headerType == HeaderType.LIVE) {
                spannableStringBuilder = x0.i0(gameObj);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return spannableStringBuilder;
    }

    public static boolean handleBaseballStatusViews(GameObj gameObj, BaseballStatusViewsObj baseballStatusViewsObj, boolean z10) {
        try {
            if (gameObj.getBaseballStatusObj() == null || gameObj.isFinished()) {
                return false;
            }
            int color = App.m().getResources().getColor(z10 ? R.color.f21625o : R.color.f21615e);
            baseballStatusViewsObj.basesView.setVisibility(0);
            baseballStatusViewsObj.ballsContainer.setVisibility(0);
            baseballStatusViewsObj.basesView.setLoadedBases(gameObj.getBaseballStatusObj().getLoadedBases());
            baseballStatusViewsObj.basesView.setCubeOutlineColor(color);
            baseballStatusViewsObj.basesView.invalidate();
            baseballStatusViewsObj.ballsView0.setOverallBalls(4);
            baseballStatusViewsObj.ballsView0.setFilledBalls(gameObj.getBaseballStatusObj().getBalls());
            baseballStatusViewsObj.ballsView0.setCircleFillerColor(p0.A(R.attr.f21562l1));
            baseballStatusViewsObj.ballsView1.setOverallBalls(3);
            baseballStatusViewsObj.ballsView1.setFilledBalls(gameObj.getBaseballStatusObj().getStrikes());
            baseballStatusViewsObj.ballsView1.setCircleFillerColor(p0.A(R.attr.f21559k1));
            baseballStatusViewsObj.ballsView2.setOverallBalls(3);
            baseballStatusViewsObj.ballsView2.setFilledBalls(gameObj.getBaseballStatusObj().getOuts());
            baseballStatusViewsObj.ballsView2.setCircleFillerColor(p0.A(R.attr.f21556j1));
            baseballStatusViewsObj.ballsTitle0.setText(p0.l0("BALLINDICATION"));
            baseballStatusViewsObj.ballsTitle1.setText(p0.l0("STRIKEINDICATION"));
            baseballStatusViewsObj.ballsTitle2.setText(p0.l0("OUTINDICATION"));
            baseballStatusViewsObj.ballsTitle0.setTypeface(o0.c(App.m()));
            baseballStatusViewsObj.ballsTitle1.setTypeface(o0.c(App.m()));
            baseballStatusViewsObj.ballsTitle2.setTypeface(o0.c(App.m()));
            baseballStatusViewsObj.ballsView0.setCircleOutlineColor(color);
            baseballStatusViewsObj.ballsView1.setCircleOutlineColor(color);
            baseballStatusViewsObj.ballsView2.setCircleOutlineColor(color);
            baseballStatusViewsObj.ballsView0.invalidate();
            baseballStatusViewsObj.ballsView1.invalidate();
            baseballStatusViewsObj.ballsView2.invalidate();
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    private void handleScoreViews() {
        this.tvMiddle.setVisibility(8);
        this.tvScoreSeparator.setVisibility(0);
    }

    private void inflateViews(GameObj gameObj, CompetitionObj competitionObj) {
        try {
            if (this.isInflationResetEnabled) {
                removeView(this.GameLayout);
                this.isInflationResetEnabled = false;
            }
            if (!this.isAlreadyInflated) {
                this.tvTop = null;
                this.tvMiddle = null;
                this.tvBottom = null;
                this.CircleView = null;
                this.isAlreadyInflated = true;
                this.GameLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.B2, (ViewGroup) null, false);
                setBackgroundColor(0);
                addView(this.GameLayout);
                this.mainContainer = (LinearLayout) this.GameLayout.findViewById(R.id.f22208og);
                this.tvTop = (TextView) this.GameLayout.findViewById(R.id.sH);
                this.tvMiddle = (TextView) this.GameLayout.findViewById(R.id.oD);
                this.CircleView = (ProgressCircleView) this.GameLayout.findViewById(R.id.Pj);
                this.tvBottom = (TextView) this.GameLayout.findViewById(R.id.bx);
                TextView textView = (TextView) this.GameLayout.findViewById(R.id.xE);
                this.tvSpread = textView;
                textView.setTypeface(o0.d(App.m()));
                this.sportId = gameObj.getSportID();
                ImageView imageView = (ImageView) this.GameLayout.findViewById(R.id.Pb);
                this.leagueLogo = imageView;
                imageView.setVisibility(8);
                this.leagueName = (TextView) this.GameLayout.findViewById(R.id.Qb);
                RelativeLayout relativeLayout = (RelativeLayout) this.GameLayout.findViewById(R.id.f22340uf);
                this.leagueHeader = relativeLayout;
                relativeLayout.setVisibility(0);
                if (x0.l(gameObj.homeAwayTeamOrder, true)) {
                    this.homeTeamNameLayout = (LinearLayout) this.GameLayout.findViewById(R.id.Tf);
                    this.awayTeamNameLayout = (LinearLayout) this.GameLayout.findViewById(R.id.f22031gg);
                    this.HomeTeamIV = (ImageView) this.GameLayout.findViewById(R.id.f22224pa);
                    this.AwayTeamIV = (ImageView) this.GameLayout.findViewById(R.id.Db);
                    this.HomeTeamTV = (TextView) this.GameLayout.findViewById(R.id.Iw);
                    this.AwayTeamTV = (TextView) this.GameLayout.findViewById(R.id.nA);
                    this.tvHomeRate = (TextView) this.GameLayout.findViewById(R.id.Dt);
                    this.tvAwayRate = (TextView) this.GameLayout.findViewById(R.id.tu);
                    this.tvHomeRecord = (TextView) this.GameLayout.findViewById(R.id.Kw);
                    this.tvAwayRecord = (TextView) this.GameLayout.findViewById(R.id.pA);
                    this.homeTeamRating = (TextView) this.GameLayout.findViewById(R.id.Jw);
                    this.awayTeamRating = (TextView) this.GameLayout.findViewById(R.id.oA);
                    this.homeTeamPossession = (ImageView) this.GameLayout.findViewById(R.id.f22291sa);
                    this.awayTeamPossession = (ImageView) this.GameLayout.findViewById(R.id.Gb);
                    this.tvHockeyShotsHomeTeamShots = (TextView) this.GameLayout.findViewById(R.id.gn);
                    this.tvHockeyShotsAwayTeamShots = (TextView) this.GameLayout.findViewById(R.id.f22406xf);
                    this.homeBonus = (HeaderBonusView) this.GameLayout.findViewById(R.id.W6);
                    this.awayBonus = (HeaderBonusView) this.GameLayout.findViewById(R.id.X6);
                    this.imgArrowHome = (ImageView) this.GameLayout.findViewById(R.id.f22311t8);
                    this.imgArrowAway = (ImageView) this.GameLayout.findViewById(R.id.f22289s8);
                    this.homeToolTipResource = R.drawable.f21821t6;
                    this.awayToolTipResource = R.drawable.f21813s6;
                } else {
                    this.homeTeamNameLayout = (LinearLayout) this.GameLayout.findViewById(R.id.f22031gg);
                    this.awayTeamNameLayout = (LinearLayout) this.GameLayout.findViewById(R.id.Tf);
                    this.HomeTeamIV = (ImageView) this.GameLayout.findViewById(R.id.Db);
                    this.AwayTeamIV = (ImageView) this.GameLayout.findViewById(R.id.f22224pa);
                    this.HomeTeamTV = (TextView) this.GameLayout.findViewById(R.id.nA);
                    this.AwayTeamTV = (TextView) this.GameLayout.findViewById(R.id.Iw);
                    this.tvHomeRate = (TextView) this.GameLayout.findViewById(R.id.tu);
                    this.tvAwayRate = (TextView) this.GameLayout.findViewById(R.id.Dt);
                    this.tvHomeRecord = (TextView) this.GameLayout.findViewById(R.id.pA);
                    this.tvAwayRecord = (TextView) this.GameLayout.findViewById(R.id.Kw);
                    this.homeTeamRating = (TextView) this.GameLayout.findViewById(R.id.oA);
                    this.awayTeamRating = (TextView) this.GameLayout.findViewById(R.id.Jw);
                    this.homeTeamPossession = (ImageView) this.GameLayout.findViewById(R.id.Gb);
                    this.awayTeamPossession = (ImageView) this.GameLayout.findViewById(R.id.f22291sa);
                    this.homeBonus = (HeaderBonusView) this.GameLayout.findViewById(R.id.X6);
                    this.awayBonus = (HeaderBonusView) this.GameLayout.findViewById(R.id.W6);
                    this.imgArrowHome = (ImageView) this.GameLayout.findViewById(R.id.f22289s8);
                    this.imgArrowAway = (ImageView) this.GameLayout.findViewById(R.id.f22311t8);
                    this.homeToolTipResource = R.drawable.f21813s6;
                    this.awayToolTipResource = R.drawable.f21821t6;
                    this.tvHockeyShotsHomeTeamShots = (TextView) this.GameLayout.findViewById(R.id.f22406xf);
                    this.tvHockeyShotsAwayTeamShots = (TextView) this.GameLayout.findViewById(R.id.gn);
                }
                this.powerPlayContainer = (ConstraintLayout) this.GameLayout.findViewById(R.id.f22367vk);
                this.hockeyShotsContainer = (ConstraintLayout) this.GameLayout.findViewById(R.id.W7);
                this.tvPowerPlayTitle = (TextView) this.GameLayout.findViewById(R.id.Yu);
                this.tvPowerPlayTime = (TextView) this.GameLayout.findViewById(R.id.Xu);
                this.tvAwayTeamScore = (TextView) this.GameLayout.findViewById(R.id.Nw);
                this.tvHomeTeamScore = (TextView) this.GameLayout.findViewById(R.id.sA);
                if (x0.F2(gameObj.getSportID())) {
                    this.HomeTeamIV.getLayoutParams().width = p0.s(56);
                    this.HomeTeamIV.getLayoutParams().height = p0.s(56);
                    this.AwayTeamIV.getLayoutParams().width = p0.s(56);
                    this.AwayTeamIV.getLayoutParams().height = p0.s(56);
                    this.HomeTeamTV.setMinLines(2);
                    this.HomeTeamTV.setGravity(17);
                    this.AwayTeamTV.setMinLines(2);
                    this.AwayTeamTV.setGravity(17);
                }
                this.tvPowerPlayTitle.setTypeface(o0.d(App.m()));
                this.tvPowerPlayTime.setTypeface(o0.d(App.m()));
                TextView textView2 = (TextView) this.GameLayout.findViewById(R.id.X7);
                this.tvHockeyShotsTitle = textView2;
                textView2.setTypeface(o0.d(App.m()));
                this.tvHockeyShotsHomeTeamShots.setTypeface(o0.d(App.m()));
                this.tvHockeyShotsAwayTeamShots.setTypeface(o0.d(App.m()));
                this.homeBonus.setVisibility(4);
                this.awayBonus.setVisibility(4);
                this.imgArrowHome.setVisibility(4);
                this.imgArrowAway.setVisibility(4);
                this.tvScoreSeparator = (TextView) this.GameLayout.findViewById(R.id.zD);
                this.baseballStatusViewsObj = new BaseballStatusViewsObj(this.GameLayout);
                this.rightContainer = (RelativeLayout) this.GameLayout.findViewById(R.id.in);
                this.leftContainer = (RelativeLayout) this.GameLayout.findViewById(R.id.f22450zf);
                this.penaltyHome = (ImageView) this.GameLayout.findViewById(R.id.Co);
                this.penaltyAway = (ImageView) this.GameLayout.findViewById(R.id.Bo);
            }
            assignOnClickListeners(gameObj, competitionObj);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void initProgressView(ProgressCircleView progressCircleView, GameObj gameObj) {
        try {
            ArrayList<ProgressCircleView.a> arrayList = new ArrayList<>();
            arrayList.add(new ProgressCircleView.a(progressCircleView.f23312a, 0.0f, 100.0f));
            if (App.l().getSportTypes().get(Integer.valueOf(gameObj.getSportID())).getStatuses().get(Integer.valueOf(gameObj.getStID())).isExtraTime()) {
                arrayList.add(new ProgressCircleView.a(progressCircleView.f23314c, 0.0f, (float) gameObj.gameTimeCompletion));
                arrayList.add(new ProgressCircleView.a(progressCircleView.f23313b, 0.0f, gameObj.regularTimeCompletion));
            } else {
                arrayList.add(new ProgressCircleView.a(progressCircleView.f23313b, 0.0f, (float) gameObj.gameTimeCompletion));
            }
            progressCircleView.d(gameObj.GetMajorEvents(App.m()), App.l().getSportTypes().get(Integer.valueOf(gameObj.getSportID())).getID(), gameObj.isExtraTime());
            progressCircleView.setDataArray(arrayList);
            progressCircleView.setVisibility(0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void initializeCollapse() {
        try {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.scores365.ui.CustomGameCenterHeaderView.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    try {
                        CustomGameCenterHeaderView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        float dimension = App.m().getResources().getDimension(R.dimen.f21653r);
                        CustomGameCenterHeaderView.this.activityWeakRef.get().P0 = CustomGameCenterHeaderView.this.getHeight() - ((int) dimension);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) CustomGameCenterHeaderView.this.HomeTeamIV.getLayoutParams();
                        int height = CustomGameCenterHeaderView.this.scoresContainer.getHeight();
                        int i10 = marginLayoutParams.topMargin;
                        int i11 = ((RelativeLayout.LayoutParams) CustomGameCenterHeaderView.this.mainContainer.getLayoutParams()).topMargin;
                        float f10 = marginLayoutParams.width / 2.0f;
                        CustomGameCenterHeaderView.this.activityWeakRef.get().N0 = (((CustomGameCenterHeaderView.this.getHeight() - i11) - (dimension / 2.0f)) - f10) - i10;
                        CustomGameCenterHeaderView customGameCenterHeaderView = CustomGameCenterHeaderView.this;
                        float r10 = (((-((ViewGroup.MarginLayoutParams) CustomGameCenterHeaderView.this.tvMiddle.getLayoutParams()).topMargin) + i10) + f10) - (p0.r(40.0f) / 2.0f);
                        float height2 = (CustomGameCenterHeaderView.this.mainContainer.getHeight() - height) / 2;
                        customGameCenterHeaderView.middleTextScaleTranslationY = r10 - height2;
                        CustomGameCenterHeaderView.this.scoreTextsScaleTranslationY = ((((-((ViewGroup.MarginLayoutParams) CustomGameCenterHeaderView.this.tvHomeTeamScore.getLayoutParams()).topMargin) + i10) + f10) - (p0.r(30.0f) / 2.0f)) - height2;
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            });
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void initializeTextViewsColorAndSizes(GameObj gameObj) {
        TextView textView;
        TextView textView2;
        try {
            this.leagueName.setTypeface(o0.c(App.m()));
            if (this.tvMiddle != null && (textView2 = this.tvTop) != null && this.tvBottom != null) {
                textView2.setTypeface(o0.c(App.m()));
                if (this.mHeaderType != HeaderType.LIVE || gameObj.addedTime <= 0) {
                    this.tvBottom.setTypeface(o0.d(App.m()));
                    this.tvBottom.setTextSize(1, 12.0f);
                } else {
                    this.tvBottom.setTypeface(o0.a(App.m()));
                    this.tvBottom.setTextSize(1, 14.0f);
                }
            }
            this.leagueName.setTextColor(p0.A(R.attr.B1));
            this.HomeTeamTV.setTextColor(p0.A(R.attr.B1));
            this.AwayTeamTV.setTextColor(p0.A(R.attr.B1));
            this.homeTeamRating.setTextColor(p0.A(R.attr.f21598x1));
            this.awayTeamRating.setTextColor(p0.A(R.attr.f21598x1));
            this.tvBottom.setBackgroundResource(0);
            if (this.tvMiddle == null || (textView = this.tvTop) == null || this.tvBottom == null) {
                return;
            }
            textView.setTextColor(p0.A(R.attr.B1));
            this.tvMiddle.setTextColor(p0.A(R.attr.B1));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.tvBottom.getLayoutParams();
            layoutParams.setMargins(0, (int) App.m().getResources().getDimension(R.dimen.f21650o), 0, 0);
            HeaderType headerType = this.mHeaderType;
            HeaderType headerType2 = HeaderType.LIVE;
            if (headerType == headerType2 && gameObj.addedTime > 0) {
                this.tvBottom.setTextColor(p0.A(R.attr.f21559k1));
            } else if (headerType == headerType2) {
            } else {
                if (gameObj.getStatusObj() != null && gameObj.getStatusObj().getIsNotStarted() && gameObj.getStatusObj().isAbnormal) {
                    this.tvBottom.setTextColor(p0.A(R.attr.f21547g1));
                    this.tvBottom.setBackgroundResource(R.drawable.f21807s0);
                    return;
                }
                if (!this.isGameAboutToStart) {
                    this.tvBottom.setTextColor(p0.A(R.attr.B1));
                }
                layoutParams.setMargins(0, (int) App.m().getResources().getDimension(R.dimen.f21650o), 0, 0);
                HeaderType headerType3 = this.mHeaderType;
                if (headerType3 == HeaderType.FINISHED || headerType3 == HeaderType.ABNORMAL_NOT_STARTED) {
                    this.tvBottom.setTextColor(p0.A(R.attr.f21557k));
                    this.tvBottom.setBackgroundResource(R.drawable.f21807s0);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private boolean isGameHalfTime(StatusObj statusObj) {
        return this.gameObj.getSportID() == SportTypesEnum.AMERICAN_FOOTBALL.getValue() && statusObj != null && statusObj.getID() == 69;
    }

    private boolean isHeaderShowOnlyDateForLanguage() {
        try {
            int k02 = sf.a.i0(App.m()).k0();
            for (String str : p0.l0("GC_ONLY_DATE_LANGUAGES").split(",")) {
                if (k02 == Integer.valueOf(str).intValue()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$assignOnClickListeners$6(GameObj gameObj, View view) {
        try {
            boolean l10 = x0.l(gameObj.homeAwayTeamOrder, true);
            if (l10) {
                if (this.imgArrowAway.getVisibility() != 0) {
                    return;
                }
            } else if (this.imgArrowHome.getVisibility() != 0) {
                return;
            }
            ToolTipFactory.Companion companion = ToolTipFactory.Companion;
            if (companion.getTag() == this.tvHomeTeamScore.getId()) {
                companion.clearForcedDismiss();
                return;
            }
            companion.setTag(this.tvHomeTeamScore.getId());
            StatusObj statusObj = getStatusObj();
            if (statusObj != null) {
                String ballPossessionToolTipText = getBallPossessionToolTipText(statusObj);
                if (l10) {
                    showAwayToolTip(ballPossessionToolTipText, false);
                } else {
                    showHomeToolTip(ballPossessionToolTipText, false);
                }
                sendToolTipAnalytics("click", isGameHalfTime(statusObj) ? 1 : 0, true);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$assignOnClickListeners$7(GameObj gameObj, View view) {
        try {
            boolean l10 = x0.l(gameObj.homeAwayTeamOrder, true);
            if (l10) {
                if (this.imgArrowHome.getVisibility() != 0) {
                    return;
                }
            } else if (this.imgArrowAway.getVisibility() != 0) {
                return;
            }
            ToolTipFactory.Companion companion = ToolTipFactory.Companion;
            if (companion.getTag() == this.tvAwayTeamScore.getId()) {
                companion.clearForcedDismiss();
                return;
            }
            companion.setTag(this.tvAwayTeamScore.getId());
            StatusObj statusObj = getStatusObj();
            if (statusObj != null) {
                String ballPossessionToolTipText = getBallPossessionToolTipText(statusObj);
                if (l10) {
                    showHomeToolTip(ballPossessionToolTipText, false);
                } else {
                    showAwayToolTip(ballPossessionToolTipText, false);
                }
                sendToolTipAnalytics("click", isGameHalfTime(statusObj) ? 1 : 0, true);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$assignOnClickListeners$8(View view) {
        try {
            ToolTipFactory.Companion companion = ToolTipFactory.Companion;
            if (companion.getTag() != this.tvHomeTeamScore.getId()) {
                companion.setTag(this.tvHomeTeamScore.getId());
                StatusObj statusObj = getStatusObj();
                if (statusObj != null) {
                    showHomeToolTip(getBallPossessionToolTipText(statusObj), false);
                    sendToolTipAnalytics("click", isGameHalfTime(statusObj) ? 1 : 0, true);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$assignOnClickListeners$9(View view) {
        try {
            ToolTipFactory.Companion companion = ToolTipFactory.Companion;
            if (companion.getTag() != this.tvAwayTeamScore.getId()) {
                companion.setTag(this.tvAwayTeamScore.getId());
                StatusObj statusObj = getStatusObj();
                if (statusObj != null) {
                    showAwayToolTip(getBallPossessionToolTipText(statusObj), false);
                    sendToolTipAnalytics("click", isGameHalfTime(statusObj) ? 1 : 0, true);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initializeView$1(BrandAsset brandAsset, View view) {
        try {
            x0.M1(brandAsset.getClickUrl());
            BrandingStripItem.sendClickAnalytics(BrandingKey.gameCenterHeaderLogo, brandAsset.brand);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBallPossessionState$2() {
        showHomeToolTip(getHalfTimeToolTipTerm(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBallPossessionState$3() {
        showHomeToolTip(getLiveBallPossessionToolTipTerm(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBallPossessionState$4() {
        showAwayToolTip(getHalfTimeToolTipTerm(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBallPossessionState$5() {
        showAwayToolTip(getLiveBallPossessionToolTipTerm(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showToolTip$0() {
        this.isHomeToolTipShown = false;
        this.isAwayToolTipShown = false;
    }

    private String makeArab(String str) {
        char[] cArr = {1632, 1633, 1634, 1635, 1636, 1637, 1638, 1639, 1640, 1641};
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (Character.isDigit(str.charAt(i10))) {
                sb2.append(cArr[str.charAt(i10) - '0']);
            } else {
                sb2.append(str.charAt(i10));
            }
        }
        PrintStream printStream = System.out;
        printStream.println("Number in English : " + str);
        PrintStream printStream2 = System.out;
        printStream2.println("Number In Arabic : " + ((Object) sb2));
        return String.valueOf(sb2);
    }

    private void removeBaseballViews() {
        try {
            this.baseballStatusViewsObj.basesView.setVisibility(8);
            this.baseballStatusViewsObj.ballsContainer.setVisibility(8);
            this.tvScoreSeparator.setAlpha(1.0f);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static void removeVarEvent(View view, View view2, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, ValueAnimator valueAnimator) {
        if (valueAnimator != null) {
            try {
                valueAnimator.cancel();
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        view.setAlpha(1.0f);
        view2.setVisibility(0);
        textView.setVisibility(8);
        imageView.setVisibility(8);
        imageView2.setVisibility(8);
        imageView3.setVisibility(8);
    }

    private void sendToolTipAnalytics(String str, int i10, boolean z10) {
        try {
            ee.k.n(App.m(), "gamecenter", "possession-tooltip", str, null, z10, "game_id", String.valueOf(this.gameObj.getID()), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, com.scores365.gameCenter.i0.D0(this.gameObj), "is_half", String.valueOf(i10));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ba A[Catch: Exception -> 0x01be, TRY_ENTER, TryCatch #0 {Exception -> 0x01be, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0010, B:12:0x0025, B:40:0x00b2, B:43:0x00ba, B:45:0x00f4, B:47:0x00fc, B:49:0x0121, B:51:0x0133, B:53:0x0161, B:55:0x0178, B:56:0x018c, B:58:0x0190, B:60:0x01a4, B:61:0x01ac, B:63:0x01b7, B:48:0x010f, B:44:0x00cf, B:38:0x00ae, B:18:0x0037, B:20:0x0043, B:22:0x0057, B:7:0x0013, B:9:0x0019, B:11:0x0023), top: B:69:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cf A[Catch: Exception -> 0x01be, TryCatch #0 {Exception -> 0x01be, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0010, B:12:0x0025, B:40:0x00b2, B:43:0x00ba, B:45:0x00f4, B:47:0x00fc, B:49:0x0121, B:51:0x0133, B:53:0x0161, B:55:0x0178, B:56:0x018c, B:58:0x0190, B:60:0x01a4, B:61:0x01ac, B:63:0x01b7, B:48:0x010f, B:44:0x00cf, B:38:0x00ae, B:18:0x0037, B:20:0x0043, B:22:0x0057, B:7:0x0013, B:9:0x0019, B:11:0x0023), top: B:69:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fc A[Catch: Exception -> 0x01be, TryCatch #0 {Exception -> 0x01be, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0010, B:12:0x0025, B:40:0x00b2, B:43:0x00ba, B:45:0x00f4, B:47:0x00fc, B:49:0x0121, B:51:0x0133, B:53:0x0161, B:55:0x0178, B:56:0x018c, B:58:0x0190, B:60:0x01a4, B:61:0x01ac, B:63:0x01b7, B:48:0x010f, B:44:0x00cf, B:38:0x00ae, B:18:0x0037, B:20:0x0043, B:22:0x0057, B:7:0x0013, B:9:0x0019, B:11:0x0023), top: B:69:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010f A[Catch: Exception -> 0x01be, TryCatch #0 {Exception -> 0x01be, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0010, B:12:0x0025, B:40:0x00b2, B:43:0x00ba, B:45:0x00f4, B:47:0x00fc, B:49:0x0121, B:51:0x0133, B:53:0x0161, B:55:0x0178, B:56:0x018c, B:58:0x0190, B:60:0x01a4, B:61:0x01ac, B:63:0x01b7, B:48:0x010f, B:44:0x00cf, B:38:0x00ae, B:18:0x0037, B:20:0x0043, B:22:0x0057, B:7:0x0013, B:9:0x0019, B:11:0x0023), top: B:69:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0133 A[Catch: Exception -> 0x01be, TryCatch #0 {Exception -> 0x01be, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0010, B:12:0x0025, B:40:0x00b2, B:43:0x00ba, B:45:0x00f4, B:47:0x00fc, B:49:0x0121, B:51:0x0133, B:53:0x0161, B:55:0x0178, B:56:0x018c, B:58:0x0190, B:60:0x01a4, B:61:0x01ac, B:63:0x01b7, B:48:0x010f, B:44:0x00cf, B:38:0x00ae, B:18:0x0037, B:20:0x0043, B:22:0x0057, B:7:0x0013, B:9:0x0019, B:11:0x0023), top: B:69:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018c A[Catch: Exception -> 0x01be, TryCatch #0 {Exception -> 0x01be, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0010, B:12:0x0025, B:40:0x00b2, B:43:0x00ba, B:45:0x00f4, B:47:0x00fc, B:49:0x0121, B:51:0x0133, B:53:0x0161, B:55:0x0178, B:56:0x018c, B:58:0x0190, B:60:0x01a4, B:61:0x01ac, B:63:0x01b7, B:48:0x010f, B:44:0x00cf, B:38:0x00ae, B:18:0x0037, B:20:0x0043, B:22:0x0057, B:7:0x0013, B:9:0x0019, B:11:0x0023), top: B:69:0x0000 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00ae -> B:39:0x00b1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setAggregateOrSeries(com.scores365.entitys.GameObj r12, int r13) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.CustomGameCenterHeaderView.setAggregateOrSeries(com.scores365.entitys.GameObj, int):void");
    }

    private void setCorrectEnumType(GameObj gameObj) {
        try {
            StatusObj statusObj = App.l().getSportTypes().get(Integer.valueOf(gameObj.getSportID())).getStatuses().get(Integer.valueOf(gameObj.getStID()));
            if (statusObj.getIsNotStarted()) {
                if (gameObj.showCountDown) {
                    this.mHeaderType = HeaderType.LESS_WITH_TIMER;
                } else {
                    this.mHeaderType = HeaderType.LESS_NO_TIMER;
                }
            } else if (statusObj.getIsActive()) {
                this.mHeaderType = HeaderType.LIVE;
            } else if (statusObj.getIsFinished()) {
                this.mHeaderType = HeaderType.FINISHED;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setGameAboutToStartState() {
        Context m10 = App.m();
        this.tvTop.setTypeface(o0.c(m10));
        this.tvMiddle.setTypeface(o0.a(m10));
        this.tvBottom.setTypeface(o0.c(m10));
        String dateString = getDateString(this.gameObj.getSTime());
        String U = x0.U(this.gameObj.getSTime(), x0.H0(x0.e.SHORT));
        this.tvTop.setText(dateString);
        this.tvMiddle.setText(U);
        this.tvBottom.setText(p0.l0("GAME_ABOUT_TO_START"));
        this.tvBottom.setTextColor(p0.A(R.attr.f21556j1));
    }

    private void setTeamsData(GameObj gameObj) {
        RankingObj rankingObj;
        RankingObj rankingObj2;
        try {
            this.HomeTeamTV.setTypeface(o0.d(App.m()));
            this.AwayTeamTV.setTypeface(o0.d(App.m()));
            this.HomeTeamTV.setText(gameObj.getComps()[0].getName());
            this.AwayTeamTV.setText(gameObj.getComps()[1].getName());
            this.tvHomeRecord.setText(gameObj.getComps()[0].getRecordStr());
            this.tvAwayRecord.setText(gameObj.getComps()[1].getRecordStr());
            this.tvHomeRecord.setTypeface(o0.d(App.m()));
            this.tvAwayRecord.setTypeface(o0.d(App.m()));
            if (gameObj.getWinner() != -1) {
                if (gameObj.getWinner() == 1) {
                    this.HomeTeamTV.setTypeface(o0.a(App.m()));
                    this.AwayTeamTV.setTypeface(o0.d(App.m()));
                } else if (gameObj.getWinner() == 2) {
                    this.HomeTeamTV.setTypeface(o0.d(App.m()));
                    this.AwayTeamTV.setTypeface(o0.a(App.m()));
                }
            }
            if (gameObj.getSportID() == 3) {
                if (this.homeTeamLogoUrl == null) {
                    this.homeTeamLogoUrl = nb.o.x(nb.p.Competitors, gameObj.getComps()[0].getID(), IMAGE_SIZE, IMAGE_SIZE, true, nb.p.CountriesRoundFlags, Integer.valueOf(gameObj.getComps()[0].getCountryID()), gameObj.getComps()[0].getImgVer());
                }
                if (this.awayTeamLogoUrl == null) {
                    this.awayTeamLogoUrl = nb.o.x(nb.p.Competitors, gameObj.getComps()[1].getID(), IMAGE_SIZE, IMAGE_SIZE, true, nb.p.CountriesRoundFlags, Integer.valueOf(gameObj.getComps()[1].getCountryID()), gameObj.getComps()[1].getImgVer());
                }
                String str = this.homeTeamLogoUrl;
                ImageView imageView = this.HomeTeamIV;
                li.u.A(str, imageView, li.u.g(true, imageView.getLayoutParams().width));
                String str2 = this.awayTeamLogoUrl;
                ImageView imageView2 = this.AwayTeamIV;
                li.u.A(str2, imageView2, li.u.g(true, imageView2.getLayoutParams().width));
            } else {
                if (this.homeTeamLogoUrl == null) {
                    this.homeTeamLogoUrl = nb.o.l(nb.p.Competitors, gameObj.getComps()[0].getID(), Integer.valueOf((int) IMAGE_SIZE), Integer.valueOf((int) IMAGE_SIZE), false, true, Integer.valueOf(gameObj.getSportID()), null, null, gameObj.getComps()[0].getImgVer());
                }
                if (this.awayTeamLogoUrl == null) {
                    this.awayTeamLogoUrl = nb.o.l(nb.p.Competitors, gameObj.getComps()[1].getID(), Integer.valueOf((int) IMAGE_SIZE), Integer.valueOf((int) IMAGE_SIZE), false, true, Integer.valueOf(gameObj.getSportID()), null, null, gameObj.getComps()[1].getImgVer());
                }
                String str3 = this.homeTeamLogoUrl;
                ImageView imageView3 = this.HomeTeamIV;
                li.u.A(str3, imageView3, li.u.g(true, imageView3.getLayoutParams().width));
                String str4 = this.awayTeamLogoUrl;
                ImageView imageView4 = this.AwayTeamIV;
                li.u.A(str4, imageView4, li.u.g(true, imageView4.getLayoutParams().width));
            }
            this.tvHomeRate.setVisibility(8);
            this.tvAwayRate.setVisibility(8);
            if (this.sportId == SportTypesEnum.BASKETBALL.getValue() || this.sportId == SportTypesEnum.AMERICAN_FOOTBALL.getValue()) {
                TextView[] textViewArr = {this.tvHomeRate, this.tvAwayRate};
                for (int i10 = 0; i10 < gameObj.getComps().length; i10++) {
                    CompObj compObj = gameObj.getComps()[i10];
                    if (compObj != null && compObj.getRankingObjs() != null && !compObj.getRankingObjs().isEmpty()) {
                        RankingObj rankingObj3 = compObj.getRankingObjs().get(0);
                        if (rankingObj3.getPosition() > 0) {
                            textViewArr[i10].setText(String.valueOf(rankingObj3.getPosition()));
                            textViewArr[i10].setTypeface(o0.c(App.m()));
                            textViewArr[i10].setVisibility(0);
                        }
                    }
                }
            }
            if (gameObj.getSportID() != SportTypesEnum.AMERICAN_FOOTBALL.getValue() && gameObj.getSportID() != SportTypesEnum.BASEBALL.getValue()) {
                this.homeTeamPossession.setVisibility(8);
                this.awayTeamPossession.setVisibility(8);
                if (gameObj.GetPossession() == 1) {
                    this.homeTeamPossession.setVisibility(0);
                    this.awayTeamPossession.setVisibility(8);
                    this.homeTeamPossession.setImageResource(getPossessionIconResource(gameObj.getSportID()));
                } else if (gameObj.GetPossession() == 2) {
                    this.awayTeamPossession.setVisibility(0);
                    this.homeTeamPossession.setVisibility(8);
                    this.awayTeamPossession.setImageResource(getPossessionIconResource(gameObj.getSportID()));
                }
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.homeTeamNameLayout.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.awayTeamNameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams2.topMargin = 0;
            this.RANKING_HEIGHT = 0;
            this.homeTeamRating.setVisibility(8);
            this.awayTeamRating.setVisibility(8);
            if (gameObj.getSportID() == 3 && gameObj.getComps()[1].getRankingObjs() != null && (rankingObj2 = gameObj.getComps()[0].getRankingObjs().get(0)) != null) {
                this.homeTeamRating.setVisibility(0);
                TextView textView = this.homeTeamRating;
                textView.setText(rankingObj2.getName() + " " + rankingObj2.getPosition());
                this.homeTeamRating.setTypeface(o0.d(App.m()));
                layoutParams.topMargin = p0.s(20);
                this.RANKING_HEIGHT = p0.s(20);
            }
            if (gameObj.getSportID() == 3 && gameObj.getComps()[1].getRankingObjs() != null && (rankingObj = gameObj.getComps()[1].getRankingObjs().get(0)) != null) {
                this.awayTeamRating.setVisibility(0);
                TextView textView2 = this.awayTeamRating;
                textView2.setText(rankingObj.getName() + " " + rankingObj.getPosition());
                this.awayTeamRating.setTypeface(o0.d(App.m()));
                layoutParams2.topMargin = p0.s(20);
                this.RANKING_HEIGHT = p0.s(20);
            }
            this.mainContainer.getLayoutParams().height = -2;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void showAwayToolTip(String str, boolean z10) {
        showToolTip(this.imgArrowAway, str, !x0.l(this.gameObj.homeAwayTeamOrder, true), this.awayToolTipResource, z10);
        toolTipClickState(false, true);
    }

    private void showBallPossessionState(StatusObj statusObj) {
        int sportID = this.gameObj.getSportID();
        SportTypesEnum sportTypesEnum = SportTypesEnum.AMERICAN_FOOTBALL;
        if (sportID == sportTypesEnum.getValue() || this.gameObj.getSportID() == SportTypesEnum.BASEBALL.getValue()) {
            boolean z10 = this.gameObj.getSportID() == sportTypesEnum.getValue();
            if (this.gameObj.GetPossession() == 1) {
                this.imgArrowHome.setVisibility(0);
                this.imgArrowAway.setVisibility(8);
                if (z10) {
                    if (this.isGameCompleteDataArrived && isGameHalfTime(statusObj) && sf.b.X1().S9()) {
                        ToolTipFactory.Companion.dismissPopup();
                        this.imgArrowHome.post(new Runnable() { // from class: com.scores365.ui.g
                            @Override // java.lang.Runnable
                            public final void run() {
                                CustomGameCenterHeaderView.this.lambda$showBallPossessionState$2();
                            }
                        });
                        sf.b.X1().N5();
                        sendToolTipAnalytics(ServerProtocol.DIALOG_PARAM_DISPLAY, 1, false);
                    } else if (this.isGameCompleteDataArrived) {
                        ToolTipFactory.Companion companion = ToolTipFactory.Companion;
                        if (companion.isPopupShown()) {
                            if (!this.isHomeToolTipShown) {
                                companion.dismissPopup();
                            }
                            this.imgArrowHome.post(new Runnable() { // from class: com.scores365.ui.h
                                @Override // java.lang.Runnable
                                public final void run() {
                                    CustomGameCenterHeaderView.this.lambda$showBallPossessionState$3();
                                }
                            });
                            sendToolTipAnalytics(ServerProtocol.DIALOG_PARAM_DISPLAY, 0, false);
                        }
                    }
                }
            } else if (this.gameObj.GetPossession() == 2) {
                this.imgArrowHome.setVisibility(8);
                this.imgArrowAway.setVisibility(0);
                if (z10) {
                    if (this.isGameCompleteDataArrived && isGameHalfTime(statusObj) && sf.b.X1().S9()) {
                        ToolTipFactory.Companion.dismissPopup();
                        this.imgArrowAway.post(new Runnable() { // from class: com.scores365.ui.i
                            @Override // java.lang.Runnable
                            public final void run() {
                                CustomGameCenterHeaderView.this.lambda$showBallPossessionState$4();
                            }
                        });
                        sf.b.X1().N5();
                        sendToolTipAnalytics(ServerProtocol.DIALOG_PARAM_DISPLAY, 1, false);
                    } else if (this.isGameCompleteDataArrived) {
                        ToolTipFactory.Companion companion2 = ToolTipFactory.Companion;
                        if (companion2.isPopupShown()) {
                            if (!this.isAwayToolTipShown) {
                                companion2.dismissPopup();
                            }
                            this.imgArrowAway.post(new Runnable() { // from class: com.scores365.ui.j
                                @Override // java.lang.Runnable
                                public final void run() {
                                    CustomGameCenterHeaderView.this.lambda$showBallPossessionState$5();
                                }
                            });
                            sendToolTipAnalytics(ServerProtocol.DIALOG_PARAM_DISPLAY, 0, false);
                        }
                    }
                }
            }
        }
    }

    private void showHomeToolTip(String str, boolean z10) {
        showToolTip(this.imgArrowHome, str, x0.l(this.gameObj.homeAwayTeamOrder, true), this.homeToolTipResource, z10);
        toolTipClickState(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopNotificationAnim() {
        try {
            ValueAnimator valueAnimator = this.crossFadeNotificationAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            int sportID = this.gameObj.getSportID();
            Animation loadAnimation = AnimationUtils.loadAnimation(App.m(), R.anim.f21506f);
            if (sportID == SportTypesEnum.TENNIS.getValue()) {
                this.tvTop.setVisibility(0);
                this.tvMiddle.startAnimation(loadAnimation);
                this.tvMiddle.setVisibility(0);
            } else if (sportID == SportTypesEnum.SOCCER.getValue() || sportID == SportTypesEnum.HOCKEY.getValue() || sportID == SportTypesEnum.RUGBY.getValue() || sportID == SportTypesEnum.CRICKET.getValue()) {
                this.tvTop.setVisibility(0);
            }
            this.animationTXT.setVisibility(8);
            this.animationIMG.setVisibility(8);
            this.animationArrowLeft.setVisibility(8);
            this.animationArrowRight.setVisibility(8);
            this.tvBottom.setVisibility(0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void toolTipClickState(boolean z10, boolean z11) {
        this.isHomeToolTipShown = z10;
        this.isAwayToolTipShown = z11;
    }

    public void assignOnClickListeners(final GameObj gameObj, CompetitionObj competitionObj) {
        if (gameObj != null) {
            try {
                if (gameObj.getID() > 0) {
                    if (x0.l(gameObj.homeAwayTeamOrder, true)) {
                        RelativeLayout relativeLayout = this.rightContainer;
                        CompObj compObj = gameObj.getComps()[0];
                        WeakReference<GameCenterBaseActivity> weakReference = this.activityWeakRef;
                        OpenSingleCompetitorDashboard.Type type = OpenSingleCompetitorDashboard.Type.Competitor;
                        relativeLayout.setOnClickListener(new OpenSingleCompetitorDashboard(compObj, weakReference, type));
                        this.leftContainer.setOnClickListener(new OpenSingleCompetitorDashboard(gameObj.getComps()[1], this.activityWeakRef, type));
                    } else {
                        RelativeLayout relativeLayout2 = this.leftContainer;
                        CompObj compObj2 = gameObj.getComps()[0];
                        WeakReference<GameCenterBaseActivity> weakReference2 = this.activityWeakRef;
                        OpenSingleCompetitorDashboard.Type type2 = OpenSingleCompetitorDashboard.Type.Competitor;
                        relativeLayout2.setOnClickListener(new OpenSingleCompetitorDashboard(compObj2, weakReference2, type2));
                        this.rightContainer.setOnClickListener(new OpenSingleCompetitorDashboard(gameObj.getComps()[1], this.activityWeakRef, type2));
                    }
                    if (this.leagueHeader != null) {
                        this.leagueHeader.setOnClickListener(new OpenSingleCompetitorDashboard(competitionObj, new WeakReference(this), this.activityWeakRef, OpenSingleCompetitorDashboard.Type.Competition));
                    }
                    this.tvHomeTeamScore.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CustomGameCenterHeaderView.this.lambda$assignOnClickListeners$6(gameObj, view);
                        }
                    });
                    this.tvAwayTeamScore.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.c
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CustomGameCenterHeaderView.this.lambda$assignOnClickListeners$7(gameObj, view);
                        }
                    });
                    this.imgArrowHome.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.d
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CustomGameCenterHeaderView.this.lambda$assignOnClickListeners$8(view);
                        }
                    });
                    this.imgArrowAway.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CustomGameCenterHeaderView.this.lambda$assignOnClickListeners$9(view);
                        }
                    });
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public void cancelLiveTimer() {
        try {
            gameTimeUpdateTask gametimeupdatetask = this.gameTimeTask;
            if (gametimeupdatetask != null) {
                gametimeupdatetask.cancel();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void clearCompetitionTitle() {
        try {
            TextView textView = this.leagueName;
            if (textView != null) {
                textView.setText("");
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void clearCompetitorsLogo() {
        this.homeTeamLogoUrl = null;
        this.awayTeamLogoUrl = null;
    }

    public void collapseToPercentage(float f10) {
        float f11 = 1.0f - (2.0f * f10);
        try {
            this.collapsedAlpha = f11;
            this.leagueHeader.setAlpha(f11);
            this.HomeTeamTV.setAlpha(this.collapsedAlpha);
            this.AwayTeamTV.setAlpha(this.collapsedAlpha);
            this.tvHomeRate.setAlpha(this.collapsedAlpha);
            this.tvAwayRate.setAlpha(this.collapsedAlpha);
            this.tvHomeRecord.setAlpha(this.collapsedAlpha);
            this.tvAwayRecord.setAlpha(this.collapsedAlpha);
            this.homeBonus.setAlpha(this.collapsedAlpha);
            this.awayBonus.setAlpha(this.collapsedAlpha);
            this.imgArrowHome.setAlpha(this.collapsedAlpha);
            this.imgArrowAway.setAlpha(this.collapsedAlpha);
            this.tvBottom.setAlpha(this.collapsedAlpha);
            this.animationArrowLeft.setAlpha(this.collapsedAlpha);
            this.animationArrowRight.setAlpha(this.collapsedAlpha);
            ProgressCircleView progressCircleView = this.CircleView;
            if (progressCircleView != null) {
                progressCircleView.setAlpha(this.collapsedAlpha);
            }
            TextView textView = this.tvWinDescription;
            if (textView != null) {
                textView.setAlpha(f11);
            }
            TextView textView2 = this.tvSpread;
            if (textView2 != null) {
                textView2.setAlpha(f11);
            }
            LinearLayout linearLayout = this.llAgregateScoreContainer;
            if (linearLayout != null) {
                linearLayout.setAlpha(f11);
            }
            this.homeTeamRating.setAlpha(this.collapsedAlpha);
            this.homeTeamPossession.setAlpha(this.collapsedAlpha);
            this.awayTeamRating.setAlpha(this.collapsedAlpha);
            this.awayTeamPossession.setAlpha(this.collapsedAlpha);
            this.penaltyHome.setAlpha(this.collapsedAlpha);
            this.penaltyAway.setAlpha(this.collapsedAlpha);
            this.baseballStatusViewsObj.basesView.setAlpha(this.collapsedAlpha);
            this.baseballStatusViewsObj.ballsContainer.setAlpha(this.collapsedAlpha);
            float f12 = 1.0f - ((1.0f - LOGOS_MAX_SCALE) * f10);
            this.HomeTeamIV.setScaleX(f12);
            this.HomeTeamIV.setScaleY(f12);
            this.AwayTeamIV.setScaleX(f12);
            this.AwayTeamIV.setScaleY(f12);
            RelativeLayout relativeLayout = this.leftContainer;
            float f13 = LOGOS_MAX_TANSLATION_X;
            relativeLayout.setTranslationX(f13 * f10);
            this.rightContainer.setTranslationX((-f13) * f10);
            this.tvBottom.setTranslationY(this.middleTextScaleTranslationY * f10);
            this.tvTop.setTranslationY(this.middleTextScaleTranslationY * f10);
            this.animationTXT.setTranslationY(this.middleTextScaleTranslationY * f10);
            this.animationIMG.setTranslationY(this.middleTextScaleTranslationY * f10);
            this.animationArrowRight.setTranslationY(this.middleTextScaleTranslationY * f10);
            this.animationArrowLeft.setTranslationY(this.middleTextScaleTranslationY * f10);
            this.tvTop.setScaleX(1.0f - ((1.0f - this.topTextMaxScale) * f10));
            this.tvTop.setScaleY(1.0f - ((1.0f - this.topTextMaxScale) * f10));
            if (x0.F2(this.gameObj.getSportID())) {
                this.tvMiddle.setScaleX(1.0f - (((1.0f - this.middleTextMaxScale) + 0.15f) * f10));
                this.tvMiddle.setScaleY(1.0f - (((1.0f - this.middleTextMaxScale) + 0.15f) * f10));
                this.tvMiddle.setTranslationY(this.middleTextScaleTranslationY * f10);
                this.tvHomeTeamScore.setTranslationY(this.scoreTextsScaleTranslationY * f10);
                this.tvAwayTeamScore.setTranslationY(this.scoreTextsScaleTranslationY * f10);
                this.tvScoreSeparator.setTranslationY(this.scoreTextsScaleTranslationY * f10);
                this.tvHomeTeamScore.setScaleX(1.0f - (((1.0f - this.middleTextMaxScale) + 0.15f) * f10));
                this.tvHomeTeamScore.setScaleY(1.0f - (((1.0f - this.middleTextMaxScale) + 0.15f) * f10));
                this.tvAwayTeamScore.setScaleX(1.0f - (((1.0f - this.middleTextMaxScale) + 0.15f) * f10));
                this.tvAwayTeamScore.setScaleY(1.0f - (((1.0f - this.middleTextMaxScale) + 0.15f) * f10));
                this.tvScoreSeparator.setScaleX(1.0f - (((1.0f - this.middleTextMaxScale) + 0.15f) * f10));
                this.tvScoreSeparator.setScaleY(1.0f - (((1.0f - this.middleTextMaxScale) + 0.15f) * f10));
                if (this.baseballStatusViewsVisible) {
                    float f14 = this.collapsedAlpha;
                    this.tvScoreSeparator.setAlpha(f14 < 0.0f ? Math.abs(f14) : 0.0f);
                }
            } else {
                this.tvMiddle.setScaleX(1.0f - ((1.0f - this.middleTextMaxScale) * f10));
                this.tvMiddle.setScaleY(1.0f - ((1.0f - this.middleTextMaxScale) * f10));
                this.tvMiddle.setTranslationY(this.middleTextScaleTranslationY * f10);
            }
            this.tvBottom.setScaleX(1.0f - ((1.0f - this.bottomTextMaxScale) * f10));
            this.tvBottom.setScaleY(1.0f - ((1.0f - this.bottomTextMaxScale) * f10));
            this.animationIMG.setAlpha(this.collapsedAlpha);
            ValueAnimator valueAnimator = this.crossFadeNotificationAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                this.tvTop.setAlpha(this.collapsedAlpha);
            }
            if (this.powerPlayContainer.getVisibility() == 0) {
                this.powerPlayContainer.setAlpha(this.collapsedAlpha);
            }
            if (this.hockeyShotsContainer.getVisibility() == 0) {
                this.hockeyShotsContainer.setAlpha(this.collapsedAlpha);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.CountDownState
    public void counterFinished() {
        if (this.gameObj.isGameAboutToStart(true)) {
            setGameAboutToStartState();
        }
    }

    @Override // com.scores365.ui.CountDownState
    public void counterTick() {
    }

    public GameCenterBaseActivity getActivityFromRef() {
        return this.activityWeakRef.get();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(48:16|17|(1:19)(1:274)|20|(42:22|23|24|25|(1:272)(1:29)|30|(1:32)(1:271)|33|(2:35|(1:37)(1:269))(1:270)|38|(1:40)(1:268)|41|(2:46|(37:48|(2:50|(35:52|53|(1:55)|56|(1:58)|59|(27:61|62|(1:64)(3:259|(1:261)(1:263)|262)|65|(1:258)|69|70|(1:72)(1:254)|(2:80|81)|(1:86)|87|88|89|(1:91)|92|(1:94)|96|97|(2:99|(2:101|(2:103|(1:(3:106|(1:108)(1:110)|109))(6:148|(1:150)(1:165)|151|(3:153|(1:163)|157)(1:164)|158|(1:162)))(7:166|(5:168|(1:191)|172|(1:174)(1:190)|175)(1:192)|176|(1:178)(1:189)|179|(1:181)(2:183|(2:185|(1:187)(1:188)))|182))(19:193|(1:195)(1:241)|196|197|198|199|200|(9:205|(1:207)(1:(1:237)(1:238))|208|(3:222|(4:226|(1:228)(1:234)|229|(1:233))|235)(1:212)|213|(1:215)|216|(1:220)|221)|239|208|(1:210)|222|(5:224|226|(0)(0)|229|(7:231|233|213|(0)|216|(2:218|220)|221))|235|213|(0)|216|(0)|221))(5:242|(1:244)|245|(1:249)|250)|111|(4:117|(1:(1:120)(1:121))|122|(1:(1:125)(1:126)))|127|(1:129)|130|(2:132|(1:134)(2:135|(1:137)))|138|(2:140|(2:142|143)(2:145|146))(1:147))|264|62|(0)(0)|65|(1:67)|258|69|70|(0)(0)|(4:76|78|80|81)|(2:84|86)|87|88|89|(0)|92|(0)|96|97|(0)(0)|111|(6:113|115|117|(0)|122|(0))|127|(0)|130|(0)|138|(0)(0)))(1:266)|265|53|(0)|56|(0)|59|(0)|264|62|(0)(0)|65|(0)|258|69|70|(0)(0)|(0)|(0)|87|88|89|(0)|92|(0)|96|97|(0)(0)|111|(0)|127|(0)|130|(0)|138|(0)(0)))|267|264|62|(0)(0)|65|(0)|258|69|70|(0)(0)|(0)|(0)|87|88|89|(0)|92|(0)|96|97|(0)(0)|111|(0)|127|(0)|130|(0)|138|(0)(0))|273|23|24|25|(1:27)|272|30|(0)(0)|33|(0)(0)|38|(0)(0)|41|(3:44|46|(0))|267|264|62|(0)(0)|65|(0)|258|69|70|(0)(0)|(0)|(0)|87|88|89|(0)|92|(0)|96|97|(0)(0)|111|(0)|127|(0)|130|(0)|138|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0584, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0586, code lost:
        li.x0.N1(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x05d5, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x05d7, code lost:
        li.x0.N1(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x058b A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x05c7 A[Catch: Exception -> 0x05d5, TryCatch #2 {Exception -> 0x05d5, blocks: (B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce), top: B:285:0x05c3, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x05ce A[Catch: Exception -> 0x05d5, TRY_LEAVE, TryCatch #2 {Exception -> 0x05d5, blocks: (B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce), top: B:285:0x05c3, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0989  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x098b  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x09f7 A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0a00 A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0a18 A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0aba A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0ad3  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0ae9  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0b22 A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0b70 A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0bb9 A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:289:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01f6 A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0293 A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02c9 A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x037a A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0403 A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x041c A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0432 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0454 A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x04b2 A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x04cd A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x04e9 A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0508 A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0517 A[Catch: Exception -> 0x0bcf, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x053a A[Catch: Exception -> 0x0bcf, TRY_LEAVE, TryCatch #0 {Exception -> 0x0bcf, blocks: (B:3:0x000b, B:5:0x0042, B:6:0x0066, B:8:0x00e9, B:9:0x00ee, B:11:0x00fe, B:13:0x0119, B:19:0x015c, B:35:0x01d9, B:37:0x01f6, B:39:0x0200, B:41:0x023d, B:43:0x0293, B:45:0x0300, B:47:0x037a, B:49:0x0389, B:52:0x040e, B:54:0x041c, B:56:0x0428, B:59:0x0434, B:61:0x043a, B:63:0x0454, B:65:0x0486, B:67:0x048c, B:70:0x049b, B:72:0x04b2, B:73:0x04bf, B:75:0x04cd, B:76:0x04e3, B:78:0x04e9, B:81:0x04fc, B:83:0x0508, B:89:0x0534, B:91:0x053a, B:111:0x058b, B:113:0x058f, B:114:0x059b, B:125:0x05da, B:136:0x061e, B:138:0x0622, B:140:0x063f, B:139:0x063a, B:243:0x0aa4, B:245:0x0aba, B:247:0x0ac0, B:249:0x0ac6, B:252:0x0ad5, B:253:0x0adc, B:254:0x0ae2, B:257:0x0aeb, B:258:0x0af2, B:259:0x0af8, B:261:0x0b22, B:262:0x0b6a, B:264:0x0b70, B:266:0x0b76, B:267:0x0b8b, B:269:0x0b91, B:270:0x0bb5, B:272:0x0bb9, B:274:0x0bbf, B:275:0x0bc7, B:141:0x066c, B:143:0x0670, B:145:0x068d, B:147:0x0697, B:149:0x06b5, B:152:0x06c2, B:154:0x0708, B:156:0x071a, B:158:0x0720, B:151:0x06bb, B:153:0x06eb, B:144:0x0688, B:159:0x072f, B:161:0x0739, B:163:0x0757, B:166:0x0764, B:168:0x076f, B:170:0x0778, B:172:0x07b2, B:174:0x07d5, B:176:0x07e2, B:178:0x0816, B:185:0x087c, B:179:0x0839, B:181:0x0845, B:183:0x084b, B:184:0x0871, B:175:0x07dc, B:169:0x0775, B:165:0x075d, B:171:0x079a, B:186:0x0887, B:188:0x0893, B:190:0x08a6, B:194:0x08d5, B:196:0x08ea, B:201:0x08f7, B:206:0x094c, B:208:0x0950, B:210:0x0958, B:225:0x09e9, B:227:0x09f7, B:228:0x09fc, B:230:0x0a00, B:232:0x0a06, B:233:0x0a13, B:211:0x0963, B:213:0x0977, B:215:0x0981, B:219:0x098c, B:221:0x0992, B:223:0x09a0, B:224:0x09d6, B:203:0x0915, B:204:0x0927, B:205:0x092d, B:189:0x089f, B:234:0x0a18, B:236:0x0a7f, B:237:0x0a84, B:239:0x0a8e, B:241:0x0a94, B:242:0x0aa1, B:124:0x05d7, B:109:0x0586, B:84:0x0517, B:86:0x0521, B:87:0x052a, B:69:0x0496, B:79:0x04f0, B:50:0x03bf, B:51:0x0403, B:44:0x02c9, B:40:0x0234, B:12:0x010d, B:115:0x05c3, B:117:0x05c7, B:118:0x05ca, B:120:0x05ce, B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:282:0x000b, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0549 A[Catch: Exception -> 0x0584, TryCatch #3 {Exception -> 0x0584, blocks: (B:94:0x0543, B:96:0x0549, B:101:0x055b, B:103:0x0573, B:105:0x057d), top: B:287:0x0543, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0557 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void initializeView(com.scores365.entitys.CompetitionObj r30, com.scores365.entitys.GameObj r31, int r32, java.lang.String r33) {
        /*
            Method dump skipped, instructions count: 3029
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.CustomGameCenterHeaderView.initializeView(com.scores365.entitys.CompetitionObj, com.scores365.entitys.GameObj, int, java.lang.String):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    public void resetViewForInflation() {
        this.isAlreadyInflated = false;
        this.isInflationResetEnabled = true;
    }

    @Override // com.scores365.ui.HeaderClickAnalytics
    public void sendHeaderClickAnalytics(@NonNull BaseObj baseObj) {
        HashMap hashMap = new HashMap();
        hashMap.put("game_id", String.valueOf(this.gameObj.getID()));
        hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, com.scores365.gameCenter.i0.T(this.gameObj));
        if (baseObj instanceof CompetitionObj) {
            hashMap.put("competition_id", String.valueOf(baseObj.getID()));
        }
        hashMap.put("sport_type_id", String.valueOf(this.sportId));
        ee.k.k(App.m(), "gamecenter", "header", "competition", "click", hashMap);
    }

    public void setActivityWeakRef(GameCenterBaseActivity gameCenterBaseActivity) {
        this.activityWeakRef = new WeakReference<>(gameCenterBaseActivity);
    }

    public void setGameCompleteDataArrived(boolean z10) {
        this.isGameCompleteDataArrived = z10;
    }

    public void setShouldHideCompetitionNameOnTop(boolean z10) {
        this.shouldHideCompetitionNameOnTop = z10;
    }

    public void showToolTip(View view, String str, boolean z10, int i10, boolean z11) {
        try {
            if (ToolTipFactory.Companion.isPopupShown()) {
                return;
            }
            ToolTipFactory toolTipFactory = new ToolTipFactory(view.getContext());
            ToolTipDimensions createDimensions = toolTipFactory.createDimensions();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i11 = iArr[0];
            int i12 = iArr[1];
            if (i11 <= 0 || i12 <= 0) {
                return;
            }
            ToolTipData build = new ToolTipData.ToolTipBuilder().text(str).setParentViewHeight(-2).xPos(!z10 ? i11 - p0.s(10) : (i11 - createDimensions.getWidth()) + p0.s(10)).yPos(!z10 ? i12 + p0.s(4) : (i12 + view.getHeight()) - p0.s(8)).imageResource(i10).onDismissListener(new ToolTipFactory.ToolTipDismissListener() { // from class: com.scores365.ui.f
                @Override // com.scores365.ui.tooltips.ToolTipFactory.ToolTipDismissListener
                public final void onDismissed() {
                    CustomGameCenterHeaderView.this.lambda$showToolTip$0();
                }
            }).build();
            if (z11) {
                String l02 = p0.l0("POSSESSION_TOOLTIP_TIME");
                if (!l02.isEmpty()) {
                    try {
                        build.setDismissTime(Long.parseLong(l02));
                    } catch (NumberFormatException e10) {
                        x0.N1(e10);
                    }
                }
                build.setDismissTimerEnabled(true);
            }
            toolTipFactory.showToolTip(build);
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    public void stopTimers() {
        try {
            GameCountDownHandler gameCountDownHandler = this.counterHandler;
            if (gameCountDownHandler != null) {
                gameCountDownHandler.cancel();
            }
            gameTimeUpdateTask gametimeupdatetask = this.gameTimeTask;
            if (gametimeupdatetask != null) {
                gametimeupdatetask.Clear();
            }
            if (!this.isVarEventShown) {
                stopNotificationAnim();
                return;
            }
            removeVarEvent(this.tvTop, this.tvBottom, this.animationTXT, this.animationIMG, this.animationArrowLeft, this.animationArrowRight, this.crossFadeNotificationAnimator);
            this.isVarEventShown = false;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
