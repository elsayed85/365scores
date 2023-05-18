package com.scores365.ui.playerCard;

import com.scores365.entitys.ScoreBoxObjects.ScoreBoxRowsObj;
/* loaded from: classes2.dex */
public class StatsRowObj extends ScoreBoxRowsObj {
    @p9.c("EntityId")
    private int entityId = -1;
    @p9.c("Title")
    private String title = "";
    @p9.c("SecondaryTitle")
    private String secondaryTitle = "";

    public int getEntityId() {
        return this.entityId;
    }

    @Override // com.scores365.entitys.ScoreBoxObjects.ScoreBoxRowsObj, com.scores365.entitys.BaseObj
    public int getID() {
        return -1;
    }

    public String getSecondaryTitle() {
        return this.secondaryTitle;
    }

    public String getTitle() {
        return this.title;
    }
}
