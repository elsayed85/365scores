package com.scores365.Pages;

import android.os.Bundle;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.AppEventsConstants;
import com.scores365.App;
import com.scores365.Design.Pages.RtlGridLayoutManager;
import com.scores365.R;
import com.scores365.dashboard.a;
import com.scores365.dashboard.singleEntity.SingleEntityDashboardActivity;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.SquadDashboardObj;
import java.util.ArrayList;
import java.util.Collection;
import li.x0;
/* compiled from: SquadsPage.java */
/* loaded from: classes2.dex */
public class b0 extends com.scores365.Design.Pages.q {

    /* renamed from: l  reason: collision with root package name */
    private SquadDashboardObj f21178l;

    /* renamed from: m  reason: collision with root package name */
    private String f21179m;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<com.scores365.Design.PageObjects.b> f21180n;

    /* renamed from: o  reason: collision with root package name */
    private int f21181o;

    /* renamed from: p  reason: collision with root package name */
    private NestedScrollView f21182p;

    /* renamed from: q  reason: collision with root package name */
    private CompetitionObj f21183q;

    /* renamed from: r  reason: collision with root package name */
    private String f21184r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f21185s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f21186t = false;

    /* compiled from: SquadsPage.java */
    /* loaded from: classes2.dex */
    class a extends GridLayoutManager.c {
        a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i10) {
            try {
                int u10 = ((GridLayoutManager) ((com.scores365.Design.Pages.q) b0.this).rvLayoutMgr).u();
                int spanSize = ((com.scores365.Design.Pages.q) b0.this).rvBaseAdapter.A(i10).getSpanSize();
                return u10 < spanSize ? u10 : spanSize;
            } catch (Exception e10) {
                x0.N1(e10);
                return 1;
            }
        }
    }

    public static b0 z1(SquadDashboardObj squadDashboardObj, String str, int i10, sc.i iVar, int i11, CompetitionObj competitionObj, String str2, String str3) {
        b0 b0Var = new b0();
        try {
            b0Var.f21178l = squadDashboardObj;
            b0Var.f21179m = str;
            b0Var.f21181o = i10;
            b0Var.placement = iVar;
            b0Var.f21183q = competitionObj;
            b0Var.f21184r = str2;
            Bundle bundle = new Bundle();
            bundle.putInt("sport_id_tag", i11);
            bundle.putString("page_key", str3);
            b0Var.setArguments(bundle);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return b0Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        try {
            this.f21180n = new ArrayList<>();
            SquadDashboardObj squadDashboardObj = this.f21178l;
            if (squadDashboardObj != null) {
                for (Integer num : squadDashboardObj.competitorById.keySet()) {
                    this.f21180n.add(new lf.m(this.f21178l.competitorById.get(num), this.f21181o));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.f21180n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void OnScrollEvent(RecyclerView recyclerView, int i10, int i11, int i12, int i13) {
        try {
            super.OnScrollEvent(recyclerView, i10, i11, i12, i13);
            if (this.f21185s && !this.f21186t) {
                this.f21186t = true;
                this.f21185s = false;
                ee.k.n(App.m(), "dashboard", "squads", "swipe", null, true, "entity_type", AppEventsConstants.EVENT_PARAM_VALUE_YES, "entity_id", String.valueOf(this.f21181o));
            }
            this.f21185s = true;
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

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return this.f21179m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void initRecyclerViewLayoutManager() {
        try {
            int i10 = com.scores365.Design.Activities.c.fragmentSpanSize;
            if (App.f20803w && !getResources().getBoolean(R.bool.f21607c)) {
                i10 = 4;
            }
            RtlGridLayoutManager rtlGridLayoutManager = new RtlGridLayoutManager(getActivity().getApplicationContext(), i10);
            this.rvLayoutMgr = rtlGridLayoutManager;
            rtlGridLayoutManager.setOrientation(1);
            if (x0.l1()) {
                ((RtlGridLayoutManager) this.rvLayoutMgr).E();
            }
            ((GridLayoutManager) this.rvLayoutMgr).C(new a());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        super.onRecyclerViewItemClick(i10);
        try {
            x0.y2(((lf.m) this.f21180n.get(i10)).f34371a, getActivity(), true, getActivity() instanceof SingleEntityDashboardActivity ? "sorted-entity" : "scores");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            com.scores365.Design.Pages.c cVar = this.rvBaseAdapter;
            if (cVar != null) {
                cVar.notifyDataSetChanged();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void relateCustomViews(View view) {
        this.f21182p = (NestedScrollView) view.findViewById(R.id.Er);
    }

    @Override // com.scores365.Design.Pages.q
    public <T extends Collection> void renderData(T t10) {
        if (t10 != null) {
            try {
                if (!t10.isEmpty()) {
                    super.renderData(t10);
                    return;
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        String string = getArguments().getString("page_key");
        if (string == null || string.isEmpty() || isPageDataFetched()) {
            return;
        }
        setPageDataFetched(true);
        if (getParentFragment() instanceof a.d) {
            a.d dVar = (a.d) getParentFragment();
        } else if (getActivity() instanceof a.d) {
            a.d dVar2 = (a.d) getActivity();
        }
        if (getPagesDataListener() != null) {
            getPagesDataListener().x0(string, this);
        }
    }

    @Override // com.scores365.Design.Pages.a
    public void updatePageData(Object obj) {
        try {
            super.updatePageData(obj);
            SquadDashboardObj squadDashboardObj = (SquadDashboardObj) obj;
            this.f21178l = squadDashboardObj;
            this.f21181o = squadDashboardObj.competitionById.keySet().iterator().next().intValue();
            getArguments().putInt("sport_id_tag", this.f21178l.competitionById.values().iterator().next().getSid());
            LoadDataAsync();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
