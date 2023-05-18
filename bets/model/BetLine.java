package com.scores365.bets.model;

import com.scores365.App;
import com.scores365.entitys.BaseObj;
import com.scores365.gameCenter.a;
import j$.util.DesugarArrays;
import li.x0;
import p9.c;
/* loaded from: classes2.dex */
public class BetLine extends BaseObj {
    @c("BookPos")
    public int bookPos;
    @c("BMGID")
    public long bookmakerGameId;
    @c("BMID")
    public int bookmakerId;
    @c("EntID")
    public int entityId;
    @c("IsConcluded")
    public boolean isConcluded;
    @c("Link")
    private String lineLink;
    private String lineLinkProcessed = null;
    @c("Options")
    public BetLineOption[] lineOptions;
    @c("PV")
    public String optionAlias;
    @c("P")
    public String optionName;
    @c("Probabilities")
    a[] probabilities;
    @c("Sponsored")
    public boolean sponsored;
    @c("TrackingURL")
    private String trackingURL;
    @c("Type")
    public int type;

    public BetLineType getBetLineType() {
        try {
            return App.l().bets.getLineTypes().get(Integer.valueOf(this.type));
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public String getLineLink() {
        if (this.lineLinkProcessed == null) {
            this.lineLinkProcessed = x0.W0(this.lineLink);
        }
        x0.E1("oddsClickFea", "BetLine.getLineLink lineLinkProcessed: " + this.lineLinkProcessed);
        return this.lineLinkProcessed;
    }

    public String getMarketName() {
        try {
            return App.l().bets.getLineTypes().get(Integer.valueOf(this.type)).getName();
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public a getProbabilities() {
        return (a) DesugarArrays.stream(this.probabilities).iterator().next();
    }

    public String getTrackingURL() {
        String str = this.trackingURL;
        return str != null ? str : "";
    }
}
