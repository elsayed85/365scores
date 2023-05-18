package com.scores365.entitys;

import com.scores365.R;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class ActiveVarEvent implements Serializable {
    public static final int TYPE_GOAL = 1;
    public static final int TYPE_PENALTY = 2;
    public static final int TYPE_REDCARD = 3;
    @p9.c("AddedTime")
    private int addedTime;
    @p9.c("AthleteID")
    private int athleteId;
    @p9.c("Comp")
    private int competitor;
    @p9.c("GT")
    private int gameTime;
    @p9.c("GTD")
    private String gameTimeToDisplay;
    @p9.c("Num")
    private int num;
    @p9.c("PID")
    private int playerId;
    @p9.c("Player")
    private String playerName;
    @p9.c("PlayerSName")
    private String playerShortName;
    @p9.c("Status")
    private int status;
    @p9.c("Type")
    private int type;

    public int getCompetitor() {
        return this.competitor;
    }

    public int getTypeIconResourse(boolean z10) {
        int i10 = this.type;
        if (i10 == 1) {
            return z10 ? R.drawable.L3 : R.drawable.K3;
        } else if (i10 == 2) {
            return z10 ? R.drawable.N3 : R.drawable.M3;
        } else if (i10 != 3) {
            return 0;
        } else {
            return z10 ? R.drawable.P3 : R.drawable.O3;
        }
    }
}
