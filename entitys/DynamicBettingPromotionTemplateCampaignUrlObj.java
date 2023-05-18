package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
/* compiled from: DynamicBettingPromotionTemplateCampaignUrlObj.kt */
/* loaded from: classes2.dex */
public final class DynamicBettingPromotionTemplateCampaignUrlObj implements Serializable {
    @p9.c("Network")
    private String network = "";
    @p9.c("Campaigns")
    private ArrayList<DynamicBettingPromotionTemplateCampaignObj> campaigns = new ArrayList<>();

    public final ArrayList<DynamicBettingPromotionTemplateCampaignObj> getCampaigns() {
        return this.campaigns;
    }

    public final String getNetwork() {
        return this.network;
    }

    public final void setCampaigns(ArrayList<DynamicBettingPromotionTemplateCampaignObj> arrayList) {
        m.g(arrayList, "<set-?>");
        this.campaigns = arrayList;
    }

    public final void setNetwork(String str) {
        m.g(str, "<set-?>");
        this.network = str;
    }
}
