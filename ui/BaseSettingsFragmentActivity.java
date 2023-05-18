package com.scores365.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.core.view.e1;
import androidx.fragment.app.Fragment;
import com.facebook.share.internal.ShareConstants;
import com.scores365.R;
import com.scores365.dashboard.MainDashboardActivity;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class BaseSettingsFragmentActivity extends com.scores365.Design.Activities.c {

    /* loaded from: classes2.dex */
    public interface ShouldRestartRootActivityListener {
        boolean shouldRestartRootActivity();
    }

    @Override // com.scores365.Design.Activities.c
    public int getAppIcon() {
        return 0;
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        String pageTitle;
        String l02 = getIntent().getBooleanExtra("isOddsSettings", false) ? p0.l0("SETTINGS_ODDS") : getIntent().getBooleanExtra("isMyScores", false) ? p0.l0("MY_SCORES_SETTINGS") : !getIntent().getBooleanExtra("isTimeSettings", false) ? p0.l0("SETTINGS_TITLE") : p0.l0("TIME_ZONE_SETTINGS");
        try {
            Fragment i02 = getSupportFragmentManager().i0(R.id.Ae);
            return (!(i02 instanceof com.scores365.Design.Pages.a) || (pageTitle = ((com.scores365.Design.Pages.a) i02).getPageTitle()) == null) ? l02 : !pageTitle.isEmpty() ? pageTitle : l02;
        } catch (Exception e10) {
            x0.N1(e10);
            return l02;
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            x0.V0(this);
            Fragment i02 = getSupportFragmentManager().i0(R.id.Ae);
            if (!(i02 instanceof ShouldRestartRootActivityListener) || !((ShouldRestartRootActivityListener) i02).shouldRestartRootActivity()) {
                if (MainDashboardActivity.Z0) {
                    MainDashboardActivity.Z0 = false;
                    Intent intent = new Intent();
                    intent.putExtra("update_dashboard", true);
                    setResult(-1, intent);
                }
                super.onBackPressed();
                return;
            }
            Intent x02 = x0.x0();
            x02.setFlags(268435456);
            x02.setFlags(67108864);
            startActivity(x02);
            String str = "language";
            if ((i02 instanceof NewsSubSettingsFragment) && ((NewsSubSettingsFragment) i02).isNewsSourcesChanged()) {
                str = ((NewsSubSettingsFragment) i02).isLanguageChanged() ? "both" : ShareConstants.FEED_SOURCE_PARAM;
            }
            LocalizationSettingsActivity.sendSettingsChangedAnalyticsEvent(str);
        } catch (Exception e10) {
            x0.N1(e10);
            super.onBackPressed();
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        Fragment fragment;
        x0.j2(this);
        super.onCreate(bundle);
        x0.D1(this);
        setContentView(R.layout.f22752x3);
        e1.I0(findViewById(R.id.Fn), x0.m0());
        boolean z14 = false;
        try {
            z10 = getIntent().getBooleanExtra("isSelectNewsSource", false);
        } catch (Exception e10) {
            x0.N1(e10);
            z10 = false;
        }
        try {
            z11 = getIntent().getBooleanExtra("isTimeSettings", false);
        } catch (Exception e11) {
            x0.N1(e11);
            z11 = false;
        }
        try {
            z12 = getIntent().getBooleanExtra("isOddsSettings", false);
        } catch (Exception e12) {
            x0.N1(e12);
            z12 = false;
        }
        try {
            z13 = getIntent().getBooleanExtra("isNewsSubMenu", false);
        } catch (Exception e13) {
            x0.N1(e13);
            z13 = false;
        }
        try {
            z14 = getIntent().getBooleanExtra("isMyScores", false);
        } catch (Exception e14) {
            x0.N1(e14);
        }
        try {
            initActionBar();
            String str = "";
            if (z10) {
                fragment = SelectNewsSourceFragment.newInstance();
                str = "select_news_source";
                this.toolbar.setVisibility(8);
            } else if (z11) {
                fragment = TimeSettingsFragment.newInstance();
                str = "time_settings";
            } else if (z12) {
                fragment = OddsSettingsFragment.newInstance();
                str = "odds_settings";
            } else if (z13) {
                fragment = NewsSubSettingsFragment.newInstance();
                str = "news_settings";
            } else if (z14) {
                fragment = MyScoresSettingsFragment.newInstance();
                str = "my_scores";
            } else {
                fragment = null;
            }
            getSupportFragmentManager().q().q(R.id.Ae, fragment, str).h();
        } catch (Exception e15) {
            x0.N1(e15);
        }
        try {
            this.toolbar.setElevation(p0.s(4));
        } catch (Exception e16) {
            x0.N1(e16);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        try {
            onBackPressed();
            return true;
        } catch (Exception e10) {
            onBackPressed();
            x0.N1(e10);
            return true;
        }
    }
}
