package com.scores365.tapbarMonetization.monetizationEntities;

import di.l;
import p9.c;
/* loaded from: classes2.dex */
public class NativeMonetizationWorldCupObject extends BaseMonetizationWorldCupObject {
    @c("bg_image")
    private String bgImage;
    @c("CTA")
    private String callToAction;
    @c("Description")
    private String description;

    public NativeMonetizationWorldCupObject(String str, String str2, String str3, boolean z10, l.b bVar, String str4, String str5, String str6) {
        super(str, str2, str3, z10, l.b.Native);
        this.description = str4;
        this.bgImage = str5;
        this.callToAction = str6;
    }

    public String getBgImage() {
        return this.bgImage;
    }

    public String getCallToAction() {
        return this.callToAction;
    }

    public String getDescription() {
        return this.description;
    }

    public void setBgImage(String str) {
        this.bgImage = str;
    }

    public void setCallToAction(String str) {
        this.callToAction = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    @Override // com.scores365.tapbarMonetization.monetizationEntities.BaseMonetizationWorldCupObject
    public void setTypeString(String str) {
        super.setTypeString("Native");
    }
}
