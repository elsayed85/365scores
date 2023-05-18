package com.scores365.entitys.allScoresCategories;

import com.scores365.entitys.BaseObj;
import p9.c;
/* compiled from: AllScoresCategory.kt */
/* loaded from: classes2.dex */
public final class AllScoresCategory extends BaseObj {
    @c("Type")
    private final int type = 1;
    @c("ImgCat")
    private final String imageCategory = "";
    @c("ImgVer")
    private final int imageVersion = -1;
    @c("Param")
    private final String parameter = "";

    public final String getImageCategory() {
        return this.imageCategory;
    }

    public final int getImageVersion() {
        return this.imageVersion;
    }

    public final String getParameter() {
        return this.parameter;
    }

    public final AllScoresCategoryTypeEnum getTypeEnum() {
        int i10 = this.type;
        return i10 != 2 ? i10 != 3 ? AllScoresCategoryTypeEnum.SPORT_TYPE : AllScoresCategoryTypeEnum.TV_SCHEDULE : AllScoresCategoryTypeEnum.FILTER;
    }
}
