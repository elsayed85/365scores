package com.scores365.Quiz.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.fragment.app.Fragment;
import com.amazon.device.ads.DTBAdSize;
import com.scores365.App;
import com.scores365.R;
import ee.k;
import java.util.HashMap;
import li.o0;
import li.p0;
import li.x0;
import od.a;
import sf.b;
import td.c;
import td.d;
/* loaded from: classes2.dex */
public class QuizWelcomePromotionActivity extends d implements View.OnClickListener {
    public static boolean H;
    int F = -1;
    StringBuilder G = new StringBuilder();

    private void a1() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("promotion_type", DTBAdSize.AAX_INTERSTITIAL_AD_SIZE);
            hashMap.put("promotion_id", this.G.toString());
            hashMap.put("click_type", "exit");
            k.m(App.m(), "quiz", "promotion", "click", null, true, hashMap);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void b1() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("promotion_type", DTBAdSize.AAX_INTERSTITIAL_AD_SIZE);
            hashMap.put("promotion_id", this.G.toString());
            hashMap.put("click_type", "enter");
            k.m(App.m(), "quiz", "promotion", "click", null, true, hashMap);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void d1(int i10) {
        Fragment s12;
        try {
            this.F = i10;
            if (i10 == 1) {
                s12 = td.d.s1(d.a.TEAM_LOGO.ordinal());
                this.G.append("team");
            } else if (i10 == 2) {
                s12 = td.d.s1(d.a.TEAM_FORMATION.ordinal());
                this.G.append("logo");
            } else if (i10 != 3) {
                s12 = null;
            } else {
                s12 = c.r1();
                this.G.append("modes");
            }
            getSupportFragmentManager().q().p(R.id.Sl, s12).h();
            b.X1().i3();
            b.X1().o5();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void initViews() {
        try {
            findViewById(R.id.ul).setOnClickListener(this);
            TextView textView = (TextView) findViewById(R.id.Jl);
            textView.setOnClickListener(this);
            textView.setText(p0.l0("QUIZ_GAME_WELCOME_POPUP_BUTTON"));
            textView.setTypeface(o0.c(App.m()), 2);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        a1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            int id2 = view.getId();
            if (id2 == R.id.ul) {
                a1();
            } else if (id2 == R.id.Jl) {
                b1();
                startActivity(QuizModeActivity.C1("promotion", false));
            }
            finish();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22582j7);
        try {
            H = true;
            int E = a.E();
            initViews();
            d1(E);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, android.app.Activity
    public void onPause() {
        super.onPause();
        H = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        super.onResume();
        H = true;
    }
}
