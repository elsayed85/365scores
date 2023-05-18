package com.scores365.bets.model;

import com.scores365.R;
import com.scores365.entitys.BaseObj;
import java.text.DecimalFormat;
import li.p0;
import li.x0;
import p9.c;
import sf.b;
/* loaded from: classes2.dex */
public class BetLineOption extends BaseObj {
    @c("American")
    private String american;
    @c("ExtraLinks")
    public LineOptionExtraLink[] extraLinks;
    @c("Fractional")
    private String fractionalOdd;
    @c("KickOffAmerican")
    private String kickOffAmerican;
    @c("KickOffFractional")
    private String kickOffFractional;
    @c("KickOffRate")
    private double kickOffRate;
    @c("Num")
    private int num;
    @c("Rate")
    private double rate;
    @c("URL")
    private String url;
    @c("OldRate")
    private double oldRate = -1.0d;
    @c("OldFractional")
    private String oldFractional = "";
    @c("OldAmerican")
    private String oldAmerican = "";
    private String urlProcessed = null;
    @c("Lead")
    public Float lead = null;
    @c("Won")
    public boolean won = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scores365.bets.model.BetLineOption$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum DecimalDigitPrecision {
        Zero(new DecimalFormat("0")),
        One(new DecimalFormat("0.0")),
        Two(new DecimalFormat("0.00"));
        
        private final DecimalFormat decimalFormat;

        DecimalDigitPrecision(DecimalFormat decimalFormat) {
            this.decimalFormat = decimalFormat;
        }

        public DecimalFormat getDecimalFormat() {
            return this.decimalFormat;
        }
    }

    private DecimalFormat getDecimalPrecision() {
        try {
            double d10 = this.rate;
            return (d10 < 0.0d || d10 >= 100.0d) ? (d10 < 100.0d || d10 >= 1000.0d) ? DecimalDigitPrecision.Zero.getDecimalFormat() : DecimalDigitPrecision.One.getDecimalFormat() : DecimalDigitPrecision.Two.getDecimalFormat();
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private String getPreGameOddsByUserChoice(EOddsFormats eOddsFormats) {
        if (this.kickOffRate > 0.0d) {
            int i10 = AnonymousClass1.$SwitchMap$com$scores365$bets$model$EOddsFormats[eOddsFormats.ordinal()];
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? "" : this.kickOffAmerican : this.kickOffFractional : new DecimalFormat("0.00").format(this.kickOffRate);
        }
        return p0.l0("ODDS_NA");
    }

    public boolean doesHaveOldRate() {
        double d10 = this.oldRate;
        return (d10 == -1.0d || d10 == 0.0d) ? false : true;
    }

    public LineOptionExtraLink getLineOptionExtraLinkByContext(String str) {
        try {
            LineOptionExtraLink[] lineOptionExtraLinkArr = this.extraLinks;
            if (lineOptionExtraLinkArr == null || lineOptionExtraLinkArr.length <= 0) {
                return null;
            }
            for (LineOptionExtraLink lineOptionExtraLink : lineOptionExtraLinkArr) {
                if (lineOptionExtraLink.context.equals(str)) {
                    return lineOptionExtraLink;
                }
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public int getNum() {
        return this.num;
    }

    public String getOddsByUserChoice() {
        return getOddsByUserChoice(false);
    }

    public String getOddsByUserChoice(boolean z10) {
        EOddsFormats A2 = b.X1().A2();
        if (z10) {
            return getPreGameOddsByUserChoice(A2);
        }
        if (this.rate >= 0.0d) {
            int i10 = AnonymousClass1.$SwitchMap$com$scores365$bets$model$EOddsFormats[A2.ordinal()];
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? "" : this.american : this.fractionalOdd : getDecimalPrecision().format(this.rate);
        }
        return p0.l0("ODDS_NA");
    }

    public String getOldOddsByUserChoice() {
        EOddsFormats A2 = b.X1().A2();
        if (this.oldRate > 0.0d) {
            int i10 = AnonymousClass1.$SwitchMap$com$scores365$bets$model$EOddsFormats[A2.ordinal()];
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? "" : this.oldAmerican : this.oldFractional : new DecimalFormat("0.00").format(this.oldRate);
        }
        return p0.l0("ODDS_NA");
    }

    public double getRate() {
        return this.rate;
    }

    public int getTermArrowId() {
        if (doesHaveOldRate()) {
            double d10 = this.rate;
            double d11 = this.oldRate;
            if (d10 > d11) {
                return R.drawable.L4;
            }
            if (d10 < d11) {
                return R.drawable.M4;
            }
        }
        return -1;
    }

    public int getTrendTermArrowIdForOutright() {
        if (doesHaveOldRate()) {
            double d10 = this.rate;
            double d11 = this.oldRate;
            if (d10 > d11) {
                return R.drawable.L4;
            }
            if (d10 < d11) {
                return R.drawable.N4;
            }
        }
        return -1;
    }

    public String getUrl() {
        if (this.urlProcessed == null) {
            this.urlProcessed = x0.W0(this.url);
        }
        x0.E1("oddsClickFea", "BetLineOption.getUrl urlProcessed: " + this.urlProcessed);
        return this.urlProcessed;
    }

    public boolean hasKickOffRate() {
        return this.kickOffRate > 0.0d;
    }

    public boolean rateNotChanged() {
        return doesHaveOldRate() && this.rate == this.oldRate;
    }
}
