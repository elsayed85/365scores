package com.scores365.Dashboard365TV;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.scores365.App;
import com.scores365.Design.Activities.c;
import com.scores365.Design.Pages.g;
import com.scores365.R;
import com.scores365.removeAds.RemoveAdsManager;
import li.p0;
import li.u;
import li.x0;
/* loaded from: classes2.dex */
public class DashboardTvActivity extends c {
    private ImageView F;
    private ImageView G;
    private ImageView H;
    private TextView I;

    /* renamed from: b0  reason: collision with root package name */
    private FrameLayout f20851b0;

    /* renamed from: f0  reason: collision with root package name */
    private LinearLayout f20852f0;

    /* renamed from: g0  reason: collision with root package name */
    private g f20853g0;

    /* renamed from: i0  reason: collision with root package name */
    private View f20855i0;

    /* renamed from: h0  reason: collision with root package name */
    private final Handler f20854h0 = new Handler();

    /* renamed from: j0  reason: collision with root package name */
    private final Runnable f20856j0 = new a();

    /* renamed from: k0  reason: collision with root package name */
    private final Runnable f20857k0 = new b();

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"InlinedApi"})
        public void run() {
            try {
                if (DashboardTvActivity.this.f20855i0 != null) {
                    DashboardTvActivity.this.f20855i0.setSystemUiVisibility(4871);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DashboardTvActivity.this.i1();
        }
    }

    @NonNull
    public static Intent g1(boolean z10) {
        return new Intent(App.m(), DashboardTvActivity.class).putExtra(c.IS_NOTIFICATION_ACTIVITY, z10);
    }

    private void h1(int i10) {
        this.f20854h0.removeCallbacks(this.f20857k0);
        this.f20854h0.postDelayed(this.f20857k0, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        getSupportActionBar();
        this.f20854h0.postDelayed(this.f20856j0, 300L);
    }

    private void relateViews() {
        try {
            this.f20852f0 = (LinearLayout) findViewById(R.id.Ns);
            this.F = (ImageView) findViewById(R.id.f22134l8);
            this.H = (ImageView) findViewById(R.id.kB);
            this.G = (ImageView) findViewById(R.id.lB);
            this.I = (TextView) findViewById(R.id.Zr);
            this.f20851b0 = (FrameLayout) findViewById(R.id.Az);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        try {
            return p0.l0("TV365_TITLE");
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public void k1(int i10) {
        try {
            q1();
            this.f20853g0 = ob.c.m2(i10, getIntent().getBooleanExtra(c.IS_NOTIFICATION_ACTIVITY, false));
            getSupportFragmentManager().q().p(R.id.Az, this.f20853g0).h();
            if (ob.a.l() && !RemoveAdsManager.isUserAdsRemoved(App.m())) {
                this.G.setVisibility(8);
                this.H.setVisibility(8);
            }
            if (x0.l1()) {
                this.G.setVisibility(0);
                this.H.setVisibility(8);
            } else {
                this.G.setVisibility(8);
                this.H.setVisibility(0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public boolean m1() {
        try {
            return ((double) getResources().getDisplayMetrics().density) >= 1.5d;
        } catch (Exception e10) {
            x0.N1(e10);
            return true;
        }
    }

    public void o1() {
        try {
            if (m1()) {
                u.x(ob.a.h(), this.F);
                this.F.getLayoutParams().height = p0.s(UserVerificationMethods.USER_VERIFY_PATTERN);
                this.I.setVisibility(8);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0050 A[Catch: Exception -> 0x005e, TRY_LEAVE, TryCatch #0 {Exception -> 0x005e, blocks: (B:13:0x004a, B:15:0x0050), top: B:25:0x004a }] */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            java.lang.String r0 = "key"
            super.onCreate(r7)
            int r7 = com.scores365.R.layout.f22496d
            r6.setContentView(r7)
            android.view.Window r7 = r6.getWindow()
            r1 = 128(0x80, float:1.794E-43)
            r7.addFlags(r1)
            r6.initActionBar()
            android.content.Intent r7 = r6.getIntent()
            r1 = -1
            android.content.Intent r2 = r6.getIntent()     // Catch: java.lang.NumberFormatException -> L41
            java.lang.String r3 = "videoUrlNotification"
            java.lang.String r2 = r2.getStringExtra(r3)     // Catch: java.lang.NumberFormatException -> L41
            android.content.Intent r3 = r6.getIntent()     // Catch: java.lang.NumberFormatException -> L41
            java.lang.String r4 = "isNotificationActivity"
            r5 = 0
            boolean r3 = r3.getBooleanExtra(r4, r5)     // Catch: java.lang.NumberFormatException -> L41
            if (r3 == 0) goto L45
            if (r2 == 0) goto L45
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch: java.lang.NumberFormatException -> L41
            java.lang.String r2 = r2.getQueryParameter(r0)     // Catch: java.lang.NumberFormatException -> L41
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.NumberFormatException -> L41
            goto L46
        L41:
            r2 = move-exception
            li.x0.N1(r2)
        L45:
            r2 = -1
        L46:
            if (r2 != r1) goto L63
            if (r7 == 0) goto L63
            android.net.Uri r3 = r7.getData()     // Catch: java.lang.Exception -> L5e
            if (r3 == 0) goto L63
            android.net.Uri r7 = r7.getData()     // Catch: java.lang.Exception -> L5e
            java.lang.String r7 = r7.getQueryParameter(r0)     // Catch: java.lang.Exception -> L5e
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Exception -> L5e
            r1 = r7
            goto L64
        L5e:
            r7 = move-exception
            li.x0.N1(r7)
            goto L64
        L63:
            r1 = r2
        L64:
            r6.relateViews()     // Catch: java.lang.Exception -> L6b
            r6.k1(r1)     // Catch: java.lang.Exception -> L6b
            goto L6f
        L6b:
            r7 = move-exception
            li.x0.N1(r7)
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Dashboard365TV.DashboardTvActivity.onCreate(android.os.Bundle):void");
    }

    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onDestroy() {
        g gVar = this.f20853g0;
        if (gVar != null && ((ob.c) gVar).W1() != null) {
            ((ob.c) this.f20853g0).w2(true);
            ((ob.c) this.f20853g0).W1().l(false);
        }
        getWindow().clearFlags(UserVerificationMethods.USER_VERIFY_PATTERN);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        try {
            if (menuItem.getItemId() != 16908332) {
                return false;
            }
            onBackPressed();
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onPause() {
        g gVar = this.f20853g0;
        if (gVar != null && ((ob.c) gVar).W1() != null) {
            ((ob.c) this.f20853g0).w2(true);
            ((ob.c) this.f20853g0).W1().l(false);
        }
        getWindow().clearFlags(UserVerificationMethods.USER_VERIFY_PATTERN);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        h1(100);
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        g gVar = this.f20853g0;
        if (gVar != null && ((ob.c) gVar).W1() != null) {
            ((ob.c) this.f20853g0).o2();
            ((ob.c) this.f20853g0).w2(false);
        }
        getWindow().addFlags(UserVerificationMethods.USER_VERIFY_PATTERN);
        super.onResume();
    }

    public void q1() {
        try {
            this.F.getLayoutParams().height = p0.s(48);
            this.F.setImageResource(0);
            this.F.setBackground(p0.J(App.m(), R.attr.A1));
            this.I.setVisibility(0);
            this.I.setText(p0.l0("TV365_TITLE"));
            this.f20852f0.setGravity(x0.l1() ? 5 : 19);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
