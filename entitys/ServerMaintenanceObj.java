package com.scores365.entitys;
/* compiled from: ServerMaintenanceObj.kt */
/* loaded from: classes2.dex */
public final class ServerMaintenanceObj {
    @p9.c("App_name")
    private String appName;
    @p9.c("appType")
    private int appType = -1;
    @p9.c("blockedUserPercentage")
    private float blockedUserPercentage = 1.0f;
    @p9.c("UnderMaintenance")
    private boolean isUnderMaintenance;
    @p9.c("minSeniorityDaysToShow")
    private int minSeniorityDaysToShow;

    public final String getAppName() {
        return this.appName;
    }

    public final int getAppType() {
        return this.appType;
    }

    public final float getBlockedUserPercentage() {
        return this.blockedUserPercentage;
    }

    public final int getMinSeniorityDaysToShow() {
        return this.minSeniorityDaysToShow;
    }

    public final boolean isUnderMaintenance() {
        return this.isUnderMaintenance;
    }

    public final void setAppName(String str) {
        this.appName = str;
    }

    public final void setAppType(int i10) {
        this.appType = i10;
    }

    public final void setBlockedUserPercentage(float f10) {
        this.blockedUserPercentage = f10;
    }

    public final void setMinSeniorityDaysToShow(int i10) {
        this.minSeniorityDaysToShow = i10;
    }

    public final void setUnderMaintenance(boolean z10) {
        this.isUnderMaintenance = z10;
    }
}
