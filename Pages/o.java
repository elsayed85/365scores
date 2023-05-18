package com.scores365.Pages;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cc.o0;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.R;
import com.scores365.branding.BrandAsset;
import com.scores365.branding.BrandingKey;
import com.scores365.branding.BrandingStripItem;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.CountryObj;
import com.scores365.entitys.GameObj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import li.x0;
/* compiled from: KnockoutPage.java */
/* loaded from: classes2.dex */
public class o extends com.scores365.Design.Pages.q {

    /* renamed from: l  reason: collision with root package name */
    private String f21285l;

    /* renamed from: m  reason: collision with root package name */
    private CompetitionObj f21286m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f21287n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f21288o = false;

    /* renamed from: p  reason: collision with root package name */
    private int f21289p;

    /* renamed from: q  reason: collision with root package name */
    private String f21290q;

    /* renamed from: r  reason: collision with root package name */
    private GameObj f21291r;

    /* renamed from: s  reason: collision with root package name */
    private ImageView f21292s;

    public static o x1(String str, CompetitionObj competitionObj, Hashtable<Integer, CountryObj> hashtable, sc.i iVar, int i10, GameObj gameObj, String str2) {
        o oVar = new o();
        try {
            oVar.f21285l = str;
            oVar.placement = iVar;
            oVar.f21286m = competitionObj;
            oVar.f21289p = i10;
            oVar.f21290q = str2;
            oVar.f21291r = gameObj;
            oVar.setArguments(new Bundle());
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        return li.v.e(this.f21286m, this.f21291r, this.f21289p, this.f21290q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void OnScrollEvent(RecyclerView recyclerView, int i10, int i11, int i12, int i13) {
        try {
            super.OnScrollEvent(recyclerView, i10, i11, i12, i13);
            if (this.f21287n && !this.f21288o) {
                this.f21288o = true;
                this.f21287n = false;
                ee.k.n(App.m(), "general", "knockout", "swipe", null, true, ShareConstants.FEED_SOURCE_PARAM, this.f21290q, "entity_type", AppEventsConstants.EVENT_PARAM_VALUE_YES, "entity_id", String.valueOf(this.f21286m.getID()));
            }
            this.f21287n = true;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return this.pageIconLink;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public int getLayoutResourceID() {
        return R.layout.N1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.a
    public int getPaddingSize() {
        try {
            if (getParentFragment() instanceof zc.c) {
                return ((zc.c) getParentFragment()).getPaddingSize(this);
            }
            return 0;
        } catch (Exception e10) {
            x0.N1(e10);
            return 0;
        }
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return this.f21285l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.a
    public boolean hasContentPadding() {
        try {
            if (getParentFragment() instanceof zc.c) {
                if (!((zc.c) getParentFragment()).T1()) {
                    if (!getContentPaddingListener().contentHasPadding()) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void initRecyclerViewLayoutManager() {
        try {
            this.rvLayoutMgr = new LinearLayoutManager(getActivity());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.a
    public boolean isContainedInCoordinatorLayout() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        super.onRecyclerViewItemClick(i10);
        try {
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            if (A instanceof qf.d) {
                qf.d dVar = (qf.d) A;
                if (dVar.m() != -1) {
                    if (dVar.o()[dVar.m()].getFutureGames().length > 1) {
                        qe.b.x1(dVar.o()[dVar.m()], this.f21286m.getSid(), dVar.v(), this.f21286m).show(getChildFragmentManager(), "BRACKETS_DIALOG_TAG");
                    }
                    if (!(dVar instanceof qf.b)) {
                        dVar.x(-1);
                    }
                    ee.k.i(App.m(), "dashboard", "knockout", "series-click", null);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void relateCustomViews(View view) {
        try {
            this.f21292s = (ImageView) view.findViewById(R.id.f22139ld);
            BrandAsset k10 = o0.y() != null ? o0.y().k(BrandingKey.knockoutBackground) : null;
            if (k10 != null && this.f21286m != null) {
                fc.a y10 = o0.y();
                BrandingKey brandingKey = BrandingKey.knockoutBackground;
                if (y10.O(brandingKey, -1, -1, this.f21286m.getID(), -1)) {
                    li.u.x(k10.getResource(), this.f21292s);
                    this.f21292s.setVisibility(0);
                    x0.S(k10.getImpressionUrl());
                    BrandingStripItem.sendImpressionAnalytics(brandingKey, k10);
                    return;
                }
            }
            this.f21292s.setVisibility(8);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.q
    public <T extends Collection> void renderData(T t10) {
        super.renderData(t10);
        try {
            int i10 = li.v.f34668a;
            if (i10 > 0) {
                this.rvItems.p1(i10);
                this.rvItems.t1(0, -1);
                this.rvItems.t1(0, 1);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
