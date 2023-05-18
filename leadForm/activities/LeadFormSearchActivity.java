package com.scores365.leadForm.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.e1;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.Design.Activities.c;
import com.scores365.R;
import com.scores365.entitys.CompObj;
import com.scores365.leadForm.activities.LeadFormSearchActivity;
import ee.k;
import gf.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.o0;
import li.p0;
import li.x0;
/* compiled from: LeadFormSearchActivity.kt */
/* loaded from: classes2.dex */
public class LeadFormSearchActivity extends c implements View.OnFocusChangeListener {

    /* renamed from: g0  reason: collision with root package name */
    public static final a f24106g0 = new a(null);

    /* renamed from: h0  reason: collision with root package name */
    private static boolean f24107h0;
    private SearchView F;
    private LinearLayoutCompat G;
    private TextView H;

    /* renamed from: b0  reason: collision with root package name */
    private CompObj f24108b0;
    private int I = -1;

    /* renamed from: f0  reason: collision with root package name */
    private final View.OnClickListener f24109f0 = new View.OnClickListener() { // from class: gg.a
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            LeadFormSearchActivity.k1(LeadFormSearchActivity.this, view);
        }
    };

    /* compiled from: LeadFormSearchActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(int i10, String str) {
            Intent intent = new Intent(App.m(), LeadFormSearchActivity.class);
            intent.putExtra("lead_form_selected", i10);
            intent.putExtra("lead_form_anal_source", str);
            return intent;
        }

        public final void b(boolean z10) {
            LeadFormSearchActivity.f24107h0 = z10;
        }
    }

    private final void g1() {
        try {
            Toolbar toolbar = this.toolbar;
            if (toolbar != null) {
                int childCount = toolbar.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = this.toolbar.getChildAt(i10);
                    if (childAt != null && (childAt instanceof TextView)) {
                        ((TextView) childAt).setTextSize(1, 16.0f);
                        ((TextView) childAt).setTypeface(o0.d(App.m()));
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private final String h1() {
        try {
            String stringExtra = getIntent().getStringExtra("containerType");
            if (stringExtra != null && m.b(stringExtra, "competitor")) {
                String l02 = p0.l0("SEARCH_FOR_TEAM");
                m.f(l02, "getTerm(\"SEARCH_FOR_TEAM\")");
                return l02;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return "";
    }

    private final void i1() {
        try {
            int intExtra = getIntent().getIntExtra("dataTypeKey", 3);
            String stringExtra = getIntent().getStringExtra("sourceForAnalytics");
            Intent intent = getIntent();
            Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra("lead_form_selected", -1)) : null;
            m.d(valueOf);
            getSupportFragmentManager().q().q(R.id.f21973e4, f.I1(intExtra, stringExtra, true, valueOf.intValue()), "EntitySearchFragment").h();
            SearchView searchView = this.F;
            m.d(searchView);
            searchView.setOnQueryTextFocusChangeListener(this);
            e1.C0(this.toolbar, p0.s(4));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(LeadFormSearchActivity this$0, View view) {
        m.g(this$0, "this$0");
        Object systemService = this$0.getSystemService("input_method");
        m.e(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).toggleSoftInput(2, 0);
        SearchView searchView = this$0.F;
        m.d(searchView);
        this$0.onFocusChange(searchView, true);
        SearchView searchView2 = this$0.F;
        m.d(searchView2);
        searchView2.requestFocus();
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

    public final void m1(CompObj compObj) {
        this.f24108b0 = compObj;
    }

    public final void o1(int i10) {
        this.I = i10;
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            Intent intent = new Intent();
            intent.putExtra("isDirty", f24107h0);
            intent.putExtra("lead_form_selected", this.I);
            intent.putExtra("team_object", this.f24108b0);
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
        try {
            setContentView(R.layout.f22574j);
            setRequestedOrientation(1);
            initActionBar();
            g1();
            this.I = getIntent().getIntExtra("lead_form_selected", -1);
            this.f24108b0 = (CompObj) getIntent().getSerializableExtra("team_object");
            if (x0.l1()) {
                View findViewById = findViewById(R.id.Us);
                m.e(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat");
                this.G = (LinearLayoutCompat) findViewById;
                View findViewById2 = findViewById(R.id.Xs);
                m.e(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.SearchView");
                this.F = (SearchView) findViewById2;
                View findViewById3 = findViewById(R.id.No);
                m.e(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
                this.H = (TextView) findViewById3;
            } else {
                View findViewById4 = findViewById(R.id.Ss);
                m.e(findViewById4, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat");
                this.G = (LinearLayoutCompat) findViewById4;
                View findViewById5 = findViewById(R.id.Ws);
                m.e(findViewById5, "null cannot be cast to non-null type androidx.appcompat.widget.SearchView");
                this.F = (SearchView) findViewById5;
                View findViewById6 = findViewById(R.id.Mo);
                m.e(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
                this.H = (TextView) findViewById6;
            }
            LinearLayoutCompat linearLayoutCompat = this.G;
            m.d(linearLayoutCompat);
            linearLayoutCompat.setVisibility(0);
            SearchView searchView = this.F;
            m.d(searchView);
            searchView.setVisibility(0);
            TextView textView = this.H;
            m.d(textView);
            textView.setVisibility(0);
            LinearLayoutCompat linearLayoutCompat2 = this.G;
            m.d(linearLayoutCompat2);
            linearLayoutCompat2.setVisibility(0);
            SearchView searchView2 = this.F;
            m.d(searchView2);
            searchView2.setVisibility(0);
            TextView textView2 = this.H;
            m.d(textView2);
            textView2.setVisibility(0);
            TextView textView3 = this.H;
            m.d(textView3);
            textView3.setText(p0.l0("NEW_DASHBOARD_SEARCH"));
            TextView textView4 = this.H;
            m.d(textView4);
            textView4.setOnClickListener(this.f24109f0);
            LinearLayoutCompat linearLayoutCompat3 = this.G;
            m.d(linearLayoutCompat3);
            linearLayoutCompat3.setOnClickListener(this.f24109f0);
            i1();
            String a10 = hg.c.f27888u.a();
            Context m10 = App.m();
            String[] strArr = new String[8];
            strArr[0] = "promotion_name";
            strArr[1] = "lead-form";
            strArr[2] = "screen_name";
            strArr[3] = "browse-team";
            strArr[4] = "screen_type";
            strArr[5] = a10;
            strArr[6] = ShareConstants.FEED_SOURCE_PARAM;
            Intent intent = getIntent();
            strArr[7] = intent != null ? intent.getStringExtra("lead_form_anal_source") : null;
            k.n(m10, "general", "promotion-feature", "screen", ServerProtocol.DIALOG_PARAM_DISPLAY, false, strArr);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v10, boolean z10) {
        m.g(v10, "v");
        try {
            TextView textView = this.H;
            m.d(textView);
            textView.setVisibility(8);
            if (z10) {
                String stringExtra = getIntent().getStringExtra("sourceForAnalytics");
                String stringExtra2 = getIntent().getStringExtra("screenForAnalytics");
                int intExtra = getIntent().getIntExtra("dataTypeKey", 3);
                Intent intent = getIntent();
                Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra("lead_form_selected", -1)) : null;
                m.d(valueOf);
                gf.c Z1 = gf.c.Z1(intExtra, stringExtra, stringExtra2, true, valueOf.intValue(), false);
                getSupportFragmentManager().q().q(R.id.f21973e4, Z1, "EntitySearchFragment").h();
                SearchView searchView = this.F;
                m.d(searchView);
                searchView.setOnQueryTextListener(Z1);
                SearchView searchView2 = this.F;
                m.d(searchView2);
                searchView2.setIconifiedByDefault(false);
                SearchView searchView3 = this.F;
                m.d(searchView3);
                View findViewById = searchView3.findViewById(androidx.appcompat.R.id.H);
                m.e(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
                ((ImageView) findViewById).setImageDrawable(null);
                e1.C0(this.toolbar, 0.0f);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        m.g(item, "item");
        try {
            if (item.getItemId() == 16908332) {
                View currentFocus = getCurrentFocus();
                if (currentFocus != null) {
                    try {
                        Object systemService = getSystemService("input_method");
                        m.e(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                        ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
                onBackPressed();
                return true;
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                try {
                    Object systemService = getSystemService("input_method");
                    m.e(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                    ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }
}
