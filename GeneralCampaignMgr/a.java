package com.scores365.GeneralCampaignMgr;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import cc.o0;
import com.scores365.Design.Pagers.GeneralTabPageIndicator;
import com.scores365.GeneralCampaignMgr.b;
import com.scores365.GeneralCampaignMgr.pages.CompareWebViewPage;
import com.scores365.R;
import java.util.ArrayList;
import java.util.HashSet;
import lf.c;
import lf.t;
import li.x0;
/* compiled from: GeneralCampaignMainFragment.java */
/* loaded from: classes2.dex */
public class a extends xe.b {
    private String k2() {
        return getArguments() != null ? getArguments().getString("campaignId", "") : "";
    }

    private void l2(int i10) {
        for (int i11 = 0; i11 < this.f36993o.getChildCount(); i11++) {
            try {
                Fragment fragment = (Fragment) this.f36993o.getAdapter().i(this.f36993o, i11);
                if (fragment instanceof CompareWebViewPage) {
                    if (i11 != i10) {
                        ((CompareWebViewPage) fragment).r1().onPause();
                    } else {
                        ((CompareWebViewPage) fragment).r1().onResume();
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
    }

    public static a m2(t tVar, String str) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("campaignId", str);
        if (tVar != null) {
            bundle.putInt("dashboardMenuTag", tVar.getValue());
        }
        aVar.setArguments(bundle);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xe.b, qb.a, qb.f
    public GeneralTabPageIndicator A1(View view) {
        GeneralTabPageIndicator A1 = super.A1(view);
        A1.p(b.c(k2()).getSelectedTabColor(), b.c(k2()).getTabColor());
        return A1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xe.b
    public int S1() {
        return R.layout.D0;
    }

    @Override // xe.b
    public t T1() {
        return t.SPECIAL;
    }

    @Override // xe.b
    protected ArrayList<com.scores365.Design.Pages.b> V1() {
        HashSet hashSet = new HashSet();
        try {
            hashSet.add(Integer.valueOf(o0.y().s("DEFENDERS_SPECIAL_SECTION_COMPID_NEWS_VIDEOS", 6863)));
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return b.d(b.e(k2()), new c(new HashSet(), hashSet, new HashSet(), new HashSet()));
    }

    @Override // xe.b
    protected Drawable X1() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xe.b
    public void d2(Toolbar toolbar, ViewPager viewPager) {
        try {
            if (b.g()) {
                this.C.setImageBitmap(b.b(b.i(b.a.Header, b.f(k2()))));
                this.C.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.C.setVisibility(0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // xe.b, cc.e1
    public boolean isBannerNeedToBeVisible() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        try {
            super.onHiddenChanged(z10);
            ViewPager viewPager = this.f36993o;
            if (viewPager != null) {
                androidx.viewpager.widget.a adapter = viewPager.getAdapter();
                ViewPager viewPager2 = this.f36993o;
                Fragment fragment = (Fragment) adapter.i(viewPager2, viewPager2.getCurrentItem());
                if (fragment instanceof CompareWebViewPage) {
                    ((CompareWebViewPage) fragment).r1().onPause();
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xe.b, qb.f
    public void t1(int i10) {
        super.t1(i10);
        l2(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xe.b, qb.f
    public void v1() {
        super.v1();
        try {
            this.f36993o.setOffscreenPageLimit(this.f36995q.e());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
