package com.scores365.bets.model;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import p9.c;
/* loaded from: classes2.dex */
public class BetsObj {
    @c("BookMakers")
    private Hashtable<Integer, BookMakerObj> bookmakers;
    @c("DailyTipAvailable")
    private boolean dailyTipAvailable;
    @c("DefaultFormat")
    private int defaultFormat;
    @c("LineTypes")
    private LinkedHashMap<Integer, BetLineType> lineTypes;
    @c("ShowBetsInAllScores")
    public boolean showBetsInAllScores;
    @c("ShowHideOddsDialog")
    private boolean showHideOddsDialog;

    public Hashtable<Integer, BookMakerObj> getBookmakers() {
        return this.bookmakers;
    }

    public int getDefaultFormat() {
        return this.defaultFormat;
    }

    public LinkedHashMap<Integer, BetLineType> getLineTypes() {
        return this.lineTypes;
    }

    public boolean isDailyTipAvailable() {
        return this.dailyTipAvailable;
    }
}
