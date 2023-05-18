package com.scores365.entitys;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PurchasesObj implements Serializable {
    @p9.c("OK")
    public boolean isDataOk;
    @p9.c("Purchases")
    private ArrayList<TipPurchaseObj> purchases;
    @p9.c("Balance")
    public TipBalanceObj tipBalance = new TipBalanceObj();

    public ArrayList<TipPurchaseObj> getActivePurchases() {
        return this.purchases;
    }

    @NonNull
    public String toString() {
        return "UserData{isOk=" + this.isDataOk + ", balance=" + this.tipBalance + ", items=" + this.purchases + '}';
    }
}
