package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ParticipantObj implements Serializable {
    private static final long serialVersionUID = 2129439832613313422L;
    @p9.c("CompetitorID")
    public int competitorId;
    @p9.c("ImgVer")
    private int imgVer;
    @p9.c("Name")
    public String name;
    @p9.c("Num")
    public int num;
    @p9.c("OriginGroup")
    public int originGroup;
    @p9.c("OriginPosition")
    public int originPosition;
    @p9.c("OriginStage")
    public int originStage;
    @p9.c("SymbolicName")
    public String participantSymbolicName;
    @p9.c("Seed")
    public String seed;
    @p9.c("ShortName")
    public String shortName;

    public ParticipantObj() {
    }

    public ParticipantObj(int i10, int i11, int i12, int i13, String str, String str2, int i14, String str3, String str4) {
        this.num = i10;
        this.originStage = i11;
        this.originGroup = i12;
        this.originPosition = i13;
        this.name = str;
        this.shortName = str2;
        this.competitorId = i14;
        this.participantSymbolicName = str3;
        this.seed = str4;
    }

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public String getShortName() {
        String str = this.shortName;
        return (str == null || str.isEmpty()) ? this.name : str;
    }
}
