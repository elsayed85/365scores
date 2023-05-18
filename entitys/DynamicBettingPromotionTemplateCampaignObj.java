package com.scores365.entitys;

import java.io.Serializable;
import kotlin.jvm.internal.m;
/* compiled from: DynamicBettingPromotionTemplateCampaignObj.kt */
/* loaded from: classes2.dex */
public final class DynamicBettingPromotionTemplateCampaignObj implements Serializable {
    @p9.c("InstallMonth")
    private int installMonth = -1;
    @p9.c("InstallYear")
    private int installYear = -1;
    @p9.c("Campaign")
    private String campaign = "";
    @p9.c("URL")
    private String url = "";

    public final String getCampaign() {
        return this.campaign;
    }

    public final int getInstallMonth() {
        return this.installMonth;
    }

    public final int getInstallYear() {
        return this.installYear;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setCampaign(String str) {
        m.g(str, "<set-?>");
        this.campaign = str;
    }

    public final void setInstallMonth(int i10) {
        this.installMonth = i10;
    }

    public final void setInstallYear(int i10) {
        this.installYear = i10;
    }

    public final void setUrl(String str) {
        m.g(str, "<set-?>");
        this.url = str;
    }
}
