package com.scores365.removeAds;

import com.google.gson.s;
import com.scores365.entitys.GsonManager;
import java.util.Date;
import li.x0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FriendsInvitedObj {
    @p9.c("CurrRoundRefferedCount")
    public int currRoundRefferedCount;
    @p9.c("DaysRemained")
    public int daysRemained;
    @p9.c("EligibleToBenefit")
    public boolean eligibleToBenefit;
    @p9.c("ExpirationDate")
    public Date expirationDate;
    @p9.c("TotalRefferedCount")
    public int totalRefferedCount;
    @p9.c("UsersNeededToRemoveAds")
    public int usersNeededToRemoveAds;

    public static FriendsInvitedObj parseObj(JSONObject jSONObject) {
        try {
            return (FriendsInvitedObj) GsonManager.getGson().l(jSONObject.toString(), FriendsInvitedObj.class);
        } catch (s e10) {
            x0.N1(e10);
            return null;
        }
    }
}
