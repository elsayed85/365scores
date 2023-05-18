package com.scores365.entitys;

import com.scores365.bets.model.BetLineOption;
import com.scores365.bets.model.BookMakerObj;
import java.util.HashMap;
/* compiled from: OutrightBetDetailsObj.kt */
/* loaded from: classes2.dex */
public final class OutrightBetDetailsObj extends BaseObj {
    @p9.c("Athlete")
    private final AthleteObj athleteObj;
    @p9.c("Competitor")
    private final CompObj competitor;
    @p9.c("Odds")
    private final BetLineOption odds;
    @p9.c("SecondaryName")
    private final String secondaryName = "";
    @p9.c("MarketTitle")
    private final String marketTitle = "";
    @p9.c("EntityType")
    private final int entityType = -1;
    @p9.c("EntityID")
    private final int entityID = -1;
    @p9.c("ImgVer")
    private final int imgVer = -1;
    @p9.c("LineTypeID")
    private final int lineTypeID = -1;
    @p9.c("LineID")
    private final int lineID = -1;
    @p9.c("BookmakerID")
    private final int bookmakerID = -1;
    @p9.c("WinningChancesText")
    private final String winningChancesText = "";
    @p9.c("InsightText")
    private final String insightText = "";
    @p9.c("Bookmakers")
    private final HashMap<Integer, BookMakerObj> bookmakers = new HashMap<>();

    public final AthleteObj getAthleteObj() {
        return this.athleteObj;
    }

    public final int getBookmakerID() {
        return this.bookmakerID;
    }

    public final HashMap<Integer, BookMakerObj> getBookmakers() {
        return this.bookmakers;
    }

    public final CompObj getCompetitor() {
        return this.competitor;
    }

    public final int getEntityID() {
        return this.entityID;
    }

    public final String getEntityName() {
        AthleteObj athleteObj;
        int i10 = this.entityType;
        if (i10 == eDashboardEntityType.Competitor.getValue()) {
            CompObj compObj = this.competitor;
            if (compObj != null) {
                return compObj.name;
            }
            return null;
        } else if (i10 != eDashboardEntityType.Athlete.getValue() || (athleteObj = this.athleteObj) == null) {
            return null;
        } else {
            return athleteObj.name;
        }
    }

    public final int getEntityType() {
        return this.entityType;
    }

    public final int getImgVer() {
        return this.imgVer;
    }

    public final String getInsightText() {
        return this.insightText;
    }

    public final int getLineID() {
        return this.lineID;
    }

    public final int getLineTypeID() {
        return this.lineTypeID;
    }

    public final String getMarketTitle() {
        return this.marketTitle;
    }

    public final BetLineOption getOdds() {
        return this.odds;
    }

    public final String getSecondaryName() {
        return this.secondaryName;
    }

    public final String getWinningChancesText() {
        return this.winningChancesText;
    }
}
