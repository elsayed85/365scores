package com.scores365.api;

import android.net.Uri;
import android.util.Log;
import com.scores365.entitys.AdjustCampaignEntitiesObj;
import com.scores365.entitys.GsonManager;
/* compiled from: ApiAdjustCampaignSelections.kt */
/* loaded from: classes2.dex */
public final class y extends d {

    /* renamed from: a  reason: collision with root package name */
    private AdjustCampaignEntitiesObj f23254a;

    public final AdjustCampaignEntitiesObj a() {
        return this.f23254a;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "get?ad_group=" + Uri.encode(sf.b.X1().B2()) + "&campaign=" + Uri.encode(sf.b.X1().C2());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.api.d
    public String getURL() {
        return "https://campaign-selections.365scores.com";
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            Log.d("ahlanErevTov", "parseJSON: " + str);
            this.f23254a = (AdjustCampaignEntitiesObj) GsonManager.getGson().l(str, AdjustCampaignEntitiesObj.class);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
