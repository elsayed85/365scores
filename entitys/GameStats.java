package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class GameStats implements Serializable {
    @p9.c("Game")
    private GameObj gameObj;
    @p9.c("MissedGames")
    private int gamesMissed;
    @p9.c("LastMatchPlayedDate")
    private String lastMatchPlayed;
    @p9.c("Played")
    private boolean played;
    @p9.c("DidNotPlayReason")
    private String reason;
    @p9.c("AthleteStats")
    protected ArrayList<AthleteStats> athleteStats = new ArrayList<>();
    @p9.c("InjuryCategory")
    protected int injuryCategory = -1;
    @p9.c("InjuryTypeImgID")
    public String injuryTypeImgID = "";
    @p9.c("SuspensionType")
    protected int suspensionType = -1;
    @p9.c("SuspensionTypeImgID")
    private int suspensionTypeImgID = -1;
    @p9.c("HasStats")
    protected boolean hasStats = false;
    @p9.c("RelatedCompetitor")
    protected int relatedCompetitor = -1;

    public ArrayList<AthleteStats> getAthleteStats() {
        return this.athleteStats;
    }

    public GameObj getGameObj() {
        return this.gameObj;
    }

    public int getGamesMissed() {
        return this.gamesMissed;
    }

    public int getInjuryCategory() {
        return this.injuryCategory;
    }

    public String getInjuryTypeImgID() {
        return this.injuryTypeImgID;
    }

    public String getLastMatchPlayed() {
        return this.lastMatchPlayed;
    }

    public String getReason() {
        return this.reason;
    }

    public int getRelatedCompetitor() {
        return this.relatedCompetitor;
    }

    public int getSuspensionType() {
        return this.suspensionType;
    }

    public int getSuspensionTypeImgID() {
        return this.suspensionTypeImgID;
    }

    public boolean hasStats() {
        return this.hasStats;
    }

    public boolean isPlayed() {
        return this.played;
    }
}
