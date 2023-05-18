package com.scores365.entitys;

import java.util.ArrayList;
import kotlin.jvm.internal.m;
/* compiled from: DynamicBettingPromotionTemplateButtonObj.kt */
/* loaded from: classes2.dex */
public final class DynamicBettingPromotionTemplateButtonObj {
    @p9.c("BG_FILL")
    private boolean bgFill;
    @p9.c("TEXT_TERM")
    private String textTerm = "";
    @p9.c("BG_COLORS")
    private ArrayList<String> bgColors = new ArrayList<>();
    @p9.c("TEXT_COLOR")
    private ArrayList<String> textColor = new ArrayList<>();

    public final ArrayList<String> getBgColors() {
        return this.bgColors;
    }

    public final boolean getBgFill() {
        return this.bgFill;
    }

    public final ArrayList<String> getTextColor() {
        return this.textColor;
    }

    public final String getTextTerm() {
        return this.textTerm;
    }

    public final void setBgColors(ArrayList<String> arrayList) {
        m.g(arrayList, "<set-?>");
        this.bgColors = arrayList;
    }

    public final void setBgFill(boolean z10) {
        this.bgFill = z10;
    }

    public final void setTextColor(ArrayList<String> arrayList) {
        m.g(arrayList, "<set-?>");
        this.textColor = arrayList;
    }

    public final void setTextTerm(String str) {
        m.g(str, "<set-?>");
        this.textTerm = str;
    }
}
