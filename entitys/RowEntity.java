package com.scores365.entitys;
/* loaded from: classes2.dex */
public class RowEntity {
    @p9.c("CompetitionID")
    public int competitionID;
    @p9.c("CompetitorID")
    public int competitorID;
    @p9.c("CountryID")
    public int countryID;
    @p9.c("IsLeftClub")
    private boolean isLeftClub;
    @p9.c("Name")
    public String name;
    @p9.c("ID")
    public int playerId;
    @p9.c("SName")
    public String sname;
    @p9.c("Position")
    public int position = -1;
    @p9.c("FormationPosition")
    public int formationPosition = -1;
    @p9.c("Boots")
    public int boots = -1;
    @p9.c("ImgVer")
    private int imgVer = -1;

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public String getName() {
        return this.name;
    }

    public String getShortName() {
        String str = this.sname;
        return (str == null || str.isEmpty()) ? this.name : this.sname;
    }

    public boolean isLeftClub() {
        return this.isLeftClub;
    }

    public void setLeftClub(boolean z10) {
        this.isLeftClub = z10;
    }
}
