package com.scores365.entitys.ScoreBoxObjects;

import com.scores365.entitys.BaseObj;
import p9.c;
/* compiled from: ScoreBoxExtraDataEntryParamObj.kt */
/* loaded from: classes2.dex */
public final class ScoreBoxExtraDataEntryParamObj extends BaseObj {
    @c("Key")
    private String key;
    @c("Value")
    private String value;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String, java.lang.Integer] */
    @Override // com.scores365.entitys.BaseObj, com.scores365.entitys.IGsonEntity
    public final Integer getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
