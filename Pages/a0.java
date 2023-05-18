package com.scores365.Pages;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import cc.o0;
import com.facebook.appevents.AppEventsConstants;
import com.scores365.App;
import com.scores365.Design.Pages.RtlGridLayoutManager;
import com.scores365.branding.BrandingKey;
import com.scores365.branding.BrandingStripItem;
import com.scores365.entitys.AthleteObj;
import com.scores365.entitys.AthletesObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.ComparePageSquadItem;
import com.scores365.entitys.CountryObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.entitys.SquadInsertionItem;
import com.scores365.ui.WebViewActivity;
import com.scores365.ui.playerCard.SinglePlayerCardActivity;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import lf.j;
import li.x0;
/* compiled from: SquadPage.java */
/* loaded from: classes2.dex */
public class a0 extends com.scores365.Design.Pages.q {

    /* renamed from: l  reason: collision with root package name */
    private AthletesObj f21169l;

    /* renamed from: m  reason: collision with root package name */
    private int f21170m;

    /* renamed from: n  reason: collision with root package name */
    private String f21171n = "";

    /* renamed from: o  reason: collision with root package name */
    private boolean f21172o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f21173p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f21174q;

    /* renamed from: r  reason: collision with root package name */
    private int f21175r;

    /* compiled from: SquadPage.java */
    /* loaded from: classes2.dex */
    class a extends GridLayoutManager.c {
        a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i10) {
            try {
                int u10 = ((GridLayoutManager) ((com.scores365.Design.Pages.q) a0.this).rvLayoutMgr).u();
                int spanSize = ((com.scores365.Design.Pages.q) a0.this).rvBaseAdapter.A(i10).getSpanSize();
                return u10 < spanSize ? u10 : spanSize;
            } catch (Exception e10) {
                x0.N1(e10);
                return 1;
            }
        }
    }

    private CompObj A1(int i10) {
        try {
            AthletesObj athletesObj = this.f21169l;
            if (athletesObj == null || athletesObj.getCompetitorsById() == null || this.f21169l.getCompetitorsById().isEmpty() || !this.f21169l.getCompetitorsById().containsKey(Integer.valueOf(i10))) {
                return null;
            }
            return this.f21169l.getCompetitorsById().get(Integer.valueOf(i10));
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @NonNull
    public static a0 B1(AthletesObj athletesObj, String str, int i10, boolean z10, sc.i iVar, boolean z11, String str2, int i11) {
        a0 a0Var = new a0();
        try {
            a0Var.f21169l = athletesObj;
            a0Var.f21170m = i10;
            a0Var.f21171n = str;
            a0Var.placement = iVar;
            a0Var.f21173p = z10;
            a0Var.f21174q = z11;
            a0Var.f21175r = i11;
            Bundle bundle = new Bundle();
            bundle.putString("page_key", str2);
            a0Var.setArguments(bundle);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return a0Var;
    }

    private ComparePageSquadItem z1(int i10, int i11, SquadInsertionItem squadInsertionItem) {
        if (squadInsertionItem != null) {
            try {
                if (cc.a0.b() && !this.f21172o && i11 == squadInsertionItem.getCharecterPositionID() && squadInsertionItem.getLocation1First2Last() == i10) {
                    return new ComparePageSquadItem(squadInsertionItem);
                }
                return null;
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        LinkedHashMap<Integer, ArrayList<AthleteObj>> linkedHashMap;
        String str;
        String str2;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            if (this.f21169l != null) {
                CompObj A1 = A1(this.f21175r);
                if (this.f21173p || A1 == null) {
                    linkedHashMap = new LinkedHashMap<>();
                    linkedHashMap.put(0, new ArrayList<>());
                    for (AthleteObj athleteObj : this.f21169l.athleteById.values()) {
                        linkedHashMap.get(0).add(athleteObj);
                    }
                } else {
                    linkedHashMap = x0.u0(A1.getSportID(), this.f21169l.athleteById);
                }
                LinkedHashMap<Integer, ArrayList<AthleteObj>> linkedHashMap2 = linkedHashMap;
                SquadInsertionItem a10 = cc.a0.a();
                boolean z10 = false;
                for (Integer num : linkedHashMap2.keySet()) {
                    lf.p pVar = new lf.p(num.intValue(), x0.v0(num.intValue(), A1.getSportID()));
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<AthleteObj> it = linkedHashMap2.get(num).iterator();
                    while (it.hasNext()) {
                        AthleteObj next = it.next();
                        try {
                            if (this.f21169l.competitorsById.containsKey(Integer.valueOf(next.clubId))) {
                                String name = this.f21169l.competitorsById.get(Integer.valueOf(next.clubId)).getName();
                                this.f21169l.competitorsById.get(Integer.valueOf(next.clubId)).getID();
                                str = name;
                            } else {
                                str = "";
                            }
                            try {
                                CountryObj f02 = sf.a.i0(App.m()).f0(this.f21169l.competitorsById.get(Integer.valueOf(next.clubId)).getCountryID());
                                str2 = f02 != null ? f02.getName() : "";
                            } catch (Exception e10) {
                                x0.N1(e10);
                                str2 = "";
                            }
                            Hashtable<Integer, CountryObj> hashtable = this.f21169l.countryById;
                            arrayList2.add(new lf.j(next, this.f21173p, str, str2, (hashtable == null || !hashtable.containsKey(Integer.valueOf(next.nationality))) ? "" : this.f21169l.countryById.get(Integer.valueOf(next.nationality)).getName(), A1.isNational()));
                        } catch (Exception e11) {
                            x0.N1(e11);
                        }
                    }
                    if (!this.f21173p) {
                        arrayList.add(pVar);
                    }
                    if (!this.f21172o) {
                        ComparePageSquadItem z12 = z1(1, num.intValue(), a10);
                        if (z12 != null) {
                            arrayList2.add(0, z12);
                            this.f21172o = true;
                        } else {
                            ComparePageSquadItem z13 = z1(2, num.intValue(), a10);
                            if (z13 != null) {
                                arrayList2.add(z13);
                                this.f21172o = true;
                            }
                        }
                    }
                    if (!z10) {
                        if (o0.y() != null) {
                            fc.a y10 = o0.y();
                            BrandingKey brandingKey = BrandingKey.squadFirstItem;
                            if (y10.k(brandingKey) != null && !this.f21173p && o0.y().O(brandingKey, -1, this.f21169l.competitorsById.keySet().iterator().next().intValue(), -1, -1)) {
                                arrayList2.add(new BrandingStripItem(o0.y().k(brandingKey), brandingKey));
                            }
                        }
                        z10 = true;
                    }
                    arrayList.addAll(arrayList2);
                }
            }
        } catch (Exception e12) {
            x0.N1(e12);
        }
        return arrayList;
    }

    @Override // com.scores365.Design.Pages.q
    protected int getFragmentSpanSize() {
        return 1;
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return this.pageIconLink;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return this.f21171n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void initRecyclerViewLayoutManager() {
        try {
            RtlGridLayoutManager rtlGridLayoutManager = new RtlGridLayoutManager(getActivity().getApplicationContext(), getFragmentSpanSize());
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
            if (this.rvBaseAdapter.A(i10).getObjectTypeNum() != lf.u.Squad.ordinal()) {
                if (this.rvBaseAdapter.A(i10).getObjectTypeNum() == lf.u.compareSquadItem.ordinal()) {
                    ComparePageSquadItem comparePageSquadItem = (ComparePageSquadItem) this.rvBaseAdapter.A(i10);
                    if (comparePageSquadItem.itemToBind.isInAppBowser()) {
                        Intent intent = new Intent(App.m(), WebViewActivity.class);
                        intent.putExtra("url", comparePageSquadItem.itemToBind.getCharacterURL());
                        intent.addFlags(268435456);
                        App.m().startActivity(intent);
                    } else {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(comparePageSquadItem.itemToBind.getCharacterURL())));
                    }
                    ee.k.n(App.m(), "ad", "click", null, null, true, AppEventsConstants.EVENT_PARAM_AD_TYPE, "squad_insertion", "ad_screen", "PlayersList", "network", "SpecialExcutions");
                    return;
                }
                return;
            }
            lf.j jVar = (lf.j) this.rvBaseAdapter.A(i10);
            AthleteObj athleteObj = jVar.f34356a;
            if (jVar.f34362g == j.a.general) {
                if (athleteObj.position != 0 || athleteObj.getSportType() == SportTypesEnum.SOCCER) {
                    int id2 = this.f21173p ? this.f21169l.competitorsById.get(Integer.valueOf(athleteObj.clubId)).competitionObj.getID() : this.f21170m;
                    if (x0.p1(athleteObj.getSportTypeId())) {
                        getActivity().startActivity(SinglePlayerCardActivity.createSinglePlayerCardActivityIntent(athleteObj.getID(), id2, this.f21174q, "", "competitor_dashboard_squad"));
                    }
                    ee.k.o(getActivity().getApplicationContext(), "athlete", "click", null, null, "page", "squadsList", "athlete_id", String.valueOf(athleteObj.getID()));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void relateCustomViews(View view) {
    }

    @Override // com.scores365.Design.Pages.a
    public void updatePageData(Object obj) {
        try {
            super.updatePageData(obj);
            AthletesObj athletesObj = (AthletesObj) obj;
            this.f21169l = athletesObj;
            if (athletesObj != null) {
                try {
                    if (athletesObj.getCompetitionsById() != null && this.f21169l.getCompetitorsById() != null && this.f21169l.getCompetitorsById().containsKey(Integer.valueOf(this.f21175r))) {
                        this.f21170m = this.f21169l.getCompetitorsById().get(Integer.valueOf(this.f21175r)).getMainComp();
                    }
                } catch (Exception unused) {
                }
            }
            LoadDataAsync();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
