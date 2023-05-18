package com.scores365.Monetization.Stc;

import ag.s;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Design.PageObjects.b;
import lf.u;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class ComparePreviousMeetings extends b {
    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.comparePreviousMeetings.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            s.a aVar = (s.a) e0Var;
            if (x0.l1()) {
                li.u.x(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.HomeLogo, aVar.f871g);
                li.u.x(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.AwayLogo, aVar.f870f);
                aVar.f872h.setText(String.valueOf(1));
                aVar.f873i.setText(String.valueOf(0));
            } else {
                li.u.x(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.HomeLogo, aVar.f870f);
                li.u.x(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.AwayLogo, aVar.f871g);
                aVar.f872h.setText(String.valueOf(0));
                aVar.f873i.setText(String.valueOf(1));
            }
            aVar.f874j.setText(String.valueOf(0));
            aVar.f877m.setText(p0.l0("H2H_DRAWS"));
            aVar.f875k.setText(p0.l0("H2H_WINS"));
            aVar.f876l.setText(p0.l0("H2H_WINS"));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
