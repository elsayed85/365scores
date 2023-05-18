package com.scores365.ui.playerCard;

import com.scores365.api.a1;
import com.scores365.entitys.GamesObj;
import com.scores365.services.b;
import li.x0;
/* loaded from: classes2.dex */
public class PlayerCardGameEngine extends com.scores365.services.b {
    private String nextGameBaseUrl = null;

    @Override // com.scores365.services.b
    protected GamesObj APICall() {
        b.c cVar;
        a1 a1Var = new a1(this.lastUpdateId, this.nextGameBaseUrl);
        try {
            a1Var.call();
            if (a1Var.error && (cVar = this.onChangeListener) != null) {
                cVar.onNetworkError();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return a1Var.a();
    }

    public void setNextGameBaseUrl(String str) {
        this.nextGameBaseUrl = str;
    }
}
