package com.scores365.entitys;

import com.google.android.gms.common.api.CommonStatusCodes;
/* loaded from: classes2.dex */
public enum eDashboardSection {
    SCORES(1),
    NEWS(2),
    HIGHLIGHTS(3),
    SOCIAL(4),
    STANDINGS(7),
    GROUPS(8),
    SINGLE_SQUAD(9),
    SQUADS(10),
    TOP_SCORER(11),
    TRANSFERS(12),
    STATS(15),
    KNOCKOUT(14),
    MEDALS(16),
    COMPETITION_DETAILS(20),
    HISTORY_AND_TEAMS(21),
    OUTRIGHT(22),
    BUZZ(100),
    SPECIAL_FIFTH(123),
    ALL_SCORES(124);
    
    private String name;
    private int value;

    eDashboardSection(int i10) {
        this.value = i10;
    }

    public static eDashboardSection create(int i10) {
        eDashboardSection edashboardsection = null;
        try {
            if (i10 == 1) {
                edashboardsection = SCORES;
                edashboardsection.name = "scores";
            } else if (i10 == 100) {
                edashboardsection = BUZZ;
                edashboardsection.name = "buzz";
            } else if (i10 == 3) {
                edashboardsection = HIGHLIGHTS;
                edashboardsection.name = "highlights";
            } else if (i10 == 4) {
                edashboardsection = SOCIAL;
                edashboardsection.name = "social";
            } else if (i10 == 14) {
                edashboardsection = KNOCKOUT;
                edashboardsection.name = "knockout";
            } else if (i10 == 15) {
                edashboardsection = STATS;
                edashboardsection.name = "stats";
            } else if (i10 == 123) {
                edashboardsection = SPECIAL_FIFTH;
                edashboardsection.name = "promotion";
            } else if (i10 != 124) {
                switch (i10) {
                    case 7:
                        edashboardsection = STANDINGS;
                        edashboardsection.name = "standings";
                        break;
                    case 8:
                        edashboardsection = GROUPS;
                        edashboardsection.name = "groups";
                        break;
                    case 9:
                        edashboardsection = SINGLE_SQUAD;
                        edashboardsection.name = "single_squad";
                        break;
                    case 10:
                        edashboardsection = SQUADS;
                        edashboardsection.name = "squads";
                        break;
                    case 11:
                        edashboardsection = TOP_SCORER;
                        edashboardsection.name = "top_score";
                        break;
                    case 12:
                        edashboardsection = TRANSFERS;
                        edashboardsection.name = "transfers";
                        break;
                    default:
                        switch (i10) {
                            case 20:
                                edashboardsection = COMPETITION_DETAILS;
                                edashboardsection.name = "competition_details";
                                break;
                            case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                                edashboardsection = HISTORY_AND_TEAMS;
                                edashboardsection.name = "history or teams";
                                break;
                            case 22:
                                edashboardsection = OUTRIGHT;
                                edashboardsection.name = "outright";
                                break;
                            default:
                                edashboardsection = NEWS;
                                edashboardsection.name = "news";
                                break;
                        }
                }
            } else {
                edashboardsection = ALL_SCORES;
                edashboardsection.name = "allscores";
            }
        } catch (Exception unused) {
        }
        return edashboardsection;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }
}
