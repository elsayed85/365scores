package com.scores365.services;

import com.scores365.App;
import com.scores365.entitys.EntityObj;
/* compiled from: CatalogUtils.java */
/* loaded from: classes2.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:20:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af A[EDGE_INSN: B:38:0x00af->B:29:0x00af ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.scores365.entitys.EntityObj a() {
        /*
            java.lang.String r0 = "CatalogUtils"
            r1 = 0
            com.scores365.App.b.q()     // Catch: java.lang.Exception -> L92
            r2 = 1
            java.lang.String r7 = li.x0.O0(r2)     // Catch: java.lang.Exception -> L92
            java.lang.String r6 = li.x0.P0(r2)     // Catch: java.lang.Exception -> L92
            java.lang.String r8 = li.x0.M0()     // Catch: java.lang.Exception -> L92
            com.scores365.api.m0 r13 = new com.scores365.api.m0     // Catch: java.lang.Exception -> L92
            r4 = 4
            r5 = 1
            r9 = -1
            r10 = -1
            r11 = -1
            r12 = 0
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L92
            ng.a r3 = ng.a.f35508a     // Catch: java.lang.Exception -> L92
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L92
            r4.<init>()     // Catch: java.lang.Exception -> L92
            java.lang.String r5 = "fetching catalog from server, api="
            r4.append(r5)     // Catch: java.lang.Exception -> L92
            r4.append(r13)     // Catch: java.lang.Exception -> L92
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L92
            r3.b(r0, r4, r1)     // Catch: java.lang.Exception -> L92
            r3 = 0
            r5 = r1
            r4 = 0
        L38:
            r13.call()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            com.scores365.entitys.EntityObj r5 = r13.a()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            boolean r6 = r13.b()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            if (r6 != 0) goto L54
            ng.a r6 = ng.a.f35508a     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            java.lang.String r7 = "invalid catalog data"
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            java.lang.String r9 = "catalog data is not valid"
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            r6.c(r0, r7, r8)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            goto L5c
        L54:
            ng.a r4 = ng.a.f35508a     // Catch: java.lang.Exception -> L5f java.lang.Throwable -> L62
            java.lang.String r6 = "got catalog from remote"
            r4.b(r0, r6, r1)     // Catch: java.lang.Exception -> L5f java.lang.Throwable -> L62
            r4 = 1
        L5c:
            int r3 = r3 + 1
            goto L88
        L5f:
            r6 = move-exception
            r4 = 1
            goto L65
        L62:
            r1 = move-exception
            goto L8f
        L64:
            r6 = move-exception
        L65:
            ng.a r7 = ng.a.f35508a     // Catch: java.lang.Throwable -> L62
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r8.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r9 = "error getting catalog, error="
            r8.append(r9)     // Catch: java.lang.Throwable -> L62
            java.lang.String r9 = r6.getMessage()     // Catch: java.lang.Throwable -> L62
            r8.append(r9)     // Catch: java.lang.Throwable -> L62
            java.lang.String r9 = ", api="
            r8.append(r9)     // Catch: java.lang.Throwable -> L62
            r8.append(r13)     // Catch: java.lang.Throwable -> L62
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L62
            r7.c(r0, r8, r6)     // Catch: java.lang.Throwable -> L62
            goto L5c
        L88:
            if (r4 != 0) goto Laf
            r6 = 100
            if (r3 < r6) goto L38
            goto Laf
        L8f:
            throw r1     // Catch: java.lang.Exception -> L90
        L90:
            r1 = move-exception
            goto L95
        L92:
            r2 = move-exception
            r5 = r1
            r1 = r2
        L95:
            ng.a r2 = ng.a.f35508a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "can't get catalog from remote, error="
            r3.append(r4)
            java.lang.String r4 = r1.getMessage()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.c(r0, r3, r1)
        Laf:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.services.a.a():com.scores365.entitys.EntityObj");
    }

    public static boolean b() {
        ng.a.f35508a.b("CatalogUtils", "getting catalog", null);
        try {
            return c(a());
        } catch (Exception e10) {
            ng.a aVar = ng.a.f35508a;
            aVar.c("CatalogUtils", "non-fatal error=" + e10.getMessage(), e10);
            return false;
        }
    }

    public static boolean c(EntityObj entityObj) {
        boolean z10 = false;
        if (entityObj != null) {
            try {
                boolean n10 = (entityObj.getCountries() == null || entityObj.getCountries().length <= 0) ? false : sf.a.i0(App.m()).n(entityObj.getCountries());
                boolean k10 = entityObj.getCompetitions() != null ? sf.a.i0(App.m()).k(entityObj.getCompetitions(), true) : false;
                boolean z11 = entityObj.getCompetitors() != null && sf.a.i0(App.m()).l(entityObj.getCompetitors(), true) && sf.a.i0(App.m()).m(entityObj.getCompetitors(), true);
                boolean i10 = entityObj.getAthletes() != null ? sf.a.i0(App.m()).i(entityObj.getAthletes(), true) : false;
                if (n10 && k10 && z11 && i10) {
                    z10 = true;
                }
                sf.a.i0(App.m()).P1(z10);
                if (z10) {
                    sf.b.X1().X6();
                }
            } catch (Exception e10) {
                ng.a aVar = ng.a.f35508a;
                aVar.c("CatalogUtils", "non-fatal error=" + e10.getMessage(), e10);
            }
        }
        return z10;
    }
}
