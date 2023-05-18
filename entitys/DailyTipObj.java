package com.scores365.entitys;

import androidx.annotation.NonNull;
import com.scores365.insight.RelatedOddsObj;
import com.scores365.insight.SingleInsightObj;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class DailyTipObj implements Serializable {
    @p9.c("Agents")
    public ArrayList<AgentObj> agents;
    @p9.c("Insights")
    public LinkedHashMap<Integer, SingleInsightObj> insightsMap;
    @p9.c("Providers")
    public ArrayList<ProviderObj> providers;
    @p9.c("RelatedOdds")
    public RelatedOddsObj relatedOdds;

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005e, code lost:
        if (r4.insightsMap.get(java.lang.Integer.valueOf(r5)).innerInsight.isEmpty() == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isSingle(int r5) {
        /*
            r4 = this;
            r0 = 1
            java.util.LinkedHashMap<java.lang.Integer, com.scores365.insight.SingleInsightObj> r1 = r4.insightsMap     // Catch: java.lang.Exception -> L62
            if (r1 == 0) goto L66
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Exception -> L62
            if (r1 != 0) goto L66
            r1 = -1
            r2 = 0
            if (r5 != r1) goto L3c
            java.util.LinkedHashMap<java.lang.Integer, com.scores365.insight.SingleInsightObj> r5 = r4.insightsMap     // Catch: java.lang.Exception -> L62
            java.util.Collection r5 = r5.values()     // Catch: java.lang.Exception -> L62
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L62
            java.lang.Object r5 = r5.next()     // Catch: java.lang.Exception -> L62
            com.scores365.insight.SingleInsightObj r5 = (com.scores365.insight.SingleInsightObj) r5     // Catch: java.lang.Exception -> L62
            java.util.ArrayList<com.scores365.insight.SingleInsightObj> r5 = r5.innerInsight     // Catch: java.lang.Exception -> L62
            if (r5 == 0) goto L66
            java.util.LinkedHashMap<java.lang.Integer, com.scores365.insight.SingleInsightObj> r5 = r4.insightsMap     // Catch: java.lang.Exception -> L62
            java.util.Collection r5 = r5.values()     // Catch: java.lang.Exception -> L62
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L62
            java.lang.Object r5 = r5.next()     // Catch: java.lang.Exception -> L62
            com.scores365.insight.SingleInsightObj r5 = (com.scores365.insight.SingleInsightObj) r5     // Catch: java.lang.Exception -> L62
            java.util.ArrayList<com.scores365.insight.SingleInsightObj> r5 = r5.innerInsight     // Catch: java.lang.Exception -> L62
            boolean r5 = r5.isEmpty()     // Catch: java.lang.Exception -> L62
            if (r5 != 0) goto L66
            goto L60
        L3c:
            java.util.LinkedHashMap<java.lang.Integer, com.scores365.insight.SingleInsightObj> r1 = r4.insightsMap     // Catch: java.lang.Exception -> L62
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> L62
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Exception -> L62
            com.scores365.insight.SingleInsightObj r1 = (com.scores365.insight.SingleInsightObj) r1     // Catch: java.lang.Exception -> L62
            java.util.ArrayList<com.scores365.insight.SingleInsightObj> r1 = r1.innerInsight     // Catch: java.lang.Exception -> L62
            if (r1 == 0) goto L66
            java.util.LinkedHashMap<java.lang.Integer, com.scores365.insight.SingleInsightObj> r1 = r4.insightsMap     // Catch: java.lang.Exception -> L62
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> L62
            java.lang.Object r5 = r1.get(r5)     // Catch: java.lang.Exception -> L62
            com.scores365.insight.SingleInsightObj r5 = (com.scores365.insight.SingleInsightObj) r5     // Catch: java.lang.Exception -> L62
            java.util.ArrayList<com.scores365.insight.SingleInsightObj> r5 = r5.innerInsight     // Catch: java.lang.Exception -> L62
            boolean r5 = r5.isEmpty()     // Catch: java.lang.Exception -> L62
            if (r5 != 0) goto L66
        L60:
            r0 = 0
            goto L66
        L62:
            r5 = move-exception
            li.x0.N1(r5)
        L66:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.entitys.DailyTipObj.isSingle(int):boolean");
    }

    @NonNull
    public String toString() {
        LinkedHashMap<Integer, SingleInsightObj> linkedHashMap = this.insightsMap;
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            return "Tip{ no data }";
        }
        return "Tip{insights=" + linkedHashMap.values() + '}';
    }
}
