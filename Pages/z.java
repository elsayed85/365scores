package com.scores365.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.R;
import com.scores365.entitys.ItemObj;
import com.scores365.entitys.NewsObj;
import com.scores365.entitys.SourceObj;
import com.scores365.ui.WebViewActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import li.x0;
/* compiled from: SocialPage.java */
/* loaded from: classes2.dex */
public class z extends com.scores365.Design.Pages.g {

    /* renamed from: l  reason: collision with root package name */
    private NewsObj f21352l = null;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<ItemObj> f21353m;

    /* renamed from: n  reason: collision with root package name */
    private Hashtable<Integer, SourceObj> f21354n;

    /* renamed from: o  reason: collision with root package name */
    ArrayList<com.scores365.Design.PageObjects.b> f21355o;

    /* renamed from: p  reason: collision with root package name */
    private String f21356p;

    /* renamed from: q  reason: collision with root package name */
    private String f21357q;

    private void A1(NewsObj newsObj) {
        try {
            androidx.fragment.app.h activity = getActivity();
            if (activity == null) {
                return;
            }
            uc.d n10 = ((App) activity.getApplication()).n();
            ItemObj[] items = newsObj.getItems();
            for (SourceObj sourceObj : newsObj.getSources().values()) {
                this.f21354n.put(Integer.valueOf(sourceObj.getID()), sourceObj);
            }
            int size = this.f21355o.size();
            for (ItemObj itemObj : items) {
                this.f21353m.add(itemObj);
                this.f21355o.add(new lf.i(n10, itemObj, this.f21354n.get(Integer.valueOf(itemObj.getSourceID()))));
            }
            addGeneralNativeAdsForList(this.f21355o, size);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0087 A[Catch: Exception -> 0x00b2, TryCatch #1 {Exception -> 0x00b2, blocks: (B:9:0x0018, B:11:0x001e, B:13:0x0024, B:18:0x009d, B:14:0x0035, B:16:0x0087), top: B:26:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.scores365.entitys.NewsObj B1(boolean r21) {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r0 = "dd/MM/yyyy"
            r2 = 0
            java.lang.String r3 = "DAY_BACKWARD_NEWS_COMPLETION"
            java.lang.String r3 = li.p0.l0(r3)     // Catch: java.lang.Exception -> L16
            boolean r4 = r3.isEmpty()     // Catch: java.lang.Exception -> L16
            if (r4 != 0) goto L16
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.Exception -> L16
            goto L17
        L16:
            r3 = 0
        L17:
            r4 = 0
            java.lang.String r5 = r20.getLink(r21)     // Catch: java.lang.Exception -> Lb2
            if (r5 == 0) goto L35
            boolean r6 = r5.isEmpty()     // Catch: java.lang.Exception -> Lb2
            if (r6 != 0) goto L35
            com.scores365.api.l r0 = new com.scores365.api.l     // Catch: java.lang.Exception -> Lb2
            androidx.fragment.app.h r2 = r20.getActivity()     // Catch: java.lang.Exception -> Lb2
            android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Exception -> Lb2
            r0.<init>(r2)     // Catch: java.lang.Exception -> Lb2
            r0.c(r5)     // Catch: java.lang.Exception -> Lb2
            goto L9d
        L35:
            com.scores365.api.l r5 = new com.scores365.api.l     // Catch: java.lang.Exception -> Lb2
            androidx.fragment.app.h r6 = r20.getActivity()     // Catch: java.lang.Exception -> Lb2
            android.content.Context r7 = r6.getApplicationContext()     // Catch: java.lang.Exception -> Lb2
            java.lang.String r8 = "5"
            java.lang.String r9 = ""
            androidx.fragment.app.h r6 = r20.getActivity()     // Catch: java.lang.Exception -> Lb2
            android.content.Context r6 = r6.getApplicationContext()     // Catch: java.lang.Exception -> Lb2
            sf.a r6 = sf.a.i0(r6)     // Catch: java.lang.Exception -> Lb2
            int r10 = r6.G0()     // Catch: java.lang.Exception -> Lb2
            java.lang.String r11 = ""
            lf.c r6 = r1.filterObj     // Catch: java.lang.Exception -> Lb2
            java.util.HashSet<java.lang.Integer> r6 = r6.f34290b     // Catch: java.lang.Exception -> Lb2
            java.lang.String r12 = li.x0.D0(r6)     // Catch: java.lang.Exception -> Lb2
            lf.c r6 = r1.filterObj     // Catch: java.lang.Exception -> Lb2
            java.util.HashSet<java.lang.Integer> r6 = r6.f34289a     // Catch: java.lang.Exception -> Lb2
            java.lang.String r13 = li.x0.D0(r6)     // Catch: java.lang.Exception -> Lb2
            lf.c r6 = r1.filterObj     // Catch: java.lang.Exception -> Lb2
            java.util.HashSet<java.lang.Integer> r6 = r6.f34291c     // Catch: java.lang.Exception -> Lb2
            java.lang.String r14 = li.x0.D0(r6)     // Catch: java.lang.Exception -> Lb2
            lf.c r6 = r1.filterObj     // Catch: java.lang.Exception -> Lb2
            java.util.HashSet<java.lang.Integer> r6 = r6.f34292d     // Catch: java.lang.Exception -> Lb2
            java.lang.String r15 = li.x0.D0(r6)     // Catch: java.lang.Exception -> Lb2
            java.util.Date r16 = li.x0.X(r3, r0)     // Catch: java.lang.Exception -> Lb2
            java.util.Date r17 = li.x0.X(r2, r0)     // Catch: java.lang.Exception -> Lb2
            java.lang.String r18 = "60"
            java.lang.String r19 = "0"
            r6 = r5
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch: java.lang.Exception -> Lb2
            if (r21 != 0) goto L9c
            java.util.ArrayList<com.scores365.entitys.ItemObj> r0 = r1.f21353m     // Catch: java.lang.Exception -> Lb2
            int r2 = r0.size()     // Catch: java.lang.Exception -> Lb2
            int r2 = r2 + (-1)
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Exception -> Lb2
            com.scores365.entitys.ItemObj r0 = (com.scores365.entitys.ItemObj) r0     // Catch: java.lang.Exception -> Lb2
            int r0 = r0.getID()     // Catch: java.lang.Exception -> Lb2
            r5.b(r0)     // Catch: java.lang.Exception -> Lb2
        L9c:
            r0 = r5
        L9d:
            r0.d()     // Catch: java.lang.Exception -> Lb2
            r0.call()     // Catch: java.lang.Exception -> Lb2
            com.scores365.entitys.NewsObj r4 = r0.a()     // Catch: java.lang.Exception -> Lb2
            com.scores365.entitys.NewsObj$Paging r0 = r4.paging     // Catch: java.lang.Exception -> Lb2
            java.lang.String r2 = r0.nextPage     // Catch: java.lang.Exception -> Lb2
            r1.f21356p = r2     // Catch: java.lang.Exception -> Lb2
            java.lang.String r0 = r0.refreshPage     // Catch: java.lang.Exception -> Lb2
            r1.f21357q = r0     // Catch: java.lang.Exception -> Lb2
            goto Lb6
        Lb2:
            r0 = move-exception
            li.x0.N1(r0)
        Lb6:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Pages.z.B1(boolean):com.scores365.entitys.NewsObj");
    }

    public static z C1(String str, ArrayList<ItemObj> arrayList, Hashtable<Integer, SourceObj> hashtable, lf.c cVar, String str2, String str3, String str4, q.f fVar, boolean z10, String str5, sc.i iVar, String str6) {
        z zVar = new z();
        try {
            zVar.setFilterObj(cVar);
            zVar.f21353m = arrayList;
            zVar.f21354n = hashtable;
            zVar.pageTitle = str;
            zVar.pageIconLink = str2;
            zVar.f21357q = str3;
            zVar.f21356p = str4;
            zVar.itemClickListener = fVar;
            zVar.placement = iVar;
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_need_to_add_native_ad", z10);
            bundle.putString("your_empty_msg", str5);
            bundle.putString("page_key", str6);
            zVar.setArguments(bundle);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return zVar;
    }

    private String getLink(boolean z10) {
        String str;
        String str2 = null;
        try {
            if (z10) {
                String str3 = this.f21357q;
                if (str3 == null || str3.isEmpty()) {
                    return null;
                }
                str = this.f21357q;
            } else {
                String str4 = this.f21356p;
                if (str4 == null || str4.isEmpty()) {
                    return null;
                }
                str = this.f21356p;
            }
            str2 = str;
            return str2;
        } catch (Exception e10) {
            x0.N1(e10);
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPreviousItems$0(boolean z10, NewsObj newsObj, boolean z11) {
        androidx.fragment.app.h activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || isStateSaved()) {
            return;
        }
        if (z10) {
            A1(newsObj);
        }
        onLoadingItemsFinished(z11, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPreviousItems$1() {
        final boolean z10;
        final boolean z11 = false;
        final NewsObj B1 = B1(false);
        if (B1 != null && B1.getItems() != null) {
            z10 = true;
            if (B1.getItems().length > 0) {
                z11 = true;
                li.c.f34483a.e().execute(new Runnable() { // from class: com.scores365.Pages.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.this.lambda$getPreviousItems$0(z10, B1, z11);
                    }
                });
            }
            this.hasPrevItems = false;
            z11 = true;
        }
        z10 = false;
        li.c.f34483a.e().execute(new Runnable() { // from class: com.scores365.Pages.y
            @Override // java.lang.Runnable
            public final void run() {
                z.this.lambda$getPreviousItems$0(z10, B1, z11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        androidx.fragment.app.h activity;
        try {
            this.f21355o = new ArrayList<>();
            activity = getActivity();
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (activity == null) {
            return this.f21355o;
        }
        uc.d n10 = ((App) activity.getApplication()).n();
        Iterator<ItemObj> it = this.f21353m.iterator();
        while (it.hasNext()) {
            ItemObj next = it.next();
            this.f21355o.add(new lf.i(n10, next, this.f21354n.get(Integer.valueOf(next.getSourceID()))));
        }
        if (getArguments().getBoolean("is_need_to_add_native_ad")) {
            addGeneralNativeAdsForList(this.f21355o, 0);
        }
        return this.f21355o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public sc.f getAdScreenType() {
        return sc.f.BigLayout;
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return this.pageIconLink;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return this.pageTitle;
    }

    @Override // com.scores365.Design.Pages.g
    protected void getPreviousItems() {
        li.c.f34483a.f().execute(new Runnable() { // from class: com.scores365.Pages.x
            @Override // java.lang.Runnable
            public final void run() {
                z.this.lambda$getPreviousItems$1();
            }
        });
    }

    @Override // com.scores365.Design.Pages.g
    protected boolean hasNextItems() {
        return false;
    }

    @Override // com.scores365.Design.Pages.g
    protected boolean hasPreviousItems() {
        return this.hasPrevItems;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void initRecyclerViewLayoutManager() {
        try {
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(com.scores365.Design.Activities.c.fragmentSpanSize, 1);
            this.rvLayoutMgr = staggeredGridLayoutManager;
            staggeredGridLayoutManager.setOrientation(1);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.y
    public boolean isSwipeEnabled() {
        return this.isRefreshEnabled;
    }

    @Override // com.scores365.Design.Pages.g
    public void lockPageDataRefresh() {
        super.lockPageDataRefresh();
        this.hasPrevItems = false;
        this.isRefreshEnabled = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        super.onRecyclerViewItemClick(i10);
        try {
            if (this.f21355o.get(i10) instanceof lf.i) {
                lf.i iVar = (lf.i) this.f21355o.get(i10);
                Iterator<ItemObj> it = this.f21353m.iterator();
                int i11 = 0;
                while (it.hasNext() && iVar.o().getID() != it.next().getID()) {
                    i11++;
                }
                Intent intent = new Intent(getActivity().getApplicationContext(), WebViewActivity.class);
                intent.putExtra(ItemObj.class.getName(), this.f21353m.get(i11));
                intent.putExtra("page_title", this.f21353m.get(i11).getTitle());
                View findViewByPosition = this.rvLayoutMgr.findViewByPosition(i10);
                androidx.core.content.a.startActivity(getActivity(), intent, androidx.core.app.f.a(findViewByPosition, 0, 0, findViewByPosition.getWidth(), findViewByPosition.getHeight()).b());
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.y
    public void onRefreshFinished() {
        try {
            NewsObj newsObj = this.f21352l;
            if (newsObj == null || newsObj.getItems() == null || this.f21352l.getItems().length <= 0) {
                return;
            }
            this.f21354n.clear();
            this.f21355o.clear();
            this.f21353m.clear();
            A1(this.f21352l);
            this.hasPrevItems = true;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void relateCustomViews(View view) {
        this.svEmptyLayout = (NestedScrollView) view.findViewById(R.id.Er);
    }

    @Override // com.scores365.Design.Pages.q, com.scores365.Design.Pages.y
    public void reloadData() {
        this.f21352l = B1(true);
    }

    @Override // com.scores365.Design.Pages.a
    public void updatePageData(Object obj) {
        try {
            super.updatePageData(obj);
            NewsObj newsObj = (NewsObj) obj;
            this.f21353m = new ArrayList<>(Arrays.asList(newsObj.getItems()));
            if (newsObj.getSources() != null) {
                for (SourceObj sourceObj : newsObj.getSources().values()) {
                    this.f21354n.put(Integer.valueOf(sourceObj.getID()), sourceObj);
                }
            }
            this.f21356p = newsObj.getNextPage();
            this.f21357q = newsObj.getRefreshPage();
            LoadDataAsync();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
