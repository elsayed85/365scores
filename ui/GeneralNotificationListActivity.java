package com.scores365.ui;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.e1;
import com.scores365.App;
import com.scores365.R;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class GeneralNotificationListActivity extends com.scores365.Design.Activities.c {
    public static final String SPORT_TYPE_TAG = "sportType";
    GeneralNotificationListFragment generalNotificationListFragment;
    int sportType = -1;

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return App.l().getSportTypes().get(Integer.valueOf(this.sportType)).getName();
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        GeneralNotificationListFragment generalNotificationListFragment = this.generalNotificationListFragment;
        if (generalNotificationListFragment.isSomethingChanged) {
            generalNotificationListFragment.showOverrunDialog();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x0.j2(this);
        x0.D1(this);
        setContentView(R.layout.f22535g);
        try {
            this.sportType = getIntent().getIntExtra(SPORT_TYPE_TAG, -1);
            initActionBar();
            Toolbar toolbar = this.toolbar;
            if (toolbar != null) {
                e1.C0(toolbar, p0.s(4));
            }
            this.generalNotificationListFragment = GeneralNotificationListFragment.newInstance(this.sportType);
            getSupportFragmentManager().q().p(R.id.f22043h6, this.generalNotificationListFragment).h();
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
