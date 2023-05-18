package com.scores365.entitys;

import com.facebook.appevents.codeless.internal.Constants;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.scores365.ui.SyncOldConfigurationActivity;
import java.io.Serializable;
import java.util.HashMap;
import li.x0;
/* loaded from: classes2.dex */
public class TableRowObj implements Serializable {
    private static final long serialVersionUID = -4926539448785934668L;
    public HashMap<String, String> valuesDictionary;
    @p9.c("Competitor")
    public CompObj competitor = null;
    @p9.c("Position")
    public int position = -1;
    @p9.c("GamePlayed")
    public int gameplayed = -1;
    @p9.c("GamesWon")
    public int gameswon = -1;
    @p9.c("GamesLost")
    public int gameslost = -1;
    @p9.c("GamesEven")
    public int gameseven = -1;
    @p9.c("For")
    public int For = -1;
    @p9.c("Against")
    public int against = -1;
    @p9.c("Ratio")
    public int ratio = -1;
    @p9.c("Points")
    public int points = -1;
    @p9.c("Group")
    public int group = -1;
    @p9.c("GamesBehind")
    public String gamesbehind = "";
    @p9.c("Trend")
    public int trend = 0;
    @p9.c("Destination")
    public int destination = 0;
    @p9.c("OriginalGamePlayed")
    public int originalGamesPlayed = -1;
    @p9.c("OriginalGamesWon")
    public int originalGamesWon = -1;
    @p9.c("OriginalGamesLost")
    public int originalGamesLost = -1;
    @p9.c("OriginalAgainst")
    public int originalGamesAgainst = -1;
    @p9.c("OriginalFor")
    public int originalFor = -1;
    @p9.c("OriginalRatio")
    public int originalRatio = -1;
    @p9.c("OriginalPoints")
    public int originalPoints = -1;
    @p9.c("OriginalPosition")
    public int originalPosition = -1;
    @p9.c("LiveGameID")
    public int liveGameId = -1;
    @p9.c("Goals")
    public String Goals = "";
    @p9.c("Pct")
    public String pct = "";
    @p9.c("Strike")
    public String strike = "";
    @p9.c("GamesWonOnOT")
    public String otWins = "";
    @p9.c("GamesLossOnOT")
    public String otLoss = "";
    @p9.c("GamesWonOnPen")
    public String penWins = "";
    @p9.c("GamesLossOnPen")
    public String penLoss = "";
    @p9.c("GamesOT")
    public String GamesOT = "";
    @p9.c("TableWinner")
    public boolean tableWinner = false;
    @p9.c("DestinationGuaranteed")
    public boolean destinationGuaranteed = false;
    @p9.c("HomeRecord")
    public String homeRecord = "";
    @p9.c("AwayRecord")
    public String awayRecord = "";
    @p9.c("GroupRecord")
    public String groupRecord = "";
    @p9.c("FatherGroupRecord")
    public String fatherGroupRecord = "";
    @p9.c("Ppg")
    public float ppg = -1.0f;
    @p9.c("Oppg")
    public float oppg = -1.0f;
    @p9.c("Diff")
    public String diff = "";
    @p9.c("LastX")
    public String lastX = "";
    @p9.c("FormattedStrike")
    public String formattedStrike = "";

    /* renamed from: com.scores365.entitys.TableRowObj$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers;

        static {
            int[] iArr = new int[eTableRowMembers.values().length];
            $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers = iArr;
            try {
                iArr[eTableRowMembers.GamePlayed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.Strike.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.GamesLossOnOT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.GamesWonOnOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.GamesLossOnPen.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.GamesWonOnPen.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.Against.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.Competitor.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.Destination.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.For.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.GamesEven.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.GamesLost.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.GamesWon.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.Goals.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.Group.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.Points.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.Position.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.GamesBehind.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.Ratio.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.Pct.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.Trend.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.OriginalAgainst.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.OriginalFor.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.OriginalGamePlayed.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.OriginalGamesWon.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.OriginalGamesLost.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.OriginalPoints.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.OriginalPosition.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.OriginalRatio.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.GamesOT.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.HomeRecord.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.AwayRecord.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.GroupRecord.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.FatherGroupRecord.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.Ppg.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.Oppg.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.Diff.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.LastX.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.FormattedStrike.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum eTableRowMembers {
        Competitor("Competitor"),
        Position("Position"),
        GamePlayed("GamePlayed"),
        GamesWon("GamesWon"),
        GamesLost("GamesLost"),
        GamesBehind("GamesBehind"),
        GamesEven("GamesEven"),
        For("For"),
        Against("Against"),
        Ratio("Ratio"),
        Points("Points"),
        Group("Group"),
        Destination("Destination"),
        Trend("Trend"),
        Goals("Goals"),
        Strike("Strike"),
        GamesWonOnOT("GamesWonOnOT"),
        GamesLossOnOT("GamesLossOnOT"),
        GamesWonOnPen("GamesWonOnPen"),
        GamesLossOnPen("GamesLossOnPen"),
        Pct("Pct"),
        OriginalGamePlayed("OriginalGamePlayed"),
        OriginalGamesWon("OriginalGamesWon"),
        OriginalGamesLost("OriginalGamesLost"),
        OriginalAgainst("OriginalAgainst"),
        OriginalFor("OriginalFor"),
        OriginalRatio("OriginalRatio"),
        OriginalPoints("OriginalPoints"),
        OriginalPosition("OriginalPosition"),
        GamesOT("GamesOT"),
        HomeRecord("HomeRecord"),
        AwayRecord("AwayRecord"),
        GroupRecord("GroupRecord"),
        FatherGroupRecord("FatherGroupRecord"),
        Ppg("Ppg"),
        Oppg("Oppg"),
        Diff("Diff"),
        LastX("LastX"),
        FormattedStrike("FormattedStrike");
        
        private final String member;

        eTableRowMembers(String str) {
            this.member = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.member;
        }
    }

    public String getColValue(String str) {
        String valueOf;
        try {
            switch (AnonymousClass1.$SwitchMap$com$scores365$entitys$TableRowObj$eTableRowMembers[eTableRowMembers.valueOf(str).ordinal()]) {
                case 1:
                    valueOf = String.valueOf(this.gameplayed);
                    break;
                case 2:
                    valueOf = String.valueOf(this.strike);
                    break;
                case 3:
                    valueOf = String.valueOf(this.otLoss);
                    break;
                case 4:
                    valueOf = String.valueOf(this.otWins);
                    break;
                case 5:
                    valueOf = String.valueOf(this.penLoss);
                    break;
                case 6:
                    valueOf = String.valueOf(this.penWins);
                    break;
                case 7:
                    valueOf = String.valueOf(this.against);
                    break;
                case 8:
                    valueOf = String.valueOf(this.competitor);
                    break;
                case 9:
                    valueOf = String.valueOf(this.destination);
                    break;
                case 10:
                    valueOf = String.valueOf(this.For);
                    break;
                case 11:
                    valueOf = String.valueOf(this.gameseven);
                    break;
                case 12:
                    valueOf = String.valueOf(this.gameslost);
                    break;
                case 13:
                    valueOf = String.valueOf(this.gameswon);
                    break;
                case 14:
                    valueOf = String.valueOf(this.Goals);
                    break;
                case 15:
                    valueOf = String.valueOf(this.group);
                    break;
                case 16:
                    valueOf = String.valueOf(this.points);
                    break;
                case 17:
                    valueOf = String.valueOf(this.position);
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    valueOf = String.valueOf(this.gamesbehind);
                    break;
                case 19:
                    valueOf = String.valueOf(this.ratio);
                    break;
                case 20:
                    valueOf = String.valueOf(this.pct);
                    break;
                case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                    valueOf = String.valueOf(this.trend);
                    break;
                case 22:
                    valueOf = String.valueOf(this.originalGamesAgainst);
                    break;
                case ConnectionResult.API_DISABLED /* 23 */:
                    valueOf = String.valueOf(this.originalFor);
                    break;
                case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                    valueOf = String.valueOf(this.originalGamesPlayed);
                    break;
                case Constants.MAX_TREE_DEPTH /* 25 */:
                    valueOf = String.valueOf(this.originalGamesWon);
                    break;
                case 26:
                    valueOf = String.valueOf(this.originalGamesLost);
                    break;
                case 27:
                    valueOf = String.valueOf(this.originalPoints);
                    break;
                case 28:
                    valueOf = String.valueOf(this.originalPosition);
                    break;
                case 29:
                    valueOf = String.valueOf(this.originalRatio);
                    break;
                case 30:
                    valueOf = String.valueOf(this.GamesOT);
                    break;
                case 31:
                    valueOf = String.valueOf(this.homeRecord);
                    break;
                case 32:
                    valueOf = String.valueOf(this.awayRecord);
                    break;
                case 33:
                    valueOf = String.valueOf(this.groupRecord);
                    break;
                case SyncOldConfigurationActivity.PROCCES_RESULT_CANCEL /* 34 */:
                    valueOf = String.valueOf(this.fatherGroupRecord);
                    break;
                case 35:
                    valueOf = String.valueOf(this.ppg);
                    break;
                case 36:
                    valueOf = String.valueOf(this.oppg);
                    break;
                case 37:
                    valueOf = String.valueOf(this.diff);
                    break;
                case 38:
                    valueOf = String.valueOf(this.lastX);
                    break;
                case 39:
                    valueOf = String.valueOf(this.formattedStrike);
                    break;
                default:
                    return "";
            }
            return valueOf;
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }
}
