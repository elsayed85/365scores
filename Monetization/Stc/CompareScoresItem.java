package com.scores365.Monetization.Stc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.dashboardEntities.dashboardScores.e;
import ef.k;
import li.o0;
import li.p0;
import li.x0;
import sc.i;
/* loaded from: classes2.dex */
public class CompareScoresItem extends e {
    String scoreText;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class StcComparisonViewHolder extends t {
        ImageView ivAwayTeamLogo;
        ImageView ivCampaignIcon;
        ImageView ivHomeTeamLogo;
        ImageView ivTipsterIcon;
        ImageView penaltyAway;
        ImageView penaltyHome;
        TextView tvAwayTeamName;
        TextView tvCampaignTitle;
        TextView tvGameScore;
        TextView tvGameStatus;
        TextView tvHomeTeamName;
        TextView tvSponsoredTitle;

        public StcComparisonViewHolder(View view, q.e eVar) {
            super(view);
            try {
                this.tvGameStatus = (TextView) view.findViewById(R.id.Jz);
                if (x0.l1()) {
                    this.ivHomeTeamLogo = (ImageView) view.findViewById(R.id.f22357va);
                    this.tvHomeTeamName = (TextView) view.findViewById(R.id.Mw);
                    this.ivAwayTeamLogo = (ImageView) view.findViewById(R.id.Jb);
                    this.tvAwayTeamName = (TextView) view.findViewById(R.id.rA);
                } else {
                    this.ivHomeTeamLogo = (ImageView) view.findViewById(R.id.Jb);
                    this.tvHomeTeamName = (TextView) view.findViewById(R.id.rA);
                    this.ivAwayTeamLogo = (ImageView) view.findViewById(R.id.f22357va);
                    this.tvAwayTeamName = (TextView) view.findViewById(R.id.Mw);
                }
                this.tvGameScore = (TextView) view.findViewById(R.id.Oz);
                this.ivTipsterIcon = (ImageView) view.findViewById(R.id.Zd);
                this.penaltyHome = (ImageView) view.findViewById(R.id.Co);
                this.penaltyAway = (ImageView) view.findViewById(R.id.Bo);
                this.tvCampaignTitle = (TextView) view.findViewById(R.id.wt);
                TextView textView = (TextView) view.findViewById(R.id.xt);
                this.tvSponsoredTitle = textView;
                ConstraintLayout.b bVar = (ConstraintLayout.b) textView.getLayoutParams();
                ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.tvCampaignTitle.getLayoutParams();
                if (x0.l1()) {
                    this.ivCampaignIcon = (ImageView) view.findViewById(R.id.vt);
                    bVar.f4622e = 0;
                    bVar.f4628h = -1;
                    bVar2.f4624f = -1;
                    this.tvCampaignTitle.setGravity(5);
                    this.tvSponsoredTitle.setGravity(3);
                } else {
                    this.ivCampaignIcon = (ImageView) view.findViewById(R.id.ut);
                    bVar.f4622e = -1;
                    bVar.f4628h = 0;
                    bVar2.f4626g = -1;
                    this.tvCampaignTitle.setGravity(3);
                    this.tvSponsoredTitle.setGravity(5);
                }
                if (k.M()) {
                    this.tvCampaignTitle.setTypeface(o0.b(App.m()));
                    this.tvSponsoredTitle.setTypeface(o0.b(App.m()));
                }
                ((t) this).itemView.setBackgroundResource(p0.T(R.attr.f21560l));
                ((t) this).itemView.setOnClickListener(new u(this, eVar));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public CompareScoresItem() {
        this.isLastItem = true;
        this.hasPlayersItemBelow = false;
        try {
            if (x0.l1()) {
                this.scoreText = CompareNativeAdScoresCampaignMgr.comparisonFakeGame.AwayScore + " - " + CompareNativeAdScoresCampaignMgr.comparisonFakeGame.HomeScore;
            } else {
                this.scoreText = CompareNativeAdScoresCampaignMgr.comparisonFakeGame.HomeScore + " - " + CompareNativeAdScoresCampaignMgr.comparisonFakeGame.AwayScore;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static t onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        try {
            return new StcComparisonViewHolder(k.M() ? LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.A9, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.B9, viewGroup, false), eVar);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private void setBackground(StcComparisonViewHolder stcComparisonViewHolder) {
        try {
            ((t) stcComparisonViewHolder).itemView.setBackgroundResource(p0.T(R.attr.f21560l));
            ((ViewGroup.MarginLayoutParams) ((RecyclerView.q) ((t) stcComparisonViewHolder).itemView.getLayoutParams())).bottomMargin = p0.s(8);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.NETFLIX_SCORES_ITEM.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            StcComparisonViewHolder stcComparisonViewHolder = (StcComparisonViewHolder) e0Var;
            stcComparisonViewHolder.tvGameStatus.setVisibility(8);
            stcComparisonViewHolder.tvHomeTeamName.setText(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.HomeText);
            stcComparisonViewHolder.tvAwayTeamName.setText(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.AwayText);
            stcComparisonViewHolder.tvGameScore.setText(this.scoreText);
            stcComparisonViewHolder.tvGameScore.setVisibility(0);
            stcComparisonViewHolder.tvSponsoredTitle.setText(p0.l0("STC_SPONSORED"));
            stcComparisonViewHolder.tvCampaignTitle.setText(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.LeagueName);
            li.u.x(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.HomeLogo, stcComparisonViewHolder.ivHomeTeamLogo);
            li.u.x(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.AwayLogo, stcComparisonViewHolder.ivAwayTeamLogo);
            li.u.x(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.LeagueLogo, stcComparisonViewHolder.ivCampaignIcon);
            stcComparisonViewHolder.ivTipsterIcon.setVisibility(8);
            stcComparisonViewHolder.penaltyHome.setVisibility(8);
            stcComparisonViewHolder.penaltyAway.setVisibility(8);
            stcComparisonViewHolder.tvGameScore.setPadding(p0.s(1), p0.s(1), p0.s(1), p0.s(1));
            setBackground(stcComparisonViewHolder);
            CompareNativeAdScoresCampaignMgr.sendImapression();
            x0.S1("comparison_game", i.Dashboard.getAnalyticsName(), "SpecialExcutions", String.valueOf(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.ComparisonFakeGameId), CompareNativeAdScoresCampaignMgr.comparisonFakeGame.URL, "", "");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
