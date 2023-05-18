package com.scores365.Pages;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cc.o0;
import com.facebook.appevents.AppEventsConstants;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.NewsCenter.NewsCenterActivity;
import com.scores365.R;
import com.scores365.dashboard.AllNewsActivity;
import com.scores365.dashboard.MainDashboardActivity;
import com.scores365.dashboard.singleEntity.SingleEntityDashboardActivity;
import com.scores365.entitys.ImageDetailObj;
import com.scores365.entitys.ItemObj;
import com.scores365.entitys.NewsObj;
import com.scores365.entitys.NewsVideoObj;
import com.scores365.entitys.SourceObj;
import com.scores365.ui.WebViewActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import li.i0;
import li.p0;
import li.x0;
import nf.c;
/* compiled from: NewsPage.java */
/* loaded from: classes2.dex */
public class r extends com.scores365.Design.Pages.g implements wh.b {

    /* renamed from: l  reason: collision with root package name */
    private NewsObj f21298l;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<ItemObj> f21299m;

    /* renamed from: n  reason: collision with root package name */
    private Hashtable<Integer, SourceObj> f21300n;

    /* renamed from: o  reason: collision with root package name */
    private ArrayList<com.scores365.Design.PageObjects.b> f21301o;

    /* renamed from: p  reason: collision with root package name */
    private String f21302p;

    /* renamed from: q  reason: collision with root package name */
    private String f21303q;

    /* renamed from: r  reason: collision with root package name */
    private String f21304r;

    /* renamed from: s  reason: collision with root package name */
    private String f21305s;

    /* renamed from: t  reason: collision with root package name */
    boolean f21306t = false;

    private void A1(NewsObj newsObj) {
        try {
            ItemObj[] items = newsObj.getItems();
            for (SourceObj sourceObj : newsObj.getSources().values()) {
                this.f21300n.put(Integer.valueOf(sourceObj.getID()), sourceObj);
            }
            int size = this.f21301o.size();
            for (int i10 = 0; i10 < items.length; i10++) {
                if (items[i10].getType() == 9) {
                    ArrayList<com.scores365.Design.PageObjects.b> arrayList = this.f21301o;
                    ItemObj itemObj = items[i10];
                    arrayList.add(new nf.a(itemObj, this.f21300n.get(Integer.valueOf(itemObj.getSourceID())), true));
                } else {
                    ArrayList<ImageDetailObj> arrayList2 = items[i10].imagesList;
                    if (arrayList2 != null && arrayList2.size() > 0 && p0.k(items[i10].imagesList.get(0).width)) {
                        ArrayList<com.scores365.Design.PageObjects.b> arrayList3 = this.f21301o;
                        ItemObj itemObj2 = items[i10];
                        arrayList3.add(new nf.a(itemObj2, this.f21300n.get(Integer.valueOf(itemObj2.getSourceID())), false));
                    } else if (x0.l1()) {
                        ArrayList<com.scores365.Design.PageObjects.b> arrayList4 = this.f21301o;
                        ItemObj itemObj3 = items[i10];
                        arrayList4.add(new nf.e(itemObj3, this.f21300n.get(Integer.valueOf(itemObj3.getSourceID()))));
                    } else {
                        ArrayList<com.scores365.Design.PageObjects.b> arrayList5 = this.f21301o;
                        ItemObj itemObj4 = items[i10];
                        arrayList5.add(new nf.d(itemObj4, this.f21300n.get(Integer.valueOf(itemObj4.getSourceID()))));
                    }
                }
                this.f21299m.add(items[i10]);
            }
            if (getArguments().getBoolean("is_need_to_add_native_ad", false) || getArguments().getBoolean("show_direct_deals_ads", false)) {
                addGeneralNativeAdsForList(this.f21301o, size);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static r B1(ArrayList<ItemObj> arrayList, Hashtable<Integer, SourceObj> hashtable, String str, lf.c cVar, String str2, String str3, String str4, String str5, q.f fVar, String str6, boolean z10, sc.i iVar, boolean z11, String str7, boolean z12) {
        r rVar = new r();
        try {
            rVar.setFilterObj(cVar);
            rVar.placement = iVar;
            rVar.f21300n = hashtable;
            rVar.f21299m = arrayList;
            rVar.f21303q = str;
            rVar.f21302p = str2;
            rVar.pageIconLink = str3;
            rVar.f21305s = str5;
            rVar.f21304r = str4;
            rVar.itemClickListener = fVar;
            Bundle bundle = new Bundle();
            bundle.putString("your_empty_msg", str6);
            bundle.putBoolean("is_need_to_add_native_ad", z10);
            bundle.putBoolean("game_center_score_tag", z11);
            bundle.putString("page_key", str7);
            bundle.putBoolean("show_direct_deals_ads", z12);
            rVar.setArguments(bundle);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return rVar;
    }

    private String C1() {
        try {
            return (o0.y().C("STICKY_VIDEO_NEWS_ENABLED") == null || !Boolean.valueOf(o0.y().C("STICKY_VIDEO_NEWS_ENABLED")).booleanValue()) ? "0" : sf.b.X1().v4() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "0";
        } catch (Exception e10) {
            x0.N1(e10);
            return "0";
        }
    }

    public static void D1(nf.c cVar, Fragment fragment) {
        try {
            Intent intent = new Intent(App.m(), WebViewActivity.class);
            intent.putExtra(ItemObj.class.getName(), cVar.f35470a);
            intent.setFlags(268435456);
            intent.putExtra("page_title", cVar.f35470a.getTitle());
            fragment.startActivity(intent);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private String getLink(boolean z10) {
        String str;
        String str2 = null;
        try {
            if (z10) {
                String str3 = this.f21305s;
                if (str3 == null || str3.isEmpty()) {
                    return null;
                }
                str = this.f21305s;
            } else {
                String str4 = this.f21304r;
                if (str4 == null || str4.isEmpty()) {
                    return null;
                }
                str = this.f21304r;
            }
            str2 = str;
            return str2;
        } catch (Exception e10) {
            x0.N1(e10);
            return str2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0064 A[Catch: Exception -> 0x00d2, TryCatch #1 {Exception -> 0x00d2, blocks: (B:9:0x0018, B:11:0x001e, B:13:0x0024, B:40:0x00c4, B:14:0x003a, B:16:0x0064, B:18:0x0068, B:20:0x0070, B:22:0x0074, B:24:0x007c, B:26:0x0080, B:28:0x0088, B:30:0x008c, B:32:0x00a2, B:34:0x00a6, B:36:0x00ac, B:38:0x00c0), top: B:48:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070 A[Catch: Exception -> 0x00d2, TryCatch #1 {Exception -> 0x00d2, blocks: (B:9:0x0018, B:11:0x001e, B:13:0x0024, B:40:0x00c4, B:14:0x003a, B:16:0x0064, B:18:0x0068, B:20:0x0070, B:22:0x0074, B:24:0x007c, B:26:0x0080, B:28:0x0088, B:30:0x008c, B:32:0x00a2, B:34:0x00a6, B:36:0x00ac, B:38:0x00c0), top: B:48:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c A[Catch: Exception -> 0x00d2, TryCatch #1 {Exception -> 0x00d2, blocks: (B:9:0x0018, B:11:0x001e, B:13:0x0024, B:40:0x00c4, B:14:0x003a, B:16:0x0064, B:18:0x0068, B:20:0x0070, B:22:0x0074, B:24:0x007c, B:26:0x0080, B:28:0x0088, B:30:0x008c, B:32:0x00a2, B:34:0x00a6, B:36:0x00ac, B:38:0x00c0), top: B:48:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0088 A[Catch: Exception -> 0x00d2, TryCatch #1 {Exception -> 0x00d2, blocks: (B:9:0x0018, B:11:0x001e, B:13:0x0024, B:40:0x00c4, B:14:0x003a, B:16:0x0064, B:18:0x0068, B:20:0x0070, B:22:0x0074, B:24:0x007c, B:26:0x0080, B:28:0x0088, B:30:0x008c, B:32:0x00a2, B:34:0x00a6, B:36:0x00ac, B:38:0x00c0), top: B:48:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a2 A[Catch: Exception -> 0x00d2, TryCatch #1 {Exception -> 0x00d2, blocks: (B:9:0x0018, B:11:0x001e, B:13:0x0024, B:40:0x00c4, B:14:0x003a, B:16:0x0064, B:18:0x0068, B:20:0x0070, B:22:0x0074, B:24:0x007c, B:26:0x0080, B:28:0x0088, B:30:0x008c, B:32:0x00a2, B:34:0x00a6, B:36:0x00ac, B:38:0x00c0), top: B:48:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.scores365.entitys.NewsObj getNewsFromServer(boolean r21) {
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
            java.lang.String r5 = r20.getLink(r21)     // Catch: java.lang.Exception -> Ld2
            if (r5 == 0) goto L3a
            boolean r6 = r5.isEmpty()     // Catch: java.lang.Exception -> Ld2
            if (r6 != 0) goto L3a
            com.scores365.api.l r0 = new com.scores365.api.l     // Catch: java.lang.Exception -> Ld2
            androidx.fragment.app.h r2 = r20.getActivity()     // Catch: java.lang.Exception -> Ld2
            android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Exception -> Ld2
            android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Exception -> Ld2
            r0.<init>(r2)     // Catch: java.lang.Exception -> Ld2
            r0.c(r5)     // Catch: java.lang.Exception -> Ld2
            goto Lc4
        L3a:
            com.scores365.api.l r5 = new com.scores365.api.l     // Catch: java.lang.Exception -> Ld2
            androidx.fragment.app.h r6 = r20.getActivity()     // Catch: java.lang.Exception -> Ld2
            android.content.Context r7 = r6.getApplicationContext()     // Catch: java.lang.Exception -> Ld2
            java.lang.String r8 = r1.f21302p     // Catch: java.lang.Exception -> Ld2
            sf.b r6 = sf.b.X1()     // Catch: java.lang.Exception -> Ld2
            java.lang.String r9 = r6.s2()     // Catch: java.lang.Exception -> Ld2
            androidx.fragment.app.h r6 = r20.getActivity()     // Catch: java.lang.Exception -> Ld2
            android.content.Context r6 = r6.getApplicationContext()     // Catch: java.lang.Exception -> Ld2
            sf.a r6 = sf.a.i0(r6)     // Catch: java.lang.Exception -> Ld2
            int r10 = r6.G0()     // Catch: java.lang.Exception -> Ld2
            java.lang.String r11 = ""
            lf.c r6 = r1.filterObj     // Catch: java.lang.Exception -> Ld2
            if (r6 == 0) goto L67
            java.util.HashSet<java.lang.Integer> r6 = r6.f34290b     // Catch: java.lang.Exception -> Ld2
            goto L68
        L67:
            r6 = r4
        L68:
            java.lang.String r12 = li.x0.D0(r6)     // Catch: java.lang.Exception -> Ld2
            lf.c r6 = r1.filterObj     // Catch: java.lang.Exception -> Ld2
            if (r6 == 0) goto L73
            java.util.HashSet<java.lang.Integer> r6 = r6.f34289a     // Catch: java.lang.Exception -> Ld2
            goto L74
        L73:
            r6 = r4
        L74:
            java.lang.String r13 = li.x0.D0(r6)     // Catch: java.lang.Exception -> Ld2
            lf.c r6 = r1.filterObj     // Catch: java.lang.Exception -> Ld2
            if (r6 == 0) goto L7f
            java.util.HashSet<java.lang.Integer> r6 = r6.f34291c     // Catch: java.lang.Exception -> Ld2
            goto L80
        L7f:
            r6 = r4
        L80:
            java.lang.String r14 = li.x0.D0(r6)     // Catch: java.lang.Exception -> Ld2
            lf.c r6 = r1.filterObj     // Catch: java.lang.Exception -> Ld2
            if (r6 == 0) goto L8b
            java.util.HashSet<java.lang.Integer> r6 = r6.f34292d     // Catch: java.lang.Exception -> Ld2
            goto L8c
        L8b:
            r6 = r4
        L8c:
            java.lang.String r15 = li.x0.D0(r6)     // Catch: java.lang.Exception -> Ld2
            java.util.Date r16 = li.x0.X(r3, r0)     // Catch: java.lang.Exception -> Ld2
            java.util.Date r17 = li.x0.X(r2, r0)     // Catch: java.lang.Exception -> Ld2
            java.lang.String r18 = "60"
            java.lang.String r19 = "0"
            r6 = r5
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch: java.lang.Exception -> Ld2
            if (r21 != 0) goto Lc3
            java.util.ArrayList<com.scores365.entitys.ItemObj> r0 = r1.f21299m     // Catch: java.lang.Exception -> Ld2
            if (r0 == 0) goto Lbf
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> Ld2
            if (r0 != 0) goto Lbf
            java.util.ArrayList<com.scores365.entitys.ItemObj> r0 = r1.f21299m     // Catch: java.lang.Exception -> Ld2
            int r2 = r0.size()     // Catch: java.lang.Exception -> Ld2
            int r2 = r2 + (-1)
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Exception -> Ld2
            com.scores365.entitys.ItemObj r0 = (com.scores365.entitys.ItemObj) r0     // Catch: java.lang.Exception -> Ld2
            int r0 = r0.getID()     // Catch: java.lang.Exception -> Ld2
            goto Lc0
        Lbf:
            r0 = -1
        Lc0:
            r5.b(r0)     // Catch: java.lang.Exception -> Ld2
        Lc3:
            r0 = r5
        Lc4:
            r0.call()     // Catch: java.lang.Exception -> Ld2
            com.scores365.entitys.NewsObj r4 = r0.a()     // Catch: java.lang.Exception -> Ld2
            com.scores365.entitys.NewsObj$Paging r0 = r4.paging     // Catch: java.lang.Exception -> Ld2
            java.lang.String r0 = r0.nextPage     // Catch: java.lang.Exception -> Ld2
            r1.f21304r = r0     // Catch: java.lang.Exception -> Ld2
            goto Ld6
        Ld2:
            r0 = move-exception
            li.x0.N1(r0)
        Ld6:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Pages.r.getNewsFromServer(boolean):com.scores365.entitys.NewsObj");
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
        final NewsObj newsFromServer = getNewsFromServer(false);
        if (newsFromServer != null && newsFromServer.getItems() != null) {
            z10 = true;
            if (newsFromServer.getItems().length > 0) {
                z11 = true;
                li.c.f34483a.e().execute(new Runnable() { // from class: com.scores365.Pages.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.this.lambda$getPreviousItems$0(z10, newsFromServer, z11);
                    }
                });
            }
            this.hasPrevItems = false;
            z11 = true;
        }
        z10 = false;
        li.c.f34483a.e().execute(new Runnable() { // from class: com.scores365.Pages.q
            @Override // java.lang.Runnable
            public final void run() {
                r.this.lambda$getPreviousItems$0(z10, newsFromServer, z11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        try {
            this.f21301o = new ArrayList<>();
            if (getArguments().getString("page_key", "").equals("monetization_train")) {
                NewsObj newsFromServer = getNewsFromServer(true);
                this.f21299m = new ArrayList<>(Arrays.asList(newsFromServer.getItems()));
                Hashtable<Integer, SourceObj> hashtable = new Hashtable<>();
                this.f21300n = hashtable;
                hashtable.putAll(newsFromServer.getSources());
            }
            ArrayList<ItemObj> arrayList = this.f21299m;
            if (arrayList != null) {
                Iterator<ItemObj> it = arrayList.iterator();
                while (it.hasNext()) {
                    ItemObj next = it.next();
                    this.f21301o.add(next.getListItem(this.f21300n.get(Integer.valueOf(next.getSourceID())), -1));
                }
            }
            if (getArguments().getBoolean("is_need_to_add_native_ad", false) || getArguments().getBoolean("show_direct_deals_ads", false) || (getParentFragment() != null && getParentFragment().getArguments().getBoolean("isSpecialSection", false))) {
                addGeneralNativeAdsForList(this.f21301o, 0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.f21301o;
    }

    @Override // wh.b
    public void finishLoading() {
        HideMainPreloader();
    }

    @Override // wh.b
    public Activity getActivityForUI() {
        return getActivity();
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return this.pageIconLink;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return this.f21303q;
    }

    @Override // com.scores365.Design.Pages.g
    protected void getPreviousItems() {
        li.c.f34483a.f().execute(new Runnable() { // from class: com.scores365.Pages.p
            @Override // java.lang.Runnable
            public final void run() {
                r.this.lambda$getPreviousItems$1();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.a
    public boolean isContainedInCoordinatorLayout() {
        return true;
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

    @Override // com.scores365.Design.Pages.q, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        String str;
        String str2;
        String string;
        super.onRecyclerViewItemClick(i10);
        try {
            androidx.fragment.app.h activity = getActivity();
            if (activity == null) {
                return;
            }
            App app = (App) activity.getApplication();
            if (this.rvBaseAdapter.A(i10) instanceof nf.c) {
                nf.c cVar = (nf.c) this.rvBaseAdapter.A(i10);
                if (cVar.p()) {
                    ItemObj itemObj = cVar.f35470a;
                    if (!itemObj.skipDetails) {
                        NewsVideoObj newsVideoObj = itemObj.newsVideos.get(0);
                        p0.M0(activity, null, newsVideoObj.thumbnailUrl, newsVideoObj.url, newsVideoObj.vId, 0L, null, "news");
                        return;
                    }
                    app.n().t(true);
                    String url = cVar.f35470a.getURL();
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                } else if (cVar.f35483n == c.b.share) {
                    cVar.f35483n = c.b.general;
                    i0.a(this, app.n(), this, cVar.f35470a, cVar.f35471b, cVar instanceof nf.a ? false : true, false);
                    x0.f2(String.valueOf(cVar.f35470a.getID()), "dashboard", "news-item", "2", AppEventsConstants.EVENT_PARAM_VALUE_YES, null);
                } else {
                    Iterator<ItemObj> it = this.f21299m.iterator();
                    int i11 = 0;
                    while (it.hasNext() && cVar.f35470a.getID() != it.next().getID()) {
                        i11++;
                    }
                    if (cVar.getObjectTypeNum() != 9) {
                        if (App.f20803w) {
                            D1(cVar, this);
                        } else if (cVar.f35470a.skipDetails) {
                            D1(cVar, this);
                        } else {
                            NewsCenterActivity.Y1(getActivity(), this.f21299m, i11, false, false);
                        }
                    }
                    if (!(getActivity() instanceof MainDashboardActivity) && !(getActivity() instanceof SingleEntityDashboardActivity)) {
                        str = getActivity() instanceof AllNewsActivity ? "all-news" : "";
                        boolean z10 = cVar.f35470a.getContentUrl() == null && !cVar.f35470a.getContentUrl().isEmpty();
                        str2 = "news";
                        string = getArguments().getString("page_key", null);
                        if (string != null && string.equalsIgnoreCase("Magazine")) {
                            str2 = "magazine";
                        }
                        ee.k.o(activity, "news-item", "preview", "click", null, "type", str2, "news_item_id", String.valueOf(cVar.f35470a.getID()), "page", str, "is_related", "0", "related_to", "", "is_swipe", "0", "game_id", "", "section", "feed", "sticky_video", C1(), "is_rich_article", String.valueOf(z10));
                    }
                    str = "dashboard-news";
                    if (cVar.f35470a.getContentUrl() == null) {
                    }
                    str2 = "news";
                    string = getArguments().getString("page_key", null);
                    if (string != null) {
                        str2 = "magazine";
                    }
                    ee.k.o(activity, "news-item", "preview", "click", null, "type", str2, "news_item_id", String.valueOf(cVar.f35470a.getID()), "page", str, "is_related", "0", "related_to", "", "is_swipe", "0", "game_id", "", "section", "feed", "sticky_video", C1(), "is_rich_article", String.valueOf(z10));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.y
    public void onRefreshFinished() {
        try {
            NewsObj newsObj = this.f21298l;
            if (newsObj == null || newsObj.getItems() == null || this.f21298l.getItems().length <= 0) {
                return;
            }
            this.f21300n.clear();
            this.f21301o.clear();
            this.f21299m.clear();
            A1(this.f21298l);
            this.hasPrevItems = true;
            this.rvBaseAdapter.H(this.f21301o);
            this.rvBaseAdapter.notifyDataSetChanged();
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
        this.f21298l = getNewsFromServer(true);
    }

    @Override // wh.b
    public void startLoading() {
        ShowMainPreloader();
    }

    public void updateData(NewsObj newsObj) {
        try {
            if (getArguments().getBoolean(f.IS_FIRST_UPDATE_RENDERED, true)) {
                this.f21302p = newsObj.newsType;
                NewsObj.Paging paging = newsObj.paging;
                this.f21304r = paging.nextPage;
                this.f21305s = paging.refreshPage;
                this.f21299m = new ArrayList<>(Arrays.asList(newsObj.getItems()));
                for (SourceObj sourceObj : newsObj.getSources().values()) {
                    this.f21300n.put(Integer.valueOf(sourceObj.getID()), sourceObj);
                }
                ArrayList<com.scores365.Design.PageObjects.b> LoadData = LoadData();
                if (LoadData != null && !LoadData.isEmpty()) {
                    this.svEmptyLayout.setVisibility(8);
                }
                HideMainPreloader();
                com.scores365.Design.Pages.c cVar = this.rvBaseAdapter;
                if (cVar != null) {
                    cVar.H(LoadData);
                    this.rvBaseAdapter.notifyDataSetChanged();
                } else {
                    renderData(LoadData);
                }
                this.rvItems.t1(0, 1);
                this.rvItems.t1(0, -1);
                getArguments().putBoolean(f.IS_FIRST_UPDATE_RENDERED, false);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.a
    public void updatePageData(Object obj) {
        super.updatePageData(obj);
        try {
            if (this.f21306t) {
                return;
            }
            this.f21306t = true;
            if (obj == null) {
                handleEmptyData();
                return;
            }
            NewsObj newsObj = (NewsObj) obj;
            this.f21299m = new ArrayList<>(Arrays.asList(newsObj.getItems()));
            if (newsObj.getSources() != null) {
                if (this.f21300n == null) {
                    this.f21300n = new Hashtable<>();
                }
                for (SourceObj sourceObj : newsObj.getSources().values()) {
                    this.f21300n.put(Integer.valueOf(sourceObj.getID()), sourceObj);
                }
            }
            this.f21302p = newsObj.getNewsType();
            this.f21304r = newsObj.getNextPage();
            this.f21305s = newsObj.getRefreshPage();
            LoadDataAsync();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
