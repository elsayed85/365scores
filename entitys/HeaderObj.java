package com.scores365.entitys;

import java.io.Serializable;
import li.x0;
/* loaded from: classes2.dex */
public class HeaderObj implements Serializable {
    @p9.c("DescriptionText")
    protected String descriptionText;
    @p9.c("HasLogo")
    protected boolean hasLogo;
    @p9.c("HasTexture")
    protected boolean hasTexture;
    @p9.c("Entity")
    protected HeaderEntityObj headerEntityObj;
    @p9.c("MainColor")
    protected String mainColor;
    @p9.c("SecondaryColor")
    protected String secondaryColor;
    @p9.c("SecondaryTextColor")
    protected String secondaryTextColor;
    @p9.c("TextColor")
    protected String textColor;
    @p9.c("TextureCompetition")
    protected int textureCompetitionId;

    public HeaderObj() {
        this.mainColor = "";
        this.secondaryColor = "";
        this.textColor = "";
        this.secondaryTextColor = "";
        this.descriptionText = "";
    }

    public HeaderObj(String str, String str2, String str3, HeaderEntityObj headerEntityObj, boolean z10, boolean z11) {
        this.secondaryTextColor = "";
        this.descriptionText = "";
        this.mainColor = str;
        this.secondaryColor = str2;
        this.textColor = str3;
        this.headerEntityObj = headerEntityObj;
        this.hasLogo = z10;
        this.hasTexture = z11;
    }

    public String getDescriptionText() {
        return this.descriptionText;
    }

    public String getEntityImageVersion() {
        try {
            return getHeaderEntityObj() != null ? getHeaderEntityObj().getEntityImageVersion() : String.valueOf(-1);
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public HeaderEntityObj getHeaderEntityObj() {
        return this.headerEntityObj;
    }

    public String getMainColor() {
        return this.mainColor;
    }

    public String getSecondaryColor() {
        return this.secondaryColor;
    }

    public String getSecondaryTextColor() {
        return this.secondaryTextColor;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public int getTextureCompetition() {
        return this.textureCompetitionId;
    }

    public boolean isHasLogo() {
        return this.hasLogo;
    }

    public boolean isHasTexture() {
        return this.hasTexture;
    }
}
