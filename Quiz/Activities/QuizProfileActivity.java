package com.scores365.Quiz.Activities;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.Scopes;
import com.scores365.R;
import li.p0;
import li.x0;
import pd.b;
import sc.i;
/* loaded from: classes2.dex */
public class QuizProfileActivity extends b {

    /* renamed from: f0  reason: collision with root package name */
    td.b f21394f0;

    @Override // pd.b
    protected boolean A1() {
        return false;
    }

    @Override // pd.b
    protected String e1() {
        return Scopes.PROFILE;
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
        return p0.l0("QUIZ_GAME_PROFILE");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        try {
            td.b bVar = this.f21394f0;
            if (bVar != null) {
                bVar.onActivityResult(i10, i11, intent);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // pd.b, com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f21394f0 = td.b.w1();
            getSupportFragmentManager().q().p(R.id.sl, this.f21394f0).h();
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
