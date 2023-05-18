package com.scores365.ui.playerCard;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.e1;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.c;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.entitys.AthleteStats;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GameStats;
import com.scores365.entitys.LastMatchesHeaderObj;
import com.scores365.entitys.PlayerObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.ui.CustomGameCenterHeaderView;
import com.scores365.ui.playerCard.CustomHorizontalScrollView;
import com.scores365.ui.playerCard.LastMatchGameBasketballItem;
import com.scores365.ui.playerCard.LastMatchGameItem;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import li.o0;
import li.p0;
import li.x0;
import nb.o;
import nb.p;
/* loaded from: classes2.dex */
public class LastMatchGameBasketballItem extends LastMatchGameItem {
    public static final int COMPETITOR_NAME_SIDE_MARGIN;
    public static final int COMPETITOR_NAME_WIDTH;
    public static final int DASH_TEXT_WIDTH;
    public static final int REASON_IV_SIDE_MARGIN;
    public static final int REASON_IV_SIZE;
    public static final int SCORE_TEXT_SIDE_MARGIN;
    public static final int SCORE_TEXT_WIDTH;
    public static final int SCROLLED_STAT_WIDTH = p0.s(32);
    public static final int STATS_OFFSET;
    String leftTeamScore;
    String rightTeamScore;
    private int scoreColor;
    boolean shouldColorLeftScore;
    String teamIconLink;
    String teamName;

    /* loaded from: classes2.dex */
    public static class ViewHolder extends t implements LastMatchGameItem.iSyncScrolledViewHolder, c.a {
        TextView dateTV;
        View dividerDark;
        int maxScrollWidth;
        protected LastMatchGameItem.iScrollListener scrollListener;
        LinearLayout statsContainer;
        CustomHorizontalScrollView statsScrollView;
        LinearLayout statsScrolledContainer;
        ImageView topTeamLogo;
        TextView vsTv;

        public ViewHolder(View view, q.e eVar) {
            super(view);
            this.maxScrollWidth = 0;
            this.statsContainer = (LinearLayout) view.findViewById(R.id.Oe);
            this.dateTV = (TextView) view.findViewById(R.id.Ne);
            this.topTeamLogo = (ImageView) view.findViewById(R.id.Pe);
            this.statsScrollView = (CustomHorizontalScrollView) view.findViewById(R.id.f22045h8);
            this.statsScrolledContainer = (LinearLayout) view.findViewById(R.id.f22407xg);
            this.dividerDark = view.findViewById(R.id.P4);
            this.vsTv = (TextView) view.findViewById(R.id.Se);
            this.dateTV.setTypeface(o0.d(App.m()));
            this.vsTv.setTypeface(o0.c(App.m()));
            if (x0.l1()) {
                view.setLayoutDirection(1);
            } else {
                view.setLayoutDirection(0);
            }
            ((t) this).itemView.setOnClickListener(new u(this, eVar));
        }

        public LastMatchGameItem.iScrollListener getScrollListener() {
            return this.scrollListener;
        }

        @Override // com.scores365.Design.Pages.t
        public boolean isSupportRTL() {
            return true;
        }

        @Override // com.scores365.Design.Pages.c.a
        public void onViewHolderAttached() {
            try {
                scrollStatContainer(this.scrollListener.getCurrentLastMatchesScrollPosition());
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // com.scores365.ui.playerCard.LastMatchGameItem.iSyncScrolledViewHolder
        public void scrollStatContainer(int i10) {
            try {
                CustomHorizontalScrollView.Companion.iScrollListener scrollListener = this.statsScrollView.getScrollListener();
                this.statsScrollView.setScrollListener(null);
                this.statsScrollView.scrollTo(i10, 0);
                this.statsScrollView.setScrollListener(scrollListener);
                updateShadowTranslation(i10);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public void setScrollListener(LastMatchGameItem.iScrollListener iscrolllistener) {
            this.scrollListener = iscrolllistener;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void updateShadowTranslation(int i10) {
            try {
                if (x0.l1()) {
                    this.dividerDark.setTranslationX(i10 - LastMatchGameBasketballItem.STATS_OFFSET);
                    if (this.dividerDark.getTranslationX() > 0.0f) {
                        this.dividerDark.setTranslationX(0.0f);
                    }
                } else {
                    this.dividerDark.setTranslationX(LastMatchGameBasketballItem.STATS_OFFSET - i10);
                    if (this.dividerDark.getTranslationX() < 0.0f) {
                        this.dividerDark.setTranslationX(0.0f);
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    static {
        int s10 = p0.s(76);
        COMPETITOR_NAME_WIDTH = s10;
        int s11 = p0.s(2);
        COMPETITOR_NAME_SIDE_MARGIN = s11;
        int s12 = p0.s(22);
        SCORE_TEXT_WIDTH = s12;
        int s13 = p0.s(12);
        DASH_TEXT_WIDTH = s13;
        int s14 = p0.s(6);
        SCORE_TEXT_SIDE_MARGIN = s14;
        STATS_OFFSET = s10 + (s11 * 2) + (s12 * 2) + s13 + (s14 * 2);
        REASON_IV_SIZE = p0.s(17);
        REASON_IV_SIDE_MARGIN = p0.s(5);
    }

    public LastMatchGameBasketballItem(GameStats gameStats, boolean z10, int i10, int i11, LastMatchGameItem.iScrollListener iscrolllistener, ArrayList<LastMatchesHeaderObj> arrayList) {
        this.scoreColor = p0.A(R.attr.U0);
        try {
            this.gameStats = gameStats;
            this.sportId = i10;
            this.headers = arrayList;
            this.date = new StringBuilder();
            char c10 = 1;
            boolean l10 = x0.l(gameStats.getGameObj().homeAwayTeamOrder, true);
            int i12 = !l10 ? 1 : 0;
            GameStats gameStats2 = this.gameStats;
            if (gameStats2 != null) {
                GameObj gameObj = gameStats2.getGameObj();
                if ((gameObj.getWinner() == GameObj.WINNER_HOME && gameObj.getComps()[0].getID() == this.gameStats.getRelatedCompetitor()) || (gameObj.getWinner() == GameObj.WINNER_AWAY && gameObj.getComps()[1].getID() == this.gameStats.getRelatedCompetitor())) {
                    this.scoreColor = p0.A(R.attr.f21562l1);
                } else {
                    this.scoreColor = p0.A(R.attr.f21559k1);
                }
                if (gameObj.getComps()[l10 ? 1 : 0].getID() == this.gameStats.getRelatedCompetitor()) {
                    this.shouldColorLeftScore = true;
                }
                if (gameObj.getScores() != null && gameObj.getScores().length == 2) {
                    this.leftTeamScore = String.valueOf(gameObj.getScores()[l10 ? 1 : 0].getScore());
                    this.rightTeamScore = String.valueOf(gameObj.getScores()[i12].getScore());
                }
                Locale locale = Locale.US;
                Calendar calendar = Calendar.getInstance(locale);
                Calendar calendar2 = Calendar.getInstance(locale);
                calendar2.setTime(this.gameStats.getGameObj().getSTime());
                int i13 = calendar.get(1) - calendar2.get(1);
                if (calendar2.get(2) > calendar.get(2) || (calendar2.get(2) == calendar.get(2) && calendar2.get(5) > calendar.get(5))) {
                    i13--;
                }
                if (i13 > 0) {
                    this.date.append(calendar2.get(1));
                } else {
                    this.date.append(x0.T(this.gameStats.getGameObj().getSTime(), false));
                }
                this.hasPlayed = this.gameStats.isPlayed();
                if (gameObj.getComps()[0].getID() != this.gameStats.getRelatedCompetitor()) {
                    c10 = 0;
                }
                this.teamName = gameObj.getComps()[c10].getTitleName();
                this.teamIconLink = o.s(p.Competitors, gameObj.getComps()[c10].getID(), Integer.valueOf((int) CustomGameCenterHeaderView.IMAGE_SIZE), Integer.valueOf((int) CustomGameCenterHeaderView.IMAGE_SIZE), false, gameObj.getComps()[c10].getImgVer());
            }
            this.isCollapsed = z10;
            this.singleStatTypeId = i11;
            this.scrollListener = iscrolllistener;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void addTeamNameAndScore(final ViewHolder viewHolder, LinearLayout linearLayout) {
        try {
            TextView textView = new TextView(App.m());
            textView.setText(this.teamName);
            textView.setTextSize(1, 12.0f);
            textView.setTextColor(p0.A(R.attr.U0));
            int i10 = 5;
            textView.setGravity((x0.l1() ? 5 : 3) | 16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(COMPETITOR_NAME_WIDTH, -1, 0.0f);
            int i11 = COMPETITOR_NAME_SIDE_MARGIN;
            layoutParams.setMarginStart(i11);
            layoutParams.setMarginEnd(i11);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.playerCard.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LastMatchGameBasketballItem.lambda$addTeamNameAndScore$0(LastMatchGameBasketballItem.ViewHolder.this, view);
                }
            });
            linearLayout.addView(textView, layoutParams);
            TextView textView2 = new TextView(App.m());
            textView2.setText(this.leftTeamScore);
            textView2.setTextSize(1, 12.0f);
            textView2.setTextColor(this.shouldColorLeftScore ? this.scoreColor : p0.A(R.attr.U0));
            textView2.setGravity((x0.l1() ? 3 : 5) | 16);
            int i12 = SCORE_TEXT_WIDTH;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i12, -1, 0.0f);
            int i13 = SCORE_TEXT_SIDE_MARGIN;
            layoutParams2.setMarginStart(i13);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.playerCard.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LastMatchGameBasketballItem.lambda$addTeamNameAndScore$1(LastMatchGameBasketballItem.ViewHolder.this, view);
                }
            });
            linearLayout.addView(textView2, layoutParams2);
            TextView textView3 = new TextView(App.m());
            textView3.setText("-");
            textView3.setTextSize(1, 12.0f);
            textView3.setTextColor(p0.A(R.attr.U0));
            textView3.setGravity(17);
            ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(DASH_TEXT_WIDTH, -1, 0.0f);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.playerCard.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LastMatchGameBasketballItem.lambda$addTeamNameAndScore$2(LastMatchGameBasketballItem.ViewHolder.this, view);
                }
            });
            linearLayout.addView(textView3, layoutParams3);
            TextView textView4 = new TextView(App.m());
            textView4.setText(this.rightTeamScore);
            textView4.setTextSize(1, 12.0f);
            textView4.setTextColor(!this.shouldColorLeftScore ? this.scoreColor : p0.A(R.attr.U0));
            if (!x0.l1()) {
                i10 = 3;
            }
            textView4.setGravity(16 | i10);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i12, -1, 0.0f);
            layoutParams4.setMarginEnd(i13);
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.playerCard.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LastMatchGameBasketballItem.lambda$addTeamNameAndScore$3(LastMatchGameBasketballItem.ViewHolder.this, view);
                }
            });
            linearLayout.addView(textView4, layoutParams4);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private ConstraintLayout.b getIVlayoutParams(boolean z10, String str) {
        ConstraintLayout.b bVar = new ConstraintLayout.b(p0.s(20), p0.s(20));
        try {
            bVar.f4636l = 0;
            bVar.f4630i = 0;
            bVar.f4622e = 0;
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return bVar;
    }

    private ConstraintLayout.b getTVlayoutParams(int i10) {
        ConstraintLayout.b bVar = new ConstraintLayout.b(p0.s(11), p0.s(11));
        try {
            bVar.f4630i = i10;
            bVar.f4634k = i10;
            bVar.f4628h = i10;
            bVar.f4624f = i10;
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addTeamNameAndScore$0(ViewHolder viewHolder, View view) {
        ((t) viewHolder).itemView.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addTeamNameAndScore$1(ViewHolder viewHolder, View view) {
        ((t) viewHolder).itemView.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addTeamNameAndScore$2(ViewHolder viewHolder, View view) {
        ((t) viewHolder).itemView.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addTeamNameAndScore$3(ViewHolder viewHolder, View view) {
        ((t) viewHolder).itemView.performClick();
    }

    public static ViewHolder onCreateViewHolderBasketball(ViewGroup viewGroup, q.e eVar) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.C3, viewGroup, false), eVar);
    }

    private View returnEmptyView(int i10) {
        View view = new View(App.m());
        try {
            view.setLayoutParams(new LinearLayout.LayoutParams(i10, p0.s(44), 1.0f));
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return view;
    }

    private TextView returnRankingTV(AthleteStats athleteStats, boolean z10) {
        Double valueOf;
        TextView textView = new TextView(App.m());
        try {
            textView.setText(athleteStats.getV());
            int i10 = 1;
            textView.setTextSize(1, 11.0f);
            textView.setGravity(17);
            textView.setTypeface(o0.d(App.m()));
            textView.setTextColor(p0.A(R.attr.U0));
            int i11 = 0;
            if (shouldUseScroll()) {
                i11 = SCROLLED_STAT_WIDTH;
                i10 = 0;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i11, p0.s(16), i10);
            layoutParams.gravity = 16;
            if (z10) {
                layoutParams.leftMargin = p0.s(7);
                layoutParams.rightMargin = p0.s(7);
            } else {
                layoutParams.leftMargin = p0.s(2);
                layoutParams.rightMargin = p0.s(2);
            }
            textView.setLayoutParams(layoutParams);
            Double.valueOf(0.0d);
            try {
                valueOf = Double.valueOf(Double.parseDouble(athleteStats.getV()));
            } catch (Exception unused) {
            }
            if (athleteStats.getBgColor().isEmpty()) {
                textView.setBackgroundResource(PlayerObj.getRankingBG(valueOf.doubleValue()));
            } else {
                GradientDrawable gradientDrawable = (GradientDrawable) App.m().getResources().getDrawable(R.drawable.F0);
                gradientDrawable.setColorFilter(Color.parseColor(athleteStats.getBgColor()), PorterDuff.Mode.SRC_IN);
                textView.setBackground(gradientDrawable);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return textView;
    }

    private ImageView returnReasonIV(int i10, String str, int i11, int i12) {
        ImageView imageView = new ImageView(App.m());
        try {
            String injuryIconLink = i10 != -1 ? PlayerObj.getInjuryIconLink(p0.s(17), str, i10) : i11 != -1 ? PlayerObj.getSuspensionIconLink(p0.s(17), i12, i11) : null;
            if (injuryIconLink == null || injuryIconLink.isEmpty()) {
                imageView.setImageResource(com.scores365.gameCenter.gameCenterItems.c.l(i10, i11));
            } else {
                li.u.x(injuryIconLink, imageView);
            }
            int i13 = REASON_IV_SIZE;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i13, i13);
            layoutParams.gravity = 16;
            int i14 = REASON_IV_SIDE_MARGIN;
            layoutParams.leftMargin = i14;
            layoutParams.rightMargin = i14;
            imageView.setLayoutParams(layoutParams);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return imageView;
    }

    public static TextView returnReasonTV(String str, int i10, boolean z10, boolean z11, boolean z12, boolean z13) {
        TextView textView = new TextView(App.m());
        try {
            textView.setText(str);
            textView.setTextSize(1, z13 ? 11.0f : 12.0f);
            textView.setTypeface(o0.d(App.m()));
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            if (z10) {
                textView.setGravity(17);
            } else {
                textView.setGravity(8388627);
            }
            if (z10) {
                textView.setTextColor(p0.A(R.attr.U0));
            } else {
                textView.setTextColor(p0.A(R.attr.f21565m1));
            }
            if (z10) {
                i10 = SCROLLED_STAT_WIDTH;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i10, p0.s(44), 1.0f);
            if (z12 && !z11) {
                layoutParams.setMarginStart(p0.s(5));
            }
            textView.setLayoutParams(layoutParams);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return textView;
    }

    private ConstraintLayout returnStatIV(String str, int i10, String str2, boolean z10) {
        ConstraintLayout constraintLayout = new ConstraintLayout(App.m());
        constraintLayout.setId(View.generateViewId());
        constraintLayout.setLayoutParams(new LinearLayout.LayoutParams(0, p0.s(44), 1.0f));
        try {
            ImageView imageView = new ImageView(App.m());
            li.u.x(str, imageView);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setAdjustViewBounds(true);
            imageView.setId(e1.n());
            constraintLayout.addView(imageView, getIVlayoutParams(z10, str2));
            if (z10 && Integer.valueOf(str2).intValue() > 0) {
                TextView textView = new TextView(App.m());
                textView.setText(str2);
                textView.setTextColor(p0.A(R.attr.B1));
                textView.setGravity(17);
                textView.setTextSize(1, 9.0f);
                textView.setBackgroundResource(R.drawable.T5);
                textView.setTypeface(o0.d(App.m()));
                textView.setIncludeFontPadding(false);
                constraintLayout.addView(textView, getTVlayoutParams(imageView.getId()));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return constraintLayout;
    }

    private ArrayList<View> returnStatsViews(int i10, int i11) {
        int size;
        ArrayList<View> arrayList = new ArrayList<>();
        if (i11 != 1) {
            size = 4;
        } else {
            try {
                size = getGameStats().getAthleteStats().size();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
        int i12 = i10 / size;
        if (shouldUseScroll()) {
            i12 = SCROLLED_STAT_WIDTH;
        }
        if (i11 != -1) {
            Iterator<AthleteStats> it = this.gameStats.getAthleteStats().iterator();
            AthleteStats athleteStats = null;
            AthleteStats athleteStats2 = null;
            while (it.hasNext()) {
                AthleteStats next = it.next();
                if (next.getV() != null && next.getT() != -1) {
                    if (next.isLogo() || next.isPlayerRanking()) {
                        if (athleteStats2 == null) {
                            athleteStats2 = next;
                        }
                    } else if (athleteStats == null) {
                        athleteStats = next;
                    }
                }
            }
            if (athleteStats != null) {
                arrayList.add(returnReasonTV(athleteStats.getV(), i12, true, shouldUseScroll(), shouldScrollBeUsedOverall(), false));
            } else {
                arrayList.add(returnEmptyView(i12));
            }
            arrayList.add(returnEmptyView(i12));
            if (athleteStats2 == null) {
                arrayList.add(returnEmptyView(i12));
            } else if (athleteStats2.isPlayerRanking()) {
                arrayList.add(returnRankingTV(athleteStats2, true));
            } else {
                p pVar = x0.n1() ? p.SportTypeStatTypesLight : p.SportTypeStatTypesDark;
                arrayList.add(returnStatIV(o.z(athleteStats2.getT(), x0.R0(-1, App.l().getImageSources().getSourcesType().get(pVar.getmName())), Integer.valueOf(p0.s(24)), Integer.valueOf(p0.s(24)), pVar), i12, athleteStats2.getV(), athleteStats2.isBadge()));
            }
        } else {
            Iterator<AthleteStats> it2 = this.gameStats.getAthleteStats().iterator();
            while (it2.hasNext()) {
                AthleteStats next2 = it2.next();
                if (next2.getV() != null && next2.getT() != -1) {
                    if (next2.isPlayerRanking()) {
                        arrayList.add(returnRankingTV(next2, false));
                    } else if (next2.isLogo()) {
                        p pVar2 = x0.n1() ? p.SportTypeStatTypesLight : p.SportTypeStatTypesDark;
                        arrayList.add(returnStatIV(o.z(next2.getT(), x0.R0(-1, App.l().getImageSources().getSourcesType().get(pVar2.getmName())), Integer.valueOf(p0.s(24)), Integer.valueOf(p0.s(24)), pVar2), i12, next2.getV(), next2.isBadge()));
                    } else {
                        arrayList.add(returnReasonTV(next2.getV(), i12, true, shouldUseScroll(), shouldScrollBeUsedOverall(), false));
                    }
                }
                arrayList.add(returnEmptyView(i12));
            }
        }
        return arrayList;
    }

    private ArrayList<View> returnStatsViewsWithSpecifiedHeaders(int i10) {
        boolean z10;
        ArrayList<View> arrayList = new ArrayList<>();
        try {
            int size = i10 / this.headers.size();
            if (shouldUseScroll()) {
                size = SCROLLED_STAT_WIDTH;
            }
            Iterator<LastMatchesHeaderObj> it = this.headers.iterator();
            while (it.hasNext()) {
                LastMatchesHeaderObj next = it.next();
                Iterator<AthleteStats> it2 = this.gameStats.getAthleteStats().iterator();
                while (true) {
                    z10 = false;
                    if (!it2.hasNext()) {
                        break;
                    }
                    AthleteStats next2 = it2.next();
                    if (next2.getT() != -1 && next2.getT() == next.getType()) {
                        arrayList.add(returnReasonTV(next2.getV(), size, true, shouldUseScroll(), shouldScrollBeUsedOverall(), this.sportId == SportTypesEnum.BASKETBALL.getValue()));
                        z10 = true;
                    }
                }
                if (!z10) {
                    arrayList.add(returnEmptyView(size));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    private boolean shouldScrollBeUsedOverall() {
        return this.sportId == SportTypesEnum.BASKETBALL.getValue() || this.sportId == SportTypesEnum.AMERICAN_FOOTBALL.getValue() || this.sportId == SportTypesEnum.HOCKEY.getValue();
    }

    private boolean shouldUseScroll() {
        return shouldScrollBeUsedOverall();
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem
    public GameStats getGameStats() {
        return this.gameStats;
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem, com.scores365.Design.PageObjects.c
    public long getItemId() {
        try {
            StringBuilder sb2 = this.date;
            if (sb2 != null) {
                if (this.randomId == -1) {
                    this.randomId = sb2.hashCode();
                }
                return 1 + this.randomId;
            }
            return super.getItemId();
        } catch (Exception e10) {
            x0.N1(e10);
            return 1L;
        }
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem, com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.LastMatchGameBasketballItem.ordinal();
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem, com.scores365.Design.PageObjects.c
    public int getSpanSize() {
        try {
            return com.scores365.Design.Activities.c.fragmentSpanSize;
        } catch (Exception unused) {
            return 1;
        }
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem, com.scores365.Design.PageObjects.c
    public boolean isFullSpanWidthSize() {
        return true;
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem
    public boolean isHasPlayed() {
        return this.hasPlayed;
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem, com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        LinearLayout linearLayout;
        final ViewHolder viewHolder = (ViewHolder) e0Var;
        try {
            viewHolder.dividerDark.setVisibility(8);
            if (shouldUseScroll()) {
                viewHolder.statsContainer.setVisibility(8);
                viewHolder.statsScrollView.setVisibility(0);
                linearLayout = viewHolder.statsScrolledContainer;
                viewHolder.statsScrollView.setScrollListener(this);
                this.itemPosition = i10;
                viewHolder.setScrollListener(this.scrollListener);
            } else {
                viewHolder.statsContainer.setVisibility(0);
                viewHolder.statsScrollView.setVisibility(8);
                linearLayout = viewHolder.statsContainer;
            }
            if (shouldScrollBeUsedOverall()) {
                viewHolder.dividerDark.setVisibility(0);
                if (x0.l1()) {
                    viewHolder.dividerDark.setRotation(180.0f);
                }
            }
            linearLayout.removeAllViews();
            addTeamNameAndScore(viewHolder, linearLayout);
            if (this.hasPlayed) {
                ArrayList<LastMatchesHeaderObj> arrayList = this.headers;
                Iterator<View> it = ((arrayList == null || arrayList.isEmpty()) ? returnStatsViews(linearLayout.getLayoutParams().width, this.singleStatTypeId) : returnStatsViewsWithSpecifiedHeaders(linearLayout.getLayoutParams().width)).iterator();
                while (it.hasNext()) {
                    linearLayout.addView(it.next());
                }
            } else {
                String reason = this.gameStats.getReason();
                linearLayout.addView(returnReasonIV(this.gameStats.getInjuryCategory(), this.gameStats.getInjuryTypeImgID(), this.gameStats.getSuspensionType(), this.gameStats.getSuspensionTypeImgID()));
                linearLayout.addView(returnReasonTV(reason, ((this.headers.size() * SCROLLED_STAT_WIDTH) - REASON_IV_SIZE) - (REASON_IV_SIDE_MARGIN * 2), false, shouldUseScroll(), shouldScrollBeUsedOverall(), false));
            }
            linearLayout.setGravity(8388611);
            if (shouldUseScroll()) {
                linearLayout.getLayoutParams().width = linearLayout.getChildCount() * SCROLLED_STAT_WIDTH;
                viewHolder.statsScrollView.invalidate();
            }
            if (this.gameStats.getGameObj().getComps()[0].getID() == this.gameStats.getRelatedCompetitor()) {
                viewHolder.vsTv.setText(p0.l0("VS_AMERICAN"));
            } else {
                viewHolder.vsTv.setText(p0.l0("SHTRUDEL_AMERICAN"));
            }
            viewHolder.dateTV.setText(this.date);
            li.u.A(this.teamIconLink, viewHolder.topTeamLogo, p0.K(R.attr.f21594w0));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((t) viewHolder).itemView.getLayoutParams();
            if (this.isCollapsed) {
                marginLayoutParams.height = 0;
                marginLayoutParams.topMargin = 0;
            } else {
                marginLayoutParams.height = p0.s(44);
                marginLayoutParams.topMargin = p0.s(1);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) ((t) viewHolder).itemView.getLayoutParams();
            if (this.singleStatTypeId != -1) {
                marginLayoutParams2.leftMargin = 0;
                marginLayoutParams2.rightMargin = 0;
                e1.C0(((t) viewHolder).itemView, 0.0f);
            } else {
                marginLayoutParams2.leftMargin = (int) App.m().getResources().getDimension(R.dimen.f21649n);
                marginLayoutParams2.rightMargin = (int) App.m().getResources().getDimension(R.dimen.f21649n);
                e1.C0(((t) viewHolder).itemView, p0.I(R.attr.f21600y0));
            }
            if (x0.l1()) {
                viewHolder.statsScrollView.setRotationY(180.0f);
                viewHolder.statsScrolledContainer.setRotationY(180.0f);
            }
            viewHolder.maxScrollWidth = (SCROLLED_STAT_WIDTH * this.headers.size()) + STATS_OFFSET;
            if (!shouldUseScroll() || this.scrollListener == null) {
                return;
            }
            viewHolder.statsScrollView.post(new Runnable() { // from class: com.scores365.ui.playerCard.LastMatchGameBasketballItem.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        CustomHorizontalScrollView.Companion.iScrollListener scrollListener = viewHolder.statsScrollView.getScrollListener();
                        viewHolder.statsScrollView.setScrollListener(null);
                        viewHolder.statsScrollView.scrollTo(LastMatchGameBasketballItem.this.scrollListener.getCurrentLastMatchesScrollPosition(), 0);
                        viewHolder.statsScrollView.setScrollListener(scrollListener);
                        viewHolder.updateShadowTranslation(LastMatchGameBasketballItem.this.scrollListener.getCurrentLastMatchesScrollPosition());
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            });
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem, com.scores365.ui.playerCard.CustomHorizontalScrollView.Companion.iScrollListener
    public void onScrolled(int i10, int i11, int i12, int i13) {
        try {
            LastMatchGameItem.iScrollListener iscrolllistener = this.scrollListener;
            if (iscrolllistener == null || i12 == i10) {
                return;
            }
            iscrolllistener.onLastMatchHorizontalScroll(i10, this.itemPosition);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem
    public void setCollapsed(boolean z10) {
        this.isCollapsed = z10;
    }
}
