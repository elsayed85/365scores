package com.scores365.entitys;
/* compiled from: LastMatchHeaderCategory.kt */
/* loaded from: classes2.dex */
public final class LastMatchHeaderCategory extends BaseObj {
    @p9.c("Subject")
    private String subject = "";
    @p9.c("OrderLevel")
    private int orederLevel = -1;

    public final int getOrederLevel() {
        return this.orederLevel;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final void setOrederLevel(int i10) {
        this.orederLevel = i10;
    }

    public final void setSubject(String str) {
        this.subject = str;
    }
}
