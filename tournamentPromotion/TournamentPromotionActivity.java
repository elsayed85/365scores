package com.scores365.tournamentPromotion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Fade;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.R;
import com.scores365.api.m0;
import com.scores365.entitys.CompetitionObj;
import com.scores365.tournamentPromotion.a;
import ee.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import li.p0;
import li.x0;
import nd.h;
/* loaded from: classes2.dex */
public class TournamentPromotionActivity extends com.scores365.Design.Activities.c {

    /* renamed from: g0  reason: collision with root package name */
    public static boolean f24307g0;
    private Handler F;
    FrameLayout H;
    public RelativeLayout I;

    /* renamed from: b0  reason: collision with root package name */
    nd.a f24308b0;
    public boolean G = true;

    /* renamed from: f0  reason: collision with root package name */
    private f f24309f0 = new a();

    /* loaded from: classes2.dex */
    class a implements f {
        a() {
        }

        @Override // com.scores365.tournamentPromotion.TournamentPromotionActivity.f
        public void a(e eVar, boolean z10, boolean z11) {
            Fragment fragment;
            String str = "notification_frg";
            boolean z12 = true;
            boolean z13 = false;
            try {
                if (z10) {
                    if (eVar == e.LANDING && !z11) {
                        if (TournamentPromotionActivity.this.getIntent() != null && TournamentPromotionActivity.this.getIntent().getExtras() != null && TournamentPromotionActivity.this.getIntent().getBooleanExtra("is_from_notification", false)) {
                            TournamentPromotionActivity.this.u1();
                        }
                        TournamentPromotionActivity.this.finish();
                        return;
                    } else if (!z11) {
                        TournamentPromotionActivity.this.onBackPressed();
                        return;
                    } else if (eVar == e.NOTIFICATIONS) {
                        TournamentPromotionActivity.this.t1();
                        return;
                    } else if (eVar == e.CHOOSE_COMPETITORS) {
                        try {
                            if (TournamentPromotionActivity.this.getSupportFragmentManager().j0("notification_frg") != null) {
                                k.n(App.m(), "wizard-tournament", "default_notification", "show", null, true, "promotion_id", String.valueOf(TournamentPromotionActivity.this.f24308b0.b()));
                            } else {
                                TournamentPromotionActivity.this.t1();
                            }
                            return;
                        } catch (Exception e10) {
                            x0.N1(e10);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                String str2 = "choose_competitors_frg";
                if (eVar == e.LANDING) {
                    if (TournamentPromotionActivity.this.f24308b0.c() == 2) {
                        TournamentPromotionActivity.this.I.setVisibility(0);
                        new Thread(new d(TournamentPromotionActivity.this)).start();
                        z12 = false;
                    } else {
                        boolean z14 = false;
                        for (CompetitionObj competitionObj : TournamentPromotionActivity.this.f24308b0.f35282g.f35316l.values()) {
                            int id2 = competitionObj.getID();
                            App.c cVar = App.c.LEAGUE;
                            if (!App.b.r(id2, cVar)) {
                                App.b.d(competitionObj.getID(), competitionObj, cVar, false);
                                App.b.y();
                                boolean z15 = p0.w0(competitionObj.getID()) > 0;
                                Context m10 = App.m();
                                String[] strArr = new String[16];
                                strArr[0] = "entity_type";
                                strArr[1] = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                                strArr[2] = "entity_id";
                                strArr[3] = String.valueOf(competitionObj.getID());
                                strArr[4] = "sport_type_id";
                                strArr[5] = String.valueOf(competitionObj.getSid());
                                strArr[6] = "is_wizard";
                                strArr[7] = "0";
                                strArr[8] = "is_sync";
                                strArr[9] = "0";
                                strArr[10] = ShareConstants.FEED_SOURCE_PARAM;
                                strArr[11] = "promotion";
                                strArr[12] = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS;
                                strArr[13] = "select";
                                strArr[14] = "is_minor_league";
                                strArr[15] = String.valueOf(z15 ? 1 : 0);
                                k.n(m10, "user-selection", "entity", "click", null, true, strArr);
                                z14 = true;
                            }
                        }
                        z13 = z14;
                    }
                    if (z13) {
                        x0.A2(null, null);
                    }
                    int intValue = TournamentPromotionActivity.this.f24308b0.f35282g.f35311g.iterator().next().intValue();
                    if (!TournamentPromotionActivity.this.f24308b0.f35281f.f35300e || App.f20803w || App.b.f0(App.c.LEAGUE, intValue)) {
                        TournamentPromotionActivity tournamentPromotionActivity = TournamentPromotionActivity.this;
                        fragment = ii.a.w1(tournamentPromotionActivity.f24308b0, tournamentPromotionActivity.k1());
                        str = "choose_competitors_frg";
                    } else {
                        fragment = com.scores365.tournamentPromotion.c.v1(TournamentPromotionActivity.this.f24309f0, TournamentPromotionActivity.this.f24308b0);
                    }
                    str2 = str;
                } else if (eVar != e.NOTIFICATIONS || App.f20803w) {
                    str2 = null;
                    fragment = null;
                } else {
                    TournamentPromotionActivity tournamentPromotionActivity2 = TournamentPromotionActivity.this;
                    fragment = ii.a.w1(tournamentPromotionActivity2.f24308b0, tournamentPromotionActivity2.k1());
                }
                if (z12) {
                    TournamentPromotionActivity.this.r1(fragment, str2);
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<TournamentPromotionActivity> f24311a;

        /* renamed from: b  reason: collision with root package name */
        long f24312b = 100;

        /* renamed from: c  reason: collision with root package name */
        int f24313c = 0;

        /* renamed from: d  reason: collision with root package name */
        long f24314d;

        /* loaded from: classes2.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ TournamentPromotionActivity f24315a;

            a(TournamentPromotionActivity tournamentPromotionActivity) {
                this.f24315a = tournamentPromotionActivity;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f24315a.I.setVisibility(8);
                    TournamentPromotionActivity tournamentPromotionActivity = this.f24315a;
                    tournamentPromotionActivity.q1(tournamentPromotionActivity.k1());
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        }

        public b(TournamentPromotionActivity tournamentPromotionActivity) {
            this.f24311a = new WeakReference<>(tournamentPromotionActivity);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f24314d = System.currentTimeMillis();
                WeakReference<TournamentPromotionActivity> weakReference = this.f24311a;
                TournamentPromotionActivity tournamentPromotionActivity = weakReference != null ? weakReference.get() : null;
                if (tournamentPromotionActivity != null) {
                    if (tournamentPromotionActivity.f24308b0 == null) {
                        new a.b(null, true).run();
                        tournamentPromotionActivity.f24308b0 = (nd.a) com.scores365.tournamentPromotion.a.g(tournamentPromotionActivity.getIntent().getExtras().getInt("competition_id_key"));
                    }
                    if (tournamentPromotionActivity.f24308b0 == null) {
                        int i10 = this.f24313c;
                        if (i10 < 20) {
                            this.f24312b *= 2;
                            this.f24313c = i10 + 1;
                            new ScheduledThreadPoolExecutor(1).schedule(this, this.f24312b, TimeUnit.MILLISECONDS);
                            return;
                        }
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        Iterator<Integer> it = tournamentPromotionActivity.f24308b0.f35282g.f35311g.iterator();
                        while (it.hasNext()) {
                            Integer next = it.next();
                            if (sb2.length() > 0) {
                                sb2.append(",");
                            }
                            sb2.append(next);
                        }
                        if (tournamentPromotionActivity.f24308b0.c() == 2) {
                            Iterator<Integer> it2 = tournamentPromotionActivity.f24308b0.f35282g.f35311g.iterator();
                            while (it2.hasNext()) {
                                Integer next2 = it2.next();
                                if (sb2.length() > 0) {
                                    sb2.append(",");
                                }
                                sb2.append(next2);
                            }
                        }
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                    m0 m0Var = new m0(4, false, new StringBuilder().toString(), sb2.toString(), "", -1, -1, -1, false);
                    m0Var.call();
                    ArrayList arrayList = new ArrayList(m0Var.a().getCompetitions());
                    h hVar = tournamentPromotionActivity.f24308b0.f35282g;
                    if (hVar.f35316l == null) {
                        hVar.f35316l = new HashMap<>();
                    }
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        CompetitionObj competitionObj = (CompetitionObj) it3.next();
                        tournamentPromotionActivity.f24308b0.f35282g.f35316l.put(Integer.valueOf(competitionObj.getID()), competitionObj);
                    }
                    h hVar2 = tournamentPromotionActivity.f24308b0.f35282g;
                    if (hVar2.f35317m == null) {
                        hVar2.f35317m = new HashMap<>();
                    }
                    tournamentPromotionActivity.runOnUiThread(new a(tournamentPromotionActivity));
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<TournamentPromotionActivity> f24317a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f24318b;

        public c(TournamentPromotionActivity tournamentPromotionActivity, boolean z10) {
            this.f24317a = new WeakReference<>(tournamentPromotionActivity);
            this.f24318b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment w12;
            String str;
            try {
                TournamentPromotionActivity tournamentPromotionActivity = this.f24317a.get();
                if (tournamentPromotionActivity != null) {
                    tournamentPromotionActivity.I.setVisibility(8);
                    if (this.f24318b) {
                        x0.A2(null, null);
                    }
                    int intValue = tournamentPromotionActivity.f24308b0.f35282g.f35311g.iterator().next().intValue();
                    if (!tournamentPromotionActivity.f24308b0.f35281f.f35300e || App.f20803w || sf.a.i0(App.m()).m1(intValue)) {
                        w12 = ii.a.w1(tournamentPromotionActivity.f24308b0, tournamentPromotionActivity.k1());
                        str = "choose_competitors_frg";
                    } else {
                        w12 = com.scores365.tournamentPromotion.c.v1(tournamentPromotionActivity.f24309f0, tournamentPromotionActivity.f24308b0);
                        str = "notification_frg";
                    }
                    tournamentPromotionActivity.r1(w12, str);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<TournamentPromotionActivity> f24319a;

        public d(TournamentPromotionActivity tournamentPromotionActivity) {
            this.f24319a = new WeakReference<>(tournamentPromotionActivity);
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            try {
                z10 = false;
                for (Integer num : com.scores365.tournamentPromotion.a.f24325f.keySet()) {
                    CompetitionObj X = sf.a.i0(App.m()).X(num.intValue());
                    int intValue = num.intValue();
                    App.c cVar = App.c.LEAGUE;
                    if (!App.b.r(intValue, cVar)) {
                        App.b.a(num.intValue(), X, cVar);
                        App.b.y();
                        boolean z11 = p0.w0(num.intValue()) > 0;
                        Context m10 = App.m();
                        String[] strArr = new String[16];
                        strArr[0] = "entity_type";
                        strArr[1] = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                        strArr[2] = "entity_id";
                        strArr[3] = String.valueOf(num);
                        strArr[4] = "sport_type_id";
                        strArr[5] = String.valueOf(X.getSid());
                        strArr[6] = "is_wizard";
                        strArr[7] = "0";
                        strArr[8] = "is_sync";
                        strArr[9] = "0";
                        strArr[10] = ShareConstants.FEED_SOURCE_PARAM;
                        strArr[11] = "promotion";
                        strArr[12] = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS;
                        strArr[13] = "select";
                        strArr[14] = "is_minor_league";
                        strArr[15] = String.valueOf(z11 ? 1 : 0);
                        k.n(m10, "user-selection", "entity", "click", null, true, strArr);
                        z10 = true;
                    }
                }
            } catch (Exception e10) {
                e = e10;
            }
            try {
                TournamentPromotionActivity tournamentPromotionActivity = this.f24319a.get();
                if (tournamentPromotionActivity != null) {
                    tournamentPromotionActivity.F.post(new c(tournamentPromotionActivity, z10));
                }
            } catch (Exception e11) {
                e = e11;
                x0.N1(e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum e {
        LANDING,
        NOTIFICATIONS,
        CHOOSE_COMPETITORS
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(e eVar, boolean z10, boolean z11);
    }

    public static Intent m1(boolean z10, int i10, String str) {
        Intent intent = new Intent(App.m(), TournamentPromotionActivity.class);
        try {
            intent.setFlags(268435456);
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_from_notification", z10);
            bundle.putInt("competition_id_key", i10);
            bundle.putString("screen_source_tag", str);
            intent.putExtras(bundle);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return intent;
    }

    private void o1() {
        try {
            if (getSupportActionBar() != null) {
                getSupportActionBar().k();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1(Fragment fragment, String str) {
        try {
            fragment.setEnterTransition(new Fade());
            fragment.setExitTransition(new Fade());
            getSupportFragmentManager().q().q(this.H.getId(), fragment, str).g(null).h();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void s1() {
        try {
            String str = "";
            if (getSupportFragmentManager().i0(R.id.f22168mk) instanceof com.scores365.tournamentPromotion.b) {
                str = "intro";
            } else if (getSupportFragmentManager().i0(R.id.f22168mk) instanceof com.scores365.tournamentPromotion.c) {
                str = "default_notification";
                this.f24309f0.a(e.NOTIFICATIONS, true, true);
            } else if (getSupportFragmentManager().i0(R.id.f22168mk) instanceof ii.a) {
                str = "teams";
                this.f24309f0.a(e.CHOOSE_COMPETITORS, true, true);
            }
            String str2 = str;
            if (str2.isEmpty()) {
                return;
            }
            k.n(App.m(), "wizard-tournament", str2, "back", "click", true, "promotion_id", String.valueOf(this.f24308b0.b()));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1() {
        try {
            k.n(App.m(), "wizard-tournament", "intro", "show", null, false, "promotion_id", String.valueOf(this.f24308b0.b()), ShareConstants.FEED_SOURCE_PARAM, k1());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1() {
        Intent x02 = x0.x0();
        x02.setFlags(268435456);
        x02.setFlags(67108864);
        startActivity(x02);
    }

    public static void v1(boolean z10, int i10, String str) {
        Intent intent = new Intent(App.m(), TournamentPromotionActivity.class);
        intent.setFlags(268435456);
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_from_notification", z10);
        bundle.putInt("competition_id_key", i10);
        bundle.putString("screen_source_tag", str);
        intent.putExtras(bundle);
        App.m().startActivity(intent);
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return "";
    }

    public String k1() {
        try {
            return (getIntent() == null || getIntent().getExtras() == null || !getIntent().getExtras().containsKey("screen_source_tag")) ? "" : getIntent().getExtras().getString("screen_source_tag", "");
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            s1();
            getSupportFragmentManager().f1();
            if (getSupportFragmentManager().p0() != 0) {
                getSupportFragmentManager().j0("notification_frg");
                return;
            }
            if (getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().getBoolean("is_from_notification", false)) {
                u1();
            }
            super.onBackPressed();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22659p6);
        try {
            f24307g0 = true;
            initActionBar(false);
            o1();
            this.H = (FrameLayout) findViewById(R.id.f22168mk);
            this.I = (RelativeLayout) findViewById(R.id.Jn);
            this.F = new Handler();
            this.f24308b0 = null;
            try {
                this.f24308b0 = (nd.a) com.scores365.tournamentPromotion.a.g(getIntent().getExtras().getInt("competition_id_key"));
            } catch (Exception e10) {
                x0.N1(e10);
            }
            this.I.setVisibility(0);
            new Thread(new b(this)).start();
            sf.b.X1().o7();
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onPause() {
        super.onPause();
        f24307g0 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        super.onResume();
        f24307g0 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStart() {
        super.onStart();
        try {
            nd.a aVar = this.f24308b0;
            if (aVar == null || aVar.b() <= 0) {
                return;
            }
            sf.b.X1().s3(this.f24308b0.b());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void q1(String str) {
        try {
            getSupportFragmentManager().q().q(R.id.f22168mk, com.scores365.tournamentPromotion.b.u1(this.f24309f0, this.f24308b0, str), "lanfing_frg").g(null).h();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
