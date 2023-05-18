package com.scores365.entitys;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SetObj extends BaseObj {
    @p9.c("PointsByPointGames")
    private ArrayList<TennisGamePointsObj> pointByPointObjs;
    @p9.c("Tiebreak")
    private TennisGamePointsObj tieBreakObjs;

    public ArrayList<TennisGamePointsObj> getPointByPointObjs() {
        return this.pointByPointObjs;
    }

    public TennisGamePointsObj getTieBreakObj() {
        return this.tieBreakObjs;
    }
}
