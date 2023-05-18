package com.scores365.entitys.oddsPreviewEntities;

import java.io.Serializable;
import p9.c;
/* compiled from: OddsPreviewCell.kt */
/* loaded from: classes2.dex */
public final class OddsPreviewCell implements Serializable {
    @c("IsBold")
    private boolean isBold;
    @c("Text")
    private String text;

    public final String getText() {
        return this.text;
    }

    public final boolean isBold() {
        return this.isBold;
    }

    public final void setBold(boolean z10) {
        this.isBold = z10;
    }

    public final void setText(String str) {
        this.text = str;
    }
}
