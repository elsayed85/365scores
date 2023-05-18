package com.scores365.ui;

import android.os.Bundle;
import com.scores365.App;
import com.scores365.R;
import li.x0;
/* loaded from: classes2.dex */
public class Splash extends androidx.appcompat.app.d {
    public boolean isStartedFromNotification() {
        try {
            if (getIntent() == null || getIntent().getExtras() == null) {
                return false;
            }
            return getIntent().getExtras().getBoolean(com.scores365.Design.Activities.c.IS_NOTIFICATION_ACTIVITY);
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(App.f20805y);
        setContentView(R.layout.S8);
    }
}
