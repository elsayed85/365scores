package com.scores365.tapbarMonetization.monetizationEntities;

import di.l;
import java.io.Serializable;
import p9.c;
/* loaded from: classes2.dex */
public class BaseMonetizationWorldCupObject implements Serializable {
    @c("image")
    private String imageLink;
    @c("link")
    private String link;
    l.b objectType;
    @c("Sponsored")
    private boolean openInBrowser;
    @c("Title")
    private String title;
    @c("Type")
    private String typeString;

    public BaseMonetizationWorldCupObject(String str, String str2, String str3, boolean z10, l.b bVar) {
        this.title = str;
        this.imageLink = str2;
        this.link = str3;
        this.openInBrowser = z10;
        this.objectType = bVar;
    }

    public String getImageLink() {
        return this.imageLink;
    }

    public String getLink() {
        return this.link;
    }

    public l.b getObjectType() {
        return this.objectType;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTypeString() {
        return this.typeString;
    }

    public boolean isOpenInBrowser() {
        return this.openInBrowser;
    }

    public void setImageLink(String str) {
        this.imageLink = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setObjectType(l.b bVar) {
        this.objectType = bVar;
    }

    public void setOpenInBrowser(boolean z10) {
        this.openInBrowser = z10;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTypeString(String str) {
        this.typeString = str;
    }
}
