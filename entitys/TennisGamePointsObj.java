package com.scores365.entitys;

import j$.util.Comparator$CC;
import j$.util.function.ToIntFunction;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes2.dex */
public class TennisGamePointsObj extends BaseObj {
    @p9.c("HasBreak")
    private boolean hasBreak;
    @p9.c("IsCurrent")
    public boolean isCurrent;
    private ArrayList<TennisPointObj> orderedPoints = null;
    @p9.c("Points")
    private ArrayList<TennisPointObj> points;
    @p9.c("Score")
    private int[] score;
    @p9.c("ServingPlayer")
    private int servingPlayer;
    @p9.c("Winner")
    private int winner;

    public ArrayList<TennisPointObj> getOrderedPoints() {
        if (this.orderedPoints == null) {
            ArrayList<TennisPointObj> arrayList = new ArrayList<>(this.points);
            this.orderedPoints = arrayList;
            Collections.sort(arrayList, Comparator$CC.comparingInt(new ToIntFunction() { // from class: com.scores365.entitys.d
                @Override // j$.util.function.ToIntFunction
                public final int applyAsInt(Object obj) {
                    int i10;
                    i10 = ((TennisPointObj) obj).pointNum;
                    return i10;
                }
            }));
        }
        return this.orderedPoints;
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
