package com.scores365.entitys;

import com.scores365.entitys.CompObj;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import li.x0;
/* loaded from: classes2.dex */
public class CompetitionObj extends BaseObj implements Comparable, IDashboardHeader {
    public static final int AWAY_TEAM_FIRST = 2;
    public static final int HOME_TEAM_FIRST = 1;
    private static final long serialVersionUID = -4464620933676739248L;
    @p9.c("CurrSeason")
    public int CurrSeason;
    @p9.c("CurrStage")
    public int CurrStage;
    @p9.c("HasSquads")
    public boolean HasSquads;
    @p9.c("ShowTopAthletes")
    public boolean ShowTopAthletes;
    @p9.c("SubSportType")
    public int SubSportType;
    @p9.c("CategoryId")
    private int categoryId;
    @p9.c("CID")
    private int cid;
    @p9.c("Color")
    private String color;
    @p9.c("CompetitorsType")
    private CompObj.eCompetitorType competitorsType;
    @p9.c("Expanded")
    public boolean expanded;
    @p9.c("FatherCompetition")
    public int fatherCompetition;
    @p9.c("GamesCount")
    private int gamesCount;
    @p9.c("Gender")
    private int gender;
    @p9.c("HalfExpanded")
    public boolean halfExpanded;
    @p9.c("HasLogo")
    private boolean hasLogo;
    @p9.c("HasTbl")
    private boolean hasTable;
    @p9.c("HasTexture")
    private boolean hasTexture;
    @p9.c("ImgVer")
    private int imgVer;
    @p9.c("LiveCount")
    private int liveCount;
    @p9.c("OR")
    private String olympicRecord;
    @p9.c("OlympicSID")
    public int olympicSportId;
    @p9.c("OrderLevel")
    private int orderLevel;
    @p9.c("PlayingCount")
    public int playingCount;
    @p9.c("Popular")
    private boolean popular;
    @p9.c("PopularityRank")
    public int popularityRank;
    private String sectionTitle;
    @p9.c("Seasons")
    private LinkedHashMap<Integer, SeasonObj> sessions;
    SeasonObj[] sessionsArray;
    @p9.c("SName")
    private String shortName;
    @p9.c("SID")
    private int sid;
    @p9.c("SupportMissingPlayers")
    public boolean supportMissingPlayers;
    @p9.c("Table")
    public TableObj tableObj;
    public HashMap<Integer, TableObj> tablesMap;
    @p9.c("TextColor")
    private String textColor;
    @p9.c("Type")
    private int type;
    @p9.c("WR")
    private String worldRecord;

    /* loaded from: classes2.dex */
    public static class CompetitionPopularityComparator implements Comparator<CompetitionObj> {
        @Override // java.util.Comparator
        public int compare(CompetitionObj competitionObj, CompetitionObj competitionObj2) {
            try {
                return competitionObj.getOrderLevel() - competitionObj2.getOrderLevel();
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    public CompetitionObj() {
        this.CurrSeason = -1;
        this.CurrStage = -1;
        this.sessionsArray = null;
        this.type = -1;
        this.HasSquads = false;
        this.SubSportType = -1;
        this.ShowTopAthletes = true;
        this.supportMissingPlayers = false;
        this.expanded = false;
        this.gamesCount = -1;
        this.liveCount = -1;
        this.categoryId = -1;
        this.imgVer = -1;
        this.halfExpanded = false;
        this.tablesMap = new HashMap<>();
        this.sectionTitle = "";
    }

    public CompetitionObj(int i10, String str, int i11, int i12, int i13, int i14, int i15, int i16, boolean z10, int i17, boolean z11, boolean z12, int i18, int i19, String str2) {
        super(i10, str);
        this.CurrSeason = -1;
        this.CurrStage = -1;
        this.sessionsArray = null;
        this.type = -1;
        this.HasSquads = false;
        this.SubSportType = -1;
        this.ShowTopAthletes = true;
        this.supportMissingPlayers = false;
        this.expanded = false;
        this.gamesCount = -1;
        this.liveCount = -1;
        this.categoryId = -1;
        this.imgVer = -1;
        this.halfExpanded = false;
        this.tablesMap = new HashMap<>();
        this.sectionTitle = "";
        this.ShowTopAthletes = z11;
        this.cid = i11;
        this.sid = i12;
        this.hasTable = false;
        this.orderLevel = i13;
        this.sessions = null;
        this.type = i14;
        this.CurrSeason = i15;
        this.CurrStage = i16;
        this.HasSquads = z10;
        this.SubSportType = i17;
        this.supportMissingPlayers = z12;
        this.fatherCompetition = i18;
        this.olympicSportId = i19;
        this.shortName = str2;
    }

    public CompetitionObj(int i10, String str, int i11, int i12, int i13, int i14, boolean z10, int i15, boolean z11, boolean z12, int i16, int i17, String str2) {
        super(i10, str);
        this.CurrSeason = -1;
        this.CurrStage = -1;
        this.sessionsArray = null;
        this.type = -1;
        this.HasSquads = false;
        this.SubSportType = -1;
        this.ShowTopAthletes = true;
        this.supportMissingPlayers = false;
        this.expanded = false;
        this.gamesCount = -1;
        this.liveCount = -1;
        this.categoryId = -1;
        this.imgVer = -1;
        this.halfExpanded = false;
        this.tablesMap = new HashMap<>();
        this.sectionTitle = "";
        this.ShowTopAthletes = z11;
        this.cid = i11;
        this.sid = i12;
        this.hasTable = false;
        this.orderLevel = i13;
        this.sessions = null;
        this.type = i14;
        this.HasSquads = z10;
        this.SubSportType = i15;
        this.supportMissingPlayers = z12;
        this.fatherCompetition = i16;
        this.olympicSportId = i17;
        this.shortName = str2;
    }

    public SeasonObj GetSeasonByNum(int i10) {
        try {
            for (SeasonObj seasonObj : this.sessions.values()) {
                if (seasonObj.getNum() == i10) {
                    return seasonObj;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean HasTableForGame(GameObj gameObj) {
        SeasonObj GetSeasonByNum;
        boolean z10 = this.hasTable;
        try {
            int i10 = gameObj.session;
            if (i10 == -1 || (GetSeasonByNum = GetSeasonByNum(i10)) == null) {
                return z10;
            }
            int i11 = gameObj.Stage;
            return i11 != -1 ? GetSeasonByNum.GetStageNum(i11).getHasTable() : GetSeasonByNum.getHasTable();
        } catch (Exception unused) {
            return z10;
        }
    }

    /* renamed from: clone */
    public CompetitionObj m174clone() {
        return new CompetitionObj(this.f23582id, this.name, this.cid, this.sid, this.orderLevel, this.type, this.CurrSeason, this.CurrStage, this.HasSquads, this.SubSportType, this.ShowTopAthletes, this.supportMissingPlayers, this.fatherCompetition, this.olympicSportId, this.shortName);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj == null || !(obj instanceof CompetitionObj)) {
            return 0;
        }
        CompetitionObj competitionObj = (CompetitionObj) obj;
        int i10 = this.orderLevel - competitionObj.orderLevel;
        return i10 == 0 ? this.f23582id - competitionObj.f23582id : i10;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof CompetitionObj) && ((CompetitionObj) obj).f23582id == this.f23582id;
    }

    public EnumAthleteGender getAthleteGender() {
        return EnumAthleteGender.create(this.gender);
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getCid() {
        return this.cid;
    }

    public String getColor() {
        return this.color;
    }

    public CompStageObj getCompStageByNumFromAndSeason(int i10, int i11) {
        CompStageObj[] stages;
        try {
            for (CompStageObj compStageObj : GetSeasonByNum(i10).getStages()) {
                if (i11 == compStageObj.getNum()) {
                    return compStageObj;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public CompStageObj getCompStageByNumFromCurrentSeason(int i10) {
        CompStageObj[] stages;
        try {
            for (CompStageObj compStageObj : GetSeasonByNum(this.CurrSeason).getStages()) {
                if (i10 == compStageObj.getNum()) {
                    return compStageObj;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public CompObj.eCompetitorType getCompetitorsType() {
        return this.competitorsType;
    }

    public int getCurrStage() {
        return this.CurrStage;
    }

    public int getGamesCount() {
        return this.gamesCount;
    }

    public boolean getHasTable() {
        return this.hasTable;
    }

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public int getLiveCount() {
        return this.liveCount;
    }

    public String getOlympicRecord() {
        return this.olympicRecord;
    }

    public int getOrderLevel() {
        return this.orderLevel;
    }

    public String getSectionTitle() {
        return this.sectionTitle;
    }

    public SeasonObj[] getSessions() {
        LinkedHashMap<Integer, SeasonObj> linkedHashMap;
        try {
            if (this.sessionsArray == null && (linkedHashMap = this.sessions) != null) {
                this.sessionsArray = new SeasonObj[linkedHashMap.size()];
                int i10 = 0;
                for (SeasonObj seasonObj : this.sessions.values()) {
                    this.sessionsArray[i10] = seasonObj;
                    i10++;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.sessionsArray;
    }

    public String getShortName() {
        String name = getName();
        String str = this.shortName;
        return (str == null || str.isEmpty()) ? name : this.shortName;
    }

    public int getSid() {
        return this.sid;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public int getType() {
        return this.type;
    }

    public String getWorldRecord() {
        return this.worldRecord;
    }

    public boolean hasBracketsForCurrentStage() {
        CompStageObj[] stages;
        try {
            for (CompStageObj compStageObj : GetSeasonByNum(this.CurrSeason).getStages()) {
                if (this.CurrStage == compStageObj.getNum()) {
                    if (compStageObj.getGroups().length > 0) {
                        return !compStageObj.getHasTable();
                    }
                    return false;
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean hasGroupsForCurrentStage() {
        CompStageObj[] stages;
        try {
            for (CompStageObj compStageObj : GetSeasonByNum(this.CurrSeason).getStages()) {
                if (this.CurrStage == compStageObj.getNum()) {
                    if (compStageObj.getGroups() == null || compStageObj.getGroups().length <= 0) {
                        return false;
                    }
                    return compStageObj.getHasTable();
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean hasTableForCurrentStage() {
        Exception e10;
        SeasonObj GetSeasonByNum;
        boolean hasTable;
        CompStageObj[] stages;
        try {
            GetSeasonByNum = GetSeasonByNum(this.CurrSeason);
            hasTable = GetSeasonByNum.getHasTable();
        } catch (Exception e11) {
            e10 = e11;
        }
        try {
            if (GetSeasonByNum.getStages() != null) {
                for (CompStageObj compStageObj : GetSeasonByNum.getStages()) {
                    if (this.CurrStage == compStageObj.getNum()) {
                        return compStageObj.getHasTable();
                    }
                }
                return hasTable;
            }
            return hasTable;
        } catch (Exception e12) {
            e10 = e12;
            x0.N1(e10);
            return false;
        }
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        try {
            return this.f23582id;
        } catch (Exception e10) {
            x0.N1(e10);
            return hashCode;
        }
    }

    public boolean isCompetitionHasTable() {
        try {
            for (CompStageObj compStageObj : GetSeasonByNum(this.CurrSeason).getStages()) {
                if (compStageObj.getHasTable()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isCompetitorTypeNational() {
        return getCompetitorsType() == CompObj.eCompetitorType.NATIONAL;
    }

    public boolean isGroupHaveTableRows(int i10, int i11) {
        try {
            Iterator<TableRowObj> it = this.tablesMap.get(Integer.valueOf(i10)).competitionTable.iterator();
            while (it.hasNext()) {
                if (it.next().group == i11) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isHasLogo() {
        return this.hasLogo;
    }

    public boolean isHasTexture() {
        return this.hasTexture;
    }

    public boolean isPopular() {
        return this.popular;
    }

    public boolean isSeasonHasGroupsOrTable(int i10, CompetitionObj competitionObj) {
        boolean z10 = false;
        try {
            SeasonObj GetSeasonByNum = GetSeasonByNum(i10);
            if (GetSeasonByNum != null) {
                CompStageObj[] stages = GetSeasonByNum.getStages();
                int length = stages.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    CompStageObj compStageObj = stages[i11];
                    if (compStageObj.getGroups() != null && compStageObj.getGroups().length > 0) {
                        z10 = true;
                        break;
                    }
                    i11++;
                }
                return !z10 ? GetSeasonByNum.getHasTable() : z10;
            }
            return competitionObj.getHasTable();
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isTableShouldShowGroups(int i10) {
        try {
            if (this.tablesMap.containsKey(Integer.valueOf(i10))) {
                return this.tablesMap.get(Integer.valueOf(i10)).showGrouped;
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public void mergeCompetitionsObj(CompetitionObj competitionObj) {
        try {
            this.sessionsArray = null;
            if (this.sessions == null) {
                this.sessions = competitionObj.sessions;
            } else {
                LinkedHashMap<Integer, SeasonObj> linkedHashMap = competitionObj.sessions;
                if (linkedHashMap != null) {
                    for (SeasonObj seasonObj : linkedHashMap.values()) {
                        if (this.sessions.containsKey(seasonObj.getKey())) {
                            this.sessions.get(seasonObj.getKey()).mergeSeasonObj(seasonObj);
                        } else {
                            this.sessions.put(seasonObj.getKey(), seasonObj);
                        }
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        try {
            if (competitionObj.getLiveCount() != -1) {
                setLiveCount(competitionObj.getLiveCount());
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    public void setGamesCount(int i10) {
        this.gamesCount = i10;
    }

    public void setLiveCount(int i10) {
        this.liveCount = i10;
    }

    public void setOlympicRecord(String str) {
        this.olympicRecord = str;
    }

    public void setSectionTitle(String str) {
        this.sectionTitle = str;
    }

    public void setWorldRecord(String str) {
        this.worldRecord = str;
    }

    @Override // com.scores365.entitys.IDashboardHeader
    public HeaderObj toHeaderObj() {
        try {
            return new HeaderObj(getColor(), null, getTextColor(), new HeaderEntityObj(getID(), getSid(), eDashboardEntityType.Competition.getValue(), getCid(), -1), isHasLogo(), isHasTexture());
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("id: ");
            sb2.append(this.f23582id);
            sb2.append(" name: ");
            sb2.append(this.name);
            sb2.append(" type: ");
            sb2.append(this.type);
            sb2.append(" orderLevel: ");
            sb2.append(this.orderLevel);
        } catch (Exception unused) {
            sb2 = new StringBuilder(super.toString());
        }
        return sb2.toString();
    }
}
