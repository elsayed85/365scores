package com.scores365.Pages;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.facebook.internal.AnalyticsEvents;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.R;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GamesObj;
import com.scores365.entitys.VideoObj;
import com.scores365.gameCenter.GameCenterBaseActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import li.p0;
import li.x0;
/* compiled from: HighlightPage.java */
/* loaded from: classes2.dex */
public class m extends com.scores365.Design.Pages.g {

    /* renamed from: l  reason: collision with root package name */
    private GamesObj f21274l;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<GameObj> f21275m;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<com.scores365.Design.PageObjects.b> f21276n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HighlightPage.java */
    /* loaded from: classes2.dex */
    public class a implements Comparator<GameObj> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(GameObj gameObj, GameObj gameObj2) {
            try {
                return gameObj2.getSTime().compareTo(gameObj.getSTime());
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HighlightPage.java */
    /* loaded from: classes2.dex */
    public class b implements Comparator<GameObj> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(GameObj gameObj, GameObj gameObj2) {
            try {
                return gameObj2.getSTime().compareTo(gameObj.getSTime());
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    private void A1(GamesObj gamesObj) {
        try {
            ArrayList arrayList = new ArrayList(gamesObj.getGames().values());
            Collections.sort(arrayList, new b());
            int size = this.f21276n.size();
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                this.f21276n.add(new lf.f((GameObj) arrayList.get(i10), 1));
                this.f21275m.add((GameObj) arrayList.get(i10));
            }
            addGeneralNativeAdsForList(this.f21276n, size);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private GamesObj B1(boolean z10) {
        com.scores365.api.i iVar;
        try {
            if (z10) {
                int i10 = 0;
                try {
                    String l02 = p0.l0("DAY_BACKWARD_NEWS_COMPLETION");
                    if (!l02.isEmpty()) {
                        i10 = Integer.parseInt(l02);
                    }
                } catch (Exception unused) {
                }
                iVar = new com.scores365.api.i("", x0.D0(this.filterObj.f34290b), x0.D0(this.filterObj.f34289a), x0.D0(this.filterObj.f34291c), x0.X(i10, "dd/MM/yyyy"), new Date(System.currentTimeMillis()), true);
            } else {
                iVar = new com.scores365.api.i();
                iVar.h(x0.D0(this.filterObj.f34289a), x0.D0(this.filterObj.f34290b), x0.D0(this.filterObj.f34291c), true);
                ArrayList<GameObj> arrayList = this.f21275m;
                iVar.d(arrayList.get(arrayList.size() - 1).getID());
            }
            iVar.call();
            return iVar.a();
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private int C1() {
        int i10 = -1;
        try {
            if (getFilterObj().f34290b != null && !getFilterObj().f34290b.isEmpty()) {
                i10 = getFilterObj().f34290b.iterator().next().intValue();
            } else if (getFilterObj().f34289a != null && !getFilterObj().f34289a.isEmpty()) {
                i10 = getFilterObj().f34289a.iterator().next().intValue();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return i10;
    }

    private int D1() {
        try {
            if (getFilterObj().f34290b == null || getFilterObj().f34290b.isEmpty()) {
                if (getFilterObj().f34289a != null) {
                    return !getFilterObj().f34289a.isEmpty() ? 2 : -1;
                }
                return -1;
            }
            return 1;
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E1(boolean z10, GamesObj gamesObj, boolean z11) {
        androidx.fragment.app.h activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || isStateSaved()) {
            return;
        }
        if (z10) {
            A1(gamesObj);
        }
        onLoadingItemsFinished(z11, false);
    }

    public static m F1(ArrayList<GameObj> arrayList, String str, lf.c cVar, String str2, q.f fVar, boolean z10, String str3, sc.i iVar, String str4) {
        m mVar = new m();
        try {
            mVar.setFilterObj(cVar);
            mVar.placement = iVar;
            mVar.pageTitle = str;
            mVar.pageIconLink = str2;
            mVar.itemClickListener = fVar;
            Collections.sort(arrayList, new a());
            mVar.f21275m = arrayList;
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_need_to_add_native_ad", z10);
            bundle.putString("your_empty_msg", str3);
            bundle.putString("page_key", str4);
            mVar.setArguments(bundle);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPreviousItems$1() {
        final boolean z10;
        final boolean z11 = false;
        final GamesObj B1 = B1(false);
        if (B1 != null && B1.getGames() != null) {
            z10 = true;
            if (B1.getGames().size() > 0) {
                z11 = true;
                li.c.f34483a.e().execute(new Runnable() { // from class: com.scores365.Pages.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.this.E1(z10, B1, z11);
                    }
                });
            }
            this.hasPrevItems = false;
            z11 = true;
        }
        z10 = false;
        li.c.f34483a.e().execute(new Runnable() { // from class: com.scores365.Pages.l
            @Override // java.lang.Runnable
            public final void run() {
                m.this.E1(z10, B1, z11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        try {
            this.f21276n = new ArrayList<>();
            Iterator<GameObj> it = this.f21275m.iterator();
            while (it.hasNext()) {
                GameObj next = it.next();
                this.f21276n.add(new lf.f(next, next.homeAwayTeamOrder));
            }
            if (getArguments().getBoolean("is_need_to_add_native_ad")) {
                addGeneralNativeAdsForList(this.f21276n, 0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.f21276n;
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
        li.c.f34483a.f().execute(new Runnable() { // from class: com.scores365.Pages.k
            @Override // java.lang.Runnable
            public final void run() {
                m.this.lambda$getPreviousItems$1();
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
        try {
            super.onRecyclerViewItemClick(i10);
            androidx.fragment.app.h activity = getActivity();
            if (activity == null) {
                return;
            }
            App app = (App) activity.getApplication();
            if (this.f21276n.get(i10) instanceof lf.f) {
                GameObj gameObj = ((lf.f) this.f21276n.get(i10)).f34317a;
                VideoObj videoObj = gameObj.getVideos()[0];
                Iterator<GameObj> it = this.f21275m.iterator();
                int i11 = 0;
                while (it.hasNext() && gameObj.getID() != it.next().getID()) {
                    i11++;
                }
                Intent v12 = GameCenterBaseActivity.v1(gameObj.getID(), gameObj.getCompetitionID(), bg.e.HIGHLIGHTS, "highlights");
                app.n().t(true);
                View findViewByPosition = this.rvLayoutMgr.findViewByPosition(i10);
                if (this.f21275m.get(i11).getVideos().length > 1) {
                    androidx.core.content.a.startActivity(getActivity(), v12, androidx.core.app.f.a(findViewByPosition, 0, 0, findViewByPosition.getWidth(), findViewByPosition.getHeight()).b());
                } else if (videoObj.isRequireDisclaimer()) {
                    p0.M0(App.m(), videoObj, videoObj.getThumbnail(), videoObj.getURL(), videoObj.getVideoIdForAnalytics(), gameObj.getID(), gameObj, "highlights");
                } else {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(videoObj.getURL())));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("entity_type", Integer.valueOf(D1()));
                hashMap.put("entity_id", Integer.valueOf(C1()));
                hashMap.put("video_id", videoObj.getVid());
                ee.k.k(getContext(), "dashboard", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "click", null, hashMap);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.y
    public void onRefreshFinished() {
        try {
            GamesObj gamesObj = this.f21274l;
            if (gamesObj == null || gamesObj.getGames() == null || this.f21274l.getGames().isEmpty()) {
                return;
            }
            this.f21276n.clear();
            this.f21275m.clear();
            A1(this.f21274l);
            this.hasPrevItems = true;
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
        try {
            this.f21274l = B1(true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.a
    public void updatePageData(Object obj) {
        try {
            super.updatePageData(obj);
            if (obj instanceof GamesObj) {
                for (GameObj gameObj : ((GamesObj) obj).getGames().values()) {
                    VideoObj[] videos = gameObj.getVideos();
                    if (videos != null && videos.length > 0) {
                        this.f21275m.add(gameObj);
                    }
                }
            } else {
                this.f21275m = (ArrayList) obj;
            }
            ArrayList<GameObj> arrayList = this.f21275m;
            if (arrayList == null || arrayList.isEmpty()) {
                new Handler().post(new q.d(this));
            }
            LoadDataAsync();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
