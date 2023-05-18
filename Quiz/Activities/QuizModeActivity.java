package com.scores365.Quiz.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import cc.r;
import com.scores365.App;
import com.scores365.Design.Activities.c;
import com.scores365.R;
import li.x0;
import pd.b;
import sc.i;
import td.a;
/* loaded from: classes2.dex */
public class QuizModeActivity extends b {

    /* renamed from: f0  reason: collision with root package name */
    FrameLayout f21393f0;

    public static Intent C1(String str, boolean z10) {
        Intent intent = new Intent(App.m(), QuizModeActivity.class);
        intent.putExtra("source_for_anal", str);
        intent.putExtra(c.IS_NOTIFICATION_ACTIVITY, z10);
        return intent;
    }

    private void D1() {
        try {
            getSupportFragmentManager().q().p(this.f21393f0.getId(), a.s1(getIntent().getStringExtra("source_for_anal"))).h();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // pd.b
    protected boolean A1() {
        return true;
    }

    @Override // pd.b
    protected String e1() {
        return "modes";
    }

    @Override // pd.b
    protected String g1() {
        return null;
    }

    @Override // cc.e1
    public i getPlacement() {
        return i.Quiz;
    }

    @Override // pd.b
    protected String h1() {
        return null;
    }

    @Override // pd.b, com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f21393f0 = (FrameLayout) findViewById(R.id.sl);
            od.a.U0();
            D1();
            r.H(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // pd.b, com.scores365.Design.Activities.d, androidx.fragment.app.h, android.app.Activity
    protected void onResume() {
        super.onResume();
        D1();
    }

    @Override // pd.b
    protected boolean x1() {
        return true;
    }

    @Override // pd.b
    protected boolean y1() {
        return true;
    }

    @Override // pd.b
    protected boolean z1() {
        return false;
    }
}
