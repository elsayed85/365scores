package com.scores365.Quiz.Activities;

import android.os.Bundle;
import android.widget.FrameLayout;
import cc.z0;
import com.scores365.R;
import java.util.HashMap;
import li.p0;
import li.x0;
import pd.b;
import sc.i;
/* loaded from: classes2.dex */
public class QuizStagesActivity extends b {
    @Override // pd.b
    protected boolean A1() {
        return false;
    }

    @Override // pd.b
    protected HashMap<String, Object> a1() {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            hashMap.put("mode_num", String.valueOf(getIntent().getIntExtra("mode_id", -1)));
            hashMap.put("screen", "stages");
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return hashMap;
    }

    @Override // pd.b
    protected String e1() {
        return "stages";
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
        return p0.l0("QUIZ_GAME_TITLE");
    }

    @Override // pd.b, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // pd.b, com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getSupportFragmentManager().q().q(((FrameLayout) findViewById(R.id.sl)).getId(), td.i.A1(getIntent().getStringExtra("source_for_anal"), getIntent().getIntExtra("mode_id", -1)), "stages_fragment_tag").h();
            this.G.setVisibility(0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // pd.b, cc.e1
    public void setBannerHandler(z0 z0Var) {
        super.setBannerHandler(z0Var);
        try {
            ((td.i) getSupportFragmentManager().j0("stages_fragment_tag")).z1();
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
        return true;
    }
}
