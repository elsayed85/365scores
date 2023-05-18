package com.scores365.entitys.competitionsDetailsCards;

import com.scores365.entitys.StatisticType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p9.c;
import se.g;
/* compiled from: CompetitionDetailsTopTeamsObj.kt */
/* loaded from: classes2.dex */
public final class CompetitionDetailsTopTeamsObj extends CompetitionDetailsBaseCardObj {
    @c("Categories")
    private final ArrayList<TopTeamCategoryObj> categories;
    @c("Layout")
    private final int layout;
    @c("StatisticTypes")
    private final LinkedHashMap<Integer, StatisticType> statisticTypes;
    @c("Title")
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompetitionDetailsTopTeamsObj(int i10, String title, ArrayList<TopTeamCategoryObj> categories, LinkedHashMap<Integer, StatisticType> linkedHashMap) {
        super(0, 1, null);
        m.g(title, "title");
        m.g(categories, "categories");
        this.layout = i10;
        this.title = title;
        this.categories = categories;
        this.statisticTypes = linkedHashMap;
    }

    public /* synthetic */ CompetitionDetailsTopTeamsObj(int i10, String str, ArrayList arrayList, LinkedHashMap linkedHashMap, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? -1 : i10, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? new ArrayList() : arrayList, linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CompetitionDetailsTopTeamsObj copy$default(CompetitionDetailsTopTeamsObj competitionDetailsTopTeamsObj, int i10, String str, ArrayList arrayList, LinkedHashMap linkedHashMap, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = competitionDetailsTopTeamsObj.layout;
        }
        if ((i11 & 2) != 0) {
            str = competitionDetailsTopTeamsObj.title;
        }
        if ((i11 & 4) != 0) {
            arrayList = competitionDetailsTopTeamsObj.categories;
        }
        if ((i11 & 8) != 0) {
            linkedHashMap = competitionDetailsTopTeamsObj.statisticTypes;
        }
        return competitionDetailsTopTeamsObj.copy(i10, str, arrayList, linkedHashMap);
    }

    public final int component1() {
        return this.layout;
    }

    public final String component2() {
        return this.title;
    }

    public final ArrayList<TopTeamCategoryObj> component3() {
        return this.categories;
    }

    public final LinkedHashMap<Integer, StatisticType> component4() {
        return this.statisticTypes;
    }

    public final CompetitionDetailsTopTeamsObj copy(int i10, String title, ArrayList<TopTeamCategoryObj> categories, LinkedHashMap<Integer, StatisticType> linkedHashMap) {
        m.g(title, "title");
        m.g(categories, "categories");
        return new CompetitionDetailsTopTeamsObj(i10, title, categories, linkedHashMap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CompetitionDetailsTopTeamsObj) {
            CompetitionDetailsTopTeamsObj competitionDetailsTopTeamsObj = (CompetitionDetailsTopTeamsObj) obj;
            return this.layout == competitionDetailsTopTeamsObj.layout && m.b(this.title, competitionDetailsTopTeamsObj.title) && m.b(this.categories, competitionDetailsTopTeamsObj.categories) && m.b(this.statisticTypes, competitionDetailsTopTeamsObj.statisticTypes);
        }
        return false;
    }

    @Override // com.scores365.entitys.competitionsDetailsCards.CompetitionDetailsBaseCardObj, se.e
    public g getCardType() {
        return g.TopTeams;
    }

    public final ArrayList<TopTeamCategoryObj> getCategories() {
        return this.categories;
    }

    public final int getLayout() {
        return this.layout;
    }

    public final LinkedHashMap<Integer, StatisticType> getStatisticTypes() {
        return this.statisticTypes;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((((this.layout * 31) + this.title.hashCode()) * 31) + this.categories.hashCode()) * 31;
        LinkedHashMap<Integer, StatisticType> linkedHashMap = this.statisticTypes;
        return hashCode + (linkedHashMap == null ? 0 : linkedHashMap.hashCode());
    }

    public String toString() {
        return "CompetitionDetailsTopTeamsObj(layout=" + this.layout + ", title=" + this.title + ", categories=" + this.categories + ", statisticTypes=" + this.statisticTypes + ')';
    }
}
