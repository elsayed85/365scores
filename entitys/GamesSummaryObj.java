package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import li.x0;
/* loaded from: classes2.dex */
public class GamesSummaryObj implements Serializable {
    private static final long serialVersionUID = 7757810477761879359L;
    @p9.c("Dates")
    public LinkedHashMap<Long, GamesDateObj> gamesDateMap;
    @p9.c("IncludesToday")
    public boolean includesToday;
    @p9.c("LastGameDate")
    public Date lastGameDate;
    @p9.c("NextGameDate")
    public Date nextGameDate;
    @p9.c("RangeEnd")
    public Date rangeEnd;
    @p9.c("RangeStart")
    public Date rangeStart;

    public void merge(GamesSummaryObj gamesSummaryObj) {
        try {
            if (this.rangeStart.after(gamesSummaryObj.rangeStart)) {
                this.rangeStart.setTime(gamesSummaryObj.rangeStart.getTime());
            }
            if (this.rangeEnd.before(gamesSummaryObj.rangeEnd)) {
                this.rangeEnd.setTime(gamesSummaryObj.rangeEnd.getTime());
            }
            ArrayList arrayList = new ArrayList(gamesSummaryObj.gamesDateMap.values());
            arrayList.addAll(this.gamesDateMap.values());
            Collections.sort(arrayList, new Comparator<GamesDateObj>() { // from class: com.scores365.entitys.GamesSummaryObj.1
                @Override // java.util.Comparator
                public int compare(GamesDateObj gamesDateObj, GamesDateObj gamesDateObj2) {
                    try {
                        return gamesDateObj.gamesDate.compareTo(gamesDateObj2.gamesDate);
                    } catch (Exception unused) {
                        return 0;
                    }
                }
            });
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GamesDateObj gamesDateObj = (GamesDateObj) it.next();
                if (linkedHashMap.containsKey(Long.valueOf(gamesDateObj.gamesDate.getTime()))) {
                    gamesDateObj.numberOfGamesInDate += ((GamesDateObj) linkedHashMap.get(Long.valueOf(gamesDateObj.gamesDate.getTime()))).numberOfGamesInDate;
                }
                linkedHashMap.put(Long.valueOf(gamesDateObj.gamesDate.getTime()), gamesDateObj);
            }
            this.gamesDateMap.clear();
            this.gamesDateMap.putAll(linkedHashMap);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
