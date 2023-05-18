package com.scores365.Quiz.Activities;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.scores365.R;
import li.p0;
import li.x0;
import pd.b;
import sc.i;
import td.h;
/* loaded from: classes2.dex */
public class QuizSettingsActivity extends b {
    @Override // pd.b
    protected boolean A1() {
        return false;
    }

    @Override // pd.b
    protected String e1() {
        return "settings";
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
        return p0.l0("QUIZ_GAME_SETTINGS");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // pd.b, com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            getSupportFragmentManager().q().p(((FrameLayout) findViewById(R.id.sl)).getId(), h.y1()).h();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // pd.b
    protected boolean x1() {
        return false;
    }

    @Override // pd.b
    protected boolean y1() {
        return false;
    }

    @Override // pd.b
    protected boolean z1() {
        return false;
    }
}
