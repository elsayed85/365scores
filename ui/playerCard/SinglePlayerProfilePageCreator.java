package com.scores365.ui.playerCard;

import com.scores365.entitys.AthleteObj;
import com.scores365.entitys.AthletesObj;
import com.scores365.entitys.GamesObj;
/* loaded from: classes2.dex */
public class SinglePlayerProfilePageCreator extends com.scores365.Design.Pages.b {
    private AthleteObj athleteObj;
    private AthletesObj athletesObj;
    private int competitionId;
    private GamesObj futureMatch;
    private boolean isNational;
    com.scores365.Design.Pages.a singlePlayerProfilePage;

    public SinglePlayerProfilePageCreator(String str, String str2, sc.i iVar, boolean z10, String str3, AthletesObj athletesObj, AthleteObj athleteObj, GamesObj gamesObj, boolean z11, int i10) {
        super(str, str2, iVar, z10, str3);
        this.singlePlayerProfilePage = null;
        this.athletesObj = athletesObj;
        this.athleteObj = athleteObj;
        this.isNational = z11;
        this.futureMatch = gamesObj;
        this.competitionId = i10;
    }

    @Override // com.scores365.Design.Pages.b
    public com.scores365.Design.Pages.a CreatePage() {
        SinglePlayerProfilePage newInstance = SinglePlayerProfilePage.newInstance(this.athletesObj, this.athleteObj, this.futureMatch, this.isNational, this.competitionId);
        this.singlePlayerProfilePage = newInstance;
        return newInstance;
    }

    public void setFutureMatch(GamesObj gamesObj) {
        this.futureMatch = gamesObj;
    }
}
