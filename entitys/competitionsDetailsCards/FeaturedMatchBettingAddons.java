package com.scores365.entitys.competitionsDetailsCards;

import java.io.Serializable;
import kotlin.jvm.internal.m;
import p9.c;
/* compiled from: FeaturedMatchBettingAddons.kt */
/* loaded from: classes2.dex */
public final class FeaturedMatchBettingAddons implements Serializable {
    @c("BookmakerId")
    private final int bookmakerId;
    @c("PredictionTextHtml")
    private final String predictionTextHtml;
    @c("ReferralLink")
    private final String referralLink;
    @c("ReferralLinkTextHtml")
    private final String referralLinkTextHtml;
    @c("SportifierGameId")
    private final int sportifierGameId;

    public FeaturedMatchBettingAddons(int i10, String predictionTextHtml, String referralLinkTextHtml, String referralLink, int i11) {
        m.g(predictionTextHtml, "predictionTextHtml");
        m.g(referralLinkTextHtml, "referralLinkTextHtml");
        m.g(referralLink, "referralLink");
        this.sportifierGameId = i10;
        this.predictionTextHtml = predictionTextHtml;
        this.referralLinkTextHtml = referralLinkTextHtml;
        this.referralLink = referralLink;
        this.bookmakerId = i11;
    }

    public static /* synthetic */ FeaturedMatchBettingAddons copy$default(FeaturedMatchBettingAddons featuredMatchBettingAddons, int i10, String str, String str2, String str3, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = featuredMatchBettingAddons.sportifierGameId;
        }
        if ((i12 & 2) != 0) {
            str = featuredMatchBettingAddons.predictionTextHtml;
        }
        String str4 = str;
        if ((i12 & 4) != 0) {
            str2 = featuredMatchBettingAddons.referralLinkTextHtml;
        }
        String str5 = str2;
        if ((i12 & 8) != 0) {
            str3 = featuredMatchBettingAddons.referralLink;
        }
        String str6 = str3;
        if ((i12 & 16) != 0) {
            i11 = featuredMatchBettingAddons.bookmakerId;
        }
        return featuredMatchBettingAddons.copy(i10, str4, str5, str6, i11);
    }

    public final int component1() {
        return this.sportifierGameId;
    }

    public final String component2() {
        return this.predictionTextHtml;
    }

    public final String component3() {
        return this.referralLinkTextHtml;
    }

    public final String component4() {
        return this.referralLink;
    }

    public final int component5() {
        return this.bookmakerId;
    }

    public final FeaturedMatchBettingAddons copy(int i10, String predictionTextHtml, String referralLinkTextHtml, String referralLink, int i11) {
        m.g(predictionTextHtml, "predictionTextHtml");
        m.g(referralLinkTextHtml, "referralLinkTextHtml");
        m.g(referralLink, "referralLink");
        return new FeaturedMatchBettingAddons(i10, predictionTextHtml, referralLinkTextHtml, referralLink, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FeaturedMatchBettingAddons) {
            FeaturedMatchBettingAddons featuredMatchBettingAddons = (FeaturedMatchBettingAddons) obj;
            return this.sportifierGameId == featuredMatchBettingAddons.sportifierGameId && m.b(this.predictionTextHtml, featuredMatchBettingAddons.predictionTextHtml) && m.b(this.referralLinkTextHtml, featuredMatchBettingAddons.referralLinkTextHtml) && m.b(this.referralLink, featuredMatchBettingAddons.referralLink) && this.bookmakerId == featuredMatchBettingAddons.bookmakerId;
        }
        return false;
    }

    public final int getBookmakerId() {
        return this.bookmakerId;
    }

    public final String getPredictionTextHtml() {
        return this.predictionTextHtml;
    }

    public final String getReferralLink() {
        return this.referralLink;
    }

    public final String getReferralLinkTextHtml() {
        return this.referralLinkTextHtml;
    }

    public final int getSportifierGameId() {
        return this.sportifierGameId;
    }

    public int hashCode() {
        return (((((((this.sportifierGameId * 31) + this.predictionTextHtml.hashCode()) * 31) + this.referralLinkTextHtml.hashCode()) * 31) + this.referralLink.hashCode()) * 31) + this.bookmakerId;
    }

    public String toString() {
        return "FeaturedMatchBettingAddons(sportifierGameId=" + this.sportifierGameId + ", predictionTextHtml=" + this.predictionTextHtml + ", referralLinkTextHtml=" + this.referralLinkTextHtml + ", referralLink=" + this.referralLink + ", bookmakerId=" + this.bookmakerId + ')';
    }
}
