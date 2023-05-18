package com.scores365.services;

import androidx.annotation.NonNull;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.scores365.App;
import com.scores365.api.i;
import com.scores365.entitys.ActiveVarEvent;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.CountryObj;
import com.scores365.entitys.EventObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GamesObj;
import com.scores365.entitys.NotificationObj;
import com.scores365.entitys.ScoreObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.entitys.StatusObj;
import com.scores365.entitys.TableObj;
import com.scores365.entitys.TopPerformerObj;
import com.scores365.entitys.VideoObj;
import com.scores365.entitys.oddsPreviewEntities.OddsPreview;
import com.scores365.gameCenter.z0;
import com.scores365.insight.InsightsObj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import li.x0;
/* compiled from: GamesUpdateEngine.java */
/* loaded from: classes2.dex */
public class b {
    private static final long DEFAULT_FREQUENCY = 30;
    public static final String EVENT_TYPE_BROADCAST = "EVENT_TYPE_BROADCAST";
    public static final String EVENT_TYPE_EVENTS = "EVENT_TYPE_EVENTS";
    private HashMap<App.c, HashSet<Integer>> LiveEntities;
    private LinkedHashMap<Integer, GameObj> allLiveGamesList;
    private String competitions;
    private String competitors;
    private String countries;
    private boolean dashBoardMode;
    private final Date date;
    private String eventType;
    private String games;
    protected i gamesApi;
    private int groupCategory;
    private int groupType;
    private boolean isFeaturedMatchContext;
    private boolean isLiveFilter;
    private boolean isSingleGame;
    private boolean isWithMainOdds;
    private GamesObj lastGamesObj;
    private long lastTimeAllLiveGamesListUpdate;
    private long lastTimeGamesListUpdate;
    public long lastUpdateId;
    private Timer liveGamesClockTimer;
    private LinkedHashMap<Integer, GameObj> liveGamesToUpdateTimeList;
    protected c onChangeListener;
    private boolean onlyVideos;
    private String parameter;
    private boolean quit;
    private long requestedLastUpdateId;
    private int sportType;
    private int topBookMaker;
    private TimerTask updateLiveGamesTimeTimerTask;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GamesUpdateEngine.java */
    /* loaded from: classes2.dex */
    public static class a implements e {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<b> f24250a;

        public a(b bVar) {
            this.f24250a = new WeakReference<>(bVar);
        }

        @Override // com.scores365.services.b.e
        public void a() {
            try {
                WeakReference<b> weakReference = this.f24250a;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                this.f24250a.get().updateLiveGamesTime();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GamesUpdateEngine.java */
    /* renamed from: com.scores365.services.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0257b extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        private final ReentrantLock f24251a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        private final e f24252b;

        public C0257b(e eVar) {
            this.f24252b = eVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ReentrantLock reentrantLock;
            try {
                if (this.f24251a.tryLock()) {
                    try {
                        e eVar = this.f24252b;
                        if (eVar != null) {
                            eVar.a();
                        }
                        reentrantLock = this.f24251a;
                    } catch (Exception e10) {
                        x0.N1(e10);
                        reentrantLock = this.f24251a;
                    }
                    reentrantLock.unlock();
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }
    }

    /* compiled from: GamesUpdateEngine.java */
    /* loaded from: classes2.dex */
    public interface c {
        void onCompetitionsUpdated(ArrayList<CompetitionObj> arrayList);

        void onCountriesUpdated(ArrayList<CountryObj> arrayList);

        void onGameAdded(GameObj gameObj);

        void onGameDeleted(GameObj gameObj);

        void onGameUpdated(GameObj gameObj);

        void onGamesUpdated(GamesObj gamesObj);

        void onNetworkError();

        void onNewVideoArrive(Vector<VideoObj> vector, GameObj gameObj);

        void onNotification(NotificationObj notificationObj, GameObj gameObj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GamesUpdateEngine.java */
    /* loaded from: classes2.dex */
    public static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<b> f24253a;

        public d(b bVar) {
            this.f24253a = new WeakReference<>(bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            try {
                WeakReference<b> weakReference = this.f24253a;
                if (weakReference == null || (bVar = weakReference.get()) == null) {
                    return;
                }
                bVar.startRun();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GamesUpdateEngine.java */
    /* loaded from: classes2.dex */
    public interface e {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        this.lastGamesObj = null;
        this.quit = false;
        this.games = "";
        this.sportType = -1;
        this.dashBoardMode = false;
        this.lastTimeGamesListUpdate = 0L;
        this.lastTimeAllLiveGamesListUpdate = 0L;
        this.liveGamesToUpdateTimeList = null;
        this.allLiveGamesList = null;
        this.liveGamesClockTimer = null;
        this.LiveEntities = new LinkedHashMap();
        this.updateLiveGamesTimeTimerTask = null;
        this.isSingleGame = false;
        this.topBookMaker = -1;
        this.isLiveFilter = false;
        this.isWithMainOdds = false;
        this.isFeaturedMatchContext = false;
        this.groupCategory = -1;
        this.groupType = -1;
        this.onChangeListener = null;
        this.date = null;
    }

    public b(String str, String str2, String str3, String str4, boolean z10, GamesObj gamesObj, int i10) {
        this.lastGamesObj = null;
        this.quit = false;
        this.games = "";
        this.sportType = -1;
        this.dashBoardMode = false;
        this.lastTimeGamesListUpdate = 0L;
        this.lastTimeAllLiveGamesListUpdate = 0L;
        this.liveGamesToUpdateTimeList = null;
        this.allLiveGamesList = null;
        this.liveGamesClockTimer = null;
        this.LiveEntities = new LinkedHashMap();
        this.updateLiveGamesTimeTimerTask = null;
        this.isSingleGame = false;
        this.topBookMaker = -1;
        this.isLiveFilter = false;
        this.isWithMainOdds = false;
        this.isFeaturedMatchContext = false;
        this.groupCategory = -1;
        this.groupType = -1;
        this.onChangeListener = null;
        init(str, str2, str3, str4, z10, gamesObj, i10);
        this.date = null;
    }

    public b(@NonNull String str, @NonNull Date date) {
        this.lastGamesObj = null;
        this.quit = false;
        this.games = "";
        this.sportType = -1;
        this.dashBoardMode = false;
        this.lastTimeGamesListUpdate = 0L;
        this.lastTimeAllLiveGamesListUpdate = 0L;
        this.liveGamesToUpdateTimeList = null;
        this.allLiveGamesList = null;
        this.liveGamesClockTimer = null;
        this.LiveEntities = new LinkedHashMap();
        this.updateLiveGamesTimeTimerTask = null;
        this.isSingleGame = false;
        this.topBookMaker = -1;
        this.isLiveFilter = false;
        this.isWithMainOdds = false;
        this.isFeaturedMatchContext = false;
        this.groupCategory = -1;
        this.groupType = -1;
        this.onChangeListener = null;
        this.sportType = -1;
        this.parameter = str;
        this.date = date;
        this.eventType = EVENT_TYPE_EVENTS;
    }

    private GamesObj addGameToArray(GameObj gameObj) {
        this.lastGamesObj.getGames().put(Integer.valueOf(gameObj.getID()), gameObj);
        long j10 = this.lastUpdateId;
        LinkedHashMap<Integer, GameObj> games = this.lastGamesObj.getGames();
        LinkedHashMap<Integer, CompetitionObj> competitions = this.lastGamesObj.getCompetitions();
        LinkedHashMap<Integer, CountryObj> countries = this.lastGamesObj.getCountries();
        ArrayList<NotificationObj> notifications = this.lastGamesObj.getNotifications();
        long j11 = this.requestedLastUpdateId;
        Date date = new Date(System.currentTimeMillis());
        GamesObj gamesObj = this.lastGamesObj;
        return new GamesObj(j10, games, competitions, countries, notifications, j11, date, gamesObj.gamesSummaryObj, gamesObj.isNoUpdatesForOldSequence());
    }

    private GamesObj deleteGameFromArray(GameObj gameObj) {
        this.lastGamesObj.getGames().remove(Integer.valueOf(gameObj.getID()));
        long j10 = this.lastUpdateId;
        LinkedHashMap<Integer, GameObj> games = this.lastGamesObj.getGames();
        LinkedHashMap<Integer, CompetitionObj> competitions = this.lastGamesObj.getCompetitions();
        LinkedHashMap<Integer, CountryObj> countries = this.lastGamesObj.getCountries();
        ArrayList<NotificationObj> notifications = this.lastGamesObj.getNotifications();
        long j11 = this.requestedLastUpdateId;
        Date date = new Date(System.currentTimeMillis());
        GamesObj gamesObj = this.lastGamesObj;
        return new GamesObj(j10, games, competitions, countries, notifications, j11, date, gamesObj.gamesSummaryObj, gamesObj.isNoUpdatesForOldSequence());
    }

    private EventObj getEventToUpdate(Vector<EventObj> vector, EventObj eventObj) {
        if (vector != null) {
            for (int i10 = 0; i10 < vector.size(); i10++) {
                if (eventObj.getNum() == vector.get(i10).getNum() && eventObj.getType() == vector.get(i10).getType()) {
                    return vector.set(i10, eventObj);
                }
            }
        }
        return null;
    }

    private GameObj getGameToUpdate(int i10) {
        return this.lastGamesObj.getGames().get(Integer.valueOf(i10));
    }

    private LinkedHashMap<Integer, GameObj> getLiveGamesForTimeProgress() {
        if (this.lastGamesObj == null) {
            return new LinkedHashMap<>(0);
        }
        LinkedHashMap<Integer, GameObj> linkedHashMap = new LinkedHashMap<>();
        try {
            if (this.lastTimeGamesListUpdate + DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL < System.currentTimeMillis()) {
                this.lastTimeGamesListUpdate = System.currentTimeMillis();
                for (GameObj gameObj : this.lastGamesObj.getGames().values()) {
                    StatusObj statusObj = App.l().getSportTypes().get(Integer.valueOf(gameObj.getSportID())).getStatuses().get(Integer.valueOf(gameObj.getStID()));
                    if (statusObj.getIsActive() && statusObj.isClockAutomaticallyProgress) {
                        linkedHashMap.put(Integer.valueOf(gameObj.getID()), gameObj);
                    }
                }
                this.liveGamesToUpdateTimeList = linkedHashMap;
                return linkedHashMap;
            }
            return this.liveGamesToUpdateTimeList;
        } catch (Exception e10) {
            x0.N1(e10);
            return linkedHashMap;
        }
    }

    private LinkedHashMap<Integer, GameObj> getLiveGamesList() {
        LinkedHashMap<Integer, GameObj> linkedHashMap = new LinkedHashMap<>();
        try {
            if (this.lastTimeAllLiveGamesListUpdate + DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL < System.currentTimeMillis()) {
                this.lastTimeAllLiveGamesListUpdate = System.currentTimeMillis();
                for (GameObj gameObj : this.lastGamesObj.getGames().values()) {
                    if (App.l().getSportTypes().get(Integer.valueOf(gameObj.getSportID())).getStatuses().get(Integer.valueOf(gameObj.getStID())).getIsActive()) {
                        linkedHashMap.put(Integer.valueOf(gameObj.getID()), gameObj);
                    }
                }
                this.allLiveGamesList = linkedHashMap;
                return linkedHashMap;
            }
            return this.allLiveGamesList;
        } catch (Exception e10) {
            x0.N1(e10);
            return linkedHashMap;
        }
    }

    @NonNull
    private Vector<VideoObj> haveNewVideos(VideoObj[] videoObjArr, @NonNull VideoObj[] videoObjArr2) {
        boolean z10;
        Vector<VideoObj> vector = new Vector<>();
        for (VideoObj videoObj : videoObjArr2) {
            if (videoObjArr != null) {
                for (VideoObj videoObj2 : videoObjArr) {
                    if (videoObj.getType() == videoObj2.getType() && videoObj.getScoreSEQ() == videoObj2.getScoreSEQ()) {
                        z10 = true;
                        break;
                    }
                }
            }
            z10 = false;
            if (!z10 && !videoObj.getURL().contains("rutube")) {
                vector.add(videoObj);
            }
        }
        return vector;
    }

    private void init(String str, String str2, String str3, String str4, boolean z10, GamesObj gamesObj, int i10) {
        this.countries = str;
        this.competitions = str2;
        this.competitors = str3;
        this.games = str4;
        this.onlyVideos = z10;
        this.lastGamesObj = gamesObj;
        this.topBookMaker = i10;
        if (gamesObj != null) {
            this.lastUpdateId = gamesObj.isNoUpdatesForOldSequence() ? 0L : gamesObj.getLastUpdateID();
            this.dashBoardMode = true;
        }
        this.eventType = EVENT_TYPE_EVENTS;
    }

    private void onGameAdded(GameObj gameObj) {
        c cVar;
        if (!Objects.equals(this.eventType, EVENT_TYPE_EVENTS) || (cVar = this.onChangeListener) == null) {
            return;
        }
        cVar.onGameAdded(gameObj);
    }

    private void onGameDeleted(GameObj gameObj) {
        c cVar;
        if (!Objects.equals(this.eventType, EVENT_TYPE_EVENTS) || (cVar = this.onChangeListener) == null) {
            return;
        }
        cVar.onGameDeleted(gameObj);
    }

    private void onGameUpdated(GameObj gameObj) {
        c cVar = this.onChangeListener;
        if (cVar != null) {
            cVar.onGameUpdated(gameObj);
        }
    }

    private void onGamesUpdated(GamesObj gamesObj) {
        c cVar;
        if (!Objects.equals(this.eventType, EVENT_TYPE_EVENTS) || (cVar = this.onChangeListener) == null) {
            return;
        }
        cVar.onGamesUpdated(gamesObj);
    }

    private void onNewVideoArrive(Vector<VideoObj> vector, GameObj gameObj) {
        c cVar;
        if (!Objects.equals(this.eventType, EVENT_TYPE_EVENTS) || (cVar = this.onChangeListener) == null) {
            return;
        }
        cVar.onNewVideoArrive(vector, gameObj);
    }

    private void onNotification(NotificationObj notificationObj, GameObj gameObj) {
        c cVar = this.onChangeListener;
        if (cVar != null) {
            cVar.onNotification(notificationObj, gameObj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRun() {
        if (this.quit) {
            return;
        }
        if (!this.dashBoardMode) {
            updateLogic(APICall());
        } else if (this.lastGamesObj != null) {
            updateLogic(APICall());
        }
    }

    private void updateCompetitions(GamesObj gamesObj) {
        if (gamesObj != null) {
            try {
                if (gamesObj.getCompetitions() != null) {
                    ArrayList<CompetitionObj> arrayList = new ArrayList<>();
                    for (CompetitionObj competitionObj : gamesObj.getCompetitions().values()) {
                        arrayList.add(competitionObj);
                        if (this.lastGamesObj.getCompetitions().get(Integer.valueOf(competitionObj.getID())) == null) {
                            this.lastGamesObj.getCompetitions().put(Integer.valueOf(competitionObj.getID()), competitionObj);
                        } else {
                            this.lastGamesObj.getCompetitions().remove(this.lastGamesObj.getCompetitions().get(Integer.valueOf(competitionObj.getID())));
                        }
                    }
                    if (this.onChangeListener == null || arrayList.isEmpty()) {
                        return;
                    }
                    this.onChangeListener.onCompetitionsUpdated(arrayList);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    private void updateCountries(GamesObj gamesObj) {
        if (gamesObj != null) {
            try {
                if (gamesObj.getCountries() != null) {
                    ArrayList<CountryObj> arrayList = new ArrayList<>();
                    for (CountryObj countryObj : gamesObj.getCountries().values()) {
                        arrayList.add(countryObj);
                        if (this.lastGamesObj.getCountries().get(Integer.valueOf(countryObj.getID())) == null) {
                            this.lastGamesObj.getCountries().put(Integer.valueOf(countryObj.getID()), countryObj);
                        } else {
                            this.lastGamesObj.getCountries().remove(this.lastGamesObj.getCountries().get(Integer.valueOf(countryObj.getID())));
                        }
                    }
                    if (this.onChangeListener == null || arrayList.isEmpty()) {
                        return;
                    }
                    this.onChangeListener.onCountriesUpdated(arrayList);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    @NonNull
    private EventObj[] updateEvents(EventObj[] eventObjArr, @NonNull EventObj[] eventObjArr2) {
        Vector<EventObj> vector = new Vector<>();
        HashMap hashMap = new HashMap();
        for (EventObj eventObj : eventObjArr2) {
            if (eventObj.getIsDel()) {
                hashMap.put(Integer.valueOf(eventObj.getType()), Integer.valueOf(eventObj.getNum()));
            }
        }
        if (eventObjArr != null) {
            for (EventObj eventObj2 : eventObjArr) {
                if (!(hashMap.containsKey(Integer.valueOf(eventObj2.getType())) && ((Integer) hashMap.get(Integer.valueOf(eventObj2.getType()))).intValue() == eventObj2.getNum())) {
                    vector.add(eventObj2);
                }
            }
        }
        for (EventObj eventObj3 : eventObjArr2) {
            if (getEventToUpdate(vector, eventObj3) == null) {
                vector.add(eventObj3);
            }
        }
        EventObj[] eventObjArr3 = new EventObj[vector.size()];
        vector.copyInto(eventObjArr3);
        return eventObjArr3;
    }

    private void updateGame(GameObj gameObj) {
        boolean z10;
        try {
            GameObj gameToUpdate = getGameToUpdate(gameObj.getID());
            if (gameToUpdate != null) {
                if (gameObj.getComps() != null) {
                    gameToUpdate.setComps(gameObj.getComps());
                }
                if (gameObj.getRoundName() != null) {
                    gameToUpdate.setRoundName(gameObj.getRoundName());
                }
                if (gameObj.getEventFilters() != null) {
                    gameToUpdate.setEventFilters(gameObj.getEventFilters());
                }
                if (gameObj.getMainOddsObj() != null) {
                    gameToUpdate.setMainOddsObj(gameObj.getMainOddsObj());
                }
                if (gameObj.getEvents() != null) {
                    gameToUpdate.setEvents(updateEvents(gameToUpdate.getEvents(), gameObj.getEvents()));
                }
                int i10 = gameObj.addedTime;
                if (i10 > -2) {
                    gameToUpdate.addedTime = i10;
                }
                double d10 = gameObj.preciseGameTime;
                if (d10 > 0.0d) {
                    gameToUpdate.preciseGameTime = d10;
                }
                if (gameObj.getGT() > -1 || gameObj.getGT() == -2) {
                    gameToUpdate.setGT(gameObj.getGT());
                }
                if (gameObj.getGTD() != null && !gameObj.getGTD().equals("")) {
                    gameToUpdate.setGTD(gameObj.getGTD());
                }
                ArrayList<Double> arrayList = gameObj.aggregatedScore;
                if (arrayList != null && !arrayList.isEmpty()) {
                    gameToUpdate.setAggregated(gameObj.getAggregatedScore());
                }
                if (gameObj.getSTime() != null) {
                    gameToUpdate.setSTime(gameObj.getSTime());
                }
                if (gameObj.getStatistics() != null) {
                    gameToUpdate.setStatistics(gameObj.getStatistics());
                }
                if ((!gameToUpdate.hasLiveTable || !gameToUpdate.getIsActive()) && (z10 = gameObj.hasLiveTable) != gameToUpdate.hasLiveTable) {
                    gameToUpdate.hasLiveTable = z10;
                }
                try {
                    if (this.liveGamesToUpdateTimeList == null) {
                        this.liveGamesToUpdateTimeList = new LinkedHashMap<>();
                    }
                    if (!gameToUpdate.getIsActive() && gameObj.getIsActive()) {
                        this.liveGamesToUpdateTimeList.put(Integer.valueOf(gameObj.getID()), gameToUpdate);
                    } else if (gameToUpdate.getIsActive() && !gameObj.getIsActive()) {
                        this.liveGamesToUpdateTimeList.remove(Integer.valueOf(gameObj.getID()));
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
                gameToUpdate.setIsActive(gameObj.getIsActive());
                gameToUpdate.autoProgressGT = gameObj.autoProgressGT;
                if (gameToUpdate.regularTimeCompletion != -1) {
                    gameToUpdate.regularTimeCompletion = gameObj.regularTimeCompletion;
                }
                TableObj tableObj = gameObj.detailTableObj;
                if (tableObj != null && tableObj.competitionTableColumn != null) {
                    gameToUpdate.detailTableObj = tableObj;
                }
                if (gameObj.getScores() != null) {
                    gameToUpdate.setScores(updateScores(gameToUpdate.getScores(), gameObj.getScores()));
                }
                if (gameObj.getServe() > 0) {
                    gameToUpdate.setServe(gameObj.getServe());
                }
                if (gameObj.getSession() > 0) {
                    gameToUpdate.setSession(gameObj.getSession());
                }
                if (gameObj.getStID() > 0) {
                    gameToUpdate.setStID(gameObj.getStID());
                }
                if (gameObj.getWinner() > -1) {
                    gameToUpdate.setWinner(gameObj.getWinner());
                }
                InsightsObj insightsObj = gameObj.insightsObj;
                if (insightsObj != null) {
                    gameToUpdate.insightsObj = insightsObj;
                }
                try {
                    if (gameObj.GetPossession() != -1) {
                        gameToUpdate.SetPossession(gameObj.GetPossession());
                    }
                    if (gameObj.isPaused() != null) {
                        gameToUpdate.setIsPaused(gameObj.isPaused().booleanValue());
                    }
                    if (!gameObj.GetWinDescription().equals("")) {
                        gameToUpdate.SetWinDescription(gameObj.GetWinDescription());
                    }
                    if (gameObj.getSportID() == SportTypesEnum.CRICKET.getValue()) {
                        int i11 = gameObj.PlayingStatus;
                        if (i11 > -1) {
                            gameToUpdate.PlayingStatus = i11;
                        }
                        if (!gameObj.FallOfWickets.isEmpty()) {
                            gameToUpdate.FallOfWickets = gameObj.FallOfWickets;
                        }
                        int i12 = gameObj.DayNum;
                        if (i12 > -1) {
                            gameToUpdate.DayNum = i12;
                        }
                        Date date = gameObj.EndDate;
                        if (date != null) {
                            gameToUpdate.EndDate = date;
                        }
                    }
                } catch (Exception e11) {
                    x0.N1(e11);
                }
                try {
                    if (gameObj.getLineUps() != null && gameObj.getLineUps().length > 0) {
                        gameToUpdate.setLineUps(gameObj.getLineUps());
                    }
                } catch (Exception e12) {
                    x0.N1(e12);
                }
                if (gameObj.getVideos() != null) {
                    Vector<VideoObj> haveNewVideos = haveNewVideos(gameToUpdate.getVideos(), gameObj.getVideos());
                    gameToUpdate.setVideos(gameObj.getVideos());
                    if (!haveNewVideos.isEmpty()) {
                        onNewVideoArrive(haveNewVideos, gameToUpdate);
                    }
                }
                try {
                    double d11 = gameObj.gameTimeCompletion;
                    if (d11 > -1.0d) {
                        gameToUpdate.gameTimeCompletion = d11;
                    }
                } catch (Exception e13) {
                    x0.N1(e13);
                }
                try {
                    int i13 = gameObj.toQualify;
                    if (i13 > -1) {
                        gameToUpdate.toQualify = i13;
                    }
                } catch (Exception e14) {
                    x0.N1(e14);
                }
                TopPerformerObj topPerformerObj = gameObj.topPerformers;
                if (topPerformerObj != null) {
                    gameToUpdate.topPerformers = topPerformerObj;
                }
                ArrayList<ActiveVarEvent> arrayList2 = gameObj.activeVarEvents;
                if (arrayList2 != null) {
                    gameToUpdate.activeVarEvents = arrayList2;
                }
                TopPerformerObj topPerformerObj2 = gameObj.probablePitchers;
                if (topPerformerObj2 != null) {
                    gameToUpdate.probablePitchers = topPerformerObj2;
                }
                z0 z0Var = gameObj.teamFoulsObj;
                if (z0Var != null) {
                    gameToUpdate.teamFoulsObj = z0Var;
                }
                try {
                    if (gameObj.getBestOddsObj() != null) {
                        gameToUpdate.setBestOddsObj(gameObj.getBestOddsObj());
                    }
                } catch (Exception e15) {
                    x0.N1(e15);
                }
                gameToUpdate.isStarted = gameObj.isStarted;
                if (gameObj.getLiveOddsObj() != null) {
                    gameToUpdate.getLiveOddsObj().c(gameObj.getLiveOddsObj());
                }
                if (gameObj.getBaseballStatusObj() != null) {
                    gameToUpdate.setBaseballStatusObj(gameObj.getBaseballStatusObj());
                }
                if (gameObj.getScoreboardObj() != null) {
                    gameToUpdate.setScoreboardObj(gameObj.getScoreboardObj());
                }
                if (gameObj.getTennisGamePointsObj() != null) {
                    gameToUpdate.setTennisGamePointsObj(gameObj.getTennisGamePointsObj());
                }
                gameToUpdate.setHockeyStrength(gameObj.getHockeyStrength());
                if (gameObj.getTennisGamePointsObj() != null) {
                    gameToUpdate.setTennisGamePointsObj(gameObj.getTennisGamePointsObj());
                }
                if (gameObj.getStatisticsFilter() != null) {
                    gameToUpdate.setStatisticsFilter(gameObj.getStatisticsFilter());
                }
                OddsPreview oddsPreview = gameObj.oddsPreview;
                if (oddsPreview != null) {
                    gameToUpdate.oddsPreview = oddsPreview;
                }
                onGameUpdated(gameToUpdate);
            } else if (gameObj.getIsNew()) {
                this.lastGamesObj = addGameToArray(gameObj);
                onGameAdded(gameObj);
            }
            if (gameObj.getIsDel()) {
                this.lastGamesObj = deleteGameFromArray(gameObj);
                onGameDeleted(gameObj);
            }
        } catch (Exception e16) {
            x0.N1(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLiveGamesTime() {
        try {
            LinkedHashMap<Integer, GameObj> liveGamesForTimeProgress = getLiveGamesForTimeProgress();
            LinkedHashMap<Integer, GameObj> liveGamesList = getLiveGamesList();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(App.c.TEAM, new HashSet());
            linkedHashMap.put(App.c.LEAGUE, new HashSet());
            linkedHashMap.put(App.c.GAME, new HashSet());
            if (liveGamesForTimeProgress != null) {
                for (GameObj gameObj : liveGamesForTimeProgress.values()) {
                    if (gameObj.isClockAutoProgress()) {
                        int i10 = gameObj.gameSeconds + 1;
                        gameObj.gameSeconds = i10;
                        if (i10 == 60) {
                            gameObj.gameSeconds = 0;
                            gameObj.gameMinute++;
                        }
                    } else {
                        gameObj.gameSeconds = 0;
                        gameObj.gameMinute = (int) gameObj.preciseGameTime;
                    }
                    ((HashSet) linkedHashMap.get(App.c.GAME)).add(Integer.valueOf(gameObj.getID()));
                    ((HashSet) linkedHashMap.get(App.c.LEAGUE)).add(Integer.valueOf(gameObj.getCompetitionID()));
                    App.c cVar = App.c.TEAM;
                    ((HashSet) linkedHashMap.get(cVar)).add(Integer.valueOf(gameObj.getComps()[0].getID()));
                    ((HashSet) linkedHashMap.get(cVar)).add(Integer.valueOf(gameObj.getComps()[1].getID()));
                }
                HashMap<App.c, HashSet<Integer>> hashMap = this.LiveEntities;
                if (hashMap == null) {
                    this.LiveEntities = new HashMap<>();
                } else {
                    hashMap.clear();
                }
                this.LiveEntities.put(App.c.GAME, new HashSet<>());
                this.LiveEntities.put(App.c.LEAGUE, new HashSet<>());
                this.LiveEntities.put(App.c.TEAM, new HashSet<>());
                if (liveGamesList != null) {
                    for (GameObj gameObj2 : liveGamesList.values()) {
                        this.LiveEntities.get(App.c.GAME).add(Integer.valueOf(gameObj2.getID()));
                        this.LiveEntities.get(App.c.LEAGUE).add(Integer.valueOf(gameObj2.getCompetitionID()));
                        if (gameObj2.getComps() != null && gameObj2.getComps().length > 1) {
                            if (gameObj2.getComps()[0] != null) {
                                this.LiveEntities.get(App.c.TEAM).add(Integer.valueOf(gameObj2.getComps()[0].getID()));
                            }
                            if (gameObj2.getComps()[1] != null) {
                                this.LiveEntities.get(App.c.TEAM).add(Integer.valueOf(gameObj2.getComps()[1].getID()));
                            }
                        }
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void updateLogic(GamesObj gamesObj) {
        updateLogic(gamesObj, false);
    }

    private void updateLogic(GamesObj gamesObj, boolean z10) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long j10 = DEFAULT_FREQUENCY;
        long millis = timeUnit.toMillis(DEFAULT_FREQUENCY);
        boolean z11 = true;
        try {
            if (gamesObj != null) {
                if (gamesObj.getTtl() >= 10) {
                    j10 = gamesObj.getTtl();
                }
                millis = timeUnit.toMillis(j10);
                if (gamesObj.isNoUpdatesForOldSequence()) {
                    z11 = false;
                }
                if (this.isFeaturedMatchContext && this.lastGamesObj == null) {
                    this.lastGamesObj = gamesObj;
                }
                long j11 = 0;
                if (this.lastGamesObj != null) {
                    this.requestedLastUpdateId = gamesObj.getRequestedUpdateID();
                    if (this.lastUpdateId < gamesObj.getLastUpdateID()) {
                        if (!z10) {
                            updateCountries(gamesObj);
                        }
                        updateCompetitions(gamesObj);
                        try {
                            if (gamesObj.getGames() != null && !gamesObj.getGames().isEmpty()) {
                                for (GameObj gameObj : gamesObj.getGames().values()) {
                                    updateGame(gameObj);
                                }
                            }
                            updateNotifications(gamesObj);
                        } catch (Exception unused) {
                        }
                    }
                    GamesObj gamesObj2 = this.lastGamesObj;
                    if (gamesObj2 != null) {
                        gamesObj2.setLastUpdateID(gamesObj.isNoUpdatesForOldSequence() ? 0L : gamesObj.getLastUpdateID());
                    }
                } else {
                    this.lastGamesObj = gamesObj;
                    this.requestedLastUpdateId = gamesObj.getRequestedUpdateID();
                    onGamesUpdated(gamesObj);
                }
                if (!gamesObj.isNoUpdatesForOldSequence()) {
                    j11 = gamesObj.getLastUpdateID();
                }
                this.lastUpdateId = j11;
            } else {
                onGamesUpdated(null);
            }
        } catch (Exception unused2) {
        }
        if (!z11) {
            millis = 1000;
        }
        if (this.quit) {
            return;
        }
        App.u().schedule(new d(this), millis, TimeUnit.MILLISECONDS);
    }

    private void updateNotifications(GamesObj gamesObj) {
        if (gamesObj.getNotifications() != null) {
            for (int i10 = 0; i10 < gamesObj.getNotifications().size(); i10++) {
                try {
                    NotificationObj notificationObj = gamesObj.getNotifications().get(i10);
                    onNotification(notificationObj, getGameToUpdate(notificationObj.getEntId()));
                } catch (Exception unused) {
                }
            }
        }
    }

    private ScoreObj[] updateScores(ScoreObj[] scoreObjArr, ScoreObj[] scoreObjArr2) {
        ScoreObj[] scoreObjArr3 = new ScoreObj[scoreObjArr2.length];
        for (int i10 = 0; i10 < scoreObjArr2.length; i10++) {
            ScoreObj scoreObj = scoreObjArr2[i10];
            if (scoreObj.getScore() > -2) {
                scoreObjArr3[i10] = scoreObj;
            } else {
                scoreObjArr3[i10] = scoreObjArr[i10];
            }
        }
        return scoreObjArr3;
    }

    protected GamesObj APICall() {
        c cVar;
        try {
            String str = this.parameter;
            if (str == null || str.isEmpty()) {
                int i10 = this.sportType;
                if (i10 > -1) {
                    this.gamesApi = new i(i10, this.lastUpdateId);
                } else {
                    this.gamesApi = new i(this.lastUpdateId, this.countries, this.competitions, this.competitors, this.games, this.onlyVideos);
                }
            } else {
                this.gamesApi = new i(this.parameter, this.lastUpdateId, this.date);
            }
            this.gamesApi.g(this.isSingleGame);
            this.gamesApi.f(this.isLiveFilter);
            this.gamesApi.j(this.isWithMainOdds);
            this.gamesApi.i(this.topBookMaker);
            int i11 = this.groupCategory;
            if (i11 > -1) {
                this.gamesApi.b(i11);
            } else {
                int i12 = this.groupType;
                if (i12 > -1) {
                    this.gamesApi.c(i12);
                }
            }
            this.gamesApi.call();
            if (this.gamesApi.error && (cVar = this.onChangeListener) != null) {
                cVar.onNetworkError();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.gamesApi.a();
    }

    public GamesObj getGames() {
        return this.lastGamesObj;
    }

    public boolean isEngineRunning() {
        return !this.quit;
    }

    public void requestStop() {
        this.quit = true;
        try {
            Timer timer = this.liveGamesClockTimer;
            if (timer != null) {
                timer.cancel();
                this.liveGamesClockTimer.purge();
            }
            this.liveGamesClockTimer = null;
            TimerTask timerTask = this.updateLiveGamesTimeTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.updateLiveGamesTimeTimerTask = null;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setEventsType(String str) {
        this.eventType = str;
    }

    public void setFeaturedMatchContext(boolean z10) {
        this.isFeaturedMatchContext = z10;
    }

    public void setGames(String str) {
        this.games = str;
    }

    public void setGroupCategory(int i10) {
        this.groupCategory = i10;
    }

    public void setGroupType(int i10) {
        this.groupType = i10;
    }

    public void setIsLiveFilter(boolean z10) {
        this.isLiveFilter = z10;
    }

    public void setIsSingleGame(boolean z10) {
        this.isSingleGame = z10;
    }

    public void setLastGamesObj(GamesObj gamesObj) {
        this.lastGamesObj = gamesObj;
    }

    public void setLastUpdateId(long j10) {
        this.lastUpdateId = j10;
    }

    public void setOnChangeListener(c cVar) {
        this.onChangeListener = cVar;
    }

    public void setQuit(boolean z10) {
        try {
            this.quit = z10;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setTopBookmaker(int i10) {
        if (i10 > -1) {
            this.topBookMaker = i10;
        }
    }

    public void setWithMainOdds(boolean z10) {
        this.isWithMainOdds = z10;
    }

    public void start(boolean z10) {
        try {
            App.u().schedule(new d(this), TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
            if (z10) {
                startLiveGamesForTimeAutomaticProgress();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void startLiveGamesForTimeAutomaticProgress() {
        try {
            try {
                Timer timer = this.liveGamesClockTimer;
                if (timer != null) {
                    timer.cancel();
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            TimerTask timerTask = this.updateLiveGamesTimeTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
                this.updateLiveGamesTimeTimerTask = null;
            }
            this.updateLiveGamesTimeTimerTask = new C0257b(new a(this));
            Timer timer2 = new Timer();
            this.liveGamesClockTimer = timer2;
            timer2.scheduleAtFixedRate(this.updateLiveGamesTimeTimerTask, 1L, 1000L);
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    public void updateAllScoresGamesAfterFetchingMissingGamesForCompetition(GamesObj gamesObj) {
        try {
            GamesObj gamesObj2 = this.lastGamesObj;
            if (gamesObj2 != null) {
                gamesObj2.mergeGamesObj(gamesObj);
            } else {
                this.lastGamesObj = gamesObj;
            }
            updateLogic(gamesObj, true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
