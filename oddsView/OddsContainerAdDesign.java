package com.scores365.oddsView;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.R;
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BetLineOption;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.bets.model.EOddsFormats;
import com.scores365.bets.model.LineTypeOption;
import com.scores365.entitys.GameObj;
import com.scores365.oddsView.SingleOddAdDesignView;
import com.scores365.ui.OddsView;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.x0;
import nb.v;
import sg.d;
/* compiled from: OddsContainerAdDesign.kt */
/* loaded from: classes2.dex */
public final class OddsContainerAdDesign extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    private final SingleOddAdDesignView f24110d;

    /* renamed from: e  reason: collision with root package name */
    private final SingleOddAdDesignView f24111e;

    /* renamed from: f  reason: collision with root package name */
    private final SingleOddAdDesignView f24112f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f24113g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OddsContainerAdDesign(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OddsContainerAdDesign(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.g(context, "context");
        View.inflate(context, R.layout.f22658p5, this);
        View findViewById = findViewById(R.id.Rp);
        m.f(findViewById, "findViewById(R.id.soadv_odds_view_0)");
        this.f24110d = (SingleOddAdDesignView) findViewById;
        View findViewById2 = findViewById(R.id.Sp);
        m.f(findViewById2, "findViewById(R.id.soadv_odds_view_1)");
        this.f24111e = (SingleOddAdDesignView) findViewById2;
        View findViewById3 = findViewById(R.id.Tp);
        m.f(findViewById3, "findViewById(R.id.soadv_odds_view_2)");
        this.f24112f = (SingleOddAdDesignView) findViewById3;
    }

    public /* synthetic */ OddsContainerAdDesign(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final BetLineOption f(BetLineOption[] betLineOptionArr) {
        for (BetLineOption betLineOption : betLineOptionArr) {
            if (betLineOption.getRate() > 0.0d) {
                return betLineOption;
            }
        }
        return null;
    }

    public static /* synthetic */ void p(OddsContainerAdDesign oddsContainerAdDesign, BetLine betLine, BookMakerObj bookMakerObj, boolean z10, int i10, int i11, int i12, boolean z11, String str, GameObj gameObj, boolean z12, boolean z13, int i13, Object obj) {
        int i14;
        int i15 = (i13 & 8) != 0 ? -16777216 : i10;
        int i16 = (i13 & 16) != 0 ? -1 : i11;
        if ((i13 & 32) != 0) {
            i14 = Color.parseColor(bookMakerObj != null ? bookMakerObj.generalTextColor : null);
        } else {
            i14 = i12;
        }
        oddsContainerAdDesign.i(betLine, bookMakerObj, z10, i15, i16, i14, (i13 & 64) != 0 ? false : z11, str, gameObj, z12, z13);
    }

    public final int d(BetLine betLine, boolean z10, int i10) {
        m.g(betLine, "betLine");
        if (!z10) {
            try {
                if (betLine.lineOptions[i10].doesHaveOldRate()) {
                    return betLine.lineOptions[i10].getTermArrowId();
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
        return -1;
    }

    public final SingleOddAdDesignView.a g(BetLine betLine) {
        m.g(betLine, "betLine");
        SingleOddAdDesignView.a aVar = SingleOddAdDesignView.a.None;
        try {
            return !h(betLine) ? SingleOddAdDesignView.a.RegularWithBackground : betLine.lineOptions.length == 2 ? SingleOddAdDesignView.a.Left : SingleOddAdDesignView.a.Below;
        } catch (Exception e10) {
            x0.N1(e10);
            return aVar;
        }
    }

    public final boolean h(BetLine betLine) {
        m.g(betLine, "betLine");
        boolean z10 = false;
        try {
            Iterator<LineTypeOption> it = betLine.getBetLineType().lineTypeOptions.iterator();
            while (it.hasNext()) {
                if (it.next().name.length() > 1) {
                    z10 = true;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return z10;
    }

    public final void i(BetLine betLine, BookMakerObj bookMakerObj, boolean z10, int i10, int i11, int i12, boolean z11, String analSource, GameObj gameObj, boolean z12, boolean z13) {
        d.a aVar;
        int i13;
        m.g(betLine, "betLine");
        m.g(analSource, "analSource");
        try {
            int length = betLine.lineOptions.length;
            int i14 = !z10 ? 0 : length - 1;
            int i15 = !z10 ? length - 1 : 0;
            d.a aVar2 = d.Companion;
            String e10 = aVar2.e(betLine, i14);
            String str = betLine.getBetLineType().lineTypeOptions.get(i14).name;
            SingleOddAdDesignView.a g10 = g(betLine);
            String oddsViewOptionClickUrl = OddsView.getOddsViewOptionClickUrl(-1, i14, true, betLine, bookMakerObj);
            int d10 = d(betLine, z11, i14);
            if (this.f24113g) {
                SingleOddAdDesignView singleOddAdDesignView = this.f24111e;
                BetLineOption[] betLineOptionArr = betLine.lineOptions;
                m.f(betLineOptionArr, "betLine.lineOptions");
                BetLineOption f10 = f(betLineOptionArr);
                singleOddAdDesignView.s(f10 != null ? f10.getOddsByUserChoice(z11) : null, EOddsFormats.DECIMAL, str, e10, oddsViewOptionClickUrl, d10, i10, i11, i12, g10);
                singleOddAdDesignView.q();
                singleOddAdDesignView.d(v.x(80));
                singleOddAdDesignView.r(analSource, gameObj, z12, z13, false, betLine, bookMakerObj);
                return;
            }
            BetLineOption betLineOption = betLine.lineOptions[i14];
            SingleOddAdDesignView singleOddAdDesignView2 = this.f24110d;
            String oddsByUserChoice = betLineOption.getOddsByUserChoice(z11);
            EOddsFormats eOddsFormats = EOddsFormats.DECIMAL;
            singleOddAdDesignView2.s(oddsByUserChoice, eOddsFormats, str, e10, oddsViewOptionClickUrl, d10, i10, i11, i12, g10);
            singleOddAdDesignView2.r(analSource, gameObj, z12, z13, false, betLine, bookMakerObj);
            if (length > 2) {
                BetLineOption betLineOption2 = betLine.lineOptions[1];
                aVar = aVar2;
                String e11 = aVar.e(betLine, 1);
                String str2 = betLine.getBetLineType().lineTypeOptions.get(1).name;
                String oddsViewOptionClickUrl2 = OddsView.getOddsViewOptionClickUrl(-1, 1, true, betLine, bookMakerObj);
                int d11 = d(betLine, z11, 1);
                SingleOddAdDesignView singleOddAdDesignView3 = this.f24111e;
                singleOddAdDesignView3.s(betLineOption2.getOddsByUserChoice(z11), eOddsFormats, str2, e11, oddsViewOptionClickUrl2, d11, i10, i11, i12, g10);
                i13 = -1;
                singleOddAdDesignView3.r(analSource, gameObj, z12, z13, false, betLine, bookMakerObj);
                singleOddAdDesignView3.setVisibility(0);
            } else {
                aVar = aVar2;
                i13 = -1;
                this.f24111e.setVisibility(8);
            }
            BetLineOption betLineOption3 = betLine.lineOptions[i15];
            String e12 = aVar.e(betLine, i15);
            String str3 = betLine.getBetLineType().lineTypeOptions.get(i15).name;
            String oddsViewOptionClickUrl3 = OddsView.getOddsViewOptionClickUrl(i13, i15, true, betLine, bookMakerObj);
            int d12 = d(betLine, z11, i15);
            SingleOddAdDesignView.a aVar3 = g10 == SingleOddAdDesignView.a.Left ? SingleOddAdDesignView.a.Right : g10;
            SingleOddAdDesignView singleOddAdDesignView4 = this.f24112f;
            singleOddAdDesignView4.s(betLineOption3.getOddsByUserChoice(z11), eOddsFormats, str3, e12, oddsViewOptionClickUrl3, d12, i10, i11, i12, aVar3);
            singleOddAdDesignView4.r(analSource, gameObj, z12, z13, false, betLine, bookMakerObj);
        } catch (Exception e13) {
            x0.N1(e13);
        }
    }

    public final void setOnlyCenterOddEnabled(boolean z10) {
        this.f24113g = z10;
    }
}
