package com.scores365.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.scores365.App;
import com.scores365.R;
import java.util.ArrayList;
import li.o0;
import li.x0;
/* loaded from: classes2.dex */
public class StandingsAndFixturesInnerActivity extends com.scores365.Design.Activities.c {
    private String d1() {
        try {
            return getIntent().getStringExtra("subtitleText");
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    private String e1() {
        try {
            return getIntent().getStringExtra("titleText");
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    private void g1() {
        try {
            this.toolbar.setSubtitle(d1());
            this.toolbar.setTitle(e1());
            if (this.toolbar != null) {
                for (int i10 = 0; i10 < this.toolbar.getChildCount(); i10++) {
                    if (this.toolbar.getChildAt(i10) instanceof TextView) {
                        ((TextView) this.toolbar.getChildAt(i10)).setTypeface(o0.d(App.m()));
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return "";
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            setResult(-1, new Intent());
        } catch (Exception e10) {
            x0.N1(e10);
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22506d9);
        try {
            initActionBar();
            g1();
            int intExtra = getIntent().getIntExtra("innerScreenTypeTag", -3);
            int intExtra2 = getIntent().getIntExtra("competitionIdTag", -1);
            int intExtra3 = getIntent().getIntExtra("innerSportId", 1);
            int intExtra4 = getIntent().getIntExtra("innerUserLanguage", 1);
            int intExtra5 = getIntent().getIntExtra("countryIdTag", -5);
            int intExtra6 = getIntent().getIntExtra("innerUserShowAllEntityID", -1);
            boolean booleanExtra = getIntent().getBooleanExtra("isOnboardingContext", false);
            String stringExtra = getIntent().getStringExtra("sourceForAnalytics");
            if (stringExtra == null) {
                stringExtra = "all-standings";
            }
            getSupportFragmentManager().q().q(R.id.X3, ac.d.N1(intExtra, intExtra2, intExtra3, intExtra4, intExtra5, getIntent().getStringExtra("tennisRequestUrl"), intExtra6, booleanExtra, stringExtra, (ArrayList) getIntent().getSerializableExtra("competitionsListTag"), getIntent().getBooleanExtra("isDoubleInnerScreen", false)), "tables_settings").h();
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
}
