package com.scores365.entitys.competitionsDetailsCards;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p9.c;
import se.e;
import se.g;
/* compiled from: CompetitionDetailsBaseCardObj.kt */
/* loaded from: classes2.dex */
public class CompetitionDetailsBaseCardObj implements Serializable, e {
    @c("CardOrder")
    private int order;

    public CompetitionDetailsBaseCardObj() {
        this(0, 1, null);
    }

    public CompetitionDetailsBaseCardObj(int i10) {
        this.order = i10;
    }

    public /* synthetic */ CompetitionDetailsBaseCardObj(int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : i10);
    }

    public int getCardOrder() {
        return this.order;
    }

    @Override // se.e
    public g getCardType() {
        return g.None;
    }

    public final int getOrder() {
        return this.order;
    }

    public final void setOrder(int i10) {
        this.order = i10;
    }
}
