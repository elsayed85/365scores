package com.scores365.entitys;
/* loaded from: classes2.dex */
public class TennisPointObj extends BaseObj {
    @p9.c("HasBreak")
    private boolean hasBreak;
    @p9.c("ImportantPoint")
    private TennisImportantPointObj importantPoint;
    @p9.c("PointNum")
    public int pointNum;
    @p9.c("Score")
    private int[] score;
    @p9.c("ServingPlayer")
    private int servingPlayer;
    @p9.c("Winner")
    private int winner;

    public TennisImportantPointObj getImportantPoint() {
        return this.importantPoint;
    }

    public int[] getScore() {
        return this.score;
    }

    public int getServingPlayer() {
        return this.servingPlayer;
    }

    public int getWinner() {
        return this.winner;
    }

    public boolean isHasBreak() {
        return this.hasBreak;
    }
}
