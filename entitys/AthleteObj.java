package com.scores365.entitys;

import com.scores365.App;
import com.scores365.R;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import li.p0;
import li.x0;
import nb.o;
/* loaded from: classes2.dex */
public class AthleteObj extends BaseObj implements IDashboardHeader {
    public static final int STATUS_ACTIVE = 1;
    public static final int STATUS_DEAD = 2;
    public static final int STATUS_RETIRED = 3;
    private static HashMap<String, com.scores365.PlayerCard.b> seasonsBySeasonKey;
    @p9.c("Age")
    private int age;
    @p9.c("AppointedDate")
    private Date appointedDate;
    @p9.c("Buzz")
    public NewsObj athleteBuzz;
    @p9.c("News")
    public NewsObj athleteNews;
    @p9.c("Stats")
    public AthleteStatisticsObj[] athleteStatistics;
    @p9.c("Birthdate")
    public Date birthDate;
    @p9.c("Boots")
    public int bootId;
    @p9.c("CareerStats")
    public com.scores365.PlayerCard.a careerStats;
    @p9.c("Club")
    public int clubId;
    @p9.c("ClubName")
    public String clubName;
    @p9.c("COB")
    protected int cob;
    @p9.c("ContractUntil")
    private Date contractUntil;
    @p9.c("DateOfDeath")
    private Date dateOfDeath;
    @p9.c("DateOfRetirement")
    private Date dateOfRetirement;
    @p9.c("HD")
    public String displayHeight;
    @p9.c("WD")
    public String displayWeight;
    @p9.c("FormationPosName")
    private String formationPosName;
    @p9.c("FormationPos")
    private int formationPosition;
    @p9.c("Gender")
    private int gender;
    @p9.c("HasBuzz")
    public boolean hasBuzz;
    @p9.c("HasNews")
    public boolean hasNews;
    @p9.c("HasTransfers")
    public boolean hasTransfers;
    @p9.c("Header")
    private HeaderObj headerObj;
    @p9.c("H")
    public int height;
    @p9.c("ImgVer")
    private int imgVer;
    @p9.c("InjuryStatus")
    private InjuryStatusObj injuryStatusObj;
    @p9.c("JerseyNum")
    private int jerseyNum;
    @p9.c("LastMatches")
    private LastMatchesObj lastMatchesObj;
    @p9.c("LiveCount")
    private int liveCount;
    @p9.c("OnLoanUntil")
    private Date loanUntil;
    @p9.c("NationalTeamID")
    public int nationalTeamId;
    @p9.c("NationalTeamStats")
    private NationalTeamStatsObj nationalTeamStatsObj;
    @p9.c("Nationality")
    public int nationality;
    @p9.c("NationalityName")
    public String nationalityName;
    @p9.c("NextMatchApiURL")
    public String nextMatchApiURL;
    @p9.c("OnLoanFrom")
    public int onLoanFrom;
    @p9.c("PlayerDetails")
    private ArrayList<PlayerDetailObj> playerDetails;
    @p9.c("PopularityRank")
    private int popularityRank;
    @p9.c("PosName")
    private String posName;
    @p9.c("Pos")
    public int position;
    @p9.c("SName")
    private String sName;
    @p9.c("SocialStats")
    public ArrayList<SocialStatEntity> socialStats;
    @p9.c("Sport")
    private int sportType;
    @p9.c("Status")
    private int status;
    @p9.c("Suspensions")
    private SuspensionObj[] suspensions;
    @p9.c("TransferHistory")
    private ArrayList<TransferHistoryObj> transferHistory;
    @p9.c("LatestTransfers")
    public LinkedHashMap<Integer, TransferObj> transfersById;
    @p9.c("Trophies")
    private TrophiesData trophiesData;
    @p9.c("RecentlyWonPersonalTrophy")
    public RecentlyWonPersonalTrophyObj trophyObj;
    @p9.c("W")
    public int weight;

    /* loaded from: classes2.dex */
    public static class PopularityComparator implements Comparator<BaseObj> {
        @Override // java.util.Comparator
        public int compare(BaseObj baseObj, BaseObj baseObj2) {
            try {
                return Integer.compare(baseObj2 instanceof AthleteObj ? ((AthleteObj) baseObj2).popularityRank : baseObj2 instanceof CompObj ? ((CompObj) baseObj2).popularRank : 0, baseObj instanceof AthleteObj ? ((AthleteObj) baseObj).popularityRank : baseObj instanceof CompObj ? ((CompObj) baseObj).popularRank : 0);
            } catch (Exception e10) {
                x0.N1(e10);
                return 0;
            }
        }
    }

    public AthleteObj(int i10, String str) {
        this.clubId = -1;
        this.position = -1;
        this.age = -1;
        this.bootId = -1;
        this.imgVer = -1;
        this.playerDetails = new ArrayList<>();
        this.hasBuzz = false;
        this.transferHistory = new ArrayList<>();
        this.formationPosName = "";
        this.posName = "";
        this.popularityRank = 0;
        this.clubName = "";
        this.liveCount = -1;
        this.f23582id = i10;
        this.name = str;
    }

    public AthleteObj(int i10, String str, int i11, int i12, String str2, int i13, int i14, int i15, String str3) {
        this.clubId = -1;
        this.position = -1;
        this.age = -1;
        this.bootId = -1;
        this.imgVer = -1;
        this.playerDetails = new ArrayList<>();
        this.hasBuzz = false;
        this.transferHistory = new ArrayList<>();
        this.formationPosName = "";
        this.posName = "";
        this.liveCount = -1;
        this.f23582id = i10;
        this.name = str;
        this.sportType = i11;
        this.popularityRank = i12;
        this.sName = str2;
        this.status = i13;
        this.nationality = i14;
        this.clubId = i15;
        this.clubName = str3;
    }

    public static String getAthleteImagePath(int i10, String str, boolean z10) {
        try {
            return o.d(i10, false, z10, str);
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public static String getIconUrl(int i10, String str, boolean z10, int i11, int i12) {
        return o.b(i10, z10, str, i11, i12);
    }

    public static HashMap<String, com.scores365.PlayerCard.b> getSeasonsBySeasonKey() {
        return seasonsBySeasonKey;
    }

    public Date getAppointedDate() {
        return this.appointedDate;
    }

    public EnumAthleteGender getAthleteGender() {
        return EnumAthleteGender.create(this.gender);
    }

    public String getAthleteImagePath(boolean z10) {
        try {
            return o.d(this.f23582id, false, z10, String.valueOf(this.imgVer));
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public com.scores365.PlayerCard.a getCareerStats() {
        return this.careerStats;
    }

    public Date getContractUntil() {
        return this.contractUntil;
    }

    public int getCountryOfBirth() {
        return this.cob;
    }

    public Date getDateOfDeath() {
        return this.dateOfDeath;
    }

    public String getDateOfDeathStr() {
        Date date = this.dateOfDeath;
        return date == null ? "" : x0.T(date, true);
    }

    public Date getDateOfRetirement() {
        return this.dateOfRetirement;
    }

    public String getDateOfRetirementStr() {
        return x0.T(this.dateOfRetirement, true);
    }

    public String getDirectFormationPosName() {
        return this.formationPosName;
    }

    public String getDirectPosName() {
        return this.posName;
    }

    public String getDisplayAge() {
        try {
            int i10 = this.age;
            return i10 > 0 ? String.valueOf(i10) : "";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public String getDisplayJerseyNumber() {
        try {
            int i10 = this.jerseyNum;
            return i10 > 0 ? String.valueOf(i10) : "";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public int getFormationPosition() {
        return this.formationPosition;
    }

    public String getFormationPositionName() {
        try {
            return this.formationPosition > 0 ? App.l().getSportTypes().get(Integer.valueOf(this.sportType)).formationPositions.get(Integer.valueOf(this.formationPosition)).name : "";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public HeaderObj getHeaderObj() {
        return this.headerObj;
    }

    public String getIconUrl(boolean z10, int i10, int i11) {
        return getIconUrl(this.f23582id, getImgVer(), z10, i10, i11);
    }

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public InjuryStatusObj getInjuryStatusObj() {
        return this.injuryStatusObj;
    }

    public int getJerseyNumber() {
        return this.jerseyNum;
    }

    public LastMatchesObj getLastMatchesObj() {
        return this.lastMatchesObj;
    }

    public int getLiveCount() {
        return this.liveCount;
    }

    public Date getLoanUntil() {
        return this.loanUntil;
    }

    public NationalTeamStatsObj getNationalTeamStatsObj() {
        return this.nationalTeamStatsObj;
    }

    public ArrayList<PlayerDetailObj> getPlayerDetails() {
        return this.playerDetails;
    }

    public int getPlayerPositionType() {
        return this.position;
    }

    public int getPlayerStatus() {
        return this.status;
    }

    public int getPopularityRank() {
        return this.popularityRank;
    }

    public String getPositionTypeName() {
        try {
            return App.l().getSportTypes().get(Integer.valueOf(this.sportType)).athletePositions.get(Integer.valueOf(this.position)).getPositionName();
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public String getPositionTypeTitle() {
        try {
            return App.l().getSportTypes().get(Integer.valueOf(this.sportType)).athletePositions.get(Integer.valueOf(this.position)).getPositionTitle();
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public int getRetiredIcon() {
        try {
            return this.sportType == SportTypesEnum.SOCCER.getValue() ? isGoalKeeper() ? p0.w(App.m(), R.attr.R0) : p0.w(App.m(), R.attr.Q0) : p0.w(App.m(), R.attr.f21563m);
        } catch (Exception e10) {
            x0.N1(e10);
            return 0;
        }
    }

    public String getShortName() {
        return this.sName;
    }

    public SportTypesEnum getSportType() {
        return SportTypesEnum.create(this.sportType);
    }

    public int getSportTypeId() {
        return this.sportType;
    }

    public SuspensionObj[] getSuspensions() {
        return this.suspensions;
    }

    public ArrayList<TransferHistoryObj> getTransferHistory() {
        return this.transferHistory;
    }

    public TrophiesData getTrophiesData() {
        return this.trophiesData;
    }

    public boolean hasActiveTransfer() {
        try {
            Iterator<TransferHistoryObj> it = this.transferHistory.iterator();
            while (it.hasNext()) {
                if (it.next().isActive()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean hasCareerStats() {
        com.scores365.PlayerCard.b[] bVarArr;
        try {
            com.scores365.PlayerCard.a aVar = this.careerStats;
            if (aVar == null || (bVarArr = aVar.f21373a) == null) {
                return false;
            }
            return bVarArr.length > 0;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean hasSeasonStats() {
        try {
            LastMatchesObj lastMatchesObj = this.lastMatchesObj;
            if (lastMatchesObj == null || lastMatchesObj.getGames() == null || this.lastMatchesObj.getGames().isEmpty()) {
                AthleteStatisticsObj[] athleteStatisticsObjArr = this.athleteStatistics;
                if (athleteStatisticsObjArr == null) {
                    return false;
                }
                if (athleteStatisticsObjArr.length <= 0) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isAthletePositionManagement() {
        try {
            if (this.position != 0 || this.sportType != SportTypesEnum.SOCCER.getValue()) {
                if (this.position != 5) {
                    return false;
                }
                if (this.sportType != SportTypesEnum.BASKETBALL.getValue()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isGoalKeeper() {
        return getFormationPosition() == 1;
    }

    public void setSeasonMaps(com.scores365.PlayerCard.a aVar) {
        com.scores365.PlayerCard.b[] bVarArr;
        try {
            HashMap<String, com.scores365.PlayerCard.b> hashMap = seasonsBySeasonKey;
            if (hashMap != null) {
                hashMap.clear();
            }
            seasonsBySeasonKey = new HashMap<>();
            if (aVar == null || (bVarArr = aVar.f21373a) == null) {
                return;
            }
            for (com.scores365.PlayerCard.b bVar : bVarArr) {
                seasonsBySeasonKey.put(bVar.a(), bVar);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setShortName(String str) {
        this.sName = str;
    }

    public void setSportType(SportTypesEnum sportTypesEnum) {
        this.sportType = sportTypesEnum.getValue();
    }

    @Override // com.scores365.entitys.IDashboardHeader
    public HeaderObj toHeaderObj() {
        return this.headerObj;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append(this.f23582id);
            sb2.append(" ");
            sb2.append(this.name);
            sb2.append(" ");
            sb2.append(this.nationality);
            sb2.append(" ");
            sb2.append(getSportTypeId());
            sb2.append(" ");
            sb2.append(this.status);
        } catch (Exception unused) {
            sb2 = new StringBuilder();
            sb2.append(super.toString());
        }
        return sb2.toString();
    }
}
