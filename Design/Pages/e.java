package com.scores365.Design.Pages;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import li.x0;
/* compiled from: ExpandableListPage.java */
/* loaded from: classes2.dex */
public abstract class e extends q {

    /* renamed from: l  reason: collision with root package name */
    protected ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> f20975l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExpandableListPage.java */
    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<e> f20976a;

        /* renamed from: b  reason: collision with root package name */
        private int f20977b;

        /* renamed from: c  reason: collision with root package name */
        private int f20978c;

        /* compiled from: ExpandableListPage.java */
        /* renamed from: com.scores365.Design.Pages.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0233a extends androidx.recyclerview.widget.m {
            C0233a(Context context) {
                super(context);
            }

            @Override // androidx.recyclerview.widget.m
            protected int getVerticalSnapPreference() {
                return 1;
            }
        }

        public a(e eVar, int i10, int i11) {
            this.f20976a = new WeakReference<>(eVar);
            this.f20977b = i10;
            this.f20978c = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e eVar = this.f20976a.get();
                if (eVar != null) {
                    int findLastVisibleItemPosition = ((LinearLayoutManager) eVar.rvItems.getLayoutManager()).findLastVisibleItemPosition();
                    int i10 = this.f20977b;
                    int i11 = this.f20978c;
                    int i12 = i10 + i11 >= findLastVisibleItemPosition ? i11 + i10 : i10;
                    if (i12 > i10) {
                        C0233a c0233a = new C0233a(App.m());
                        c0233a.setTargetPosition(i12);
                        eVar.rvLayoutMgr.startSmoothScroll(c0233a);
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public static ArrayList<com.scores365.Design.PageObjects.b> C1(ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList2 = new ArrayList<>();
        try {
            Iterator<ArrayList<com.scores365.Design.PageObjects.b>> it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<com.scores365.Design.PageObjects.b> next = it.next();
                if (next != null && !next.isEmpty()) {
                    if (!(next.get(0) instanceof k) || ((k) next.get(0)).isExpanded()) {
                        arrayList2.addAll(next);
                    } else {
                        arrayList2.add(next.get(0));
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A1(int i10, int i11) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int B1(int i10) {
        int i11 = -1;
        try {
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            for (int i12 = 0; i12 < this.f20975l.size(); i12++) {
                if (this.f20975l.get(i12) != null && this.f20975l.get(i12).size() > 0 && this.f20975l.get(i12).get(0).equals(A)) {
                    i11 = i12;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D1(int i10, ArrayList<com.scores365.Design.PageObjects.b> arrayList) {
        try {
            com.scores365.Design.PageObjects.b bVar = this.f20975l.get(i10).get(0);
            if (bVar instanceof k) {
                k kVar = (k) bVar;
                kVar.setExpanded(true);
                for (int i11 = 0; i11 < this.rvBaseAdapter.getItemCount(); i11++) {
                    if (this.rvBaseAdapter.A(i11).equals(kVar)) {
                        this.f20975l.get(i10).addAll(arrayList);
                        kVar.d(false);
                        kVar.setExpanded(true);
                        this.rvBaseAdapter.notifyItemChanged(i11);
                        x1(i11, arrayList, true);
                        return;
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected boolean E1() {
        return false;
    }

    protected abstract ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> F1();

    protected void G1(int i10, int i11) {
        if (i11 > 0) {
            try {
                int i12 = i10 + 1;
                this.rvBaseAdapter.notifyItemRangeRemoved(i12, i11);
                for (int i13 = i11 - 1; i13 >= 0; i13--) {
                    this.rvBaseAdapter.B().remove(i12 + i13);
                }
                this.rvBaseAdapter.I();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H1() {
        try {
            this.rvBaseAdapter.H(C1(this.f20975l));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> F1 = F1();
            this.f20975l = F1;
            return C1(F1);
        } catch (Exception e10) {
            e10.printStackTrace();
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        super.onRecyclerViewItemClick(i10);
        try {
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            if (A instanceof k) {
                k kVar = (k) A;
                int B1 = B1(i10);
                if (B1 == -1 || !kVar.e()) {
                    return;
                }
                boolean z10 = false;
                if (!kVar.isExpanded() && E1() && this.f20975l.get(B1).size() < 2) {
                    z10 = true;
                }
                if (z10) {
                    kVar.d(true);
                    this.rvBaseAdapter.notifyItemChanged(i10);
                    A1(B1, i10);
                } else if (kVar.isExpanded()) {
                    y1(i10);
                } else {
                    z1(i10);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    protected void x1(int i10, Collection<? extends com.scores365.Design.PageObjects.b> collection, boolean z10) {
        try {
            int i11 = i10 + 1;
            this.rvBaseAdapter.B().addAll(i11, collection);
            this.rvBaseAdapter.I();
            this.rvBaseAdapter.notifyItemRangeInserted(i11, collection.size());
            if (z10) {
                this.rvItems.postDelayed(new a(this, i10, collection.size()), 250L);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y1(int i10) {
        try {
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            if (A instanceof k) {
                k kVar = (k) A;
                Iterator<ArrayList<com.scores365.Design.PageObjects.b>> it = this.f20975l.iterator();
                while (it.hasNext()) {
                    ArrayList<com.scores365.Design.PageObjects.b> next = it.next();
                    if (next != null && next.size() > 1 && next.get(0).equals(kVar)) {
                        G1(i10, next.size() - 1);
                        kVar.setExpanded(false);
                        if (kVar.k()) {
                            RecyclerView.e0 a02 = this.rvItems.a0(i10);
                            if (a02 != null) {
                                kVar.f(a02);
                            } else {
                                this.rvBaseAdapter.notifyItemChanged(i10);
                            }
                        } else {
                            this.rvBaseAdapter.notifyItemChanged(i10);
                        }
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z1(int i10) {
        try {
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            if (A instanceof k) {
                k kVar = (k) A;
                Iterator<ArrayList<com.scores365.Design.PageObjects.b>> it = this.f20975l.iterator();
                while (it.hasNext()) {
                    ArrayList<com.scores365.Design.PageObjects.b> next = it.next();
                    if (next != null && next.size() > 0 && next.get(0).equals(kVar)) {
                        x1(i10, next.subList(1, next.size()), false);
                        kVar.setExpanded(true);
                        if (kVar.k()) {
                            RecyclerView.e0 a02 = this.rvItems.a0(i10);
                            if (a02 != null) {
                                kVar.a(a02);
                            } else {
                                this.rvBaseAdapter.notifyItemChanged(i10);
                            }
                        } else {
                            this.rvBaseAdapter.notifyItemChanged(i10);
                        }
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
