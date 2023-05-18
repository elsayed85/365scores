package com.scores365.insight;

import com.scores365.App;
import com.scores365.bets.model.BetLineType;
import com.scores365.entitys.BaseObj;
import p9.c;
/* loaded from: classes2.dex */
public class InsightBetLineTypeObj extends BaseObj {
    @c("CompetitorID")
    public int competitorId;
    @c("LineTypeID")
    public int lineTypeId;
    @c("OptionNum")
    public int optionNum;
    @c("Param")
    public String param;
    @c("Recommendation")
    public String recommendation;

    public BetLineType getLineTypeObj() {
        return App.l().bets.getLineTypes().get(Integer.valueOf(this.lineTypeId));
    }
}
