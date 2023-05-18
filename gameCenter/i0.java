package com.scores365.gameCenter;

import ag.f1;
import ag.g;
import ag.j1;
import ag.o1;
import ag.s1;
import ag.u1;
import android.app.Activity;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import cc.e1;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.R;
import com.scores365.api.g1;
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BetLineType;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.bets.model.BookmakerDisclaimer;
import com.scores365.entitys.AthleteTrophiesScoreBoxColumnObj;
import com.scores365.entitys.BetObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.CountryObj;
import com.scores365.entitys.EventFilterObj;
import com.scores365.entitys.EventObj;
import com.scores365.entitys.EventTypeObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GamesObj;
import com.scores365.entitys.LineUpsObj;
import com.scores365.entitys.NewsObj;
import com.scores365.entitys.NotificationObj;
import com.scores365.entitys.PlainTitleItemWithSposored;
import com.scores365.entitys.PlayerObj;
import com.scores365.entitys.PromotedRadioObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxCategotyObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxColumnsObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxExtraDataEntryObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxExtraDataEntryParamObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxGroupObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxRowHelperObject;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxSummaryObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxTablesObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxValueObj;
import com.scores365.entitys.ScoreObj;
import com.scores365.entitys.ScreenSizeEnum;
import com.scores365.entitys.SourceObj;
import com.scores365.entitys.SportTypeObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.entitys.StageObj;
import com.scores365.entitys.StatObj;
import com.scores365.entitys.StatisticCategoryObj;
import com.scores365.entitys.StatisticType;
import com.scores365.entitys.StatusObj;
import com.scores365.entitys.SubTypeObj;
import com.scores365.entitys.TableObj;
import com.scores365.entitys.TableRowObj;
import com.scores365.entitys.TopPerformerObj;
import com.scores365.entitys.TopPerformerStatisticObj;
import com.scores365.entitys.TrendingItem;
import com.scores365.entitys.TvNetworkObj;
import com.scores365.entitys.VideoObj;
import com.scores365.entitys.WidgetObj;
import com.scores365.entitys.WinProbabilityObj;
import com.scores365.entitys.eCompetitorTrend;
import com.scores365.gameCenter.c1;
import com.scores365.gameCenter.gameCenterItems.VisualLineup;
import com.scores365.gameCenter.gameCenterItems.WinProbabilityChart;
import com.scores365.gameCenter.gameCenterItems.a;
import com.scores365.gameCenter.gameCenterItems.c;
import com.scores365.gameCenter.m0;
import com.scores365.gameCenter.q0;
import com.scores365.insight.InsightBetLineObj;
import com.scores365.insight.InsightsObj;
import com.scores365.insight.RelatedOddsObj;
import com.scores365.insight.SingleInsightObj;
import com.scores365.removeAds.RemoveAdsManager;
import com.scores365.services.b;
import com.scores365.ui.NoTeamDataActivity;
import com.scores365.ui.OddsView;
import com.scores365.ui.bettingViews.LineupOddsBrandedListItem;
import com.scores365.ui.bettingViews.LiveVSKickoffOddsBrandedListItem;
import com.scores365.ui.bettingViews.PostGameTeaserBrandedListItem;
import com.scores365.ui.items.AmericanRecentFormItem;
import com.scores365.ui.playerCard.LastMatchGameItem;
import com.scores365.ui.playerCard.SinglePlayerCardActivity;
import com.scores365.ui.playerCard.StatsRowObj;
import gc.n;
import j$.util.Comparator$CC;
import j$.util.function.ToIntFunction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;
import ke.a;
import ke.b;
import kotlin.jvm.functions.Function1;
import li.d1;
import sf.b;
import vh.a;
import xf.b;
import xf.y;
/* compiled from: GameCenterDataMgr.java */
/* loaded from: classes2.dex */
public class i0 implements b.c, d1.c, u1.j {
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private Boolean F;
    private final LinkedHashMap<Integer, String> G;
    private r0 H;
    private q0 I;
    private s0 J;
    ag.c K;
    u1 L;
    private cc.q0 M;
    private int N;
    private int O;
    private int P;
    private xf.g Q;
    private int R;
    private boolean S;
    private boolean T;
    private ai.a U;
    private ArrayList<com.scores365.Design.PageObjects.b> V;
    private boolean W;
    private xf.b X;
    private WinProbabilityObj Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    int f23899a;

    /* renamed from: b  reason: collision with root package name */
    boolean f23900b;

    /* renamed from: b0  reason: collision with root package name */
    private float f23901b0;

    /* renamed from: c  reason: collision with root package name */
    boolean f23902c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23903d;

    /* renamed from: e  reason: collision with root package name */
    private final int f23904e;

    /* renamed from: f  reason: collision with root package name */
    private GameObj f23905f;

    /* renamed from: f0  reason: collision with root package name */
    private final HashMap<sc.f, gc.h> f23906f0;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<Integer, GameObj.LatestNotifications> f23907g;

    /* renamed from: g0  reason: collision with root package name */
    private xe.c f23908g0;

    /* renamed from: h  reason: collision with root package name */
    private CompetitionObj f23909h;

    /* renamed from: h0  reason: collision with root package name */
    private l0 f23910h0;

    /* renamed from: i  reason: collision with root package name */
    private LinkedHashMap<Integer, CompetitionObj> f23911i;

    /* renamed from: i0  reason: collision with root package name */
    private androidx.lifecycle.a1 f23912i0;

    /* renamed from: j  reason: collision with root package name */
    private com.scores365.services.b f23913j;

    /* renamed from: j0  reason: collision with root package name */
    int f23914j0;

    /* renamed from: k  reason: collision with root package name */
    private GamesObj f23915k;

    /* renamed from: k0  reason: collision with root package name */
    int f23916k0;

    /* renamed from: l  reason: collision with root package name */
    private BetObj f23917l;

    /* renamed from: l0  reason: collision with root package name */
    ArrayList<Integer> f23918l0;

    /* renamed from: m  reason: collision with root package name */
    private boolean f23919m;

    /* renamed from: m0  reason: collision with root package name */
    ArrayList<ArrayList<TextView>> f23920m0;

    /* renamed from: n  reason: collision with root package name */
    private boolean f23921n;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f23922n0;

    /* renamed from: o  reason: collision with root package name */
    private boolean f23923o;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f23924o0;

    /* renamed from: p  reason: collision with root package name */
    private int f23925p;

    /* renamed from: p0  reason: collision with root package name */
    private cc.s0 f23926p0;

    /* renamed from: q  reason: collision with root package name */
    private ArrayList<PromotedRadioObj> f23927q;

    /* renamed from: q0  reason: collision with root package name */
    private int f23928q0;

    /* renamed from: r  reason: collision with root package name */
    private int f23929r;

    /* renamed from: r0  reason: collision with root package name */
    private q.f f23930r0;

    /* renamed from: s  reason: collision with root package name */
    private final LinkedHashMap<String, ScoreBoxTablesObj> f23931s;

    /* renamed from: s0  reason: collision with root package name */
    private j f23932s0;

    /* renamed from: t  reason: collision with root package name */
    private ke.d f23933t;

    /* renamed from: t0  reason: collision with root package name */
    private b.InterfaceC0401b f23934t0;

    /* renamed from: u  reason: collision with root package name */
    private ke.b f23935u;

    /* renamed from: u0  reason: collision with root package name */
    private c1.b f23936u0;

    /* renamed from: v  reason: collision with root package name */
    private l f23937v;

    /* renamed from: v0  reason: collision with root package name */
    private n f23938v0;

    /* renamed from: w  reason: collision with root package name */
    private m f23939w;

    /* renamed from: w0  reason: collision with root package name */
    Boolean f23940w0;

    /* renamed from: x  reason: collision with root package name */
    private int f23941x;

    /* renamed from: y  reason: collision with root package name */
    private int f23942y;

    /* renamed from: z  reason: collision with root package name */
    private int f23943z;

    /* renamed from: x0  reason: collision with root package name */
    public static final int f23896x0 = li.p0.s(2);

    /* renamed from: y0  reason: collision with root package name */
    public static final int f23897y0 = li.p0.s(12);

    /* renamed from: z0  reason: collision with root package name */
    public static int f23898z0 = -1;
    public static int A0 = -1;
    public static int B0 = -1;
    public static int C0 = -1;
    public static int D0 = -1;
    public static Boolean E0 = null;
    public static String F0 = null;
    public static Boolean G0 = null;
    private static HashSet<Integer> H0 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public class a implements Comparator<yf.e> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(yf.e eVar, yf.e eVar2) {
            try {
                return eVar2.f43355d - eVar.f43355d;
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public class b implements Comparator<PlayerObj> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(PlayerObj playerObj, PlayerObj playerObj2) {
            try {
                return playerObj2.getSubtituteTime() - playerObj.getSubtituteTime();
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    class c implements Comparator<VideoObj> {
        c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(VideoObj videoObj, VideoObj videoObj2) {
            try {
                return videoObj.getType() - videoObj2.getType();
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23947a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f23948b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f23949c;

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ int[] f23950d;

        static {
            int[] iArr = new int[bg.e.values().length];
            f23950d = iArr;
            try {
                iArr[bg.e.ODDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23950d[bg.e.LINEUPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23950d[bg.e.PLAY_BY_PLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23950d[bg.e.STANDINGS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23950d[bg.e.PLAYER_STATISTICS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23950d[bg.e.TRENDS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23950d[bg.e.STATISTICS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23950d[bg.e.HEAD_2_HEAD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f23950d[bg.e.NEWS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f23950d[bg.e.BUZZ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f23950d[bg.e.STORY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f23950d[bg.e.HIGHLIGHTS.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f23950d[bg.e.INSIGHTS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f23950d[bg.e.POINT_BY_POINT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f23950d[bg.e.DETAILS.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr2 = new int[bg.d.values().length];
            f23949c = iArr2;
            try {
                iArr2[bg.d.MATCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f23949c[bg.d.BUZZ.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f23949c[bg.d.INSIGHTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr3 = new int[TrendingItem.eTrendingItem.values().length];
            f23948b = iArr3;
            try {
                iArr3[TrendingItem.eTrendingItem.BUZZ.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f23948b[TrendingItem.eTrendingItem.NEWS.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f23948b[TrendingItem.eTrendingItem.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            int[] iArr4 = new int[s.values().length];
            f23947a = iArr4;
            try {
                iArr4[s.Overall.ordinal()] = 1;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f23947a[s.CurrentSurface.ordinal()] = 2;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f23947a[s.HomeTeam.ordinal()] = 3;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f23947a[s.AwayTeam.ordinal()] = 4;
            } catch (NoSuchFieldError unused25) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public EventObj f23951a;

        /* renamed from: b  reason: collision with root package name */
        public EventObj f23952b;

        private e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public static class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<i0> f23953a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<k> f23954b;

        /* renamed from: c  reason: collision with root package name */
        private int f23955c;

        /* renamed from: d  reason: collision with root package name */
        private int f23956d;

        /* renamed from: e  reason: collision with root package name */
        private WeakReference<Handler> f23957e;

        public f(i0 i0Var, int i10, k kVar, Handler handler, int i11) {
            this.f23953a = new WeakReference<>(i0Var);
            this.f23954b = new WeakReference<>(kVar);
            this.f23955c = i10;
            this.f23956d = i11;
            this.f23957e = new WeakReference<>(handler);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                i0 i0Var = this.f23953a.get();
                if (i0Var != null) {
                    i0Var.x0(this.f23954b.get(), this.f23955c, this.f23957e.get(), this.f23956d);
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public static class g extends AsyncTask<GameObj, Void, com.scores365.gameCenter.Predictions.b> {

        /* renamed from: a  reason: collision with root package name */
        n f23958a;

        public g(n nVar) {
            this.f23958a = nVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public com.scores365.gameCenter.Predictions.b doInBackground(GameObj... gameObjArr) {
            try {
                g1 g1Var = new g1(App.m(), gameObjArr[0].getID(), gameObjArr[0].getTopBookMaker());
                g1Var.call();
                return g1Var.a();
            } catch (Exception e10) {
                li.x0.N1(e10);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(com.scores365.gameCenter.Predictions.b bVar) {
            super.onPostExecute(bVar);
            try {
                n nVar = this.f23958a;
                if (nVar != null) {
                    nVar.h(bVar);
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        private boolean f23959a = false;

        /* renamed from: b  reason: collision with root package name */
        private String f23960b = "";

        /* renamed from: c  reason: collision with root package name */
        private String f23961c = "";

        public String a() {
            return this.f23960b;
        }

        public boolean b() {
            return this.f23959a;
        }

        public void c(String str) {
            this.f23960b = str;
        }

        public void d(String str) {
            this.f23961c = str;
        }

        public void e(boolean z10) {
            this.f23959a = z10;
        }

        public void f(BookMakerObj bookMakerObj) {
            BookmakerDisclaimer bookmakerDisclaimer;
            try {
                if (!a().isEmpty() || bookMakerObj == null || (bookmakerDisclaimer = bookMakerObj.disclaimer) == null || bookmakerDisclaimer.getText() == null || bookMakerObj.disclaimer.getText().isEmpty() || bookMakerObj.disclaimer.getUrl() == null || bookMakerObj.disclaimer.getUrl().isEmpty()) {
                    return;
                }
                c(bookMakerObj.disclaimer.getText());
                d(bookMakerObj.disclaimer.getUrl());
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public static class i implements Comparator<PlayerObj> {
        private i() {
        }

        /* synthetic */ i(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(PlayerObj playerObj, PlayerObj playerObj2) {
            if (playerObj == null || playerObj2 == null) {
                return 0;
            }
            try {
                return playerObj2.getImportanceRank() - playerObj.getImportanceRank() > 0.0f ? 1 : -1;
            } catch (Exception e10) {
                li.x0.N1(e10);
                return 0;
            }
        }
    }

    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public interface j {
        void t(BetObj betObj);
    }

    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public interface k {
        void OnGameCompleteGameData(GameObj gameObj, CompetitionObj competitionObj, boolean z10);
    }

    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public interface l {
        void Y0();

        void onNetworkError();
    }

    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public interface m {
        void p(bg.e eVar, bg.d dVar, boolean z10, bg.e eVar2);
    }

    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public interface n {
        void h(com.scores365.gameCenter.Predictions.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public static class o implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final int f23962a;

        /* renamed from: b  reason: collision with root package name */
        private final int f23963b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f23964c;

        /* renamed from: d  reason: collision with root package name */
        private final int f23965d;

        /* renamed from: e  reason: collision with root package name */
        private final int f23966e;

        /* renamed from: f  reason: collision with root package name */
        private final String f23967f;

        /* renamed from: g  reason: collision with root package name */
        private final int f23968g;

        /* renamed from: h  reason: collision with root package name */
        private final PlayerObj f23969h;

        /* renamed from: i  reason: collision with root package name */
        private final String f23970i;

        /* renamed from: j  reason: collision with root package name */
        private final d1 f23971j;

        /* renamed from: k  reason: collision with root package name */
        private final a.EnumC0251a f23972k;

        /* renamed from: l  reason: collision with root package name */
        private final GameObj f23973l;

        /* renamed from: m  reason: collision with root package name */
        private final CompetitionObj f23974m;

        public o(int i10, int i11, boolean z10, int i12, int i13, String str, int i14, PlayerObj playerObj, String str2, a.EnumC0251a enumC0251a, d1 d1Var, GameObj gameObj, CompetitionObj competitionObj) {
            this.f23962a = i10;
            this.f23963b = i11;
            this.f23964c = z10;
            this.f23965d = i12;
            this.f23966e = i13;
            this.f23967f = str;
            this.f23968g = i14;
            this.f23969h = playerObj;
            this.f23970i = str2;
            this.f23971j = d1Var;
            this.f23972k = enumC0251a;
            this.f23973l = gameObj;
            this.f23974m = competitionObj;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (this.f23962a > 0) {
                    boolean z10 = (this.f23968g == SportTypesEnum.HOCKEY.getValue() || (this.f23969h.getStatus() == PlayerObj.ePlayerStatus.MANAGEMENT) || this.f23973l.getLineUps() == null || !this.f23973l.getLineUps()[this.f23972k.ordinal()].isHasPlayerStats() || this.f23969h.athleteId <= 0) ? false : true;
                    FragmentManager C = this.f23971j.C();
                    if (z10 && C != null) {
                        int id2 = this.f23973l.getID();
                        int sportID = this.f23973l.getSportID();
                        boolean z11 = this.f23964c;
                        a.EnumC0251a enumC0251a = this.f23972k;
                        PlayerObj playerObj = this.f23969h;
                        zb.k W1 = zb.k.W1(new zb.l(id2, sportID, z11, enumC0251a, playerObj.athleteId, playerObj.pId, this.f23973l.getCompetitionID(), this.f23973l.getComps()[this.f23972k.ordinal()].getID(), this.f23973l.getComps()[this.f23972k.ordinal()].getName(), "boxscore_popup", i0.D0(this.f23973l), false, new se.f(false, ""), true));
                        W1.d2(this.f23973l);
                        W1.c2(this.f23974m);
                        W1.show(C, "LiveStatsPopupDialog");
                    } else if (li.x0.p1(this.f23968g)) {
                        App.m().startActivity(SinglePlayerCardActivity.createSinglePlayerCardActivityIntent(this.f23962a, this.f23963b, this.f23964c, "", "gamecenter_boxscore").addFlags(268435456));
                    }
                } else {
                    li.p0.m(NoTeamDataActivity.eNoTeamDataErrorType.Player, this.f23966e, this.f23970i, this.f23968g, this.f23969h.countryId, App.m(), this.f23969h.getImgVer(), this.f23969h.getShortNameForTopPerformer(), this.f23969h.athleteId);
                }
                ee.k.n(App.m(), "gamecenter", "player-stat", "player", "click", true, "game_id", String.valueOf(this.f23965d), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.f23967f, "is_top_performers", "0", "athlete_id", String.valueOf(this.f23962a), "team_id", String.valueOf(this.f23966e));
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public static class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<i0> f23975a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<k> f23976b;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<GameObj> f23977c;

        /* renamed from: d  reason: collision with root package name */
        private WeakReference<GamesObj> f23978d;

        /* renamed from: e  reason: collision with root package name */
        private WeakReference<CompetitionObj> f23979e;

        public p(GameObj gameObj, CompetitionObj competitionObj, k kVar, i0 i0Var, GamesObj gamesObj) {
            this.f23976b = new WeakReference<>(kVar);
            this.f23977c = new WeakReference<>(gameObj);
            this.f23979e = new WeakReference<>(competitionObj);
            this.f23975a = new WeakReference<>(i0Var);
            this.f23978d = new WeakReference<>(gamesObj);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                k kVar = this.f23976b.get();
                GameObj gameObj = this.f23977c.get();
                CompetitionObj competitionObj = this.f23979e.get();
                i0 i0Var = this.f23975a.get();
                if (kVar != null) {
                    if (i0Var.f23907g != null && !i0Var.f23907g.isEmpty()) {
                        gameObj.set_latestNotifications(i0Var.f23907g);
                    }
                    gameObj.initLatestNotifications(this.f23978d.get());
                    kVar.OnGameCompleteGameData(gameObj, competitionObj, false);
                    i0Var.W3();
                    i0Var.W();
                    i0Var.F0();
                    i0Var.h3();
                    if (gameObj.isHasMorePrediction()) {
                        i0Var.a1();
                    }
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public static class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<e1> f23980a;

        public q(e1 e1Var) {
            this.f23980a = new WeakReference<>(e1Var);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e1 e1Var = this.f23980a.get();
                if (e1Var != null) {
                    e1Var.GetBannerHolderView().setVisibility(8);
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public enum r {
        lineups,
        gameDetails,
        statistics,
        news,
        standings,
        knockout,
        groups,
        insight,
        predictions,
        none
    }

    /* compiled from: GameCenterDataMgr.java */
    /* loaded from: classes2.dex */
    public enum s {
        Overall,
        HomeTeam,
        AwayTeam,
        CurrentSurface,
        none;

        public static s fromTabNumber(int i10, boolean z10) {
            s sVar = none;
            try {
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (z10) {
                if (i10 == 1) {
                    sVar = AwayTeam;
                } else if (i10 != 2) {
                    if (i10 == 3) {
                        sVar = HomeTeam;
                    }
                    return sVar;
                } else {
                    sVar = Overall;
                }
            } else if (i10 == 1) {
                sVar = HomeTeam;
            } else if (i10 == 2) {
                sVar = Overall;
            } else if (i10 != 3) {
                return sVar;
            } else {
                sVar = AwayTeam;
            }
            return sVar;
        }

        public static s fromTennisSurfaceTabNumber(int i10) {
            s sVar = none;
            try {
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (i10 != 1) {
                if (i10 == 2) {
                    sVar = CurrentSurface;
                }
                return sVar;
            }
            sVar = Overall;
            return sVar;
        }
    }

    public i0(int i10, int i11, int i12, boolean z10) {
        this.f23899a = 0;
        this.f23900b = false;
        this.f23902c = false;
        this.f23907g = null;
        this.f23919m = false;
        this.f23921n = true;
        this.f23923o = false;
        this.f23925p = -1;
        this.f23929r = -1;
        this.f23931s = new LinkedHashMap<>();
        this.f23941x = -1;
        this.f23942y = -1;
        this.f23943z = -1;
        this.A = -1;
        this.B = false;
        this.C = true;
        this.D = true;
        this.E = false;
        this.F = null;
        this.G = new LinkedHashMap<>();
        this.N = -1;
        this.O = 0;
        this.P = 0;
        this.R = -1;
        this.S = false;
        this.T = true;
        this.W = false;
        this.Z = false;
        this.f23901b0 = 0.5f;
        this.f23906f0 = new HashMap<>();
        this.f23922n0 = false;
        this.f23924o0 = false;
        this.f23926p0 = null;
        this.f23928q0 = -1;
        this.f23930r0 = new q.f() { // from class: com.scores365.gameCenter.u
            @Override // com.scores365.Design.Pages.q.f
            public final void a(int i13, com.scores365.Design.PageObjects.b bVar) {
                i0.c3(i13, bVar);
            }
        };
        this.f23940w0 = null;
        this.f23903d = i10;
        this.f23904e = i11;
        this.f23929r = i12;
        E0 = Boolean.valueOf(z10);
        f23898z0 = i10;
        C0 = i11;
    }

    public i0(GameObj gameObj, CompetitionObj competitionObj, boolean z10) {
        this.f23899a = 0;
        this.f23900b = false;
        this.f23902c = false;
        this.f23907g = null;
        this.f23919m = false;
        this.f23921n = true;
        this.f23923o = false;
        this.f23925p = -1;
        this.f23929r = -1;
        this.f23931s = new LinkedHashMap<>();
        this.f23941x = -1;
        this.f23942y = -1;
        this.f23943z = -1;
        this.A = -1;
        this.B = false;
        this.C = true;
        this.D = true;
        this.E = false;
        this.F = null;
        this.G = new LinkedHashMap<>();
        this.N = -1;
        this.O = 0;
        this.P = 0;
        this.R = -1;
        this.S = false;
        this.T = true;
        this.W = false;
        this.Z = false;
        this.f23901b0 = 0.5f;
        this.f23906f0 = new HashMap<>();
        this.f23922n0 = false;
        this.f23924o0 = false;
        this.f23926p0 = null;
        this.f23928q0 = -1;
        this.f23930r0 = new q.f() { // from class: com.scores365.gameCenter.u
            @Override // com.scores365.Design.Pages.q.f
            public final void a(int i13, com.scores365.Design.PageObjects.b bVar) {
                i0.c3(i13, bVar);
            }
        };
        this.f23940w0 = null;
        this.f23905f = gameObj;
        this.f23907g = gameObj.get_latestNotifications();
        this.f23909h = competitionObj;
        int id2 = this.f23905f.getID();
        this.f23903d = id2;
        if (competitionObj != null) {
            this.f23904e = competitionObj.getID();
        } else {
            this.f23904e = this.f23905f.getCompetitionID();
        }
        E0 = Boolean.valueOf(z10);
        f23898z0 = id2;
        C0 = this.f23904e;
        A0 = this.f23905f.getSportID();
        if (this.f23905f.isShowPlayByPlay() || this.f23905f.hasMatchFacts) {
            this.H = new r0(this.f23905f.getPlayByPlayPreviewURL(), this.f23905f);
            this.I = new q0(this.f23905f.getPlayByPlayFeedURL(), this.f23905f);
        }
        zh.i.f44133a.a();
        if (this.f23905f.hasPointByPoint()) {
            this.J = new s0();
        }
    }

    private String A1() {
        if (this.f23905f.GetPhaseName().isEmpty()) {
            return "";
        }
        return " - " + this.f23905f.GetPhaseName();
    }

    private com.scores365.Design.PageObjects.b B(Object obj, Object obj2, g.e eVar, int i10) {
        try {
            return new ag.g(obj, obj2, i10, eVar, obj instanceof EventObj ? n2((EventObj) obj) : null, obj2 instanceof EventObj ? n2((EventObj) obj2) : null, C0());
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> B0() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        com.scores365.Design.PageObjects.b t02 = t0();
        if (t02 != null) {
            arrayList.add(new ag.d0(li.p0.l0("GAME_CENTER_GAME_INFO")));
            arrayList.add(t02);
        }
        return arrayList;
    }

    private List<com.scores365.Design.PageObjects.b> B1() {
        ArrayList arrayList = new ArrayList();
        try {
            LinkedHashMap<Integer, SingleInsightObj> linkedHashMap = this.f23905f.getWinningProbabilityInsights().insightsMap;
            arrayList.add(new yc.r(li.p0.l0("WINNING_PROBABILITY")));
            if (li.x0.k(this.f23905f.homeAwayTeamOrder)) {
                if (linkedHashMap.size() > 1) {
                    arrayList.add(new o1(this.f23905f, 1));
                }
                arrayList.add(new o1(this.f23905f, 0));
            } else {
                arrayList.add(new o1(this.f23905f, 0));
                if (linkedHashMap.size() > 1) {
                    arrayList.add(new o1(this.f23905f, 1));
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    public static boolean B2(GameObj gameObj) {
        try {
            if (!App.b.s(gameObj) && !App.b.s(gameObj.getComps()[0]) && !App.b.s(gameObj.getComps()[1])) {
                if (!App.b.r(gameObj.getCompetitionID(), App.c.LEAGUE)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    private void C(Activity activity, ArrayList<com.scores365.Design.PageObjects.b> arrayList, h hVar) {
        try {
            if (li.x0.s2()) {
                if (!(activity instanceof GameCenterBaseActivity) || J2()) {
                    arrayList.addAll(z1(hVar));
                } else {
                    GameCenterBaseActivity gameCenterBaseActivity = (GameCenterBaseActivity) activity;
                    if (zf.c.q2() && gameCenterBaseActivity.showAdsForContext() && !F2() && M2()) {
                        this.A = arrayList.size();
                    } else {
                        arrayList.addAll(z1(hVar));
                    }
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> C1(int i10, h hVar) {
        BookMakerObj bookMakerObj;
        BookmakerDisclaimer bookmakerDisclaimer;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        if (this.f23905f.getPredictionObj() != null) {
            if (hVar != null) {
                bookMakerObj = null;
                for (Integer num : this.f23905f.getPredictionObj().b().keySet()) {
                    com.scores365.gameCenter.Predictions.a aVar = this.f23905f.getPredictionObj().b().get(num);
                    if (aVar.e() != null && li.x0.s2()) {
                        hVar.e(true);
                        bookMakerObj = this.f23905f.getPredictionObj().a().get(Integer.valueOf(aVar.e().bookmakerId));
                        if (hVar.a().isEmpty() && (bookmakerDisclaimer = bookMakerObj.disclaimer) != null && bookmakerDisclaimer.getText() != null && !bookMakerObj.disclaimer.getText().isEmpty() && bookMakerObj.disclaimer.getUrl() != null && !bookMakerObj.disclaimer.getUrl().isEmpty()) {
                            hVar.c(bookMakerObj.disclaimer.getText());
                            hVar.d(bookMakerObj.disclaimer.getUrl());
                        }
                    }
                }
            } else {
                bookMakerObj = null;
            }
            if (n0.f24018a.f()) {
                GameObj gameObj = this.f23905f;
                arrayList.add(new xf.q(gameObj, this.f23939w, gameObj.homeAwayTeamOrder));
            } else {
                if (this.Q == null) {
                    this.Q = new xf.g();
                }
                this.Q.s(this.f23905f);
                arrayList.add(this.Q);
            }
            this.f23943z = (i10 + arrayList.size()) - 1;
        } else {
            bookMakerObj = null;
        }
        StatusObj statusObj = this.f23905f.getStatusObj();
        String l02 = li.p0.l0(this.f23905f.getIsActive() || statusObj.getAliasName().equals("Suspended") || statusObj.getAliasName().equals("Interrupted") ? "GC_PREDICTIONS_PRE_GAME" : "GC_PREDICTIONS");
        if (arrayList.size() > 0) {
            if (this.f23905f.getPredictionObj() == null || this.f23905f.getPredictionObj().a() == null || this.f23905f.getPredictionObj().a().size() <= 0 || !li.x0.s2()) {
                arrayList.add(0, new ag.d0(l02));
            } else {
                arrayList.add(0, new PlainTitleItemWithSposored(l02, -1, n0.f24018a.d() ? bookMakerObj : null, "predictions", C0(), !ke.a.f33223a.g().booleanValue()));
            }
        }
        return arrayList;
    }

    public static boolean C2(GameObj gameObj) {
        try {
            if (gameObj.getStatusObj().getIsFinished()) {
                return false;
            }
            int id2 = gameObj.getID();
            App.c cVar = App.c.GAME;
            if (!App.b.r(id2, cVar) || (!App.b.d0(gameObj.getID(), cVar) && App.b.f0(cVar, gameObj.getID()))) {
                if (!App.b.f0(cVar, gameObj.getID())) {
                    App.c cVar2 = App.c.TEAM;
                    boolean z10 = App.b.f0(cVar2, gameObj.getComps()[0].getID()) && !App.b.d0(gameObj.getComps()[0].getID(), cVar2);
                    boolean z11 = App.b.f0(cVar2, gameObj.getComps()[1].getID()) && !App.b.d0(gameObj.getComps()[1].getID(), cVar2);
                    if (!z10 && !z11) {
                        App.c cVar3 = App.c.LEAGUE;
                        if (!App.b.f0(cVar3, gameObj.getCompetitionID()) || App.b.d0(gameObj.getCompetitionID(), cVar3)) {
                            return false;
                        }
                    }
                } else if (App.b.d0(gameObj.getID(), cVar)) {
                    return false;
                }
                return true;
            }
            return false;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    private void D(TreeMap<Integer, TreeMap<Integer, TreeMap<Integer, LinkedHashMap<Integer, ArrayList<Object>>>>> treeMap, ArrayList<yf.e> arrayList, int i10) {
        int i11;
        try {
            Iterator<yf.e> it = arrayList.iterator();
            while (it.hasNext()) {
                yf.e next = it.next();
                StatusObj statusObj = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStatuses().get(Integer.valueOf(next.f43352a.substituteStatus));
                Iterator<StageObj> it2 = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStages().values().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        i11 = -1;
                        break;
                    }
                    int id2 = it2.next().getID();
                    i11 = statusObj.scoreStage;
                    if (id2 == i11) {
                        break;
                    }
                }
                Comparator comparator = null;
                if (!treeMap.containsKey(Integer.valueOf(i11))) {
                    treeMap.put(Integer.valueOf(i11), new TreeMap<>(this.f23905f.shouldShowEventsOrderFromBottom() ? null : Collections.reverseOrder()));
                }
                if (!treeMap.get(Integer.valueOf(i11)).containsKey(Integer.valueOf(next.f43352a.getSubtituteTime()))) {
                    TreeMap<Integer, TreeMap<Integer, LinkedHashMap<Integer, ArrayList<Object>>>> treeMap2 = treeMap.get(Integer.valueOf(i11));
                    Integer valueOf = Integer.valueOf(next.f43352a.getSubtituteTime());
                    if (!this.f23905f.shouldShowEventsOrderFromBottom()) {
                        comparator = Collections.reverseOrder();
                    }
                    treeMap2.put(valueOf, new TreeMap<>(comparator));
                }
                if (!treeMap.get(Integer.valueOf(i11)).get(Integer.valueOf(next.f43352a.getSubtituteTime())).containsKey(Integer.valueOf(next.f43352a.substituteAddedTime))) {
                    treeMap.get(Integer.valueOf(i11)).get(Integer.valueOf(next.f43352a.getSubtituteTime())).put(Integer.valueOf(next.f43352a.substituteAddedTime), new LinkedHashMap<>());
                }
                if (!treeMap.get(Integer.valueOf(i11)).get(Integer.valueOf(next.f43352a.getSubtituteTime())).get(Integer.valueOf(next.f43352a.substituteAddedTime)).containsKey(Integer.valueOf(i10))) {
                    treeMap.get(Integer.valueOf(i11)).get(Integer.valueOf(next.f43352a.getSubtituteTime())).get(Integer.valueOf(next.f43352a.substituteAddedTime)).put(Integer.valueOf(i10), new ArrayList<>());
                }
                treeMap.get(Integer.valueOf(i11)).get(Integer.valueOf(next.f43352a.getSubtituteTime())).get(Integer.valueOf(next.f43352a.substituteAddedTime)).get(Integer.valueOf(i10)).add(next);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public static String D0(GameObj gameObj) {
        String str;
        if (gameObj != null) {
            try {
                StatusObj statusObj = App.l().getSportTypes().get(Integer.valueOf(gameObj.getSportID())).getStatuses().get(Integer.valueOf(gameObj.getStID()));
                if (statusObj.getIsFinished()) {
                    str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                } else if (!statusObj.getIsActive()) {
                    return "0";
                } else {
                    str = "2";
                }
                return str;
            } catch (Exception e10) {
                li.x0.N1(e10);
                return "0";
            }
        }
        return "0";
    }

    private ArrayList<com.scores365.Design.PageObjects.b> D1() {
        TopPerformerObj topPerformerObj;
        ArrayList<TopPerformerStatisticObj> arrayList;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList2 = new ArrayList<>();
        try {
            if (this.f23905f.getSportID() == SportTypesEnum.BASEBALL.getValue() && (topPerformerObj = this.f23905f.probablePitchers) != null && (arrayList = topPerformerObj.statistics) != null && !arrayList.isEmpty()) {
                arrayList2.add(new yc.r(this.f23905f.probablePitchers.statistics.get(0).statisticTitle));
                int cid = a0(this.f23905f.getCompetitionID()).getCid();
                GameObj gameObj = this.f23905f;
                arrayList2.add(new xf.d0(gameObj.probablePitchers, 0, gameObj, cid, true, gameObj.homeAwayTeamOrder, true));
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0092 A[Catch: Exception -> 0x009f, TRY_LEAVE, TryCatch #0 {Exception -> 0x009f, blocks: (B:16:0x003a, B:18:0x004c, B:22:0x005f, B:24:0x006f, B:31:0x0086, B:33:0x0092), top: B:42:0x003a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean D2(com.scores365.entitys.GameObj r6) {
        /*
            r0 = 0
            int r1 = r6.getID()     // Catch: java.lang.Exception -> La2
            com.scores365.App$c r2 = com.scores365.App.c.GAME     // Catch: java.lang.Exception -> La2
            boolean r1 = com.scores365.App.b.r(r1, r2)     // Catch: java.lang.Exception -> La2
            r3 = 1
            if (r1 == 0) goto L23
            int r1 = r6.getID()     // Catch: java.lang.Exception -> La2
            boolean r1 = com.scores365.App.b.d0(r1, r2)     // Catch: java.lang.Exception -> La2
            if (r1 != 0) goto L39
            int r1 = r6.getID()     // Catch: java.lang.Exception -> La2
            boolean r1 = com.scores365.App.b.f0(r2, r1)     // Catch: java.lang.Exception -> La2
            if (r1 != 0) goto L23
            goto L39
        L23:
            int r1 = r6.getID()     // Catch: java.lang.Exception -> La2
            boolean r1 = com.scores365.App.b.f0(r2, r1)     // Catch: java.lang.Exception -> La2
            if (r1 == 0) goto L39
            int r1 = r6.getID()     // Catch: java.lang.Exception -> La2
            boolean r1 = com.scores365.App.b.d0(r1, r2)     // Catch: java.lang.Exception -> La2
            if (r1 != 0) goto L39
            r1 = 1
            goto L3a
        L39:
            r1 = 0
        L3a:
            com.scores365.App$c r2 = com.scores365.App.c.TEAM     // Catch: java.lang.Exception -> L9f
            com.scores365.entitys.CompObj[] r4 = r6.getComps()     // Catch: java.lang.Exception -> L9f
            r4 = r4[r0]     // Catch: java.lang.Exception -> L9f
            int r4 = r4.getID()     // Catch: java.lang.Exception -> L9f
            boolean r4 = com.scores365.App.b.f0(r2, r4)     // Catch: java.lang.Exception -> L9f
            if (r4 == 0) goto L5e
            com.scores365.entitys.CompObj[] r4 = r6.getComps()     // Catch: java.lang.Exception -> L9f
            r4 = r4[r0]     // Catch: java.lang.Exception -> L9f
            int r4 = r4.getID()     // Catch: java.lang.Exception -> L9f
            boolean r4 = com.scores365.App.b.d0(r4, r2)     // Catch: java.lang.Exception -> L9f
            if (r4 != 0) goto L5e
            r4 = 1
            goto L5f
        L5e:
            r4 = 0
        L5f:
            com.scores365.entitys.CompObj[] r5 = r6.getComps()     // Catch: java.lang.Exception -> L9f
            r5 = r5[r3]     // Catch: java.lang.Exception -> L9f
            int r5 = r5.getID()     // Catch: java.lang.Exception -> L9f
            boolean r5 = com.scores365.App.b.f0(r2, r5)     // Catch: java.lang.Exception -> L9f
            if (r5 == 0) goto L80
            com.scores365.entitys.CompObj[] r5 = r6.getComps()     // Catch: java.lang.Exception -> L9f
            r5 = r5[r3]     // Catch: java.lang.Exception -> L9f
            int r5 = r5.getID()     // Catch: java.lang.Exception -> L9f
            boolean r2 = com.scores365.App.b.d0(r5, r2)     // Catch: java.lang.Exception -> L9f
            if (r2 != 0) goto L80
            goto L81
        L80:
            r3 = 0
        L81:
            if (r4 != 0) goto L85
            if (r3 == 0) goto L86
        L85:
            r1 = 0
        L86:
            com.scores365.App$c r2 = com.scores365.App.c.LEAGUE     // Catch: java.lang.Exception -> L9f
            int r3 = r6.getCompetitionID()     // Catch: java.lang.Exception -> L9f
            boolean r3 = com.scores365.App.b.f0(r2, r3)     // Catch: java.lang.Exception -> L9f
            if (r3 == 0) goto L9d
            int r6 = r6.getCompetitionID()     // Catch: java.lang.Exception -> L9f
            boolean r6 = com.scores365.App.b.d0(r6, r2)     // Catch: java.lang.Exception -> L9f
            if (r6 != 0) goto L9d
            goto La6
        L9d:
            r0 = r1
            goto La6
        L9f:
            r6 = move-exception
            r0 = r1
            goto La3
        La2:
            r6 = move-exception
        La3:
            li.x0.N1(r6)
        La6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.i0.D2(com.scores365.entitys.GameObj):boolean");
    }

    private String E1(LinkedHashMap<Integer, PlayerObj> linkedHashMap, ScoreBoxTablesObj scoreBoxTablesObj, Integer num) {
        try {
            Iterator<StatsRowObj> it = scoreBoxTablesObj.getRows().iterator();
            while (it.hasNext()) {
                StatsRowObj next = it.next();
                if (next.getNum() == num.intValue() && linkedHashMap.get(Integer.valueOf(next.getPlayerID())) != null) {
                    return linkedHashMap.get(Integer.valueOf(next.getPlayerID())).isDidNotPlayed() ? linkedHashMap.get(Integer.valueOf(next.getPlayerID())).getDidNotPlayedReason() : "";
                }
            }
            return "";
        } catch (Exception e10) {
            li.x0.N1(e10);
            return "";
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> F(int i10, d1 d1Var, LastMatchGameItem.iScrollListener iscrolllistener) {
        PlayerObj[] players;
        PlayerObj[] players2;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            LineUpsObj lineUpsObj = this.f23905f.getLineUps()[i10];
            ArrayList<ScoreBoxTablesObj> arrayList2 = new ArrayList<>();
            if (lineUpsObj.getPlayersStatistics() != null) {
                arrayList2 = lineUpsObj.getPlayersStatistics().getTables();
            }
            G(lineUpsObj);
            H(arrayList2, lineUpsObj);
            LineUpsObj lineUpsObj2 = C0().getLineUps()[i10];
            PlayerObj[] playerObjArr = new PlayerObj[0];
            try {
                players2 = lineUpsObj2.getPlayers();
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
            LinkedHashMap<Integer, PlayerObj> linkedHashMap = new LinkedHashMap<>();
            boolean z10 = false;
            for (PlayerObj playerObj : players2) {
                linkedHashMap.put(Integer.valueOf(playerObj.pId), playerObj);
                if (!z10 && playerObj.athleteId != -1) {
                    z10 = true;
                }
            }
            if (C0().unavailablePlayers != null && C0().unavailablePlayers[i10].getPlayers() != null) {
                for (PlayerObj playerObj2 : C0().unavailablePlayers[i10].getPlayers()) {
                    linkedHashMap.put(Integer.valueOf(playerObj2.pId), playerObj2);
                    if (!z10 && playerObj2.athleteId != -1) {
                        z10 = true;
                    }
                }
            }
            boolean z11 = z10;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            int R1 = R1();
            this.f23914j0 = R1;
            int i11 = 5;
            this.f23916k0 = (R1 * 5) / 10;
            this.f23918l0 = new ArrayList<>();
            this.f23920m0 = new ArrayList<>();
            ArrayList arrayList6 = arrayList3;
            ArrayList arrayList7 = arrayList4;
            boolean z12 = false;
            boolean z13 = false;
            int i12 = 0;
            for (Integer num : this.G.keySet()) {
                LinkedHashMap<Integer, String> linkedHashMap2 = this.G;
                String str = linkedHashMap2 != null ? linkedHashMap2.get(num) : null;
                LinkedHashMap<String, ScoreBoxTablesObj> linkedHashMap3 = this.f23931s;
                ScoreBoxTablesObj scoreBoxTablesObj = linkedHashMap3 != null ? linkedHashMap3.get(str) : null;
                if (scoreBoxTablesObj != null) {
                    if (scoreBoxTablesObj.getSummary() != null && scoreBoxTablesObj.getSummary().size() > 0 && scoreBoxTablesObj.isShouldShowSummary()) {
                        i12 = scoreBoxTablesObj.getSummary().size();
                    }
                    int i13 = i12;
                    boolean z14 = this.f23921n && h1(scoreBoxTablesObj) > i11;
                    ScoreBoxTablesObj scoreBoxTablesObj2 = scoreBoxTablesObj;
                    ArrayList arrayList8 = arrayList7;
                    ArrayList arrayList9 = arrayList6;
                    arrayList9.addAll(t1(scoreBoxTablesObj, linkedHashMap, str, i10, z11, d1Var));
                    arrayList8.addAll(U1(linkedHashMap, scoreBoxTablesObj2));
                    ArrayList<ScoreBoxExtraDataEntryObj> extraData = scoreBoxTablesObj2.getExtraData();
                    if (extraData != null && !extraData.isEmpty()) {
                        arrayList5.addAll(extraData);
                    }
                    if (scoreBoxTablesObj2.getCategoryID() != -1) {
                        if (scoreBoxTablesObj2.getEmptyText().isEmpty()) {
                            arrayList.add(new ag.v(arrayList9, arrayList8, z14, i13, iscrolllistener, this.f23918l0));
                            if (extraData != null && !extraData.isEmpty()) {
                                arrayList.addAll(L1(extraData));
                            }
                        } else {
                            arrayList.add(new yc.r(lineUpsObj2.getPlayersStatistics().getCategoryTitleFromID(scoreBoxTablesObj2.getCategoryID())));
                            arrayList.add(new ag.w(scoreBoxTablesObj2.getEmptyText()));
                        }
                        arrayList6 = new ArrayList();
                        arrayList7 = new ArrayList();
                        i12 = i13;
                        z13 = z14;
                        z12 = true;
                    } else {
                        arrayList6 = arrayList9;
                        arrayList7 = arrayList8;
                        i12 = i13;
                        z13 = z14;
                    }
                }
                i11 = 5;
            }
            ArrayList arrayList10 = arrayList7;
            ArrayList arrayList11 = arrayList6;
            u2();
            if (!z12) {
                arrayList.add(new ag.v(arrayList11, arrayList10, z13, i12, iscrolllistener, this.f23918l0));
                if (!arrayList5.isEmpty()) {
                    arrayList.addAll(L1(arrayList5));
                }
            }
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        try {
            GameObj gameObj = this.f23905f;
            if (gameObj.hasBetsTeaser) {
                ke.b bVar = new ke.b(gameObj.getID(), this.f23934t0, this.f23905f.getTopBookMaker());
                this.f23935u = bVar;
                bVar.b();
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> F1() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        if (!this.f23905f.getStatusObj().getIsFinished() && ((this.f23905f.getComps()[0].getCompetitorTrend() != null && !this.f23905f.getComps()[0].getCompetitorTrend().isEmpty()) || (this.f23905f.getComps()[1].getCompetitorTrend() != null && !this.f23905f.getComps()[1].getCompetitorTrend().isEmpty()))) {
            GameObj gameObj = this.f23905f;
            xf.j jVar = new xf.j(gameObj, gameObj.homeAwayTeamOrder);
            arrayList.add(new ag.d0(li.p0.l0("GAME_CENTER_RECENT_FORM")));
            arrayList.add(jVar);
        }
        return arrayList;
    }

    private void G(LineUpsObj lineUpsObj) {
        try {
            if (lineUpsObj.getPlayersStatistics().getCategories() != null) {
                int size = this.G.size();
                Iterator<ScoreBoxCategotyObj> it = lineUpsObj.getPlayersStatistics().getCategories().iterator();
                while (it.hasNext()) {
                    ScoreBoxCategotyObj next = it.next();
                    this.G.put(Integer.valueOf(size), next.getName());
                    size++;
                    this.f23931s.put(next.getName(), a2(lineUpsObj.getPlayersStatistics().getTables(), next.getID()));
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private String G0(VideoObj videoObj) {
        EventObj[] events;
        try {
            if (this.f23905f.getEvents() == null || this.f23905f.getEvents().length <= 0) {
                return "";
            }
            for (EventObj eventObj : this.f23905f.getEvents()) {
                if (videoObj.eventNum == eventObj.getNum() && eventObj.getType() == videoObj.eventType) {
                    if (eventObj.getSubType() == 0) {
                        return "";
                    }
                    SubTypeObj subTypeObj = eventObj.getSubTypeObj(this.f23905f.getSportID());
                    return subTypeObj != null ? subTypeObj.getName() : eventObj.getEventType(this.f23905f.getSportID()).getName();
                }
            }
            return "";
        } catch (Exception e10) {
            li.x0.N1(e10);
            return "";
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> G1() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        boolean l10 = li.x0.l(this.f23905f.homeAwayTeamOrder, true);
        arrayList.add(new ag.d0(this.f23905f.atsRecords.getTitle()));
        arrayList.add(new AmericanRecentFormItem(this.f23905f, AmericanRecentFormItem.ItemType.TITLE, -1));
        GameObj gameObj = this.f23905f;
        AmericanRecentFormItem.ItemType itemType = AmericanRecentFormItem.ItemType.DATA;
        arrayList.add(new AmericanRecentFormItem(gameObj, itemType, l10 ? 1 : 0));
        arrayList.add(new AmericanRecentFormItem(this.f23905f, itemType, !l10 ? 1 : 0));
        arrayList.add(new f1(this.f23939w, bg.e.HEAD_2_HEAD, bg.d.INSIGHTS, li.p0.l0("ATS_UO_RECORDS_SLG")));
        return arrayList;
    }

    private boolean G2() {
        try {
            if ((li.x0.F2(this.f23905f.getSportID()) || O1() == SportTypesEnum.SOCCER.getValue()) && this.f23905f.isShowMissingPlayersWidget()) {
                GameObj gameObj = this.f23905f;
                if (gameObj.hasMissingPlayers) {
                    return gameObj.unavailablePlayers != null;
                }
                return false;
            }
            return false;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    private void H(ArrayList<ScoreBoxTablesObj> arrayList, LineUpsObj lineUpsObj) {
        try {
            Iterator<ScoreBoxTablesObj> it = arrayList.iterator();
            while (it.hasNext()) {
                ScoreBoxTablesObj next = it.next();
                if (next.getGroups() != null) {
                    int size = this.G.size();
                    Iterator<ScoreBoxGroupObj> it2 = next.getGroups().iterator();
                    while (it2.hasNext()) {
                        ScoreBoxGroupObj next2 = it2.next();
                        this.G.put(Integer.valueOf(size), next2.getName());
                        size++;
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<StatsRowObj> it3 = next.getRows().iterator();
                        while (it3.hasNext()) {
                            StatsRowObj next3 = it3.next();
                            if (next3.getGroupID() == next2.getID()) {
                                arrayList2.add(next3);
                            }
                        }
                        ScoreBoxTablesObj scoreBoxTablesObj = new ScoreBoxTablesObj(next.getCategoryID(), next.isExpandable(), next.getColumns(), arrayList2, next.getSummary());
                        scoreBoxTablesObj.setShouldShowSummary(next.getGroups().size() == size);
                        this.f23931s.put(next2.getName(), scoreBoxTablesObj);
                    }
                } else if (!lineUpsObj.getPlayersStatistics().getCategoryTitleFromID(next.getCategoryID()).isEmpty()) {
                    this.f23931s.put(lineUpsObj.getPlayersStatistics().getCategoryTitleFromID(next.getCategoryID()), next);
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private com.scores365.Design.PageObjects.e H0(s sVar) {
        int i10;
        try {
            int i11 = d.f23947a[sVar.ordinal()];
            int i12 = 1;
            int i13 = i11 != 3 ? i11 != 4 ? 2 : 3 : 1;
            boolean k10 = li.x0.k(this.f23905f.homeAwayTeamOrder);
            String shortName = this.f23905f.getComps()[0].getShortName();
            String shortName2 = this.f23905f.getComps()[1].getShortName();
            if (!k10 || sVar == s.Overall) {
                i10 = i13;
            } else {
                if (i13 != 3) {
                    i12 = 3;
                }
                i10 = i12;
            }
            return new com.scores365.Design.PageObjects.e(shortName, li.p0.l0("GC_ALL"), shortName2, i10, k10, false, 0.0f, true);
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public static CountryObj H1(GameObj gameObj) {
        if (gameObj != null) {
            try {
                ArrayList<PlayerObj> arrayList = gameObj.officialsList;
                if (arrayList == null || arrayList.isEmpty()) {
                    return null;
                }
                return sf.a.i0(App.m()).f0(gameObj.officialsList.get(0).countryId);
            } catch (Exception e10) {
                li.x0.N1(e10);
                return null;
            }
        }
        return null;
    }

    private boolean H2(ArrayList<com.scores365.Design.PageObjects.b> arrayList) {
        Iterator<com.scores365.Design.PageObjects.b> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getObjectTypeNum() == lf.u.PBPBetRadarItem.ordinal()) {
                return true;
            }
        }
        return false;
    }

    private void H3(Iterator<Integer> it, ScoreBoxSummaryObj scoreBoxSummaryObj, int i10, int i11, LinearLayout linearLayout, LinkedHashMap<Integer, ScoreBoxColumnsObj> linkedHashMap) {
        ScoreBoxValueObj X1 = X1(scoreBoxSummaryObj, it.next().intValue());
        TextView textView = new TextView(App.m());
        textView.setTypeface(li.o0.d(App.m()));
        textView.setTextColor(li.p0.A(R.attr.U0));
        textView.setGravity(17);
        textView.setTextSize(1, 12.0f);
        textView.setText((X1 == null || linkedHashMap.get(Integer.valueOf(X1.getColumnNum())) == null) ? " " : X1.getValue());
        if (li.x0.l1()) {
            textView.setTextDirection(4);
        } else {
            textView.setTextDirection(3);
        }
        int i12 = f23896x0;
        textView.setPadding(i12, 4, i12, 4);
        textView.setLayoutParams(new LinearLayout.LayoutParams(li.p0.s(i10), li.p0.s(32)));
        linearLayout.addView(textView);
        j3(linearLayout.getChildCount() - 1, textView);
    }

    private LinkedHashMap<Integer, ArrayList<ScoreBoxValueObj>> I(LinkedHashMap<Integer, ScoreBoxColumnsObj> linkedHashMap, ScoreBoxTablesObj scoreBoxTablesObj) {
        LinkedHashMap<Integer, ArrayList<ScoreBoxValueObj>> linkedHashMap2 = new LinkedHashMap<>();
        try {
            Iterator<StatsRowObj> it = scoreBoxTablesObj.getRows().iterator();
            while (it.hasNext()) {
                StatsRowObj next = it.next();
                ArrayList<ScoreBoxValueObj> arrayList = new ArrayList<>();
                if (next.getValues() != null) {
                    Iterator<ScoreBoxValueObj> it2 = next.getValues().iterator();
                    while (it2.hasNext()) {
                        ScoreBoxValueObj next2 = it2.next();
                        if (linkedHashMap.containsKey(Integer.valueOf(next2.getColumnNum()))) {
                            arrayList.add(next2);
                        }
                    }
                    arrayList = V3(arrayList, linkedHashMap);
                }
                linkedHashMap2.put(Integer.valueOf(next.getNum()), arrayList);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return linkedHashMap2;
    }

    public static final int I0() {
        return 5;
    }

    private ArrayList<com.scores365.Design.PageObjects.b> I1(LinkedHashMap<Integer, LinkedHashMap<String, ArrayList<EventObj>>> linkedHashMap, boolean z10) {
        LinkedHashMap<Integer, LinkedHashMap<String, ArrayList<EventObj>>> linkedHashMap2;
        int i10;
        int gameTime;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList(linkedHashMap.keySet());
        if (!this.f23905f.shouldShowEventsOrderFromBottom()) {
            Collections.reverse(arrayList2);
        }
        Iterator it = arrayList2.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (this.f23905f.isStageHasScores(num.intValue())) {
                arrayList.add(z(num.intValue(), true, !z11));
                linkedHashMap2 = linkedHashMap;
                z11 = true;
            } else {
                linkedHashMap2 = linkedHashMap;
            }
            LinkedHashMap<String, ArrayList<EventObj>> linkedHashMap3 = linkedHashMap2.get(num);
            if (linkedHashMap3 == null || linkedHashMap3.isEmpty()) {
                arrayList.add(new xf.a(App.l().getSportTypes().get(Integer.valueOf(SportTypesEnum.AMERICAN_FOOTBALL.getValue())).getStages().get(num).getName()));
            } else {
                ArrayList arrayList3 = new ArrayList(linkedHashMap3.keySet());
                if (!this.f23905f.shouldShowEventsOrderFromBottom()) {
                    Collections.reverse(arrayList3);
                }
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    ArrayList arrayList7 = new ArrayList(linkedHashMap3.get((String) it2.next()));
                    if (!this.f23905f.shouldShowEventsOrderFromBottom()) {
                        Collections.reverse(arrayList7);
                    }
                    Iterator it3 = arrayList7.iterator();
                    while (it3.hasNext()) {
                        EventObj eventObj = (EventObj) it3.next();
                        if (eventObj.getComp() == 1) {
                            if (li.x0.k(this.f23905f.homeAwayTeamOrder)) {
                                arrayList5.add(eventObj);
                            } else {
                                arrayList4.add(eventObj);
                            }
                        } else if (eventObj.getComp() == 2) {
                            if (li.x0.k(this.f23905f.homeAwayTeamOrder)) {
                                arrayList4.add(eventObj);
                            } else {
                                arrayList5.add(eventObj);
                            }
                        }
                    }
                    int max = Math.max(arrayList4.size(), arrayList5.size());
                    for (int i11 = 0; i11 < max; i11++) {
                        e eVar = new e(null);
                        if (i11 < arrayList4.size() && arrayList4.get(i11) != null) {
                            eVar.f23951a = (EventObj) arrayList4.get(i11);
                        }
                        if (i11 < arrayList5.size() && arrayList5.get(i11) != null) {
                            eVar.f23952b = (EventObj) arrayList5.get(i11);
                        }
                        arrayList6.add(eVar);
                    }
                    if (!this.f23905f.shouldShowEventsOrderFromBottom()) {
                        Collections.reverse(arrayList6);
                    }
                    Iterator it4 = arrayList6.iterator();
                    while (it4.hasNext()) {
                        e eVar2 = (e) it4.next();
                        EventObj eventObj2 = eVar2.f23951a;
                        if (eventObj2 != null) {
                            gameTime = eventObj2.getGameTime();
                        } else {
                            EventObj eventObj3 = eVar2.f23952b;
                            if (eventObj3 != null) {
                                gameTime = eventObj3.getGameTime();
                            } else {
                                i10 = -1;
                                arrayList.add(new ag.t(eVar2.f23951a, eVar2.f23952b, i10, g.e.none, null, null, this.f23905f));
                            }
                        }
                        i10 = gameTime;
                        arrayList.add(new ag.t(eVar2.f23951a, eVar2.f23952b, i10, g.e.none, null, null, this.f23905f));
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            arrayList.add(new ag.e());
        }
        return arrayList;
    }

    private boolean I2() {
        LinkedHashMap<Integer, SingleInsightObj> linkedHashMap;
        ArrayList<InsightBetLineObj> arrayList;
        try {
            InsightsObj insightsObj = this.f23905f.insightsObj;
            if (insightsObj == null || (linkedHashMap = insightsObj.insightsMap) == null) {
                return false;
            }
            for (SingleInsightObj singleInsightObj : linkedHashMap.values()) {
                if (singleInsightObj.live && (arrayList = singleInsightObj.insightBetLines) != null && !arrayList.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    private void I3(LinkedHashMap<Integer, LinkedHashMap<String, ArrayList<EventObj>>> linkedHashMap, int i10) {
        int i11;
        try {
            EventObj[] events = this.f23905f.getEvents();
            if (events != null) {
                B0 = events.length;
                for (EventObj eventObj : events) {
                    StatusObj statusObj = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStatuses().get(Integer.valueOf(eventObj.statusId));
                    if (statusObj.hasEvents) {
                        Iterator<StageObj> it = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStages().values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i11 = -1;
                                break;
                            }
                            int id2 = it.next().getID();
                            i11 = statusObj.scoreStage;
                            if (id2 == i11) {
                                break;
                            }
                        }
                        if (statusObj.hasEvents) {
                            if (!linkedHashMap.containsKey(Integer.valueOf(i11))) {
                                linkedHashMap.put(Integer.valueOf(i11), new LinkedHashMap<>());
                            }
                            if (i10 == 2 || App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getEventByIndex(eventObj.getType()).Major) {
                                if (!linkedHashMap.get(Integer.valueOf(i11)).containsKey(eventObj.getGameTimeToDisplay())) {
                                    linkedHashMap.get(Integer.valueOf(i11)).put(eventObj.getGameTimeToDisplay(), new ArrayList<>());
                                }
                                linkedHashMap.get(Integer.valueOf(i11)).get(eventObj.getGameTimeToDisplay()).add(eventObj);
                            }
                        }
                    }
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public static int J0() {
        return (li.p0.A0(App.p()) - 6) / 2;
    }

    private ArrayList<com.scores365.Design.PageObjects.b> J1(int i10) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            LinkedHashMap<Integer, LinkedHashMap<String, ArrayList<EventObj>>> linkedHashMap = new LinkedHashMap<>();
            I3(linkedHashMap, i10);
            ArrayList<com.scores365.Design.PageObjects.b> I1 = I1(linkedHashMap, false);
            if (I1.size() > 0) {
                arrayList.add(new ag.d0(li.p0.l0("SELECTIONS_MENU_NOTIFICATIONS_GAME_EVENTS")));
                arrayList.addAll(I1);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    private ArrayList<com.scores365.Design.PageObjects.b> K0() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        ArrayList<com.scores365.Design.PageObjects.b> R0 = R0(this.f23911i);
        if (R0 != null && !R0.isEmpty()) {
            arrayList.add(new ag.d0(li.p0.l0("GAME_CENTER_PREVIOUS_MEETINGS")));
            arrayList.addAll(R0(this.f23911i));
        }
        return arrayList;
    }

    public static boolean K2(a.EnumC0251a enumC0251a, GameObj gameObj) {
        try {
            return gameObj.getComps()[enumC0251a == a.EnumC0251a.AWAY ? (char) 1 : (char) 0].getType() == CompObj.eCompetitorType.NATIONAL;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> L0() {
        int i10;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            LinkedHashMap<Integer, LinkedHashMap<Integer, ArrayList<EventObj>>> linkedHashMap = new LinkedHashMap<>();
            if (this.f23905f.getEvents() != null) {
                y(linkedHashMap);
                w3(linkedHashMap);
                ArrayList arrayList2 = new ArrayList();
                EventFilterObj[] eventFilters = this.f23905f.getEventFilters();
                if (eventFilters == null || eventFilters.length <= 0) {
                    i10 = -1;
                } else {
                    for (EventFilterObj eventFilterObj : eventFilters) {
                        arrayList2.add(new y.b(eventFilterObj.getId(), eventFilterObj.getName()));
                    }
                    i10 = ((y.b) arrayList2.get(this.P)).a();
                    xf.y yVar = new xf.y(arrayList2, M0());
                    yVar.o(40);
                    arrayList.add(yVar);
                }
                arrayList.addAll(new cg.d(this.f23905f, i10).e(linkedHashMap));
                linkedHashMap.clear();
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    private static ArrayList<com.scores365.Design.PageObjects.b> L1(ArrayList<ScoreBoxExtraDataEntryObj> arrayList) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList2 = new ArrayList<>();
        try {
            Iterator<ScoreBoxExtraDataEntryObj> it = arrayList.iterator();
            boolean z10 = true;
            while (it.hasNext()) {
                ScoreBoxExtraDataEntryObj next = it.next();
                if (next != null && next.getName() != null && next.getData() != null) {
                    arrayList2.add(new ag.d1(next.getName(), z10));
                    z10 = false;
                    for (int i10 = 0; i10 < next.getData().size(); i10++) {
                        ScoreBoxExtraDataEntryParamObj scoreBoxExtraDataEntryParamObj = next.getData().get(i10);
                        if (scoreBoxExtraDataEntryParamObj != null) {
                            arrayList2.add(new ag.c1(scoreBoxExtraDataEntryParamObj.getKey(), scoreBoxExtraDataEntryParamObj.getValue()));
                        }
                    }
                    arrayList2.add(new ag.b1());
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList2;
    }

    private void L3(TreeMap<Integer, TreeMap<Integer, TreeMap<Integer, LinkedHashMap<Integer, ArrayList<Object>>>>> treeMap, int i10) {
        StatusObj statusObj;
        int i11;
        try {
            EventObj[] events = this.f23905f.getEvents();
            if (events != null) {
                for (EventObj eventObj : events) {
                    EventTypeObj eventByIndex = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getEventByIndex(eventObj.getType());
                    if ((i10 == 2 || (eventByIndex.Major && !eventObj.isNotInPlay())) && (statusObj = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStatuses().get(Integer.valueOf(eventObj.statusId))) != null && statusObj.hasEvents) {
                        Iterator<StageObj> it = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStages().values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i11 = -1;
                                break;
                            }
                            int id2 = it.next().getID();
                            i11 = statusObj.scoreStage;
                            if (id2 == i11) {
                                break;
                            }
                        }
                        Comparator comparator = null;
                        if (!treeMap.containsKey(Integer.valueOf(i11))) {
                            treeMap.put(Integer.valueOf(i11), new TreeMap<>(this.f23905f.shouldShowEventsOrderFromBottom() ? null : Collections.reverseOrder()));
                        }
                        if (!treeMap.get(Integer.valueOf(i11)).containsKey(Integer.valueOf(eventObj.getGT()))) {
                            TreeMap<Integer, TreeMap<Integer, LinkedHashMap<Integer, ArrayList<Object>>>> treeMap2 = treeMap.get(Integer.valueOf(i11));
                            Integer valueOf = Integer.valueOf(eventObj.getGT());
                            if (!this.f23905f.shouldShowEventsOrderFromBottom()) {
                                comparator = Collections.reverseOrder();
                            }
                            treeMap2.put(valueOf, new TreeMap<>(comparator));
                        }
                        if (!treeMap.get(Integer.valueOf(i11)).get(Integer.valueOf(eventObj.getGT())).containsKey(Integer.valueOf(eventObj.addedTime))) {
                            treeMap.get(Integer.valueOf(i11)).get(Integer.valueOf(eventObj.getGT())).put(Integer.valueOf(eventObj.addedTime), new LinkedHashMap<>());
                        }
                        if (!treeMap.get(Integer.valueOf(i11)).get(Integer.valueOf(eventObj.getGT())).get(Integer.valueOf(eventObj.addedTime)).containsKey(Integer.valueOf(eventObj.getComp()))) {
                            treeMap.get(Integer.valueOf(i11)).get(Integer.valueOf(eventObj.getGT())).get(Integer.valueOf(eventObj.addedTime)).put(Integer.valueOf(eventObj.getComp()), new ArrayList<>());
                        }
                        treeMap.get(Integer.valueOf(i11)).get(Integer.valueOf(eventObj.getGT())).get(Integer.valueOf(eventObj.addedTime)).get(Integer.valueOf(eventObj.getComp())).add(eventObj);
                    }
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private List<com.scores365.Design.PageObjects.b> M1() {
        try {
            int sportID = this.f23905f.getSportID();
            SportTypesEnum sportTypesEnum = SportTypesEnum.BASKETBALL;
            if (sportID == sportTypesEnum.getValue() || this.f23905f.getSportID() == SportTypesEnum.HOCKEY.getValue()) {
                if (this.V == null) {
                    this.V = new ArrayList<>();
                }
                if (this.U == null) {
                    this.U = new ai.a(this.f23903d, -1, this.f23905f.homeAwayTeamOrder);
                }
                if (this.V.isEmpty()) {
                    GameObj gameObj = this.f23905f;
                    if (gameObj.hasChartEvents && this.f23919m) {
                        String l02 = li.p0.l0(gameObj.getSportID() == sportTypesEnum.getValue() ? "BASKETBALL_SHOW_CHART" : "EVENT_CHART");
                        kotlinx.coroutines.flow.c<zh.c> f10 = this.U.f();
                        this.V.add(new yc.r(l02));
                        this.V.add(new zh.d(f10, this.U, this.f23905f.homeAwayTeamOrder));
                        this.V.add(new zh.h(f10, this.U, this.f23905f));
                        this.V.add(new zh.j(f10, true, true, this.U, this.f23905f));
                        this.V.add(new zh.e(f10, true, true, this.U, this.f23905f));
                        this.V.add(new zh.j(f10, false, true, this.U, this.f23905f));
                        this.V.add(new zh.e(f10, false, true, this.U, this.f23905f));
                        this.V.add(new zh.a(SportTypesEnum.create(this.f23905f.getSportID()), false, 0));
                    }
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return this.V;
    }

    private void M3(TreeMap<Integer, TreeMap<Integer, TreeMap<Integer, LinkedHashMap<Integer, ArrayList<Object>>>>> treeMap) {
        try {
            if (this.f23905f.getSportID() == SportTypesEnum.SOCCER.getValue() || this.f23905f.getSportID() == SportTypesEnum.RUGBY.getValue()) {
                D(treeMap, E0(this.f23905f.getLineUpsForCompetitor(1), 1), 1);
                D(treeMap, E0(this.f23905f.getLineUpsForCompetitor(2), 2), 2);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> N0(Activity activity, int i10, zf.c cVar, h hVar) {
        BetLine betLine;
        RelatedOddsObj relatedOddsObj;
        Hashtable<Integer, BookMakerObj> hashtable;
        RelatedOddsObj relatedOddsObj2;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            GameObj gameObj = this.f23905f;
            if (gameObj.hasInsights && gameObj.insightsObj != null) {
                ag.d0 d0Var = new ag.d0(li.p0.l0("GC_INSIGHTS"));
                SingleInsightObj value = this.f23905f.insightsObj.insightsMap.entrySet().iterator().next().getValue();
                if (!li.x0.s2() || (relatedOddsObj2 = this.f23905f.insightsObj.relatedOdds) == null || relatedOddsObj2.linesMap == null || value.getBetLine() == null) {
                    betLine = null;
                } else {
                    if (hVar != null) {
                        hVar.e(true);
                        if (hVar.a().isEmpty()) {
                            for (Integer num : this.f23905f.insightsObj.relatedOdds.linesMap.keySet()) {
                                RelatedOddsObj relatedOddsObj3 = this.f23905f.insightsObj.relatedOdds;
                                hVar.f(relatedOddsObj3.bookmakers.get(Integer.valueOf(relatedOddsObj3.linesMap.get(num).bookmakerId)));
                            }
                        }
                    }
                    betLine = this.f23905f.insightsObj.relatedOdds.linesMap.get(Integer.valueOf(value.getBetLine().lineId));
                }
                BookMakerObj bookMakerObj = (!li.x0.s2() || (relatedOddsObj = this.f23905f.insightsObj.relatedOdds) == null || (hashtable = relatedOddsObj.bookmakers) == null || betLine == null) ? null : hashtable.get(Integer.valueOf(betLine.bookmakerId));
                arrayList.add(d0Var);
                arrayList.add(new ag.i0(value, betLine, bookMakerObj, true, false, false, this.f23905f, "gamecenter", activity, this.f23909h.getName(), d0(this.f23909h.getCid()), true, cVar));
                this.f23942y = (i10 + arrayList.size()) - 1;
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    private String N1(bg.d dVar, LinkedHashSet<bg.e> linkedHashSet) {
        String c10;
        try {
            if (linkedHashSet.size() > 1) {
                int i10 = d.f23949c[dVar.ordinal()];
                c10 = i10 != 2 ? i10 != 3 ? this.f23905f.getSportID() == SportTypesEnum.TENNIS.getValue() ? li.p0.l0("TENNIS_MATCH_HEADER") : li.p0.l0("GC_MATCH") : li.p0.l0("GC_INSIGHTS") : li.p0.l0("GAME_CENTER_BUZZ");
            } else {
                c10 = bg.c.c(linkedHashSet.iterator().next(), this.f23905f.getSportID());
            }
            return c10;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return "";
        }
    }

    public static boolean N2(GameObj gameObj) {
        if (gameObj != null) {
            if (gameObj.InSeries) {
                if (gameObj.getSeriesScore() == null || gameObj.getSeriesScore().isEmpty()) {
                    return false;
                }
            } else if (gameObj.getAggregatedScore() == null || gameObj.getAggregatedScore().isEmpty()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean O0() {
        return E0.booleanValue();
    }

    private Boolean P() {
        return Boolean.valueOf(this.f23905f.getHaveLineUps() && (this.f23905f.getSportID() == SportTypesEnum.BASKETBALL.getValue() || this.f23905f.getSportID() == SportTypesEnum.AMERICAN_FOOTBALL.getValue()));
    }

    private ArrayList<GameObj> P0(int i10, boolean z10) {
        ArrayList<GameObj> lastMatchesListByDate = this.f23905f.getComps()[i10].getLastMatchesListByDate();
        return z10 ? Q0(lastMatchesListByDate, this.f23905f.getSurface()) : new ArrayList<>(lastMatchesListByDate.subList(0, Math.min(lastMatchesListByDate.size(), 15)));
    }

    private ArrayList<com.scores365.Design.PageObjects.b> P1() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            if (this.f23905f.getComps()[0].tablePosition != null && this.f23905f.getComps()[1].tablePosition != null) {
                ag.d0 d0Var = new ag.d0(li.p0.l0("GAME_CENTER_STANDING_POSITION"));
                CompObj compObj = this.f23905f.getComps()[0];
                CompObj compObj2 = this.f23905f.getComps()[1];
                if (compObj.tablePosition.isSameTable(compObj2.tablePosition.getTableId()) && compObj.tablePosition.tableRowObj.position > compObj2.tablePosition.tableRowObj.position) {
                    compObj = this.f23905f.getComps()[1];
                    compObj2 = this.f23905f.getComps()[0];
                }
                xf.o oVar = new xf.o(compObj, compObj2, this.f23905f.getSportID(), this.f23905f.getScores(), this.f23905f.getStID(), this.f23905f.getID(), this.f23905f.getComps()[0].getID(), this.f23905f.getComps()[1].getID(), this.f23905f.homeAwayTeamOrder);
                arrayList.add(d0Var);
                arrayList.add(oVar);
                if (this.f23905f.hasTable) {
                    arrayList.add(new f1(this.f23939w, bg.e.STANDINGS, bg.d.MATCH, li.p0.l0("GC_SEE_ALL")));
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    private TableRow Q1(LinkedHashMap<Integer, ScoreBoxColumnsObj> linkedHashMap) {
        TableRow tableRow;
        TableRow tableRow2 = null;
        try {
            tableRow = new TableRow(App.m());
        } catch (Exception e10) {
            e = e10;
        }
        try {
            tableRow.setLayoutParams(new TableRow.LayoutParams(-2, -2));
            LinearLayout linearLayout = new LinearLayout(App.m());
            linearLayout.setOrientation(0);
            N(linearLayout, linkedHashMap, true);
            tableRow.addView(linearLayout);
            return tableRow;
        } catch (Exception e11) {
            e = e11;
            tableRow2 = tableRow;
            li.x0.N1(e);
            return tableRow2;
        }
    }

    private boolean Q2() {
        try {
            int j02 = sf.a.i0(App.m()).j0();
            for (String str : li.p0.l0("GC_INSIGHT_RESTRICTED_COUNTRIES").split(",")) {
                if (j02 == Integer.valueOf(str).intValue()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    private e1 R(Activity activity) {
        try {
            if (activity instanceof e1) {
                return (e1) activity;
            }
            return null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> R0(LinkedHashMap<Integer, CompetitionObj> linkedHashMap) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            ArrayList<GameObj> arrayList2 = this.f23905f.lastMatchesList;
            if (arrayList2 != null && arrayList2.size() > 0) {
                boolean k10 = li.x0.k(this.f23905f.homeAwayTeamOrder);
                int parseInt = Integer.parseInt(li.p0.l0("MAX_GAMES_IN_LAST_MATCHES"));
                boolean z10 = this.f23905f.getH2hLayout() != null && this.f23905f.getH2hLayout().equals("US");
                com.scores365.Design.PageObjects.b u02 = u0(parseInt);
                if (u02 != null) {
                    arrayList.add(u02);
                }
                Iterator<GameObj> it = this.f23905f.lastMatchesList.iterator();
                while (it.hasNext()) {
                    GameObj next = it.next();
                    int i10 = parseInt - 1;
                    arrayList.add(new ag.m(next, eCompetitorTrend.NONE, k10, s.Overall, linkedHashMap.get(Integer.valueOf(next.getCompetitionID())).getName(), true, false, z10));
                    if (i10 == 0) {
                        break;
                    }
                    parseInt = i10;
                }
                arrayList.add(new ag.j(z10));
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    private int R1() {
        TextView textView = new TextView(App.m());
        textView.setPadding(0, 0, 0, 0);
        textView.setTypeface(li.o0.d(App.m()));
        textView.setTextSize(0, f23897y0);
        textView.setText("1234567890");
        textView.measure(View.MeasureSpec.makeMeasureSpec(App.p(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return textView.getMeasuredWidth();
    }

    private boolean R2(int i10) {
        try {
            if (H0 == null) {
                HashSet<Integer> hashSet = new HashSet<>();
                H0 = hashSet;
                hashSet.add(Integer.valueOf(SportTypesEnum.SOCCER.getValue()));
                H0.add(Integer.valueOf(SportTypesEnum.BASKETBALL.getValue()));
                H0.add(Integer.valueOf(SportTypesEnum.AMERICAN_FOOTBALL.getValue()));
                H0.add(Integer.valueOf(SportTypesEnum.HOCKEY.getValue()));
            }
            return H0.contains(Integer.valueOf(i10));
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> S(int i10) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            LinkedHashMap<Integer, LinkedHashMap<String, ArrayList<EventObj>>> linkedHashMap = new LinkedHashMap<>();
            l3(linkedHashMap, i10);
            ArrayList<com.scores365.Design.PageObjects.b> a10 = new de.a(this.f23905f).a(linkedHashMap);
            if (a10.size() > 0) {
                arrayList.add(new ag.d0(li.p0.l0("SCORING_SUMMARY_GAME_EVENTS")));
                arrayList.addAll(a10);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    private com.scores365.gameCenter.gameCenterItems.a S0(a.EnumC0251a enumC0251a) {
        GameObj gameObj = this.f23905f;
        return new com.scores365.gameCenter.gameCenterItems.a(gameObj, enumC0251a, !App.f20803w, gameObj.homeAwayTeamOrder);
    }

    private boolean S2() {
        try {
            if (this.f23909h.getSessions() == null || this.f23909h.getSessions()[0].getStages() == null || this.f23909h.getSessions()[0].getStages()[0].getGroups() == null) {
                return false;
            }
            Iterator<TableRowObj> it = this.f23905f.detailTableObj.competitionTable.iterator();
            int i10 = -1;
            int i11 = -1;
            int i12 = 0;
            while (it.hasNext()) {
                TableRowObj next = it.next();
                if (i10 == -1 && next.competitor.getID() == this.f23905f.getComps()[0].getID()) {
                    i10 = i12;
                }
                if (i11 == -1 && next.competitor.getID() == this.f23905f.getComps()[1].getID()) {
                    i11 = i12;
                }
                i12++;
                if (i10 > -1 && i11 > -1) {
                    break;
                }
            }
            return this.f23905f.detailTableObj.competitionTable.get(i10).group == this.f23905f.detailTableObj.competitionTable.get(i11).group;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    public static String T(GameObj gameObj) {
        String str;
        try {
            StatusObj statusObj = App.l().getSportTypes().get(Integer.valueOf(gameObj.getSportID())).getStatuses().get(Integer.valueOf(gameObj.getStID()));
            if (statusObj.getIsActive()) {
                str = "2";
            } else if (!statusObj.getIsFinished()) {
                return "0";
            } else {
                str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            }
            return str;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return "0";
        }
    }

    private String T0(String str) {
        try {
            return li.p0.l0("LINEUPS_COMPETITION_NAME").replace("#CompetitionName", str);
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public static LinkedHashMap<Integer, ScoreBoxColumnsObj> T1(ScoreBoxTablesObj scoreBoxTablesObj) {
        LinkedHashMap<Integer, ScoreBoxColumnsObj> linkedHashMap = new LinkedHashMap<>();
        try {
            ArrayList arrayList = new ArrayList(scoreBoxTablesObj.getColumns());
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ScoreBoxColumnsObj scoreBoxColumnsObj = (ScoreBoxColumnsObj) it.next();
                    linkedHashMap.put(Integer.valueOf(scoreBoxColumnsObj.getNum()), scoreBoxColumnsObj);
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return linkedHashMap;
    }

    private a.EnumC0251a U0(int i10) {
        return i10 == 0 ? a.EnumC0251a.HOME : a.EnumC0251a.AWAY;
    }

    public static boolean U3() {
        return Boolean.parseBoolean(li.p0.l0("USE_SPORTRADAR_WIDGET"));
    }

    public static String V(BetLine betLine, int i10, String str, String str2, boolean z10, int i11) {
        String str3;
        String str4;
        String str5;
        String str6 = "";
        if (i11 != -1) {
            try {
                BetLineType betLineType = App.l().bets.getLineTypes().get(Integer.valueOf(i11));
                str3 = betLineType.lineTypeOptions.get(i10).template;
                str4 = betLineType.lineTypeOptions.get(i10).name;
            } catch (Exception e10) {
                e = e10;
                li.x0.N1(e);
                return str6;
            }
        } else {
            str4 = "";
            str3 = str4;
        }
        String valueOf = betLine != null ? String.valueOf(betLine.lineOptions[i10].lead) : "";
        if (str3 == null || str3.equals("") || z10) {
            return (str4 == null || str4.isEmpty()) ? "" : str4;
        }
        try {
            if (str3.contains("#COMPETITOR1")) {
                if (li.x0.l1()) {
                    str = "\u200f" + str + "\u200f";
                }
                str5 = str3.replace("#COMPETITOR1", str);
            } else {
                str5 = str3;
            }
            if (str5.contains("#COMPETITOR2")) {
                if (li.x0.l1()) {
                    str2 = "\u200f" + str2 + "\u200f";
                }
                str5 = str5.replace("#COMPETITOR2", str2);
            }
            if (str5.contains("#LEAD")) {
                return str5.replace("#LEAD", "\u200e" + valueOf);
            }
            return str5;
        } catch (Exception e11) {
            e = e11;
            str6 = str3;
            li.x0.N1(e);
            return str6;
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> V0(zf.c cVar) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            if (C0().getLiveOddsObj() != null) {
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (BetLine betLine : C0().getLiveOddsObj().b().values()) {
                    arrayList3.add(betLine);
                }
                for (BookMakerObj bookMakerObj : C0().getLiveOddsObj().a().values()) {
                    arrayList2.add(bookMakerObj);
                }
                arrayList.add(new kg.d(arrayList3, arrayList2, C0(), this.f23905f.homeAwayTeamOrder, cVar));
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    private ArrayList<com.scores365.Design.PageObjects.b> V1(boolean z10) {
        String a10;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        if (nb.x.b(this.f23905f) && this.f23905f.getOfficialVideoObj() == null && (a10 = nb.x.a(this.f23905f)) != null && !a10.isEmpty()) {
            String l02 = li.p0.l0(z10 ? "LIVE_VIDEO_HIGHLIGHTS_TITLE" : "LIVE_VIDEO_HIGHLIGHTS_SEC_TITLE");
            int A = li.p0.A(R.attr.f21559k1);
            int indexOf = l02.indexOf("#");
            int lastIndexOf = l02.lastIndexOf("#");
            SpannableString spannableString = new SpannableString(l02.replaceAll("#", ""));
            if (indexOf > -1 && lastIndexOf > -1) {
                spannableString.setSpan(new ForegroundColorSpan(A), indexOf, lastIndexOf - 1, 18);
            }
            arrayList.add(new yc.r(spannableString));
            arrayList.add(new j1(this.f23905f, a10));
            if (!this.f23922n0) {
                j1.f688c.b(j1.b.DISPLAY, this.f23905f);
                this.f23922n0 = true;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int V2(Object obj, Object obj2) {
        int i10 = 0;
        try {
            int i11 = obj instanceof EventObj ? ((EventObj) obj).eventOrder : obj instanceof yf.e ? ((yf.e) obj).f43355d : 0;
            if (obj2 instanceof EventObj) {
                i10 = ((EventObj) obj2).eventOrder;
            } else if (obj2 instanceof yf.e) {
                i10 = ((yf.e) obj2).f43355d;
            }
            return i11 - i10;
        } catch (Exception unused) {
            return 0;
        }
    }

    private ArrayList<ScoreBoxValueObj> V3(ArrayList<ScoreBoxValueObj> arrayList, LinkedHashMap<Integer, ScoreBoxColumnsObj> linkedHashMap) {
        ArrayList<ScoreBoxValueObj> arrayList2 = new ArrayList<>();
        for (Integer num : linkedHashMap.keySet()) {
            Iterator<ScoreBoxValueObj> it = arrayList.iterator();
            while (it.hasNext()) {
                ScoreBoxValueObj next = it.next();
                if (num.intValue() == next.getColumnNum()) {
                    arrayList2.add(next);
                }
            }
        }
        arrayList.clear();
        return arrayList2;
    }

    private List<com.scores365.Design.PageObjects.b> W0(Activity activity) {
        ArrayList arrayList = new ArrayList();
        try {
            if (this.Y != null) {
                arrayList.add(new ag.d0(li.p0.l0("WINNING_PROBABILITY")));
            }
            arrayList.add(new s1(this.Y, this.f23905f.getSportID(), activity instanceof WinProbabilityChart.a ? (WinProbabilityChart.a) activity : null, li.x0.k(this.f23905f.homeAwayTeamOrder), this.f23901b0));
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    private ArrayList<com.scores365.Design.PageObjects.b> W1(PlayerObj[] playerObjArr, boolean z10) {
        Iterator it;
        int i10;
        int i11;
        String str;
        int i12;
        Iterator it2;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap = new HashMap();
            HashSet hashSet = new HashSet();
            int h10 = VisualLineup.h(playerObjArr);
            int i13 = 0;
            boolean z11 = false;
            for (PlayerObj playerObj : playerObjArr) {
                if (playerObj.getStatus() == PlayerObj.ePlayerStatus.SUBSTITUTE) {
                    arrayList2.add(playerObj);
                    if (playerObj.getSubtituteTime() > 0) {
                        hashMap.put(Integer.valueOf(playerObj.pId), playerObj);
                        z11 = true;
                    }
                }
            }
            Collections.sort(arrayList2, new b());
            Iterator it3 = arrayList2.iterator();
            boolean z12 = false;
            while (it3.hasNext()) {
                PlayerObj playerObj2 = (PlayerObj) it3.next();
                if (z11 && !z12 && playerObj2.getSubtituteTime() <= 0) {
                    arrayList.add(new ag.d0(li.p0.l0("SHOW_BENCH"), i13, li.p0.s(8)));
                    z12 = true;
                }
                c.EnumC0252c t22 = t2(playerObj2.pId);
                if (this.f23905f.getEvents() != null) {
                    EventObj[] events = this.f23905f.getEvents();
                    int length = events.length;
                    int i14 = 0;
                    int i15 = 0;
                    int i16 = 0;
                    while (i14 < length) {
                        EventObj eventObj = events[i14];
                        if (eventObj.getType() == 0) {
                            it2 = it3;
                            if (playerObj2.pId == eventObj.PId) {
                                if (eventObj.getSubType() == 1) {
                                    i16++;
                                } else {
                                    i15++;
                                }
                                i14++;
                                it3 = it2;
                            }
                        } else {
                            it2 = it3;
                        }
                        i14++;
                        it3 = it2;
                    }
                    it = it3;
                    i11 = i16;
                    i10 = i15;
                } else {
                    it = it3;
                    i10 = 0;
                    i11 = 0;
                }
                if (hashMap.containsKey(Integer.valueOf(playerObj2.pId))) {
                    int substitutedPlayer = ((PlayerObj) hashMap.get(Integer.valueOf(playerObj2.pId))).getSubstitutedPlayer();
                    for (PlayerObj playerObj3 : playerObjArr) {
                        if (playerObj3.playerNum == substitutedPlayer && !hashSet.contains(Integer.valueOf(playerObj3.pId))) {
                            hashSet.add(Integer.valueOf(playerObj3.pId));
                            str = playerObj3.getPlayerName();
                            i12 = playerObj3.getJerseyNum();
                            break;
                        }
                    }
                }
                str = "";
                i12 = -1;
                if (playerObj2.getSubstitutedPlayer() != -1) {
                    arrayList.add(new com.scores365.gameCenter.gameCenterItems.e(playerObj2, i10, i11, t22, str, i12, z10, this.f23923o, playerObj2.pId == h10));
                } else {
                    arrayList.add(new com.scores365.gameCenter.gameCenterItems.c(playerObj2, i10, i11, t22, z10, O1()));
                }
                it3 = it;
                i13 = 0;
            }
            if (!arrayList.isEmpty()) {
                if (z11) {
                    arrayList.add(0, new ag.d0(li.p0.l0("SUBS"), 0, li.p0.s(8)));
                } else {
                    arrayList.add(0, new ag.d0(li.p0.l0("SHOW_BENCH"), 0, li.p0.s(8)));
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int W2(EventObj eventObj, EventObj eventObj2) {
        try {
            return eventObj2.eventOrder - eventObj.eventOrder;
        } catch (Exception unused) {
            return 0;
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> X() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        GameObj gameObj = this.f23905f;
        if (gameObj.showScoreboard && gameObj.getScoreboardObj() != null && this.f23905f.getScoreboardObj().getColumns() != null && !this.f23905f.getScoreboardObj().getColumns().isEmpty()) {
            HashMap<Integer, ArrayList<m0.b>> b10 = m0.b(this.f23905f, this.f23909h);
            if (b10.get(1).size() > 1 || b10.get(2).size() > 1) {
                arrayList.add(new ag.d0(li.p0.l0("GAME_CENTER_BOXSCORE")));
                arrayList.add(new xf.n(this.f23905f));
            }
        }
        return arrayList;
    }

    private ArrayList<com.scores365.Design.PageObjects.b> X0(zf.c cVar) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            WidgetObj lMTWidget = this.f23905f.getLMTWidget();
            if (this.f23905f.shouldShowLiveMatchTracker() && com.scores365.gameCenter.c.m(lMTWidget, this.f23905f.widgetProviders) > 0) {
                arrayList.add(new yc.r(li.p0.l0("GAME_CENTER_MATCH_TRACKER")));
                androidx.fragment.app.h activity = cVar.getActivity();
                b.a aVar = activity instanceof b.a ? (b.a) activity : null;
                if (this.f23905f.hasPlayByPlay() && this.f23905f.shouldUseLmtPbpPreviewForSportType()) {
                    if (this.X == null) {
                        this.X = new xf.v(this.f23905f, aVar, this.f23939w);
                    }
                    arrayList.add(this.X);
                } else {
                    arrayList.add(new xf.b(this.f23905f, aVar));
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    public static ScoreBoxValueObj X1(ScoreBoxSummaryObj scoreBoxSummaryObj, int i10) {
        try {
            Iterator<ScoreBoxValueObj> it = scoreBoxSummaryObj.getValueObjs().iterator();
            while (it.hasNext()) {
                ScoreBoxValueObj next = it.next();
                if (next.getColumnNum() == i10) {
                    return next;
                }
            }
            return null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    private PlayerObj[] Y(a.EnumC0251a enumC0251a) {
        PlayerObj[] players;
        try {
            if (enumC0251a == a.EnumC0251a.HOME) {
                players = this.f23905f.getStaff()[0].getPlayers();
            } else if (enumC0251a != a.EnumC0251a.AWAY) {
                return null;
            } else {
                players = this.f23905f.getStaff()[1].getPlayers();
            }
            return players;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public static TableRow Y1(String str, boolean z10, boolean z11) {
        TableRow tableRow = new TableRow(App.m());
        try {
            ViewGroup.LayoutParams layoutParams = new TableRow.LayoutParams(-2, -2);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(-2, -2));
            ConstraintLayout constraintLayout = new ConstraintLayout(App.m());
            TextView textView = new TextView(App.m());
            textView.setTextSize(1, 12.0f);
            textView.setTypeface(li.o0.d(App.m()));
            textView.setTextColor(li.p0.A(R.attr.U0));
            textView.setGravity(16);
            ConstraintLayout.b bVar = new ConstraintLayout.b(-2, li.p0.s(32));
            bVar.f4630i = constraintLayout.getId();
            bVar.f4634k = constraintLayout.getId();
            bVar.f4622e = constraintLayout.getId();
            bVar.f4628h = constraintLayout.getId();
            constraintLayout.setId(li.p0.t());
            bVar.setMargins(li.p0.s(8), li.p0.s(0), li.p0.s(8), li.p0.s(0));
            textView.setLayoutParams(bVar);
            textView.setText(str);
            textView.setPadding(li.p0.s(8), li.p0.s(0), li.p0.s(8), li.p0.s(0));
            constraintLayout.setBackgroundColor(li.p0.A(R.attr.f21547g1));
            constraintLayout.addView(textView);
            constraintLayout.setLayoutParams(layoutParams);
            tableRow.addView(constraintLayout);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(-2, -2));
            tableRow.setPadding(0, li.p0.s(1), 0, 0);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return tableRow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int Y2(StatisticCategoryObj statisticCategoryObj, StatisticCategoryObj statisticCategoryObj2) {
        try {
            return statisticCategoryObj.getOrederLevel() - statisticCategoryObj2.getOrederLevel();
        } catch (Exception unused) {
            return 0;
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> Z(PlayerObj[] playerObjArr) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        if (playerObjArr != null) {
            try {
                int length = playerObjArr.length;
                int i10 = 0;
                boolean z10 = false;
                while (i10 < length) {
                    PlayerObj playerObj = playerObjArr[i10];
                    if (!z10) {
                        arrayList.add(new ag.d0(li.p0.l0("LINEUPS_COACHING"), li.p0.s(10)));
                    }
                    arrayList.add(new com.scores365.gameCenter.gameCenterItems.c(playerObj, -1, -1, t2(playerObj.pId), false, C0().getSportID()));
                    i10++;
                    z10 = true;
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ab A[Catch: Exception -> 0x016a, TryCatch #0 {Exception -> 0x016a, blocks: (B:3:0x0007, B:5:0x000d, B:8:0x0020, B:10:0x002a, B:12:0x002e, B:14:0x0040, B:16:0x0047, B:18:0x0053, B:20:0x005a, B:21:0x0070, B:23:0x007a, B:25:0x008b, B:32:0x00ab, B:34:0x00b0, B:36:0x00c4, B:40:0x00d2, B:44:0x010a, B:41:0x00ea, B:43:0x00f6, B:33:0x00ae, B:27:0x0096, B:29:0x009e, B:46:0x0116, B:45:0x010e, B:47:0x011a, B:49:0x0128, B:57:0x0157, B:50:0x012b, B:52:0x0139, B:54:0x0147, B:56:0x0155), top: B:62:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ae A[Catch: Exception -> 0x016a, TryCatch #0 {Exception -> 0x016a, blocks: (B:3:0x0007, B:5:0x000d, B:8:0x0020, B:10:0x002a, B:12:0x002e, B:14:0x0040, B:16:0x0047, B:18:0x0053, B:20:0x005a, B:21:0x0070, B:23:0x007a, B:25:0x008b, B:32:0x00ab, B:34:0x00b0, B:36:0x00c4, B:40:0x00d2, B:44:0x010a, B:41:0x00ea, B:43:0x00f6, B:33:0x00ae, B:27:0x0096, B:29:0x009e, B:46:0x0116, B:45:0x010e, B:47:0x011a, B:49:0x0128, B:57:0x0157, B:50:0x012b, B:52:0x0139, B:54:0x0147, B:56:0x0155), top: B:62:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4 A[Catch: Exception -> 0x016a, TryCatch #0 {Exception -> 0x016a, blocks: (B:3:0x0007, B:5:0x000d, B:8:0x0020, B:10:0x002a, B:12:0x002e, B:14:0x0040, B:16:0x0047, B:18:0x0053, B:20:0x005a, B:21:0x0070, B:23:0x007a, B:25:0x008b, B:32:0x00ab, B:34:0x00b0, B:36:0x00c4, B:40:0x00d2, B:44:0x010a, B:41:0x00ea, B:43:0x00f6, B:33:0x00ae, B:27:0x0096, B:29:0x009e, B:46:0x0116, B:45:0x010e, B:47:0x011a, B:49:0x0128, B:57:0x0157, B:50:0x012b, B:52:0x0139, B:54:0x0147, B:56:0x0155), top: B:62:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ea A[Catch: Exception -> 0x016a, TryCatch #0 {Exception -> 0x016a, blocks: (B:3:0x0007, B:5:0x000d, B:8:0x0020, B:10:0x002a, B:12:0x002e, B:14:0x0040, B:16:0x0047, B:18:0x0053, B:20:0x005a, B:21:0x0070, B:23:0x007a, B:25:0x008b, B:32:0x00ab, B:34:0x00b0, B:36:0x00c4, B:40:0x00d2, B:44:0x010a, B:41:0x00ea, B:43:0x00f6, B:33:0x00ae, B:27:0x0096, B:29:0x009e, B:46:0x0116, B:45:0x010e, B:47:0x011a, B:49:0x0128, B:57:0x0157, B:50:0x012b, B:52:0x0139, B:54:0x0147, B:56:0x0155), top: B:62:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.ArrayList<com.scores365.Design.PageObjects.b> Z0() {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.i0.Z0():java.util.ArrayList");
    }

    public static TableRow Z1(String str, boolean z10, boolean z11, boolean z12, int i10) {
        TableRow tableRow = new TableRow(App.m());
        try {
            ViewGroup.LayoutParams layoutParams = new TableRow.LayoutParams(-2, -2);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(-2, -2));
            ConstraintLayout constraintLayout = new ConstraintLayout(App.m());
            TextView textView = new TextView(App.m());
            textView.setTextSize(1, 12.0f);
            textView.setTypeface(li.o0.c(App.m()));
            textView.setTextColor(li.p0.A(R.attr.U0));
            if (li.x0.l1()) {
                textView.setGravity(21);
            } else {
                textView.setGravity(19);
            }
            ConstraintLayout.b bVar = new ConstraintLayout.b(-1, li.p0.s(32));
            bVar.f4630i = constraintLayout.getId();
            bVar.f4634k = constraintLayout.getId();
            bVar.f4622e = constraintLayout.getId();
            bVar.f4628h = constraintLayout.getId();
            constraintLayout.setId(li.p0.t());
            bVar.setMargins(li.p0.s(8), li.p0.s(0), li.p0.s(8), li.p0.s(0));
            textView.setLayoutParams(bVar);
            textView.setText(str);
            textView.setPadding(li.p0.s(1), li.p0.s(0), li.p0.s(1), li.p0.s(0));
            textView.setTextSize(1, i10);
            constraintLayout.setBackgroundColor(li.p0.A(R.attr.f21547g1));
            constraintLayout.addView(textView);
            constraintLayout.setLayoutParams(layoutParams);
            tableRow.addView(constraintLayout);
            if (li.x0.l1()) {
                tableRow.setGravity(5);
            } else {
                tableRow.setGravity(3);
            }
            tableRow.setLayoutParams(new TableLayout.LayoutParams(-2, -2));
            tableRow.setPadding(0, li.p0.s(1), 0, 0);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return tableRow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int Z2(StatObj statObj, StatObj statObj2) {
        try {
            return statObj.getStatisticTypeObj(this.f23905f.getSportID()).order - statObj2.getStatisticTypeObj(this.f23905f.getSportID()).order;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return 0;
        }
    }

    private void Z3(PlayerObj playerObj, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, String str, String str2) {
        try {
            textView.setTextSize(1, 13.0f);
            textView2.setTextSize(1, 12.0f);
            textView.setTypeface(li.o0.d(App.m()));
            textView2.setTypeface(li.o0.d(App.m()));
            constraintLayout.setId(li.p0.t());
            if (imageView != null) {
                imageView.setId(li.p0.t());
            }
            textView.setId(li.p0.t());
            textView.setMaxLines(1);
            textView2.setId(li.p0.t());
            textView2.setMaxLines(1);
            boolean z10 = imageView != null;
            ConstraintLayout.b bVar = new ConstraintLayout.b(li.p0.A0(App.p()) / 2, li.p0.s(48));
            ConstraintLayout.b bVar2 = new ConstraintLayout.b(li.p0.A0(App.p()) / 2, li.p0.s(48));
            ConstraintLayout.b bVar3 = new ConstraintLayout.b(li.p0.A0(App.p()) / 2, li.p0.s(48));
            bVar.f4630i = constraintLayout.getId();
            bVar.f4636l = constraintLayout.getId();
            ((ViewGroup.MarginLayoutParams) bVar2).width = -2;
            ((ViewGroup.MarginLayoutParams) bVar3).width = -2;
            ((ViewGroup.MarginLayoutParams) bVar).width = li.p0.s(36);
            ((ViewGroup.MarginLayoutParams) bVar).height = li.p0.s(36);
            if (z10) {
                bVar2.f4630i = imageView.getId();
                bVar3.f4636l = imageView.getId();
            } else {
                bVar2.f4630i = constraintLayout.getId();
                bVar3.f4632j = textView.getId();
            }
            boolean isEmpty = true ^ str.isEmpty();
            if (isEmpty) {
                textView2.setText(str);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
                bVar3.f4632j = -1;
                if (z10) {
                    bVar2.f4636l = imageView.getId();
                } else {
                    bVar2.f4636l = constraintLayout.getId();
                }
            }
            if (li.x0.l1()) {
                bVar.f4628h = constraintLayout.getId();
                if (z10) {
                    bVar2.f4626g = imageView.getId();
                    bVar3.f4626g = imageView.getId();
                } else {
                    bVar2.f4628h = constraintLayout.getId();
                    bVar3.f4628h = constraintLayout.getId();
                }
                textView.setGravity(5);
                textView2.setGravity(5);
            } else {
                bVar.f4622e = constraintLayout.getId();
                if (z10) {
                    bVar2.f4624f = imageView.getId();
                    bVar3.f4624f = imageView.getId();
                } else {
                    bVar2.f4622e = constraintLayout.getId();
                    bVar3.f4622e = constraintLayout.getId();
                }
                textView.setGravity(3);
                textView2.setGravity(3);
            }
            bVar2.setMargins(li.p0.s(8), li.p0.s(0), li.p0.s(8), li.p0.s(0));
            bVar3.setMargins(li.p0.s(8), li.p0.s(0), li.p0.s(8), li.p0.s(0));
            bVar.setMargins(li.p0.s(5), li.p0.s(6), li.p0.s(5), li.p0.s(6));
            textView.setTextColor(li.p0.A(R.attr.U0));
            textView2.setTextColor(li.p0.A(R.attr.f21565m1));
            if (isEmpty) {
                textView.setGravity(48);
                textView2.setGravity(80);
                ((ViewGroup.MarginLayoutParams) bVar2).height = -2;
                ((ViewGroup.MarginLayoutParams) bVar3).height = -2;
            } else {
                textView.setGravity(16);
            }
            textView.setLayoutParams(bVar2);
            textView2.setLayoutParams(bVar3);
            if (z10) {
                imageView.setLayoutParams(bVar);
            }
            constraintLayout.setBackgroundColor(li.p0.A(R.attr.f21557k));
            textView.setText(str2);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1() {
        new g(this.f23938v0).execute(this.f23905f);
    }

    private ScoreBoxTablesObj a2(ArrayList<ScoreBoxTablesObj> arrayList, int i10) {
        try {
            Iterator<ScoreBoxTablesObj> it = arrayList.iterator();
            while (it.hasNext()) {
                ScoreBoxTablesObj next = it.next();
                if (next.getCategoryID() == i10) {
                    return next;
                }
            }
            return null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int a3(com.scores365.Design.PageObjects.b bVar, com.scores365.Design.PageObjects.b bVar2) {
        if ((bVar instanceof ag.z) && (bVar2 instanceof ag.a0)) {
            return -1;
        }
        if ((bVar instanceof ag.a0) && (bVar2 instanceof ag.z)) {
            return 1;
        }
        StatisticType statisticType = null;
        StatisticType statisticType2 = bVar instanceof ag.z ? App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStatisticsTypes().get(Integer.valueOf(((ag.z) bVar).f1074a.getType())) : bVar instanceof ag.a0 ? App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStatisticsTypes().get(Integer.valueOf(((ag.a0) bVar).f407d.getType())) : null;
        if (bVar2 instanceof ag.z) {
            statisticType = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStatisticsTypes().get(Integer.valueOf(((ag.z) bVar2).f1074a.getType()));
        } else if (bVar2 instanceof ag.a0) {
            statisticType = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStatisticsTypes().get(Integer.valueOf(((ag.a0) bVar2).f407d.getType()));
        }
        if (statisticType2 != null && statisticType != null) {
            return statisticType2.order - statisticType.order;
        }
        return 0;
    }

    private cc.q0 b1(e1 e1Var) {
        cc.q0 q0Var = this.M;
        if (q0Var == null && v2() && !RemoveAdsManager.isUserAdsRemoved(App.m()) && M2()) {
            cc.q0 q0Var2 = new cc.q0(e1Var, true);
            this.M = q0Var2;
            return q0Var2;
        }
        cc.q0 q0Var3 = this.M;
        if (q0Var3 == null || !q0Var3.f10068c) {
            return q0Var;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b3(PlayerObj playerObj, PlayerObj playerObj2) {
        if (playerObj == null || playerObj2 == null) {
            return 0;
        }
        try {
            return playerObj2.getImportanceRank() - playerObj.getImportanceRank() >= 0.0f ? 1 : -1;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return 0;
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> c2() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            if (this.f23905f.getSportID() == SportTypesEnum.TENNIS.getValue() && this.f23905f.getTennisGamePointsObj() != null) {
                arrayList.add(new ag.d0(li.p0.l0("CURRENT_GAME")));
                GameObj gameObj = this.f23905f;
                arrayList.add(new ag.b(gameObj, gameObj.getTennisGamePointsObj(), true));
                if (this.f23905f.hasPointByPoint()) {
                    arrayList.add(new f1(this.f23939w, bg.e.POINT_BY_POINT, bg.d.MATCH, li.p0.l0("TENNIS_POINT_BY_POINT")));
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c3(int i10, com.scores365.Design.PageObjects.b bVar) {
        try {
            if (bVar instanceof nf.c) {
                li.x0.b2(((nf.c) bVar).f35470a.getID(), "gamecenter", false, false);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private void d1(Activity activity, @NonNull uc.d dVar, ArrayList<com.scores365.Design.PageObjects.b> arrayList, StatusObj statusObj) {
        A(arrayList, -1, activity, statusObj, dVar);
        this.f23925p = arrayList.size();
    }

    private ArrayList<com.scores365.Design.PageObjects.b> d2() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            if (this.f23905f.isNotStarted() && ((App) App.m()).i().J() && li.x0.s2() && App.l().bets.isDailyTipAvailable() && this.f23905f.hasTips() && !App.f20803w) {
                arrayList.add(new ag.d0(li.p0.l0("TIPS_DAILY_TIP")));
                arrayList.add(new gi.k());
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d3() {
        l lVar = this.f23937v;
        if (lVar != null) {
            lVar.Y0();
        }
    }

    private CountryObj e0(int i10) {
        try {
            CountryObj countryObj = this.f23915k.getCountries() != null ? this.f23915k.getCountries().get(Integer.valueOf(i10)) : null;
            return countryObj == null ? sf.a.i0(App.m()).f0(this.f23909h.getCid()) : countryObj;
        } catch (Exception unused) {
            return null;
        }
    }

    private TableRow e2(String str) {
        TableRow tableRow = new TableRow(App.m());
        try {
            tableRow.setLayoutParams(new TableLayout.LayoutParams(-2, -2));
            TextView textView = new TextView(App.m());
            z2(textView);
            textView.setText(str);
            tableRow.addView(textView, new TableRow.LayoutParams(-2, li.p0.s(32)));
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return tableRow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e3() {
        l lVar = this.f23937v;
        if (lVar != null) {
            lVar.onNetworkError();
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> f0() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        if (this.f23905f.getSportID() == SportTypesEnum.CRICKET.getValue()) {
            xf.r rVar = new xf.r(this.f23905f);
            arrayList.add(new ag.d0(li.p0.l0("WICKETS_TITLE")));
            arrayList.add(rVar);
            if (!this.f23905f.GetCurrBatters().isEmpty()) {
                xf.d dVar = new xf.d(this.f23905f);
                arrayList.add(new ag.d0(li.p0.l0("CRICKET_BATTERS_BOWLERS_TITLE")));
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    private ArrayList<com.scores365.Design.PageObjects.b> f1(PlayerObj[] playerObjArr, boolean z10) {
        c.EnumC0252c enumC0252c;
        int i10;
        int i11;
        EventObj[] events;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            HashMap hashMap = new HashMap();
            for (PlayerObj playerObj : playerObjArr) {
                if (playerObj.getSubtituteTime() > 0) {
                    hashMap.put(Integer.valueOf(playerObj.pId), playerObj);
                }
            }
            for (PlayerObj playerObj2 : playerObjArr) {
                if (playerObj2.getStatus() == PlayerObj.ePlayerStatus.LINEUP) {
                    c.EnumC0252c enumC0252c2 = c.EnumC0252c.NONE;
                    if (this.f23905f.getEvents() != null) {
                        int i12 = 0;
                        int i13 = 0;
                        for (EventObj eventObj : this.f23905f.getEvents()) {
                            if (eventObj.getType() == 0 && playerObj2.pId == eventObj.PId) {
                                if (eventObj.getSubType() == 1) {
                                    i13++;
                                } else {
                                    i12++;
                                }
                            }
                            if (eventObj.getType() == 2 && playerObj2.pId == eventObj.PId) {
                                enumC0252c2 = c.EnumC0252c.RED;
                                if (eventObj.getSubType() != -1) {
                                    enumC0252c2 = c.EnumC0252c.SECOND_YELLOW;
                                }
                            }
                            if (eventObj.getType() == 1 && playerObj2.pId == eventObj.PId) {
                                enumC0252c2 = c.EnumC0252c.YELLOW;
                            }
                        }
                        enumC0252c = enumC0252c2;
                        i10 = i12;
                        i11 = i13;
                    } else {
                        enumC0252c = enumC0252c2;
                        i10 = 0;
                        i11 = 0;
                    }
                    arrayList.add(new com.scores365.gameCenter.gameCenterItems.c(playerObj2, i10, i11, enumC0252c, z10, (String) null));
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        if (arrayList.size() > 0) {
            arrayList.add(0, new ag.d0(li.p0.l0("LINEUPS"), 0, li.p0.s(8)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f2(boolean z10) {
        if (z10) {
            return li.p0.l0("SEASON_LEADERS_TITLE") + A1();
        }
        return li.p0.l0("GAME_LEADERS_TITLE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int f3(EventObj eventObj, EventObj eventObj2) {
        try {
            return eventObj.eventOrder - eventObj2.eventOrder;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:1|(2:2|3)|(2:5|(29:7|8|(4:20|(1:24)|25|(28:29|30|31|32|(3:34|(1:37)|36)|(4:41|42|43|44)(1:120)|45|46|(1:48)|(1:50)|51|(1:55)|56|(1:58)|59|(1:63)|64|65|66|67|(1:109)(1:71)|72|(3:74|(2:95|96)(2:77|78)|(1:82))(4:97|(1:101)|102|(1:106)(1:105))|83|(1:85)|86|(2:88|(1:90))|92))|124|(0)|(0)(0)|45|46|(0)|(0)|51|(2:53|55)|56|(0)|59|(2:61|63)|64|65|66|67|(1:69)|109|72|(0)(0)|83|(0)|86|(0)|92))|128|119|46|(0)|(0)|51|(0)|56|(0)|59|(0)|64|65|66|67|(0)|109|72|(0)(0)|83|(0)|86|(0)|92|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x028d, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d7, code lost:
        if (r0 != 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0195, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0196, code lost:
        li.x0.N1(r0);
        r8 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0257 A[Catch: Exception -> 0x028d, TryCatch #1 {Exception -> 0x028d, blocks: (B:93:0x01d6, B:95:0x01da, B:106:0x0216, B:108:0x0257, B:109:0x025e, B:111:0x026b, B:113:0x027f, B:91:0x01d1, B:98:0x01eb, B:100:0x01ef, B:101:0x01fa, B:104:0x0209, B:105:0x0213), top: B:125:0x01b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x026b A[Catch: Exception -> 0x028d, TryCatch #1 {Exception -> 0x028d, blocks: (B:93:0x01d6, B:95:0x01da, B:106:0x0216, B:108:0x0257, B:109:0x025e, B:111:0x026b, B:113:0x027f, B:91:0x01d1, B:98:0x01eb, B:100:0x01ef, B:101:0x01fa, B:104:0x0209, B:105:0x0213), top: B:125:0x01b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cf A[Catch: Exception -> 0x00da, TryCatch #2 {Exception -> 0x00da, blocks: (B:30:0x00c3, B:33:0x00cf, B:36:0x00d5), top: B:127:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010d A[Catch: Exception -> 0x028f, TryCatch #0 {Exception -> 0x028f, blocks: (B:55:0x0102, B:57:0x010d, B:59:0x0116, B:60:0x011d, B:62:0x0139, B:64:0x013f, B:65:0x0146, B:67:0x014c, B:68:0x0153, B:70:0x0170, B:72:0x0176, B:73:0x0179, B:78:0x019a, B:80:0x01a0, B:82:0x01a4, B:85:0x01b4, B:88:0x01c3, B:77:0x0196, B:52:0x00fb, B:74:0x0180), top: B:123:0x00fb, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0116 A[Catch: Exception -> 0x028f, TryCatch #0 {Exception -> 0x028f, blocks: (B:55:0x0102, B:57:0x010d, B:59:0x0116, B:60:0x011d, B:62:0x0139, B:64:0x013f, B:65:0x0146, B:67:0x014c, B:68:0x0153, B:70:0x0170, B:72:0x0176, B:73:0x0179, B:78:0x019a, B:80:0x01a0, B:82:0x01a4, B:85:0x01b4, B:88:0x01c3, B:77:0x0196, B:52:0x00fb, B:74:0x0180), top: B:123:0x00fb, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0139 A[Catch: Exception -> 0x028f, TryCatch #0 {Exception -> 0x028f, blocks: (B:55:0x0102, B:57:0x010d, B:59:0x0116, B:60:0x011d, B:62:0x0139, B:64:0x013f, B:65:0x0146, B:67:0x014c, B:68:0x0153, B:70:0x0170, B:72:0x0176, B:73:0x0179, B:78:0x019a, B:80:0x01a0, B:82:0x01a4, B:85:0x01b4, B:88:0x01c3, B:77:0x0196, B:52:0x00fb, B:74:0x0180), top: B:123:0x00fb, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014c A[Catch: Exception -> 0x028f, TryCatch #0 {Exception -> 0x028f, blocks: (B:55:0x0102, B:57:0x010d, B:59:0x0116, B:60:0x011d, B:62:0x0139, B:64:0x013f, B:65:0x0146, B:67:0x014c, B:68:0x0153, B:70:0x0170, B:72:0x0176, B:73:0x0179, B:78:0x019a, B:80:0x01a0, B:82:0x01a4, B:85:0x01b4, B:88:0x01c3, B:77:0x0196, B:52:0x00fb, B:74:0x0180), top: B:123:0x00fb, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0170 A[Catch: Exception -> 0x028f, TryCatch #0 {Exception -> 0x028f, blocks: (B:55:0x0102, B:57:0x010d, B:59:0x0116, B:60:0x011d, B:62:0x0139, B:64:0x013f, B:65:0x0146, B:67:0x014c, B:68:0x0153, B:70:0x0170, B:72:0x0176, B:73:0x0179, B:78:0x019a, B:80:0x01a0, B:82:0x01a4, B:85:0x01b4, B:88:0x01c3, B:77:0x0196, B:52:0x00fb, B:74:0x0180), top: B:123:0x00fb, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a0 A[Catch: Exception -> 0x028f, TryCatch #0 {Exception -> 0x028f, blocks: (B:55:0x0102, B:57:0x010d, B:59:0x0116, B:60:0x011d, B:62:0x0139, B:64:0x013f, B:65:0x0146, B:67:0x014c, B:68:0x0153, B:70:0x0170, B:72:0x0176, B:73:0x0179, B:78:0x019a, B:80:0x01a0, B:82:0x01a4, B:85:0x01b4, B:88:0x01c3, B:77:0x0196, B:52:0x00fb, B:74:0x0180), top: B:123:0x00fb, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b4 A[Catch: Exception -> 0x028f, TryCatch #0 {Exception -> 0x028f, blocks: (B:55:0x0102, B:57:0x010d, B:59:0x0116, B:60:0x011d, B:62:0x0139, B:64:0x013f, B:65:0x0146, B:67:0x014c, B:68:0x0153, B:70:0x0170, B:72:0x0176, B:73:0x0179, B:78:0x019a, B:80:0x01a0, B:82:0x01a4, B:85:0x01b4, B:88:0x01c3, B:77:0x0196, B:52:0x00fb, B:74:0x0180), top: B:123:0x00fb, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e6  */
    /* JADX WARN: Type inference failed for: r0v75, types: [ag.u1] */
    /* JADX WARN: Type inference failed for: r23v0, types: [ag.u1$j, com.scores365.gameCenter.i0] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v1, types: [ag.u1] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.ArrayList<com.scores365.Design.PageObjects.b> h0(@androidx.annotation.NonNull android.app.Activity r24, @androidx.annotation.NonNull uc.d r25, com.scores365.entitys.StatusObj r26, int r27, zf.c r28) {
        /*
            Method dump skipped, instructions count: 664
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.i0.h0(android.app.Activity, uc.d, com.scores365.entitys.StatusObj, int, zf.c):java.util.ArrayList");
    }

    private int h1(ScoreBoxTablesObj scoreBoxTablesObj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Iterator<AthleteTrophiesScoreBoxColumnObj> it = scoreBoxTablesObj.getColumns().iterator();
            while (it.hasNext()) {
                AthleteTrophiesScoreBoxColumnObj next = it.next();
                boolean z10 = this.f23921n;
                if (z10) {
                    linkedHashMap.put(Integer.valueOf(next.getNum()), next);
                } else if (!z10 && !next.isExtended()) {
                    linkedHashMap.put(Integer.valueOf(next.getNum()), next);
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return linkedHashMap.size();
    }

    private ArrayList<com.scores365.Design.PageObjects.b> h2(boolean z10, h hVar) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        j0 j0Var = new j0(this.f23905f, z10, this.O, new Function1() { // from class: com.scores365.gameCenter.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String f22;
                f22 = i0.this.f2(((Boolean) obj).booleanValue());
                return f22;
            }
        }, new Function1() { // from class: com.scores365.gameCenter.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return i0.this.a0(((Integer) obj).intValue());
            }
        });
        try {
            if (j0Var.h() && j0Var.f()) {
                switch (this.f23905f.topPerformers.getLayout()) {
                    case 1:
                    case 2:
                        arrayList.addAll(j0Var.b(z10, hVar));
                        break;
                    case 3:
                        arrayList.addAll(j0Var.g(z10));
                        break;
                    case 4:
                        arrayList.addAll(j0Var.c(z10));
                        break;
                    case 5:
                        arrayList.addAll(j0Var.a());
                        break;
                    case 6:
                        arrayList.addAll(j0Var.e(z10, hVar));
                        break;
                }
                if (P().booleanValue()) {
                    arrayList.add(new f1(this.f23939w, bg.e.PLAYER_STATISTICS, bg.d.MATCH, li.p0.l0("FULL_BOX_SCORE_BUTTON")));
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h3() {
        try {
            if (!this.f23905f.hasWinProbability() || this.f23905f.isNotStarted()) {
                return;
            }
            c1.f23726a.a(this.f23936u0, this.f23903d);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @NonNull
    private ArrayList<com.scores365.Design.PageObjects.b> i0(@NonNull Activity activity, @NonNull uc.d dVar, StatusObj statusObj, int i10, zf.c cVar) {
        GameObj gameObj;
        BookMakerObj m22;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            h hVar = new h();
            boolean z10 = false;
            arrayList.addAll(V1(false));
            arrayList.addAll(m1(activity));
            arrayList.addAll(X0(cVar));
            arrayList.addAll(X());
            if (v2()) {
                arrayList.addAll(x1());
            }
            arrayList.addAll(z0(statusObj, i10));
            arrayList.addAll(c2());
            arrayList.addAll(h2(false, hVar));
            arrayList.addAll(f0());
            try {
                z10 = Boolean.valueOf((String) cc.o0.y().q().get("GAME_DETAILS_AD_BEFORE_INSIGHT")).booleanValue();
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
            if (z10) {
                com.scores365.Design.PageObjects.b b12 = b1((e1) activity);
                if (!M2() || b12 == null) {
                    d1(activity, dVar, arrayList, statusObj);
                } else {
                    arrayList.add(b12);
                    this.f23925p = arrayList.size();
                }
                C(activity, arrayList, hVar);
            } else {
                C(activity, arrayList, hVar);
                com.scores365.Design.PageObjects.b b13 = b1((e1) activity);
                if (!M2() || b13 == null) {
                    d1(activity, dVar, arrayList, statusObj);
                } else {
                    arrayList.add(b13);
                    this.f23925p = arrayList.size();
                }
            }
            arrayList.addAll(m0());
            List<com.scores365.Design.PageObjects.b> M1 = M1();
            if (M1 != null && !M1.isEmpty()) {
                arrayList.addAll(M1);
            }
            arrayList.addAll(W0(activity));
            arrayList.addAll(j2(hVar));
            arrayList.addAll(i2());
            arrayList.addAll(P1());
            arrayList.addAll(B0());
            arrayList.addAll(C1(arrayList.size(), hVar));
            if (hVar.b() && (gameObj = this.f23905f) != null && gameObj.getBestOddsObj() != null && this.f23905f.getBestOddsObj().getBookMakerObjs() != null && (m22 = li.x0.m2(this.f23905f.getBestOddsObj().getBookMakerObjs().values())) != null && m22.disclaimer != null) {
                arrayList.add(new ld.e(-1L, true, m22, false));
            }
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
        return arrayList;
    }

    private String i1(BetLine betLine) {
        try {
            return li.p0.l0("PROMOFEED_ODDS_BY");
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ce, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.ArrayList<com.scores365.Design.PageObjects.b> i2() {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.i0.i2():java.util.ArrayList");
    }

    private PlayerObj[] i3(int i10, ScoreBoxTablesObj scoreBoxTablesObj, LinkedHashMap<Integer, PlayerObj> linkedHashMap) {
        PlayerObj[] players = C0().getLineUps()[i10].getPlayers();
        if (players != null) {
            PlayerObj[] playerObjArr = new PlayerObj[players.length];
            Iterator<StatsRowObj> it = scoreBoxTablesObj.getRows().iterator();
            while (it.hasNext()) {
                StatsRowObj next = it.next();
                int length = players.length;
                int i11 = 0;
                for (int i12 = 0; i12 < length && players[i12].pId != next.getPlayerID(); i12++) {
                    i11++;
                }
                playerObjArr[i11] = linkedHashMap.get(Integer.valueOf(next.getPlayerID()));
            }
            return playerObjArr;
        }
        return null;
    }

    @NonNull
    private ArrayList<com.scores365.Design.PageObjects.b> j0(@NonNull Activity activity, @NonNull uc.d dVar, StatusObj statusObj) {
        BookMakerObj m22;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            h hVar = new h();
            arrayList.addAll(d2());
            arrayList.addAll(r2(hVar));
            arrayList.addAll(C1(arrayList.size(), hVar));
            ArrayList<com.scores365.Design.PageObjects.b> W1 = this.f23910h0.W1();
            if (!W1.isEmpty()) {
                arrayList.addAll(W1);
                this.f23910h0.b2(true);
            }
            arrayList.addAll(D1());
            arrayList.addAll(h2(true, hVar));
            arrayList.addAll(V1(false));
            cc.q0 b12 = b1((e1) activity);
            if (!M2() || b12 == null) {
                d1(activity, dVar, arrayList, statusObj);
            } else {
                arrayList.add(b12);
                this.f23925p = arrayList.size();
            }
            arrayList.addAll(Z0());
            arrayList.addAll(j2(hVar));
            if (this.f23905f.getWinningProbabilityInsights() != null && this.f23919m && this.f23905f.getWinningProbabilityInsights() != null && this.f23905f.getWinningProbabilityInsights().insightsMap != null && !this.f23905f.getWinningProbabilityInsights().insightsMap.isEmpty()) {
                arrayList.addAll(B1());
            }
            arrayList.addAll(i2());
            if (!li.x0.Y0(this.f23905f.getSportID())) {
                arrayList.addAll(P1());
                arrayList.addAll(F1());
            } else if (this.f23905f.atsRecords != null) {
                arrayList.addAll(G1());
            } else {
                arrayList.addAll(P1());
            }
            arrayList.addAll(K0());
            arrayList.addAll(B0());
            if (hVar.b() && (m22 = li.x0.m2(this.f23905f.getBestOddsObj().getBookMakerObjs().values())) != null && m22.disclaimer != null) {
                arrayList.add(new ld.e(-1L, true, m22, false));
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    private ArrayList<com.scores365.Design.PageObjects.b> j1(h hVar) {
        BetLine betLine;
        boolean z10;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            if (li.x0.s2() && ((!I2() || this.E) && this.f23905f.getBestOddsObj() != null && this.f23905f.getBestOddsObj().getBetLines() != null)) {
                BetLine[] betLines = this.f23905f.getBestOddsObj().getBetLines();
                int length = betLines.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        betLine = null;
                        break;
                    }
                    BetLine betLine2 = betLines[i10];
                    if (betLine2.type == 1) {
                        betLine = betLine2;
                        break;
                    }
                    i10++;
                }
                String i12 = i1(betLine);
                BookMakerObj bookMakerObj = this.f23905f.getBestOddsObj().getBookMakerObjs().get(Integer.valueOf(betLine.bookmakerId));
                if (i12 == null || i12.isEmpty()) {
                    z10 = false;
                } else {
                    this.E = true;
                    a.C0400a c0400a = ke.a.f33223a;
                    if (c0400a.g().booleanValue() && c0400a.a(bookMakerObj.getID())) {
                        arrayList.add(new LiveVSKickoffOddsBrandedListItem(bookMakerObj, new ArrayList(Collections.singleton(betLine)), this.f23905f));
                        z10 = true;
                    } else {
                        GameObj gameObj = this.f23905f;
                        arrayList.add(new xf.u(gameObj, betLine, i12, bookMakerObj, gameObj.homeAwayTeamOrder));
                        z10 = false;
                    }
                    hVar.e(true);
                    hVar.f(this.f23905f.getBestOddsObj().getBookMakerObjs().get(Integer.valueOf(betLine.bookmakerId)));
                    BookmakerDisclaimer bookmakerDisclaimer = bookMakerObj.disclaimer;
                    hVar.c(bookmakerDisclaimer != null ? bookmakerDisclaimer.getText() : "");
                    BookmakerDisclaimer bookmakerDisclaimer2 = bookMakerObj.disclaimer;
                    hVar.d(bookmakerDisclaimer2 != null ? bookmakerDisclaimer2.getUrl() : "");
                }
                if (arrayList.size() > 0 && this.f23905f.getBestOddsObj() != null && this.f23905f.getBestOddsObj().getBookMakerObjs() != null && this.f23905f.getBestOddsObj().getBookMakerObjs().size() > 0) {
                    arrayList.add(0, new PlainTitleItemWithSposored("", -1, (!OddsView.shouldShowBetNowBtn() || z10) ? null : bookMakerObj, "", null, !z10));
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02b2 A[Catch: Exception -> 0x035c, TryCatch #0 {Exception -> 0x035c, blocks: (B:3:0x0009, B:5:0x0011, B:7:0x0017, B:9:0x006c, B:11:0x008d, B:12:0x009c, B:14:0x00a2, B:16:0x00ae, B:17:0x00b1, B:18:0x00b5, B:20:0x00bb, B:22:0x00cb, B:29:0x00f8, B:30:0x0115, B:32:0x011b, B:34:0x0127, B:36:0x012d, B:38:0x0139, B:42:0x0143, B:44:0x014d, B:46:0x015d, B:48:0x0171, B:60:0x01b1, B:62:0x01b7, B:64:0x01bd, B:66:0x01e5, B:68:0x01ec, B:70:0x01f2, B:75:0x020d, B:77:0x0211, B:79:0x0218, B:81:0x0220, B:84:0x022c, B:86:0x0232, B:89:0x0242, B:91:0x0248, B:93:0x024e, B:96:0x027d, B:98:0x02a4, B:100:0x02b2, B:102:0x02b6, B:104:0x02bc, B:106:0x02e3, B:49:0x0184, B:51:0x0190, B:53:0x0194, B:55:0x01a2, B:57:0x01a6, B:25:0x00e1, B:108:0x0302, B:111:0x0325, B:113:0x0334, B:114:0x0347, B:10:0x007d), top: B:119:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011b A[Catch: Exception -> 0x035c, TryCatch #0 {Exception -> 0x035c, blocks: (B:3:0x0009, B:5:0x0011, B:7:0x0017, B:9:0x006c, B:11:0x008d, B:12:0x009c, B:14:0x00a2, B:16:0x00ae, B:17:0x00b1, B:18:0x00b5, B:20:0x00bb, B:22:0x00cb, B:29:0x00f8, B:30:0x0115, B:32:0x011b, B:34:0x0127, B:36:0x012d, B:38:0x0139, B:42:0x0143, B:44:0x014d, B:46:0x015d, B:48:0x0171, B:60:0x01b1, B:62:0x01b7, B:64:0x01bd, B:66:0x01e5, B:68:0x01ec, B:70:0x01f2, B:75:0x020d, B:77:0x0211, B:79:0x0218, B:81:0x0220, B:84:0x022c, B:86:0x0232, B:89:0x0242, B:91:0x0248, B:93:0x024e, B:96:0x027d, B:98:0x02a4, B:100:0x02b2, B:102:0x02b6, B:104:0x02bc, B:106:0x02e3, B:49:0x0184, B:51:0x0190, B:53:0x0194, B:55:0x01a2, B:57:0x01a6, B:25:0x00e1, B:108:0x0302, B:111:0x0325, B:113:0x0334, B:114:0x0347, B:10:0x007d), top: B:119:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x020d A[Catch: Exception -> 0x035c, TryCatch #0 {Exception -> 0x035c, blocks: (B:3:0x0009, B:5:0x0011, B:7:0x0017, B:9:0x006c, B:11:0x008d, B:12:0x009c, B:14:0x00a2, B:16:0x00ae, B:17:0x00b1, B:18:0x00b5, B:20:0x00bb, B:22:0x00cb, B:29:0x00f8, B:30:0x0115, B:32:0x011b, B:34:0x0127, B:36:0x012d, B:38:0x0139, B:42:0x0143, B:44:0x014d, B:46:0x015d, B:48:0x0171, B:60:0x01b1, B:62:0x01b7, B:64:0x01bd, B:66:0x01e5, B:68:0x01ec, B:70:0x01f2, B:75:0x020d, B:77:0x0211, B:79:0x0218, B:81:0x0220, B:84:0x022c, B:86:0x0232, B:89:0x0242, B:91:0x0248, B:93:0x024e, B:96:0x027d, B:98:0x02a4, B:100:0x02b2, B:102:0x02b6, B:104:0x02bc, B:106:0x02e3, B:49:0x0184, B:51:0x0190, B:53:0x0194, B:55:0x01a2, B:57:0x01a6, B:25:0x00e1, B:108:0x0302, B:111:0x0325, B:113:0x0334, B:114:0x0347, B:10:0x007d), top: B:119:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0232 A[Catch: Exception -> 0x035c, TryCatch #0 {Exception -> 0x035c, blocks: (B:3:0x0009, B:5:0x0011, B:7:0x0017, B:9:0x006c, B:11:0x008d, B:12:0x009c, B:14:0x00a2, B:16:0x00ae, B:17:0x00b1, B:18:0x00b5, B:20:0x00bb, B:22:0x00cb, B:29:0x00f8, B:30:0x0115, B:32:0x011b, B:34:0x0127, B:36:0x012d, B:38:0x0139, B:42:0x0143, B:44:0x014d, B:46:0x015d, B:48:0x0171, B:60:0x01b1, B:62:0x01b7, B:64:0x01bd, B:66:0x01e5, B:68:0x01ec, B:70:0x01f2, B:75:0x020d, B:77:0x0211, B:79:0x0218, B:81:0x0220, B:84:0x022c, B:86:0x0232, B:89:0x0242, B:91:0x0248, B:93:0x024e, B:96:0x027d, B:98:0x02a4, B:100:0x02b2, B:102:0x02b6, B:104:0x02bc, B:106:0x02e3, B:49:0x0184, B:51:0x0190, B:53:0x0194, B:55:0x01a2, B:57:0x01a6, B:25:0x00e1, B:108:0x0302, B:111:0x0325, B:113:0x0334, B:114:0x0347, B:10:0x007d), top: B:119:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x027d A[Catch: Exception -> 0x035c, TryCatch #0 {Exception -> 0x035c, blocks: (B:3:0x0009, B:5:0x0011, B:7:0x0017, B:9:0x006c, B:11:0x008d, B:12:0x009c, B:14:0x00a2, B:16:0x00ae, B:17:0x00b1, B:18:0x00b5, B:20:0x00bb, B:22:0x00cb, B:29:0x00f8, B:30:0x0115, B:32:0x011b, B:34:0x0127, B:36:0x012d, B:38:0x0139, B:42:0x0143, B:44:0x014d, B:46:0x015d, B:48:0x0171, B:60:0x01b1, B:62:0x01b7, B:64:0x01bd, B:66:0x01e5, B:68:0x01ec, B:70:0x01f2, B:75:0x020d, B:77:0x0211, B:79:0x0218, B:81:0x0220, B:84:0x022c, B:86:0x0232, B:89:0x0242, B:91:0x0248, B:93:0x024e, B:96:0x027d, B:98:0x02a4, B:100:0x02b2, B:102:0x02b6, B:104:0x02bc, B:106:0x02e3, B:49:0x0184, B:51:0x0190, B:53:0x0194, B:55:0x01a2, B:57:0x01a6, B:25:0x00e1, B:108:0x0302, B:111:0x0325, B:113:0x0334, B:114:0x0347, B:10:0x007d), top: B:119:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.ArrayList<com.scores365.Design.PageObjects.b> j2(com.scores365.gameCenter.i0.h r34) {
        /*
            Method dump skipped, instructions count: 865
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.i0.j2(com.scores365.gameCenter.i0$h):java.util.ArrayList");
    }

    private void l3(LinkedHashMap<Integer, LinkedHashMap<String, ArrayList<EventObj>>> linkedHashMap, int i10) {
        int i11;
        try {
            EventObj[] events = this.f23905f.getEvents();
            if (events != null) {
                Arrays.sort(events, new Comparator() { // from class: com.scores365.gameCenter.e0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int f32;
                        f32 = i0.f3((EventObj) obj, (EventObj) obj2);
                        return f32;
                    }
                });
                B0 = events.length;
                for (EventObj eventObj : events) {
                    StatusObj statusObj = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStatuses().get(Integer.valueOf(eventObj.statusId));
                    Iterator<StageObj> it = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStages().values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            i11 = -1;
                            break;
                        }
                        int id2 = it.next().getID();
                        i11 = statusObj.scoreStage;
                        if (id2 == i11) {
                            break;
                        }
                    }
                    if (statusObj != null && statusObj.hasEvents) {
                        if (!linkedHashMap.containsKey(Integer.valueOf(i11))) {
                            linkedHashMap.put(Integer.valueOf(i11), new LinkedHashMap<>());
                        }
                        if (i10 == 2 || App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getEventByIndex(eventObj.getType()).Major) {
                            if (!linkedHashMap.get(Integer.valueOf(i11)).containsKey(eventObj.getGameTimeToDisplay())) {
                                linkedHashMap.get(Integer.valueOf(i11)).put(eventObj.getGameTimeToDisplay(), new ArrayList<>());
                            }
                            linkedHashMap.get(Integer.valueOf(i11)).get(eventObj.getGameTimeToDisplay()).add(eventObj);
                        }
                    }
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> m0() {
        ArrayList<com.scores365.Design.PageObjects.b> S1;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        GameObj gameObj = this.f23905f;
        if (gameObj.showStatsCard && gameObj.getStatistics() != null && (S1 = S1(true, null, false, null, this.f23905f.getStatistics())) != null && !S1.isEmpty()) {
            arrayList.add(new ag.d0(li.p0.l0("STATS_TAB_TITLE")));
            arrayList.addAll(S1);
            arrayList.add(new f1(this.f23939w, bg.e.STATISTICS, bg.d.MATCH, li.p0.l0("GC_SEE_ALL")));
        }
        return arrayList;
    }

    private ArrayList<com.scores365.Design.PageObjects.b> p0(TreeMap<Integer, TreeMap<Integer, TreeMap<Integer, LinkedHashMap<Integer, ArrayList<Object>>>>> treeMap) {
        boolean z10;
        boolean z11;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        boolean z12 = false;
        int i10 = 1;
        try {
            try {
                if (this.f23905f.getScores() != null) {
                    ScoreObj[] scores = this.f23905f.getScores();
                    int i11 = 0;
                    for (StageObj stageObj : App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStages().values()) {
                        if (i11 > 0 && !treeMap.containsKey(Integer.valueOf(stageObj.getID()))) {
                            int i12 = i11 * 2;
                            boolean z13 = scores[i12].getScore() > -1 && scores[i12 + 1].getScore() > -1;
                            Iterator<StatusObj> it = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStatuses().values().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z11 = false;
                                    break;
                                }
                                StatusObj next = it.next();
                                if (next.scoreStage == stageObj.getID() && this.f23905f.getStID() == next.getID()) {
                                    z11 = true;
                                    break;
                                }
                            }
                            if (z11 || z13) {
                                treeMap.put(Integer.valueOf(stageObj.getID()), new TreeMap<>());
                            }
                        }
                        i11++;
                    }
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
            boolean z14 = false;
            for (Integer num : treeMap.keySet()) {
                if (this.f23905f.isStageHasScores(num.intValue())) {
                    arrayList.add(z(num.intValue(), z12, !z14));
                    z10 = true;
                } else {
                    z10 = z14;
                }
                for (Integer num2 : treeMap.get(num).keySet()) {
                    for (Integer num3 : treeMap.get(num).get(num2).keySet()) {
                        int size = treeMap.get(num).get(num2).get(num3).containsKey(Integer.valueOf(i10)) ? treeMap.get(num).get(num2).get(num3).get(Integer.valueOf(i10)).size() : 0;
                        int size2 = treeMap.get(num).get(num2).get(num3).containsKey(2) ? treeMap.get(num).get(num2).get(num3).get(2).size() : 0;
                        if (size + size2 > i10) {
                            try {
                                int max = Math.max(size, size2);
                                Object obj = treeMap.get(num).get(num2).get(num3).containsKey(Integer.valueOf(i10)) ? treeMap.get(num).get(num2).get(num3).get(Integer.valueOf(i10)).get(z12 ? 1 : 0) : treeMap.get(num).get(num2).get(num3).get(2).get(z12 ? 1 : 0);
                                arrayList.addAll(q0(max, obj instanceof EventObj ? ((EventObj) obj).getGameTime() : num2.intValue(), treeMap.get(num).get(num2).get(num3).get(Integer.valueOf(i10)), treeMap.get(num).get(num2).get(num3).get(2)));
                            } catch (Exception e11) {
                                li.x0.N1(e11);
                            }
                        } else {
                            for (Integer num4 : treeMap.get(num).get(num2).get(num3).keySet()) {
                                if (!treeMap.get(num).get(num2).get(num3).get(num4).isEmpty()) {
                                    Object obj2 = treeMap.get(num).get(num2).get(num3).get(num4).get(0);
                                    int gameTime = obj2 instanceof EventObj ? ((EventObj) obj2).getGameTime() : num2.intValue();
                                    Object obj3 = num4.intValue() == i10 ? obj2 : null;
                                    if (num4.intValue() != 2) {
                                        obj2 = null;
                                    }
                                    arrayList.add(B(obj3, obj2, g.e.none, gameTime));
                                }
                                i10 = 1;
                            }
                        }
                        z12 = false;
                        i10 = 1;
                    }
                }
                z14 = z10;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<com.scores365.Design.PageObjects.b> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.scores365.Design.PageObjects.b next2 = it2.next();
                if (next2 instanceof ag.g) {
                    ag.g gVar = (ag.g) next2;
                    if (!linkedHashMap.containsKey(Integer.valueOf(gVar.f554c))) {
                        linkedHashMap.put(Integer.valueOf(gVar.f554c), new LinkedHashMap());
                    }
                    if (!((LinkedHashMap) linkedHashMap.get(Integer.valueOf(gVar.f554c))).containsKey(Integer.valueOf(gVar.f559h))) {
                        ((LinkedHashMap) linkedHashMap.get(Integer.valueOf(gVar.f554c))).put(Integer.valueOf(gVar.f559h), new ArrayList());
                    }
                    ((ArrayList) ((LinkedHashMap) linkedHashMap.get(Integer.valueOf(gVar.f554c))).get(Integer.valueOf(gVar.f559h))).add(gVar);
                }
            }
            for (Integer num5 : linkedHashMap.keySet()) {
                for (Integer num6 : ((LinkedHashMap) linkedHashMap.get(num5)).keySet()) {
                    if (((ArrayList) ((LinkedHashMap) linkedHashMap.get(num5)).get(num6)).size() > 1) {
                        Iterator it3 = ((ArrayList) ((LinkedHashMap) linkedHashMap.get(num5)).get(num6)).iterator();
                        int i13 = 0;
                        while (it3.hasNext()) {
                            ag.g gVar2 = (ag.g) it3.next();
                            if (i13 == 0) {
                                gVar2.f557f = g.e.first;
                            } else if (((ArrayList) ((LinkedHashMap) linkedHashMap.get(num5)).get(num6)).size() - 1 == i13) {
                                gVar2.f557f = g.e.last;
                            } else {
                                gVar2.f557f = g.e.middle;
                            }
                            i13++;
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                arrayList.add(new ag.e());
            }
        } catch (Exception e12) {
            li.x0.N1(e12);
        }
        return arrayList;
    }

    private ArrayList<com.scores365.Design.PageObjects.b> q0(int i10, int i11, ArrayList<Object> arrayList, ArrayList<Object> arrayList2) {
        Object obj;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList3 = new ArrayList<>();
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = (i10 - i12) - 1;
            Object obj2 = null;
            if (arrayList != null) {
                try {
                    if (i13 < arrayList.size()) {
                        obj = arrayList.get(i13);
                        if (arrayList2 != null && i13 < arrayList2.size()) {
                            obj2 = arrayList2.get(i13);
                        }
                        arrayList3.add(B(obj, obj2, g.e.none, i11));
                    }
                } catch (Exception e10) {
                    li.x0.N1(e10);
                }
            }
            obj = null;
            if (arrayList2 != null) {
                obj2 = arrayList2.get(i13);
            }
            arrayList3.add(B(obj, obj2, g.e.none, i11));
        }
        if (this.f23905f.shouldShowEventsOrderFromBottom()) {
            Collections.reverse(arrayList3);
        }
        return arrayList3;
    }

    private String q1(VideoObj videoObj) {
        EventObj[] events;
        try {
            if (this.f23905f.getEvents() == null || this.f23905f.getEvents().length <= 0) {
                return "";
            }
            for (EventObj eventObj : this.f23905f.getEvents()) {
                if (videoObj.eventNum == eventObj.getNum() && eventObj.getType() == videoObj.eventType) {
                    return eventObj.getPlayer();
                }
            }
            return "";
        } catch (Exception e10) {
            li.x0.N1(e10);
            return "";
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> r0(int i10) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            TreeMap<Integer, TreeMap<Integer, TreeMap<Integer, LinkedHashMap<Integer, ArrayList<Object>>>>> treeMap = new TreeMap<>(this.f23905f.shouldShowEventsOrderFromBottom() ? null : Collections.reverseOrder());
            L3(treeMap, i10);
            if (i10 == 2) {
                M3(treeMap);
            }
            for (Integer num : treeMap.keySet()) {
                for (Integer num2 : treeMap.get(num).keySet()) {
                    for (Integer num3 : treeMap.get(num).get(num2).keySet()) {
                        for (Integer num4 : treeMap.get(num).get(num2).get(num3).keySet()) {
                            B0 += treeMap.get(num).get(num2).get(num3).get(num4).size();
                            Collections.sort(treeMap.get(num).get(num2).get(num3).get(num4), new Comparator() { // from class: com.scores365.gameCenter.d0
                                @Override // java.util.Comparator
                                public final int compare(Object obj, Object obj2) {
                                    int V2;
                                    V2 = i0.V2(obj, obj2);
                                    return V2;
                                }
                            });
                        }
                    }
                }
            }
            return p0(treeMap);
        } catch (Exception e10) {
            li.x0.N1(e10);
            return arrayList;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:3|4|(6:(23:9|10|11|12|(1:14)(2:56|(1:58)(4:59|60|(3:62|(1:64)|65)(2:67|(1:69))|66))|15|16|(1:18)(1:55)|19|(13:24|(11:29|30|(1:32)(1:52)|33|(6:38|39|40|41|42|43)|51|39|40|41|42|43)|53|30|(0)(0)|33|(7:35|38|39|40|41|42|43)|51|39|40|41|42|43)|54|(12:26|29|30|(0)(0)|33|(0)|51|39|40|41|42|43)|53|30|(0)(0)|33|(0)|51|39|40|41|42|43)|(14:21|24|(0)|53|30|(0)(0)|33|(0)|51|39|40|41|42|43)|40|41|42|43)|72|10|11|12|(0)(0)|15|16|(0)(0)|19|54|(0)|53|30|(0)(0)|33|(0)|51|39) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ef, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f0, code lost:
        li.x0.N1(r0);
        r7 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007d A[Catch: Exception -> 0x00ef, TryCatch #0 {Exception -> 0x00ef, blocks: (B:12:0x0077, B:14:0x007d, B:15:0x0084, B:17:0x008a, B:18:0x0091, B:21:0x009e, B:23:0x00a4, B:24:0x00b3, B:28:0x00e9, B:25:0x00c1, B:27:0x00da), top: B:68:0x0077, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0084 A[Catch: Exception -> 0x00ef, TryCatch #0 {Exception -> 0x00ef, blocks: (B:12:0x0077, B:14:0x007d, B:15:0x0084, B:17:0x008a, B:18:0x0091, B:21:0x009e, B:23:0x00a4, B:24:0x00b3, B:28:0x00e9, B:25:0x00c1, B:27:0x00da), top: B:68:0x0077, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fe A[Catch: Exception -> 0x0212, TryCatch #2 {Exception -> 0x0212, blocks: (B:4:0x000c, B:6:0x0053, B:11:0x0065, B:32:0x00f4, B:34:0x00fe, B:36:0x0107, B:38:0x0121, B:44:0x0138, B:49:0x0149, B:51:0x0190, B:53:0x01ec, B:55:0x01f0, B:60:0x01fa, B:48:0x0142, B:42:0x012b, B:35:0x0103, B:31:0x00f0, B:10:0x005b, B:12:0x0077, B:14:0x007d, B:15:0x0084, B:17:0x008a, B:18:0x0091, B:21:0x009e, B:23:0x00a4, B:24:0x00b3, B:28:0x00e9, B:25:0x00c1, B:27:0x00da), top: B:71:0x000c, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0103 A[Catch: Exception -> 0x0212, TryCatch #2 {Exception -> 0x0212, blocks: (B:4:0x000c, B:6:0x0053, B:11:0x0065, B:32:0x00f4, B:34:0x00fe, B:36:0x0107, B:38:0x0121, B:44:0x0138, B:49:0x0149, B:51:0x0190, B:53:0x01ec, B:55:0x01f0, B:60:0x01fa, B:48:0x0142, B:42:0x012b, B:35:0x0103, B:31:0x00f0, B:10:0x005b, B:12:0x0077, B:14:0x007d, B:15:0x0084, B:17:0x008a, B:18:0x0091, B:21:0x009e, B:23:0x00a4, B:24:0x00b3, B:28:0x00e9, B:25:0x00c1, B:27:0x00da), top: B:71:0x000c, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0138 A[Catch: Exception -> 0x0212, TryCatch #2 {Exception -> 0x0212, blocks: (B:4:0x000c, B:6:0x0053, B:11:0x0065, B:32:0x00f4, B:34:0x00fe, B:36:0x0107, B:38:0x0121, B:44:0x0138, B:49:0x0149, B:51:0x0190, B:53:0x01ec, B:55:0x01f0, B:60:0x01fa, B:48:0x0142, B:42:0x012b, B:35:0x0103, B:31:0x00f0, B:10:0x005b, B:12:0x0077, B:14:0x007d, B:15:0x0084, B:17:0x008a, B:18:0x0091, B:21:0x009e, B:23:0x00a4, B:24:0x00b3, B:28:0x00e9, B:25:0x00c1, B:27:0x00da), top: B:71:0x000c, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0190 A[Catch: Exception -> 0x0212, TryCatch #2 {Exception -> 0x0212, blocks: (B:4:0x000c, B:6:0x0053, B:11:0x0065, B:32:0x00f4, B:34:0x00fe, B:36:0x0107, B:38:0x0121, B:44:0x0138, B:49:0x0149, B:51:0x0190, B:53:0x01ec, B:55:0x01f0, B:60:0x01fa, B:48:0x0142, B:42:0x012b, B:35:0x0103, B:31:0x00f0, B:10:0x005b, B:12:0x0077, B:14:0x007d, B:15:0x0084, B:17:0x008a, B:18:0x0091, B:21:0x009e, B:23:0x00a4, B:24:0x00b3, B:28:0x00e9, B:25:0x00c1, B:27:0x00da), top: B:71:0x000c, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f0 A[Catch: Exception -> 0x0212, TryCatch #2 {Exception -> 0x0212, blocks: (B:4:0x000c, B:6:0x0053, B:11:0x0065, B:32:0x00f4, B:34:0x00fe, B:36:0x0107, B:38:0x0121, B:44:0x0138, B:49:0x0149, B:51:0x0190, B:53:0x01ec, B:55:0x01f0, B:60:0x01fa, B:48:0x0142, B:42:0x012b, B:35:0x0103, B:31:0x00f0, B:10:0x005b, B:12:0x0077, B:14:0x007d, B:15:0x0084, B:17:0x008a, B:18:0x0091, B:21:0x009e, B:23:0x00a4, B:24:0x00b3, B:28:0x00e9, B:25:0x00c1, B:27:0x00da), top: B:71:0x000c, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.scores365.entitys.ScoreBoxObjects.ScoreBoxRowHelperObject r1(com.scores365.entitys.PlayerObj r28, int r29, boolean r30, boolean r31, com.scores365.gameCenter.d1 r32) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.i0.r1(com.scores365.entitys.PlayerObj, int, boolean, boolean, com.scores365.gameCenter.d1):com.scores365.entitys.ScoreBoxObjects.ScoreBoxRowHelperObject");
    }

    private ArrayList<com.scores365.Design.PageObjects.b> r2(h hVar) {
        boolean z10;
        boolean z11;
        BookmakerDisclaimer bookmakerDisclaimer;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            if (li.x0.s2()) {
                if (li.x0.s2()) {
                    z10 = this.f23905f.getIsActive();
                    z11 = this.f23905f.isNotStarted() && !this.f23905f.hasTips();
                } else {
                    z10 = false;
                    z11 = false;
                }
                if (z10 || z11) {
                    Iterator<TvNetworkObj> it = this.f23905f.TvNetworks.iterator();
                    while (it.hasNext()) {
                        TvNetworkObj next = it.next();
                        if (next.bookmaker > 0) {
                            String lineLink = next.getTvLinks().get(0).getLineLink();
                            if (this.F == null) {
                                Boolean valueOf = Boolean.valueOf(next.bookmaker == 14 && !next.hideLogo);
                                this.F = valueOf;
                                this.f23899a = 1;
                                if (valueOf.booleanValue()) {
                                    this.f23899a = 2;
                                } else {
                                    this.f23899a = 3;
                                }
                            }
                            LinkedHashMap<Integer, BookMakerObj> linkedHashMap = this.f23915k.bookMakerObjs;
                            BookMakerObj bookMakerObj = (linkedHashMap == null || linkedHashMap.isEmpty()) ? null : this.f23915k.bookMakerObjs.get(Integer.valueOf(this.f23905f.getTopBookMaker()));
                            if (hVar != null && bookMakerObj != null && (bookmakerDisclaimer = bookMakerObj.disclaimer) != null && !bookmakerDisclaimer.getUrl().isEmpty() && !bookMakerObj.disclaimer.getText().isEmpty()) {
                                try {
                                    hVar.e(true);
                                    hVar.f(bookMakerObj);
                                } catch (Exception e10) {
                                    li.x0.N1(e10);
                                }
                            }
                            if (this.C) {
                                if (this.F.booleanValue()) {
                                    arrayList.add(new ag.f0(next.bookmaker, lineLink, this.f23905f, this.C, this.f23899a, z11));
                                } else {
                                    arrayList.add(new ag.g0(next.bookmaker, lineLink, this.f23905f, this.C, this.f23899a, bookMakerObj, z11));
                                }
                                this.C = false;
                            } else if (this.F.booleanValue()) {
                                arrayList.add(new ag.f0(next.bookmaker, lineLink, this.f23905f, this.C, this.f23899a, z11));
                            } else {
                                arrayList.add(new ag.g0(next.bookmaker, lineLink, this.f23905f, this.C, this.f23899a, bookMakerObj, z11));
                            }
                        }
                    }
                }
            }
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
        return arrayList;
    }

    private int s0() {
        int i10 = -1;
        try {
            if (C0() != null && C0().getTopBookMaker() != -1) {
                i10 = C0().getTopBookMaker();
            } else if (C0() != null && C0().getMainOddsObj() != null) {
                i10 = C0().getMainOddsObj().bookmakerId;
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return i10;
    }

    private PlayerObj[] s1(a.EnumC0251a enumC0251a) {
        PlayerObj[] players;
        try {
            if (enumC0251a == a.EnumC0251a.HOME) {
                players = this.f23905f.getLineUps()[0].getPlayers();
            } else if (enumC0251a != a.EnumC0251a.AWAY) {
                return null;
            } else {
                players = this.f23905f.getLineUps()[1].getPlayers();
            }
            return players;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public static eCompetitorTrend s2(GameObj gameObj, int i10) {
        eCompetitorTrend ecompetitortrend = eCompetitorTrend.NONE;
        try {
            return eCompetitorTrend.create((gameObj.getComps()[0].getID() == i10 ? gameObj.getComps()[0] : gameObj.getComps()[1]).getOutcome());
        } catch (Exception e10) {
            li.x0.N1(e10);
            return ecompetitortrend;
        }
    }

    private com.scores365.Design.PageObjects.b t0() {
        ArrayList<PlayerObj> arrayList;
        try {
            ArrayList arrayList2 = new ArrayList();
            GamesObj gamesObj = this.f23915k;
            if (gamesObj != null && gamesObj.getNetworks() != null) {
                Iterator<TvNetworkObj> it = this.f23915k.getNetworks().iterator();
                while (it.hasNext()) {
                    TvNetworkObj next = it.next();
                    if (next.bookmaker <= 0 && !next.isStoryNetworkId()) {
                        arrayList2.add(next);
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                GameObj gameObj = this.f23905f;
                if (gameObj.venueObj == null && ((arrayList = gameObj.officialsList) == null || arrayList.isEmpty())) {
                    return null;
                }
            }
            return this.f23915k != null ? new xf.i(this.f23905f, this.f23915k.getCountries(), O0(), arrayList2, H1(this.f23905f)) : new xf.i(this.f23905f, null, O0(), null, H1(this.f23905f));
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    private c.EnumC0252c t2(int i10) {
        EventObj[] events;
        c.EnumC0252c enumC0252c = c.EnumC0252c.NONE;
        try {
            if (this.f23905f.getEvents() != null) {
                for (EventObj eventObj : this.f23905f.getEvents()) {
                    if (eventObj.getType() == 2 && i10 == eventObj.PId) {
                        enumC0252c = c.EnumC0252c.RED;
                        if (eventObj.getSubType() != -1) {
                            enumC0252c = c.EnumC0252c.SECOND_YELLOW;
                        }
                    }
                    if (eventObj.getType() == 1 && i10 == eventObj.PId) {
                        enumC0252c = c.EnumC0252c.YELLOW;
                    }
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return enumC0252c;
    }

    private com.scores365.Design.PageObjects.b u0(int i10) {
        int i11;
        int i12;
        int i13;
        try {
            int id2 = this.f23905f.getComps()[0].getID();
            int id3 = this.f23905f.getComps()[1].getID();
            try {
                Iterator<GameObj> it = this.f23905f.lastMatchesList.iterator();
                int i14 = i10;
                i11 = 0;
                i12 = 0;
                i13 = 0;
                while (it.hasNext()) {
                    try {
                        GameObj next = it.next();
                        if (i14 <= 0) {
                            break;
                        }
                        i14--;
                        int winner = next.getWinner();
                        if (winner == -1 || winner == 0) {
                            i11++;
                        } else if (winner != 1) {
                            if (winner == 2) {
                                if (next.getComps()[1].getID() == id3) {
                                    i13++;
                                } else {
                                    i12++;
                                }
                            }
                        } else if (next.getComps()[0].getID() == id2) {
                            i12++;
                        } else {
                            i13++;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        li.x0.N1(e);
                        return new ag.s(i12, i11, i13, id2, id3, this.f23905f.getSportID(), this.f23905f.getComps()[0].getImgVer(), this.f23905f.getComps()[1].getImgVer(), this.f23905f.getComps()[0].getCountryID(), this.f23905f.getComps()[1].getCountryID(), this.f23905f.homeAwayTeamOrder);
                    }
                }
            } catch (Exception e11) {
                e = e11;
                i11 = 0;
                i12 = 0;
                i13 = 0;
            }
            return new ag.s(i12, i11, i13, id2, id3, this.f23905f.getSportID(), this.f23905f.getComps()[0].getImgVer(), this.f23905f.getComps()[1].getImgVer(), this.f23905f.getComps()[0].getCountryID(), this.f23905f.getComps()[1].getCountryID(), this.f23905f.homeAwayTeamOrder);
        } catch (Exception e12) {
            li.x0.N1(e12);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x010f A[Catch: Exception -> 0x017c, TryCatch #0 {Exception -> 0x017c, blocks: (B:3:0x0007, B:4:0x000f, B:6:0x0015, B:8:0x005e, B:10:0x0071, B:12:0x007b, B:14:0x007e, B:16:0x0084, B:17:0x00e7, B:21:0x010f, B:22:0x0175), top: B:27:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.ArrayList<android.widget.TableRow> u1(java.util.LinkedHashMap<java.lang.Integer, java.util.ArrayList<com.scores365.entitys.ScoreBoxObjects.ScoreBoxValueObj>> r18, java.util.LinkedHashMap<java.lang.Integer, com.scores365.entitys.PlayerObj> r19, com.scores365.entitys.ScoreBoxObjects.ScoreBoxTablesObj r20) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.i0.u1(java.util.LinkedHashMap, java.util.LinkedHashMap, com.scores365.entitys.ScoreBoxObjects.ScoreBoxTablesObj):java.util.ArrayList");
    }

    private void u2() {
        for (int i10 = 0; i10 < this.f23920m0.size(); i10++) {
            int intValue = this.f23918l0.get(i10).intValue();
            Iterator<TextView> it = this.f23920m0.get(i10).iterator();
            while (it.hasNext()) {
                it.next().getLayoutParams().width = (f23896x0 * 2) + intValue + li.p0.s(1);
            }
        }
    }

    private void w3(LinkedHashMap<Integer, LinkedHashMap<Integer, ArrayList<EventObj>>> linkedHashMap) {
        int i10;
        try {
            if (this.f23905f.getEvents() != null) {
                ArrayList arrayList = new ArrayList(Arrays.asList(this.f23905f.getEvents()));
                Collections.sort(arrayList, Comparator$CC.comparingInt(new ToIntFunction() { // from class: com.scores365.gameCenter.w
                    @Override // j$.util.function.ToIntFunction
                    public final int applyAsInt(Object obj) {
                        int i11;
                        i11 = ((EventObj) obj).eventOrder;
                        return i11;
                    }
                }));
                B0 = arrayList.size();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    EventObj eventObj = (EventObj) it.next();
                    StatusObj statusObj = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStatuses().get(Integer.valueOf(eventObj.statusId));
                    Iterator<StageObj> it2 = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStages().values().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            i10 = -1;
                            break;
                        }
                        StageObj next = it2.next();
                        if (statusObj != null) {
                            int id2 = next.getID();
                            i10 = statusObj.scoreStage;
                            if (id2 == i10) {
                                break;
                            }
                        }
                    }
                    if (statusObj != null && statusObj.hasEvents) {
                        if (linkedHashMap.containsKey(-1)) {
                            y3(i10, eventObj, linkedHashMap.get(-1));
                        } else {
                            int[] filterIds = eventObj.getFilterIds();
                            if (filterIds != null) {
                                for (int i11 : filterIds) {
                                    y3(i10, eventObj, linkedHashMap.get(Integer.valueOf(i11)));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(k kVar, int i10, Handler handler, int i11) {
        try {
            com.scores365.api.h hVar = new com.scores365.api.h(App.m(), sf.a.i0(App.m()).k0(), sf.a.i0(App.m()).G0(), String.valueOf(i10), String.valueOf(sf.a.i0(App.m()).j0()), i11, s0());
            int i12 = this.f23929r;
            if (i12 != -1) {
                hVar.b(i12);
            }
            hVar.c(true);
            hVar.call();
            GamesObj a10 = hVar.a();
            this.f23915k = a10;
            this.f23905f = a10.getGames().get(Integer.valueOf(i10));
            this.f23927q = this.f23915k.getRadioNetworks();
            int gameMinutes = this.f23905f.getGameMinutes();
            GameObj gameObj = this.f23905f;
            double preciseGameTimeField = gameObj.getPreciseGameTimeField();
            GameObj gameObj2 = this.f23905f;
            gameObj.setPreciseGameTime(preciseGameTimeField, gameMinutes, gameObj2.getGameSeconds(gameObj2.getPreciseGameTimeField()));
            this.f23905f.setGT(gameMinutes);
            this.f23911i = hVar.a().getCompetitions();
            this.f23909h = hVar.a().getCompetitions().get(Integer.valueOf(this.f23905f.getCompetitionID()));
            this.f23919m = true;
            D0 = this.f23905f.getTopBookMaker();
            com.scores365.services.b bVar = this.f23913j;
            if (bVar != null) {
                bVar.setTopBookmaker(this.f23905f.getTopBookMaker());
            }
            if (this.f23905f.isShowPlayByPlay() || this.f23905f.hasMatchFacts) {
                this.H = new r0(this.f23905f.getPlayByPlayPreviewURL(), this.f23905f);
                this.I = new q0(this.f23905f.getPlayByPlayFeedURL(), this.f23905f);
            }
            try {
                TableObj tableObj = this.f23905f.detailTableObj;
                if (tableObj != null) {
                    this.f23909h.tableObj = tableObj;
                    hVar.a().getCompetitions().get(Integer.valueOf(this.f23905f.getCompetitionID())).tableObj = this.f23905f.detailTableObj;
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
            sf.b.X1().m3(b.e.GameCenterVisitForLmtAd);
            if (handler != null) {
                handler.post(new p(this.f23905f, this.f23909h, kVar, this, this.f23915k));
            }
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> x1() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        GameObj gameObj = this.f23905f;
        if (gameObj != null && gameObj.postGamePitchers != null) {
            arrayList.add(new ie.d(this.f23905f));
        }
        return arrayList;
    }

    private void x2(n.a aVar) {
        HashMap<sc.f, gc.h> hashMap = this.f23906f0;
        sc.f fVar = sc.f.Branded_GC_Strip;
        hashMap.put(fVar, new gc.h(fVar, aVar));
        HashMap<sc.f, gc.h> hashMap2 = this.f23906f0;
        sc.f fVar2 = sc.f.Branded_Lineups_Strip;
        hashMap2.put(fVar2, new gc.h(fVar2, aVar));
        this.f23906f0.get(fVar).D(C0());
        this.f23906f0.get(fVar2).D(C0());
    }

    private void y(LinkedHashMap<Integer, LinkedHashMap<Integer, ArrayList<EventObj>>> linkedHashMap) {
        ScoreObj[] scores = this.f23905f.getScores();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        EventFilterObj[] eventFilters = this.f23905f.getEventFilters();
        if (eventFilters != null) {
            for (EventFilterObj eventFilterObj : eventFilters) {
                linkedHashMap.put(Integer.valueOf(eventFilterObj.getId()), new LinkedHashMap<>());
            }
        } else {
            linkedHashMap.put(-1, new LinkedHashMap<>());
        }
        boolean z10 = false;
        for (Integer num : linkedHashMap.keySet()) {
            int i10 = 0;
            for (StageObj stageObj : App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStages().values()) {
                if (i10 > 0) {
                    int i11 = i10 * 2;
                    if (scores[i11].getScore() > -1 && scores[i11 + 1].getScore() > -1) {
                        if (linkedHashMap.get(num).containsKey(Integer.valueOf(stageObj.getID()))) {
                            LinkedHashMap<Integer, ArrayList<EventObj>> linkedHashMap3 = linkedHashMap.get(num);
                            linkedHashMap3.put(Integer.valueOf(stageObj.getID()), linkedHashMap3.get(Integer.valueOf(stageObj.getID())));
                            linkedHashMap2.put(num, linkedHashMap3);
                        } else {
                            LinkedHashMap<Integer, ArrayList<EventObj>> linkedHashMap4 = linkedHashMap.get(num);
                            linkedHashMap4.put(Integer.valueOf(stageObj.getID()), new ArrayList<>());
                            linkedHashMap2.put(num, linkedHashMap4);
                            z10 = true;
                        }
                    }
                }
                i10++;
            }
        }
        if (z10) {
            linkedHashMap.clear();
            linkedHashMap.putAll(linkedHashMap2);
        }
    }

    private com.scores365.Design.PageObjects.b z(int i10, boolean z10, boolean z11) {
        int i11;
        yf.b bVar;
        int i12;
        yf.b bVar2 = null;
        try {
            String str = "";
            LinkedHashMap<Integer, StageObj> stages = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStages();
            Iterator<StageObj> it = stages.values().iterator();
            int i13 = 0;
            while (it.hasNext() && i10 != it.next().getID()) {
                i13 += 2;
            }
            if (li.x0.l(this.f23905f.homeAwayTeamOrder, true)) {
                if (this.f23905f.getScores()[i13 + 1].getScore() > -1 && this.f23905f.getScores()[i13].getScore() > -1) {
                    str = this.f23905f.getScores()[i12].getScore() + " - " + this.f23905f.getScores()[i13].getScore();
                }
            } else {
                if (this.f23905f.getScores()[i13 + 1].getScore() > -1 && this.f23905f.getScores()[i13].getScore() > -1) {
                    str = this.f23905f.getScores()[i13].getScore() + " - " + this.f23905f.getScores()[i11].getScore();
                }
            }
            Iterator<StageObj> it2 = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStages().values().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                StageObj next = it2.next();
                if (next.getID() == i10) {
                    if (!z10 && this.f23905f.getSportID() == 4) {
                        bVar = new yf.b(next.getName());
                        bVar2 = bVar;
                    }
                    bVar = new yf.b(next.getName(), str, z11);
                    bVar2 = bVar;
                }
            }
            return bVar2 == null ? new yf.b(stages.get(Integer.valueOf(i10)).getName(), str, z11) : bVar2;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return bVar2;
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> z0(StatusObj statusObj, int i10) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        B0 = 0;
        if (!statusObj.getIsNotStarted()) {
            if (this.f23905f.getSportID() == SportTypesEnum.SOCCER.getValue()) {
                ArrayList<com.scores365.Design.PageObjects.b> r02 = r0(i10);
                if (r02 != null && !r02.isEmpty()) {
                    arrayList.add(new ag.d0(li.p0.l0("SELECTIONS_MENU_NOTIFICATIONS_GAME_EVENTS")));
                }
                if (this.f23905f.eventsCategories > 1) {
                    arrayList.add(new ag.f(i10));
                }
                if (r02 != null && !r02.isEmpty()) {
                    arrayList.addAll(r02);
                }
            } else if (this.f23905f.getSportID() == SportTypesEnum.E_SPORT.getValue() && this.f23905f.getEvents() != null) {
                ArrayList arrayList2 = new ArrayList(Arrays.asList(this.f23905f.getEvents()));
                Collections.sort(arrayList2, new Comparator() { // from class: com.scores365.gameCenter.c0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int W2;
                        W2 = i0.W2((EventObj) obj, (EventObj) obj2);
                        return W2;
                    }
                });
                if (this.f23905f.shouldShowEventsOrderFromBottom()) {
                    Collections.reverse(arrayList2);
                }
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    EventObj eventObj = (EventObj) it.next();
                    arrayList.add(new ag.g(eventObj.getComp() == 1 ? eventObj : null, eventObj.getComp() == 2 ? eventObj : null, eventObj.getGameTime(), g.e.none, null, null, this.f23905f));
                }
                B0 = arrayList2.size();
                if (!arrayList.isEmpty()) {
                    arrayList.add(0, new ag.d0(li.p0.l0("SELECTIONS_MENU_NOTIFICATIONS_GAME_EVENTS")));
                }
                arrayList.add(new ag.e());
            } else if (this.f23905f.getSportID() == SportTypesEnum.HOCKEY.getValue()) {
                ArrayList<com.scores365.Design.PageObjects.b> L0 = L0();
                if (!L0.isEmpty()) {
                    arrayList.add(new ag.d0(li.p0.l0("SELECTIONS_MENU_NOTIFICATIONS_GAME_EVENTS")));
                    arrayList.addAll(L0);
                }
            } else if (this.f23905f.getSportID() == SportTypesEnum.AMERICAN_FOOTBALL.getValue()) {
                ArrayList<com.scores365.Design.PageObjects.b> S = S(i10);
                if (this.f23905f.eventsCategories > 1) {
                    arrayList.add(new ag.f(i10));
                }
                if (S != null && !S.isEmpty()) {
                    arrayList.addAll(S);
                }
            } else if (this.f23905f.getSportID() == SportTypesEnum.BASEBALL.getValue()) {
                ArrayList<com.scores365.Design.PageObjects.b> a10 = new ie.a(this.f23905f).a();
                if (!a10.isEmpty()) {
                    arrayList.add(new ag.d0(li.p0.l0("SCORING_SUMMARY_GAME_EVENTS")));
                    arrayList.addAll(a10);
                }
                if (this.f23905f.hasPlayByPlay) {
                    arrayList.add(new f1(this.f23939w, bg.e.PLAY_BY_PLAY, bg.d.MATCH, li.p0.l0("SEE_FULL_PBP")));
                }
            } else if (this.f23905f.getSportID() == SportTypesEnum.RUGBY.getValue()) {
                ArrayList<com.scores365.Design.PageObjects.b> J1 = J1(i10);
                if (this.f23905f.eventsCategories > 1) {
                    arrayList.add(new ag.f(i10));
                }
                if (J1 != null && !J1.isEmpty()) {
                    arrayList.addAll(J1);
                }
            }
        }
        return arrayList;
    }

    public static void z2(TextView textView) {
        try {
            if (li.x0.l1()) {
                textView.setPadding(0, 0, li.p0.s(6), li.p0.s(1));
                textView.setGravity(85);
            } else {
                textView.setPadding(li.p0.s(6), 0, 0, li.p0.s(1));
                textView.setGravity(83);
            }
            textView.setTextColor(li.p0.A(R.attr.f21565m1));
            textView.setTextSize(1, 12.0f);
            textView.setTypeface(li.o0.d(App.m()));
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public boolean A(ArrayList<com.scores365.Design.PageObjects.b> arrayList, int i10, Activity activity, StatusObj statusObj, @NonNull uc.d dVar) {
        boolean z10 = false;
        try {
            if (c1() != null) {
                e1 R = R(activity);
                int Q = Q(statusObj);
                if (Q == 2 || Q == 3 || F2()) {
                    xf.e eVar = new xf.e(dVar, R.getPlacement(), c1());
                    if (i10 > -1) {
                        arrayList.add(i10, eVar);
                    } else {
                        arrayList.add(eVar);
                    }
                    z10 = true;
                    if (Q == 2 && this.f23926p0 != null) {
                        activity.runOnUiThread(new q(R));
                    }
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return z10;
    }

    public int A0() {
        return this.f23903d;
    }

    public boolean A2(ArrayList<com.scores365.Design.PageObjects.b> arrayList) {
        try {
            Iterator<com.scores365.Design.PageObjects.b> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof le.k) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    public void A3(boolean z10) {
        this.B = z10;
    }

    public void B3(cc.s0 s0Var) {
        this.f23926p0 = s0Var;
    }

    public GameObj C0() {
        return this.f23905f;
    }

    public void C3(j jVar) {
        this.f23932s0 = jVar;
    }

    public void D3(b.InterfaceC0401b interfaceC0401b) {
        this.f23934t0 = interfaceC0401b;
    }

    public void E(ArrayList<com.scores365.Design.PageObjects.b> arrayList) {
        try {
            if (this.H.v()) {
                this.H.F(arrayList);
                if (this.H.H()) {
                    return;
                }
                this.H.J();
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public ArrayList<yf.e> E0(PlayerObj[] playerObjArr, int i10) {
        PlayerObj playerObj;
        ArrayList<yf.e> arrayList = new ArrayList<>();
        if (playerObjArr != null) {
            try {
                HashMap hashMap = new HashMap();
                for (PlayerObj playerObj2 : playerObjArr) {
                    hashMap.put(Integer.valueOf(playerObj2.playerNum), playerObj2);
                }
                for (PlayerObj playerObj3 : playerObjArr) {
                    if (playerObj3 != null && playerObj3.getSubtituteType() == 1 && (playerObj = (PlayerObj) hashMap.get(Integer.valueOf(playerObj3.getSubstitutedPlayer()))) != null) {
                        arrayList.add(new yf.e(playerObj3, playerObj, i10, playerObj.getPbpEventKey()));
                    }
                }
                Collections.sort(arrayList, new a());
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
        return arrayList;
    }

    public boolean E2() {
        try {
            if (li.p0.e0(App.m()) != ScreenSizeEnum.SMALL) {
                return this.f23905f.HasFieldPositions;
            }
            return false;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    public void E3(n nVar) {
        this.f23938v0 = nVar;
    }

    public boolean F2() {
        try {
            if (RemoveAdsManager.isUserAdsRemoved(App.m())) {
                return false;
            }
            return cc.o0.y().v("GC_SPONSORED_NATIVE").contains(Integer.valueOf(A0()));
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    public void F3(c1.b bVar) {
        this.f23936u0 = bVar;
    }

    public void G3(boolean z10) {
        this.W = z10;
    }

    public void J() {
        f23898z0 = -1;
        C0 = -1;
        B0 = -1;
        D0 = -1;
        A0 = -1;
        E0 = null;
        F0 = null;
        G0 = null;
    }

    public boolean J2() {
        return this.B;
    }

    public void J3(float f10) {
        this.f23901b0 = f10;
    }

    public void K() {
        try {
            LinkedHashMap<String, ScoreBoxTablesObj> linkedHashMap = this.f23931s;
            if (linkedHashMap != null) {
                linkedHashMap.clear();
            }
            LinkedHashMap<Integer, String> linkedHashMap2 = this.G;
            if (linkedHashMap2 != null) {
                linkedHashMap2.clear();
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public ArrayList<com.scores365.Design.PageObjects.b> K1(int i10, d1 d1Var, LastMatchGameItem.iScrollListener iscrolllistener) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            if (C0().getLineUps() != null) {
                arrayList.addAll(F(i10, d1Var, iscrolllistener));
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    public void K3(boolean z10) {
        this.T = z10;
    }

    public void L(ArrayList<com.scores365.Design.PageObjects.b> arrayList) {
        this.H.F(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000b A[Catch: Exception -> 0x001b, TryCatch #0 {Exception -> 0x001b, blocks: (B:3:0x0001, B:4:0x0005, B:6:0x000b, B:8:0x0015), top: B:14:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean L2(java.util.ArrayList<com.scores365.Design.PageObjects.b> r4) {
        /*
            r3 = this;
            r0 = 0
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Exception -> L1b
        L5:
            boolean r1 = r4.hasNext()     // Catch: java.lang.Exception -> L1b
            if (r1 == 0) goto L1f
            java.lang.Object r1 = r4.next()     // Catch: java.lang.Exception -> L1b
            com.scores365.Design.PageObjects.b r1 = (com.scores365.Design.PageObjects.b) r1     // Catch: java.lang.Exception -> L1b
            boolean r2 = r1 instanceof lf.d     // Catch: java.lang.Exception -> L1b
            if (r2 != 0) goto L19
            boolean r1 = r1 instanceof le.k     // Catch: java.lang.Exception -> L1b
            if (r1 == 0) goto L5
        L19:
            r0 = 1
            goto L1f
        L1b:
            r4 = move-exception
            li.x0.N1(r4)
        L1f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.i0.L2(java.util.ArrayList):boolean");
    }

    public void M() {
        com.scores365.services.b bVar = this.f23913j;
        if (bVar != null) {
            bVar.requestStop();
        }
        this.f23913j = null;
    }

    public int M0() {
        return this.P;
    }

    public boolean M2() {
        boolean z10;
        try {
            if (this.f23940w0 == null) {
                String D = cc.o0.y().D("GAME_DETAILS_MPU_RATIO", "");
                if (D != null && !D.isEmpty() && !D.equalsIgnoreCase("null")) {
                    if (li.x0.r1(D)) {
                        int parseInt = Integer.parseInt(D);
                        if (parseInt > 0) {
                            this.f23940w0 = Boolean.valueOf(li.x0.L1(Math.min(parseInt, 100.0f) / 100.0f));
                        } else {
                            this.f23940w0 = Boolean.FALSE;
                        }
                    } else {
                        this.f23940w0 = Boolean.FALSE;
                    }
                }
                if (!cc.o0.y().i("GAME_DETAILS_NATIVE_OVER_MPU")) {
                    z10 = true;
                    if (Q(this.f23905f.getStatusObj()) != 1) {
                        this.f23940w0 = Boolean.valueOf(z10);
                    }
                }
                z10 = false;
                this.f23940w0 = Boolean.valueOf(z10);
            }
            return this.f23940w0.booleanValue();
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    public void N(LinearLayout linearLayout, LinkedHashMap<Integer, ScoreBoxColumnsObj> linkedHashMap, boolean z10) {
        try {
            int min = Math.min(linkedHashMap.values().size(), 5);
            int J0 = J0();
            int i10 = J0 / min;
            if (i10 < J0 / 5) {
                i10 = J0 / 5;
            }
            for (ScoreBoxColumnsObj scoreBoxColumnsObj : linkedHashMap.values()) {
                TextView textView = new TextView(App.m());
                textView.setTypeface(li.o0.d(App.m()));
                textView.setTextColor(li.p0.A(R.attr.f21565m1));
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setGravity(81);
                textView.setTextSize(1, 12.0f);
                textView.setText((scoreBoxColumnsObj.getShortName() == null || scoreBoxColumnsObj.getShortName().equals("")) ? scoreBoxColumnsObj.getName() : scoreBoxColumnsObj.getShortName());
                int i11 = f23896x0;
                textView.setPadding(i11, 4, i11, 4);
                textView.setLayoutParams(new LinearLayout.LayoutParams(li.p0.s(i10), li.p0.s(32)));
                linearLayout.addView(textView);
                if (z10) {
                    j3(linearLayout.getChildCount() - 1, textView);
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public void N3(boolean z10) {
        this.S = z10;
    }

    public boolean O() {
        try {
            GameObj gameObj = this.f23905f;
            if (gameObj != null) {
                return gameObj.hasPlayByPlay();
            }
            return false;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    public int O1() {
        try {
            GameObj gameObj = this.f23905f;
            if (gameObj != null) {
                return gameObj.getSportID();
            }
            return -1;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return -1;
        }
    }

    public boolean O2() {
        return this.W;
    }

    public void O3(int i10) {
        this.O = i10;
    }

    public boolean P2() {
        return this.f23923o;
    }

    public void P3(xe.c cVar) {
        this.f23908g0 = cVar;
    }

    public int Q(StatusObj statusObj) {
        int i10;
        int s10;
        int i11 = 1;
        try {
            i10 = this.f23928q0;
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        if (i10 == -1) {
            if (statusObj != null && !statusObj.getIsActive()) {
                s10 = statusObj.getIsNotStarted() ? cc.o0.y().s(cc.o0.y().E("NATIVE_GAMEDETAILS_BEFORE_1_BANNER_OR_2_NATIVE_OR_3_BOTH"), -1) : cc.o0.y().s(cc.o0.y().E("NATIVE_GAMEDETAILS_AFTER_1_BANNER_OR_2_NATIVE_OR_3_BOTH"), -1);
                i11 = s10;
                this.f23928q0 = i11;
                return i11;
            }
            s10 = cc.o0.y().s(cc.o0.y().E("NATIVE_GAMEDETAILS_LIVE_1_BANNER_OR_2_NATIVE_OR_3_BOTH"), -1);
            i11 = s10;
            this.f23928q0 = i11;
            return i11;
        }
        return i10;
    }

    public ArrayList<GameObj> Q0(ArrayList<GameObj> arrayList, int i10) {
        ArrayList<GameObj> arrayList2 = new ArrayList<>();
        Iterator<GameObj> it = arrayList.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            GameObj next = it.next();
            if (i11 >= 15) {
                break;
            } else if (next.getSurface() == i10) {
                arrayList2.add(next);
                i11++;
            }
        }
        return arrayList2;
    }

    public void Q3(androidx.lifecycle.a1 a1Var) {
        this.f23912i0 = a1Var;
    }

    public void R3(WinProbabilityObj winProbabilityObj) {
        this.Y = winProbabilityObj;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x03ac A[Catch: Exception -> 0x058b, LOOP:9: B:116:0x03a6->B:118:0x03ac, LOOP_END, TryCatch #1 {Exception -> 0x058b, blocks: (B:3:0x000b, B:5:0x002e, B:7:0x0032, B:10:0x0062, B:12:0x0066, B:14:0x006c, B:17:0x007e, B:19:0x0084, B:21:0x008e, B:22:0x009a, B:24:0x00ae, B:25:0x00c4, B:26:0x00db, B:28:0x00e1, B:29:0x00fb, B:31:0x0101, B:34:0x0124, B:35:0x012d, B:37:0x0133, B:39:0x0143, B:42:0x014d, B:44:0x0153, B:46:0x015f, B:48:0x0167, B:50:0x016d, B:54:0x017c, B:57:0x018d, B:59:0x0193, B:61:0x0199, B:62:0x01b1, B:65:0x01bb, B:66:0x01d3, B:68:0x01d9, B:70:0x01ef, B:72:0x0215, B:73:0x0220, B:77:0x0246, B:78:0x024e, B:80:0x0254, B:86:0x02a0, B:91:0x02ae, B:93:0x02c3, B:95:0x02ce, B:97:0x02db, B:98:0x02e9, B:100:0x02ef, B:102:0x02fc, B:103:0x0321, B:105:0x0327, B:110:0x033b, B:115:0x0396, B:116:0x03a6, B:118:0x03ac, B:114:0x036f, B:121:0x03eb, B:122:0x03fe, B:124:0x0404, B:126:0x0410, B:127:0x042f, B:129:0x0435, B:131:0x0450, B:133:0x045c, B:134:0x046f, B:135:0x049a, B:137:0x04a5, B:139:0x04b1, B:141:0x04d9, B:142:0x04ed, B:144:0x04f3, B:146:0x0527, B:147:0x054a, B:150:0x0582, B:83:0x0277), top: B:157:0x000b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04d9 A[Catch: Exception -> 0x058b, TryCatch #1 {Exception -> 0x058b, blocks: (B:3:0x000b, B:5:0x002e, B:7:0x0032, B:10:0x0062, B:12:0x0066, B:14:0x006c, B:17:0x007e, B:19:0x0084, B:21:0x008e, B:22:0x009a, B:24:0x00ae, B:25:0x00c4, B:26:0x00db, B:28:0x00e1, B:29:0x00fb, B:31:0x0101, B:34:0x0124, B:35:0x012d, B:37:0x0133, B:39:0x0143, B:42:0x014d, B:44:0x0153, B:46:0x015f, B:48:0x0167, B:50:0x016d, B:54:0x017c, B:57:0x018d, B:59:0x0193, B:61:0x0199, B:62:0x01b1, B:65:0x01bb, B:66:0x01d3, B:68:0x01d9, B:70:0x01ef, B:72:0x0215, B:73:0x0220, B:77:0x0246, B:78:0x024e, B:80:0x0254, B:86:0x02a0, B:91:0x02ae, B:93:0x02c3, B:95:0x02ce, B:97:0x02db, B:98:0x02e9, B:100:0x02ef, B:102:0x02fc, B:103:0x0321, B:105:0x0327, B:110:0x033b, B:115:0x0396, B:116:0x03a6, B:118:0x03ac, B:114:0x036f, B:121:0x03eb, B:122:0x03fe, B:124:0x0404, B:126:0x0410, B:127:0x042f, B:129:0x0435, B:131:0x0450, B:133:0x045c, B:134:0x046f, B:135:0x049a, B:137:0x04a5, B:139:0x04b1, B:141:0x04d9, B:142:0x04ed, B:144:0x04f3, B:146:0x0527, B:147:0x054a, B:150:0x0582, B:83:0x0277), top: B:157:0x000b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0576 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<com.scores365.Design.PageObjects.b> S1(boolean r31, zf.l r32, boolean r33, com.scores365.branding.BrandAsset r34, com.scores365.entitys.StatObj[] r35) {
        /*
            Method dump skipped, instructions count: 1424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.i0.S1(boolean, zf.l, boolean, com.scores365.branding.BrandAsset, com.scores365.entitys.StatObj[]):java.util.ArrayList");
    }

    public void S3(boolean z10) {
        this.Z = z10;
    }

    public boolean T2() {
        return this.S;
    }

    public boolean T3() {
        return this.T;
    }

    public HashMap<sc.f, gc.h> U(n.a aVar) {
        if (this.f23906f0.isEmpty() && aVar != null) {
            x2(aVar);
        }
        return this.f23906f0;
    }

    public ArrayList<TableRow> U1(LinkedHashMap<Integer, PlayerObj> linkedHashMap, ScoreBoxTablesObj scoreBoxTablesObj) {
        ArrayList<TableRow> arrayList = new ArrayList<>();
        try {
            LinkedHashMap<Integer, ScoreBoxColumnsObj> T1 = T1(scoreBoxTablesObj);
            LinkedHashMap<Integer, ArrayList<ScoreBoxValueObj>> I = I(T1, scoreBoxTablesObj);
            arrayList.add(Q1(T1));
            arrayList.addAll(u1(I, linkedHashMap, scoreBoxTablesObj));
            if (scoreBoxTablesObj != null && scoreBoxTablesObj.getSummary() != null && scoreBoxTablesObj.getSummary().size() > 0 && scoreBoxTablesObj.isShouldShowSummary()) {
                arrayList.addAll(v1(scoreBoxTablesObj.getSummary(), T1));
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    public boolean U2() {
        return this.Z;
    }

    public void W() {
        li.d1.b().a(this.f23905f.getID(), this);
    }

    public void W3() {
        try {
            com.scores365.services.b bVar = this.f23913j;
            if (bVar != null) {
                bVar.requestStop();
            }
            com.scores365.services.b bVar2 = new com.scores365.services.b("", "", "", String.valueOf(this.f23905f.getID()), false, this.f23915k, this.f23905f.getTopBookMaker());
            this.f23913j = bVar2;
            bVar2.setOnChangeListener(this);
            this.f23913j.setIsSingleGame(true);
            this.f23913j.start(true);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public void X3() {
        r0 r0Var = this.H;
        if (r0Var != null) {
            r0Var.K();
        }
        this.f23924o0 = false;
    }

    public ArrayList<com.scores365.Design.Pages.b> Y0(bg.e eVar, int i10) {
        boolean z10;
        boolean z11;
        ArrayList<com.scores365.Design.Pages.b> arrayList = new ArrayList<>();
        try {
            LinkedHashMap<bg.d, LinkedHashSet<bg.e>> v02 = v0();
            for (bg.d dVar : v02.keySet()) {
                if (!v02.get(dVar).isEmpty()) {
                    String N1 = N1(dVar, v02.get(dVar));
                    bg.e eVar2 = v02.get(dVar).contains(eVar) ? eVar : null;
                    try {
                        z10 = this.f23905f.hasLiveTable;
                    } catch (Exception e10) {
                        li.x0.N1(e10);
                        z10 = false;
                    }
                    try {
                        z11 = this.f23909h.getCompStageByNumFromCurrentSeason(this.f23905f.getStage()) != null ? !this.f23909h.getCompStageByNumFromCurrentSeason(this.f23905f.getStage()).getHasTable() : false;
                    } catch (Exception e11) {
                        li.x0.N1(e11);
                        z11 = false;
                    }
                    arrayList.add(new bg.a(N1, "", v02.get(dVar), this.f23905f.getSportID(), eVar2, z10, z11, dVar));
                }
            }
        } catch (Exception e12) {
            li.x0.N1(e12);
        }
        return arrayList;
    }

    public void Y3() {
        try {
            if (this.L != null) {
                this.L = null;
            }
            if (this.K != null) {
                this.K = null;
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // ag.u1.j
    public void a() {
        this.f23900b = true;
    }

    public CompetitionObj a0(int i10) {
        try {
            LinkedHashMap<Integer, CompetitionObj> linkedHashMap = this.f23911i;
            if (linkedHashMap == null || !linkedHashMap.containsKey(Integer.valueOf(i10))) {
                return null;
            }
            return this.f23911i.get(Integer.valueOf(i10));
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    @Override // ag.u1.j
    public boolean b() {
        return this.f23902c;
    }

    public String b0(a.EnumC0251a enumC0251a) {
        int i10;
        CompetitionObj competitionObj;
        try {
            LineUpsObj[] lineUpsObjArr = this.f23905f.unavailablePlayers;
            if (lineUpsObjArr != null) {
                boolean z10 = false;
                if (enumC0251a == a.EnumC0251a.HOME) {
                    boolean showCompetitionStatsName = lineUpsObjArr[0].getShowCompetitionStatsName();
                    i10 = this.f23905f.unavailablePlayers[0].getCompetitionStatsId();
                    z10 = showCompetitionStatsName;
                } else if (enumC0251a == a.EnumC0251a.AWAY) {
                    z10 = lineUpsObjArr[1].getShowCompetitionStatsName();
                    i10 = this.f23905f.unavailablePlayers[1].getCompetitionStatsId();
                } else {
                    i10 = -1;
                }
                if (!z10 || i10 == -1 || (competitionObj = this.f23915k.getCompetitions().get(Integer.valueOf(i10))) == null) {
                    return null;
                }
                return competitionObj.getName();
            }
            return null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public LinkedHashMap<String, ScoreBoxTablesObj> b2() {
        return this.f23931s;
    }

    @Override // ag.u1.j
    public boolean c() {
        return this.f23900b;
    }

    public CompetitionObj c0() {
        return this.f23909h;
    }

    public cc.s0 c1() {
        return this.f23926p0;
    }

    @Override // ag.u1.j
    public void d() {
        this.f23902c = true;
    }

    public String d0(int i10) {
        try {
            CountryObj e02 = e0(i10);
            return e02 != null ? e02.getName() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // li.d1.c
    public void e(BetObj betObj) {
        if (this.f23917l != null || betObj == null) {
            return;
        }
        this.f23917l = betObj;
        j jVar = this.f23932s0;
        if (jVar != null) {
            jVar.t(betObj);
        }
    }

    public com.scores365.Pages.r e1() {
        String str;
        String str2;
        ArrayList arrayList;
        String str3;
        try {
            ArrayList arrayList2 = new ArrayList();
            Hashtable hashtable = new Hashtable();
            String str4 = App.f20803w ? "NEWS_TERM" : "title term";
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            hashSet.add(Integer.valueOf(this.f23905f.getID()));
            lf.c cVar = new lf.c(hashSet2, hashSet2, hashSet, hashSet2);
            NewsObj newsObj = this.f23905f.gameNewsObj;
            if (newsObj != null) {
                str3 = newsObj.newsType;
                NewsObj.Paging paging = newsObj.paging;
                String str5 = paging.nextPage;
                String str6 = paging.refreshPage;
                ArrayList arrayList3 = new ArrayList(Arrays.asList(this.f23905f.gameNewsObj.getItems()));
                for (SourceObj sourceObj : this.f23905f.gameNewsObj.getSources().values()) {
                    hashtable.put(Integer.valueOf(sourceObj.getID()), sourceObj);
                }
                str2 = str6;
                str = str5;
                arrayList = arrayList3;
            } else {
                str = "";
                str2 = str;
                arrayList = arrayList2;
                str3 = str2;
            }
            return com.scores365.Pages.r.B1(arrayList, hashtable, str4, cVar, str3, null, str, str2, this.f23930r0, "", false, sc.i.GameDetails, App.f20803w, null, false);
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public StatusObj g0() {
        try {
            if (this.f23905f != null) {
                return App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStatuses().get(Integer.valueOf(this.f23905f.getStID()));
            }
            return null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public ArrayList<com.scores365.Design.PageObjects.b> g1(a.EnumC0251a enumC0251a) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            if (this.f23905f.getBestOddsObj() != null && li.x0.s2()) {
                this.f23941x = arrayList.size();
                a.C0400a c0400a = ke.a.f33223a;
                if (c0400a.g().booleanValue() && c0400a.a(this.f23905f.getBestOddsObj().getBetLines()[0].bookmakerId)) {
                    arrayList.add(new LineupOddsBrandedListItem(this.f23905f.getBestOddsObj().getBookMakerObjs().get(Integer.valueOf(this.f23905f.getBestOddsObj().getBetLines()[0].bookmakerId)), Arrays.asList(this.f23905f.getBestOddsObj().getBetLines()), this.f23905f));
                } else {
                    BetLine betLine = this.f23905f.getBestOddsObj().getBetLines()[0];
                    GameObj gameObj = this.f23905f;
                    arrayList.add(new ag.p(betLine, gameObj, gameObj.homeAwayTeamOrder));
                    if (!OddsView.shouldShowBetNowBtn()) {
                        arrayList.add(0, new yc.r(li.p0.l0("SPONSORED_AD_BETTING")));
                    }
                }
            }
            boolean K2 = K2(enumC0251a, this.f23905f);
            arrayList.add(S0(enumC0251a));
            arrayList.addAll(f1(s1(enumC0251a), K2));
            arrayList.addAll(Z(Y(enumC0251a)));
            arrayList.addAll(W1(s1(enumC0251a), K2));
            arrayList.addAll(m2(l2(enumC0251a), K2, b0(enumC0251a), enumC0251a));
            BookMakerObj m22 = li.x0.m2(this.f23905f.getBestOddsObj().getBookMakerObjs().values());
            if (m22 != null && m22.disclaimer != null) {
                arrayList.add(new ld.e(-1L, true, m22, false));
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    public int g2() {
        return this.O;
    }

    public void j3(int i10, TextView textView) {
        int length = textView.getText().length();
        if (this.f23918l0.size() <= i10) {
            this.f23918l0.add(Integer.valueOf(this.f23916k0));
            this.f23920m0.add(new ArrayList<>());
        }
        if (length > 10) {
            length = 10;
        }
        if (length < 5) {
            length = 5;
        }
        int i11 = (length * this.f23914j0) / 10;
        if (i11 > this.f23918l0.get(i10).intValue()) {
            this.f23918l0.set(i10, Integer.valueOf(i11));
        }
        this.f23920m0.get(i10).add(textView);
    }

    @NonNull
    public ArrayList<com.scores365.Design.PageObjects.b> k0(@NonNull Activity activity, @NonNull uc.d dVar, zf.c cVar) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            StatusObj statusObj = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStatuses().get(Integer.valueOf(this.f23905f.getStID()));
            if (statusObj.getIsNotStarted()) {
                arrayList.addAll(j0(activity, dVar, statusObj));
            } else {
                if (!statusObj.getIsActive() && !statusObj.getIsAbnormal()) {
                    arrayList.addAll(i0(activity, dVar, statusObj, this.N, cVar));
                }
                arrayList.addAll(h0(activity, dVar, statusObj, this.N, cVar));
            }
            if (arrayList.size() > 0 && this.f23925p < 1) {
                this.f23925p = arrayList.size();
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    public ke.d k1() {
        if (this.f23933t == null) {
            this.f23933t = new ke.d(this.f23903d, this.f23905f.getTopBookMaker());
        }
        return this.f23933t;
    }

    public ArrayList<TvNetworkObj> k2() {
        return this.f23915k.getNetworks();
    }

    public void k3() {
        this.f23924o0 = false;
    }

    public int l0() {
        return this.R;
    }

    public int l1() {
        return this.f23941x;
    }

    public LineUpsObj l2(a.EnumC0251a enumC0251a) {
        LineUpsObj lineUpsObj;
        try {
            LineUpsObj[] lineUpsObjArr = this.f23905f.unavailablePlayers;
            if (lineUpsObjArr != null) {
                if (enumC0251a == a.EnumC0251a.HOME) {
                    lineUpsObj = lineUpsObjArr[0];
                } else if (enumC0251a != a.EnumC0251a.AWAY) {
                    return null;
                } else {
                    lineUpsObj = lineUpsObjArr[1];
                }
                return lineUpsObj;
            }
            return null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public ArrayList<com.scores365.Design.PageObjects.b> m1(Activity activity) {
        VideoObj officialVideoObj;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            if ((activity instanceof GameCenterBaseActivity) && C0().isFinished() && (officialVideoObj = C0().getOfficialVideoObj()) != null) {
                arrayList.add(new yc.r(li.p0.l0("OFFICIAL_HIGHLIGHTS")));
                if (officialVideoObj.isVideoSupportEmbedding()) {
                    if (this.L == null) {
                        this.L = new u1(officialVideoObj.getURL(), ((GameCenterBaseActivity) activity).f23650t1, this.f23903d, C0().getStatusObj().valueForAnalytics(), -1, true, this, officialVideoObj.isEmbeddingAllowed(), officialVideoObj.getThumbnail());
                    }
                    arrayList.add(this.L);
                } else {
                    arrayList.add(new ag.n(officialVideoObj));
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0077 A[Catch: Exception -> 0x0180, TryCatch #0 {Exception -> 0x0180, blocks: (B:3:0x0009, B:8:0x0014, B:10:0x001a, B:12:0x0027, B:14:0x0033, B:16:0x003d, B:47:0x00e2, B:18:0x0045, B:20:0x004d, B:26:0x006b, B:28:0x0077, B:38:0x00c1, B:40:0x00c7, B:42:0x00d1, B:44:0x00d7, B:45:0x00db, B:46:0x00df, B:30:0x008e, B:32:0x009c, B:36:0x00aa, B:22:0x0058, B:24:0x0060, B:48:0x00e6, B:51:0x00f0, B:52:0x0100, B:54:0x0106, B:56:0x011d, B:58:0x0123, B:60:0x012d, B:62:0x0138, B:61:0x0132, B:63:0x0148, B:65:0x014e, B:67:0x016d, B:69:0x0173), top: B:74:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008e A[Catch: Exception -> 0x0180, TryCatch #0 {Exception -> 0x0180, blocks: (B:3:0x0009, B:8:0x0014, B:10:0x001a, B:12:0x0027, B:14:0x0033, B:16:0x003d, B:47:0x00e2, B:18:0x0045, B:20:0x004d, B:26:0x006b, B:28:0x0077, B:38:0x00c1, B:40:0x00c7, B:42:0x00d1, B:44:0x00d7, B:45:0x00db, B:46:0x00df, B:30:0x008e, B:32:0x009c, B:36:0x00aa, B:22:0x0058, B:24:0x0060, B:48:0x00e6, B:51:0x00f0, B:52:0x0100, B:54:0x0106, B:56:0x011d, B:58:0x0123, B:60:0x012d, B:62:0x0138, B:61:0x0132, B:63:0x0148, B:65:0x014e, B:67:0x016d, B:69:0x0173), top: B:74:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c7 A[Catch: Exception -> 0x0180, TryCatch #0 {Exception -> 0x0180, blocks: (B:3:0x0009, B:8:0x0014, B:10:0x001a, B:12:0x0027, B:14:0x0033, B:16:0x003d, B:47:0x00e2, B:18:0x0045, B:20:0x004d, B:26:0x006b, B:28:0x0077, B:38:0x00c1, B:40:0x00c7, B:42:0x00d1, B:44:0x00d7, B:45:0x00db, B:46:0x00df, B:30:0x008e, B:32:0x009c, B:36:0x00aa, B:22:0x0058, B:24:0x0060, B:48:0x00e6, B:51:0x00f0, B:52:0x0100, B:54:0x0106, B:56:0x011d, B:58:0x0123, B:60:0x012d, B:62:0x0138, B:61:0x0132, B:63:0x0148, B:65:0x014e, B:67:0x016d, B:69:0x0173), top: B:74:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<com.scores365.Design.PageObjects.b> m2(com.scores365.entitys.LineUpsObj r21, boolean r22, java.lang.String r23, com.scores365.gameCenter.gameCenterItems.a.EnumC0251a r24) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.i0.m2(com.scores365.entitys.LineUpsObj, boolean, java.lang.String, com.scores365.gameCenter.gameCenterItems.a$a):java.util.ArrayList");
    }

    public void m3(int i10) {
        this.R = i10;
    }

    public int n0() {
        return this.N;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:31|(22:101|102|37|38|39|(1:94)(5:43|45|46|(4:49|(2:54|(3:59|60|61))(1:65)|62|47)|67)|68|69|70|71|72|73|74|75|(1:77)(1:83)|78|(1:80)(1:82)|81|21|8|9|(0)(0))|36|37|38|39|(1:41)|94|68|69|70|71|72|73|74|75|(0)(0)|78|(0)(0)|81|21|8|9|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x011c, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x011d, code lost:
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0133, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0134, code lost:
        li.x0.N1(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0137, code lost:
        r4 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0144, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0145, code lost:
        li.x0.N1(r0);
        r9 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014f A[Catch: Exception -> 0x01c3, TryCatch #5 {Exception -> 0x01c3, blocks: (B:3:0x000a, B:4:0x0013, B:5:0x0016, B:76:0x01a2, B:6:0x001a, B:7:0x0024, B:8:0x0036, B:9:0x003c, B:10:0x0048, B:11:0x006c, B:12:0x0072, B:13:0x0078, B:14:0x007e, B:15:0x008a, B:16:0x0092, B:18:0x0099, B:53:0x0122, B:63:0x0149, B:65:0x014f, B:67:0x0156, B:71:0x0181, B:62:0x0145, B:57:0x0134, B:52:0x011f, B:21:0x00a0, B:23:0x00a4, B:25:0x00aa, B:72:0x018f, B:73:0x0196, B:74:0x019b, B:59:0x0138, B:54:0x0127), top: B:97:0x000a, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b8 A[Catch: Exception -> 0x01bf, TRY_LEAVE, TryCatch #0 {Exception -> 0x01bf, blocks: (B:78:0x01b3, B:80:0x01b8), top: B:87:0x01b3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.scores365.Design.Pages.a n1(bg.e r30, com.scores365.entitys.GameObj r31, com.scores365.entitys.CompetitionObj r32, com.scores365.gameCenter.p0 r33) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.i0.n1(bg.e, com.scores365.entitys.GameObj, com.scores365.entitys.CompetitionObj, com.scores365.gameCenter.p0):com.scores365.Design.Pages.a");
    }

    public VideoObj n2(EventObj eventObj) {
        VideoObj[] videos;
        try {
            GameObj gameObj = this.f23905f;
            if (gameObj == null || gameObj.getVideos() == null) {
                return null;
            }
            for (VideoObj videoObj : this.f23905f.getVideos()) {
                if (eventObj.getNum() == videoObj.eventNum && eventObj.getType() == videoObj.eventType) {
                    return videoObj;
                }
            }
            return null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public void n3(boolean z10) {
        f23898z0 = this.f23903d;
        C0 = this.f23904e;
        A0 = this.f23905f.getSportID();
        GameObj gameObj = this.f23905f;
        if (gameObj != null) {
            D0 = gameObj.getTopBookMaker();
        }
        E0 = Boolean.valueOf(z10);
        q3();
        v3();
    }

    public ArrayList<com.scores365.Design.PageObjects.b> o0() {
        ArrayList<com.scores365.Design.PageObjects.b> J1;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            if (!App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStatuses().get(Integer.valueOf(this.f23905f.getStID())).getIsNotStarted()) {
                if (this.f23905f.getSportID() == SportTypesEnum.SOCCER.getValue()) {
                    ArrayList<com.scores365.Design.PageObjects.b> r02 = r0(2);
                    if (r02 != null && !r02.isEmpty()) {
                        arrayList.add(new ag.d0(li.p0.l0("SELECTIONS_MENU_NOTIFICATIONS_GAME_EVENTS")));
                        arrayList.addAll(r02);
                    }
                } else if (this.f23905f.getSportID() == SportTypesEnum.HOCKEY.getValue()) {
                    ArrayList<com.scores365.Design.PageObjects.b> L0 = L0();
                    if (!L0.isEmpty()) {
                        arrayList.addAll(L0);
                    }
                } else if (this.f23905f.getSportID() == SportTypesEnum.AMERICAN_FOOTBALL.getValue()) {
                    ArrayList<com.scores365.Design.PageObjects.b> S = S(2);
                    if (S != null && !S.isEmpty()) {
                        arrayList.addAll(S);
                    }
                } else if (this.f23905f.getSportID() == SportTypesEnum.RUGBY.getValue() && (J1 = J1(2)) != null && !J1.isEmpty()) {
                    arrayList.addAll(J1);
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    public void o1(final q0.b bVar, Handler handler, ArrayList<com.scores365.Design.PageObjects.b> arrayList) {
        r0 r0Var;
        if (this.f23905f.shouldUseLmtPbpPreviewForSportType() && O2() && H2(arrayList) && (r0Var = this.H) != null) {
            if (!r0Var.v() && !this.f23924o0) {
                this.f23924o0 = true;
                this.H.u(bVar, handler);
            } else if (this.f23924o0) {
            } else {
                this.f23924o0 = true;
                handler.post(new Runnable() { // from class: com.scores365.gameCenter.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        q0.b.this.M(null);
                    }
                });
            }
        }
    }

    public ArrayList<com.scores365.Design.PageObjects.b> o2() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            VideoObj[] videos = this.f23905f.getVideos();
            Arrays.sort(videos, new c());
            boolean z10 = false;
            boolean z11 = false;
            for (VideoObj videoObj : videos) {
                if (videoObj.getType() == 1) {
                    if (!z11) {
                        arrayList.add(new xf.s(li.p0.l0("VIDEO_GOAL_HIGHLIGHTS")));
                        z11 = true;
                    }
                } else if (!z10) {
                    arrayList.add(new xf.s(li.p0.l0("VIDEO_GOAL_GOALS")));
                    z10 = true;
                }
                String q12 = q1(videoObj);
                if (videoObj.getType() == 1) {
                    arrayList.add(new ag.n(videoObj));
                } else {
                    arrayList.add(new ag.e0(videoObj, q12, G0(videoObj)));
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    public void o3(int i10) {
        this.N = i10;
    }

    @Override // com.scores365.services.b.c
    public void onCompetitionsUpdated(ArrayList<CompetitionObj> arrayList) {
    }

    @Override // com.scores365.services.b.c
    public void onCountriesUpdated(ArrayList<CountryObj> arrayList) {
    }

    @Override // com.scores365.services.b.c
    public void onGameAdded(GameObj gameObj) {
    }

    @Override // com.scores365.services.b.c
    public void onGameDeleted(GameObj gameObj) {
    }

    @Override // com.scores365.services.b.c
    public void onGameUpdated(GameObj gameObj) {
        try {
            this.f23905f.updateGameData(gameObj);
            li.c.f34483a.e().execute(new Runnable() { // from class: com.scores365.gameCenter.x
                @Override // java.lang.Runnable
                public final void run() {
                    i0.this.d3();
                }
            });
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.services.b.c
    public void onGamesUpdated(GamesObj gamesObj) {
    }

    @Override // com.scores365.services.b.c
    public void onNetworkError() {
        try {
            li.c.f34483a.e().execute(new Runnable() { // from class: com.scores365.gameCenter.v
                @Override // java.lang.Runnable
                public final void run() {
                    i0.this.e3();
                }
            });
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.services.b.c
    public void onNewVideoArrive(Vector<VideoObj> vector, GameObj gameObj) {
    }

    @Override // com.scores365.services.b.c
    public void onNotification(NotificationObj notificationObj, GameObj gameObj) {
        try {
            gameObj.AddNotification(notificationObj.getType(), notificationObj.getAnimationText(), notificationObj.getTimeOfRelevancy(), notificationObj.getCompetitorNum());
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public q0 p1() {
        return this.I;
    }

    public androidx.lifecycle.a1 p2() {
        return this.f23912i0;
    }

    public void p3(int i10) {
        this.f23925p = i10;
    }

    public ArrayList<com.scores365.Design.PageObjects.b> q2(@NonNull Activity activity, a.EnumC0251a enumC0251a, FragmentManager fragmentManager, n.a aVar) {
        BookMakerObj m22;
        int id2;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            if (this.f23905f.getBestOddsObj() != null && li.x0.s2()) {
                this.f23941x = arrayList.size();
                a.C0400a c0400a = ke.a.f33223a;
                if (c0400a.g().booleanValue() && c0400a.a(this.f23905f.getBestOddsObj().getBetLines()[0].bookmakerId)) {
                    arrayList.add(new LineupOddsBrandedListItem(this.f23905f.getBestOddsObj().getBookMakerObjs().get(Integer.valueOf(this.f23905f.getBestOddsObj().getBetLines()[0].bookmakerId)), Arrays.asList(this.f23905f.getBestOddsObj().getBetLines()), this.f23905f));
                } else {
                    BetLine betLine = this.f23905f.getBestOddsObj().getBetLines()[0];
                    GameObj gameObj = this.f23905f;
                    arrayList.add(new ag.p(betLine, gameObj, gameObj.homeAwayTeamOrder));
                    if (!OddsView.shouldShowBetNowBtn()) {
                        arrayList.add(0, new yc.r(li.p0.l0("SPONSORED_AD_BETTING")));
                        this.f23941x++;
                    }
                }
            }
            arrayList.add(S0(enumC0251a));
            gc.h hVar = U(aVar).get(sc.f.Branded_Lineups_Strip);
            if (hVar != null) {
                arrayList.add(new gc.j(hVar));
                hVar.n(activity);
            }
            GameObj gameObj2 = this.f23905f;
            if (gameObj2 != null && gameObj2.getLineUps() != null && this.f23905f.getLineUps()[0].isHasRankings()) {
                this.f23923o = this.f23905f.getLineUps()[0].isHasRankings();
            }
            boolean K2 = K2(enumC0251a, this.f23905f);
            ArrayList arrayList2 = new ArrayList(Arrays.asList(this.f23905f.getLineUps()));
            int id3 = this.f23905f.getID();
            String D02 = D0(this.f23905f);
            int competitionID = this.f23905f.getCompetitionID();
            int sportID = this.f23905f.getSportID();
            boolean isStartedOrFinished = this.f23905f.isStartedOrFinished();
            HashMap hashMap = new HashMap();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                PlayerObj[] players = ((LineUpsObj) it.next()).getPlayers();
                if (players != null) {
                    int length = players.length;
                    for (int i10 = 0; i10 < length; i10++) {
                        PlayerObj playerObj = players[i10];
                        CompObj[] comps = this.f23905f.getComps();
                        int length2 = comps.length;
                        int i11 = 0;
                        while (i11 < length2) {
                            int i12 = length2;
                            CompObj compObj = comps[i11];
                            Iterator it2 = it;
                            int i13 = playerObj.competitorId;
                            PlayerObj[] playerObjArr = players;
                            if (i13 == -1 || i13 != compObj.getID()) {
                                int i14 = playerObj.competitorNum;
                                if ((i14 == 1 || i14 == 2) && (id2 = this.f23905f.getComps()[i14 - 1].getID()) == compObj.getID()) {
                                    hashMap.put(Integer.valueOf(id2), compObj);
                                    playerObj.competitorId = id2;
                                }
                            } else {
                                hashMap.put(Integer.valueOf(playerObj.competitorId), compObj);
                            }
                            i11++;
                            it = it2;
                            players = playerObjArr;
                            length2 = i12;
                        }
                    }
                }
                it = it;
            }
            arrayList.add(new com.scores365.gameCenter.gameCenterItems.b(w2(), new se.q0(arrayList2, id3, D02, competitionID, sportID, isStartedOrFinished, hashMap, "", -1, null), enumC0251a, false, P2(), fragmentManager, false));
            arrayList.addAll(Z(Y(enumC0251a)));
            arrayList.addAll(W1(s1(enumC0251a), K2));
            arrayList.addAll(m2(l2(enumC0251a), K2, b0(enumC0251a), enumC0251a));
            GameObj gameObj3 = this.f23905f;
            if (gameObj3 != null && gameObj3.getBestOddsObj() != null && this.f23905f.getBestOddsObj().getBookMakerObjs() != null && (m22 = li.x0.m2(this.f23905f.getBestOddsObj().getBookMakerObjs().values())) != null && m22.disclaimer != null) {
                arrayList.add(new ld.e(-1L, true, m22, false));
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    public void q3() {
        try {
            F0 = this.f23905f.getGameStatusForDfp();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public void r3(l lVar) {
        this.f23937v = lVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:236:0x078c A[Catch: Exception -> 0x07bf, TryCatch #0 {Exception -> 0x07bf, blocks: (B:3:0x000d, B:5:0x0021, B:7:0x0030, B:9:0x0038, B:13:0x0049, B:234:0x077e, B:236:0x078c, B:237:0x0795, B:239:0x079d, B:243:0x07a3, B:22:0x0063, B:25:0x0078, B:26:0x008c, B:27:0x009e, B:29:0x00a4, B:31:0x00c4, B:33:0x00de, B:35:0x00e3, B:40:0x0103, B:34:0x00e1, B:45:0x0146, B:47:0x0157, B:50:0x01b1, B:51:0x01b4, B:53:0x01ba, B:55:0x01c9, B:56:0x01d4, B:58:0x01da, B:60:0x01f8, B:65:0x0218, B:66:0x023d, B:68:0x0256, B:74:0x0279, B:78:0x02a3, B:81:0x02b3, B:83:0x02b9, B:86:0x02d0, B:87:0x02e4, B:88:0x02f6, B:90:0x02fc, B:92:0x031c, B:94:0x0321, B:96:0x033c, B:102:0x035d, B:93:0x031f, B:107:0x0390, B:108:0x039b, B:111:0x03f1, B:112:0x03f4, B:114:0x03ff, B:116:0x0405, B:117:0x0410, B:119:0x0416, B:121:0x0434, B:124:0x044e, B:125:0x0473, B:127:0x048c, B:133:0x04af, B:136:0x04d4, B:139:0x04e4, B:140:0x04e9, B:142:0x04f8, B:146:0x04ff, B:148:0x0505, B:150:0x050b, B:152:0x054c, B:153:0x0560, B:154:0x0565, B:156:0x056b, B:161:0x0591, B:163:0x0596, B:173:0x05c9, B:162:0x0594, B:174:0x05df, B:176:0x05e6, B:177:0x05f1, B:179:0x05ff, B:183:0x0606, B:185:0x060c, B:187:0x0612, B:189:0x0653, B:190:0x0667, B:191:0x066c, B:193:0x0672, B:198:0x0698, B:200:0x069d, B:210:0x06d0, B:199:0x069b, B:211:0x06e6, B:213:0x06ed, B:214:0x06f8, B:216:0x06fc, B:219:0x070f, B:221:0x0715, B:222:0x072f, B:224:0x0735, B:230:0x075b, B:231:0x076b, B:233:0x0774, B:217:0x0701), top: B:248:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0795 A[Catch: Exception -> 0x07bf, TryCatch #0 {Exception -> 0x07bf, blocks: (B:3:0x000d, B:5:0x0021, B:7:0x0030, B:9:0x0038, B:13:0x0049, B:234:0x077e, B:236:0x078c, B:237:0x0795, B:239:0x079d, B:243:0x07a3, B:22:0x0063, B:25:0x0078, B:26:0x008c, B:27:0x009e, B:29:0x00a4, B:31:0x00c4, B:33:0x00de, B:35:0x00e3, B:40:0x0103, B:34:0x00e1, B:45:0x0146, B:47:0x0157, B:50:0x01b1, B:51:0x01b4, B:53:0x01ba, B:55:0x01c9, B:56:0x01d4, B:58:0x01da, B:60:0x01f8, B:65:0x0218, B:66:0x023d, B:68:0x0256, B:74:0x0279, B:78:0x02a3, B:81:0x02b3, B:83:0x02b9, B:86:0x02d0, B:87:0x02e4, B:88:0x02f6, B:90:0x02fc, B:92:0x031c, B:94:0x0321, B:96:0x033c, B:102:0x035d, B:93:0x031f, B:107:0x0390, B:108:0x039b, B:111:0x03f1, B:112:0x03f4, B:114:0x03ff, B:116:0x0405, B:117:0x0410, B:119:0x0416, B:121:0x0434, B:124:0x044e, B:125:0x0473, B:127:0x048c, B:133:0x04af, B:136:0x04d4, B:139:0x04e4, B:140:0x04e9, B:142:0x04f8, B:146:0x04ff, B:148:0x0505, B:150:0x050b, B:152:0x054c, B:153:0x0560, B:154:0x0565, B:156:0x056b, B:161:0x0591, B:163:0x0596, B:173:0x05c9, B:162:0x0594, B:174:0x05df, B:176:0x05e6, B:177:0x05f1, B:179:0x05ff, B:183:0x0606, B:185:0x060c, B:187:0x0612, B:189:0x0653, B:190:0x0667, B:191:0x066c, B:193:0x0672, B:198:0x0698, B:200:0x069d, B:210:0x06d0, B:199:0x069b, B:211:0x06e6, B:213:0x06ed, B:214:0x06f8, B:216:0x06fc, B:219:0x070f, B:221:0x0715, B:222:0x072f, B:224:0x0735, B:230:0x075b, B:231:0x076b, B:233:0x0774, B:217:0x0701), top: B:248:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<com.scores365.Design.PageObjects.b> s(com.scores365.gameCenter.i0.s r33, boolean[] r34) {
        /*
            Method dump skipped, instructions count: 1988
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.i0.s(com.scores365.gameCenter.i0$s, boolean[]):java.util.ArrayList");
    }

    public void s3(l0 l0Var) {
        this.f23910h0 = l0Var;
    }

    public ArrayList<ScoreBoxRowHelperObject> t1(ScoreBoxTablesObj scoreBoxTablesObj, LinkedHashMap<Integer, PlayerObj> linkedHashMap, String str, int i10, boolean z10, d1 d1Var) {
        ArrayList<ScoreBoxRowHelperObject> arrayList = new ArrayList<>();
        try {
            ArrayList arrayList2 = new ArrayList();
            if (SportTypesEnum.HOCKEY.getValue() == O1()) {
                PlayerObj[] i32 = i3(i10, scoreBoxTablesObj, linkedHashMap);
                if (i32 != null) {
                    arrayList2.addAll(Arrays.asList(i32));
                }
            } else {
                Iterator<StatsRowObj> it = scoreBoxTablesObj.getRows().iterator();
                while (it.hasNext()) {
                    arrayList2.add(linkedHashMap.get(Integer.valueOf(it.next().getPlayerID())));
                }
            }
            boolean z11 = h1(scoreBoxTablesObj) > 5;
            if (!str.isEmpty()) {
                arrayList.add(new ScoreBoxRowHelperObject(null, e2(str), "", false, true, str, false));
            }
            if (arrayList2.size() > 0) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ScoreBoxRowHelperObject r12 = r1((PlayerObj) it2.next(), i10, z10, z11, d1Var);
                    if (r12 != null) {
                        arrayList.add(r12);
                    }
                }
            }
            if (scoreBoxTablesObj.getSummary() != null && scoreBoxTablesObj.getSummary().size() > 0 && scoreBoxTablesObj.isShouldShowSummary()) {
                Iterator<ScoreBoxSummaryObj> it3 = scoreBoxTablesObj.getSummary().iterator();
                while (it3.hasNext()) {
                    arrayList.add(new ScoreBoxRowHelperObject(null, Y1(it3.next().getTitle(), z11, this.f23921n), "", false, false, null, true));
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    public void t3(int i10) {
        com.scores365.services.b bVar = this.f23913j;
        if (bVar != null) {
            bVar.setGroupCategory(i10);
        }
    }

    public void u3(int i10) {
        com.scores365.services.b bVar = this.f23913j;
        if (bVar != null) {
            bVar.setGroupType(i10);
        }
    }

    public LinkedHashMap<bg.d, LinkedHashSet<bg.e>> v0() {
        LinkedHashMap<bg.d, LinkedHashSet<bg.e>> linkedHashMap = new LinkedHashMap<>();
        try {
            StatusObj statusObj = App.l().getSportTypes().get(Integer.valueOf(this.f23905f.getSportID())).getStatuses().get(Integer.valueOf(this.f23905f.getStID()));
            bg.d dVar = bg.d.MATCH;
            linkedHashMap.put(dVar, new LinkedHashSet<>());
            linkedHashMap.get(dVar).add(bg.e.DETAILS);
            if ((this.f23905f.getSportID() == SportTypesEnum.SOCCER.getValue() || this.f23905f.getSportID() == SportTypesEnum.RUGBY.getValue()) && (this.f23905f.getHaveLineUps() || this.f23905f.hasMissingPlayers)) {
                linkedHashMap.get(dVar).add(bg.e.LINEUPS);
            }
            if ((this.f23905f.getHaveLineUps() || this.f23905f.hasMissingPlayers) && (this.f23905f.getSportID() == SportTypesEnum.BASKETBALL.getValue() || this.f23905f.getSportID() == SportTypesEnum.HOCKEY.getValue() || this.f23905f.getSportID() == SportTypesEnum.AMERICAN_FOOTBALL.getValue() || this.f23905f.getSportID() == SportTypesEnum.BASEBALL.getValue() || this.f23905f.getSportID() == SportTypesEnum.CRICKET.getValue())) {
                linkedHashMap.get(dVar).add(bg.e.PLAYER_STATISTICS);
            }
            if (!statusObj.getIsNotStarted() && this.f23905f.getHaveStatistics() && this.f23905f.getSportID() != SportTypesEnum.CRICKET.getValue()) {
                linkedHashMap.get(dVar).add(bg.e.STATISTICS);
            }
            if (this.f23905f.hasPointByPoint()) {
                linkedHashMap.get(dVar).add(bg.e.POINT_BY_POINT);
            }
            if (this.f23905f.isShowPlayByPlay() || this.f23905f.hasMatchFacts) {
                linkedHashMap.get(dVar).add(bg.e.PLAY_BY_PLAY);
            }
            if (this.f23905f.hasTable) {
                linkedHashMap.get(dVar).add(bg.e.STANDINGS);
            }
            bg.d dVar2 = bg.d.BUZZ;
            linkedHashMap.put(dVar2, new LinkedHashSet<>());
            if (nb.x.b(this.f23905f)) {
                linkedHashMap.get(dVar2).add(bg.e.STORY);
            } else if (this.f23905f.hasBuzz) {
                linkedHashMap.get(dVar2).add(bg.e.BUZZ);
            }
            if (this.f23905f.hasVideo) {
                linkedHashMap.get(dVar2).add(bg.e.HIGHLIGHTS);
            }
            if (this.f23905f.hasNews) {
                linkedHashMap.get(dVar2).add(bg.e.NEWS);
            }
            bg.d dVar3 = bg.d.INSIGHTS;
            linkedHashMap.put(dVar3, new LinkedHashSet<>());
            if (this.f23905f.hasInsights) {
                linkedHashMap.get(dVar3).add(bg.e.INSIGHTS);
            }
            if (C0().hasBets() && li.x0.s2()) {
                linkedHashMap.get(dVar3).add(bg.e.ODDS);
            }
            if (C0().isHasTrend()) {
                linkedHashMap.get(dVar3).add(bg.e.TRENDS);
            }
            linkedHashMap.get(dVar3).add(bg.e.HEAD_2_HEAD);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return linkedHashMap;
    }

    public ArrayList<TableRow> v1(ArrayList<ScoreBoxSummaryObj> arrayList, LinkedHashMap<Integer, ScoreBoxColumnsObj> linkedHashMap) {
        ArrayList<TableRow> arrayList2 = new ArrayList<>();
        try {
            Iterator<ScoreBoxSummaryObj> it = arrayList.iterator();
            while (it.hasNext()) {
                ScoreBoxSummaryObj next = it.next();
                TableRow tableRow = new TableRow(App.m());
                tableRow.setLayoutParams(new TableRow.LayoutParams(-2, -2));
                LinearLayout linearLayout = new LinearLayout(App.m());
                linearLayout.setOrientation(0);
                linearLayout.setGravity(16);
                linearLayout.setBackgroundColor(li.p0.A(R.attr.f21547g1));
                ArrayList<ScoreBoxValueObj> valueObjs = next.getValueObjs();
                int min = Math.min(linkedHashMap.size(), 5);
                int J0 = J0();
                int i10 = J0 / min;
                int i11 = i10 < J0 / 5 ? J0 / 5 : i10;
                Iterator<Integer> it2 = linkedHashMap.keySet().iterator();
                while (linkedHashMap.values().size() > 0 && valueObjs.size() > 0 && it2.hasNext()) {
                    H3(it2, next, i11, 0, linearLayout, linkedHashMap);
                }
                if (next.getValueObjs().isEmpty()) {
                    H3(it2, next, i11, 0, linearLayout, linkedHashMap);
                }
                tableRow.addView(linearLayout);
                tableRow.setPadding(li.p0.s(2), li.p0.s(1), li.p0.s(2), 0);
                arrayList2.add(tableRow);
            }
        } catch (Resources.NotFoundException e10) {
            li.x0.N1(e10);
        }
        return arrayList2;
    }

    public boolean v2() {
        return this.f23919m;
    }

    public void v3() {
        try {
            if (this.f23905f.getPredictionObj() == null || this.f23905f.getPredictionObj().a() == null || this.f23905f.getPredictionObj().a().isEmpty()) {
                G0 = Boolean.FALSE;
            } else {
                G0 = Boolean.TRUE;
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public void w0(k kVar, int i10) {
        GameCenterBaseActivity.f23612x1 = false;
        new Thread(new f(this, this.f23903d, kVar, new Handler(), i10)).start();
    }

    public s0 w1() {
        try {
            if (this.J == null) {
                this.J = new s0();
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return this.J;
    }

    public ag.o w2() {
        PlayerObj[] players;
        ag.o oVar = new ag.o();
        try {
            EventObj[] events = this.f23905f.getEvents();
            if (events != null) {
                for (EventObj eventObj : events) {
                    if (eventObj.getType() == 0) {
                        if (eventObj.getSubType() == 1) {
                            if (oVar.b().containsKey(Integer.valueOf(eventObj.PId))) {
                                oVar.b().put(Integer.valueOf(eventObj.PId), Integer.valueOf(oVar.b().get(Integer.valueOf(eventObj.PId)).intValue() + 1));
                            } else {
                                oVar.b().put(Integer.valueOf(eventObj.PId), 1);
                            }
                        } else if (oVar.a().containsKey(Integer.valueOf(eventObj.PId))) {
                            oVar.a().put(Integer.valueOf(eventObj.PId), Integer.valueOf(oVar.a().get(Integer.valueOf(eventObj.PId)).intValue() + 1));
                        } else {
                            oVar.a().put(Integer.valueOf(eventObj.PId), 1);
                        }
                    }
                    if (eventObj.getType() == 2) {
                        if (eventObj.getSubType() != -1) {
                            LinkedHashMap<Integer, SportTypeObj> sportTypes = App.l().getSportTypes();
                            SportTypesEnum sportTypesEnum = SportTypesEnum.SOCCER;
                            if (sportTypes.get(Integer.valueOf(sportTypesEnum.getValue())).getEventTypes().get(Integer.valueOf(eventObj.getType())).getSubTypes()[eventObj.getSubType()].getID() == 20 && eventObj.getType() == 2 && eventObj.getSubType() == 0) {
                                oVar.c().put(Integer.valueOf(eventObj.PId), Boolean.TRUE);
                                try {
                                    oVar.d().put(Integer.valueOf(eventObj.PId), Integer.valueOf(eventObj.getGT()));
                                } catch (Exception unused) {
                                }
                            } else if (App.l().getSportTypes().get(Integer.valueOf(sportTypesEnum.getValue())).getEventTypes().get(Integer.valueOf(eventObj.getType())).getSubTypes()[eventObj.getSubType()].getID() == 21 && eventObj.getType() == 2 && eventObj.getSubType() == 1) {
                                oVar.e().put(Integer.valueOf(eventObj.PId), Boolean.TRUE);
                                oVar.f().put(Integer.valueOf(eventObj.PId), Integer.valueOf(eventObj.getGT()));
                                oVar.h().remove(Integer.valueOf(eventObj.PId));
                                oVar.i().remove(Integer.valueOf(eventObj.PId));
                            }
                        } else if (App.l().getSportTypes().get(Integer.valueOf(SportTypesEnum.SOCCER.getValue())).getEventTypes().get(Integer.valueOf(eventObj.getType())).getSubTypes()[0].getID() == 20 && eventObj.getType() == 2) {
                            oVar.c().put(Integer.valueOf(eventObj.PId), Boolean.TRUE);
                            oVar.d().put(Integer.valueOf(eventObj.PId), Integer.valueOf(eventObj.getGT()));
                        }
                    }
                    if (eventObj.getType() == 1) {
                        oVar.h().put(Integer.valueOf(eventObj.PId), Boolean.TRUE);
                        try {
                            oVar.i().put(Integer.valueOf(eventObj.PId), Integer.valueOf(eventObj.getGT()));
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            LineUpsObj[] lineUps = this.f23905f.getLineUps();
            if (lineUps != null) {
                for (LineUpsObj lineUpsObj : lineUps) {
                    for (PlayerObj playerObj : lineUpsObj.getPlayers()) {
                        if (playerObj.getStatus() == PlayerObj.ePlayerStatus.LINEUP && playerObj.getSubtituteTime() > 0) {
                            oVar.g().put(Integer.valueOf(playerObj.pId), Integer.valueOf(playerObj.getSubtituteTime()));
                        }
                    }
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return oVar;
    }

    public void x3(int i10) {
        this.P = i10;
    }

    public int y0() {
        return this.f23925p;
    }

    public int y1() {
        return this.A;
    }

    public void y2(a.InterfaceC0616a<Boolean> interfaceC0616a) {
        try {
            String playByPlayPreviewURL = this.f23905f.getPlayByPlayPreviewURL();
            if (this.H == null || !this.f23905f.shouldUseLmtPbpPreviewForSportType() || O2() || !O() || playByPlayPreviewURL == null || playByPlayPreviewURL.isEmpty()) {
                return;
            }
            G3(true);
            this.H.L(this.f23905f);
            this.H.I(interfaceC0616a);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public void y3(int i10, EventObj eventObj, LinkedHashMap<Integer, ArrayList<EventObj>> linkedHashMap) {
        if (linkedHashMap != null) {
            if (!linkedHashMap.containsKey(Integer.valueOf(i10))) {
                linkedHashMap.put(Integer.valueOf(i10), new ArrayList<>());
            }
            linkedHashMap.get(Integer.valueOf(i10)).add(eventObj);
        }
    }

    public ArrayList<com.scores365.Design.PageObjects.b> z1(h hVar) {
        ke.b bVar;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            if (li.x0.s2() && (bVar = this.f23935u) != null && bVar.d() != null && this.f23935u.d().isGameTeaserHasGames()) {
                BookMakerObj bookMakerObj = null;
                for (Integer num : this.f23935u.d().getOddsObj().getBookMakerObjs().keySet()) {
                    bookMakerObj = this.f23935u.d().getOddsObj().getBookMakerObjs().get(num);
                }
                if (hVar != null) {
                    hVar.e(true);
                    if (hVar.a().isEmpty()) {
                        hVar.f(bookMakerObj);
                    }
                }
                a.C0400a c0400a = ke.a.f33223a;
                if (c0400a.g().booleanValue() && c0400a.a(bookMakerObj.getID())) {
                    arrayList.add(new ag.d0(li.p0.l0("GC_GAME_TEASER")));
                    arrayList.add(new PostGameTeaserBrandedListItem(bookMakerObj, this.f23905f, this.f23935u.d()));
                } else {
                    arrayList.add(new ag.a1(this.f23935u.d(), this.f23935u.c(), this.f23905f, true));
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    public void z3(m mVar) {
        this.f23939w = mVar;
    }
}
