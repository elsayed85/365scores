package com.scores365.ui.playerCard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.R;
import com.scores365.entitys.AthleteObj;
import com.scores365.entitys.AthleteStatisticsObj;
import com.scores365.entitys.AthleteTrophiesScoreBoxColumnObj;
import com.scores365.entitys.AthleteTrophiesScoreBoxRowObj;
import com.scores365.entitys.AthletesObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GamesObj;
import com.scores365.entitys.NotificationObj;
import com.scores365.entitys.PlayerObj;
import com.scores365.entitys.PositionObj;
import com.scores365.entitys.RecentlyWonPersonalTrophyItem;
import com.scores365.entitys.RecentlyWonPersonalTrophyObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxRowHelperObject;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxValueObj;
import com.scores365.entitys.SportTypeObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.entitys.SuspensionObj;
import com.scores365.entitys.TransferHistoryObj;
import com.scores365.entitys.Trophies;
import com.scores365.entitys.Trophy;
import com.scores365.entitys.TrophyStats;
import com.scores365.entitys.eDashboardSection;
import com.scores365.gameCenter.i0;
import com.scores365.ui.playerCard.AthleteDataFetcherHelper;
import com.scores365.ui.playerCard.PlayerCardNextGameItem;
import com.scores365.ui.playerCard.PlayerTrophiesCompetitionSelectorItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import lf.u;
import li.o0;
import li.p0;
import li.x0;
import nb.o;
import xf.f0;
import yc.r;
/* loaded from: classes2.dex */
public class SinglePlayerProfilePage extends q implements AthleteDataFetcherHelper.OnAthleteTrophiesDataListener, hd.m {
    private static final String ATHLETES_TAG = "athletes_tag";
    private static final String ATHLETE_TAG = "athlete_tag";
    private static final int COLLAPSED_HISTORY_ITEM_COUNT = 4;
    private static final int COLLAPSED_HISTORY_ITEM_COUNT_IF_SIZE_IS_3 = 3;
    private static final int COLLAPSED_TROPHY_ITEM_COUNT = 4;
    private static final String COMPETITION_ID_TAG = "is_national_tag";
    private static final String GAMES_TAG = "games_tag";
    private static final String IS_NATIONAL_TAG = "is_national_tag";
    private static final int ROW_SIZE_OF_HEADER_AND_3_DATA = 4;
    int chosenTrophyType = -1;
    int chosenCompetitionId = -1;
    boolean isTrophyListExpanded = false;
    PlayerCardNextGameItem.Companion.InjurySuspensionStatusItemData injurySuspensionData = null;
    private int indexToInsertFutureGame = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scores365.ui.playerCard.SinglePlayerProfilePage$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$scores365$entitys$SuspensionObj$ESoccerSuspensionTypes;

        static {
            int[] iArr = new int[SuspensionObj.ESoccerSuspensionTypes.values().length];
            $SwitchMap$com$scores365$entitys$SuspensionObj$ESoccerSuspensionTypes = iArr;
            try {
                iArr[SuspensionObj.ESoccerSuspensionTypes.RedCard.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scores365$entitys$SuspensionObj$ESoccerSuspensionTypes[SuspensionObj.ESoccerSuspensionTypes.YellowCards.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scores365$entitys$SuspensionObj$ESoccerSuspensionTypes[SuspensionObj.ESoccerSuspensionTypes.Disciplinary.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class CompetitorClickListener implements View.OnClickListener {
        private final int athleteID;
        int entityId;
        App.c entityType;

        public CompetitorClickListener(int i10, App.c cVar, int i11) {
            this.athleteID = i11;
            this.entityId = i10;
            this.entityType = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent s10 = x0.s(this.entityType, this.entityId, eDashboardSection.SCORES, "", false, 0, "player_card_career_tab_competitions_table");
                s10.addFlags(335544320);
                App.m().startActivity(s10);
                HashMap hashMap = new HashMap();
                hashMap.put("entity_id", Integer.valueOf(this.entityId));
                hashMap.put("entity_type", Integer.valueOf(this.entityType.getValue()));
                int i10 = this.athleteID;
                if (i10 != -1) {
                    hashMap.put("athlete_id", Integer.valueOf(i10));
                }
                hashMap.put("section", "career-stats");
                ee.k.k(App.m(), "athlete", "entity", "click", null, hashMap);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public static TextView addCellTextView(String str, int i10) {
        TextView textView;
        TextView textView2 = null;
        try {
            textView = new TextView(App.m());
        } catch (Exception e10) {
            e = e10;
        }
        try {
            textView.setMaxLines(1);
            textView.setTypeface(o0.d(App.m()));
            textView.setTextColor(p0.A(R.attr.U0));
            textView.setGravity(17);
            textView.setTextSize(1, i10);
            textView.setTextDirection(3);
            if (str.length() >= 5) {
                str = str.substring(0, 5);
            }
            textView.setText(str);
            textView.setPadding(2, 2, 2, 2);
            return textView;
        } catch (Exception e11) {
            e = e11;
            textView2 = textView;
            x0.N1(e);
            return textView2;
        }
    }

    private void changeTab(int i10, int i11) {
        try {
            this.chosenTrophyType = i10;
            updateCompetitionSelectorItem(i11);
            AthleteObj athleteObj = getAthleteObj();
            if (athleteObj.getTrophiesData().getCategoryById(this.chosenTrophyType).isTrophyHasData(this.chosenCompetitionId)) {
                lambda$onAthleteTrophiesData$2(i11);
            } else {
                fetchAthleteTrophiesData(athleteObj.getID(), this.chosenCompetitionId, i11);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void fetchAthleteTrophiesData(int i10, int i11, int i12) {
        try {
            AthleteDataFetcherHelper.getTrophiesData(i10, i11, i12, this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private AthleteObj getAthleteObj() {
        try {
            if (getArguments() == null || !getArguments().containsKey(ATHLETE_TAG)) {
                return null;
            }
            return (AthleteObj) getArguments().getSerializable(ATHLETE_TAG);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private AthletesObj getAthletesObj() {
        try {
            if (getArguments() == null || !getArguments().containsKey(ATHLETES_TAG)) {
                return null;
            }
            return (AthletesObj) getArguments().getSerializable(ATHLETES_TAG);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private com.scores365.Design.PageObjects.b getChooserItem() {
        int i10;
        int i11;
        try {
            AthleteObj athleteObj = getAthleteObj();
            if (athleteObj.getTrophiesData().getCategories().size() > 1) {
                String name = athleteObj.getTrophiesData().getCategories().get(0).getName();
                String name2 = athleteObj.getTrophiesData().getCategories().get(1).getName();
                String str = "";
                int type = athleteObj.getTrophiesData().getCategories().get(0).getType();
                int type2 = athleteObj.getTrophiesData().getCategories().get(1).getType();
                if (athleteObj.getTrophiesData().getCategories().size() > 2) {
                    str = athleteObj.getTrophiesData().getCategories().get(2).getName();
                    i10 = athleteObj.getTrophiesData().getCategories().get(2).getType();
                } else {
                    i10 = -1;
                }
                try {
                    if (getArguments() != null && getArguments().getBoolean("is_national_tag", false)) {
                        i11 = 2;
                        return new PlayerCardTrophiesChooserItem(name, name2, str, i11, x0.l1(), true, App.m().getResources().getDimension(R.dimen.f21649n), type, type2, i10);
                    }
                    if (!isNationalContextSelected(athleteObj.getTrophiesData().getCategories())) {
                        i11 = 1;
                        return new PlayerCardTrophiesChooserItem(name, name2, str, i11, x0.l1(), true, App.m().getResources().getDimension(R.dimen.f21649n), type, type2, i10);
                    }
                    i11 = 2;
                    return new PlayerCardTrophiesChooserItem(name, name2, str, i11, x0.l1(), true, App.m().getResources().getDimension(R.dimen.f21649n), type, type2, i10);
                } catch (Exception e10) {
                    e = e10;
                    x0.N1(e);
                    return null;
                }
            }
            return null;
        } catch (Exception e11) {
            e = e11;
        }
    }

    private GamesObj getGamesObj() {
        try {
            if (getArguments() == null || !getArguments().containsKey(GAMES_TAG)) {
                return null;
            }
            return (GamesObj) getArguments().getSerializable(GAMES_TAG);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> getInjurySuspensionItems(ArrayList<PlayerCardNextGameItem.Companion.InjurySuspensionStatusItemData> arrayList) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList2 = new ArrayList<>();
        try {
            Iterator<PlayerCardNextGameItem.Companion.InjurySuspensionStatusItemData> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new InjurySuspensionStatusItem(it.next()));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList2;
    }

    private com.scores365.Design.PageObjects.b getNextGameItem() {
        GamesObj gamesObj = getGamesObj();
        if (gamesObj != null) {
            GameObj gameObj = (GameObj) gamesObj.getGames().values().toArray()[0];
            CompetitionObj competitionObj = (CompetitionObj) gamesObj.getCompetitions().values().toArray()[0];
            if (gameObj != null) {
                PlayerCardNextGameItem playerCardNextGameItem = new PlayerCardNextGameItem(gameObj, competitionObj, false, true, false, true, i0.D2(gameObj), true, Locale.getDefault());
                AthleteObj athleteObj = getAthleteObj();
                playerCardNextGameItem.setWwwInnerDataItem(new f0(true, athleteObj != null ? athleteObj.getID() : -1, competitionObj != null ? competitionObj.getID() : -1, athleteObj != null && App.b.r(athleteObj.getID(), App.c.ATHLETE), athleteObj != null && isCoach(athleteObj.getPlayerPositionType(), athleteObj.getSportType())));
                playerCardNextGameItem.setInjuryData(this.injurySuspensionData);
                return playerCardNextGameItem;
            }
        }
        return null;
    }

    private String getNextGameItemTitleForPlayersPage(GameObj gameObj, CompetitionObj competitionObj) {
        LinkedHashMap<Integer, CompetitionObj> linkedHashMap;
        String str = "";
        if (gameObj != null) {
            String l02 = gameObj.isNotStarted() ? p0.l0("PLAYER_CARD_NEXT_GAME") : gameObj.getIsActive() ? p0.l0("PLAYER_CARD_LIVE_GAME") : p0.l0("PLAYER_CARD_LAST_GAME");
            AthletesObj athletesObj = getAthletesObj();
            if (competitionObj == null) {
                CompetitionObj competitionObj2 = (athletesObj == null || (linkedHashMap = athletesObj.competitionsById) == null) ? null : linkedHashMap.get(Integer.valueOf(gameObj.getCompetitionID()));
                if (competitionObj2 != null) {
                    str = competitionObj2.getName();
                }
            } else {
                str = competitionObj.getName();
            }
            if (TextUtils.isEmpty(str)) {
                return l02;
            }
            return l02 + " - " + str;
        }
        return "";
    }

    private com.scores365.Design.PageObjects.b getRecentlyWonTrophyItem() {
        RecentlyWonPersonalTrophyObj recentlyWonPersonalTrophyObj = getAthleteObj().trophyObj;
        CompetitionObj competitionObj = getAthletesObj().getCompetitionsById().get(Integer.valueOf(recentlyWonPersonalTrophyObj.getCompetitionID()));
        if (competitionObj == null || recentlyWonPersonalTrophyObj.getTitle().isEmpty()) {
            return null;
        }
        return new RecentlyWonPersonalTrophyItem(new RecentlyWonPersonalTrophyObj(recentlyWonPersonalTrophyObj.getTitle(), recentlyWonPersonalTrophyObj.getCompetitionID()), competitionObj, getAthleteObj().getID());
    }

    public static ScoreBoxRowHelperObject getSeasonRow(String str, String str2, String str3, String str4, int i10, int i11, int i12, boolean z10, int i13, int i14, boolean z11) {
        try {
            App.c y02 = x0.y0(str);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(i11, p0.s(48));
            TableRow tableRow = new TableRow(App.m());
            tableRow.setLayoutParams(new TableLayout.LayoutParams(p0.s(p0.A0(App.p()) / 2), -2));
            ConstraintLayout constraintLayout = new ConstraintLayout(App.m());
            ImageView imageView = new ImageView(App.m());
            TextView textView = new TextView(App.m());
            TextView textView2 = new TextView(App.m());
            updateRowWithContent(constraintLayout, imageView, textView, textView2, str3, str2, i10, i13);
            constraintLayout.addView(imageView);
            constraintLayout.addView(textView);
            constraintLayout.addView(textView2);
            constraintLayout.setLayoutParams(layoutParams);
            tableRow.addView(constraintLayout);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(-2, -2));
            tableRow.setPadding(0, p0.s(1), 0, 0);
            if (y02 != null && z10) {
                constraintLayout.setOnClickListener(new CompetitorClickListener(i12, y02, i14));
            }
            return new ScoreBoxRowHelperObject(imageView, tableRow, str4, z11, false, null, false);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r2.getStats() == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
        r0.addAll(getTableSeasonRowsFrom(r2.getStats()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
        if (r0.size() <= 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
        r0.add(0, new com.scores365.entitys.ScoreBoxObjects.ScoreBoxRowHelperObject(null, getTopTitleRow(r2.getName(), 32), "", false, true, r2.getTitleName(), false));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.ArrayList<com.scores365.entitys.ScoreBoxObjects.ScoreBoxRowHelperObject> getSeasonsRows() {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.scores365.entitys.AthleteObj r1 = r11.getAthleteObj()     // Catch: java.lang.Exception -> L67
            com.scores365.entitys.TrophiesData r1 = r1.getTrophiesData()     // Catch: java.lang.Exception -> L67
            int r2 = r11.chosenTrophyType     // Catch: java.lang.Exception -> L67
            com.scores365.entitys.Trophies r1 = r1.getCategoryById(r2)     // Catch: java.lang.Exception -> L67
            if (r1 == 0) goto L6b
            java.util.ArrayList r1 = r1.getTrophies()     // Catch: java.lang.Exception -> L67
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L67
        L1d:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Exception -> L67
            if (r2 == 0) goto L6b
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> L67
            com.scores365.entitys.Trophy r2 = (com.scores365.entitys.Trophy) r2     // Catch: java.lang.Exception -> L67
            int r3 = r11.chosenCompetitionId     // Catch: java.lang.Exception -> L67
            int r4 = r2.getCompetitionID()     // Catch: java.lang.Exception -> L67
            if (r3 != r4) goto L1d
            com.scores365.entitys.TrophyStats r1 = r2.getStats()     // Catch: java.lang.Exception -> L67
            if (r1 == 0) goto L42
            com.scores365.entitys.TrophyStats r1 = r2.getStats()     // Catch: java.lang.Exception -> L67
            java.util.ArrayList r1 = r11.getTableSeasonRowsFrom(r1)     // Catch: java.lang.Exception -> L67
            r0.addAll(r1)     // Catch: java.lang.Exception -> L67
        L42:
            int r1 = r0.size()     // Catch: java.lang.Exception -> L67
            if (r1 <= 0) goto L6b
            com.scores365.entitys.ScoreBoxObjects.ScoreBoxRowHelperObject r1 = new com.scores365.entitys.ScoreBoxObjects.ScoreBoxRowHelperObject     // Catch: java.lang.Exception -> L67
            r4 = 0
            java.lang.String r3 = r2.getName()     // Catch: java.lang.Exception -> L67
            r5 = 32
            android.widget.TableRow r5 = getTopTitleRow(r3, r5)     // Catch: java.lang.Exception -> L67
            java.lang.String r6 = ""
            r7 = 0
            r8 = 1
            java.lang.String r9 = r2.getTitleName()     // Catch: java.lang.Exception -> L67
            r10 = 0
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L67
            r2 = 0
            r0.add(r2, r1)     // Catch: java.lang.Exception -> L67
            goto L6b
        L67:
            r1 = move-exception
            li.x0.N1(r1)
        L6b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.playerCard.SinglePlayerProfilePage.getSeasonsRows():java.util.ArrayList");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
        r0.addAll(getTableColumnsHeader(r3, r1.getSportType()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
        if (r3.getStats() == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0042, code lost:
        r0.addAll(getTableRowsFrom(r3.getStats()));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.ArrayList<android.widget.TableRow> getStatisticsRows() {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.scores365.entitys.AthleteObj r1 = r6.getAthleteObj()     // Catch: java.lang.Exception -> L4e
            com.scores365.entitys.TrophiesData r2 = r1.getTrophiesData()     // Catch: java.lang.Exception -> L4e
            int r3 = r6.chosenTrophyType     // Catch: java.lang.Exception -> L4e
            com.scores365.entitys.Trophies r2 = r2.getCategoryById(r3)     // Catch: java.lang.Exception -> L4e
            if (r2 == 0) goto L52
            java.util.ArrayList r2 = r2.getTrophies()     // Catch: java.lang.Exception -> L4e
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Exception -> L4e
        L1d:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Exception -> L4e
            if (r3 == 0) goto L52
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Exception -> L4e
            com.scores365.entitys.Trophy r3 = (com.scores365.entitys.Trophy) r3     // Catch: java.lang.Exception -> L4e
            int r4 = r6.chosenCompetitionId     // Catch: java.lang.Exception -> L4e
            int r5 = r3.getCompetitionID()     // Catch: java.lang.Exception -> L4e
            if (r4 != r5) goto L1d
            com.scores365.entitys.SportTypesEnum r1 = r1.getSportType()     // Catch: java.lang.Exception -> L4e
            java.util.ArrayList r1 = r6.getTableColumnsHeader(r3, r1)     // Catch: java.lang.Exception -> L4e
            r0.addAll(r1)     // Catch: java.lang.Exception -> L4e
            com.scores365.entitys.TrophyStats r1 = r3.getStats()     // Catch: java.lang.Exception -> L4e
            if (r1 == 0) goto L52
            com.scores365.entitys.TrophyStats r1 = r3.getStats()     // Catch: java.lang.Exception -> L4e
            java.util.ArrayList r1 = r6.getTableRowsFrom(r1)     // Catch: java.lang.Exception -> L4e
            r0.addAll(r1)     // Catch: java.lang.Exception -> L4e
            goto L52
        L4e:
            r1 = move-exception
            li.x0.N1(r1)
        L52:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.playerCard.SinglePlayerProfilePage.getStatisticsRows():java.util.ArrayList");
    }

    private ArrayList<PlayerCardNextGameItem.Companion.InjurySuspensionStatusItemData> getSuspensionDataList() {
        SuspensionObj[] suspensions;
        String str;
        LinkedHashMap<Integer, CompetitionObj> linkedHashMap;
        ArrayList<PlayerCardNextGameItem.Companion.InjurySuspensionStatusItemData> arrayList = new ArrayList<>();
        AthletesObj athletesObj = getAthletesObj();
        AthleteObj athleteObj = getAthleteObj();
        if (athleteObj.getSuspensions() != null) {
            for (SuspensionObj suspensionObj : athleteObj.getSuspensions()) {
                int i10 = AnonymousClass1.$SwitchMap$com$scores365$entitys$SuspensionObj$ESoccerSuspensionTypes[suspensionObj.getSuspensionType().ordinal()];
                int i11 = i10 != 1 ? i10 != 2 ? i10 != 3 ? 0 : R.drawable.K2 : R.drawable.f21842w3 : R.drawable.f21780o5;
                String suspensionIconLink = PlayerObj.getSuspensionIconLink(p0.s(16), suspensionObj.getSuspensionTypeImgID(), suspensionObj.getSuspensionTypeInt());
                if (athletesObj == null || (linkedHashMap = athletesObj.competitionsById) == null || linkedHashMap.isEmpty() || !athletesObj.competitionsById.containsKey(Integer.valueOf(suspensionObj.competition))) {
                    str = "";
                } else {
                    str = suspensionObj.gamesCount > 1 ? p0.l0("PLAYER_SUSPENSION_STATUS_PLURAL").replace("#GAMES_COUNT", String.valueOf(suspensionObj.gamesCount)) : p0.l0("PLAYER_SUSPENSION_STATUS_SINGULAR");
                    try {
                        CompetitionObj competitionObj = athletesObj.competitionsById.get(Integer.valueOf(suspensionObj.competition));
                        str = str.replace("#COMPETITION", competitionObj != null ? competitionObj.getName() : "");
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
                arrayList.add(new PlayerCardNextGameItem.Companion.InjurySuspensionStatusItemData("", suspensionObj.getTypeName() + " - " + str, i11, suspensionIconLink));
            }
        }
        return arrayList;
    }

    private ArrayList<TableRow> getTableColumnsHeader(Trophy trophy, SportTypesEnum sportTypesEnum) {
        ArrayList<TableRow> arrayList = new ArrayList<>();
        try {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            TrophyStats stats = trophy.getStats();
            if (stats != null && stats.getColumns() != null) {
                Iterator<AthleteTrophiesScoreBoxColumnObj> it = stats.getColumns().iterator();
                while (it.hasNext()) {
                    AthleteTrophiesScoreBoxColumnObj next = it.next();
                    if (stats.isShowColumnIcons()) {
                        linkedHashSet.add(o.y(next.getEntity().getId(), "-1", Integer.valueOf(p0.s(16)), Integer.valueOf(p0.s(16))));
                    }
                }
            }
            arrayList.add(returnStatsHeaderTableRow(linkedHashSet, 32, 32, 8, null, sportTypesEnum != SportTypesEnum.SOCCER, false));
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    private ArrayList<TableRow> getTableRowsFrom(TrophyStats trophyStats) {
        ArrayList<TableRow> arrayList = new ArrayList<>();
        try {
            Iterator<AthleteTrophiesScoreBoxRowObj> it = trophyStats.getRows().iterator();
            while (it.hasNext()) {
                int A0 = (int) ((p0.A0(App.p()) - p0.s(4)) * 0.4d);
                TableRow tableRow = new TableRow(App.m());
                tableRow.setLayoutParams(new TableRow.LayoutParams(p0.s(A0), -2));
                LinearLayout linearLayout = new LinearLayout(App.m());
                linearLayout.setOrientation(0);
                linearLayout.setBackgroundColor(p0.A(R.attr.f21557k));
                ArrayList<ScoreBoxValueObj> values = it.next().getValues();
                if (values == null || values.size() <= 0) {
                    TextView addCellTextView = addCellTextView(" ", 11);
                    addCellTextView.setLayoutParams(new LinearLayout.LayoutParams(p0.s(A0), p0.s(48)));
                    linearLayout.addView(addCellTextView);
                    tableRow.addView(linearLayout);
                } else {
                    int i10 = 0;
                    while (i10 < values.size()) {
                        i10++;
                        TextView addCellTextView2 = addCellTextView(values.get(i10).getValue(), 11);
                        addCellTextView2.setLayoutParams(new LinearLayout.LayoutParams(p0.s(32), p0.s(46)));
                        linearLayout.addView(addCellTextView2);
                    }
                    if (x0.l1()) {
                        linearLayout.setGravity(19);
                    } else {
                        linearLayout.setGravity(21);
                    }
                    if (x0.l1()) {
                        tableRow.setGravity(19);
                    } else {
                        tableRow.setGravity(21);
                    }
                    linearLayout.setBackgroundColor(p0.A(R.attr.f21557k));
                    linearLayout.setLayoutParams(new TableRow.LayoutParams(p0.s(A0), p0.s(48)));
                    tableRow.addView(linearLayout);
                    tableRow.setBackgroundColor(p0.A(R.attr.f21554j));
                }
                tableRow.setPadding(0, p0.s(1), 0, 0);
                arrayList.add(tableRow);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    private ArrayList<ScoreBoxRowHelperObject> getTableSeasonRowsFrom(TrophyStats trophyStats) {
        ArrayList<ScoreBoxRowHelperObject> arrayList = new ArrayList<>();
        AthletesObj athletesObj = (AthletesObj) getArguments().getSerializable(ATHLETES_TAG);
        if (trophyStats.getRows().size() > 0) {
            Iterator<AthleteTrophiesScoreBoxRowObj> it = trophyStats.getRows().iterator();
            while (it.hasNext()) {
                AthleteTrophiesScoreBoxRowObj next = it.next();
                String e10 = o.e(next.getEntityID(), false);
                CompObj compObj = athletesObj.getCompetitorsById().get(Integer.valueOf(next.getEntityID()));
                ScoreBoxRowHelperObject seasonRow = getSeasonRow(trophyStats.getRowsEntityType(), compObj != null ? compObj.getName() : next.getTitle(), next.getSecondaryTitle(), e10, 32, (int) (App.p() * 0.6d), next.getEntityID(), false, 1, -1, true);
                if (seasonRow != null) {
                    arrayList.add(seasonRow);
                }
            }
        }
        return arrayList;
    }

    public static TableRow getTopTitleRow(String str, int i10) {
        TableRow tableRow = new TableRow(App.m());
        try {
            tableRow.setBackgroundColor(p0.A(R.attr.f21557k));
            tableRow.setLayoutParams(new TableLayout.LayoutParams(-2, -2));
            TextView textView = new TextView(App.m());
            textView.setLayoutParams(new TableRow.LayoutParams(-1, -2));
            textView.getLayoutParams().height = p0.s(i10);
            textView.getLayoutParams().width = -2;
            if (x0.l1()) {
                textView.setPadding(0, 0, p0.s(6), p0.s(1));
                textView.setGravity(21);
            } else {
                textView.setPadding(p0.s(6), 0, 0, p0.s(1));
                textView.setGravity(19);
            }
            textView.setText(str);
            textView.setTextColor(p0.A(R.attr.f21565m1));
            textView.setTextSize(1, 12.0f);
            textView.setMaxLines(2);
            textView.setTypeface(o0.d(App.m()));
            tableRow.addView(textView);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return tableRow;
    }

    private ArrayList<com.scores365.Design.PageObjects.b> getTransferHistoryItems() {
        long j10;
        long j11;
        PlayerTransferHistoryItem playerTransferHistoryItem;
        PlayerTransferHistoryItem playerTransferHistoryItem2;
        PlayerTransferHistoryItem playerTransferHistoryItem3;
        PlayerTransferHistoryItem playerTransferHistoryItem4;
        boolean z10;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            AthletesObj athletesObj = getAthletesObj();
            AthleteObj athleteObj = getAthleteObj();
            if (this.rvItems.getItemAnimator() != null) {
                j10 = this.rvItems.getItemAnimator().l();
                j11 = this.rvItems.getItemAnimator().n();
            } else {
                j10 = 120;
                j11 = 250;
            }
            int i10 = 0;
            while (i10 < athleteObj.getTransferHistory().size()) {
                TransferHistoryObj transferHistoryObj = athleteObj.getTransferHistory().get(i10);
                CompObj compObj = athletesObj.competitorsById.get(Integer.valueOf(transferHistoryObj.getCompetitorId()));
                int i11 = athleteObj.getTransferHistory().size() == 1 ? 4 : i10 == 0 ? 1 : i10 == athleteObj.getTransferHistory().size() - 1 ? 3 : 2;
                int id2 = athleteObj.getID();
                if (i10 < 3 || athleteObj.getTransferHistory().size() == 4) {
                    playerTransferHistoryItem4 = playerTransferHistoryItem3;
                    z10 = false;
                } else {
                    playerTransferHistoryItem4 = playerTransferHistoryItem3;
                    z10 = true;
                }
                new PlayerTransferHistoryItem(id2, transferHistoryObj, compObj, i11, z10, j10, j11);
                arrayList.add(playerTransferHistoryItem4);
                i10++;
                athletesObj = athletesObj;
            }
            if (!arrayList.isEmpty()) {
                if ((arrayList.get(0) instanceof PlayerTransferHistoryItem) && (playerTransferHistoryItem2 = (PlayerTransferHistoryItem) arrayList.get(arrayList.size() - 1)) != null && playerTransferHistoryItem2.transferHistoryObj.useDraftText(playerTransferHistoryItem2.compObj)) {
                    ((PlayerTransferHistoryItem) arrayList.get(arrayList.size() - 1)).addTopMargin();
                }
                if ((arrayList.get(arrayList.size() - 1) instanceof PlayerTransferHistoryItem) && (playerTransferHistoryItem = (PlayerTransferHistoryItem) arrayList.get(arrayList.size() - 1)) != null && playerTransferHistoryItem.transferHistoryObj.useDraftText(playerTransferHistoryItem.compObj)) {
                    ((PlayerTransferHistoryItem) arrayList.get(arrayList.size() - 1)).addBottomMargin();
                }
            }
            if (athleteObj.getTransferHistory().size() > 4) {
                arrayList.add(new ExapndCollapsePlayerProfileItem(athleteObj.getTransferHistory().size() == 4, 3, "transfer-history"));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    public static boolean isCoach(int i10, SportTypesEnum sportTypesEnum) {
        SportTypeObj sportTypeObj;
        try {
            if (App.l() == null || App.l().getSportTypes() == null || (sportTypeObj = App.l().getSportTypes().get(Integer.valueOf(sportTypesEnum.getValue()))) == null) {
                return false;
            }
            PositionObj positionObj = sportTypeObj.athletePositions.get(Integer.valueOf(i10));
            return (positionObj != null ? positionObj.getAlias() : "").equals("Management");
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    private boolean isNationalContextSelected(ArrayList<Trophies> arrayList) {
        try {
            if (arrayList.size() <= 1 || !arrayList.get(1).isSelected()) {
                return false;
            }
            return !arrayList.get(0).isSelected();
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public static boolean isOnMainThread() {
        try {
            return Looper.getMainLooper().getThread() == Thread.currentThread();
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$insertFutureGameToPageList$0() {
        try {
            if (getRvBaseAdapter() == null || getRvBaseAdapter().B() == null) {
                return;
            }
            String nextGameItemTitleForPlayersPage = getNextGameItemTitleForPlayersPage(getGamesObj());
            r rVar = (r) getRvBaseAdapter().B().get(this.indexToInsertFutureGame);
            if (rVar == null || rVar.f43276a.equals(nextGameItemTitleForPlayersPage)) {
                return;
            }
            getRvBaseAdapter().B().add(this.indexToInsertFutureGame, new r(nextGameItemTitleForPlayersPage));
            getRvBaseAdapter().B().add(this.indexToInsertFutureGame + 1, getNextGameItem());
            getRvBaseAdapter().I();
            getRvBaseAdapter().notifyItemRangeInserted(this.indexToInsertFutureGame, 2);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRecyclerViewItemClick$1(int i10, int i11) {
        this.rvItems.x1(Math.min(i10 + 1, i11));
    }

    public static SinglePlayerProfilePage newInstance(AthletesObj athletesObj, AthleteObj athleteObj, GamesObj gamesObj, boolean z10, int i10) {
        SinglePlayerProfilePage singlePlayerProfilePage = new SinglePlayerProfilePage();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ATHLETES_TAG, athletesObj);
        bundle.putSerializable(ATHLETE_TAG, athleteObj);
        bundle.putSerializable(GAMES_TAG, gamesObj);
        bundle.putBoolean("is_national_tag", z10);
        bundle.putInt("is_national_tag", i10);
        singlePlayerProfilePage.setArguments(bundle);
        return singlePlayerProfilePage;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003f A[Catch: Exception -> 0x0112, TryCatch #0 {Exception -> 0x0112, blocks: (B:4:0x000d, B:8:0x0019, B:10:0x003f, B:11:0x0043, B:13:0x0049, B:15:0x0051, B:18:0x0066, B:20:0x006d, B:21:0x0071, B:23:0x009b, B:25:0x00c4, B:27:0x00cb, B:26:0x00c8, B:22:0x0095, B:16:0x005b, B:28:0x00d0, B:30:0x00e2, B:33:0x00eb, B:35:0x00f1, B:37:0x0105, B:36:0x0102, B:31:0x00e6, B:7:0x0015), top: B:42:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e2 A[Catch: Exception -> 0x0112, TryCatch #0 {Exception -> 0x0112, blocks: (B:4:0x000d, B:8:0x0019, B:10:0x003f, B:11:0x0043, B:13:0x0049, B:15:0x0051, B:18:0x0066, B:20:0x006d, B:21:0x0071, B:23:0x009b, B:25:0x00c4, B:27:0x00cb, B:26:0x00c8, B:22:0x0095, B:16:0x005b, B:28:0x00d0, B:30:0x00e2, B:33:0x00eb, B:35:0x00f1, B:37:0x0105, B:36:0x0102, B:31:0x00e6, B:7:0x0015), top: B:42:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e6 A[Catch: Exception -> 0x0112, TryCatch #0 {Exception -> 0x0112, blocks: (B:4:0x000d, B:8:0x0019, B:10:0x003f, B:11:0x0043, B:13:0x0049, B:15:0x0051, B:18:0x0066, B:20:0x006d, B:21:0x0071, B:23:0x009b, B:25:0x00c4, B:27:0x00cb, B:26:0x00c8, B:22:0x0095, B:16:0x005b, B:28:0x00d0, B:30:0x00e2, B:33:0x00eb, B:35:0x00f1, B:37:0x0105, B:36:0x0102, B:31:0x00e6, B:7:0x0015), top: B:42:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00eb A[Catch: Exception -> 0x0112, LOOP:1: B:33:0x00eb->B:35:0x00f1, LOOP_START, PHI: r4 
      PHI: (r4v3 int) = (r4v2 int), (r4v4 int) binds: [B:32:0x00e9, B:35:0x00f1] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x0112, blocks: (B:4:0x000d, B:8:0x0019, B:10:0x003f, B:11:0x0043, B:13:0x0049, B:15:0x0051, B:18:0x0066, B:20:0x006d, B:21:0x0071, B:23:0x009b, B:25:0x00c4, B:27:0x00cb, B:26:0x00c8, B:22:0x0095, B:16:0x005b, B:28:0x00d0, B:30:0x00e2, B:33:0x00eb, B:35:0x00f1, B:37:0x0105, B:36:0x0102, B:31:0x00e6, B:7:0x0015), top: B:42:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0102 A[Catch: Exception -> 0x0112, TryCatch #0 {Exception -> 0x0112, blocks: (B:4:0x000d, B:8:0x0019, B:10:0x003f, B:11:0x0043, B:13:0x0049, B:15:0x0051, B:18:0x0066, B:20:0x006d, B:21:0x0071, B:23:0x009b, B:25:0x00c4, B:27:0x00cb, B:26:0x00c8, B:22:0x0095, B:16:0x005b, B:28:0x00d0, B:30:0x00e2, B:33:0x00eb, B:35:0x00f1, B:37:0x0105, B:36:0x0102, B:31:0x00e6, B:7:0x0015), top: B:42:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.widget.TableRow returnStatsHeaderTableRow(java.util.HashSet<java.lang.String> r13, int r14, int r15, int r16, android.view.View.OnClickListener r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.playerCard.SinglePlayerProfilePage.returnStatsHeaderTableRow(java.util.HashSet, int, int, int, android.view.View$OnClickListener, boolean, boolean):android.widget.TableRow");
    }

    private void updateCompetitionSelectorItem(int i10) {
        com.scores365.Design.PageObjects.b bVar;
        try {
            AthleteObj athleteObj = getAthleteObj();
            do {
                i10++;
                if (i10 >= this.rvBaseAdapter.B().size()) {
                    return;
                }
                bVar = this.rvBaseAdapter.B().get(i10);
            } while (!(bVar instanceof PlayerTrophiesCompetitionSelectorItem));
            PlayerTrophiesCompetitionSelectorItem playerTrophiesCompetitionSelectorItem = (PlayerTrophiesCompetitionSelectorItem) bVar;
            playerTrophiesCompetitionSelectorItem.setTrophies(athleteObj.getTrophiesData().getCategoryById(this.chosenTrophyType).getTrophies());
            playerTrophiesCompetitionSelectorItem.resetData();
            playerTrophiesCompetitionSelectorItem.resetSelecetedIndex();
            RecyclerView.e0 a02 = this.rvItems.a0(i10);
            if (a02 instanceof PlayerTrophiesCompetitionSelectorItem.ViewHolder) {
                ((PlayerTrophiesCompetitionSelectorItem.ViewHolder) a02).getHorizontalRecyclerView().p1(0);
            }
            this.chosenCompetitionId = athleteObj.getTrophiesData().getCategoryById(this.chosenTrophyType).getTrophies().get(0).getCompetitionID();
            this.rvBaseAdapter.notifyItemChanged(i10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void updateGame(GameObj gameObj) {
        for (int i10 = 0; i10 < getRvBaseAdapter().B().size(); i10++) {
            com.scores365.Design.PageObjects.b bVar = getRvBaseAdapter().B().get(i10);
            if (bVar.getObjectTypeNum() == u.GameWithWwwNewOdds.ordinal()) {
                ((sg.d) bVar).updateGameData(gameObj);
                getRvBaseAdapter().notifyItemChanged(i10, bVar);
                updateTitle(i10, gameObj);
            }
        }
    }

    public static void updateRowWithContent(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, String str, String str2, int i10, int i11) {
        try {
            textView.setTextSize(1, 13.0f);
            textView2.setTextSize(1, 13.0f);
            textView.setTypeface(o0.d(App.m()));
            textView2.setTypeface(o0.d(App.m()));
            constraintLayout.setId(p0.t());
            if (imageView != null) {
                imageView.setId(p0.t());
            }
            textView.setId(p0.t());
            textView.setMaxLines(i11);
            textView2.setId(p0.t());
            textView2.setMaxLines(1);
            boolean z10 = imageView != null;
            ConstraintLayout.b bVar = new ConstraintLayout.b(p0.A0(App.p()) / 2, p0.s(48));
            ConstraintLayout.b bVar2 = new ConstraintLayout.b(0, p0.s(48));
            ConstraintLayout.b bVar3 = new ConstraintLayout.b(p0.A0(App.p()) / 2, p0.s(48));
            bVar.f4630i = constraintLayout.getId();
            bVar.f4636l = constraintLayout.getId();
            ((ViewGroup.MarginLayoutParams) bVar3).width = -2;
            ((ViewGroup.MarginLayoutParams) bVar).width = p0.s(i10);
            ((ViewGroup.MarginLayoutParams) bVar).height = p0.s(i10);
            if (z10) {
                bVar2.f4630i = imageView.getId();
                bVar3.f4636l = imageView.getId();
            } else {
                bVar2.f4630i = constraintLayout.getId();
                bVar3.f4636l = constraintLayout.getId();
            }
            boolean z11 = !str.isEmpty();
            if (z11) {
                textView2.setText(str);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
                bVar3.f4632j = -1;
                if (z10) {
                    bVar2.f4636l = imageView.getId();
                } else {
                    bVar2.f4636l = constraintLayout.getId();
                }
            }
            if (x0.l1()) {
                bVar.f4628h = 0;
                bVar2.f4622e = 0;
                if (z10) {
                    bVar2.f4626g = imageView.getId();
                    bVar3.f4626g = imageView.getId();
                } else {
                    bVar2.f4628h = 0;
                }
                textView.setGravity(5);
                textView2.setGravity(5);
            } else {
                bVar.f4622e = 0;
                bVar2.f4628h = 0;
                if (z10) {
                    bVar2.f4624f = imageView.getId();
                    bVar3.f4624f = imageView.getId();
                } else {
                    bVar2.f4622e = 0;
                }
                textView.setGravity(3);
                textView2.setGravity(3);
            }
            bVar2.setMargins(p0.s(8), p0.s(0), p0.s(8), p0.s(0));
            bVar3.setMargins(p0.s(8), p0.s(0), p0.s(8), p0.s(0));
            bVar.setMargins(p0.s(5), p0.s(6), p0.s(5), p0.s(6));
            textView.setTextColor(p0.A(R.attr.U0));
            textView2.setTextColor(p0.A(R.attr.U0));
            textView2.setTextSize(1, 13.0f);
            if (z11) {
                if (x0.l1()) {
                    textView.setGravity(53);
                }
                textView2.setGravity(80);
                ((ViewGroup.MarginLayoutParams) bVar2).height = -2;
                ((ViewGroup.MarginLayoutParams) bVar3).height = -2;
                bVar2.f4634k = textView2.getId();
                bVar3.f4632j = textView.getId();
                bVar2.O = 2;
                bVar3.O = 2;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
            } else if (x0.l1()) {
                textView.setGravity(21);
            } else {
                textView.setGravity(16);
            }
            textView.setLayoutParams(bVar2);
            textView2.setLayoutParams(bVar3);
            if (z10) {
                imageView.setLayoutParams(bVar);
            }
            constraintLayout.setBackgroundColor(p0.A(R.attr.f21557k));
            textView.setText(str2);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void updateTitle(int i10, GameObj gameObj) {
        if (i10 > 0) {
            int i11 = i10 - 1;
            com.scores365.Design.PageObjects.b bVar = getRvBaseAdapter().B().get(i11);
            if (bVar.getObjectTypeNum() == u.PlainTitleItem.ordinal()) {
                ((r) bVar).f43276a = getNextGameItemTitleForPlayersPage(gameObj, null);
                getRvBaseAdapter().notifyItemChanged(i11, bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateTrophyStatsItem */
    public void lambda$onAthleteTrophiesData$2(int i10) {
        for (int i11 = i10 + 1; i11 < this.rvBaseAdapter.B().size(); i11++) {
            try {
                com.scores365.Design.PageObjects.b bVar = this.rvBaseAdapter.B().get(i11);
                if (bVar instanceof ProfileTrophyItem) {
                    ProfileTrophyItem profileTrophyItem = (ProfileTrophyItem) bVar;
                    ArrayList<ScoreBoxRowHelperObject> seasonsRows = getSeasonsRows();
                    ArrayList<TableRow> statisticsRows = getStatisticsRows();
                    profileTrophyItem.setSeasonsRows(seasonsRows);
                    profileTrophyItem.setStatisticsRows(statisticsRows);
                    boolean z10 = false;
                    profileTrophyItem.setShowOnly3(statisticsRows.size() > 4 && !this.isTrophyListExpanded);
                    this.rvBaseAdapter.notifyItemChanged(i11);
                    if (seasonsRows.size() > 4 && statisticsRows.size() > 0) {
                        if (this.rvBaseAdapter.B().size() - 1 == i11) {
                            ArrayList<com.scores365.Design.PageObjects.b> B = this.rvBaseAdapter.B();
                            if (this.isTrophyListExpanded && statisticsRows.size() > 4) {
                                z10 = true;
                            }
                            B.add(new SeeAllTableItem(null, 2, z10));
                            this.rvBaseAdapter.I();
                            this.rvBaseAdapter.notifyItemInserted(i11 + 1);
                            return;
                        }
                        return;
                    }
                    if (this.rvBaseAdapter.B().size() - 1 > i11) {
                        int i12 = i11 + 1;
                        if (this.rvBaseAdapter.B().get(i12) instanceof SeeAllTableItem) {
                            this.rvBaseAdapter.B().remove(i12);
                            this.rvBaseAdapter.notifyItemRemoved(i12);
                            return;
                        }
                        return;
                    }
                    return;
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        String str;
        com.scores365.Design.PageObjects.b recentlyWonTrophyItem;
        String str2;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            AthletesObj athletesObj = getAthletesObj();
            AthleteObj athleteObj = getAthleteObj();
            if (athleteObj.getInjuryStatusObj() != null) {
                ArrayList<PlayerCardNextGameItem.Companion.InjurySuspensionStatusItemData> arrayList2 = new ArrayList<>();
                PlayerCardNextGameItem.Companion.InjurySuspensionStatusItemData a10 = nb.u.a(athleteObj.getInjuryStatusObj());
                this.injurySuspensionData = a10;
                if (a10 != null && ((str2 = athleteObj.nextMatchApiURL) == null || str2.isEmpty())) {
                    arrayList2.add(this.injurySuspensionData);
                    arrayList.addAll(getInjurySuspensionItems(arrayList2));
                }
            } else {
                ArrayList<PlayerCardNextGameItem.Companion.InjurySuspensionStatusItemData> suspensionDataList = getSuspensionDataList();
                if (!suspensionDataList.isEmpty() && ((str = athleteObj.nextMatchApiURL) == null || str.isEmpty())) {
                    arrayList.addAll(getInjurySuspensionItems(suspensionDataList));
                } else if (!suspensionDataList.isEmpty()) {
                    this.injurySuspensionData = suspensionDataList.get(0);
                }
            }
            com.scores365.Design.PageObjects.b nextGameItem = getNextGameItem();
            if (athleteObj.trophyObj != null && (recentlyWonTrophyItem = getRecentlyWonTrophyItem()) != null) {
                arrayList.add(recentlyWonTrophyItem);
            }
            if (isCoach(athleteObj.getPlayerPositionType(), athleteObj.getSportType())) {
                arrayList.add(new r(p0.l0("NEW_PLAYER_CARD_SOCCER_PERSONAL_DETAILS")));
            } else {
                arrayList.add(new r(p0.l0("NEW_PLAYER_CARD_SOCCER_PLAYER_DETAILS")));
            }
            arrayList.add(new PlayerDetailsItem(athletesObj, athleteObj, athleteObj.getID()));
            this.indexToInsertFutureGame = arrayList.size();
            if (nextGameItem != null) {
                arrayList.add(new r(getNextGameItemTitleForPlayersPage(getGamesObj())));
                arrayList.add(nextGameItem);
            }
            AthleteStatisticsObj[] athleteStatisticsObjArr = athleteObj.athleteStatistics;
            if (athleteStatisticsObjArr != null && athleteStatisticsObjArr.length > 0) {
                arrayList.add(new r(p0.l0("NEW_PLAYER_CARD_SOCCER_STATS_CARD_TITLE")));
                CompetitionObj competitionObj = athletesObj.competitionsById.get(Integer.valueOf(athleteObj.athleteStatistics[0].competitionId));
                String name = competitionObj != null ? competitionObj.getName() : "";
                String str3 = athleteObj.athleteStatistics[0].titleName;
                if (str3 != null && !str3.isEmpty()) {
                    name = athleteObj.athleteStatistics[0].titleName;
                }
                String str4 = name;
                if (competitionObj != null) {
                    arrayList.add(new PlayerCardProfileStatsItem(competitionObj, athleteObj.athleteStatistics[0], athleteObj.getSportTypeId(), athletesObj.getAthleteStatTypes(), athleteObj.getID(), true, str4));
                    arrayList.add(new SeeAllTableItem(p0.l0("NEW_PLAYER_CARD_SOCCER_STATS_CARD_BUTTON"), 1));
                }
            }
            if (athleteObj.getTransferHistory() != null && !athleteObj.getTransferHistory().isEmpty()) {
                if (isCoach(athleteObj.getPlayerPositionType(), athleteObj.getSportType())) {
                    arrayList.add(new r(p0.l0("NEW_PLAYER_CARD_SOCCER_COACH_CAREER_HISTORY")));
                } else if (x0.X0(athleteObj.getSportType().getValue())) {
                    arrayList.add(new r(p0.l0("NEW_PLAYER_CARD_SOCCER_STATS_CAREER")));
                } else {
                    arrayList.add(new r(p0.l0("NEW_PLAYER_CARD_SOCCER_TRANSFER_HISTORY")));
                }
                arrayList.addAll(getTransferHistoryItems());
            }
            if (athleteObj.getTrophiesData() != null && athleteObj.getTrophiesData().getCategories() != null && !athleteObj.getTrophiesData().getCategories().isEmpty()) {
                String l02 = p0.l0("NEW_PLAYER_CARD_SOCCER_TROPHIES");
                if (athleteObj.getTrophiesData().getCategories().size() == 1) {
                    if (athleteObj.getTrophiesData().getCategories().get(0).getType() == 2) {
                        l02 = p0.l0("NEW_PLAYER_CARD_SOCCER_CLUB_TROPHIES_TITLE");
                    } else if (athleteObj.getTrophiesData().getCategories().get(0).getType() == 3) {
                        l02 = p0.l0("NEW_PLAYER_CARD_SOCCER_INTERNATIONAL_TROPHIES_TITLE");
                    }
                }
                arrayList.add(new r(l02));
                this.chosenTrophyType = athleteObj.getTrophiesData().getCategories().get(0).getType();
                this.chosenCompetitionId = athleteObj.getTrophiesData().getCategoryById(this.chosenTrophyType).getTrophies().get(0).getCompetitionID();
                com.scores365.Design.PageObjects.b chooserItem = getChooserItem();
                if (chooserItem != null) {
                    arrayList.add(chooserItem);
                    if ((getArguments() != null && getArguments().getBoolean("is_national_tag", false)) || isNationalContextSelected(athleteObj.getTrophiesData().getCategories())) {
                        this.chosenTrophyType = athleteObj.getTrophiesData().getCategories().get(1).getType();
                        this.chosenCompetitionId = athleteObj.getTrophiesData().getCategoryById(this.chosenTrophyType).getTrophies().get(0).getCompetitionID();
                    }
                }
                arrayList.add(new PlayerTrophiesCompetitionSelectorItem(athletesObj.competitionsById, athleteObj.getTrophiesData().getCategoryById(this.chosenTrophyType).getTrophies()));
                ArrayList<ScoreBoxRowHelperObject> seasonsRows = getSeasonsRows();
                ArrayList<TableRow> statisticsRows = getStatisticsRows();
                arrayList.add(new ProfileTrophyItem(seasonsRows, statisticsRows, seasonsRows.size() > 3));
                if (seasonsRows.size() > 4 && !statisticsRows.isEmpty()) {
                    arrayList.add(new SeeAllTableItem(null, 2, this.isTrophyListExpanded));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    public String getNextGameItemTitleForPlayersPage(GamesObj gamesObj) {
        GameObj gameObj;
        CompetitionObj competitionObj;
        CompetitionObj competitionObj2 = null;
        if (gamesObj != null) {
            try {
                gameObj = (GameObj) gamesObj.getGames().values().toArray()[0];
            } catch (Exception e10) {
                e = e10;
                gameObj = null;
            }
            try {
                competitionObj = gamesObj.getCompetitions().get(Integer.valueOf(gameObj.getCompetitionID()));
                competitionObj2 = gameObj;
            } catch (Exception e11) {
                e = e11;
                x0.N1(e);
                return getNextGameItemTitleForPlayersPage(gameObj, competitionObj2);
            }
        } else {
            competitionObj = null;
        }
        gameObj = competitionObj2;
        competitionObj2 = competitionObj;
        return getNextGameItemTitleForPlayersPage(gameObj, competitionObj2);
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return null;
    }

    public void insertFutureGameToPageList(GamesObj gamesObj) {
        try {
            if (getArguments() == null) {
                setArguments(new Bundle());
            }
            getArguments().putSerializable(GAMES_TAG, gamesObj);
            this.rvItems.post(new Runnable() { // from class: com.scores365.ui.playerCard.m
                @Override // java.lang.Runnable
                public final void run() {
                    SinglePlayerProfilePage.this.lambda$insertFutureGameToPageList$0();
                }
            });
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.playerCard.AthleteDataFetcherHelper.OnAthleteTrophiesDataListener
    public void onAthleteTrophiesData(TrophyStats trophyStats, int i10, final int i11) {
        if (trophyStats != null) {
            try {
                Iterator<Trophy> it = getAthleteObj().getTrophiesData().getCategoryById(this.chosenTrophyType).getTrophies().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Trophy next = it.next();
                    if (next.getCompetitionID() == i10) {
                        next.setStats(trophyStats);
                        break;
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        requireActivity().runOnUiThread(new Runnable() { // from class: com.scores365.ui.playerCard.l
            @Override // java.lang.Runnable
            public final void run() {
                SinglePlayerProfilePage.this.lambda$onAthleteTrophiesData$2(i11);
            }
        });
    }

    public void onFinished() {
    }

    @Override // hd.m
    public void onGameUpdate(GameObj gameObj) {
        updateGame(gameObj);
    }

    @Override // hd.m
    public void onGamesUpdate(GamesObj gamesObj) {
    }

    @Override // hd.m
    public void onNotification(NotificationObj notificationObj, GameObj gameObj) {
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x018f A[Catch: Exception -> 0x051c, TryCatch #0 {Exception -> 0x051c, blocks: (B:3:0x0007, B:6:0x0026, B:10:0x0042, B:11:0x0075, B:14:0x0084, B:16:0x00ad, B:18:0x00b3, B:23:0x00c4, B:27:0x00d5, B:29:0x00e1, B:31:0x00e8, B:36:0x00f9, B:41:0x0104, B:43:0x0108, B:45:0x0110, B:48:0x011c, B:50:0x0122, B:52:0x012e, B:54:0x0137, B:56:0x013f, B:59:0x0148, B:60:0x014a, B:69:0x01c7, B:72:0x01d0, B:74:0x01da, B:76:0x01ec, B:77:0x01f4, B:82:0x0202, B:85:0x0213, B:87:0x0219, B:91:0x022e, B:92:0x0231, B:61:0x017f, B:63:0x018f, B:64:0x0199, B:66:0x01a7, B:68:0x01b3, B:93:0x0246, B:95:0x024a, B:97:0x0253, B:99:0x025b, B:101:0x027e, B:105:0x029f, B:102:0x0283, B:104:0x029b, B:106:0x02ca, B:109:0x02d0, B:111:0x02dd, B:113:0x02fc, B:115:0x0309, B:114:0x0306, B:116:0x0342, B:118:0x0346, B:120:0x034d, B:122:0x036b, B:125:0x0393, B:126:0x03a7, B:128:0x03b5, B:130:0x03bd, B:132:0x03ce, B:133:0x040c, B:135:0x0410, B:137:0x0418, B:139:0x0434, B:140:0x0438, B:141:0x04a7, B:144:0x04ac, B:146:0x04b8, B:148:0x04c8), top: B:154:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d0 A[Catch: Exception -> 0x051c, TRY_ENTER, TryCatch #0 {Exception -> 0x051c, blocks: (B:3:0x0007, B:6:0x0026, B:10:0x0042, B:11:0x0075, B:14:0x0084, B:16:0x00ad, B:18:0x00b3, B:23:0x00c4, B:27:0x00d5, B:29:0x00e1, B:31:0x00e8, B:36:0x00f9, B:41:0x0104, B:43:0x0108, B:45:0x0110, B:48:0x011c, B:50:0x0122, B:52:0x012e, B:54:0x0137, B:56:0x013f, B:59:0x0148, B:60:0x014a, B:69:0x01c7, B:72:0x01d0, B:74:0x01da, B:76:0x01ec, B:77:0x01f4, B:82:0x0202, B:85:0x0213, B:87:0x0219, B:91:0x022e, B:92:0x0231, B:61:0x017f, B:63:0x018f, B:64:0x0199, B:66:0x01a7, B:68:0x01b3, B:93:0x0246, B:95:0x024a, B:97:0x0253, B:99:0x025b, B:101:0x027e, B:105:0x029f, B:102:0x0283, B:104:0x029b, B:106:0x02ca, B:109:0x02d0, B:111:0x02dd, B:113:0x02fc, B:115:0x0309, B:114:0x0306, B:116:0x0342, B:118:0x0346, B:120:0x034d, B:122:0x036b, B:125:0x0393, B:126:0x03a7, B:128:0x03b5, B:130:0x03bd, B:132:0x03ce, B:133:0x040c, B:135:0x0410, B:137:0x0418, B:139:0x0434, B:140:0x0438, B:141:0x04a7, B:144:0x04ac, B:146:0x04b8, B:148:0x04c8), top: B:154:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ec A[Catch: Exception -> 0x051c, TryCatch #0 {Exception -> 0x051c, blocks: (B:3:0x0007, B:6:0x0026, B:10:0x0042, B:11:0x0075, B:14:0x0084, B:16:0x00ad, B:18:0x00b3, B:23:0x00c4, B:27:0x00d5, B:29:0x00e1, B:31:0x00e8, B:36:0x00f9, B:41:0x0104, B:43:0x0108, B:45:0x0110, B:48:0x011c, B:50:0x0122, B:52:0x012e, B:54:0x0137, B:56:0x013f, B:59:0x0148, B:60:0x014a, B:69:0x01c7, B:72:0x01d0, B:74:0x01da, B:76:0x01ec, B:77:0x01f4, B:82:0x0202, B:85:0x0213, B:87:0x0219, B:91:0x022e, B:92:0x0231, B:61:0x017f, B:63:0x018f, B:64:0x0199, B:66:0x01a7, B:68:0x01b3, B:93:0x0246, B:95:0x024a, B:97:0x0253, B:99:0x025b, B:101:0x027e, B:105:0x029f, B:102:0x0283, B:104:0x029b, B:106:0x02ca, B:109:0x02d0, B:111:0x02dd, B:113:0x02fc, B:115:0x0309, B:114:0x0306, B:116:0x0342, B:118:0x0346, B:120:0x034d, B:122:0x036b, B:125:0x0393, B:126:0x03a7, B:128:0x03b5, B:130:0x03bd, B:132:0x03ce, B:133:0x040c, B:135:0x0410, B:137:0x0418, B:139:0x0434, B:140:0x0438, B:141:0x04a7, B:144:0x04ac, B:146:0x04b8, B:148:0x04c8), top: B:154:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0219 A[Catch: Exception -> 0x051c, TryCatch #0 {Exception -> 0x051c, blocks: (B:3:0x0007, B:6:0x0026, B:10:0x0042, B:11:0x0075, B:14:0x0084, B:16:0x00ad, B:18:0x00b3, B:23:0x00c4, B:27:0x00d5, B:29:0x00e1, B:31:0x00e8, B:36:0x00f9, B:41:0x0104, B:43:0x0108, B:45:0x0110, B:48:0x011c, B:50:0x0122, B:52:0x012e, B:54:0x0137, B:56:0x013f, B:59:0x0148, B:60:0x014a, B:69:0x01c7, B:72:0x01d0, B:74:0x01da, B:76:0x01ec, B:77:0x01f4, B:82:0x0202, B:85:0x0213, B:87:0x0219, B:91:0x022e, B:92:0x0231, B:61:0x017f, B:63:0x018f, B:64:0x0199, B:66:0x01a7, B:68:0x01b3, B:93:0x0246, B:95:0x024a, B:97:0x0253, B:99:0x025b, B:101:0x027e, B:105:0x029f, B:102:0x0283, B:104:0x029b, B:106:0x02ca, B:109:0x02d0, B:111:0x02dd, B:113:0x02fc, B:115:0x0309, B:114:0x0306, B:116:0x0342, B:118:0x0346, B:120:0x034d, B:122:0x036b, B:125:0x0393, B:126:0x03a7, B:128:0x03b5, B:130:0x03bd, B:132:0x03ce, B:133:0x040c, B:135:0x0410, B:137:0x0418, B:139:0x0434, B:140:0x0438, B:141:0x04a7, B:144:0x04ac, B:146:0x04b8, B:148:0x04c8), top: B:154:0x0007 }] */
    @Override // com.scores365.Design.Pages.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onRecyclerViewItemClick(int r32) {
        /*
            Method dump skipped, instructions count: 1313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.playerCard.SinglePlayerProfilePage.onRecyclerViewItemClick(int):void");
    }

    @Override // hd.m
    public void showPreloader() {
    }
}
