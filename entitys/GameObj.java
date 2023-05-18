package com.scores365.entitys;

import android.content.Context;
import com.facebook.internal.security.CertificateUtil;
import com.scores365.App;
import com.scores365.bets.model.BetLine;
import com.scores365.entitys.PlayerObj;
import com.scores365.entitys.WidgetObj;
import com.scores365.entitys.notificationEntities.ExtraScoreObj;
import com.scores365.entitys.oddsPreviewEntities.OddsPreview;
import com.scores365.gameCenter.i0;
import com.scores365.gameCenter.z0;
import com.scores365.insight.InsightsObj;
import com.scores365.www.WhoWillWinObj;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class GameObj implements Serializable, IGsonEntity<Integer> {
    public static int WINNER_AWAY = 2;
    public static int WINNER_HOME = 1;
    public static int WINNER_NONE = -1;
    private static final long serialVersionUID = -606064047481117170L;
    @p9.c("EndDate")
    public Date EndDate;
    @p9.c("Active")
    protected boolean active;
    @p9.c("BestOdds")
    protected BestOddsObj bestOddsObj;
    @p9.c("Comp")
    protected int competitionId;
    @p9.c("Comps")
    protected CompObj[] comps;
    @p9.c("Table")
    public TableObj detailTableObj;
    @p9.c("EventsFilters")
    private EventFilterObj[] eventFilters;
    @p9.c("EventsGroups")
    private ArrayList<BaseObj> eventGroups;
    @p9.c("Events")
    protected EventObj[] events;
    @p9.c("ExtraScores")
    public ArrayList<ExtraScoreObj> extraScore;
    @p9.c("GameIsAboutToStart")
    private boolean gameIsAboutToStart;
    @p9.c("Name")
    public String gameName;
    @p9.c("Summary")
    public GameSummaryObj gameSummaryObj;
    @p9.c("GT")
    protected float gt;
    @p9.c("GTD")
    protected String gtd;
    @p9.c(alternate = {"HasChartEvents"}, value = "HasShotChart")
    public boolean hasChartEvents;
    @p9.c("HasLiveVsKickoff")
    public boolean hasLiveVsKickoff;
    @p9.c("HasMedals")
    public boolean hasMedals;
    @p9.c("HasMorePredictions")
    boolean hasMorePrediction;
    @p9.c("HasTable")
    public boolean hasTable;
    @p9.c("HasTips")
    private boolean hasTips;
    @p9.c("HasTrends")
    public boolean hasTrend;
    @p9.c("HasVideo")
    public boolean hasVideo;
    @p9.c("HasWinProbability")
    private boolean hasWinProbability;
    @p9.c("HockeyStrength")
    protected HockeyStrength hockeyStrength;
    @p9.c("ID")

    /* renamed from: id  reason: collision with root package name */
    protected int f23589id;
    @p9.c("PromotedInsights")
    public InsightsObj insightsObj;
    @p9.c("NotInSquad")
    private boolean isNotInSquad;
    @p9.c("TopTrendsAvailable")
    private boolean isTopTrendAvailable;
    @p9.c("JustFinished")
    public boolean justFinished;
    @p9.c("LastMatches")
    public ArrayList<GameObj> lastMatchesList;
    @p9.c("Lineups")
    protected LineUpsObj[] lineUps;
    @p9.c("LiveOdds")
    protected kg.b liveOddsObj;
    @p9.c("MainOdds")
    private BetLine mainOddsObj;
    @p9.c("MatchFacts")
    public MatchFactsObj[] matchFacts;
    @p9.c("Medals")
    public ArrayList<MedalObj> medalsList;
    @p9.c("NotPlaying")
    public boolean notPlaying;
    @p9.c("Officials")
    public ArrayList<PlayerObj> officialsList;
    @p9.c("OlympicSID")
    public int olympicSportId;
    @p9.c("OnTV")
    protected boolean onTv;
    private ArrayList<PlayByPlayObj> playByPlayDataList;
    @p9.c("PostGamePitchers")
    public TopPerformerObj postGamePitchers;
    @p9.c("PromotedPredictions")
    com.scores365.gameCenter.Predictions.b predictionObj;
    @p9.c("ProbablePitchers")
    public TopPerformerObj probablePitchers;
    @p9.c("RadioNetworks")
    protected ArrayList<TvNetworkObj> radioNetworks;
    @p9.c("Round")
    protected int round;
    @p9.c("RoundName")
    private String roundName;
    @p9.c("STime")
    protected Date sTime;
    @p9.c("Scrs")
    protected ScoreObj[] scores;
    @p9.c("Score")
    private int[] seriesScore;
    @p9.c("ServNum")
    protected int serve;
    @p9.c("Season")
    protected int session;
    @p9.c("ShowCountdown")
    public boolean showCountDown;
    @p9.c("ShowMissingPlayersWidget")
    private boolean showMissingPlayersWidget;
    @p9.c("ShowPlayByPlay")
    public boolean showPlayByPlay;
    @p9.c("SID")
    protected int sportId;
    @p9.c("Spread")
    public String spread;
    @p9.c("Staff")
    public LineUpsObj[] staff;
    @p9.c("StageTimes")
    public LinkedHashMap<Integer, StageTimeObj> stageTimes;
    @p9.c("Statistics")
    protected StatObj[] statistics;
    @p9.c("StatisticsFilters")
    private List<StatisticsFilter> statisticsFilter;
    @p9.c("STID")
    protected int stid;
    @p9.c("CurrentPointByPointGame")
    private TennisGamePointsObj tennisGamePointsObj;
    @p9.c("TopPerformers")
    public TopPerformerObj topPerformers;
    @p9.c("PromotedTrends")
    private ed.d trendPageObject;
    @p9.c("TrendingItems")
    public ArrayList<TrendingItem> trendingItems;
    @p9.c("MissingPlayers")
    public LineUpsObj[] unavailablePlayers;
    @p9.c("Venue")
    public VenueObj venueObj;
    @p9.c("Videos")
    protected VideoObj[] videos;
    @p9.c("WidgetsProviders")
    public ArrayList<String> widgetProviders;
    @p9.c("WinningProbabilityInsights")
    private InsightsObj winningProbabilityInsights;
    @p9.c("WhoWillWinReults")
    public WhoWillWinObj wwwObj;
    public int gameMinute = -1;
    public int gameSeconds = 0;
    @p9.c("TopBookmaker")
    protected int topBookMaker = -1;
    @p9.c("Surface")
    protected int surface = -1;
    @p9.c("TVNetworks")
    public LinkedHashSet<TvNetworkObj> TvNetworks = new LinkedHashSet<>();
    @p9.c("Winner")
    protected int winner = -1;
    @p9.c("IsNew")
    protected boolean isNew = false;
    @p9.c("IsDel")
    protected boolean isDel = false;
    @p9.c("HasStatistics")
    protected boolean haveStatistics = false;
    @p9.c("HasLineups")
    protected boolean haveLineUps = false;
    @p9.c("HasPlayByPlay")
    public boolean hasPlayByPlay = false;
    @p9.c("Possession")
    protected int Possession = -1;
    @p9.c("Paused")
    protected Boolean Paused = Boolean.FALSE;
    @p9.c("WinDescription")
    protected String WinDescription = "";
    @p9.c("Group")
    protected int Group = -1;
    @p9.c("PhaseName")
    public String phaseName = "";
    @p9.c("Stage")
    protected int Stage = -1;
    @p9.c("HasBets")
    protected boolean hasBets = false;
    @p9.c("HasFieldPositions")
    public boolean HasFieldPositions = false;
    @p9.c("HasGalleries")
    public boolean HasGalleries = false;
    @p9.c("SocialStats")
    public SocialStatsObj socialStatsObj = null;
    @p9.c("HasBuzz")
    public boolean hasBuzz = false;
    @p9.c("Buzz")
    public NewsObj gameBuzzObj = null;
    @p9.c("PreciseGT")
    public double preciseGameTime = -1.0d;
    @p9.c("Completion")
    public double gameTimeCompletion = -1.0d;
    @p9.c("AggregatedScore")
    public ArrayList<Double> aggregatedScore = new ArrayList<>();
    @p9.c("ToQualify")
    public int toQualify = 0;
    @p9.c("EventsCategories")
    public int eventsCategories = 0;
    @p9.c("RegularTimeCompletion")
    public int regularTimeCompletion = 0;
    @p9.c("AutoProgressGT")
    public Boolean autoProgressGT = null;
    @p9.c("InSeries")
    public boolean InSeries = false;
    @p9.c("SeriesScore")
    public ArrayList<Double> SeriesScore = new ArrayList<>();
    @p9.c("LTID")
    public long liveTracketGameId = -1;
    @p9.c("ShowTracker")
    public boolean showTracker = false;
    @p9.c("LmtPage")
    public String matchTrackerpageLink = "";
    @p9.c("Widgets")
    private ArrayList<WidgetObj> widgetObjs = new ArrayList<>();
    @p9.c("Countdown")
    public long gameStartCountDown = -1;
    @p9.c("PlayByPlayFeedURL")
    public String PlayByPlayFeedURL = "";
    @p9.c("PlayByPlayPreviewURL")
    public String PlayByPlayPreviewURL = "";
    @p9.c("HasNews")
    public boolean hasNews = false;
    @p9.c("TeamFouls")
    public z0 teamFoulsObj = null;
    @p9.c("News")
    public NewsObj gameNewsObj = null;
    @p9.c("Attendance")
    public int attendance = -1;
    @p9.c("AddedTime")
    public int addedTime = -2;
    @p9.c("ShowMomentum")
    public boolean showMomentum = false;
    @p9.c("HasLiveTable")
    public boolean hasLiveTable = false;
    @p9.c("HasMissingPlayers")
    public boolean hasMissingPlayers = false;
    @p9.c("Notifications")
    private HashMap<Integer, LatestNotifications> _latestNotifications = new LinkedHashMap();
    @p9.c("DayNum")
    public int DayNum = -1;
    @p9.c("PlayingStatus")
    public int PlayingStatus = -1;
    @p9.c("CurrFallOfWickets")
    public ArrayList<FallOfWicketObj> FallOfWickets = new ArrayList<>();
    @p9.c("OnRadio")
    protected boolean onRadio = false;
    @p9.c("HasDoubtful")
    public boolean hasDoubtful = false;
    @p9.c("ShowStatsCard")
    public boolean showStatsCard = false;
    @p9.c("HasInsights")
    public boolean hasInsights = false;
    @p9.c("HasBetsTeaser")
    public boolean hasBetsTeaser = false;
    @p9.c("IsStarted")
    public boolean isStarted = false;
    @p9.c("EditorsChoice")
    private boolean editorsChoice = false;
    @p9.c("EditorsShowSportType")
    private boolean editorsShowSportType = false;
    @p9.c("EditorsPromotedOdds")
    private boolean editorsPromotedOdds = false;
    @p9.c("HasMatchFacts")
    public boolean hasMatchFacts = false;
    @p9.c("ActiveVarEvents")
    public ArrayList<ActiveVarEvent> activeVarEvents = null;
    @p9.c("HomeAwayTeamOrder")
    public int homeAwayTeamOrder = 1;
    @p9.c("ShowScoreboard")
    public boolean showScoreboard = false;
    @p9.c("BaseballStatus")
    private BaseballStatusObj baseballStatusObj = null;
    @p9.c("Scoreboard")
    private ScoreboardObj scoreboardObj = null;
    @p9.c("ExtraData")
    private ArrayList<LastMatchExtraDataEntryObj> extraData = null;
    @p9.c("H2HLayout")
    private String h2hLayout = null;
    @p9.c("ExtraDataTitle")
    private String extraDataTitle = null;
    @p9.c("ShowInHalfExpandedMode")
    public boolean showInHalfExpandedMode = false;
    @p9.c("OddsPreview")
    public OddsPreview oddsPreview = null;
    @p9.c("GameStatusTitle")
    private String gameStatusTitle = null;
    @p9.c("AtsRecords")
    public AtsRecords atsRecords = null;
    @p9.c("HasPointByPoint")
    private boolean hasPointByPoint = false;

    /* loaded from: classes2.dex */
    public static class LatestNotifications implements Serializable {
        public int ID;
        public String Name;
        private int competitorNum;
        public long expiredTime;
        public boolean isAlreadyRender;

        public LatestNotifications() {
            this.expiredTime = -1L;
            this.isAlreadyRender = false;
            this.competitorNum = -1;
        }

        public LatestNotifications(int i10, String str, long j10, int i11) {
            this.isAlreadyRender = false;
            this.ID = i10;
            this.Name = str;
            this.expiredTime = j10;
            this.competitorNum = i11;
        }

        public boolean IsNotificationExpired() {
            return System.currentTimeMillis() > this.expiredTime;
        }

        public int getCompetitorNum() {
            return this.competitorNum;
        }
    }

    public static boolean shouldUseLmtPbpPreviewForSportType(int i10) {
        try {
            if (i10 != SportTypesEnum.AMERICAN_FOOTBALL.getValue() && i10 != SportTypesEnum.BASKETBALL.getValue()) {
                if (i10 != SportTypesEnum.HOCKEY.getValue()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public void AddNotification(int i10, String str, int i11, int i12) {
        try {
            this._latestNotifications.put(Integer.valueOf(i10), new LatestNotifications(i10, str, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(i11), i12));
        } catch (Exception unused) {
        }
    }

    public LinkedHashSet<PlayerObj> GetCurrBatters() {
        PlayerObj[] players;
        LinkedHashSet<PlayerObj> linkedHashSet = new LinkedHashSet<>();
        try {
            for (LineUpsObj lineUpsObj : this.lineUps) {
                for (PlayerObj playerObj : lineUpsObj.getPlayers()) {
                    if (playerObj.IsCurrBatter) {
                        linkedHashSet.add(playerObj);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return linkedHashSet;
    }

    public LatestNotifications GetLatestNotification() {
        LatestNotifications latestNotifications = null;
        try {
            long j10 = 0;
            for (LatestNotifications latestNotifications2 : this._latestNotifications.values()) {
                if (latestNotifications2 != null && !latestNotifications2.IsNotificationExpired()) {
                    long j11 = latestNotifications2.expiredTime;
                    if (j11 > j10) {
                        latestNotifications = latestNotifications2;
                        j10 = j11;
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return latestNotifications;
    }

    public List<EventObj> GetMajorEvents(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            if (this.events != null) {
                int i10 = 0;
                while (true) {
                    EventObj[] eventObjArr = this.events;
                    if (i10 >= eventObjArr.length) {
                        break;
                    }
                    try {
                        EventObj eventObj = eventObjArr[i10];
                        EventTypeObj eventByIndex = App.l().getSportTypes().get(Integer.valueOf(this.sportId)).getEventByIndex(eventObj.getType());
                        if (eventByIndex.Major && !eventObj.getIsDel()) {
                            eventObj.eventTypeID = eventByIndex.getID();
                            arrayList.add(eventObj);
                        }
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                    i10++;
                }
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
        return arrayList;
    }

    public String GetPhaseName() {
        return this.phaseName;
    }

    public int GetPossession() {
        return this.Possession;
    }

    public String GetWinDescription() {
        return this.WinDescription;
    }

    public boolean IsHaveNotification() {
        return GetLatestNotification() != null;
    }

    public void SetPossession(int i10) {
        this.Possession = i10;
    }

    public void SetWinDescription(String str) {
        this.WinDescription = str;
    }

    public ArrayList<ActiveVarEvent> getActiveVarEvents() {
        return this.activeVarEvents;
    }

    public ArrayList<Double> getAggregatedScore() {
        return this.aggregatedScore;
    }

    public AtsRecords getAtsRecords() {
        return this.atsRecords;
    }

    public BaseballStatusObj getBaseballStatusObj() {
        return this.baseballStatusObj;
    }

    public BestOddsObj getBestOddsObj() {
        return this.bestOddsObj;
    }

    public int getCompetitionID() {
        return this.competitionId;
    }

    public CompObj[] getComps() {
        return this.comps;
    }

    public EventFilterObj[] getEventFilters() {
        return this.eventFilters;
    }

    public ArrayList<BaseObj> getEventGroups() {
        return this.eventGroups;
    }

    public EventObj[] getEvents() {
        return this.events;
    }

    public ArrayList<LastMatchExtraDataEntryObj> getExtraData() {
        return this.extraData;
    }

    public String getExtraDataTitle() {
        return this.extraDataTitle;
    }

    public int getGT() {
        return (int) this.gt;
    }

    public String getGTD() {
        try {
            String str = this.gtd;
            if (str != null && !str.isEmpty()) {
                return this.gtd;
            }
            return "";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public int getGameMinutes() {
        try {
            return (int) this.preciseGameTime;
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getGameSeconds(double d10) {
        return (int) ((d10 - ((int) d10)) * 60.0d);
    }

    public String getGameStatusForDfp() {
        try {
            StatusObj statusObj = getStatusObj();
            return statusObj.getIsFinished() ? "Finished" : statusObj.getIsActive() ? "Live" : "NotStarted";
        } catch (Exception e10) {
            x0.N1(e10);
            return "NotStarted";
        }
    }

    public String getGameStatusName() {
        return isGameStatusTitleExist() ? this.gameStatusTitle : getStatusName();
    }

    public String getGameStatusTitle() {
        return this.gameStatusTitle;
    }

    public String getGameTimeToDisplay() {
        String str = "";
        try {
            String str2 = this.gtd;
            if (str2 != null && !str2.equals("")) {
                str = this.gtd;
            } else if (this.gt > 0.0f) {
                str = String.valueOf(this.gt) + "'";
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return str;
    }

    public int getGroup() {
        return this.Group;
    }

    public String getH2hLayout() {
        return this.h2hLayout;
    }

    public boolean getHaveLineUps() {
        return this.haveLineUps;
    }

    public boolean getHaveStatistics() {
        return this.haveStatistics;
    }

    public HockeyShotsHelper getHockeyShotsHelper() {
        HockeyShotsHelper hockeyShotsHelper = null;
        try {
            StatObj[] statObjArr = this.statistics;
            if (statObjArr == null || statObjArr.length <= 0) {
                return null;
            }
            int length = statObjArr.length;
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                StatObj statObj = statObjArr[i10];
                if (statObj.getType() == 5) {
                    hockeyShotsHelper = new HockeyShotsHelper(statObj.getVals()[0], statObj.getVals()[1], p0.l0("SHOTS_POWER_PLAY_HOCKEY"));
                    z10 = true;
                    break;
                }
                i10++;
            }
            return !z10 ? new HockeyShotsHelper("0", "0", p0.l0("SHOTS_POWER_PLAY_HOCKEY")) : hockeyShotsHelper;
        } catch (Exception e10) {
            x0.N1(e10);
            return hockeyShotsHelper;
        }
    }

    public HockeyStrength getHockeyStrength() {
        return this.hockeyStrength;
    }

    public int getID() {
        return this.f23589id;
    }

    public String getInningScore(int i10, int i11, boolean z10) {
        String str = "";
        try {
            if (i11 == 1) {
                if (i10 == 1) {
                    if (this.scores[2].getScore() != -1 && this.scores[4].getScore() != -1) {
                        str = String.valueOf(this.scores[2].getScore()) + "/" + String.valueOf(this.scores[4].getScore());
                    }
                    if (!z10 || this.scores[6].getScore() == -1) {
                        return str;
                    }
                    return str + " (" + String.valueOf(this.scores[6].getStringScore()) + ")";
                } else if (i10 == 2) {
                    if (this.scores[3].getScore() != -1 && this.scores[5].getScore() != -1) {
                        str = String.valueOf(this.scores[3].getScore()) + "/" + String.valueOf(this.scores[5].getScore());
                    }
                    if (!z10 || this.scores[7].getScore() == -1) {
                        return str;
                    }
                    return str + " (" + String.valueOf(this.scores[7].getStringScore()) + ")";
                } else {
                    return "";
                }
            } else if (i11 == 2 && hasSecondInning()) {
                if (i10 == 1) {
                    if (this.scores[8].getScore() != -1 && this.scores[10].getScore() != -1) {
                        str = String.valueOf(this.scores[8].getScore()) + "/" + String.valueOf(this.scores[10].getScore());
                    }
                    if (!z10 || this.scores[12].getScore() == -1) {
                        return str;
                    }
                    return str + " (" + String.valueOf(this.scores[12].getStringScore()) + ")";
                } else if (i10 == 2) {
                    if (this.scores[9].getScore() != -1 && this.scores[11].getScore() != -1) {
                        str = String.valueOf(this.scores[9].getScore()) + "/" + String.valueOf(this.scores[11].getScore());
                    }
                    if (!z10 || this.scores[13].getScore() == -1) {
                        return str;
                    }
                    return str + " (" + String.valueOf(this.scores[13].getStringScore()) + ")";
                } else {
                    return "";
                }
            } else {
                return "";
            }
        } catch (Exception unused) {
            return "";
        }
    }

    public boolean getIsActive() {
        return this.active;
    }

    public boolean getIsDel() {
        return this.isDel;
    }

    public boolean getIsNew() {
        return this.isNew;
    }

    public boolean getIsOnTV() {
        try {
            if (this.onTv) {
                return this.TvNetworks.size() > 0;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.IGsonEntity
    public Integer getKey() {
        return Integer.valueOf(getID());
    }

    public WidgetObj getLMTWidget() {
        try {
            ArrayList<WidgetObj> arrayList = this.widgetObjs;
            if (arrayList != null) {
                Iterator<WidgetObj> it = arrayList.iterator();
                while (it.hasNext()) {
                    WidgetObj next = it.next();
                    if (next.getWidgetType() == WidgetObj.eWidgetType.LMT) {
                        return next;
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public ActiveVarEvent getLatestActiveVarEvent() {
        try {
            ArrayList<ActiveVarEvent> arrayList = this.activeVarEvents;
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            return this.activeVarEvents.get(0);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public LineUpsObj[] getLineUps() {
        return this.lineUps;
    }

    public PlayerObj[] getLineUpsForCompetitor(int i10) {
        LineUpsObj[] lineUps;
        PlayerObj[] playerObjArr = new PlayerObj[0];
        try {
            if (getLineUps() != null) {
                for (LineUpsObj lineUpsObj : getLineUps()) {
                    if (lineUpsObj.getCompNum() == i10) {
                        return lineUpsObj.getPlayers();
                    }
                }
                return playerObjArr;
            }
            return playerObjArr;
        } catch (Exception e10) {
            x0.N1(e10);
            return playerObjArr;
        }
    }

    public String getLiveGameTime() {
        StatusObj statusObj;
        int i10;
        StringBuilder sb2 = new StringBuilder();
        try {
            statusObj = App.l().getSportTypes().get(Integer.valueOf(this.sportId)).getStatuses().get(Integer.valueOf(this.stid));
            if (this.gameMinute < 0) {
                this.gameMinute = (int) this.gt;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (this.addedTime <= 0 && !isClockAutoProgress() && ((i10 = this.gameMinute) < statusObj.statusTimeOnStart - 1 || i10 >= statusObj.statusTimeOnFinish)) {
            sb2.append(statusObj.statusTimeOnFinish);
            sb2.append(":00");
            return sb2.toString();
        }
        sb2.append(this.gameMinute);
        sb2.append(CertificateUtil.DELIMITER);
        if (this.gameSeconds < 10) {
            sb2.append("0");
        }
        sb2.append(this.gameSeconds);
        return sb2.toString();
    }

    public kg.b getLiveOddsObj() {
        return this.liveOddsObj;
    }

    public TvNetworkObj getLiveStreamingNetwork() {
        try {
            if (getTvNetworks() != null) {
                Iterator<TvNetworkObj> it = this.TvNetworks.iterator();
                while (it.hasNext()) {
                    TvNetworkObj next = it.next();
                    if (!next.isLiveStream() || (!next.getTvLinks().get(0).isTwitch() && !next.getTvLinks().get(0).isYoutube())) {
                    }
                    return next;
                }
                return null;
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public BetLine getMainOddsObj() {
        return this.mainOddsObj;
    }

    public MatchFactsObj[] getMatchFactsObj() {
        return this.matchFacts;
    }

    public WidgetObj getMomentumWidget() {
        try {
            ArrayList<WidgetObj> arrayList = this.widgetObjs;
            if (arrayList != null) {
                Iterator<WidgetObj> it = arrayList.iterator();
                while (it.hasNext()) {
                    WidgetObj next = it.next();
                    if (next.getWidgetType() == WidgetObj.eWidgetType.Momentum) {
                        return next;
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public void getNotificationsFromGameObj(GameObj gameObj) {
        try {
            HashMap<Integer, LatestNotifications> hashMap = this._latestNotifications;
            if (hashMap == null || hashMap.isEmpty()) {
                this._latestNotifications = gameObj._latestNotifications;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public VideoObj getOfficialVideoObj() {
        try {
            VideoObj[] videoObjArr = this.videos;
            if (videoObjArr != null) {
                for (VideoObj videoObj : videoObjArr) {
                    if (videoObj.isShowOnMain()) {
                        return videoObj;
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public ArrayList<PlayByPlayObj> getPlayByPlayDataList() {
        return this.playByPlayDataList;
    }

    public String getPlayByPlayFeedURL() {
        return this.PlayByPlayFeedURL;
    }

    public String getPlayByPlayPreviewURL() {
        return this.PlayByPlayPreviewURL;
    }

    public int getPreciseGameTime() {
        double d10 = this.preciseGameTime;
        int i10 = (int) d10;
        try {
            int i11 = this.gameMinute;
            return i11 > 0 ? (int) ((d10 - i11) * 60.0d) : i10;
        } catch (Exception e10) {
            x0.N1(e10);
            return i10;
        }
    }

    public double getPreciseGameTimeField() {
        return this.preciseGameTime;
    }

    public com.scores365.gameCenter.Predictions.b getPredictionObj() {
        return this.predictionObj;
    }

    public ArrayList<TvNetworkObj> getRadioNetworks() {
        return this.radioNetworks;
    }

    public int getRound() {
        return this.round;
    }

    public String getRoundName() {
        return this.roundName;
    }

    public Date getSTime() {
        return this.sTime;
    }

    public ScoreboardObj getScoreboardObj() {
        return this.scoreboardObj;
    }

    public ScoreObj[] getScores() {
        return this.scores;
    }

    public ArrayList<ScoreObj> getScoresForStage(int i10) {
        ArrayList<ScoreObj> arrayList = new ArrayList<>();
        try {
            Iterator<Integer> it = App.l().getSportTypes().get(Integer.valueOf(this.sportId)).getStages().keySet().iterator();
            int i11 = 0;
            while (it.hasNext() && it.next().intValue() != i10) {
                i11 += 2;
            }
            arrayList.add(this.scores[i11]);
            arrayList.add(this.scores[i11 + 1]);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    public ArrayList<Double> getSeriesScore() {
        return this.SeriesScore;
    }

    public int getServe() {
        return this.serve;
    }

    public int getSession() {
        return this.session;
    }

    public String getShortGameStatusName() {
        return isGameStatusTitleExist() ? this.gameStatusTitle : getStatusShortName();
    }

    public int getSingleScore(int i10) {
        try {
            ScoreObj[] scoreObjArr = this.scores;
            if (i10 < scoreObjArr.length) {
                return scoreObjArr[i10].getScore();
            }
            return -1;
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    public String getSingleStringScore(int i10) {
        try {
            ScoreObj[] scoreObjArr = this.scores;
            return i10 < scoreObjArr.length ? scoreObjArr[i10].getStringScore() : "";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public int getSportID() {
        return this.sportId;
    }

    public int getStID() {
        return this.stid;
    }

    public LineUpsObj[] getStaff() {
        return this.staff;
    }

    public int getStage() {
        return this.Stage;
    }

    public StatObj[] getStatistics() {
        return this.statistics;
    }

    public List<StatisticsFilter> getStatisticsFilter() {
        return this.statisticsFilter;
    }

    public String getStatusName() {
        return App.l().getSportTypes().get(Integer.valueOf(getSportID())).getStatuses().get(Integer.valueOf(getStID())).getName();
    }

    public StatusObj getStatusObj() {
        return App.l().getSportTypes().get(Integer.valueOf(getSportID())).getStatuses().get(Integer.valueOf(getStID()));
    }

    public String getStatusShortName() {
        return App.l().getSportTypes().get(Integer.valueOf(getSportID())).getStatuses().get(Integer.valueOf(getStID())).getShortName();
    }

    public int getSurface() {
        return this.surface;
    }

    public String getSurfaceName() {
        SurfaceTypeObj surfaceTypeObj;
        try {
            LinkedHashMap<Integer, SportTypeObj> sportTypes = App.l() != null ? App.l().getSportTypes() : null;
            if (sportTypes != null) {
                SportTypeObj sportTypeObj = sportTypes.get(Integer.valueOf(this.sportId));
                LinkedHashMap<Integer, SurfaceTypeObj> linkedHashMap = sportTypeObj != null ? sportTypeObj.surfaceTypes : null;
                return (linkedHashMap == null || linkedHashMap.isEmpty() || (surfaceTypeObj = linkedHashMap.get(Integer.valueOf(this.surface))) == null) ? "" : surfaceTypeObj.getName();
            }
            return "";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public z0 getTeamFoulsObj() {
        return this.teamFoulsObj;
    }

    public TennisGamePointsObj getTennisGamePointsObj() {
        return this.tennisGamePointsObj;
    }

    public int getToQualify() {
        return this.toQualify;
    }

    public int getTopBookMaker() {
        return this.topBookMaker;
    }

    public ed.d getTrendPageObject() {
        return this.trendPageObject;
    }

    public ArrayList<TrendingItem> getTrendingItems() {
        return this.trendingItems;
    }

    public HashSet<TvNetworkObj> getTvNetworks() {
        return this.TvNetworks;
    }

    public VideoObj[] getVideos() {
        return this.videos;
    }

    public int getWinner() {
        return this.winner;
    }

    public InsightsObj getWinningProbabilityInsights() {
        return this.winningProbabilityInsights;
    }

    public HashMap<Integer, LatestNotifications> get_latestNotifications() {
        return this._latestNotifications;
    }

    public boolean hasBets() {
        return this.hasBets;
    }

    public boolean hasMatchFacts() {
        return this.hasMatchFacts;
    }

    public boolean hasPlayByPlay() {
        return this.hasPlayByPlay;
    }

    public boolean hasPointByPoint() {
        return this.hasPointByPoint;
    }

    public boolean hasSecondInning() {
        try {
            if (this.scores[8].getScore() == -1 && this.scores[10].getScore() == -1 && this.scores[12].getScore() == -1 && this.scores[9].getScore() == -1 && this.scores[11].getScore() == -1) {
                return this.scores[13].getScore() != -1;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public boolean hasTips() {
        return this.hasTips;
    }

    public boolean hasWinProbability() {
        return this.hasWinProbability;
    }

    public void initLatestNotifications(GamesObj gamesObj) {
        try {
            HashMap<Integer, LatestNotifications> hashMap = this._latestNotifications;
            if ((hashMap == null || hashMap.isEmpty()) && gamesObj.getNotifications() != null) {
                for (int i10 = 0; i10 < gamesObj.getNotifications().size(); i10++) {
                    NotificationObj notificationObj = gamesObj.getNotifications().get(i10);
                    AddNotification(notificationObj.getType(), notificationObj.getAnimationText(), notificationObj.getTimeOfRelevancy(), notificationObj.getCompetitorNum());
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public boolean isAbnormal() {
        return App.l().getSportTypes().get(Integer.valueOf(getSportID())).getStatuses().get(Integer.valueOf(getStID())).getIsAbnormal();
    }

    public boolean isClockAutoProgress() {
        boolean z10 = true;
        try {
            Boolean bool = this.autoProgressGT;
            if (bool != null) {
                z10 = bool.booleanValue();
            } else {
                StatusObj statusObj = App.l().getSportTypes().get(Integer.valueOf(getSportID())).getStatuses().get(Integer.valueOf(getStID()));
                if (statusObj.getIsActive()) {
                    boolean z11 = statusObj.isClockAutomaticallyProgress;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return z10;
    }

    public boolean isCompetitorHome(int i10) {
        return getComps() != null && getComps().length == 2 && getComps()[0].getID() == i10;
    }

    public boolean isEditorsChoice() {
        return this.editorsChoice;
    }

    public boolean isEditorsPromotedOdds() {
        return this.editorsPromotedOdds;
    }

    public boolean isEditorsShowSportType() {
        return this.editorsShowSportType;
    }

    public boolean isExtraTime() {
        return App.l().getSportTypes().get(Integer.valueOf(getSportID())).getStatuses().get(Integer.valueOf(getStID())).isExtraTime();
    }

    public boolean isFinished() {
        return App.l().getSportTypes().get(Integer.valueOf(getSportID())).getStatuses().get(Integer.valueOf(getStID())).getIsFinished();
    }

    public boolean isGameAboutToStart(boolean z10) {
        SportTypeObj sportTypeObj;
        StatusObj statusObj;
        try {
            if (getStatusObj().getIsActive() || (sportTypeObj = App.l().getSportTypes().get(Integer.valueOf(getSportID()))) == null || (statusObj = sportTypeObj.getStatuses().get(Integer.valueOf(getStID()))) == null) {
                return false;
            }
            if (!this.gameIsAboutToStart) {
                if (!statusObj.isShowGameIsAboutToStartUponCountDownZero() || !z10) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isGameDatePassed(Calendar calendar, Calendar calendar2) {
        try {
            return calendar2.getTime().before(calendar.getTime());
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isGameHasScores() {
        try {
            ScoreObj[] scoreObjArr = this.scores;
            if (scoreObjArr != null) {
                for (ScoreObj scoreObj : scoreObjArr) {
                    if (scoreObj.score > -1.0d) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isGameHaveLiveStreaming() {
        try {
            Iterator<TvNetworkObj> it = this.TvNetworks.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == 2) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isGameStatusTitleExist() {
        String str = this.gameStatusTitle;
        return (str == null || str.isEmpty()) ? false : true;
    }

    public boolean isGtMinusTwo() {
        return this.gt == -2.0f;
    }

    public boolean isHasMorePrediction() {
        return this.hasMorePrediction;
    }

    public boolean isHasTrend() {
        return this.hasTrend;
    }

    public boolean isInSeries() {
        return this.InSeries;
    }

    public boolean isNotInSquad() {
        return this.isNotInSquad;
    }

    public boolean isNotStarted() {
        return App.l().getSportTypes().get(Integer.valueOf(getSportID())).getStatuses().get(Integer.valueOf(getStID())).getIsNotStarted();
    }

    public boolean isOnRadio() {
        return this.onRadio;
    }

    public Boolean isPaused() {
        return this.Paused;
    }

    public boolean isPlayerManager(int i10) {
        try {
            if (getLineUps() != null) {
                for (LineUpsObj lineUpsObj : getLineUps()) {
                    PlayerObj[] players = lineUpsObj.getPlayers();
                    int length = players.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 < length) {
                            PlayerObj playerObj = players[i11];
                            if (i10 != playerObj.athleteId) {
                                i11++;
                            } else if (playerObj.getStatus() == PlayerObj.ePlayerStatus.MANAGEMENT) {
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return false;
    }

    public boolean isScheduled() {
        try {
            if (isFinished()) {
                return false;
            }
            return !getIsActive();
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isShowMissingPlayersWidget() {
        return this.showMissingPlayersWidget;
    }

    public boolean isShowPlayByPlay() {
        return this.showPlayByPlay;
    }

    public boolean isStageHasScores(int i10) {
        try {
            ArrayList<ScoreObj> scoresForStage = getScoresForStage(i10);
            if (scoresForStage.get(0).getScore() >= 0) {
                return scoresForStage.get(1).getScore() >= 0;
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isStartedOrFinished() {
        try {
            if (App.l().getSportTypes().get(Integer.valueOf(getSportID())).getStatuses().get(Integer.valueOf(getStID())).getIsNotStarted()) {
                if (!App.l().getSportTypes().get(Integer.valueOf(getSportID())).getStatuses().get(Integer.valueOf(getStID())).getIsFinished()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isTopTrendAvailable() {
        return this.isTopTrendAvailable;
    }

    public void setAggregated(ArrayList<Double> arrayList) {
        this.aggregatedScore = arrayList;
    }

    public void setBaseballStatusObj(BaseballStatusObj baseballStatusObj) {
        this.baseballStatusObj = baseballStatusObj;
    }

    public void setBestOddsObj(BestOddsObj bestOddsObj) {
        this.bestOddsObj = bestOddsObj;
    }

    public void setCompetitionID(int i10) {
        this.competitionId = i10;
    }

    public void setComps(CompObj[] compObjArr) {
        this.comps = compObjArr;
    }

    public void setEditorsChoice(boolean z10) {
        this.editorsChoice = z10;
    }

    public void setEventFilters(EventFilterObj[] eventFilterObjArr) {
        this.eventFilters = eventFilterObjArr;
    }

    public void setEventGroups(ArrayList<BaseObj> arrayList) {
        this.eventGroups = arrayList;
    }

    public void setEvents(EventObj[] eventObjArr) {
        this.events = eventObjArr;
    }

    public void setGT(int i10) {
        try {
            this.gt = i10;
            double d10 = this.preciseGameTime;
            if (d10 <= -1.0d || Math.abs(d10 - this.gameMinute) <= 1.0d) {
                return;
            }
            this.gameMinute = (int) this.preciseGameTime;
            this.gameSeconds = getPreciseGameTime();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setGTD(String str) {
        this.gtd = str;
    }

    public void setHaveLineUps(boolean z10) {
        this.haveLineUps = z10;
    }

    public void setHaveStatisrics(boolean z10) {
        this.haveStatistics = z10;
    }

    public void setHockeyStrength(HockeyStrength hockeyStrength) {
        this.hockeyStrength = hockeyStrength;
    }

    public void setIsActive(boolean z10) {
        this.active = z10;
    }

    public void setIsDel(boolean z10) {
        this.isDel = z10;
    }

    public void setIsNew(boolean z10) {
        this.isNew = z10;
    }

    public void setIsPaused(boolean z10) {
        this.Paused = Boolean.valueOf(z10);
    }

    public void setLineUps(LineUpsObj[] lineUpsObjArr) {
        try {
            if (this.lineUps == null) {
                this.lineUps = lineUpsObjArr;
                return;
            }
            for (int i10 = 0; i10 < lineUpsObjArr.length; i10++) {
                for (int i11 = 0; i11 < lineUpsObjArr[i10].getPlayers().length; i11++) {
                    PlayerObj playerObj = lineUpsObjArr[i10].getPlayers()[i11];
                    int i12 = 0;
                    while (true) {
                        if (i12 >= this.lineUps[i10].getPlayers().length) {
                            break;
                        } else if (playerObj.pId == this.lineUps[i10].getPlayers()[i12].pId) {
                            this.lineUps[i10].getPlayers()[i12] = playerObj;
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                this.lineUps[i10].setCompNum(lineUpsObjArr[i10].getCompNum());
                this.lineUps[i10].setStatus(lineUpsObjArr[i10].getStatus());
                this.lineUps[i10].setFormation(lineUpsObjArr[i10].getFormation());
                this.lineUps[i10].setHasRankings(lineUpsObjArr[i10].getHasRankings());
                this.lineUps[i10].setHasPlayerStats(lineUpsObjArr[i10].isHasPlayerStats());
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setMainOddsObj(BetLine betLine) {
        this.mainOddsObj = betLine;
    }

    public void setPlayByPlayDataList(ArrayList<PlayByPlayObj> arrayList) {
        ArrayList<PlayByPlayObj> arrayList2 = this.playByPlayDataList;
        if (arrayList2 == null) {
            this.playByPlayDataList = arrayList;
        } else {
            arrayList2.addAll(arrayList);
        }
    }

    public void setPreciseGameTime(double d10, int i10, int i11) {
        this.preciseGameTime = d10;
        this.gameMinute = i10;
        this.gameSeconds = i11;
    }

    public void setPredictions(com.scores365.gameCenter.Predictions.b bVar) {
        this.predictionObj = bVar;
    }

    public void setRound(int i10) {
        this.round = i10;
    }

    public void setRoundName(String str) {
        this.roundName = str;
    }

    public void setSTime(Date date) {
        this.sTime = date;
    }

    public void setScoreboardObj(ScoreboardObj scoreboardObj) {
        this.scoreboardObj = scoreboardObj;
    }

    public void setScores(ScoreObj[] scoreObjArr) {
        this.scores = scoreObjArr;
    }

    public void setServe(int i10) {
        this.serve = i10;
    }

    public void setSession(int i10) {
        this.session = i10;
    }

    public void setSportID(int i10) {
        this.sportId = i10;
    }

    public void setStID(int i10) {
        this.stid = i10;
    }

    public void setStatistics(StatObj[] statObjArr) {
        this.statistics = statObjArr;
    }

    public void setStatisticsFilter(List<StatisticsFilter> list) {
        this.statisticsFilter = list;
    }

    public void setTennisGamePointsObj(TennisGamePointsObj tennisGamePointsObj) {
        this.tennisGamePointsObj = tennisGamePointsObj;
    }

    public void setVideos(VideoObj[] videoObjArr) {
        this.videos = videoObjArr;
    }

    public void setWinner(int i10) {
        this.winner = i10;
    }

    public void set_latestNotifications(HashMap<Integer, LatestNotifications> hashMap) {
        this._latestNotifications = hashMap;
    }

    public boolean shouldShowEventsOrderFromBottom() {
        try {
            return App.l().getSportTypes().get(Integer.valueOf(this.sportId)).shouldShowEventsOrderFromBottom();
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean shouldShowLiveMatchTracker() {
        try {
            if (this.showTracker && i0.U3()) {
                return !isFinished();
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean shouldShowOdds() {
        return getMainOddsObj() != null;
    }

    public boolean shouldUseLmtPbpPreviewForSportType() {
        return shouldUseLmtPbpPreviewForSportType(getSportID());
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append(this.f23589id);
            sb2.append(" | ");
            sb2.append(getComps()[0].getName());
            sb2.append("-");
            sb2.append(getComps()[1].getName());
            sb2.append(" | ");
            sb2.append(getScores()[0].getScore());
            sb2.append("-");
            sb2.append(getScores()[1].getScore());
            sb2.append(" | ");
            sb2.append(this.gt);
            sb2.append(" | ");
            sb2.append(this.sTime.toString());
            sb2.append(" | ");
            sb2.append(this.competitionId);
            sb2.append(" | ");
            sb2.append(App.b.d0(this.f23589id, App.c.GAME));
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return sb2.toString();
    }

    public void updateGameData(GameObj gameObj) {
        if (gameObj != null) {
            try {
                if (gameObj.getID() == getID()) {
                    if (gameObj.getEvents() != null) {
                        setEvents(gameObj.getEvents());
                    }
                    setWinner(gameObj.getWinner());
                    if (gameObj.getVideos() != null) {
                        setVideos(gameObj.getVideos());
                    }
                    setSTime(gameObj.getSTime());
                    setScores(gameObj.getScores());
                    setIsActive(gameObj.getIsActive());
                    this.preciseGameTime = gameObj.preciseGameTime;
                    setGT(gameObj.getGT());
                    setRound(gameObj.getRound());
                    ArrayList<Double> arrayList = gameObj.aggregatedScore;
                    if (arrayList != null && !arrayList.isEmpty()) {
                        setAggregated(gameObj.getAggregatedScore());
                    }
                    try {
                        setEvents(gameObj.getEvents());
                        if (gameObj.getStID() > 0) {
                            setStID(gameObj.getStID());
                        }
                        setGTD(gameObj.getGTD());
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                    if (gameObj.getLineUps() != null) {
                        setLineUps(gameObj.getLineUps());
                    }
                    if (gameObj.getRoundName() != null) {
                        setRoundName(gameObj.getRoundName());
                    }
                    if (gameObj.getStatistics() != null) {
                        setStatistics(gameObj.getStatistics());
                    }
                    if (gameObj.getMainOddsObj() != null) {
                        setMainOddsObj(gameObj.getMainOddsObj());
                    }
                    if (gameObj.GetPossession() != -1) {
                        SetPossession(gameObj.GetPossession());
                    }
                    if (gameObj.isPaused() != null) {
                        setIsPaused(gameObj.isPaused().booleanValue());
                    }
                    if (!gameObj.GetWinDescription().equals("")) {
                        SetWinDescription(gameObj.GetWinDescription());
                    }
                    InsightsObj insightsObj = gameObj.insightsObj;
                    if (insightsObj != null) {
                        this.insightsObj = insightsObj;
                    }
                    int i10 = this.attendance;
                    int i11 = gameObj.attendance;
                    if (i10 != i11) {
                        this.attendance = i11;
                    }
                    int i12 = gameObj.addedTime;
                    if (i12 > -2) {
                        this.addedTime = i12;
                    }
                    TableObj tableObj = gameObj.detailTableObj;
                    if (tableObj != null && tableObj.competitionTableColumn != null) {
                        this.detailTableObj = tableObj;
                    }
                    boolean z10 = gameObj.hasLiveTable;
                    if (z10 != this.hasLiveTable) {
                        this.hasLiveTable = z10;
                    }
                    try {
                        int i13 = gameObj.regularTimeCompletion;
                        if (i13 != -1) {
                            this.regularTimeCompletion = i13;
                        }
                        double d10 = gameObj.gameTimeCompletion;
                        if (d10 > -1.0d) {
                            this.gameTimeCompletion = d10;
                        }
                    } catch (Exception e11) {
                        x0.N1(e11);
                    }
                    try {
                        if (getSportID() == SportTypesEnum.CRICKET.getValue()) {
                            int i14 = gameObj.PlayingStatus;
                            if (i14 > -1) {
                                this.PlayingStatus = i14;
                            }
                            if (!gameObj.FallOfWickets.isEmpty()) {
                                this.FallOfWickets = gameObj.FallOfWickets;
                            }
                            int i15 = gameObj.DayNum;
                            if (i15 > -1) {
                                this.DayNum = i15;
                            }
                            Date date = gameObj.EndDate;
                            if (date != null) {
                                this.EndDate = date;
                            }
                        }
                    } catch (Exception e12) {
                        x0.N1(e12);
                    }
                    this.isStarted = gameObj.isStarted;
                    TopPerformerObj topPerformerObj = gameObj.topPerformers;
                    if (topPerformerObj != null) {
                        this.topPerformers = topPerformerObj;
                    }
                    TopPerformerObj topPerformerObj2 = gameObj.probablePitchers;
                    if (topPerformerObj2 != null) {
                        this.probablePitchers = topPerformerObj2;
                    }
                    ArrayList<ActiveVarEvent> arrayList2 = gameObj.activeVarEvents;
                    if (arrayList2 != null) {
                        this.activeVarEvents = arrayList2;
                    }
                    z0 z0Var = gameObj.teamFoulsObj;
                    if (z0Var != null) {
                        this.teamFoulsObj = z0Var;
                    }
                    try {
                        if (gameObj.getBestOddsObj() != null) {
                            setBestOddsObj(gameObj.getBestOddsObj());
                        }
                    } catch (Exception e13) {
                        x0.N1(e13);
                    }
                    if (gameObj.getEventFilters() != null) {
                        setEventFilters(gameObj.getEventFilters());
                    }
                    if (gameObj.getStatisticsFilter() != null) {
                        setStatisticsFilter(gameObj.getStatisticsFilter());
                    }
                    OddsPreview oddsPreview = gameObj.oddsPreview;
                    if (oddsPreview != null) {
                        this.oddsPreview = oddsPreview;
                    }
                }
            } catch (Exception e14) {
                x0.N1(e14);
            }
        }
    }
}
