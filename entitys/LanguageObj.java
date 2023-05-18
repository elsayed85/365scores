package com.scores365.entitys;

import li.x0;
/* loaded from: classes2.dex */
public class LanguageObj extends BaseObj {
    private static final long serialVersionUID = 959189623227024720L;
    @p9.c("AndroidLocale")
    private String AndroidLocale;
    @p9.c("CultureName")
    private String cultureName;
    @p9.c("Direction")
    private String direction;
    @p9.c("FB_Code")
    private String fbCode;
    @p9.c("FatherLang")
    private int FatherID = -1;
    @p9.c("Languages")
    private boolean isLangRTL = false;
    @p9.c("ImgVer")
    private int imgVer = -1;
    @p9.c("DidomiCode")
    private String didomiCode = "en";

    public String getAndroidLocale() {
        return this.AndroidLocale;
    }

    public String getCulture() {
        return this.cultureName;
    }

    public String getDidomiCode() {
        return this.didomiCode;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getFBCode() {
        return this.fbCode;
    }

    public int getFatherID() {
        int i10 = this.f23582id;
        try {
            int i11 = this.FatherID;
            return i11 != -1 ? i11 : i10;
        } catch (Exception unused) {
            return i10;
        }
    }

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public boolean getIsLangRTL() {
        try {
            String str = this.direction;
            if (str != null && str.equals("rtl")) {
                this.isLangRTL = true;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.isLangRTL;
    }
}
