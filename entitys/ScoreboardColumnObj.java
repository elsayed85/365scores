package com.scores365.entitys;

import kotlin.jvm.internal.m;
/* compiled from: ScoreboardColumnObj.kt */
/* loaded from: classes2.dex */
public final class ScoreboardColumnObj extends BaseObj {
    @p9.c("Active")
    private boolean active;
    @p9.c("ExtraScores")
    private int[] extraScores;
    @p9.c("Main")
    private boolean main;
    @p9.c("Scores")
    private String[] scores;
    @p9.c("SName")
    private String sName = "";
    @p9.c("Winner")
    private int winner = -1;
    @p9.c("Time")
    private String time = "";

    public final boolean getActive() {
        return this.active;
    }

    public final int[] getExtraScores() {
        return this.extraScores;
    }

    public final boolean getMain() {
        return this.main;
    }

    public final String getSName() {
        if (this.sName.length() == 0) {
            String name = this.name;
            m.f(name, "name");
            return name;
        }
        return this.sName;
    }

    public final String[] getScores() {
        return this.scores;
    }

    public final String getTime() {
        return this.time;
    }

    public final int getWinner() {
        return this.winner;
    }

    public final void setActive(boolean z10) {
        this.active = z10;
    }

    public final void setExtraScores(int[] iArr) {
        this.extraScores = iArr;
    }

    public final void setMain(boolean z10) {
        this.main = z10;
    }

    public final void setSName(String str) {
        m.g(str, "<set-?>");
        this.sName = str;
    }

    public final void setScores(String[] strArr) {
        this.scores = strArr;
    }

    public final void setTime(String str) {
        m.g(str, "<set-?>");
        this.time = str;
    }

    public final void setWinner(int i10) {
        this.winner = i10;
    }
}
