package com.scores365.entitys;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import li.x0;
/* loaded from: classes2.dex */
public class GameTeaserObj {
    @p9.c("Competitions")
    private LinkedHashMap<Integer, CompetitionObj> competitions;
    @p9.c("Countries")
    private LinkedHashMap<Integer, CountryObj> countries;
    @p9.c("Games")
    private LinkedHashMap<Integer, GameObj> games = new LinkedHashMap<>();
    private ArrayList<GameObj> gamesList;
    @p9.c("Odds")
    private BestOddsObj oddsObj;

    public GameObj getGame(int i10) {
        GameObj gameObj;
        try {
            if (this.gamesList == null) {
                ArrayList<GameObj> arrayList = new ArrayList<>();
                this.gamesList = arrayList;
                LinkedHashMap<Integer, GameObj> linkedHashMap = this.games;
                if (linkedHashMap != null) {
                    arrayList.addAll(linkedHashMap.values());
                }
            }
            if (this.gamesList.isEmpty()) {
                return null;
            }
            if (i10 == 0) {
                gameObj = this.gamesList.get(0);
            } else if (this.gamesList.size() <= 1) {
                return null;
            } else {
                gameObj = this.gamesList.get(1);
            }
            return gameObj;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public BestOddsObj getOddsObj() {
        return this.oddsObj;
    }

    public boolean isGameTeaserHasGames() {
        LinkedHashMap<Integer, GameObj> linkedHashMap = this.games;
        return (linkedHashMap == null || linkedHashMap.isEmpty()) ? false : true;
    }
}
