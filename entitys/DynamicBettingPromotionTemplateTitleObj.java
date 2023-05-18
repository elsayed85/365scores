package com.scores365.entitys;

import java.util.ArrayList;
import kotlin.jvm.internal.m;
/* compiled from: DynamicBettingPromotionTemplateTitleObj.kt */
/* loaded from: classes2.dex */
public final class DynamicBettingPromotionTemplateTitleObj {
    @p9.c("TITLE_TERM")
    private String titleTerm = "";
    @p9.c("TITLE_COLOR")
    private ArrayList<String> titleColor = new ArrayList<>();
    @p9.c("TITLE_BOLD_COLOR")
    private ArrayList<String> titleBoldColor = new ArrayList<>();

    public final ArrayList<String> getTitleBoldColor() {
        return this.titleBoldColor;
    }

    public final ArrayList<String> getTitleColor() {
        return this.titleColor;
    }

    public final String getTitleTerm() {
        return this.titleTerm;
    }

    public final void setTitleBoldColor(ArrayList<String> arrayList) {
        m.g(arrayList, "<set-?>");
        this.titleBoldColor = arrayList;
    }

    public final void setTitleColor(ArrayList<String> arrayList) {
        m.g(arrayList, "<set-?>");
        this.titleColor = arrayList;
    }

    public final void setTitleTerm(String str) {
        m.g(str, "<set-?>");
        this.titleTerm = str;
    }

    public String toString() {
        return this.titleTerm;
    }
}
