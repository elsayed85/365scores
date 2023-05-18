package com.scores365.entitys;

import li.x0;
/* loaded from: classes2.dex */
public class StatisticType extends BaseObj {
    @p9.c("Extra")
    private boolean Extra;
    @p9.c("Visible")
    private boolean Visible;
    @p9.c("Category")
    private int category = -1;
    @p9.c("Father")
    private int father;
    @p9.c("HideStatName")
    private boolean hideStatName;
    @p9.c("ImageId")
    private int imageId;
    @p9.c("IsExtendedStats")
    private boolean isExtendedStats;
    @p9.c("Major")
    public boolean major;
    @p9.c("Order")
    public int order;
    @p9.c("PersonalStatsOrder")
    private int personalStatsOrder;
    @p9.c("Primary")
    public boolean primary;
    @p9.c("SName")
    private String sname;
    @p9.c("SubCategory")
    private int subCategory;
    @p9.c("TopPlayerStat")
    private boolean topPlayerStat;

    public int getCategory() {
        return this.category;
    }

    public boolean getExtra() {
        return this.Extra;
    }

    public int getFather() {
        return this.father;
    }

    public int getImageId() {
        return this.imageId;
    }

    public int getPersonalStatsOrder() {
        return this.personalStatsOrder;
    }

    public String getShortName() {
        String str = this.name;
        try {
            String str2 = this.sname;
            return (str2 == null || str2.isEmpty()) ? str : this.sname;
        } catch (Exception e10) {
            x0.N1(e10);
            return str;
        }
    }

    public int getSubCategory() {
        return this.subCategory;
    }

    public boolean getVisible() {
        return this.Visible;
    }

    public boolean isExtendedStats() {
        return this.isExtendedStats;
    }

    public boolean isHideStatName() {
        return this.hideStatName;
    }

    public boolean isTopPlayerStat() {
        return this.topPlayerStat;
    }
}
