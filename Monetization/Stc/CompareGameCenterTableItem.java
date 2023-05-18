package com.scores365.Monetization.Stc;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.AppEventsConstants;
import com.scores365.App;
import com.scores365.Design.PageObjects.b;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import li.o0;
import li.p0;
import li.u;
import li.x0;
/* loaded from: classes2.dex */
public class CompareGameCenterTableItem extends b {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        RelativeLayout awayTeamLayout;
        RelativeLayout homeTeamLayout;
        ImageView ivTeamLogoAway;
        ImageView ivTeamLogoHome;
        ImageView ivTrendAway;
        ImageView ivTrendHome;
        TextView tvColum1Away;
        TextView tvColum1Header;
        TextView tvColum1Home;
        TextView tvColum2Away;
        TextView tvColum2Header;
        TextView tvColum2Home;
        TextView tvColum3Away;
        TextView tvColum3Header;
        TextView tvColum3Home;
        TextView tvLiveGameScoreAway;
        TextView tvLiveGameScoreHome;
        TextView tvTeamNameAway;
        TextView tvTeamNameHome;
        TextView tvTeamPositionAway;
        TextView tvTeamPositionHome;

        public ViewHolder(View view) {
            super(view);
            try {
                this.tvColum1Header = (TextView) view.findViewById(R.id.HE);
                this.tvColum2Header = (TextView) view.findViewById(R.id.JE);
                this.tvColum3Header = (TextView) view.findViewById(R.id.LE);
                this.tvColum1Header.setTypeface(o0.b(App.m()));
                this.tvColum2Header.setTypeface(o0.b(App.m()));
                this.tvColum3Header.setTypeface(o0.b(App.m()));
                this.ivTeamLogoHome = (ImageView) view.findViewById(R.id.f22271rd);
                this.tvTeamNameHome = (TextView) view.findViewById(R.id.dF);
                this.tvColum1Home = (TextView) view.findViewById(R.id.SE);
                this.tvColum2Home = (TextView) view.findViewById(R.id.UE);
                this.tvColum3Home = (TextView) view.findViewById(R.id.WE);
                this.tvTeamPositionHome = (TextView) view.findViewById(R.id.wG);
                this.tvLiveGameScoreHome = (TextView) view.findViewById(R.id.bF);
                this.ivTrendHome = (ImageView) view.findViewById(R.id.f22316td);
                this.ivTeamLogoAway = (ImageView) view.findViewById(R.id.f22249qd);
                this.tvTeamNameAway = (TextView) view.findViewById(R.id.cF);
                this.tvColum1Away = (TextView) view.findViewById(R.id.RE);
                this.tvColum2Away = (TextView) view.findViewById(R.id.TE);
                this.tvColum3Away = (TextView) view.findViewById(R.id.VE);
                this.tvTeamPositionAway = (TextView) view.findViewById(R.id.vG);
                this.tvLiveGameScoreAway = (TextView) view.findViewById(R.id.aF);
                this.ivTrendAway = (ImageView) view.findViewById(R.id.f22294sd);
                this.homeTeamLayout = (RelativeLayout) view.findViewById(R.id.Vq);
                this.awayTeamLayout = (RelativeLayout) view.findViewById(R.id.Uq);
                this.ivTeamLogoHome.setAdjustViewBounds(true);
                this.tvColum1Home.setTypeface(o0.b(App.m()));
                this.tvColum2Home.setTypeface(o0.b(App.m()));
                this.tvColum3Home.setTypeface(o0.b(App.m()));
                this.tvTeamPositionHome.setTypeface(o0.d(App.m()));
                this.tvTeamNameHome.setTypeface(o0.d(App.m()));
                this.tvTeamNameHome.setMaxLines(1);
                this.tvTeamNameHome.setEllipsize(TextUtils.TruncateAt.END);
                this.ivTeamLogoAway.setAdjustViewBounds(true);
                this.tvColum1Away.setTypeface(o0.b(App.m()));
                this.tvColum2Away.setTypeface(o0.b(App.m()));
                this.tvColum3Away.setTypeface(o0.b(App.m()));
                this.tvTeamPositionAway.setTypeface(o0.d(App.m()));
                this.tvTeamNameAway.setTypeface(o0.d(App.m()));
                this.tvTeamNameAway.setMaxLines(1);
                this.tvTeamNameAway.setEllipsize(TextUtils.TruncateAt.END);
                this.tvColum1Header.setTypeface(o0.b(App.m()));
                this.tvColum2Header.setTypeface(o0.b(App.m()));
                this.tvColum3Header.setTypeface(o0.b(App.m()));
                this.tvTeamNameAway.setTypeface(o0.d(App.m()));
                this.tvTeamNameHome.setTypeface(o0.d(App.m()));
                this.tvColum1Home.setTypeface(o0.b(App.m()));
                this.tvColum2Home.setTypeface(o0.b(App.m()));
                this.tvColum3Home.setTypeface(o0.d(App.m()));
                this.tvColum1Away.setTypeface(o0.b(App.m()));
                this.tvColum2Away.setTypeface(o0.b(App.m()));
                this.tvColum3Away.setTypeface(o0.d(App.m()));
                this.tvTeamPositionHome.setTypeface(o0.b(App.m()));
                this.tvTeamPositionAway.setTypeface(o0.b(App.m()));
                this.tvLiveGameScoreHome.setTypeface(o0.b(App.m()));
                this.tvLiveGameScoreAway.setTypeface(o0.b(App.m()));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    private void initViews(ViewHolder viewHolder) {
        viewHolder.tvTeamNameHome.setText(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.AwayText);
        viewHolder.tvTeamNameAway.setText(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.HomeText);
        u.x(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.AwayLogo, viewHolder.ivTeamLogoHome);
        u.x(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.HomeLogo, viewHolder.ivTeamLogoAway);
        viewHolder.tvTeamPositionHome.setText(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        viewHolder.tvTeamPositionAway.setText("2");
        viewHolder.tvColum1Header.setText(p0.l0("TABLE_P"));
        viewHolder.tvColum2Header.setText(p0.l0("TABLE_GOALS"));
        viewHolder.tvColum3Header.setText(p0.l0("TABLE_PTS"));
        viewHolder.tvColum1Home.setText("8");
        viewHolder.tvColum2Home.setText("6");
        viewHolder.tvColum3Home.setText("20");
        viewHolder.tvColum1Away.setText("8");
        viewHolder.tvColum2Away.setText("4");
        viewHolder.tvColum3Away.setText("16");
    }

    public static t onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(x0.l1() ? LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.V2, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.U2, viewGroup, false));
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.compareTableItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        initViews((ViewHolder) e0Var);
    }
}
