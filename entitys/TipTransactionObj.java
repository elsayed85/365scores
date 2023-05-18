package com.scores365.entitys;

import androidx.annotation.NonNull;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class TipTransactionObj implements Serializable {
    @p9.c("PurchaseProof")
    private TipPurchaseProof purchaseProof;
    @p9.c("Store")
    private String store;

    public TipPurchaseProof getPurchaseProof() {
        return this.purchaseProof;
    }

    @NonNull
    public String toString() {
        return "Transaction{store='" + this.store + "', p=" + this.purchaseProof + '}';
    }
}
