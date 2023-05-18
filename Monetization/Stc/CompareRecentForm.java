package com.scores365.Monetization.Stc;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Design.PageObjects.b;
import com.scores365.entitys.eCompetitorTrend;
import lf.u;
import li.x0;
import xf.j;
/* loaded from: classes2.dex */
public class CompareRecentForm extends b {
    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.compareRecentForm.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            j.a aVar = (j.a) e0Var;
            if (x0.l1()) {
                TextView textView = aVar.f42399g[0];
                eCompetitorTrend ecompetitortrend = eCompetitorTrend.WIN;
                j.l(textView, ecompetitortrend);
                TextView textView2 = aVar.f42399g[1];
                eCompetitorTrend ecompetitortrend2 = eCompetitorTrend.DRAW;
                j.l(textView2, ecompetitortrend2);
                j.l(aVar.f42399g[2], ecompetitortrend);
                j.l(aVar.f42399g[3], eCompetitorTrend.LOSE);
                j.l(aVar.f42399g[4], ecompetitortrend);
                j.l(aVar.f42398f[0], ecompetitortrend);
                j.l(aVar.f42398f[1], ecompetitortrend);
                j.l(aVar.f42398f[2], ecompetitortrend);
                j.l(aVar.f42398f[3], ecompetitortrend2);
                j.l(aVar.f42398f[4], ecompetitortrend);
            } else {
                TextView textView3 = aVar.f42398f[0];
                eCompetitorTrend ecompetitortrend3 = eCompetitorTrend.WIN;
                j.l(textView3, ecompetitortrend3);
                TextView textView4 = aVar.f42398f[1];
                eCompetitorTrend ecompetitortrend4 = eCompetitorTrend.DRAW;
                j.l(textView4, ecompetitortrend4);
                j.l(aVar.f42398f[2], ecompetitortrend3);
                j.l(aVar.f42398f[3], eCompetitorTrend.LOSE);
                j.l(aVar.f42398f[4], ecompetitortrend3);
                j.l(aVar.f42399g[0], ecompetitortrend3);
                j.l(aVar.f42399g[1], ecompetitortrend3);
                j.l(aVar.f42399g[2], ecompetitortrend3);
                j.l(aVar.f42399g[3], ecompetitortrend4);
                j.l(aVar.f42399g[4], ecompetitortrend3);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
