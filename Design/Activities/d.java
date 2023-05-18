package com.scores365.Design.Activities;

import android.content.Intent;
import android.os.Bundle;
import cc.o0;
import com.flurry.android.FlurryAgent;
import com.scores365.App;
import com.scores365.R;
import ee.k;
import li.x0;
/* compiled from: BaseActivity.java */
/* loaded from: classes2.dex */
public class d extends androidx.appcompat.app.d {
    private static final String TAG = "BaseActivity";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(App.f20805y);
        Intent intent = getIntent();
        if (intent.hasExtra("NewVersionPopup") && intent.getBooleanExtra("NewVersionPopup", false)) {
            pg.e.f36658a.h(getSupportFragmentManager());
        }
        k.A(this, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        super.onResume();
        if (o0.y() == null) {
            o0.h(this, true, false);
            ng.a.f35508a.c(TAG, "content config not found", new NullPointerException("missing content configuration"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStart() {
        try {
            super.onStart();
            FlurryAgent.onStartSession(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStop() {
        try {
            super.onStop();
            FlurryAgent.onEndSession(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setActivityTheme() {
        try {
            if (App.f20805y == -1) {
                if (x0.n1()) {
                    App.f20805y = R.style.f22831f;
                } else {
                    App.f20805y = R.style.f22830e;
                }
            }
            setTheme(App.f20805y);
            App.f20804x = getTheme();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
