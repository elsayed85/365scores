package com.scores365.entitys;

import li.x0;
/* loaded from: classes2.dex */
public class HeaderEntityObj extends BaseObj {
    @p9.c("CID")
    protected int cId;
    @p9.c("Competition")
    public CompetitionObj competition;
    @p9.c("Competitor")
    public CompObj competitor;
    @p9.c("EntityType")
    protected int entityType;
    @p9.c("MainComp")
    protected int mainComp;
    @p9.c("SportTypeID")
    protected int sportTypeID;

    public HeaderEntityObj(int i10, int i11, int i12, int i13, int i14) {
        this.f23582id = i10;
        this.sportTypeID = i11;
        this.entityType = i12;
        this.cId = i13;
        this.mainComp = i14;
    }

    public int getCId() {
        return this.cId;
    }

    public String getEntityImageVersion() {
        String valueOf = String.valueOf(-1);
        try {
            CompetitionObj competitionObj = this.competition;
            if (competitionObj != null) {
                valueOf = competitionObj.getImgVer();
            } else {
                CompObj compObj = this.competitor;
                if (compObj != null) {
                    valueOf = compObj.getImgVer();
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return valueOf;
    }

    public String getEntityName() {
        CompObj compObj = this.competitor;
        if (compObj != null) {
            return compObj.getName();
        }
        CompetitionObj competitionObj = this.competition;
        if (competitionObj != null) {
            return competitionObj.getName();
        }
        return null;
    }

    public eDashboardEntityType getEntityType() {
        return eDashboardEntityType.create(this.entityType);
    }

    public int getId() {
        return this.f23582id;
    }

    public int getMainComp() {
        return this.mainComp;
    }

    public int getSportTypeID() {
        return this.sportTypeID;
    }
}
