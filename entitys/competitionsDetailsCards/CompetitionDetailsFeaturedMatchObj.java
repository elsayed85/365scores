package com.scores365.entitys.competitionsDetailsCards;

import com.scores365.entitys.GameObj;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p9.c;
import se.g;
/* compiled from: CompetitionDetailsFeaturedMatchObj.kt */
/* loaded from: classes2.dex */
public final class CompetitionDetailsFeaturedMatchObj extends CompetitionDetailsBaseCardObj {
    @c("BettingAddons")
    private final ArrayList<FeaturedMatchBettingAddons> bettingAddons;
    @c("Games")
    private final LinkedHashMap<Integer, GameObj> games;
    @c("Title")
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompetitionDetailsFeaturedMatchObj(LinkedHashMap<Integer, GameObj> games, String str, ArrayList<FeaturedMatchBettingAddons> arrayList) {
        super(0, 1, null);
        m.g(games, "games");
        this.games = games;
        this.title = str;
        this.bettingAddons = arrayList;
    }

    public /* synthetic */ CompetitionDetailsFeaturedMatchObj(LinkedHashMap linkedHashMap, String str, ArrayList arrayList, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(linkedHashMap, (i10 & 2) != 0 ? null : str, arrayList);
    }

    public final ArrayList<FeaturedMatchBettingAddons> getBettingAddons() {
        return this.bettingAddons;
    }

    @Override // com.scores365.entitys.competitionsDetailsCards.CompetitionDetailsBaseCardObj, se.e
    public g getCardType() {
        return g.FeaturedMatch;
    }

    public final LinkedHashMap<Integer, GameObj> getGames() {
        return this.games;
    }

    public final String getTitle() {
        return this.title;
    }
}
