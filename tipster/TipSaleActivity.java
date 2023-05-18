package com.scores365.tipster;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.viewpager.widget.ViewPager;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.Design.Activities.c;
import com.scores365.Design.Pagers.GeneralTabPageIndicator;
import com.scores365.Design.Pages.CustomViewPager;
import com.scores365.Pages.u;
import com.scores365.R;
import com.scores365.entitys.PurchasesObj;
import com.scores365.tipster.a;
import ee.k;
import fi.f;
import fi.o;
import fi.p;
import java.util.ArrayList;
import java.util.HashMap;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class TipSaleActivity extends c {
    private int F;
    private GeneralTabPageIndicator H;
    private CustomViewPager I;

    /* renamed from: b0  reason: collision with root package name */
    private RelativeLayout f24279b0;
    private int G = -1;

    /* renamed from: f0  reason: collision with root package name */
    private final ViewPager.j f24280f0 = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements c0<f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveData f24281a;

        a(LiveData liveData) {
            this.f24281a = liveData;
        }

        @Override // androidx.lifecycle.c0
        /* renamed from: a */
        public void d(f fVar) {
            String str;
            if (fVar != null) {
                this.f24281a.o(this);
                TipSaleActivity.this.f24279b0.setVisibility(8);
                PurchasesObj d10 = fVar.d();
                TipSaleActivity.this.F = fVar.b();
                TipSaleActivity.this.G = fVar.a();
                String stringExtra = TipSaleActivity.this.getIntent().getStringExtra("sourceForAnalytics");
                String stringExtra2 = TipSaleActivity.this.getIntent().getStringExtra("entityId");
                TipSaleActivity.this.u1(d10, stringExtra);
                boolean booleanExtra = TipSaleActivity.this.getIntent().getBooleanExtra("showSubscriptionTab", false);
                ArrayList arrayList = new ArrayList();
                if (booleanExtra) {
                    str = "purchase_source";
                    TipSaleActivity.this.H.setVisibility(8);
                } else {
                    if (TipSaleActivity.this.getIntent().getExtras() == null || !TipSaleActivity.this.getIntent().getExtras().containsKey("purchase_source")) {
                        TipSaleActivity.this.getIntent().putExtra("purchase_source", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    } else if (!String.valueOf(TipSaleActivity.this.getIntent().getExtras().get("purchase_source")).equals("2")) {
                        TipSaleActivity.this.getIntent().putExtra("purchase_source", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    }
                    str = "purchase_source";
                    arrayList.add(new p(p0.l0("SINGLE_TIP_TAB"), stringExtra, stringExtra2, TipSaleActivity.this.getIntent().getStringExtra("purchase_source"), TipSaleActivity.this.getIntent().getStringExtra("notification_id"), TipSaleActivity.this.getIntent().getStringExtra("entityType"), TipSaleActivity.this.F, TipSaleActivity.this.G));
                }
                arrayList.add(new o(p0.l0("SUBSCRIPTIONS_TAB"), stringExtra, String.valueOf(TipSaleActivity.this.getIntent().getExtras().get(str)), TipSaleActivity.this.getIntent().getStringExtra("notification_id"), TipSaleActivity.this.getIntent().getBooleanExtra("showSingleOffer", false), TipSaleActivity.this.getIntent().getIntExtra("tipsterWorldCupClickType", -1), TipSaleActivity.this.F, TipSaleActivity.this.G));
                TipSaleActivity.this.I.setAdapter(new u(TipSaleActivity.this.getSupportFragmentManager(), arrayList));
                TipSaleActivity.this.H.setViewPager(TipSaleActivity.this.I);
                if (booleanExtra || TipSaleActivity.this.F >= 1) {
                    return;
                }
                TipSaleActivity.this.I.setCurrentItem(1);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements ViewPager.j {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            try {
                k.o(App.m(), "tip-sale", "purchase", "tab", "click", "free_tips_left", String.valueOf(TipSaleActivity.this.F), "entity_type", "4", "entity_id", TipSaleActivity.this.getIntent().getExtras().getString("entityId"), "tipster_id", String.valueOf(TipSaleActivity.this.G), ShareConstants.FEED_SOURCE_PARAM, TipSaleActivity.this.getIntent().getExtras().getString("sourceForAnalytics"), "tab", TipSaleActivity.this.s1(i10));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    private void d1() {
        LiveData<f> B = ((App) getApplication()).w().B();
        B.j(this, new a(B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s1(int i10) {
        try {
            return (!getIntent().getBooleanExtra("showSubscriptionTab", false) && i10 == 0) ? "single" : "subscriptions";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    @NonNull
    public static Intent t1(String str, boolean z10, String str2, String str3, String str4, boolean z11) {
        Intent intent = new Intent(App.m(), TipSaleActivity.class);
        intent.putExtra("notification_id", str);
        intent.putExtra("sourceForAnalytics", str2);
        intent.putExtra("showSubscriptionTab", z10);
        intent.putExtra("entityId", str3);
        intent.putExtra("purchase_source", str4);
        intent.putExtra("showSingleOffer", z11);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(@NonNull PurchasesObj purchasesObj, @NonNull String str) {
        HashMap hashMap = new HashMap();
        if (purchasesObj.tipBalance != null) {
            hashMap.put("free_tips_left", Integer.valueOf(this.F));
        }
        hashMap.put("entity_type", "4");
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, str);
        hashMap.put("tab", s1(0));
        hashMap.put("ab-test", "false");
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("entityId")) {
                hashMap.put("entity_id", intent.getStringExtra("entityId"));
            }
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("purchase_source")) {
                hashMap.put("purchase_source", String.valueOf(extras.get("purchase_source")));
                hashMap.put(ShareConstants.FEED_SOURCE_PARAM, String.valueOf(extras.get("purchase_source")));
            }
        }
        int i10 = this.G;
        if (i10 > -1) {
            hashMap.put("tipster_id", String.valueOf(i10));
        }
        k.k(App.m(), "tip-sale", "purchase", ServerProtocol.DIALOG_PARAM_DISPLAY, null, hashMap);
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return p0.l0("PURCHASE_SCREEN_TITLE");
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            if (getIntent().getBooleanExtra(c.IS_NOTIFICATION_ACTIVITY, false)) {
                startActivity(x0.x0());
                finish();
            } else {
                super.onBackPressed();
            }
        } catch (Exception unused) {
            super.onBackPressed();
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.M9);
        initActionBar();
        try {
            TextView textView = (TextView) findViewById(R.id.YG);
            this.H = (GeneralTabPageIndicator) findViewById(R.id.Lr);
            this.I = (CustomViewPager) findViewById(R.id.PI);
            TextView textView2 = (TextView) findViewById(R.id.My);
            textView2.setVisibility(8);
            this.f24279b0 = (RelativeLayout) findViewById(R.id.Jn);
            textView.setTypeface(o0.b(App.m()));
            textView2.setTypeface(o0.b(App.m()));
            textView2.setText(Html.fromHtml((p0.l0("TIPS_DISCLAIMER").replace("#", "<font color=#03a9f4>") + "</font>").replace("EULA_LINK_TERM", p0.l0("TIPS_ELUA"))));
            textView.setText(Html.fromHtml(p0.l0("TIPSTERS_PROMOTION_TITLE").replaceAll("#", "<font color=#03a9f4>") + "</font>"));
            this.H.setTabIndicatorColorWhite(true);
            this.H.p(String.format("%06X", Integer.valueOf(p0.A(R.attr.U0) & 16777215)), String.format("%06X", Integer.valueOf(16777215 & p0.A(R.attr.f21565m1))));
            this.H.setAlignTabTextToBottom(true);
            this.H.setExpandedTabsContext(true);
            this.H.n();
            this.H.setOnPageChangeListener(this.f24280f0);
            this.I.setSwipePagingEnabled(false);
            this.f24279b0.setVisibility(0);
            textView2.setOnClickListener(new a.View$OnClickListenerC0259a("", getIntent().getStringExtra("sourceForAnalytics")));
            d1();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
