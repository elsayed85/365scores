package com.scores365.entitys;

import androidx.annotation.NonNull;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class TipBalanceObj implements Serializable {
    @p9.c("Tip")
    private int tips = 0;
    @p9.c("FreeTip")
    private int freeTip = 0;

    public int getFreeTipCount() {
        return this.freeTip;
    }

    public int getTipCount() {
        return this.tips;
    }

    public boolean shouldUseRefundData() {
        return this.freeTip == 0 && this.tips > 0;
    }

    @NonNull
    public String toString() {
        return "Balance{free=" + this.freeTip + ", amount=" + this.tips + '}';
    }
}
