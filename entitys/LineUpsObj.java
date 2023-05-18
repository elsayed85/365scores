package com.scores365.entitys;

import com.scores365.entitys.ScoreBoxObjects.ScoreBoxPlayersStatistics;
import com.scores365.ui.playerCard.SinglePlayerProfilePage;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: LineUpsObj.kt */
/* loaded from: classes2.dex */
public final class LineUpsObj implements Serializable {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 7435272151719204105L;
    @p9.c("HasRankings")
    private boolean HasRankings;
    private PlayerObj coach;
    @p9.c("CompNum")
    private int compNum;
    @p9.c("CompetitionStatsId")
    private int competitionStatsId = -1;
    @p9.c("DoubtfulTitle")
    private final String doubtfulTitle = "";
    @p9.c("Formation")
    private String formation;
    @p9.c("HasFieldPositions")
    private boolean hasFieldPosition;
    @p9.c("HasPlayerStats")
    private boolean hasPlayerStats;
    @p9.c("Players")
    private PlayerObj[] players;
    @p9.c("PlayersStatistics")
    private final ScoreBoxPlayersStatistics playersStatistics;
    @p9.c("Competitors")
    private final HashMap<Integer, CompObj> relatedCompetitors;
    @p9.c("ShowCompetitionStatsName")
    private boolean showCompetitionStatsName;
    @p9.c("Status")
    private String status;

    /* compiled from: LineUpsObj.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final PlayerObj getCoach() {
        return this.coach;
    }

    public final int getCompNum() {
        return this.compNum;
    }

    public final int getCompetitionStatsId() {
        return this.competitionStatsId;
    }

    public final CompObj getCompetitorById(int i10) {
        if (this.relatedCompetitors != null) {
            if (this.relatedCompetitors.containsKey(Integer.valueOf(i10))) {
                return this.relatedCompetitors.get(Integer.valueOf(i10));
            }
        }
        return null;
    }

    public final String getDoubtfulTitle() {
        return this.doubtfulTitle;
    }

    public final String getFormation() {
        return this.formation;
    }

    public final boolean getHasFieldPosition() {
        return this.hasFieldPosition;
    }

    public final boolean getHasPlayerStats() {
        return this.hasPlayerStats;
    }

    public final boolean getHasRankings() {
        return this.HasRankings;
    }

    public final PlayerObj[] getPlayers() {
        return this.players;
    }

    public final ScoreBoxPlayersStatistics getPlayersStatistics() {
        return this.playersStatistics;
    }

    public final HashMap<Integer, CompObj> getRelatedCompetitors() {
        return this.relatedCompetitors;
    }

    public final boolean getShowCompetitionStatsName() {
        return this.showCompetitionStatsName;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void initializeCoach(int i10) {
        if (this.coach == null) {
            PlayerObj[] playerObjArr = this.players;
            PlayerObj playerObj = null;
            if (playerObjArr != null) {
                int length = playerObjArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    PlayerObj playerObj2 = playerObjArr[i11];
                    if (SinglePlayerProfilePage.isCoach(playerObj2.getPosition(), SportTypesEnum.create(i10))) {
                        playerObj = playerObj2;
                        break;
                    }
                    i11++;
                }
            }
            this.coach = playerObj;
        }
    }

    public final boolean isHasPlayerStats() {
        return this.hasPlayerStats;
    }

    public final boolean isHasRankings() {
        return this.HasRankings;
    }

    public final void setCoach(PlayerObj playerObj) {
        this.coach = playerObj;
    }

    public final void setCompNum(int i10) {
        this.compNum = i10;
    }

    public final void setCompetitionStatsId(int i10) {
        this.competitionStatsId = i10;
    }

    public final void setFormation(String str) {
        this.formation = str;
    }

    public final void setHasFieldPosition(boolean z10) {
        this.hasFieldPosition = z10;
    }

    public final void setHasPlayerStats(boolean z10) {
        this.hasPlayerStats = z10;
    }

    public final void setHasRankings(boolean z10) {
        this.HasRankings = z10;
    }

    public final void setPlayers(PlayerObj[] playerObjArr) {
        this.players = playerObjArr;
    }

    public final void setShowCompetitionStatsName(boolean z10) {
        this.showCompetitionStatsName = z10;
    }

    public final void setStatus(String str) {
        this.status = str;
    }
}
