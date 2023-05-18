package com.scores365.entitys.competitionsDetailsCards;

import com.scores365.entitys.BaseObj;
import com.scores365.entitys.CompObj;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p9.c;
/* compiled from: TeamObj.kt */
/* loaded from: classes2.dex */
public final class TeamObj extends BaseObj {
    @c("Action")
    private final GeneralCompetitionDetailsAction action;
    @c("Competitor")
    private final CompObj comp;
    @c("MainStat")
    private final String mainStat;
    @c("SecondaryStat")
    private final String secondaryStat;

    public TeamObj(CompObj compObj, String mainStat, String str, GeneralCompetitionDetailsAction generalCompetitionDetailsAction) {
        m.g(mainStat, "mainStat");
        this.comp = compObj;
        this.mainStat = mainStat;
        this.secondaryStat = str;
        this.action = generalCompetitionDetailsAction;
    }

    public /* synthetic */ TeamObj(CompObj compObj, String str, String str2, GeneralCompetitionDetailsAction generalCompetitionDetailsAction, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(compObj, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? "" : str2, generalCompetitionDetailsAction);
    }

    public static /* synthetic */ TeamObj copy$default(TeamObj teamObj, CompObj compObj, String str, String str2, GeneralCompetitionDetailsAction generalCompetitionDetailsAction, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            compObj = teamObj.comp;
        }
        if ((i10 & 2) != 0) {
            str = teamObj.mainStat;
        }
        if ((i10 & 4) != 0) {
            str2 = teamObj.secondaryStat;
        }
        if ((i10 & 8) != 0) {
            generalCompetitionDetailsAction = teamObj.action;
        }
        return teamObj.copy(compObj, str, str2, generalCompetitionDetailsAction);
    }

    public final CompObj component1() {
        return this.comp;
    }

    public final String component2() {
        return this.mainStat;
    }

    public final String component3() {
        return this.secondaryStat;
    }

    public final GeneralCompetitionDetailsAction component4() {
        return this.action;
    }

    public final TeamObj copy(CompObj compObj, String mainStat, String str, GeneralCompetitionDetailsAction generalCompetitionDetailsAction) {
        m.g(mainStat, "mainStat");
        return new TeamObj(compObj, mainStat, str, generalCompetitionDetailsAction);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TeamObj) {
            TeamObj teamObj = (TeamObj) obj;
            return m.b(this.comp, teamObj.comp) && m.b(this.mainStat, teamObj.mainStat) && m.b(this.secondaryStat, teamObj.secondaryStat) && m.b(this.action, teamObj.action);
        }
        return false;
    }

    public final GeneralCompetitionDetailsAction getAction() {
        return this.action;
    }

    public final CompObj getComp() {
        return this.comp;
    }

    public final String getMainStat() {
        return this.mainStat;
    }

    public final String getSecondaryStat() {
        return this.secondaryStat;
    }

    public int hashCode() {
        CompObj compObj = this.comp;
        int hashCode = (((compObj == null ? 0 : compObj.hashCode()) * 31) + this.mainStat.hashCode()) * 31;
        String str = this.secondaryStat;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        GeneralCompetitionDetailsAction generalCompetitionDetailsAction = this.action;
        return hashCode2 + (generalCompetitionDetailsAction != null ? generalCompetitionDetailsAction.hashCode() : 0);
    }

    public String toString() {
        return "TeamObj(comp=" + this.comp + ", mainStat=" + this.mainStat + ", secondaryStat=" + this.secondaryStat + ", action=" + this.action + ')';
    }
}
