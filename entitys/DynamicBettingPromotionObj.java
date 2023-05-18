package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
/* compiled from: DynamicBettingPromotionObj.kt */
/* loaded from: classes2.dex */
public final class DynamicBettingPromotionObj implements Serializable {
    @p9.c("Templates")
    private ArrayList<DynamicBettingPromotionTemplateObj> templates = new ArrayList<>();

    public final ArrayList<DynamicBettingPromotionTemplateObj> getTemplates() {
        return this.templates;
    }

    public final void setTemplates(ArrayList<DynamicBettingPromotionTemplateObj> arrayList) {
        m.g(arrayList, "<set-?>");
        this.templates = arrayList;
    }
}
