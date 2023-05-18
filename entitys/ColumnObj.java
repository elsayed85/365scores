package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ColumnObj implements Serializable {
    @p9.c("DisplayName")
    private String displayName;
    private int itemWidth = -1;
    @p9.c("MemberName")
    private String memberName;
    @p9.c("OnlyExpanded")
    private boolean onlyExpanded;

    public ColumnObj() {
    }

    public ColumnObj(String str, String str2, boolean z10) {
        this.memberName = str;
        this.displayName = str2;
        this.onlyExpanded = z10;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getItemWidth() {
        return this.itemWidth;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public boolean getOnlyExpanded() {
        return this.onlyExpanded;
    }

    public boolean isDisplayed() {
        return true;
    }

    public void setItemWidth(int i10) {
        this.itemWidth = i10;
    }
}
