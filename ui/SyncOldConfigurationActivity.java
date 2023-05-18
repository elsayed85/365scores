package com.scores365.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.facebook.appevents.AppEventsConstants;
import com.scores365.App;
import com.scores365.R;
import com.scores365.ui.SyncOldConfigurationFragment;
import li.e0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class SyncOldConfigurationActivity extends com.scores365.Design.Activities.c implements SyncOldConfigurationFragment.OnUserChoiceSelectedListener, e0.d {
    private static final String COMPETITIONS_COUNT = "competitions_count";
    private static final String COMPETITORS_COUNT = "competitors_count";
    public static final String IS_MANUAL_REQUEST = "manual_request";
    public static final int PROCCES_REQUEST_CODE = 404;
    public static final int PROCCES_RESULT_CANCEL = 34;
    public static final int PROCCES_RESULT_OK = 1993;

    public static Intent getSyncActivityIntent(int i10, int i11, boolean z10) {
        Intent intent = new Intent(App.m(), SyncOldConfigurationActivity.class);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(COMPETITORS_COUNT, i10);
            bundle.putInt(COMPETITIONS_COUNT, i11);
            bundle.putBoolean("manual_request", z10);
            intent.putExtras(bundle);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return intent;
    }

    private void loadSyncPageToScreen() {
        try {
            getSupportFragmentManager().q().p(R.id.f22154m6, SyncOldConfigurationFragment.newInstance(this, getIntent().getExtras().getInt(COMPETITORS_COUNT), getIntent().getExtras().getInt(COMPETITIONS_COUNT), getIntent().getExtras().getBoolean("manual_request"))).h();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static void onDataRecovered(boolean z10, @NonNull Context context, Intent intent) {
        try {
            if (sf.a.i0(App.m()).h0()) {
                if (z10) {
                    sf.b.X1().K9(true);
                    sf.b.X1().Z6(true);
                    sf.b.X1().N6(true);
                    sf.b.X1().Q7(-1, true);
                    sf.b.X1().d7(true);
                    sf.b.X1().I9(-1);
                    sf.b.X1().H9(-1);
                    App.b.t();
                    x0.A2(null, null);
                    ee.k.g();
                }
                int i10 = x0.n1() ? R.style.f22831f : R.style.f22830e;
                id.g.e().i();
                p0.C0(context, i10);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        re.h.w(intent, -2L);
    }

    @Override // li.e0.d
    public void OnDataRecovery(boolean z10, boolean z11) {
        try {
            onDataRecovered(z10, this, getIntent());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return "";
    }

    @Override // com.scores365.ui.SyncOldConfigurationFragment.OnUserChoiceSelectedListener
    public void onAbortSelected(boolean z10) {
        try {
            Context m10 = App.m();
            String[] strArr = new String[4];
            strArr[0] = "selection";
            strArr[1] = "no";
            strArr[2] = "request";
            strArr[3] = z10 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "0";
            ee.k.o(m10, "synchronization", "click", null, null, strArr);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        setResult(34);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x0.D1(this);
        setContentView(R.layout.E9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        super.onResume();
        loadSyncPageToScreen();
    }

    @Override // com.scores365.ui.SyncOldConfigurationFragment.OnUserChoiceSelectedListener
    public void onSyncSelected(boolean z10) {
        try {
            Context m10 = App.m();
            String[] strArr = new String[4];
            strArr[0] = "selection";
            strArr[1] = "yes";
            strArr[2] = "request";
            strArr[3] = z10 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "0";
            ee.k.o(m10, "synchronization", "click", null, null, strArr);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        try {
            li.e0.m().a(this);
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }
}
