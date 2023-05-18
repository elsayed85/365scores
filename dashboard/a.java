package com.scores365.dashboard;

import ad.h;
import ad.l;
import ad.o;
import ad.p;
import androidx.lifecycle.a1;
import cc.o0;
import com.facebook.appevents.AppEventsConstants;
import com.scores365.App;
import com.scores365.Design.Pages.j;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.s;
import com.scores365.db.InternalStorageDataManager;
import com.scores365.entitys.AthletesObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GamesObj;
import com.scores365.entitys.NewsObj;
import com.scores365.entitys.SourceObj;
import com.scores365.entitys.SquadDashboardObj;
import com.scores365.entitys.StatsDashboardData;
import com.scores365.entitys.StatsFilter;
import com.scores365.entitys.VideoObj;
import com.scores365.entitys.dashboardSections.AbstractSectionObject;
import com.scores365.entitys.dashboardSections.BuzzSection;
import com.scores365.entitys.dashboardSections.NewsSection;
import com.scores365.entitys.dashboardSections.PlayersListSection;
import com.scores365.entitys.dashboardSections.SocialSection;
import com.scores365.entitys.dashboardSections.SquadSection;
import com.scores365.entitys.dashboardSections.TransfersSection;
import com.scores365.entitys.eDashboardSection;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import lf.t;
import li.p0;
import li.x0;
import sc.i;
import sc.k;
/* compiled from: DashboardPagesDataMgr.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private xe.c f23331c;

    /* renamed from: d  reason: collision with root package name */
    private a1 f23332d;

    /* renamed from: e  reason: collision with root package name */
    private LinkedHashMap<t, LinkedHashMap<String, com.scores365.Design.Pages.b>> f23333e;

    /* renamed from: f  reason: collision with root package name */
    private LinkedHashMap<String, Object> f23334f;

    /* renamed from: a  reason: collision with root package name */
    protected k f23329a = null;

    /* renamed from: b  reason: collision with root package name */
    public e f23330b = null;

    /* renamed from: g  reason: collision with root package name */
    final Object f23335g = new Object();

    /* compiled from: DashboardPagesDataMgr.java */
    /* renamed from: com.scores365.dashboard.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0242a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private String f23336a;

        /* renamed from: b  reason: collision with root package name */
        private HashMap<String, Object> f23337b;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<d> f23338c;

        /* renamed from: d  reason: collision with root package name */
        private WeakReference<b> f23339d;

        public RunnableC0242a(String str, HashMap<String, Object> hashMap, d dVar, b bVar) {
            this.f23336a = str;
            this.f23337b = hashMap;
            this.f23338c = new WeakReference<>(dVar);
            this.f23339d = new WeakReference<>(bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            try {
                d dVar = this.f23338c.get();
                if (dVar != null) {
                    Object obj = null;
                    if (x0.o1(App.m())) {
                        com.scores365.api.e e10 = a.e(this.f23336a, dVar);
                        e10.call();
                        if (e10.c() != null && e10.c().length > 0) {
                            obj = e10.c()[0].getData();
                            e10.c()[0].setAdditionalData();
                        }
                        if (!dVar.y0()) {
                            dVar.k0(this.f23336a, obj);
                        }
                        if (this.f23337b == null) {
                            this.f23337b = new LinkedHashMap();
                        }
                        this.f23337b.put(this.f23336a, obj);
                    }
                    if (!dVar.y0() || (bVar = this.f23339d.get()) == null) {
                        return;
                    }
                    bVar.a(obj);
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }
    }

    /* compiled from: DashboardPagesDataMgr.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(Object obj);
    }

    /* compiled from: DashboardPagesDataMgr.java */
    /* loaded from: classes2.dex */
    public interface c {
        void onPageDataLoaded(Object obj);
    }

    /* compiled from: DashboardPagesDataMgr.java */
    /* loaded from: classes2.dex */
    public interface d {
        boolean I0();

        String Q0();

        void S0();

        ArrayList<StatsFilter> U0();

        int e0();

        void f0(ArrayList<StatsFilter> arrayList);

        boolean f1();

        void k0(String str, Object obj);

        ArrayList<com.scores365.Design.Pages.b> l0(t tVar);

        lf.c l1();

        void n1(String str, Object obj);

        Object p0(String str);

        int p1();

        Object r0(String str);

        void x0(String str, c cVar);

        boolean y0();
    }

    /* compiled from: DashboardPagesDataMgr.java */
    /* loaded from: classes2.dex */
    public enum e {
        MySelections,
        Competitor,
        Competition
    }

    private k a() {
        k kVar = k.Banner;
        try {
            if (this.f23329a == null) {
                this.f23329a = o0.n(i.Dashboard);
            }
            return this.f23329a;
        } catch (Exception e10) {
            x0.N1(e10);
            return kVar;
        }
    }

    private void b(AbstractSectionObject[] abstractSectionObjectArr, q.f fVar, lf.c cVar, boolean z10) {
        boolean z11 = false;
        for (AbstractSectionObject abstractSectionObject : abstractSectionObjectArr) {
            if (abstractSectionObject != null && eDashboardSection.COMPETITION_DETAILS.getValue() != abstractSectionObject.getSType() && eDashboardSection.HISTORY_AND_TEAMS.getValue() != abstractSectionObject.getSType() && eDashboardSection.OUTRIGHT.getValue() != abstractSectionObject.getSType()) {
                if (!z11 || (eDashboardSection.SCORES.getValue() == abstractSectionObject.getSType() && abstractSectionObject.getKey() != null && abstractSectionObject.getKey().equals("Games"))) {
                    if (!x0.l1()) {
                        this.f23333e.get(t.SCORES).put(abstractSectionObject.getKey(), p(abstractSectionObject, fVar, cVar));
                    }
                    LinkedHashMap<t, LinkedHashMap<String, com.scores365.Design.Pages.b>> linkedHashMap = this.f23333e;
                    t tVar = t.SCORES;
                    linkedHashMap.get(tVar).put("AllScores", new ad.a(p0.l0("DASHBOARD_ALL_SCORES_TITLE"), null, i.Dashboard, false, null));
                    if (x0.l1()) {
                        this.f23333e.get(tVar).put(abstractSectionObject.getKey(), p(abstractSectionObject, fVar, cVar));
                    }
                    z11 = true;
                } else if (eDashboardSection.NEWS.getValue() == abstractSectionObject.getSType()) {
                    this.f23333e.get(t.MEDIA).put(abstractSectionObject.getKey(), k(abstractSectionObject, fVar, cVar));
                } else if (eDashboardSection.BUZZ.getValue() == abstractSectionObject.getSType()) {
                    this.f23333e.get(t.MEDIA).put(abstractSectionObject.getKey(), g(abstractSectionObject, fVar, cVar));
                } else if (eDashboardSection.SOCIAL.getValue() == abstractSectionObject.getSType()) {
                    this.f23333e.get(t.MEDIA).put(abstractSectionObject.getKey(), r(abstractSectionObject, fVar, cVar));
                } else if (eDashboardSection.HIGHLIGHTS.getValue() == abstractSectionObject.getSType()) {
                    this.f23333e.get(t.MEDIA).put(abstractSectionObject.getKey(), i(abstractSectionObject, fVar, cVar));
                } else if (eDashboardSection.TRANSFERS.getValue() == abstractSectionObject.getSType()) {
                    this.f23333e.get(t.MEDIA).put(abstractSectionObject.getKey(), v(abstractSectionObject, fVar, cVar));
                } else if (eDashboardSection.SINGLE_SQUAD.getValue() == abstractSectionObject.getSType()) {
                    this.f23333e.get(t.MEDIA).put(abstractSectionObject.getKey(), q(abstractSectionObject, fVar, cVar));
                } else if (eDashboardSection.SQUADS.getValue() == abstractSectionObject.getSType()) {
                    this.f23333e.get(t.MEDIA).put(abstractSectionObject.getKey(), s(abstractSectionObject, fVar, cVar));
                } else if (eDashboardSection.STATS.getValue() == abstractSectionObject.getSType()) {
                    this.f23333e.get(t.MEDIA).put(abstractSectionObject.getKey(), u(abstractSectionObject, fVar, cVar));
                } else if (eDashboardSection.STANDINGS.getValue() == abstractSectionObject.getSType()) {
                    this.f23333e.get(t.MEDIA).put(abstractSectionObject.getKey(), t(abstractSectionObject, fVar, cVar));
                }
            }
        }
    }

    private boolean c(AbstractSectionObject[] abstractSectionObjectArr, q.f fVar, lf.c cVar, boolean z10) {
        try {
            synchronized (this.f23335g) {
                try {
                    this.f23334f = null;
                    x();
                    b(abstractSectionObjectArr, fVar, cVar, z10);
                    this.f23333e.get(t.FOLLOWING).putAll(n());
                    this.f23333e.get(t.MORE).putAll(o());
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
            return abstractSectionObjectArr.length > 0;
        } catch (Exception e11) {
            x0.N1(e11);
            return false;
        }
    }

    public static com.scores365.api.e e(String str, d dVar) {
        com.scores365.api.e eVar;
        String a10;
        if (dVar != null) {
            try {
                a10 = dVar.l1().a();
                eVar = r15;
                com.scores365.api.e eVar2 = new com.scores365.api.e(dVar.Q0(), "", x0.D0(dVar.l1().f34290b), x0.D0(dVar.l1().f34289a), x0.D0(dVar.l1().f34291c), x0.D0(dVar.l1().f34292d), sf.a.i0(App.m()).j0(), true, false, dVar.I0(), dVar.f1(), false, a10);
            } catch (Exception e10) {
                e = e10;
                eVar = null;
            }
            try {
                if (dVar.e0() > 0) {
                    eVar.i(dVar.e0());
                }
                if ((a10 == null || a10.isEmpty()) && "stats".equalsIgnoreCase(str)) {
                    eVar.f(Boolean.TRUE);
                }
                eVar.g(str);
                eVar.h(dVar.p1());
                return eVar;
            } catch (Exception e11) {
                e = e11;
                x0.N1(e);
                return eVar;
            }
        }
        return null;
    }

    private void f(String str, Object obj, d dVar, b bVar) {
        try {
            if (dVar.y0()) {
                bVar.a(obj);
            } else {
                dVar.k0(str, obj);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private com.scores365.Design.Pages.b g(AbstractSectionObject abstractSectionObject, q.f fVar, lf.c cVar) {
        try {
            return new ad.b(abstractSectionObject.getName(), null, i.Dashboard, false, abstractSectionObject.getKey(), ((BuzzSection) abstractSectionObject).getData(), p0.l0("EMPTY_SCREEN_NO_NEWS_FOR_SELECTIONS"), 1, false, true, false);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private com.scores365.Design.Pages.b i(AbstractSectionObject abstractSectionObject, q.f fVar, lf.c cVar) {
        boolean z10;
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            GamesObj gamesObj = (GamesObj) abstractSectionObject.getData();
            if (gamesObj != null) {
                for (GameObj gameObj : gamesObj.getGames().values()) {
                    VideoObj[] videos = gameObj.getVideos();
                    if (videos != null && videos.length > 0) {
                        for (VideoObj videoObj : videos) {
                            arrayList2.add(videoObj);
                        }
                        arrayList.add(gameObj);
                    }
                }
            }
            k a10 = a();
            if (a10 != k.Both && a10 != k.Native) {
                z10 = false;
                return new ad.e(arrayList, abstractSectionObject.getName(), cVar, null, fVar, false, z10, "", i.Dashboard, false, abstractSectionObject.getKey());
            }
            z10 = true;
            return new ad.e(arrayList, abstractSectionObject.getName(), cVar, null, fVar, false, z10, "", i.Dashboard, false, abstractSectionObject.getKey());
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private com.scores365.Design.Pages.b k(AbstractSectionObject abstractSectionObject, q.f fVar, lf.c cVar) {
        String str;
        String str2;
        String str3;
        try {
            NewsObj data = ((NewsSection) abstractSectionObject).getData();
            ArrayList arrayList = data != null ? new ArrayList(Arrays.asList(data.getItems())) : null;
            Hashtable hashtable = new Hashtable();
            if (data != null && data.getSources() != null) {
                for (SourceObj sourceObj : data.getSources().values()) {
                    hashtable.put(Integer.valueOf(sourceObj.getID()), sourceObj);
                }
            }
            String l02 = p0.l0("EMPTY_SCREEN_NO_NEWS_FOR_SELECTIONS");
            if (data != null) {
                String newsType = data.getNewsType();
                String nextPage = data.getNextPage();
                str3 = data.getRefreshPage();
                str = newsType;
                str2 = nextPage;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            return new h(arrayList, hashtable, abstractSectionObject.getName(), cVar, str, null, str2, str3, fVar, false, l02, true, i.Dashboard, false, false, abstractSectionObject.getKey(), false);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private LinkedHashMap<String, com.scores365.Design.Pages.b> n() {
        LinkedHashMap<String, com.scores365.Design.Pages.b> linkedHashMap = new LinkedHashMap<>();
        try {
            if (x0.l1()) {
                String l02 = p0.l0("SETTINGS_CATEGORY_NOTIFICATIONS");
                i iVar = i.Dashboard;
                linkedHashMap.put("2", new s(l02, null, iVar, false, null));
                linkedHashMap.put(AppEventsConstants.EVENT_PARAM_VALUE_YES, new j(p0.l0("NEW_DASHBAORD_FOLLOWING"), null, iVar, false, null));
            } else {
                String l03 = p0.l0("NEW_DASHBAORD_FOLLOWING");
                i iVar2 = i.Dashboard;
                linkedHashMap.put(AppEventsConstants.EVENT_PARAM_VALUE_YES, new j(l03, null, iVar2, false, null));
                linkedHashMap.put("2", new s(p0.l0("SETTINGS_CATEGORY_NOTIFICATIONS"), null, iVar2, false, null));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return linkedHashMap;
    }

    private LinkedHashMap<String, com.scores365.Design.Pages.b> o() {
        LinkedHashMap<String, com.scores365.Design.Pages.b> linkedHashMap = new LinkedHashMap<>();
        try {
            linkedHashMap.put(AppEventsConstants.EVENT_PARAM_VALUE_YES, new hf.d(p0.l0("NEW_DASHBAORD_MORE"), null, i.Dashboard, false, null));
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0057 A[Catch: Exception -> 0x0086, TryCatch #0 {Exception -> 0x0086, blocks: (B:3:0x0005, B:5:0x001d, B:14:0x0051, B:16:0x0057, B:18:0x006a, B:7:0x0029, B:9:0x0035, B:11:0x003f, B:12:0x0046), top: B:26:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.scores365.Design.Pages.b p(com.scores365.entitys.dashboardSections.AbstractSectionObject r19, com.scores365.Design.Pages.q.f r20, lf.c r21) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = 0
            java.lang.String r3 = "NO_GAMES_STRIP_NO_GAMES_TEXT"
            java.lang.String r3 = li.p0.l0(r3)     // Catch: java.lang.Exception -> L86
            java.lang.String r4 = "#"
            java.lang.String r5 = "\n"
            java.lang.String r14 = r3.replace(r4, r5)     // Catch: java.lang.Exception -> L86
            java.lang.String r3 = r19.getKey()     // Catch: java.lang.Exception -> L86
            java.lang.Object r3 = r1.m(r3)     // Catch: java.lang.Exception -> L86
            if (r3 == 0) goto L29
            java.lang.String r3 = r19.getKey()     // Catch: java.lang.Exception -> L86
            java.lang.Object r3 = r1.m(r3)     // Catch: java.lang.Exception -> L86
            com.scores365.entitys.GamesObj r3 = (com.scores365.entitys.GamesObj) r3     // Catch: java.lang.Exception -> L86
        L27:
            r7 = r3
            goto L51
        L29:
            int r3 = r19.getSType()     // Catch: java.lang.Exception -> L86
            com.scores365.entitys.eDashboardSection r4 = com.scores365.entitys.eDashboardSection.SCORES     // Catch: java.lang.Exception -> L86
            int r4 = r4.getValue()     // Catch: java.lang.Exception -> L86
            if (r3 != r4) goto L50
            java.lang.Object r3 = r19.getData()     // Catch: java.lang.Exception -> L86
            com.scores365.entitys.GamesObj r3 = (com.scores365.entitys.GamesObj) r3     // Catch: java.lang.Exception -> L86
            java.util.LinkedHashMap<java.lang.String, java.lang.Object> r4 = r1.f23334f     // Catch: java.lang.Exception -> L86
            if (r4 != 0) goto L46
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap     // Catch: java.lang.Exception -> L86
            r4.<init>()     // Catch: java.lang.Exception -> L86
            r1.f23334f = r4     // Catch: java.lang.Exception -> L86
        L46:
            java.util.LinkedHashMap<java.lang.String, java.lang.Object> r4 = r1.f23334f     // Catch: java.lang.Exception -> L86
            java.lang.String r5 = r19.getKey()     // Catch: java.lang.Exception -> L86
            r4.put(r5, r3)     // Catch: java.lang.Exception -> L86
            goto L27
        L50:
            r7 = r2
        L51:
            java.lang.String r3 = "Games"
            boolean r4 = r0 instanceof com.scores365.entitys.dashboardSections.ScoresSection     // Catch: java.lang.Exception -> L86
            if (r4 == 0) goto L66
            r3 = r0
            com.scores365.entitys.dashboardSections.ScoresSection r3 = (com.scores365.entitys.dashboardSections.ScoresSection) r3     // Catch: java.lang.Exception -> L86
            int r3 = r3.getGamesToday()     // Catch: java.lang.Exception -> L86
            java.lang.String r0 = r19.getKey()     // Catch: java.lang.Exception -> L86
            r17 = r0
            r10 = r3
            goto L6a
        L66:
            r0 = 0
            r17 = r3
            r10 = 0
        L6a:
            ad.g r3 = new ad.g     // Catch: java.lang.Exception -> L86
            java.lang.String r0 = "MY_SCORES"
            java.lang.String r8 = li.p0.l0(r0)     // Catch: java.lang.Exception -> L86
            r11 = 0
            r13 = 0
            r15 = 1
            sc.i r16 = sc.i.Dashboard     // Catch: java.lang.Exception -> L86
            r6 = r3
            r9 = r21
            r12 = r20
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Exception -> L86
            li.x0.Q1(r21)     // Catch: java.lang.Exception -> L83
            goto L8b
        L83:
            r0 = move-exception
            r2 = r3
            goto L87
        L86:
            r0 = move-exception
        L87:
            li.x0.N1(r0)
            r3 = r2
        L8b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.dashboard.a.p(com.scores365.entitys.dashboardSections.AbstractSectionObject, com.scores365.Design.Pages.q$f, lf.c):com.scores365.Design.Pages.b");
    }

    private com.scores365.Design.Pages.b q(AbstractSectionObject abstractSectionObject, q.f fVar, lf.c cVar) {
        CompObj compObj;
        boolean z10;
        boolean z11;
        HashSet<Integer> hashSet;
        try {
            AthletesObj data = ((PlayersListSection) abstractSectionObject).getData();
            int i10 = -1;
            int intValue = (data == null || data.getCompetitorsById() == null || data.getCompetitorsById().isEmpty()) ? -1 : data.getCompetitorsById().keySet().iterator().next().intValue();
            boolean z12 = true;
            if (intValue > -1) {
                compObj = data.getCompetitorsById().get(Integer.valueOf(intValue));
                z10 = compObj.getType() == CompObj.eCompetitorType.NATIONAL;
            } else {
                compObj = null;
                z10 = false;
            }
            if (data != null) {
                try {
                    if (data.getCompetitionsById().values().iterator().next() != null) {
                        i10 = data.getCompetitionsById().values().iterator().next().getID();
                    }
                } catch (Exception unused) {
                }
            }
            if (cVar == null || (hashSet = cVar.f34290b) == null || cVar.f34289a == null) {
                z11 = true;
            } else {
                if (hashSet.size() <= 0) {
                    z12 = false;
                }
                z11 = z12;
            }
            return new ad.j(data, abstractSectionObject.getName(), i10, compObj != null ? compObj.getName() : "", z11, i.Dashboard, z10, abstractSectionObject.getKey());
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private com.scores365.Design.Pages.b r(AbstractSectionObject abstractSectionObject, q.f fVar, lf.c cVar) {
        String str;
        String str2;
        boolean z10;
        try {
            NewsObj data = ((SocialSection) abstractSectionObject).getData();
            Hashtable hashtable = new Hashtable();
            ArrayList arrayList = data != null ? new ArrayList(Arrays.asList(data.getItems())) : null;
            if (data != null && data.getSources() != null) {
                for (SourceObj sourceObj : data.getSources().values()) {
                    hashtable.put(Integer.valueOf(sourceObj.getID()), sourceObj);
                }
            }
            if (data != null) {
                String refreshPage = data.getRefreshPage();
                str2 = data.getNextPage();
                str = refreshPage;
            } else {
                str = null;
                str2 = null;
            }
            k a10 = a();
            if (a10 != k.Both && a10 != k.Native) {
                z10 = false;
                return new ad.i(abstractSectionObject.getName(), arrayList, hashtable, cVar, null, str, str2, fVar, false, z10, "", i.Dashboard, false, abstractSectionObject.getKey());
            }
            z10 = true;
            return new ad.i(abstractSectionObject.getName(), arrayList, hashtable, cVar, null, str, str2, fVar, false, z10, "", i.Dashboard, false, abstractSectionObject.getKey());
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private com.scores365.Design.Pages.b s(AbstractSectionObject abstractSectionObject, q.f fVar, lf.c cVar) {
        int i10;
        int i11;
        try {
            SquadDashboardObj data = ((SquadSection) abstractSectionObject).getData();
            if (data != null) {
                i10 = data.competitionById.keySet().iterator().next().intValue();
                i11 = data.competitionById.values().iterator().next().getSid();
            } else {
                i10 = -1;
                i11 = -1;
            }
            return new ad.k(data, abstractSectionObject.getName(), i10, i.Dashboard, i11, null, "dashboard", abstractSectionObject.getKey());
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003e A[Catch: Exception -> 0x0062, TRY_LEAVE, TryCatch #5 {Exception -> 0x0062, blocks: (B:17:0x0038, B:19:0x003e), top: B:51:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076 A[Catch: Exception -> 0x0079, TRY_LEAVE, TryCatch #3 {Exception -> 0x0079, blocks: (B:30:0x006c, B:32:0x0076), top: B:47:0x006c, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.scores365.Design.Pages.b t(com.scores365.entitys.dashboardSections.AbstractSectionObject r29, com.scores365.Design.Pages.q.f r30, lf.c r31) {
        /*
            r28 = this;
            r1 = r28
            r2 = 0
            r3 = 0
            r0 = r29
            com.scores365.entitys.dashboardSections.StandingsSection r0 = (com.scores365.entitys.dashboardSections.StandingsSection) r0     // Catch: java.lang.Exception -> L2f
            com.scores365.entitys.StandingsObj r0 = r0.getData()     // Catch: java.lang.Exception -> L2f
            if (r0 == 0) goto L29
            r0 = r29
            com.scores365.entitys.dashboardSections.StandingsSection r0 = (com.scores365.entitys.dashboardSections.StandingsSection) r0     // Catch: java.lang.Exception -> L2f
            com.scores365.entitys.StandingsObj r0 = r0.getData()     // Catch: java.lang.Exception -> L2f
            java.util.ArrayList r4 = r0.getCompetitions()     // Catch: java.lang.Exception -> L2f
            r0 = r29
            com.scores365.entitys.dashboardSections.StandingsSection r0 = (com.scores365.entitys.dashboardSections.StandingsSection) r0     // Catch: java.lang.Exception -> L27
            com.scores365.entitys.StandingsObj r0 = r0.getData()     // Catch: java.lang.Exception -> L27
            boolean r0 = r0.isShowOnlyTables()     // Catch: java.lang.Exception -> L27
            goto L2b
        L27:
            r0 = move-exception
            goto L31
        L29:
            r4 = r2
            r0 = 0
        L2b:
            r25 = r0
            r12 = r4
            goto L37
        L2f:
            r0 = move-exception
            r4 = r2
        L31:
            li.x0.N1(r0)     // Catch: java.lang.Exception -> Lad
            r12 = r4
            r25 = 0
        L37:
            r4 = -1
            com.scores365.dashboard.a$e r0 = r1.f23330b     // Catch: java.lang.Exception -> L62
            com.scores365.dashboard.a$e r5 = com.scores365.dashboard.a.e.Competitor     // Catch: java.lang.Exception -> L62
            if (r0 != r5) goto L5d
            r5 = r31
            java.util.HashSet<java.lang.Integer> r0 = r5.f34289a     // Catch: java.lang.Exception -> L62
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L62
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Exception -> L62
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Exception -> L62
            int r5 = r0.intValue()     // Catch: java.lang.Exception -> L62
            java.lang.Object r0 = r12.get(r3)     // Catch: java.lang.Exception -> L5b
            com.scores365.entitys.CompetitionObj r0 = (com.scores365.entitys.CompetitionObj) r0     // Catch: java.lang.Exception -> L5b
            int r4 = r0.CurrStage     // Catch: java.lang.Exception -> L5b
            r0 = r4
            r4 = r5
            goto L5e
        L5b:
            r0 = move-exception
            goto L64
        L5d:
            r0 = -1
        L5e:
            r16 = r0
            r6 = r4
            goto L6a
        L62:
            r0 = move-exception
            r5 = -1
        L64:
            li.x0.N1(r0)     // Catch: java.lang.Exception -> Lad
            r6 = r5
            r16 = -1
        L6a:
            zc.c$d r3 = zc.c.d.AUTO     // Catch: java.lang.Exception -> Lad
            r0 = r29
            com.scores365.entitys.dashboardSections.StandingsSection r0 = (com.scores365.entitys.dashboardSections.StandingsSection) r0     // Catch: java.lang.Exception -> L79
            boolean r0 = r0.isShowOnlyTables()     // Catch: java.lang.Exception -> L79
            if (r0 == 0) goto L7d
            zc.c$d r3 = zc.c.d.GROUPS     // Catch: java.lang.Exception -> L79
            goto L7d
        L79:
            r0 = move-exception
            li.x0.N1(r0)     // Catch: java.lang.Exception -> Lad
        L7d:
            r14 = r3
            ad.c r0 = new ad.c     // Catch: java.lang.Exception -> Lad
            r7 = -1
            java.lang.String r8 = r29.getName()     // Catch: java.lang.Exception -> Lad
            java.lang.String r9 = ""
            sc.i r10 = sc.i.Dashboard     // Catch: java.lang.Exception -> Lad
            r11 = 0
            r13 = 0
            java.lang.String r17 = "dashboard"
            java.lang.String r18 = ""
            java.lang.String r19 = ""
            r20 = 0
            r21 = 0
            java.lang.String r22 = r29.getKey()     // Catch: java.lang.Exception -> Lad
            r23 = -1
            r24 = 0
            xe.c r3 = r1.f23331c     // Catch: java.lang.Exception -> Lad
            androidx.lifecycle.a1 r4 = r1.f23332d     // Catch: java.lang.Exception -> Lad
            r5 = r0
            r15 = r16
            r26 = r3
            r27 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)     // Catch: java.lang.Exception -> Lad
            r2 = r0
            goto Lb1
        Lad:
            r0 = move-exception
            li.x0.N1(r0)
        Lb1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.dashboard.a.t(com.scores365.entitys.dashboardSections.AbstractSectionObject, com.scores365.Design.Pages.q$f, lf.c):com.scores365.Design.Pages.b");
    }

    private com.scores365.Design.Pages.b u(AbstractSectionObject abstractSectionObject, q.f fVar, lf.c cVar) {
        CompetitionObj competitionObj;
        int i10;
        int i11;
        int i12;
        boolean z10;
        int intValue;
        try {
            if (abstractSectionObject.getData() != null) {
                LinkedHashMap<Integer, CompetitionObj> competitionsById = ((StatsDashboardData) abstractSectionObject.getData()).getCompetitionsById();
                competitionObj = competitionsById.get(competitionsById.keySet().iterator().next());
            } else {
                competitionObj = null;
            }
            int i13 = -1;
            boolean z11 = false;
            try {
            } catch (Exception e10) {
                e = e10;
                i10 = -1;
            }
            if (competitionObj != null) {
                intValue = competitionObj.getID();
            } else {
                HashSet<Integer> hashSet = cVar.f34290b;
                if (hashSet == null || hashSet.size() != 1) {
                    HashSet<Integer> hashSet2 = cVar.f34289a;
                    if (hashSet2 != null && hashSet2.size() == 1) {
                        i10 = cVar.f34289a.iterator().next().intValue();
                        try {
                            if (((StatsDashboardData) abstractSectionObject.getData()).competitorsById.get(Integer.valueOf(i10)) != null) {
                                if (((StatsDashboardData) abstractSectionObject.getData()).competitorsById.get(Integer.valueOf(i10)).getType() == CompObj.eCompetitorType.TEAM) {
                                    z11 = true;
                                }
                            }
                            i11 = i10;
                            i12 = i13;
                            z10 = z11;
                        } catch (Exception e11) {
                            e = e11;
                            x0.N1(e);
                            i11 = i10;
                            i12 = -1;
                            z10 = false;
                            return new l(abstractSectionObject.getName(), "", i.Dashboard, false, (StatsDashboardData) abstractSectionObject.getData(), i12, abstractSectionObject.getKey(), z10, i11);
                        }
                        return new l(abstractSectionObject.getName(), "", i.Dashboard, false, (StatsDashboardData) abstractSectionObject.getData(), i12, abstractSectionObject.getKey(), z10, i11);
                    }
                    i10 = -1;
                    i11 = i10;
                    i12 = i13;
                    z10 = z11;
                    return new l(abstractSectionObject.getName(), "", i.Dashboard, false, (StatsDashboardData) abstractSectionObject.getData(), i12, abstractSectionObject.getKey(), z10, i11);
                }
                intValue = cVar.f34290b.iterator().next().intValue();
            }
            i13 = intValue;
            i10 = -1;
            i11 = i10;
            i12 = i13;
            z10 = z11;
            return new l(abstractSectionObject.getName(), "", i.Dashboard, false, (StatsDashboardData) abstractSectionObject.getData(), i12, abstractSectionObject.getKey(), z10, i11);
        } catch (Exception e12) {
            x0.N1(e12);
            return null;
        }
    }

    private com.scores365.Design.Pages.b v(AbstractSectionObject abstractSectionObject, q.f fVar, lf.c cVar) {
        boolean z10;
        try {
            k a10 = a();
            if (a10 != k.Both && a10 != k.Native) {
                z10 = false;
                return new o(((TransfersSection) abstractSectionObject).getData(), cVar, abstractSectionObject.getName(), null, fVar, false, z10, i.Dashboard, abstractSectionObject.getKey());
            }
            z10 = true;
            return new o(((TransfersSection) abstractSectionObject).getData(), cVar, abstractSectionObject.getName(), null, fVar, false, z10, i.Dashboard, abstractSectionObject.getKey());
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private void x() {
        LinkedHashMap<t, LinkedHashMap<String, com.scores365.Design.Pages.b>> linkedHashMap = new LinkedHashMap<>();
        this.f23333e = linkedHashMap;
        linkedHashMap.put(t.SCORES, new LinkedHashMap<>());
        this.f23333e.put(t.MEDIA, new LinkedHashMap<>());
        this.f23333e.put(t.FOLLOWING, new LinkedHashMap<>());
        this.f23333e.put(t.MORE, new LinkedHashMap<>());
    }

    public void A(lf.c cVar) {
        try {
            for (t tVar : this.f23333e.keySet()) {
                for (com.scores365.Design.Pages.b bVar : this.f23333e.get(tVar).values()) {
                    if (bVar instanceof com.scores365.Design.Pages.i) {
                        ((com.scores365.Design.Pages.i) bVar).f20986a = cVar;
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void B(GamesObj gamesObj) {
        String str;
        try {
            Iterator<com.scores365.Design.Pages.b> it = this.f23333e.get(t.SCORES).values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    break;
                }
                com.scores365.Design.Pages.b next = it.next();
                if ((next instanceof p) && ((p) next).a() == lf.s.SCORES) {
                    str = next.pageKey;
                    break;
                }
            }
            if (str != null) {
                this.f23334f.put(str, gamesObj);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void d() {
        LinkedHashMap<String, com.scores365.Design.Pages.b> linkedHashMap;
        LinkedHashMap<t, LinkedHashMap<String, com.scores365.Design.Pages.b>> linkedHashMap2 = this.f23333e;
        if (linkedHashMap2 == null || (linkedHashMap = linkedHashMap2.get(t.MEDIA)) == null) {
            return;
        }
        linkedHashMap.clear();
    }

    public LinkedHashMap<String, Object> h() {
        return this.f23334f;
    }

    public GamesObj j() {
        String str;
        try {
            Iterator<com.scores365.Design.Pages.b> it = this.f23333e.get(t.SCORES).values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    break;
                }
                com.scores365.Design.Pages.b next = it.next();
                if ((next instanceof p) && ((p) next).a() == lf.s.SCORES) {
                    str = next.pageKey;
                    break;
                }
            }
            if (str != null) {
                return (GamesObj) this.f23334f.get(str);
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public ArrayList<com.scores365.Design.Pages.b> l(t tVar) {
        try {
            return new ArrayList<>(this.f23333e.get(tVar).values());
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public Object m(String str) {
        try {
            LinkedHashMap<String, Object> linkedHashMap = this.f23334f;
            if (linkedHashMap == null || !linkedHashMap.containsKey(str)) {
                return null;
            }
            return this.f23334f.get(str);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public boolean w(d dVar, q.f fVar, boolean z10, boolean z11) {
        boolean z12 = false;
        try {
            com.scores365.api.e e10 = e(null, dVar);
            if (z11) {
                String loadDashboardData = InternalStorageDataManager.loadDashboardData();
                if (loadDashboardData != null && !loadDashboardData.isEmpty()) {
                    e10.e(loadDashboardData);
                }
            } else {
                e10.call();
            }
            if (e10.c() != null && e10.c().length > 0) {
                z12 = c(e10.c(), fVar, dVar.l1(), z10);
                if (this.f23333e.get(t.MEDIA).size() == 0) {
                    b(e10.c(), fVar, dVar.l1(), z10);
                }
                if (!z11 && x0.q2()) {
                    InternalStorageDataManager.saveDashboardDataAsync(e10.a());
                }
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
        return z12;
    }

    public void y(String str, d dVar, b bVar) {
        try {
            Object m10 = m(str);
            if (m10 != null) {
                f(str, m10, dVar, bVar);
            } else {
                new RunnableC0242a(str, this.f23334f, dVar, bVar).run();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void z(xe.c cVar, a1 a1Var) {
        this.f23331c = cVar;
        this.f23332d = a1Var;
    }
}
