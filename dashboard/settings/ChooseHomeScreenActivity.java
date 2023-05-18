package com.scores365.dashboard.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.scores365.Design.Activities.c;
import com.scores365.R;
import hf.a;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class ChooseHomeScreenActivity extends c {
    public static Intent d1(Context context) {
        return new Intent(context, ChooseHomeScreenActivity.class);
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return p0.l0("HOME_PAGE_BUTTON_CHOOSE");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.K0);
        try {
            initActionBar();
            getSupportFragmentManager().q().p(R.id.f22065i6, a.x1()).h();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        try {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            onBackPressed();
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return true;
        }
    }
}
