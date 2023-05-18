package com.scores365.dashboard.following;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.scores365.Design.Activities.d;
import com.scores365.R;
import de.hdodenhof.circleimageview.CircleImageView;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class InfoActivity extends d implements View.OnClickListener {
    TextView F;
    TextView G;
    TextView H;
    TextView I;

    /* renamed from: b0  reason: collision with root package name */
    TextView f23353b0;

    /* renamed from: f0  reason: collision with root package name */
    TextView f23354f0;

    /* renamed from: g0  reason: collision with root package name */
    TextView f23355g0;

    /* renamed from: h0  reason: collision with root package name */
    TextView f23356h0;

    /* renamed from: i0  reason: collision with root package name */
    ImageView f23357i0;

    /* renamed from: j0  reason: collision with root package name */
    CircleImageView f23358j0;

    /* renamed from: k0  reason: collision with root package name */
    CircleImageView f23359k0;

    /* renamed from: l0  reason: collision with root package name */
    CircleImageView f23360l0;

    /* renamed from: m0  reason: collision with root package name */
    CircleImageView f23361m0;

    /* renamed from: n0  reason: collision with root package name */
    boolean f23362n0;

    /* renamed from: o0  reason: collision with root package name */
    private View.OnClickListener f23363o0 = new a();

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("closed_activity_no_result", true);
            intent.putExtra("is_notification_click", true);
            InfoActivity.this.setResult(-1, intent);
            InfoActivity.this.finish();
        }
    }

    private void init() {
        try {
            this.F = (TextView) findViewById(R.id.I6);
            this.G = (TextView) findViewById(R.id.zr);
            this.f23355g0 = (TextView) findViewById(R.id.Vi);
            this.f23357i0 = (ImageView) findViewById(R.id.C3);
            this.f23356h0 = (TextView) findViewById(R.id.f22277rj);
            this.H = (TextView) findViewById(R.id.f22422y9);
            this.I = (TextView) findViewById(R.id.f22444z9);
            this.f23353b0 = (TextView) findViewById(R.id.A9);
            this.f23354f0 = (TextView) findViewById(R.id.B9);
            this.f23358j0 = (CircleImageView) findViewById(R.id.f22348v1);
            this.f23359k0 = (CircleImageView) findViewById(R.id.f22370w1);
            this.f23360l0 = (CircleImageView) findViewById(R.id.f22392x1);
            this.f23361m0 = (CircleImageView) findViewById(R.id.f22414y1);
            if (this.f23362n0) {
                if (x0.l1()) {
                    this.G.setGravity(5);
                } else {
                    this.G.setGravity(3);
                }
                this.H.setVisibility(8);
                this.I.setVisibility(8);
                this.f23353b0.setVisibility(8);
                this.f23354f0.setVisibility(8);
                this.f23358j0.setVisibility(8);
                this.f23359k0.setVisibility(8);
                this.f23360l0.setVisibility(8);
                this.f23361m0.setVisibility(8);
            }
            this.f23356h0.setOnClickListener(this.f23363o0);
            this.f23357i0.setOnClickListener(this.f23363o0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setText() {
        try {
            if (this.f23362n0) {
                this.F.setText(p0.l0("FAVORITES_TITLE"));
                this.G.setText(p0.l0("FAVORITES_TEXT_WITH_PLAYERS"));
            } else {
                this.F.setText(p0.l0("FOLLOWING_TITLE"));
                this.G.setText(p0.l0("FOLLOWING_POPUP_TEXT_WITH_PLAYERS"));
            }
            this.F.setTextSize(1, 20.0f);
            this.G.setTextSize(1, 13.0f);
            this.H.setText(p0.l0("FOLLOWING_1_SCORES"));
            this.I.setText(p0.l0("FOLLOWING_2_NEWS"));
            this.f23353b0.setText(p0.l0("FOLLOWING_3_TRANSFERS"));
            this.f23354f0.setText(p0.l0("FOLLOWING_4_NOTIFICATIONS"));
            this.f23356h0.setText(p0.l0("GENERAL_OK"));
            this.f23355g0.setText(Html.fromHtml(p0.y0(p0.l0("FOLLOWING_POPUP_NOTIFICATIONS"))));
            this.F.setTypeface(o0.d(getApplicationContext()));
            this.G.setTypeface(o0.d(getApplicationContext()));
            this.H.setTypeface(o0.b(getApplicationContext()));
            this.I.setTypeface(o0.b(getApplicationContext()));
            this.f23353b0.setTypeface(o0.b(getApplicationContext()));
            this.f23354f0.setTypeface(o0.b(getApplicationContext()));
            this.f23355g0.setTypeface(o0.b(getApplicationContext()));
            this.f23356h0.setTypeface(o0.c(getApplicationContext()));
            this.f23355g0.setOnClickListener(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (view.getId() == this.f23355g0.getId()) {
                Intent intent = new Intent();
                intent.putExtra("is_favourite", this.f23362n0);
                intent.putExtra("is_notification_click", true);
                setResult(-1, intent);
                finish();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x0.g2(this);
        this.f23362n0 = getIntent().getBooleanExtra("is_favourite", false);
        if (x0.l1()) {
            setContentView(R.layout.V1);
        } else {
            setContentView(R.layout.U1);
        }
        try {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.height = -2;
            attributes.width = p0.s(300);
            getWindow().setAttributes(attributes);
            init();
            setText();
            setFinishOnTouchOutside(true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
