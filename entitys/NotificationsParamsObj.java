package com.scores365.entitys;

import androidx.annotation.NonNull;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class NotificationsParamsObj implements Serializable {
    @p9.c("Key")
    public String mKey;
    @p9.c("Val")
    public String mValue;

    public String GetParam(String str) {
        try {
            return this.mKey.equals(str) ? this.mValue : "";
        } catch (Exception unused) {
            return "";
        }
    }

    @NonNull
    public String toString() {
        return "Params{" + this.mKey + ',' + this.mValue + 125;
    }
}
