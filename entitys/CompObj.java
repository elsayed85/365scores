package com.scores365.entitys;

import android.content.Context;
import android.graphics.Color;
import com.scores365.App;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import li.x0;
import nb.o;
import nb.p;
/* loaded from: classes2.dex */
public class CompObj extends BaseObj implements IDashboardHeader {
    private static final long serialVersionUID = 2354901822847094043L;
    @p9.c("HasSquad")
    public boolean HasSquad;
    @p9.c("CategoryId")
    private HashSet<Integer> categoryIds;
    @p9.c("CompetitionHasTexture")
    private boolean competitionHasTexture;
    @p9.c("MainCompetition")
    public CompetitionObj competitionObj;
    @p9.c("Record")
    private com.scores365.gameCenter.d competitorRecord;
    @p9.c("Trend")
    private ArrayList<Integer> competitorTrend;
    @p9.c("Type")
    private eCompetitorType competitorType;
    @p9.c("Comps")
    private int[] comps;
    @p9.c("CID")
    private int countryId;
    private ArrayList<eCompetitorTrend> enumCompetitorTrend;
    @p9.c("ExtraDataTitle")
    private String extraDataTitle;
    @p9.c("ImgVer")
    private int imgVer;
    @p9.c("Eliminated")
    private boolean isEliminated;
    private boolean isLastMatchesSorted;
    @p9.c("LastMatchesLayoutData")
    private LastMatchesLayoutDataObj lastMatchesLayoutData;
    @p9.c("LastMatches")
    public ArrayList<GameObj> lastMatchesList;
    @p9.c("LiveCount")
    private int liveCount;
    @p9.c("AwayColor")
    private String mainAwayColor;
    @p9.c("Color")
    public String mainColor;
    @p9.c("MainComp")
    private int mainComp;
    @p9.c("Outcome")
    private int outcome;
    @p9.c("PopularityRank")
    public int popularRank;
    @p9.c("Rankings")
    private ArrayList<RankingObj> rankingObjs;
    @p9.c("AwayColor2")
    private String secondaryAwayColor;
    @p9.c("Color2")
    public String secondaryColor;
    private String sectionTitle;
    @p9.c("ShotChartColor")
    private String shotChartColor;
    @p9.c("SName")
    private String sname;
    @p9.c("SID")
    private int sportId;
    @p9.c("Stats")
    private PlayerStatObj[] stat;
    @p9.c("SymbolicName")
    private String symbolicName;
    @p9.c("TablePosition")
    public TablePosition tablePosition;
    @p9.c("TextColor")
    private String textColor;
    @p9.c("TitleName")
    private String titleName;

    /* loaded from: classes2.dex */
    public enum eCompetitorType {
        TEAM(1),
        NATIONAL(2),
        PLAYER(3),
        COUPLE(4);
        
        private int value;

        eCompetitorType(int i10) {
            this.value = i10;
        }

        public static eCompetitorType create(int i10) {
            eCompetitorType ecompetitortype = TEAM;
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? ecompetitortype : COUPLE : PLAYER : NATIONAL : ecompetitortype;
        }

        public int getValue() {
            return this.value;
        }
    }

    public CompObj() {
        this.sname = "";
        this.HasSquad = false;
        this.sectionTitle = "";
        this.competitorTrend = new ArrayList<>();
        this.enumCompetitorTrend = null;
        this.symbolicName = "";
        this.isEliminated = false;
        this.rankingObjs = null;
        this.textColor = null;
        this.mainComp = -1;
        this.imgVer = -1;
        this.liveCount = -1;
        this.categoryIds = new HashSet<>();
        this.extraDataTitle = null;
        this.outcome = -1;
    }

    public CompObj(int i10, String str, String str2, int i11, int i12, int[] iArr, String str3, String str4, boolean z10, int i13, int i14) {
        super(i10, str);
        this.sname = "";
        this.HasSquad = false;
        this.sectionTitle = "";
        this.competitorTrend = new ArrayList<>();
        this.enumCompetitorTrend = null;
        this.symbolicName = "";
        this.isEliminated = false;
        this.rankingObjs = null;
        this.textColor = null;
        this.mainComp = -1;
        this.imgVer = -1;
        this.liveCount = -1;
        this.categoryIds = new HashSet<>();
        this.extraDataTitle = null;
        this.outcome = -1;
        this.countryId = i11;
        this.sportId = i12;
        this.comps = iArr;
        this.sname = str2;
        this.HasSquad = z10;
        this.popularRank = i13;
        this.competitorType = eCompetitorType.create(i14);
        if (!str3.equals("")) {
            this.mainColor = str3;
        }
        if (str4.equals("")) {
            return;
        }
        this.secondaryColor = str4;
    }

    public static String getIconUrl(int i10, int i11, int i12, String str, int i13, int i14) {
        return i10 == SportTypesEnum.TENNIS.getValue() ? o.x(p.Competitors, i11, i13, i14, true, p.CountriesRoundFlags, Integer.valueOf(i12), str) : o.l(p.Competitors, i11, Integer.valueOf(i14), Integer.valueOf(i13), false, true, Integer.valueOf(i10), null, null, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getLastMatchesListByDate$0(GameObj gameObj, GameObj gameObj2) {
        try {
            return gameObj2.getSTime().compareTo(gameObj.getSTime());
        } catch (Exception unused) {
            return 0;
        }
    }

    public HashSet<Integer> getCategoryIds() {
        return this.categoryIds;
    }

    public String getColor() {
        return this.mainColor;
    }

    public String getColor2() {
        return this.secondaryColor;
    }

    public boolean getCompetitionHasTexture() {
        return this.competitionHasTexture;
    }

    public String getCompetitorLogoUrl(int i10, int i11) {
        try {
            return this.sportId == SportTypesEnum.TENNIS.getValue() ? o.x(p.Competitors, this.f23582id, i10, i11, true, p.CountriesRoundFlags, Integer.valueOf(this.countryId), String.valueOf(this.imgVer)) : o.l(p.Competitors, this.f23582id, Integer.valueOf(i11), Integer.valueOf(i10), false, true, Integer.valueOf(this.sportId), null, null, String.valueOf(this.imgVer));
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public String getCompetitorNameToDisplay() {
        String name = getName();
        String str = this.titleName;
        if (str == null || str.isEmpty()) {
            String str2 = this.sname;
            return (str2 == null || str2.isEmpty()) ? name : this.sname;
        }
        return this.titleName;
    }

    public ArrayList<eCompetitorTrend> getCompetitorTrend() {
        ArrayList<eCompetitorTrend> arrayList = this.enumCompetitorTrend;
        if (arrayList != null) {
            return arrayList;
        }
        this.enumCompetitorTrend = new ArrayList<>();
        Iterator<Integer> it = this.competitorTrend.iterator();
        while (it.hasNext()) {
            this.enumCompetitorTrend.add(eCompetitorTrend.create(it.next().intValue()));
        }
        return this.enumCompetitorTrend;
    }

    public int[] getComps() {
        return this.comps;
    }

    public int getCountryID() {
        return this.countryId;
    }

    public String getExtraDataTitle() {
        return this.extraDataTitle;
    }

    public String getIconUrl(int i10, int i11) {
        return getIconUrl(this.sportId, this.f23582id, this.countryId, getImgVer(), i10, i11);
    }

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public boolean getIsEliminated() {
        return this.isEliminated;
    }

    public LastMatchesLayoutDataObj getLastMatchesLayoutData() {
        return this.lastMatchesLayoutData;
    }

    public ArrayList<GameObj> getLastMatchesListByDate() {
        ArrayList<GameObj> arrayList = this.lastMatchesList;
        if (arrayList != null && !this.isLastMatchesSorted) {
            Collections.sort(arrayList, new Comparator() { // from class: com.scores365.entitys.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int lambda$getLastMatchesListByDate$0;
                    lambda$getLastMatchesListByDate$0 = CompObj.lambda$getLastMatchesListByDate$0((GameObj) obj, (GameObj) obj2);
                    return lambda$getLastMatchesListByDate$0;
                }
            });
            this.isLastMatchesSorted = true;
        }
        return this.lastMatchesList;
    }

    public int getLiveCount() {
        return this.liveCount;
    }

    public String getMainAwayColor() {
        return this.mainAwayColor;
    }

    public int getMainColor(Context context, boolean z10) {
        try {
            int parseColor = Color.parseColor(this.mainColor);
            return (!this.mainColor.equals("#16994E") || z10) ? parseColor : Color.parseColor("#328CB7");
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    public int getMainComp() {
        return this.mainComp;
    }

    public CompetitionObj getMainCompetitionObj() {
        return this.competitionObj;
    }

    public int getOutcome() {
        return this.outcome;
    }

    public ArrayList<RankingObj> getRankingObjs() {
        return this.rankingObjs;
    }

    public String getRecordStr() {
        StringBuilder sb2 = new StringBuilder();
        try {
            if (this.competitorRecord != null) {
                if (x0.l1()) {
                    if (this.sportId == SportTypesEnum.AMERICAN_FOOTBALL.getValue() && this.competitorRecord.c() > 0) {
                        sb2.append(this.competitorRecord.c());
                        sb2.append("-");
                    } else if (this.sportId == SportTypesEnum.HOCKEY.getValue() && this.competitorRecord.b() >= 0) {
                        sb2.append(this.competitorRecord.b());
                        sb2.append("-");
                    }
                    sb2.append(this.competitorRecord.a());
                    sb2.append("-");
                    sb2.append(this.competitorRecord.d());
                } else {
                    sb2.append(this.competitorRecord.d());
                    sb2.append("-");
                    sb2.append(this.competitorRecord.a());
                    if (this.sportId == SportTypesEnum.AMERICAN_FOOTBALL.getValue() && this.competitorRecord.c() > 0) {
                        sb2.append("-");
                        sb2.append(this.competitorRecord.c());
                    } else if (this.sportId == SportTypesEnum.HOCKEY.getValue() && this.competitorRecord.b() >= 0) {
                        sb2.append("-");
                        sb2.append(this.competitorRecord.b());
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return sb2.toString();
    }

    public String getSectionTitle() {
        return this.sectionTitle;
    }

    public String getShortName() {
        String str = this.sname;
        return (str == null || str.isEmpty()) ? this.name : this.sname;
    }

    public String getShortTitleFullName() {
        String name = getName();
        String str = this.sname;
        if (str == null || str.isEmpty()) {
            String str2 = this.titleName;
            return (str2 == null || str2.isEmpty()) ? name : this.titleName;
        }
        return this.sname;
    }

    public String getShotChartColor() {
        return this.shotChartColor;
    }

    public int getSportID() {
        return this.sportId;
    }

    public PlayerStatObj[] getStat() {
        return this.stat;
    }

    public String getSymbolicName() {
        if (this.symbolicName.isEmpty()) {
            return null;
        }
        return this.symbolicName;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public String getTitleName() {
        String str = this.titleName;
        return (str == null || str.isEmpty()) ? getShortName() : str;
    }

    public eCompetitorType getType() {
        return this.competitorType;
    }

    public boolean isCompetitorInCompetition(int i10) {
        boolean z10 = false;
        try {
            boolean z11 = false;
            for (int i11 : this.comps) {
                try {
                    z11 = i11 == i10;
                    if (z11) {
                        return z11;
                    }
                } catch (Exception e10) {
                    e = e10;
                    z10 = z11;
                    x0.N1(e);
                    return z10;
                }
            }
            return z11;
        } catch (Exception e11) {
            e = e11;
        }
    }

    public boolean isNational() {
        try {
            return getType() == eCompetitorType.NATIONAL;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSectionTitle(String str) {
        this.sectionTitle = str;
    }

    public boolean shouldBeShownAsAthlete() {
        try {
            return App.l().getSportTypes().get(Integer.valueOf(this.sportId)).getDefaultCompetitorType() == eCompetitorType.PLAYER.value;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // com.scores365.entitys.IDashboardHeader
    public HeaderObj toHeaderObj() {
        try {
            return new HeaderObj(getColor(), getColor2(), getTextColor(), new HeaderEntityObj(getID(), getSportID(), eDashboardEntityType.Competitor.getValue(), getCountryID(), getMainComp()), true, getCompetitionHasTexture());
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append(this.f23582id);
            sb2.append(" ");
            sb2.append(this.name);
            sb2.append(" ");
            sb2.append(this.countryId);
            sb2.append(" ");
            sb2.append(this.sportId);
            sb2.append(" ");
            sb2.append(this.competitorType);
        } catch (Exception unused) {
            sb2 = new StringBuilder();
            sb2.append(super.toString());
        }
        return sb2.toString();
    }
}
