package com.scores365.gameCenter;

import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.FilterTopObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.PlayerObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.entitys.StatisticType;
import com.scores365.entitys.TopPerformerObj;
import com.scores365.entitys.TopPerformerStatisticObj;
import com.scores365.gameCenter.i0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;
import xf.y;
/* compiled from: GameCenterDataMgrTopPerformersHelper.kt */
/* loaded from: classes2.dex */
public final class j0 {

    /* renamed from: a  reason: collision with root package name */
    private final GameObj f23982a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f23983b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23984c;

    /* renamed from: d  reason: collision with root package name */
    private final Function1<Boolean, String> f23985d;

    /* renamed from: e  reason: collision with root package name */
    private final Function1<Integer, CompetitionObj> f23986e;

    /* JADX WARN: Multi-variable type inference failed */
    public j0(GameObj mGameObj, boolean z10, int i10, Function1<? super Boolean, String> getTitleForTopPerformer, Function1<? super Integer, ? extends CompetitionObj> getCompetitionById) {
        kotlin.jvm.internal.m.g(mGameObj, "mGameObj");
        kotlin.jvm.internal.m.g(getTitleForTopPerformer, "getTitleForTopPerformer");
        kotlin.jvm.internal.m.g(getCompetitionById, "getCompetitionById");
        this.f23982a = mGameObj;
        this.f23983b = z10;
        this.f23984c = i10;
        this.f23985d = getTitleForTopPerformer;
        this.f23986e = getCompetitionById;
    }

    private final String d() {
        String str = this.f23982a.phaseName;
        kotlin.jvm.internal.m.f(str, "mGameObj.phaseName");
        if (str.length() > 0) {
            return " - " + this.f23982a.phaseName;
        }
        return "";
    }

    public final ArrayList<com.scores365.Design.PageObjects.b> a() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        ArrayList<TopPerformerStatisticObj> arrayList2 = this.f23982a.topPerformers.statistics;
        kotlin.jvm.internal.m.f(arrayList2, "mGameObj.topPerformers.statistics");
        ArrayList<PlayerObj> players = arrayList2.get(0).getPlayers();
        if (players != null && (!players.isEmpty())) {
            arrayList.add(new yc.r(li.p0.l0("THREE_STARS")));
            Iterator<PlayerObj> it = players.iterator();
            while (it.hasNext()) {
                PlayerObj player = it.next();
                kotlin.jvm.internal.m.f(player, "player");
                arrayList.add(new cg.h(player, this.f23982a));
            }
        }
        return arrayList;
    }

    public final ArrayList<com.scores365.Design.PageObjects.b> b(boolean z10, i0.h isOddsItemAdded) {
        String l02;
        kotlin.jvm.internal.m.g(isOddsItemAdded, "isOddsItemAdded");
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        if (this.f23982a.getSportID() == SportTypesEnum.BASKETBALL.getValue()) {
            l02 = this.f23985d.invoke(Boolean.valueOf(z10));
        } else {
            l02 = li.p0.l0("KEY_PLAYERS_CARD_TITLE");
            kotlin.jvm.internal.m.f(l02, "getTerm(\"KEY_PLAYERS_CARD_TITLE\")");
        }
        arrayList.add(new yc.r(l02));
        if (this.f23982a.topPerformers.statistics.size() > 1) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<TopPerformerStatisticObj> statistics = this.f23982a.topPerformers.getStatistics();
            kotlin.jvm.internal.m.f(statistics, "mGameObj.topPerformers.getStatistics()");
            for (TopPerformerStatisticObj topPerformerStatisticObj : statistics) {
                String str = topPerformerStatisticObj.statisticTitle;
                kotlin.jvm.internal.m.f(str, "statistic.statisticTitle");
                arrayList2.add(new y.b(-1, str));
            }
            arrayList.add(new xf.y(arrayList2, this.f23984c));
        }
        int cid = this.f23986e.invoke(Integer.valueOf(this.f23982a.getCompetitionID())).getCid();
        try {
            if (li.x0.s2() && this.f23982a.topPerformers.getBookMakers() != null) {
                ArrayList<BookMakerObj> bookMakers = this.f23982a.topPerformers.getBookMakers();
                kotlin.jvm.internal.m.f(bookMakers, "mGameObj.topPerformers.bookMakers");
                if (!bookMakers.isEmpty()) {
                    isOddsItemAdded.e(true);
                    BookMakerObj next = this.f23982a.topPerformers.getBookMakers().iterator().next();
                    kotlin.jvm.internal.m.f(next, "mGameObj.topPerformers.b…kMakers.iterator().next()");
                    isOddsItemAdded.f(next);
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        TopPerformerObj topPerformerObj = this.f23982a.topPerformers;
        kotlin.jvm.internal.m.f(topPerformerObj, "mGameObj.topPerformers");
        int i10 = this.f23984c;
        GameObj gameObj = this.f23982a;
        arrayList.add(new xf.d0(topPerformerObj, i10, gameObj, cid, gameObj.getSportID() == SportTypesEnum.BASKETBALL.getValue(), this.f23982a.homeAwayTeamOrder, false));
        return arrayList;
    }

    public final ArrayList<com.scores365.Design.PageObjects.b> c(boolean z10) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        ArrayList<TopPerformerStatisticObj> arrayList2 = this.f23982a.topPerformers.statistics;
        kotlin.jvm.internal.m.f(arrayList2, "mGameObj.topPerformers.statistics");
        if (arrayList2.get(0).getPlayers() != null) {
            ArrayList<PlayerObj> players = arrayList2.get(0).getPlayers();
            kotlin.jvm.internal.m.f(players, "categories[0].players");
            if (!players.isEmpty()) {
                arrayList.add(new yc.r(this.f23985d.invoke(Boolean.valueOf(z10))));
                Iterator<TopPerformerStatisticObj> it = arrayList2.iterator();
                while (it.hasNext()) {
                    TopPerformerStatisticObj category = it.next();
                    ArrayList<PlayerObj> players2 = category.getPlayers();
                    if (players2 != null && (!players2.isEmpty())) {
                        GameObj gameObj = this.f23982a;
                        kotlin.jvm.internal.m.f(category, "category");
                        arrayList.add(new cg.i(gameObj, category));
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<com.scores365.Design.PageObjects.b> e(boolean z10, i0.h isOddsItemAdded) {
        FilterTopObj filterTopObj;
        int i10;
        kotlin.jvm.internal.m.g(isOddsItemAdded, "isOddsItemAdded");
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        arrayList.add(new yc.r(this.f23985d.invoke(Boolean.valueOf(z10))));
        ArrayList arrayList2 = new ArrayList();
        if (this.f23982a.topPerformers.getFilters() != null) {
            ArrayList<FilterTopObj> filters = this.f23982a.topPerformers.getFilters();
            kotlin.jvm.internal.m.f(filters, "mGameObj.topPerformers.filters");
            if (!filters.isEmpty()) {
                ArrayList<FilterTopObj> filters2 = this.f23982a.topPerformers.getFilters();
                kotlin.jvm.internal.m.f(filters2, "mGameObj.topPerformers.filters");
                Iterator<FilterTopObj> it = filters2.iterator();
                while (it.hasNext()) {
                    String component2 = it.next().component2();
                    kotlin.jvm.internal.m.d(component2);
                    arrayList2.add(new y.b(-1, component2));
                }
            }
        }
        xf.y yVar = new xf.y(arrayList2, this.f23984c);
        yVar.o(40);
        arrayList.add(yVar);
        int cid = this.f23986e.invoke(Integer.valueOf(this.f23982a.getCompetitionID())).getCid();
        try {
            if (li.x0.s2() && this.f23982a.topPerformers.getBookMakers() != null) {
                ArrayList<BookMakerObj> bookMakers = this.f23982a.topPerformers.getBookMakers();
                kotlin.jvm.internal.m.f(bookMakers, "mGameObj.topPerformers.bookMakers");
                if (!bookMakers.isEmpty()) {
                    isOddsItemAdded.e(true);
                    BookMakerObj next = this.f23982a.topPerformers.getBookMakers().iterator().next();
                    kotlin.jvm.internal.m.f(next, "mGameObj.topPerformers.b…kMakers.iterator().next()");
                    isOddsItemAdded.f(next);
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        ArrayList<FilterTopObj> filters3 = this.f23982a.topPerformers.getFilters();
        kotlin.jvm.internal.m.f(filters3, "mGameObj.topPerformers.filters");
        if (this.f23984c <= filters3.size()) {
            FilterTopObj filterTopObj2 = filters3.get(this.f23984c);
            kotlin.jvm.internal.m.f(filterTopObj2, "filters[topPerformerChosenStatIndex]");
            FilterTopObj filterTopObj3 = filterTopObj2;
            TopPerformerObj topPerformerObj = this.f23982a.topPerformers;
            kotlin.jvm.internal.m.f(topPerformerObj, "mGameObj.topPerformers");
            if (filterTopObj3.getId() != null) {
                int size = topPerformerObj.statistics.size();
                int i11 = 0;
                int i12 = 0;
                while (i11 < size) {
                    int filterId = topPerformerObj.statistics.get(i11).getFilterId();
                    Integer id2 = filterTopObj3.getId();
                    if (id2 == null || filterId != id2.intValue() || (topPerformerObj.statistics.get(i11).getPlayerForCompetitor(1) == null && topPerformerObj.statistics.get(i11).getPlayerForCompetitor(2) == null)) {
                        filterTopObj = filterTopObj3;
                        i10 = i11;
                    } else {
                        TopPerformerObj topPerformerObj2 = this.f23982a.topPerformers;
                        kotlin.jvm.internal.m.f(topPerformerObj2, "mGameObj.topPerformers");
                        GameObj gameObj = this.f23982a;
                        filterTopObj = filterTopObj3;
                        i10 = i11;
                        xf.d0 d0Var = new xf.d0(topPerformerObj2, i11, gameObj, cid, gameObj.getSportID() == SportTypesEnum.BASKETBALL.getValue() || this.f23982a.getSportID() == SportTypesEnum.BASEBALL.getValue(), this.f23982a.homeAwayTeamOrder, false);
                        if (i12 > 0) {
                            d0Var.D(1);
                        }
                        arrayList.add(d0Var);
                        i12++;
                    }
                    i11 = i10 + 1;
                    filterTopObj3 = filterTopObj;
                }
            }
        }
        return arrayList;
    }

    public final boolean f() {
        if (h() && this.f23982a.topPerformers.getStatisticTypes() != null) {
            LinkedHashMap<Integer, StatisticType> statisticTypes = this.f23982a.topPerformers.getStatisticTypes();
            kotlin.jvm.internal.m.f(statisticTypes, "mGameObj.topPerformers.statisticTypes");
            if (!statisticTypes.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final ArrayList<com.scores365.Design.PageObjects.b> g(boolean z10) {
        String l02;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        if (z10) {
            l02 = li.p0.l0("SEASON_LEADERS_TITLE") + d();
        } else {
            l02 = li.p0.l0("GAME_LEADERS_TITLE");
            kotlin.jvm.internal.m.f(l02, "{\n                UiUtil…ERS_TITLE\")\n            }");
        }
        arrayList.add(new yc.r(l02));
        LinkedHashMap<Integer, StatisticType> statisticTypes = this.f23982a.topPerformers.getStatisticTypes();
        kotlin.jvm.internal.m.f(statisticTypes, "mGameObj.topPerformers.statisticTypes");
        int cid = this.f23986e.invoke(Integer.valueOf(this.f23982a.getCompetitionID())).getCid();
        Iterator<TopPerformerStatisticObj> it = this.f23982a.topPerformers.statistics.iterator();
        while (it.hasNext()) {
            TopPerformerStatisticObj category = it.next();
            GameObj gameObj = this.f23982a;
            kotlin.jvm.internal.m.f(category, "category");
            arrayList.add(new de.d(gameObj, category, statisticTypes, cid));
        }
        return arrayList;
    }

    public final boolean h() {
        ArrayList<TopPerformerStatisticObj> arrayList;
        TopPerformerObj topPerformerObj = this.f23982a.topPerformers;
        if (topPerformerObj != null && (arrayList = topPerformerObj.statistics) != null) {
            kotlin.jvm.internal.m.f(arrayList, "mGameObj.topPerformers.statistics");
            if (!arrayList.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
