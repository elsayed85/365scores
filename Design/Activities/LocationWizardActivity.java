package com.scores365.Design.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.e1;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.R;
import ee.k;
import li.o0;
import li.p0;
import li.x0;
import nb.y;
/* loaded from: classes2.dex */
public class LocationWizardActivity extends d {
    TextView F;
    TextView G;
    TextView H;
    TextView I;

    /* renamed from: b0  reason: collision with root package name */
    ImageView f20861b0;

    /* renamed from: f0  reason: collision with root package name */
    Button f20862f0;

    /* renamed from: g0  reason: collision with root package name */
    RelativeLayout f20863g0;

    /* renamed from: h0  reason: collision with root package name */
    String f20864h0;

    /* renamed from: i0  reason: collision with root package name */
    boolean f20865i0 = false;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                k.n(App.m(), "app", "user-permission", "pop-up", "click", true, ShareConstants.FEED_SOURCE_PARAM, LocationWizardActivity.this.f20864h0);
                k.n(App.m(), "app", "user-permission", "show", null, false, "permission_type", "location");
                LocationWizardActivity locationWizardActivity = LocationWizardActivity.this;
                locationWizardActivity.f20865i0 = true;
                androidx.core.app.b.g(locationWizardActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public String D(String str) {
        String str2;
        try {
            if (str.contains("#")) {
                int indexOf = str.indexOf("#");
                int i10 = indexOf;
                while (true) {
                    if (i10 >= str.length()) {
                        i10 = -1;
                        break;
                    } else if (str.charAt(i10) == ' ') {
                        break;
                    } else {
                        i10++;
                    }
                }
                String replace = str.replace("#", "");
                String replace2 = replace.substring(indexOf, i10).replace("#", "");
                if (x0.n1()) {
                    str2 = "<font color=#000000>" + replace2 + "</font>";
                } else {
                    str2 = "<font color=#ffffff>" + replace2 + "</font>";
                }
                return replace.replace(replace2, str2);
            }
            return str;
        } catch (Exception e10) {
            x0.N1(e10);
            return str;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            setResult(1233, new Intent());
            if (!this.f20865i0) {
                k.n(App.m(), "app", "user-permission", "pop-up", "close", true, ShareConstants.FEED_SOURCE_PARAM, this.f20864h0);
            }
            super.onBackPressed();
        } catch (Exception e10) {
            x0.N1(e10);
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        RelativeLayout relativeLayout;
        Spanned fromHtml;
        super.onCreate(bundle);
        setActivityTheme();
        setContentView(R.layout.f22600l);
        try {
            sf.b.X1().L9(true);
            this.f20864h0 = getIntent().getExtras().getString("loc");
            this.F = (TextView) findViewById(R.id.f21894ah);
            this.G = (TextView) findViewById(R.id.Yg);
            this.H = (TextView) findViewById(R.id.Zg);
            this.f20861b0 = (ImageView) findViewById(R.id.Xg);
            this.f20862f0 = (Button) findViewById(R.id.Wg);
            this.f20863g0 = (RelativeLayout) findViewById(R.id.En);
            this.F.setVisibility(0);
            this.G.setVisibility(0);
            this.H.setVisibility(0);
            this.f20862f0.setVisibility(0);
            this.F.setTypeface(o0.b(App.m()));
            this.G.setTypeface(o0.b(App.m()));
            this.H.setTypeface(o0.b(App.m()));
            this.f20862f0.setTypeface(o0.b(App.m()));
            try {
                if (y.c()) {
                    this.F.setText(p0.l0("LOCATION_PER_VENUE_TITLE"));
                    this.G.setText(p0.l0("LOCATION_PER_VENUE_EXPLANATION"));
                    this.f20862f0.setText(p0.l0("LOCATION_PER_VENUE_CONTINUE"));
                    if (x0.l1()) {
                        relativeLayout = (RelativeLayout) findViewById(R.id.Ug);
                        relativeLayout.setVisibility(0);
                    } else {
                        relativeLayout = (RelativeLayout) findViewById(R.id.Tg);
                        relativeLayout.setVisibility(0);
                    }
                    this.H = (TextView) findViewById(R.id.Zg);
                    TextView textView = (TextView) relativeLayout.findViewById(R.id.f21882a5);
                    this.I = textView;
                    textView.setText(p0.l0("LOCATION_ENABLE"));
                    ((TextView) relativeLayout.findViewById(R.id.iB)).setText(p0.l0("LOCATION_ANDROID"));
                    ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.Io);
                    this.f20861b0 = imageView;
                    imageView.setImageResource(R.drawable.A4);
                    int i10 = Build.VERSION.SDK_INT;
                    this.f20861b0.setImageAlpha(64);
                    String D = D(p0.l0("LOCATION_PER_GC_ALLOW_TEXT"));
                    if (i10 >= 24) {
                        TextView textView2 = this.H;
                        fromHtml = Html.fromHtml(D, 63);
                        textView2.setText(fromHtml);
                    } else {
                        this.H.setText(Html.fromHtml(D));
                    }
                } else {
                    y.d(true);
                    if (!this.f20864h0.equals("wizard") && !this.f20864h0.equals("sync")) {
                        if (this.f20864h0.equals("gamecenter")) {
                            this.f20861b0.setImageResource(p0.w(App.m(), R.attr.C0));
                            this.F.setText(p0.l0("LOCATION_PER_GC_TITLE"));
                            this.G.setText(p0.l0("LOCATION_PER_GC_EXPLANATION"));
                            this.f20862f0.setText(p0.l0("LOCATION_CONTINUE"));
                            this.H.setText(Html.fromHtml(D(p0.l0("LOCATION_PER_GC_ALLOW_TEXT"))));
                        }
                    }
                    this.F.setText(p0.l0("LOCATION_TITLE"));
                    this.G.setText(p0.l0("LOCATION_EXPLANATION"));
                    this.f20862f0.setText(p0.l0("LOCATION_CONTINUE"));
                    this.H.setText(Html.fromHtml(D(p0.l0("LOCATION_ALLOW_TEXT"))));
                    this.f20861b0.setImageResource(p0.w(App.m(), R.attr.C0));
                    this.f20861b0.setVisibility(0);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            e1.C0(this.f20863g0, p0.s(4));
            this.f20862f0.setTypeface(o0.b(App.m()));
            this.f20862f0.setOnClickListener(new a());
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 != 1) {
            return;
        }
        try {
            if (iArr.length <= 0 || iArr[0] != 0) {
                sf.b.X1().y7(false);
                k.n(App.m(), "app", "user-permission", "click", null, true, "permission_type", "location", "click_type", "deny");
            } else {
                sf.b.X1().y7(true);
                k.n(App.m(), "app", "user-permission", "click", null, true, "permission_type", "location", "click_type", "allow");
            }
            setResult(1233, new Intent());
            if (!this.f20865i0) {
                k.n(App.m(), "app", "user-permission", "pop-up", "close", true, ShareConstants.FEED_SOURCE_PARAM, this.f20864h0);
            }
            finish();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.d
    public void setActivityTheme() {
        try {
            if (App.f20805y == -1) {
                if (x0.n1()) {
                    App.f20805y = R.style.f22831f;
                } else {
                    App.f20805y = R.style.f22830e;
                }
            }
            setTheme(App.f20805y);
            App.f20804x = getTheme();
            p0.E0(this, 0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
