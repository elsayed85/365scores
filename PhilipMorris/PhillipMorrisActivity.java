package com.scores365.PhilipMorris;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.scores365.App;
import com.scores365.Design.Activities.d;
import com.scores365.R;
import ee.k;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class PhillipMorrisActivity extends d {

    /* renamed from: f0  reason: collision with root package name */
    public static boolean f21358f0;
    private ImageView F;
    private TextView G;
    private TextView H;
    private TextView I;

    /* renamed from: b0  reason: collision with root package name */
    private TextView f21359b0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                PhillipMorrisActivity.this.b1("allow", true);
                sf.b.X1().E8("Yes");
                sf.b.X1().m9();
                PhillipMorrisActivity.this.finish();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                PhillipMorrisActivity.this.b1("exit", false);
                PhillipMorrisActivity.this.finish();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                PhillipMorrisActivity.this.b1("deny", false);
                sf.b.X1().E8("No");
                sf.b.X1().m9();
                PhillipMorrisActivity.this.finish();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    private String a1() {
        String l02 = p0.l0("IQOS_CHECKBOX_TERMS");
        try {
            String l03 = p0.l0("IQOS_CHECKBOX_TERMS_" + sf.a.i0(App.m()).j0());
            return l03 != null ? !l03.isEmpty() ? l03 : l02 : l02;
        } catch (Exception e10) {
            x0.N1(e10);
            return l02;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(String str, boolean z10) {
        try {
            Context m10 = App.m();
            String[] strArr = new String[6];
            strArr[0] = "click_type";
            strArr[1] = str;
            strArr[2] = "permission_type";
            strArr[3] = "smoker";
            strArr[4] = "checkbox";
            strArr[5] = z10 ? "on" : "off";
            k.o(m10, "app", "user-permission", "pop-up", "click", strArr);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void d1() {
        try {
            sf.b.X1().F8();
            sf.b.X1().G8();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void initViews() {
        try {
            this.F = (ImageView) findViewById(R.id.B3);
            this.G = (TextView) findViewById(R.id.ql);
            this.H = (TextView) findViewById(R.id.f22326u1);
            this.I = (TextView) findViewById(R.id.f22083j1);
            this.f21359b0 = (TextView) findViewById(R.id.ox);
            this.G.setTypeface(o0.d(App.m()));
            this.H.setTypeface(o0.d(App.m()));
            this.I.setTypeface(o0.d(App.m()));
            this.f21359b0.setTypeface(o0.b(App.m()));
            this.G.setText(p0.l0("IQOS_TITLE").replace("#age", md.a.b()));
            this.H.setText(p0.l0("IQOS_YES"));
            this.I.setText(p0.l0("IQOS_NO"));
            this.f21359b0.setText(a1());
            this.H.setOnClickListener(new a());
            this.F.setOnClickListener(new b());
            this.I.setOnClickListener(new c());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        try {
            this.F.callOnClick();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.f22652p);
            f21358f0 = true;
            initViews();
            d1();
            k.n(App.m(), "app", "user-permission", "pop-up", "show", false, "permission_type", "smoker");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, android.app.Activity
    public void onPause() {
        super.onPause();
        f21358f0 = false;
    }

    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, android.app.Activity
    protected void onResume() {
        super.onResume();
        f21358f0 = true;
    }
}
