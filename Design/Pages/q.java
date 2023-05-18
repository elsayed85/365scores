package com.scores365.Design.Pages;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.appcompat.R;
import androidx.core.view.e1;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cc.o0;
import cc.s0;
import com.scores365.App;
import com.scores365.dashboard.a;
import com.scores365.gameCenter.GameCenterBaseActivity;
import com.scores365.gameCenter.p0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import li.x0;
/* compiled from: ListPage.java */
/* loaded from: classes2.dex */
public abstract class q extends y implements a.c {
    private static final int FALSE = 2;
    protected static final int RETRY_MAX_NUM = 10;
    private static final int TRUE = 1;
    private static final int UNSPECIFIED = -1;
    public static boolean isListInFling;
    protected p0 pageListScrolledListener;
    public e recylerItemClickListener;
    protected com.scores365.Design.Pages.c rvBaseAdapter;
    public RecyclerView rvItems;
    protected RecyclerView.p rvLayoutMgr;
    protected Bundle savedInstanceState;
    protected NestedScrollView svEmptyLayout;
    private long waitTime = 100;
    protected long loadDataRetryCounter = 0;
    private boolean isFirstRender = true;
    protected boolean shouldCheckForNativeInMidPage = false;
    protected f itemClickListener = null;
    protected View mainPreLoaderView = null;
    protected int handleListScrolledValue = -1;
    protected int generalNativeAdCounter = 0;
    protected GridLayoutManager.c spanSizeLookup = new c();

    /* compiled from: ListPage.java */
    /* loaded from: classes2.dex */
    class a extends RecyclerView.u {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.u
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i10) {
            p0 p0Var;
            try {
                super.onScrollStateChanged(recyclerView, i10);
                q.this.OnScrollStateChangedEvent(null, i10);
                if (i10 != 2) {
                    q.isListInFling = false;
                }
                if (i10 == 0 && q.this.isContainedInCoordinatorLayout()) {
                    RecyclerView.p pVar = q.this.rvLayoutMgr;
                    if (pVar instanceof LinearLayoutManager) {
                        int findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) pVar).findFirstCompletelyVisibleItemPosition();
                        int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) q.this.rvLayoutMgr).findLastCompletelyVisibleItemPosition();
                        if (findFirstCompletelyVisibleItemPosition != 0 || q.this.rvItems.getAdapter().getItemCount() - 1 == findLastCompletelyVisibleItemPosition) {
                            return;
                        }
                        q qVar = q.this;
                        if ((qVar instanceof com.scores365.Pages.f) || (p0Var = qVar.pageListScrolledListener) == null) {
                            return;
                        }
                        p0Var.showSubmenu();
                        if (q.this.getActivity() instanceof GameCenterBaseActivity) {
                            ((GameCenterBaseActivity) q.this.getActivity()).z2();
                        }
                    } else if (pVar instanceof StaggeredGridLayoutManager) {
                        int[] w10 = ((StaggeredGridLayoutManager) pVar).w(null);
                        int[] C = ((StaggeredGridLayoutManager) q.this.rvLayoutMgr).C(null);
                        for (int i11 = 0; i11 < w10.length; i11++) {
                            int i12 = w10[i11];
                            int i13 = C[i11];
                            if (i12 == 0 && q.this.rvItems.getAdapter().getItemCount() - 1 != i13) {
                                q qVar2 = q.this;
                                if (!(qVar2 instanceof com.scores365.Pages.f) && (qVar2.getActivity() instanceof GameCenterBaseActivity)) {
                                    ((GameCenterBaseActivity) q.this.getActivity()).z2();
                                    ((GameCenterBaseActivity) q.this.getActivity()).showSubmenu();
                                }
                            }
                        }
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.u
        public void onScrolled(@NonNull RecyclerView recyclerView, int i10, int i11) {
            try {
                super.onScrolled(recyclerView, i10, i11);
                int firstVisiblePositionFromLayoutMgr = q.this.getFirstVisiblePositionFromLayoutMgr();
                RecyclerView.p pVar = q.this.rvLayoutMgr;
                if (pVar != null) {
                    q.this.OnScrollEvent(recyclerView, firstVisiblePositionFromLayoutMgr, pVar.getChildCount(), q.this.rvLayoutMgr.getItemCount(), i11);
                }
                q.this.sendNativeAdImpressionForMoreThan50(firstVisiblePositionFromLayoutMgr);
                q qVar = q.this;
                qVar.sendNativeAdImpressionForMoreThan50(qVar.getLastVisibilePositionFromLayoutMgr());
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* compiled from: ListPage.java */
    /* loaded from: classes2.dex */
    class b extends RecyclerView.s {

        /* renamed from: a  reason: collision with root package name */
        private final double f20999a = sf.b.X1().S1() * 7;

        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean onFling(int i10, int i11) {
            if (i11 < 0) {
                i11 *= -1;
            }
            if (i11 > this.f20999a) {
                q.isListInFling = true;
                return false;
            }
            return false;
        }
    }

    /* compiled from: ListPage.java */
    /* loaded from: classes2.dex */
    class c extends GridLayoutManager.c {
        c() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i10) {
            try {
                int u10 = ((GridLayoutManager) q.this.rvLayoutMgr).u();
                com.scores365.Design.Pages.c cVar = q.this.rvBaseAdapter;
                if (cVar != null) {
                    int spanSize = cVar.A(i10).getSpanSize();
                    return u10 < spanSize ? u10 : spanSize;
                }
                return 1;
            } catch (Exception e10) {
                x0.N1(e10);
                return 1;
            }
        }
    }

    /* compiled from: ListPage.java */
    /* loaded from: classes2.dex */
    protected static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<q> f21002a;

        public d(q qVar) {
            this.f21002a = new WeakReference<>(qVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                q qVar = this.f21002a.get();
                if (qVar != null) {
                    q.access$130(qVar, 2L);
                    qVar.loadDataRetryCounter++;
                    qVar.LoadDataAsync();
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* compiled from: ListPage.java */
    /* loaded from: classes2.dex */
    public interface e {
        void OnRecylerItemClick(int i10);
    }

    /* compiled from: ListPage.java */
    /* loaded from: classes2.dex */
    public interface f {
        void a(int i10, com.scores365.Design.PageObjects.b bVar);
    }

    static /* synthetic */ long access$130(q qVar, long j10) {
        long j11 = qVar.waitTime * j10;
        qVar.waitTime = j11;
        return j11;
    }

    private void checkForNativeInMidPage(@NonNull Activity activity, @NonNull uc.d dVar) {
        int i10;
        int i11;
        s0.a aVar;
        s0 h10;
        try {
            RecyclerView.p pVar = this.rvLayoutMgr;
            if (pVar instanceof GridLayoutManager) {
                i10 = ((GridLayoutManager) pVar).findFirstVisibleItemPosition();
                i11 = ((GridLayoutManager) this.rvLayoutMgr).findLastVisibleItemPosition();
            } else if (pVar instanceof LinearLayoutManager) {
                i10 = ((LinearLayoutManager) pVar).findFirstVisibleItemPosition();
                i11 = ((LinearLayoutManager) this.rvLayoutMgr).findLastVisibleItemPosition();
            } else {
                i10 = -1;
                i11 = -1;
            }
            while (true) {
                i10++;
                if (i10 >= i11) {
                    return;
                }
                if ((getRvBaseAdapter().B().get(i10) instanceof com.scores365.dashboardEntities.dashboardScores.l) && (aVar = (s0.a) this.rvItems.a0(i10)) != null && (h10 = aVar.h()) != null && h10.I()) {
                    h10.w(activity, dVar, getAdScreenType());
                    return;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private String getPageKey() {
        try {
            if (getArguments() != null) {
                return getArguments().getString("page_key", null);
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$LoadDataAsync$0(ArrayList arrayList) {
        try {
            if (isDataReady(arrayList)) {
                HideMainPreloader();
            }
            renderData(arrayList);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$LoadDataAsync$1() {
        try {
            final ArrayList arrayList = (ArrayList) LoadData();
            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() { // from class: com.scores365.Design.Pages.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.this.lambda$LoadDataAsync$0(arrayList);
                    }
                });
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void relateMainPreLoader(View view) {
        this.mainPreLoaderView = view.findViewById(getPreloaderId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sendNativeAdImpressionForMoreThan50(int i10) {
        s0 h10;
        androidx.fragment.app.h activity;
        if (i10 > -1) {
            try {
                if (this.rvItems.a0(i10) == null || !(this.rvItems.a0(i10) instanceof t)) {
                    return false;
                }
                t tVar = (t) this.rvItems.a0(i10);
                if ((tVar instanceof s0.a) && (h10 = ((s0.a) tVar).h()) != null && h10.I()) {
                    View view = this.rvItems.a0(i10).itemView;
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    this.rvItems.a0(i10).itemView.getLocationOnScreen(iArr);
                    Rect rect = new Rect();
                    view.getGlobalVisibleRect(rect);
                    if (rect.height() / view.getHeight() >= 0.5d && (activity = getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && !isStateSaved()) {
                        h10.w(requireActivity(), ((App) activity.getApplication()).n(), getAdScreenType());
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }
        return false;
    }

    private boolean shouldHandleListScrolled() {
        try {
            if (this instanceof com.scores365.Pages.i) {
                this.handleListScrolledValue = 1;
            }
            if (this.handleListScrolledValue == -1) {
                RecyclerView.p pVar = this.rvLayoutMgr;
                if (pVar instanceof GridLayoutManager) {
                    if (((GridLayoutManager) pVar).findLastVisibleItemPosition() == this.rvItems.getAdapter().getItemCount() - 1 && ((GridLayoutManager) this.rvLayoutMgr).findFirstVisibleItemPosition() == 0) {
                        this.handleListScrolledValue = 2;
                    } else {
                        this.handleListScrolledValue = 1;
                    }
                } else if (pVar instanceof LinearLayoutManager) {
                    if (((LinearLayoutManager) pVar).findLastVisibleItemPosition() == this.rvItems.getAdapter().getItemCount() - 1 && ((LinearLayoutManager) this.rvLayoutMgr).findFirstVisibleItemPosition() == 0) {
                        this.handleListScrolledValue = 2;
                    } else {
                        this.handleListScrolledValue = 1;
                    }
                } else if (pVar instanceof StaggeredGridLayoutManager) {
                    this.handleListScrolledValue = 1;
                }
            }
            return this.handleListScrolledValue == 1;
        } catch (Exception e10) {
            x0.N1(e10);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showMainPreloaderTask */
    public void lambda$ShowMainPreloader$2(View view) {
        try {
            if (view.getVisibility() == 8) {
                view.startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f1221a));
            }
            view.setVisibility(0);
        } catch (Resources.NotFoundException e10) {
            x0.N1(e10);
        }
    }

    public void HideMainPreloader() {
        View view = this.mainPreLoaderView;
        if (view != null) {
            if (view.getVisibility() == 0) {
                this.mainPreLoaderView.startAnimation(AnimationUtils.loadAnimation(App.m(), com.scores365.R.anim.f21508h));
            }
            this.mainPreLoaderView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract <T> T LoadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void LoadDataAsync() {
        LoadDataAsync(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void LoadDataAsync(boolean z10) {
        if (z10) {
            try {
                ShowMainPreloader();
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        new Thread(new Runnable() { // from class: com.scores365.Design.Pages.p
            @Override // java.lang.Runnable
            public final void run() {
                q.this.lambda$LoadDataAsync$1();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void OnScrollEvent(RecyclerView recyclerView, int i10, int i11, int i12, int i13) {
        try {
            p0 p0Var = this.pageListScrolledListener;
            if (p0Var != null && p0Var.isNeedToHandleScroll(this) && shouldHandleListScrolled()) {
                this.pageListScrolledListener.onInnerPageListScrolled(i13);
            }
            androidx.fragment.app.h activity = getActivity();
            if (activity instanceof com.scores365.Design.Activities.g) {
                ((com.scores365.Design.Activities.g) activity).onPageScroll(i13);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void OnScrollStateChangedEvent(AbsListView absListView, int i10) {
    }

    public void ShowMainPreloader() {
        final View view = this.mainPreLoaderView;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            lambda$ShowMainPreloader$2(view);
            return;
        }
        Handler handler = view.getHandler();
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.scores365.Design.Pages.o
                @Override // java.lang.Runnable
                public final void run() {
                    q.this.lambda$ShowMainPreloader$2(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addGeneralNativeAdsForList(ArrayList<com.scores365.Design.PageObjects.b> arrayList, int i10) {
        com.scores365.Design.PageObjects.b nativeAdItem;
        try {
            if (o0.e() && shouldAddNativeAdsToListForSingleEntity()) {
                int s10 = o0.s(getAdScreenType());
                int r10 = o0.r(getAdScreenType()) + 1;
                int i11 = 0;
                while (i10 < arrayList.size()) {
                    if ((i10 == s10 || (i10 > 0 && i10 >= i11 && i11 % r10 == 0)) && (nativeAdItem = getNativeAdItem()) != null) {
                        arrayList.add(i10, nativeAdItem);
                        this.generalNativeAdCounter++;
                        i11 = 0;
                    }
                    i11++;
                    i10++;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public sc.f getAdScreenType() {
        sc.f fVar = sc.f.BigLayout;
        try {
            if ((getParentFragment() instanceof xe.q) && getParentFragment().getArguments().getBoolean("isSpecialSection", false)) {
                fVar = sc.f.SpecialSectionBig;
            } else if (getArguments().getBoolean("show_direct_deals_ads", false)) {
                fVar = sc.f.Branding;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getFirstCompletelyVisiblePositionFromLayoutMgr() {
        int i10 = -1;
        try {
            RecyclerView.p pVar = this.rvLayoutMgr;
            if (pVar instanceof LinearLayoutManager) {
                i10 = ((LinearLayoutManager) pVar).findFirstCompletelyVisibleItemPosition();
            } else if (pVar instanceof StaggeredGridLayoutManager) {
                i10 = ((StaggeredGridLayoutManager) pVar).w(null)[0];
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getFirstVisiblePositionFromLayoutMgr() {
        int i10 = 0;
        try {
            RecyclerView.p pVar = this.rvLayoutMgr;
            if (pVar instanceof LinearLayoutManager) {
                i10 = ((LinearLayoutManager) pVar).findFirstVisibleItemPosition();
            } else if (pVar instanceof StaggeredGridLayoutManager) {
                i10 = ((StaggeredGridLayoutManager) pVar).B(null)[0];
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return i10;
    }

    protected int getFragmentSpanSize() {
        return com.scores365.Design.Activities.c.fragmentSpanSize;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005e -> B:27:0x005f). Please submit an issue!!! */
    public int getLastVisibilePositionFromLayoutMgr() {
        int i10;
        RecyclerView.p pVar;
        int i11;
        int i12 = 0;
        try {
            com.scores365.Design.Pages.c cVar = this.rvBaseAdapter;
            i10 = cVar != null ? cVar.getItemCount() - 1 : 0;
        } catch (Exception e10) {
            e = e10;
            x0.N1(e);
            i10 = i12;
            return i10;
        }
        try {
            pVar = this.rvLayoutMgr;
        } catch (Exception e11) {
            int i13 = i10;
            e = e11;
            i12 = i13;
            x0.N1(e);
            i10 = i12;
            return i10;
        }
        if (!(pVar instanceof LinearLayoutManager)) {
            return pVar instanceof StaggeredGridLayoutManager ? ((StaggeredGridLayoutManager) pVar).E(null)[0] : i10;
        }
        i12 = ((LinearLayoutManager) pVar).findLastVisibleItemPosition();
        com.scores365.Design.Pages.c cVar2 = this.rvBaseAdapter;
        if (cVar2 != null && cVar2.B().size() - 1 == (i11 = i12 + 1)) {
            if (this.rvBaseAdapter.B().get(this.rvBaseAdapter.B().size() - 1) instanceof com.scores365.dashboardEntities.dashboardScores.d) {
                return i11;
            }
        }
        i10 = i12;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLayoutResourceID() {
        return com.scores365.R.layout.T;
    }

    protected com.scores365.Design.PageObjects.b getNativeAdItem() {
        androidx.fragment.app.h activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || isStateSaved()) {
            return null;
        }
        return new lf.d(((App) activity.getApplication()).n(), sc.i.Dashboard, sc.f.BigLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getPageDataByKey(String str) {
        try {
            setPageDataFetched(true);
            if (getPagesDataListener() != null) {
                getPagesDataListener().x0(str, this);
            }
            NestedScrollView nestedScrollView = this.svEmptyLayout;
            if (nestedScrollView != null) {
                nestedScrollView.setVisibility(8);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public int getPreloaderId() {
        return com.scores365.R.id.Jn;
    }

    protected int getRecyclerViewResourceID() {
        return com.scores365.R.id.Km;
    }

    public com.scores365.Design.Pages.c getRvBaseAdapter() {
        return this.rvBaseAdapter;
    }

    @Override // com.scores365.Design.Pages.z
    public int getSwipeRefreshResourceID() {
        return com.scores365.R.id.Hr;
    }

    @Override // com.scores365.Design.Pages.a
    public void handleContentPadding() {
        RecyclerView recyclerView;
        super.handleContentPadding();
        if (!hasContentPadding() || (recyclerView = this.rvItems) == null) {
            return;
        }
        recyclerView.setPadding(0, getPaddingSize(), 0, 0);
        this.rvItems.setClipToPadding(false);
        setRefreshLayoutPadding(getPaddingSize() - li.p0.s(45), getPaddingSize() + li.p0.s(25));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleEmptyData() {
        try {
            this.rvItems.setVisibility(8);
            handleUiForEmptyData();
            HideMainPreloader();
            onDataRendered();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleUiForEmptyData() {
        li.p0.r0(this.svEmptyLayout, getArguments() != null ? getArguments().getString("your_empty_msg") : "");
    }

    protected View inflateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(getLayoutResourceID(), viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initParams() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initRecyclerViewLayoutManager() {
        try {
            RtlGridLayoutManager rtlGridLayoutManager = new RtlGridLayoutManager(getActivity().getApplicationContext(), getFragmentSpanSize());
            this.rvLayoutMgr = rtlGridLayoutManager;
            rtlGridLayoutManager.setOrientation(1);
            if (x0.l1()) {
                ((RtlGridLayoutManager) this.rvLayoutMgr).E();
            }
            ((GridLayoutManager) this.rvLayoutMgr).C(this.spanSizeLookup);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends Collection> boolean isDataReady(T t10) {
        return (t10 == null || t10.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isListEmpty() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflateView = inflateView(layoutInflater, viewGroup, bundle);
        this.savedInstanceState = bundle;
        try {
            if (inflateView != null) {
                try {
                    View findViewById = inflateView.findViewById(com.scores365.R.id.Ap);
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
            initParams();
            relateListView(inflateView);
            initSwipeRefreshLayout(inflateView);
            relateMainPreLoader(inflateView);
            relateCustomViews(inflateView);
            handleContentPadding();
            if (!this.isClickBlocked) {
                this.recylerItemClickListener = new e() { // from class: com.scores365.Design.Pages.m
                    @Override // com.scores365.Design.Pages.q.e
                    public final void OnRecylerItemClick(int i10) {
                        q.this.onRecyclerViewItemClick(i10);
                    }
                };
            }
            RecyclerView recyclerView = this.rvItems;
            if (recyclerView != null) {
                recyclerView.l(new a());
                this.rvItems.setOnFlingListener(new b());
            }
            LoadDataAsync();
            if (this.isReversed) {
                inflateView.setRotationY(180.0f);
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
        return inflateView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDataRendered() {
        if (this.shouldCheckForNativeInMidPage) {
            try {
                androidx.fragment.app.h activity = getActivity();
                if (activity != null && !activity.isFinishing() && !activity.isDestroyed() && !isStateSaved()) {
                    checkForNativeInMidPage(activity, ((App) activity.getApplication()).n());
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.pageListScrolledListener = null;
    }

    @Override // com.scores365.dashboard.a.c
    public void onPageDataLoaded(Object obj) {
        if (obj == null) {
            try {
                if (this.loadDataRetryCounter < 10) {
                    new Handler().postDelayed(new d(this), this.waitTime);
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        updatePageData(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRecyclerViewItemClick(int i10) {
        try {
            f fVar = this.itemClickListener;
            if (fVar != null) {
                fVar.a(i10, this.rvBaseAdapter.A(i10));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void relateCustomViews(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void relateListView(View view) {
        try {
            this.rvItems = (RecyclerView) view.findViewById(getRecyclerViewResourceID());
            initRecyclerViewLayoutManager();
            this.rvItems.setLayoutManager(this.rvLayoutMgr);
            e1.I0(this.rvItems, x0.m0());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.y
    public void reloadData() {
        LoadData();
    }

    public <T extends Collection> void renderData(T t10) {
        if (t10 != null) {
            try {
                if (!t10.isEmpty() && !isListEmpty()) {
                    this.rvItems.setVisibility(0);
                    this.rvBaseAdapter = new com.scores365.Design.Pages.c((ArrayList) t10, this.recylerItemClickListener);
                    setListeners();
                    this.rvItems.setAdapter(this.rvBaseAdapter);
                    onDataRendered();
                    scrollToTop();
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        String pageKey = getPageKey();
        if (pageKey == null || pageKey.isEmpty() || (isPageDataFetched() && this.loadDataRetryCounter > 10)) {
            handleEmptyData();
        } else {
            getPageDataByKey(pageKey);
        }
        scrollToTop();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048 A[Catch: Exception -> 0x00a6, TryCatch #0 {Exception -> 0x00a6, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0013, B:8:0x0042, B:10:0x0048, B:12:0x0052, B:17:0x005b, B:19:0x0065, B:20:0x006e), top: B:25:0x0002 }] */
    @Override // com.scores365.Design.Pages.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void renderNativeAds() {
        /*
            r5 = this;
            java.lang.String r0 = "is_need_to_add_native_ad"
            android.os.Bundle r1 = r5.getArguments()     // Catch: java.lang.Exception -> La6
            if (r1 == 0) goto Laa
            android.os.Bundle r1 = r5.getArguments()     // Catch: java.lang.Exception -> La6
            r2 = 0
            boolean r1 = r1.getBoolean(r0, r2)     // Catch: java.lang.Exception -> La6
            if (r1 == 0) goto Laa
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La6
            r1.<init>()     // Catch: java.lang.Exception -> La6
            java.lang.Class r3 = r5.getClass()     // Catch: java.lang.Exception -> La6
            java.lang.String r3 = r3.getSimpleName()     // Catch: java.lang.Exception -> La6
            r1.append(r3)     // Catch: java.lang.Exception -> La6
            java.lang.String r3 = " Page - List Size Before: "
            r1.append(r3)     // Catch: java.lang.Exception -> La6
            com.scores365.Design.Pages.c r3 = r5.rvBaseAdapter     // Catch: java.lang.Exception -> La6
            int r3 = r3.getItemCount()     // Catch: java.lang.Exception -> La6
            r1.append(r3)     // Catch: java.lang.Exception -> La6
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> La6
            li.x0.Z1(r1)     // Catch: java.lang.Exception -> La6
            com.scores365.Design.Pages.c r1 = r5.rvBaseAdapter     // Catch: java.lang.Exception -> La6
            java.util.ArrayList r1 = r1.B()     // Catch: java.lang.Exception -> La6
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> La6
        L42:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Exception -> La6
            if (r3 == 0) goto L58
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Exception -> La6
            com.scores365.Design.PageObjects.b r3 = (com.scores365.Design.PageObjects.b) r3     // Catch: java.lang.Exception -> La6
            boolean r4 = r3 instanceof lf.d     // Catch: java.lang.Exception -> La6
            if (r4 != 0) goto L56
            boolean r3 = r3 instanceof lf.q     // Catch: java.lang.Exception -> La6
            if (r3 == 0) goto L42
        L56:
            r1 = 1
            goto L59
        L58:
            r1 = 0
        L59:
            if (r1 != 0) goto Laa
            android.os.Bundle r1 = r5.getArguments()     // Catch: java.lang.Exception -> La6
            boolean r0 = r1.getBoolean(r0, r2)     // Catch: java.lang.Exception -> La6
            if (r0 == 0) goto L6e
            com.scores365.Design.Pages.c r0 = r5.rvBaseAdapter     // Catch: java.lang.Exception -> La6
            java.util.ArrayList r0 = r0.B()     // Catch: java.lang.Exception -> La6
            r5.addGeneralNativeAdsForList(r0, r2)     // Catch: java.lang.Exception -> La6
        L6e:
            com.scores365.Design.Pages.c r0 = r5.rvBaseAdapter     // Catch: java.lang.Exception -> La6
            java.util.ArrayList r1 = r0.B()     // Catch: java.lang.Exception -> La6
            r0.H(r1)     // Catch: java.lang.Exception -> La6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La6
            r0.<init>()     // Catch: java.lang.Exception -> La6
            java.lang.Class r1 = r5.getClass()     // Catch: java.lang.Exception -> La6
            java.lang.String r1 = r1.getSimpleName()     // Catch: java.lang.Exception -> La6
            r0.append(r1)     // Catch: java.lang.Exception -> La6
            java.lang.String r1 = " Page - List Size After: "
            r0.append(r1)     // Catch: java.lang.Exception -> La6
            com.scores365.Design.Pages.c r1 = r5.rvBaseAdapter     // Catch: java.lang.Exception -> La6
            int r1 = r1.getItemCount()     // Catch: java.lang.Exception -> La6
            r0.append(r1)     // Catch: java.lang.Exception -> La6
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> La6
            li.x0.Z1(r0)     // Catch: java.lang.Exception -> La6
            com.scores365.Design.Pages.c r0 = r5.rvBaseAdapter     // Catch: java.lang.Exception -> La6
            int r1 = r0.getItemCount()     // Catch: java.lang.Exception -> La6
            r0.notifyItemRangeChanged(r2, r1)     // Catch: java.lang.Exception -> La6
            goto Laa
        La6:
            r0 = move-exception
            li.x0.N1(r0)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Design.Pages.q.renderNativeAds():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetHandleListScrolled() {
        this.handleListScrolledValue = -1;
    }

    public void scrollToListStartingPosition() {
        try {
            RecyclerView.p pVar = this.rvLayoutMgr;
            if (pVar instanceof LinearLayoutManager) {
                ((LinearLayoutManager) pVar).scrollToPositionWithOffset(0, 0);
                this.rvItems.t1(0, -1);
                this.rvItems.t1(0, 1);
            } else if (pVar instanceof StaggeredGridLayoutManager) {
                ((StaggeredGridLayoutManager) pVar).scrollToPositionWithOffset(0, 0);
                this.rvItems.t1(0, -1);
                this.rvItems.t1(0, 1);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void scrollToTop() {
        try {
            if (this.isFirstRender) {
                this.rvItems.p1(0);
                this.isFirstRender = false;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setClickBlocked(boolean z10) {
        this.isClickBlocked = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setListeners() {
    }

    public void setPageListScrolledListener(p0 p0Var) {
        this.pageListScrolledListener = p0Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldAddNativeAdsToListForSingleEntity() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof cc.e1) {
            return ((cc.e1) parentFragment).showAdsForContext();
        }
        androidx.fragment.app.h activity = getActivity();
        if (activity instanceof cc.e1) {
            return ((cc.e1) activity).showAdsForContext();
        }
        return false;
    }
}
