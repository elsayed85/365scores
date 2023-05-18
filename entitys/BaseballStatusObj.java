package com.scores365.entitys;
/* compiled from: BaseballStatusObj.kt */
/* loaded from: classes2.dex */
public final class BaseballStatusObj extends BaseObj {
    @p9.c("BasesLoadDescription")
    private final String basesLoadDescription;
    @p9.c("InningDescription")
    private final String inningDescription;
    @p9.c("InningDivision")
    private final String inningDivision;
    @p9.c("LoadedBases")
    private final int[] loadedBases;
    @p9.c("Balls")
    private final int balls = -1;
    @p9.c("Strikes")
    private final int strikes = -1;
    @p9.c("Outs")
    private final int outs = -1;
    @p9.c("InningNumber")
    private final int inningNumber = -1;

    public final int getBalls() {
        return this.balls;
    }

    public final String getBasesLoadDescription() {
        return this.basesLoadDescription;
    }

    public final String getInningDescription() {
        return this.inningDescription;
    }

    public final String getInningDivision() {
        return this.inningDivision;
    }

    public final int getInningNumber() {
        return this.inningNumber;
    }

    public final int[] getLoadedBases() {
        return this.loadedBases;
    }

    public final int getOuts() {
        return this.outs;
    }

    public final int getStrikes() {
        return this.strikes;
    }
}
