package com.scores365.ui.playerCard;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.e1;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import bc.a;
import bc.b;
import cc.c1;
import com.amazon.device.ads.DtbConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.scores365.App;
import com.scores365.Design.Activities.g;
import com.scores365.Design.Pagers.GeneralTabPageIndicator;
import com.scores365.NewsCenter.ControllableAppBarLayout;
import com.scores365.NewsCenter.MyCoordinatorLayout;
import com.scores365.Pages.r;
import com.scores365.Pages.u;
import com.scores365.R;
import com.scores365.dashboard.MainDashboardActivity;
import com.scores365.dashboard.singleEntity.SingleEntityDashboardActivity;
import com.scores365.entitys.AthleteObj;
import com.scores365.entitys.AthleteStatisticsObj;
import com.scores365.entitys.AthletesObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.CountryObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GamesObj;
import com.scores365.entitys.HeaderObj;
import com.scores365.entitys.InjuryStatusObj;
import com.scores365.entitys.NotificationObj;
import com.scores365.entitys.StatusObj;
import com.scores365.entitys.SuspensionObj;
import com.scores365.entitys.TransfersObj;
import com.scores365.entitys.VideoObj;
import com.scores365.entitys.eAthleteInjuryCategory;
import com.scores365.entitys.eDashboardSection;
import com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj;
import com.scores365.gameCenter.o0;
import com.scores365.gameCenter.p0;
import com.scores365.services.b;
import com.scores365.ui.CustomSpinner;
import com.scores365.ui.NotificationListActivity;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Vector;
import li.x0;
import nb.o;
import uc.f;
/* loaded from: classes2.dex */
public class SinglePlayerCardActivity extends com.scores365.Design.Activities.c implements View.OnClickListener, OnShowAllProfileStatClickListener, o0, com.scores365.Design.Activities.g, p0, b.c {
    public static final String ANAL_SOURCE = "anal_source";
    public static final String ATHLETE_ID_KEY = "athleteId";
    public static final String ATHLETE_SOURCE = "athleteSource";
    public static final String COMPETITION_ID_KEY = "competitionId";
    public static final String IS_NATIONAL_CONTEXT = "is_national_context";
    public static final String PROMOTED_BUZZ_ITEM = "promotedBuzzItem";
    public static final String STARTING_PAGE = "startingPage";
    public static final String STAT_OPEN_TYPE = "statOpenType";
    public static long bootId = -1;
    private static int rest_counter;
    private ControllableAppBarLayout appBarLayout;
    private AthletesObj athletesObj;
    private AppCompatCheckBox cbFavourite;
    private ImageView checkBoxFillerStar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    public eDashboardSection currentPage;
    private ImageView headerBgTexture;
    private ConstraintLayout headerLayout;
    private CircleImageView ivPlayer;
    private CircleImageView ivPlayerCollapsed;
    private LinearLayout llSubtypeAndBrandLayout;
    private LinearLayout llSubtypeIndicator;
    private androidx.activity.result.b<Intent> notificationActivityResultLauncher;
    private bc.a notificationSpinnerAdapter;
    private CustomSpinner notificationsSpinner;
    protected u pagerAdapter;
    private ArrayList<com.scores365.Design.Pages.b> pagesList;
    private Handler restHandler;
    private RelativeLayout rlAdBannerLayout;
    private RelativeLayout rlPreloader;
    protected GeneralTabPageIndicator tabsIndicator;
    private TextView tvPlayerName;
    private TextView tvPlayerNameCollapsed;
    private TextView tvPlayerPosition;
    private com.scores365.services.b updateEngine;
    protected ViewPager viewPager;
    private int competitionId = -1;
    private int athleteId = -1;
    private int statsTabSelected = -1;
    private AthleteObj athleteObj = null;
    public GamesObj athleteFutureGame = null;
    public GameObj athleteUpdatedGame = null;
    boolean IS_GAMES_UPDATE_DEBUG_ON = false;
    private int possibleStatusBarHeight = 0;
    private int lastSubTypeItemClickedId = -1;
    LinkedHashMap<Integer, String> spinnerOptions = null;
    private final ValueAnimator.AnimatorUpdateListener animationListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.scores365.ui.playerCard.SinglePlayerCardActivity.1
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                SinglePlayerCardActivity.this.checkBoxFillerStar.setScaleX(floatValue);
                SinglePlayerCardActivity.this.checkBoxFillerStar.setScaleY(floatValue);
                SinglePlayerCardActivity.this.checkBoxFillerStar.setRotation((floatValue * 90.0f) + 270.0f);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    };
    protected ViewPager.j viewPagerPageChangeListener = new ViewPager.j() { // from class: com.scores365.ui.playerCard.SinglePlayerCardActivity.2
        private void sendStatisticsPageSelectedEvent() {
            ee.k.n(App.m(), "athlete", "stats", "click", null, true, "athlete_id", String.valueOf(SinglePlayerCardActivity.this.athleteId), ShareConstants.FEED_SOURCE_PARAM, SinglePlayerCardActivity.this.getAnalSource());
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            try {
                Fragment fragment = (Fragment) SinglePlayerCardActivity.this.viewPager.getAdapter().i(SinglePlayerCardActivity.this.viewPager, i10);
                if (i10 == 0) {
                    ee.k.n(App.m(), "athlete", Scopes.PROFILE, "click", null, true, "athlete_id", String.valueOf(SinglePlayerCardActivity.this.athleteId), ShareConstants.FEED_SOURCE_PARAM, SinglePlayerCardActivity.this.getAnalSource());
                } else if (i10 == 1) {
                    if (SinglePlayerCardActivity.this.athleteObj == null || !(SinglePlayerCardActivity.this.athleteObj.hasBuzz || SinglePlayerCardActivity.this.athleteObj.hasNews || SinglePlayerCardActivity.this.athleteObj.hasTransfers)) {
                        sendStatisticsPageSelectedEvent();
                    } else {
                        ee.k.n(App.m(), "athlete", SinglePlayerCardActivity.this.getBuzzSubPageAnalAction(), "click", null, true, "athlete_id", String.valueOf(SinglePlayerCardActivity.this.athleteId), ShareConstants.FEED_SOURCE_PARAM, SinglePlayerCardActivity.this.getAnalSource(), "type_of_click", "auto");
                    }
                } else if (i10 == 2) {
                    sendStatisticsPageSelectedEvent();
                }
                if (fragment instanceof com.scores365.Design.Pages.a) {
                    ((com.scores365.Design.Pages.a) fragment).onPageSelectedInViewPager();
                }
                SinglePlayerCardActivity.this.setSubTypeData(SinglePlayerCardActivity.this.pagerAdapter.t(i10));
                SinglePlayerCardActivity.this.showSubmenu();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scores365.ui.playerCard.SinglePlayerCardActivity$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$scores365$MainFragments$notificationSettings$NotificationSpinnerAdapter$NotificationState;
        static final /* synthetic */ int[] $SwitchMap$com$scores365$entitys$SuspensionObj$ESoccerSuspensionTypes;
        static final /* synthetic */ int[] $SwitchMap$com$scores365$entitys$eAthleteInjuryCategory;
        static final /* synthetic */ int[] $SwitchMap$com$scores365$entitys$eDashboardSection;
        static final /* synthetic */ int[] $SwitchMap$com$scores365$ui$playerCard$SinglePlayerCardActivity$eAthletePageType;

        static {
            int[] iArr = new int[a.EnumC0114a.values().length];
            $SwitchMap$com$scores365$MainFragments$notificationSettings$NotificationSpinnerAdapter$NotificationState = iArr;
            try {
                iArr[a.EnumC0114a.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scores365$MainFragments$notificationSettings$NotificationSpinnerAdapter$NotificationState[a.EnumC0114a.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scores365$MainFragments$notificationSettings$NotificationSpinnerAdapter$NotificationState[a.EnumC0114a.MUTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[eDashboardSection.values().length];
            $SwitchMap$com$scores365$entitys$eDashboardSection = iArr2;
            try {
                iArr2[eDashboardSection.BUZZ.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$scores365$entitys$eDashboardSection[eDashboardSection.NEWS.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$scores365$entitys$eDashboardSection[eDashboardSection.TRANSFERS.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[SuspensionObj.ESoccerSuspensionTypes.values().length];
            $SwitchMap$com$scores365$entitys$SuspensionObj$ESoccerSuspensionTypes = iArr3;
            try {
                iArr3[SuspensionObj.ESoccerSuspensionTypes.RedCard.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$scores365$entitys$SuspensionObj$ESoccerSuspensionTypes[SuspensionObj.ESoccerSuspensionTypes.YellowCards.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$scores365$entitys$SuspensionObj$ESoccerSuspensionTypes[SuspensionObj.ESoccerSuspensionTypes.Disciplinary.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[eAthleteInjuryCategory.values().length];
            $SwitchMap$com$scores365$entitys$eAthleteInjuryCategory = iArr4;
            try {
                iArr4[eAthleteInjuryCategory.MEDICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$scores365$entitys$eAthleteInjuryCategory[eAthleteInjuryCategory.UNKONWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$scores365$entitys$eAthleteInjuryCategory[eAthleteInjuryCategory.NATIONAL_TEAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$scores365$entitys$eAthleteInjuryCategory[eAthleteInjuryCategory.PERSONAL_REASONS.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr5 = new int[eAthletePageType.values().length];
            $SwitchMap$com$scores365$ui$playerCard$SinglePlayerCardActivity$eAthletePageType = iArr5;
            try {
                iArr5[eAthletePageType.PROFILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$scores365$ui$playerCard$SinglePlayerCardActivity$eAthletePageType[eAthletePageType.BUZZ.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$scores365$ui$playerCard$SinglePlayerCardActivity$eAthletePageType[eAthletePageType.STATS.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class GetSinglePlayer extends AsyncTask<Void, Void, Integer> {
        private static final int RESULT_BAD = 1335;
        private static final int RESULT_OK = 1334;
        WeakReference<SinglePlayerCardActivity> activityRef;

        public GetSinglePlayer(SinglePlayerCardActivity singlePlayerCardActivity) {
            this.activityRef = new WeakReference<>(singlePlayerCardActivity);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Integer doInBackground(Void... voidArr) {
            int i10 = RESULT_BAD;
            try {
                SinglePlayerCardActivity singlePlayerCardActivity = this.activityRef.get();
                com.scores365.api.a aVar = new com.scores365.api.a(String.valueOf(singlePlayerCardActivity.athleteId), singlePlayerCardActivity.competitionId);
                aVar.b(singlePlayerCardActivity.getIntent().getIntExtra(SinglePlayerCardActivity.PROMOTED_BUZZ_ITEM, 0));
                aVar.call();
                singlePlayerCardActivity.athletesObj = aVar.a();
                singlePlayerCardActivity.athleteObj = aVar.a().athleteById.get(Integer.valueOf(singlePlayerCardActivity.athleteId));
                if (singlePlayerCardActivity.athleteObj != null) {
                    SinglePlayerCardActivity.bootId = singlePlayerCardActivity.athleteObj.bootId;
                }
                if (singlePlayerCardActivity.athleteObj != null) {
                    i10 = RESULT_OK;
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return Integer.valueOf(i10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((GetSinglePlayer) num);
            try {
                SinglePlayerCardActivity.access$1008();
                if (num.intValue() == RESULT_OK) {
                    this.activityRef.get().setData();
                    this.activityRef.get().loadBanner();
                } else if (SinglePlayerCardActivity.rest_counter >= 10) {
                    int unused = SinglePlayerCardActivity.rest_counter = 0;
                } else {
                    this.activityRef.get().startAsyncRunner();
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            try {
                SinglePlayerCardActivity singlePlayerCardActivity = this.activityRef.get();
                if (singlePlayerCardActivity != null) {
                    singlePlayerCardActivity.rlPreloader.setVisibility(0);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class OffsetChangedListener implements AppBarLayout.h {
        WeakReference<SinglePlayerCardActivity> activityRef;

        public OffsetChangedListener(SinglePlayerCardActivity singlePlayerCardActivity) {
            this.activityRef = new WeakReference<>(singlePlayerCardActivity);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void onOffsetChanged(AppBarLayout appBarLayout, int i10) {
            try {
                SinglePlayerCardActivity singlePlayerCardActivity = this.activityRef.get() != null ? this.activityRef.get() : null;
                if (singlePlayerCardActivity != null) {
                    float s10 = (li.p0.s(58) + i10) / li.p0.s(58);
                    if (singlePlayerCardActivity.ivPlayer != null) {
                        singlePlayerCardActivity.ivPlayer.setAlpha(s10);
                    }
                    if (singlePlayerCardActivity.tvPlayerName != null) {
                        singlePlayerCardActivity.tvPlayerName.setAlpha(s10);
                    }
                    if (singlePlayerCardActivity.tvPlayerPosition != null) {
                        singlePlayerCardActivity.tvPlayerPosition.setAlpha(s10);
                    }
                    if (singlePlayerCardActivity.ivPlayerCollapsed != null) {
                        singlePlayerCardActivity.ivPlayerCollapsed.setAlpha(1.0f - s10);
                    }
                    if (singlePlayerCardActivity.tvPlayerNameCollapsed != null) {
                        singlePlayerCardActivity.tvPlayerNameCollapsed.setAlpha(1.0f - s10);
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SubTypeClickImplementation implements View.OnClickListener {
        private final WeakReference<SinglePlayerCardActivity> activityRef;
        private final WeakReference<SinglePlayerBuzzPageCreator> pageCreatorRef;
        private final jf.b subType;

        public SubTypeClickImplementation(SinglePlayerCardActivity singlePlayerCardActivity, jf.b bVar, SinglePlayerBuzzPageCreator singlePlayerBuzzPageCreator) {
            this.activityRef = new WeakReference<>(singlePlayerCardActivity);
            this.subType = bVar;
            this.pageCreatorRef = new WeakReference<>(singlePlayerBuzzPageCreator);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                SinglePlayerCardActivity singlePlayerCardActivity = this.activityRef.get();
                if (singlePlayerCardActivity == null || view.getId() == singlePlayerCardActivity.lastSubTypeItemClickedId) {
                    return;
                }
                u uVar = singlePlayerCardActivity.pagerAdapter;
                SinglePlayerBuzzPageCreator singlePlayerBuzzPageCreator = this.pageCreatorRef.get();
                if (uVar != null && singlePlayerBuzzPageCreator != null) {
                    jf.b bVar = this.subType;
                    singlePlayerBuzzPageCreator.currentSection = bVar.f32663a;
                    singlePlayerBuzzPageCreator.pageKey = bVar.f32668f;
                    uVar.k();
                }
                singlePlayerCardActivity.lastSubTypeItemClickedId = view.getId();
                singlePlayerCardActivity.updateSubMenuClickedItem(this.subType.f32668f);
                ee.k.n(App.m(), "athlete", singlePlayerCardActivity.getBuzzSubPageAnalAction(), "click", null, true, "athlete_id", String.valueOf(singlePlayerCardActivity.athleteId), ShareConstants.FEED_SOURCE_PARAM, singlePlayerCardActivity.getAnalSource(), "type_of_click", "click");
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum eAthletePageType {
        PROFILE,
        BUZZ,
        STATS
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class getAsyncData implements Runnable {
        private getAsyncData() {
        }

        @Override // java.lang.Runnable
        public void run() {
            new GetSinglePlayer(SinglePlayerCardActivity.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ExitScreen() {
        try {
            if (getIntent() != null && getIntent().getBooleanExtra(com.scores365.Design.Activities.c.IS_NOTIFICATION_ACTIVITY, false)) {
                Intent x02 = x0.x0();
                x02.setFlags(268435456);
                x02.setFlags(67108864);
                startActivity(x02);
            }
            finish();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    static /* synthetic */ int access$1008() {
        int i10 = rest_counter;
        rest_counter = i10 + 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEntityBecauseOfNotification() {
        try {
            App.b.a(this.athleteObj.getID(), this.athleteObj, this.entityType);
            x0.A2(null, null);
            App.b.y();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateStarChecked(boolean z10) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
        try {
            ValueAnimator ofFloat = z10 ? ValueAnimator.ofFloat(0.0f, 1.0f) : ValueAnimator.ofFloat(1.0f, 0.0f);
            if (ofFloat.getListeners() == null && (animatorUpdateListener = this.animationListener) != null) {
                ofFloat.addUpdateListener(animatorUpdateListener);
            }
            ofFloat.setDuration(300L);
            ofFloat.start();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static Intent createSinglePlayerCardActivityIntent(int i10, int i11, boolean z10) {
        Intent intent;
        Intent intent2 = null;
        try {
            intent = new Intent(App.m(), SinglePlayerCardActivity.class);
        } catch (Exception e10) {
            e = e10;
        }
        try {
            intent.putExtra("athleteId", i10);
            intent.putExtra(IS_NATIONAL_CONTEXT, z10);
            intent.putExtra(COMPETITION_ID_KEY, i11);
            return intent;
        } catch (Exception e11) {
            e = e11;
            intent2 = intent;
            x0.N1(e);
            return intent2;
        }
    }

    public static Intent createSinglePlayerCardActivityIntent(int i10, int i11, boolean z10, String str) {
        Intent intent;
        Intent intent2 = null;
        try {
            intent = new Intent(App.m(), SinglePlayerCardActivity.class);
        } catch (Exception e10) {
            e = e10;
        }
        try {
            intent.putExtra("athleteId", i10);
            intent.putExtra(ATHLETE_SOURCE, str);
            intent.putExtra(IS_NATIONAL_CONTEXT, z10);
            intent.putExtra(COMPETITION_ID_KEY, i11);
            return intent;
        } catch (Exception e11) {
            e = e11;
            intent2 = intent;
            x0.N1(e);
            return intent2;
        }
    }

    public static Intent createSinglePlayerCardActivityIntent(int i10, int i11, boolean z10, String str, eAthletePageType eathletepagetype, int i12, int i13, boolean z11) {
        Intent intent = null;
        try {
            Intent intent2 = new Intent(App.m(), SinglePlayerCardActivity.class);
            try {
                intent2.putExtra("athleteId", i10);
                intent2.putExtra(ATHLETE_SOURCE, str);
                intent2.putExtra(com.scores365.Design.Activities.c.ENTITY_ENTRANCE_SOURCE, str);
                intent2.putExtra(IS_NATIONAL_CONTEXT, z10);
                intent2.putExtra(COMPETITION_ID_KEY, i11);
                intent2.putExtra(STARTING_PAGE, eathletepagetype.ordinal());
                intent2.putExtra(PROMOTED_BUZZ_ITEM, i12);
                intent2.putExtra(STAT_OPEN_TYPE, i13);
                intent2.putExtra(com.scores365.Design.Activities.c.IS_NOTIFICATION_ACTIVITY, z11);
                return intent2;
            } catch (Exception e10) {
                e = e10;
                intent = intent2;
                x0.N1(e);
                return intent;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public static Intent createSinglePlayerCardActivityIntent(int i10, int i11, boolean z10, String str, String str2) {
        Intent intent;
        try {
            intent = createSinglePlayerCardActivityIntent(i10, i11, z10, str);
        } catch (Exception e10) {
            e = e10;
            intent = null;
        }
        try {
            intent.putExtra(com.scores365.Design.Activities.c.ENTITY_ENTRANCE_SOURCE, str2);
        } catch (Exception e11) {
            e = e11;
            x0.N1(e);
            return intent;
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAnalSource() {
        String str;
        try {
            if (getIntent().getExtras().containsKey(ANAL_SOURCE)) {
                str = getIntent().getExtras().getString(ANAL_SOURCE, "");
            } else if (!getIntent().getBooleanExtra(com.scores365.Design.Activities.c.IS_NOTIFICATION_ACTIVITY, false)) {
                return "tab";
            } else {
                str = "notification";
            }
            return str;
        } catch (Exception e10) {
            x0.N1(e10);
            return "tab";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getBuzzSubPageAnalAction() {
        try {
            int i10 = AnonymousClass4.$SwitchMap$com$scores365$entitys$eDashboardSection[((SinglePlayerBuzzPageCreator) this.pagesList.get(1)).currentSection.ordinal()];
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? "buzz" : "transfers" : "news" : "buzz";
        } catch (Exception e10) {
            x0.N1(e10);
            return "buzz";
        }
    }

    private int getStartPosition() {
        try {
            int i10 = AnonymousClass4.$SwitchMap$com$scores365$ui$playerCard$SinglePlayerCardActivity$eAthletePageType[eAthletePageType.values()[getIntent().getIntExtra(STARTING_PAGE, 0)].ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return 0;
                    }
                    return this.viewPager.getAdapter().e() > 2 ? 2 : 1;
                }
                return 1;
            }
            return 0;
        } catch (Exception e10) {
            x0.N1(e10);
            return 0;
        }
    }

    private int getStatusForEntityEntranceEvent(GameObj gameObj) {
        if (gameObj != null) {
            StatusObj statusObj = gameObj.getStatusObj();
            if (statusObj.getIsActive()) {
                return 2;
            }
            if (statusObj.getIsNotStarted()) {
                return 0;
            }
            if (statusObj.getIsFinished()) {
                return 1;
            }
        }
        return -1;
    }

    private void handleAthleteSelection() {
        String str;
        try {
            AthleteObj athleteObj = this.athleteObj;
            if (athleteObj != null) {
                int id2 = athleteObj.getID();
                App.c cVar = App.c.ATHLETE;
                if (App.b.r(id2, cVar)) {
                    App.b.u(this.athleteObj.getID(), cVar);
                    str = "unselect";
                } else {
                    App.b.a(this.athleteObj.getID(), this.athleteObj, cVar);
                    str = "select";
                }
                String str2 = str;
                this.notificationSpinnerAdapter.l();
                x0.A2(null, null);
                int value = this.athleteObj.getSportType().getValue();
                boolean h02 = App.b.h0(this.athleteId);
                boolean z10 = (getIntent() == null || getIntent().getExtras() == null) ? false : getIntent().getExtras().getBoolean(IS_NATIONAL_CONTEXT, false);
                int i10 = this.athleteId;
                x0.e2(cVar, i10, value, false, h02, false, false, "sorted-entity", "", str2, z10, !App.b.d0(i10, cVar));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void handleNotificationsSpinner() {
        try {
            if (x0.Z0(this.athleteObj.getSportTypeId())) {
                this.notificationsSpinner.setVisibility(0);
                final String l02 = li.p0.l0("TURN_ON_NOTIFICATIONS");
                String l03 = li.p0.l0("SELECTIONS_EDIT_NOTIFICATIONS_TITLE");
                final String l04 = li.p0.l0("BELL_NOTIFICATION_REMOVE");
                ArrayList arrayList = new ArrayList();
                bc.a aVar = new bc.a(arrayList, this.athleteObj, true, false);
                this.notificationSpinnerAdapter = aVar;
                int i10 = AnonymousClass4.$SwitchMap$com$scores365$MainFragments$notificationSettings$NotificationSpinnerAdapter$NotificationState[aVar.d().ordinal()];
                if (i10 == 1) {
                    arrayList.add(new bc.b(l03, b.a.CUSTOMIZE));
                    arrayList.add(new bc.b(l04, b.a.REMOVE));
                } else if (i10 == 2 || i10 == 3) {
                    arrayList.add(new bc.b(l02, b.a.DEFAULT));
                    arrayList.add(new bc.b(l03, b.a.CUSTOMIZE));
                }
                this.notificationsSpinner.setAdapter((SpinnerAdapter) this.notificationSpinnerAdapter);
                this.notificationsSpinner.setSelection(0);
                this.notificationsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.scores365.ui.playerCard.SinglePlayerCardActivity.3
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j10) {
                        String str;
                        boolean z10;
                        boolean z11;
                        boolean z12;
                        try {
                            b.a aVar2 = ((bc.a) adapterView.getAdapter()).getItem(i11) != null ? ((bc.a) adapterView.getAdapter()).getItem(i11).f9019b : null;
                            String str2 = "on";
                            b.a aVar3 = b.a.DEFAULT;
                            if (aVar2 == aVar3) {
                                z11 = !App.b.r(SinglePlayerCardActivity.this.athleteObj.getID(), SinglePlayerCardActivity.this.entityType);
                                NotificationSettingsBaseObj.newInstance(SinglePlayerCardActivity.this.athleteObj).resetNotifications();
                                SinglePlayerCardActivity.this.addEntityBecauseOfNotification();
                                if (!SinglePlayerCardActivity.this.cbFavourite.isChecked()) {
                                    SinglePlayerCardActivity.this.animateStarChecked(true);
                                    SinglePlayerCardActivity.this.cbFavourite.setChecked(true);
                                }
                                SingleEntityDashboardActivity.f23400h0 = true;
                                SinglePlayerCardActivity.this.notificationSpinnerAdapter.j(i11);
                                SinglePlayerCardActivity.this.notificationSpinnerAdapter.b(new bc.b(l04, b.a.REMOVE));
                                SinglePlayerCardActivity.this.notificationSpinnerAdapter.l();
                                str = "select";
                                z10 = true;
                            } else {
                                if (aVar2 == b.a.CUSTOMIZE) {
                                    if (!App.b.r(SinglePlayerCardActivity.this.athleteObj.getID(), SinglePlayerCardActivity.this.entityType)) {
                                        SinglePlayerCardActivity.this.addEntityBecauseOfNotification();
                                    }
                                    SinglePlayerCardActivity.this.notificationActivityResultLauncher.b(NotificationListActivity.getNotificationListActivityIntent(SinglePlayerCardActivity.this.athleteObj, "sorted-entity", null, null, true));
                                    if (App.b.r(SinglePlayerCardActivity.this.athleteObj.getID(), SinglePlayerCardActivity.this.entityType) && !App.b.d0(SinglePlayerCardActivity.this.athleteObj.getID(), SinglePlayerCardActivity.this.entityType)) {
                                        SinglePlayerCardActivity singlePlayerCardActivity = SinglePlayerCardActivity.this;
                                        if (!App.b.Q(singlePlayerCardActivity.entityType, singlePlayerCardActivity.athleteObj.getID()).isEmpty()) {
                                            z12 = true;
                                            ee.k.q(App.m(), "notification", "entity", "click", true, "entity_type", "5", "entity_id", String.valueOf(SinglePlayerCardActivity.this.athleteObj.getID()), "click_type", "on", ShareConstants.FEED_SOURCE_PARAM, "sorted-entity", "current-button-state", String.valueOf(z12));
                                        }
                                    }
                                    z12 = false;
                                    ee.k.q(App.m(), "notification", "entity", "click", true, "entity_type", "5", "entity_id", String.valueOf(SinglePlayerCardActivity.this.athleteObj.getID()), "click_type", "on", ShareConstants.FEED_SOURCE_PARAM, "sorted-entity", "current-button-state", String.valueOf(z12));
                                } else if (aVar2 == b.a.REMOVE) {
                                    App.b.t0(SinglePlayerCardActivity.this.athleteObj);
                                    MainDashboardActivity.f23295a1 = true;
                                    x0.A2(null, null);
                                    str2 = "off";
                                    SinglePlayerCardActivity.this.notificationSpinnerAdapter.j(i11);
                                    SinglePlayerCardActivity.this.notificationSpinnerAdapter.a(1, new bc.b(l02, aVar3));
                                    SinglePlayerCardActivity.this.notificationSpinnerAdapter.l();
                                    str = "unselect";
                                    z10 = true;
                                    z11 = false;
                                }
                                str = "select";
                                z10 = false;
                                z11 = true;
                            }
                            SinglePlayerCardActivity.this.notificationsSpinner.setSelection(0);
                            if (z10) {
                                ee.k.q(App.m(), "notification", "button", "click", true, "entity_type", "5", "entity_id", String.valueOf(SinglePlayerCardActivity.this.athleteObj.getID()), "click_type", str2, ShareConstants.FEED_SOURCE_PARAM, "sorted-entity");
                                boolean h02 = App.b.h0(SinglePlayerCardActivity.this.athleteObj.getID());
                                if (z11) {
                                    SinglePlayerCardActivity singlePlayerCardActivity2 = SinglePlayerCardActivity.this;
                                    x0.e2(singlePlayerCardActivity2.entityType, singlePlayerCardActivity2.athleteObj.getID(), SinglePlayerCardActivity.this.athleteObj.getSportTypeId(), false, h02, false, false, "sorted-entity", "", str, false, !App.b.d0(SinglePlayerCardActivity.this.athleteObj.getID(), SinglePlayerCardActivity.this.entityType));
                                }
                            }
                        } catch (Exception e10) {
                            x0.N1(e10);
                        }
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets lambda$onCreate$1(View view, WindowInsets windowInsets) {
        try {
            int systemWindowInsetTop = view.onApplyWindowInsets(windowInsets).getSystemWindowInsetTop();
            ((ViewGroup.MarginLayoutParams) this.headerLayout.getLayoutParams()).topMargin = systemWindowInsetTop;
            ((ViewGroup.MarginLayoutParams) this.toolbar.getLayoutParams()).topMargin = systemWindowInsetTop;
            this.possibleStatusBarHeight = systemWindowInsetTop;
            this.headerBgTexture.getLayoutParams().height = li.p0.s(146) + this.possibleStatusBarHeight;
            this.collapsingToolbarLayout.getLayoutParams().height = li.p0.s(146) + this.possibleStatusBarHeight;
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(ActivityResult activityResult) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onActivityResult: ");
            sb2.append(activityResult.b() == -1);
            Log.d("ShalomShalom", sb2.toString());
            if (activityResult.b() != -1 || activityResult.a() == null) {
                return;
            }
            setCheckboxStatus();
            this.notificationSpinnerAdapter.l();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadBanner() {
    }

    private void logGamesUpdateEvents(String str) {
        Log.d("GamesUpdateListener", str + ": games was updated");
    }

    private void sendEntityEntrance(int i10, int i11) {
        x0.W1("athlete", String.valueOf(i10), String.valueOf(i11), getIntent().getExtras().getString(com.scores365.Design.Activities.c.ENTITY_ENTRANCE_SOURCE, ""));
    }

    private void setActivityResult() {
        try {
            Intent intent = new Intent();
            intent.putExtra("is_selection_changed", true);
            setResult(-1, intent);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setCheckboxStatus() {
        try {
            boolean r10 = App.b.r(this.athleteId, App.c.ATHLETE);
            this.cbFavourite.setChecked(r10);
            if (r10) {
                this.checkBoxFillerStar.setRotation(360.0f);
                this.checkBoxFillerStar.setScaleX(1.0f);
                this.checkBoxFillerStar.setScaleY(1.0f);
            } else {
                this.checkBoxFillerStar.setRotation(270.0f);
                this.checkBoxFillerStar.setScaleX(0.0f);
                this.checkBoxFillerStar.setScaleY(0.0f);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setCollapsingToolbarOffsetChangeListener() {
        try {
            this.appBarLayout.d(new OffsetChangedListener(this));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SuspiciousIndentation"})
    public void setData() {
        int i10;
        CompObj compObj;
        CompetitionObj competitionObj;
        LinkedHashMap<Integer, CompetitionObj> linkedHashMap;
        CompetitionObj competitionObj2;
        AthletesObj athletesObj;
        AthleteStatisticsObj[] athleteStatisticsObjArr;
        try {
            this.spinnerOptions = new LinkedHashMap<>();
            HashSet hashSet = new HashSet();
            try {
                AthleteObj athleteObj = this.athleteObj;
                if (athleteObj != null && (athletesObj = this.athletesObj) != null && athletesObj.competitionsById != null && (athleteStatisticsObjArr = athleteObj.athleteStatistics) != null) {
                    for (AthleteStatisticsObj athleteStatisticsObj : athleteStatisticsObjArr) {
                        if (this.athletesObj.competitionsById.containsKey(Integer.valueOf(athleteStatisticsObj.competitionId))) {
                            hashSet.add(Integer.valueOf(athleteStatisticsObj.competitionId));
                        }
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            AthletesObj athletesObj2 = this.athletesObj;
            if (athletesObj2 != null && (linkedHashMap = athletesObj2.competitionsById) != null && !linkedHashMap.isEmpty()) {
                for (Integer num : this.athletesObj.competitionsById.keySet()) {
                    if (hashSet.contains(num) && (competitionObj2 = this.athletesObj.competitionsById.get(num)) != null) {
                        this.spinnerOptions.put(Integer.valueOf(competitionObj2.getID()), competitionObj2.getName());
                    }
                }
            }
            this.spinnerOptions.put(-1, li.p0.l0("WORLDCUP_PLAYER_STATS"));
            AthleteObj athleteObj2 = this.athleteObj;
            HeaderObj headerObj = athleteObj2 != null ? athleteObj2.getHeaderObj() : null;
            new ArrayAdapter(this, li.p0.h0(), new ArrayList(this.spinnerOptions.values())).setDropDownViewResource(R.layout.N);
            boolean z10 = getIntent().getExtras().getBoolean(IS_NATIONAL_CONTEXT, false);
            setUpSuspensionsAndInjuries(this.spinnerOptions.keySet().iterator().next().intValue());
            li.u.A(this.athleteObj.getAthleteImagePath(z10), this.ivPlayer, li.p0.K(R.attr.S0));
            li.u.A(this.athleteObj.getAthleteImagePath(z10), this.ivPlayerCollapsed, li.p0.K(R.attr.S0));
            this.tvPlayerName.setTypeface(li.o0.c(this));
            this.tvPlayerName.setText(this.athleteObj.getName());
            TextView textView = (TextView) findViewById(R.id.rC);
            this.tvPlayerNameCollapsed = textView;
            textView.setTypeface(li.o0.c(this));
            this.tvPlayerNameCollapsed.setText(this.athleteObj.getName());
            TextView textView2 = (TextView) findViewById(R.id.xC);
            this.tvPlayerPosition = textView2;
            textView2.setTypeface(li.o0.d(getApplicationContext()));
            String directFormationPosName = this.athleteObj.getDirectFormationPosName();
            String directPosName = this.athleteObj.getDirectPosName();
            if (this.athleteObj.getPlayerStatus() == 2) {
                if (this.athleteObj.getDateOfDeath() != null) {
                    StringBuilder sb2 = new StringBuilder();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(this.athleteObj.birthDate);
                    sb2.append(calendar.get(1));
                    sb2.append(" - ");
                    calendar.setTime(this.athleteObj.getDateOfDeath());
                    sb2.append(calendar.get(1));
                    this.tvPlayerPosition.setText(sb2);
                    this.tvPlayerPosition.setTextColor(li.p0.A(R.attr.f21556j1));
                    this.tvPlayerPosition.setVisibility(0);
                } else {
                    this.tvPlayerPosition.setVisibility(8);
                }
            } else if (directFormationPosName != null && !directFormationPosName.isEmpty()) {
                this.tvPlayerPosition.setText(directFormationPosName);
                this.tvPlayerPosition.setVisibility(0);
            } else if (directPosName == null || directPosName.isEmpty()) {
                this.tvPlayerPosition.setVisibility(8);
            } else {
                this.tvPlayerPosition.setText(directPosName);
                this.tvPlayerPosition.setVisibility(0);
            }
            if ((this.athleteObj.getPlayerStatus() == 1 && this.athletesObj.getCompetitorsById().get(Integer.valueOf(this.athleteObj.clubId)) == null) || this.athleteObj.getPlayerStatus() == 3) {
                this.tvPlayerPosition.setTextColor(li.p0.A(R.attr.B1));
            }
            this.pagesList = new ArrayList<>();
            SinglePlayerProfilePageCreator singlePlayerProfilePageCreator = new SinglePlayerProfilePageCreator(li.p0.l0("NEW_PLAYER_CARD_SOCCER_PROFILE"), null, sc.i.Dashboard, false, null, this.athletesObj, this.athleteObj, this.athleteFutureGame, z10, this.competitionId);
            this.pagesList.add(singlePlayerProfilePageCreator);
            AthleteObj athleteObj3 = this.athleteObj;
            if (athleteObj3 != null && (athleteObj3.hasBuzz || athleteObj3.hasNews || athleteObj3.hasTransfers)) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (this.athleteObj.hasBuzz) {
                    linkedHashSet.add(new jf.b(eDashboardSection.BUZZ, R.drawable.Z3, R.drawable.f21667a4, "buzz"));
                }
                if (this.athleteObj.hasNews) {
                    linkedHashSet.add(new jf.b(eDashboardSection.NEWS, R.drawable.X3, R.drawable.Y3, "news"));
                }
                TransfersObj transfersObj = new TransfersObj();
                if (this.athleteObj.hasTransfers) {
                    linkedHashSet.add(new jf.b(eDashboardSection.TRANSFERS, R.drawable.f21665a2, R.drawable.f21673b2, "transfers"));
                    try {
                        transfersObj.competitionById = new Hashtable<>(this.athletesObj.competitionsById);
                        transfersObj.competitorById = new Hashtable<>(this.athletesObj.competitorsById);
                        transfersObj.transfersById = new LinkedHashMap<>(this.athleteObj.transfersById);
                        transfersObj.countryById = new Hashtable<>(this.athletesObj.countryById);
                        transfersObj.sourceObjById = new Hashtable<>(this.athletesObj.newsSources);
                    } catch (Exception e11) {
                        x0.N1(e11);
                    }
                }
                ArrayList<com.scores365.Design.Pages.b> arrayList = this.pagesList;
                String l02 = li.p0.l0("GAME_CENTER_BUZZ");
                sc.i iVar = sc.i.Dashboard;
                AthleteObj athleteObj4 = this.athleteObj;
                arrayList.add(new SinglePlayerBuzzPageCreator(l02, null, iVar, false, null, athleteObj4.athleteBuzz, "", 2, false, true, false, athleteObj4.socialStats, athleteObj4.getID(), getIntent().getIntExtra(PROMOTED_BUZZ_ITEM, 0), linkedHashSet, this.athleteObj.athleteNews, transfersObj));
            }
            if (this.athleteObj.hasSeasonStats() || this.athleteObj.hasCareerStats()) {
                this.statsTabSelected = getIntent().getIntExtra(STAT_OPEN_TYPE, -1);
                this.pagesList.add(new SinglePlayerStatsPageCreator(li.p0.l0("NEW_PLAYER_CARD_SOCCER_STATS"), null, sc.i.Dashboard, false, null, this.athletesObj, this.athleteId, this.statsTabSelected, z10));
            }
            u uVar = new u(getSupportFragmentManager(), this.pagesList);
            this.pagerAdapter = uVar;
            uVar.v(this);
            ViewPager viewPager = (ViewPager) findViewById(R.id.PI);
            this.viewPager = viewPager;
            viewPager.setAdapter(this.pagerAdapter);
            GeneralTabPageIndicator generalTabPageIndicator = (GeneralTabPageIndicator) findViewById(R.id.Lr);
            this.tabsIndicator = generalTabPageIndicator;
            generalTabPageIndicator.setExpandedTabsContext(true);
            this.tabsIndicator.setTabTextColorWhite(true);
            this.tabsIndicator.setTabIndicatorColorWhite(true);
            this.tabsIndicator.setOnPageChangeListener(this.viewPagerPageChangeListener);
            this.tabsIndicator.setAlignTabTextToBottom(true);
            this.tabsIndicator.setViewPager(this.viewPager);
            ArrayList<com.scores365.Design.Pages.b> arrayList2 = this.pagesList;
            if (arrayList2 == null || arrayList2.size() >= 2) {
                i10 = 8;
                this.tabsIndicator.setVisibility(0);
            } else {
                i10 = 8;
                this.tabsIndicator.setVisibility(8);
            }
            this.cbFavourite = (AppCompatCheckBox) findViewById(R.id.f21925c2);
            this.checkBoxFillerStar = (ImageView) findViewById(R.id.Qa);
            int startPosition = getStartPosition();
            this.viewPager.setCurrentItem(startPosition);
            setSubTypeData(this.pagesList.get(startPosition));
            try {
                if (headerObj != null) {
                    if (headerObj.getTextColor() != null && !headerObj.getTextColor().isEmpty()) {
                        this.tabsIndicator.setTextColor(headerObj.getTextColor());
                        this.tvPlayerName.setTextColor(Color.parseColor(headerObj.getTextColor()));
                    }
                    if (headerObj.getSecondaryTextColor() != null && !headerObj.getSecondaryTextColor().isEmpty()) {
                        this.tvPlayerPosition.setTextColor(Color.parseColor(headerObj.getSecondaryTextColor()));
                    }
                    if (headerObj.isHasTexture()) {
                        li.u.x(o.t(headerObj.getTextureCompetition(), li.p0.s(UserVerificationMethods.USER_VERIFY_PATTERN) + this.possibleStatusBarHeight, headerObj.getEntityImageVersion()), this.headerBgTexture);
                    } else {
                        this.headerBgTexture.setImageResource(R.drawable.U);
                    }
                    if (headerObj.getMainColor() == null || headerObj.getMainColor().isEmpty()) {
                        this.appBarLayout.setBackgroundColor(li.p0.A(R.attr.A1));
                    } else {
                        this.appBarLayout.setBackgroundColor(li.p0.C(Color.parseColor(headerObj.getMainColor()), 1.0f));
                    }
                } else {
                    if (z10) {
                        Iterator<CompObj> it = this.athletesObj.getCompetitorsById().values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                compObj = null;
                                break;
                            }
                            CompObj next = it.next();
                            if (next.isNational()) {
                                compObj = next;
                                break;
                            }
                        }
                    } else {
                        compObj = this.athletesObj.competitorsById.get(Integer.valueOf(this.athleteObj.clubId));
                    }
                    if (compObj != null && (competitionObj = this.athletesObj.competitionsById.get(Integer.valueOf(compObj.getMainComp()))) != null) {
                        li.u.x(o.t(competitionObj.getID(), li.p0.s(UserVerificationMethods.USER_VERIFY_PATTERN) + this.possibleStatusBarHeight, competitionObj.getImgVer()), this.headerBgTexture);
                        if (compObj.getColor() == null || compObj.getColor().isEmpty()) {
                            this.appBarLayout.setBackgroundColor(li.p0.A(R.attr.A1));
                        } else {
                            this.appBarLayout.setBackgroundColor(li.p0.C(Color.parseColor(compObj.getColor()), 1.0f));
                        }
                    }
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            this.cbFavourite.setOnClickListener(this);
            this.cbFavourite.setButtonDrawable(R.drawable.f21818t3);
            setCheckboxStatus();
            this.checkBoxFillerStar.setImageResource(R.drawable.f21826u3);
            this.checkBoxFillerStar.setVisibility(0);
            this.cbFavourite.setVisibility(0);
            this.rlPreloader.setVisibility(i10);
            handleNotificationsSpinner();
            AthleteObj athleteObj5 = this.athleteObj;
            if (athleteObj5 != null) {
                if (TextUtils.isEmpty(athleteObj5.nextMatchApiURL)) {
                    sendEntityEntrance(this.athleteId, 1);
                } else {
                    new SinglePlayerFutureMatchCoroutine(this).fetchFutureMatchAsync(this.athleteObj, singlePlayerProfilePageCreator);
                }
            }
        } catch (Exception e13) {
            x0.N1(e13);
        }
    }

    private void setDeepLinkParams() {
        try {
            if (getIntent() == null || getIntent().getData() == null || getIntent().getData().getQueryParameter("entityid") == null || getIntent().getData().getQueryParameter("entityid").isEmpty()) {
                return;
            }
            int i10 = 0;
            Intent createSinglePlayerCardActivityIntent = createSinglePlayerCardActivityIntent(Integer.parseInt(getIntent().getData().getQueryParameter("entityid")), -1, false);
            String queryParameter = getIntent().getData().getQueryParameter("startingpage");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equalsIgnoreCase("BUZZ")) {
                i10 = 1;
            } else if (!TextUtils.isEmpty(queryParameter) && queryParameter.equalsIgnoreCase("STATS")) {
                i10 = 2;
            }
            createSinglePlayerCardActivityIntent.putExtra(ANAL_SOURCE, "deep-link");
            createSinglePlayerCardActivityIntent.putExtra(STARTING_PAGE, i10);
            setIntent(createSinglePlayerCardActivityIntent);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubTypeData(com.scores365.Design.Pages.b bVar) {
        try {
            this.llSubtypeIndicator.removeAllViews();
            if (!(bVar instanceof SinglePlayerBuzzPageCreator) || ((SinglePlayerBuzzPageCreator) bVar).pagesTypeSet == null || ((SinglePlayerBuzzPageCreator) bVar).pagesTypeSet.size() <= 1) {
                this.llSubtypeIndicator.setVisibility(8);
                return;
            }
            SinglePlayerBuzzPageCreator singlePlayerBuzzPageCreator = (SinglePlayerBuzzPageCreator) bVar;
            this.llSubtypeIndicator.setVisibility(0);
            Iterator<jf.b> it = singlePlayerBuzzPageCreator.pagesTypeSet.iterator();
            while (it.hasNext()) {
                jf.b next = it.next();
                LinearLayout linearLayout = new LinearLayout(App.m());
                linearLayout.setId(next.f32668f.hashCode());
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
                linearLayout.setOrientation(1);
                linearLayout.setWeightSum(1.0f);
                linearLayout.setGravity(81);
                ImageView imageView = new ImageView(App.m());
                imageView.setVisibility(4);
                ImageView imageView2 = new ImageView(App.m());
                imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                linearLayout.addView(imageView2);
                linearLayout.addView(imageView);
                linearLayout.setTag(next);
                imageView.setImageResource(li.p0.T(R.attr.J));
                if (next.f32663a.equals(singlePlayerBuzzPageCreator.currentSection)) {
                    imageView2.setImageResource(next.f32665c);
                } else {
                    imageView2.setImageResource(next.f32664b);
                    imageView.setVisibility(4);
                }
                this.llSubtypeIndicator.addView(linearLayout);
                linearLayout.setBackgroundResource(li.p0.w(App.m(), R.attr.K));
                linearLayout.setOnClickListener(new SubTypeClickImplementation(this, next, singlePlayerBuzzPageCreator));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAsyncRunner() {
        this.restHandler.postAtTime(new getAsyncData(), 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubMenuClickedItem(String str) {
        LinearLayout linearLayout;
        for (int i10 = 0; i10 < this.llSubtypeIndicator.getChildCount(); i10++) {
            try {
                if (!(this.llSubtypeIndicator.getChildAt(i10) instanceof LinearLayout)) {
                    ViewGroup viewGroup = (ViewGroup) this.llSubtypeIndicator.getChildAt(i10);
                    int i11 = 0;
                    while (true) {
                        if (i11 >= viewGroup.getChildCount()) {
                            linearLayout = null;
                            break;
                        } else if (viewGroup.getChildAt(i11) instanceof LinearLayout) {
                            linearLayout = (LinearLayout) viewGroup.getChildAt(i11);
                            break;
                        } else {
                            i11++;
                        }
                    }
                } else {
                    linearLayout = (LinearLayout) this.llSubtypeIndicator.getChildAt(i10);
                }
                ImageView imageView = (ImageView) linearLayout.getChildAt(0);
                ImageView imageView2 = (ImageView) linearLayout.getChildAt(1);
                jf.b bVar = (jf.b) linearLayout.getTag();
                if (bVar.f32668f.equals(str)) {
                    this.lastSubTypeItemClickedId = linearLayout.getId();
                    imageView.setImageResource(bVar.f32665c);
                    imageView2.setVisibility(4);
                } else {
                    imageView.setImageResource(bVar.f32664b);
                    imageView2.setVisibility(4);
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public ViewGroup GetBannerHolderView() {
        if (this.rlAdBannerLayout == null) {
            this.rlAdBannerLayout = (RelativeLayout) findViewById(R.id.ln);
        }
        return this.rlAdBannerLayout;
    }

    @Override // com.scores365.ui.playerCard.OnShowAllProfileStatClickListener
    public void OnShowAllProfileStatClick(int i10) {
        try {
            ArrayList<com.scores365.Design.Pages.b> u10 = this.pagerAdapter.u();
            for (int i11 = 0; i11 < u10.size(); i11++) {
                com.scores365.Design.Pages.b bVar = u10.get(i11);
                if (bVar instanceof SinglePlayerStatsPageCreator) {
                    SinglePlayerStatsPageCreator singlePlayerStatsPageCreator = (SinglePlayerStatsPageCreator) bVar;
                    singlePlayerStatsPageCreator.setSelectedTab(1);
                    singlePlayerStatsPageCreator.setSelectedCompetitionId(i10);
                    this.viewPager.setCurrentItem(i11);
                    Fragment fragment = (Fragment) this.viewPager.getAdapter().i(this.viewPager, i11);
                    if (fragment instanceof SinglePlayerStatsPage) {
                        SinglePlayerStatsPage singlePlayerStatsPage = (SinglePlayerStatsPage) fragment;
                        singlePlayerStatsPage.setSelectedCompetitionId(i10);
                        singlePlayerStatsPage.updateSelectedCompetitionIdOnUI();
                        singlePlayerStatsPage.changeTab(1);
                        return;
                    }
                    return;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.gameCenter.o0
    public boolean contentHasPadding() {
        return true;
    }

    @Override // com.scores365.gameCenter.o0
    public int getPaddingSize(com.scores365.Design.Pages.a aVar) {
        try {
            Iterator<com.scores365.Design.Pages.b> it = this.pagesList.iterator();
            while (it.hasNext()) {
                com.scores365.Design.Pages.b next = it.next();
                if ((next instanceof SinglePlayerBuzzPageCreator) && ((SinglePlayerBuzzPageCreator) next).pagesTypeSet.size() > 1 && ((aVar instanceof com.scores365.Pages.f) || (aVar instanceof r) || (aVar instanceof jd.e))) {
                    return (int) App.m().getResources().getDimension(R.dimen.f21654s);
                }
            }
            return 0;
        } catch (Exception e10) {
            x0.N1(e10);
            return 0;
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return "";
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public sc.i getPlacement() {
        return sc.i.AllScreens;
    }

    public void initUpdateEngine() {
        try {
            com.scores365.services.b bVar = this.updateEngine;
            if (bVar == null || !bVar.isEngineRunning()) {
                com.scores365.services.b bVar2 = this.updateEngine;
                if (bVar2 != null) {
                    bVar2.requestStop();
                    this.updateEngine = null;
                }
                PlayerCardGameEngine playerCardGameEngine = new PlayerCardGameEngine();
                this.updateEngine = playerCardGameEngine;
                playerCardGameEngine.setNextGameBaseUrl(this.athleteObj.nextMatchApiURL);
                this.updateEngine.setOnChangeListener(this);
                if (this.athleteUpdatedGame != null) {
                    this.updateEngine.start(true);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void insertFutureMatch(GamesObj gamesObj) {
        this.athleteFutureGame = gamesObj;
        for (Fragment fragment : getSupportFragmentManager().v0()) {
            if (fragment instanceof SinglePlayerProfilePage) {
                ((SinglePlayerProfilePage) fragment).insertFutureGameToPageList(gamesObj);
                GameObj gameObj = (GameObj) gamesObj.getGames().values().toArray()[0];
                this.athleteUpdatedGame = gameObj;
                sendEntityEntrance(this.athleteId, getStatusForEntityEntranceEvent(gameObj));
                initUpdateEngine();
                return;
            }
        }
    }

    @Override // com.scores365.gameCenter.p0
    public boolean isNeedToHandleScroll(com.scores365.Design.Pages.a aVar) {
        return true;
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setActivityResult();
        uc.d interstitialController = getInterstitialController();
        uc.f f10 = interstitialController.i().f();
        if ((f10 instanceof f.e) && interstitialController.u(this, (f.e) f10, new c1.a() { // from class: com.scores365.ui.playerCard.j
            @Override // cc.c1.a
            public final void a() {
                SinglePlayerCardActivity.this.ExitScreen();
            }
        })) {
            return;
        }
        ExitScreen();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (view.getId() == this.cbFavourite.getId()) {
                handleAthleteSelection();
                animateStarChecked(this.cbFavourite.isChecked());
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.services.b.c
    public void onCompetitionsUpdated(ArrayList<CompetitionObj> arrayList) {
        if (this.IS_GAMES_UPDATE_DEBUG_ON) {
            logGamesUpdateEvents("onCompetitionsUpdated");
        }
    }

    @Override // com.scores365.services.b.c
    public void onCountriesUpdated(ArrayList<CountryObj> arrayList) {
        if (this.IS_GAMES_UPDATE_DEBUG_ON) {
            logGamesUpdateEvents("onCountriesUpdated");
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            x0.j2(this);
            x0.D1(this);
            x0.i2(this, 360, DtbConstants.VIDEO_WIDTH);
            setContentView(R.layout.J8);
            this.entityType = App.c.ATHLETE;
            setDeepLinkParams();
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Jn);
            this.rlPreloader = relativeLayout;
            relativeLayout.setVisibility(0);
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.Fn);
            this.collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.f22112k8);
            this.headerBgTexture = (ImageView) findViewById(R.id.f22134l8);
            this.headerLayout = (ConstraintLayout) findViewById(R.id.f22372w3);
            ((MyCoordinatorLayout) findViewById(R.id.f22156m8)).setAllowForScrool(true);
            this.appBarLayout = (ControllableAppBarLayout) findViewById(R.id.f22090j8);
            this.checkBoxFillerStar = (ImageView) findViewById(R.id.Qa);
            this.cbFavourite = (AppCompatCheckBox) findViewById(R.id.f21925c2);
            this.ivPlayer = (CircleImageView) findViewById(R.id.f22425yc);
            this.ivPlayerCollapsed = (CircleImageView) findViewById(R.id.Cc);
            this.tvPlayerName = (TextView) findViewById(R.id.nC);
            this.notificationsSpinner = (CustomSpinner) findViewById(R.id.Ui);
            this.llSubtypeIndicator = (LinearLayout) findViewById(R.id.Mg);
            this.llSubtypeAndBrandLayout = (LinearLayout) findViewById(R.id.Lg);
            initActionBar();
            getToolbar().setBackground(null);
            try {
                this.competitionId = getIntent().getExtras().getInt(COMPETITION_ID_KEY);
            } catch (Exception unused) {
                this.competitionId = -1;
            }
            try {
                this.athleteId = getIntent().getExtras().getInt("athleteId", -1);
            } catch (Exception unused2) {
                this.athleteId = -1;
            }
            AthletesObj athletesObj = this.athletesObj;
            if (athletesObj == null) {
                new GetSinglePlayer(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                this.athleteObj = athletesObj.athleteById.get(Integer.valueOf(this.athleteId));
                setData();
            }
            try {
                constraintLayout.setSystemUiVisibility(1280);
                getWindow().addFlags(67108864);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.scores365.ui.playerCard.g
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    WindowInsets lambda$onCreate$1;
                    lambda$onCreate$1 = SinglePlayerCardActivity.this.lambda$onCreate$1(view, windowInsets);
                    return lambda$onCreate$1;
                }
            });
            setCollapsingToolbarOffsetChangeListener();
            HashMap hashMap = new HashMap();
            hashMap.put("athlete_id", String.valueOf(this.athleteId));
            if (getIntent() != null && getIntent().getExtras() != null && !getIntent().getExtras().getString(ATHLETE_SOURCE, "").isEmpty()) {
                hashMap.put(ShareConstants.FEED_SOURCE_PARAM, "popup");
            }
            if (sf.b.X1().L3()) {
                this.ivPlayer.setOnLongClickListener(new li.k(this.athleteId));
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setElevation(li.p0.s(4));
        }
        try {
            this.restHandler = new Handler();
        } catch (Exception e12) {
            x0.N1(e12);
        }
        this.notificationActivityResultLauncher = registerForActivityResult(new b.c(), new androidx.activity.result.a() { // from class: com.scores365.ui.playerCard.h
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                SinglePlayerCardActivity.this.lambda$onCreate$2((ActivityResult) obj);
            }
        });
    }

    @Override // com.scores365.services.b.c
    public void onGameAdded(GameObj gameObj) {
        if (this.IS_GAMES_UPDATE_DEBUG_ON) {
            logGamesUpdateEvents("onGameAdded");
        }
    }

    @Override // com.scores365.services.b.c
    public void onGameDeleted(GameObj gameObj) {
        if (this.IS_GAMES_UPDATE_DEBUG_ON) {
            logGamesUpdateEvents("onGameDeleted");
        }
    }

    @Override // com.scores365.services.b.c
    public void onGameUpdated(final GameObj gameObj) {
        if (gameObj != null) {
            try {
                runOnUiThread(new Runnable() { // from class: com.scores365.ui.playerCard.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        SinglePlayerCardActivity.this.lambda$onGameUpdated$0(gameObj);
                    }
                });
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
        if (this.IS_GAMES_UPDATE_DEBUG_ON) {
            logGamesUpdateEvents("onGameUpdated");
        }
    }

    @Override // com.scores365.services.b.c
    public void onGamesUpdated(GamesObj gamesObj) {
        if (gamesObj != null && gamesObj.getGames() != null && !gamesObj.getGames().isEmpty()) {
            onGameUpdated((GameObj) gamesObj.getGames().values().toArray()[0]);
        }
        if (this.IS_GAMES_UPDATE_DEBUG_ON) {
            logGamesUpdateEvents("onGamesUpdated");
        }
    }

    @Override // com.scores365.gameCenter.p0
    public void onInnerPageListScrolled(int i10) {
        try {
            if (this.llSubtypeIndicator.getVisibility() == 0) {
                LinearLayout linearLayout = this.llSubtypeAndBrandLayout;
                linearLayout.setTranslationY(linearLayout.getTranslationY() - i10);
            }
            if (this.llSubtypeAndBrandLayout.getTranslationY() >= 0.0f) {
                this.llSubtypeAndBrandLayout.setTranslationY(0.0f);
            } else if (this.llSubtypeAndBrandLayout.getTranslationY() < (-App.m().getResources().getDimension(R.dimen.f21654s))) {
                this.llSubtypeAndBrandLayout.setTranslationY(-App.m().getResources().getDimension(R.dimen.f21654s));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.services.b.c
    public void onNetworkError() {
        if (this.IS_GAMES_UPDATE_DEBUG_ON) {
            logGamesUpdateEvents("onNetworkError");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            setIntent(intent);
            try {
                this.competitionId = intent.getExtras().getInt(COMPETITION_ID_KEY);
            } catch (Exception unused) {
                this.competitionId = -1;
            }
            try {
                this.athleteId = intent.getExtras().getInt("athleteId", -1);
            } catch (Exception unused2) {
            }
            this.athletesObj = null;
            this.athleteObj = null;
            new GetSinglePlayer(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.services.b.c
    public void onNewVideoArrive(Vector<VideoObj> vector, GameObj gameObj) {
        if (this.IS_GAMES_UPDATE_DEBUG_ON) {
            logGamesUpdateEvents("onNewVideoArrive");
        }
    }

    @Override // com.scores365.services.b.c
    public void onNotification(NotificationObj notificationObj, GameObj gameObj) {
        if (this.IS_GAMES_UPDATE_DEBUG_ON) {
            logGamesUpdateEvents("onNotification");
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.scores365.Design.Activities.g
    public g.a onPageScroll(int i10) {
        g.a aVar = new g.a(0.0f, 0.0f);
        try {
            aVar.d(this.llSubtypeAndBrandLayout.getTranslationY());
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onPause() {
        super.onPause();
        bootId = -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.athleteUpdatedGame != null) {
            initUpdateEngine();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStop() {
        super.onStop();
        com.scores365.services.b bVar = this.updateEngine;
        if (bVar != null) {
            bVar.requestStop();
        }
    }

    @Override // com.scores365.Design.Activities.c
    public void relateToolbar() {
        super.relateToolbar();
        try {
            Toolbar toolbar = this.toolbar;
            if (toolbar != null) {
                toolbar.setNavigationIcon(R.drawable.f21696e1);
                e1.I0(this.toolbar, x0.m0());
                this.toolbar.setContentInsetsAbsolute(li.p0.s(16), 0);
                setSupportActionBar(this.toolbar);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setSelectedStatsTab(int i10) {
        try {
            this.statsTabSelected = i10;
            Iterator<com.scores365.Design.Pages.b> it = this.pagerAdapter.u().iterator();
            while (it.hasNext()) {
                com.scores365.Design.Pages.b next = it.next();
                if (next instanceof SinglePlayerStatsPageCreator) {
                    ((SinglePlayerStatsPageCreator) next).setSelectedTab(i10);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setUpSuspensionsAndInjuries(int i10) {
        boolean z10;
        LinkedHashMap<Integer, CompetitionObj> linkedHashMap;
        try {
            AthleteObj athleteObj = this.athleteObj;
            if (athleteObj != null) {
                InjuryStatusObj injuryStatusObj = athleteObj.getInjuryStatusObj();
                int i11 = 17;
                int i12 = 5;
                if (injuryStatusObj != null) {
                    RelativeLayout relativeLayout = new RelativeLayout(this);
                    relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    relativeLayout.setGravity(13);
                    LinearLayout linearLayout = new LinearLayout(App.m());
                    linearLayout.setId(li.p0.t());
                    linearLayout.setOrientation(0);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(14);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setGravity(1);
                    ImageView imageView = new ImageView(this);
                    imageView.setId(li.p0.t());
                    TextView textView = new TextView(this);
                    textView.setId(li.p0.t());
                    TextView textView2 = new TextView(this);
                    textView2.setId(li.p0.t());
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(li.p0.s(17), li.p0.s(17));
                    layoutParams2.leftMargin = li.p0.s(5);
                    layoutParams2.rightMargin = li.p0.s(5);
                    layoutParams2.topMargin = li.p0.s(1);
                    imageView.setLayoutParams(layoutParams2);
                    imageView.setAdjustViewBounds(true);
                    textView.setTypeface(li.o0.b(getApplicationContext()));
                    textView2.setTypeface(li.o0.b(getApplicationContext()));
                    int i13 = AnonymousClass4.$SwitchMap$com$scores365$entitys$eAthleteInjuryCategory[injuryStatusObj.getAthleteInjuryCategory().ordinal()];
                    if (i13 == 1 || i13 == 2) {
                        imageView.setImageResource(R.drawable.L2);
                    } else if (i13 == 3) {
                        imageView.setImageResource(R.drawable.I2);
                    } else if (i13 == 4) {
                        imageView.setImageResource(R.drawable.J2);
                    }
                    textView.setText(li.p0.l0("PLAYER_INJURY_STATUS").replace("#INJURY", injuryStatusObj.injuryType));
                    textView2.setText(li.p0.l0("PLAYER_RETURN_STATUS").replace("#RETURN", injuryStatusObj.expectedReturn));
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                    if (x0.l1()) {
                        textView.setGravity(5);
                        textView2.setGravity(5);
                        imageView.setLayoutParams(layoutParams2);
                        linearLayout.addView(textView);
                        linearLayout.addView(imageView);
                    } else {
                        textView.setGravity(3);
                        textView2.setGravity(3);
                        linearLayout.addView(imageView);
                        linearLayout.addView(textView);
                    }
                    layoutParams3.addRule(3, linearLayout.getId());
                    textView2.setLayoutParams(layoutParams3);
                    boolean z11 = !textView2.getText().toString().isEmpty();
                    relativeLayout.addView(linearLayout);
                    if (z11) {
                        relativeLayout.addView(textView2);
                    }
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10 || this.athleteObj.getSuspensions() == null) {
                    return;
                }
                SuspensionObj[] suspensions = this.athleteObj.getSuspensions();
                int length = suspensions.length;
                int i14 = 0;
                while (i14 < length) {
                    SuspensionObj suspensionObj = suspensions[i14];
                    if (i10 == -1 || suspensionObj.competition == i10) {
                        LinearLayout linearLayout2 = new LinearLayout(this);
                        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                        ImageView imageView2 = new ImageView(this);
                        TextView textView3 = new TextView(this);
                        textView3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                        linearLayout2.setGravity(i11);
                        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(li.p0.s(15), li.p0.s(15));
                        layoutParams4.gravity = i11;
                        if (z10) {
                            layoutParams4.topMargin = li.p0.s(i12);
                        }
                        layoutParams4.rightMargin = li.p0.s(i12);
                        layoutParams4.leftMargin = li.p0.s(i12);
                        imageView2.setLayoutParams(layoutParams4);
                        imageView2.setAdjustViewBounds(true);
                        textView3.setTypeface(li.o0.b(getApplicationContext()));
                        textView3.setGravity(i11);
                        int i15 = AnonymousClass4.$SwitchMap$com$scores365$entitys$SuspensionObj$ESoccerSuspensionTypes[suspensionObj.getSuspensionType().ordinal()];
                        if (i15 == 1) {
                            imageView2.setImageResource(R.drawable.f21780o5);
                        } else if (i15 == 2) {
                            imageView2.setImageResource(R.drawable.f21842w3);
                        } else if (i15 == 3) {
                            imageView2.setImageResource(R.drawable.K2);
                        }
                        String str = "";
                        AthletesObj athletesObj = this.athletesObj;
                        if (athletesObj != null && (linkedHashMap = athletesObj.competitionsById) != null && !linkedHashMap.isEmpty() && this.athletesObj.competitionsById.containsKey(Integer.valueOf(suspensionObj.competition))) {
                            str = suspensionObj.gamesCount > 1 ? li.p0.l0("PLAYER_SUSPENSION_STATUS_PLURAL").replace("#GAMES_COUNT", String.valueOf(suspensionObj.gamesCount)) : li.p0.l0("PLAYER_SUSPENSION_STATUS_SINGULAR");
                            try {
                                str = str.replace("#COMPETITION", this.athletesObj.competitionsById.get(Integer.valueOf(suspensionObj.competition)).getName());
                            } catch (Exception e10) {
                                x0.N1(e10);
                            }
                        }
                        textView3.setText(str);
                        linearLayout2.setOrientation(0);
                        if (x0.l1()) {
                            linearLayout2.addView(textView3);
                            linearLayout2.addView(imageView2);
                        } else {
                            linearLayout2.addView(imageView2);
                            linearLayout2.addView(textView3);
                        }
                    }
                    i14++;
                    i11 = 17;
                    i12 = 5;
                }
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    @Override // com.scores365.gameCenter.p0
    public void showSubmenu() {
        try {
            LinearLayout linearLayout = this.llSubtypeAndBrandLayout;
            if (linearLayout == null || linearLayout.getVisibility() != 0) {
                return;
            }
            this.llSubtypeAndBrandLayout.setY(0.0f);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* renamed from: updateGame */
    public void lambda$onGameUpdated$0(GameObj gameObj) {
        try {
            for (Fragment fragment : getSupportFragmentManager().v0()) {
                if (fragment instanceof hd.m) {
                    ((hd.m) fragment).onGameUpdate(gameObj);
                    return;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
