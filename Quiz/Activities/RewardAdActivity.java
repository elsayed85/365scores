package com.scores365.Quiz.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cc.e1;
import cc.r;
import cc.u0;
import cc.x;
import cc.z0;
import com.scores365.App;
import com.scores365.Design.Activities.d;
import com.scores365.R;
import ee.k;
import java.util.HashMap;
import li.p0;
import li.x0;
import od.a;
import sc.h;
import sc.i;
/* loaded from: classes2.dex */
public class RewardAdActivity extends d implements View.OnClickListener, e1, u0 {
    ImageView F;
    TextView G;
    ProgressBar H;

    public static Intent D(Context context, int i10, boolean z10, int i11, int i12) {
        Intent intent = new Intent(context, RewardAdActivity.class);
        intent.putExtra("coinRewardTag", i10);
        intent.putExtra("isTimeRewardTag", z10);
        intent.putExtra("modeIdTag", i11);
        intent.putExtra("stageIdTag", i12);
        return intent;
    }

    @Override // cc.e1
    public ViewGroup GetBannerHolderView() {
        return null;
    }

    @Override // cc.u0
    public void T0() {
        try {
            int intExtra = getIntent().getIntExtra("coinRewardTag", 0);
            if (getIntent().getBooleanExtra("isTimeRewardTag", false)) {
                a.D().F0(getIntent().getIntExtra("modeIdTag", 0), getIntent().getIntExtra("stageIdTag", 0));
            } else {
                a.D().l0(intExtra);
            }
            r.H(this);
            r.n();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // cc.u0
    public void X0() {
        try {
            this.H.setVisibility(8);
            this.G.setText(p0.l0("NO_VIDEOS_TO_SHOW"));
            k.k(App.m(), "quiz", "video-ad", "not-shown", null, new HashMap());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // cc.e1
    public z0 getCurrBanner() {
        return null;
    }

    @Override // cc.e1
    public z0 getMpuHandler() {
        return null;
    }

    @Override // cc.e1
    public i getPlacement() {
        return null;
    }

    @Override // cc.e1
    public boolean isBannerNeedToBeShown() {
        return isBannerNeedToBeVisible();
    }

    @Override // cc.e1
    public boolean isBannerNeedToBeVisible() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (view.getId() == R.id.cn) {
                onBackPressed();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setActivityTheme();
            setContentView(R.layout.f22700t);
            this.H = (ProgressBar) findViewById(R.id.bn);
            this.G = (TextView) findViewById(R.id.an);
            ImageView imageView = (ImageView) findViewById(R.id.cn);
            this.F = imageView;
            imageView.setOnClickListener(this);
            this.G.setText(p0.l0("LOADING_VIDEO_GAME"));
            int p10 = (int) (App.p() * 0.083333336f);
            this.H.getLayoutParams().width = p10;
            this.H.getLayoutParams().height = p10;
            r.G(this, this, false);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.d, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStop() {
        super.onStop();
        r.n();
    }

    @Override // cc.u0
    public void q(@NonNull x xVar) {
        if (!isFinishing() && !isDestroyed() && xVar.f10132d == h.ReadyToShow) {
            xVar.z(this);
            this.G.setVisibility(4);
            this.H.setVisibility(4);
        }
        r.f10072a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.d
    public void setActivityTheme() {
        try {
            setTheme(R.style.f22832g);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // cc.e1
    public void setBannerHandler(z0 z0Var) {
    }

    @Override // cc.e1
    public void setMpuHandler(z0 z0Var) {
    }

    @Override // cc.e1
    public boolean showAdsForContext() {
        return false;
    }
}
