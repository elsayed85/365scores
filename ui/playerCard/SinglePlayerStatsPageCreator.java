package com.scores365.ui.playerCard;

import com.scores365.entitys.AthletesObj;
import li.x0;
/* loaded from: classes2.dex */
public class SinglePlayerStatsPageCreator extends com.scores365.Design.Pages.b {
    private int athleteId;
    private AthletesObj athletesObj;
    private boolean isNational;
    private int selectedCompetitionId;
    private int statsTabSelected;

    public SinglePlayerStatsPageCreator(String str, String str2, sc.i iVar, boolean z10, String str3, AthletesObj athletesObj, int i10, int i11, boolean z11) {
        super(str, str2, iVar, z10, str3);
        this.athletesObj = athletesObj;
        this.athleteId = i10;
        this.statsTabSelected = i11;
        this.selectedCompetitionId = -1;
        this.isNational = z11;
    }

    @Override // com.scores365.Design.Pages.b
    public com.scores365.Design.Pages.a CreatePage() {
        return SinglePlayerStatsPage.newInstance(this.athletesObj, this.athleteId, this.statsTabSelected, this.selectedCompetitionId, this.isNational);
    }

    public void setSelectedCompetitionId(int i10) {
        this.selectedCompetitionId = i10;
    }

    public void setSelectedTab(int i10) {
        try {
            this.statsTabSelected = i10;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
