package com.scores365.gameCenter;

import ag.e1;
import ag.f1;
import ag.h1;
import ag.i0;
import ag.j1;
import ag.l1;
import ag.n1;
import ag.o1;
import ag.s1;
import ag.u1;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.branding.BrandingStripItem;
import com.scores365.entitys.PlainTitleItemWithSposored;
import com.scores365.gameCenter.GameCenterBaseActivity;
import com.scores365.ui.bettingViews.LineupOddsBrandedListItem;
import com.scores365.ui.bettingViews.LiveVSKickoffOddsBrandedListItem;
import com.scores365.ui.bettingViews.PostGameTeaserBrandedListItem;
import com.scores365.ui.items.AmericanRecentFormItem;
import com.scores365.ui.playerCard.LastMatchGameBasketballItem;
import com.scores365.ui.playerCard.LastMatchGameItem;
import com.scores365.ui.playerCard.MissedConsecutiveLastMatchsItem;
import com.scores365.ui.playerCard.ProfileTrophyItem;
import com.scores365.ui.playerCard.SeeAllTableItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import lf.d;
/* compiled from: GameCenterBaseRecyclerViewAdapter.java */
/* loaded from: classes2.dex */
public class t extends RecyclerView.h<com.scores365.Design.Pages.t> {

    /* renamed from: e  reason: collision with root package name */
    private final Hashtable<Integer, Integer> f24049e = new Hashtable<>();

    /* renamed from: f  reason: collision with root package name */
    private final WeakReference<q.e> f24050f;

    /* renamed from: g  reason: collision with root package name */
    protected WeakReference<i0.a.b> f24051g;

    /* renamed from: h  reason: collision with root package name */
    protected WeakReference<GameCenterBaseActivity.f> f24052h;

    /* renamed from: i  reason: collision with root package name */
    ArrayList<com.scores365.Design.PageObjects.b> f24053i;

    public t(ArrayList<com.scores365.Design.PageObjects.b> arrayList, q.e eVar) {
        G(arrayList);
        this.f24050f = new WeakReference<>(eVar);
    }

    public ArrayList<com.scores365.Design.PageObjects.b> A() {
        return this.f24053i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B */
    public void onBindViewHolder(@NonNull com.scores365.Design.Pages.t tVar, int i10) {
        try {
            this.f24053i.get(i10).onBindViewHolder(tVar, i10);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    @NonNull
    /* renamed from: C */
    public com.scores365.Design.Pages.t onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        com.scores365.Design.Pages.t tVar = null;
        try {
            com.scores365.Design.Pages.t tVar2 = null;
            for (Map.Entry<Integer, Integer> entry : this.f24049e.entrySet()) {
                try {
                    if (i10 == entry.getValue().intValue()) {
                        int intValue = entry.getKey().intValue();
                        if (intValue == lf.u.STATISTICS_WEB_STAT.ordinal()) {
                            tVar2 = ag.x.onCreateViewHolder(viewGroup);
                        } else if (intValue == lf.u.HEAD_TO_HEAD.ordinal()) {
                            tVar2 = ag.m.onCreateViewHolder(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.HEAD_TO_HEAD_AMERICAN.ordinal()) {
                            tVar2 = ag.l.f704j.a(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.HEAD_TO_HEAD_COLUMN_HEADER.ordinal()) {
                            tVar2 = ag.h.f597b.a(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.PlayByPlayFillerItem.ordinal()) {
                            tVar2 = ag.r0.onCreateViewHolder(viewGroup);
                        } else if (intValue == lf.u.LINEUPS_BENCH.ordinal()) {
                            tVar2 = com.scores365.gameCenter.gameCenterItems.c.m(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.LINEUPS_MISSING_PLAYER.ordinal()) {
                            tVar2 = com.scores365.gameCenter.gameCenterItems.c.m(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.LINEUPS_MISSING_PLAYER_BASKETBALL.ordinal()) {
                            tVar2 = ag.q.f829h.a(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.LINEUPS_BENCH_NEW.ordinal()) {
                            tVar2 = com.scores365.gameCenter.gameCenterItems.e.l(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.PlainTitleItem.ordinal()) {
                            tVar2 = yc.r.m(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.PlainPBPTitleItem.ordinal()) {
                            tVar2 = yc.q.f43271a.a(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.BuzzStoryItem.ordinal()) {
                            tVar2 = com.scores365.Pages.g.f21242d.a(viewGroup);
                        } else if (intValue == lf.u.StoryPagePromoItem.ordinal()) {
                            tVar2 = j1.f688c.a(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.GameLiveOddsItem.ordinal()) {
                            tVar2 = kg.a.f33277e.a(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.LiveOddsWidgetContainerItem.ordinal()) {
                            tVar2 = kg.d.f33292h.a(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.TrendBookieItem.ordinal()) {
                            tVar2 = cd.b.f10150h.a(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.PlainTitleItemWithSposored.ordinal()) {
                            tVar2 = PlainTitleItemWithSposored.onCreateViewHolder(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.SeeAllTableItem.ordinal()) {
                            tVar2 = SeeAllTableItem.onCreateViewHolder(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.MissedConsecutiveLastMatchsItem.ordinal()) {
                            tVar2 = MissedConsecutiveLastMatchsItem.onCreateViewHolder(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.LastMatchGameItem.ordinal()) {
                            tVar2 = LastMatchGameItem.onCreateViewHolder(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.LastMatchGameBasketballItem.ordinal()) {
                            tVar2 = LastMatchGameBasketballItem.onCreateViewHolderBasketball(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.LINEUPS_TEAMS_CHOOSER_ITEM.ordinal()) {
                            tVar2 = com.scores365.Design.PageObjects.e.onCreateViewHolder(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.HokeyTopPerformersItem.ordinal()) {
                            tVar2 = cg.i.f10271d.a(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.StageTitleItem.ordinal()) {
                            tVar2 = v0.f24072h.a(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.EventGroupItem.ordinal()) {
                            tVar2 = ie.c.f28661c.a(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.BaseBallEventItem.ordinal()) {
                            tVar2 = ie.b.f28655c.a(viewGroup);
                        } else if (intValue == lf.u.FootballEventItem.ordinal()) {
                            tVar2 = de.b.f25142c.a(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.AmericanRecentFormItem.ordinal()) {
                            tVar2 = AmericanRecentFormItem.Companion.onCreateViewHolder(viewGroup, this.f24050f.get());
                        } else if (intValue == lf.u.PostGamePitchersItem.ordinal()) {
                            tVar2 = ie.d.f28667c.a(viewGroup, this.f24050f.get());
                        } else {
                            lf.u uVar = lf.u.HockeyEventItem;
                            if (intValue == uVar.ordinal()) {
                                tVar2 = com.scores365.Design.PageObjects.d.f20907a.c(viewGroup, this.f24050f.get(), uVar);
                            } else {
                                lf.u uVar2 = lf.u.EmptyScoringEventItem;
                                if (intValue == uVar2.ordinal()) {
                                    tVar2 = com.scores365.Design.PageObjects.d.f20907a.c(viewGroup, this.f24050f.get(), uVar2);
                                } else {
                                    lf.u uVar3 = lf.u.EmptyPenaltyEventItem;
                                    if (intValue == uVar3.ordinal()) {
                                        tVar2 = com.scores365.Design.PageObjects.d.f20907a.c(viewGroup, this.f24050f.get(), uVar3);
                                    } else if (intValue == lf.u.StatisticsFilterItem.ordinal()) {
                                        tVar2 = h1.f603c.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.EmptyEventItem.ordinal()) {
                                        tVar2 = cg.a.f10243b.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.TopPerformerNoTabItem.ordinal()) {
                                        tVar2 = de.d.f25150g.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.HockeyStarItem.ordinal()) {
                                        tVar2 = cg.h.f10260e.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.ShotChartItem.ordinal()) {
                                        tVar2 = zh.d.f44067d.a(viewGroup);
                                    } else if (intValue == lf.u.ShotChartTabsItem.ordinal()) {
                                        tVar2 = zh.h.f44117d.a(viewGroup);
                                    } else if (intValue == lf.u.ShotChartTeamControlItem.ordinal()) {
                                        tVar2 = zh.j.f44135j.a(viewGroup);
                                    } else if (intValue == lf.u.ShotChartPlayerItem.ordinal()) {
                                        tVar2 = zh.g.f44109h.a(viewGroup);
                                    } else if (intValue == lf.u.ShotChartLineupsItem.ordinal()) {
                                        tVar2 = zh.e.f44080m.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.ExpandCollapseShotChartItem.ordinal()) {
                                        tVar2 = zh.a.f44029e.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.WinProbabilityItem.ordinal()) {
                                        tVar2 = o1.f810c.a(viewGroup);
                                    } else if (intValue == lf.u.WinProbabilityLivePostItem.ordinal()) {
                                        tVar2 = s1.f905h.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.LINEUPS_ODD_ITEM.ordinal()) {
                                        tVar2 = ag.p.l(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.GAME_CENTER_TITLE_ITEM.ordinal()) {
                                        tVar2 = ag.d0.l(viewGroup);
                                    } else if (intValue == lf.u.LINEUPS_VISUAL_ITEM.ordinal()) {
                                        tVar2 = com.scores365.gameCenter.gameCenterItems.b.t(viewGroup, this.f24050f.get(), false);
                                    } else if (intValue == lf.u.WHO_WILL_WIN.ordinal()) {
                                        tVar2 = xf.q.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.ImprovedWWWItem.ordinal()) {
                                        tVar2 = xf.g.f42357i.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.ImprovedWWWInnerItem.ordinal()) {
                                        tVar2 = xf.f.f42333e.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.RESULT_SECTION.ordinal()) {
                                        tVar2 = xf.j.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.INFO_SECTION_ANONYMOUS.ordinal()) {
                                        tVar2 = xf.c.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.TABLES.ordinal()) {
                                        tVar2 = xf.o.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.LIVE_TRACKER.ordinal()) {
                                        tVar2 = xf.b.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.VIDEO_ITEM.ordinal()) {
                                        tVar2 = ag.e0.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.VIDEO_TITLE_ITEM.ordinal()) {
                                        tVar2 = xf.s.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.PLAYER_STATISTICS_HEADER.ordinal()) {
                                        tVar2 = com.scores365.gameCenter.gameCenterItems.g.l(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.ScoreBoxToggleItem.ordinal()) {
                                        tVar2 = e1.l(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.GameCenterScoreBox.ordinal()) {
                                        tVar2 = ag.v.p(viewGroup);
                                    } else if (intValue == lf.u.GameCenterScoreBoxEmptyTextItem.ordinal()) {
                                        tVar2 = ag.w.f1037b.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.ScoreBoxExtraDataTitleItem.ordinal()) {
                                        tVar2 = ag.d1.f511c.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.ScoreBoxExtraDataRowItem.ordinal()) {
                                        tVar2 = ag.c1.f500c.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.ScoreBoxExtraDataRowFillerItem.ordinal()) {
                                        tVar2 = ag.b1.f472a.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.ProfileTropyItem.ordinal()) {
                                        tVar2 = ProfileTrophyItem.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.SCORE_BOX.ordinal()) {
                                        tVar2 = xf.k.m(viewGroup);
                                    } else if (intValue == lf.u.GameCenterScoreboardItem.ordinal()) {
                                        tVar2 = xf.n.f42407b.b(viewGroup);
                                    } else if (intValue == lf.u.HOCKY_EMPTY_STATUS.ordinal()) {
                                        tVar2 = xf.t.l(viewGroup);
                                    } else if (intValue == lf.u.CRICKET_WICKETS.ordinal()) {
                                        tVar2 = xf.r.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.CRICKET_BATSMEN.ordinal()) {
                                        tVar2 = xf.d.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.A_FOOTBALL_EMPTY_STATUS.ordinal()) {
                                        tVar2 = xf.a.l(viewGroup);
                                    } else if (intValue == lf.u.GeneralNativeAd.ordinal()) {
                                        tVar2 = lf.d.m(viewGroup, this.f24050f.get(), false);
                                    } else if (intValue == lf.u.BuzzNativeAd.ordinal()) {
                                        tVar2 = lf.d.m(viewGroup, this.f24050f.get(), false);
                                    } else if (intValue == lf.u.emptyInjuredAndSuspendedPlaers.ordinal()) {
                                        tVar2 = ag.d.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.mpuAdItem.ordinal()) {
                                        tVar2 = cc.q0.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.Game_Info_V2.ordinal()) {
                                        tVar2 = xf.i.f42375b.a(viewGroup);
                                    } else if (intValue == lf.u.STATISTICS_TITLE.ordinal()) {
                                        tVar2 = ag.b0.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.STATISTICS_PROGRESS_BAR.ordinal()) {
                                        tVar2 = ag.a0.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.STATISTICS_POSSESSION_CIRCLE.ordinal()) {
                                        tVar2 = ag.z.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.HIGHLIGHT_ITEM.ordinal()) {
                                        tVar2 = ag.n.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.GAME_EVENT_ITEM.ordinal()) {
                                        tVar2 = ag.g.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.GAME_RUGBY_EVENT_ITEM.ordinal()) {
                                        tVar2 = ag.t.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.GAME_EVENT_FILTER.ordinal()) {
                                        tVar2 = ag.f.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.EVENTS_TITLE.ordinal()) {
                                        tVar2 = yf.b.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.EVENTS_CLOCK.ordinal()) {
                                        tVar2 = ag.e.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.GAME_CENTER_H2H_TITLE_ITEM.ordinal()) {
                                        tVar2 = ag.k.n(viewGroup);
                                    } else if (intValue == lf.u.HEAD_TO_HEAD_SHOW_MORE.ordinal()) {
                                        tVar2 = ag.j.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.PREVIOUS_GAMES_CARD.ordinal()) {
                                        tVar2 = ag.s.l(viewGroup);
                                    } else if (intValue == lf.u.HEAD_TO_HEAD_EXPAND_CARD.ordinal()) {
                                        tVar2 = ag.i.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.InsightInPlayItem.ordinal()) {
                                        tVar2 = ag.i0.l(viewGroup, this.f24051g.get());
                                    } else if (intValue == lf.u.newsTitle.ordinal()) {
                                        tVar2 = xc.i.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.NewsCenterRelated.ordinal()) {
                                        tVar2 = nf.b.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.PlaylistItem.ordinal()) {
                                        tVar2 = nf.b.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.Buzz_Trend.ordinal()) {
                                        tVar2 = yf.a.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.Video_Highlight.ordinal()) {
                                        tVar2 = yf.c.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.SEE_ALL.ordinal()) {
                                        tVar2 = f1.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.postGameTeaser.ordinal()) {
                                        tVar2 = ag.a1.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.ODDS_STRIP_18.ordinal()) {
                                        tVar2 = ld.e.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (((App) App.m()).i().J() && intValue == lf.u.tipsterGameCenterPromotionItem.ordinal()) {
                                        tVar2 = gi.k.l(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.oddsComparison.ordinal()) {
                                        tVar2 = xf.u.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.brandingStripItem.ordinal()) {
                                        tVar2 = BrandingStripItem.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.BannerStripItem.ordinal()) {
                                        tVar2 = gc.j.f26997b.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.followingEntityTitleItem.ordinal()) {
                                        tVar2 = ze.n.l(viewGroup);
                                    } else if (intValue == lf.u.followingEntityItem.ordinal()) {
                                        tVar2 = ze.m.v(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.recentSearchItem.ordinal()) {
                                        tVar2 = com.scores365.Design.PageObjects.a.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.recentSearchEmptyItem.ordinal()) {
                                        tVar2 = gf.g.l(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.recentSearchSubItem.ordinal()) {
                                        tVar2 = gf.i.l(viewGroup);
                                    } else if (intValue == lf.u.viewAllPopularEntitiesItem.ordinal()) {
                                        tVar2 = gf.k.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.WatchOnlineStrip2.ordinal()) {
                                        tVar2 = ag.g0.l(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.WatchOnlineBet3652.ordinal()) {
                                        tVar2 = ag.f0.l(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.TopPerformerItemTitle.ordinal()) {
                                        tVar2 = xf.e0.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.TopPerformerItem.ordinal()) {
                                        tVar2 = xf.a0.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.TopPerformerLayout2Item.ordinal()) {
                                        tVar2 = xf.d0.f42283s.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.TopPerformerLayout2ChooserItem.ordinal()) {
                                        tVar2 = xf.z.f42642a.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.LineupsCompetitionStatsNameItem.ordinal()) {
                                        tVar2 = ag.k0.l(viewGroup);
                                    } else if (intValue == lf.u.generalChooserItem.ordinal()) {
                                        tVar2 = com.scores365.Design.PageObjects.e.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.TabSelectorItem.ordinal()) {
                                        tVar2 = xf.y.f42624h.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.PlayByPlayEvent.ordinal()) {
                                        tVar2 = com.scores365.gameCenter.gameCenterItems.f.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.PlayByPlayGameItem.ordinal()) {
                                        tVar2 = ag.s0.f880f.b(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.PlayByPlayHeaderGameItem.ordinal()) {
                                        tVar2 = ag.t0.f927a.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.PlayByPlayAFootballDriveItem.ordinal()) {
                                        tVar2 = ag.n0.f763e.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.PlayByPlayAFootballMessageItem.ordinal()) {
                                        tVar2 = ag.p0.f819e.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.PlayByPlayHockeyExpandableItem.ordinal()) {
                                        tVar2 = ag.w0.f1040d.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.PlayByPlayHockeyStaticItem.ordinal()) {
                                        tVar2 = ag.x0.f1060c.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.PBPBetRadarItem.ordinal()) {
                                        tVar2 = xf.v.f42598m.b(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.PlayByPlayFact.ordinal()) {
                                        tVar2 = ag.q0.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.gameCenterStatsBrandItem.ordinal()) {
                                        tVar2 = ag.y.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.RankingToggleBtnItem.ordinal()) {
                                        tVar2 = t0.l(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.EgameLiveStreamItem.ordinal()) {
                                        tVar2 = ag.c.o(viewGroup);
                                    } else if (intValue == lf.u.YouTubePlayerItem.ordinal()) {
                                        WeakReference<GameCenterBaseActivity.f> weakReference = this.f24052h;
                                        tVar2 = u1.o(viewGroup, weakReference != null ? weakReference.get() : null);
                                    } else if (intValue == lf.u.pagingProgressBarItem.ordinal()) {
                                        tVar2 = com.scores365.Design.PageObjects.g.l(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.TrendsWidgetTitleItem.ordinal()) {
                                        tVar2 = n1.f776l.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.TrendCalculationDialogItem.ordinal()) {
                                        tVar2 = cd.c.f10161c.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.TrendRowItem.ordinal()) {
                                        tVar2 = cd.h.f10191m.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.TrendCompetitorTitleItem.ordinal()) {
                                        tVar2 = cd.e.f10182c.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.NoInjuriesAndSuspensionsItem.ordinal()) {
                                        tVar2 = ag.l0.f722a.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.PointDeductionTitleItem.ordinal()) {
                                        tVar2 = of.h.f36200a.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.PointDeductionRowItem.ordinal()) {
                                        tVar2 = of.g.f36192d.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.TitleItem.ordinal()) {
                                        tVar2 = of.r.f36275h.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.ChampionByKnockoutItem.ordinal()) {
                                        tVar2 = we.a.f41334g.a(viewGroup);
                                    } else if (intValue == lf.u.OddsTestItem.ordinal()) {
                                        tVar2 = sg.a.f39190a.a(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.LineupsOddsBrandedListItem.ordinal()) {
                                        tVar2 = LineupOddsBrandedListItem.Companion.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.LiveVSKickoffOddsBrandedListItem.ordinal()) {
                                        tVar2 = LiveVSKickoffOddsBrandedListItem.Companion.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.PostGameTeaserBrandedListItem.ordinal()) {
                                        tVar2 = PostGameTeaserBrandedListItem.Companion.onCreateViewHolder(viewGroup);
                                    } else if (intValue == lf.u.CurrentTennisGamePoints.ordinal()) {
                                        tVar2 = ag.b.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.TennisH2HSurfaceChooserItem.ordinal()) {
                                        tVar2 = l1.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.TitleWithCardItem.ordinal()) {
                                        tVar2 = b1.l(viewGroup);
                                    } else if (intValue == lf.u.TennisSetChooserItem.ordinal()) {
                                        tVar2 = a1.onCreateViewHolder(viewGroup, this.f24050f.get());
                                    } else if (intValue == lf.u.BoostItem.ordinal()) {
                                        tVar2 = le.k.f34255h.a(viewGroup, this.f24050f.get());
                                    }
                                }
                            }
                        }
                        if (tVar2 != null) {
                            break;
                        }
                    }
                } catch (Exception e10) {
                    e = e10;
                    tVar = tVar2;
                    li.x0.N1(e);
                    return tVar;
                }
            }
            if (tVar2 != null && tVar2.itemView != null && !tVar2.isSupportRTL()) {
                androidx.core.view.e1.I0(tVar2.itemView, 0);
            }
            return tVar2 == null ? yc.r.m(viewGroup, null) : tVar2;
        } catch (Exception e11) {
            e = e11;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: D */
    public void onViewDetachedFromWindow(@NonNull com.scores365.Design.Pages.t tVar) {
        try {
            super.onViewDetachedFromWindow(tVar);
            if (!(tVar instanceof d.b) || ((d.b) tVar).l() == null) {
                return;
            }
            ((d.b) tVar).l().f();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public void E(ArrayList<com.scores365.Design.PageObjects.b> arrayList) {
        this.f24053i.clear();
        this.f24053i.addAll(arrayList);
        H();
    }

    public void F(GameCenterBaseActivity.f fVar) {
        this.f24052h = new WeakReference<>(fVar);
    }

    public void G(ArrayList<com.scores365.Design.PageObjects.b> arrayList) {
        this.f24053i = arrayList;
        H();
    }

    public void H() {
        try {
            int size = this.f24049e.size();
            Iterator<com.scores365.Design.PageObjects.b> it = this.f24053i.iterator();
            while (it.hasNext()) {
                int objectTypeNum = it.next().getObjectTypeNum();
                if (!this.f24049e.containsKey(Integer.valueOf(objectTypeNum))) {
                    this.f24049e.put(Integer.valueOf(objectTypeNum), Integer.valueOf(size));
                    size++;
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = this.f24053i;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i10) {
        com.scores365.Design.PageObjects.b bVar;
        try {
            ArrayList<com.scores365.Design.PageObjects.b> arrayList = this.f24053i;
            if (arrayList == null || arrayList.size() <= i10 || (bVar = this.f24053i.get(i10)) == null || !this.f24049e.containsKey(Integer.valueOf(bVar.getObjectTypeNum()))) {
                return 0;
            }
            return this.f24049e.get(Integer.valueOf(bVar.getObjectTypeNum())).intValue();
        } catch (Exception e10) {
            li.x0.N1(e10);
            return 0;
        }
    }

    public com.scores365.Design.PageObjects.b z(int i10) {
        try {
            if (this.f24053i.size() > i10) {
                return this.f24053i.get(i10);
            }
            return null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }
}
