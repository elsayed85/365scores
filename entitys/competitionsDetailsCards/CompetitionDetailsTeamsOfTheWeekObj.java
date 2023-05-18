package com.scores365.entitys.competitionsDetailsCards;

import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p9.c;
import se.g;
/* compiled from: CompetitionDetailsTeamsOfTheWeekObj.kt */
/* loaded from: classes2.dex */
public final class CompetitionDetailsTeamsOfTheWeekObj extends CompetitionDetailsBaseCardObj {
    @c("Lineups")
    private final ArrayList<TeamOfTheWeekObj> lineupsList;
    @c("Title")
    private final String title;

    public CompetitionDetailsTeamsOfTheWeekObj(String str, ArrayList<TeamOfTheWeekObj> arrayList) {
        super(0, 1, null);
        this.title = str;
        this.lineupsList = arrayList;
    }

    public /* synthetic */ CompetitionDetailsTeamsOfTheWeekObj(String str, ArrayList arrayList, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? "" : str, arrayList);
    }

    @Override // com.scores365.entitys.competitionsDetailsCards.CompetitionDetailsBaseCardObj, se.e
    public g getCardType() {
        return g.TeamOfTheWeek;
    }

    public final ArrayList<TeamOfTheWeekObj> getLineupsList() {
        return this.lineupsList;
    }

    public final String getTitle() {
        return this.title;
    }
}
