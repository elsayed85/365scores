package com.scores365.ui.playerCard;

import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Design.PageObjects.a;
import com.scores365.entitys.AthleteStatisticsObj;
import com.scores365.entitys.AthletesObj;
import com.scores365.entitys.CompetitionObj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import lf.u;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class SinglePlayerStatsCompetitionSelectorItem extends com.scores365.Design.PageObjects.a {
    int athleteId;
    AthletesObj athletesObj;
    private int selectedItemPosition = 0;

    public SinglePlayerStatsCompetitionSelectorItem(AthletesObj athletesObj, int i10) {
        this.athletesObj = athletesObj;
        this.athleteId = i10;
    }

    @Override // com.scores365.Design.PageObjects.a, com.scores365.Design.Pages.q.e
    public void OnRecylerItemClick(int i10) {
        try {
            this.selectedItemPosition = i10;
            int i11 = 0;
            while (i11 < this.data.size()) {
                if (this.data.get(i11) instanceof SinglePlayerStatsCompetitionSelectorSubItem) {
                    ((SinglePlayerStatsCompetitionSelectorSubItem) this.data.get(i11)).setSelected(i11 == i10);
                }
                i11++;
            }
            WeakReference<a.C0230a> weakReference = this.holderRef;
            a.C0230a c0230a = weakReference != null ? weakReference.get() : null;
            if (c0230a != null) {
                c0230a.getAdapter().notifyDataSetChanged();
            }
            super.OnRecylerItemClick(i10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.PageObjects.a
    public ArrayList<com.scores365.Design.PageObjects.b> getData() {
        ArrayList<com.scores365.Design.PageObjects.b> data = super.getData();
        int i10 = 0;
        while (i10 < data.size()) {
            try {
                com.scores365.Design.PageObjects.b bVar = data.get(i10);
                if (bVar instanceof SinglePlayerStatsCompetitionSelectorSubItem) {
                    ((SinglePlayerStatsCompetitionSelectorSubItem) bVar).setSelected(i10 == this.selectedItemPosition);
                }
                i10++;
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
        return data;
    }

    @Override // com.scores365.Design.PageObjects.a
    protected int getItemHeight() {
        return p0.s(40);
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.playerStatsCompetitionSelectorItem.ordinal();
    }

    public int getSelectedCompetitionId() {
        try {
            int size = this.data.size();
            int i10 = this.selectedItemPosition;
            if (size > i10) {
                return ((SinglePlayerStatsCompetitionSelectorSubItem) this.data.get(i10)).getCompetitionObj().getID();
            }
            return -1;
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    public int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    @Override // com.scores365.Design.PageObjects.a
    protected ArrayList<com.scores365.Design.PageObjects.b> loadItems() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            AthleteStatisticsObj[] athleteStatisticsObjArr = this.athletesObj.getAthleteById().get(Integer.valueOf(this.athleteId)).athleteStatistics;
            if (athleteStatisticsObjArr != null && athleteStatisticsObjArr.length > 0) {
                for (AthleteStatisticsObj athleteStatisticsObj : athleteStatisticsObjArr) {
                    CompetitionObj competitionObj = this.athletesObj.competitionsById.get(Integer.valueOf(athleteStatisticsObj.competitionId));
                    if (competitionObj != null) {
                        arrayList.add(new SinglePlayerStatsCompetitionSelectorSubItem(competitionObj, athleteStatisticsObj));
                    }
                }
                ((SinglePlayerStatsCompetitionSelectorSubItem) arrayList.get(this.selectedItemPosition)).setSelected(true);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    @Override // com.scores365.Design.PageObjects.a, com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        super.onBindViewHolder(e0Var, i10);
        try {
            e0Var.itemView.setPadding(p0.s(4), e0Var.itemView.getPaddingTop(), p0.s(4), e0Var.itemView.getPaddingBottom());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setClickedCompetition(int i10) {
        try {
            if (this.data != null) {
                for (int i11 = 0; i11 < this.data.size(); i11++) {
                    com.scores365.Design.PageObjects.b bVar = this.data.get(i11);
                    if ((bVar instanceof SinglePlayerStatsCompetitionSelectorSubItem) && ((SinglePlayerStatsCompetitionSelectorSubItem) bVar).getCompetitionObj().getID() == i10) {
                        this.selectedItemPosition = i11;
                        return;
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
