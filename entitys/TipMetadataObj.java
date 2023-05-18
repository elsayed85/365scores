package com.scores365.entitys;

import androidx.annotation.NonNull;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class TipMetadataObj implements Serializable {
    @p9.c("ProductType")
    public String purchaseType = "";
    @p9.c("EntityID")
    public int entityId = -1;

    @NonNull
    public String toString() {
        return "Data{type='" + this.purchaseType + "', entity=" + this.entityId + '}';
    }
}
