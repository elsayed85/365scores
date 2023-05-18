package com.scores365.ui;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.e1;
import com.scores365.R;
import com.scores365.ui.settings.GeneralNotificationsFragment;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class GeneralNotifications extends com.scores365.Design.Activities.c {
    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return p0.l0("GENERAL_NOTIFICATIONS");
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x0.j2(this);
        x0.D1(this);
        setContentView(R.layout.f22526f3);
        e1.I0(findViewById(R.id.Fn), x0.m0());
        initActionBar();
        getSupportFragmentManager().q().p(R.id.f21906b6, GeneralNotificationsFragment.newInstance()).h();
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setElevation(p0.s(4));
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
