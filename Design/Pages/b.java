package com.scores365.Design.Pages;

import com.scores365.entitys.eDashboardSection;
/* compiled from: BasePageCreator.java */
/* loaded from: classes2.dex */
public abstract class b {
    public String iconLink;
    public boolean isIconLocalResource;
    public String pageKey;
    public sc.i placement;
    public String title;
    public boolean isReversed = false;
    protected boolean isClickBlocked = false;

    public b(String str, String str2, sc.i iVar, boolean z10, String str3) {
        this.title = str;
        this.iconLink = str2;
        this.placement = iVar;
        this.isIconLocalResource = z10;
        this.pageKey = str3;
    }

    public abstract a CreatePage();

    public eDashboardSection getDashboardSection() {
        return null;
    }

    public void setClickBlocked(boolean z10) {
        this.isClickBlocked = z10;
    }

    public Object updateData(Object obj) {
        return null;
    }
}
