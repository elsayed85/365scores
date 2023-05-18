package com.scores365.dashboard;

import ac.b;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.core.view.e1;
import com.scores365.App;
import com.scores365.R;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class AllNewsActivity extends com.scores365.Design.Activities.c {
    private final b.d F = b.d.NEWS;

    @NonNull
    public static Intent d1() {
        return new Intent(App.m(), AllNewsActivity.class);
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        b.d dVar = this.F;
        if (dVar != null) {
            if (dVar == b.d.VIDEOS) {
                return p0.l0("MOBILE_MENU_VIDEOS");
            }
            if (dVar == b.d.NEWS) {
                return p0.l0("NEWS_BY_TEAM");
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22748x);
        initActionBar();
        getToolbar().setBackgroundColor(getResources().getColor(R.color.f21611a));
        e1.C0(getToolbar(), p0.r(4.0f));
        getSupportFragmentManager().q().q(R.id.f22147m, ac.b.T1(null, b.d.NEWS), "all_news").h();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        try {
            onBackPressed();
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }
}
