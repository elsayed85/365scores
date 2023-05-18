package com.scores365.entitys.oddsPreviewEntities;

import java.io.Serializable;
import java.util.ArrayList;
import p9.c;
/* compiled from: OddsPreview.kt */
/* loaded from: classes2.dex */
public final class OddsPreview implements Serializable {
    @c("GameID")
    private int gameId = -1;
    @c("Cells")
    private ArrayList<OddsPreviewCell> oddsPreviewCell;

    public final int getGameId() {
        return this.gameId;
    }

    public final ArrayList<OddsPreviewCell> getOddsPreviewCell() {
        return this.oddsPreviewCell;
    }

    public final void setGameId(int i10) {
        this.gameId = i10;
    }

    public final void setOddsPreviewCell(ArrayList<OddsPreviewCell> arrayList) {
        this.oddsPreviewCell = arrayList;
    }
}
