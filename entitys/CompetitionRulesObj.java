package com.scores365.entitys;

import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
/* compiled from: CompetitionRulesObj.kt */
/* loaded from: classes2.dex */
public final class CompetitionRulesObj extends BaseObj {
    @p9.c("Descriptions")
    private final List<String> descriptions;
    @p9.c("Title")
    private final String title;

    public CompetitionRulesObj() {
        this(null, null, 3, null);
    }

    public CompetitionRulesObj(List<String> descriptions, String title) {
        m.g(descriptions, "descriptions");
        m.g(title, "title");
        this.descriptions = descriptions;
        this.title = title;
    }

    public /* synthetic */ CompetitionRulesObj(List list, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? r.i() : list, (i10 & 2) != 0 ? "" : str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CompetitionRulesObj copy$default(CompetitionRulesObj competitionRulesObj, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = competitionRulesObj.descriptions;
        }
        if ((i10 & 2) != 0) {
            str = competitionRulesObj.title;
        }
        return competitionRulesObj.copy(list, str);
    }

    public final List<String> component1() {
        return this.descriptions;
    }

    public final String component2() {
        return this.title;
    }

    public final CompetitionRulesObj copy(List<String> descriptions, String title) {
        m.g(descriptions, "descriptions");
        m.g(title, "title");
        return new CompetitionRulesObj(descriptions, title);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CompetitionRulesObj) {
            CompetitionRulesObj competitionRulesObj = (CompetitionRulesObj) obj;
            return m.b(this.descriptions, competitionRulesObj.descriptions) && m.b(this.title, competitionRulesObj.title);
        }
        return false;
    }

    public final List<String> getDescriptions() {
        return this.descriptions;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.descriptions.hashCode() * 31) + this.title.hashCode();
    }

    public String toString() {
        return "CompetitionRulesObj(descriptions=" + this.descriptions + ", title=" + this.title + ')';
    }
}
