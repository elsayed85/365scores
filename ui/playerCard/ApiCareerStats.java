package com.scores365.ui.playerCard;

import com.scores365.entitys.GsonManager;
import li.x0;
/* loaded from: classes2.dex */
public class ApiCareerStats extends com.scores365.api.d {
    private int athleteId;
    protected String resultData;
    com.scores365.PlayerCard.e resultObj;
    private String seasonKey;

    public ApiCareerStats(int i10, String str) {
        this.athleteId = i10;
        this.seasonKey = str;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("/Data/Entities/Athletes/Statistics/?");
            sb2.append("athleteID=");
            sb2.append(this.athleteId);
            sb2.append("&seasonkey=");
            sb2.append(this.seasonKey);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.resultObj = (com.scores365.PlayerCard.e) GsonManager.getGson().l(str, com.scores365.PlayerCard.e.class);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        this.resultData = str;
    }
}
