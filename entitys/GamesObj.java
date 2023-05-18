package com.scores365.entitys;

import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.NewsObj;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import li.x0;
/* loaded from: classes2.dex */
public class GamesObj implements Serializable {
    private static final long serialVersionUID = -3097997652267501171L;
    @p9.c("TVNetworks")
    protected ArrayList<TvNetworkObj> TvNetworks;
    @p9.c("Athletes")
    public ArrayList<AthleteObj> athletesList;
    @p9.c("Bookmakers")
    public LinkedHashMap<Integer, BookMakerObj> bookMakerObjs;
    @p9.c("Competitions")
    private LinkedHashMap<Integer, CompetitionObj> competitions;
    @p9.c("Countries")
    private LinkedHashMap<Integer, CountryObj> countries;
    @p9.c("CurrentDate")
    private Date currentDate;
    @p9.c("Games")
    private LinkedHashMap<Integer, GameObj> games;
    @p9.c("Summary")
    public GamesSummaryObj gamesSummaryObj;
    private ArrayList<? extends yb.a> infoObject;
    private boolean isWithMainOdds;
    @p9.c("LastUpdateID")
    private long lastUpdateID;
    @p9.c("NoUpdatesForOldSequence")
    private boolean noUpdatesForOldSequence;
    @p9.c("Notifications")
    private ArrayList<NotificationObj> notifications;
    @p9.c("Paging")
    protected NewsObj.Paging paging;
    @p9.c("RadioNetworks")
    protected ArrayList<PromotedRadioObj> radioNetworks;
    @p9.c("RequestedUpdateID")
    private long requestedUpdateID;
    @p9.c("RoundFilter")
    private List<RoundFilterObj> roundFilterList;
    @p9.c("TTL")
    private long ttl;

    public GamesObj() {
        this.games = new LinkedHashMap<>();
        this.competitions = new LinkedHashMap<>();
        this.TvNetworks = new ArrayList<>();
        this.noUpdatesForOldSequence = false;
        this.isWithMainOdds = false;
    }

    public GamesObj(long j10, LinkedHashMap<Integer, GameObj> linkedHashMap, LinkedHashMap<Integer, CompetitionObj> linkedHashMap2, LinkedHashMap<Integer, CountryObj> linkedHashMap3, ArrayList<NotificationObj> arrayList, long j11, Date date, GamesSummaryObj gamesSummaryObj, boolean z10) {
        this.games = new LinkedHashMap<>();
        this.competitions = new LinkedHashMap<>();
        this.TvNetworks = new ArrayList<>();
        this.isWithMainOdds = false;
        this.lastUpdateID = j10;
        this.games = linkedHashMap;
        this.competitions = linkedHashMap2;
        this.countries = linkedHashMap3;
        this.notifications = arrayList;
        this.requestedUpdateID = j11;
        this.currentDate = date;
        this.gamesSummaryObj = gamesSummaryObj;
        this.noUpdatesForOldSequence = z10;
    }

    public ArrayList<AthleteObj> getAthletesList() {
        return this.athletesList;
    }

    public LinkedHashMap<Integer, CompetitionObj> getCompetitions() {
        return this.competitions;
    }

    public LinkedHashMap<Integer, CountryObj> getCountries() {
        return this.countries;
    }

    public CountryObj getCountryById(int i10) {
        try {
            return this.countries.get(Integer.valueOf(i10));
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public Date getCurrentData() {
        return this.currentDate;
    }

    public LinkedHashMap<Integer, GameObj> getGames() {
        return this.games;
    }

    public ArrayList<? extends yb.a> getInfoObject() {
        return this.infoObject;
    }

    public long getLastUpdateID() {
        return this.lastUpdateID;
    }

    public ArrayList<TvNetworkObj> getNetworks() {
        return this.TvNetworks;
    }

    public String getNextPage() {
        try {
            NewsObj.Paging paging = this.paging;
            if (paging != null) {
                return paging.nextPage;
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public ArrayList<NotificationObj> getNotifications() {
        return this.notifications;
    }

    public String getPreviousPage() {
        try {
            NewsObj.Paging paging = this.paging;
            if (paging != null) {
                return paging.previousPage;
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public ArrayList<PromotedRadioObj> getRadioNetworks() {
        return this.radioNetworks;
    }

    public long getRequestedUpdateID() {
        return this.requestedUpdateID;
    }

    public List<RoundFilterObj> getRoundFilterList() {
        return this.roundFilterList;
    }

    public long getTtl() {
        return this.ttl;
    }

    public boolean isNoUpdatesForOldSequence() {
        return this.noUpdatesForOldSequence;
    }

    public boolean isWithMainOdds() {
        return this.isWithMainOdds;
    }

    public void mergeGamesObj(GamesObj gamesObj) {
        if (gamesObj != null) {
            try {
                if (getCompetitions() != null && gamesObj.getCompetitions() != null) {
                    for (Integer num : gamesObj.getCompetitions().keySet()) {
                        if (getCompetitions().containsKey(num)) {
                            getCompetitions().get(num).mergeCompetitionsObj(gamesObj.getCompetitions().get(num));
                        } else {
                            getCompetitions().put(num, gamesObj.getCompetitions().get(num));
                        }
                    }
                }
                if (getCountries() != null && gamesObj.getCountries() != null) {
                    for (Integer num2 : gamesObj.getCountries().keySet()) {
                        if (!getCountries().containsKey(num2)) {
                            getCountries().put(num2, gamesObj.getCountries().get(num2));
                        }
                    }
                }
                if (getGames() == null || gamesObj.getGames() == null) {
                    return;
                }
                getGames().putAll(gamesObj.getGames());
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public void replaceDataForCompetitionFilter(GamesObj gamesObj) {
        try {
            if (gamesObj == null) {
                this.games = null;
                return;
            }
            this.games = gamesObj.getGames();
            try {
                LinkedHashMap<Integer, CompetitionObj> linkedHashMap = this.competitions;
                if (linkedHashMap != null) {
                    for (Integer num : linkedHashMap.keySet()) {
                        if (this.competitions.containsKey(num) && this.competitions.get(num) != null) {
                            this.competitions.get(num).mergeCompetitionsObj(gamesObj.getCompetitions().get(num));
                        }
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            this.noUpdatesForOldSequence = gamesObj.isNoUpdatesForOldSequence();
            this.lastUpdateID = gamesObj.getLastUpdateID();
            this.notifications = gamesObj.getNotifications();
            this.requestedUpdateID = gamesObj.getRequestedUpdateID();
            this.currentDate = gamesObj.getCurrentData();
            this.athletesList = gamesObj.getAthletesList();
            this.gamesSummaryObj = gamesObj.gamesSummaryObj;
            this.TvNetworks = gamesObj.getNetworks();
            this.bookMakerObjs = gamesObj.bookMakerObjs;
            this.radioNetworks = gamesObj.getRadioNetworks();
            this.paging = gamesObj.paging;
            this.infoObject = gamesObj.infoObject;
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    public void setGames(LinkedHashMap<Integer, GameObj> linkedHashMap) {
        this.games = linkedHashMap;
    }

    public void setInfoObject(ArrayList<? extends yb.a> arrayList) {
        this.infoObject = arrayList;
    }

    public void setLastUpdateID(long j10) {
        this.lastUpdateID = j10;
    }

    public void setWithMainOdds(boolean z10) {
        this.isWithMainOdds = z10;
    }

    public void updateNextPageLink(String str) {
        this.paging.nextPage = str;
    }

    public void updatePreviousPageLink(String str) {
        this.paging.previousPage = str;
    }
}
