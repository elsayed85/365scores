package com.scores365.gameCenter.gameCenterItems;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.scores365.App;
import com.scores365.R;
import com.scores365.bets.model.BetLineOption;
import com.scores365.bets.model.BookmakerActionButton;
import com.scores365.bets.model.ExtraContext;
import com.scores365.entitys.GameObj;
import com.scores365.gameCenter.gameCenterItems.BetNowOddsView;
import com.scores365.ui.OddsView;
import java.util.ArrayList;
import li.o0;
import li.p0;
import li.x0;
import sh.a;
import xf.q;
/* loaded from: classes2.dex */
public class BetNowOddsView extends OddsView {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f23743a;

    public BetNowOddsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BetNowOddsView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    private void c() {
        try {
            this.tvBetNowTitleA.setVisibility(8);
            this.divider2.setVisibility(8);
            this.f23743a.setBackground(p0.K(R.attr.B0));
            if (this.betLine.lineOptions.length > 2) {
                this.odd1.setBackgroundColor(p0.A(R.attr.f21603z0));
                this.odd2.setBackgroundColor(p0.A(R.attr.A0));
                this.odd3.setBackgroundColor(p0.A(R.attr.f21603z0));
                if (!x0.n1()) {
                    this.f23743a.setPadding(p0.s(1), p0.s(1), p0.s(1), p0.s(1));
                }
                this.divider1.setVisibility(8);
            } else {
                if (x0.l1()) {
                    this.divider2.setVisibility(0);
                    this.divider1.setVisibility(8);
                } else {
                    this.divider1.setVisibility(0);
                }
                this.odd1.setBackground(null);
                this.odd2.setBackground(null);
                this.odd3.setBackground(null);
            }
            if (x0.n1()) {
                if (x0.l1()) {
                    this.divider2.setBackgroundColor(p0.B(R.color.f21622l));
                } else {
                    this.divider1.setBackgroundColor(p0.B(R.color.f21622l));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(int i10, int i11, boolean z10, String str, GameObj gameObj, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, View view) {
        try {
            String oddsViewOptionClickUrl = OddsView.getOddsViewOptionClickUrl(i10, i11, z10, this.betLine, this.bookMakerObj);
            a.C0569a c0569a = sh.a.f39207a;
            String g10 = c0569a.g();
            String p10 = c0569a.p(oddsViewOptionClickUrl, g10);
            OddsView.directExternalUrl(getContext(), p10);
            OddsView.sendClickAnalyticsEvent(str, gameObj, String.valueOf(this.betLine.lineOptions[i11].getOddsByUserChoice(z11)), AppEventsConstants.EVENT_PARAM_VALUE_YES, z10, z12, z13, z14, z15, this.betLine, this.eventParamsForAnalytics, false, this.bookMakerObj, p10, this.isWwwScope, this.wwwEntityId, g10);
            je.b.f32619a.i("", this.betLine.bookmakerId);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.OddsView
    protected void bindViews() {
        try {
            this.odd1 = findViewById(R.id.WB);
            this.odd2 = findViewById(R.id.XB);
            this.odd3 = findViewById(R.id.YB);
            this.textViewOdd1 = (TextView) this.odd1.findViewById(R.id.f22189nj);
            this.textViewOdd2 = (TextView) this.odd2.findViewById(R.id.f22189nj);
            this.textViewOdd3 = (TextView) this.odd3.findViewById(R.id.f22189nj);
            this.imageViewOdd1 = (ImageView) this.odd1.findViewById(R.id.f22167mj);
            this.imageViewOdd2 = (ImageView) this.odd2.findViewById(R.id.f22167mj);
            this.imageViewOdd3 = (ImageView) this.odd3.findViewById(R.id.f22167mj);
            this.tvMarketTypeOptionName1 = (TextView) this.odd1.findViewById(R.id.Xi);
            this.tvMarketTypeOptionName2 = (TextView) this.odd2.findViewById(R.id.Xi);
            this.tvMarketTypeOptionName3 = (TextView) this.odd3.findViewById(R.id.Xi);
            this.textViewOdd1yellow = (TextView) this.odd1.findViewById(R.id.f22255qj);
            this.textViewOdd2yellow = (TextView) this.odd2.findViewById(R.id.f22255qj);
            this.textViewOdd3yellow = (TextView) this.odd3.findViewById(R.id.f22255qj);
            this.f23743a = (LinearLayout) findViewById(R.id.f22230pg);
            this.tvBetNowTitleA = (TextView) findViewById(R.id.Tw);
            this.divider1 = findViewById(R.id.H4);
            this.divider2 = findViewById(R.id.I4);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.OddsView
    public void inflateLayout(LayoutInflater layoutInflater) {
        layoutInflater.inflate(R.layout.L4, this);
    }

    @Override // com.scores365.ui.OddsView
    public void setClickListenersAndTexts(final boolean z10, final int i10, final String str, final GameObj gameObj, final boolean z11, final boolean z12, final boolean z13, final boolean z14, final boolean z15, boolean z16) {
        BetLineOption[] betLineOptionArr;
        ExtraContext[] extraContextArr;
        ExtraContext extraContext;
        StringBuilder sb2;
        int i11;
        StringBuilder sb3;
        int i12;
        int i13;
        int termArrowId;
        boolean z17 = z15;
        try {
            replaceViewsForEnglishUS(gameObj.homeAwayTeamOrder, true);
            StringBuilder sb4 = new StringBuilder();
            int i14 = 0;
            int i15 = 0;
            while (true) {
                betLineOptionArr = this.betLine.lineOptions;
                if (i15 >= betLineOptionArr.length) {
                    break;
                }
                this.containerViews.get(i15).setVisibility(i14);
                if (z17) {
                    sb2 = sb4;
                    i11 = i15;
                } else {
                    final int i16 = i15;
                    sb2 = sb4;
                    i11 = i15;
                    ((LinearLayout) this.textViews.get(i15).getParent()).setOnClickListener(new View.OnClickListener() { // from class: ag.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BetNowOddsView.this.d(i10, i16, z10, str, gameObj, z15, z11, z12, z13, z14, view);
                        }
                    });
                }
                if ((this.isLiveOddsContext && OddsView.isLineSupportUnderOverTitlesInside(this.betLine.type)) || z16) {
                    this.textViewsMarketName.get(i11).setText(this.betLine.getBetLineType().lineTypeOptions.get(i11).name);
                    this.textViewsMarketName.get(i11).setTextColor(p0.A(R.attr.U0));
                    this.textViewsMarketName.get(i11).setTypeface(o0.c(App.m()));
                    sb3 = sb2;
                    i12 = 0;
                    sb3.setLength(0);
                    this.textViewsMarketName.get(i11).setVisibility(0);
                    i13 = 8;
                } else {
                    sb3 = sb2;
                    i12 = 0;
                    i13 = 8;
                    this.textViewsMarketName.get(i11).setVisibility(8);
                }
                this.textViews.get(i11).setText(this.betLine.lineOptions[i11].getOddsByUserChoice(z15));
                this.textViews.get(i11).setTextDirection(3);
                this.textViews.get(i11).setVisibility(i12);
                this.textViews.get(i11).setTextColor(p0.A(R.attr.U0));
                this.textViews.get(i11).setVisibility(i12);
                this.imageViews.get(i11).setVisibility(i13);
                if (!z15 && this.betLine.lineOptions[i11].doesHaveOldRate() && (termArrowId = this.betLine.lineOptions[i11].getTermArrowId()) != -1) {
                    this.imageViews.get(i11).setImageResource(termArrowId);
                    this.imageViews.get(i11).setVisibility(i12);
                }
                if (this.betLine.lineOptions[i11].lead != null) {
                    this.textViewsYellow.get(i11).setText(" (" + this.betLine.lineOptions[i11].lead + ")");
                    this.textViewsYellow.get(i11).setVisibility(i12);
                } else {
                    this.textViewsYellow.get(i11).setVisibility(i13);
                }
                i15 = i11 + 1;
                sb4 = sb3;
                z17 = z15;
                i14 = 0;
            }
            for (int length = betLineOptionArr.length; length < 3; length++) {
                this.containerViews.get(length).setVisibility(8);
            }
            if (sf.b.X1().s4() && x0.b1(this.bookMakerObj)) {
                BookmakerActionButton bookmakerActionButton = this.bookMakerObj.actionButton;
                this.tvBetNowTitleA.setOnClickListener(new q.g.a((bookmakerActionButton == null || (extraContextArr = bookmakerActionButton.extraContexts) == null || (extraContext = extraContextArr[0]) == null || extraContext.getUrl() == null) ? this.bookMakerObj.actionButton.getUrl() : this.bookMakerObj.actionButton.extraContexts[0].getUrl(), gameObj, this.betLine, false, false, false, "game-teaser", true, false, -1));
            }
            c();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.OddsView
    protected void setViewsParams() {
        try {
            this.textViewOdd1.setTypeface(o0.d(App.m()));
            this.textViewOdd2.setTypeface(o0.d(App.m()));
            this.textViewOdd3.setTypeface(o0.d(App.m()));
            this.textViewOdd1.setVisibility(8);
            this.textViewOdd2.setVisibility(8);
            this.textViewOdd3.setVisibility(8);
            ArrayList<View> arrayList = new ArrayList<>();
            this.containerViews = arrayList;
            arrayList.add(this.odd1);
            this.containerViews.add(this.odd2);
            this.containerViews.add(this.odd3);
            ArrayList<TextView> arrayList2 = new ArrayList<>();
            this.textViews = arrayList2;
            arrayList2.add(this.textViewOdd1);
            this.textViews.add(this.textViewOdd2);
            this.textViews.add(this.textViewOdd3);
            ArrayList<ImageView> arrayList3 = new ArrayList<>();
            this.imageViews = arrayList3;
            arrayList3.add(this.imageViewOdd1);
            this.imageViews.add(this.imageViewOdd2);
            this.imageViews.add(this.imageViewOdd3);
            ArrayList<TextView> arrayList4 = new ArrayList<>();
            this.textViewsMarketName = arrayList4;
            arrayList4.add(this.tvMarketTypeOptionName1);
            this.textViewsMarketName.add(this.tvMarketTypeOptionName2);
            this.textViewsMarketName.add(this.tvMarketTypeOptionName3);
            ArrayList<TextView> arrayList5 = new ArrayList<>();
            this.textViewsYellow = arrayList5;
            arrayList5.add(this.textViewOdd1yellow);
            this.textViewsYellow.add(this.textViewOdd2yellow);
            this.textViewsYellow.add(this.textViewOdd3yellow);
            this.tvBetNowTitleA.setText(p0.l0("ODDS_COMPARISON_BET_NOW"));
            this.divider1.setVisibility(0);
            this.divider2.setVisibility(0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
