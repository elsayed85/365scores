package com.scores365.ui.playerCard;

import ag.v;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.PlayerCard.PlayerTopStatsDialogActivity;
import com.scores365.R;
import com.scores365.entitys.AthleteObj;
import com.scores365.entitys.AthleteStatisticsObj;
import com.scores365.entitys.AthleteStats;
import com.scores365.entitys.AthleteTrophiesScoreBoxColumnObj;
import com.scores365.entitys.AthletesObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GameStats;
import com.scores365.entitys.LastMatchHeaderCategory;
import com.scores365.entitys.LastMatchesHeaderObj;
import com.scores365.entitys.LastMatchesObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxCategotyObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxRowHelperObject;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxSummaryObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxTablesObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxValueObj;
import com.scores365.entitys.ScoreBoxObjects.StatLegendObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.gameCenter.GameCenterBaseActivity;
import com.scores365.gameCenter.gameCenterItems.a;
import com.scores365.gameCenter.i0;
import com.scores365.ui.CustomSpinner;
import com.scores365.ui.playerCard.CustomHorizontalScrollView;
import com.scores365.ui.playerCard.LastMatchGameBasketballItem;
import com.scores365.ui.playerCard.LastMatchGameItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import lf.u;
import li.o0;
import li.p0;
import li.x0;
import nb.o;
import nb.p;
import xf.y;
import yc.r;
/* loaded from: classes2.dex */
public class SinglePlayerStatsPage extends q implements View.OnClickListener, iScrollToLegandInPage, CustomSpinner.OnSpinnerEventsListener, LastMatchGameItem.iScrollListener {
    private static final String ATHLETES_TAG = "athletesTag";
    private static final String ATHLETE_ID_TAG = "athleteIdTag";
    private static final String ATHLETE_TAB_TAG = "athleteTab";
    public static final int CAREER_TAG = 2;
    public static final String HEADERS_CATEGORY_LAST_POSITION = "headersCategoryLastPosition";
    private static final int NOT_PLAYER_GAMES_IN_ROW_LIMIT = 3;
    public static final int SEASON_TAG = 1;
    private static final String SELECTED_COMPETITION_TAG = "selectedCompetitionTag";
    private com.scores365.PlayerCard.d careerSpinnerAdapter;
    private ImageView ivCompetitionForSpinner;
    private Toast lastLegendsToast;
    private ConstraintLayout spinnerContainer;
    private Spinner spinnerTables;
    ConstraintLayout tabsContainer;
    TextView tvCareer;
    TextView tvSeason;
    int currentTab = -1;
    private int currentSpinnerPosition = 0;
    private int positionOfSeason = 0;
    int currentLastMatchScrollPosition = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class FetchCareerStatsTask extends AsyncTask<Void, Void, com.scores365.PlayerCard.e> {
        private int athleteId;
        private String key;
        WeakReference<SinglePlayerStatsPage> playerStatsPageWeakReference;

        public FetchCareerStatsTask(SinglePlayerStatsPage singlePlayerStatsPage, int i10, String str) {
            this.athleteId = -1;
            this.key = "";
            this.playerStatsPageWeakReference = new WeakReference<>(singlePlayerStatsPage);
            this.athleteId = i10;
            this.key = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public com.scores365.PlayerCard.e doInBackground(Void... voidArr) {
            com.scores365.PlayerCard.e eVar = null;
            try {
                WeakReference<SinglePlayerStatsPage> weakReference = this.playerStatsPageWeakReference;
                if (weakReference == null || weakReference.get() == null) {
                    return null;
                }
                ApiCareerStats apiCareerStats = new ApiCareerStats(this.athleteId, this.key);
                apiCareerStats.call();
                eVar = apiCareerStats.resultObj;
                AthleteObj.getSeasonsBySeasonKey().get(this.key).f(apiCareerStats.resultObj);
                return eVar;
            } catch (Exception e10) {
                x0.N1(e10);
                return eVar;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(com.scores365.PlayerCard.e eVar) {
            SinglePlayerStatsPage singlePlayerStatsPage;
            super.onPostExecute((FetchCareerStatsTask) eVar);
            try {
                WeakReference<SinglePlayerStatsPage> weakReference = this.playerStatsPageWeakReference;
                if (weakReference == null || (singlePlayerStatsPage = weakReference.get()) == null) {
                    return;
                }
                singlePlayerStatsPage.renderData(singlePlayerStatsPage.updateCareerData(eVar));
                singlePlayerStatsPage.getRvBaseAdapter().notifyDataSetChanged();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean areThereStatsAndCareerStats() {
        /*
            r8 = this;
            r0 = 0
            android.os.Bundle r1 = r8.getArguments()     // Catch: java.lang.Exception -> La9
            java.lang.String r2 = "athletesTag"
            java.io.Serializable r1 = r1.getSerializable(r2)     // Catch: java.lang.Exception -> La9
            com.scores365.entitys.AthletesObj r1 = (com.scores365.entitys.AthletesObj) r1     // Catch: java.lang.Exception -> La9
            android.os.Bundle r2 = r8.getArguments()     // Catch: java.lang.Exception -> La9
            java.lang.String r3 = "athleteIdTag"
            r4 = -1
            int r2 = r2.getInt(r3, r4)     // Catch: java.lang.Exception -> La9
            java.util.LinkedHashMap r3 = r1.getAthleteById()     // Catch: java.lang.Exception -> La9
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> La9
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Exception -> La9
            com.scores365.entitys.AthleteObj r3 = (com.scores365.entitys.AthleteObj) r3     // Catch: java.lang.Exception -> La9
            com.scores365.PlayerCard.a r3 = r3.careerStats     // Catch: java.lang.Exception -> La9
            r4 = 1
            if (r3 == 0) goto L2d
            r3 = 1
            goto L2e
        L2d:
            r3 = 0
        L2e:
            java.util.LinkedHashMap r5 = r1.getAthleteById()     // Catch: java.lang.Exception -> La9
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> La9
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Exception -> La9
            com.scores365.entitys.AthleteObj r5 = (com.scores365.entitys.AthleteObj) r5     // Catch: java.lang.Exception -> La9
            com.scores365.entitys.AthleteStatisticsObj[] r5 = r5.athleteStatistics     // Catch: java.lang.Exception -> La9
            if (r5 == 0) goto L55
            java.util.LinkedHashMap r5 = r1.getAthleteById()     // Catch: java.lang.Exception -> La9
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> La9
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Exception -> La9
            com.scores365.entitys.AthleteObj r5 = (com.scores365.entitys.AthleteObj) r5     // Catch: java.lang.Exception -> La9
            com.scores365.entitys.AthleteStatisticsObj[] r5 = r5.athleteStatistics     // Catch: java.lang.Exception -> La9
            int r5 = r5.length     // Catch: java.lang.Exception -> La9
            if (r5 <= 0) goto L55
            r5 = 1
            goto L56
        L55:
            r5 = 0
        L56:
            java.util.LinkedHashMap r6 = r1.getAthleteById()     // Catch: java.lang.Exception -> La9
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> La9
            java.lang.Object r6 = r6.get(r7)     // Catch: java.lang.Exception -> La9
            com.scores365.entitys.AthleteObj r6 = (com.scores365.entitys.AthleteObj) r6     // Catch: java.lang.Exception -> La9
            com.scores365.entitys.LastMatchesObj r6 = r6.getLastMatchesObj()     // Catch: java.lang.Exception -> La9
            if (r6 == 0) goto La0
            java.util.LinkedHashMap r6 = r1.getAthleteById()     // Catch: java.lang.Exception -> La9
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> La9
            java.lang.Object r6 = r6.get(r7)     // Catch: java.lang.Exception -> La9
            com.scores365.entitys.AthleteObj r6 = (com.scores365.entitys.AthleteObj) r6     // Catch: java.lang.Exception -> La9
            com.scores365.entitys.LastMatchesObj r6 = r6.getLastMatchesObj()     // Catch: java.lang.Exception -> La9
            java.util.ArrayList r6 = r6.getGames()     // Catch: java.lang.Exception -> La9
            if (r6 == 0) goto La0
            java.util.LinkedHashMap r1 = r1.getAthleteById()     // Catch: java.lang.Exception -> La9
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> La9
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Exception -> La9
            com.scores365.entitys.AthleteObj r1 = (com.scores365.entitys.AthleteObj) r1     // Catch: java.lang.Exception -> La9
            com.scores365.entitys.LastMatchesObj r1 = r1.getLastMatchesObj()     // Catch: java.lang.Exception -> La9
            java.util.ArrayList r1 = r1.getGames()     // Catch: java.lang.Exception -> La9
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Exception -> La9
            if (r1 != 0) goto La0
            r1 = 1
            goto La1
        La0:
            r1 = 0
        La1:
            if (r3 == 0) goto Lad
            if (r5 != 0) goto La7
            if (r1 == 0) goto Lad
        La7:
            r0 = 1
            goto Lad
        La9:
            r1 = move-exception
            li.x0.N1(r1)
        Lad:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.playerCard.SinglePlayerStatsPage.areThereStatsAndCareerStats():boolean");
    }

    private LinkedHashMap<Integer, com.scores365.PlayerCard.b> getHashFromListItems(com.scores365.PlayerCard.b[] bVarArr) {
        LinkedHashMap<Integer, com.scores365.PlayerCard.b> linkedHashMap = new LinkedHashMap<>();
        try {
            int i10 = 0;
            for (com.scores365.PlayerCard.b bVar : bVarArr) {
                linkedHashMap.put(Integer.valueOf(i10), bVar);
                i10++;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return linkedHashMap;
    }

    public static y getHeadersCategories(LastMatchesObj lastMatchesObj, Bundle bundle) {
        y yVar = null;
        if (lastMatchesObj == null) {
            return null;
        }
        try {
            if (lastMatchesObj.getHeaderCategories() == null || lastMatchesObj.getHeaderCategories().size() <= 1) {
                return null;
            }
            int i10 = bundle.getInt(HEADERS_CATEGORY_LAST_POSITION, 0);
            ArrayList arrayList = new ArrayList();
            Iterator<LastMatchHeaderCategory> it = lastMatchesObj.getHeaderCategories().iterator();
            while (it.hasNext()) {
                LastMatchHeaderCategory next = it.next();
                arrayList.add(new y.b(next.getID(), next.getName()));
            }
            y yVar2 = new y(arrayList, i10);
            try {
                yVar2.o(48);
                return yVar2;
            } catch (Exception e10) {
                yVar = yVar2;
                e = e10;
                x0.N1(e);
                return yVar;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> getLastMatchesItems(AthletesObj athletesObj, int i10) {
        int i11;
        int i12;
        boolean z10;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            AthleteObj athleteObj = athletesObj.getAthleteById().get(Integer.valueOf(i10));
            LastMatchesObj lastMatchesObj = athleteObj.getLastMatchesObj();
            if (lastMatchesObj != null && lastMatchesObj.getGames().size() > 0) {
                ArrayList<LastMatchGameItem> arrayList2 = new ArrayList<>();
                y headersCategories = getHeadersCategories(lastMatchesObj, getArguments());
                if (headersCategories != null) {
                    arrayList.add(headersCategories);
                    i11 = lastMatchesObj.getHeaderCategories().get(getArguments().getInt(HEADERS_CATEGORY_LAST_POSITION, 0)).getID();
                } else {
                    i11 = -1;
                }
                ArrayList<LastMatchesHeaderObj> headers = lastMatchesObj.getHeaders(i11);
                Iterator<GameStats> it = lastMatchesObj.getGames().iterator();
                int i13 = 0;
                boolean z11 = false;
                while (it.hasNext()) {
                    GameStats next = it.next();
                    if (next.getGameObj() != null) {
                        int relatedCompetitor = next.getRelatedCompetitor();
                        if (i13 == relatedCompetitor) {
                            i12 = i13;
                            z10 = z11;
                        } else if (lastMatchesObj.hasHeaderData()) {
                            arrayList.addAll(getNonPlayedGamesWithExpandItem(arrayList2, false));
                            arrayList2.clear();
                            LastMatchesTitleItem lastMatchesTitleItem = new LastMatchesTitleItem(athletesObj.competitorsById.get(Integer.valueOf(relatedCompetitor)).getShortName(), headers, this);
                            if (!z11) {
                                lastMatchesTitleItem.setTopMargin(p0.s(1));
                            }
                            arrayList.add(lastMatchesTitleItem);
                            i12 = relatedCompetitor;
                            z10 = true;
                        } else {
                            z10 = z11;
                            i12 = relatedCompetitor;
                        }
                        if (next.isPlayed()) {
                            arrayList.addAll(getNonPlayedGamesWithExpandItem(arrayList2, false));
                            arrayList2.clear();
                            arrayList.add(LastMatchGameItem.getLastMatchGameItem(next, false, athleteObj.getSportTypeId(), -1, this, headers));
                        } else {
                            arrayList2.add(LastMatchGameItem.getLastMatchGameItem(next, false, athleteObj.getSportTypeId(), -1, this, headers));
                        }
                        i13 = i12;
                        z11 = z10;
                    }
                }
                arrayList.addAll(getNonPlayedGamesWithExpandItem(arrayList2, false));
                arrayList2.clear();
            }
            if (lastMatchesObj.getPaging() != null && lastMatchesObj.getPaging().fullPage != null && !lastMatchesObj.getPaging().fullPage.isEmpty()) {
                arrayList.add(new SeeAllTableItem(getSeeAllTitle(athleteObj, false), 3));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    private ArrayList<com.scores365.Design.PageObjects.b> getLegendItems(ArrayList<StatLegendObj> arrayList) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList2 = new ArrayList<>();
        try {
            int i10 = getArguments().getInt(ATHLETE_ID_TAG, -1);
            AthletesObj athletesObj = (AthletesObj) getArguments().getSerializable(ATHLETES_TAG);
            AthleteObj athleteObj = athletesObj.getAthleteById().get(Integer.valueOf(i10));
            Iterator<StatLegendObj> it = arrayList.iterator();
            boolean z10 = true;
            while (it.hasNext()) {
                StatLegendObj next = it.next();
                arrayList2.add(new of.i(next.getTitle(), next.getEntityObj().getId(), athleteObj.getSportType().getValue(), z10, athletesObj.getAthleteStatTypes().get(Integer.valueOf(next.getEntityObj().getId())).getShortName()));
                if (z10) {
                    z10 = false;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList2;
    }

    private ArrayList<com.scores365.Design.PageObjects.b> getNonPlayedGamesWithExpandItem(ArrayList<LastMatchGameItem> arrayList, boolean z10) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList2 = new ArrayList<>();
        try {
            if (arrayList.size() >= 3) {
                Iterator<LastMatchGameItem> it = arrayList.iterator();
                while (true) {
                    boolean z11 = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    LastMatchGameItem next = it.next();
                    if (!z10) {
                        z11 = true;
                    }
                    next.setCollapsed(z11);
                }
                arrayList2.add(new PlayerLastMatchExpandItem(z10, arrayList.size(), arrayList.get(arrayList.size() - 1).getGameStats().getGameObj().getSTime(), arrayList.get(0).getGameStats().getGameObj().getSTime()));
            }
            arrayList2.addAll(arrayList);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList2;
    }

    private ArrayList<ScoreBoxRowHelperObject> getRows(ScoreBoxTablesObj scoreBoxTablesObj, double d10, boolean z10) {
        ArrayList<ScoreBoxRowHelperObject> arrayList = new ArrayList<>();
        try {
            AthletesObj athletesObj = (AthletesObj) getArguments().getSerializable(ATHLETES_TAG);
            int i10 = getArguments().getInt(ATHLETE_ID_TAG, -1);
            Iterator<StatsRowObj> it = scoreBoxTablesObj.getRows().iterator();
            String str = null;
            while (it.hasNext()) {
                StatsRowObj next = it.next();
                if (x0.y0(scoreBoxTablesObj.getRowEntityType()) == App.c.LEAGUE) {
                    str = o.x(x0.n1() ? p.CompetitionsLight : p.Competitions, next.getEntityId(), 100, 100, false, p.CountriesRoundFlags, Integer.valueOf(athletesObj.competitionsById.get(Integer.valueOf(next.getEntityId())) != null ? athletesObj.competitionsById.get(Integer.valueOf(next.getEntityId())).getCid() : -1), athletesObj.competitionsById.get(Integer.valueOf(next.getEntityId())) != null ? athletesObj.competitionsById.get(Integer.valueOf(next.getEntityId())).getImgVer() : String.valueOf(-1));
                } else if (x0.y0(scoreBoxTablesObj.getRowEntityType()) == App.c.TEAM) {
                    str = o.x(p.Competitors, next.getEntityId(), 100, 100, false, null, -1, String.valueOf(-1));
                }
                String str2 = str;
                ScoreBoxRowHelperObject seasonRow = SinglePlayerProfilePage.getSeasonRow(scoreBoxTablesObj.getRowEntityType(), next.getTitle(), next.getSecondaryTitle(), str2, 24, (int) (App.p() * 0.45d), next.getEntityId(), true, 2, i10, (scoreBoxTablesObj.getRowEntityType() == null || scoreBoxTablesObj.getRowEntityType().isEmpty()) ? false : true);
                if (seasonRow != null) {
                    arrayList.add(seasonRow);
                }
                str = str2;
            }
            if (scoreBoxTablesObj.getSummary() != null && scoreBoxTablesObj.getSummary().size() > 0 && scoreBoxTablesObj.isShouldShowSummary()) {
                Iterator<ScoreBoxSummaryObj> it2 = scoreBoxTablesObj.getSummary().iterator();
                while (it2.hasNext()) {
                    arrayList.add(new ScoreBoxRowHelperObject(null, i0.Z1(it2.next().getTitle(), true, false, true, shouldUseSmallerTextForStatsTable() ? 12 : 14), "", false, false, null, true));
                }
            }
            if (arrayList.size() > 0) {
                arrayList.add(0, new ScoreBoxRowHelperObject(null, SinglePlayerProfilePage.getTopTitleRow(" ", 32), "", false, true, " ", false));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    private String getSeeAllTitle(AthleteObj athleteObj, boolean z10) {
        return x0.F2(athleteObj.getSportType().getValue()) ? p0.l0("SHOW_FULL_GAMELOG") : (!z10 || x0.F2(athleteObj.getSportType().getValue())) ? p0.l0("H2H_MORE") : p0.l0("NEW_PLAYER_CARD_SOCCER_LAST_MATCHES_TITLE");
    }

    private com.scores365.PlayerCard.e getStats() {
        com.scores365.PlayerCard.e eVar = null;
        try {
            AthletesObj athletesObj = (AthletesObj) getArguments().getSerializable(ATHLETES_TAG);
            int i10 = getArguments().getInt(ATHLETE_ID_TAG, -1);
            if (athletesObj != null && athletesObj.getAthleteById() != null && athletesObj.getAthleteById().get(Integer.valueOf(i10)) != null && athletesObj.getAthleteById().get(Integer.valueOf(i10)).getCareerStats() != null && athletesObj.getAthleteById().get(Integer.valueOf(i10)).getCareerStats().f21373a != null && athletesObj.getAthleteById().get(Integer.valueOf(i10)).getCareerStats().f21373a[this.positionOfSeason] != null) {
                com.scores365.PlayerCard.b bVar = athletesObj.getAthleteById().get(Integer.valueOf(i10)).getCareerStats().f21373a[this.positionOfSeason];
                eVar = bVar.d() != null ? bVar.d() : AthleteObj.getSeasonsBySeasonKey().get(bVar.a()).d();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return eVar;
    }

    private ArrayList<TableRow> getStatsRows(ScoreBoxTablesObj scoreBoxTablesObj, LegendClickListener legendClickListener) {
        ArrayList<TableRow> arrayList = new ArrayList<>();
        try {
            arrayList.addAll(getTableColumnsHeader(scoreBoxTablesObj, ((AthletesObj) getArguments().getSerializable(ATHLETES_TAG)).getAthleteById().get(Integer.valueOf(getArguments().getInt(ATHLETE_ID_TAG, -1))).getSportType(), legendClickListener));
            if (scoreBoxTablesObj.getRows() != null) {
                arrayList.addAll(getTableRowsFrom(scoreBoxTablesObj.getRows()));
            }
            if (scoreBoxTablesObj.getSummary() != null && scoreBoxTablesObj.getSummary().size() > 0 && scoreBoxTablesObj.isShouldShowSummary()) {
                arrayList.addAll(getPlayersSummaryRow(scoreBoxTablesObj.getSummary()));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    private ScoreBoxTablesObj getTableByCategoryId(com.scores365.PlayerCard.e eVar, int i10) {
        try {
            Iterator<ScoreBoxTablesObj> it = eVar.getTables().iterator();
            while (it.hasNext()) {
                ScoreBoxTablesObj next = it.next();
                if (next.getCategoryID() == i10) {
                    return next;
                }
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private ArrayList<TableRow> getTableColumnsHeader(ScoreBoxTablesObj scoreBoxTablesObj, SportTypesEnum sportTypesEnum, LegendClickListener legendClickListener) {
        ArrayList<TableRow> arrayList = new ArrayList<>();
        try {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (scoreBoxTablesObj != null && scoreBoxTablesObj.getColumns() != null) {
                Iterator<AthleteTrophiesScoreBoxColumnObj> it = scoreBoxTablesObj.getColumns().iterator();
                while (it.hasNext()) {
                    AthleteTrophiesScoreBoxColumnObj next = it.next();
                    if (scoreBoxTablesObj.isShowColumnIcons()) {
                        linkedHashSet.add(o.y(next.getEntity().getId(), "-1", Integer.valueOf(p0.s(16)), Integer.valueOf(p0.s(16))));
                    } else {
                        linkedHashSet.add(next.getShortName());
                    }
                }
                arrayList.add(returnStatsHeaderTableRow(linkedHashSet, legendClickListener, !scoreBoxTablesObj.isShowColumnIcons(), x0.F2(sportTypesEnum.getValue())));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    private ArrayList<TableRow> getTableRowsFrom(ArrayList<StatsRowObj> arrayList) {
        ArrayList<TableRow> arrayList2 = new ArrayList<>();
        try {
            Iterator<StatsRowObj> it = arrayList.iterator();
            while (it.hasNext()) {
                TableRow tableRow = new TableRow(App.m());
                TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = p0.s(1);
                tableRow.setLayoutParams(layoutParams);
                tableRow.setBackgroundColor(p0.A(R.attr.f21557k));
                ArrayList<ScoreBoxValueObj> values = it.next().getValues();
                int J0 = i0.J0();
                if (values == null) {
                    TextView addCellTextView = SinglePlayerProfilePage.addCellTextView(" ", getTextSizeForTable());
                    addCellTextView.setLayoutParams(new LinearLayout.LayoutParams(p0.s(J0), p0.s(48)));
                    tableRow.addView(addCellTextView);
                    tableRow.setPadding(0, p0.s(1), 0, 0);
                    tableRow.setGravity(3);
                    arrayList2.add(tableRow);
                } else if (values.size() != 0) {
                    int i10 = 0;
                    while (i10 < values.size()) {
                        i10++;
                        TextView textView = new TextView(App.m());
                        textView.setMaxLines(1);
                        textView.setTypeface(o0.d(App.m()));
                        textView.setTextColor(p0.A(R.attr.U0));
                        textView.setGravity(17);
                        textView.setTextSize(1, getTextSizeForTable());
                        textView.setTextDirection(3);
                        textView.setText(values.get(i10).getValue());
                        int s10 = p0.s(3);
                        textView.setPadding(s10, s10, s10, s10);
                        textView.setMinWidth(p0.s(32));
                        textView.setLayoutParams(new TableRow.LayoutParams(-2, p0.s(48) - p0.s(1)));
                        tableRow.addView(textView);
                    }
                    tableRow.setPadding(0, p0.s(1), 0, 0);
                    arrayList2.add(tableRow);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList2;
    }

    private int getTextSizeForTable() {
        return shouldUseSmallerTextForStatsTable() ? 10 : 11;
    }

    private void handleRequestSeasonStats(com.scores365.PlayerCard.b bVar) {
        try {
            new FetchCareerStatsTask(this, getArguments().getInt(ATHLETE_ID_TAG, -1), bVar.a()).execute(new Void[0]);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSelectedPosition(int i10) {
        try {
            com.scores365.PlayerCard.b bVar = (com.scores365.PlayerCard.b) this.careerSpinnerAdapter.getItem(i10);
            if (bVar == null || bVar.d() == null) {
                handleRequestSeasonStats(bVar);
            } else {
                renderData(updateCareerData(bVar.d()));
                this.rvBaseAdapter.notifyDataSetChanged();
            }
            HideMainPreloader();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void handleSpinner(View view) {
        try {
            this.spinnerContainer = (ConstraintLayout) view.findViewById(R.id.Oo);
            Spinner spinner = (Spinner) view.findViewById(R.id.Bq);
            this.spinnerTables = spinner;
            spinner.setVisibility(0);
            if (x0.l1()) {
                this.ivCompetitionForSpinner = (ImageView) view.findViewById(R.id.f22117kd);
            } else {
                this.ivCompetitionForSpinner = (ImageView) view.findViewById(R.id.f22095jd);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void handleTabs(View view, AthleteObj athleteObj) {
        try {
            this.currentTab = getArguments().getInt(ATHLETE_TAB_TAG, -1);
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.L1);
            this.tabsContainer = constraintLayout;
            constraintLayout.setBackgroundResource(p0.w(App.m(), R.attr.f21554j));
            int p10 = App.p() / 6;
            ConstraintLayout constraintLayout2 = this.tabsContainer;
            constraintLayout2.setPadding(p10, constraintLayout2.getPaddingTop(), p10, this.tabsContainer.getPaddingBottom());
            TextView textView = (TextView) view.findViewById(R.id.NA);
            TextView textView2 = (TextView) view.findViewById(R.id.iD);
            view.findViewById(R.id.Fw).setVisibility(8);
            if (x0.l1()) {
                this.tvSeason = textView2;
                this.tvCareer = textView;
            } else {
                this.tvSeason = textView;
                this.tvCareer = textView2;
            }
            this.tvSeason.setText(p0.l0("NEW_PLAYER_CARD_SOCCER_STATS_SEASON"));
            this.tvCareer.setText(p0.l0("NEW_PLAYER_CARD_SOCCER_STATS_CAREER"));
            this.tvSeason.setTypeface(o0.d(App.m()));
            this.tvCareer.setTypeface(o0.d(App.m()));
            if (this.currentTab == -1) {
                this.currentTab = 1;
            }
            if (this.currentTab == 1) {
                this.tvCareer.setSelected(false);
                this.tvSeason.setSelected(true);
            } else {
                this.tvSeason.setSelected(false);
                this.tvCareer.setSelected(true);
            }
            this.tvSeason.setOnClickListener(this);
            this.tvCareer.setOnClickListener(this);
            this.rvItems.setItemAnimator(null);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private boolean isOnlyCareerReturned() {
        try {
            AthletesObj athletesObj = (AthletesObj) getArguments().getSerializable(ATHLETES_TAG);
            int i10 = getArguments().getInt(ATHLETE_ID_TAG, -1);
            if (athletesObj.getAthleteById().get(Integer.valueOf(i10)).careerStats != null) {
                return athletesObj.getAthleteById().get(Integer.valueOf(i10)).athleteStatistics == null;
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public static SinglePlayerStatsPage newInstance(AthletesObj athletesObj, int i10, int i11, int i12, boolean z10) {
        SinglePlayerStatsPage singlePlayerStatsPage = new SinglePlayerStatsPage();
        Bundle bundle = new Bundle();
        bundle.putInt(ATHLETE_ID_TAG, i10);
        bundle.putInt(SELECTED_COMPETITION_TAG, i12);
        bundle.putSerializable(ATHLETES_TAG, athletesObj);
        bundle.putInt(ATHLETE_TAB_TAG, i11);
        bundle.putBoolean(SinglePlayerCardActivity.IS_NATIONAL_CONTEXT, z10);
        singlePlayerStatsPage.setArguments(bundle);
        return singlePlayerStatsPage;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[Catch: Exception -> 0x00cb, TryCatch #0 {Exception -> 0x00cb, blocks: (B:4:0x000b, B:8:0x0017, B:10:0x002c, B:11:0x0030, B:13:0x0038, B:15:0x0040, B:18:0x0055, B:20:0x0088, B:19:0x0079, B:16:0x004a, B:21:0x0098, B:24:0x00b0, B:26:0x00b6, B:27:0x00c7, B:7:0x0013), top: B:32:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c7 A[Catch: Exception -> 0x00cb, TRY_LEAVE, TryCatch #0 {Exception -> 0x00cb, blocks: (B:4:0x000b, B:8:0x0017, B:10:0x002c, B:11:0x0030, B:13:0x0038, B:15:0x0040, B:18:0x0055, B:20:0x0088, B:19:0x0079, B:16:0x004a, B:21:0x0098, B:24:0x00b0, B:26:0x00b6, B:27:0x00c7, B:7:0x0013), top: B:32:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.widget.TableRow returnStatsHeaderTableRow(java.util.HashSet<java.lang.String> r7, android.view.View.OnClickListener r8, boolean r9, boolean r10) {
        /*
            android.widget.TableRow r0 = new android.widget.TableRow
            android.content.Context r1 = com.scores365.App.m()
            r0.<init>(r1)
            if (r9 != 0) goto L13
            int r1 = r7.size()     // Catch: java.lang.Exception -> Lcb
            r2 = 5
            if (r1 <= r2) goto L13
            goto L17
        L13:
            int r2 = r7.size()     // Catch: java.lang.Exception -> Lcb
        L17:
            android.widget.TableLayout$LayoutParams r1 = new android.widget.TableLayout$LayoutParams     // Catch: java.lang.Exception -> Lcb
            r3 = -1
            r4 = -2
            r1.<init>(r3, r4)     // Catch: java.lang.Exception -> Lcb
            r0.setLayoutParams(r1)     // Catch: java.lang.Exception -> Lcb
            int r1 = com.scores365.R.attr.f21557k     // Catch: java.lang.Exception -> Lcb
            int r1 = li.p0.A(r1)     // Catch: java.lang.Exception -> Lcb
            r0.setBackgroundColor(r1)     // Catch: java.lang.Exception -> Lcb
            if (r2 == 0) goto Lad
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Exception -> Lcb
        L30:
            boolean r1 = r7.hasNext()     // Catch: java.lang.Exception -> Lcb
            r2 = 32
            if (r1 == 0) goto L98
            java.lang.Object r1 = r7.next()     // Catch: java.lang.Exception -> Lcb
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> Lcb
            if (r9 == 0) goto L4a
            android.widget.TextView r3 = new android.widget.TextView     // Catch: java.lang.Exception -> Lcb
            android.content.Context r5 = com.scores365.App.m()     // Catch: java.lang.Exception -> Lcb
            r3.<init>(r5)     // Catch: java.lang.Exception -> Lcb
            goto L53
        L4a:
            android.widget.ImageView r3 = new android.widget.ImageView     // Catch: java.lang.Exception -> Lcb
            android.content.Context r5 = com.scores365.App.m()     // Catch: java.lang.Exception -> Lcb
            r3.<init>(r5)     // Catch: java.lang.Exception -> Lcb
        L53:
            if (r9 == 0) goto L79
            r5 = r3
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch: java.lang.Exception -> Lcb
            r5.setText(r1)     // Catch: java.lang.Exception -> Lcb
            r1 = r3
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch: java.lang.Exception -> Lcb
            r5 = 1094713344(0x41400000, float:12.0)
            r6 = 1
            r1.setTextSize(r6, r5)     // Catch: java.lang.Exception -> Lcb
            r1 = r3
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch: java.lang.Exception -> Lcb
            int r5 = com.scores365.R.attr.f21565m1     // Catch: java.lang.Exception -> Lcb
            int r5 = li.p0.A(r5)     // Catch: java.lang.Exception -> Lcb
            r1.setTextColor(r5)     // Catch: java.lang.Exception -> Lcb
            r1 = r3
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch: java.lang.Exception -> Lcb
            r5 = 17
            r1.setGravity(r5)     // Catch: java.lang.Exception -> Lcb
            goto L88
        L79:
            r5 = r3
            android.widget.ImageView r5 = (android.widget.ImageView) r5     // Catch: java.lang.Exception -> Lcb
            li.u.x(r1, r5)     // Catch: java.lang.Exception -> Lcb
            r1 = 8
            int r1 = li.p0.s(r1)     // Catch: java.lang.Exception -> Lcb
            r3.setPadding(r1, r1, r1, r1)     // Catch: java.lang.Exception -> Lcb
        L88:
            android.widget.TableRow$LayoutParams r1 = new android.widget.TableRow$LayoutParams     // Catch: java.lang.Exception -> Lcb
            int r2 = li.p0.s(r2)     // Catch: java.lang.Exception -> Lcb
            r1.<init>(r4, r2)     // Catch: java.lang.Exception -> Lcb
            r3.setLayoutParams(r1)     // Catch: java.lang.Exception -> Lcb
            r0.addView(r3)     // Catch: java.lang.Exception -> Lcb
            goto L30
        L98:
            android.view.View r7 = new android.view.View     // Catch: java.lang.Exception -> Lcb
            android.content.Context r9 = com.scores365.App.m()     // Catch: java.lang.Exception -> Lcb
            r7.<init>(r9)     // Catch: java.lang.Exception -> Lcb
            android.widget.TableRow$LayoutParams r9 = new android.widget.TableRow$LayoutParams     // Catch: java.lang.Exception -> Lcb
            int r1 = li.p0.s(r2)     // Catch: java.lang.Exception -> Lcb
            r9.<init>(r4, r1)     // Catch: java.lang.Exception -> Lcb
            r0.addView(r7, r9)     // Catch: java.lang.Exception -> Lcb
        Lad:
            if (r10 == 0) goto Lc7
            r7 = 0
        Lb0:
            int r9 = r0.getChildCount()     // Catch: java.lang.Exception -> Lcb
            if (r7 >= r9) goto Lcf
            android.view.View r9 = r0.getChildAt(r7)     // Catch: java.lang.Exception -> Lcb
            r9.setOnClickListener(r8)     // Catch: java.lang.Exception -> Lcb
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> Lcb
            r9.setTag(r10)     // Catch: java.lang.Exception -> Lcb
            int r7 = r7 + 1
            goto Lb0
        Lc7:
            r0.setOnClickListener(r8)     // Catch: java.lang.Exception -> Lcb
            goto Lcf
        Lcb:
            r7 = move-exception
            li.x0.N1(r7)
        Lcf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.playerCard.SinglePlayerStatsPage.returnStatsHeaderTableRow(java.util.HashSet, android.view.View$OnClickListener, boolean, boolean):android.widget.TableRow");
    }

    public static boolean shouldOpenLiveStatForSportType(AthleteObj athleteObj) {
        Set i10;
        try {
            i10 = kotlin.collections.p0.i("1,2".split(","));
            return i10.contains(String.valueOf(athleteObj.getSportTypeId()));
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    private boolean shouldUseSmallerTextForStatsTable() {
        try {
            int sportTypeId = ((AthletesObj) getArguments().getSerializable(ATHLETES_TAG)).getAthleteById().get(Integer.valueOf(getArguments().getInt(ATHLETE_ID_TAG, -1))).getSportTypeId();
            if (sportTypeId != SportTypesEnum.HOCKEY.getValue() && sportTypeId != SportTypesEnum.AMERICAN_FOOTBALL.getValue()) {
                if (sportTypeId != SportTypesEnum.BASEBALL.getValue()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    private void updateActivityWithSelectedTab() {
        try {
            if (getActivity() instanceof SinglePlayerCardActivity) {
                ((SinglePlayerCardActivity) getActivity()).setSelectedStatsTab(this.currentTab);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private ArrayList<com.scores365.Design.PageObjects.b> updatePageAcorrdingToSelection() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            if (areThereStatsAndCareerStats()) {
                int i10 = this.currentTab;
                if (i10 == 1) {
                    arrayList = updateSeasonData();
                } else if (i10 == 2) {
                    arrayList = updateCareerData(getStats());
                }
            } else {
                arrayList = isOnlyCareerReturned() ? updateCareerData(getStats()) : updateSeasonData();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    private ArrayList<com.scores365.Design.PageObjects.b> updateSeasonData() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            AthletesObj athletesObj = (AthletesObj) getArguments().getSerializable(ATHLETES_TAG);
            int i10 = getArguments().getInt(ATHLETE_ID_TAG, -1);
            if (athletesObj != null && athletesObj.getAthleteById() != null && athletesObj.getAthleteById().size() > 0) {
                AthleteObj athleteObj = athletesObj.getAthleteById().get(Integer.valueOf(i10));
                AthleteStatisticsObj[] athleteStatisticsObjArr = athleteObj.athleteStatistics;
                if (athleteStatisticsObjArr != null && athleteStatisticsObjArr.length > 0) {
                    SinglePlayerStatsCompetitionSelectorItem singlePlayerStatsCompetitionSelectorItem = new SinglePlayerStatsCompetitionSelectorItem(athletesObj, i10);
                    singlePlayerStatsCompetitionSelectorItem.getData();
                    int selectedCompetitionId = getSelectedCompetitionId();
                    if (selectedCompetitionId > -1) {
                        singlePlayerStatsCompetitionSelectorItem.setClickedCompetition(selectedCompetitionId);
                    }
                    arrayList.add(singlePlayerStatsCompetitionSelectorItem);
                    int selectedCompetitionId2 = singlePlayerStatsCompetitionSelectorItem.getSelectedCompetitionId();
                    AthleteStatisticsObj athleteStatisticsObj = athleteObj.athleteStatistics[singlePlayerStatsCompetitionSelectorItem.getSelectedItemPosition()];
                    if (athleteStatisticsObj == null || athleteStatisticsObj.playerStatistics.length >= 5) {
                        arrayList.add(new SinglePlayerOverallStatsItem(athletesObj, selectedCompetitionId2, i10, athleteStatisticsObj));
                    } else {
                        arrayList.add(new PlayerCardProfileStatsItem(athletesObj.competitionsById.get(Integer.valueOf(selectedCompetitionId2)), athleteStatisticsObj, athleteObj.getSportTypeId(), athletesObj.getAthleteStatTypes(), athleteObj.getID(), false, null));
                    }
                }
                ArrayList<com.scores365.Design.PageObjects.b> lastMatchesItems = getLastMatchesItems(athletesObj, i10);
                if (lastMatchesItems != null && !lastMatchesItems.isEmpty()) {
                    arrayList.add(new r(x0.X0(athleteObj.getSportType().getValue()) ? p0.l0("BASKETBALL_GAME_LOG") : p0.l0("NEW_PLAYER_CARD_SOCCER_LAST_MATCHES_TITLE")));
                    arrayList.addAll(lastMatchesItems);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            AthletesObj athletesObj = (AthletesObj) getArguments().getSerializable(ATHLETES_TAG);
            final int i10 = getArguments().getInt(ATHLETE_ID_TAG, -1);
            com.scores365.PlayerCard.a careerStats = athletesObj.getAthleteById().get(Integer.valueOf(i10)).getCareerStats();
            athletesObj.getAthleteById().get(Integer.valueOf(i10)).setSeasonMaps(careerStats);
            LinkedHashMap<Integer, com.scores365.PlayerCard.b> hashFromListItems = getHashFromListItems(careerStats.f21373a);
            com.scores365.PlayerCard.d dVar = new com.scores365.PlayerCard.d(hashFromListItems, i10);
            this.careerSpinnerAdapter = dVar;
            Spinner spinner = this.spinnerTables;
            if (spinner != null) {
                spinner.setAdapter((SpinnerAdapter) dVar);
                if (hashFromListItems.values().size() > 1) {
                    Spinner spinner2 = this.spinnerTables;
                    if (spinner2 instanceof CustomSpinner) {
                        ((CustomSpinner) spinner2).setSpinnerEventsListener(this);
                    }
                    this.spinnerTables.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.scores365.ui.playerCard.SinglePlayerStatsPage.1
                        @Override // android.widget.AdapterView.OnItemSelectedListener
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j10) {
                            try {
                                SinglePlayerStatsPage.this.positionOfSeason = i11;
                                SinglePlayerStatsPage.this.careerSpinnerAdapter.d(i11);
                                if (SinglePlayerStatsPage.this.currentSpinnerPosition != i11) {
                                    SinglePlayerStatsPage.this.ShowMainPreloader();
                                    SinglePlayerStatsPage.this.handleSelectedPosition(i11);
                                    ee.k.n(App.m(), "athlete", "stats", "season", "click", true, "athlete_id", String.valueOf(i10), "season", ((com.scores365.PlayerCard.b) SinglePlayerStatsPage.this.careerSpinnerAdapter.getItem(i11)).e());
                                }
                                SinglePlayerStatsPage.this.currentSpinnerPosition = i11;
                            } catch (Exception e10) {
                                x0.N1(e10);
                            }
                        }

                        @Override // android.widget.AdapterView.OnItemSelectedListener
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                    this.spinnerTables.setOnTouchListener(new View.OnTouchListener() { // from class: com.scores365.ui.playerCard.SinglePlayerStatsPage.2
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return false;
                        }
                    });
                } else {
                    this.spinnerTables.setEnabled(false);
                }
            }
            return updatePageAcorrdingToSelection();
        } catch (Exception e10) {
            x0.N1(e10);
            return arrayList;
        }
    }

    public void changeTab(int i10) {
        try {
            if (this.currentTab != i10) {
                this.currentTab = i10;
                String str = "";
                if (i10 == 1) {
                    this.tvSeason.setSelected(true);
                    this.tvCareer.setSelected(false);
                    str = "season";
                } else if (i10 == 2) {
                    this.tvSeason.setSelected(false);
                    this.tvCareer.setSelected(true);
                    str = "career";
                }
                updateActivityWithSelectedTab();
                renderData(updatePageAcorrdingToSelection());
                ee.k.n(App.m(), "athlete", "stats", "tab-click", null, true, "athlete_id", String.valueOf(getArguments().getInt(ATHLETE_ID_TAG, -1)), "tab", str);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem.iScrollListener
    public int getCurrentLastMatchesScrollPosition() {
        return this.currentLastMatchScrollPosition;
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public int getLayoutResourceID() {
        return R.layout.f22646o6;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return null;
    }

    public ArrayList<TableRow> getPlayersSummaryRow(ArrayList<ScoreBoxSummaryObj> arrayList) {
        ArrayList<TableRow> arrayList2 = new ArrayList<>();
        try {
            boolean shouldUseSmallerTextForStatsTable = shouldUseSmallerTextForStatsTable();
            int i10 = shouldUseSmallerTextForStatsTable ? 2 : 4;
            Iterator<ScoreBoxSummaryObj> it = arrayList.iterator();
            while (it.hasNext()) {
                TableRow tableRow = new TableRow(App.m());
                TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = p0.s(1);
                tableRow.setLayoutParams(layoutParams);
                tableRow.setBackgroundColor(p0.A(R.attr.f21547g1));
                Iterator<ScoreBoxValueObj> it2 = it.next().getValueObjs().iterator();
                while (it2.hasNext()) {
                    ScoreBoxValueObj next = it2.next();
                    TextView textView = new TextView(App.m());
                    textView.setTypeface(o0.d(App.m()));
                    textView.setTextColor(p0.A(R.attr.U0));
                    textView.setGravity(17);
                    textView.setTextSize(1, shouldUseSmallerTextForStatsTable ? 10.0f : 13.0f);
                    textView.setText(next.getValue());
                    if (x0.l1()) {
                        textView.setTextDirection(4);
                    } else {
                        textView.setTextDirection(3);
                    }
                    textView.setPadding(i10, i10, i10, i10);
                    textView.setLayoutParams(new TableRow.LayoutParams(-2, p0.s(32) - p0.s(1)));
                    tableRow.addView(textView);
                }
                tableRow.setPadding(0, p0.s(1), 0, 0);
                arrayList2.add(tableRow);
            }
        } catch (Resources.NotFoundException e10) {
            x0.N1(e10);
        }
        return arrayList2;
    }

    public int getSelectedCompetitionId() {
        try {
            return getArguments().getInt(SELECTED_COMPETITION_TAG, -1);
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    @Override // com.scores365.ui.playerCard.iScrollToLegandInPage
    public void handleLegendClick(boolean z10, String str) {
        try {
            if (!z10) {
                Toast toast = this.lastLegendsToast;
                if (toast != null) {
                    toast.cancel();
                }
                Toast makeText = Toast.makeText(App.m(), str, 0);
                this.lastLegendsToast = makeText;
                makeText.show();
                return;
            }
            int size = getRvBaseAdapter().B().size() - 1;
            while (true) {
                if (size <= 0) {
                    size = -1;
                    break;
                } else if (getRvBaseAdapter().B().get(size) instanceof of.i) {
                    break;
                } else {
                    size++;
                }
            }
            if (size != -1) {
                this.rvItems.x1(size);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (view.getId() == this.tvSeason.getId()) {
                changeTab(1);
                this.spinnerContainer.setVisibility(8);
                this.spinnerTables.setVisibility(8);
            } else if (view.getId() == this.tvCareer.getId()) {
                changeTab(2);
                this.spinnerContainer.setVisibility(0);
                this.spinnerTables.setVisibility(0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem.iScrollListener
    public void onLastMatchHorizontalScroll(int i10, int i11) {
        try {
            if (this.currentLastMatchScrollPosition != i10) {
                this.currentLastMatchScrollPosition = i10;
                for (int i12 = 0; i12 < this.rvBaseAdapter.getItemCount(); i12++) {
                    if (i12 != i11) {
                        RecyclerView.e0 a02 = this.rvItems.a0(i12);
                        com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i12);
                        if (a02 instanceof LastMatchGameItem.iSyncScrolledViewHolder) {
                            ((LastMatchGameItem.iSyncScrolledViewHolder) a02).scrollStatContainer(i10);
                        } else if (A instanceof CustomHorizontalScrollView.Companion.iScrollListener) {
                            this.rvBaseAdapter.notifyItemChanged(i12);
                        }
                    } else {
                        RecyclerView.e0 a03 = this.rvItems.a0(i12);
                        if (a03 instanceof LastMatchGameBasketballItem.ViewHolder) {
                            ((LastMatchGameBasketballItem.ViewHolder) a03).updateShadowTranslation(i10);
                        }
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        int i11;
        super.onRecyclerViewItemClick(i10);
        try {
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            if (A instanceof SinglePlayerStatsCompetitionSelectorItem) {
                SinglePlayerStatsCompetitionSelectorItem singlePlayerStatsCompetitionSelectorItem = (SinglePlayerStatsCompetitionSelectorItem) A;
                int selectedCompetitionId = singlePlayerStatsCompetitionSelectorItem.getSelectedCompetitionId();
                int selectedItemPosition = singlePlayerStatsCompetitionSelectorItem.getSelectedItemPosition();
                while (i11 < this.rvBaseAdapter.getItemCount()) {
                    com.scores365.Design.PageObjects.b bVar = this.rvBaseAdapter.B().get(i11);
                    i11 = ((bVar instanceof SinglePlayerOverallStatsItem) || (bVar instanceof PlayerCardProfileStatsItem)) ? 0 : i11 + 1;
                    AthletesObj athletesObj = (AthletesObj) getArguments().getSerializable(ATHLETES_TAG);
                    AthleteObj athleteObj = athletesObj.getAthleteById().get(Integer.valueOf(getArguments().getInt(ATHLETE_ID_TAG, -1)));
                    if (bVar instanceof SinglePlayerOverallStatsItem) {
                        ((SinglePlayerOverallStatsItem) bVar).setCompetitionId(selectedCompetitionId);
                        ((SinglePlayerOverallStatsItem) bVar).updateStatisticData(athleteObj.athleteStatistics[selectedItemPosition]);
                    } else {
                        ((PlayerCardProfileStatsItem) bVar).updateData(athleteObj.athleteStatistics[selectedItemPosition], athleteObj.getSportTypeId(), athletesObj.getAthleteStatTypes());
                    }
                    this.rvBaseAdapter.notifyItemChanged(i11);
                    HashMap hashMap = new HashMap();
                    hashMap.put("athlete_id", Integer.valueOf(getArguments().getInt(ATHLETE_ID_TAG, -1)));
                    hashMap.put("competition_id", Integer.valueOf(selectedCompetitionId));
                    hashMap.put("order_id", Integer.valueOf(singlePlayerStatsCompetitionSelectorItem.clickedPosition));
                    ee.k.k(App.m(), "athlete", "stats", "competition", "click", hashMap);
                    return;
                }
            } else if (A instanceof LastMatchGameItem) {
                AthletesObj athletesObj2 = (AthletesObj) getArguments().getSerializable(ATHLETES_TAG);
                int i12 = getArguments().getInt(ATHLETE_ID_TAG, -1);
                AthleteObj athleteObj2 = athletesObj2.getAthleteById().get(Integer.valueOf(i12));
                GameObj gameObj = ((LastMatchGameItem) A).getGameStats().getGameObj();
                GameStats gameStats = ((LastMatchGameItem) A).getGameStats();
                ArrayList<AthleteStats> athleteStats = ((LastMatchGameItem) A).getGameStats().getAthleteStats();
                boolean z10 = (athleteStats == null || athleteStats.isEmpty()) ? false : true;
                CompetitionObj competitionObj = athletesObj2.competitionsById.get(Integer.valueOf(gameObj.getCompetitionID()));
                boolean z11 = getArguments().getBoolean(SinglePlayerCardActivity.IS_NATIONAL_CONTEXT, false);
                boolean isCoach = SinglePlayerProfilePage.isCoach(athleteObj2.getPlayerPositionType(), athleteObj2.getSportType());
                a.EnumC0251a enumC0251a = a.EnumC0251a.HOME;
                boolean z12 = !isCoach && z10 && gameStats.hasStats() && shouldOpenLiveStatForSportType(athleteObj2);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("athlete_id", Integer.valueOf(getArguments().getInt(ATHLETE_ID_TAG, -1)));
                hashMap2.put("section", "previous-matches");
                hashMap2.put("competition_id", Integer.valueOf(gameObj.getCompetitionID()));
                hashMap2.put("game_id", Integer.valueOf(gameObj.getID()));
                hashMap2.put("is_live_stats", Integer.valueOf(z12 ? 1 : 0));
                hashMap2.put("type_tab", Integer.valueOf(getArguments().getInt(HEADERS_CATEGORY_LAST_POSITION, 0)));
                ee.k.k(App.m(), "athlete", "stats", "game", "click", hashMap2);
                if (z12 && ((LastMatchGameItem) A).isHasPlayed()) {
                    zb.k W1 = zb.k.W1(new zb.l(gameObj.getID(), gameObj.getSportID(), z11, enumC0251a, i12, -1, gameObj.getCompetitionID(), athleteObj2.clubId, athleteObj2.clubName, "last-matches", gameObj.getStatusObj().valueForAnalytics(), true, new se.f(false, ""), false));
                    W1.d2(gameObj);
                    W1.c2(competitionObj);
                    W1.f2(true);
                    W1.show(getChildFragmentManager(), "LiveStatsPopupDialog");
                } else if ((getActivity() instanceof com.scores365.Design.Activities.c) && !((com.scores365.Design.Activities.c) getActivity()).isOpeningActivityLocked()) {
                    Intent v12 = GameCenterBaseActivity.v1(gameObj.getID(), gameObj.getCompetitionID(), bg.e.DETAILS, "player-card");
                    ((com.scores365.Design.Activities.c) getActivity()).lockUnLockActivityOpening();
                    ((com.scores365.Design.Activities.c) getActivity()).startActivityForResultWithLock(v12, 888);
                }
            } else {
                String str = "more";
                if (A.getObjectTypeNum() == u.SeeAllTableItem.ordinal()) {
                    int i13 = getArguments().getInt(ATHLETE_ID_TAG, -1);
                    AthleteObj athleteObj3 = ((AthletesObj) getArguments().getSerializable(ATHLETES_TAG)).getAthleteById().get(Integer.valueOf(i13));
                    startActivity(AthleteMatchesActivity.getActivityIntent(athleteObj3.getLastMatchesObj().getPaging().fullPage, i13, athleteObj3.getName(), athleteObj3, getSeeAllTitle(athleteObj3, true)));
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("athlete_id", Integer.valueOf(getArguments().getInt(ATHLETE_ID_TAG, -1)));
                    hashMap3.put("section", "more-games");
                    hashMap3.put("show", "more");
                    ee.k.m(App.m(), "athlete", "show-all", "click", null, true, hashMap3);
                } else if (A.getObjectTypeNum() == u.playerLastMatchExpandItem.ordinal()) {
                    PlayerLastMatchExpandItem playerLastMatchExpandItem = (PlayerLastMatchExpandItem) A;
                    boolean z13 = !playerLastMatchExpandItem.isExpanded();
                    playerLastMatchExpandItem.setExpanded(z13);
                    for (int i14 = i10 + 1; i14 < this.rvBaseAdapter.getItemCount(); i14++) {
                        com.scores365.Design.PageObjects.b A2 = this.rvBaseAdapter.A(i14);
                        if ((A2 instanceof LastMatchGameItem) && !((LastMatchGameItem) A2).isHasPlayed()) {
                            ((LastMatchGameItem) A2).setCollapsed(!z13);
                        }
                        this.rvBaseAdapter.notifyItemRangeChanged(i10, i14 - i10);
                    }
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("athlete_id", Integer.valueOf(getArguments().getInt(ATHLETE_ID_TAG, -1)));
                    hashMap4.put("section", "no-appearances");
                    if (!z13) {
                        str = "less";
                    }
                    hashMap4.put("show", str);
                    ee.k.m(App.m(), "athlete", "expand", "click", null, true, hashMap4);
                } else if (A instanceof SinglePlayerOverallStatsItem) {
                    SinglePlayerOverallStatsItem singlePlayerOverallStatsItem = (SinglePlayerOverallStatsItem) A;
                    if (singlePlayerOverallStatsItem.getClickedStatType() != null) {
                        int i15 = getArguments().getInt(ATHLETE_ID_TAG, -1);
                        AthletesObj athletesObj3 = (AthletesObj) getArguments().getSerializable(ATHLETES_TAG);
                        AthleteObj athleteObj4 = athletesObj3.athleteById.get(Integer.valueOf(i15));
                        int competitionId = singlePlayerOverallStatsItem.getCompetitionId();
                        startActivity(PlayerTopStatsDialogActivity.G(i15, competitionId, athletesObj3.competitionsById.get(Integer.valueOf(competitionId)).getName(), singlePlayerOverallStatsItem.getClickedStatType().f23580id, singlePlayerOverallStatsItem.getClickedStatType().name, SinglePlayerProfilePage.isCoach(athleteObj4.getPlayerPositionType(), athleteObj4.getSportType()), "stats"));
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("athlete_id", Integer.valueOf(i15));
                        hashMap5.put("competition_id", Integer.valueOf(competitionId));
                        hashMap5.put("screen", "stats");
                        hashMap5.put("category", Integer.valueOf(singlePlayerOverallStatsItem.getClickedStatType().f23580id));
                        ee.k.k(App.m(), "athlete", "stats", "details", "click", hashMap5);
                        singlePlayerOverallStatsItem.setClickedStatType(null);
                    }
                } else if (A instanceof y) {
                    int l10 = ((y) A).l();
                    int i16 = getArguments().getInt(HEADERS_CATEGORY_LAST_POSITION, 0);
                    int i17 = getArguments().getInt(ATHLETE_ID_TAG, -1);
                    AthletesObj athletesObj4 = (AthletesObj) getArguments().getSerializable(ATHLETES_TAG);
                    athletesObj4.athleteById.get(Integer.valueOf(i17)).getLastMatchesObj().getHeaderCategories().get(l10).getID();
                    if (i16 != l10) {
                        getArguments().putInt(HEADERS_CATEGORY_LAST_POSITION, l10);
                        this.rvBaseAdapter.B().removeAll(this.rvBaseAdapter.B().subList(i10, this.rvBaseAdapter.getItemCount()));
                        this.rvBaseAdapter.B().addAll(getLastMatchesItems(athletesObj4, i17));
                        this.rvBaseAdapter.I();
                        for (int i18 = i10; i18 < this.rvBaseAdapter.getItemCount(); i18++) {
                            onLastMatchHorizontalScroll(0, i18);
                        }
                        com.scores365.Design.Pages.c cVar = this.rvBaseAdapter;
                        cVar.notifyItemRangeChanged(i10, cVar.getItemCount());
                        HashMap hashMap6 = new HashMap();
                        hashMap6.put("athlete_id", Integer.valueOf(i17));
                        hashMap6.put("type_tab", Integer.valueOf(l10));
                        ee.k.m(App.m(), "athlete", "stats", "type", "tab-click", true, hashMap6);
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.CustomSpinner.OnSpinnerEventsListener
    public void onSpinnerClosed() {
        this.careerSpinnerAdapter.c(false);
        this.careerSpinnerAdapter.notifyDataSetChanged();
    }

    @Override // com.scores365.ui.CustomSpinner.OnSpinnerEventsListener
    public void onSpinnerOpened() {
        this.careerSpinnerAdapter.c(true);
        this.careerSpinnerAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void relateCustomViews(View view) {
        super.relateCustomViews(view);
        try {
            AthletesObj athletesObj = (AthletesObj) getArguments().getSerializable(ATHLETES_TAG);
            int i10 = getArguments().getInt(ATHLETE_ID_TAG, -1);
            if (athletesObj != null && athletesObj.getAthleteById().containsKey(Integer.valueOf(i10))) {
                AthleteObj athleteObj = athletesObj.getAthleteById().get(Integer.valueOf(i10));
                if (areThereStatsAndCareerStats()) {
                    handleTabs(view, athleteObj);
                    handleSpinner(view);
                } else if (isOnlyCareerReturned()) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.L1);
                    this.tabsContainer = constraintLayout;
                    constraintLayout.setVisibility(8);
                    handleSpinner(view);
                } else {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.L1);
                    this.tabsContainer = constraintLayout2;
                    constraintLayout2.setVisibility(8);
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.sq);
                    this.spinnerContainer = constraintLayout3;
                    constraintLayout3.setVisibility(8);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.q
    public <T extends Collection> void renderData(T t10) {
        super.renderData(t10);
        try {
            if (!(areThereStatsAndCareerStats() && this.currentTab == 2) && (areThereStatsAndCareerStats() || !isOnlyCareerReturned())) {
                this.spinnerContainer.setVisibility(8);
                this.spinnerTables.setVisibility(8);
                return;
            }
            this.spinnerContainer.setVisibility(0);
            this.spinnerTables.setVisibility(0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setSelectedCompetitionId(int i10) {
        try {
            getArguments().putInt(SELECTED_COMPETITION_TAG, i10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public ArrayList<com.scores365.Design.PageObjects.b> updateCareerData(com.scores365.PlayerCard.e eVar) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i10 = getArguments().getInt(ATHLETE_ID_TAG, -1);
            AthletesObj athletesObj = (AthletesObj) getArguments().getSerializable(ATHLETES_TAG);
            AthleteObj athleteObj = athletesObj.getAthleteById().get(Integer.valueOf(i10));
            boolean z10 = false;
            boolean z11 = getArguments().getBoolean(SinglePlayerCardActivity.IS_NATIONAL_CONTEXT, false);
            boolean z12 = athleteObj.getSportTypeId() != SportTypesEnum.SOCCER.getValue();
            boolean F2 = x0.F2(athleteObj.getSportType().getValue());
            double d10 = 0.55d;
            if (eVar.getCategories() != null) {
                Iterator<ScoreBoxCategotyObj> it = eVar.getCategories().iterator();
                ArrayList arrayList4 = arrayList3;
                int i11 = 0;
                while (it.hasNext()) {
                    ScoreBoxCategotyObj next = it.next();
                    int i12 = i10;
                    int i13 = i11;
                    ArrayList arrayList5 = arrayList4;
                    int i14 = i10;
                    AthletesObj athletesObj2 = athletesObj;
                    double d11 = d10;
                    LegendClickListener legendClickListener = new LegendClickListener(this, i12, z11, athleteObj.getSportTypeId(), athletesObj.getAthleteStatTypes());
                    ScoreBoxTablesObj tableByCategoryId = getTableByCategoryId(eVar, next.getID());
                    legendClickListener.addColumns(tableByCategoryId);
                    int size = (tableByCategoryId.getSummary() == null || tableByCategoryId.getSummary().size() <= 0 || !tableByCategoryId.isShouldShowSummary()) ? i13 : tableByCategoryId.getSummary().size();
                    arrayList2.addAll(getRows(tableByCategoryId, d11, z12));
                    arrayList5.addAll(getStatsRows(tableByCategoryId, legendClickListener));
                    arrayList.add(new r(next.getName()));
                    v vVar = new v(arrayList2, arrayList5, 0.55d, false, F2, size, null);
                    vVar.r(true);
                    arrayList.add(vVar);
                    if (!z10 && arrayList2.size() > 0) {
                        z10 = true;
                    }
                    arrayList2 = new ArrayList();
                    arrayList4 = new ArrayList();
                    i11 = size;
                    d10 = d11;
                    i10 = i14;
                    athletesObj = athletesObj2;
                }
            } else {
                LegendClickListener legendClickListener2 = new LegendClickListener(this, i10, z11, athleteObj.getSportTypeId(), athletesObj.getAthleteStatTypes());
                ScoreBoxTablesObj scoreBoxTablesObj = eVar.getTables().get(0);
                legendClickListener2.addColumns(scoreBoxTablesObj);
                int size2 = (scoreBoxTablesObj.getSummary() == null || scoreBoxTablesObj.getSummary().size() <= 0 || !scoreBoxTablesObj.isShouldShowSummary()) ? 0 : scoreBoxTablesObj.getSummary().size();
                ArrayList<ScoreBoxRowHelperObject> rows = getRows(scoreBoxTablesObj, 0.55d, z12);
                arrayList3.addAll(getStatsRows(scoreBoxTablesObj, legendClickListener2));
                v vVar2 = new v(rows, arrayList3, 0.55d, false, F2, size2, null);
                vVar2.r(true);
                arrayList.add(vVar2);
                z10 = rows.size() > 0;
            }
            if (!x0.F2(athleteObj.getSportType().getValue()) && z10) {
                arrayList.addAll(getLegendItems(eVar.a()));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    public void updateSelectedCompetitionIdOnUI() {
        for (int i10 = 0; i10 < this.rvBaseAdapter.getItemCount(); i10++) {
            try {
                com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
                if (A instanceof SinglePlayerOverallStatsItem) {
                    SinglePlayerOverallStatsItem singlePlayerOverallStatsItem = (SinglePlayerOverallStatsItem) A;
                    singlePlayerOverallStatsItem.setCompetitionId(getSelectedCompetitionId());
                    singlePlayerOverallStatsItem.updateStatisticData(((AthletesObj) getArguments().getSerializable(ATHLETES_TAG)).getAthleteById().get(Integer.valueOf(getArguments().getInt(ATHLETE_ID_TAG, -1))).athleteStatistics[0]);
                    this.rvBaseAdapter.notifyItemChanged(i10);
                } else if (A instanceof SinglePlayerStatsCompetitionSelectorItem) {
                    ((SinglePlayerStatsCompetitionSelectorItem) A).setClickedCompetition(getSelectedCompetitionId());
                    this.rvBaseAdapter.notifyItemChanged(i10);
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
    }
}
