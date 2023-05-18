package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import li.x0;
/* loaded from: classes2.dex */
public class GroupObj implements Serializable {
    private static final long serialVersionUID = -6376194455416515449L;
    @p9.c("ScoreIsAggregated")
    public boolean aggregated;
    @p9.c("Games")
    private GroupGameObj[] futureGames;
    @p9.c("GroupBy")
    public boolean groupBy;
    @p9.c("HasTbl")
    private boolean hasTbl;
    @p9.c("HomeAwayTeamOrder")
    public int homeAwayTeamOrder;
    @p9.c("Expanded")
    public boolean isExpanded;
    @p9.c("Name")
    private String name;
    @p9.c("Num")
    private int num;
    @p9.c("Participants")
    private ParticipantObj[] participants;
    @p9.c("Series")
    public boolean series;
    @p9.c("Score")
    private int[] seriesScore;
    @p9.c("UseName")
    private boolean useName;
    @p9.c("WinDescription")
    private String winDescription;
    @p9.c("SName")
    private String sName = "";
    @p9.c("DestStage")
    public int destinationStage = -1;
    @p9.c("DestGroup")
    public int destinationGroup = -1;
    @p9.c("GamesCount")
    public int gamesCount = -1;
    @p9.c("LiveCount")
    public int liveCount = -1;
    @p9.c("ToQualify")
    public int toQualify = 0;
    @p9.c("PenaltiesScore")
    private ArrayList<Integer> penaltiesScore = new ArrayList<>();
    @p9.c("ShowGames")
    public boolean showGames = false;

    public boolean areAllGamesFinished() {
        boolean z10 = false;
        try {
            for (GroupGameObj groupGameObj : this.futureGames) {
                GameObj gameObj = groupGameObj.gameObj;
                if (gameObj == null || !gameObj.isFinished()) {
                    z10 = true;
                    break;
                }
            }
            return !z10;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public String getAggregateScore(int i10, int i11, int i12) {
        try {
            if (this.seriesScore != null) {
                StringBuilder sb2 = new StringBuilder();
                boolean l10 = x0.l(i12, true);
                if (l10) {
                    sb2.append(this.seriesScore[1]);
                    sb2.append(" - ");
                    sb2.append(this.seriesScore[0]);
                } else {
                    sb2.append(this.seriesScore[0]);
                    sb2.append(" - ");
                    sb2.append(this.seriesScore[1]);
                }
                if (i11 > 0) {
                    if (l10 ^ (i11 == 2)) {
                        sb2.append("*");
                    } else {
                        sb2.insert(0, "*");
                    }
                }
                return sb2.toString();
            }
            return "";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public int getAwayPenaltyScore() {
        ArrayList<Integer> arrayList = this.penaltiesScore;
        if (arrayList == null || arrayList.isEmpty() || this.penaltiesScore.get(1) == null) {
            return -1;
        }
        return this.penaltiesScore.get(1).intValue();
    }

    public GroupGameObj[] getFutureGames() {
        GroupGameObj[] groupGameObjArr;
        GroupGameObj[] groupGameObjArr2 = null;
        try {
            groupGameObjArr = this.futureGames;
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (groupGameObjArr != null) {
            return groupGameObjArr;
        }
        groupGameObjArr2 = new GroupGameObj[]{new GroupGameObj(1, false, null, -1, null, null, null, null)};
        return groupGameObjArr2;
    }

    public boolean getHasTable() {
        return this.hasTbl;
    }

    public String getHomeAndAwayScore(int i10, String str, int i11) {
        try {
            if (this.seriesScore != null) {
                StringBuilder sb2 = new StringBuilder();
                if (x0.l(i11, true)) {
                    sb2.append(this.seriesScore[1]);
                    sb2.append("-");
                    sb2.append(this.seriesScore[0]);
                } else {
                    sb2.append(this.seriesScore[0]);
                    sb2.append("-");
                    sb2.append(this.seriesScore[1]);
                }
                return sb2.toString();
            }
            return str;
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public int getHomePenaltyScore() {
        ArrayList<Integer> arrayList = this.penaltiesScore;
        if (arrayList == null || arrayList.isEmpty() || this.penaltiesScore.get(0) == null) {
            return -1;
        }
        return this.penaltiesScore.get(0).intValue();
    }

    public String getName() {
        return this.name;
    }

    public int getNum() {
        return this.num;
    }

    public ParticipantObj[] getParticipants() {
        return this.participants;
    }

    public ArrayList<Integer> getPenaltiesScore() {
        return this.penaltiesScore;
    }

    public int[] getScores() {
        try {
            int[] iArr = this.seriesScore;
            if (iArr != null) {
                if (iArr.length > 1) {
                    return iArr;
                }
                return null;
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public String getSerieScore(int i10) {
        try {
            if (this.seriesScore != null) {
                StringBuilder sb2 = new StringBuilder();
                if (x0.l(i10, true)) {
                    sb2.append(this.seriesScore[1]);
                    sb2.append(" - ");
                    sb2.append(this.seriesScore[0]);
                } else {
                    sb2.append(this.seriesScore[0]);
                    sb2.append(" - ");
                    sb2.append(this.seriesScore[1]);
                }
                return sb2.toString();
            }
            return "";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public int[] getSeriesScore() {
        return this.seriesScore;
    }

    public String getShortName() {
        String str;
        Exception e10;
        try {
            str = this.name;
        } catch (Exception e11) {
            str = "";
            e10 = e11;
        }
        try {
            String str2 = this.sName;
            return (str2 == null || str2 == "") ? str : str2;
        } catch (Exception e12) {
            e10 = e12;
            x0.N1(e10);
            return str;
        }
    }

    public boolean getUseName() {
        return this.useName;
    }

    public String getWinDescription() {
        return this.winDescription;
    }

    public boolean hasAggregateScoreInsideGame() {
        GroupGameObj[] groupGameObjArr;
        try {
            for (GroupGameObj groupGameObj : this.futureGames) {
                GameObj gameObj = groupGameObj.gameObj;
                if (gameObj != null && gameObj.getAggregatedScore() != null && !groupGameObj.gameObj.getAggregatedScore().isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean hasSeriesScoreInsideGame() {
        GroupGameObj[] groupGameObjArr;
        try {
            for (GroupGameObj groupGameObj : this.futureGames) {
                GameObj gameObj = groupGameObj.gameObj;
                if (gameObj != null && gameObj.getSeriesScore() != null && !groupGameObj.gameObj.getSeriesScore().isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isAggregated() {
        return this.aggregated;
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }
}
