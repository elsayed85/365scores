package com.scores365.entitys;
/* loaded from: classes2.dex */
public class PromotedRadioObj extends BaseObj {
    @p9.c("StreamURL")
    protected String StreamUrl;
    @p9.c("Active")
    protected boolean active = false;
    @p9.c("AdPreRoll")
    protected String adPreRoll;
    @p9.c("CountryID")
    protected int countryId;
    @p9.c("SName")
    protected String sName;
    @p9.c("Website")
    protected String website;

    public String getAdPreRoll() {
        return this.adPreRoll;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public String getSName() {
        return this.sName;
    }

    public String getStreamUrl() {
        return this.StreamUrl;
    }

    public String getWebsite() {
        return this.website;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean z10) {
        this.active = z10;
    }
}
