package com.scores365.entitys;
/* loaded from: classes2.dex */
public class EventTypeObj extends BaseObj {
    @p9.c("SportTypeID")
    private int sportTypeId;
    @p9.c("SubTypes")
    private SubTypeObj[] subTypes;
    @p9.c("Major")
    public boolean Major = false;
    @p9.c("IsScoring")
    public boolean isScoring = false;
    @p9.c("ImgVer")
    private int imgVer = -1;
    public int EventNum = -1;

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public int getSportTypeID() {
        return this.sportTypeId;
    }

    public SubTypeObj[] getSubTypes() {
        return this.subTypes;
    }
}
