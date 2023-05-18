package com.scores365.entitys;

import androidx.annotation.NonNull;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class TipPurchaseObj implements Serializable {
    @p9.c("PurchaseID")
    public String purchaseId;
    @p9.c("Metadata")
    public TipMetadataObj tipMetadata;
    @p9.c("Transaction")
    public TipTransactionObj tipTransaction;

    @NonNull
    public String toString() {
        return "Item{id='" + this.purchaseId + "', transaction=" + this.tipTransaction + ", data=" + this.tipMetadata + '}';
    }
}
