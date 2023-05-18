package com.scores365.bets.model;

import com.scores365.entitys.oddsPreviewEntities.OddsPreview;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import li.x0;
import p9.c;
/* loaded from: classes2.dex */
public class GameBetsObj {
    @c("Lines")
    public LinkedHashMap<Integer, BetLine> betLines;
    @c("Bookmakers")
    public Hashtable<Integer, BookMakerObj> bookmakers;
    public HashMap<Integer, OddsPreview> gameId2OddsPreview = new HashMap<>();
    public HashMap<Integer, BetLine> gamesOfLines = new HashMap<>();
    private boolean isBetLinesChanged = false;
    @c("LastUpdateID")
    public long lastUpdateID;
    @c("OddsPreviews")
    public ArrayList<OddsPreview> oddsPreview;

    public boolean isBetLinesChanged() {
        return this.isBetLinesChanged;
    }

    public void merge(GameBetsObj gameBetsObj) {
        if (gameBetsObj != null) {
            this.lastUpdateID = gameBetsObj.lastUpdateID;
            try {
                Hashtable<Integer, BookMakerObj> hashtable = gameBetsObj.bookmakers;
                if (hashtable != null && !hashtable.isEmpty()) {
                    this.bookmakers.putAll(gameBetsObj.bookmakers);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            try {
                LinkedHashMap<Integer, BetLine> linkedHashMap = gameBetsObj.betLines;
                if (linkedHashMap == null || linkedHashMap.isEmpty()) {
                    return;
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(this.betLines);
                this.betLines.putAll(gameBetsObj.betLines);
                if (this.isBetLinesChanged) {
                    return;
                }
                this.isBetLinesChanged = !linkedHashMap2.equals(this.betLines);
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }
    }

    public void setBetLinesChanged(boolean z10) {
        this.isBetLinesChanged = z10;
    }

    public void updateSetForLines() {
        try {
            for (BetLine betLine : this.betLines.values()) {
                if (this.gamesOfLines.get(Integer.valueOf(betLine.entityId)) == null) {
                    this.gamesOfLines.put(Integer.valueOf(betLine.entityId), betLine);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void updateSetForPreviewLines() {
        try {
            ArrayList<OddsPreview> arrayList = this.oddsPreview;
            if (arrayList != null) {
                Iterator<OddsPreview> it = arrayList.iterator();
                while (it.hasNext()) {
                    OddsPreview next = it.next();
                    if (this.gameId2OddsPreview.get(Integer.valueOf(next.getGameId())) == null) {
                        this.gameId2OddsPreview.put(Integer.valueOf(next.getGameId()), next);
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
