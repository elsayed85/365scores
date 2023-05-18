package com.scores365.insight;

import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BookMakerObj;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import p9.c;
/* loaded from: classes2.dex */
public class RelatedOddsObj implements Serializable {
    @c("Bookmakers")
    public Hashtable<Integer, BookMakerObj> bookmakers;
    @c("Lines")
    public LinkedHashMap<Integer, BetLine> linesMap;
}
