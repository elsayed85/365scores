package com.scores365.entitys;

import androidx.annotation.NonNull;
import com.scores365.bets.model.BetLineType;
import com.scores365.bets.model.BookMakerObj;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import se.e;
import se.g;
/* loaded from: classes2.dex */
public class TopPerformerObj implements Serializable, e {
    public static final int FIFTH_LAYOUT_NUMBER = 5;
    public static final int FIRST_LAYOUT_NUMBER = 1;
    public static final int FOURTH_LAYOUT_NUMBER = 4;
    public static final int SECOND_LAYOUT_NUMBER = 2;
    public static final int SIXTH_LAYOUT_NUMBER = 6;
    public static final int THIRD_LAYOUT_NUMBER = 3;
    @p9.c("LineTypes")
    private ArrayList<BetLineType> betLineTypes;
    @p9.c("Bookmakers")
    private ArrayList<BookMakerObj> bookMakers;
    @p9.c("Filters")
    private ArrayList<FilterTopObj> filters;
    @p9.c("StatisticTypes")
    private LinkedHashMap<Integer, StatisticType> statisticTypes;
    @p9.c("Categories")
    public ArrayList<TopPerformerStatisticObj> statistics;
    @p9.c("Layout")
    private int layout = -1;
    @p9.c("CardOrder")
    public int cardOrder = -1;
    @p9.c("Title")
    private String title = null;

    public ArrayList<BetLineType> getBetLineTypes() {
        return this.betLineTypes;
    }

    public ArrayList<BookMakerObj> getBookMakers() {
        return this.bookMakers;
    }

    public int getCardOrder() {
        return this.cardOrder;
    }

    @Override // se.e
    @NonNull
    public g getCardType() {
        return g.TopPlayers;
    }

    public ArrayList<FilterTopObj> getFilters() {
        return this.filters;
    }

    public int getLayout() {
        return this.layout;
    }

    public LinkedHashMap<Integer, StatisticType> getStatisticTypes() {
        return this.statisticTypes;
    }

    public ArrayList<TopPerformerStatisticObj> getStatistics() {
        return this.statistics;
    }

    public String getTitle() {
        return this.title;
    }
}
