package com.scores365.ui;

import android.os.Bundle;
import android.view.MenuItem;
import com.amazon.device.ads.DtbConstants;
import com.scores365.R;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class ChooseThemeActivity extends com.scores365.Design.Activities.c {
    ChooseThemeFragment themeFragment;

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return p0.l0("MOBILE_MENU_SET_BACKGROUND");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x0.D1(this);
        x0.i2(this, 360, DtbConstants.VIDEO_WIDTH);
        setContentView(R.layout.L0);
        initActionBar();
        if (findViewById(R.id.P2) == null) {
            finish();
            return;
        }
        this.themeFragment = new ChooseThemeFragment();
        getSupportFragmentManager().q().b(R.id.P2, this.themeFragment).h();
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
