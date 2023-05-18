package com.scores365.Design.Pages;

import android.content.Context;
import android.os.Handler;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import li.x0;
/* compiled from: ExpandableFeedUpdatesPage.kt */
/* loaded from: classes2.dex */
public abstract class d extends g {

    /* renamed from: r  reason: collision with root package name */
    public static final a f20961r = new a(null);

    /* renamed from: l  reason: collision with root package name */
    private Handler f20962l;

    /* renamed from: m  reason: collision with root package name */
    private a.C0232a f20963m;

    /* renamed from: n  reason: collision with root package name */
    private Timer f20964n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f20965o;

    /* renamed from: p  reason: collision with root package name */
    private final Object f20966p = new Object();

    /* renamed from: q  reason: collision with root package name */
    private ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> f20967q;

    /* compiled from: ExpandableFeedUpdatesPage.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: protected */
        /* compiled from: ExpandableFeedUpdatesPage.kt */
        /* renamed from: com.scores365.Design.Pages.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0232a extends TimerTask {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<Handler> f20968a;

            /* renamed from: b  reason: collision with root package name */
            private final WeakReference<d> f20969b;

            public C0232a(d page, Handler handler) {
                kotlin.jvm.internal.m.g(page, "page");
                this.f20969b = new WeakReference<>(page);
                this.f20968a = new WeakReference<>(handler);
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                d dVar;
                Handler handler;
                try {
                    WeakReference<d> weakReference = this.f20969b;
                    if (weakReference == null || (dVar = weakReference.get()) == null || dVar.f20965o) {
                        return;
                    }
                    boolean z10 = true;
                    dVar.f20965o = true;
                    synchronized (dVar.f20966p) {
                        try {
                            String fullUpdateUrlPath = dVar.getFullUpdateUrlPath();
                            if (fullUpdateUrlPath != null) {
                                if (fullUpdateUrlPath.length() != 0) {
                                    z10 = false;
                                }
                                if (!z10) {
                                    ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> updateDataListItems = dVar.getUpdateDataListItems(x0.R(fullUpdateUrlPath));
                                    WeakReference<Handler> weakReference2 = this.f20968a;
                                    if (weakReference2 != null && (handler = weakReference2.get()) != null) {
                                        handler.post(new b(dVar, updateDataListItems));
                                    }
                                }
                            }
                        } catch (Exception e10) {
                            x0.N1(e10);
                        }
                        Unit unit = Unit.f33377a;
                    }
                    dVar.f20965o = false;
                } catch (Exception e11) {
                    x0.N1(e11);
                }
            }
        }

        /* compiled from: ExpandableFeedUpdatesPage.kt */
        /* loaded from: classes2.dex */
        protected static final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<d> f20970a;

            /* renamed from: b  reason: collision with root package name */
            private final ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> f20971b;

            public b(d page, ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList) {
                kotlin.jvm.internal.m.g(page, "page");
                this.f20970a = new WeakReference<>(page);
                this.f20971b = arrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                WeakReference<d> weakReference;
                d dVar;
                try {
                    ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList = this.f20971b;
                    if (arrayList == null || arrayList.size() <= 0 || (weakReference = this.f20970a) == null || (dVar = weakReference.get()) == null) {
                        return;
                    }
                    dVar.I1(this.f20971b, false);
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExpandableFeedUpdatesPage.kt */
    /* loaded from: classes2.dex */
    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<d> f20972a;

        /* renamed from: b  reason: collision with root package name */
        private final int f20973b;

        /* renamed from: c  reason: collision with root package name */
        private final int f20974c;

        /* compiled from: ExpandableFeedUpdatesPage.kt */
        /* loaded from: classes2.dex */
        public static final class a extends androidx.recyclerview.widget.m {
            a(Context context) {
                super(context);
            }

            @Override // androidx.recyclerview.widget.m
            protected int getVerticalSnapPreference() {
                return 1;
            }
        }

        public b(d page, int i10, int i11) {
            kotlin.jvm.internal.m.g(page, "page");
            this.f20972a = new WeakReference<>(page);
            this.f20973b = i10;
            this.f20974c = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d dVar = this.f20972a.get();
                if (dVar != null) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) dVar.rvItems.getLayoutManager();
                    kotlin.jvm.internal.m.d(linearLayoutManager);
                    int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    int i10 = this.f20973b;
                    int i11 = this.f20974c;
                    int i12 = i10 + i11 >= findLastVisibleItemPosition ? i11 + i10 : i10;
                    if (i12 > i10) {
                        a aVar = new a(App.m());
                        aVar.setTargetPosition(i12);
                        dVar.rvLayoutMgr.startSmoothScroll(aVar);
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    private final void clearUpdater(boolean z10) {
        try {
            this.f20965o = false;
            Timer timer = this.f20964n;
            if (timer != null) {
                timer.cancel();
            }
            Timer timer2 = this.f20964n;
            if (timer2 != null) {
                timer2.purge();
            }
            this.f20964n = null;
        } catch (Exception e10) {
            x0.N1(e10);
        }
        try {
            a.C0232a c0232a = this.f20963m;
            if (c0232a != null) {
                c0232a.cancel();
            }
            this.f20963m = null;
        } catch (Exception e11) {
            x0.N1(e11);
        }
        try {
            Handler handler = this.f20962l;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (z10) {
                this.f20962l = null;
            }
        } catch (Exception e12) {
            x0.N1(e12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        if ((r0.length() == 0) == false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040 A[Catch: Exception -> 0x004a, TRY_LEAVE, TryCatch #0 {Exception -> 0x004a, blocks: (B:2:0x0000, B:5:0x0012, B:19:0x0040, B:11:0x001f, B:16:0x0029), top: B:25:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getFullUpdateUrlPath() {
        /*
            r5 = this;
            java.lang.String r0 = r5.getBaseUrlPath()     // Catch: java.lang.Exception -> L4a
            java.lang.String r1 = r5.getUpdateUrl()     // Catch: java.lang.Exception -> L4a
            boolean r2 = r5.useBaseUrlPath()     // Catch: java.lang.Exception -> L4a
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1d
            if (r0 == 0) goto L3d
            int r2 = r0.length()     // Catch: java.lang.Exception -> L4a
            if (r2 != 0) goto L1a
            r2 = 1
            goto L1b
        L1a:
            r2 = 0
        L1b:
            if (r2 != 0) goto L3d
        L1d:
            if (r1 == 0) goto L3d
            int r2 = r1.length()     // Catch: java.lang.Exception -> L4a
            if (r2 != 0) goto L26
            goto L27
        L26:
            r3 = 0
        L27:
            if (r3 != 0) goto L3d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L4a
            r2.<init>()     // Catch: java.lang.Exception -> L4a
            r2.append(r0)     // Catch: java.lang.Exception -> L4a
            r2.append(r1)     // Catch: java.lang.Exception -> L4a
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Exception -> L4a
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch: java.lang.Exception -> L4a
            goto L3e
        L3d:
            r0 = 0
        L3e:
            if (r0 == 0) goto L4e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L4a
            java.lang.String r1 = "uri.toString()"
            kotlin.jvm.internal.m.f(r0, r1)     // Catch: java.lang.Exception -> L4a
            goto L50
        L4a:
            r0 = move-exception
            li.x0.N1(r0)
        L4e:
            java.lang.String r0 = ""
        L50:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Design.Pages.d.getFullUpdateUrlPath():java.lang.String");
    }

    protected final void C1(int i10, Collection<? extends com.scores365.Design.PageObjects.b> itemsToAdd, boolean z10) {
        kotlin.jvm.internal.m.g(itemsToAdd, "itemsToAdd");
        try {
            int i11 = i10 + 1;
            this.rvBaseAdapter.B().addAll(i11, itemsToAdd);
            this.rvBaseAdapter.I();
            this.rvBaseAdapter.notifyItemRangeInserted(i11, itemsToAdd.size());
            if (z10) {
                this.rvItems.postDelayed(new b(this, i10, itemsToAdd.size()), 250L);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D1(int i10) {
        try {
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            if (A instanceof k) {
                k kVar = (k) A;
                ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList = this.f20967q;
                kotlin.jvm.internal.m.d(arrayList);
                Iterator<ArrayList<com.scores365.Design.PageObjects.b>> it = arrayList.iterator();
                while (it.hasNext()) {
                    ArrayList<com.scores365.Design.PageObjects.b> next = it.next();
                    if (next != null && next.size() > 1 && kotlin.jvm.internal.m.b(next.get(0), kVar)) {
                        L1(i10, next.size() - 1);
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
    public void E1(int i10) {
        try {
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            if (A instanceof k) {
                k kVar = (k) A;
                ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList = this.f20967q;
                kotlin.jvm.internal.m.d(arrayList);
                Iterator<ArrayList<com.scores365.Design.PageObjects.b>> it = arrayList.iterator();
                while (it.hasNext()) {
                    ArrayList<com.scores365.Design.PageObjects.b> next = it.next();
                    if (next != null && next.size() > 0 && kotlin.jvm.internal.m.b(next.get(0), kVar)) {
                        List<com.scores365.Design.PageObjects.b> subList = next.subList(1, next.size());
                        kotlin.jvm.internal.m.f(subList, "group.subList(1, group.size)");
                        C1(i10, subList, false);
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

    protected final void F1(int i10, int i11) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> G1() {
        return this.f20967q;
    }

    protected final int H1(int i10) {
        int i11 = -1;
        try {
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList = this.f20967q;
            kotlin.jvm.internal.m.d(arrayList);
            int size = arrayList.size();
            for (int i12 = 0; i12 < size; i12++) {
                ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList2 = this.f20967q;
                kotlin.jvm.internal.m.d(arrayList2);
                if (kotlin.jvm.internal.m.b(arrayList2.get(i12).get(0), A)) {
                    i11 = i12;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return i11;
    }

    protected abstract void I1(ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList, boolean z10);

    protected final boolean J1() {
        return false;
    }

    protected abstract ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> K1();

    protected final void L1(int i10, int i11) {
        if (i11 > 0) {
            for (int i12 = i11 - 1; -1 < i12; i12--) {
                try {
                    this.rvBaseAdapter.B().remove(i10 + 1 + i12);
                } catch (Exception e10) {
                    x0.N1(e10);
                    return;
                }
            }
            this.rvBaseAdapter.I();
            this.rvBaseAdapter.notifyItemRangeRemoved(i10 + 1, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public <T> T LoadData() {
        T t10 = (T) new ArrayList();
        try {
            ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> K1 = K1();
            this.f20967q = K1;
            T t11 = (T) e.C1(K1);
            kotlin.jvm.internal.m.f(t11, "groupDataToItemList(groupData)");
            return t11;
        } catch (Exception e10) {
            e10.printStackTrace();
            return t10;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void M1(ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList) {
        this.f20967q = arrayList;
    }

    protected abstract String getBaseUrlPath();

    protected abstract ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> getUpdateDataListItems(String str);

    protected abstract String getUpdateUrl();

    protected long getUpdatesStartDelay() {
        return 0L;
    }

    protected abstract long getUpdatesTimeInterval();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onDataRendered() {
        super.onDataRendered();
        startUpdater();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        clearUpdater(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        super.onRecyclerViewItemClick(i10);
        try {
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            if (A instanceof k) {
                k kVar = (k) A;
                int H1 = H1(i10);
                if (H1 == -1 || !kVar.e()) {
                    return;
                }
                boolean z10 = false;
                if (!kVar.isExpanded() && J1()) {
                    ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList = this.f20967q;
                    kotlin.jvm.internal.m.d(arrayList);
                    if (arrayList.get(H1).size() < 2) {
                        z10 = true;
                    }
                }
                if (z10) {
                    kVar.d(true);
                    this.rvBaseAdapter.notifyItemChanged(i10);
                    F1(H1, i10);
                } else if (kVar.isExpanded()) {
                    D1(i10);
                } else {
                    E1(i10);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        try {
            super.onResume();
            if (requireArguments().getBoolean("shouldUpdaterStartFromOnResume", false)) {
                startUpdater();
            }
            requireArguments().putBoolean("shouldUpdaterStartFromOnResume", true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected void startUpdater() {
        startUpdater(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startUpdater(boolean z10) {
        try {
            clearUpdater(z10);
            if (this.f20962l == null || !z10) {
                if (z10) {
                    this.f20962l = new Handler();
                }
                this.f20963m = new a.C0232a(this, this.f20962l);
                Timer timer = new Timer();
                this.f20964n = timer;
                timer.schedule(this.f20963m, getUpdatesStartDelay(), getUpdatesTimeInterval());
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected boolean useBaseUrlPath() {
        return true;
    }
}
