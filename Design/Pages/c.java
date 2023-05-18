package com.scores365.Design.Pages;

import ag.b1;
import ag.c0;
import ag.c1;
import ag.d0;
import ag.d1;
import ag.f1;
import ag.h1;
import ag.i0;
import ag.j1;
import ag.k0;
import ag.l1;
import ag.m0;
import ag.n0;
import ag.n1;
import ag.o1;
import ag.p0;
import ag.r0;
import ag.s0;
import ag.s1;
import ag.t0;
import ag.w0;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.e1;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cc.q0;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Monetization.Stc.CompareGameCenterTableItem;
import com.scores365.Monetization.Stc.CompareScoresItem;
import com.scores365.Monetization.Stc.CompareWhoWillWinItem;
import com.scores365.branding.BrandingStripItem;
import com.scores365.dashboardEntities.dashboardScores.d;
import com.scores365.dashboardEntities.dashboardScores.k;
import com.scores365.entitys.ComparePageSquadItem;
import com.scores365.entitys.PlainTitleItemWithSposored;
import com.scores365.entitys.RecentlyWonPersonalTrophyItem;
import com.scores365.gameCenter.a1;
import com.scores365.gameCenter.v0;
import com.scores365.ui.bettingViews.GameLiveOddsBrandedListItem;
import com.scores365.ui.bettingViews.LineupOddsBrandedListItem;
import com.scores365.ui.bettingViews.LiveVSKickoffOddsBrandedListItem;
import com.scores365.ui.bettingViews.PostGameTeaserBrandedListItem;
import com.scores365.ui.playerCard.ExapndCollapsePlayerProfileItem;
import com.scores365.ui.playerCard.InjurySuspensionStatusItem;
import com.scores365.ui.playerCard.LastMatchGameBasketballItem;
import com.scores365.ui.playerCard.LastMatchGameItem;
import com.scores365.ui.playerCard.LastMatchesTitleItem;
import com.scores365.ui.playerCard.MissedConsecutiveLastMatchsItem;
import com.scores365.ui.playerCard.PlayerCardNextGameItem;
import com.scores365.ui.playerCard.PlayerCardProfileStatsItem;
import com.scores365.ui.playerCard.PlayerDetailsItem;
import com.scores365.ui.playerCard.PlayerLastMatchExpandItem;
import com.scores365.ui.playerCard.PlayerTransferHistoryItem;
import com.scores365.ui.playerCard.PlayerTrophiesCompetitionSelectorFillerItem;
import com.scores365.ui.playerCard.PlayerTrophiesCompetitionSelectorItem;
import com.scores365.ui.playerCard.PlayerTrophiesCompetitionSingleItem;
import com.scores365.ui.playerCard.PlayerTrophiesTitleIconsItem;
import com.scores365.ui.playerCard.PlayerTrophyItem;
import com.scores365.ui.playerCard.ProfileTrophyItem;
import com.scores365.ui.playerCard.SeeAllTableItem;
import com.scores365.ui.playerCard.SinglePlayerOverallStatsItem;
import com.scores365.ui.playerCard.SinglePlayerStatsCompetitionSelectorSubItem;
import com.scores365.ui.playerCard.SocialStatItem;
import com.scores365.ui.settings.NewsSourceItem;
import com.scores365.ui.settings.SelectLangItem;
import com.scores365.ui.settings.SelectNewsLangItem;
import com.scores365.ui.settings.SelectSportTypeItem;
import com.scores365.ui.swipe.SwipeableViewHolder;
import gi.a0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import lf.d;
import li.x0;
import se.e0;
import se.f0;
import se.g0;
import se.j0;
/* compiled from: BaseRecyclerAdapter.java */
/* loaded from: classes2.dex */
public class c extends RecyclerView.h<RecyclerView.e0> {

    /* renamed from: e  reason: collision with root package name */
    public Hashtable<Integer, Integer> f20953e = new Hashtable<>();

    /* renamed from: f  reason: collision with root package name */
    protected ArrayList<com.scores365.Design.PageObjects.b> f20954f;

    /* renamed from: g  reason: collision with root package name */
    protected WeakReference<q.e> f20955g;

    /* renamed from: h  reason: collision with root package name */
    protected WeakReference<i0.a.b> f20956h;

    /* renamed from: i  reason: collision with root package name */
    private int f20957i;

    /* renamed from: j  reason: collision with root package name */
    private String f20958j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f20959k;

    /* renamed from: l  reason: collision with root package name */
    int f20960l;

    /* compiled from: BaseRecyclerAdapter.java */
    /* loaded from: classes2.dex */
    public interface a {
        void onViewHolderAttached();
    }

    public c(ArrayList<com.scores365.Design.PageObjects.b> arrayList, q.e eVar) {
        H(arrayList);
        this.f20955g = new WeakReference<>(eVar);
        setHasStableIds(true);
    }

    public com.scores365.Design.PageObjects.b A(int i10) {
        if (i10 < 0) {
            return null;
        }
        try {
            ArrayList<com.scores365.Design.PageObjects.b> arrayList = this.f20954f;
            if (arrayList == null || arrayList.size() <= i10) {
                return null;
            }
            return this.f20954f.get(i10);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public ArrayList<com.scores365.Design.PageObjects.b> B() {
        return this.f20954f;
    }

    public int C() {
        return 0;
    }

    public void D(int i10, String str, boolean z10) {
        this.f20957i = i10;
        this.f20958j = str;
        this.f20959k = z10;
    }

    public void E(i0.a.b bVar) {
        this.f20956h = new WeakReference<>(bVar);
    }

    public void G(int i10) {
        this.f20960l = i10;
    }

    public void H(ArrayList<com.scores365.Design.PageObjects.b> arrayList) {
        this.f20954f = arrayList;
        I();
    }

    public void I() {
        try {
            int size = this.f20953e.size();
            Iterator<com.scores365.Design.PageObjects.b> it = this.f20954f.iterator();
            while (it.hasNext()) {
                int objectTypeNum = it.next().getObjectTypeNum();
                if (!this.f20953e.containsKey(Integer.valueOf(objectTypeNum))) {
                    this.f20953e.put(Integer.valueOf(objectTypeNum), Integer.valueOf(size));
                    size++;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = this.f20954f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public long getItemId(int i10) {
        try {
            ArrayList<com.scores365.Design.PageObjects.b> arrayList = this.f20954f;
            return (arrayList == null || arrayList.size() <= i10 || this.f20954f.get(i10) == null) ? new Random().nextLong() : this.f20954f.get(i10).hashCode();
        } catch (Exception e10) {
            x0.N1(e10);
            return 0L;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i10) {
        com.scores365.Design.PageObjects.b bVar;
        int i11 = 0;
        try {
            ArrayList<com.scores365.Design.PageObjects.b> arrayList = this.f20954f;
            if (arrayList != null && arrayList.size() > i10 && this.f20953e != null && (bVar = this.f20954f.get(i10)) != null) {
                if (bVar.getItemViewType() != -1) {
                    i11 = bVar.getItemViewType();
                } else if (this.f20953e.containsKey(Integer.valueOf(bVar.getObjectTypeNum()))) {
                    i11 = this.f20953e.get(Integer.valueOf(bVar.getObjectTypeNum())).intValue();
                    bVar.setItemViewType(i11);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            this.f20954f.get(i10).onBindViewHolder(e0Var, i10);
            if (e0Var.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.c) {
                ((StaggeredGridLayoutManager.c) e0Var.itemView.getLayoutParams()).l(this.f20954f.get(i10).isFullSpanWidthSize());
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        RecyclerView.e0 e0Var = null;
        try {
            Hashtable<Integer, Integer> hashtable = this.f20953e;
            if (hashtable != null) {
                RecyclerView.e0 e0Var2 = null;
                for (Map.Entry<Integer, Integer> entry : hashtable.entrySet()) {
                    try {
                        if (i10 == entry.getValue().intValue()) {
                            int intValue = entry.getKey().intValue();
                            if (intValue == lf.u.Highlight.ordinal()) {
                                e0Var2 = lf.f.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.Social.ordinal()) {
                                e0Var2 = lf.i.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.Squad.ordinal()) {
                                e0Var2 = lf.j.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.compareSquadItem.ordinal()) {
                                e0Var2 = ComparePageSquadItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.SquadSection.ordinal()) {
                                e0Var2 = lf.p.onCreateViewHolder(viewGroup);
                            } else if (intValue == lf.u.Squads.ordinal()) {
                                e0Var2 = lf.m.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.TransferWithVote.ordinal()) {
                                e0Var2 = lf.o.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.TransferSection.ordinal()) {
                                e0Var2 = lf.r.onCreateViewHolder(viewGroup);
                            } else if (intValue == lf.u.PlainPBPTitleItem.ordinal()) {
                                e0Var2 = yc.q.f43271a.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.PlayByPlayGameItem.ordinal()) {
                                e0Var2 = s0.f880f.b(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.BuzzStoryItem.ordinal()) {
                                e0Var2 = com.scores365.Pages.g.f21242d.a(viewGroup);
                            } else if (intValue == lf.u.StoryPagePromoItem.ordinal()) {
                                e0Var2 = j1.f688c.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.GeneralNativeAd.ordinal()) {
                                e0Var2 = lf.d.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.BuzzNativeAd.ordinal()) {
                                e0Var2 = lf.d.m(viewGroup, this.f20955g.get(), false);
                            } else if (intValue == lf.u.TransfersNativeAd.ordinal()) {
                                e0Var2 = lf.q.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.HockeyStarItem.ordinal()) {
                                e0Var2 = cg.h.f10260e.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.CompetitionDetailsHostsDialogItem.ordinal()) {
                                e0Var2 = se.j.f38879b.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.CompetitionDetailsTopTeamItem.ordinal()) {
                                e0Var2 = se.t.f39045b.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.CompetitionDetailsTopTeamAvgItem.ordinal()) {
                                e0Var2 = se.s.f39040c.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.ShotChartItem.ordinal()) {
                                e0Var2 = zh.d.f44067d.a(viewGroup);
                            } else if (intValue == lf.u.ShotChartTabsItem.ordinal()) {
                                e0Var2 = zh.h.f44117d.a(viewGroup);
                            } else if (intValue == lf.u.ShotChartTeamControlItem.ordinal()) {
                                e0Var2 = zh.j.f44135j.a(viewGroup);
                            } else if (intValue == lf.u.ShotChartPlayerItem.ordinal()) {
                                e0Var2 = zh.g.f44109h.a(viewGroup);
                            } else if (intValue == lf.u.ShotChartLineupsItem.ordinal()) {
                                e0Var2 = zh.e.f44080m.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.ExpandCollapseShotChartItem.ordinal()) {
                                e0Var2 = zh.a.f44029e.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.TopPerformerNoTabItem.ordinal()) {
                                e0Var2 = de.d.f25150g.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.HokeyTopPerformersItem.ordinal()) {
                                e0Var2 = cg.i.f10271d.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.ShotChartPopupItem.ordinal()) {
                                e0Var2 = zb.q.f43705g.b(viewGroup);
                            } else if (intValue == lf.u.StageTitleItem.ordinal()) {
                                e0Var2 = v0.f24072h.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.EventGroupItem.ordinal()) {
                                e0Var2 = ie.c.f28661c.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.BaseBallEventItem.ordinal()) {
                                e0Var2 = ie.b.f28655c.a(viewGroup);
                            } else if (intValue == lf.u.FootballEventItem.ordinal()) {
                                e0Var2 = de.b.f25142c.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.EmptyEventItem.ordinal()) {
                                e0Var2 = cg.a.f10243b.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.PostGamePitchersItem.ordinal()) {
                                e0Var2 = ie.d.f28667c.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.ScoresSection.ordinal()) {
                                e0Var2 = com.scores365.dashboardEntities.dashboardScores.m.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.ProfileTropyItem.ordinal()) {
                                e0Var2 = ProfileTrophyItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.LiveGame.ordinal()) {
                                e0Var2 = com.scores365.dashboardEntities.dashboardScores.k.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.Game.ordinal()) {
                                e0Var2 = com.scores365.dashboardEntities.dashboardScores.g.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.GameWithTVChannel.ordinal()) {
                                e0Var2 = com.scores365.dashboardEntities.dashboardScores.h.f23453b.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.DivSoccerGameItem.ordinal()) {
                                e0Var2 = zd.a.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.GameWithWwwNewOdds.ordinal()) {
                                e0Var2 = sg.d.Companion.f(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.PlayerCardNextGameItem.ordinal()) {
                                e0Var2 = PlayerCardNextGameItem.Companion.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.FeaturedMatchItem.ordinal()) {
                                e0Var2 = e0.f38818e.b(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.FeaturedMatchWithAddonItem.ordinal()) {
                                e0Var2 = ve.b.f40729h.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.SEE_ALL.ordinal()) {
                                e0Var2 = f1.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.GameTennisLive.ordinal()) {
                                e0Var2 = com.scores365.dashboardEntities.dashboardScores.n.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.GameAllScoresTennisLive.ordinal()) {
                                e0Var2 = com.scores365.dashboardEntities.dashboardScores.a.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.noItems.ordinal()) {
                                e0Var2 = com.scores365.dashboardEntities.dashboardScores.c.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.ScoresNativeAd.ordinal()) {
                                e0Var2 = com.scores365.dashboardEntities.dashboardScores.l.onCreateViewHolder(viewGroup);
                            } else if (intValue == lf.u.WinProbabilityItem.ordinal()) {
                                e0Var2 = o1.f810c.a(viewGroup);
                            } else if (intValue == lf.u.WinProbabilityLivePostItem.ordinal()) {
                                e0Var2 = s1.f905h.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.ScoresBannerAdItem.ordinal()) {
                                e0Var2 = com.scores365.dashboardEntities.dashboardScores.d.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.NETFLIX_SCORES_ITEM.ordinal()) {
                                e0Var2 = CompareScoresItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.mpuAdItem.ordinal()) {
                                e0Var2 = q0.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.allScoresMpuAdItem.ordinal()) {
                                e0Var2 = cc.w.f10104g.a(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.ScoresItemTitle.ordinal()) {
                                e0Var2 = com.scores365.dashboardEntities.dashboardScores.j.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.newsWebView.ordinal()) {
                                e0Var2 = xc.j.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.NewsBigImage.ordinal()) {
                                e0Var2 = nf.a.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.NewsCenterRelated.ordinal()) {
                                e0Var2 = nf.b.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.PlaylistItem.ordinal()) {
                                e0Var2 = ob.b.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.NewsSmallRtl.ordinal()) {
                                e0Var2 = nf.e.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.NewsSmallLtr.ordinal()) {
                                e0Var2 = nf.d.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.SingleNewsTitle.ordinal()) {
                                e0Var2 = xc.l.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.NewsCenterImageItem.ordinal()) {
                                e0Var2 = xc.h.onCreateViewHolder(viewGroup);
                            } else if (intValue == lf.u.SingleNewsContent.ordinal()) {
                                e0Var2 = xc.k.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.newsTitle.ordinal()) {
                                e0Var2 = xc.i.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.showMoreFixtureItem.ordinal()) {
                                e0Var2 = id.e.l(viewGroup);
                            } else if (intValue == lf.u.TournamentStageItem.ordinal()) {
                                e0Var2 = zd.b.onCreateViewHolder(viewGroup, this.f20955g.get());
                            } else if (intValue == lf.u.GameCenterScoreBox.ordinal()) {
                                e0Var2 = ag.v.p(viewGroup);
                            } else {
                                lf.u uVar = lf.u.ScoreBoxExtraDataTitleItem;
                                if (intValue == uVar.ordinal()) {
                                    e0Var2 = d1.f511c.a(viewGroup, this.f20955g.get());
                                } else {
                                    lf.u uVar2 = lf.u.ScoreBoxExtraDataRowItem;
                                    if (intValue == uVar2.ordinal()) {
                                        e0Var2 = c1.f500c.a(viewGroup, this.f20955g.get());
                                    } else {
                                        lf.u uVar3 = lf.u.ScoreBoxExtraDataRowFillerItem;
                                        if (intValue == uVar3.ordinal()) {
                                            e0Var2 = b1.f472a.a(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.GameCenterScoreBoxEmptyTextItem.ordinal()) {
                                            e0Var2 = ag.w.f1037b.a(viewGroup, this.f20955g.get());
                                        } else if (intValue == uVar.ordinal()) {
                                            e0Var2 = d1.f511c.a(viewGroup, this.f20955g.get());
                                        } else if (intValue == uVar2.ordinal()) {
                                            e0Var2 = c1.f500c.a(viewGroup, this.f20955g.get());
                                        } else if (intValue == uVar3.ordinal()) {
                                            e0Var2 = b1.f472a.a(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.rightMenuNotificationItem.ordinal()) {
                                            e0Var2 = bf.d.m(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.rightMenuNotificationSelectAllItem.ordinal()) {
                                            e0Var2 = bf.f.m(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.rightMenuNotificationCategoryItem.ordinal()) {
                                            e0Var2 = bf.b.l(viewGroup);
                                        } else if (intValue == lf.u.Knockout.ordinal()) {
                                            e0Var2 = qf.f.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.SemiFinal.ordinal()) {
                                            e0Var2 = qf.e.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.FinalSingleGame.ordinal()) {
                                            e0Var2 = qf.b.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.FinalDoubleGame.ordinal()) {
                                            e0Var2 = qf.a.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.TournamentCompetitorItem.ordinal()) {
                                            e0Var2 = ii.b.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.GroupsDateItem.ordinal()) {
                                            e0Var2 = of.c.l(viewGroup);
                                        } else if (intValue == lf.u.GroupsGameItem.ordinal()) {
                                            e0Var2 = of.f.l(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.INFO_SECTION_ANONYMOUS.ordinal()) {
                                            e0Var2 = xf.c.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.GAME_CENTER_TITLE_ITEM.ordinal()) {
                                            e0Var2 = d0.l(viewGroup);
                                        } else if (intValue == lf.u.BuzzNewDesign.ordinal()) {
                                            e0Var2 = mf.b.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.BuzzVideoNewDesign.ordinal()) {
                                            e0Var2 = mf.c.r(viewGroup, this.f20955g.get(), this.f20957i, this.f20958j, this.f20959k);
                                        } else if (intValue == lf.u.soundItem.ordinal()) {
                                            e0Var2 = bf.i.l(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.Game_Info_V2.ordinal()) {
                                            e0Var2 = xf.i.f42375b.a(viewGroup);
                                        } else if (intValue == lf.u.bracketsSummaryItem.ordinal()) {
                                            e0Var2 = qe.e.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.bracketsGameItem.ordinal()) {
                                            e0Var2 = qe.c.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.bracketsConclusionItem.ordinal()) {
                                            e0Var2 = qe.a.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.BracketsSoccerAggregateItem.ordinal()) {
                                            e0Var2 = qe.d.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.StandingsFooter.ordinal()) {
                                            e0Var2 = of.i.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.InsightInPlayItem.ordinal()) {
                                            WeakReference<i0.a.b> weakReference = this.f20956h;
                                            e0Var2 = i0.l(viewGroup, weakReference == null ? null : weakReference.get());
                                        } else if (intValue == lf.u.Video_Highlight.ordinal()) {
                                            e0Var2 = yf.c.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.Buzz_Trend.ordinal()) {
                                            e0Var2 = yf.a.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.ODDS_STRIP_18.ordinal()) {
                                            e0Var2 = ld.e.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.comparePreviousMeetings.ordinal()) {
                                            e0Var2 = ag.s.l(viewGroup);
                                        } else if (intValue == lf.u.compareRecentForm.ordinal()) {
                                            e0Var2 = xf.j.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.compareTableItem.ordinal()) {
                                            e0Var2 = CompareGameCenterTableItem.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.comparePredictoinItem.ordinal()) {
                                            e0Var2 = CompareWhoWillWinItem.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.tipsterHeaderItem.ordinal()) {
                                            e0Var2 = gi.n.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.tipsterDateItem.ordinal()) {
                                            e0Var2 = gi.f.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.tipsterBigGameViewItem.ordinal()) {
                                            e0Var2 = gi.c.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.tipsterAwaitingItem.ordinal()) {
                                            e0Var2 = gi.b.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.tipsterGetTipButton.ordinal()) {
                                            e0Var2 = gi.m.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.TipsterBuyTipsItem.ordinal()) {
                                            e0Var2 = gi.e.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.TipsterDetailsItem.ordinal()) {
                                            e0Var2 = gi.g.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.TipsterFreeOrSingleOrWeeklyItem.ordinal()) {
                                            e0Var2 = gi.j.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.TipsterPersuasionItem.ordinal()) {
                                            e0Var2 = gi.r.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.TipsterManageSubscriptionItem.ordinal()) {
                                            e0Var2 = gi.y.f27426a.a(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.ODDS_LINE.ordinal()) {
                                            e0Var2 = ld.d.n(viewGroup);
                                        } else if (intValue == lf.u.tipsterSubscriptionItem.ordinal()) {
                                            e0Var2 = gi.x.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.tipsterEulaItem.ordinal()) {
                                            e0Var2 = gi.i.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.tipsterGameItem.ordinal()) {
                                            e0Var2 = gi.l.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.tipsterTipItem.ordinal()) {
                                            e0Var2 = a0.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.tipsterDoubleTipItem.ordinal()) {
                                            e0Var2 = gi.h.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.tipsterOddsItem.ordinal()) {
                                            e0Var2 = gi.p.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.tipsterPostGameTipItem.ordinal()) {
                                            e0Var2 = gi.s.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.tipsterLongTextItem.ordinal()) {
                                            e0Var2 = gi.o.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.tipsterBoldTitleItem.ordinal()) {
                                            e0Var2 = gi.d.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.tipsterRecommendationButton.ordinal()) {
                                            e0Var2 = gi.u.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.tipsterOutcom.ordinal()) {
                                            e0Var2 = gi.q.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.tipsterCurentItem.ordinal()) {
                                            e0Var2 = gi.t.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.tipsterGameCenterPromotionItem.ordinal() && ((App) App.m()).i().J()) {
                                            e0Var2 = gi.k.l(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.tipsterBlueButtonItem.ordinal()) {
                                            e0Var2 = gi.v.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.tipsterSubscriptionSaveMoneyItem.ordinal()) {
                                            e0Var2 = gi.z.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.FoodListItem.ordinal()) {
                                            e0Var2 = ei.a.m(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.WorldCupNativeListItem.ordinal()) {
                                            e0Var2 = ei.d.n(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.StadiumListItem.ordinal()) {
                                            e0Var2 = ei.b.m(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.TeamsListItem.ordinal()) {
                                            e0Var2 = ei.c.m(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.WorldCupStadiumNativeListItem.ordinal()) {
                                            e0Var2 = ei.e.n(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.followingEntityTitleItem.ordinal()) {
                                            e0Var2 = ze.n.l(viewGroup);
                                        } else if (intValue == lf.u.recentSearchesTitleItem.ordinal()) {
                                            e0Var2 = ze.l.l(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.followingEntityItem.ordinal()) {
                                            e0Var2 = ze.m.v(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.FollowItem.ordinal()) {
                                            e0Var2 = ze.b.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.FollowTitleItem.ordinal()) {
                                            e0Var2 = ze.i.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.FollowingEmptyItem.ordinal()) {
                                            e0Var2 = ze.f.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.FollowItemsContainer.ordinal()) {
                                            e0Var2 = ze.c.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.FollowObjsTabsItem.ordinal()) {
                                            e0Var2 = ze.d.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.FollowPlaceholderItem.ordinal()) {
                                            e0Var2 = ze.e.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.NotificationEntityItem.ordinal()) {
                                            e0Var2 = bf.c.l(viewGroup, this.f20955g.get(), this);
                                        } else if (intValue == lf.u.EntityNotificationTitleItem.ordinal()) {
                                            e0Var2 = bf.a.l(viewGroup, this.f20955g.get(), this);
                                        } else if (intValue == lf.u.MyScoresCategoryItem.ordinal()) {
                                            e0Var2 = ef.o.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.AllScoresNoGamesTodayItem.ordinal()) {
                                            e0Var2 = ef.e.onCreateViewHolder(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.MyScoresCompetitionTitleItem.ordinal()) {
                                            e0Var2 = ef.n.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.MyScoresDateItem.ordinal()) {
                                            e0Var2 = ef.p.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.NewMyScoresDateItem.ordinal()) {
                                            e0Var2 = ef.l.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.MyScoresFillerItem.ordinal()) {
                                            e0Var2 = ef.q.onCreateViewHolder(viewGroup);
                                        } else if (intValue == lf.u.StandingsAndFixturesSportType.ordinal()) {
                                            e0Var2 = id.h.n(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.AllScoresCategory.ordinal()) {
                                            e0Var2 = yc.a.n(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.PlainTitleItem.ordinal()) {
                                            e0Var2 = yc.r.m(viewGroup, this.f20955g.get());
                                        } else if (intValue == lf.u.GameLiveOddsItem.ordinal()) {
                                            e0Var2 = kg.a.f33277e.a(viewGroup, this.f20955g.get());
                                        } else {
                                            lf.u uVar4 = lf.u.TrendBookieItem;
                                            if (intValue == uVar4.ordinal()) {
                                                e0Var2 = cd.b.f10150h.a(viewGroup, this.f20955g.get());
                                            } else if (intValue == uVar4.ordinal()) {
                                                e0Var2 = cd.b.f10150h.a(viewGroup, this.f20955g.get());
                                            } else if (intValue == lf.u.TrendTitleItem.ordinal()) {
                                                e0Var2 = cd.i.f10215b.a(viewGroup, this.f20955g.get());
                                            } else if (intValue == lf.u.TrendCompetitorTitleItem.ordinal()) {
                                                e0Var2 = cd.e.f10182c.a(viewGroup, this.f20955g.get());
                                            } else if (intValue == lf.u.TrendRowItem.ordinal()) {
                                                e0Var2 = cd.h.f10191m.a(viewGroup, this.f20955g.get());
                                            } else {
                                                lf.u uVar5 = lf.u.PlainCompetitionItem;
                                                if (intValue == uVar5.ordinal()) {
                                                    e0Var2 = m0.l(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.StatisticsFilterItem.ordinal()) {
                                                    e0Var2 = h1.f603c.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == uVar5.ordinal()) {
                                                    e0Var2 = m0.l(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.CompetitionChampionshipItem.ordinal()) {
                                                    e0Var2 = xb.a.l(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.CompetitionMostTitlesRowItem.ordinal()) {
                                                    e0Var2 = ue.h.f40175d.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.CompetitionRelegationEntityItem.ordinal()) {
                                                    e0Var2 = xb.c.l(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.CompetitionInformationItem.ordinal()) {
                                                    e0Var2 = xb.b.l(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.QuizStageItem.ordinal()) {
                                                    e0Var2 = vd.e.n(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.QuizStageTitleItem.ordinal()) {
                                                    e0Var2 = vd.f.l(viewGroup);
                                                } else if (intValue == lf.u.CompetitionTopEntities.ordinal()) {
                                                    e0Var2 = se.z.f39071h.a(viewGroup);
                                                } else if (intValue == lf.u.BettingScoreItem.ordinal()) {
                                                    e0Var2 = me.b.f34913c.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.BetBoostItemMyScores.ordinal()) {
                                                    e0Var2 = ff.h.f26482c.b(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.BettingPromotionsItem.ordinal()) {
                                                    e0Var2 = me.a.f34907d.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.PlainTitleItemWithSposored.ordinal()) {
                                                    e0Var2 = PlainTitleItemWithSposored.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.SeeAllTableItem.ordinal()) {
                                                    e0Var2 = SeeAllTableItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.MissedConsecutiveLastMatchsItem.ordinal()) {
                                                    e0Var2 = MissedConsecutiveLastMatchsItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.LastMatchGameItem.ordinal()) {
                                                    e0Var2 = LastMatchGameItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.LastMatchGameBasketballItem.ordinal()) {
                                                    e0Var2 = LastMatchGameBasketballItem.onCreateViewHolderBasketball(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.LastMatchesTitleItem.ordinal()) {
                                                    e0Var2 = LastMatchesTitleItem.Companion.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.PlayByPlayFillerItem.ordinal()) {
                                                    e0Var2 = r0.onCreateViewHolder(viewGroup);
                                                } else if (intValue == lf.u.NotificationsDisabledItem.ordinal()) {
                                                    e0Var2 = bf.g.l(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.MyScoresNoGamesTodayItem.ordinal()) {
                                                    e0Var2 = ef.r.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.recentSearchItem.ordinal()) {
                                                    e0Var2 = com.scores365.Design.PageObjects.a.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.recentSearchEmptyItem.ordinal()) {
                                                    e0Var2 = gf.g.l(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.recentSearchSubItem.ordinal()) {
                                                    e0Var2 = gf.i.l(viewGroup);
                                                } else if (intValue == lf.u.viewAllPopularEntitiesItem.ordinal()) {
                                                    e0Var2 = gf.k.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.AllScoresCountryItem.ordinal()) {
                                                    e0Var2 = ef.b.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.AllScoresShowAllLinkItem.ordinal()) {
                                                    e0Var2 = ef.g.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.MorePageItem.ordinal()) {
                                                    e0Var2 = hf.b.n(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.LoadGamesPreLoader.ordinal()) {
                                                    e0Var2 = lf.a.l(viewGroup);
                                                } else if (intValue == lf.u.TipsterSaleTextItem.ordinal()) {
                                                    e0Var2 = gi.r.onCreateViewHolder(viewGroup, null);
                                                } else if (intValue == lf.u.brandingStripItem.ordinal()) {
                                                    e0Var2 = BrandingStripItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.BannerStripItem.ordinal()) {
                                                    e0Var2 = gc.j.f26997b.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.LiveGamesTitleItem.ordinal()) {
                                                    e0Var2 = ef.i.onCreateViewHolder(viewGroup);
                                                } else if (intValue == lf.u.StandingsInternationalCompetition.ordinal()) {
                                                    e0Var2 = id.m.m(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.StandingsCountry.ordinal()) {
                                                    e0Var2 = id.j.m(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.StandingsCompetition.ordinal()) {
                                                    e0Var2 = id.i.n(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.StandingsTennisRanking.ordinal()) {
                                                    e0Var2 = com.scores365.Design.PageObjects.a.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.StandingsTennisRankingSub.ordinal()) {
                                                    e0Var2 = id.r.l(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.StandingsRankingTitleItem.ordinal()) {
                                                    e0Var2 = id.o.l(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.StandingsTennisCountryItem.ordinal()) {
                                                    e0Var2 = id.p.n(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.LineupsCompetitionStatsNameItem.ordinal()) {
                                                    e0Var2 = k0.l(viewGroup);
                                                } else if (intValue == lf.u.PlayByPlayEvent.ordinal()) {
                                                    e0Var2 = com.scores365.gameCenter.gameCenterItems.f.onCreateViewHolder(viewGroup);
                                                } else if (intValue == lf.u.PlayByPlayHeaderGameItem.ordinal()) {
                                                    e0Var2 = t0.f927a.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.PlayByPlayAFootballDriveItem.ordinal()) {
                                                    e0Var2 = n0.f763e.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.PlayByPlayAFootballMessageItem.ordinal()) {
                                                    e0Var2 = p0.f819e.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.PlayByPlayHockeyExpandableItem.ordinal()) {
                                                    e0Var2 = w0.f1040d.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.PlayByPlayHockeyStaticItem.ordinal()) {
                                                    e0Var2 = ag.x0.f1060c.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.PBPBetRadarItem.ordinal()) {
                                                    e0Var2 = xf.v.f42598m.b(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.PlayByPlayFact.ordinal()) {
                                                    e0Var2 = ag.q0.onCreateViewHolder(viewGroup);
                                                } else if (intValue == lf.u.PlayByPlayChooserItem.ordinal()) {
                                                    e0Var2 = ag.r.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.playerInjurySuspensionStatusItem.ordinal()) {
                                                    e0Var2 = InjurySuspensionStatusItem.onCreateViewHolder(viewGroup);
                                                } else if (intValue == lf.u.playerDetailsItem.ordinal()) {
                                                    e0Var2 = PlayerDetailsItem.onCreateViewHolder(viewGroup);
                                                } else if (intValue == lf.u.playerDetailsProfileStatsItem.ordinal()) {
                                                    e0Var2 = PlayerCardProfileStatsItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.playerTransferHistoryItem.ordinal()) {
                                                    e0Var2 = PlayerTransferHistoryItem.onCreateViewHolder(viewGroup);
                                                } else if (intValue == lf.u.playerTransferShowAllItem.ordinal()) {
                                                    e0Var2 = ExapndCollapsePlayerProfileItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.playerTrophiesTitleItem.ordinal()) {
                                                    e0Var2 = PlayerTrophiesTitleIconsItem.onCreateViewHolder(viewGroup);
                                                } else if (intValue == lf.u.playerTrophyItem.ordinal()) {
                                                    e0Var2 = PlayerTrophyItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.playerTrophiesCompetitionSelectorItem.ordinal()) {
                                                    e0Var2 = PlayerTrophiesCompetitionSelectorItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.CompetitionDetailsHighlightItem.ordinal()) {
                                                    e0Var2 = te.b.f39685n.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.playerTrophiesCompetitionSingleItem.ordinal()) {
                                                    e0Var2 = PlayerTrophiesCompetitionSingleItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.generalChooserItem.ordinal()) {
                                                    e0Var2 = com.scores365.Design.PageObjects.e.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.TabSelectorItem.ordinal()) {
                                                    e0Var2 = xf.y.f42624h.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.CompetitionDetailsItem.ordinal()) {
                                                    e0Var2 = se.l.f38909i.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.playerRecentlyWonTrophy.ordinal()) {
                                                    e0Var2 = RecentlyWonPersonalTrophyItem.Companion.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.CompetitionDetailsTOWCoachItem.ordinal()) {
                                                    e0Var2 = se.q.f39015b.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.playerTrophiesChooserItem.ordinal()) {
                                                    e0Var2 = com.scores365.Design.PageObjects.e.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.playerTrophiesCompetitionSelectorFillerItem.ordinal()) {
                                                    e0Var2 = PlayerTrophiesCompetitionSelectorFillerItem.onCreateViewHolder(viewGroup);
                                                } else if (intValue == lf.u.selectSportTypeItem.ordinal()) {
                                                    e0Var2 = SelectSportTypeItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.selectLangItem.ordinal()) {
                                                    e0Var2 = SelectLangItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.selectNewsLangItem.ordinal()) {
                                                    e0Var2 = SelectNewsLangItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.newsSourceItem.ordinal()) {
                                                    e0Var2 = NewsSourceItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.STATS_CHILD.ordinal()) {
                                                    e0Var2 = ld.m.o(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.STATS_HEADER.ordinal()) {
                                                    e0Var2 = ld.l.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.STATS_GROUP.ordinal()) {
                                                    e0Var2 = ld.k.r(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.STATS_FOOTER.ordinal()) {
                                                    e0Var2 = ld.j.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.playerSocialStatItem.ordinal()) {
                                                    e0Var2 = SocialStatItem.onCreateViewHolder(viewGroup);
                                                } else if (intValue == lf.u.playerStatsCompetitionSelectorItem.ordinal()) {
                                                    e0Var2 = com.scores365.Design.PageObjects.a.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.playerStatsCompetitionSelectorSubItem.ordinal()) {
                                                    e0Var2 = SinglePlayerStatsCompetitionSelectorSubItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.playerOverallStatsItem.ordinal()) {
                                                    e0Var2 = SinglePlayerOverallStatsItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.playerLastMatchExpandItem.ordinal()) {
                                                    e0Var2 = PlayerLastMatchExpandItem.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.ODDS_GROUP.ordinal()) {
                                                    e0Var2 = ld.b.p(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.ODDS_TITLE.ordinal()) {
                                                    e0Var2 = ld.i.l(viewGroup);
                                                } else if (intValue == lf.u.ODDS_LINE.ordinal()) {
                                                    e0Var2 = ld.d.n(viewGroup);
                                                } else if (intValue == lf.u.ODDS_SUB_FILTER.ordinal()) {
                                                    e0Var2 = ld.f.m(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.ODDS_STRIP_18.ordinal()) {
                                                    e0Var2 = ld.e.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.StandingsFilter.ordinal()) {
                                                    e0Var2 = c0.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.CompetitionDetailsTOWSpinnerItem.ordinal()) {
                                                    e0Var2 = se.d.f38809e.a(viewGroup);
                                                } else if (intValue == lf.u.TournamentselectCompetitorItem.ordinal()) {
                                                    e0Var2 = ji.c.l(viewGroup);
                                                } else if (intValue == lf.u.RankingToggleBtnItem.ordinal()) {
                                                    e0Var2 = com.scores365.gameCenter.t0.l(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.TopStatsPopupItem.ordinal()) {
                                                    e0Var2 = zb.r.l(viewGroup);
                                                } else if (intValue == lf.u.SEE_ALL.ordinal()) {
                                                    e0Var2 = f1.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.LiveStatsPopupLineItem.ordinal()) {
                                                    e0Var2 = zb.m.l(viewGroup);
                                                } else if (intValue == lf.u.LiveStatsPopupHeatMapItem.ordinal()) {
                                                    e0Var2 = zb.f.m(viewGroup);
                                                } else if (intValue == lf.u.EmptyStatsDataPopupItem.ordinal()) {
                                                    e0Var2 = zb.e.l(viewGroup);
                                                } else if (intValue == lf.u.LINEUPS_BENCH.ordinal()) {
                                                    e0Var2 = com.scores365.gameCenter.gameCenterItems.c.m(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.QuizRegularImageItem.ordinal()) {
                                                    e0Var2 = vd.c.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.LINEUPS_VISUAL_ITEM.ordinal()) {
                                                    e0Var2 = com.scores365.gameCenter.gameCenterItems.b.t(viewGroup, this.f20955g.get(), false);
                                                } else if (intValue == lf.u.QuizCircularImageItem.ordinal()) {
                                                    e0Var2 = vd.a.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.QuizScrollableImageItem.ordinal()) {
                                                    e0Var2 = vd.d.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.HomeScreenOption.ordinal()) {
                                                    e0Var2 = hf.c.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.pagingProgressBarItem.ordinal()) {
                                                    e0Var2 = com.scores365.Design.PageObjects.g.l(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.ImprovedWWWInnerItem.ordinal()) {
                                                    e0Var2 = xf.f.f42333e.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.TrendsWidgetTitleItem.ordinal()) {
                                                    e0Var2 = n1.f776l.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.TrendCalculationDialogItem.ordinal()) {
                                                    e0Var2 = cd.c.f10161c.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.OnBoardingListEntityItem.ordinal()) {
                                                    e0Var2 = mh.b.f34992g.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.OnBoardingListTitleItem.ordinal()) {
                                                    e0Var2 = mh.c.f35008e.b(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.OnBoardingListBrowseItem.ordinal()) {
                                                    e0Var2 = mh.a.f34985e.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.PointDeductionTitleItem.ordinal()) {
                                                    e0Var2 = of.h.f36200a.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.TitleItem.ordinal()) {
                                                    e0Var2 = of.r.f36275h.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.ChampionByKnockoutItem.ordinal()) {
                                                    e0Var2 = we.a.f41334g.a(viewGroup);
                                                } else if (intValue == lf.u.PointDeductionRowItem.ordinal()) {
                                                    e0Var2 = of.g.f36192d.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.OddsTestItem.ordinal()) {
                                                    e0Var2 = sg.a.f39190a.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.LineupsOddsBrandedListItem.ordinal()) {
                                                    e0Var2 = LineupOddsBrandedListItem.Companion.onCreateViewHolder(viewGroup);
                                                } else if (intValue == lf.u.CompetitionDetailsHighlightInnerItem.ordinal()) {
                                                    e0Var2 = te.a.f39680d.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.LiveOddsBrandedListItem.ordinal()) {
                                                    e0Var2 = GameLiveOddsBrandedListItem.Companion.onCreateViewHolder(viewGroup);
                                                } else if (intValue == lf.u.LiveVSKickoffOddsBrandedListItem.ordinal()) {
                                                    e0Var2 = LiveVSKickoffOddsBrandedListItem.Companion.onCreateViewHolder(viewGroup);
                                                } else if (intValue == lf.u.PostGameTeaserBrandedListItem.ordinal()) {
                                                    e0Var2 = PostGameTeaserBrandedListItem.Companion.onCreateViewHolder(viewGroup);
                                                } else if (intValue == lf.u.OlympicMedalsTableTitleItem.ordinal()) {
                                                    e0Var2 = hi.h.f27934a.a(viewGroup);
                                                } else if (intValue == lf.u.OlympicMedalsTableCountryItem.ordinal()) {
                                                    e0Var2 = hi.f.f27929c.a(viewGroup);
                                                } else if (intValue == lf.u.newComerItem.ordinal()) {
                                                    e0Var2 = f0.f38830e.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.CurrentTennisGamePoints.ordinal()) {
                                                    e0Var2 = ag.b.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.TennisH2HSurfaceChooserItem.ordinal()) {
                                                    e0Var2 = l1.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.TitleWithCardItem.ordinal()) {
                                                    e0Var2 = com.scores365.gameCenter.b1.l(viewGroup);
                                                } else if (intValue == lf.u.TennisSetChooserItem.ordinal()) {
                                                    e0Var2 = a1.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.HistoryAndTeamsChooserItem.ordinal()) {
                                                    e0Var2 = we.g.f41384a.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.CompetitionTeamItem.ordinal()) {
                                                    e0Var2 = we.e.f41368f.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.CompetitionTeamsGroupItem.ordinal()) {
                                                    e0Var2 = we.f.f41381d.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.CompetitionHistoryItem.ordinal()) {
                                                    e0Var2 = we.c.f41358d.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.CompetitionHistoryTitleItem.ordinal()) {
                                                    e0Var2 = we.d.f41364b.b(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.StandingsPreviewItem.ordinal()) {
                                                    e0Var2 = of.o.f36237e.e(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.StandingsPreviewHeaderItem.ordinal()) {
                                                    e0Var2 = of.n.f36231d.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.OutrightColumnHeaderItem.ordinal()) {
                                                    e0Var2 = g0.f38836b.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.OutrightRowItem.ordinal()) {
                                                    e0Var2 = j0.f38885p.c(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.OutrightSpinnerItem.ordinal()) {
                                                    e0Var2 = se.d.f38809e.a(viewGroup);
                                                } else if (intValue == lf.u.HEAD_TO_HEAD.ordinal()) {
                                                    e0Var2 = ag.m.onCreateViewHolder(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.ChanceOfWinningItem.ordinal()) {
                                                    e0Var2 = df.d.f25199e.a(viewGroup);
                                                } else if (intValue == lf.u.BoostItem.ordinal()) {
                                                    e0Var2 = le.k.f34255h.a(viewGroup, this.f20955g.get());
                                                } else if (intValue == lf.u.PlainTitleItemWithSmallImage.ordinal()) {
                                                    e0Var2 = ff.j.f26495d.a(viewGroup);
                                                } else if (intValue == lf.u.BoostInnerItem.ordinal()) {
                                                    e0Var2 = le.i.f34247d.b(viewGroup, this.f20955g.get());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (e0Var2 != null) {
                                break;
                            }
                        }
                    } catch (Exception e10) {
                        e = e10;
                        e0Var = e0Var2;
                        x0.N1(e);
                        return e0Var;
                    }
                }
                if ((e0Var2 instanceof t) && e0Var2.itemView != null && !((t) e0Var2).isSupportRTL()) {
                    e1.I0(e0Var2.itemView, 0);
                }
                return e0Var2 == null ? yc.r.m(viewGroup, null) : e0Var2;
            }
            return null;
        } catch (Exception e11) {
            e = e11;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onViewAttachedToWindow(RecyclerView.e0 e0Var) {
        try {
            super.onViewAttachedToWindow(e0Var);
            if (e0Var instanceof a) {
                ((a) e0Var).onViewHolderAttached();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onViewDetachedFromWindow(RecyclerView.e0 e0Var) {
        try {
            super.onViewDetachedFromWindow(e0Var);
            if (e0Var instanceof mf.a) {
                ((mf.a) e0Var).f34937z = false;
            } else if (e0Var instanceof d.b) {
                if (((d.b) e0Var).l() != null) {
                    ((d.b) e0Var).l().f();
                }
            } else if (e0Var instanceof k.b) {
                ((k.b) e0Var).n();
            }
            if (e0Var instanceof SwipeableViewHolder) {
                ((SwipeableViewHolder) e0Var).restoreInitialStateWithoutAnimation();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onViewRecycled(@NonNull RecyclerView.e0 e0Var) {
        try {
            super.onViewRecycled(e0Var);
            if (e0Var instanceof d.a) {
                ((d.a) e0Var).l();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void z() {
        this.f20954f.clear();
    }
}
