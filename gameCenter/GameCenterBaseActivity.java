package com.scores365.gameCenter;

import ag.c;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.webkit.WebChromeClient;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import androidx.activity.result.ActivityResult;
import androidx.annotation.NonNull;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.e1;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import bc.a;
import bc.b;
import cc.c1;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.scores365.App;
import com.scores365.Design.Pagers.GameCenterTabsIndicator;
import com.scores365.Design.Pages.CustomViewPager;
import com.scores365.DraggableView.GameCenterVideoDraggableItem;
import com.scores365.DraggableView.ScoresDraggableView;
import com.scores365.NewsCenter.ControllableAppBarLayout;
import com.scores365.NewsCenter.MyCoordinatorLayout;
import com.scores365.R;
import com.scores365.dashboard.MainDashboardActivity;
import com.scores365.entitys.BetObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GameTeaserObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.entitys.TableObj;
import com.scores365.entitys.WinProbabilityObj;
import com.scores365.entitys.allScoresCategories.AllScoresCategoryTypeEnum;
import com.scores365.entitys.notificationEntities.NotificationSettingsGameObj;
import com.scores365.gameCenter.c1;
import com.scores365.gameCenter.gameCenterItems.WinProbabilityChart;
import com.scores365.gameCenter.i0;
import com.scores365.removeAds.RemoveAdsManager;
import com.scores365.ui.CustomGameCenterHeaderView;
import com.scores365.ui.CustomSpinner;
import com.scores365.ui.GeneralNotificationListFragment;
import com.scores365.ui.NotificationListActivity;
import ec.o;
import ee.r;
import fd.c;
import gc.n;
import gc.p;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import ke.b;
import li.i0;
import qb.f;
import sf.b;
import uc.f;
import vf.b;
import xf.b;
import xf.q;
/* loaded from: classes2.dex */
public class GameCenterBaseActivity extends com.scores365.Design.Activities.c implements ViewPager.j, i0.k, c1.b, i0.l, i0.j, i0.n, i0.m, wh.b, p0, o0, b.InterfaceC0401b, gc.g0, b.a, WinProbabilityChart.a, rb.c, c.InterfaceC0303c, sh.g, n.a {
    private static Handler A1;
    private static j B1;
    private static Handler C1;
    private static h D1;
    private static final Map<Integer, Integer> E1;
    private static final Map<Integer, Integer> F1;
    private static final Map<Integer, Integer> G1;

    /* renamed from: v1  reason: collision with root package name */
    public static bg.e f23610v1;

    /* renamed from: w1  reason: collision with root package name */
    public static com.scores365.gameCenter.c f23611w1;

    /* renamed from: y1  reason: collision with root package name */
    private static int f23613y1;
    private bc.a A0;
    Thread B0;
    private CustomGameCenterHeaderView C0;
    MyCoordinatorLayout D0;
    ControllableAppBarLayout E0;
    private RelativeLayout F;
    CollapsingToolbarLayout F0;
    private CustomViewPager G;
    private GameCenterTabsIndicator H;
    private RelativeLayout I;
    int M0;
    public float O0;
    public int P0;

    /* renamed from: b0  reason: collision with root package name */
    private LinearLayout f23616b0;

    /* renamed from: b1  reason: collision with root package name */
    private GameCenterVideoDraggableItem f23617b1;

    /* renamed from: c1  reason: collision with root package name */
    public sb.a f23618c1;

    /* renamed from: d1  reason: collision with root package name */
    private GameCenterVideoDraggableItem.b f23619d1;

    /* renamed from: e1  reason: collision with root package name */
    private GameCenterVideoDraggableItem.a f23620e1;

    /* renamed from: f0  reason: collision with root package name */
    private View f23621f0;

    /* renamed from: g0  reason: collision with root package name */
    private LinearLayout f23623g0;

    /* renamed from: h0  reason: collision with root package name */
    private RelativeLayout f23625h0;

    /* renamed from: h1  reason: collision with root package name */
    private Handler f23626h1;

    /* renamed from: i0  reason: collision with root package name */
    private bg.b f23627i0;

    /* renamed from: i1  reason: collision with root package name */
    private boolean f23628i1;

    /* renamed from: j0  reason: collision with root package name */
    private i0 f23629j0;

    /* renamed from: k0  reason: collision with root package name */
    private ImageView f23631k0;

    /* renamed from: k1  reason: collision with root package name */
    private xe.c f23632k1;

    /* renamed from: l0  reason: collision with root package name */
    private ImageView f23633l0;

    /* renamed from: l1  reason: collision with root package name */
    private l0 f23634l1;

    /* renamed from: n0  reason: collision with root package name */
    private int f23637n0;

    /* renamed from: o0  reason: collision with root package name */
    private int f23639o0;

    /* renamed from: p0  reason: collision with root package name */
    private GameObj f23641p0;

    /* renamed from: q0  reason: collision with root package name */
    private CompetitionObj f23643q0;

    /* renamed from: q1  reason: collision with root package name */
    private Handler f23644q1;

    /* renamed from: y0  reason: collision with root package name */
    public w0 f23655y0;

    /* renamed from: u1  reason: collision with root package name */
    private static final int f23609u1 = App.o() - li.p0.s(232);

    /* renamed from: x1  reason: collision with root package name */
    public static boolean f23612x1 = false;

    /* renamed from: z1  reason: collision with root package name */
    private static boolean f23614z1 = false;

    /* renamed from: m0  reason: collision with root package name */
    private int f23635m0 = 0;

    /* renamed from: r0  reason: collision with root package name */
    private boolean f23645r0 = false;

    /* renamed from: s0  reason: collision with root package name */
    private boolean f23647s0 = false;

    /* renamed from: t0  reason: collision with root package name */
    private boolean f23649t0 = true;

    /* renamed from: u0  reason: collision with root package name */
    private bg.e f23651u0 = bg.e.DETAILS;

    /* renamed from: v0  reason: collision with root package name */
    private int f23652v0 = -1;

    /* renamed from: w0  reason: collision with root package name */
    private boolean f23653w0 = true;

    /* renamed from: x0  reason: collision with root package name */
    private long f23654x0 = -1;

    /* renamed from: z0  reason: collision with root package name */
    private CustomSpinner f23656z0 = null;
    private int G0 = 0;
    private int H0 = 0;
    private int I0 = 0;
    private int J0 = 0;
    private int K0 = 0;
    private final int L0 = li.p0.A0((int) App.m().getResources().getDimension(R.dimen.f21653r));
    public float N0 = 0.0f;
    private boolean Q0 = true;
    private boolean R0 = false;
    private boolean S0 = false;
    private boolean T0 = false;
    private boolean U0 = false;
    private boolean V0 = false;
    private int W0 = -1;
    private boolean X0 = false;
    private boolean Y0 = false;
    private int Z0 = -1;

    /* renamed from: a1  reason: collision with root package name */
    private String f23615a1 = null;

    /* renamed from: f1  reason: collision with root package name */
    private final View.OnTouchListener f23622f1 = new GameCenterVideoDraggableItem.c(this);

    /* renamed from: g1  reason: collision with root package name */
    private boolean f23624g1 = false;

    /* renamed from: j1  reason: collision with root package name */
    private final gc.p f23630j1 = new gc.p(this);

    /* renamed from: m1  reason: collision with root package name */
    private final androidx.lifecycle.a1 f23636m1 = this;

    /* renamed from: n1  reason: collision with root package name */
    private boolean f23638n1 = false;

    /* renamed from: o1  reason: collision with root package name */
    private boolean f23640o1 = false;

    /* renamed from: p1  reason: collision with root package name */
    private boolean f23642p1 = false;

    /* renamed from: r1  reason: collision with root package name */
    int f23646r1 = -1;

    /* renamed from: s1  reason: collision with root package name */
    androidx.activity.result.b<Intent> f23648s1 = registerForActivityResult(new b.c(), new androidx.activity.result.a() { // from class: com.scores365.gameCenter.f
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            GameCenterBaseActivity.this.b3((ActivityResult) obj);
        }
    });

    /* renamed from: t1  reason: collision with root package name */
    public f f23650t1 = new f() { // from class: com.scores365.gameCenter.j
        @Override // com.scores365.gameCenter.GameCenterBaseActivity.f
        public final androidx.appcompat.app.d z() {
            androidx.appcompat.app.d c32;
            c32 = GameCenterBaseActivity.this.c3();
            return c32;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23657a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23658b;

        a(String str, String str2) {
            this.f23657a = str;
            this.f23658b = str2;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            b.a aVar;
            int i11;
            HashSet hashSet;
            try {
                GameCenterBaseActivity.this.S0 = true;
                bc.b item = ((bc.a) adapterView.getAdapter()).getItem(i10);
                if (item != null) {
                    aVar = item.f9019b;
                    if (!App.b.r(GameCenterBaseActivity.this.f23641p0.getID(), App.c.GAME)) {
                        li.x0.Y1(GameCenterBaseActivity.this.f23641p0.getID(), GameCenterBaseActivity.this.f23641p0.getSportID(), false, false, false, false, "gamecenter", "gamecenter", "select", false, true, li.x0.k1(GameCenterBaseActivity.this.f23641p0), GameCenterBaseActivity.this.f23643q0.getCid(), GameCenterBaseActivity.this.f23643q0.getID(), GameCenterBaseActivity.this.f23641p0.getStatusObj().getIsActive() ? "2" : GameCenterBaseActivity.this.f23641p0.isFinished() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "0");
                    }
                } else {
                    aVar = null;
                }
                b.a aVar2 = b.a.DEFAULT;
                if (aVar == aVar2) {
                    new NotificationSettingsGameObj(GameCenterBaseActivity.this.f23641p0).resetNotifications();
                    App.b.a(GameCenterBaseActivity.this.f23641p0.getID(), GameCenterBaseActivity.this.f23641p0, App.c.GAME);
                    App.b.w0(GameCenterBaseActivity.this.f23641p0.getID());
                    MainDashboardActivity.f23295a1 = true;
                    GameCenterBaseActivity.this.A0.j(i10);
                    GameCenterBaseActivity.this.A0.b(new bc.b(this.f23657a, b.a.MUTE));
                    GameCenterBaseActivity.this.A0.l();
                    i11 = 0;
                } else if (aVar == b.a.CUSTOMIZE) {
                    int A0 = GameCenterBaseActivity.this.f23629j0.A0();
                    App.c cVar = App.c.GAME;
                    if (App.b.r(A0, cVar)) {
                        hashSet = new HashSet(App.b.Q(cVar, GameCenterBaseActivity.this.f23629j0.A0()));
                    } else {
                        int id2 = GameCenterBaseActivity.this.f23629j0.C0().getComps()[0].getID();
                        App.c cVar2 = App.c.TEAM;
                        if (App.b.r(id2, cVar2)) {
                            hashSet = new HashSet(App.b.Q(cVar2, GameCenterBaseActivity.this.f23629j0.C0().getComps()[0].getID()));
                        } else if (App.b.r(GameCenterBaseActivity.this.f23629j0.C0().getComps()[1].getID(), cVar2)) {
                            hashSet = new HashSet(App.b.Q(cVar2, GameCenterBaseActivity.this.f23629j0.C0().getComps()[1].getID()));
                        } else {
                            int competitionID = GameCenterBaseActivity.this.f23629j0.C0().getCompetitionID();
                            App.c cVar3 = App.c.LEAGUE;
                            hashSet = App.b.r(competitionID, cVar3) ? new HashSet(App.b.Q(cVar3, GameCenterBaseActivity.this.f23629j0.C0().getCompetitionID())) : null;
                        }
                    }
                    GameCenterBaseActivity gameCenterBaseActivity = GameCenterBaseActivity.this;
                    gameCenterBaseActivity.f23648s1.b(NotificationListActivity.getNotificationListActivityIntent(gameCenterBaseActivity.f23641p0, "gamecenter", hashSet, null, true));
                    i11 = !GameCenterBaseActivity.this.A0.i();
                } else if (aVar == b.a.MUTE) {
                    int A02 = GameCenterBaseActivity.this.f23629j0.A0();
                    GameObj C0 = GameCenterBaseActivity.this.f23629j0.C0();
                    App.c cVar4 = App.c.GAME;
                    App.b.d(A02, C0, cVar4, false);
                    App.b.p0(GameCenterBaseActivity.this.f23629j0.A0(), cVar4);
                    MainDashboardActivity.f23295a1 = true;
                    GameCenterBaseActivity.this.A0.j(i10);
                    GameCenterBaseActivity.this.A0.a(1, new bc.b(this.f23658b, aVar2));
                    GameCenterBaseActivity.this.A0.m(true);
                    i11 = 1;
                } else {
                    i11 = -1;
                }
                GameCenterBaseActivity.this.f23656z0.setSelection(0);
                if (aVar != null) {
                    ee.k.o(App.m(), "gamecenter", "game-notification", "click", null, "game_id", String.valueOf(GameCenterBaseActivity.this.f23641p0.getID()), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, String.valueOf(i0.D0(GameCenterBaseActivity.this.f23641p0)), "selection", String.valueOf(i11));
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements CustomSpinner.OnSpinnerEventsListener {
        b() {
        }

        @Override // com.scores365.ui.CustomSpinner.OnSpinnerEventsListener
        public void onSpinnerClosed() {
        }

        @Override // com.scores365.ui.CustomSpinner.OnSpinnerEventsListener
        public void onSpinnerOpened() {
            try {
                ee.k.q(App.m(), "gamecenter", "game-notification-main", "click", true, "game_id", String.valueOf(GameCenterBaseActivity.this.f23641p0.getID()), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, String.valueOf(i0.D0(GameCenterBaseActivity.this.f23641p0)));
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23661a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f23662b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f23663c;

        static {
            int[] iArr = new int[a.EnumC0114a.values().length];
            f23663c = iArr;
            try {
                iArr[a.EnumC0114a.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23663c[a.EnumC0114a.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23663c[a.EnumC0114a.MUTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[bg.e.values().length];
            f23662b = iArr2;
            try {
                iArr2[bg.e.STATISTICS.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23662b[bg.e.STANDINGS.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23662b[bg.e.NEWS.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23662b[bg.e.BUZZ.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23662b[bg.e.HIGHLIGHTS.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f23662b[bg.e.PLAYER_STATISTICS.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f23662b[bg.e.PLAY_BY_PLAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f23662b[bg.e.PLAY_BY_PLAY_BASKETBALL.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f23662b[bg.e.TRENDS.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f23662b[bg.e.LINEUPS.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f23662b[bg.e.HEAD_2_HEAD.ordinal()] = 11;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f23662b[bg.e.POINT_BY_POINT.ordinal()] = 12;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr3 = new int[f.c.values().length];
            f23661a = iArr3;
            try {
                iArr3[f.c.ByClick.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f23661a[f.c.BySwipe.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f23661a[f.c.Auto.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<GameCenterBaseActivity> f23664a;

        public d(GameCenterBaseActivity gameCenterBaseActivity) {
            this.f23664a = new WeakReference<>(gameCenterBaseActivity);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            try {
                GameCenterBaseActivity gameCenterBaseActivity = this.f23664a.get();
                if (gameCenterBaseActivity != null) {
                    gameCenterBaseActivity.K1();
                    gameCenterBaseActivity.O2();
                    return null;
                }
                return null;
            } catch (Exception e10) {
                li.x0.N1(e10);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r82) {
            try {
                super.onPostExecute(r82);
                GameCenterBaseActivity gameCenterBaseActivity = this.f23664a.get();
                if (gameCenterBaseActivity != null) {
                    if (gameCenterBaseActivity.f23641p0 == null) {
                        gameCenterBaseActivity.f23629j0 = new i0(gameCenterBaseActivity.f23637n0, gameCenterBaseActivity.f23639o0, gameCenterBaseActivity.f23652v0, gameCenterBaseActivity.f23647s0);
                        gameCenterBaseActivity.f23629j0.P3(gameCenterBaseActivity.f23632k1);
                        gameCenterBaseActivity.f23629j0.s3(gameCenterBaseActivity.f23634l1);
                        gameCenterBaseActivity.f23629j0.Q3(gameCenterBaseActivity.f23636m1);
                        gameCenterBaseActivity.f23625h0.setVisibility(0);
                        try {
                            mi.a.c(gameCenterBaseActivity.getIntent().getExtras().getInt("notification_system_id"));
                        } catch (Exception e10) {
                            li.x0.N1(e10);
                        }
                    } else {
                        gameCenterBaseActivity.f23629j0 = new i0(gameCenterBaseActivity.f23641p0, gameCenterBaseActivity.f23643q0, gameCenterBaseActivity.f23647s0);
                        gameCenterBaseActivity.f23629j0.P3(gameCenterBaseActivity.f23632k1);
                        gameCenterBaseActivity.f23629j0.s3(gameCenterBaseActivity.f23634l1);
                        gameCenterBaseActivity.f23629j0.Q3(gameCenterBaseActivity.f23636m1);
                        gameCenterBaseActivity.o3();
                    }
                    gameCenterBaseActivity.f23629j0.r3(gameCenterBaseActivity);
                    gameCenterBaseActivity.f23629j0.z3(gameCenterBaseActivity);
                    gameCenterBaseActivity.f23629j0.D3(gameCenterBaseActivity);
                    gameCenterBaseActivity.f23629j0.F3(gameCenterBaseActivity);
                    gameCenterBaseActivity.f23629j0.w0(gameCenterBaseActivity, gameCenterBaseActivity.getIntent().getIntExtra("notification_system_id", -1));
                    gameCenterBaseActivity.f23629j0.C3(gameCenterBaseActivity);
                    gameCenterBaseActivity.f23629j0.E3(gameCenterBaseActivity);
                    String str = "";
                    try {
                        if (gameCenterBaseActivity.f23629j0 != null && gameCenterBaseActivity.f23629j0.C0() != null) {
                            str = gameCenterBaseActivity.f23629j0.d0(gameCenterBaseActivity.f23629j0.C0().getCompetitionID());
                        }
                    } catch (Exception unused) {
                    }
                    gameCenterBaseActivity.u3();
                    if (gameCenterBaseActivity.f23629j0.C0() != null) {
                        gameCenterBaseActivity.C0.initializeView(gameCenterBaseActivity.f23629j0.a0(gameCenterBaseActivity.f23629j0.C0().getCompetitionID()), gameCenterBaseActivity.f23629j0.C0(), -1, str);
                    }
                    gameCenterBaseActivity.C0.setBackgroundColor(0);
                    gameCenterBaseActivity.J3();
                    GameCenterBaseActivity.J2(gameCenterBaseActivity);
                    gameCenterBaseActivity.M3(gameCenterBaseActivity.f23629j0.C0());
                    gameCenterBaseActivity.M0 = gameCenterBaseActivity.w2();
                    gameCenterBaseActivity.setCollapsingToolbarOffsetChangeListener();
                    gameCenterBaseActivity.F0.getLayoutParams().height = li.p0.s(gameCenterBaseActivity.M0);
                    gameCenterBaseActivity.L2();
                }
            } catch (Exception e11) {
                li.x0.N1(e11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class e implements AppBarLayout.h {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<GameCenterBaseActivity> f23665a;

        public e(GameCenterBaseActivity gameCenterBaseActivity) {
            this.f23665a = new WeakReference<>(gameCenterBaseActivity);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void onOffsetChanged(AppBarLayout appBarLayout, int i10) {
            try {
                WeakReference<GameCenterBaseActivity> weakReference = this.f23665a;
                GameCenterBaseActivity gameCenterBaseActivity = weakReference != null ? weakReference.get() : null;
                if (gameCenterBaseActivity != null) {
                    int i11 = -i10;
                    gameCenterBaseActivity.O0 = i11 / gameCenterBaseActivity.P0;
                    if (i11 < 0) {
                        gameCenterBaseActivity.O0 = 0.0f;
                    }
                    if (gameCenterBaseActivity.f23656z0 != null) {
                        if (i11 < gameCenterBaseActivity.P0 / 2) {
                            gameCenterBaseActivity.f23656z0.setVisibility(0);
                            gameCenterBaseActivity.f23656z0.setAlpha(1.0f - ((i11 * 2) / gameCenterBaseActivity.P0));
                        } else {
                            gameCenterBaseActivity.f23656z0.setVisibility(8);
                        }
                    }
                    gameCenterBaseActivity.C0.setTranslationY(gameCenterBaseActivity.O0 * gameCenterBaseActivity.N0);
                    gameCenterBaseActivity.C0.collapseToPercentage(gameCenterBaseActivity.O0);
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        androidx.appcompat.app.d z();
    }

    /* loaded from: classes2.dex */
    public static class g implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private static final long[] f23666c = {5000, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD, 30000, DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL};

        /* renamed from: a  reason: collision with root package name */
        private final int f23667a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference<Handler> f23668b;

        public g(int i10, Handler handler) {
            this.f23667a = i10;
            this.f23668b = new WeakReference<>(handler);
        }

        @Override // java.lang.Runnable
        public void run() {
            Handler handler;
            try {
                if (App.f20792l.n()) {
                    return;
                }
                int i10 = this.f23667a;
                long[] jArr = f23666c;
                if (i10 >= jArr.length || (handler = this.f23668b.get()) == null) {
                    return;
                }
                int i11 = this.f23667a;
                if (i11 + 1 < jArr.length) {
                    g gVar = new g(i11 + 1, handler);
                    int i12 = this.f23667a;
                    handler.postDelayed(gVar, jArr[i12 + 1] - jArr[i12]);
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        String f23669a;

        /* renamed from: b  reason: collision with root package name */
        HashMap<String, Object> f23670b;

        @Override // java.lang.Runnable
        public void run() {
            try {
                ee.k.k(App.m(), "gamecenter", this.f23669a, "click", null, this.f23670b);
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final bg.c f23671a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<bg.b> f23672b;

        /* renamed from: c  reason: collision with root package name */
        private final WeakReference<bg.a> f23673c;

        /* renamed from: d  reason: collision with root package name */
        private final WeakReference<GameCenterBaseActivity> f23674d;

        public i(bg.c cVar, bg.b bVar, bg.a aVar, GameCenterBaseActivity gameCenterBaseActivity) {
            this.f23671a = cVar;
            this.f23672b = new WeakReference<>(bVar);
            this.f23673c = new WeakReference<>(aVar);
            this.f23674d = new WeakReference<>(gameCenterBaseActivity);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (view.getId() != GameCenterBaseActivity.this.f23646r1) {
                    bg.b bVar = this.f23672b.get();
                    bg.a aVar = this.f23673c.get();
                    if (bVar != null && aVar != null) {
                        bg.e eVar = this.f23671a.f9102a;
                        aVar.f9094b = eVar;
                        GameCenterBaseActivity.f23610v1 = eVar;
                        bVar.k();
                        GameCenterBaseActivity.this.X0 = false;
                        GameCenterBaseActivity gameCenterBaseActivity = this.f23674d.get();
                        if (gameCenterBaseActivity != null) {
                            gameCenterBaseActivity.t0();
                        }
                    }
                    li.x0.Z1("GameCenterBaseActivity " + bg.c.b(aVar.f9094b) + " click");
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("game_id", String.valueOf(GameCenterBaseActivity.this.f23629j0.C0().getID()));
                    hashMap.put("type_of_click", "click");
                    hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.D0(GameCenterBaseActivity.this.f23629j0.C0()));
                    hashMap.put("is_match_tracker", String.valueOf(GameCenterBaseActivity.this.N2()));
                    hashMap.put("stage_id", String.valueOf(GameCenterBaseActivity.this.f23629j0.c0().CurrStage));
                    hashMap.put("competition_id", String.valueOf(GameCenterBaseActivity.this.f23629j0.c0().getID()));
                    hashMap.put(ShareConstants.FEED_SOURCE_PARAM, GameCenterBaseActivity.this.f23646r1 != -1 ? bg.c.b(bg.e.values()[GameCenterBaseActivity.this.f23646r1]) : "details");
                    hashMap.put("is_from_notification", Boolean.valueOf(GameCenterBaseActivity.this.f23647s0));
                    if (GameCenterBaseActivity.C1 == null) {
                        Handler unused = GameCenterBaseActivity.C1 = new Handler();
                    }
                    if (GameCenterBaseActivity.D1 == null) {
                        h unused2 = GameCenterBaseActivity.D1 = new h();
                    }
                    if (GameCenterBaseActivity.A1 == null) {
                        Handler unused3 = GameCenterBaseActivity.A1 = new Handler();
                    }
                    if (GameCenterBaseActivity.B1 == null) {
                        j unused4 = GameCenterBaseActivity.B1 = new j();
                    }
                    GameCenterBaseActivity.A1.removeCallbacks(GameCenterBaseActivity.B1);
                    if (bg.c.b(aVar.f9094b).equals("lineups") && GameCenterBaseActivity.this.f23629j0.C0() != null && GameCenterBaseActivity.this.f23629j0.C0().getLineUps() != null && GameCenterBaseActivity.this.f23629j0.C0().getLineUps()[0] != null) {
                        hashMap.put("is_ratings", GameCenterBaseActivity.this.f23629j0.C0().getLineUps()[0].isHasRankings() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "0");
                    }
                    GameCenterBaseActivity.B1.a(bg.c.b(aVar.f9094b), hashMap);
                    GameCenterBaseActivity.A1.postDelayed(GameCenterBaseActivity.B1, 1000L);
                    GameCenterBaseActivity.this.f23646r1 = view.getId();
                    GameCenterBaseActivity.this.L3(this.f23671a.f9102a);
                    GameCenterBaseActivity gameCenterBaseActivity2 = GameCenterBaseActivity.this;
                    gameCenterBaseActivity2.I2(gameCenterBaseActivity2.G != null ? GameCenterBaseActivity.this.G.getCurrentItem() : -1);
                    GameCenterBaseActivity.this.I3();
                    if (this.f23671a.f9102a.equals(bg.e.ODDS) || this.f23671a.f9102a.equals(bg.e.TRENDS)) {
                        sf.b.X1().m3(b.e.BettingFeatureCount);
                        ee.c.f25841a.c(r.a.f25905a);
                    }
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        String f23676a;

        /* renamed from: b  reason: collision with root package name */
        HashMap<String, Object> f23677b;

        public void a(String str, HashMap<String, Object> hashMap) {
            this.f23676a = str;
            this.f23677b = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ee.k.k(App.m(), "gamecenter", this.f23676a, "click", null, this.f23677b);
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        E1 = hashMap;
        hashMap.put(1, Integer.valueOf(R.drawable.f21743k0));
        hashMap.put(2, Integer.valueOf(R.drawable.f21727i0));
        hashMap.put(3, 0);
        hashMap.put(4, Integer.valueOf(R.drawable.f21759m0));
        hashMap.put(5, Integer.valueOf(R.drawable.f21751l0));
        hashMap.put(6, Integer.valueOf(R.drawable.f21711g0));
        hashMap.put(7, Integer.valueOf(R.drawable.f21719h0));
        hashMap.put(8, Integer.valueOf(R.drawable.f21799r0));
        hashMap.put(9, Integer.valueOf(R.drawable.f21767n0));
        hashMap.put(11, Integer.valueOf(R.drawable.f21735j0));
        hashMap.put(12, Integer.valueOf(R.drawable.f21846x));
        hashMap.put(13, Integer.valueOf(R.drawable.f21743k0));
        HashMap hashMap2 = new HashMap();
        F1 = hashMap2;
        hashMap2.put(1, Integer.valueOf(R.drawable.f21710g));
        hashMap2.put(2, Integer.valueOf(R.drawable.f21727i0));
        hashMap2.put(3, 0);
        hashMap2.put(4, Integer.valueOf(R.drawable.f21759m0));
        hashMap2.put(5, Integer.valueOf(R.drawable.f21726i));
        hashMap2.put(6, Integer.valueOf(R.drawable.f21710g));
        hashMap2.put(7, Integer.valueOf(R.drawable.f21710g));
        hashMap2.put(8, Integer.valueOf(R.drawable.f21726i));
        hashMap2.put(9, Integer.valueOf(R.drawable.f21710g));
        hashMap2.put(11, Integer.valueOf(R.drawable.f21710g));
        hashMap2.put(12, Integer.valueOf(R.drawable.f21846x));
        hashMap2.put(13, Integer.valueOf(R.drawable.f21710g));
        HashMap hashMap3 = new HashMap();
        G1 = hashMap3;
        hashMap3.put(1, Integer.valueOf(R.drawable.f21775o0));
        hashMap3.put(2, Integer.valueOf(R.drawable.f21791q0));
        hashMap3.put(3, Integer.valueOf(R.drawable.f21775o0));
        hashMap3.put(4, Integer.valueOf(R.drawable.f21775o0));
        hashMap3.put(5, Integer.valueOf(R.drawable.f21783p0));
        hashMap3.put(6, Integer.valueOf(R.drawable.f21775o0));
        hashMap3.put(7, Integer.valueOf(R.drawable.f21791q0));
        hashMap3.put(8, Integer.valueOf(R.drawable.f21775o0));
        hashMap3.put(9, Integer.valueOf(R.drawable.f21775o0));
    }

    @SuppressLint({"WrongConstant"})
    public static Intent A1(int i10, bg.e eVar, String str, int i11) {
        Intent intent;
        Intent intent2 = null;
        try {
            intent = new Intent(App.m(), GameCenterBaseActivity.class);
        } catch (Exception e10) {
            e = e10;
        }
        try {
            intent.addFlags(603979776);
            if (!com.scores365.Design.Activities.c.isActivityVisible()) {
                intent.addFlags(268435456);
            }
            intent.putExtra("promo_item_id", i11);
            intent.putExtra("gc_game_id", i10);
            intent.putExtra("gc_starting_tab", eVar.ordinal());
            intent.putExtra("analyticsSource", str);
            intent.putExtra(com.scores365.Design.Activities.c.ENTITY_ENTRANCE_SOURCE, str);
            return intent;
        } catch (Exception e11) {
            e = e11;
            intent2 = intent;
            li.x0.N1(e);
            return intent2;
        }
    }

    private String A2(bg.e eVar) {
        switch (c.f23662b[eVar.ordinal()]) {
            case 1:
                return "0";
            case 2:
                return AppEventsConstants.EVENT_PARAM_VALUE_YES;
            case 3:
                return "2";
            case 4:
                return GeneralNotificationListFragment.ANALYTICS_ENTITY_TYPE_SPORT_TYPE;
            case 5:
                return "4";
            case 6:
                return "5";
            case 7:
            case 8:
                return "9";
            case 9:
                return "10";
            case 10:
                return "11";
            case 11:
                return "12";
            case 12:
                return "7";
            default:
                return "";
        }
    }

    public static Intent B1(int i10, bg.e eVar, String str, String str2) {
        return C1(i10, eVar, str, true, str2);
    }

    public static int B2() {
        return f23613y1;
    }

    public static Intent C1(int i10, bg.e eVar, String str, boolean z10, String str2) {
        Intent intent;
        Intent intent2 = null;
        try {
            intent = new Intent(App.m(), GameCenterBaseActivity.class);
        } catch (Exception e10) {
            e = e10;
        }
        try {
            intent.addFlags(268435456);
            intent.putExtra("gc_game_id", i10);
            intent.putExtra("gc_starting_tab", eVar.ordinal());
            intent.putExtra("analyticsSource", str);
            intent.putExtra("showInterstitialOnExit", z10);
            if (str2 != null) {
                intent.putExtra(com.scores365.Design.Activities.c.ENTITY_ENTRANCE_SOURCE, str2);
                return intent;
            }
            return intent;
        } catch (Exception e11) {
            e = e11;
            intent2 = intent;
            li.x0.N1(e);
            return intent2;
        }
    }

    public static bg.e C2() {
        return f23610v1;
    }

    private boolean C3() {
        try {
            androidx.viewpager.widget.a adapter = this.G.getAdapter();
            CustomViewPager customViewPager = this.G;
            Fragment fragment = (Fragment) adapter.i(customViewPager, customViewPager.getCurrentItem());
            if (fragment instanceof zf.c) {
                return ((zf.c) fragment).p2();
            }
            return false;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    public static Intent D1(Context context, GameObj gameObj, CompetitionObj competitionObj, int i10, bg.e eVar, int[] iArr, String str, String str2, boolean z10, boolean z11, int i11, int i12, int i13, int i14, int i15) {
        Intent intent = new Intent(context, GameCenterBaseActivity.class);
        l3(intent, eVar, z10, gameObj, iArr, competitionObj, z11, i13, i10, i14);
        try {
            intent.putExtra("analyticsSource", str);
            intent.putExtra("analyticsSection", str2);
            intent.putExtra("allScoresCategoryId", i11);
            intent.putExtra("allScoresCategoryType", i12);
            intent.putExtra("allScoresHelperSection", i15);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return intent;
    }

    private static int D2(int i10, boolean z10, int i11) {
        int intValue;
        int i12 = 0;
        try {
            if (i10 != 3) {
                intValue = z10 ? F1.get(Integer.valueOf(i10)).intValue() : E1.get(Integer.valueOf(i10)).intValue();
            } else if (z10) {
                intValue = R.drawable.f21718h;
            } else {
                Map<Integer, Integer> map = G1;
                intValue = map.containsKey(Integer.valueOf(i11)) ? map.get(Integer.valueOf(i11)).intValue() : R.drawable.f21775o0;
            }
            i12 = intValue;
            x3(true);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return i12;
    }

    private boolean D3(int i10) {
        bg.b bVar = this.f23627i0;
        if (bVar != null) {
            com.scores365.Design.Pages.b t10 = bVar.t(i10);
            return ((t10 instanceof bg.a) && ((bg.a) t10).f9094b == bg.e.STORY) ? false : true;
        }
        return true;
    }

    public static Intent E1(Context context, GameObj gameObj, CompetitionObj competitionObj, int i10, bg.e eVar, int[] iArr, String str, String str2, boolean z10, boolean z11, int i11, int i12, int i13, int i14, String str3, int i15) {
        Intent intent = new Intent(context, GameCenterBaseActivity.class);
        l3(intent, eVar, z10, gameObj, iArr, competitionObj, z11, i13, i10, i14);
        try {
            intent.putExtra("analyticsSource", str);
            intent.putExtra("analyticsSection", str2);
            intent.putExtra("allScoresCategoryId", i11);
            intent.putExtra("allScoresCategoryType", i12);
            intent.putExtra("allScoresHelperSection", i15);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        intent.putExtra(com.scores365.Design.Activities.c.ENTITY_ENTRANCE_SOURCE, str3);
        return intent;
    }

    private String E2(GameObj gameObj) {
        return gameObj.isNotStarted() ? "0" : gameObj.getIsActive() ? "2" : gameObj.isFinished() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ExitScreen() {
        try {
            if (this.f23647s0) {
                Intent x02 = li.x0.x0();
                x02.setFlags(268435456);
                x02.setFlags(67108864);
                x02.putExtra("startFromGameNotif", true);
                startActivity(x02);
                finish();
            } else {
                finish();
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public static Intent F1(Context context, GameObj gameObj, CompetitionObj competitionObj, int i10, int[] iArr, String str, String str2, int i11, int i12) {
        return D1(context, gameObj, competitionObj, i10, bg.e.DETAILS, iArr, str, str2, false, false, i11, i12, -1, -1, -1);
    }

    private boolean F3() {
        try {
            return !RemoveAdsManager.isUserAdsRemoved(App.m());
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    public static Intent G1(Context context, GameObj gameObj, CompetitionObj competitionObj, int i10, int[] iArr, String str, String str2, int i11, int i12, String str3, int i13) {
        return E1(context, gameObj, competitionObj, i10, bg.e.DETAILS, iArr, str, str2, false, false, i11, i12, -1, -1, str3, i13);
    }

    private int G2(int i10) {
        try {
            bg.a aVar = (bg.a) this.f23627i0.t(i10);
            r0 = aVar.f9093a.size() > 1 ? (int) App.m().getResources().getDimension(R.dimen.f21654s) : 0;
            return (i10 == 0 && aVar.f9094b == bg.e.DETAILS) ? r0 + this.f23635m0 : r0;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return r0;
        }
    }

    private void G3() {
        try {
            Handler handler = this.f23626h1;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public static Intent H1(Context context, GameObj gameObj, CompetitionObj competitionObj, int i10, int[] iArr, String str, String str2, boolean z10, boolean z11, int i11, int i12, String str3, int i13) {
        return E1(context, gameObj, competitionObj, i10, bg.e.DETAILS, iArr, str, str2, z10, z11, -1, -1, i11, i12, str3, i13);
    }

    private void I1() {
        sc.i placement;
        sc.k n10;
        try {
            i0 i0Var = this.f23629j0;
            if ((i0Var != null && (i0Var.Q(i0Var.g0()) == 2 || !this.T0)) || (placement = getPlacement()) == null || (n10 = cc.o0.n(placement)) == null) {
                return;
            }
            if (n10 == sc.k.Banner || n10 == sc.k.Both) {
                cc.r.l(this, this);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2(int i10) {
        try {
            cc.z0 z0Var = this.bannerHandler;
            if (z0Var != null && z0Var.f10132d != sc.h.FailedToLoad) {
                if (this.f23627i0 != null) {
                    q3(i10);
                    if (GetBannerHolderView().getChildCount() == 0 || C3()) {
                        GetBannerHolderView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            GetBannerHolderView().setVisibility(8);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I3() {
        try {
            if (this.f23633l0 == null) {
                this.f23633l0 = (ImageView) findViewById(R.id.Ia);
            }
            final gc.h hVar = this.f23629j0.U(this).get(sc.f.Branded_GC_Strip);
            if (this.f23627i0 == null || hVar == null) {
                return;
            }
            if (hVar.g() == null) {
                this.f23629j0.n3(this.f23647s0);
                hVar.n(this);
            }
            bg.a aVar = (bg.a) this.f23627i0.t(B2());
            NativeAd.Image x10 = hVar.x();
            if (this.f23641p0.getIsActive() || x10 == null || aVar.f9094b != bg.e.DETAILS) {
                this.f23633l0.setVisibility(8);
                return;
            }
            this.f23633l0.setVisibility(0);
            this.f23633l0.setImageDrawable(x10.getDrawable());
            this.f23635m0 = (int) (App.p() * hVar.z());
            this.f23633l0.getLayoutParams().height = this.f23635m0;
            this.f23633l0.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.gameCenter.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GameCenterBaseActivity.h3(gc.h.this, view);
                }
            });
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J2(@NonNull GameCenterBaseActivity gameCenterBaseActivity) {
        try {
            i0 i0Var = gameCenterBaseActivity.f23629j0;
            if (i0Var != null && i0Var.C0() != null) {
                gameCenterBaseActivity.f23631k0.setImageResource(D2(gameCenterBaseActivity.f23629j0.C0().getSportID(), gameCenterBaseActivity.f23629j0.C0().shouldShowLiveMatchTracker(), gameCenterBaseActivity.f23629j0.C0().getSurface()));
            }
            if (gameCenterBaseActivity.R0) {
                return;
            }
            gc.p pVar = gameCenterBaseActivity.f23630j1;
            p.b bVar = p.b.GameCenter;
            NativeCustomFormatAd A = pVar.A(bVar, gameCenterBaseActivity.F2().C0(), -1);
            if (A == null) {
                gameCenterBaseActivity.f23630j1.E(gameCenterBaseActivity, bVar, gameCenterBaseActivity.F2().C0(), -1);
                return;
            }
            gameCenterBaseActivity.f23630j1.v(A);
            gameCenterBaseActivity.j1("12157593", A, gameCenterBaseActivity.f23630j1);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J3() {
        try {
            MenuItem findItem = this.toolbar.getMenu().findItem(R.id.f22036h);
            if (findItem != null) {
                findItem.setVisible(this.f23629j0.C0().getSportID() == SportTypesEnum.SOCCER.getValue());
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        try {
            i0 i0Var = this.f23629j0;
            if (i0Var == null || i0Var.C0() == null) {
                return;
            }
            if (!this.f23629j0.C0().isFinished() && this.f23629j0.A0() >= 0) {
                if (this.f23656z0 == null) {
                    v2(this.toolbar, (LinearLayoutCompat) this.toolbar.findViewById(R.id.Ss));
                    return;
                }
                return;
            }
            if (this.f23656z0 != null) {
                ((LinearLayoutCompat) this.toolbar.findViewById(R.id.Ss)).removeView(this.f23656z0);
            }
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
    }

    private void K2(boolean z10) {
        try {
            androidx.viewpager.widget.a adapter = this.G.getAdapter();
            CustomViewPager customViewPager = this.G;
            Fragment fragment = (Fragment) adapter.i(customViewPager, customViewPager.getCurrentItem());
            if (fragment instanceof zf.c) {
                ((zf.c) fragment).s2(z10, this);
            } else {
                androidx.viewpager.widget.a adapter2 = this.G.getAdapter();
                CustomViewPager customViewPager2 = this.G;
                Fragment fragment2 = (Fragment) adapter2.i(customViewPager2, customViewPager2.getCurrentItem() - 1);
                if (fragment2 instanceof zf.c) {
                    ((zf.c) fragment2).s2(z10, this);
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L2() {
        try {
            final Drawable B = this.f23630j1.B();
            int z10 = this.f23630j1.z();
            if (B != null) {
                if (z10 == -1 || z10 == F2().C0().getTopBookMaker()) {
                    new Thread(new Runnable() { // from class: com.scores365.gameCenter.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            GameCenterBaseActivity.this.a3(B);
                        }
                    }).start();
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L3(bg.e eVar) {
        ConstraintLayout constraintLayout;
        for (int i10 = 0; i10 < this.f23616b0.getChildCount(); i10++) {
            try {
                if (!(this.f23616b0.getChildAt(i10) instanceof ConstraintLayout)) {
                    ViewGroup viewGroup = (ViewGroup) this.f23616b0.getChildAt(i10);
                    int i11 = 0;
                    while (true) {
                        if (i11 >= viewGroup.getChildCount()) {
                            constraintLayout = null;
                            break;
                        } else if (viewGroup.getChildAt(i11) instanceof ConstraintLayout) {
                            constraintLayout = (ConstraintLayout) viewGroup.getChildAt(i11);
                            break;
                        } else {
                            i11++;
                        }
                    }
                } else {
                    constraintLayout = (ConstraintLayout) this.f23616b0.getChildAt(i10);
                }
                if (constraintLayout != null) {
                    ImageView imageView = (ImageView) constraintLayout.getChildAt(0);
                    bg.c cVar = (bg.c) constraintLayout.getTag();
                    if (cVar.f9102a == eVar) {
                        this.f23646r1 = constraintLayout.getId();
                        imageView.setImageResource(cVar.f9104c);
                    } else {
                        imageView.setImageResource(cVar.f9103b);
                    }
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
                return;
            }
        }
    }

    private void M2() {
        try {
            if (F3()) {
                this.f23617b1.setGameCenterWeakReference(this);
                this.f23617b1.setPivotY(0.0f);
                this.f23617b1.setPivotX(0.0f);
                if (this.f23618c1 == null) {
                    this.f23617b1.setEnabled(true);
                    this.f23617b1.setClickable(true);
                    this.f23618c1 = new sb.a(this);
                    this.f23617b1.setOnTouchListener(this.f23622f1);
                    this.f23619d1 = new GameCenterVideoDraggableItem.b(this.f23617b1, this);
                    this.f23620e1 = new GameCenterVideoDraggableItem.a(this.f23617b1);
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006f A[Catch: Exception -> 0x0099, TryCatch #0 {Exception -> 0x0099, blocks: (B:3:0x0002, B:5:0x000b, B:7:0x0015, B:9:0x001a, B:11:0x0022, B:13:0x002c, B:14:0x0033, B:16:0x003a, B:18:0x0040, B:21:0x0050, B:23:0x005d, B:29:0x006f, B:30:0x0071, B:32:0x0081, B:36:0x0094, B:20:0x004a, B:8:0x0018), top: B:41:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0094 A[Catch: Exception -> 0x0099, TRY_LEAVE, TryCatch #0 {Exception -> 0x0099, blocks: (B:3:0x0002, B:5:0x000b, B:7:0x0015, B:9:0x001a, B:11:0x0022, B:13:0x002c, B:14:0x0033, B:16:0x003a, B:18:0x0040, B:21:0x0050, B:23:0x005d, B:29:0x006f, B:30:0x0071, B:32:0x0081, B:36:0x0094, B:20:0x004a, B:8:0x0018), top: B:41:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void M3(com.scores365.entitys.GameObj r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L9d
            java.lang.String r0 = r5.GetWinDescription()     // Catch: java.lang.Exception -> L99
            r1 = 20
            r2 = 0
            if (r0 == 0) goto L18
            java.lang.String r0 = r5.GetWinDescription()     // Catch: java.lang.Exception -> L99
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> L99
            if (r0 != 0) goto L18
            r4.H0 = r1     // Catch: java.lang.Exception -> L99
            goto L1a
        L18:
            r4.H0 = r2     // Catch: java.lang.Exception -> L99
        L1a:
            r4.G0 = r2     // Catch: java.lang.Exception -> L99
            boolean r0 = com.scores365.gameCenter.i0.N2(r5)     // Catch: java.lang.Exception -> L99
            if (r0 == 0) goto L38
            int r3 = r5.getSportID()     // Catch: java.lang.Exception -> L99
            boolean r3 = li.x0.F2(r3)     // Catch: java.lang.Exception -> L99
            if (r3 == 0) goto L33
            int r3 = r4.G0     // Catch: java.lang.Exception -> L99
            int r3 = r3 + 10
            r4.G0 = r3     // Catch: java.lang.Exception -> L99
            goto L38
        L33:
            int r3 = r4.G0     // Catch: java.lang.Exception -> L99
            int r3 = r3 + r1
            r4.G0 = r3     // Catch: java.lang.Exception -> L99
        L38:
            if (r0 != 0) goto L4a
            java.lang.String r0 = r5.GetWinDescription()     // Catch: java.lang.Exception -> L99
            if (r0 == 0) goto L50
            java.lang.String r0 = r5.GetWinDescription()     // Catch: java.lang.Exception -> L99
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> L99
            if (r0 != 0) goto L50
        L4a:
            int r0 = r4.H0     // Catch: java.lang.Exception -> L99
            int r0 = r0 + 10
            r4.H0 = r0     // Catch: java.lang.Exception -> L99
        L50:
            com.scores365.entitys.CompObj[] r0 = r5.getComps()     // Catch: java.lang.Exception -> L99
            r0 = r0[r2]     // Catch: java.lang.Exception -> L99
            java.util.ArrayList r0 = r0.getRankingObjs()     // Catch: java.lang.Exception -> L99
            r3 = 1
            if (r0 != 0) goto L6c
            com.scores365.entitys.CompObj[] r0 = r5.getComps()     // Catch: java.lang.Exception -> L99
            r0 = r0[r3]     // Catch: java.lang.Exception -> L99
            java.util.ArrayList r0 = r0.getRankingObjs()     // Catch: java.lang.Exception -> L99
            if (r0 == 0) goto L6a
            goto L6c
        L6a:
            r0 = 0
            goto L6d
        L6c:
            r0 = 1
        L6d:
            if (r0 == 0) goto L71
            r4.I0 = r1     // Catch: java.lang.Exception -> L99
        L71:
            com.scores365.entitys.CompObj[] r0 = r5.getComps()     // Catch: java.lang.Exception -> L99
            r0 = r0[r2]     // Catch: java.lang.Exception -> L99
            java.lang.String r0 = r0.getRecordStr()     // Catch: java.lang.Exception -> L99
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> L99
            if (r0 == 0) goto L91
            com.scores365.entitys.CompObj[] r5 = r5.getComps()     // Catch: java.lang.Exception -> L99
            r5 = r5[r3]     // Catch: java.lang.Exception -> L99
            java.lang.String r5 = r5.getRecordStr()     // Catch: java.lang.Exception -> L99
            boolean r5 = r5.isEmpty()     // Catch: java.lang.Exception -> L99
            if (r5 != 0) goto L92
        L91:
            r2 = 1
        L92:
            if (r2 == 0) goto L9d
            r5 = 15
            r4.J0 = r5     // Catch: java.lang.Exception -> L99
            goto L9d
        L99:
            r5 = move-exception
            li.x0.N1(r5)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.GameCenterBaseActivity.M3(com.scores365.entitys.GameObj):void");
    }

    private void P2() {
        try {
            xf.b.f42251d = false;
            zf.c.I = false;
            f23611w1 = new com.scores365.gameCenter.c();
            this.f23655y0 = new w0(this);
            new d(this).execute(new Void[0]);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private boolean U2(ArrayList<com.scores365.Design.Pages.b> arrayList, ArrayList<com.scores365.Design.Pages.b> arrayList2) {
        return arrayList.size() != arrayList2.size();
    }

    private boolean V2() {
        try {
            GameObj gameObj = this.f23641p0;
            if (gameObj != null) {
                return gameObj.getSportID() == SportTypesEnum.SOCCER.getValue();
            }
            return false;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W2(uc.d dVar, ec.h hVar) {
        this.f23629j0.B3(hVar);
        j3(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X2(GameTeaserObj gameTeaserObj) {
        if (gameTeaserObj != null) {
            try {
                GameObj C0 = this.f23629j0.C0();
                i0 i0Var = this.f23629j0;
                OnGameCompleteGameData(C0, i0Var.a0(i0Var.C0().getCompetitionID()), true);
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y2() {
        this.f23625h0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z2(Bitmap bitmap) {
        try {
            this.f23631k0.setImageBitmap(bitmap);
            this.f23631k0.setScaleType(ImageView.ScaleType.FIT_START);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a3(Drawable drawable) {
        try {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            final Bitmap createBitmap = Bitmap.createBitmap(bitmapDrawable.getBitmap(), 0, 0, bitmapDrawable.getBitmap().getWidth(), (li.p0.s(w2()) * bitmapDrawable.getBitmap().getWidth()) / App.p());
            this.f23631k0.post(new Runnable() { // from class: com.scores365.gameCenter.i
                @Override // java.lang.Runnable
                public final void run() {
                    GameCenterBaseActivity.this.Z2(createBitmap);
                }
            });
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b3(ActivityResult activityResult) {
        try {
            s3((LinearLayoutCompat) this.toolbar.findViewById(R.id.Ss));
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ androidx.appcompat.app.d c3() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets d3(View view, WindowInsets windowInsets) {
        try {
            int systemWindowInsetTop = view.onApplyWindowInsets(windowInsets).getSystemWindowInsetTop();
            ((ViewGroup.MarginLayoutParams) this.I.getLayoutParams()).topMargin = systemWindowInsetTop;
            ((ViewGroup.MarginLayoutParams) this.toolbar.getLayoutParams()).topMargin = systemWindowInsetTop;
            this.K0 = li.p0.A0(systemWindowInsetTop);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f3() {
        this.f23625h0.setVisibility(0);
        this.f23625h0.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g3(float f10, ValueAnimator valueAnimator) {
        try {
            this.f23617b1.setTranslationX(f10 + (((Float) valueAnimator.getAnimatedValue()).floatValue() * (li.p0.s(142) + li.p0.s(15))));
            if (((Float) valueAnimator.getAnimatedValue()).floatValue() >= 1.0f) {
                ee.k.j(App.m(), "365tv", "exit", "click", null, App.g(null, false), false, ShareConstants.FEED_SOURCE_PARAM, "my-scores");
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h3(gc.h hVar, View view) {
        try {
            hVar.g().performClick("strip_image");
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private void i3(@NonNull uc.d dVar) {
        try {
            if (!this.f23638n1) {
                cc.s0 w10 = cc.o0.w(sc.f.BigLayout);
                if (w10 != null) {
                    this.f23629j0.B3(w10);
                    j3(dVar);
                    this.f23638n1 = true;
                } else if (!this.f23640o1) {
                    this.f23640o1 = true;
                    this.f23629j0.q3();
                    this.f23629j0.v3();
                    cc.r.F(this, this, sc.i.GameDetails, null);
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private void j3(@NonNull uc.d dVar) {
        try {
            CustomViewPager customViewPager = this.G;
            if (customViewPager != null && customViewPager.getAdapter() != null) {
                androidx.viewpager.widget.a adapter = this.G.getAdapter();
                CustomViewPager customViewPager2 = this.G;
                Object i10 = adapter.i(customViewPager2, customViewPager2.getCurrentItem());
                if (i10 instanceof zf.c) {
                    ((zf.c) i10).B1(dVar);
                } else {
                    androidx.viewpager.widget.a adapter2 = this.G.getAdapter();
                    CustomViewPager customViewPager3 = this.G;
                    Fragment fragment = (Fragment) adapter2.i(customViewPager3, customViewPager3.getCurrentItem() - 1);
                    if (fragment instanceof zf.c) {
                        ((zf.c) fragment).B1(dVar);
                    }
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private static void l3(Intent intent, bg.e eVar, boolean z10, GameObj gameObj, int[] iArr, CompetitionObj competitionObj, boolean z11, int i10, int i11, int i12) {
        if (iArr != null) {
            for (int i13 : iArr) {
                intent.addFlags(i13);
            }
        }
        try {
            intent.putExtra("gc_starting_tab", eVar.ordinal());
            intent.putExtra(MainDashboardActivity.Y0, z10);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(gameObj);
            intent.putExtra("GAME", byteArrayOutputStream.toByteArray());
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream2).writeObject(competitionObj);
            intent.putExtra("COMPETITION", byteArrayOutputStream2.toByteArray());
            intent.putExtra("isPromotedForAnalytics", z11);
            intent.putExtra("wwwPredictionID", i10);
            intent.putExtra("gameItemPositionToUpdate", i12);
            intent.putExtra("gc_game_id", gameObj.getID());
            intent.putExtra("gc_competition_id", i11);
        } catch (IOException e10) {
            li.x0.N1(e10);
        }
    }

    private void m3() {
        try {
            K1();
            this.f23637n0 = -1;
            this.f23639o0 = -1;
            this.f23641p0 = null;
            this.f23627i0 = null;
            this.f23617b1 = null;
            J1();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private void n3(boolean z10) {
        bg.b bVar;
        try {
            CustomViewPager customViewPager = this.G;
            if (customViewPager != null && (bVar = this.f23627i0) != null) {
                com.scores365.Design.Pages.b t10 = bVar.t(customViewPager.getCurrentItem());
                if ((t10 instanceof bg.a) && ((bg.a) t10).f9094b == bg.e.STORY) {
                    androidx.viewpager.widget.a adapter = this.G.getAdapter();
                    CustomViewPager customViewPager2 = this.G;
                    com.scores365.Pages.d0 d0Var = (com.scores365.Pages.d0) adapter.i(customViewPager2, customViewPager2.getCurrentItem());
                    if (z10) {
                        d0Var.LoadDataAsync();
                    } else {
                        d0Var.B1();
                    }
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p3 */
    public void e3(HashMap<String, Object> hashMap) {
        try {
            ee.k.k(App.m(), "gamecenter", "main-tab", "click", null, hashMap);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private void q3(int i10) {
        if (D3(i10)) {
            GetBannerHolderView().setVisibility(0);
        } else {
            GetBannerHolderView().setVisibility(8);
        }
    }

    private void r3() {
        int i10;
        try {
            int i11 = getIntent().getExtras().getInt("notification_id");
            if ((i11 == 10 || i11 == 17 || i11 == 18 || i11 == 16 || i11 == 19) && (i10 = getIntent().getExtras().getInt("competitorIdNotification")) > -1) {
                App.b.q();
                if (App.b.r(i10, App.c.TEAM)) {
                    sf.b.X1().H7(sf.b.X1().q1());
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private void s3(LinearLayoutCompat linearLayoutCompat) {
        linearLayoutCompat.removeAllViews();
        String l02 = li.p0.l0("TURN_ON_NOTIFICATIONS");
        String l03 = li.p0.l0("SELECTIONS_EDIT_NOTIFICATIONS_TITLE");
        String l04 = li.p0.l0("GAME_CENTER_MUTE");
        ArrayList arrayList = new ArrayList();
        a.C0025a c0025a = new a.C0025a(-1, -1);
        ((ViewGroup.MarginLayoutParams) c0025a).leftMargin = li.p0.s(10);
        c0025a.f1578a = 16;
        linearLayoutCompat.addView(this.f23656z0, c0025a);
        bc.a aVar = new bc.a(arrayList, this.f23641p0);
        this.A0 = aVar;
        int i10 = c.f23663c[aVar.d().ordinal()];
        if (i10 == 1) {
            arrayList.add(new bc.b(l03, b.a.CUSTOMIZE));
            arrayList.add(new bc.b(l04, b.a.MUTE));
        } else if (i10 == 2 || i10 == 3) {
            arrayList.add(new bc.b(l02, b.a.DEFAULT));
            arrayList.add(new bc.b(l03, b.a.CUSTOMIZE));
        }
        this.f23656z0.setAdapter((SpinnerAdapter) this.A0);
        this.f23656z0.setSelection(0);
        this.f23656z0.setOnItemSelectedListener(new a(l04, l02));
        this.f23656z0.setSpinnerEventsListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCollapsingToolbarOffsetChangeListener() {
        try {
            this.E0.d(new e(this));
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public static void t3(@NonNull GameCenterBaseActivity gameCenterBaseActivity) {
        Intent intent = gameCenterBaseActivity.getIntent();
        if (intent != null && intent.getBooleanExtra(com.scores365.Design.Activities.c.IS_NOTIFICATION_ACTIVITY, false)) {
            GameObj gameObj = gameCenterBaseActivity.f23641p0;
            if (gameObj == null) {
                ec.e.f25767v = "game background";
            } else if (gameObj.getIsActive()) {
                ec.e.f25767v = "Live game new session";
            } else {
                ec.e.f25767v = "game new session";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3() {
        this.C0.setActivityWeakRef(this);
    }

    public static Intent v1(int i10, int i11, bg.e eVar, String str) {
        Intent intent = new Intent(App.m(), GameCenterBaseActivity.class);
        intent.putExtra("gc_game_id", i10);
        intent.putExtra("gc_competition_id", i11);
        intent.putExtra("gc_starting_tab", eVar.ordinal());
        intent.putExtra("analyticsSource", str);
        return intent;
    }

    public static Intent w1(int i10, int i11, bg.e eVar, String str, String str2) {
        Intent v12 = v1(i10, i11, eVar, str);
        v12.putExtra(com.scores365.Design.Activities.c.ENTITY_ENTRANCE_SOURCE, str2);
        return v12;
    }

    private void w3(bg.a aVar, boolean z10) {
        int i10;
        int i11;
        try {
            this.f23616b0.removeAllViews();
            if (aVar.f9093a.size() > 1) {
                this.f23616b0.setVisibility(0);
                Pair pair = new Pair(1, 8);
                bg.e eVar = null;
                for (bg.c cVar : aVar.f9093a.values()) {
                    ConstraintLayout constraintLayout = new ConstraintLayout(App.m());
                    constraintLayout.setId(cVar.f9102a.ordinal());
                    constraintLayout.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
                    ImageView imageView = new ImageView(App.m());
                    imageView.setId(View.generateViewId());
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    if (cVar.d()) {
                        i10 = ((Integer) pair.first).intValue();
                        i11 = ((Integer) pair.second).intValue();
                    } else {
                        i10 = 0;
                        i11 = 0;
                    }
                    li.p0.F0(imageView, i10, i11, constraintLayout, cVar.d());
                    constraintLayout.setTag(cVar);
                    if (aVar.f9094b == cVar.f9102a) {
                        imageView.setImageResource(cVar.f9104c);
                        eVar = cVar.f9102a;
                    } else {
                        imageView.setImageResource(cVar.f9103b);
                    }
                    this.f23616b0.addView(constraintLayout);
                    constraintLayout.setBackgroundResource(li.p0.w(App.m(), R.attr.K));
                    constraintLayout.setOnClickListener(new i(cVar, this.f23627i0, aVar, this));
                }
                if (z10 && eVar != null) {
                    androidx.viewpager.widget.a adapter = this.G.getAdapter();
                    CustomViewPager customViewPager = this.G;
                    Fragment fragment = (Fragment) adapter.i(customViewPager, customViewPager.getCurrentItem());
                    if ((fragment instanceof s) && ((s) fragment).x1() != eVar) {
                        this.f23616b0.getChildAt(0).callOnClick();
                    }
                }
            } else {
                this.f23616b0.setVisibility(8);
            }
            if (z10 && this.f23653w0) {
                this.f23651u0 = aVar.f9093a.values().iterator().next().f9102a;
            }
            this.f23653w0 = true;
        } catch (Resources.NotFoundException e10) {
            li.x0.N1(e10);
        }
    }

    public static Intent x1(int i10, int i11, boolean z10, int i12, int i13, String str, int i14) {
        return y1(i10, bg.e.DETAILS, i11, z10, i12, i13, str, i14);
    }

    private void x2(ArrayList<com.scores365.Design.Pages.b> arrayList) {
        GameObj gameObj = this.f23641p0;
        if (gameObj == null || !gameObj.isTopTrendAvailable() || !this.f23641p0.isNotStarted() || arrayList == null || dd.b.f25119a.i(this.f23641p0.getID())) {
            return;
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            com.scores365.Design.Pages.b bVar = arrayList.get(i10);
            if ((bVar instanceof bg.a) && ((bg.a) bVar).f9095c == bg.d.INSIGHTS) {
                this.H.setPositionForTopTrend(i10);
                this.H.setTopTrend(true);
                this.H.setGameId(this.f23641p0.getID());
                this.H.setGameStartTime(this.f23641p0.getSTime().getTime());
                return;
            }
        }
    }

    public static void x3(boolean z10) {
        f23614z1 = z10;
    }

    public static Intent y1(int i10, bg.e eVar, int i11, boolean z10, int i12, int i13, String str, int i14) {
        Intent intent = new Intent(App.m(), GameCenterBaseActivity.class);
        intent.addFlags(603979776);
        intent.putExtra("gc_game_id", i10);
        intent.putExtra("gc_competition_id", i13);
        intent.putExtra("gc_starting_tab", eVar.ordinal());
        intent.putExtra(com.scores365.Design.Activities.c.IS_NOTIFICATION_ACTIVITY, true);
        intent.putExtra("notification_id", i11);
        intent.putExtra("notification_system_id", i12);
        intent.putExtra("has_lmt", z10);
        intent.putExtra("analyticsSource", str);
        intent.putExtra(com.scores365.Design.Activities.c.ENTITY_ENTRANCE_SOURCE, str);
        intent.putExtra("competitorIdNotification", i14);
        return intent;
    }

    public static void y2(androidx.appcompat.app.d dVar, View view, WebChromeClient.CustomViewCallback customViewCallback, int i10, int i11) {
        try {
            dVar.setRequestedOrientation(1);
            ((FrameLayout) dVar.getWindow().getDecorView()).removeView(view);
            dVar.getWindow().getDecorView().setSystemUiVisibility(i10);
            dVar.setRequestedOrientation(i11);
            customViewCallback.onCustomViewHidden();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public static Intent z1(int i10, bg.e eVar, String str) {
        return C1(i10, eVar, str, true, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0190 A[Catch: Exception -> 0x01f6, TryCatch #0 {Exception -> 0x01f6, blocks: (B:2:0x0000, B:4:0x001b, B:6:0x0023, B:33:0x0150, B:42:0x019b, B:37:0x0190, B:8:0x002b, B:10:0x002f, B:12:0x0035, B:13:0x005c, B:15:0x0062, B:16:0x0090, B:17:0x0096, B:19:0x009a, B:20:0x00a0, B:31:0x0126, B:32:0x012b, B:23:0x00a6, B:25:0x00bc, B:26:0x00e6, B:28:0x00ea), top: B:47:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x019b A[Catch: Exception -> 0x01f6, TRY_LEAVE, TryCatch #0 {Exception -> 0x01f6, blocks: (B:2:0x0000, B:4:0x001b, B:6:0x0023, B:33:0x0150, B:42:0x019b, B:37:0x0190, B:8:0x002b, B:10:0x002f, B:12:0x0035, B:13:0x005c, B:15:0x0062, B:16:0x0090, B:17:0x0096, B:19:0x009a, B:20:0x00a0, B:31:0x0126, B:32:0x012b, B:23:0x00a6, B:25:0x00bc, B:26:0x00e6, B:28:0x00ea), top: B:47:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A3() {
        /*
            Method dump skipped, instructions count: 507
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.GameCenterBaseActivity.A3():void");
    }

    public void B3() {
        try {
            zf.g gVar = (zf.g) this.G.getAdapter().i(this.G, 0);
            H2().setVisibility(0);
            H2().bringToFront();
            Thread thread = new Thread(new i0.c(this, this, this.f23629j0, gVar.rvItems, i0.r.lineups, gVar.f43997v));
            this.B0 = thread;
            thread.start();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public boolean E3() {
        try {
            if (getIntent() == null || getIntent().getExtras() == null || !getIntent().getExtras().containsKey("showInterstitialOnExit")) {
                return true;
            }
            return getIntent().getExtras().getBoolean("showInterstitialOnExit");
        } catch (Exception e10) {
            li.x0.N1(e10);
            return true;
        }
    }

    @Override // sh.g
    public void F0(@NonNull androidx.fragment.app.c cVar) {
        bc.a aVar;
        try {
            if (!(cVar instanceof vf.a) || (aVar = this.A0) == null) {
                return;
            }
            aVar.l();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public i0 F2() {
        return this.f23629j0;
    }

    @Override // gc.n.a
    public boolean G0() {
        return (isDestroyed() || isFinishing() || isChangingConfigurations()) ? false : true;
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public ViewGroup GetBannerHolderView() {
        return this.F;
    }

    public RelativeLayout H2() {
        return this.f23625h0;
    }

    public void H3(Fragment fragment) {
        try {
            if (fragment instanceof s) {
                ((s) fragment).y1();
            } else if (fragment instanceof com.scores365.Pages.f) {
                ((com.scores365.Pages.f) fragment).updateData(this.f23629j0.C0().gameBuzzObj);
            } else if (fragment instanceof com.scores365.Pages.r) {
                ((com.scores365.Pages.r) fragment).updateData(this.f23629j0.C0().gameNewsObj);
            } else if (fragment instanceof com.scores365.Pages.c0) {
                ArrayList<CompetitionObj> arrayList = new ArrayList<>();
                i0 i0Var = this.f23629j0;
                CompetitionObj a02 = i0Var.a0(i0Var.C0().getCompetitionID());
                a02.tableObj = this.f23629j0.C0().detailTableObj;
                arrayList.add(a02);
                ((com.scores365.Pages.c0) fragment).N1(arrayList);
            } else if (fragment instanceof zc.c) {
                i0 i0Var2 = this.f23629j0;
                CompetitionObj a03 = i0Var2.a0(i0Var2.C0().getCompetitionID());
                TableObj tableObj = this.f23629j0.C0().detailTableObj;
                a03.tableObj = tableObj;
                ((zc.c) fragment).Y1(tableObj);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public void J1() {
        try {
            K1();
            O2();
            if (this.f23641p0 == null) {
                i0 i0Var = new i0(this.f23637n0, this.f23639o0, this.f23652v0, this.f23647s0);
                this.f23629j0 = i0Var;
                i0Var.P3(this.f23632k1);
                this.f23629j0.s3(this.f23634l1);
                this.f23629j0.Q3(this.f23636m1);
                this.f23625h0.setVisibility(0);
                try {
                    mi.a.c(getIntent().getExtras().getInt("notification_system_id"));
                } catch (Exception e10) {
                    li.x0.N1(e10);
                }
            } else {
                i0 i0Var2 = new i0(this.f23641p0, this.f23643q0, this.f23647s0);
                this.f23629j0 = i0Var2;
                i0Var2.P3(this.f23632k1);
                this.f23629j0.s3(this.f23634l1);
                this.f23629j0.Q3(this.f23636m1);
                o3();
            }
            this.f23629j0.r3(this);
            this.f23629j0.D3(this);
            this.f23629j0.F3(this);
            this.f23629j0.w0(this, getIntent().getIntExtra("notification_system_id", -1));
            this.f23629j0.z3(this);
            this.f23629j0.C3(this);
            this.f23629j0.E3(this);
            String d02 = this.f23629j0.d0(this.f23643q0.getCid());
            if (d02 == null || d02.isEmpty()) {
                d02 = sf.a.i0(App.m()).f0(this.f23643q0.getCid()).getName();
            }
            CustomGameCenterHeaderView customGameCenterHeaderView = this.C0;
            i0 i0Var3 = this.f23629j0;
            customGameCenterHeaderView.initializeView(i0Var3.a0(i0Var3.C0().getCompetitionID()), this.f23629j0.C0(), -1, d02);
            this.C0.setBackgroundColor(0);
            J3();
            J2(this);
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
    }

    public void K1() {
        try {
            i0 i0Var = this.f23629j0;
            if (i0Var != null) {
                i0Var.M();
            }
            this.f23645r0 = true;
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    protected bg.a K3() {
        bg.a aVar;
        Exception e10;
        try {
            aVar = (bg.a) this.f23627i0.t(this.G.getCurrentItem());
            try {
                if (aVar.f9093a.containsKey(f23610v1)) {
                    aVar.f9094b = f23610v1;
                    this.f23653w0 = true;
                } else {
                    int i10 = 0;
                    this.f23653w0 = false;
                    while (i10 < this.f23627i0.e()) {
                        bg.a aVar2 = (bg.a) this.f23627i0.t(i10);
                        try {
                            if (aVar2.f9093a.containsKey(this.f23651u0)) {
                                aVar2.f9094b = this.f23651u0;
                                this.G.setCurrentItem(i10);
                                f23613y1 = i10;
                                aVar = aVar2;
                                break;
                            }
                            i10++;
                            aVar = aVar2;
                        } catch (Exception e11) {
                            e10 = e11;
                            aVar = aVar2;
                            li.x0.N1(e10);
                            return aVar;
                        }
                    }
                }
            } catch (Exception e12) {
                e10 = e12;
            }
        } catch (Exception e13) {
            aVar = null;
            e10 = e13;
        }
        return aVar;
    }

    @Override // rb.c
    public void N0() {
        try {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(500);
            final float translationX = this.f23617b1.getTranslationX();
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.scores365.gameCenter.h
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GameCenterBaseActivity.this.g3(translationX, valueAnimator);
                }
            });
            sb.a aVar = this.f23618c1;
            if (aVar != null) {
                ofFloat.addListener(aVar);
            }
            ofFloat.setRepeatCount(0);
            ofFloat.start();
            this.f23617b1.setRemoved(true);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public boolean N2() {
        boolean z10 = false;
        try {
            z10 = this.f23647s0 ? getIntent().getBooleanExtra("has_lmt", false) : this.f23629j0.C0().shouldShowLiveMatchTracker();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return z10;
    }

    @Override // rb.c
    public ScoresDraggableView O0() {
        return this.f23617b1;
    }

    public void O2() {
        try {
            Bundle extras = getIntent().getExtras();
            if (extras.containsKey("GAME")) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(extras.getByteArray("GAME")));
                this.f23641p0 = (GameObj) objectInputStream.readObject();
                objectInputStream.close();
            }
            if (extras.containsKey("COMPETITION")) {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(extras.getByteArray("COMPETITION")));
                this.f23643q0 = (CompetitionObj) objectInputStream2.readObject();
                objectInputStream2.close();
            }
            if (extras.containsKey("gc_game_id")) {
                this.f23637n0 = extras.getInt("gc_game_id");
            }
            if (extras.containsKey("gc_competition_id")) {
                this.f23639o0 = extras.getInt("gc_competition_id");
            }
            if (extras.containsKey("gc_starting_tab")) {
                bg.e eVar = bg.e.values()[extras.getInt("gc_starting_tab")];
                this.f23651u0 = eVar;
                f23610v1 = eVar;
            }
            if (extras.containsKey("promo_item_id")) {
                this.f23652v0 = ((Integer) extras.get("promo_item_id")).intValue();
            }
            boolean z10 = false;
            this.f23647s0 = (getIntent().getBooleanExtra(com.scores365.Design.Activities.c.IS_NOTIFICATION_ACTIVITY, false) || getIntent().getBooleanExtra(com.scores365.Design.Activities.c.IS_NOTIFICATION_ACTIVITY, false)) ? true : true;
            sf.a.i0(App.m()).T0();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.gameCenter.i0.k
    public void OnGameCompleteGameData(GameObj gameObj, CompetitionObj competitionObj, boolean z10) {
        try {
            if (!isDestroyed() && !isFinishing()) {
                ng.a aVar = ng.a.f35508a;
                aVar.b("GameCenterActivity", "game complete data arrived, game=" + gameObj, null);
                this.f23643q0 = competitionObj;
                gameObj.getNotificationsFromGameObj(this.f23641p0);
                this.f23641p0 = gameObj;
                this.f23634l1.a2(gameObj);
                RelativeLayout relativeLayout = this.f23625h0;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                I3();
                o3();
                M3(gameObj);
                this.M0 = w2();
                this.C0.setGameCompleteDataArrived(true);
                this.C0.initializeView(competitionObj, gameObj, competitionObj.getCid(), this.f23629j0.d0(competitionObj.getCid()));
                J3();
                setCollapsingToolbarOffsetChangeListener();
                this.F0.getLayoutParams().height = li.p0.s(this.M0);
                L2();
                t3(this);
                final uc.d interstitialController = getInterstitialController();
                if (this.f23647s0) {
                    interstitialController.h();
                }
                if (!this.U0 && this.f23647s0) {
                    this.U0 = true;
                    App.f20792l.r(this);
                }
                if (showAdsForContext()) {
                    if (this.f23629j0.F2()) {
                        i0 i0Var = this.f23629j0;
                        i0Var.B3(ec.o.q(this, interstitialController, i0Var.A0(), i0.C0, new o.c() { // from class: com.scores365.gameCenter.q
                            @Override // ec.o.c
                            public final void a(ec.h hVar) {
                                GameCenterBaseActivity.this.W2(interstitialController, hVar);
                            }
                        }));
                    } else if (!z10) {
                        if (this.f23629j0.M2()) {
                            this.f23629j0.n3(this.f23647s0);
                            cc.r.F(this, this, sc.i.GameDetails, null);
                        } else {
                            i3(interstitialController);
                        }
                    }
                }
                f23612x1 = true;
                if (!S2()) {
                    J2(this);
                }
                if (!z10) {
                    this.T0 = true;
                    li.x0.W1("gamecenter", String.valueOf(gameObj.getID()), E2(gameObj), getIntent().getExtras().getString(com.scores365.Design.Activities.c.ENTITY_ENTRANCE_SOURCE, ""));
                    I1();
                }
                if (this.f23634l1.c2() && gameObj.isNotStarted()) {
                    this.f23634l1.Y1(this);
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public void Q2() {
        setContentView(R.layout.f22603l2);
        initActionBar();
        try {
            this.f23617b1 = (GameCenterVideoDraggableItem) findViewById(R.id.M4);
            MyCoordinatorLayout myCoordinatorLayout = (MyCoordinatorLayout) findViewById(R.id.f22156m8);
            this.D0 = myCoordinatorLayout;
            myCoordinatorLayout.setAllowForScrool(true);
            this.H = (GameCenterTabsIndicator) findViewById(R.id.Lr);
            this.f23616b0 = (LinearLayout) findViewById(R.id.Mg);
            this.f23623g0 = (LinearLayout) findViewById(R.id.Lg);
            this.f23621f0 = findViewById(R.id.Yh);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Jn);
            this.f23625h0 = relativeLayout;
            relativeLayout.setVisibility(0);
            this.H.setTabTextColorWhite(true);
            this.H.setAlignTabTextToBottom(true);
            this.H.setExpandedTabsContext(true);
            this.H.setTabIndicatorColorWhite(true);
            this.H.setListener(this);
            f23613y1 = 0;
            this.G = (CustomViewPager) findViewById(R.id.PI);
            this.F = (RelativeLayout) findViewById(R.id.ln);
            this.f23616b0.setBackgroundColor(li.p0.A(R.attr.A1));
            e1.I0(this.f23616b0, li.x0.m0());
            e1.C0(this.H, 4.0f);
            e1.C0(this.f23616b0, 12.0f);
            this.E0 = (ControllableAppBarLayout) findViewById(R.id.f22090j8);
            this.F0 = (CollapsingToolbarLayout) findViewById(R.id.f22112k8);
            e1.I0(this.G, li.x0.m0());
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public boolean R2() {
        return this.f23647s0;
    }

    public boolean S2() {
        return f23614z1;
    }

    public boolean T2() {
        try {
            if (this.f23654x0 != -1) {
                return System.currentTimeMillis() > this.f23654x0 + (((long) Integer.valueOf(li.p0.l0("GAME_CENTER_REFRESH_TIME_MINUTE")).intValue()) * TimeUnit.MINUTES.toMillis(1L));
            }
            return false;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    @Override // rb.c
    public void V0() {
    }

    @Override // gc.g0
    @NonNull
    public sc.f W0() {
        return sc.f.BigLayout;
    }

    @Override // com.scores365.gameCenter.i0.l
    public void Y0() {
        try {
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        if (!isDestroyed() && !isFinishing()) {
            ArrayList<com.scores365.Design.Pages.b> Y0 = this.f23629j0.Y0(this.f23651u0, this.f23652v0);
            Iterator<com.scores365.Design.Pages.b> it = Y0.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                com.scores365.Design.Pages.b next = it.next();
                Iterator<com.scores365.Design.Pages.b> it2 = this.f23627i0.u().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        com.scores365.Design.Pages.b next2 = it2.next();
                        if (((bg.a) next).f9095c == ((bg.a) next2).f9095c) {
                            z10 = U2(Y0, this.f23627i0.u());
                            ((bg.a) next).f9094b = ((bg.a) next2).f9094b;
                            continue;
                            break;
                        }
                    }
                }
                if (z10) {
                    break;
                }
            }
            if (z10) {
                this.f23627i0.z(Y0, this.f23629j0);
                this.f23627i0.k();
                this.H.l();
                w3(K3(), true);
            }
            try {
                if (this.f23629j0.C0().isFinished()) {
                    if (this.f23656z0 != null) {
                        ((LinearLayoutCompat) this.toolbar.findViewById(R.id.Ss)).removeView(this.f23656z0);
                    }
                } else if (this.f23656z0 == null) {
                    v2(this.toolbar, (LinearLayoutCompat) this.toolbar.findViewById(R.id.Ss));
                }
            } catch (Exception e11) {
                li.x0.N1(e11);
            }
            try {
                this.C0.initializeView(F2().c0(), this.f23641p0, this.f23643q0.getCid(), this.f23629j0.d0(this.f23643q0.getCid()));
                M3(this.f23641p0);
                this.M0 = w2();
                J3();
                setCollapsingToolbarOffsetChangeListener();
                this.F0.getLayoutParams().height = li.p0.s(this.M0);
                L2();
                androidx.viewpager.widget.a adapter = this.G.getAdapter();
                CustomViewPager customViewPager = this.G;
                H3((Fragment) adapter.i(customViewPager, customViewPager.getCurrentItem()));
                if (this.G.getCurrentItem() - 1 >= 0) {
                    androidx.viewpager.widget.a adapter2 = this.G.getAdapter();
                    CustomViewPager customViewPager2 = this.G;
                    H3((Fragment) adapter2.i(customViewPager2, customViewPager2.getCurrentItem() - 1));
                }
                if (this.G.getCurrentItem() + 1 < this.G.getAdapter().e()) {
                    androidx.viewpager.widget.a adapter3 = this.G.getAdapter();
                    CustomViewPager customViewPager3 = this.G;
                    H3((Fragment) adapter3.i(customViewPager3, customViewPager3.getCurrentItem() + 1));
                }
            } catch (Exception e12) {
                li.x0.N1(e12);
            }
        }
    }

    @Override // com.scores365.gameCenter.c1.b
    public void Z0(WinProbabilityObj winProbabilityObj) {
        try {
            this.f23629j0.R3(winProbabilityObj);
            CustomViewPager customViewPager = this.G;
            if (customViewPager == null || customViewPager.getAdapter() == null) {
                return;
            }
            androidx.viewpager.widget.a adapter = this.G.getAdapter();
            CustomViewPager customViewPager2 = this.G;
            Object i10 = adapter.i(customViewPager2, customViewPager2.getCurrentItem());
            if (i10 instanceof c1.b) {
                ((c1.b) i10).Z0(winProbabilityObj);
            }
            if (this.G.getCurrentItem() - 1 >= 0) {
                androidx.viewpager.widget.a adapter2 = this.G.getAdapter();
                CustomViewPager customViewPager3 = this.G;
                Object i11 = adapter2.i(customViewPager3, customViewPager3.getCurrentItem() - 1);
                if (i11 instanceof c1.b) {
                    ((c1.b) i11).Z0(winProbabilityObj);
                }
            }
            if (this.G.getCurrentItem() + 1 < this.G.getAdapter().e()) {
                androidx.viewpager.widget.a adapter3 = this.G.getAdapter();
                CustomViewPager customViewPager4 = this.G;
                Object i12 = adapter3.i(customViewPager4, customViewPager4.getCurrentItem() + 1);
                if (i12 instanceof c1.b) {
                    ((c1.b) i12).Z0(winProbabilityObj);
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // fd.c.InterfaceC0303c
    public void c(boolean z10) {
        this.f23628i1 = z10;
    }

    @Override // rb.c
    public int c1() {
        try {
            return f23609u1 - li.p0.s(50);
        } catch (Exception e10) {
            li.x0.N1(e10);
            return 0;
        }
    }

    @Override // com.scores365.gameCenter.o0
    public boolean contentHasPadding() {
        return true;
    }

    @Override // wh.b
    public void finishLoading() {
        runOnUiThread(new Runnable() { // from class: com.scores365.gameCenter.g
            @Override // java.lang.Runnable
            public final void run() {
                GameCenterBaseActivity.this.Y2();
            }
        });
    }

    @Override // com.scores365.gameCenter.gameCenterItems.WinProbabilityChart.a
    public void g(float f10) {
        try {
            this.f23629j0.J3(f10);
            if (this.f23629j0.U2()) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("game_id", Integer.valueOf(this.f23629j0.C0().getID()));
            hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.D0(this.f23629j0.C0()));
            ee.k.k(App.m(), "gamecenter", "win-probability", "slide", null, hashMap);
            this.f23629j0.S3(true);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // fd.c.InterfaceC0303c
    public boolean g0() {
        return this.f23628i1;
    }

    @Override // wh.b
    public Activity getActivityForUI() {
        return this;
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public cc.z0 getMpuHandler() {
        return this.mpuHandler;
    }

    @Override // com.scores365.gameCenter.o0
    public int getPaddingSize(com.scores365.Design.Pages.a aVar) {
        int i10 = -1;
        try {
            androidx.viewpager.widget.a adapter = this.G.getAdapter();
            CustomViewPager customViewPager = this.G;
            int G2 = ((Fragment) adapter.i(customViewPager, customViewPager.getCurrentItem())).getClass().equals(aVar.getClass()) ? G2(this.G.getCurrentItem()) : -1;
            if (G2 == -1) {
                try {
                    if (this.G.getCurrentItem() - 1 >= 0) {
                        androidx.viewpager.widget.a adapter2 = this.G.getAdapter();
                        CustomViewPager customViewPager2 = this.G;
                        if (((Fragment) adapter2.i(customViewPager2, customViewPager2.getCurrentItem() - 1)).getClass().equals(aVar.getClass())) {
                            G2 = G2(this.G.getCurrentItem() - 1);
                        }
                    }
                } catch (Exception e10) {
                    e = e10;
                    i10 = G2;
                    li.x0.N1(e);
                    return i10;
                }
            }
            if (G2 == -1 && this.G.getCurrentItem() + 1 < this.G.getAdapter().e()) {
                androidx.viewpager.widget.a adapter3 = this.G.getAdapter();
                CustomViewPager customViewPager3 = this.G;
                if (((Fragment) adapter3.i(customViewPager3, customViewPager3.getCurrentItem() + 1)).getClass().equals(aVar.getClass())) {
                    G2 = G2(this.G.getCurrentItem() + 1);
                }
            }
            if (G2 == -1) {
                return 0;
            }
            return G2;
        } catch (Exception e11) {
            e = e11;
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return "";
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public sc.i getPlacement() {
        return sc.i.GameDetails;
    }

    @Override // com.scores365.gameCenter.i0.n
    public void h(com.scores365.gameCenter.Predictions.b bVar) {
        try {
            androidx.viewpager.widget.a adapter = this.G.getAdapter();
            CustomViewPager customViewPager = this.G;
            com.scores365.Design.Pages.a aVar = (com.scores365.Design.Pages.a) adapter.i(customViewPager, customViewPager.getCurrentItem());
            if (aVar instanceof zf.c) {
                zf.c cVar = (zf.c) aVar;
                for (int i10 = 0; i10 < cVar.H1().A().size(); i10++) {
                    com.scores365.Design.PageObjects.b z10 = cVar.H1().z(i10);
                    if (z10 instanceof xf.q) {
                        this.f23641p0.setPredictions(bVar);
                        RecyclerView D = ((xf.q) z10).D();
                        if (D != null && D.getAdapter() != null) {
                            ((q.g) D.getAdapter()).O(bVar, D);
                        }
                    } else if (z10 instanceof xf.g) {
                        ((xf.g) z10).t(bVar);
                        cVar.H1().notifyItemChanged(i10);
                    }
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public boolean isBannerNeedToBeVisible() {
        if (!C3()) {
            CustomViewPager customViewPager = this.G;
            if (D3(customViewPager != null ? customViewPager.getCurrentItem() : -1)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.scores365.gameCenter.p0
    public boolean isNeedToHandleScroll(com.scores365.Design.Pages.a aVar) {
        try {
            androidx.viewpager.widget.a adapter = this.G.getAdapter();
            CustomViewPager customViewPager = this.G;
            return ((Fragment) adapter.i(customViewPager, customViewPager.getCurrentItem())).getClass().equals(aVar.getClass());
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // gc.n.a
    public void j1(@NonNull String str, @NonNull NativeCustomFormatAd nativeCustomFormatAd, @NonNull gc.n nVar) {
        char c10;
        Log.d("brandedHeaderFea", "GameCenterBaseActivity.onBrandedNativeAdLoaded");
        str.hashCode();
        switch (str.hashCode()) {
            case -1917629443:
                if (str.equals("12157593")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case -1914891771:
                if (str.equals("12186223")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case -1914891768:
                if (str.equals("12186226")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case -1914142100:
                if (str.equals("12190751")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        switch (c10) {
            case 0:
                Drawable B = this.f23630j1.B();
                int z10 = this.f23630j1.z();
                if (B != null) {
                    if (z10 == -1 || z10 == F2().C0().getTopBookMaker()) {
                        L2();
                        this.f23630j1.H();
                        this.R0 = true;
                        if (this.f23630j1.J()) {
                            this.C0.clearCompetitionTitle();
                            this.C0.setShouldHideCompetitionNameOnTop(true);
                        }
                        if (this.f23630j1.I()) {
                            this.E0.setExpanded(true);
                            this.D0.setAllowForScrool(false);
                            this.E0.setIsAllowedToScroll(false);
                        }
                        String C = this.f23630j1.C();
                        String D = this.f23630j1.D();
                        if (C == null || C.isEmpty() || D == null || D.isEmpty()) {
                            return;
                        }
                        int parseColor = Color.parseColor(C);
                        int parseColor2 = Color.parseColor(D);
                        this.H.setTabIndicatorColorWhite(false);
                        this.H.o(parseColor, parseColor2);
                        this.H.j();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                I3();
                if (this.G.getAdapter() != null) {
                    Iterator<Fragment> it = li.p0.F(this.G).iterator();
                    while (it.hasNext()) {
                        Fragment next = it.next();
                        if (next instanceof com.scores365.Design.Pages.a) {
                            ((com.scores365.Design.Pages.a) next).handleContentPadding();
                        }
                    }
                    return;
                }
                return;
            case 2:
                if (this.G.getAdapter() != null) {
                    Iterator<Fragment> it2 = li.p0.F(this.G).iterator();
                    while (it2.hasNext()) {
                        Fragment next2 = it2.next();
                        if (next2 instanceof n.a) {
                            ((n.a) next2).j1(str, nativeCustomFormatAd, nVar);
                        }
                    }
                    return;
                }
                return;
            case 3:
                u2();
                return;
            default:
                return;
        }
    }

    public void k3() {
        if (isDestroyed() || isFinishing()) {
            return;
        }
        for (Fragment fragment : getSupportFragmentManager().v0()) {
            if (fragment instanceof zf.c) {
                ((zf.c) fragment).S1();
                return;
            }
        }
    }

    @Override // gc.g0
    public void m0() {
        j3(getInterstitialController());
    }

    @Override // com.scores365.gameCenter.gameCenterItems.WinProbabilityChart.a
    public void o(boolean z10) {
        try {
            this.G.setSwipePagingEnabled(!z10);
            androidx.viewpager.widget.a adapter = this.G.getAdapter();
            CustomViewPager customViewPager = this.G;
            Fragment fragment = (Fragment) adapter.i(customViewPager, customViewPager.getCurrentItem());
            if (fragment instanceof zf.c) {
                ((zf.c) fragment).o2(z10);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // rb.c
    public boolean o0() {
        return this.f23624g1;
    }

    public void o3() {
        bg.a K3;
        try {
            ArrayList<com.scores365.Design.Pages.b> Y0 = this.f23629j0.Y0(this.f23651u0, this.f23652v0);
            bg.b bVar = this.f23627i0;
            if (bVar == null) {
                bg.b bVar2 = new bg.b(getSupportFragmentManager(), Y0, this.f23629j0, this);
                this.f23627i0 = bVar2;
                this.G.setAdapter(bVar2);
                this.H.setViewPager(this.G);
                this.H.setOnPageChangeListener(this);
                K3 = K3();
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) this.toolbar.findViewById(R.id.Ss);
                if (!this.f23641p0.isFinished()) {
                    v2(this.toolbar, linearLayoutCompat);
                }
                Bundle extras = getIntent().getExtras();
                GameObj C0 = this.f23629j0.C0();
                HashMap hashMap = new HashMap();
                hashMap.put("game_id", String.valueOf(C0.getID()));
                hashMap.put("type_of_click", "click");
                hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.D0(C0));
                hashMap.put("is_match_tracker", String.valueOf(N2()));
                hashMap.put(ShareConstants.FEED_SOURCE_PARAM, extras.getString("analyticsSource", ""));
                hashMap.put("section", extras.getString("analyticsSection", ""));
                hashMap.put("is_notification", String.valueOf(this.f23647s0));
                boolean z10 = C0.hasTips() && C0.isNotStarted() && li.x0.s2() && App.l().bets.isDailyTipAvailable();
                String str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                hashMap.put("is_tipsale", z10 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "0");
                hashMap.put("is_promoted", Boolean.valueOf(extras.getBoolean("isPromotedForAnalytics", false)));
                hashMap.put("is_pbp", C0.hasPlayByPlay ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "0");
                if (!C0.isTopTrendAvailable()) {
                    str = "0";
                }
                hashMap.put("hot_trends", str);
                try {
                    if (extras.getInt("promo_item_id", -1) > 0) {
                        hashMap.put("item_id", Integer.valueOf(extras.getInt("promo_item_id", -1)));
                    }
                    hashMap.put("competition_id", String.valueOf(this.f23629j0.c0().getID()));
                } catch (Exception e10) {
                    li.x0.N1(e10);
                }
                try {
                    int i10 = extras.getInt("allScoresCategoryId", -1);
                    if (i10 > 0) {
                        hashMap.put("category_id", Integer.valueOf(i10));
                    }
                    int i11 = extras.getInt("allScoresCategoryType", -1);
                    if (i11 > 0) {
                        AllScoresCategoryTypeEnum allScoresCategoryTypeEnum = AllScoresCategoryTypeEnum.FILTER;
                        Object obj = "-1";
                        hashMap.put("as_tab", i11 == allScoresCategoryTypeEnum.getValue() ? "-1" : Integer.valueOf(i10));
                        hashMap.put("category_type", Integer.valueOf(i11));
                        if (i11 == AllScoresCategoryTypeEnum.TV_SCHEDULE.getValue()) {
                            obj = "-2";
                        } else if (i11 != allScoresCategoryTypeEnum.getValue()) {
                            obj = Integer.valueOf(i11);
                        }
                        hashMap.put("sport_type_id", obj);
                    }
                    int i12 = extras.getInt("allScoresHelperSection", -1);
                    if (i12 != -1) {
                        hashMap.put("list", i12 == 2 ? "popular-competitions" : "country-list");
                    }
                } catch (Exception e11) {
                    li.x0.N1(e11);
                }
                hashMap.put("gc_num", String.valueOf(sf.b.X1().c(b.e.GameCenterVisits, App.m())));
                hashMap.put("followed", Boolean.valueOf(i0.B2(C0)));
                ee.k.k(App.m(), "gamecenter", bg.c.b(K3.f9094b), "click", null, hashMap);
            } else {
                if (U2(Y0, bVar.u())) {
                    this.f23627i0.z(Y0, this.f23629j0);
                    this.f23627i0.k();
                    this.H.l();
                } else {
                    Y0();
                }
                K3 = K3();
            }
            w3(K3, false);
            this.f23654x0 = System.currentTimeMillis();
            this.f23625h0.setVisibility(8);
            if (this.f23647s0 && !App.B && App.f20802v > 0) {
                App.B = true;
                ee.k.n(App.m(), "app", "loading-time", null, null, false, ShareConstants.FEED_SOURCE_PARAM, this.f23651u0 == bg.e.BUZZ ? "buzz-notification" : "game-notification", "duration", String.valueOf(System.currentTimeMillis() - App.f20802v));
            }
            this.f23623g0.setVisibility(0);
            if (!isStartedFromNotification() && !this.Y0) {
                b.a aVar = vf.b.f40747a;
                aVar.s(this.f23641p0);
                this.Y0 = true;
                if (aVar.v()) {
                    CompObj compObj = aVar.u(this.f23641p0.getComps()[0]) ? this.f23641p0.getComps()[0] : aVar.u(this.f23641p0.getComps()[1]) ? this.f23641p0.getComps()[1] : null;
                    if (compObj != null) {
                        aVar.w(compObj, getSupportFragmentManager(), this, "gamecenter");
                    }
                }
            }
            x2(Y0);
        } catch (Exception e12) {
            li.x0.N1(e12);
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            boolean z10 = false;
            Fragment fragment = (Fragment) this.G.getAdapter().i(this.G, 0);
            if (fragment instanceof zf.c) {
                ((zf.c) fragment).v().clear();
            }
            if (getRequestedOrientation() == 0) {
                if (fragment instanceof zf.c) {
                    c.C0011c c0011c = (c.C0011c) ((zf.c) fragment).rvItems.a0(0);
                    if (c0011c.l() != null) {
                        c0011c.l().onHideCustomView();
                        return;
                    }
                    return;
                }
                return;
            }
            boolean z11 = true;
            if (this.X0) {
                p(bg.e.DETAILS, bg.d.MATCH, true, bg.e.PLAY_BY_PLAY);
                return;
            }
            if (E3()) {
                uc.d interstitialController = getInterstitialController();
                uc.f f10 = interstitialController.i().f();
                if ((f10 instanceof f.e) && !((f.e) f10).b().g()) {
                    z11 = true ^ interstitialController.u(this, (f.e) f10, new c1.a() { // from class: com.scores365.gameCenter.o
                        @Override // cc.c1.a
                        public final void a() {
                            GameCenterBaseActivity.this.ExitScreen();
                        }
                    });
                }
            }
            if (this.B0 != null) {
                this.f23625h0.setVisibility(8);
                this.B0.interrupt();
                this.B0 = null;
            } else {
                z10 = z11;
            }
            if (this.V0 && this.W0 != -1 && sf.a.i0(App.m()).o1(this.W0) != -1) {
                Intent intent = new Intent();
                intent.putExtra("gameItemPositionToUpdate", getIntent().getIntExtra("gameItemPositionToUpdate", -1));
                setResult(-1, intent);
            }
            if (z10) {
                ExitScreen();
            }
            if (this.S0) {
                Intent intent2 = new Intent();
                intent2.putExtra("gameCenterGameID", this.f23637n0);
                setResult(994, intent2);
            }
            finish();
        } catch (Exception e10) {
            li.x0.N1(e10);
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        Uri data;
        super.onCreate(bundle);
        this.f23632k1 = (xe.c) new androidx.lifecycle.w0(this.f23636m1).a(xe.c.class);
        this.f23634l1 = (l0) new androidx.lifecycle.w0(this.f23636m1).a(l0.class);
        Intent intent = getIntent();
        boolean z10 = true;
        if (intent != null && (data = intent.getData()) != null) {
            String queryParameter = data.getQueryParameter("entityid");
            if (!TextUtils.isEmpty(queryParameter)) {
                intent.putExtra("gc_game_id", Integer.valueOf(queryParameter));
                intent.putExtra("gc_starting_tab", bg.e.DETAILS.ordinal());
                intent.putExtra("analyticsSource", SDKConstants.PARAM_TOURNAMENTS_DEEPLINK);
                intent.putExtra("showInterstitialOnExit", true);
                intent.putExtra(com.scores365.Design.Activities.c.IS_NOTIFICATION_ACTIVITY, true);
            }
        }
        try {
            x3(false);
            Q2();
            P2();
            li.p0.E0(this, 0);
            this.C0 = (CustomGameCenterHeaderView) findViewById(R.id.U7);
            u2();
            r3();
            this.f23631k0 = (ImageView) findViewById(R.id.f22134l8);
            this.I = (RelativeLayout) findViewById(R.id.no);
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(1280);
            window.setStatusBarColor(0);
            window.getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.scores365.gameCenter.p
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    WindowInsets d32;
                    d32 = GameCenterBaseActivity.this.d3(view, windowInsets);
                    return d32;
                }
            });
            if (intent == null || !intent.getExtras().getBoolean("isPromotedForAnalytics", false)) {
                z10 = false;
            }
            this.V0 = z10;
            if (z10) {
                this.W0 = intent.getExtras().getInt("wwwPredictionID", -1);
            }
            M2();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            getMenuInflater().inflate(R.menu.f22785b, menu);
            MenuItem findItem = menu.findItem(R.id.f22036h);
            findItem.setTitle(li.p0.l0("SHARE_ITEM"));
            if (V2()) {
                return true;
            }
            findItem.setVisible(false);
            return true;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onDestroy() {
        try {
            cc.z0 z0Var = this.mpuHandler;
            if (z0Var != null) {
                z0Var.o();
            }
            this.C0.stopTimers();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        super.onDestroy();
        try {
            GameCenterVideoDraggableItem gameCenterVideoDraggableItem = this.f23617b1;
            if (gameCenterVideoDraggableItem != null) {
                gameCenterVideoDraggableItem.h();
            }
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
    }

    @Override // com.scores365.gameCenter.p0
    public void onInnerPageListScrolled(int i10) {
        try {
            if (this.f23616b0.getVisibility() == 0) {
                if (i10 < 0) {
                    if (this.O0 > 0.0f && this.f23616b0.getY() < 0.0f) {
                        LinearLayout linearLayout = this.f23616b0;
                        float f10 = i10;
                        linearLayout.setY(linearLayout.getY() - f10);
                        this.f23621f0.setY(this.f23616b0.getY() - f10);
                        if (this.f23633l0.getVisibility() == 0) {
                            this.f23633l0.setTranslationY(this.f23616b0.getY() - f10);
                        }
                    }
                } else if (i10 > 0) {
                    if (this.O0 > 0.99d && this.f23616b0.getY() * (-1.0f) <= this.f23616b0.getHeight()) {
                        LinearLayout linearLayout2 = this.f23616b0;
                        float f11 = i10;
                        linearLayout2.setY(linearLayout2.getY() - f11);
                        this.f23621f0.setY(this.f23616b0.getY() - f11);
                        if (this.f23633l0.getVisibility() == 0) {
                            this.f23633l0.setTranslationY(this.f23616b0.getY() - f11);
                        }
                    }
                } else if (this.f23616b0.getY() < 0.0f) {
                    this.f23616b0.setY(0.0f);
                    this.f23633l0.setTranslationY(0.0f);
                    this.f23621f0.setTranslationY(0.0f);
                }
            }
            if (this.f23616b0.getY() >= 0.0f) {
                this.f23616b0.setY(0.0f);
                this.f23633l0.setTranslationY(0.0f);
                this.f23621f0.setTranslationY(0.0f);
            } else if (this.f23616b0.getY() < (-App.m().getResources().getDimension(R.dimen.f21654s))) {
                this.f23616b0.setY(-App.m().getResources().getDimension(R.dimen.f21654s));
                this.f23633l0.setTranslationY(-App.m().getResources().getDimension(R.dimen.f21654s));
                this.f23621f0.setTranslationY(-App.m().getResources().getDimension(R.dimen.f21654s));
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.gameCenter.i0.l
    public void onNetworkError() {
        try {
            CustomGameCenterHeaderView customGameCenterHeaderView = this.C0;
            if (customGameCenterHeaderView != null) {
                customGameCenterHeaderView.cancelLiveTimer();
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            this.f23615a1 = null;
            this.Z0 = -1;
            f23611w1.g();
            setIntent(intent);
            CustomGameCenterHeaderView customGameCenterHeaderView = this.C0;
            if (customGameCenterHeaderView != null) {
                customGameCenterHeaderView.clearCompetitorsLogo();
                this.C0.resetViewForInflation();
            }
            this.T0 = false;
            m3();
            x3(false);
            z2();
            showSubmenu();
            ee.k.A(this, intent);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            this.X0 = false;
            onBackPressed();
            return true;
        } else if (itemId == R.id.f22036h) {
            A3();
            return true;
        } else {
            return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrollStateChanged(int i10) {
        if (i10 == 1) {
            this.f23642p1 = true;
        } else if (i10 == 0) {
            this.f23642p1 = false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrolled(int i10, float f10, int i11) {
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageSelected(int i10) {
        GameObj gameObj;
        boolean z10 = false;
        try {
            this.X0 = false;
            int i11 = f23613y1;
            f23613y1 = i10;
            bg.a aVar = (bg.a) this.f23627i0.t(i10);
            try {
                androidx.viewpager.widget.a adapter = this.G.getAdapter();
                CustomViewPager customViewPager = this.G;
                Fragment fragment = (Fragment) adapter.i(customViewPager, customViewPager.getCurrentItem());
                if (fragment instanceof zf.g) {
                    fragment.getArguments().putBoolean("shouldSendTrackingLink", true);
                } else if (fragment instanceof com.scores365.Pages.n) {
                    fragment.getArguments().putBoolean("shouldSendTrackingLink", true);
                } else if (fragment instanceof zf.c) {
                    xf.q.f42460m = true;
                    xf.u.f42585f = false;
                    ((zf.c) fragment).m2();
                    ((zf.c) fragment).Q1(false);
                } else if ((fragment instanceof com.scores365.Pages.t) || (fragment instanceof fd.c)) {
                    sf.b.X1().m3(b.e.BettingFeatureCount);
                    ee.c.f25841a.c(r.a.f25905a);
                }
                Object i12 = this.G.getAdapter().i(this.G, i11);
                if ((i12 instanceof com.scores365.Pages.d0) && !(fragment instanceof com.scores365.Pages.d0)) {
                    ((com.scores365.Pages.d0) i12).B1();
                }
                if (!(fragment instanceof zf.c) && i11 == 0) {
                    Fragment fragment2 = (Fragment) this.G.getAdapter().i(this.G, i11);
                    if (fragment2 instanceof zf.c) {
                        ((zf.c) fragment2).P1();
                        ((zf.c) fragment2).Q1(true);
                    }
                }
                if (fragment instanceof zf.c) {
                    ((zf.c) fragment).N1();
                }
                if (fragment instanceof com.scores365.Design.Pages.a) {
                    ((com.scores365.Design.Pages.a) fragment).onPageSelectedInViewPager();
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
            t0();
            w3(aVar, true);
            bg.e eVar = f23610v1;
            f23610v1 = aVar.f9094b;
            showSubmenu();
            I2(i10);
            if (this.Q0) {
                f.c cVar = f.c.ByClick;
                if (this.f23642p1) {
                    cVar = f.c.BySwipe;
                }
                int i13 = c.f23661a[cVar.ordinal()];
                String str = i13 != 1 ? i13 != 2 ? "auto" : "swipe" : "click";
                String b10 = bg.c.b(eVar);
                if (this.f23647s0 && this.f23649t0) {
                    b10 = "notification";
                    this.f23649t0 = false;
                    z10 = true;
                }
                final HashMap hashMap = new HashMap();
                hashMap.put("tab_id", Integer.toString(i10 + 1));
                hashMap.put("tab_name", aVar.f9095c.name());
                hashMap.put("game_id", String.valueOf(this.f23629j0.C0().getID()));
                hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.D0(this.f23629j0.C0()));
                if (aVar.f9095c == bg.d.INSIGHTS && (gameObj = this.f23641p0) != null) {
                    hashMap.put("hot_trends", gameObj.isTopTrendAvailable() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "0");
                }
                if (this.f23644q1 == null) {
                    this.f23644q1 = new Handler();
                }
                this.f23644q1.removeCallbacksAndMessages(null);
                this.f23644q1.postDelayed(new Runnable() { // from class: com.scores365.gameCenter.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameCenterBaseActivity.this.e3(hashMap);
                    }
                }, 1000L);
                if (z10) {
                    HashMap<String, Object> hashMap2 = new HashMap<>();
                    hashMap2.put("game_id", String.valueOf(this.f23629j0.C0().getID()));
                    hashMap2.put("type_of_click", str);
                    hashMap2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.D0(this.f23629j0.C0()));
                    hashMap2.put("is_match_tracker", String.valueOf(N2()));
                    hashMap2.put("competition_id", String.valueOf(this.f23629j0.c0().getID()));
                    hashMap2.put(ShareConstants.FEED_SOURCE_PARAM, b10);
                    hashMap2.put("is_from_notification", Boolean.valueOf(this.f23647s0));
                    if (A1 == null) {
                        A1 = new Handler();
                    }
                    if (B1 == null) {
                        B1 = new j();
                    }
                    A1.removeCallbacks(B1);
                    B1.a(bg.c.b(aVar.f9094b), hashMap2);
                    A1.postDelayed(B1, 1000L);
                }
                this.f23646r1 = aVar.f9094b.ordinal();
            }
            this.Q0 = true;
            I3();
            this.H.setMainPageType(aVar.f9095c);
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            cc.z0 z0Var = this.mpuHandler;
            if (z0Var != null) {
                z0Var.p(true);
            }
            K1();
            i0 i0Var = this.f23629j0;
            if (i0Var != null) {
                i0Var.J();
            }
            this.C0.stopTimers();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        try {
            GameCenterVideoDraggableItem gameCenterVideoDraggableItem = this.f23617b1;
            if (gameCenterVideoDraggableItem != null) {
                gameCenterVideoDraggableItem.E();
                G3();
            }
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
        n3(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        String str;
        try {
            i0 i0Var = this.f23629j0;
            if (i0Var != null && i0Var.C0() != null) {
                if (this.f23629j0.C0().getIsActive()) {
                    ec.e.f25767v = "Live game from background";
                } else {
                    ec.e.f25767v = "game from background";
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        super.onResume();
        try {
            if (T2()) {
                m3();
                showSubmenu();
            } else {
                i0 i0Var2 = this.f23629j0;
                if (i0Var2 != null && this.f23645r0) {
                    this.f23645r0 = false;
                    i0Var2.W3();
                }
            }
            i0 i0Var3 = this.f23629j0;
            if (i0Var3 != null) {
                i0Var3.n3(this.f23647s0);
            }
            sf.b.X1().I();
            sf.b.X1().m3(b.e.GameCenterVisits);
            this.f23646r1 = -1;
            bc.a aVar = this.A0;
            if (aVar != null) {
                aVar.l();
            }
            if (showAdsForContext()) {
                uf.a.J((ConstraintLayout) findViewById(R.id.Fn));
            }
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
        try {
            int i10 = (getIntent() == null || getIntent().getExtras() == null) ? -1 : getIntent().getExtras().getInt("gc_game_id");
            String g10 = App.g(null, false);
            if (this.Z0 != i10 || ((str = this.f23615a1) != null && !str.equals(g10))) {
                this.f23615a1 = g10;
                this.Z0 = i10;
            }
        } catch (Exception e12) {
            li.x0.N1(e12);
        }
        try {
            i0 i0Var4 = this.f23629j0;
            String d02 = i0Var4 != null ? i0Var4.d0(this.f23643q0.getCid()) : null;
            if ((d02 == null || d02.isEmpty()) && this.f23643q0 != null) {
                d02 = sf.a.i0(App.m()).f0(this.f23643q0.getCid()).getName();
            }
            i0 i0Var5 = this.f23629j0;
            if (i0Var5 != null && i0Var5.C0() != null) {
                CustomGameCenterHeaderView customGameCenterHeaderView = this.C0;
                i0 i0Var6 = this.f23629j0;
                customGameCenterHeaderView.initializeView(i0Var6.a0(i0Var6.C0().getCompetitionID()), this.f23629j0.C0(), -1, d02);
            }
        } catch (Exception e13) {
            li.x0.N1(e13);
        }
        try {
            GameCenterVideoDraggableItem gameCenterVideoDraggableItem = this.f23617b1;
            if (gameCenterVideoDraggableItem != null && !gameCenterVideoDraggableItem.f() && !this.f23617b1.C() && !this.f23617b1.s() && ((this.f23617b1.N() || this.f23617b1.M()) && !App.f20792l.n())) {
                this.f23617b1.F();
            }
        } catch (Exception e14) {
            li.x0.N1(e14);
        }
        n3(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStop() {
        try {
            i0 i0Var = this.f23629j0;
            if (i0Var != null) {
                i0Var.M();
            }
            com.scores365.gameCenter.c cVar = f23611w1;
            if (cVar != null) {
                cVar.h();
            }
            w0 w0Var = this.f23655y0;
            if (w0Var != null) {
                w0Var.a();
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        i0 i0Var2 = this.f23629j0;
        if (i0Var2 != null) {
            i0Var2.X3();
        }
        try {
            com.scores365.Pages.f.sendItemPreviewEvent(this.f23629j0.C0(), "gamecenter", this.f23647s0);
            com.scores365.Pages.f.shouldSendItemPreviewEvent = false;
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
        super.onStop();
        try {
            GameCenterVideoDraggableItem gameCenterVideoDraggableItem = this.f23617b1;
            if (gameCenterVideoDraggableItem != null) {
                gameCenterVideoDraggableItem.E();
                G3();
            }
        } catch (Exception e12) {
            li.x0.N1(e12);
        }
    }

    @Override // com.scores365.gameCenter.i0.m
    public void p(bg.e eVar, bg.d dVar, boolean z10, bg.e eVar2) {
        boolean z11;
        try {
            if (eVar != bg.e.PLAY_BY_PLAY) {
                this.X0 = false;
            }
            int i10 = 0;
            while (true) {
                if (i10 >= this.f23627i0.u().size()) {
                    z11 = false;
                    i10 = -1;
                    break;
                }
                bg.a aVar = (bg.a) this.f23627i0.t(i10);
                if (aVar.f9095c != dVar) {
                    i10++;
                } else if (aVar.f9094b != eVar) {
                    aVar.f9094b = eVar;
                    z11 = true;
                } else {
                    z11 = false;
                }
            }
            if (i10 != -1) {
                f23610v1 = eVar;
                if (this.G.getCurrentItem() != i10) {
                    this.Q0 = false;
                    this.G.setCurrentItem(i10);
                    f23613y1 = i10;
                    this.f23627i0.k();
                } else if (z11) {
                    if (eVar != bg.e.DETAILS) {
                        I3();
                    }
                    this.f23627i0.k();
                    L3(eVar);
                    showSubmenu();
                }
                t0();
                ee.k.o(App.m(), "gamecenter", "details", "more-items", z10 ? "back-click" : "click", "game_id", String.valueOf(this.f23629j0.A0()), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.D0(this.f23629j0.C0()), "type", z10 ? A2(eVar2) : A2(eVar));
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // ke.b.InterfaceC0401b
    public void r(final GameTeaserObj gameTeaserObj) {
        try {
            li.c.f34483a.e().execute(new Runnable() { // from class: com.scores365.gameCenter.l
                @Override // java.lang.Runnable
                public final void run() {
                    GameCenterBaseActivity.this.X2(gameTeaserObj);
                }
            });
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public void setBannerHandler(cc.z0 z0Var) {
        super.setBannerHandler(z0Var);
        try {
            I2(this.G.getCurrentItem());
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public void setMpuHandler(cc.z0 z0Var) {
        try {
            super.setMpuHandler(z0Var);
            sc.h f10 = z0Var == null ? null : z0Var.f();
            if (z0Var != null && (f10 == sc.h.ReadyToShow || f10 == sc.h.Showing || f10 == sc.h.Shown)) {
                this.f23640o1 = true;
                K2(true);
                return;
            }
            K2(false);
            i0 i0Var = this.f23629j0;
            i0Var.p3(i0Var.y0());
            i3(getInterstitialController());
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public boolean showAdsForContext() {
        try {
            int i10 = getIntent().getExtras().getInt("gc_competition_id", -1);
            if (i10 < 1) {
                CompetitionObj competitionObj = this.f23643q0;
                i10 = competitionObj != null ? competitionObj.getID() : -1;
            }
            return true ^ cc.o0.y().b(i10);
        } catch (Exception e10) {
            li.x0.N1(e10);
            return true;
        }
    }

    @Override // com.scores365.gameCenter.p0
    public void showSubmenu() {
        try {
            LinearLayout linearLayout = this.f23616b0;
            if (linearLayout == null || linearLayout.getVisibility() != 0) {
                return;
            }
            this.f23616b0.setY(0.0f);
            this.f23633l0.setTranslationY(0.0f);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // wh.b
    public void startLoading() {
        runOnUiThread(new Runnable() { // from class: com.scores365.gameCenter.r
            @Override // java.lang.Runnable
            public final void run() {
                GameCenterBaseActivity.this.f3();
            }
        });
    }

    @Override // com.scores365.gameCenter.i0.j
    public void t(BetObj betObj) {
        if (betObj != null) {
            try {
                GameObj C0 = this.f23629j0.C0();
                i0 i0Var = this.f23629j0;
                OnGameCompleteGameData(C0, i0Var.a0(i0Var.C0().getCompetitionID()), true);
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    @Override // rb.c
    public void t0() {
        try {
            GameCenterVideoDraggableItem gameCenterVideoDraggableItem = this.f23617b1;
            if (gameCenterVideoDraggableItem == null || gameCenterVideoDraggableItem.O()) {
                return;
            }
            getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            this.f23617b1.getLocationOnScreen(new int[2]);
            this.f23617b1.setShrinked(true);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(400);
            z0(true);
            GameCenterVideoDraggableItem.b bVar = this.f23619d1;
            if (bVar != null) {
                ofFloat.addUpdateListener(bVar);
            }
            GameCenterVideoDraggableItem.a aVar = this.f23620e1;
            if (aVar != null) {
                ofFloat.addListener(aVar);
            }
            sb.a aVar2 = this.f23618c1;
            if (aVar2 != null) {
                ofFloat.addListener(aVar2);
            }
            ofFloat.setRepeatCount(0);
            ofFloat.start();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // xf.b.a
    public void u(int i10) {
        GameCenterVideoDraggableItem gameCenterVideoDraggableItem;
        try {
            fc.a y10 = cc.o0.y();
            if (y10 == null || (gameCenterVideoDraggableItem = this.f23617b1) == null || gameCenterVideoDraggableItem.s() || this.f23617b1.C() || this.f23617b1.f() || !this.f23617b1.t()) {
                return;
            }
            if (this.f23617b1.getPlayer() == null || !(this.f23617b1.getPlayer() == null || this.f23617b1.getPlayer().c())) {
                float f10 = Boolean.parseBoolean(y10.C("LMT_VIDEO_SOUND_ON")) ? 1.0f : 0.0f;
                this.f23617b1.D(y10.C("LMT_VIDEO_SOURCE"), y10.C("LMT_VIDEO_TAG") + cc.f.f9994a.a(), f10);
                this.f23617b1.setReadyToPlay(true);
                Handler handler = new Handler();
                this.f23626h1 = handler;
                handler.postDelayed(new g(0, this.f23626h1), g.f23666c[0]);
                ((ViewGroup.MarginLayoutParams) this.f23617b1.getLayoutParams()).setMargins(0, (int) (i10 + ((MyCoordinatorLayout) ((ConstraintLayout) findViewById(R.id.Fn)).getChildAt(0)).getChildAt(1).getY()), 0, 0);
                this.f23617b1.getLayoutParams().height = f23611w1.l();
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public void u2() {
        uf.a.t((ConstraintLayout) findViewById(R.id.Fn), sc.i.GameDetails, this);
    }

    public void v2(Toolbar toolbar, LinearLayoutCompat linearLayoutCompat) {
        try {
            linearLayoutCompat.removeAllViews();
            String l02 = li.p0.l0("TURN_ON_NOTIFICATIONS");
            String l03 = li.p0.l0("SELECTIONS_EDIT_NOTIFICATIONS_TITLE");
            String l04 = li.p0.l0("GAME_CENTER_MUTE");
            if (l02.isEmpty() || l03.isEmpty() || l04.isEmpty()) {
                return;
            }
            try {
                this.f23656z0 = (CustomSpinner) LayoutInflater.from(App.m()).inflate(R.layout.P2, (ViewGroup) toolbar, false);
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
            if (this.f23656z0 != null) {
                s3(linearLayoutCompat);
            }
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
    }

    public void v3(boolean z10) {
        this.X0 = z10;
    }

    public int w2() {
        return this.L0 + 90 + 30 + this.G0 + this.H0 + this.I0 + this.J0 + this.K0 + li.p0.s(5) + li.p0.A0(this.C0.BRANDING_LOGO_HEIGHT);
    }

    public void y3() {
        try {
            i0.c cVar = new i0.c(this, this, this.f23629j0, ((zf.c) this.G.getAdapter().i(this.G, 0)).rvItems, i0.r.gameDetails);
            cVar.b(F2().k2());
            Thread thread = new Thread(cVar);
            this.B0 = thread;
            thread.start();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // rb.c
    public void z0(boolean z10) {
        this.f23624g1 = z10;
    }

    public void z2() {
        this.E0.setExpanded(true);
    }

    public void z3() {
        try {
            H2().setVisibility(0);
            H2().bringToFront();
            Thread thread = new Thread(new i0.c(this, this, this.f23629j0, ((zf.l) this.G.getAdapter().i(this.G, 0)).rvItems, i0.r.statistics));
            this.B0 = thread;
            thread.start();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
