package com.scores365.entitys;
/* loaded from: classes2.dex */
public class StageTimeObj extends BaseObj {
    @p9.c("Minutes")
    public int minutes;
    @p9.c("StageID")
    public int stageId;
    @p9.c("Time")
    public String time;

    @Override // com.scores365.entitys.BaseObj
    public int getID() {
        return this.stageId;
    }
}
