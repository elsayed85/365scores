package com.scores365.entitys.dashboardSections;

import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GamesObj;
import java.util.ArrayList;
import li.x0;
import p9.c;
import yb.a;
/* loaded from: classes2.dex */
public class ScoresSection extends AbstractSectionObject {
    @c("Data")
    private GamesObj Data;
    @c("GamesToday")
    private int GamesToday;
    @c("ShowCalendar")
    private boolean ShowCalendar;
    @c("InfoCards")
    private ArrayList<? extends a> info;
    @c("CompetitionsFilter")
    private ArrayList<CompetitionObj> relatedCompetitions;

    @Override // com.scores365.entitys.dashboardSections.AbstractSectionObject
    public GamesObj getData() {
        return this.Data;
    }

    public ArrayList<CompetitionObj> getFilteredCompetitions() {
        return this.relatedCompetitions;
    }

    public int getGamesToday() {
        return this.GamesToday;
    }

    public ArrayList<? extends a> getInfo() {
        return this.info;
    }

    public boolean isShowCalendar() {
        return this.ShowCalendar;
    }

    @Override // com.scores365.entitys.dashboardSections.AbstractSectionObject
    public void setAdditionalData() {
        super.setAdditionalData();
        try {
            if (getData() == null || getInfo() == null) {
                return;
            }
            getData().setInfoObject(getInfo());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
