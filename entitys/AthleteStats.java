package com.scores365.entitys;

import com.google.android.gms.ads.RequestConfiguration;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class AthleteStats implements Serializable {
    @p9.c(RequestConfiguration.MAX_AD_CONTENT_RATING_T)

    /* renamed from: t  reason: collision with root package name */
    private int f23576t = -1;
    @p9.c("V")

    /* renamed from: v  reason: collision with root package name */
    private String f23577v = "";
    @p9.c("Logo")
    private boolean logo = false;
    @p9.c("Badge")
    private boolean badge = false;
    @p9.c("ShowOnMainStatsCard")
    private boolean showOnMainStatsCard = false;
    @p9.c("BGColor")
    private String bgColor = "";

    public String getBgColor() {
        return this.bgColor;
    }

    public int getT() {
        return this.f23576t;
    }

    public String getV() {
        return this.f23577v;
    }

    public boolean isBadge() {
        return this.badge;
    }

    public boolean isLogo() {
        return this.logo;
    }

    public boolean isPlayerRanking() {
        return this.f23576t == 0;
    }

    public boolean isShowOnMainStatsCard() {
        return this.showOnMainStatsCard;
    }
}
