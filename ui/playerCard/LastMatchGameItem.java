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
public class LastMatchGameItem extends com.scores365.Design.PageObjects.b implements CustomHorizontalScrollView.Companion.iScrollListener {
    public static final int SCROLLED_STAT_WIDTH = p0.s(32);
    String bottomTeamIconLink;
    String bottomTeamName;
    String bottomTeamScore;
    StringBuilder date;
    protected GameStats gameStats;
    protected boolean hasPlayed;
    protected ArrayList<LastMatchesHeaderObj> headers;
    protected boolean isCollapsed;
    protected boolean isOutrightDialogContext;
    protected int itemPosition;
    protected long randomId;
    protected iScrollListener scrollListener;
    int singleStatTypeId;
    protected int sportId;
    String topTeamIconLink;
    String topTeamName;
    String topTeamScore;

    /* loaded from: classes2.dex */
    public static class LastMatchGameItemViewHolder extends t implements iSyncScrolledViewHolder {
        TextView bottomNameTV;
        TextView bottomScoreTV;
        ImageView bottomTeamLogo;
        TextView dateTV;
        View dividerDark;
        LinearLayout statsContainer;
        CustomHorizontalScrollView statsScrollView;
        LinearLayout statsScrolledContainer;
        TextView topNameTV;
        TextView topScoreTV;
        ImageView topTeamLogo;

        public LastMatchGameItemViewHolder(View view, q.e eVar) {
            super(view);
            this.statsContainer = (LinearLayout) view.findViewById(R.id.Oe);
            this.topNameTV = (TextView) view.findViewById(R.id.Qe);
            this.bottomNameTV = (TextView) view.findViewById(R.id.Le);
            this.dateTV = (TextView) view.findViewById(R.id.Ne);
            this.topScoreTV = (TextView) view.findViewById(R.id.Re);
            this.bottomScoreTV = (TextView) view.findViewById(R.id.Me);
            this.topTeamLogo = (ImageView) view.findViewById(R.id.Pe);
            this.bottomTeamLogo = (ImageView) view.findViewById(R.id.Ke);
            this.statsScrollView = (CustomHorizontalScrollView) view.findViewById(R.id.f22045h8);
            this.statsScrolledContainer = (LinearLayout) view.findViewById(R.id.f22407xg);
            this.dividerDark = view.findViewById(R.id.P4);
            this.topNameTV.setTypeface(o0.d(App.m()));
            this.bottomNameTV.setTypeface(o0.d(App.m()));
            this.dateTV.setTypeface(o0.d(App.m()));
            this.topScoreTV.setTypeface(o0.d(App.m()));
            this.bottomScoreTV.setTypeface(o0.d(App.m()));
            if (x0.l1()) {
                view.setLayoutDirection(1);
            } else {
                view.setLayoutDirection(0);
            }
            ((t) this).itemView.setOnClickListener(new u(this, eVar));
        }

        @Override // com.scores365.Design.Pages.t
        public boolean isSupportRTL() {
            return true;
        }

        @Override // com.scores365.ui.playerCard.LastMatchGameItem.iSyncScrolledViewHolder
        public void scrollStatContainer(int i10) {
            try {
                this.statsScrollView.scrollTo(i10, 0);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface iScrollListener {
        int getCurrentLastMatchesScrollPosition();

        void onLastMatchHorizontalScroll(int i10, int i11);
    }

    /* loaded from: classes2.dex */
    public interface iSyncScrolledViewHolder {
        void scrollStatContainer(int i10);
    }

    public LastMatchGameItem() {
        this.gameStats = null;
        this.randomId = -1L;
        this.hasPlayed = false;
        this.isOutrightDialogContext = false;
    }

    public LastMatchGameItem(GameStats gameStats, boolean z10, int i10, int i11, iScrollListener iscrolllistener, ArrayList<LastMatchesHeaderObj> arrayList) {
        this.randomId = -1L;
        this.hasPlayed = false;
        this.isOutrightDialogContext = false;
        try {
            this.gameStats = gameStats;
            this.sportId = i10;
            this.headers = arrayList;
            this.date = new StringBuilder();
            boolean k10 = x0.k(gameStats.getGameObj().homeAwayTeamOrder);
            int i12 = !k10 ? 1 : 0;
            GameStats gameStats2 = this.gameStats;
            if (gameStats2 != null) {
                GameObj gameObj = gameStats2.getGameObj();
                if (gameObj.getScores() != null && gameObj.getScores().length == 2) {
                    this.topTeamScore = String.valueOf(gameObj.getScores()[k10 ? 1 : 0].getScore());
                    this.bottomTeamScore = String.valueOf(gameObj.getScores()[i12].getScore());
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
                this.topTeamName = nb.u.b(gameObj.getComps()[k10 ? 1 : 0]);
                this.bottomTeamName = nb.u.b(gameObj.getComps()[i12]);
                p pVar = p.Competitors;
                this.topTeamIconLink = o.s(pVar, gameObj.getComps()[k10 ? 1 : 0].getID(), Integer.valueOf((int) CustomGameCenterHeaderView.IMAGE_SIZE), Integer.valueOf((int) CustomGameCenterHeaderView.IMAGE_SIZE), false, gameObj.getComps()[k10 ? 1 : 0].getImgVer());
                this.bottomTeamIconLink = o.s(pVar, gameObj.getComps()[i12].getID(), Integer.valueOf((int) CustomGameCenterHeaderView.IMAGE_SIZE), Integer.valueOf((int) CustomGameCenterHeaderView.IMAGE_SIZE), false, gameObj.getComps()[i12].getImgVer());
            }
            this.isCollapsed = z10;
            this.singleStatTypeId = i11;
            this.scrollListener = iscrolllistener;
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

    public static LastMatchGameItem getLastMatchGameItem(GameStats gameStats, boolean z10, int i10, int i11, iScrollListener iscrolllistener, ArrayList<LastMatchesHeaderObj> arrayList) {
        try {
            return x0.F2(i10) ? new LastMatchGameBasketballItem(gameStats, z10, i10, i11, iscrolllistener, arrayList) : new LastMatchGameItem(gameStats, z10, i10, i11, iscrolllistener, arrayList);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
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

    public static LastMatchGameItemViewHolder onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new LastMatchGameItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.D3, viewGroup, false), eVar);
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
            String injuryIconLink = i10 != -1 ? PlayerObj.getInjuryIconLink(p0.s(17), str, i10) : i11 != -1 ? PlayerObj.getSuspensionIconLink(p0.s(17), i11, i11) : null;
            if (injuryIconLink == null || injuryIconLink.isEmpty()) {
                imageView.setImageResource(com.scores365.gameCenter.gameCenterItems.c.l(i10, i11));
            } else {
                li.u.x(injuryIconLink, imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(p0.s(17), p0.s(17));
            layoutParams.gravity = 16;
            layoutParams.leftMargin = p0.s(5);
            layoutParams.rightMargin = p0.s(5);
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
            if (z11) {
                textView.setGravity(17);
            } else {
                textView.setGravity(8388627);
            }
            if (z10) {
                textView.setTextColor(p0.A(R.attr.U0));
            } else {
                textView.setTextColor(p0.A(R.attr.f21565m1));
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(z11 ? SCROLLED_STAT_WIDTH : 0, -1, 1.0f);
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
        if (x0.l1()) {
            i10 += p0.s(8);
        }
        constraintLayout.setLayoutParams(new LinearLayout.LayoutParams(i10, p0.s(44), 1.0f));
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
        if (i11 == -1 && !this.isOutrightDialogContext) {
            Iterator<AthleteStats> it = this.gameStats.getAthleteStats().iterator();
            while (it.hasNext()) {
                AthleteStats next = it.next();
                if (next.getV() != null && next.getT() != -1) {
                    if (next.isPlayerRanking()) {
                        arrayList.add(returnRankingTV(next, false));
                    } else if (next.isLogo()) {
                        p pVar = x0.n1() ? p.SportTypeStatTypesLight : p.SportTypeStatTypesDark;
                        arrayList.add(returnStatIV(o.z(next.getT(), x0.R0(-1, App.l().getImageSources().getSourcesType().get(pVar.getmName())), Integer.valueOf(p0.s(24)), Integer.valueOf(p0.s(24)), pVar), i12, next.getV(), next.isBadge()));
                    } else {
                        arrayList.add(returnReasonTV(next.getV(), i12, true, shouldUseScroll(), shouldScrollBeUsedOverall(), false));
                    }
                }
                arrayList.add(returnEmptyView(i12));
            }
            return arrayList;
        }
        Iterator<AthleteStats> it2 = this.gameStats.getAthleteStats().iterator();
        AthleteStats athleteStats = null;
        AthleteStats athleteStats2 = null;
        while (it2.hasNext()) {
            AthleteStats next2 = it2.next();
            if (next2.getV() != null && next2.getT() != -1) {
                if (next2.isLogo() || next2.isPlayerRanking()) {
                    if (athleteStats2 == null) {
                        athleteStats2 = next2;
                    }
                } else if (athleteStats == null) {
                    athleteStats = next2;
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
            p pVar2 = x0.n1() ? p.SportTypeStatTypesLight : p.SportTypeStatTypesDark;
            arrayList.add(returnStatIV(o.z(athleteStats2.getT(), x0.R0(-1, App.l().getImageSources().getSourcesType().get(pVar2.getmName())), Integer.valueOf(p0.s(24)), Integer.valueOf(p0.s(24)), pVar2), i12, athleteStats2.getV(), athleteStats2.isBadge()));
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
                    if (!it2.hasNext()) {
                        z10 = false;
                        break;
                    }
                    AthleteStats next2 = it2.next();
                    if (next2.getT() != -1 && next2.getT() == next.getType()) {
                        arrayList.add(returnReasonTV(next2.getV(), size, true, shouldUseScroll(), shouldScrollBeUsedOverall(), x0.F2(this.sportId)));
                        z10 = true;
                        break;
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
        return this.sportId == SportTypesEnum.BASKETBALL.getValue() || this.sportId == SportTypesEnum.AMERICAN_FOOTBALL.getValue();
    }

    private boolean shouldUseScroll() {
        return shouldScrollBeUsedOverall() && this.hasPlayed;
    }

    public GameStats getGameStats() {
        return this.gameStats;
    }

    @Override // com.scores365.Design.PageObjects.c
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

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.LastMatchGameItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getSpanSize() {
        try {
            return com.scores365.Design.Activities.c.fragmentSpanSize;
        } catch (Exception unused) {
            return 1;
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public boolean isFullSpanWidthSize() {
        return true;
    }

    public boolean isHasPlayed() {
        return this.hasPlayed;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        LinearLayout linearLayout;
        final LastMatchGameItemViewHolder lastMatchGameItemViewHolder = (LastMatchGameItemViewHolder) e0Var;
        try {
            lastMatchGameItemViewHolder.dividerDark.setVisibility(8);
            if (shouldUseScroll()) {
                lastMatchGameItemViewHolder.statsContainer.setVisibility(8);
                lastMatchGameItemViewHolder.statsScrollView.setVisibility(0);
                linearLayout = lastMatchGameItemViewHolder.statsScrolledContainer;
                lastMatchGameItemViewHolder.statsScrollView.setScrollListener(this);
                this.itemPosition = i10;
            } else {
                lastMatchGameItemViewHolder.statsContainer.setVisibility(0);
                lastMatchGameItemViewHolder.statsScrollView.setVisibility(8);
                linearLayout = lastMatchGameItemViewHolder.statsContainer;
            }
            if (shouldScrollBeUsedOverall()) {
                lastMatchGameItemViewHolder.dividerDark.setVisibility(0);
                if (x0.l1()) {
                    lastMatchGameItemViewHolder.dividerDark.setRotation(180.0f);
                }
            }
            linearLayout.removeAllViews();
            if (this.hasPlayed) {
                ArrayList<LastMatchesHeaderObj> arrayList = this.headers;
                Iterator<View> it = ((arrayList == null || arrayList.isEmpty()) ? returnStatsViews(linearLayout.getLayoutParams().width, this.singleStatTypeId) : returnStatsViewsWithSpecifiedHeaders(linearLayout.getLayoutParams().width)).iterator();
                while (it.hasNext()) {
                    linearLayout.addView(it.next());
                }
            } else {
                String reason = this.gameStats.getReason();
                int injuryCategory = this.gameStats.getInjuryCategory();
                String injuryTypeImgID = this.gameStats.getInjuryTypeImgID();
                int suspensionType = this.gameStats.getSuspensionType();
                int suspensionTypeImgID = this.gameStats.getSuspensionTypeImgID();
                linearLayout.addView(returnReasonTV(reason, -1, false, shouldUseScroll(), shouldScrollBeUsedOverall(), false));
                linearLayout.addView(returnReasonIV(injuryCategory, injuryTypeImgID, suspensionType, suspensionTypeImgID));
            }
            linearLayout.setGravity(8388611);
            if (shouldUseScroll()) {
                linearLayout.getLayoutParams().width = linearLayout.getChildCount() * SCROLLED_STAT_WIDTH;
                lastMatchGameItemViewHolder.statsScrollView.invalidate();
            }
            lastMatchGameItemViewHolder.bottomNameTV.setText(this.bottomTeamName);
            lastMatchGameItemViewHolder.topNameTV.setText(this.topTeamName);
            lastMatchGameItemViewHolder.topScoreTV.setText(this.topTeamScore);
            lastMatchGameItemViewHolder.bottomScoreTV.setText(this.bottomTeamScore);
            lastMatchGameItemViewHolder.dateTV.setText(this.date);
            li.u.A(this.topTeamIconLink, lastMatchGameItemViewHolder.topTeamLogo, p0.K(R.attr.f21594w0));
            li.u.A(this.bottomTeamIconLink, lastMatchGameItemViewHolder.bottomTeamLogo, p0.K(R.attr.f21594w0));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((t) lastMatchGameItemViewHolder).itemView.getLayoutParams();
            if (this.isCollapsed) {
                marginLayoutParams.height = 0;
                marginLayoutParams.topMargin = 0;
            } else {
                marginLayoutParams.height = p0.s(44);
                marginLayoutParams.topMargin = p0.s(1);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) ((t) lastMatchGameItemViewHolder).itemView.getLayoutParams();
            if (this.singleStatTypeId != -1) {
                lastMatchGameItemViewHolder.bottomNameTV.getLayoutParams().width = p0.s(92);
                lastMatchGameItemViewHolder.topNameTV.getLayoutParams().width = p0.s(92);
                marginLayoutParams2.leftMargin = 0;
                marginLayoutParams2.rightMargin = 0;
                e1.C0(((t) lastMatchGameItemViewHolder).itemView, 0.0f);
            } else {
                lastMatchGameItemViewHolder.bottomNameTV.getLayoutParams().width = p0.s(84);
                lastMatchGameItemViewHolder.topNameTV.getLayoutParams().width = p0.s(84);
                marginLayoutParams2.leftMargin = (int) App.m().getResources().getDimension(R.dimen.f21649n);
                marginLayoutParams2.rightMargin = (int) App.m().getResources().getDimension(R.dimen.f21649n);
                e1.C0(((t) lastMatchGameItemViewHolder).itemView, p0.I(R.attr.f21600y0));
            }
            if (!shouldUseScroll() || this.scrollListener == null) {
                return;
            }
            lastMatchGameItemViewHolder.statsScrollView.post(new Runnable() { // from class: com.scores365.ui.playerCard.LastMatchGameItem.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        lastMatchGameItemViewHolder.statsScrollView.scrollTo(LastMatchGameItem.this.scrollListener.getCurrentLastMatchesScrollPosition(), 0);
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            });
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void onScrolled(int i10, int i11, int i12, int i13) {
        try {
            iScrollListener iscrolllistener = this.scrollListener;
            if (iscrolllistener != null) {
                iscrolllistener.onLastMatchHorizontalScroll(i10, this.itemPosition);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setCollapsed(boolean z10) {
        this.isCollapsed = z10;
    }

    public void setHeaders(ArrayList<LastMatchesHeaderObj> arrayList) {
        this.headers = arrayList;
    }

    public void setOutrightDialogContext(boolean z10) {
        this.isOutrightDialogContext = z10;
    }
}
