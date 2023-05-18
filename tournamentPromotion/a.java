package com.scores365.tournamentPromotion;

import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.scores365.App;
import com.scores365.api.m0;
import com.scores365.api.o;
import com.scores365.db.InternalStorageDataManager;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.EntityObj;
import com.scores365.entitys.GsonManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import li.j;
import li.u;
import li.x0;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: PromotionMgr.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f24320a;

    /* renamed from: b  reason: collision with root package name */
    private static int f24321b;

    /* renamed from: c  reason: collision with root package name */
    public static BitmapDrawable f24322c;

    /* renamed from: d  reason: collision with root package name */
    public static BitmapDrawable f24323d;

    /* renamed from: i  reason: collision with root package name */
    private static nd.b f24328i;

    /* renamed from: e  reason: collision with root package name */
    private static final LinkedHashMap<Integer, nd.c> f24324e = new LinkedHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<Integer, CompetitionObj> f24325f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private static boolean f24326g = false;

    /* renamed from: h  reason: collision with root package name */
    private static ArrayList<nd.b> f24327h = null;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f24329j = false;

    /* renamed from: k  reason: collision with root package name */
    private static final Object f24330k = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PromotionMgr.java */
    /* renamed from: com.scores365.tournamentPromotion.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0260a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        HashSet<Integer> f24331a;

        public RunnableC0260a(HashSet<Integer> hashSet) {
            this.f24331a = hashSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                StringBuilder sb2 = new StringBuilder();
                Iterator<Integer> it = this.f24331a.iterator();
                while (it.hasNext()) {
                    Integer next = it.next();
                    if (!sf.a.i0(App.m()).i1(next.intValue())) {
                        if (sb2.length() > 0) {
                            sb2.append(",");
                        }
                        sb2.append(next);
                    }
                }
                if (sb2.toString().isEmpty()) {
                    return;
                }
                m0 m0Var = new m0(4, false, "", sb2.toString(), "", -1, -1, -1, false);
                m0Var.call();
                EntityObj a10 = m0Var.a();
                if (a10 == null || a10.getCompetitions() == null || a10.getCompetitions().isEmpty()) {
                    return;
                }
                sf.a.i0(App.m()).j(a10.getCompetitions());
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* compiled from: PromotionMgr.java */
    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<c> f24332a;

        /* renamed from: b  reason: collision with root package name */
        boolean f24333b;

        public b(c cVar, boolean z10) {
            this.f24332a = new WeakReference<>(cVar);
            this.f24333b = z10;
        }

        public static ArrayList<nd.c> a() {
            ArrayList<nd.c> arrayList = null;
            try {
                Vector<CompObj> l10 = App.b.l();
                HashSet hashSet = new HashSet();
                Iterator<CompObj> it = l10.iterator();
                while (it.hasNext()) {
                    hashSet.add(Integer.valueOf(it.next().getID()));
                }
                String D0 = x0.D0(hashSet);
                int e10 = j.e("PROM_VERSION");
                o oVar = new o(D0, e10);
                oVar.call();
                arrayList = oVar.c();
                if (arrayList != null) {
                    if (!arrayList.isEmpty()) {
                        InternalStorageDataManager.savePromotionData(oVar.a());
                        sf.b.X1().fa();
                        a.f24320a = oVar.d();
                        int unused = a.f24321b = oVar.b();
                        StringBuilder sb2 = new StringBuilder();
                        Iterator<nd.c> it2 = oVar.c().iterator();
                        while (it2.hasNext()) {
                            nd.c next = it2.next();
                            if (next instanceof nd.a) {
                                Iterator<Integer> it3 = ((nd.a) next).f35282g.f35311g.iterator();
                                while (it3.hasNext()) {
                                    Integer next2 = it3.next();
                                    if (sb2.length() > 0) {
                                        sb2.append(",");
                                    }
                                    sb2.append(next2);
                                }
                            }
                        }
                        m0 m0Var = new m0(4, false, "", sb2.toString(), "", -1, -1, -1, false);
                        if (m0Var.a() != null && m0Var.a().getCompetitions() != null) {
                            sf.a.i0(App.m()).j(m0Var.a().getCompetitions());
                        }
                    }
                    j.f("PROM_VERSION", e10);
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
            return arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashSet hashSet = new HashSet();
                ArrayList<nd.c> a10 = a();
                if (this.f24333b) {
                    a.f();
                    a.r();
                }
                try {
                    Iterator<nd.c> it = a10.iterator();
                    while (it.hasNext()) {
                        nd.c next = it.next();
                        if (next instanceof nd.a) {
                            hashSet.addAll(((nd.a) next).f35282g.f35311g);
                        }
                    }
                    new Thread(new RunnableC0260a(hashSet)).start();
                } catch (Exception e10) {
                    x0.N1(e10);
                }
                WeakReference<c> weakReference = this.f24332a;
                c cVar = weakReference != null ? weakReference.get() : null;
                if (cVar != null) {
                    cVar.a(a10);
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }
    }

    /* compiled from: PromotionMgr.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a(ArrayList<nd.c> arrayList);
    }

    public static void c() {
        try {
            d();
            f24328i = null;
            f24326g = false;
            f24329j = false;
            f24323d = null;
            f24322c = null;
            sf.b.X1().ga(-1);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static void d() {
        f24327h = null;
    }

    public static ArrayList<nd.b> e() {
        try {
            if (f24327h == null) {
                f24327h = new ArrayList<>();
                for (nd.c cVar : f24324e.values()) {
                    if ((cVar instanceof nd.b) && o((nd.b) cVar) && cVar.b() != j().b()) {
                        f24327h.add((nd.b) cVar);
                    }
                }
            }
        } catch (Exception e10) {
            ng.a.f35508a.c("PromotionMgr", "error adding fifth button", e10);
        }
        return f24327h;
    }

    public static void f() {
        nd.c cVar;
        try {
            String loadPromotionData = InternalStorageDataManager.loadPromotionData();
            if (TextUtils.isEmpty(loadPromotionData)) {
                ng.a.f35508a.b("PromotionMgr", "no load data found", null);
                return;
            }
            JSONObject jSONObject = new JSONObject(loadPromotionData);
            JSONArray optJSONArray = jSONObject.optJSONArray("Promotions");
            if (optJSONArray != null) {
                f24324e.clear();
                Gson gson = GsonManager.getGson();
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                    int optInt = optJSONObject == null ? -1 : optJSONObject.optInt("Type");
                    if (optJSONObject == null) {
                        ng.a.f35508a.c("PromotionMgr", "error extracting single promotion", new IllegalArgumentException("object should be a valid json, data=" + loadPromotionData + ", obj=" + optJSONArray.get(i10)));
                    } else {
                        if (1 == optInt) {
                            cVar = (nd.c) gson.l(optJSONObject.toString(), nd.a.class);
                        } else if (3 == optInt) {
                            cVar = (nd.c) gson.l(optJSONObject.toString(), nd.b.class);
                        } else {
                            ng.a.f35508a.c("PromotionMgr", "single promotion has invalid type (" + optInt + ")", new IllegalArgumentException("missing type error, obj=" + optJSONObject));
                            cVar = (nd.c) gson.l(optJSONObject.toString(), nd.c.class);
                        }
                        f24324e.put(Integer.valueOf(cVar.b()), cVar);
                    }
                }
                f24320a = jSONObject.getInt("Version");
                f24321b = jSONObject.getInt("MinWaitTime");
            }
        } catch (Exception e10) {
            ng.a.f35508a.c("PromotionMgr", "error loading local data", e10);
        }
    }

    public static nd.c g(int i10) {
        try {
            return f24324e.get(Integer.valueOf(i10));
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public static int h(int i10, boolean z10) {
        int i11 = -1;
        try {
            if (z10) {
                nd.c g10 = g(i10);
                if (q(g10, z10)) {
                    i11 = g10.b();
                }
            } else {
                Iterator<nd.c> it = f24324e.values().iterator();
                int i12 = -1;
                do {
                    try {
                        if (!it.hasNext()) {
                            break;
                        }
                        nd.c next = it.next();
                        if (q(next, z10)) {
                            i12 = next.b();
                            continue;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        i11 = i12;
                        x0.N1(e);
                        return i11;
                    }
                } while (i12 <= -1);
                i11 = i12;
            }
        } catch (Exception e11) {
            e = e11;
        }
        return i11;
    }

    public static int i(boolean z10) {
        return h(-1, z10);
    }

    public static nd.b j() {
        try {
            if (!f24326g && f24328i == null) {
                int U1 = sf.b.X1().U1();
                if (U1 > -1) {
                    nd.c cVar = f24324e.get(Integer.valueOf(U1));
                    if (cVar instanceof nd.b) {
                        nd.b bVar = (nd.b) cVar;
                        if (o(bVar)) {
                            f24328i = bVar;
                        }
                    }
                }
                if (f24328i == null) {
                    Iterator<Integer> it = f24324e.keySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Integer next = it.next();
                        LinkedHashMap<Integer, nd.c> linkedHashMap = f24324e;
                        if (linkedHashMap.get(next) instanceof nd.b) {
                            nd.b bVar2 = (nd.b) linkedHashMap.get(next);
                            if (o(bVar2)) {
                                f24328i = bVar2;
                                break;
                            }
                        }
                    }
                }
                f24326g = true;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return f24328i;
    }

    public static void k() {
        l(false);
    }

    public static void l(boolean z10) {
        m(z10, false);
    }

    public static void m(boolean z10, boolean z11) {
        if (z10 || sf.b.X1().U9() || j.a("PROM_VERSION")) {
            new Thread(new b(null, z11)).start();
        }
    }

    public static void n() {
        try {
            if (f24329j) {
                return;
            }
            synchronized (f24330k) {
                try {
                    if (!f24329j) {
                        f24329j = true;
                        if (sf.b.X1().b5()) {
                            f();
                            k();
                        }
                        r();
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    private static boolean o(nd.b bVar) {
        if (bVar != null) {
            try {
                if (bVar.a() && bVar.f() && bVar.d() != null) {
                    return bVar.d().i();
                }
                return false;
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }
        return false;
    }

    public static boolean p() {
        try {
            LinkedHashMap<Integer, nd.c> linkedHashMap = f24324e;
            if (linkedHashMap.isEmpty()) {
                return false;
            }
            int i10 = 0;
            for (Integer num : linkedHashMap.keySet()) {
                if (f24324e.get(num) instanceof nd.b) {
                    i10++;
                }
            }
            return i10 > 1;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    private static boolean q(nd.c cVar, boolean z10) {
        if (cVar != null) {
            try {
                if (cVar.a() && (cVar instanceof nd.a) && ((nd.a) cVar).f35284i.f35304b) {
                    if (!sf.b.X1().U0(cVar.b()) && sf.b.X1().H1(cVar.b()) < ((nd.a) cVar).f35284i.f35303a) {
                        if (!z10) {
                            if (sf.b.X1().d1() + TimeUnit.HOURS.toMillis(f24321b) > System.currentTimeMillis()) {
                                return false;
                            }
                        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void r() {
        try {
            if (f24323d == null && j() != null) {
                f24323d = new BitmapDrawable(App.m().getResources(), u.u(Uri.parse(j().d().b())));
            }
            if (f24322c != null || j() == null) {
                return;
            }
            f24322c = new BitmapDrawable(App.m().getResources(), u.u(Uri.parse(j().d().h())));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static void s() {
        f24326g = false;
    }

    public static void t(nd.b bVar) {
        f24328i = bVar;
    }

    public static void u(int i10, String str) {
        try {
            TournamentPromotionActivity.v1(false, i10, str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
