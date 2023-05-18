package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class TabObj implements Serializable {
    @p9.c("SectionId")
    public int sectionID;
    @p9.c("Name")
    public String tabName;
    @p9.c("Type")
    public tabTypeEnum tabType;
    @p9.c("Url")
    public String tabURL;

    /* loaded from: classes2.dex */
    public enum tabTypeEnum {
        WebView,
        News
    }

    public TabObj(String str, String str2, String str3, int i10) {
        this.tabName = str;
        this.tabURL = str2;
        this.sectionID = i10;
        getTabTypeEnum(str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (r2.equals("News") == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getTabTypeEnum(java.lang.String r2) {
        /*
            r1 = this;
            r2.hashCode()
            java.lang.String r0 = "WebView"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L14
            java.lang.String r0 = "News"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L18
            goto L1c
        L14:
            com.scores365.entitys.TabObj$tabTypeEnum r2 = com.scores365.entitys.TabObj.tabTypeEnum.WebView
            r1.tabType = r2
        L18:
            com.scores365.entitys.TabObj$tabTypeEnum r2 = com.scores365.entitys.TabObj.tabTypeEnum.News
            r1.tabType = r2
        L1c:
            com.scores365.entitys.TabObj$tabTypeEnum r2 = com.scores365.entitys.TabObj.tabTypeEnum.WebView
            r1.tabType = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.entitys.TabObj.getTabTypeEnum(java.lang.String):void");
    }
}
