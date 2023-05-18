package com.scores365.Pages;

import ag.i0;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.GameObj;
import com.scores365.gameCenter.i0;
import com.scores365.insight.InsightsObj;
import com.scores365.insight.SingleInsightObj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import li.p0;
import li.x0;
/* compiled from: InsightsPage.java */
/* loaded from: classes2.dex */
public class n extends com.scores365.gameCenter.s {

    /* renamed from: v  reason: collision with root package name */
    private static Object f21278v = new Object();

    /* renamed from: q  reason: collision with root package name */
    GameObj f21279q;

    /* renamed from: r  reason: collision with root package name */
    InsightsObj f21280r;

    /* renamed from: s  reason: collision with root package name */
    String f21281s;

    /* renamed from: t  reason: collision with root package name */
    String f21282t;

    /* renamed from: u  reason: collision with root package name */
    boolean f21283u = true;

    /* compiled from: InsightsPage.java */
    /* loaded from: classes2.dex */
    class a implements i0.a.b {
        a() {
        }

        @Override // ag.i0.a.b
        public void H(int i10) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        r5 = (ag.i0) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        if (getArguments().getBoolean("shouldSendTrackingLink", false) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
        r0 = r5.f618b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
        r0 = r0.getTrackingURL();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r0.isEmpty() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
        getArguments().putBoolean("shouldSendTrackingLink", false);
        ke.d.p(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
        if (r13.f21283u == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
        if (li.x0.s2() == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
        r13.f21283u = false;
        r0 = r5.f618b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
        if (r0 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
        r0 = r0.bookmakerId;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
        r0 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0067, code lost:
        r12 = new java.util.HashMap();
        r12.put("game_id", java.lang.String.valueOf(r13.f21279q.getID()));
        r12.put(com.facebook.internal.AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, com.scores365.gameCenter.i0.D0(r13.f21279q));
        r12.put("section", com.scores365.ui.GeneralNotificationListFragment.ANALYTICS_ENTITY_TYPE_SPORT_TYPE);
        r12.put("market_type", java.lang.String.valueOf(r5.f617a.getBetLineType().getID()));
        r12.put("bookie_id", java.lang.String.valueOf(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ab, code lost:
        if (r5.f625i != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ad, code lost:
        r12.put("bet-now-ab-test", com.facebook.appevents.AppEventsConstants.EVENT_PARAM_VALUE_YES);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b4, code lost:
        ee.k.m(com.scores365.App.m(), "gamecenter", "bets-impressions", "show", null, false, r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A1(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.Object r14 = com.scores365.Pages.n.f21278v     // Catch: java.lang.Exception -> Ld2
            monitor-enter(r14)     // Catch: java.lang.Exception -> Ld2
            int r0 = r13.getFirstVisiblePositionFromLayoutMgr()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            int r1 = r13.getLastVisibilePositionFromLayoutMgr()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            com.scores365.Design.Pages.c r2 = r13.rvBaseAdapter     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            java.util.ArrayList r2 = r2.B()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            r3 = 0
            r4 = 0
        L17:
            boolean r5 = r2.hasNext()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            if (r5 == 0) goto Lce
            java.lang.Object r5 = r2.next()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            com.scores365.Design.PageObjects.b r5 = (com.scores365.Design.PageObjects.b) r5     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            if (r0 > r4) goto Lc4
            if (r1 < r4) goto Lc4
            boolean r6 = r5 instanceof ag.i0     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            if (r6 == 0) goto Lc4
            ag.i0 r5 = (ag.i0) r5     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            android.os.Bundle r0 = r13.getArguments()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            java.lang.String r1 = "shouldSendTrackingLink"
            boolean r0 = r0.getBoolean(r1, r3)     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            if (r0 == 0) goto Lce
            com.scores365.bets.model.BetLine r0 = r5.f618b     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            if (r0 == 0) goto L53
            java.lang.String r0 = r0.getTrackingURL()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            boolean r1 = r0.isEmpty()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            if (r1 != 0) goto L53
            android.os.Bundle r1 = r13.getArguments()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            java.lang.String r2 = "shouldSendTrackingLink"
            r1.putBoolean(r2, r3)     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            ke.d.p(r0)     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
        L53:
            boolean r0 = r13.f21283u     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            if (r0 == 0) goto Lce
            boolean r0 = li.x0.s2()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            if (r0 == 0) goto Lce
            r13.f21283u = r3     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            com.scores365.bets.model.BetLine r0 = r5.f618b     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            if (r0 == 0) goto L66
            int r0 = r0.bookmakerId     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            goto L67
        L66:
            r0 = -1
        L67:
            java.util.HashMap r12 = new java.util.HashMap     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            r12.<init>()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            java.lang.String r1 = "game_id"
            com.scores365.entitys.GameObj r2 = r13.f21279q     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            int r2 = r2.getID()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            r12.put(r1, r2)     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            java.lang.String r1 = "status"
            com.scores365.entitys.GameObj r2 = r13.f21279q     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            java.lang.String r2 = com.scores365.gameCenter.i0.D0(r2)     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            r12.put(r1, r2)     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            java.lang.String r1 = "section"
            java.lang.String r2 = "3"
            r12.put(r1, r2)     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            java.lang.String r1 = "market_type"
            com.scores365.insight.SingleInsightObj r2 = r5.f617a     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            com.scores365.insight.InsightBetLineTypeObj r2 = r2.getBetLineType()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            int r2 = r2.getID()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            r12.put(r1, r2)     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            java.lang.String r1 = "bookie_id"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            r12.put(r1, r0)     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            boolean r0 = r5.f625i     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            if (r0 != 0) goto Lb4
            java.lang.String r0 = "bet-now-ab-test"
            java.lang.String r1 = "1"
            r12.put(r0, r1)     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
        Lb4:
            android.content.Context r6 = com.scores365.App.m()     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            java.lang.String r7 = "gamecenter"
            java.lang.String r8 = "bets-impressions"
            java.lang.String r9 = "show"
            r10 = 0
            r11 = 0
            ee.k.m(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> Lc8 java.lang.Exception -> Lca
            goto Lce
        Lc4:
            int r4 = r4 + 1
            goto L17
        Lc8:
            r0 = move-exception
            goto Ld0
        Lca:
            r0 = move-exception
            li.x0.N1(r0)     // Catch: java.lang.Throwable -> Lc8
        Lce:
            monitor-exit(r14)     // Catch: java.lang.Throwable -> Lc8
            goto Ld6
        Ld0:
            monitor-exit(r14)     // Catch: java.lang.Throwable -> Lc8
            throw r0     // Catch: java.lang.Exception -> Ld2
        Ld2:
            r14 = move-exception
            li.x0.N1(r14)
        Ld6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Pages.n.A1(java.lang.String):void");
    }

    public static n z1(GameObj gameObj, String str, String str2) {
        n nVar = new n();
        nVar.f21279q = gameObj;
        nVar.f21281s = str;
        nVar.f21282t = str2;
        nVar.setArguments(new Bundle());
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        BookMakerObj bookMakerObj;
        InsightsObj insightsObj;
        LinkedHashMap<Integer, SingleInsightObj> linkedHashMap;
        BookMakerObj bookMakerObj2;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            i0.h hVar = new i0.h();
            com.scores365.api.k kVar = new com.scores365.api.k(App.m(), this.f21279q.getID(), this.f21279q.getTopBookMaker());
            kVar.call();
            this.f21280r = kVar.a();
            HashSet hashSet = new HashSet();
            if (this.f21279q.getIsActive()) {
                GameObj gameObj = this.f21279q;
                if (gameObj.hasInsights && (insightsObj = gameObj.insightsObj) != null && (linkedHashMap = insightsObj.insightsMap) != null && !linkedHashMap.isEmpty()) {
                    arrayList.add(new ag.d0(p0.l0("INSIGHT_LIVE")));
                    SingleInsightObj value = this.f21279q.insightsObj.insightsMap.entrySet().iterator().next().getValue();
                    BetLine betLine = value.getBetLine() != null ? this.f21280r.getBetLine(value.getBetLine().lineId) : null;
                    if (betLine != null) {
                        BookMakerObj bookMaker = this.f21280r.getBookMaker(betLine.bookmakerId);
                        hVar.e(true);
                        hVar.f(bookMaker);
                        bookMakerObj2 = bookMaker;
                    } else {
                        bookMakerObj2 = null;
                    }
                    arrayList.add(new ag.i0(value, betLine, bookMakerObj2, true, false, false, this.f21279q, "main", getActivity(), this.f21281s, this.f21282t, false, null));
                    hashSet.add(Integer.valueOf(value.getID()));
                }
            }
            LinkedHashMap<Integer, SingleInsightObj> linkedHashMap2 = this.f21280r.insightsMap;
            if (linkedHashMap2 != null && !linkedHashMap2.isEmpty()) {
                boolean z10 = false;
                for (Integer num : this.f21280r.insightsMap.keySet()) {
                    if (!hashSet.contains(num)) {
                        if (!z10) {
                            arrayList.add(new ag.d0(p0.l0("INSIGHT_PRE_GAME")));
                            z10 = true;
                        }
                        SingleInsightObj singleInsightObj = this.f21280r.insightsMap.get(num);
                        BetLine betLine2 = singleInsightObj.getBetLine() != null ? this.f21280r.getBetLine(singleInsightObj.getBetLine().lineId) : null;
                        if (betLine2 != null) {
                            BookMakerObj bookMaker2 = this.f21280r.getBookMaker(betLine2.bookmakerId);
                            hVar.e(true);
                            hVar.f(bookMaker2);
                            bookMakerObj = bookMaker2;
                        } else {
                            bookMakerObj = null;
                        }
                        arrayList.add(new ag.i0(singleInsightObj, betLine2, bookMakerObj, !this.f21279q.getIsActive(), true, true, this.f21279q, "insights", getActivity(), this.f21281s, this.f21282t, false, null));
                        hashSet.add(Integer.valueOf(singleInsightObj.getID()));
                    }
                }
            }
            BookMakerObj m22 = x0.m2(this.f21280r.relatedOdds.bookmakers.values());
            if (hVar.b() && m22 != null && m22.disclaimer != null) {
                arrayList.add(new ld.e(-1L, false, m22, false));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    @Override // com.scores365.Design.Pages.q.e
    public void OnRecylerItemClick(int i10) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void OnScrollEvent(RecyclerView recyclerView, int i10, int i11, int i12, int i13) {
        super.OnScrollEvent(recyclerView, i10, i11, i12, i13);
        A1("OnScrollEvent");
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
    @Override // com.scores365.Design.Pages.a
    public boolean isContainedInCoordinatorLayout() {
        return true;
    }

    @Override // com.scores365.gameCenter.s, com.scores365.Design.Pages.q
    protected <T extends Collection> boolean isDataReady(T t10) {
        return (t10 == null || t10.isEmpty()) ? false : true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            A1("onResume");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getArguments().putBoolean("shouldSendTrackingLink", true);
        this.f21283u = true;
    }

    @Override // com.scores365.Design.Pages.q
    public <T extends Collection> void renderData(T t10) {
        super.renderData(t10);
        if (getUserVisibleHint()) {
            getArguments().putBoolean("shouldSendTrackingLink", true);
            this.f21283u = true;
            A1("renderData");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void setListeners() {
        try {
            super.setListeners();
            this.rvBaseAdapter.E(new a());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        super.setUserVisibleHint(z10);
        if (z10) {
            A1("setUserVisibleHint");
        }
    }

    @Override // com.scores365.gameCenter.s
    public void y1() {
    }
}
