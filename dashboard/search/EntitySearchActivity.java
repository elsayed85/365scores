package com.scores365.dashboard.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.e1;
import com.scores365.App;
import com.scores365.Design.Activities.c;
import com.scores365.R;
import gf.d;
import gf.f;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class EntitySearchActivity extends c implements View.OnFocusChangeListener {
    protected SearchView F;
    LinearLayoutCompat G;
    protected TextView H;
    protected boolean I = false;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f23385b0 = false;

    /* renamed from: f0  reason: collision with root package name */
    private View.OnClickListener f23386f0 = new a();

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((InputMethodManager) EntitySearchActivity.this.getSystemService("input_method")).toggleSoftInput(2, 0);
            EntitySearchActivity entitySearchActivity = EntitySearchActivity.this;
            entitySearchActivity.onFocusChange(entitySearchActivity.F, true);
            EntitySearchActivity.this.F.requestFocus();
        }
    }

    public static Intent e1(int i10, String str, String str2) {
        Intent intent = new Intent(App.m(), EntitySearchActivity.class);
        intent.putExtra("dataTypeKey", i10);
        intent.putExtra("sourceForAnalytics", str);
        intent.putExtra("screenForAnalytics", str2);
        return intent;
    }

    public static Intent g1(int i10, String str, String str2, String str3, boolean z10) {
        Intent intent = new Intent(App.m(), EntitySearchActivity.class);
        intent.putExtra("dataTypeKey", i10);
        intent.putExtra("sourceForAnalytics", str);
        intent.putExtra("screenForAnalytics", str2);
        intent.putExtra("containerType", str3);
        intent.putExtra("isOnboardingContext", z10);
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058 A[Catch: Exception -> 0x005f, TRY_LEAVE, TryCatch #0 {Exception -> 0x005f, blocks: (B:3:0x0002, B:5:0x000e, B:26:0x004a, B:27:0x0051, B:28:0x0058, B:12:0x0024, B:15:0x002e, B:18:0x0038), top: B:33:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String h1() {
        /*
            r6 = this;
            java.lang.String r0 = ""
            android.content.Intent r1 = r6.getIntent()     // Catch: java.lang.Exception -> L5f
            java.lang.String r2 = "containerType"
            java.lang.String r1 = r1.getStringExtra(r2)     // Catch: java.lang.Exception -> L5f
            if (r1 == 0) goto L63
            int r2 = r1.hashCode()     // Catch: java.lang.Exception -> L5f
            r3 = -1782210391(0xffffffff95c5a0a9, float:-7.9821143E-26)
            r4 = 2
            r5 = 1
            if (r2 == r3) goto L38
            r3 = -1095396929(0xffffffffbeb591bf, float:-0.35462758)
            if (r2 == r3) goto L2e
            r3 = -728071860(0xffffffffd49a814c, float:-5.3087536E12)
            if (r2 == r3) goto L24
            goto L42
        L24:
            java.lang.String r2 = "competitor"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L5f
            if (r1 == 0) goto L42
            r1 = 1
            goto L43
        L2e:
            java.lang.String r2 = "competition"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L5f
            if (r1 == 0) goto L42
            r1 = 2
            goto L43
        L38:
            java.lang.String r2 = "favourite"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L5f
            if (r1 == 0) goto L42
            r1 = 0
            goto L43
        L42:
            r1 = -1
        L43:
            if (r1 == 0) goto L58
            if (r1 == r5) goto L51
            if (r1 == r4) goto L4a
            goto L63
        L4a:
            java.lang.String r1 = "SEARCH_FOR_COMPETITIONS"
            java.lang.String r0 = li.p0.l0(r1)     // Catch: java.lang.Exception -> L5f
            goto L63
        L51:
            java.lang.String r1 = "SEARCH_FOR_TEAM"
            java.lang.String r0 = li.p0.l0(r1)     // Catch: java.lang.Exception -> L5f
            goto L63
        L58:
            java.lang.String r1 = "SEARCH_FOR_FAV_TEAM"
            java.lang.String r0 = li.p0.l0(r1)     // Catch: java.lang.Exception -> L5f
            goto L63
        L5f:
            r1 = move-exception
            li.x0.N1(r1)
        L63:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.dashboard.search.EntitySearchActivity.h1():java.lang.String");
    }

    public void d1() {
        if (this.toolbar != null) {
            for (int i10 = 0; i10 < this.toolbar.getChildCount(); i10++) {
                View childAt = this.toolbar.getChildAt(i10);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(1, 16.0f);
                    textView.setTypeface(o0.d(App.m()));
                }
            }
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        try {
            return h1();
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            gf.c.f2(null);
            Intent intent = new Intent();
            intent.putExtra("isDirty", this.f23385b0);
            setResult(-1, intent);
            super.onBackPressed();
        } catch (Exception unused) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22509e);
        initActionBar();
        try {
            d1();
            if (x0.l1()) {
                this.G = (LinearLayoutCompat) findViewById(R.id.Us);
                this.F = (SearchView) findViewById(R.id.Xs);
                this.H = (TextView) findViewById(R.id.No);
            } else {
                this.G = (LinearLayoutCompat) findViewById(R.id.Ss);
                this.F = (SearchView) findViewById(R.id.Ws);
                this.H = (TextView) findViewById(R.id.Mo);
            }
            this.H.setTypeface(o0.d(App.m()));
            try {
                TextView textView = (TextView) this.F.findViewById(androidx.appcompat.R.id.J);
                textView.setTextSize(1, 18.0f);
                textView.setTypeface(o0.d(App.m()));
                textView.setTextSize(1, 18.0f);
            } catch (Exception e10) {
                x0.N1(e10);
            }
            this.G.setVisibility(0);
            this.F.setVisibility(0);
            this.H.setVisibility(0);
            this.H.setText(p0.l0("NEW_DASHBOARD_SEARCH"));
            this.H.setOnClickListener(this.f23386f0);
            this.G.setOnClickListener(this.f23386f0);
            if (getIntent().getIntExtra("dataTypeKey", 3) == 5) {
                getSupportFragmentManager().q().q(R.id.f21973e4, d.Y1(getIntent().getStringExtra("sourceForAnalytics"), false, false), "EntitySearchFragment").h();
                this.F.setOnQueryTextFocusChangeListener(this);
                e1.C0(this.toolbar, p0.s(0));
            } else {
                getSupportFragmentManager().q().q(R.id.f21973e4, f.I1(getIntent().getIntExtra("dataTypeKey", 3), getIntent().getStringExtra("sourceForAnalytics"), false, -1), "EntitySearchFragment").h();
                this.F.setOnQueryTextFocusChangeListener(this);
                e1.C0(this.toolbar, p0.s(4));
            }
            if (getIntent().getBooleanExtra("isOnboardingContext", false)) {
                this.f23386f0.onClick(null);
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        try {
            this.H.setVisibility(8);
            if (this.I || !z10) {
                return;
            }
            gf.c Z1 = gf.c.Z1(getIntent().getIntExtra("dataTypeKey", 3), getIntent().getStringExtra("sourceForAnalytics"), getIntent().getStringExtra("screenForAnalytics"), false, -1, getIntent().getBooleanExtra("isOnboardingContext", false));
            getSupportFragmentManager().q().q(R.id.f21973e4, Z1, "EntitySearchFragment").h();
            this.F.setOnQueryTextListener(Z1);
            this.F.setIconifiedByDefault(false);
            ((ImageView) this.F.findViewById(androidx.appcompat.R.id.H)).setImageDrawable(null);
            this.I = true;
            e1.C0(this.toolbar, 0.0f);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        try {
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }
        onBackPressed();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                try {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
                    if (inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
