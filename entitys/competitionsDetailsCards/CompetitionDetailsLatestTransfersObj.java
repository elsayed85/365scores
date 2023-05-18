package com.scores365.entitys.competitionsDetailsCards;

import com.scores365.entitys.TransferObj;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.m;
import p9.c;
import se.g;
/* compiled from: CompetitionDetailsLatestTransfersObj.kt */
/* loaded from: classes2.dex */
public final class CompetitionDetailsLatestTransfersObj extends CompetitionDetailsBaseCardObj {
    @c("Transfers")
    private final LinkedHashMap<Integer, TransferObj> transfers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompetitionDetailsLatestTransfersObj(LinkedHashMap<Integer, TransferObj> transfers) {
        super(0, 1, null);
        m.g(transfers, "transfers");
        this.transfers = transfers;
    }

    @Override // com.scores365.entitys.competitionsDetailsCards.CompetitionDetailsBaseCardObj, se.e
    public g getCardType() {
        return g.LatestTransfers;
    }

    public final LinkedHashMap<Integer, TransferObj> getTransfers() {
        return this.transfers;
    }
}
