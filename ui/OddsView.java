package com.scores365.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.scores365.App;
import com.scores365.R;
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.bets.model.BookmakerActionButton;
import com.scores365.entitys.GameObj;
import com.scores365.gameCenter.n0;
import com.scores365.insight.SingleInsightObj;
import ee.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import li.o0;
import li.p0;
import li.x0;
import sf.b;
import sh.a;
import xf.q;
/* loaded from: classes2.dex */
public class OddsView extends LinearLayout {
    public static Boolean betNowPositionAbTesting;
    private static Boolean shouldShowBetNowBtn;
    private static HashSet<Integer> underOverSupportedLines;
    protected BetLine betLine;
    public View betNowBackgroundColorView;
    public RelativeLayout bookMakerLinearLayoutA;
    protected BookMakerObj bookMakerObj;
    public RelativeLayout bookMakerRelativeLayoutB;
    protected LinearLayout.LayoutParams bookmakerLayoutParams;
    protected ConstraintLayout clBetNowBtnA;
    protected ConstraintLayout clBetNowBtnB;
    protected ArrayList<View> containerViews;
    protected View divider1;
    protected View divider2;
    protected HashMap<String, Object> eventParamsForAnalytics;
    protected ImageView imageViewBookMaker;
    protected ImageView imageViewBookMakerA;
    protected ImageView imageViewOdd1;
    protected ImageView imageViewOdd2;
    protected ImageView imageViewOdd3;
    protected ArrayList<ImageView> imageViews;
    protected boolean isBookmakerImageLoadingOrLoaded;
    protected boolean isGameCenterScope;
    protected boolean isLiveOddsContext;
    protected boolean isPositionsSwapped;
    protected boolean isScoresScope;
    protected boolean isWwwScope;
    public ImageView ivBookmakerImage;
    protected LinearLayout llInsightOdd;
    protected View odd1;
    protected View odd2;
    protected View odd3;
    protected RelativeLayout rlBetNowBtnB;
    protected TextView textViewBookMakerA;
    protected TextView textViewOdd1;
    protected TextView textViewOdd1yellow;
    protected TextView textViewOdd2;
    protected TextView textViewOdd2yellow;
    protected TextView textViewOdd3;
    protected TextView textViewOdd3yellow;
    protected ArrayList<TextView> textViews;
    protected ArrayList<TextView> textViewsMarketName;
    protected ArrayList<TextView> textViewsYellow;
    protected TextView title1;
    protected TextView title2;
    protected TextView title3;
    protected LinearLayout titleContainer;
    protected ArrayList<TextView> titleViews;
    protected TextView tvBetNowTitleA;
    public TextView tvBetNowTitleB;
    protected TextView tvMarketTypeOptionName1;
    protected TextView tvMarketTypeOptionName2;
    protected TextView tvMarketTypeOptionName3;
    protected int wwwEntityId;

    public OddsView(Context context) {
        super(context);
        this.eventParamsForAnalytics = null;
        this.isBookmakerImageLoadingOrLoaded = false;
        this.isGameCenterScope = false;
        this.isWwwScope = false;
        this.wwwEntityId = -1;
        this.isLiveOddsContext = false;
        this.isPositionsSwapped = false;
        this.isScoresScope = false;
        init();
    }

    public OddsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eventParamsForAnalytics = null;
        this.isBookmakerImageLoadingOrLoaded = false;
        this.isGameCenterScope = false;
        this.isWwwScope = false;
        this.wwwEntityId = -1;
        this.isLiveOddsContext = false;
        this.isPositionsSwapped = false;
        this.isScoresScope = false;
        init();
    }

    public OddsView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.eventParamsForAnalytics = null;
        this.isBookmakerImageLoadingOrLoaded = false;
        this.isGameCenterScope = false;
        this.isWwwScope = false;
        this.wwwEntityId = -1;
        this.isLiveOddsContext = false;
        this.isPositionsSwapped = false;
        this.isScoresScope = false;
        init();
    }

    public static void directExternalUrl(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        x0.E1("oddsClickFea", "directExternalUrl. url: " + str);
    }

    public static String getBetNowBtnDesignForAnalytics() {
        return shouldShowBetNowBtn() ? "bet-now" : "odds-by";
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getOddsViewOptionClickUrl(int r4, int r5, boolean r6, com.scores365.bets.model.BetLine r7, com.scores365.bets.model.BookMakerObj r8) {
        /*
            r0 = 0
            boolean r1 = xf.q.g.M()     // Catch: java.lang.Exception -> Lc2
            r2 = -1
            java.lang.String r3 = "PredictionsBeforeVote"
            if (r1 == 0) goto L2c
            if (r4 != r2) goto L21
            com.scores365.bets.model.BetLineOption[] r1 = r7.lineOptions     // Catch: java.lang.Exception -> Lc2
            r1 = r1[r5]     // Catch: java.lang.Exception -> Lc2
            com.scores365.bets.model.LineOptionExtraLink r1 = r1.getLineOptionExtraLinkByContext(r3)     // Catch: java.lang.Exception -> Lc2
            if (r1 == 0) goto L21
            com.scores365.bets.model.BetLineOption[] r1 = r7.lineOptions     // Catch: java.lang.Exception -> Lc2
            r1 = r1[r5]     // Catch: java.lang.Exception -> Lc2
            com.scores365.bets.model.LineOptionExtraLink r1 = r1.getLineOptionExtraLinkByContext(r3)     // Catch: java.lang.Exception -> Lc2
            java.lang.String r1 = r1.link     // Catch: java.lang.Exception -> Lc2
            goto L2d
        L21:
            if (r4 == r2) goto L2c
            com.scores365.bets.model.BetLineOption[] r1 = r7.lineOptions     // Catch: java.lang.Exception -> Lc2
            r1 = r1[r5]     // Catch: java.lang.Exception -> Lc2
            java.lang.String r1 = r1.getUrl()     // Catch: java.lang.Exception -> Lc2
            goto L2d
        L2c:
            r1 = r0
        L2d:
            if (r1 == 0) goto L32
            r0 = r1
            goto Lc6
        L32:
            if (r6 == 0) goto L51
            boolean r6 = xf.q.g.M()     // Catch: java.lang.Exception -> Lc2
            if (r6 == 0) goto L51
            if (r4 != r2) goto L51
            com.scores365.bets.model.BetLineOption[] r4 = r7.lineOptions     // Catch: java.lang.Exception -> Lc2
            r4 = r4[r5]     // Catch: java.lang.Exception -> Lc2
            com.scores365.bets.model.LineOptionExtraLink r4 = r4.getLineOptionExtraLinkByContext(r3)     // Catch: java.lang.Exception -> Lc2
            if (r4 == 0) goto L51
            com.scores365.bets.model.BetLineOption[] r4 = r7.lineOptions     // Catch: java.lang.Exception -> Lc2
            r4 = r4[r5]     // Catch: java.lang.Exception -> Lc2
            com.scores365.bets.model.LineOptionExtraLink r4 = r4.getLineOptionExtraLinkByContext(r3)     // Catch: java.lang.Exception -> Lc2
            java.lang.String r4 = r4.link     // Catch: java.lang.Exception -> Lc2
            goto L8f
        L51:
            com.scores365.bets.model.BetLineOption[] r4 = r7.lineOptions     // Catch: java.lang.Exception -> Lc2
            r4 = r4[r5]     // Catch: java.lang.Exception -> Lc2
            java.lang.String r4 = r4.getUrl()     // Catch: java.lang.Exception -> Lc2
            java.lang.String r6 = ""
            if (r4 == 0) goto L74
            com.scores365.bets.model.BetLineOption[] r4 = r7.lineOptions     // Catch: java.lang.Exception -> Lc2
            r4 = r4[r5]     // Catch: java.lang.Exception -> Lc2
            java.lang.String r4 = r4.getUrl()     // Catch: java.lang.Exception -> Lc2
            boolean r4 = r4.equals(r6)     // Catch: java.lang.Exception -> Lc2
            if (r4 != 0) goto L74
            com.scores365.bets.model.BetLineOption[] r4 = r7.lineOptions     // Catch: java.lang.Exception -> Lc2
            r4 = r4[r5]     // Catch: java.lang.Exception -> Lc2
            java.lang.String r4 = r4.getUrl()     // Catch: java.lang.Exception -> Lc2
            goto L8f
        L74:
            java.lang.String r4 = r7.getLineLink()     // Catch: java.lang.Exception -> Lc2
            if (r4 == 0) goto L89
            java.lang.String r4 = r7.getLineLink()     // Catch: java.lang.Exception -> Lc2
            boolean r4 = r4.equals(r6)     // Catch: java.lang.Exception -> Lc2
            if (r4 != 0) goto L89
            java.lang.String r4 = r7.getLineLink()     // Catch: java.lang.Exception -> Lc2
            goto L8f
        L89:
            if (r8 == 0) goto L91
            java.lang.String r4 = r8.getUrl()     // Catch: java.lang.Exception -> Lc2
        L8f:
            r0 = r4
            goto Lc6
        L91:
            com.scores365.entitys.InitObj r4 = com.scores365.App.l()     // Catch: java.lang.Exception -> Lc2
            com.scores365.bets.model.BetsObj r4 = r4.bets     // Catch: java.lang.Exception -> Lc2
            java.util.Hashtable r4 = r4.getBookmakers()     // Catch: java.lang.Exception -> Lc2
            int r5 = r7.bookmakerId     // Catch: java.lang.Exception -> Lc2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> Lc2
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Exception -> Lc2
            if (r4 == 0) goto Lc6
            com.scores365.entitys.InitObj r4 = com.scores365.App.l()     // Catch: java.lang.Exception -> Lc2
            com.scores365.bets.model.BetsObj r4 = r4.bets     // Catch: java.lang.Exception -> Lc2
            java.util.Hashtable r4 = r4.getBookmakers()     // Catch: java.lang.Exception -> Lc2
            int r5 = r7.bookmakerId     // Catch: java.lang.Exception -> Lc2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> Lc2
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Exception -> Lc2
            com.scores365.bets.model.BookMakerObj r4 = (com.scores365.bets.model.BookMakerObj) r4     // Catch: java.lang.Exception -> Lc2
            java.lang.String r4 = r4.getUrl()     // Catch: java.lang.Exception -> Lc2
            goto L8f
        Lc2:
            r4 = move-exception
            li.x0.N1(r4)
        Lc6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.OddsView.getOddsViewOptionClickUrl(int, int, boolean, com.scores365.bets.model.BetLine, com.scores365.bets.model.BookMakerObj):java.lang.String");
    }

    private void handleNoActionButtonUI(View.OnClickListener onClickListener) {
        try {
            this.tvBetNowTitleB.setText(x0.H(this.bookMakerObj));
            ImageView imageView = (ImageView) this.clBetNowBtnA.findViewById(R.id.Da);
            if (this.clBetNowBtnA == null || this.bookMakerObj.getColor() == null || this.bookMakerObj.getColor().isEmpty() || shouldShowBetNowBtn()) {
                this.tvBetNowTitleB.setText(this.bookMakerObj.actionButton.text);
                this.ivBookmakerImage.setVisibility(8);
                imageView.setVisibility(0);
                if (this.isGameCenterScope) {
                    this.llInsightOdd.getLayoutParams().height = p0.s(30);
                }
            } else {
                this.clBetNowBtnA.setBackgroundColor(Color.parseColor(this.bookMakerObj.getColor()));
                this.tvBetNowTitleB.setTypeface(null, 2);
                if (this.isGameCenterScope) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                }
            }
            this.bookMakerLinearLayoutA.setVisibility(8);
            this.bookMakerRelativeLayoutB.setVisibility(8);
            this.clBetNowBtnA.setOnClickListener(null);
            this.rlBetNowBtnB.setOnClickListener(null);
            this.clBetNowBtnA.setVisibility(0);
            this.rlBetNowBtnB.setVisibility(8);
            this.tvBetNowTitleA.setVisibility(8);
            imageView.setVisibility(0);
            li.u.x(nb.o.f(this.betLine.bookmakerId, this.bookMakerObj.getImgVer()), imageView);
            imageView.setOnClickListener(onClickListener);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (this.isGameCenterScope) {
            invalidate();
        }
    }

    private void init() {
        try {
            inflateLayout((LayoutInflater) getContext().getSystemService("layout_inflater"));
            initViews();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isLineSupportUnderOverTitlesInside(int i10) {
        try {
            if (underOverSupportedLines == null) {
                underOverSupportedLines = new HashSet<>();
                for (String str : p0.l0("UNDER_OVER_SUPPORTED_LINES").split(",")) {
                    underOverSupportedLines.add(Integer.valueOf(str));
                }
            }
            return underOverSupportedLines.contains(Integer.valueOf(i10));
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClickListenersAndTexts$0(boolean z10, int i10, String str, GameObj gameObj, boolean z11, boolean z12, boolean z13, boolean z14, View view) {
        BookmakerActionButton bookmakerActionButton;
        String oddsOptionClickLink;
        if (z10) {
            try {
                if (q.g.M() && (bookmakerActionButton = this.bookMakerObj.actionButton) != null) {
                    oddsOptionClickLink = bookmakerActionButton.getOddsOptionClickLink(i10 != -1);
                    a.C0569a c0569a = sh.a.f39207a;
                    String g10 = c0569a.g();
                    String p10 = c0569a.p(oddsOptionClickLink, g10);
                    directExternalUrl(getContext(), p10);
                    sendClickAnalyticsEvent(str, gameObj, "", "2", z10, z11, z12, z13, z14, this.betLine, this.eventParamsForAnalytics, false, this.bookMakerObj, p10, this.isWwwScope, this.wwwEntityId, g10);
                    je.b.f32619a.i("", this.betLine.bookmakerId);
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        BookMakerObj bookMakerObj = this.bookMakerObj;
        oddsOptionClickLink = (bookMakerObj == null || bookMakerObj.getUrl() == null || this.bookMakerObj.getUrl().isEmpty()) ? App.l().bets.getBookmakers().get(Integer.valueOf(this.betLine.bookmakerId)) != null ? App.l().bets.getBookmakers().get(Integer.valueOf(this.betLine.bookmakerId)).getUrl() : "" : this.bookMakerObj.getUrl();
        a.C0569a c0569a2 = sh.a.f39207a;
        String g102 = c0569a2.g();
        String p102 = c0569a2.p(oddsOptionClickLink, g102);
        directExternalUrl(getContext(), p102);
        sendClickAnalyticsEvent(str, gameObj, "", "2", z10, z11, z12, z13, z14, this.betLine, this.eventParamsForAnalytics, false, this.bookMakerObj, p102, this.isWwwScope, this.wwwEntityId, g102);
        je.b.f32619a.i("", this.betLine.bookmakerId);
    }

    public static void sendClickAnalyticsEvent(String str, GameObj gameObj, String str2, String str3, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, BetLine betLine, HashMap<String, Object> hashMap, boolean z15, BookMakerObj bookMakerObj, String str4, boolean z16, int i10, String str5) {
        try {
            if (str.isEmpty()) {
                return;
            }
            HashMap hashMap2 = new HashMap();
            if (hashMap != null) {
                hashMap2.putAll(hashMap);
            } else {
                hashMap2.put("game_id", String.valueOf(gameObj.getID()));
                hashMap2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, com.scores365.gameCenter.i0.D0(gameObj));
                if (betLine != null) {
                    hashMap2.put("market_type", String.valueOf(betLine.type));
                    hashMap2.put("bookie_id", String.valueOf(betLine.bookmakerId));
                } else {
                    hashMap2.put("bookie_id", String.valueOf(bookMakerObj.getID()));
                }
            }
            hashMap2.put("click_type", str3);
            if (z16 && i10 != -1) {
                hashMap2.put("time_vote", sf.a.i0(App.m()).o1(i10) != -1 ? "after" : "before");
            }
            if (z10 || z15) {
                hashMap2.put("bet-now-ab-test", n0.f24018a.b());
            }
            if (z14) {
                hashMap2.put("bet-now-ab-test", n0.f24018a.b());
            }
            hashMap2.put("insight-ab-test", q.g.M() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "0");
            hashMap2.put("button_design", getBetNowBtnDesignForAnalytics());
            hashMap2.put("guid", str5);
            hashMap2.put("url", str4);
            ee.k.m(App.m(), "gamecenter", str, "bookie", "click", true, hashMap2);
            sf.b.X1().m3(b.e.BookieClicksCount);
            ee.c.f25841a.c(r.b.f25906a);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static boolean shouldShowBetNowBtn() {
        try {
            if (shouldShowBetNowBtn == null) {
                shouldShowBetNowBtn = Boolean.FALSE;
                String[] split = p0.l0("COUNTRIES_WITH_OLD_ODDS_VIEW").split(",");
                String valueOf = String.valueOf(sf.a.i0(App.m()).j0());
                for (String str : split) {
                    if (valueOf.equals(str)) {
                        shouldShowBetNowBtn = Boolean.TRUE;
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return shouldShowBetNowBtn.booleanValue();
    }

    protected void bindViews() {
        if (betNowPositionAbTesting == null) {
            betNowPositionAbTesting = Boolean.valueOf(x0.K1("BETS_LINEUPS_CTA_PREC", 0.5f));
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.nn);
        this.bookMakerRelativeLayoutB = relativeLayout;
        this.imageViewBookMaker = (ImageView) relativeLayout.findViewById(R.id.Da);
        this.imageViewBookMakerA = (ImageView) findViewById(R.id.Ea);
        TextView textView = (TextView) findViewById(R.id.f21942cj);
        this.textViewBookMakerA = textView;
        textView.setTypeface(o0.d(App.m()));
        this.bookMakerLinearLayoutA = (RelativeLayout) findViewById(R.id.Vf);
        this.llInsightOdd = (LinearLayout) findViewById(R.id.f22053hg);
        this.tvBetNowTitleA = null;
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.mn);
        this.rlBetNowBtnB = relativeLayout2;
        TextView textView2 = (TextView) relativeLayout2.findViewById(R.id.Vw);
        this.tvBetNowTitleB = textView2;
        textView2.setTypeface(o0.d(App.m()));
        this.ivBookmakerImage = (ImageView) this.rlBetNowBtnB.findViewById(R.id.Da);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.Y2);
        this.clBetNowBtnA = constraintLayout;
        this.tvBetNowTitleA = (TextView) constraintLayout.findViewById(R.id.Vw);
        this.betNowBackgroundColorView = this.clBetNowBtnA.findViewById(R.id.S);
        this.tvBetNowTitleA.setText(p0.l0("ODDS_COMPARISON_BET_NOW"));
        this.tvBetNowTitleA.setTypeface(o0.d(App.m()));
        this.tvBetNowTitleB.setTypeface(o0.d(App.m()));
        if (x0.l1()) {
            this.bookMakerRelativeLayoutB.setLayoutDirection(1);
            this.clBetNowBtnA.setLayoutDirection(1);
            this.bookMakerLinearLayoutA.setLayoutDirection(1);
            this.llInsightOdd.setLayoutDirection(1);
            this.rlBetNowBtnB.setLayoutDirection(1);
        }
        this.odd1 = findViewById(R.id.WB);
        this.odd2 = findViewById(R.id.XB);
        this.odd3 = findViewById(R.id.YB);
        this.divider1 = findViewById(R.id.H4);
        this.divider2 = findViewById(R.id.I4);
        this.textViewOdd1 = (TextView) this.odd1.findViewById(R.id.f22189nj);
        this.textViewOdd2 = (TextView) this.odd2.findViewById(R.id.f22189nj);
        this.textViewOdd3 = (TextView) this.odd3.findViewById(R.id.f22189nj);
        this.textViewOdd1yellow = (TextView) this.odd1.findViewById(R.id.f22255qj);
        this.textViewOdd2yellow = (TextView) this.odd2.findViewById(R.id.f22255qj);
        this.textViewOdd3yellow = (TextView) this.odd3.findViewById(R.id.f22255qj);
        this.tvMarketTypeOptionName1 = (TextView) this.odd1.findViewById(R.id.Xi);
        this.tvMarketTypeOptionName2 = (TextView) this.odd2.findViewById(R.id.Xi);
        this.tvMarketTypeOptionName3 = (TextView) this.odd3.findViewById(R.id.Xi);
        this.imageViewOdd1 = (ImageView) findViewById(R.id.WB).findViewById(R.id.f22167mj);
        this.imageViewOdd2 = (ImageView) findViewById(R.id.XB).findViewById(R.id.f22167mj);
        this.imageViewOdd3 = (ImageView) findViewById(R.id.YB).findViewById(R.id.f22167mj);
        this.titleContainer = (LinearLayout) findViewById(R.id.Og);
        this.title1 = (TextView) findViewById(R.id.hH);
        this.title2 = (TextView) findViewById(R.id.iH);
        this.title3 = (TextView) findViewById(R.id.jH);
        ArrayList<TextView> arrayList = new ArrayList<>();
        this.titleViews = arrayList;
        arrayList.add(this.title1);
        this.titleViews.add(this.title2);
        this.titleViews.add(this.title3);
        setViewsParams();
    }

    public LinearLayout getLlInsightOdd() {
        return this.llInsightOdd;
    }

    public void hideBetNowButtonBelow() {
        try {
            this.rlBetNowBtnB.setVisibility(8);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void inflateLayout(LayoutInflater layoutInflater) {
        layoutInflater.inflate(R.layout.f22728v3, this);
    }

    protected void initViews() {
        try {
            if (betNowPositionAbTesting == null) {
                betNowPositionAbTesting = Boolean.valueOf(x0.K1("BETS_LINEUPS_CTA_PREC", 0.5f));
            }
            bindViews();
            setViewsParams();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void replaceViewsForEnglishUS(int i10, boolean z10) {
        try {
            if (this.isPositionsSwapped) {
                return;
            }
            if ((z10 && x0.l1()) || x0.k(i10)) {
                ArrayList<View> arrayList = this.containerViews;
                if (arrayList != null) {
                    Collections.reverse(arrayList);
                }
                ArrayList<TextView> arrayList2 = this.textViews;
                if (arrayList2 != null) {
                    Collections.reverse(arrayList2);
                }
                ArrayList<ImageView> arrayList3 = this.imageViews;
                if (arrayList3 != null) {
                    Collections.reverse(arrayList3);
                }
                ArrayList<TextView> arrayList4 = this.titleViews;
                if (arrayList4 != null) {
                    Collections.reverse(arrayList4);
                }
                ArrayList<TextView> arrayList5 = this.textViewsYellow;
                if (arrayList5 != null) {
                    Collections.reverse(arrayList5);
                }
                ArrayList<TextView> arrayList6 = this.textViewsMarketName;
                if (arrayList6 != null) {
                    Collections.reverse(arrayList6);
                }
                this.isPositionsSwapped = true;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setBetLine(BetLine betLine, String str, GameObj gameObj, BookMakerObj bookMakerObj, boolean z10) {
        setBetLine(betLine, str, gameObj, bookMakerObj, false, false, false, false, z10, -1);
    }

    public void setBetLine(BetLine betLine, String str, GameObj gameObj, BookMakerObj bookMakerObj, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i10) {
        setBetLine(betLine, str, gameObj, bookMakerObj, z10, z11, z12, z13, z14, false, false, i10);
    }

    public void setBetLine(BetLine betLine, String str, GameObj gameObj, BookMakerObj bookMakerObj, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i10) {
        this.betLine = betLine;
        this.bookMakerObj = bookMakerObj;
        setClickListenersAndTexts(z10, i10, str, gameObj, z11, z12, z13, z14, z16, z15);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0258  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setClickListenersAndTexts(final boolean r20, final int r21, final java.lang.String r22, final com.scores365.entitys.GameObj r23, final boolean r24, final boolean r25, final boolean r26, final boolean r27, boolean r28, final boolean r29) {
        /*
            Method dump skipped, instructions count: 1647
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.OddsView.setClickListenersAndTexts(boolean, int, java.lang.String, com.scores365.entitys.GameObj, boolean, boolean, boolean, boolean, boolean, boolean):void");
    }

    public void setEventParamsForAnalyticsFromTeaser(int i10, String str) {
        try {
            HashMap<String, Object> hashMap = new HashMap<>();
            this.eventParamsForAnalytics = hashMap;
            hashMap.put("game_id", String.valueOf(i10));
            this.eventParamsForAnalytics.put("bookie_id", String.valueOf(this.betLine.bookmakerId));
            this.eventParamsForAnalytics.put("next_game_id", str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setGameCenterScope(boolean z10) {
        this.isGameCenterScope = z10;
    }

    public void setIsWwwScope(boolean z10) {
        this.isWwwScope = z10;
    }

    public void setLiveOddsContext(boolean z10) {
        this.isLiveOddsContext = z10;
    }

    public void setPredictionInsight(com.scores365.gameCenter.Predictions.a aVar, int i10) {
        BetLine e10 = aVar.e();
        SingleInsightObj c10 = aVar.c();
        if (e10 != null && c10 != null && c10.getBetLine() != null && c10.getBetLine().optionNum != 0) {
            this.textViewOdd1.setText(String.valueOf(e10.lineOptions[c10.getBetLine().optionNum - 1].getOddsByUserChoice()));
            this.textViewOdd1.setTextColor(p0.A(R.attr.U0));
            int termArrowId = e10.lineOptions[c10.getBetLine().optionNum - 1].doesHaveOldRate() ? e10.lineOptions[c10.getBetLine().optionNum - 1].getTermArrowId() : 0;
            int i11 = c10.getBetLine().optionNum;
            if (i11 == 1) {
                this.textViewOdd1yellow.setVisibility(8);
                this.imageViewOdd1.setImageResource(termArrowId);
                this.odd2.setVisibility(8);
                this.odd3.setVisibility(8);
            } else if (i11 == 2) {
                this.textViewOdd2yellow.setVisibility(8);
                this.imageViewOdd2.setImageResource(termArrowId);
                this.odd1.setVisibility(8);
                this.odd3.setVisibility(8);
            } else if (i11 == 3) {
                this.textViewOdd3yellow.setVisibility(8);
                this.imageViewOdd3.setImageResource(termArrowId);
                this.odd1.setVisibility(8);
                this.odd2.setVisibility(8);
            }
        } else if (i10 != -1) {
            if (i10 == 1) {
                this.containerViews.get(1).setVisibility(8);
                this.containerViews.get(2).setVisibility(8);
                this.clBetNowBtnA.setVisibility(8);
            } else if (i10 == 2) {
                this.containerViews.get(0).setVisibility(8);
                this.containerViews.get(2).setVisibility(8);
                this.clBetNowBtnA.setVisibility(8);
            } else if (i10 == 3) {
                this.containerViews.get(0).setVisibility(8);
                this.containerViews.get(1).setVisibility(8);
                this.clBetNowBtnA.setVisibility(8);
            }
        }
        if (this.isScoresScope) {
            this.odd1.getLayoutParams().width = p0.s(88);
            this.odd2.getLayoutParams().width = p0.s(88);
            this.odd3.getLayoutParams().width = p0.s(88);
        }
        getLlInsightOdd().setLayoutTransition(null);
        getLlInsightOdd().getLayoutParams().width = -2;
    }

    public void setPredictionMinWidth(int i10) {
        try {
            View view = this.odd1;
            if (view != null) {
                view.setMinimumWidth(p0.s(i10));
            }
            View view2 = this.odd2;
            if (view2 != null) {
                view2.setMinimumWidth(p0.s(i10));
            }
            View view3 = this.odd3;
            if (view3 != null) {
                view3.setMinimumWidth(p0.s(i10));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setScoresScope(boolean z10) {
        this.isScoresScope = z10;
    }

    public void setTitleVisible(boolean z10) {
        try {
            if (z10) {
                this.titleContainer.setVisibility(0);
            } else {
                this.titleContainer.setVisibility(8);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected void setViewsParams() {
        try {
            this.title1.setTypeface(o0.d(App.m()));
            this.title2.setTypeface(o0.d(App.m()));
            this.title3.setTypeface(o0.d(App.m()));
            this.textViewOdd1.setTypeface(o0.d(App.m()));
            this.textViewOdd2.setTypeface(o0.d(App.m()));
            this.textViewOdd3.setTypeface(o0.d(App.m()));
            this.tvMarketTypeOptionName1.setTypeface(o0.d(App.m()));
            this.tvMarketTypeOptionName2.setTypeface(o0.d(App.m()));
            this.tvMarketTypeOptionName3.setTypeface(o0.d(App.m()));
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
            ArrayList<TextView> arrayList3 = new ArrayList<>();
            this.textViewsYellow = arrayList3;
            arrayList3.add(this.textViewOdd1yellow);
            this.textViewsYellow.add(this.textViewOdd2yellow);
            this.textViewsYellow.add(this.textViewOdd3yellow);
            ArrayList<ImageView> arrayList4 = new ArrayList<>();
            this.imageViews = arrayList4;
            arrayList4.add(this.imageViewOdd1);
            this.imageViews.add(this.imageViewOdd2);
            this.imageViews.add(this.imageViewOdd3);
            ArrayList<TextView> arrayList5 = new ArrayList<>();
            this.textViewsMarketName = arrayList5;
            arrayList5.add(this.tvMarketTypeOptionName1);
            this.textViewsMarketName.add(this.tvMarketTypeOptionName2);
            this.textViewsMarketName.add(this.tvMarketTypeOptionName3);
            this.bookmakerLayoutParams = (LinearLayout.LayoutParams) this.bookMakerRelativeLayoutB.getLayoutParams();
            this.title1.setTypeface(o0.d(App.m()));
            this.title2.setTypeface(o0.d(App.m()));
            this.title3.setTypeface(o0.d(App.m()));
            this.tvBetNowTitleA.setText(p0.l0("ODDS_COMPARISON_BET_NOW"));
            this.tvBetNowTitleB.setText(p0.l0("ODDS_COMPARISON_BET_NOW"));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setWwwEntityId(int i10) {
        this.wwwEntityId = i10;
    }
}
