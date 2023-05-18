package com.scores365.Design.Activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.c0;
import cc.c1;
import cc.e1;
import cc.z0;
import com.flurry.android.FlurryAgent;
import com.scores365.App;
import com.scores365.R;
import ee.k;
import li.o0;
import li.p0;
import li.x0;
import sc.i;
import uc.f;
/* compiled from: BaseActionBarActivity.java */
/* loaded from: classes2.dex */
public abstract class c extends androidx.appcompat.app.d implements e1 {
    public static final String ENTITY_ENTRANCE_SOURCE = "entityEntranceSource";
    public static final String IS_NOTIFICATION_ACTIVITY = "isNotificationActivity";
    public static final String NOTIFICATION_ANALTICS_EVENT = "notificationAnalyticsEvent";
    public static final String NOTIFICATION_URL_GUID = "notificationUrlGuid";
    private static boolean activityVisible = false;
    public static int fragmentSpanSize = 1;
    protected Toolbar toolbar;
    public App.c entityType = null;
    public int EntityID = -1;
    protected z0 bannerHandler = null;
    protected z0 mpuHandler = null;
    private boolean lockOpeningActivity = false;

    public static void activityPaused() {
        activityVisible = false;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static boolean isActivityVisible() {
        return activityVisible;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreate$0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(uc.d dVar, uc.f fVar) {
        if (fVar instanceof f.e) {
            f.e eVar = (f.e) fVar;
            if (eVar.b().g()) {
                dVar.u(this, eVar, new c1.a() { // from class: com.scores365.Design.Activities.a
                    @Override // cc.c1.a
                    public final void a() {
                        c.lambda$onCreate$0();
                    }
                });
            }
        }
    }

    private void setTitle(Toolbar toolbar) {
        if (toolbar != null) {
            toolbar.setTitle(getPageTitle());
            toolbar.setTitleTextColor(p0.A(R.attr.B1));
            for (int i10 = 0; i10 < toolbar.getChildCount(); i10++) {
                View childAt = toolbar.getChildAt(i10);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTypeface(o0.d(this));
                }
            }
        }
    }

    @Override // cc.e1
    public ViewGroup GetBannerHolderView() {
        return null;
    }

    public void HandleToolbarOptions(Toolbar toolbar) {
        if (toolbar != null) {
            toolbar.getMenu().clear();
        }
    }

    public void RefreshActionbar() {
        int homeIcon = getHomeIcon();
        if (homeIcon != -1) {
            this.toolbar.setNavigationIcon(homeIcon);
        }
        setTitle(this.toolbar);
        HandleToolbarOptions(this.toolbar);
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.D(getPageTitle());
            int appIcon = getAppIcon();
            if (appIcon != -1) {
                supportActionBar.z(appIcon);
            }
        }
    }

    public int getAppIcon() {
        return -1;
    }

    @Override // cc.e1
    public z0 getCurrBanner() {
        return this.bannerHandler;
    }

    public int getHomeIcon() {
        return R.drawable.f21696e1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public uc.d getInterstitialController() {
        return ((App) getApplication()).n();
    }

    @Override // cc.e1
    public z0 getMpuHandler() {
        return this.mpuHandler;
    }

    public abstract String getPageTitle();

    @Override // cc.e1
    public i getPlacement() {
        return null;
    }

    public Toolbar getToolbar() {
        return this.toolbar;
    }

    public void initActionBar() {
        initActionBar(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initActionBar(boolean z10) {
        try {
            relateToolbar();
            Toolbar toolbar = this.toolbar;
            if (toolbar != null) {
                androidx.core.view.e1.I0(toolbar, x0.m0());
                setSupportActionBar(this.toolbar);
                androidx.appcompat.app.a supportActionBar = getSupportActionBar();
                if (supportActionBar == null) {
                    return;
                }
                supportActionBar.t(true);
                supportActionBar.y(true);
                if (z10) {
                    supportActionBar.v(true);
                    supportActionBar.A(androidx.core.content.res.h.f(getResources(), R.drawable.f21734j, getTheme()));
                } else {
                    supportActionBar.v(false);
                }
                supportActionBar.x(R.drawable.f21801r2);
                supportActionBar.w(0.0f);
                RefreshActionbar();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // cc.e1
    public boolean isBannerNeedToBeShown() {
        return isBannerNeedToBeVisible();
    }

    @Override // cc.e1
    public boolean isBannerNeedToBeVisible() {
        return true;
    }

    public boolean isOpeningActivityLocked() {
        return this.lockOpeningActivity;
    }

    public boolean isStartedFromNotification() {
        try {
            if (getIntent() == null || getIntent().getExtras() == null) {
                return false;
            }
            return getIntent().getExtras().getBoolean(IS_NOTIFICATION_ACTIVITY);
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public void lockUnLockActivityOpening() {
        this.lockOpeningActivity = !this.lockOpeningActivity;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            x0.V0(this);
            if (getIntent().getBooleanExtra(IS_NOTIFICATION_ACTIVITY, false) && App.f20792l.l()) {
                startActivity(x0.x0());
                finish();
            } else {
                super.onBackPressed();
            }
        } catch (Exception e10) {
            x0.N1(e10);
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.d, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setItemsSpanForPages();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setActivityTheme();
        try {
            initActionBar();
            App.M(getApplicationContext());
            setItemsSpanForPages();
        } catch (Exception e10) {
            x0.N1(e10);
        }
        Intent intent = getIntent();
        if (intent == null) {
            intent = new Intent();
        }
        k.A(this, intent);
        if (intent.getBooleanExtra("NewVersionPopup", false)) {
            pg.e.f36658a.h(getSupportFragmentManager());
        } else if (intent.getBooleanExtra(IS_NOTIFICATION_ACTIVITY, false) || !showAdsForContext()) {
        } else {
            final uc.d interstitialController = getInterstitialController();
            interstitialController.i().j(this, new c0() { // from class: com.scores365.Design.Activities.b
                @Override // androidx.lifecycle.c0
                public final void d(Object obj) {
                    c.this.lambda$onCreate$1(interstitialController, (uc.f) obj);
                }
            });
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        HandleToolbarOptions(this.toolbar);
        return super.onCreateOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onDestroy() {
        try {
            z0 z0Var = this.bannerHandler;
            if (z0Var != null) {
                z0Var.o();
                this.bannerHandler = null;
            }
            super.onDestroy();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, android.app.Activity
    public void onPause() {
        try {
            activityPaused();
            z0 z0Var = this.bannerHandler;
            if (z0Var != null) {
                z0Var.p(true);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        try {
            super.onPause();
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        try {
            try {
                activityResumed();
                z0 z0Var = this.bannerHandler;
                if (z0Var != null) {
                    z0Var.C();
                }
                Toolbar toolbar = this.toolbar;
                if (toolbar != null) {
                    androidx.core.view.e1.I0(toolbar, x0.m0());
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            super.onResume();
            App.M(getApplicationContext());
            startBet365SurveyActivity();
        } catch (Throwable th2) {
            super.onResume();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStart() {
        try {
            super.onStart();
            FlurryAgent.onStartSession(this);
            z0 z0Var = this.bannerHandler;
            if (z0Var != null) {
                z0Var.F();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStop() {
        try {
            super.onStop();
            z0 z0Var = this.bannerHandler;
            if (z0Var != null) {
                z0Var.q();
            }
            FlurryAgent.onEndSession(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void relateToolbar() {
        this.toolbar = (Toolbar) findViewById(R.id.f21968e);
    }

    protected void setActivityTheme() {
        try {
            if (shouldSetTheme()) {
                if (App.f20805y == -1) {
                    if (x0.n1()) {
                        App.f20805y = R.style.f22831f;
                    } else {
                        App.f20805y = R.style.f22830e;
                    }
                }
                setTheme(App.f20805y);
                App.f20804x = getTheme();
                p0.E0(this, 0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // cc.e1
    public void setBannerHandler(z0 z0Var) {
        this.bannerHandler = z0Var;
    }

    public void setItemsSpanForPages() {
        if (App.f20803w && getResources().getConfiguration().orientation == 1) {
            fragmentSpanSize = 2;
        } else if (App.f20803w && getResources().getConfiguration().orientation == 2) {
            fragmentSpanSize = 3;
        } else {
            fragmentSpanSize = 1;
        }
    }

    @Override // cc.e1
    public void setMpuHandler(z0 z0Var) {
        this.mpuHandler = z0Var;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    protected boolean shouldSetTheme() {
        return true;
    }

    @Override // cc.e1
    public boolean showAdsForContext() {
        return true;
    }

    public void startActivityForResultWithLock(Intent intent, int i10) {
        try {
            if (isOpeningActivityLocked()) {
                lockUnLockActivityOpening();
                startActivityForResult(intent, i10);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected void startBet365SurveyActivity() {
        je.b.f32619a.k();
    }
}
