package com.scores365.Pages;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.scores365.Design.Pages.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import li.x0;
/* compiled from: ExpandableRecyclerViewPage.java */
/* loaded from: classes2.dex */
public abstract class i extends com.scores365.Design.Pages.q implements RecyclerViewExpandableItemManager.b, RecyclerViewExpandableItemManager.c, q.e {

    /* renamed from: l  reason: collision with root package name */
    protected HashMap<Integer, Boolean> f21265l = new HashMap<>();

    /* renamed from: m  reason: collision with root package name */
    protected RecyclerView.h f21266m;

    /* renamed from: n  reason: collision with root package name */
    protected RecyclerView.h f21267n;

    /* renamed from: o  reason: collision with root package name */
    protected RecyclerViewExpandableItemManager f21268o;

    public static ArrayList<com.scores365.Design.PageObjects.b> x1(ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList2 = new ArrayList<>();
        try {
            ArrayList<com.scores365.Design.PageObjects.b> arrayList3 = new ArrayList<>();
            try {
                Iterator<ArrayList<com.scores365.Design.PageObjects.b>> it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList3.addAll(it.next());
                }
                return arrayList3;
            } catch (Exception e10) {
                e = e10;
                arrayList2 = arrayList3;
                x0.N1(e);
                return arrayList2;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public <T> T LoadData() {
        return null;
    }

    @Override // com.scores365.Design.Pages.q.e
    public void OnRecylerItemClick(int i10) {
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager.c
    public void S(int i10, boolean z10, Object obj) {
        try {
            z1(z10, i10);
            if (((a) this.f21267n).C(i10) instanceof pb.b) {
                pb.b bVar = (pb.b) ((a) this.f21267n).C(i10);
                bVar.n();
                if (z10) {
                    bVar.o(true, i10);
                }
                this.f21265l.put(Integer.valueOf(i10 - 1), Boolean.TRUE);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return null;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager.b
    public void h1(int i10, boolean z10, Object obj) {
        try {
            y1(z10, i10);
            if (((a) this.f21267n).C(i10) instanceof pb.b) {
                pb.b bVar = (pb.b) ((a) this.f21267n).C(i10);
                bVar.m();
                if (z10) {
                    bVar.o(false, i10);
                }
                this.f21265l.put(Integer.valueOf(i10 - 1), Boolean.FALSE);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.q
    public <T extends Collection> void renderData(T t10) {
        if (t10 != null) {
            try {
                if (!t10.isEmpty()) {
                    Bundle bundle = this.savedInstanceState;
                    Parcelable parcelable = bundle != null ? bundle.getParcelable("RecyclerViewExpandableItemManager") : null;
                    RecyclerViewExpandableItemManager recyclerViewExpandableItemManager = new RecyclerViewExpandableItemManager(parcelable);
                    this.f21268o = recyclerViewExpandableItemManager;
                    recyclerViewExpandableItemManager.k(this);
                    this.f21268o.j(this);
                    a aVar = new a((ArrayList) t10, this.recylerItemClickListener);
                    this.f21267n = aVar;
                    this.f21266m = this.f21268o.b(aVar);
                    wa.c cVar = new wa.c();
                    cVar.V(false);
                    this.rvItems.setAdapter(this.f21266m);
                    this.rvItems.setItemAnimator(cVar);
                    this.rvItems.setHasFixedSize(false);
                    this.f21268o.a(this.rvItems);
                    if (parcelable == null) {
                        ((a) this.f21267n).B(this.f21268o);
                        return;
                    }
                    return;
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        ShowMainPreloader();
        String string = getArguments().getString("page_key");
        if (string == null || string.isEmpty() || isPageDataFetched()) {
            return;
        }
        setPageDataFetched(true);
        if (getPagesDataListener() != null) {
            getPagesDataListener().x0(string, this);
        }
    }

    public void y1(boolean z10, int i10) {
    }

    public void z1(boolean z10, int i10) {
    }
}
