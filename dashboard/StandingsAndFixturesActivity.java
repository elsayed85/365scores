package com.scores365.dashboard;

import android.os.Bundle;
import android.view.MenuItem;
import com.scores365.R;
import id.g;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class StandingsAndFixturesActivity extends com.scores365.Design.Activities.c {
    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        try {
            return p0.l0("NEW_DASHBOARD_COMPETITION");
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22480b9);
        try {
            initActionBar();
            getSupportFragmentManager().q().q(R.id.X3, ac.c.d2(), "tables_settings").h();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            g.e().b();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
