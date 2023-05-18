package com.scores365.insight;

import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BookMakerObj;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import p9.c;
/* loaded from: classes2.dex */
public class InsightsObj implements Serializable {
    @c("ImgVer")
    private int imgVer = -1;
    @c("Insights")
    public LinkedHashMap<Integer, SingleInsightObj> insightsMap;
    @c("RelatedOdds")
    public RelatedOddsObj relatedOdds;

    public BetLine getBetLine(int i10) {
        LinkedHashMap<Integer, BetLine> linkedHashMap;
        RelatedOddsObj relatedOddsObj = this.relatedOdds;
        BetLine betLine = null;
        if (relatedOddsObj != null && (linkedHashMap = relatedOddsObj.linesMap) != null) {
            for (Integer num : linkedHashMap.keySet()) {
                BetLine betLine2 = linkedHashMap.get(Integer.valueOf(num.intValue()));
                if (betLine2.getID() == i10) {
                    betLine = betLine2;
                }
            }
        }
        return betLine;
    }

    public BookMakerObj getBookMaker(int i10) {
        Hashtable<Integer, BookMakerObj> hashtable;
        RelatedOddsObj relatedOddsObj = this.relatedOdds;
        BookMakerObj bookMakerObj = null;
        if (relatedOddsObj != null && (hashtable = relatedOddsObj.bookmakers) != null) {
            for (Integer num : hashtable.keySet()) {
                BookMakerObj bookMakerObj2 = hashtable.get(Integer.valueOf(num.intValue()));
                if (bookMakerObj2.getID() == i10) {
                    bookMakerObj = bookMakerObj2;
                }
            }
        }
        return bookMakerObj;
    }

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }
}
