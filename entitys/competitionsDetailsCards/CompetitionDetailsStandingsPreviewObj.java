package com.scores365.entitys.competitionsDetailsCards;

import com.scores365.entitys.TableObj;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p9.c;
import se.g;
/* compiled from: CompetitionDetailsStandingsPreviewObj.kt */
/* loaded from: classes2.dex */
public final class CompetitionDetailsStandingsPreviewObj extends CompetitionDetailsBaseCardObj {
    @c("Table")
    private final TableObj table;
    @c("Title")
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompetitionDetailsStandingsPreviewObj(String title, TableObj table) {
        super(0, 1, null);
        m.g(title, "title");
        m.g(table, "table");
        this.title = title;
        this.table = table;
    }

    public /* synthetic */ CompetitionDetailsStandingsPreviewObj(String str, TableObj tableObj, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? "" : str, tableObj);
    }

    @Override // com.scores365.entitys.competitionsDetailsCards.CompetitionDetailsBaseCardObj, se.e
    public g getCardType() {
        return g.StandingsPreview;
    }

    public final TableObj getTable() {
        return this.table;
    }

    public final String getTitle() {
        return this.title;
    }
}
