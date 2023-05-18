package com.scores365.Pages.stats;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import com.facebook.appevents.AppEventsConstants;
import com.scores365.App;
import com.scores365.Design.Activities.c;
import com.scores365.Pages.stats.a;
import com.scores365.R;
import ee.k;
import java.util.ArrayList;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class FullPlayersStateActivity extends c implements a.InterfaceC0238a {
    RelativeLayout F;
    private com.scores365.Pages.stats.a G;
    private int H;
    private ArrayList<Integer> I;

    /* renamed from: b0  reason: collision with root package name */
    private String f21308b0;

    /* renamed from: f0  reason: collision with root package name */
    private String f21309f0;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                FullPlayersStateActivity.this.F.setVisibility(8);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public static void d1(int i10, ArrayList<Integer> arrayList, String str, String str2, String str3, boolean z10, boolean z11, boolean z12) {
        try {
            Intent intent = new Intent(App.m(), FullPlayersStateActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("state_name_key", str2);
            bundle.putInt("competition_id_key", i10);
            bundle.putString("pageContextId", str);
            bundle.putString("request_key", str3);
            bundle.putBoolean("isTeamStats", z10);
            bundle.putBoolean("isLeagueStats", z11);
            bundle.putBoolean("isTeamNational", z12);
            bundle.putIntegerArrayList("states_key", arrayList);
            intent.putExtras(bundle);
            intent.addFlags(268435456);
            App.m().startActivity(intent);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        try {
            return getIntent().getStringExtra("state_name_key");
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        x0.j2(this);
        super.onCreate(bundle);
        x0.D1(this);
        setContentView(R.layout.f22659p6);
        initActionBar();
        try {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Jn);
            this.F = relativeLayout;
            relativeLayout.setVisibility(0);
            this.H = getIntent().getIntExtra("competition_id_key", -1);
            this.f21308b0 = getIntent().getStringExtra("pageContextId");
            this.I = getIntent().getIntegerArrayListExtra("states_key");
            this.f21309f0 = getIntent().getStringExtra("state_name_key");
            com.scores365.Pages.stats.a aVar = new com.scores365.Pages.stats.a(this, getIntent().getExtras().getString("request_key", ""));
            this.G = aVar;
            aVar.execute(new Void[0]);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            getMenuInflater().inflate(R.menu.f22785b, menu);
            MenuItem findItem = menu.findItem(R.id.f22036h);
            findItem.setTitle(p0.l0("SHARE_ITEM"));
            findItem.setVisible(false);
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            k.n(App.m(), "dashboard", "stats", "statisticTitle", "back", true, "entity_type", AppEventsConstants.EVENT_PARAM_VALUE_YES, "entity_id", String.valueOf(this.H), "statisticTitle", this.f21308b0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007e  */
    @Override // com.scores365.Pages.stats.a.InterfaceC0238a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s(com.scores365.entitys.ChartDashboardData r22) {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r2 = "isTeamStats"
            java.lang.String r3 = ""
            com.scores365.entitys.SportTypesEnum r0 = com.scores365.entitys.SportTypesEnum.SOCCER     // Catch: java.lang.Exception -> Lc9
            int r4 = r0.getValue()     // Catch: java.lang.Exception -> Lc9
            r6 = r22
            com.scores365.entitys.CompetitionObj r0 = r6.competitionObj     // Catch: java.lang.Exception -> L17
            if (r0 == 0) goto L1b
            int r4 = r0.getSid()     // Catch: java.lang.Exception -> L17
            goto L1b
        L17:
            r0 = move-exception
            li.x0.N1(r0)     // Catch: java.lang.Exception -> Lc9
        L1b:
            r20 = r4
            r4 = 1
            r5 = 0
            com.scores365.entitys.InitObj r0 = com.scores365.App.l()     // Catch: java.lang.Exception -> L66
            java.util.LinkedHashMap r0 = r0.getSportTypes()     // Catch: java.lang.Exception -> L66
            java.lang.Integer r7 = java.lang.Integer.valueOf(r20)     // Catch: java.lang.Exception -> L66
            java.lang.Object r0 = r0.get(r7)     // Catch: java.lang.Exception -> L66
            com.scores365.entitys.SportTypeObj r0 = (com.scores365.entitys.SportTypeObj) r0     // Catch: java.lang.Exception -> L66
            java.util.LinkedHashMap<java.lang.Integer, com.scores365.entitys.AthletesStatisticTypeObj> r0 = r0.athleteStatics     // Catch: java.lang.Exception -> L66
            java.util.ArrayList<java.lang.Integer> r7 = r1.I     // Catch: java.lang.Exception -> L66
            java.lang.Object r7 = r7.get(r5)     // Catch: java.lang.Exception -> L66
            java.lang.Object r0 = r0.get(r7)     // Catch: java.lang.Exception -> L66
            com.scores365.entitys.AthletesStatisticTypeObj r0 = (com.scores365.entitys.AthletesStatisticTypeObj) r0     // Catch: java.lang.Exception -> L66
            java.lang.String r7 = r0.name     // Catch: java.lang.Exception -> L66
            com.scores365.entitys.InitObj r0 = com.scores365.App.l()     // Catch: java.lang.Exception -> L64
            java.util.LinkedHashMap r0 = r0.getSportTypes()     // Catch: java.lang.Exception -> L64
            java.lang.Integer r8 = java.lang.Integer.valueOf(r20)     // Catch: java.lang.Exception -> L64
            java.lang.Object r0 = r0.get(r8)     // Catch: java.lang.Exception -> L64
            com.scores365.entitys.SportTypeObj r0 = (com.scores365.entitys.SportTypeObj) r0     // Catch: java.lang.Exception -> L64
            java.util.LinkedHashMap<java.lang.Integer, com.scores365.entitys.AthletesStatisticTypeObj> r0 = r0.athleteStatics     // Catch: java.lang.Exception -> L64
            java.util.ArrayList<java.lang.Integer> r8 = r1.I     // Catch: java.lang.Exception -> L64
            java.lang.Object r8 = r8.get(r4)     // Catch: java.lang.Exception -> L64
            java.lang.Object r0 = r0.get(r8)     // Catch: java.lang.Exception -> L64
            com.scores365.entitys.AthletesStatisticTypeObj r0 = (com.scores365.entitys.AthletesStatisticTypeObj) r0     // Catch: java.lang.Exception -> L64
            java.lang.String r3 = r0.name     // Catch: java.lang.Exception -> L64
            goto L6b
        L64:
            r0 = move-exception
            goto L68
        L66:
            r0 = move-exception
            r7 = r3
        L68:
            li.x0.N1(r0)     // Catch: java.lang.Exception -> Lc9
        L6b:
            r13 = r3
            r12 = r7
            ad.m r0 = new ad.m     // Catch: java.lang.Exception -> Lc9
            java.lang.String r7 = ""
            r8 = 1
            android.content.Intent r3 = r21.getIntent()     // Catch: java.lang.Exception -> Lc9
            boolean r3 = r3.getBooleanExtra(r2, r5)     // Catch: java.lang.Exception -> Lc9
            if (r3 != 0) goto L7e
            r9 = 1
            goto L7f
        L7e:
            r9 = 0
        L7f:
            sc.i r10 = sc.i.Dashboard     // Catch: java.lang.Exception -> Lc9
            int r11 = r1.H     // Catch: java.lang.Exception -> Lc9
            java.lang.String r14 = "stats"
            java.lang.String r15 = r1.f21308b0     // Catch: java.lang.Exception -> Lc9
            r16 = 0
            android.content.Intent r3 = r21.getIntent()     // Catch: java.lang.Exception -> Lc9
            boolean r17 = r3.getBooleanExtra(r2, r5)     // Catch: java.lang.Exception -> Lc9
            android.content.Intent r2 = r21.getIntent()     // Catch: java.lang.Exception -> Lc9
            java.lang.String r3 = "isLeagueStats"
            boolean r18 = r2.getBooleanExtra(r3, r5)     // Catch: java.lang.Exception -> Lc9
            android.content.Intent r2 = r21.getIntent()     // Catch: java.lang.Exception -> Lc9
            java.lang.String r3 = "isTeamNational"
            boolean r19 = r2.getBooleanExtra(r3, r5)     // Catch: java.lang.Exception -> Lc9
            r5 = r0
            r6 = r22
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch: java.lang.Exception -> Lc9
            androidx.fragment.app.FragmentManager r2 = r21.getSupportFragmentManager()     // Catch: java.lang.Exception -> Lc9
            androidx.fragment.app.a0 r2 = r2.q()     // Catch: java.lang.Exception -> Lc9
            int r3 = com.scores365.R.id.f22168mk     // Catch: java.lang.Exception -> Lc9
            com.scores365.Design.Pages.a r0 = r0.CreatePage()     // Catch: java.lang.Exception -> Lc9
            androidx.fragment.app.a0 r0 = r2.p(r3, r0)     // Catch: java.lang.Exception -> Lc9
            r0.h()     // Catch: java.lang.Exception -> Lc9
            com.scores365.Pages.stats.FullPlayersStateActivity$a r0 = new com.scores365.Pages.stats.FullPlayersStateActivity$a     // Catch: java.lang.Exception -> Lc9
            r0.<init>()     // Catch: java.lang.Exception -> Lc9
            r1.runOnUiThread(r0)     // Catch: java.lang.Exception -> Lc9
            goto Lcd
        Lc9:
            r0 = move-exception
            li.x0.N1(r0)
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Pages.stats.FullPlayersStateActivity.s(com.scores365.entitys.ChartDashboardData):void");
    }
}
