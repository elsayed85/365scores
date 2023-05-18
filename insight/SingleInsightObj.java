package com.scores365.insight;

import androidx.annotation.NonNull;
import com.scores365.bets.model.EOddsFormats;
import com.scores365.entitys.BaseObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.Params;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import li.p0;
import p9.c;
import sf.b;
/* loaded from: classes2.dex */
public class SingleInsightObj extends BaseObj {
    @c("AgentID")
    public int agentId;
    @c("CalculationDetailsUrl")
    private String calculationDetailsUrl;
    @c("Cause")
    public String cause;
    @c("CompetitorIds")
    public ArrayList<Integer> competitorIds;
    @c("CurrentRate")
    public InsightRateObj currentRate;
    @c("Delay")
    public int delay;
    @c("Dislikes")
    public int dislikes;
    @c("Game")
    public GameObj gameObj;
    @c("InnerInsights")
    public ArrayList<SingleInsightObj> innerInsight;
    @c("BetLineTypes")
    public ArrayList<InsightBetLineTypeObj> insightBetLineTypes;
    @c("BetLines")
    public ArrayList<InsightBetLineObj> insightBetLines;
    @c("Text")
    public String insightText;
    @c("InsightTypeID")
    public int insightTypeId;
    @c("TopTrend")
    public boolean isTopTrend;
    @c("Likes")
    public int likes;
    @c("Live")
    public boolean live;
    @c("Outcome")
    public int outcome = 0;
    @c("OutcomeText")
    public String outcomeText;
    @c("Params")
    public Params params;
    @c("Premium")
    public boolean premium;
    @c("ProviderID")
    public int providerId;
    @c("Rate")
    public InsightRateObj rate;
    @c("ReleventGames")
    public int releventGames;
    @c("TotalGames")
    public int totalGames;
    @c("TrendText")
    public String trendText;

    /* renamed from: com.scores365.insight.SingleInsightObj$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$scores365$bets$model$EOddsFormats;

        static {
            int[] iArr = new int[EOddsFormats.values().length];
            $SwitchMap$com$scores365$bets$model$EOddsFormats = iArr;
            try {
                iArr[EOddsFormats.DECIMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scores365$bets$model$EOddsFormats[EOddsFormats.FRACTIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scores365$bets$model$EOddsFormats[EOddsFormats.AMERICAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class InsightRateObj implements Serializable {
        @c("American")
        private String american;
        @c("Decimal")
        private double decimal;
        @c("Fractional")
        private String fractionalOdd;

        public String getOddsByUserChoice() {
            EOddsFormats A2 = b.X1().A2();
            if (this.decimal != -1.0d) {
                int i10 = AnonymousClass1.$SwitchMap$com$scores365$bets$model$EOddsFormats[A2.ordinal()];
                return i10 != 1 ? i10 != 2 ? i10 != 3 ? "" : this.american : this.fractionalOdd : new DecimalFormat("0.00").format(this.decimal);
            }
            return p0.l0("ODDS_NA");
        }
    }

    public InsightBetLineObj getBetLine() {
        ArrayList<InsightBetLineObj> arrayList = this.insightBetLines;
        if (arrayList != null) {
            return arrayList.get(0);
        }
        return null;
    }

    public InsightBetLineTypeObj getBetLineType() {
        ArrayList<InsightBetLineTypeObj> arrayList = this.insightBetLineTypes;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return this.insightBetLineTypes.get(0);
    }

    public String getCalculationDetailsUrl() {
        return this.calculationDetailsUrl;
    }

    @NonNull
    public String toString() {
        return "Insight{id=" + this.f23582id + ", name='" + this.name + "', games=" + this.releventGames + ", gameCount=" + this.totalGames + ", insightType=" + this.insightTypeId + ", insight='" + this.insightText + "', innerInsight=" + this.innerInsight + ", trend='" + this.trendText + "', outcomeInt=" + this.outcome + ", outcome='" + this.outcomeText + "', live=" + this.live + ", premium=" + this.premium + ", providerId=" + this.providerId + ", agent=" + this.agentId + ", competitors=" + this.competitorIds + ", lines=" + this.insightBetLines + ", lineTypes=" + this.insightBetLineTypes + ", game=" + this.gameObj + ", topTrend=" + this.isTopTrend + ", calcUrl='" + this.calculationDetailsUrl + "', params=" + this.params + ", cause='" + this.cause + "', delay=" + this.delay + '}';
    }
}
