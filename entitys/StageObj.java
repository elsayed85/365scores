package com.scores365.entitys;
/* loaded from: classes2.dex */
public class StageObj extends BaseObj {
    @p9.c("AliasName")
    private String aliasName;
    @p9.c("isExtraTime")
    private boolean isExtraTime;
    @p9.c("Main")
    private boolean isMain;
    @p9.c("Optional")
    private boolean isOptional;
    @p9.c("isPenalties")
    private boolean isPenalties;
    @p9.c("ShortName")
    private String shortName;
    @p9.c("SportTypeID")
    private int sportTypeID;

    public String getAliasName() {
        return this.aliasName;
    }

    public String getShortName() {
        return this.shortName;
    }

    public int getSportTypeID() {
        return this.sportTypeID;
    }

    public boolean isExtraTime() {
        return this.isExtraTime;
    }

    public boolean isMain() {
        return this.isMain;
    }

    public boolean isOptional() {
        return this.isOptional;
    }

    public boolean isPenalties() {
        return this.isPenalties;
    }
}
