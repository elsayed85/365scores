package com.scores365.entitys;
/* compiled from: FacebookReferralDataObj.kt */
/* loaded from: classes2.dex */
public final class FacebookReferralDataObj {
    @p9.c("is_instagram")
    private final boolean isInstagram;
    @p9.c("ad_id")
    private final long adId = -1;
    @p9.c("ad_objective_name")
    private final String adObjectiveName = "";
    @p9.c("adgroup_id")
    private final long adGroupId = -1;
    @p9.c("adgroup_name")
    private final String adGroupName = "";
    @p9.c("campaign_id")
    private final long campaignId = -1;
    @p9.c("campaign_name")
    private final String campaignName = "";
    @p9.c("campaign_group_id")
    private final long campaignGroupId = -1;
    @p9.c("campaign_group_name")
    private final String campaignGroupName = "";
    @p9.c("account_id")
    private final long accountId = -1;
    @p9.c("publisher_platform")
    private final String publisherPlatform = "";

    public final long getAccountId() {
        return this.accountId;
    }

    public final long getAdGroupId() {
        return this.adGroupId;
    }

    public final String getAdGroupName() {
        return this.adGroupName;
    }

    public final long getAdId() {
        return this.adId;
    }

    public final String getAdObjectiveName() {
        return this.adObjectiveName;
    }

    public final long getCampaignGroupId() {
        return this.campaignGroupId;
    }

    public final String getCampaignGroupName() {
        return this.campaignGroupName;
    }

    public final long getCampaignId() {
        return this.campaignId;
    }

    public final String getCampaignName() {
        return this.campaignName;
    }

    public final String getPublisherPlatform() {
        return this.publisherPlatform;
    }

    public final boolean isInstagram() {
        return this.isInstagram;
    }

    public String toString() {
        return "FacebookReferralDataObj(adId=" + this.adId + ", adObjectiveName='" + this.adObjectiveName + "', adGroupId=" + this.adGroupId + ", adGroupName='" + this.adGroupName + "', campaignId=" + this.campaignId + ", campaignName='" + this.campaignName + "', campaignGroupId=" + this.campaignGroupId + ", campaignGroupName='" + this.campaignGroupName + "', accountId=" + this.accountId + ", isInstagram=" + this.isInstagram + ", publisherPlatform='" + this.publisherPlatform + "')";
    }
}
