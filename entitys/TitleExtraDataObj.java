package com.scores365.entitys;

import java.io.Serializable;
import kotlin.jvm.internal.m;
/* compiled from: TitleExtraDataObj.kt */
/* loaded from: classes2.dex */
public final class TitleExtraDataObj implements Serializable {
    @p9.c("Text")
    private String text = "";
    @p9.c("Color")
    private String color = "";

    public final String getColor() {
        return this.color;
    }

    public final String getText() {
        return this.text;
    }

    public final void setColor(String str) {
        m.g(str, "<set-?>");
        this.color = str;
    }

    public final void setText(String str) {
        m.g(str, "<set-?>");
        this.text = str;
    }
}
