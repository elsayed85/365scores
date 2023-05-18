package com.scores365.entitys;
/* loaded from: classes2.dex */
public class VideoSources implements IGsonEntity<Integer> {
    @p9.c("AndroidSupport")
    public boolean androidSupport;
    @p9.c("IPhoneSupport")
    public boolean iPhoneSupport;
    @p9.c("MobileSupport")
    public boolean mobileSupport;
    @p9.c("AliasName")
    public String videoSourceAliasName;
    @p9.c("HTML5Embed")
    public String videoSourceHtaml5Embed;
    @p9.c("ID")
    public int videoSourceId;
    @p9.c("ThumbnailURL")
    public String videoSourceLogoUrl;
    @p9.c("Name")
    public String videoSourceName;
    @p9.c("URL")
    public String videoSourceUrl;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.IGsonEntity
    public Integer getKey() {
        return Integer.valueOf(this.videoSourceId);
    }
}
