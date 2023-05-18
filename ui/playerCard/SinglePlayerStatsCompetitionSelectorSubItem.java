package com.scores365.ui.playerCard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.entitys.AthleteStatisticsObj;
import com.scores365.entitys.CompetitionObj;
import li.o0;
import li.p0;
import li.x0;
import nb.o;
import nb.p;
/* loaded from: classes2.dex */
public class SinglePlayerStatsCompetitionSelectorSubItem extends com.scores365.Design.PageObjects.b {
    private final AthleteStatisticsObj athleteStatistic;
    private final CompetitionObj competitionObj;
    private boolean isSelected;
    private String leagueLogoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        ImageView competitionLogo;
        TextView competitionName;

        public ViewHolder(View view, q.e eVar) {
            super(view);
            this.competitionLogo = (ImageView) view.findViewById(R.id.Za);
            TextView textView = (TextView) view.findViewById(R.id.Ox);
            this.competitionName = textView;
            textView.setTypeface(o0.d(App.m()));
            view.setOnClickListener(new u(this, eVar));
        }
    }

    public SinglePlayerStatsCompetitionSelectorSubItem(CompetitionObj competitionObj, AthleteStatisticsObj athleteStatisticsObj) {
        this.competitionObj = competitionObj;
        this.athleteStatistic = athleteStatisticsObj;
        try {
            this.leagueLogoUrl = o.x(x0.n1() ? p.CompetitionsLight : p.Competitions, competitionObj.getID(), p0.s(16), p0.s(16), false, p.CountriesRoundFlags, Integer.valueOf(competitionObj.getCid()), competitionObj.getImgVer());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static ViewHolder onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new ViewHolder(x0.l1() ? LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.M8, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.L8, viewGroup, false), eVar);
    }

    public CompetitionObj getCompetitionObj() {
        return this.competitionObj;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.playerStatsCompetitionSelectorSubItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        ViewHolder viewHolder = (ViewHolder) e0Var;
        try {
            String str = this.leagueLogoUrl;
            ImageView imageView = viewHolder.competitionLogo;
            li.u.A(str, imageView, li.u.f(imageView.getLayoutParams().width));
            viewHolder.competitionName.setText(this.athleteStatistic.titleName);
            if (this.isSelected) {
                viewHolder.competitionLogo.setAlpha(1.0f);
                viewHolder.competitionName.setAlpha(1.0f);
            } else {
                viewHolder.competitionLogo.setAlpha(0.4f);
                viewHolder.competitionName.setAlpha(0.4f);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setSelected(boolean z10) {
        this.isSelected = z10;
    }
}
