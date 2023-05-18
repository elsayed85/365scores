package com.scores365.tipster;

import ac.i;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.e1;
import com.scores365.App;
import com.scores365.Design.Activities.c;
import com.scores365.R;
import com.scores365.tipster.TipsterStandaloneActivity;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class TipsterStandaloneActivity extends c {
    boolean F = false;
    RelativeLayout G;

    @NonNull
    public static Intent e1(int i10, int i11, String str) {
        Intent intent = new Intent(App.m(), TipsterStandaloneActivity.class);
        intent.putExtra("insightId", i11);
        intent.putExtra("notification_id", str);
        intent.putExtra("sourceForAnalytics", i10);
        return intent;
    }

    private void g1() {
        try {
            RelativeLayout relativeLayout = this.G;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            int intExtra = getIntent().getIntExtra("sourceForAnalytics", a.f24304b);
            int i10 = -1;
            if (getIntent() != null && getIntent().getExtras() != null) {
                i10 = getIntent().getExtras().getInt("insightId", -1);
            }
            String str = "";
            if (getIntent() != null && getIntent().getExtras() != null) {
                str = getIntent().getExtras().getString("notification_id", "");
            }
            getSupportFragmentManager().q().q(R.id.f22065i6, i.D1(intExtra, i10, str, true), "main_fragment").g(null).h();
            this.toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: fi.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TipsterStandaloneActivity.this.h1(view);
                }
            });
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h1(View view) {
        try {
            i iVar = (i) getSupportFragmentManager().j0("main_fragment");
            if (iVar == null || !iVar.P()) {
                return;
            }
            iVar.T();
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return p0.l0("TIPS_DAILY_TIP");
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            Intent intent = new Intent();
            setResult(-1, intent);
            i iVar = (i) getSupportFragmentManager().j0("main_fragment");
            intent.putExtra("isDirty", iVar != null && iVar.y1());
            if (iVar != null && iVar.P()) {
                iVar.T();
                if (iVar.m()) {
                    super.onBackPressed();
                }
            } else if (!this.F) {
                finish();
            } else {
                Intent x02 = x0.x0();
                x02.setFlags(268435456);
                x02.setFlags(67108864);
                startActivity(x02);
                finish();
            }
        } catch (Exception e10) {
            x0.N1(e10);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22611la);
        x0.D1(this);
        initActionBar();
        e1.C0(this.toolbar, 4.0f);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Jn);
        this.G = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        try {
            if (getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra("notification_id")) {
                this.F = true;
                getIntent().removeExtra("insightId");
                getIntent().removeExtra("notification_id");
            }
            if (getIntent().getBooleanExtra(c.IS_NOTIFICATION_ACTIVITY, false)) {
                this.F = true;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        try {
            g1();
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }
}
