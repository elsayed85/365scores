package com.scores365.entitys;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class TipPurchaseProof implements Serializable {
    @p9.c("ProductID")
    public String productId = "";
    @p9.c("Token")
    public String token = "";

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Proof{productId='");
        sb2.append(this.productId);
        sb2.append('\'');
        sb2.append(", hasToken='");
        sb2.append(!TextUtils.isEmpty(this.token));
        sb2.append('\'');
        sb2.append('}');
        return sb2.toString();
    }
}
