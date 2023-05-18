package com.scores365.entitys;

import com.scores365.api.y1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.collections.r;
import li.x0;
/* compiled from: WinProbabilityObj.kt */
/* loaded from: classes2.dex */
public final class WinProbabilityObj implements Serializable {
    @p9.c("Competitors")
    private CompObj[] competitors;
    @p9.c("Statuses")
    private final LinkedHashMap<Integer, StatusObj> statuses;
    @p9.c("WinProbability")
    private final ArrayList<y1> winProbabilityEntries;

    public final CompObj[] getCompetitors() {
        return this.competitors;
    }

    public final float getLastCompletionFraction() {
        int k10;
        try {
            ArrayList<y1> arrayList = this.winProbabilityEntries;
            if (arrayList != null) {
                k10 = r.k(arrayList);
                return arrayList.get(k10).a() / 100;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return 1.0f;
    }

    public final LinkedHashMap<Integer, StatusObj> getStatuses() {
        return this.statuses;
    }

    public final ArrayList<y1> getWinProbabilityEntries() {
        return this.winProbabilityEntries;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0011 A[Catch: Exception -> 0x0048, TryCatch #0 {Exception -> 0x0048, blocks: (B:3:0x0001, B:5:0x0005, B:11:0x0011, B:12:0x0018, B:14:0x001e, B:21:0x003a), top: B:26:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.scores365.api.y1 getWinProbabilityEntryByCompletion(float r7) {
        /*
            r6 = this;
            r0 = 0
            java.util.ArrayList<com.scores365.api.y1> r1 = r6.winProbabilityEntries     // Catch: java.lang.Exception -> L48
            if (r1 == 0) goto Le
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Exception -> L48
            if (r1 == 0) goto Lc
            goto Le
        Lc:
            r1 = 0
            goto Lf
        Le:
            r1 = 1
        Lf:
            if (r1 != 0) goto L4c
            java.util.ArrayList<com.scores365.api.y1> r1 = r6.winProbabilityEntries     // Catch: java.lang.Exception -> L48
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L48
            r2 = r0
        L18:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Exception -> L48
            if (r3 == 0) goto L38
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Exception -> L48
            com.scores365.api.y1 r3 = (com.scores365.api.y1) r3     // Catch: java.lang.Exception -> L48
            float r4 = r3.a()     // Catch: java.lang.Exception -> L48
            r5 = 100
            float r5 = (float) r5     // Catch: java.lang.Exception -> L48
            float r4 = r4 / r5
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 <= 0) goto L36
            if (r2 != 0) goto L34
            r0 = r3
            goto L38
        L34:
            r0 = r2
            goto L38
        L36:
            r2 = r3
            goto L18
        L38:
            if (r0 != 0) goto L4c
            java.util.ArrayList<com.scores365.api.y1> r7 = r6.winProbabilityEntries     // Catch: java.lang.Exception -> L48
            int r1 = kotlin.collections.p.k(r7)     // Catch: java.lang.Exception -> L48
            java.lang.Object r7 = r7.get(r1)     // Catch: java.lang.Exception -> L48
            com.scores365.api.y1 r7 = (com.scores365.api.y1) r7     // Catch: java.lang.Exception -> L48
            r0 = r7
            goto L4c
        L48:
            r7 = move-exception
            li.x0.N1(r7)
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.entitys.WinProbabilityObj.getWinProbabilityEntryByCompletion(float):com.scores365.api.y1");
    }

    public final void setCompetitors(CompObj[] compObjArr) {
        this.competitors = compObjArr;
    }
}
