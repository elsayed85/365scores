package com.scores365.GeneralCampaignMgr;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.a1;
import androidx.lifecycle.w0;
import androidx.viewpager.widget.ViewPager;
import cc.o0;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.scores365.Design.Activities.c;
import com.scores365.Design.Pagers.GeneralTabPageIndicator;
import com.scores365.GeneralCampaignMgr.b;
import com.scores365.GeneralCampaignMgr.pages.CompareWebViewPage;
import com.scores365.Pages.u;
import com.scores365.R;
import com.scores365.dashboard.a;
import com.scores365.entitys.StatsFilter;
import ee.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import lf.t;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class GeneralCampaignMgrActivity extends c implements a.d {
    private ViewPager F;
    private u G;
    private FrameLayout H;
    private ArrayList<com.scores365.Design.Pages.b> I;

    /* renamed from: b0  reason: collision with root package name */
    private lf.c f21081b0;

    /* renamed from: f0  reason: collision with root package name */
    private String f21082f0;

    /* renamed from: g0  reason: collision with root package name */
    private com.scores365.dashboard.a f21083g0;

    /* renamed from: h0  reason: collision with root package name */
    private xe.c f21084h0;

    /* renamed from: i0  reason: collision with root package name */
    private final a1 f21085i0 = this;

    /* renamed from: j0  reason: collision with root package name */
    ViewPager.j f21086j0 = new b();

    /* loaded from: classes2.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f21087a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f21088b;

        a(int i10, Object obj) {
            this.f21087a = i10;
            this.f21088b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Fragment fragment = (Fragment) GeneralCampaignMgrActivity.this.F.getAdapter().i(GeneralCampaignMgrActivity.this.F, this.f21087a);
                if (fragment == null || !(fragment instanceof com.scores365.Design.Pages.a)) {
                    return;
                }
                ((com.scores365.Design.Pages.a) fragment).updatePageData(this.f21088b);
            } catch (Exception e10) {
                x0.N1(e10);
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
                GeneralCampaignMgrActivity.this.h1(i10);
                Context applicationContext = GeneralCampaignMgrActivity.this.getApplicationContext();
                k.o(applicationContext, "ad", ServerProtocol.DIALOG_PARAM_DISPLAY, null, null, AppEventsConstants.EVENT_PARAM_AD_TYPE, "Section_" + GeneralCampaignMgrActivity.this.f21082f0, "ad_screen", "Tab_" + i10, "network", "Sections");
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(int i10) {
        for (int i11 = 0; i11 < this.F.getChildCount(); i11++) {
            Fragment fragment = (Fragment) this.F.getAdapter().i(this.F, i11);
            if (fragment instanceof CompareWebViewPage) {
                if (i11 != i10) {
                    ((CompareWebViewPage) fragment).r1().onPause();
                } else {
                    ((CompareWebViewPage) fragment).r1().onResume();
                }
            }
        }
    }

    private void i1() {
        this.H = (FrameLayout) findViewById(R.id.f22132l6);
        this.F = (ViewPager) findViewById(R.id.PI);
        GeneralTabPageIndicator generalTabPageIndicator = (GeneralTabPageIndicator) findViewById(R.id.Lr);
        generalTabPageIndicator.p(com.scores365.GeneralCampaignMgr.b.c(this.f21082f0).getSelectedTabColor(), com.scores365.GeneralCampaignMgr.b.c(this.f21082f0).getTabColor());
        String e10 = com.scores365.GeneralCampaignMgr.b.e(this.f21082f0);
        if (!e10.isEmpty()) {
            this.I = com.scores365.GeneralCampaignMgr.b.d(e10, this.f21081b0);
        }
        u uVar = new u(getSupportFragmentManager(), this.I);
        this.G = uVar;
        this.F.setAdapter(uVar);
        generalTabPageIndicator.setViewPager(this.F);
        generalTabPageIndicator.setOnPageChangeListener(this.f21086j0);
    }

    @Override // com.scores365.dashboard.a.d
    public boolean I0() {
        return false;
    }

    @Override // com.scores365.dashboard.a.d
    public String Q0() {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES;
    }

    @Override // com.scores365.dashboard.a.d
    public void S0() {
    }

    @Override // com.scores365.dashboard.a.d
    public ArrayList<StatsFilter> U0() {
        return null;
    }

    @Override // com.scores365.dashboard.a.d
    public int e0() {
        return 0;
    }

    @Override // com.scores365.dashboard.a.d
    public void f0(ArrayList<StatsFilter> arrayList) {
    }

    @Override // com.scores365.dashboard.a.d
    public boolean f1() {
        return false;
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return null;
    }

    @Override // com.scores365.dashboard.a.d
    public void k0(String str, Object obj) {
        Object obj2;
        try {
            Iterator<com.scores365.Design.Pages.b> it = this.I.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                com.scores365.Design.Pages.b next = it.next();
                String str2 = next.pageKey;
                if (str2 != null && str2.equals(str)) {
                    obj2 = next.updateData(obj);
                    break;
                }
                i10++;
            }
            runOnUiThread(new a(i10, obj2));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.dashboard.a.d
    public ArrayList<com.scores365.Design.Pages.b> l0(t tVar) {
        return null;
    }

    @Override // com.scores365.dashboard.a.d
    public lf.c l1() {
        return this.f21081b0;
    }

    @Override // com.scores365.dashboard.a.d
    public void n1(String str, Object obj) {
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            setResult(1456);
            if (this.H.getVisibility() == 0) {
                this.H.setVisibility(8);
            } else {
                super.onBackPressed();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f21084h0 = (xe.c) new w0(this.f21085i0).a(xe.c.class);
            Intent intent = getIntent();
            com.scores365.dashboard.a aVar = new com.scores365.dashboard.a();
            this.f21083g0 = aVar;
            aVar.z(this.f21084h0, this.f21085i0);
            this.f21082f0 = intent.getExtras().getString("selectionID");
            if (x0.l0()) {
                getWindow().addFlags(Integer.MIN_VALUE);
                getWindow().clearFlags(67108864);
                getWindow().setStatusBarColor(getResources().getColor(R.color.f21633w));
            }
        } catch (NumberFormatException e10) {
            x0.N1(e10);
        }
        setContentView(R.layout.f22457a);
        initActionBar();
        try {
            getSupportActionBar().r(null);
            getSupportActionBar().D("");
            this.toolbar.setTitle("");
            try {
                ImageView imageView = (ImageView) findViewById(R.id.f22029ge);
                TypedValue typedValue = new TypedValue();
                int s10 = p0.s(48);
                if (getTheme().resolveAttribute(16843499, typedValue, true)) {
                    s10 = TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
                }
                imageView.getLayoutParams().height = (int) (s10 + getResources().getDimension(R.dimen.M));
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setAdjustViewBounds(true);
                if (com.scores365.GeneralCampaignMgr.b.g()) {
                    imageView.setImageBitmap(com.scores365.GeneralCampaignMgr.b.b(com.scores365.GeneralCampaignMgr.b.i(b.a.Header, com.scores365.GeneralCampaignMgr.b.f(this.f21082f0))));
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
            } catch (Resources.NotFoundException e11) {
                x0.N1(e11);
            }
            HashSet hashSet = new HashSet();
            try {
                hashSet.add(Integer.valueOf(o0.y().s("DEFENDERS_SPECIAL_SECTION_COMPID_NEWS_VIDEOS", 6863)));
            } catch (Exception e12) {
                x0.N1(e12);
            }
            this.f21081b0 = new lf.c(new HashSet(), hashSet, new HashSet(), new HashSet());
            i1();
        } catch (Exception e13) {
            x0.N1(e13);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            Context applicationContext = getApplicationContext();
            k.o(applicationContext, "ad", ServerProtocol.DIALOG_PARAM_DISPLAY, null, null, AppEventsConstants.EVENT_PARAM_AD_TYPE, "Section_" + this.f21082f0, "ad_screen", "Tab" + this.F.getCurrentItem(), "network", "Sections");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.dashboard.a.d
    public Object p0(String str) {
        return null;
    }

    @Override // com.scores365.dashboard.a.d
    public int p1() {
        return 0;
    }

    @Override // com.scores365.dashboard.a.d
    public Object r0(String str) {
        return null;
    }

    @Override // com.scores365.dashboard.a.d
    public void x0(String str, a.c cVar) {
    }

    @Override // com.scores365.dashboard.a.d
    public boolean y0() {
        return false;
    }
}
