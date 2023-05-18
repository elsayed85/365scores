package com.scores365.tipster;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazon.device.ads.DtbConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.Design.Activities.d;
import com.scores365.R;
import com.scores365.tipster.a;
import ee.k;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class TipsterPopupActivity extends d {
    ImageView F;
    TextView G;
    TextView H;
    TextView I;

    /* renamed from: b0  reason: collision with root package name */
    TextView f24284b0;

    /* renamed from: f0  reason: collision with root package name */
    RelativeLayout f24285f0;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                k.q(App.m(), "tip-sale", "promo", "click", true, ShareConstants.FEED_SOURCE_PARAM, TipsterPopupActivity.this.getIntent().getExtras().getString(ShareConstants.FEED_SOURCE_PARAM));
                TipsterPopupActivity.this.finish();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.f22559ha);
            this.G = (TextView) findViewById(R.id.XG);
            this.H = (TextView) findViewById(R.id.WG);
            this.I = (TextView) findViewById(R.id.cA);
            this.f24284b0 = (TextView) findViewById(R.id.TG);
            this.F = (ImageView) findViewById(R.id.Xd);
            this.f24285f0 = (RelativeLayout) findViewById(R.id.Fn);
            this.I.setTypeface(o0.d(this));
            this.G.setTypeface(o0.d(this));
            this.H.setTypeface(o0.d(this));
            this.f24284b0.setTypeface(o0.d(this));
            this.G.setText(p0.l0("TIPSTER_TITLE"));
            this.H.setText(p0.l0("TIPS_WELCOME_TEXT"));
            this.I.setText(p0.l0("TIPS_WELCOME_BUTTON"));
            this.f24284b0.setText(p0.l0("TIPS_ELUA"));
            this.f24284b0.setOnClickListener(new a.View$OnClickListenerC0259a(DtbConstants.NETWORK_TYPE_LTE, "2"));
            int p10 = App.p() - p0.s(72);
            this.f24285f0.getLayoutParams().width = p10;
            int i10 = (p10 * 349) / 288;
            this.f24285f0.getLayoutParams().height = i10;
            ((ViewGroup.MarginLayoutParams) this.f24285f0.getLayoutParams()).topMargin = (App.o() - i10) / 2;
            ((RelativeLayout.LayoutParams) this.H.getLayoutParams()).topMargin = (p10 * 186) / 288;
            ((RelativeLayout.LayoutParams) this.F.getLayoutParams()).width = (p10 * 83) / 288;
            ((RelativeLayout.LayoutParams) this.F.getLayoutParams()).topMargin = (p10 * 43) / 288;
            this.I.setOnClickListener(new a());
            if (App.p() > 480) {
                this.H.setTextSize(1, 14.0f);
                this.I.setTextSize(1, 15.0f);
                ((RelativeLayout.LayoutParams) this.H.getLayoutParams()).leftMargin = p0.s(27);
                ((RelativeLayout.LayoutParams) this.H.getLayoutParams()).rightMargin = p0.s(27);
            } else {
                this.H.setTextSize(1, 12.0f);
                this.I.setTextSize(1, 13.0f);
                ((RelativeLayout.LayoutParams) this.H.getLayoutParams()).leftMargin = p0.s(10);
                ((RelativeLayout.LayoutParams) this.H.getLayoutParams()).rightMargin = p0.s(10);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            k.q(App.m(), "tip-sale", "promo", ServerProtocol.DIALOG_PARAM_DISPLAY, false, ShareConstants.FEED_SOURCE_PARAM, getIntent().getExtras().getString(ShareConstants.FEED_SOURCE_PARAM));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
