package com.scores365.entitys;

import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BookMakerObj;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class BestOddsObj extends BaseObj {
    @p9.c("Lines")
    private BetLine[] betLines;
    @p9.c("Bookmakers")
    private LinkedHashMap<Integer, BookMakerObj> bookMakerObjs;

    public BetLine[] getBetLines() {
        return this.betLines;
    }

    public LinkedHashMap<Integer, BookMakerObj> getBookMakerObjs() {
        return this.bookMakerObjs;
    }
}
