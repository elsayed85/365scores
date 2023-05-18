package com.scores365.Pages;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.scores365.App;
import com.scores365.R;
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BetLineType;
import com.scores365.bets.model.GameBetsObj;
import com.scores365.gameCenter.GameCenterBaseActivity;
import com.scores365.gameCenter.i0;
import com.scores365.ui.GridSelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import ke.d;
import li.p0;
import li.x0;
/* compiled from: OddsPage.java */
/* loaded from: classes2.dex */
public class t extends com.scores365.Design.Pages.e implements d.InterfaceC0402d, AdapterView.OnItemSelectedListener, GridSelector.GridSelectorEvents {

    /* renamed from: m  reason: collision with root package name */
    ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> f21313m;

    /* renamed from: n  reason: collision with root package name */
    i0 f21314n;

    /* renamed from: o  reason: collision with root package name */
    int f21315o = -1;

    /* renamed from: p  reason: collision with root package name */
    HashSet<Integer> f21316p = new HashSet<>();

    /* renamed from: q  reason: collision with root package name */
    int f21317q = 0;

    /* renamed from: r  reason: collision with root package name */
    boolean f21318r = false;

    /* renamed from: s  reason: collision with root package name */
    private HashSet<Integer> f21319s = new HashSet<>();

    /* compiled from: OddsPage.java */
    /* loaded from: classes2.dex */
    class a extends GridLayoutManager.c {
        a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i10) {
            try {
                return ((GridLayoutManager) ((com.scores365.Design.Pages.q) t.this).rvLayoutMgr).u();
            } catch (Exception e10) {
                x0.N1(e10);
                return 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K1() {
        LoadDataAsync();
    }

    public static t L1(i0 i0Var) {
        t tVar = new t();
        try {
            tVar.f21314n = i0Var;
            Bundle bundle = new Bundle();
            bundle.putString("your_empty_msg", p0.l0("1X2_EMPTY_SCREEN").replace("#", "\n"));
            tVar.setArguments(bundle);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return tVar;
    }

    private void M1(int i10, String str, boolean z10) {
        if (z10) {
            try {
                ee.k.n(App.m(), "gamecenter", "odds-nw", "market-type", "click", true, "game_id", String.valueOf(this.f21314n.C0().getID()), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.T(this.f21314n.C0()), "market_type", String.valueOf(((ld.b) this.rvBaseAdapter.A(i10)).f34110f), "rank", String.valueOf(i10), "click_type", str);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    private void N1(int i10) {
        try {
            Iterator<com.scores365.Design.PageObjects.b> it = this.f21313m.get(i10).iterator();
            while (it.hasNext()) {
                com.scores365.Design.PageObjects.b next = it.next();
                if ((next instanceof ld.d) && !this.f21319s.contains(Integer.valueOf(((ld.d) next).f34122b.getID()))) {
                    BetLine betLine = ((ld.d) next).f34122b;
                    String trackingURL = betLine.getTrackingURL();
                    if (!trackingURL.isEmpty()) {
                        ke.d.p(trackingURL);
                    }
                    BetLineType betLineType = App.l().bets.getLineTypes().get(Integer.valueOf(((ld.d) next).f34122b.getBetLineType().getID()));
                    Context m10 = App.m();
                    String[] strArr = new String[10];
                    strArr[0] = "game_id";
                    strArr[1] = String.valueOf(this.f21314n.C0().getID());
                    strArr[2] = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS;
                    strArr[3] = i0.D0(this.f21314n.C0());
                    strArr[4] = "section";
                    strArr[5] = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                    strArr[6] = "market_type";
                    strArr[7] = betLineType != null ? String.valueOf(betLineType.getID()) : "";
                    strArr[8] = "bookie_id";
                    strArr[9] = String.valueOf(betLine.bookmakerId);
                    ee.k.n(m10, "gamecenter", "bets-impressions", "show", null, false, strArr);
                    this.f21319s.add(Integer.valueOf(betLine.getID()));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void O1(boolean z10) {
        if (!z10) {
            try {
                if (GameCenterBaseActivity.C2() != bg.e.ODDS) {
                    return;
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        if (x0.s2()) {
            for (int i10 = 0; i10 < this.f21313m.size(); i10++) {
                if (((ld.b) this.f21313m.get(i10).get(0)).isExpanded()) {
                    N1(i10);
                }
            }
        }
    }

    private void P1(GameBetsObj gameBetsObj) {
        int i10;
        try {
            this.f21314n.k1().t(gameBetsObj);
            this.f21314n.k1().h(this.f21315o);
            ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> k10 = this.f21314n.k1().k(this.f21315o, this, this.f21314n.C0());
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<ArrayList<com.scores365.Design.PageObjects.b>> it = k10.iterator();
            while (true) {
                i10 = 0;
                if (!it.hasNext()) {
                    break;
                }
                ArrayList<com.scores365.Design.PageObjects.b> next = it.next();
                if (next.get(0) instanceof ld.b) {
                    linkedHashMap.put(Integer.valueOf(((ld.b) next.get(0)).f34110f), next);
                }
            }
            Iterator<ArrayList<com.scores365.Design.PageObjects.b>> it2 = this.f21313m.iterator();
            while (it2.hasNext()) {
                ArrayList<com.scores365.Design.PageObjects.b> next2 = it2.next();
                if (next2.get(0) instanceof ld.b) {
                    linkedHashSet.add(Integer.valueOf(((ld.b) next2.get(0)).f34110f));
                }
            }
            int i11 = 0;
            while (i11 < this.f21313m.size()) {
                ArrayList<com.scores365.Design.PageObjects.b> arrayList = this.f21313m.get(i11);
                if (arrayList.get(i10) instanceof ld.b) {
                    ld.b bVar = (ld.b) arrayList.get(i10);
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    Iterator<com.scores365.Design.PageObjects.b> it3 = arrayList.iterator();
                    int i12 = -1;
                    while (it3.hasNext()) {
                        com.scores365.Design.PageObjects.b next3 = it3.next();
                        if (next3 instanceof ld.f) {
                            i12 = ((ld.f) next3).l();
                        }
                        if (next3 instanceof ld.d) {
                            linkedHashSet2.add(Integer.valueOf(((ld.d) next3).f34122b.getID()));
                        }
                    }
                    if (i12 != -1) {
                        Iterator<com.scores365.Design.PageObjects.b> it4 = this.f21314n.k1().m(this.f21315o, i12, this.f21314n.C0()).iterator();
                        while (it4.hasNext()) {
                            com.scores365.Design.PageObjects.b next4 = it4.next();
                            if (next4 instanceof ld.d) {
                                linkedHashMap2.put(Integer.valueOf(((ld.d) next4).f34122b.getID()), next4);
                            }
                        }
                    } else {
                        Iterator it5 = ((ArrayList) linkedHashMap.get(Integer.valueOf(bVar.f34110f))).iterator();
                        while (it5.hasNext()) {
                            com.scores365.Design.PageObjects.b bVar2 = (com.scores365.Design.PageObjects.b) it5.next();
                            if (bVar2 instanceof ld.d) {
                                linkedHashMap2.put(Integer.valueOf(((ld.d) bVar2).f34122b.getID()), bVar2);
                            }
                        }
                    }
                    Iterator<com.scores365.Design.PageObjects.b> it6 = arrayList.iterator();
                    while (it6.hasNext()) {
                        com.scores365.Design.PageObjects.b next5 = it6.next();
                        if (next5 instanceof ld.d) {
                            ld.d dVar = (ld.d) next5;
                            if (gameBetsObj.betLines.containsKey(Integer.valueOf(dVar.f34122b.getID()))) {
                                dVar.p(gameBetsObj.betLines.get(Integer.valueOf(dVar.f34122b.getID())));
                                hashSet.add(Integer.valueOf(i11));
                            }
                        }
                    }
                    for (Integer num : linkedHashMap2.keySet()) {
                        if (!linkedHashSet2.contains(num)) {
                            hashSet3.add(new Pair(Integer.valueOf(i11), Integer.valueOf(arrayList.size())));
                            arrayList.add((com.scores365.Design.PageObjects.b) linkedHashMap2.get(num));
                        }
                    }
                }
                i11++;
                i10 = 0;
            }
            for (Integer num2 : linkedHashMap.keySet()) {
                if (!linkedHashSet.contains(num2)) {
                    hashSet2.add(Integer.valueOf(this.f21313m.size()));
                    this.f21313m.add((ArrayList) linkedHashMap.get(num2));
                }
            }
            try {
                if (gameBetsObj.isBetLinesChanged()) {
                    getRvBaseAdapter().notifyDataSetChanged();
                    gameBetsObj.setBetLinesChanged(false);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    @Override // com.scores365.Design.Pages.e
    protected ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> F1() {
        try {
            if (this.f21314n.k1().i() == null) {
                this.f21314n.k1().q(this);
                this.f21313m = new ArrayList<>();
            } else {
                this.f21313m = this.f21314n.k1().k(this.f21315o, this, this.f21314n.C0());
            }
            this.f21314n.k1().r();
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.f21313m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.e, com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        ArrayList<com.scores365.Design.PageObjects.b> LoadData = super.LoadData();
        if (LoadData.size() > 0) {
            LoadData.add(0, new yc.r(p0.l0("SPONSORED_AD_BETTING")));
        }
        return LoadData;
    }

    @Override // ke.d.InterfaceC0402d
    public void M0(GameBetsObj gameBetsObj) {
        ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList;
        if (!isPageDataFetched()) {
            setPageDataFetched(true);
        }
        if (this.f21314n.k1().i() != null && (arrayList = this.f21313m) != null && !arrayList.isEmpty()) {
            P1(gameBetsObj);
            return;
        }
        try {
            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() { // from class: com.scores365.Pages.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.this.K1();
                    }
                });
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void OnScrollEvent(RecyclerView recyclerView, int i10, int i11, int i12, int i13) {
        super.OnScrollEvent(recyclerView, i10, i11, i12, i13);
        this.f21317q += i13;
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void handleUiForEmptyData() {
        super.handleUiForEmptyData();
        ImageView imageView = (ImageView) this.svEmptyLayout.findViewById(R.id.f22115kb);
        TextView textView = (TextView) this.svEmptyLayout.findViewById(R.id.Ey);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.width = p0.s(56);
        marginLayoutParams.height = p0.s(37);
        marginLayoutParams.setMargins(0, p0.s(100), 0, p0.s(16));
        imageView.setLayoutParams(marginLayoutParams);
        imageView.setImageDrawable(null);
        imageView.setBackgroundResource(R.drawable.f21847x0);
        textView.setTextSize(1, 16.0f);
        textView.setTextColor(p0.A(R.attr.f21565m1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void initRecyclerViewLayoutManager() {
        super.initRecyclerViewLayoutManager();
        RecyclerView.p pVar = this.rvLayoutMgr;
        if (pVar instanceof GridLayoutManager) {
            ((GridLayoutManager) pVar).C(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.a
    public boolean isContainedInCoordinatorLayout() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            i0 i0Var = this.f21314n;
            if (i0Var == null || i0Var.k1() == null) {
                return;
            }
            this.f21314n.k1().q(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onDataRendered() {
        super.onDataRendered();
        try {
            O1(false);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        try {
            int i11 = 0;
            int intValue = ((Integer) adapterView.getTag()).intValue() + 0;
            Iterator<com.scores365.Design.PageObjects.b> it = this.f21313m.get(intValue).iterator();
            int i12 = -1;
            while (it.hasNext()) {
                com.scores365.Design.PageObjects.b next = it.next();
                if (next instanceof ld.f) {
                    ld.f fVar = (ld.f) next;
                    if (fVar.l() == i10) {
                        return;
                    }
                    i12 = fVar.f34143b.values().iterator().next().get(0).type;
                    fVar.setSelectedIndex(i10);
                }
            }
            int i13 = 0;
            while (true) {
                if (i13 >= this.rvBaseAdapter.getItemCount()) {
                    i13 = -1;
                    break;
                } else if (this.f21313m.get(((Integer) adapterView.getTag()).intValue() + 0).get(0).equals(this.rvBaseAdapter.A(i13))) {
                    break;
                } else {
                    i13++;
                }
            }
            int i14 = 0;
            for (int size = this.f21313m.get(intValue).size() - 1; size > 0; size--) {
                com.scores365.Design.PageObjects.b bVar = this.f21313m.get(intValue).get(size);
                if ((bVar instanceof ld.d) || (bVar instanceof ld.i)) {
                    this.f21313m.get(((Integer) adapterView.getTag()).intValue() + 0).remove(bVar);
                    this.rvBaseAdapter.B().remove(bVar);
                    i14++;
                }
            }
            this.f21313m.get(((Integer) adapterView.getTag()).intValue() + 0).size();
            if (i12 != -1) {
                ArrayList<com.scores365.Design.PageObjects.b> m10 = this.f21314n.k1().m(i12, i10, this.f21314n.C0());
                int size2 = m10.size();
                this.f21313m.get(((Integer) adapterView.getTag()).intValue() + 0).addAll(m10);
                this.rvBaseAdapter.B().addAll(i13 + 2, m10);
                i11 = size2;
            }
            if (i11 != i14) {
                this.rvBaseAdapter.notifyDataSetChanged();
                return;
            }
            int i15 = i13 + 2;
            this.rvBaseAdapter.notifyItemRangeRemoved(i15, i11);
            this.rvBaseAdapter.notifyItemRangeInserted(i15, i11);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.GridSelector.GridSelectorEvents
    public void onMarketSelected(int i10) {
        if (this.f21315o == i10) {
            this.f21315o = -1;
        } else {
            this.f21315o = i10;
        }
        this.f21314n.k1().h(this.f21315o);
        Iterator<ArrayList<com.scores365.Design.PageObjects.b>> it = this.f21313m.iterator();
        int i11 = 1;
        while (it.hasNext()) {
            if (it.next().size() > 0) {
                i11++;
            }
        }
        while (this.f21313m.size() > i11) {
            this.f21313m.remove(i11);
        }
        this.f21313m.addAll(this.f21314n.k1().l(this, this.f21313m.size(), this.f21314n.C0()));
        this.f21316p.clear();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // com.scores365.Design.Pages.a
    public void onPageSelectedInViewPager() {
        super.onPageSelectedInViewPager();
        try {
            O1(true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        try {
            super.onPause();
            if (this.f21314n.k1() != null) {
                this.f21314n.k1().s();
                this.f21318r = true;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.e, com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        super.onRecyclerViewItemClick(i10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        try {
            super.onResume();
            if (this.f21318r && this.f21314n.k1() != null) {
                this.f21314n.k1().r();
                this.f21318r = false;
            }
            O1(false);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void relateCustomViews(View view) {
        super.relateCustomViews(view);
        this.rvItems.setPadding(0, 0, 0, p0.s(15));
        this.rvItems.setClipToPadding(false);
        this.svEmptyLayout = (NestedScrollView) view.findViewById(R.id.Er);
    }

    @Override // com.scores365.Design.Pages.q
    public <T extends Collection> void renderData(T t10) {
        if (t10 != null) {
            try {
                if (!t10.isEmpty() && !isListEmpty()) {
                    super.renderData(t10);
                    return;
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        String string = getArguments().getString("page_key", null);
        if (string != null && !string.isEmpty() && (!isPageDataFetched() || this.loadDataRetryCounter <= 10)) {
            getPageDataByKey(string);
        } else if (isPageDataFetched()) {
            handleEmptyData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.e
    public void y1(int i10) {
        super.y1(i10);
        try {
            M1(i10, "close", true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.e
    public void z1(int i10) {
        super.z1(i10);
        try {
            O1(false);
            M1(i10, "open", true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
