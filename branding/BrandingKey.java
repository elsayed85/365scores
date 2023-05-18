package com.scores365.branding;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import java.io.Serializable;
import li.x0;
/* loaded from: classes2.dex */
public enum BrandingKey implements Serializable {
    worldCup("WorldCupSectionLogo"),
    worldCupRussiaQuiz("WorldCupRussiaQuiz"),
    worldCupMundialCafe("WorldCupMundialCafe"),
    newsStrip("NewsStrip"),
    groupsBackground("GroupsStageBG"),
    knockoutBackground("KnockoutOutStageBG"),
    gameCenterBackground("GameCenterBG"),
    gameCenterHeaderLogo("GameCenterLogo"),
    lineups("GameCenterLineupsStrip"),
    topScorers("TopScorer"),
    squadFirstItem("SquadItem"),
    gameDetailsLMTVideo("GameDetailsLMTVideo"),
    teamLeagueHeader("TeamLeagueHeader"),
    gameCenterPrematchFinished("GameCenterPrematchFinished"),
    knockoutFinalLogo("KnockoutFinalLogo"),
    dashboardHeader("DashboardHeader"),
    dashboardHeaderBG("DashboardHeaderBG"),
    gameDetailsVideo("GameDetailsVideo"),
    playByPlayItem("PlayByPlayItem"),
    playerCard("PlayerCard"),
    gameCenterStats("GameCenterStats"),
    MedalsBackground("MedalsBackground"),
    MedalsBanner("MedalsBanner");
    
    private String value;

    BrandingKey(String str) {
        this.value = str;
    }

    public static BrandingKey create(String str) {
        char c10;
        BrandingKey brandingKey;
        BrandingKey brandingKey2 = worldCup;
        try {
            switch (str.hashCode()) {
                case -2001324506:
                    if (str.equals("DashboardHeaderBG")) {
                        c10 = 16;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -2000981019:
                    if (str.equals("NewsStrip")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1695019076:
                    if (str.equals("WorldCupRussiaQuiz")) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1467658053:
                    if (str.equals("GameCenterPrematchFinished")) {
                        c10 = '\r';
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1309820743:
                    if (str.equals("TeamLeagueHeader")) {
                        c10 = '\f';
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1243776312:
                    if (str.equals("MedalsBanner")) {
                        c10 = 22;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -990375347:
                    if (str.equals("SquadItem")) {
                        c10 = '\n';
                        break;
                    }
                    c10 = 65535;
                    break;
                case -988348078:
                    if (str.equals("GameCenterLogo")) {
                        c10 = 7;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -968872369:
                    if (str.equals("KnockoutOutStageBG")) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -567411240:
                    if (str.equals("GameCenterStats")) {
                        c10 = 20;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -532871796:
                    if (str.equals("GameCenterBG")) {
                        c10 = 6;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -512737817:
                    if (str.equals("WorldCupMundialCafe")) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -456949992:
                    if (str.equals("GameDetailsLMTVideo")) {
                        c10 = 11;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -206172751:
                    if (str.equals("PlayerCard")) {
                        c10 = 19;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 35040338:
                    if (str.equals("PlayByPlayItem")) {
                        c10 = 18;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 780942151:
                    if (str.equals("KnockoutFinalLogo")) {
                        c10 = 14;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 802235082:
                    if (str.equals("MedalsBackground")) {
                        c10 = 21;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1048195617:
                    if (str.equals("DashboardHeader")) {
                        c10 = 15;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1056887947:
                    if (str.equals("GameDetailsVideo")) {
                        c10 = 17;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1113783087:
                    if (str.equals("GroupsStageBG")) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1309929819:
                    if (str.equals("GameCenterLineupsStrip")) {
                        c10 = '\b';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1364965668:
                    if (str.equals("WorldCupSectionLogo")) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1763331509:
                    if (str.equals("TopScorer")) {
                        c10 = '\t';
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                    return brandingKey2;
                case 1:
                    brandingKey = worldCupRussiaQuiz;
                    break;
                case 2:
                    brandingKey = worldCupMundialCafe;
                    break;
                case 3:
                    brandingKey = newsStrip;
                    break;
                case 4:
                    brandingKey = groupsBackground;
                    break;
                case 5:
                    brandingKey = knockoutBackground;
                    break;
                case 6:
                    brandingKey = gameCenterBackground;
                    break;
                case 7:
                    brandingKey = gameCenterHeaderLogo;
                    break;
                case '\b':
                    brandingKey = lineups;
                    break;
                case '\t':
                    brandingKey = topScorers;
                    break;
                case '\n':
                    brandingKey = squadFirstItem;
                    break;
                case 11:
                    brandingKey = gameDetailsLMTVideo;
                    break;
                case '\f':
                    brandingKey = teamLeagueHeader;
                    break;
                case '\r':
                    brandingKey = gameCenterPrematchFinished;
                    break;
                case 14:
                    brandingKey = knockoutFinalLogo;
                    break;
                case 15:
                    brandingKey = dashboardHeader;
                    break;
                case 16:
                    brandingKey = dashboardHeaderBG;
                    break;
                case 17:
                    brandingKey = gameDetailsVideo;
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    brandingKey = playByPlayItem;
                    break;
                case 19:
                    brandingKey = playerCard;
                    break;
                case 20:
                    brandingKey = gameCenterStats;
                    break;
                case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                    brandingKey = MedalsBackground;
                    break;
                case 22:
                    brandingKey = MedalsBanner;
                    break;
                default:
                    return brandingKey2;
            }
            return brandingKey;
        } catch (Exception e10) {
            x0.N1(e10);
            return brandingKey2;
        }
    }

    public String getValue() {
        return this.value;
    }
}
