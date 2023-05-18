package com.scores365.Monetization.dhn.db;

import androidx.annotation.NonNull;
import b1.j;
import b1.k;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import x0.f;
import x0.p;
import x0.v;
import x0.x;
import z0.b;
import z0.d;
/* loaded from: classes2.dex */
public final class DhnDatabase_Impl extends DhnDatabase {

    /* renamed from: p  reason: collision with root package name */
    private volatile lc.a f21102p;

    /* loaded from: classes2.dex */
    class a extends x.b {
        a(int i10) {
            super(i10);
        }

        @Override // x0.x.b
        public void a(j jVar) {
            jVar.F("CREATE TABLE IF NOT EXISTS `dhnDB` (`AdId` INTEGER NOT NULL, `AdType` INTEGER NOT NULL, `ImpressionCountLastHour` INTEGER NOT NULL, `ImpressionCountLastDay` INTEGER NOT NULL, `ImpressionCountLastWeek` INTEGER NOT NULL, `ImpressionCountLastLifetime` INTEGER NOT NULL, `LastTimeResetCounterHour` INTEGER NOT NULL, `LastTimeResetCounterDay` INTEGER NOT NULL, `LastTimeResetCounterWeek` INTEGER NOT NULL, `TimeLastShown` INTEGER NOT NULL, PRIMARY KEY(`AdId`, `AdType`))");
            jVar.F("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            jVar.F("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a8d5098c395b13587dbdb81018ef9d28')");
        }

        @Override // x0.x.b
        public void b(j jVar) {
            jVar.F("DROP TABLE IF EXISTS `dhnDB`");
            if (((v) DhnDatabase_Impl.this).f41701h != null) {
                int size = ((v) DhnDatabase_Impl.this).f41701h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((v.b) ((v) DhnDatabase_Impl.this).f41701h.get(i10)).b(jVar);
                }
            }
        }

        @Override // x0.x.b
        public void c(j jVar) {
            if (((v) DhnDatabase_Impl.this).f41701h != null) {
                int size = ((v) DhnDatabase_Impl.this).f41701h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((v.b) ((v) DhnDatabase_Impl.this).f41701h.get(i10)).a(jVar);
                }
            }
        }

        @Override // x0.x.b
        public void d(j jVar) {
            ((v) DhnDatabase_Impl.this).f41694a = jVar;
            DhnDatabase_Impl.this.u(jVar);
            if (((v) DhnDatabase_Impl.this).f41701h != null) {
                int size = ((v) DhnDatabase_Impl.this).f41701h.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((v.b) ((v) DhnDatabase_Impl.this).f41701h.get(i10)).c(jVar);
                }
            }
        }

        @Override // x0.x.b
        public void e(j jVar) {
        }

        @Override // x0.x.b
        public void f(j jVar) {
            b.a(jVar);
        }

        @Override // x0.x.b
        public x.c g(j jVar) {
            HashMap hashMap = new HashMap(10);
            hashMap.put("AdId", new d.a("AdId", "INTEGER", true, 1, null, 1));
            hashMap.put("AdType", new d.a("AdType", "INTEGER", true, 2, null, 1));
            hashMap.put("ImpressionCountLastHour", new d.a("ImpressionCountLastHour", "INTEGER", true, 0, null, 1));
            hashMap.put("ImpressionCountLastDay", new d.a("ImpressionCountLastDay", "INTEGER", true, 0, null, 1));
            hashMap.put("ImpressionCountLastWeek", new d.a("ImpressionCountLastWeek", "INTEGER", true, 0, null, 1));
            hashMap.put("ImpressionCountLastLifetime", new d.a("ImpressionCountLastLifetime", "INTEGER", true, 0, null, 1));
            hashMap.put("LastTimeResetCounterHour", new d.a("LastTimeResetCounterHour", "INTEGER", true, 0, null, 1));
            hashMap.put("LastTimeResetCounterDay", new d.a("LastTimeResetCounterDay", "INTEGER", true, 0, null, 1));
            hashMap.put("LastTimeResetCounterWeek", new d.a("LastTimeResetCounterWeek", "INTEGER", true, 0, null, 1));
            hashMap.put("TimeLastShown", new d.a("TimeLastShown", "INTEGER", true, 0, null, 1));
            d dVar = new d("dhnDB", hashMap, new HashSet(0), new HashSet(0));
            d a10 = d.a(jVar, "dhnDB");
            if (dVar.equals(a10)) {
                return new x.c(true, null);
            }
            return new x.c(false, "dhnDB(com.scores365.Monetization.dhn.db.DhnRowObj).\n Expected:\n" + dVar + "\n Found:\n" + a10);
        }
    }

    @Override // com.scores365.Monetization.dhn.db.DhnDatabase
    public lc.a C() {
        lc.a aVar;
        if (this.f21102p != null) {
            return this.f21102p;
        }
        synchronized (this) {
            if (this.f21102p == null) {
                this.f21102p = new lc.b(this);
            }
            aVar = this.f21102p;
        }
        return aVar;
    }

    @Override // x0.v
    protected p g() {
        return new p(this, new HashMap(0), new HashMap(0), "dhnDB");
    }

    @Override // x0.v
    protected k h(f fVar) {
        return fVar.f41620c.a(k.b.a(fVar.f41618a).d(fVar.f41619b).c(new x(fVar, new a(1), "a8d5098c395b13587dbdb81018ef9d28", "7696a2323b3a945d96cb25a9bf497df8")).b());
    }

    @Override // x0.v
    public List<y0.b> j(@NonNull Map<Class<? extends y0.a>, y0.a> map) {
        return Arrays.asList(new y0.b[0]);
    }

    @Override // x0.v
    public Set<Class<? extends y0.a>> o() {
        return new HashSet();
    }

    @Override // x0.v
    protected Map<Class<?>, List<Class<?>>> p() {
        HashMap hashMap = new HashMap();
        hashMap.put(lc.a.class, lc.b.d());
        return hashMap;
    }
}
