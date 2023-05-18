package com.scores365.Pages;

import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.dashboard.singleEntity.SingleEntityDashboardActivity;
import com.scores365.entitys.ColumnObj;
import com.scores365.entitys.CompStageObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GroupObj;
import com.scores365.entitys.RowMetadataObj;
import com.scores365.entitys.SeasonObj;
import com.scores365.entitys.TableObj;
import com.scores365.entitys.TableRowObj;
import com.scores365.entitys.TableRowValueObj;
import com.scores365.ui.playerCard.CustomHorizontalScrollView;
import com.scores365.ui.playerCard.LastMatchGameItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import li.p0;
import li.x0;
/* compiled from: StandingsBase.java */
/* loaded from: classes2.dex */
public abstract class c0 extends com.scores365.Design.Pages.q implements LastMatchGameItem.iScrollListener {

    /* renamed from: l  reason: collision with root package name */
    protected String f21189l;

    /* renamed from: m  reason: collision with root package name */
    protected RelativeLayout f21190m;

    /* renamed from: q  reason: collision with root package name */
    public ArrayList<com.scores365.Design.PageObjects.b> f21194q;

    /* renamed from: r  reason: collision with root package name */
    public ArrayList<CompetitionObj> f21195r;

    /* renamed from: s  reason: collision with root package name */
    public LinkedHashSet<ColumnObj> f21196s;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f21191n = false;

    /* renamed from: o  reason: collision with root package name */
    protected boolean f21192o = false;

    /* renamed from: p  reason: collision with root package name */
    private int f21193p = 0;

    /* renamed from: t  reason: collision with root package name */
    private ArrayList<b> f21197t = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StandingsBase.java */
    /* loaded from: classes2.dex */
    public class a implements Comparator<com.scores365.Design.PageObjects.b> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.scores365.Design.PageObjects.b bVar, com.scores365.Design.PageObjects.b bVar2) {
            try {
                if ((bVar instanceof of.q) && (bVar2 instanceof of.q)) {
                    return ((of.q) bVar).f36253e.position - ((of.q) bVar2).f36253e.position;
                }
            } catch (Exception unused) {
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StandingsBase.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f21199a;

        /* renamed from: b  reason: collision with root package name */
        public int f21200b;

        public b(int i10, int i11) {
            this.f21199a = i10;
            this.f21200b = i11;
        }
    }

    private boolean A1(TableRowObj tableRowObj) {
        try {
            int i10 = getArguments().getInt("game_id_val", -1);
            int i11 = getArguments().getInt("home_team_id_val", -1);
            int i12 = getArguments().getInt("away_team_id_val", -1);
            if (i10 > 0) {
                if (tableRowObj.competitor.getID() != i12) {
                    if (tableRowObj.competitor.getID() != i11) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    private of.q B1(TableRowObj tableRowObj, CompetitionObj competitionObj, boolean z10, boolean z11) {
        try {
            String str = "scores";
            if (getActivity() instanceof SingleEntityDashboardActivity) {
                if (((SingleEntityDashboardActivity) getActivity()).getEntityType() == App.c.LEAGUE) {
                    str = "competition";
                } else if (((SingleEntityDashboardActivity) getActivity()).getEntityType() == App.c.TEAM) {
                    str = "competitor";
                }
            }
            return new of.q(F1(tableRowObj, competitionObj), tableRowObj, competitionObj, E1(tableRowObj, competitionObj), D1(tableRowObj, competitionObj), A1(tableRowObj), false, false, str, z11, this);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private int C1() {
        try {
            int i10 = getArguments().getInt("team_id_val", -1);
            if (i10 > 0) {
                Iterator<com.scores365.Design.PageObjects.b> it = this.f21194q.iterator();
                int i11 = 0;
                int i12 = 0;
                while (it.hasNext()) {
                    com.scores365.Design.PageObjects.b next = it.next();
                    if ((next instanceof of.q) && i10 == ((of.q) next).f36253e.competitor.getID()) {
                        break;
                    }
                    if (next instanceof of.j) {
                        i12 = i11;
                    }
                    i11++;
                }
                return i12;
            }
            return 0;
        } catch (Exception e10) {
            x0.N1(e10);
            return 0;
        }
    }

    private GameObj D1(TableRowObj tableRowObj, CompetitionObj competitionObj) {
        try {
            return competitionObj.tableObj.liveLightGames.get(Integer.valueOf(tableRowObj.liveGameId));
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private String E1(TableRowObj tableRowObj, CompetitionObj competitionObj) {
        try {
            return competitionObj.tableObj.rowMetadataList.containsKey(Integer.valueOf(tableRowObj.destination)) ? competitionObj.tableObj.rowMetadataList.get(Integer.valueOf(tableRowObj.destination)).color : "";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    private LinkedHashMap<String, Object> F1(TableRowObj tableRowObj, CompetitionObj competitionObj) {
        ArrayList<ColumnObj> tableColumns;
        boolean z10;
        String colValue;
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        try {
            tableColumns = competitionObj.tableObj.getTableColumns();
            z10 = false;
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (tableColumns != null && !tableColumns.isEmpty()) {
            Iterator<ColumnObj> it = tableColumns.iterator();
            while (it.hasNext()) {
                ColumnObj next = it.next();
                try {
                    int i10 = tableRowObj.originalGamesPlayed;
                    boolean z11 = i10 > 0 && tableRowObj.gameplayed > i10;
                    try {
                        colValue = tableRowObj.getColValue(next.getMemberName());
                        if (L1(colValue)) {
                            int intValue = Integer.valueOf(colValue).intValue();
                            int intValue2 = Integer.valueOf(tableRowObj.getColValue("original" + next.getMemberName())).intValue();
                            z11 = intValue != intValue2 && intValue2 > -1;
                        }
                    } catch (Exception e11) {
                        x0.N1(e11);
                    }
                    linkedHashMap.put(next.getMemberName(), new TableRowValueObj(z11, colValue, next.getOnlyExpanded(), z1(next, competitionObj.tableObj)));
                } catch (Exception unused) {
                }
            }
            return linkedHashMap;
        }
        int i11 = tableRowObj.originalGamesPlayed;
        linkedHashMap.put(p0.l0("TABLE_P"), new TableRowValueObj(i11 > 0 && tableRowObj.gameplayed > i11, Integer.valueOf(tableRowObj.gameplayed), true));
        if (tableRowObj.originalGamesPlayed > 0 && tableRowObj.points > tableRowObj.originalPoints) {
            z10 = true;
        }
        linkedHashMap.put(p0.l0("TABLE_PTS"), new TableRowValueObj(z10, Integer.valueOf(tableRowObj.points), true));
        return linkedHashMap;
    }

    private boolean K1(TableObj tableObj) {
        boolean z10 = false;
        try {
            Iterator<ColumnObj> it = tableObj.getTableColumns().iterator();
            while (it.hasNext()) {
                if (it.next().getMemberName().equals(of.q.f36247q)) {
                    z10 = true;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return z10;
    }

    public static boolean L1(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private boolean M1(CompetitionObj competitionObj) {
        try {
            if (competitionObj.GetSeasonByNum(competitionObj.CurrSeason).getStages() != null) {
                return competitionObj.GetSeasonByNum(competitionObj.CurrSeason).getStages().length > 0;
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    private void x1() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList;
        try {
            if (!this.f21192o || (arrayList = this.f21194q) == null) {
                return;
            }
            arrayList.clear();
            id.f fVar = new id.f(this.f21194q, null, this.f21196s);
            this.rvBaseAdapter = fVar;
            this.rvItems.setAdapter(fVar);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void G1(CompetitionObj competitionObj, boolean z10, int i10) {
        ArrayList arrayList;
        CompetitionObj competitionObj2 = competitionObj;
        try {
            this.f21196s = new LinkedHashSet<>();
            int i11 = 0;
            if (competitionObj2.tableObj.getTableColumns() == null) {
                this.f21196s.add(new ColumnObj("", p0.l0("TABLE_P"), false));
                this.f21196s.add(new ColumnObj("", p0.l0("TABLE_PTS"), false));
            } else {
                Iterator<ColumnObj> it = competitionObj2.tableObj.getTableColumns().iterator();
                while (it.hasNext()) {
                    ColumnObj next = it.next();
                    next.setItemWidth(z1(next, competitionObj2.tableObj));
                    this.f21196s.add(next);
                }
            }
            this.f21194q.add(new of.l(this.f21196s, z10, competitionObj.getName(), -1, false, this));
            if (!z10 || i10 <= -1) {
                arrayList = new ArrayList(competitionObj2.tableObj.competitionTable);
            } else {
                arrayList = new ArrayList();
                Iterator<TableRowObj> it2 = competitionObj2.tableObj.competitionTable.iterator();
                while (it2.hasNext()) {
                    TableRowObj next2 = it2.next();
                    if (next2.group == i10) {
                        arrayList.add(next2);
                    }
                }
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                TableRowObj tableRowObj = (TableRowObj) it3.next();
                LinkedHashMap<String, Object> F1 = F1(tableRowObj, competitionObj2);
                String E1 = E1(tableRowObj, competitionObj2);
                GameObj D1 = D1(tableRowObj, competitionObj2);
                boolean A1 = A1(tableRowObj);
                String str = "scores";
                if (getActivity() instanceof SingleEntityDashboardActivity) {
                    if (((SingleEntityDashboardActivity) getActivity()).getEntityType() == App.c.LEAGUE) {
                        str = "competition";
                    } else if (((SingleEntityDashboardActivity) getActivity()).getEntityType() == App.c.TEAM) {
                        str = "competitor";
                    }
                }
                this.f21194q.add(new of.q(F1, tableRowObj, competitionObj, E1, D1, A1, false, false, str, this.f21195r.get(i11).tableObj.isPointDeductedFromCompetitor(tableRowObj.competitor.getID()), this));
                competitionObj2 = competitionObj;
                i11 = 0;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void H1(CompetitionObj competitionObj) {
        try {
            if (competitionObj.tableObj.rowMetadataList.size() > 0) {
                HashSet hashSet = new HashSet();
                for (RowMetadataObj rowMetadataObj : competitionObj.tableObj.rowMetadataList.values()) {
                    if (!hashSet.contains(rowMetadataObj.destination)) {
                        this.f21194q.add(new of.i(rowMetadataObj.destination, rowMetadataObj.color, false));
                        hashSet.add(rowMetadataObj.destination);
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void I1(CompetitionObj competitionObj, int i10, boolean z10) {
        try {
            if (this.f21194q == null) {
                this.f21194q = new ArrayList<>();
            }
            if (!this.f21194q.isEmpty()) {
                this.f21194q.clear();
            }
            x1();
            J1(competitionObj, i10, z10);
            H1(competitionObj);
            int C1 = i10 == -1 ? C1() : 0;
            com.scores365.Design.Pages.c cVar = this.rvBaseAdapter;
            if (cVar == null) {
                id.f fVar = new id.f(this.f21194q, null, this.f21196s);
                this.rvBaseAdapter = fVar;
                this.rvItems.setAdapter(fVar);
                this.f21192o = true;
            } else {
                cVar.H(this.f21194q);
                this.rvBaseAdapter.notifyDataSetChanged();
            }
            if (C1 > 0) {
                RecyclerView.p pVar = this.rvLayoutMgr;
                if (pVar instanceof LinearLayoutManager) {
                    ((LinearLayoutManager) pVar).scrollToPositionWithOffset(C1, 10);
                }
            }
            HideMainPreloader();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void J1(CompetitionObj competitionObj, int i10, boolean z10) {
        CompStageObj compStageObj;
        SeasonObj seasonObj;
        try {
            if (!M1(competitionObj)) {
                G1(competitionObj, false, -1);
                return;
            }
            SeasonObj[] sessions = competitionObj.getSessions();
            int i11 = 0;
            while (true) {
                compStageObj = null;
                if (i11 >= sessions.length) {
                    seasonObj = null;
                    break;
                } else if (sessions[i11].getNum() == competitionObj.CurrSeason) {
                    seasonObj = sessions[i11];
                    break;
                } else {
                    i11++;
                }
            }
            CompStageObj[] stages = seasonObj.getStages();
            try {
                if (competitionObj.tableObj.stage > 0) {
                    int length = stages.length;
                    int i12 = 0;
                    int i13 = 0;
                    while (true) {
                        if (i12 >= length) {
                            break;
                        } else if (stages[i12].getNum() == competitionObj.tableObj.stage) {
                            compStageObj = stages[i13];
                            break;
                        } else {
                            i13++;
                            i12++;
                        }
                    }
                } else {
                    compStageObj = stages[0];
                }
            } catch (Exception e10) {
                x0.N1(e10);
                compStageObj = stages[0];
            }
            if (!compStageObj.getHasTable() || compStageObj.getGroups() == null) {
                G1(competitionObj, false, -1);
                return;
            }
            GroupObj[] groups = compStageObj.getGroups();
            for (int i14 = 0; i14 < groups.length; i14++) {
                if (groups[i14].getHasTable()) {
                    if (!z10 || i10 == -1) {
                        y1(groups[i14], competitionObj);
                    } else if (i14 + 1 == i10) {
                        y1(groups[i14], competitionObj);
                    }
                }
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    public void N1(ArrayList<CompetitionObj> arrayList) {
        int i10;
        try {
            ArrayList<CompetitionObj> arrayList2 = this.f21195r;
            if (arrayList2 != null && arrayList2.get(0) != null && this.f21195r.get(0).tableObj != null && this.f21195r.get(0).tableObj.competitionTable != null && !this.f21195r.get(0).tableObj.competitionTable.isEmpty()) {
                this.f21197t.clear();
                Iterator<com.scores365.Design.PageObjects.b> it = this.f21194q.iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    com.scores365.Design.PageObjects.b next = it.next();
                    if (next instanceof of.q) {
                        of.q qVar = (of.q) next;
                        Iterator<TableRowObj> it2 = arrayList.get(0).tableObj.competitionTable.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                TableRowObj next2 = it2.next();
                                if (qVar.f36255g == next2.competitor.getID()) {
                                    int i12 = i11 - 1;
                                    this.f21197t.add(new b(qVar.f36253e.position + i12, next2.position + i12));
                                    break;
                                }
                            }
                        }
                    } else {
                        i11++;
                    }
                }
                boolean K1 = K1(this.f21195r.get(0).tableObj);
                Iterator<TableRowObj> it3 = this.f21195r.get(0).tableObj.competitionTable.iterator();
                while (it3.hasNext()) {
                    TableRowObj next3 = it3.next();
                    Iterator<com.scores365.Design.PageObjects.b> it4 = this.f21194q.iterator();
                    int i13 = 0;
                    while (it4.hasNext()) {
                        com.scores365.Design.PageObjects.b next4 = it4.next();
                        if ((next4 instanceof of.q) && ((of.q) next4).f36255g == next3.competitor.getID()) {
                            this.f21194q.set(i13, B1(next3, this.f21195r.get(0), K1, this.f21195r.get(0).tableObj.isPointDeductedFromCompetitor(next3.competitor.getID())));
                        }
                        i13++;
                    }
                }
                Collections.sort(this.f21194q, new a());
                Iterator<b> it5 = this.f21197t.iterator();
                while (it5.hasNext()) {
                    b next5 = it5.next();
                    try {
                        if (x0.q1(this.rvItems, next5.f21199a) && x0.q1(this.rvItems, next5.f21200b)) {
                            int i14 = next5.f21199a;
                            int i15 = next5.f21200b;
                            if (i14 != i15) {
                                this.rvLayoutMgr.moveView(i14, i15);
                                this.rvBaseAdapter.notifyItemMoved(next5.f21199a, next5.f21200b);
                            }
                        } else if (!x0.q1(this.rvItems, next5.f21199a) && !x0.q1(this.rvItems, next5.f21200b) && (i10 = next5.f21199a) != next5.f21200b) {
                            this.rvBaseAdapter.notifyItemChanged(i10);
                        }
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
                return;
            }
            this.f21195r = arrayList;
            ArrayList<com.scores365.Design.PageObjects.b> arrayList3 = this.f21194q;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                Iterator<com.scores365.Design.PageObjects.b> it6 = this.f21194q.iterator();
                int i16 = 0;
                while (it6.hasNext()) {
                    if (it6.next() instanceof of.q) {
                        ((of.q) this.f21194q.get(i16)).f36253e = arrayList.get(0).tableObj.competitionTable.get(i16);
                        this.rvBaseAdapter.notifyItemChanged(i16);
                    }
                    i16++;
                }
                return;
            }
            renderData((ArrayList) LoadData());
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem.iScrollListener
    public int getCurrentLastMatchesScrollPosition() {
        return this.f21193p;
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return this.f21189l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public <T extends Collection> boolean isDataReady(T t10) {
        return true;
    }

    public void l(boolean z10) {
        RelativeLayout relativeLayout = this.f21190m;
        if (relativeLayout != null) {
            if (z10) {
                relativeLayout.setVisibility(0);
            } else {
                relativeLayout.setVisibility(8);
            }
        }
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem.iScrollListener
    public void onLastMatchHorizontalScroll(int i10, int i11) {
        try {
            if (this.f21193p != i10) {
                this.f21193p = i10;
                for (int i12 = 0; i12 < this.rvBaseAdapter.getItemCount(); i12++) {
                    if (i12 != i11) {
                        RecyclerView.e0 a02 = this.rvItems.a0(i12);
                        com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i12);
                        if (a02 instanceof LastMatchGameItem.iSyncScrolledViewHolder) {
                            ((LastMatchGameItem.iSyncScrolledViewHolder) a02).scrollStatContainer(i10);
                        } else if (A instanceof CustomHorizontalScrollView.Companion.iScrollListener) {
                            this.rvBaseAdapter.notifyItemChanged(i12);
                        }
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.q
    public <T extends Collection> void renderData(T t10) {
        try {
            id.f fVar = new id.f((ArrayList) t10, this.recylerItemClickListener, this.f21196s);
            this.rvBaseAdapter = fVar;
            this.rvItems.setAdapter(fVar);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void y1(GroupObj groupObj, CompetitionObj competitionObj) {
        int num = groupObj.getNum();
        this.f21194q.add(new of.j(groupObj.getName()));
        G1(competitionObj, true, num);
    }

    public int z1(ColumnObj columnObj, TableObj tableObj) {
        int i10 = -1;
        try {
            int length = columnObj.getDisplayName().length();
            Iterator<TableRowObj> it = tableObj.competitionTable.iterator();
            while (it.hasNext()) {
                length = Math.max(it.next().getColValue(columnObj.getMemberName()).length(), length);
            }
            i10 = p0.s((length * 8) + 4);
            return Math.max(p0.s(25), (int) (i10 * ((p0.O(getActivity()) > 1.0f ? 1 : (p0.O(getActivity()) == 1.0f ? 0 : -1)) > 0 ? 1.5d : 1.0d)));
        } catch (Exception e10) {
            x0.N1(e10);
            return i10;
        }
    }
}
