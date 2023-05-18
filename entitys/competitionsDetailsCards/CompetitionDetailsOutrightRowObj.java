package com.scores365.entitys.competitionsDetailsCards;

import com.scores365.entitys.BaseObj;
import java.util.LinkedHashMap;
import p9.c;
/* compiled from: CompetitionDetailsOutrightRowObj.kt */
/* loaded from: classes2.dex */
public final class CompetitionDetailsOutrightRowObj extends BaseObj {
    @c("BettingAddon")
    private final BettingAddonObj bettingAddon;
    @c("ColumnValues")
    private final LinkedHashMap<Integer, CompetitionDetailsOutrightColumnValueObj> columnValues;
    @c("SecondaryName")
    private final String secondaryName = "";
    @c("EntityID")
    private final long entityID = -1;
    @c("ImgVer")
    private final int imgVer = -1;
    @c("DetailsRequest")
    private final String detailsRequest = "";

    public final BettingAddonObj getBettingAddon() {
        return this.bettingAddon;
    }

    public final LinkedHashMap<Integer, CompetitionDetailsOutrightColumnValueObj> getColumnValues() {
        return this.columnValues;
    }

    public final String getDetailsRequest() {
        return this.detailsRequest;
    }

    public final long getEntityID() {
        return this.entityID;
    }

    public final int getImgVer() {
        return this.imgVer;
    }

    public final String getSecondaryName() {
        return this.secondaryName;
    }
}
