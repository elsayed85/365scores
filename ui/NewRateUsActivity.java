package com.scores365.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.appevents.AppEventsConstants;
import com.scores365.App;
import com.scores365.R;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class NewRateUsActivity extends com.scores365.Design.Activities.d {
    public static final String SOURCE_CONDITION = "source_condition";
    private ImageView ivClose;
    private TextView tvLaterBtn;
    private TextView tvRateNowBtn;
    private TextView tvSubtitle;
    private TextView tvTitle;
    private final View.OnClickListener rateNowListener = new View.OnClickListener() { // from class: com.scores365.ui.u
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NewRateUsActivity.this.lambda$new$0(view);
        }
    };
    private final View.OnClickListener rateLaterListener = new View.OnClickListener() { // from class: com.scores365.ui.v
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NewRateUsActivity.this.lambda$new$1(view);
        }
    };
    private final View.OnClickListener NoListener = new View.OnClickListener() { // from class: com.scores365.ui.w
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NewRateUsActivity.this.lambda$new$2(view);
        }
    };

    private String getExplainTitle(String str) {
        try {
            StringBuilder sb2 = new StringBuilder();
            boolean z10 = false;
            for (int i10 = 0; i10 < str.length(); i10++) {
                if (!z10 && str.charAt(i10) == '#') {
                    sb2.append("<b>");
                    z10 = true;
                } else if (str.charAt(i10) == '#') {
                    sb2.append("</b>");
                }
                if (str.charAt(i10) != '#') {
                    sb2.append(str.charAt(i10));
                }
            }
            return sb2.toString();
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    private void init() {
        try {
            this.tvTitle = (TextView) findViewById(R.id.Cm);
            this.tvSubtitle = (TextView) findViewById(R.id.Bm);
            this.tvRateNowBtn = (TextView) findViewById(R.id.zm);
            this.tvLaterBtn = (TextView) findViewById(R.id.Am);
            this.ivClose = (ImageView) findViewById(R.id.f22438z3);
            ((ImageView) findViewById(R.id.xm)).setImageResource(R.drawable.V2);
            if (x0.l1()) {
                ((ConstraintLayout.b) this.tvRateNowBtn.getLayoutParams()).f4622e = R.id.ym;
                ((ConstraintLayout.b) this.tvRateNowBtn.getLayoutParams()).f4628h = -1;
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) this.tvRateNowBtn.getLayoutParams())).leftMargin = p0.s(16);
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) this.tvRateNowBtn.getLayoutParams())).rightMargin = 0;
                ((ConstraintLayout.b) this.tvLaterBtn.getLayoutParams()).f4622e = -1;
                ((ConstraintLayout.b) this.tvLaterBtn.getLayoutParams()).f4626g = -1;
                ((ConstraintLayout.b) this.tvLaterBtn.getLayoutParams()).f4624f = R.id.zm;
                ((ConstraintLayout.b) this.tvLaterBtn.getLayoutParams()).f4630i = R.id.zm;
            }
            this.tvRateNowBtn.setVisibility(0);
            this.tvLaterBtn.setVisibility(0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        try {
            li.c0.d(getApplicationContext());
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())));
                finish();
            } catch (Exception e10) {
                e = e10;
                x0.N1(e);
                ee.k.o(getApplicationContext(), "app", "popup", "click", null, "type", "rate us", "result", "Rate Us", "condition", getIntent().getStringExtra(SOURCE_CONDITION));
                ee.k.o(getApplicationContext(), "app", "rate_us_popup", "click", null, "type", "rate us", "result", "Rate Us", "condition", getIntent().getStringExtra(SOURCE_CONDITION));
            }
        } catch (Exception e11) {
            e = e11;
        }
        ee.k.o(getApplicationContext(), "app", "popup", "click", null, "type", "rate us", "result", "Rate Us", "condition", getIntent().getStringExtra(SOURCE_CONDITION));
        ee.k.o(getApplicationContext(), "app", "rate_us_popup", "click", null, "type", "rate us", "result", "Rate Us", "condition", getIntent().getStringExtra(SOURCE_CONDITION));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
        try {
            li.c0.c(getApplicationContext());
            finish();
        } catch (Exception e10) {
            x0.N1(e10);
        }
        ee.k.o(getApplicationContext(), "app", "popup", "click", null, "type", "rate us", "result", "Remind Me Later", "condition", getIntent().getStringExtra(SOURCE_CONDITION));
        ee.k.o(getApplicationContext(), "app", "rate_us_popup", "click", null, "type", "rate us", "result", "Remind Me Later", "condition", getIntent().getStringExtra(SOURCE_CONDITION));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(View view) {
        try {
            li.c0.b(getApplicationContext());
            finish();
        } catch (Exception e10) {
            x0.N1(e10);
        }
        ee.k.o(getApplicationContext(), "app", "popup", "click", null, "type", "rate us", "result", "Cancel", "condition", getIntent().getStringExtra(SOURCE_CONDITION));
        ee.k.o(getApplicationContext(), "app", "rate_us_popup", "click", null, "type", "rate us", "result", "Cancel", "condition", getIntent().getStringExtra(SOURCE_CONDITION));
    }

    private void setText() {
        try {
            this.tvTitle.setText(p0.l0("NEW_DASHBOARD_RATE_US"));
            this.tvSubtitle.setText(Html.fromHtml(getExplainTitle(p0.l0("ENJOYING_USING"))));
            this.tvRateNowBtn.setText(Html.fromHtml(p0.l0("RATE_NOW").toUpperCase()));
            this.tvLaterBtn.setText(p0.l0("NEW_DASHBOARD_REMIND_ME_LATER").toUpperCase());
            this.tvTitle.setTypeface(o0.c(getApplicationContext()));
            this.tvSubtitle.setTypeface(o0.b(getApplicationContext()));
            this.tvRateNowBtn.setTypeface(o0.d(getApplicationContext()));
            this.tvLaterBtn.setTypeface(o0.d(getApplicationContext()));
            this.tvRateNowBtn.setOnClickListener(this.rateNowListener);
            this.tvLaterBtn.setOnClickListener(this.rateLaterListener);
            this.ivClose.setOnClickListener(this.NoListener);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(App.f20805y);
        x0.g2(this);
        setContentView(R.layout.f22608l7);
        try {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.height = p0.s(353);
            attributes.width = p0.s(290);
            getWindow().setAttributes(attributes);
            init();
            setText();
            ee.k.o(getApplicationContext(), "app", "popup", "open", null, "type", "rate us", "condition", getIntent().getStringExtra(SOURCE_CONDITION));
            ee.k.o(getApplicationContext(), "app", "rate_us_popup", "open", null, "type", AppEventsConstants.EVENT_PARAM_VALUE_YES, "condition", getIntent().getStringExtra(SOURCE_CONDITION));
            sf.b.X1().t7();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
