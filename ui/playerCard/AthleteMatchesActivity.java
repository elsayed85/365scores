package com.scores365.ui.playerCard;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.fragment.app.a0;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.AthleteObj;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class AthleteMatchesActivity extends com.scores365.Design.Activities.c {
    public static final String ALL_MATCHES_LINK = "allMatchesLink";
    public static final String ATHLETE_ID = "athleteId";
    public static final String ATHLETE_OBJ_TAG = "athleteObj";
    public static final String ATHLETE_SHORT_NAME = "athleteName";
    public static final String PAGE_TITLE = "pageTitle";

    public static Intent getActivityIntent(String str, int i10, String str2, AthleteObj athleteObj, String str3) {
        Intent intent = new Intent(App.m(), AthleteMatchesActivity.class);
        intent.putExtra(ALL_MATCHES_LINK, str);
        intent.putExtra("athleteId", i10);
        intent.putExtra(ATHLETE_SHORT_NAME, str2);
        intent.putExtra(ATHLETE_OBJ_TAG, athleteObj);
        intent.putExtra(PAGE_TITLE, str3);
        return intent;
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        try {
            return getIntent().getExtras().getString(PAGE_TITLE, p0.l0("NEW_PLAYER_CARD_SOCCER_LAST_MATCHES_TITLE"));
        } catch (Exception unused) {
            return p0.l0("NEW_PLAYER_CARD_SOCCER_LAST_MATCHES_TITLE");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        AthleteObj athleteObj;
        super.onCreate(bundle);
        setContentView(R.layout.f22752x3);
        initActionBar();
        getSupportActionBar().C(getIntent().getStringExtra(ATHLETE_SHORT_NAME));
        a0 q10 = getSupportFragmentManager().q();
        try {
            athleteObj = (AthleteObj) getIntent().getSerializableExtra(ATHLETE_OBJ_TAG);
        } catch (Exception e10) {
            x0.N1(e10);
            athleteObj = null;
        }
        q10.q(R.id.Ae, AthleteMatchesPage.newInstance(getIntent().getStringExtra(ALL_MATCHES_LINK), getIntent().getIntExtra("athleteId", -1), athleteObj), "allMatches").h();
        try {
            this.toolbar.setElevation(p0.s(4));
            if (this.toolbar != null) {
                for (int i10 = 0; i10 < this.toolbar.getChildCount(); i10++) {
                    if (this.toolbar.getChildAt(i10) instanceof TextView) {
                        ((TextView) this.toolbar.getChildAt(i10)).setTypeface(o0.d(App.m()));
                    }
                }
            }
        } catch (Exception e11) {
            x0.N1(e11);
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
