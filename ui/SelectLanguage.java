package com.scores365.ui;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.core.view.e1;
import com.facebook.appevents.AppEventsConstants;
import com.scores365.R;
import com.scores365.ui.settings.SelectLanguageFragment;
import li.p0;
import li.x0;
import li.z0;
/* loaded from: classes2.dex */
public class SelectLanguage extends com.scores365.Design.Activities.c {
    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return p0.l0("SETTINGS_SELECT_YOUR_LANGUAGE");
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        z0.g();
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x0.j2(this);
        x0.D1(this);
        setContentView(R.layout.f22544g8);
        e1.I0(findViewById(R.id.Fn), x0.m0());
        String action = getIntent().getAction();
        if (action == null) {
            action = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        }
        getSupportFragmentManager().q().p(R.id.f22065i6, SelectLanguageFragment.newInstance(action)).h();
        initActionBar();
        try {
            this.toolbar.setElevation(p0.s(4));
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
}
