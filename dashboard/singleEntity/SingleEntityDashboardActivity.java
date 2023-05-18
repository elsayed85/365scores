package com.scores365.dashboard.singleEntity;

import ag.u1;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import cc.c1;
import cc.o0;
import cc.r;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.scores365.App;
import com.scores365.Design.Activities.c;
import com.scores365.R;
import com.scores365.dashboard.singleEntity.SingleEntityDashboardActivity;
import com.scores365.entitys.BaseObj;
import com.scores365.entitys.HeaderObj;
import com.scores365.entitys.eDashboardSection;
import com.scores365.removeAds.RemoveAdsManager;
import com.scores365.ui.NoTeamDataActivity;
import li.x0;
import sc.i;
import uc.d;
import uc.f;
import xe.q;
import ze.k;
/* loaded from: classes2.dex */
public class SingleEntityDashboardActivity extends c implements u1.a.InterfaceC0018a, k {

    /* renamed from: h0  reason: collision with root package name */
    public static boolean f23400h0;
    public ConstraintLayout F;
    private RelativeLayout G;
    private HeaderObj H;
    private BaseObj I;

    /* renamed from: b0  reason: collision with root package name */
    public int f23401b0;

    /* renamed from: f0  reason: collision with root package name */
    private App.c f23402f0;

    /* renamed from: g0  reason: collision with root package name */
    private u1.a f23403g0 = null;

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23404a;

        static {
            int[] iArr = new int[App.c.values().length];
            f23404a = iArr;
            try {
                iArr[App.c.LEAGUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23404a[App.c.TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Intent h1(App.c cVar, int i10, eDashboardSection edashboardsection, String str, int i11, String str2) {
        Intent intent;
        Intent intent2 = null;
        try {
            intent = new Intent(App.m(), SingleEntityDashboardActivity.class);
        } catch (Exception e10) {
            e = e10;
        }
        try {
            intent.putExtra("entityType", cVar.getValue());
            intent.putExtra("entityId", i10);
            intent.putExtra("promotedItemTag", i11);
            if (edashboardsection != null) {
                intent.putExtra("startingTab", edashboardsection.getValue());
            }
            intent.putExtra("source_for_analytics", str);
            intent.putExtra(c.ENTITY_ENTRANCE_SOURCE, str2);
            return intent;
        } catch (Exception e11) {
            e = e11;
            intent2 = intent;
            x0.N1(e);
            return intent2;
        }
    }

    public static Intent i1(HeaderObj headerObj, App.c cVar, int i10, boolean z10, eDashboardSection edashboardsection, boolean z11, String str, String str2) {
        Intent intent = null;
        try {
            Intent intent2 = new Intent(App.m(), SingleEntityDashboardActivity.class);
            try {
                intent2.putExtra("header_tag", headerObj);
                intent2.putExtra(NoTeamDataActivity.IMAGE_VERSION_KEY, str2);
                intent2.putExtra("entityType", cVar.getValue());
                intent2.putExtra("entityId", i10);
                intent2.putExtra("shouldOpenTeamsTab", z10);
                intent2.putExtra("searchForFirstStandingPage", z11);
                if (edashboardsection != null) {
                    intent2.putExtra("startingTab", edashboardsection.getValue());
                }
                intent2.putExtra("source_for_analytics", str);
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

    public static Intent k1(HeaderObj headerObj, App.c cVar, int i10, boolean z10, eDashboardSection edashboardsection, boolean z11, String str, String str2, String str3) {
        Intent intent;
        try {
            intent = i1(headerObj, cVar, i10, z10, edashboardsection, z11, str, str2);
        } catch (Exception e10) {
            e = e10;
            intent = null;
        }
        try {
            intent.putExtra(c.ENTITY_ENTRANCE_SOURCE, str3);
        } catch (Exception e11) {
            e = e11;
            x0.N1(e);
            return intent;
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1() {
        try {
            if (getIntent() != null && getIntent().getBooleanExtra(c.IS_NOTIFICATION_ACTIVITY, false)) {
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

    private BaseObj q1() {
        BaseObj baseObj = this.I;
        if (baseObj == null) {
            App.c cVar = this.f23402f0;
            baseObj = cVar == App.c.TEAM ? sf.a.i0(App.m()).a0(this.f23401b0) : cVar == App.c.LEAGUE ? sf.a.i0(App.m()).X(this.f23401b0) : null;
            this.I = baseObj;
        }
        return baseObj;
    }

    private q r1() {
        for (Fragment fragment : getSupportFragmentManager().v0()) {
            if (fragment instanceof q) {
                return (q) fragment;
            }
        }
        ng.a.f35508a.a("SingleEntityDashboardActivity", "single entity page not found", new IllegalStateException("can't find single entity page"));
        return null;
    }

    private void relateViews() {
        try {
            this.G = (RelativeLayout) findViewById(R.id.ln);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void s1() {
        Intent intent = getIntent();
        Bundle bundle = intent == null ? new Bundle() : intent.getExtras();
        boolean z10 = bundle.getBoolean("shouldOpenTeamsTab", false);
        boolean z11 = bundle.getBoolean("searchForFirstStandingPage", false);
        if (intent != null) {
            this.f23401b0 = intent.getIntExtra("entityId", -1);
            this.f23402f0 = App.c.Create(intent.getIntExtra("entityType", -1));
            if (intent.hasExtra("header_tag")) {
                this.H = (HeaderObj) intent.getSerializableExtra("header_tag");
            }
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.f22129l3);
        this.F = constraintLayout;
        constraintLayout.setSystemUiVisibility(1280);
        getWindow().addFlags(67108864);
        relateViews();
        String stringExtra = intent == null ? "" : intent.getStringExtra(c.ENTITY_ENTRANCE_SOURCE);
        int intExtra = intent == null ? 0 : intent.getIntExtra("promotedItemTag", 0);
        int intExtra2 = intent != null ? intent.getIntExtra("startingTab", -1) : -1;
        q s22 = q.s2(this.f23402f0, this.f23401b0, true, intExtra, false, stringExtra);
        s22.M2(z10);
        s22.L2(z11);
        s22.O2(intExtra2);
        getSupportFragmentManager().q().q(R.id.Y5, s22, "fragmentTag").h();
    }

    private void setActivityResult() {
        Intent intent = new Intent();
        intent.putExtra("is_selection_changed", true);
        q r12 = r1();
        if (r12 == null || !r12.k2()) {
            return;
        }
        setResult(-1, intent);
    }

    private void setDeepLinkParams() {
        try {
            if (getIntent() == null || getIntent().getData() == null || getIntent().getData().getQueryParameter("entityid") == null || getIntent().getData().getQueryParameter("entityid").isEmpty()) {
                return;
            }
            App.c cVar = App.c.LEAGUE;
            String queryParameter = getIntent().getData().getQueryParameter("entitytype");
            if (!queryParameter.isEmpty()) {
                cVar = App.c.Create(Integer.parseInt(queryParameter));
            }
            getIntent().putExtra("entityType", cVar.getValue());
            getIntent().putExtra("entityId", Integer.valueOf(getIntent().getData().getQueryParameter("entityid")));
            getIntent().putExtra("startingTab", eDashboardSection.SCORES.getValue());
            getIntent().putExtra("source_for_analytics", SDKConstants.PARAM_TOURNAMENTS_DEEPLINK);
            getIntent().putExtra(c.IS_NOTIFICATION_ACTIVITY, true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public ViewGroup GetBannerHolderView() {
        return this.G;
    }

    @Override // ag.u1.a.InterfaceC0018a
    public void a(u1.a aVar) {
        this.f23403g0 = aVar;
    }

    protected void e1() {
        sc.k n10;
        try {
            i placement = getPlacement();
            if (placement == null || RemoveAdsManager.isUserAdsRemoved(App.m()) || (n10 = o0.n(placement)) == null) {
                return;
            }
            String str = o0.f10052d;
            Log.d(str, "Ad Behavior: " + n10.name() + " | placement: " + placement.name() + " | " + x0.F0());
            if (n10 != sc.k.Native) {
                r.l(this, this);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void g1(AdManagerAdRequest.Builder builder) {
        App.c cVar = this.f23402f0;
        if (cVar != null) {
            int i10 = a.f23404a[cVar.ordinal()];
            if (i10 == 1) {
                builder.addCustomTargeting("COMPETITION_ID", String.valueOf(this.f23401b0));
            } else if (i10 != 2) {
            } else {
                builder.addCustomTargeting("COMPETITOR_ID", String.valueOf(this.f23401b0));
            }
        }
    }

    public App.c getEntityType() {
        return this.f23402f0;
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        try {
            HeaderObj headerObj = this.H;
            return headerObj != null ? headerObj.getHeaderEntityObj().getName() : q1().getName();
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public i getPlacement() {
        return i.Dashboard;
    }

    @Override // ze.k
    public void k(BaseObj baseObj, App.c cVar, boolean z10) {
        q r12 = r1();
        if (r12 != null) {
            r12.T2(true);
        }
    }

    public int o1() {
        return this.f23401b0;
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        boolean z10;
        try {
            f23400h0 = false;
            Fragment j02 = getSupportFragmentManager().j0("fragmentTag");
            u1.a aVar = this.f23403g0;
            if (aVar == null || !aVar.f952c) {
                z10 = false;
            } else {
                aVar.a();
                z10 = true;
            }
            if (!z10 && (j02 instanceof q)) {
                z10 = ((q) j02).u2();
            }
            if (z10) {
                return;
            }
            if (getIntent() != null && getIntent().getBooleanExtra(c.IS_NOTIFICATION_ACTIVITY, false)) {
                Intent x02 = x0.x0();
                x02.setFlags(268435456);
                x02.setFlags(67108864);
                x02.putExtra("startFromGameNotif", true);
                startActivity(x02);
                super.onBackPressed();
                return;
            }
            setActivityResult();
            d n10 = ((App) getApplication()).n();
            f f10 = n10.i().f();
            if ((f10 instanceof f.e) && n10.u(this, (f.e) f10, new c1.a() { // from class: if.c
                @Override // cc.c1.a
                public final void a() {
                    SingleEntityDashboardActivity.this.m1();
                }
            })) {
                return;
            }
            m1();
        } catch (Exception e10) {
            x0.N1(e10);
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.D8);
        setDeepLinkParams();
        s1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        try {
            super.onNewIntent(intent);
            setIntent(intent);
            s1();
        } catch (Exception e10) {
            x0.N1(e10);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            e1();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public boolean showAdsForContext() {
        try {
            if (this.f23402f0 == App.c.LEAGUE) {
                return true ^ o0.y().b(this.f23401b0);
            }
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return true;
        }
    }

    public void t1(int i10) {
        q r12 = r1();
        if (r12 != null) {
            r12.J2(i10);
        }
    }

    public void u1(int i10) {
        q r12 = r1();
        if (r12 != null) {
            r12.K2(i10);
        }
    }

    public void v1(int i10) {
        q r12 = r1();
        if (r12 != null) {
            r12.N2(i10);
        }
    }

    public void w1(int i10) {
        q r12 = r1();
        if (r12 != null) {
            r12.P2(i10);
        }
    }

    public void x1(int i10) {
        q r12 = r1();
        if (r12 != null) {
            r12.S2(i10);
        }
    }
}
