package com.scores365.dashboard.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Design.PageObjects.b;
import com.scores365.Design.Pages.q;
import com.scores365.entitys.AthleteObj;
import com.scores365.entitys.BaseObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.RelatedEntities;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.ui.playerCard.SinglePlayerCardActivity;
import gf.f;
import java.util.ArrayList;
import java.util.Iterator;
import li.d0;
import li.p0;
import li.x0;
import ze.m;
import ze.n;
/* compiled from: ViewAllPopularEntitiesFragment.java */
/* loaded from: classes2.dex */
public class a extends q {

    /* renamed from: o  reason: collision with root package name */
    public static String f23393o = "is_dirty";

    /* renamed from: p  reason: collision with root package name */
    public static String f23394p = "sportId";

    /* renamed from: q  reason: collision with root package name */
    public static String f23395q = "isFavouriteTag";

    /* renamed from: r  reason: collision with root package name */
    public static String f23396r = "entityCountTag";

    /* renamed from: l  reason: collision with root package name */
    boolean f23397l = false;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<BaseObj> f23398m = null;

    /* renamed from: n  reason: collision with root package name */
    private RelatedEntities f23399n = null;

    private void A1() {
        try {
            Iterator<b> it = getRvBaseAdapter().B().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                b next = it.next();
                if ((next instanceof m) && ((m) next).t() && ((m) next).u()) {
                    ((m) next).x(false);
                    getRvBaseAdapter().notifyItemChanged(i10);
                    return;
                }
                i10++;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private ArrayList<BaseObj> B1(int i10, ArrayList<BaseObj> arrayList) {
        ArrayList<BaseObj> arrayList2 = new ArrayList<>();
        try {
            Iterator<BaseObj> it = arrayList.iterator();
            while (it.hasNext()) {
                BaseObj next = it.next();
                if ((next instanceof CompetitionObj) && i10 == 2) {
                    arrayList2.add(next);
                } else if (((next instanceof AthleteObj) && i10 == 6) || ((next instanceof CompObj) && i10 == 6 && ((CompObj) next).shouldBeShownAsAthlete())) {
                    arrayList2.add(next);
                } else if ((next instanceof CompObj) && i10 == 3) {
                    arrayList2.add(next);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList2;
    }

    private n x1() {
        String str;
        int size;
        n nVar;
        n nVar2 = null;
        try {
            str = "";
            size = y1() ? this.f23398m.size() : getArguments().getInt(f23396r);
            int i10 = getArguments().getInt("dataTypeKey");
            if (i10 == 2) {
                str = p0.l0("NEW_DASHBAORD_COMPETITIONS");
            } else if (i10 == 3) {
                str = (y1() && getArguments().getInt(f23394p, -1) == SportTypesEnum.TENNIS.getValue()) ? p0.l0("NEW_DASHBOARD_PLAYERS") : p0.l0("NEW_DASHBAORD_TEAMS");
            } else if (i10 == 6) {
                str = p0.l0("NEW_DASHBOARD_PLAYERS");
            }
            nVar = new n(i10);
        } catch (Exception e10) {
            e = e10;
        }
        try {
            nVar.m(str.replace("#NUM", String.valueOf(size)));
            return nVar;
        } catch (Exception e11) {
            e = e11;
            nVar2 = nVar;
            x0.N1(e);
            return nVar2;
        }
    }

    private boolean y1() {
        return getArguments().getBoolean("isOnboardingContext");
    }

    public static a z1(int i10, ArrayList<BaseObj> arrayList, RelatedEntities relatedEntities, int i11, boolean z10, int i12, int i13, boolean z11, boolean z12, boolean z13, int i14, boolean z14) {
        a aVar = new a();
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("dataTypeKey", i10);
            bundle.putInt(f23394p, i11);
            bundle.putBoolean(f23395q, z10);
            bundle.putBoolean("isPopularContextTag", z11);
            bundle.putInt("locationTag", i13);
            bundle.putBoolean("", z12);
            bundle.putBoolean("is_lead_form", z13);
            bundle.putInt("lead_form_selected", i14);
            bundle.putBoolean("isOnboardingContext", z14);
            aVar.f23398m = arrayList;
            aVar.f23399n = relatedEntities;
            if (i12 == -1 && arrayList != null) {
                i12 = arrayList.size();
            }
            bundle.putInt(f23396r, i12);
            aVar.setArguments(bundle);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0100, code lost:
        if ((r9 instanceof com.scores365.entitys.AthleteObj) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010f, code lost:
        if (r7 == r15) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011a, code lost:
        if (r7 == r15) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0121, code lost:
        if (r3 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x012e, code lost:
        if (r3 == false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014e  */
    @Override // com.scores365.Design.Pages.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.dashboard.search.a.LoadData():java.util.ArrayList");
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        super.onRecyclerViewItemClick(i10);
        try {
            if (this.rvBaseAdapter.A(i10) instanceof m) {
                m mVar = (m) this.rvBaseAdapter.A(i10);
                if (getArguments().getBoolean("is_lead_form")) {
                    try {
                        A1();
                        mVar.r();
                        getRvBaseAdapter().notifyItemChanged(i10);
                        this.f23397l = true;
                        getActivity().getIntent().putExtra("is_lead_form", true);
                        getActivity().getIntent().putExtra("lead_form_selected", mVar.n().getID());
                        getActivity().getIntent().putExtra("team_object", mVar.n());
                        return;
                    } catch (Exception e10) {
                        x0.N1(e10);
                        return;
                    }
                }
                if (mVar.m() != m.b.checkbox && !y1()) {
                    d0.c(mVar.n());
                    Intent createSinglePlayerCardActivityIntent = ((mVar.n() instanceof AthleteObj) && x0.p1(((AthleteObj) mVar.n()).getSportTypeId())) ? SinglePlayerCardActivity.createSinglePlayerCardActivityIntent(((AthleteObj) mVar.n()).getID(), -1, false) : x0.u(mVar.n(), false, null, false, "");
                    if (createSinglePlayerCardActivityIntent != null) {
                        startActivity(createSinglePlayerCardActivityIntent);
                        return;
                    }
                    return;
                }
                mVar.w();
                mVar.p(this.rvItems.a0(i10), y1() ? false : true);
                this.f23397l = true;
                f.C1(mVar, getArguments().getInt("locationTag", -1), "main-search");
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            gf.a.b2(this.rvBaseAdapter, getArguments().getBoolean(f23395q, false));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void relateCustomViews(View view) {
        super.relateCustomViews(view);
        RecyclerView recyclerView = this.rvItems;
        recyclerView.setPadding(recyclerView.getPaddingLeft(), this.rvItems.getPaddingTop(), this.rvItems.getPaddingRight(), p0.s(8));
        this.rvItems.setClipToPadding(false);
    }
}
