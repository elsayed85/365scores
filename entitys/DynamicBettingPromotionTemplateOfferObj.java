package com.scores365.entitys;

import java.util.ArrayList;
import kotlin.jvm.internal.m;
/* compiled from: DynamicBettingPromotionTemplateOfferObj.kt */
/* loaded from: classes2.dex */
public final class DynamicBettingPromotionTemplateOfferObj {
    @p9.c("OFFER_TERM")
    private String offerTerm = "";
    @p9.c("OFFER_COLOR")
    private ArrayList<String> offerColor = new ArrayList<>();
    @p9.c("OFFER_BOLD_COLOR")
    private ArrayList<String> offerBoldColor = new ArrayList<>();

    public final ArrayList<String> getOfferBoldColor() {
        return this.offerBoldColor;
    }

    public final ArrayList<String> getOfferColor() {
        return this.offerColor;
    }

    public final String getOfferTerm() {
        return this.offerTerm;
    }

    public final void setOfferBoldColor(ArrayList<String> arrayList) {
        m.g(arrayList, "<set-?>");
        this.offerBoldColor = arrayList;
    }

    public final void setOfferColor(ArrayList<String> arrayList) {
        m.g(arrayList, "<set-?>");
        this.offerColor = arrayList;
    }

    public final void setOfferTerm(String str) {
        m.g(str, "<set-?>");
        this.offerTerm = str;
    }

    public String toString() {
        return this.offerTerm;
    }
}
