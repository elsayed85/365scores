package com.scores365.entitys;

import com.google.android.gms.ads.RequestConfiguration;
import com.scores365.App;
import java.io.Serializable;
import li.x0;
/* loaded from: classes2.dex */
public class PlayerStatObj implements Serializable {
    private static final long serialVersionUID = 1501381864687845701L;
    @p9.c("BGColor")
    private String bgcolor;
    @p9.c("Color")
    private String color;
    @p9.c("CompetitionRelativeRank")
    private String ordinal;
    @p9.c(RequestConfiguration.MAX_AD_CONTENT_RATING_T)

    /* renamed from: t  reason: collision with root package name */
    private int f23595t;
    @p9.c("V")

    /* renamed from: v  reason: collision with root package name */
    private String f23596v;
    @p9.c("Title")
    private String title = "";
    @p9.c("IsSignificant")
    private boolean significant = false;
    @p9.c("Top")
    private boolean top = false;
    @p9.c("ShowOnMainStatsCard")
    private boolean showOnMainStatsCard = false;

    public String getBGColor() {
        return this.bgcolor;
    }

    public String getColor() {
        return this.color;
    }

    public String getOrdinal() {
        return this.ordinal;
    }

    public String getStatTypeShortName(int i10) {
        try {
            return App.l().getSportTypes().get(Integer.valueOf(i10)).athleteStatics.get(Integer.valueOf(this.f23595t)).getShortName();
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public int getT() {
        return this.f23595t;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean getTop() {
        return this.top;
    }

    public String getV() {
        return this.f23596v;
    }

    public boolean isShowOnMainStatsCard() {
        return this.showOnMainStatsCard;
    }

    public boolean isSignificant() {
        return this.significant;
    }
}
