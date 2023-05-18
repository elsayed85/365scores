package com.scores365.entitys.competitionsDetailsCards;

import com.scores365.bets.model.BookMakerObj;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p9.c;
import se.g;
/* compiled from: CompetitionDetailsOutrightCardObj.kt */
/* loaded from: classes2.dex */
public final class CompetitionDetailsOutrightCardObj extends CompetitionDetailsBaseCardObj {
    @c("Bookmakers")
    private final HashMap<Integer, BookMakerObj> bookmakers;
    @c("Tables")
    private final LinkedHashMap<Integer, CompetitionDetailsOutrightTableObj> tables;
    @c("Title")
    private final String title;
    @c("TopBookmakerID")
    private final int topBookmakerId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompetitionDetailsOutrightCardObj(String str, LinkedHashMap<Integer, CompetitionDetailsOutrightTableObj> tables, int i10, HashMap<Integer, BookMakerObj> bookmakers) {
        super(0, 1, null);
        m.g(tables, "tables");
        m.g(bookmakers, "bookmakers");
        this.title = str;
        this.tables = tables;
        this.topBookmakerId = i10;
        this.bookmakers = bookmakers;
    }

    public /* synthetic */ CompetitionDetailsOutrightCardObj(String str, LinkedHashMap linkedHashMap, int i10, HashMap hashMap, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, linkedHashMap, i10, (i11 & 8) != 0 ? new HashMap() : hashMap);
    }

    public final HashMap<Integer, BookMakerObj> getBookmakers() {
        return this.bookmakers;
    }

    @Override // com.scores365.entitys.competitionsDetailsCards.CompetitionDetailsBaseCardObj, se.e
    public g getCardType() {
        return g.Outright;
    }

    public final LinkedHashMap<Integer, CompetitionDetailsOutrightTableObj> getTables() {
        return this.tables;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTopBookmakerId() {
        return this.topBookmakerId;
    }
}
