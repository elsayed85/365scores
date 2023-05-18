package com.scores365.entitys;

import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
/* compiled from: DynamicBettingPromotionTemplateObj.kt */
/* loaded from: classes2.dex */
public final class DynamicBettingPromotionTemplateObj {
    @p9.c("Distribution")
    private DynamicBettingPromotionTemplateDistributionObj distribution;
    @p9.c("Offer")
    private DynamicBettingPromotionTemplateOfferObj offerObj;
    @p9.c("Title")
    private DynamicBettingPromotionTemplateTitleObj titleObj;
    @p9.c("Buttons")
    private ArrayList<DynamicBettingPromotionTemplateButtonObj> buttons = new ArrayList<>();
    @p9.c("BPROMOTION_DEFAULT_URL")
    private String bPromotionDefaultUrl = "";
    @p9.c("BPROMOTION_CAMPAIGN_URL")
    private ArrayList<DynamicBettingPromotionTemplateCampaignUrlObj> bPromotionCampaignUrl = new ArrayList<>();
    @p9.c("BG_IMAGE_URL")
    private String bgImageUrl = "";
    @p9.c("PROMOTION_VERSION_NAME")
    private String promotionVersionName = "";
    @p9.c("BPClock")
    private String bpClock = "0";
    @p9.c("BPClockDisplay")
    private String bpClockDisplay = AppEventsConstants.EVENT_PARAM_VALUE_YES;

    public final ArrayList<DynamicBettingPromotionTemplateCampaignUrlObj> getBPromotionCampaignUrl() {
        return this.bPromotionCampaignUrl;
    }

    public final String getBPromotionDefaultUrl() {
        return this.bPromotionDefaultUrl;
    }

    public final String getBgImageUrl() {
        return this.bgImageUrl;
    }

    public final String getBpClock() {
        return this.bpClock;
    }

    public final String getBpClockDisplay() {
        return this.bpClockDisplay;
    }

    public final ArrayList<DynamicBettingPromotionTemplateButtonObj> getButtons() {
        return this.buttons;
    }

    public final DynamicBettingPromotionTemplateDistributionObj getDistribution() {
        return this.distribution;
    }

    public final DynamicBettingPromotionTemplateOfferObj getOfferObj() {
        return this.offerObj;
    }

    public final String getPromotionVersionName() {
        return this.promotionVersionName;
    }

    public final DynamicBettingPromotionTemplateTitleObj getTitleObj() {
        return this.titleObj;
    }

    public final void setBPromotionCampaignUrl(ArrayList<DynamicBettingPromotionTemplateCampaignUrlObj> arrayList) {
        m.g(arrayList, "<set-?>");
        this.bPromotionCampaignUrl = arrayList;
    }

    public final void setBPromotionDefaultUrl(String str) {
        m.g(str, "<set-?>");
        this.bPromotionDefaultUrl = str;
    }

    public final void setBgImageUrl(String str) {
        m.g(str, "<set-?>");
        this.bgImageUrl = str;
    }

    public final void setBpClock(String str) {
        m.g(str, "<set-?>");
        this.bpClock = str;
    }

    public final void setBpClockDisplay(String str) {
        m.g(str, "<set-?>");
        this.bpClockDisplay = str;
    }

    public final void setButtons(ArrayList<DynamicBettingPromotionTemplateButtonObj> arrayList) {
        m.g(arrayList, "<set-?>");
        this.buttons = arrayList;
    }

    public final void setDistribution(DynamicBettingPromotionTemplateDistributionObj dynamicBettingPromotionTemplateDistributionObj) {
        this.distribution = dynamicBettingPromotionTemplateDistributionObj;
    }

    public final void setOfferObj(DynamicBettingPromotionTemplateOfferObj dynamicBettingPromotionTemplateOfferObj) {
        this.offerObj = dynamicBettingPromotionTemplateOfferObj;
    }

    public final void setPromotionVersionName(String str) {
        m.g(str, "<set-?>");
        this.promotionVersionName = str;
    }

    public final void setTitleObj(DynamicBettingPromotionTemplateTitleObj dynamicBettingPromotionTemplateTitleObj) {
        this.titleObj = dynamicBettingPromotionTemplateTitleObj;
    }

    public String toString() {
        return "BpTmpl(dist=" + this.distribution + ", title=" + this.titleObj + ", defUrl='" + this.bPromotionDefaultUrl + "', url=" + this.bPromotionCampaignUrl + ", image='" + this.bgImageUrl + "', versionName='" + this.promotionVersionName + "')";
    }
}
