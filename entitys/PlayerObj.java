package com.scores365.entitys;

import com.scores365.App;
import com.scores365.R;
import com.scores365.bets.model.BetLine;
import com.scores365.entitys.SuspensionObj;
import java.io.Serializable;
import li.x0;
import nb.o;
import nb.p;
/* loaded from: classes2.dex */
public class PlayerObj implements Serializable {
    private static final long serialVersionUID = -1115050136807292859L;
    @p9.c("RelatedLines")
    private BetLine[] betLines;
    @p9.c("Ejected")
    private boolean ejected;
    @p9.c(alternate = {"FormationPositionId"}, value = "FormationPosition")
    private int formationPosition;
    @p9.c("FouledOut")
    private boolean fouledOut;
    @p9.c("ImportanceRank")
    private float importanceRank;
    @p9.c("InjuryTypeImgID")
    public String injuryTypeImgID;
    @p9.c("PBPEventKey")
    private String pbpEventKey;
    @p9.c(alternate = {"PlayerShortName"}, value = "PlayerName")
    private String playerName;
    @p9.c("SeasonStats")
    private SeasonStats seasonStats;
    @p9.c("Stats")
    private PlayerStatObj[] stat;
    @p9.c("Status")
    private int status;
    @p9.c("JerseyNum")
    private int jerseyNum = -1;
    @p9.c("PlayerSName")
    private String playerShortName = "";
    @p9.c(alternate = {"PositionId"}, value = "Position")
    private int position = -1;
    @p9.c("PopularityRank")
    private int popularityRank = -1;
    @p9.c("SubstitutedPlayer")
    private int substitutedPlayer = -1;
    @p9.c("SubstituteTime")
    private int subtituteTime = -1;
    @p9.c("SubstitutedPlayerNum")
    private int substitutedPlayerNum = -1;
    @p9.c("SubstituteType")
    private int subtituteType = -1;
    @p9.c("CurrBatter")
    boolean IsCurrBatter = false;
    @p9.c("CurrBowler")
    boolean IsCurrBowler = false;
    @p9.c("Ranking")
    double ranking = -1.0d;
    @p9.c(alternate = {"PlayerID"}, value = "PID")
    public int pId = -1;
    @p9.c("AthleteID")
    public int athleteId = -1;
    @p9.c("FieldPosition")
    public int fieldPosition = -1;
    @p9.c(alternate = {"FieldPositionLine"}, value = "FieldLine")
    public int fieldLine = -1;
    @p9.c(alternate = {"FieldPositionSide"}, value = "FieldSide")
    public int fieldSide = -1;
    @p9.c("CID")
    public int countryId = -1;
    @p9.c("SubstituteStatus")
    public int substituteStatus = -1;
    @p9.c("EventOrder")
    public int eventOrder = -1;
    @p9.c("SubstituteAddedTime")
    public int substituteAddedTime = 0;
    @p9.c("PlayerNum")
    public int playerNum = -1;
    @p9.c("Reason")
    public String reason = "";
    @p9.c("DidNotPlayedReason")
    public String didNotPlayedReason = "";
    @p9.c("DueDate")
    public String dueDate = "";
    @p9.c("HeatMap")
    public String heatMap = "";
    @p9.c("Description")
    private String description = "";
    @p9.c("SuspensionType")
    private int suspensionType = -1;
    @p9.c("SuspensionTypeImgID")
    private int suspensionTypeImgID = -1;
    @p9.c("InjuryCategory")
    private int injuryCategory = -1;
    @p9.c("Line")
    private int line = -1;
    @p9.c("Doubtful")
    private boolean doubtful = false;
    @p9.c("HasStats")
    private boolean hasStats = false;
    @p9.c("HasShotChart")
    private boolean hasShotChart = false;
    @p9.c("DidNotPlayed")
    private boolean didNotPlayed = false;
    @p9.c("CompetitorNum")
    public int competitorNum = -1;
    @p9.c(alternate = {"CompetitorId"}, value = "CompetitorID")
    public int competitorId = -1;
    @p9.c("ImgVer")
    private int imgVer = -1;
    @p9.c("ExpectedReturn")
    private String expectedReturn = "";
    @p9.c("IsInjured")
    public boolean isInjured = false;
    @p9.c("IsSuspended")
    public boolean isSuspended = false;
    @p9.c("Rating")
    private int rating = 1;
    @p9.c("GameId")
    public int gameId = -1;
    @p9.c("DisplayText")
    private String displayText = "";

    /* loaded from: classes2.dex */
    public enum ePlayerStatus {
        NONE(0),
        LINEUP(1),
        SUBSTITUTE(2),
        INJURED(3),
        MANAGEMENT(4),
        SUSPENDED(5);
        
        private int value;

        ePlayerStatus(int i10) {
            this.value = i10;
        }

        public static ePlayerStatus create(int i10) {
            if (i10 != 0 && i10 != 1) {
                return i10 != 3 ? i10 != 4 ? i10 != 5 ? SUBSTITUTE : SUSPENDED : MANAGEMENT : INJURED;
            }
            return LINEUP;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static String getInjuryIconLink(int i10, String str, int i11) {
        if (i11 <= 0 || str == null) {
            return null;
        }
        try {
            if (str.isEmpty()) {
                return null;
            }
            return o.m(p.Injuries, str, Integer.valueOf(i10), Integer.valueOf(i10), false, false, true, 1, p.InjuriesCategories, String.valueOf(i11), String.valueOf(-1), false, false);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public static int getRankingBG(double d10) {
        if (d10 != -1.0d) {
            if (d10 <= 4.9d) {
                return R.drawable.f21788p5;
            }
            if (d10 <= 4.9d || d10 >= 6.0d) {
                if (d10 < 6.0d || d10 >= 7.0d) {
                    if (d10 >= 7.0d) {
                        return R.drawable.H0;
                    }
                    return -1;
                }
                return R.drawable.V6;
            }
            return R.drawable.T4;
        }
        return R.drawable.F0;
    }

    public static String getSuspensionIconLink(int i10, int i11, int i12) {
        try {
            p pVar = x0.n1() ? p.SuspensionsLight : p.SuspensionsDark;
            return o.m(pVar, String.valueOf(i11), Integer.valueOf(i10), Integer.valueOf(i10), false, false, true, 1, pVar, String.valueOf(i12), String.valueOf(-1), false, false);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public static int getTopRankingBG() {
        return R.drawable.f21862z;
    }

    public boolean IsBatter() {
        return this.IsCurrBatter;
    }

    public boolean IsBowler() {
        return this.IsCurrBowler;
    }

    public eAthleteInjuryCategory getAthleteInjuryCategory() {
        return eAthleteInjuryCategory.create(this.injuryCategory);
    }

    public BetLine[] getBetLines() {
        return this.betLines;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDidNotPlayedReason() {
        return this.didNotPlayedReason;
    }

    public String getDisplayText() {
        return this.displayText;
    }

    public String getExpectedReturn() {
        return this.expectedReturn;
    }

    public int getFieldPosition() {
        return this.fieldPosition;
    }

    public int getFormationPosition() {
        return this.formationPosition;
    }

    public String getFormationPositionName(int i10) {
        try {
            return getFormationPosition() != 0 ? App.l().getSportTypes().get(Integer.valueOf(i10)).formationPositions.get(Integer.valueOf(getFormationPosition())).name : getPositionName(i10);
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public String getFormationPositionShortName(int i10) {
        try {
            return getFormationPosition() != 0 ? App.l().getSportTypes().get(Integer.valueOf(i10)).formationPositions.get(Integer.valueOf(getFormationPosition())).shortName : getPositionName(i10);
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public String getHeatMap() {
        return this.heatMap;
    }

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public float getImportanceRank() {
        return this.importanceRank;
    }

    public String getInjuryIconLink(int i10) {
        try {
            return getInjuryIconLink(i10, this.injuryTypeImgID, getAthleteInjuryCategory().getValue());
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public int getJerseyNum() {
        return this.jerseyNum;
    }

    public String getPbpEventKey() {
        return this.pbpEventKey;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public int getPopularityRank() {
        return this.popularityRank;
    }

    public int getPosition() {
        return this.position;
    }

    public int getPositionLine() {
        return this.line;
    }

    public String getPositionName(int i10) {
        try {
            return App.l().getSportTypes().get(Integer.valueOf(i10)).athletePositions.get(Integer.valueOf(getPosition())) != null ? App.l().getSportTypes().get(Integer.valueOf(i10)).athletePositions.get(Integer.valueOf(getPosition())).getPositionName() : "";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public int getRankingBG() {
        return getRankingBG(this.ranking);
    }

    public double getRankingToDisplay() {
        return Math.round(this.ranking * 10.0d) / 10.0d;
    }

    public int getRating() {
        return this.rating;
    }

    public SeasonStats getSeasonStats() {
        return this.seasonStats;
    }

    public String getShortName() {
        String str = this.playerShortName;
        return (str == null || str.isEmpty()) ? "" : this.playerShortName;
    }

    public String getShortNameForTopPerformer() {
        String str = this.playerShortName;
        return (str == null || str.isEmpty()) ? getShortNameFromFullName() : this.playerShortName;
    }

    public String getShortNameFromFullName() {
        String str = this.playerName;
        if (str != null && !str.isEmpty()) {
            String[] split = this.playerName.split(" ");
            if (split.length > 0) {
                return split[split.length - 1];
            }
        }
        return "";
    }

    public String getShortNameWithFallback() {
        String str = this.playerShortName;
        return (str == null || str.isEmpty()) ? this.playerName : this.playerShortName;
    }

    public PlayerStatObj[] getStat() {
        return this.stat;
    }

    public ePlayerStatus getStatus() {
        return ePlayerStatus.create(this.status);
    }

    public int getSubstitutedPlayer() {
        return this.substitutedPlayerNum;
    }

    public int getSubtituteTime() {
        return this.subtituteTime;
    }

    public int getSubtituteType() {
        return this.subtituteType;
    }

    public String getSuspensionIconLink(int i10) {
        try {
            return getSuspensionIconLink(i10, this.suspensionTypeImgID, this.suspensionType);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public SuspensionObj.ESoccerSuspensionTypes getSuspensionType() {
        return SuspensionObj.ESoccerSuspensionTypes.getValue(this.suspensionType);
    }

    public boolean isDidNotPlayed() {
        return this.didNotPlayed;
    }

    public boolean isDoubtful() {
        return this.doubtful;
    }

    public boolean isEjected() {
        return this.ejected;
    }

    public boolean isFouledOut() {
        return this.fouledOut;
    }

    public boolean isHasShotChart() {
        return this.hasShotChart;
    }

    public boolean isHasStats() {
        return this.hasStats;
    }

    public void removeJerseyNumber() {
        this.jerseyNum = 0;
    }
}
