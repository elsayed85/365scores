package com.scores365.entitys;
/* loaded from: classes2.dex */
public class SourceObj extends BaseObj {
    public static final int INSTAGRAM_SOURCE_ID = 1861;
    public static final int TWITTER_SOURCE_ID = 62;
    private static final long serialVersionUID = 241117862854810535L;
    @p9.c("SkipReadability")
    private boolean SkipReadability;
    @p9.c("CountryID")
    private int countryId;
    @p9.c("Description")
    private String description;
    @p9.c("ImgVer")
    private int imgVer = -1;
    @p9.c("LogoUrl")
    public String logoUrl;
    @p9.c("Lang")
    public int newsLang;
    @p9.c("URL")
    private String url;

    public boolean SkipReadability() {
        return this.SkipReadability;
    }

    public int getCountryID() {
        return this.countryId;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public String getLogoURL() {
        return this.logoUrl;
    }

    public String getURL() {
        return this.url;
    }
}
