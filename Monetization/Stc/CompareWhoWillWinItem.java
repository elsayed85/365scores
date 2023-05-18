package com.scores365.Monetization.Stc;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.PageObjects.b;
import com.scores365.Design.Pages.t;
import com.scores365.Monetization.Stc.CompareNativeAdScoresCampaignMgr;
import com.scores365.R;
import com.scores365.dashboard.CircleProgressBar;
import com.scores365.gameCenter.m0;
import com.scores365.ui.OddsView;
import com.scores365.ui.stackedProgressbar.StackedProgressbar;
import com.scores365.ui.stackedProgressbar.StackedProgressbarItem;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import lf.u;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class CompareWhoWillWinItem extends b {

    /* loaded from: classes2.dex */
    private static class CompareCustomItemClick implements View.OnClickListener {
        private WeakReference<PredictionCardViewHolder> holderRef;
        private int selection;

        public CompareCustomItemClick(PredictionCardViewHolder predictionCardViewHolder, int i10) {
            this.holderRef = new WeakReference<>(predictionCardViewHolder);
            this.selection = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                PredictionCardViewHolder predictionCardViewHolder = this.holderRef.get();
                if (predictionCardViewHolder != null) {
                    int id2 = view.getId();
                    m0.c cVar = id2 == R.id.Ak ? m0.c.HOME_WIN : id2 == R.id.f22433yk ? m0.c.TIE : id2 == R.id.f22389wk ? m0.c.AWAY_WIN : null;
                    sf.b.X1().E9(this.selection);
                    CompareWhoWillWinItem.setPostVoteData(predictionCardViewHolder, CompareWhoWillWinItem.getSelectedValueByLangDirection(cVar));
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class PredictionCardViewHolder extends t {
        public View awayContainer;
        public CircleProgressBar awayProgressbar;
        public TextView awayTeamName;
        public View drawContainer;
        public TextView drawPercentageCount;
        public CircleProgressBar drawProgressbar;
        public TextView drawTeamName;
        public View homeContainer;
        public CircleProgressBar homeProgressbar;
        public TextView homeTeamName;
        public TextView insightText;
        private boolean isForShare;
        public CircleImageView ivPreVoteLeft;
        public CircleImageView ivPreVoteRight;
        public TextView lineName;
        public OddsView oddsView;
        public TextView ourTipText;
        public LinearLayout postVoteContainer;
        public TextView postVoteLeftText;
        public TextView postVoteMiddleText;
        public TextView postVoteRightText;
        public LinearLayout preVoteContainer;
        public Button predictionShare;
        public TextView totalVotesText;
        public TextView voteLeft;
        public TextView voteMiddle;
        public TextView voteRight;
        public StackedProgressbar votesProgressBar;

        @SuppressLint({"CutPasteId"})
        public PredictionCardViewHolder(View view) {
            super(view);
            this.isForShare = false;
            try {
                this.preVoteContainer = (LinearLayout) view.findViewById(R.id.Dk);
                this.postVoteContainer = (LinearLayout) view.findViewById(R.id.Ik);
                this.votesProgressBar = (StackedProgressbar) view.findViewById(R.id.Kk);
                Button button = (Button) view.findViewById(R.id.Mk);
                this.predictionShare = button;
                button.setText(p0.l0("GC_SHARE_PREDICTION"));
                this.predictionShare.setTypeface(o0.d(App.m()));
                this.predictionShare.setVisibility(8);
                this.voteLeft = (TextView) view.findViewById(R.id.Fk);
                this.voteMiddle = (TextView) view.findViewById(R.id.Gk);
                this.voteRight = (TextView) view.findViewById(R.id.Hk);
                this.postVoteMiddleText = (TextView) view.findViewById(R.id.Ek);
                OddsView oddsView = (OddsView) view.findViewById(R.id.f22101jj);
                this.oddsView = oddsView;
                oddsView.setVisibility(8);
                this.drawContainer = view.findViewById(R.id.f22433yk);
                this.postVoteLeftText = (TextView) view.findViewById(R.id.Ck);
                this.postVoteRightText = (TextView) view.findViewById(R.id.Lk);
                if (x0.l1()) {
                    this.homeContainer = view.findViewById(R.id.f22389wk);
                    this.awayContainer = view.findViewById(R.id.Ak);
                } else {
                    this.homeContainer = view.findViewById(R.id.Ak);
                    this.awayContainer = view.findViewById(R.id.f22389wk);
                }
                TextView textView = (TextView) view.findViewById(R.id.Ok);
                this.lineName = textView;
                textView.setTypeface(o0.a(App.m()));
                this.totalVotesText = (TextView) view.findViewById(R.id.Pk);
                view.findViewById(R.id.f22053hg).setVisibility(8);
                view.findViewById(R.id.Da).setVisibility(8);
                view.findViewById(R.id.WB).setVisibility(8);
                view.findViewById(R.id.XB).setVisibility(8);
                view.findViewById(R.id.YB).setVisibility(8);
                this.homeProgressbar = (CircleProgressBar) view.findViewById(R.id.Ak).findViewById(R.id.f22411xk);
                this.drawProgressbar = (CircleProgressBar) view.findViewById(R.id.f22433yk).findViewById(R.id.f22411xk);
                this.awayProgressbar = (CircleProgressBar) view.findViewById(R.id.f22389wk).findViewById(R.id.f22411xk);
                CircleProgressBar circleProgressBar = this.homeProgressbar;
                CircleProgressBar.b bVar = CircleProgressBar.b.RIGHT;
                circleProgressBar.setDirection(bVar);
                this.drawProgressbar.setDirection(bVar);
                this.awayProgressbar.setDirection(bVar);
                this.ivPreVoteLeft = (CircleImageView) view.findViewById(R.id.Ak).findViewById(R.id.Jk);
                this.drawPercentageCount = (TextView) view.findViewById(R.id.f22433yk).findViewById(R.id.Jk);
                this.ivPreVoteRight = (CircleImageView) view.findViewById(R.id.f22389wk).findViewById(R.id.Jk);
                this.drawTeamName = (TextView) view.findViewById(R.id.f22433yk).findViewById(R.id.Nk);
                if (x0.l1()) {
                    this.homeTeamName = (TextView) view.findViewById(R.id.f22389wk).findViewById(R.id.Nk);
                    this.awayTeamName = (TextView) view.findViewById(R.id.Ak).findViewById(R.id.Nk);
                } else {
                    this.homeTeamName = (TextView) view.findViewById(R.id.Ak).findViewById(R.id.Nk);
                    this.awayTeamName = (TextView) view.findViewById(R.id.f22389wk).findViewById(R.id.Nk);
                }
                view.findViewById(R.id.qI).setVisibility(8);
                view.findViewById(R.id.Uf).setVisibility(8);
                this.insightText.setTypeface(o0.d(App.m()));
                this.ourTipText.setTypeface(o0.d(App.m()));
                this.drawPercentageCount.setTypeface(o0.d(App.m()));
                this.awayTeamName.setTypeface(o0.d(App.m()));
                this.drawTeamName.setTypeface(o0.d(App.m()));
                this.homeTeamName.setTypeface(o0.d(App.m()));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    private static void enlightSelection(PredictionCardViewHolder predictionCardViewHolder, int i10) {
        try {
            if (x0.l1()) {
                if (i10 == 1) {
                    predictionCardViewHolder.postVoteRightText.setTextColor(p0.A(R.attr.U0));
                    predictionCardViewHolder.voteRight.setTextColor(p0.A(R.attr.U0));
                    predictionCardViewHolder.postVoteLeftText.setTextColor(p0.A(R.attr.f21565m1));
                    predictionCardViewHolder.voteLeft.setTextColor(p0.A(R.attr.f21565m1));
                    predictionCardViewHolder.postVoteMiddleText.setTextColor(p0.A(R.attr.f21565m1));
                    predictionCardViewHolder.voteMiddle.setTextColor(p0.A(R.attr.f21565m1));
                    i10 = 3;
                } else if (i10 == 2) {
                    predictionCardViewHolder.postVoteMiddleText.setTextColor(p0.A(R.attr.U0));
                    predictionCardViewHolder.voteMiddle.setTextColor(p0.A(R.attr.U0));
                    predictionCardViewHolder.postVoteLeftText.setTextColor(p0.A(R.attr.f21565m1));
                    predictionCardViewHolder.voteLeft.setTextColor(p0.A(R.attr.f21565m1));
                    predictionCardViewHolder.postVoteRightText.setTextColor(p0.A(R.attr.f21565m1));
                    predictionCardViewHolder.voteRight.setTextColor(p0.A(R.attr.f21565m1));
                } else if (i10 == 3) {
                    predictionCardViewHolder.postVoteLeftText.setTextColor(p0.A(R.attr.U0));
                    predictionCardViewHolder.voteLeft.setTextColor(p0.A(R.attr.U0));
                    predictionCardViewHolder.postVoteMiddleText.setTextColor(p0.A(R.attr.f21565m1));
                    predictionCardViewHolder.voteMiddle.setTextColor(p0.A(R.attr.f21565m1));
                    predictionCardViewHolder.postVoteRightText.setTextColor(p0.A(R.attr.f21565m1));
                    predictionCardViewHolder.voteRight.setTextColor(p0.A(R.attr.f21565m1));
                    i10 = 1;
                }
            } else if (i10 == 1) {
                predictionCardViewHolder.postVoteLeftText.setTextColor(p0.A(R.attr.U0));
                predictionCardViewHolder.voteLeft.setTextColor(p0.A(R.attr.U0));
                predictionCardViewHolder.postVoteMiddleText.setTextColor(p0.A(R.attr.f21565m1));
                predictionCardViewHolder.voteMiddle.setTextColor(p0.A(R.attr.f21565m1));
                predictionCardViewHolder.postVoteRightText.setTextColor(p0.A(R.attr.f21565m1));
                predictionCardViewHolder.voteRight.setTextColor(p0.A(R.attr.f21565m1));
            } else if (i10 == 2) {
                predictionCardViewHolder.postVoteMiddleText.setTextColor(p0.A(R.attr.U0));
                predictionCardViewHolder.voteMiddle.setTextColor(p0.A(R.attr.U0));
                predictionCardViewHolder.postVoteLeftText.setTextColor(p0.A(R.attr.f21565m1));
                predictionCardViewHolder.voteLeft.setTextColor(p0.A(R.attr.f21565m1));
                predictionCardViewHolder.postVoteRightText.setTextColor(p0.A(R.attr.f21565m1));
                predictionCardViewHolder.voteRight.setTextColor(p0.A(R.attr.f21565m1));
            } else if (i10 == 3) {
                predictionCardViewHolder.postVoteRightText.setTextColor(p0.A(R.attr.U0));
                predictionCardViewHolder.voteRight.setTextColor(p0.A(R.attr.U0));
                predictionCardViewHolder.postVoteLeftText.setTextColor(p0.A(R.attr.f21565m1));
                predictionCardViewHolder.voteLeft.setTextColor(p0.A(R.attr.f21565m1));
                predictionCardViewHolder.postVoteMiddleText.setTextColor(p0.A(R.attr.f21565m1));
                predictionCardViewHolder.voteMiddle.setTextColor(p0.A(R.attr.f21565m1));
            }
            predictionCardViewHolder.votesProgressBar.setSelection(i10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x001d A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getSelectedValueByLangDirection(com.scores365.gameCenter.m0.c r3) {
        /*
            boolean r0 = li.x0.l1()
            r1 = 3
            r2 = 1
            if (r0 == 0) goto L12
            com.scores365.gameCenter.m0$c r0 = com.scores365.gameCenter.m0.c.HOME_WIN
            if (r3 != r0) goto Ld
            goto L1e
        Ld:
            com.scores365.gameCenter.m0$c r0 = com.scores365.gameCenter.m0.c.AWAY_WIN
            if (r3 != r0) goto L1d
            goto L16
        L12:
            com.scores365.gameCenter.m0$c r0 = com.scores365.gameCenter.m0.c.HOME_WIN
            if (r3 != r0) goto L18
        L16:
            r1 = 1
            goto L1e
        L18:
            com.scores365.gameCenter.m0$c r0 = com.scores365.gameCenter.m0.c.AWAY_WIN
            if (r3 != r0) goto L1d
            goto L1e
        L1d:
            r1 = 2
        L1e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Monetization.Stc.CompareWhoWillWinItem.getSelectedValueByLangDirection(com.scores365.gameCenter.m0$c):int");
    }

    public static t onCreateViewHolder(ViewGroup viewGroup) {
        try {
            return new PredictionCardViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.Q0, viewGroup, false));
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public static void setPostVoteData(PredictionCardViewHolder predictionCardViewHolder, int i10) {
        int i11;
        try {
            predictionCardViewHolder.postVoteContainer.setVisibility(0);
            predictionCardViewHolder.preVoteContainer.setVisibility(4);
            predictionCardViewHolder.homeContainer.setOnClickListener(null);
            predictionCardViewHolder.drawContainer.setOnClickListener(null);
            predictionCardViewHolder.awayContainer.setOnClickListener(null);
            ArrayList arrayList = new ArrayList();
            predictionCardViewHolder.voteMiddle.setVisibility(0);
            predictionCardViewHolder.postVoteMiddleText.setVisibility(0);
            CompareNativeAdScoresCampaignMgr.ComparisonFakeGame comparisonFakeGame = CompareNativeAdScoresCampaignMgr.comparisonFakeGame;
            int i12 = comparisonFakeGame.WWWHomeTeam;
            int i13 = comparisonFakeGame.WWWDraw;
            int i14 = comparisonFakeGame.WWWAwayTeam;
            float f10 = i12 + i13 + i14;
            float f11 = i12 / f10;
            float f12 = i13 / f10;
            float f13 = i14 / f10;
            int round = Math.round(f11 * 100.0f);
            int round2 = Math.round(100.0f * f12);
            arrayList.add(Integer.valueOf(round));
            arrayList.add(Integer.valueOf(round2));
            arrayList.add(Integer.valueOf(100 - (round + round2)));
            ArrayList arrayList2 = new ArrayList();
            if (x0.l1()) {
                arrayList2.add(predictionCardViewHolder.voteLeft);
                arrayList2.add(predictionCardViewHolder.voteMiddle);
                arrayList2.add(predictionCardViewHolder.voteRight);
            } else {
                arrayList2.add(predictionCardViewHolder.voteRight);
                arrayList2.add(predictionCardViewHolder.voteMiddle);
                arrayList2.add(predictionCardViewHolder.voteLeft);
            }
            if (x0.l1()) {
                Collections.reverse(arrayList);
            }
            ArrayList<StackedProgressbarItem> arrayList3 = new ArrayList<>();
            arrayList3.add(new StackedProgressbarItem(p0.A(R.attr.f21565m1), f11));
            arrayList3.add(new StackedProgressbarItem(p0.A(R.attr.f21565m1), f12));
            arrayList3.add(new StackedProgressbarItem(p0.A(R.attr.f21565m1), f13));
            if (x0.l1()) {
                ((TextView) arrayList2.get(0)).setText(String.valueOf(arrayList.get(0) + "%"));
                ((TextView) arrayList2.get(1)).setText(String.valueOf(arrayList.get(1) + "%"));
                ((TextView) arrayList2.get(2)).setText(String.valueOf(arrayList.get(2) + "%"));
            } else {
                ((TextView) arrayList2.get(0)).setText(String.valueOf(arrayList.get(2) + "%"));
                ((TextView) arrayList2.get(1)).setText(String.valueOf(arrayList.get(1) + "%"));
                ((TextView) arrayList2.get(2)).setText(String.valueOf(arrayList.get(0) + "%"));
            }
            predictionCardViewHolder.votesProgressBar.initData(arrayList3, x0.l1());
            predictionCardViewHolder.votesProgressBar.setSelection(i10);
            predictionCardViewHolder.postVoteMiddleText.setText(p0.l0("WWW_DRAW_MOBILE"));
            if (x0.l1()) {
                predictionCardViewHolder.postVoteLeftText.setText(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.AwayText);
                predictionCardViewHolder.postVoteRightText.setText(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.HomeText);
            } else {
                predictionCardViewHolder.postVoteRightText.setText(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.AwayText);
                predictionCardViewHolder.postVoteLeftText.setText(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.HomeText);
            }
            enlightSelection(predictionCardViewHolder, i10);
            predictionCardViewHolder.totalVotesText.setVisibility(0);
            predictionCardViewHolder.totalVotesText.setText(p0.l0("WWW_TOTAL_VOTES") + " " + x0.e(i11));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.comparePredictoinItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            PredictionCardViewHolder predictionCardViewHolder = (PredictionCardViewHolder) e0Var;
            predictionCardViewHolder.lineName.setText(p0.l0("WWW_TITLE"));
            predictionCardViewHolder.drawContainer.setVisibility(0);
            int T2 = sf.b.X1().T2();
            if (T2 != -1) {
                setPostVoteData(predictionCardViewHolder, T2);
            } else {
                predictionCardViewHolder.postVoteContainer.setVisibility(4);
                predictionCardViewHolder.preVoteContainer.setVisibility(0);
                predictionCardViewHolder.homeContainer.setOnClickListener(new CompareCustomItemClick(predictionCardViewHolder, 1));
                predictionCardViewHolder.drawContainer.setOnClickListener(new CompareCustomItemClick(predictionCardViewHolder, 2));
                predictionCardViewHolder.awayContainer.setOnClickListener(new CompareCustomItemClick(predictionCardViewHolder, 3));
                predictionCardViewHolder.drawTeamName.setText(p0.l0("WWW_DRAW_MOBILE"));
                predictionCardViewHolder.drawPercentageCount.setText("X");
                li.u.x(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.HomeLogo, predictionCardViewHolder.ivPreVoteLeft);
                li.u.x(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.AwayLogo, predictionCardViewHolder.ivPreVoteRight);
                predictionCardViewHolder.homeTeamName.setText(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.HomeText);
                predictionCardViewHolder.awayTeamName.setText(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.AwayText);
                if (x0.l1()) {
                    li.u.x(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.HomeLogo, predictionCardViewHolder.ivPreVoteRight);
                    li.u.x(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.AwayLogo, predictionCardViewHolder.ivPreVoteLeft);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
